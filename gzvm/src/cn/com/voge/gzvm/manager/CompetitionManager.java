package cn.com.voge.gzvm.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.Competition;
import cn.com.voge.gzvm.beans.CompetitionInsurance;
import cn.com.voge.gzvm.beans.CompetitionPackage;
import cn.com.voge.gzvm.beans.Discount;
import cn.com.voge.gzvm.beans.Insurance;
import cn.com.voge.gzvm.beans.JoinCompetition;
import cn.com.voge.gzvm.beans.JoinInfo;
import cn.com.voge.gzvm.beans.JoinInfoDefine;
import cn.com.voge.gzvm.beans.JoinMember;
import cn.com.voge.gzvm.beans.Package;
//import cn.com.voge.gzvm.beans.User;
import cn.com.voge.gzvm.dao.CompetitionDao;
import cn.com.voge.gzvm.dao.CompetitionInsuranceDao;
import cn.com.voge.gzvm.dao.CompetitionPackageDao;
import cn.com.voge.gzvm.dao.DiscountDao;
import cn.com.voge.gzvm.dao.InsuranceDao;
import cn.com.voge.gzvm.dao.JoinCompetitionDao;
import cn.com.voge.gzvm.dao.JoinInfoDao;
import cn.com.voge.gzvm.dao.JoinInfoDefineDao;
import cn.com.voge.gzvm.dao.JoinMemberDao;
import cn.com.voge.gzvm.dao.JoinPhotoDao;

import com.google.gxp.com.google.common.collect.Maps;
import com.voyageci.core.manage.AbstractEntityManage;
import com.voyageci.tools.utils.BeanUtils;
import com.voyageci.tools.utils.ListUtils;


@SuppressWarnings({"rawtypes","unchecked"})
public class CompetitionManager extends AbstractEntityManage<Competition, CompetitionDao> {

	private CompetitionDao competitionDao;
	private CompetitionPackageDao competitionPackageDao;
	private CompetitionInsuranceDao competitionInsuranceDao;
	private DiscountDao discountDao;
	private JoinInfoDefineDao joinInfoDefineDao;
	private InsuranceDao insuranceDao;
	private JoinCompetitionDao joinCompetitionDao;
	private JoinPhotoDao joinPhotoDao;
	private JoinInfoDao joinInfoDao;
	private JoinMemberDao joinMemberDao;
	private PackageManager packageManager;
//	private UserManager userManager;
	
	@Override
	public Map getRecordDetail(Competition object) throws DataAccessException {
		Map record = super.getRecordDetail(object);
		return record;
	}
	
	@Override
	public void insertDetail(Competition object, Map values) throws DataAccessException {
//		super.insertDetail(object, values);
		
	}
	
	@Override
	public void updateDetail(Competition object, Map newValues, Map oldValues) throws DataAccessException {
//		super.updateDetail(object, newValues, oldValues);
		
	}
	
	@Override
	public void removeDetail(Competition object) throws DataAccessException {
		Map criteria = Maps.newHashMap();
		criteria.put("competiId", object.getCompetiId());
		competitionPackageDao.deleteBy(criteria);
		discountDao.deleteBy(criteria);
		joinInfoDefineDao.deleteBy(criteria);
		
		List<CompetitionInsurance> cis = competitionInsuranceDao.findBy(criteria);
		if (ListUtils.isNotEmpty(cis)) {
			for (CompetitionInsurance ci : cis) {
				deleteInsurance(ci.getInsuranceId());
			}
		}
		
		List<JoinCompetition> jcs = joinCompetitionDao.findBy(criteria);
		if (ListUtils.isNotEmpty(jcs)) {
			for (JoinCompetition jc : jcs) {
				deleteJoinDetail(jc);
			}
		}
	}
	
