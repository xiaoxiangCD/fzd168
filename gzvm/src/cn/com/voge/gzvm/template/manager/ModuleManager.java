package cn.com.voge.gzvm.template.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.template.beans.ItemContent;
import cn.com.voge.gzvm.template.beans.ItemContentPhoto;
import cn.com.voge.gzvm.template.beans.Module;
import cn.com.voge.gzvm.template.beans.ModuleItem;
import cn.com.voge.gzvm.template.beans.OperModule;
import cn.com.voge.gzvm.template.dao.ItemContentDao;
import cn.com.voge.gzvm.template.dao.ItemContentPhotoDao;
import cn.com.voge.gzvm.template.dao.ModuleDao;
import cn.com.voge.gzvm.template.dao.ModuleItemDao;
import cn.com.voge.gzvm.template.dao.OperModuleDao;

import com.google.gxp.com.google.common.collect.Maps;
import com.voyageci.core.manage.AbstractEntityManage;
import com.voyageci.tools.utils.BeanUtils;
import com.voyageci.tools.utils.ListUtils;


@SuppressWarnings({"rawtypes","unchecked"})
public class ModuleManager extends AbstractEntityManage<Module, ModuleDao> {

	private ModuleDao moduleDao;
	private OperModuleDao operModuleDao;
	private ModuleItemDao moduleItemDao;
	private ItemContentDao itemContentDao;
	private ItemContentPhotoDao itemContentPhotoDao;
	
	@Override
	public Map getRecordDetail(Module object) throws DataAccessException {
		Map record = super.getRecordDetail(object);
		return record;
	}
	
	@Override
	public void removeDetail(Module object) throws DataAccessException {
		operModuleDao.deleteBy("moduleId", object.getModuleId());
		List<ModuleItem> items = moduleItemDao.findBy("moduleId", object.getModuleId());
		for (ModuleItem moduleItem : items) {
			itemContentDao.deleteBy("itemId", moduleItem.getItemId());
			moduleItemDao.remove(moduleItem);
		}
	}
	
	/** 获取系统模块
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getModule(Map criteria,Integer start, Integer pageSize) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<Module> modules = findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(modules)) {
			for (Module module : modules) {
				Map map = getRecordDetail(module);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = modules.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}

	/** 获取管理员模块
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getOperModule(Integer operId,Integer start, Integer pageSize) throws DataAccessException{
		Map criteria = new HashMap();
		criteria.put("operId", operId);
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<OperModule> operModules = operModuleDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(operModules)) {
			for (OperModule operModule : operModules) {
				Map map = getRecordMap(operModule,true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = operModules.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 获取系统模块的栏目
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getModuleItem(Integer moduleId,Integer start, Integer pageSize) throws DataAccessException{
		Map criteria = new HashMap();
		criteria.put("moduleId", moduleId);
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<ModuleItem> moduleItems = moduleItemDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(moduleItems)) {
			for (ModuleItem moduleItem : moduleItems) {
				Map map = getRecordMap(moduleItem,true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = moduleItems.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 获取栏目内容
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getItemContent(Integer itemId,Integer state,Integer start, Integer pageSize) throws DataAccessException{
		Map criteria = new HashMap();
		criteria.put("itemId", itemId);
		if (state == null) {
			state = Constant.BASE_STATE_PUBLISH;
		}
		criteria.put("state", state);
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<ItemContent> itemContents = itemContentDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(itemContents)) {
			for (ItemContent itemContent : itemContents) {
				Map map = getRecordMap(itemContent,true);
				ItemContentPhoto photo = itemContentPhotoDao.firstFindBy("contentId",itemContent.getContentId());
				if(photo != null){
					map.put("photoId", photo.getPhotoId());
				}else{
					map.put("photoId", "");
				}
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = itemContents.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 获取内容详情
	 * @author lianzw
	 * @param itemId
	 * @return
	 */
	public Map getItemContent(Integer contentId) {
		ItemContent item = itemContentDao.get(contentId);
		if (item != null) {
			Map result = getRecordMap(item, true);
			Map criteria = Maps.newHashMap();
			criteria.put("contentId", contentId);
			criteria.put("photoType", Constant.PHOTO_TYPE_COVER);
			ItemContentPhoto photo = itemContentPhotoDao.firstFindBy("itemId", item.getItemId());
			if (photo!= null) {
				result.put("photoId", photo.getPhotoId());
			}else{
				result.put("photoId", "");
			}
			return result;
		}
		return null;
	}
	
