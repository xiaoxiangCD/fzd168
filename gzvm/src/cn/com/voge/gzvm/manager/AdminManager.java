package cn.com.voge.gzvm.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.AdminRela;
import cn.com.voge.gzvm.beans.AdminRole;
import cn.com.voge.gzvm.beans.AdminToken;
import cn.com.voge.gzvm.beans.SMBanner;
import cn.com.voge.gzvm.beans.VMAdmin;
import cn.com.voge.gzvm.beans.VMAdminLog;
import cn.com.voge.gzvm.dao.AdminRelaDao;
import cn.com.voge.gzvm.dao.AdminRoleDao;
import cn.com.voge.gzvm.dao.AdminTokenDao;
import cn.com.voge.gzvm.dao.SMBannerDao;
import cn.com.voge.gzvm.dao.VMAdminDao;
import cn.com.voge.gzvm.dao.VMAdminLogDao;

import com.google.gxp.com.google.common.collect.Maps;
import com.voyageci.core.manage.AbstractEntityManage;
import com.voyageci.tools.utils.BeanUtils;
import com.voyageci.tools.utils.GeneralUtils;
import com.voyageci.tools.utils.ListUtils;
import com.voyageci.tools.utils.WebUtils;


@SuppressWarnings({"rawtypes","unchecked"})
public class AdminManager extends AbstractEntityManage<VMAdmin, VMAdminDao> {

	private VMAdminDao vmAdminDao;
	private VMAdminLogDao vmAdminLogDao;
	private SMBannerDao smBannerDao;
	private AdminTokenDao adminTokenDao;
	private AdminRoleDao adminRoleDao;
	private AdminRelaDao adminRelaDao;
	
	@Override
	public Map getRecordDetail(VMAdmin object) throws DataAccessException {
		Map record = super.getRecordDetail(object);
		AdminRela adminRela = adminRelaDao.firstFindBy("adminId", object.getAdminId());
		if (adminRela != null) {
			record.put("roleId", adminRela.getRoleId());
		}
		return record;
	}
	
	@Override
	public void insertDetail(VMAdmin object, Map values) throws DataAccessException {
		
		Integer roleId = getIntValue(values, "roleId");
		if (roleId != 0) {
			Map criteria = Maps.newHashMap();
			criteria.put("adminId", object.getAdminId());
			criteria.put("roleId", roleId);
			saveAdminRelaRole(criteria);
		}
		
	}
	
	@Override
	public void updateDetail(VMAdmin object, Map newValues, Map oldValues)
			throws DataAccessException {
		
		Integer roleId = getIntValue(newValues, "roleId");
		if (roleId != 0) {
			Map criteria = Maps.newHashMap();
			criteria.put("adminId", object.getAdminId());
			criteria.put("roleId", roleId);
			AdminRela adminRela = adminRelaDao.firstFindBy("adminId", object.getAdminId());
			if (adminRela != null) {
				criteria.put("relaId", adminRela.getRelaId());
			}
			saveAdminRelaRole(criteria);
		}
	}
	
	@Override
	public void removeDetail(VMAdmin object) throws DataAccessException {
		adminRelaDao.deleteBy("adminId", object.getAdminId());
	}
	
	public VMAdmin getAdmin(Map criteria) throws DataAccessException{
		VMAdmin amdin = firstFindBy(criteria);
		return amdin;
	}
	