	/** 获取赛事列表
	 * @author lianzw
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getCompetitions(Map criteria,Integer start, Integer pageSize) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<Competition> cpts = findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(cpts)) {
			for (Competition vmCompetition : cpts) {
				Map map = getRecordDetail(vmCompetition);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = cpts.size();
			}
		}
		result.put("results", cpts);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 新增或更新赛事信息
	 * @author lianzw
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveCompetition(Map values) throws DataAccessException{
		Integer competiId = getIntValue(values, "competiId");
		int oper = Constant.OPER_UPDATE;
		Competition cpt = null;
		if (competiId > 0) {
			cpt = get(competiId);
		}
		if (cpt == null) {
			oper = Constant.OPER_INSTER;
			cpt = new Competition();
			cpt.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(cpt, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			insert(cpt);
		}else{
			update(cpt);
		}
		Map record = getRecordDetail(cpt);
		return record;
	}
	
	/** 删除赛事
	 * @author lianzw
	 * @param competiId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteCompetition(Integer competiId) throws DataAccessException{
		Competition cpt = get(competiId);
		return deleteCompetition(cpt);
	}
	
	public Map deleteCompetition(Competition cpt) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (cpt == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			removeDetail(cpt);
			remove(cpt);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取报名列表
	 * @author lianzw
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map getJoins(Map criteria,Integer start, Integer pageSize) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<JoinCompetition> jcs = joinCompetitionDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(jcs)) {
			for (JoinCompetition jc : jcs) {
				Map map = getJoinDetail(jc);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = jcs.size();
			}
		}
		result.put("results", jcs);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 获取报名详情
	 * @author lianzw
	 * @param joinId
	 * @return
	 * @throws DataAccessException
	 */
	public Map getJoinDetail(Integer joinId) throws DataAccessException{
		JoinCompetition jc = joinCompetitionDao.get(joinId);
		return getJoinDetail(jc);
	}
	
	public Map getJoinDetail(JoinCompetition jc) throws DataAccessException{
		Map record = getRecordMap(jc, true);
		Map criteria = Maps.newHashMap();
		criteria.put("state", Constant.BASE_STATE);
		criteria.put("joinId", jc.getJoinId());
		JoinMember jm = joinMemberDao.firstFindBy(criteria);
		Map mInfo = getRecordMap(jm, true);
		criteria.remove("joinId");
		criteria.put("memberId", jm.getMemberId());	
		List<Map> infos = new ArrayList<Map>();
		List<JoinInfo> jis = joinInfoDao.findBy(criteria);
		if (ListUtils.isNotEmpty(jis)) {
			for (JoinInfo joinInfo : jis) {
				infos.add(getRecordMap(joinInfo, true));
			}
		}
		mInfo.put("infos", infos);
		record.put("member",mInfo);
		return record;
	}
	