	/** 新增或更新系统模块
	 * @author xzq
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveModule(Map values) throws DataAccessException{
		Integer moduleId = getIntValue(values, "moduleId");
		int oper = Constant.OPER_UPDATE;
		Module module = null;
		if (moduleId > 0) {
			module = moduleDao.get(moduleId);
		}
		if (module == null) {
			oper = Constant.OPER_INSTER;
			module = new Module();
			module.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(module, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			moduleDao.insert(module);
		}else{
			moduleDao.update(module);
		}
		Map record = getRecordMap(module, true);
		return record;
	}
	
	/** 新增或更新栏目
	 * @author xzq
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveModuleItem(Map values) throws DataAccessException{
		Integer itemId = getIntValue(values, "itemId");
		int oper = Constant.OPER_UPDATE;
		ModuleItem moduleItem = null;
		if (itemId > 0) {
			moduleItem = moduleItemDao.get(itemId);
		}
		if (moduleItem == null) {
			oper = Constant.OPER_INSTER;
			moduleItem = new ModuleItem();
			moduleItem.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(moduleItem, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			moduleItemDao.insert(moduleItem);
		}else{
			moduleItemDao.update(moduleItem);
		}
		Map record = getRecordMap(moduleItem, true);
		return record;
	}
	
	/** 新增或更新栏目内容
	 * @author xzq
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveItemContent(Map values) throws DataAccessException{
		Integer contentId = getIntValue(values, "contentId");
		int oper = Constant.OPER_UPDATE;
		ItemContent itemContent = null;
		if (contentId > 0) {
			itemContent = itemContentDao.get(contentId);
		}
		if (itemContent == null) {
			oper = Constant.OPER_INSTER;
			itemContent = new ItemContent();
			itemContent.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(itemContent, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			moduleItemDao.insert(itemContent);
		}else{
			moduleItemDao.update(itemContent);
		}
		Map record = getRecordMap(itemContent, true);
		return record;
	}
	
	/** 新增或更新系统模块
	 * @author xzq
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveOperModule(Map values) throws DataAccessException{
		Integer operId = getIntValue(values, "operId");
		int oper = Constant.OPER_UPDATE;
		OperModule operModule = null;
		if (operId > 0) {
			operModule = operModuleDao.get(operId);
		}
		if (operModule == null) {
			oper = Constant.OPER_INSTER;
			operModule = new OperModule();
			operModule.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(operModule, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			operModuleDao.insert(operModule);
		}else{
			operModuleDao.update(operModule);
		}
		Map record = getRecordMap(operModule, true);
		return record;
	}
	
	
	/** 删除管理员模块
	 * @author xzq
	 * @param operId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delOperModule(Integer operId) throws DataAccessException{
		OperModule operModule = operModuleDao.get(operId);
		return delOperModule(operModule);
	}
	
	public Map delOperModule(OperModule operModule) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (operModule == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			operModuleDao.remove(operModule);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	
	/** 删除系统模块
	 * @author xzq
	 * @param moduleId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delModule(Integer moduleId) throws DataAccessException{
		Module module = moduleDao.get(moduleId);
		return delModule(module);
	}
	
	public Map delModule(Module module) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (module == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			removeDetail(module);
			remove(module);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 删除栏目内容
	 * @author xzq
	 * @param contentId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delItemContent(Integer contentId) throws DataAccessException{
		ItemContent itemContent = itemContentDao.get(contentId);
		return delItemContent(itemContent);
	}
	
	public Map delItemContent(ItemContent itemContent) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		Map result = Maps.newHashMap();
		if (itemContent == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			List<ItemContentPhoto> photos = itemContentPhotoDao.findBy("contentId", itemContent.getContentId());
			if (ListUtils.isNotEmpty(photos)) {
				List<Integer> picIds = new ArrayList<Integer>();
				for (ItemContentPhoto photo : photos) {
					picIds.add(photo.getPhotoId());
				}
				result.put("photoIds", picIds);
				itemContentPhotoDao.deleteBy("contentId", itemContent.getContentId());
			}
			itemContentDao.remove(itemContent);
		}
		result.putAll(getReturnMap(msg, code));
		return result;
	}
	
	/** 删除栏目
	 * @author xzq
	 * @param itemId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delModuleItem(Integer itemId) throws DataAccessException{
		ModuleItem moduleItem = moduleItemDao.get(itemId);
		Map criteria = new HashMap();
		criteria.put("itemId", moduleItem.getItemId());
		List<ItemContent> itemContents = itemContentDao.findBy(criteria);
		for (ItemContent itemContent : itemContents) {
			delItemContent(itemContent);
		}
		return delModuleItem(moduleItem);
	}
	
	public Map delModuleItem(ModuleItem moduleItem) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (moduleItem == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			moduleItemDao.remove(moduleItem);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 保存内容图片
	 * @author lianzw
	 * @param photoId
	 * @param contentId
	 * @param photoType
	 * @param photoName
	 * @param remark
	 * @return
	 * @throws DataAccessException
	 */
	public ItemContentPhoto saveItemContentPhoto(Integer photoId, Integer contentId, Integer photoType, String photoName, String remark) throws DataAccessException{
		ItemContentPhoto photo = null;
		Integer oper = Constant.OPER_UPDATE;
		if (photoId != null &&  photoId > 0) {
			photo = itemContentPhotoDao.get(photoId);
		}
		if (photo == null) {
			oper = Constant.OPER_INSTER;
			photo = new ItemContentPhoto();
			photo.setState(Constant.BASE_STATE);
			photo.setPhotoTime(new Date());
		}
		photo.setContentId(contentId);
		photo.setPhotoType(photoType);
		photo.setPhotoName(photoName);
		photo.setRemark(remark);
		if (oper == Constant.OPER_INSTER) {
			itemContentPhotoDao.insert(photo);
		}else{
			itemContentPhotoDao.update(photo);
		}
		return photo;
	}
	
	public ItemContentPhoto getItemContentPhoto(Integer photoId){
		ItemContentPhoto photo = itemContentPhotoDao.get(photoId);
		return photo;
	}

	public ModuleDao getModuleDao() {
		return moduleDao;
	}

	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	public OperModuleDao getOperModuleDao() {
		return operModuleDao;
	}

	public void setOperModuleDao(OperModuleDao operModuleDao) {
		this.operModuleDao = operModuleDao;
	}

	public ModuleItemDao getModuleItemDao() {
		return moduleItemDao;
	}

	public void setModuleItemDao(ModuleItemDao moduleItemDao) {
		this.moduleItemDao = moduleItemDao;
	}

	public ItemContentDao getItemContentDao() {
		return itemContentDao;
	}

	public void setItemContentDao(ItemContentDao itemContentDao) {
		this.itemContentDao = itemContentDao;
	}

	public ItemContentPhotoDao getItemContentPhotoDao() {
		return itemContentPhotoDao;
	}

	public void setItemContentPhotoDao(ItemContentPhotoDao itemContentPhotoDao) {
		this.itemContentPhotoDao = itemContentPhotoDao;
	}
	
}