	/** 获取管理员列表
	 * @author lianzw
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getAdmins(Map criteria,Integer start, Integer pageSize) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<VMAdmin> admins = findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(admins)) {
			for (VMAdmin vmAdmin : admins) {
				Map map = getRecordDetail(vmAdmin);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = admins.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 获取管理员所有角色列表
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getAdminRoles(Map criteria,Integer start, Integer pageSize) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<AdminRole> adminRoles = adminRoleDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(adminRoles)) {
			for (AdminRole adminRole : adminRoles) {
				Map map = getRecordMap(adminRole,true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = adminRoles.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	
	/** 获取管理员角色
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getAdminRelaRoles(Integer adminId,Integer start, Integer pageSize) throws DataAccessException{
		Map criteria = new HashMap();
		criteria.put("adminId", adminId);
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<AdminRela> adminRelas = adminRelaDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(adminRelas)) {
			for (AdminRela adminRela : adminRelas) {
				Map map = getRecordMap(adminRela,true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = adminRelas.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	
	/** 新增或更新管理员信息
	 * @author lianzw
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveAdmin(Map values) throws DataAccessException{
		Integer adminId = getIntValue(values, "adminId");
		int oper = Constant.OPER_UPDATE;
		VMAdmin admin = null;
		if (adminId > 0) {
			admin = get(adminId);
		}
		if (admin == null) {
			oper = Constant.OPER_INSTER;
			admin = new VMAdmin();
			admin.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(admin, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			insert(admin);
			insertDetail(admin, values);
		}else{
			update(admin);
			updateDetail(admin, values, null);
		}
		Map record = getRecordDetail(admin);
		return record;
	}
	
	public Map savePassword(Integer adminId,String oldPassword,String password) throws DataAccessException {
		VMAdmin admin = get(adminId);
		if (admin == null) {
			return getReturnMap("管理员已经不存在", Constant.RESULT_CODE_ERROR);
		}
		if (oldPassword != null) {
			if (admin.getPassword() != GeneralUtils.MD5(oldPassword)) {
				return getReturnMap("旧密码不正确，", Constant.RESULT_CODE_ERROR);
			}
		}
		admin.setPassword(GeneralUtils.MD5(password));
		update(admin);
		return getRecordDetail(admin);
	}
	
	/** 新增或更新管理员角色
	 * @author xzq
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveAdminRole(Map values) throws DataAccessException{
		Integer roleId = getIntValue(values, "roleId");
		int oper = Constant.OPER_UPDATE;
		AdminRole adminRole = null;
		if (roleId > 0) {
			adminRole = adminRoleDao.get(roleId);
		}
		if (adminRole == null) {
			oper = Constant.OPER_INSTER;
			adminRole = new AdminRole();
			adminRole.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(adminRole, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			adminRoleDao.insert(adminRole);
		}else{
			adminRoleDao.update(adminRole);
		}
		Map record = getRecordMap(adminRole,true);
		return record;
	}
	
	/** 新增管理员角色
	 * @author xzq
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveAdminRelaRole(Map values) throws DataAccessException{
		Integer relaId = getIntValue(values, "relaId");
		int oper = Constant.OPER_UPDATE;
		AdminRela adminRela = null;
		if (relaId > 0) {
			adminRela =adminRelaDao.get(relaId);
		}
		if (adminRela == null) {
			oper = Constant.OPER_INSTER;
			adminRela = new AdminRela();
			adminRela.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(adminRela, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			adminRelaDao.insert(adminRela);
		}else{
			adminRelaDao.update(adminRela);
		}
		Map record = getRecordMap(adminRela, true);
		return record;
	}
	
	
	
	/** 删除管理员
	 * @author lianzw
	 * @param adminId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteAdmin(Integer adminId) throws DataAccessException{
		VMAdmin admin = get(adminId);
		return deleteAdmin(admin);
	}
	
	
	/** 删除角色
	 * @author xzq
	 * @param roleId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delAdminRole(Integer roleId) throws DataAccessException{
		AdminRole adminRole = adminRoleDao.get(roleId);
		return delAdminRole(adminRole);
	}
	
	public Map delAdminRole(AdminRole adminRole) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (adminRole == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			adminRoleDao.remove(adminRole);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 删除管理员角色
	 * @author xzq
	 * @param roleId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delAdminRelaRole(Integer relaId) throws DataAccessException{
		AdminRela adminRela = adminRelaDao.get(relaId);
		return delAdminRelaRole(adminRela);
	}
	
	public Map delAdminRelaRole(AdminRela adminRela) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (adminRela == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			adminRelaDao.remove(adminRela);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	
	
	public Map deleteAdmin(VMAdmin admin) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (admin == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			remove(admin);
		}

		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** ------ 操作日志   ------ */
	
	/** 获取操作日志列表
	 * @author lianzw
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Map getAdminLogs(Map criteria, Integer start, Integer pageSize){
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<VMAdminLog> logs = vmAdminLogDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(logs)) {
			for (VMAdminLog log : logs) {
				Map map = getRecordMap(log, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = logs.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}

	/** 保存管理员操作日志
	 * @author lianzw
	 * @param adminId
	 * @param module
	 * @param method
	 * @param describe
	 * @return
	 */
	public Map saveAdminLog(Integer adminId, String module, String method, String describe,Integer logState,String errMsg){
		VMAdmin admin = get(adminId);
		VMAdminLog log = null;
		if (admin != null) {
			log = new VMAdminLog();
			log.setAdminId(adminId);
			log.setAdminName(admin.getAdminName());
			log.setModule(module);
			log.setMethod(method);
			log.setDescribe(describe);
			log.setLogTime(new Date());
			log.setErrMsg(errMsg);
			log.setLogState(logState);
			log.setState(Constant.BASE_STATE);
			vmAdminLogDao.insert(log);
		}
		if (log == null) {
			return null;
		}
		return getRecordMap(log, true);
	}
	