	/** 保存报名详细信息
	 * @author lianzw
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveJoinDetail(Map values,List<Map> infos) throws DataAccessException {
		Integer joinId = getIntValue(values, "joinId");
		int oper = Constant.OPER_UPDATE;
		JoinCompetition jc = null;
		if (joinId > 0) {
			jc = joinCompetitionDao.get(joinId);
		}
		if (jc == null) {
			oper = Constant.OPER_INSTER;
			jc = new JoinCompetition();
			jc.setState(Constant.BASE_STATE);
			jc.setPayState(Constant.BASE_STATE);
			jc.setJoinState(Constant.BASE_STATE);
			jc.setJoinTime(new Date());
		}
		try {
			BeanUtils.copyProperties(jc, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			joinCompetitionDao.insert(jc);
		}else{
			joinCompetitionDao.update(jc);
		}
		JoinMember jm = saveJoinMember(values, jc.getJoinId());
		saveJoinInfo(jm.getMemberId(), infos);
		return getJoinDetail(jc); 
	}
	
	/** 保存报名成员
	 * @author lianzw
	 * @param values
	 * @param joinId
	 * @return
	 * @throws DataAccessException
	 */
	public JoinMember saveJoinMember(Map values,Integer joinId) throws DataAccessException{
		Integer memberId = getIntValue(values, "memberId");
		int oper = Constant.OPER_UPDATE;
		JoinMember jm = null;
		if (joinId > 0) {
			jm = joinMemberDao.get(memberId);
		}
		if (jm == null) {
			oper = Constant.OPER_INSTER;
			jm = new JoinMember();
			jm.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(jm, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			jm.setJoinId(joinId);
			joinMemberDao.insert(jm);
		}else{
			joinMemberDao.update(jm);
		}
		
		return jm;
	}
	
	/** 保存填写信息
	 * @author lianzw
	 * @param joinId
	 * @param defineIds
	 * @param dataVals
	 */
	public void saveJoinInfo(Integer memberId,List<Map> infos){
		Map criteria = Maps.newHashMap();
		criteria.put("state", Constant.BASE_STATE);
		criteria.put("memberId", memberId);
		if (ListUtils.isNotEmpty(infos)) {
			for (int i = 0; i < infos.size(); i++) {
				Map info = infos.get(i);
				Integer defineId = getIntValue(info, "defineId");
				if (defineId == 0) {
					continue;
				}
				criteria.put("defineId", defineId);
				JoinInfoDefine define = joinInfoDefineDao.get(defineId);
				if (define != null) {
					String value = getStringValue(info, "value");
					JoinInfo join = joinInfoDao.firstFindBy(criteria);
					if (join == null) {
						join = new JoinInfo();
						join.setState(Constant.BASE_STATE);
						join.setMemberId(memberId);
						join.setDefineId(defineId);
						join.setCompetiId(define.getCompetiId());
						join.setValue(value);
						join.setDataName(define.getDataName());
						join.setDataType(define.getDataType());
						join.setDispIndex(define.getDispIndex());
						join.setRequired(define.getRequired());
						joinInfoDao.insert(info);
					}else{
						if (!join.getValue().equals(value)) {
							joinInfoDao.update(info);
						}
					}
				}else{
					joinInfoDao.deleteBy(criteria);
				}
			}
		}
	}
	
	/** 删除报名详情
	 * @author lianzw
	 * @param joinId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteJoinDetail(Integer joinId) throws DataAccessException{
		JoinCompetition jc = joinCompetitionDao.get(joinId);
		return deleteJoinDetail(jc);
	}
	
	public Map deleteJoinDetail(JoinCompetition jc) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (jc == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			joinPhotoDao.deleteBy("joinId", jc.getJoinId());
			
			List<JoinMember> jms = joinMemberDao.findBy("joinId",jc.getJoinId());
			if (ListUtils.isNotEmpty(jms)) {
				for (JoinMember joinMember : jms) {
					joinInfoDao.deleteBy("memberId", joinMember.getMemberId());
					joinMemberDao.remove(joinMember);
				}
			}
			joinCompetitionDao.remove(jc);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	
	/** 删除口令
	 * @author xzq
	 * @param ruleId
	 * @return
	 * @throws DataAccessException
	 */
	public Map delDis(Integer ruleId) throws DataAccessException{
		Discount dis = discountDao.get(ruleId);
		return delDis(dis);
	}
	
	public Map delDis(Discount dis) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (dis == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			discountDao.remove(dis);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取赛事报名信息定义
	 * @author lianzw
	 * @param criteria
	 * @return
	 * @throws DataAccessException
	 */
	public Map getJonInfoDefines(Map criteria) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> results = new ArrayList<Map>();
		List<JoinInfoDefine> defines = joinInfoDefineDao.findBy(criteria);
		if (ListUtils.isNotEmpty(defines)) {
			for (JoinInfoDefine define : defines) {
				Map map = getRecordMap(define, true);
				results.add(map);
			}
		}
		result.put("results", results);
		return result;
	}
	
	/** 保存用户报名信息定义
	 * @author lianzw
	 * @param competiId
	 * @param names
	 * @param types
	 * @param requireds
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveJoinInfoDefines(Integer competiId,List<String> names, List<String> types,List<Integer> requireds) throws DataAccessException{
		Map criteria = Maps.newHashMap();
		criteria.put("competiId", competiId);
		joinInfoDefineDao.deleteBy(criteria);
		if (ListUtils.isNotEmpty(names)) {
			for (int i = 0; i < names.size(); i++) {
				JoinInfoDefine define = new JoinInfoDefine();
				define.setCompetiId(competiId);
				define.setDataName(names.get(i));
				define.setDataType(types.get(i));
				define.setRequired(requireds.get(i));
				define.setDispIndex(i);
				define.setState(Constant.BASE_STATE);
				joinInfoDefineDao.insert(define);
			}
		}
		return getReturnMap("保存成功", Constant.RESULT_CODE_SUCCESS);
	}
	
	/**
	 * 保存口令
	 * @author lianzw
	 * @param competiId
	 * @param ruleIds
	 * @param passwords
	 * @param discounts
	 * @param disNums
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveDiscounts(Integer competiId, List<Integer> ruleIds, List<String> passwords, List<Float> discounts, List<Integer> disNums) throws DataAccessException{
		Map criteria = Maps.newHashMap();
		criteria.put("competiId", competiId);
		if (ListUtils.isEmpty(passwords)) {
			discountDao.deleteBy(criteria);
		}else {
			List<Discount> dcs = discountDao.findBy(criteria);
			if (ListUtils.isNotEmpty(dcs)) {
				for (Discount discount : dcs) {
					int index = ruleIds.indexOf(discount.getRuleId());
					if(index < 0){
						discountDao.remove(discount);
					}else{
						discount.setPassword(passwords.get(index));
						discount.setDiscount(discounts.get(index));
						discount.setDiscountNum(disNums.get(index));
						discountDao.update(discount);
						ruleIds.remove(index);
						passwords.remove(index);
						discounts.remove(index);
						disNums.remove(index);
					}
				}
			}
			for (int i = 0; i < passwords.size(); i++) {
				Discount discount  = new Discount();
				discount.setCompetiId(competiId);
				discount.setPassword(passwords.get(i));
				discount.setDiscount(discounts.get(i));
				discount.setDiscountNum(disNums.get(i));
				discount.setState(Constant.BASE_STATE);
				discountDao.insert(discount);
			}
		}
		return getReturnMap("保存成功", Constant.RESULT_CODE_SUCCESS);
	}
	
	/** 保存赛事保险
	 * @author lianzw
	 * @param competiId
	 * @param fileName
	 * @param cost
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveCompetitionInsurance(Integer competiId, String fileName, Float cost) throws DataAccessException{
		Map insMap = saveInsurance(null, fileName, cost);
		Integer insuranceId = getIntValue(insMap, "insuranceId");
		CompetitionInsurance ci = new CompetitionInsurance();
		ci.setCompetiId(competiId);
		ci.setInsuranceId(insuranceId);
		ci.setState(Constant.BASE_STATE);
		competitionInsuranceDao.insert(ci);
		return getRecordMap(ci, true);
	}
	
	/** 保存优惠口令
	 * @author xzq
	 * @param competiId
	 * @param password
	 * @param discount
	 * @param disNum    
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveDiscount(Integer competiId, String password, Float discount,Integer discountNum) throws DataAccessException{
		Discount discount1=new Discount();
		discount1.setCompetiId(competiId);
		discount1.setPassword(password);
		discount1.setDiscount(discount);
		discount1.setDiscountNum(discountNum);
		discount1.setState(Constant.BASE_STATE);
		discountDao.insert(discount1);
		return getReturnMap("保存成功", Constant.RESULT_CODE_SUCCESS);
	}
	
	/** 获取优惠口令
	 * @author xzq
	 * @param competiId
	 * @param 
	 * @param 
	 * @param   
	 * @return
	 * @throws DataAccessException
	 */
	public Map getDiscoun(Map criteria,Integer start, Integer pageSize) throws DataAccessException{
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<Discount> dis = discountDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(dis)) {
			for (Discount di : dis) {
				Map map = getRecordMap(di, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = dis.size();
			}
		}
		result.put("results", dis);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 保存保险
	 * @author lianzw
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveInsurance(Integer insuranceId, String fileName, Float cost) throws DataAccessException{
//		Integer insuranceId = getIntValue(values, "insuranceId");
		int oper = Constant.OPER_UPDATE;
		Insurance insurance = null;
		if (insuranceId != null && insuranceId > 0) {
			insurance = insuranceDao.get(insuranceId);
		}
		if (insurance == null) {
			oper = Constant.OPER_INSTER;
			insurance = new Insurance();
			insurance.setState(Constant.BASE_STATE);
			insurance.setUploadTime(new Date());
		}
		
		insurance.setFileName(fileName);
		insurance.setCost(cost);
		insurance.setInsuranceName(fileName);
		
		if (oper == Constant.OPER_INSTER) {
			insuranceDao.insert(insurance);
		}else{
			insuranceDao.update(insurance);
		}
		Map record = getRecordMap(insurance,true);
		return record;
	}
	
	/** 删除保险
	 * @author lianzw
	 * @param insuranceId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteInsurance(Integer insuranceId) throws DataAccessException {
		Insurance insurance = insuranceDao.get(insuranceId);
		return deleteInsurance(insurance);
	}
	
	public Map deleteInsurance(Insurance insurance) throws DataAccessException {
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (insurance == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			competitionInsuranceDao.deleteBy("insuranceId", insurance.getInstanceId());
			insuranceDao.remove(insurance);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取赛事的参赛包
	 * @author lianzw
	 * @param competiId
	 * @return
	 * @throws DataAccessException
	 */
	public Map getCompetitionPackage(Integer competiId) throws DataAccessException {
		Map criteria = Maps.newHashMap();
		criteria.put("competiId", competiId);
		Map result = Maps.newHashMap();
		List<Map> results = new ArrayList<Map>();
		List<CompetitionPackage> cps = competitionPackageDao.findBy(criteria);
		if (ListUtils.isNotEmpty(cps)) {
			for (CompetitionPackage cp : cps) {
				Map map = getRecordMap(cp, true);
				results.add(map);
			}
		}
		result.put("results", results);
		return result;
	}
	
	/** 保存关联赛事的参赛包
	 * @author lianzw
	 * @param competiId
	 * @param packageIds
	 * @throws DataAccessException
	 */
	public Map saveCompetitionPackage(Integer competiId,List<Integer> packageIds) throws DataAccessException{
		Map criteria = Maps.newHashMap();
		criteria.put("competiId", competiId);
		if (ListUtils.isEmpty(packageIds)) {
			competitionPackageDao.deleteBy(criteria);
		}else {
			List<CompetitionPackage> cps = competitionPackageDao.findBy(criteria);
			if (ListUtils.isNotEmpty(cps)) {
				for (CompetitionPackage cp : cps) {
					int index = packageIds.indexOf(cp.getPackageId());
					if(index < 0){
						competitionPackageDao.remove(cp);
					}else{
						packageIds.remove(index);
					}
				}
			}
			for (int i = 0; i < packageIds.size(); i++) {
				Integer packageId = packageIds.get(i);
				Package pkg = packageManager.get(packageId);
				if (pkg != null) {
					CompetitionPackage cp  = new CompetitionPackage();
					cp.setCompetiId(competiId);
					cp.setPackageId(packageId);
					cp.setDiscountType(pkg.getDiscountType());
					cp.setCost(pkg.getCost());
					cp.setState(Constant.BASE_STATE);
					competitionPackageDao.insert(cp);
				}
			}
		}
		Map result = Maps.newHashMap();
		List<CompetitionPackage> cps = competitionPackageDao.findBy(criteria);
		result.put("results", cps);
		return result;
	}
	
	public CompetitionDao getCompetitionDao() {
		return competitionDao;
	}

	public void setCompetitionDao(CompetitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}

	public CompetitionPackageDao getCompetitionPackageDao() {
		return competitionPackageDao;
	}

	public void setCompetitionPackageDao(CompetitionPackageDao competitionPackageDao) {
		this.competitionPackageDao = competitionPackageDao;
	}

	public CompetitionInsuranceDao getCompetitionInsuranceDao() {
		return competitionInsuranceDao;
	}

	public void setCompetitionInsuranceDao(
			CompetitionInsuranceDao competitionInsuranceDao) {
		this.competitionInsuranceDao = competitionInsuranceDao;
	}

	public DiscountDao getDiscountDao() {
		return discountDao;
	}

	public void setDiscountDao(DiscountDao discountDao) {
		this.discountDao = discountDao;
	}

	public JoinInfoDefineDao getJoinInfoDefineDao() {
		return joinInfoDefineDao;
	}

	public void setJoinInfoDefineDao(JoinInfoDefineDao joinInfoDefineDao) {
		this.joinInfoDefineDao = joinInfoDefineDao;
	}

	public InsuranceDao getInsuranceDao() {
		return insuranceDao;
	}

	public void setInsuranceDao(InsuranceDao insuranceDao) {
		this.insuranceDao = insuranceDao;
	}

	public JoinCompetitionDao getJoinCompetitionDao() {
		return joinCompetitionDao;
	}

	public void setJoinCompetitionDao(JoinCompetitionDao joinCompetitionDao) {
		this.joinCompetitionDao = joinCompetitionDao;
	}

	public JoinPhotoDao getJoinPhotoDao() {
		return joinPhotoDao;
	}

	public void setJoinPhotoDao(JoinPhotoDao joinPhotoDao) {
		this.joinPhotoDao = joinPhotoDao;
	}

	public JoinInfoDao getJoinInfoDao() {
		return joinInfoDao;
	}

	public void setJoinInfoDao(JoinInfoDao joinInfoDao) {
		this.joinInfoDao = joinInfoDao;
	}

	public JoinMemberDao getJoinMemberDao() {
		return joinMemberDao;
	}

	public void setJoinMemberDao(JoinMemberDao joinMemberDao) {
		this.joinMemberDao = joinMemberDao;
	}

	public PackageManager getPackageManager() {
		return packageManager;
	}

	public void setPackageManager(PackageManager packageManager) {
		this.packageManager = packageManager;
	}

}
