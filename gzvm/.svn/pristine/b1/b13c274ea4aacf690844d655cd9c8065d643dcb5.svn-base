package cn.com.voge.gzvm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;

import com.google.common.collect.Maps;
import com.voyageci.tools.utils.NumberUtils;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.User;
import cn.com.voge.gzvm.manager.CompetitionManager;
import cn.com.voge.gzvm.manager.PackageManager;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月4日 上午11:23:29 
 * 类说明 预留的公共类，写公用方法
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class CompetitionService  extends GzvmService{
	
	protected CompetitionManager competitionManager;
	protected PackageManager packageManager;
	
	public Map getCompetitions(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return competitionManager.getCompetitions(criteria, start, pageSize);
	}
	
	public Map saveCompetition(Map values){
		return competitionManager.saveCompetition(values);
	}
	
	public Map deleteCompetition(Integer competiId){
		return competitionManager.deleteCompetition(competiId);
	}
	
	public Map getJoins(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return competitionManager.getJoins(criteria, start, pageSize);
	}
	
	public Map getJoinDetail(Integer joinId){
		return competitionManager.getJoinDetail(joinId);
	}
	
	/** 验证证件号是否存在系统
	 * @author lianzw
	 * @param idCard
	 * @return
	 */
	public Map validationIdCard(String loginCode){
		Map criteria = Maps.newHashMap();
		criteria.put("mobile", loginCode);
		criteria.put("state", Constant.BASE_STATE);
		User user = userManager.getUser(criteria);
		if (user != null) {
			String msg ="该账号已注册，请使用手机号"+StringUtils.substring(user.getMobile(), 0, 2)+"****"+StringUtils.substring(user.getMobile(), 6)+"登录报名。";
			return getReturnMap(msg, Constant.RESULT_CODE_ERROR);
		}else{
			return getReturnMap("可以报名", Constant.RESULT_CODE_SUCCESS);
		}
	}

	public Map saveJoindetail(Map values,String defineIds,String vals){
		List<Map> infos = new ArrayList<Map>();
		String[] strIds = defineIds.split(",");
		String[] strVals = vals.split(",");
		for (int i = 0; i < strIds.length; i++) {
			Integer defineId = NumberUtils.toInt(strIds[i]);
			String value = strVals[i];
			Map map = Maps.newHashMap();
			map.put("defineId", defineId);
			map.put("value", value);
			infos.add(map);
		}
		Integer userId = getIntValue(values, "userId");
		if (userId == 0) {
			try {
				Map user = userManager.saveUser(values);
				values.put("ownerId", getIntValue(user, "userId"));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else{// 自己报名才传userId
			values.put("ownerId", userId);
		}
		
		return competitionManager.saveJoinDetail(values, infos);
	}
	
	public Map deleteJoinDetail(Integer joinId){
		return competitionManager.deleteJoinDetail(joinId);
	}
	
	public Map delDis(Integer ruleId){
		return competitionManager.delDis(ruleId);
	}
	
	public Map getJonInfoDefines(Map criteria){
		criteria = initCriteria(criteria);
		return competitionManager.getJonInfoDefines(criteria);
	}
	
	public Map saveJoinInfoDefines(Integer competiId,String names, String types,String requireds){
		List<String> nameArr = new ArrayList<String>();
		List<String> typeArr = new ArrayList<String>();
		List<Integer> requiredArr = new ArrayList<Integer>();
		String[] strVals = names.split(",");
		String[] strTypes = types.split(",");
		String[] strReqs = requireds.split(",");
		for (int i = 0; i < strVals.length; i++) {
			nameArr.add(strVals[i]);
			typeArr.add(strTypes[i]);
			Integer required = NumberUtils.toInt(strReqs[i]);
			requiredArr.add(required);
		}
		return competitionManager.saveJoinInfoDefines(competiId, nameArr, typeArr, requiredArr);
	}
	
	public Map saveDiscounts(Integer competiId, String ruleIds,String passwords, String discounts, String disNums){
		List<String> pwArr = new ArrayList<String>();
		List<Float> discountArr = new ArrayList<Float>();
		List<Integer> ruleIdArr = new ArrayList<Integer>();
		List<Integer> disNumArr = new ArrayList<Integer>();
		String[] strPws = passwords.split(",");
		String[] strDcs = discounts.split(",");
		String[] strRis = ruleIds.split(",");
		String[] strDus = disNums.split(",");
		for (int i = 0; i < strPws.length; i++) {
			pwArr.add(strPws[i]);
			discountArr.add(NumberUtils.toFloatValue(strDcs[i]));
			ruleIdArr.add(NumberUtils.toInt(strRis[i]));
			disNumArr.add(NumberUtils.toInt(strDus[i]));
		}
		return competitionManager.saveDiscounts(competiId, ruleIdArr, pwArr, discountArr, disNumArr);
	}
	
	public Map saveCompetitionInsurance(Integer competiId, String fileName, Float cost){
		return competitionManager.saveCompetitionInsurance(competiId, fileName, cost);
	}
	
	public Map saveDiscount(Integer competiId, String password, Float discount,Integer discountNum){
		return competitionManager.saveDiscount(competiId, password, discount,discountNum);
	}
	
	public Map getDiscoun(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return competitionManager.getDiscoun(criteria,start,pageSize);
	}
	
	public Map deleteInsurance(Integer insuranceId){
		return competitionManager.deleteInsurance(insuranceId);
	}
	
	public Map getCompetitionPackage(Integer competiId){
		return competitionManager.getCompetitionPackage(competiId);
	}
	
	public Map saveCompetitionPackage(Integer competiId,String packageIds){
		List<Integer> idList = new ArrayList<Integer>();
		if (packageIds != null && packageIds.length() > 0) {
			String[] numArr = packageIds.split(",");
			for (String string : numArr) {
				idList.add(NumberUtils.toIntValue(string));
			}
		}
		return competitionManager.saveCompetitionPackage(competiId, idList);
	}
	
	public Map getPackages(Map criteria,Integer start, Integer pageSize){
		return packageManager.getPackages(criteria, start, pageSize);
	}
	
	public Map savePackage(Map values, String numbers){
		if (numbers != null && numbers.length() > 0) {
			List<String> numList = new ArrayList<String>();
			String[] numArr = numbers.split(",");
			for (String string : numArr) {
				numList.add(string);
			}
			values.put("numbers", numList);
		}
		return packageManager.savePackage(values);
	}
	
	public Map deletePackage(Integer packageId){
		return packageManager.deletePackage(packageId);
	}
	// ---------- get set ------------ //
	public CompetitionManager getCompetitionManager() {
		return competitionManager;
	}

	public void setCompetitionManager(CompetitionManager competitionManager) {
		this.competitionManager = competitionManager;
	}

	public PackageManager getPackageManager() {
		return packageManager;
	}

	public void setPackageManager(PackageManager packageManager) {
		this.packageManager = packageManager;
	}
	
}