	/** 获取管理员token
	 * @author lianzw
	 * @param criteria
	 * @return
	 * @throws DataAccessException
	 */
	public AdminToken getAdminToken(Map criteria) throws DataAccessException{
		AdminToken token = adminTokenDao.firstFindBy(criteria); 
		return token;
	}
	
	/** 保存管理员登录token数据
	 * @author lianzw
	 * @param adminId
	 * @param request
	 * @return
	 */
	public AdminToken saveAdminToken(VMAdmin admin,HttpServletRequest request) throws DataAccessException{
//		VMAdmin admin = get(adminId);
		AdminToken token = null; 
		if (admin != null) {
			Map criteria = Maps.newHashMap();
			criteria.put("state", Constant.BASE_STATE);
			criteria.put("adminId", admin.getAdminId());
			Integer oper = Constant.OPER_UPDATE;
			token = adminTokenDao.firstFindBy(criteria);
			if (token == null) {
				token = new AdminToken();
				token.setAdminId(admin.getAdminId());
				token.setState(Constant.BASE_STATE);
				oper = Constant.OPER_INSTER;
			}
			token.setAdminCode(admin.getAdminCode());
			token.setAdminName(admin.getAdminName());
			token.setToken(WebUtils.getSessionId(request));
			token.setLoginTime(new Date());
			if (oper == Constant.OPER_INSTER) {
				adminTokenDao.insert(token);
			}else{
				adminTokenDao.update(token);
			}
		}
		return token;
	}
	
	/** 获取banner列表
	 * @author lianzw
	 * @param criteria
	 * @return
	 * @throws DataAccessException
	 */
	public Map getBanners(Map criteria) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<SMBanner> banners = smBannerDao.findBy(criteria);
		Integer count = 0;
		if (ListUtils.isNotEmpty(banners)) {
			for (SMBanner banner : banners) {
				Map map = getRecordMap(banner, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = banners.size();
			}
		}
		result.put("results", maps);
		result.put("totalCount", count);
		return result;
	}
	
	/** 新增或更新系统模块
	 * @author xzq
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveBanner(Map values) throws DataAccessException{
		Integer bannerId = getIntValue(values, "bannerId");
		int oper = Constant.OPER_UPDATE;
		SMBanner banner = null;
		if (bannerId > 0) {
			banner = smBannerDao.get(bannerId);
		}
		if (banner == null) {
			oper = Constant.OPER_INSTER;
			banner = new SMBanner();
			banner.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(banner, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			smBannerDao.insert(banner);
		}else{
			smBannerDao.update(banner);
		}
		Map record = getRecordMap(banner, true);
		return record;
	}
	
	/** 删除banner
	 * @author xzq
	 * @param moduleId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delBanner(Integer bannerId) throws DataAccessException{
		SMBanner banner = smBannerDao.get(bannerId);
		return delBanner(banner);
	}
	
	public Map delBanner(SMBanner module) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (module == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			smBannerDao.remove(module);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	public VMAdminDao getVmAdminDao() {
		return vmAdminDao;
	}

	public void setVmAdminDao(VMAdminDao vmAdminDao) {
		this.vmAdminDao = vmAdminDao;
	}

	public VMAdminLogDao getVmAdminLogDao() {
		return vmAdminLogDao;
	}

	public void setVmAdminLogDao(VMAdminLogDao vmAdminLogDao) {
		this.vmAdminLogDao = vmAdminLogDao;
	}

	public AdminTokenDao getAdminTokenDao() {
		return adminTokenDao;
	}

	public void setAdminTokenDao(AdminTokenDao adminTokenDao) {
		this.adminTokenDao = adminTokenDao;
	}

	public AdminRoleDao getAdminRoleDao() {
		return adminRoleDao;
	}

	public void setAdminRoleDao(AdminRoleDao adminRoleDao) {
		this.adminRoleDao = adminRoleDao;
	}

	public AdminRelaDao getAdminRelaDao() {
		return adminRelaDao;
	}

	public void setAdminRelaDao(AdminRelaDao adminRelaDao) {
		this.adminRelaDao = adminRelaDao;
	}
	
}