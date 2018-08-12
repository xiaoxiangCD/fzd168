package cn.com.voge.gzvm.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.dao.CompetitionPackageDao;
import cn.com.voge.gzvm.dao.PackageDao;
import cn.com.voge.gzvm.dao.PackageNumberDao;
import cn.com.voge.gzvm.dao.PackagePhotoDao;
import cn.com.voge.gzvm.beans.CompetitionPackage;
import cn.com.voge.gzvm.beans.Package;
import cn.com.voge.gzvm.beans.PackageNumber;
import cn.com.voge.gzvm.beans.PackagePhoto;

import com.google.gxp.com.google.common.collect.Maps;
import com.voyageci.core.manage.AbstractEntityManage;
import com.voyageci.tools.utils.BeanUtils;
import com.voyageci.tools.utils.ListUtils;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月16日 上午11:07:40 
 * 类说明 
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class PackageManager extends AbstractEntityManage<Package, PackageDao>{

	private PackageDao packageDao;
	private PackageNumberDao packageNumberDao;
	private PackagePhotoDao packagePhotoDao;
	private CompetitionPackageDao competitionPackageDao;

	@Override
	public Map getRecordDetail(Package object) throws DataAccessException {
		Map record = super.getRecordDetail(object);
		List<String> numbers =  new ArrayList<String>();
		List<PackageNumber> pns = packageNumberDao.findBy("packageId",object.getPackageId());
		if (ListUtils.isNotEmpty(pns)) {
			for (PackageNumber packageNumber : pns) {
				numbers.add(packageNumber.getNumberName());
			}
		}
		record.put("numbers", numbers);
		List<Integer> photoIds =  new ArrayList<Integer>();
		List<PackagePhoto> pts = packagePhotoDao.findBy("packageId",object.getPackageId());
		if (ListUtils.isNotEmpty(pts)) {
			for (PackagePhoto photo : pts) {
				photoIds.add(photo.getPhotoId());
			}
		}
		record.put("photoIds", photoIds);
		return record;
	}
	
	@Override
	public void removeDetail(Package object) throws DataAccessException {
		packageNumberDao.deleteBy("packageId", object.getPackageId());
		packagePhotoDao.deleteBy("packageId", object.getPackageId());
	}
	
	@Override
	public void insertDetail(Package object, Map values) throws DataAccessException {
		List<String> numbers = (List<String>) values.get("numbers");
		savePackageNumbers(object.getPackageId(), numbers);
	}
	
	/** 获取参赛包列表
	 * @author lianzw
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getPackages(Map criteria,Integer start, Integer pageSize) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<Package> pkgs = findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(pkgs)) {
			for (Package pg : pkgs) {
				Map map = getRecordDetail(pg);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = pkgs.size();
			}
		}
		result.put("results", pkgs);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 保存参赛包
	 * @author lianzw
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map savePackage(Map values) throws DataAccessException{
		Integer packageId = getIntValue(values, "packageId");
		int oper = Constant.OPER_UPDATE;
		Package pkg = null;
		if (packageId > 0) {
			pkg = get(packageId);
		}
		if (pkg == null) {
			oper = Constant.OPER_INSTER;
			pkg = new Package();
			pkg.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(pkg, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			insert(pkg);
		}else{
			update(pkg);
		}
		return getRecordDetail(pkg);
	}
	
	/** 删除赛事包
	 * @author lianzw
	 * @param competiId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deletePackage(Integer packageId) throws DataAccessException{
		Package pkg = get(packageId);
		return deletePackage(pkg);
	}
	
	public Map deletePackage(Package pkg) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (pkg == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			List <CompetitionPackage> cps = competitionPackageDao.findBy("packageId",pkg.getPackageId());
			if (ListUtils.isNotEmpty(cps)) {
				code = Constant.RESULT_CODE_ERROR;
				msg = "该参赛包已在赛事应用，不能删除！";
			}else{
				removeDetail(pkg);
				remove(pkg);
			}
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	public Map savePackageNumbers(int packageId, List<String> numbers)  throws DataAccessException{
		packageNumberDao.deleteBy("packageId",packageId);
		if (ListUtils.isNotEmpty(numbers)) {
			for (int i = 0; i < numbers.size(); i++) {
				String num = numbers.get(i);
				PackageNumber number = new PackageNumber();
				number.setState(Constant.BASE_STATE);
				number.setNumberName(num);
				number.setDispIndex(i);
				number.setPackageId(packageId);
				packageNumberDao.insert(number);
			}
		}
		return null;
	}
	
	public PackageDao getPackageDao() {
		return packageDao;
	}

	public void setPackageDao(PackageDao packageDao) {
		this.packageDao = packageDao;
	}

	public PackageNumberDao getPackageNumberDao() {
		return packageNumberDao;
	}

	public void setPackageNumberDao(PackageNumberDao packageNumberDao) {
		this.packageNumberDao = packageNumberDao;
	}

	public PackagePhotoDao getPackagePhotoDao() {
		return packagePhotoDao;
	}

	public void setPackagePhotoDao(PackagePhotoDao packagePhotoDao) {
		this.packagePhotoDao = packagePhotoDao;
	}

	public CompetitionPackageDao getCompetitionPackageDao() {
		return competitionPackageDao;
	}

	public void setCompetitionPackageDao(CompetitionPackageDao competitionPackageDao) {
		this.competitionPackageDao = competitionPackageDao;
	}
	
}
