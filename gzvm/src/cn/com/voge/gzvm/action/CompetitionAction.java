package cn.com.voge.gzvm.action;

import java.util.Date;
import java.util.Map;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.security.AdminSession;
import cn.com.voge.gzvm.service.CompetitionService;
 
import com.google.common.collect.Maps;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings({"rawtypes","unchecked"})
public class CompetitionAction extends GebileAction implements Preparable {

	private static final long serialVersionUID = 3201323292295599856L;
	private CompetitionService competitionService;
	private String mobile;
	private String idCard;
	private String defineIds;
	private String values;
	private String competiType;
	private String level;
	private String city;
	private String joinType;
	private Date joinStartTime;
	private Date joinEndTime;// 
	private Date startTime;
	private Date endTime;
	private Integer discountSet;
	private Integer luckyType;
	private Integer joinProve;
	private Integer chargeType;
	private Integer groupType;
	private Integer peopleNum;
	private Integer groupNum;
	private Integer competiId;
	private Integer joinId;
	private Integer productId;
	private String size;
	private String userName;
	private Integer age;
	private Integer insuranceId;
	private String contactName;
	private String contactNumber;
	private String idType;
	private String names;
	private String types;
	private String requireds;
	private String ruleIds;
	private String passwords;
	private String discounts;
	private String disNums;
	private String fileName;
	private Float cost;
	private String competiName;
	private String addr;
	private Float discount;
	private Integer discountNum;
	private Integer ruleId;
	/** 赛事列表
	 * @author lianzw
	 */
	public void getCompetitions(){
		Map criteria = getValueMaps();
		if (searchLike != null) {
			criteria.put("competiLike", searchLike);
		}
		Map result = null;
		try {
			result = competitionService.getCompetitions(criteria, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result, "获取赛事列表");
	}
	
	/** 保存赛事
	 * @author lianzw
	 */
	public void saveCompeti(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map values = getValueMaps();
		Map result = null;
		try {
			result = competitionService.saveCompetition(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(session, result, "CompetitionAction", "saveCompeti", "保存赛事");
	}
	
	/** 删除赛事
	 * @author lianzw
	 */
	public void delCompeti(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map result = null;
		try {
			result = competitionService.deleteCompetition(competiId);
		} catch (Exception e) {
			result = getReturnMap("删除赛事失败！", Constant.RESULT_CODE_ERROR);
			System.err.println(e.getMessage());
		}
		saveAdminLog(session, "CompetitionAction", "delCompeti", "删除赛事接口.", result);
		writeJson(response, result);
	}
	
	/** 获取报名列表
	 * @author lianzw
	 */
	public void getJoins(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map criteria = getValueMaps();
		if (searchLike != null) {
			criteria.put("joinLike", searchLike);
		}
		Map result = null;
		try {
			result = competitionService.getJoins(criteria, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result, "获取报名列表");
	}
	
	/** 获取报名详情
	 * @author lianzw
	 */
	public void getJoinDetail(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map result = null;
		try {
			result = competitionService.getJoinDetail(joinId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result, "获取报名详情");
	}
	
	/** 验证手机号或者证件号存不存在系统
	 * @author lianzw
	 */
	public void validationIdCard(){
		Map result = null;
		String loginCode = null;
		if (mobile != null) {
			loginCode = mobile;
		}else{
			loginCode = idCard;
		}
		try {
			result = competitionService.validationIdCard(loginCode);
		} catch (Exception e) {
			result = getReturnMap("验证失败", Constant.RESULT_CODE_ERROR);
			System.err.println(e.getMessage());
		}
		writeJson(response, result);
	}
	
	/** 保存报名详情
	 * @author lianzw
	 */
	public void saveJoindetail(){
	
		Map params = getValueMaps();
		Map result = null;
		try {
			result = competitionService.saveJoindetail(params, defineIds, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result, "报名失败");
	}
	
	/** 删除报名信息
	 * @author lianzw
	 */
	public void delJoin(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map result = null;
		try {
			result = competitionService.deleteJoinDetail(joinId);
		} catch (Exception e) {
			result = getReturnMap("删除报名信息失败！", Constant.RESULT_CODE_ERROR);
			System.err.println(e.getMessage());
		}
		saveAdminLog(session, "CompetitionAction", "delJoin", "删除报名信息", result);
		writeJson(response, result);
	}
	
	/** 获取定义的报名信息
	 * @author lianzw
	 */
	public void getJonInfoDefines(){
		
		Map criteria = getValueMaps();
		Map result = null;
		try {
			result = competitionService.getJonInfoDefines(criteria);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result, "获取报名信息");
	}
	
	/** 保存定义的报名信息
	 * @author lianzw
	 */
	public void saveDefines(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map result = null;
		try {
			result = competitionService.saveJoinInfoDefines(competiId, names, types, requireds);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(session, result,"CompetitionAction", "saveDefines", "保存定义的报名信息");
	}
	
	/** 保存口令
	 * @author lianzw
	 */
	public void saveDiscounts(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		
		Map result = null;
		try {
			result = competitionService.saveDiscounts(competiId, ruleIds, passwords, discounts, disNums);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(session, result,"CompetitionAction", "saveDiscounts", "保存赛事优惠口令");
	}
	
	/** 保存口令
	 * @author xzq
	 */
	public void saveDiscount(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		
		Map result = null;
		try {
			result = competitionService.saveDiscount(competiId, password, discount, discountNum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(session, result,"CompetitionAction", "saveDiscounts", "保存赛事优惠口令");
	}
	
	/** 获取口令
	 * @author xzq
	 */
	public void getDiscoun(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map criteria = getValueMaps();
		
			criteria.put("competiId", competiId);
		
		Map result = null;
		try {
			result = competitionService.getDiscoun(criteria, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(session, result,"CompetitionAction", "getDiscoun", "获取赛事优惠口令");
	}
	
	/** 保存赛事保险
	 * @author lianzw
	 */
	public void saveInsurance(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		
		Map result = null;
		try {
			result = competitionService.saveCompetitionInsurance(competiId, fileName, cost);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(session, result,"CompetitionAction", "saveInsurance", "保存赛事保险");
	}
	
	/** 删除赛事保险
	 * @author lianzw
	 */
	public void delInsurance(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		
		Map result = null;
		try {
			result = competitionService.deleteInsurance(insuranceId);
		} catch (Exception e) {
			result = getReturnMap("删除保险失败！", Constant.RESULT_CODE_ERROR);
			System.err.println(e.getMessage());
		}
		saveAdminLog(session, "CompetitionAction", "delInsurance", "删除保险", result);
		writeJson(response, result);
	}
	
	/** 删除口令
	 * @author xzq
	 */
	public void delDis(){
		AdminSession session = getAdminSession(true);
		if (session == null) {
			return;
		}
		Map result = null;
		try {
			result = competitionService.delDis(ruleId);
		} catch (Exception e) {
			result = getReturnMap("删除口令失败！", Constant.RESULT_CODE_ERROR);
			System.err.println(e.getMessage());
		}
		saveAdminLog(session, "CompetitionAction", "delDis", "删除口令失败", result);
		writeJson(response, result);
	}
	
	// ------------- //
	public Map getValueMaps(){
		Map criteria = Maps.newHashMap();
		if (competiType != null) {
			criteria.put("competiType", competiType);
		}
		if (level != null) {
			criteria.put("level", level);
		}
		if (city != null) {
			criteria.put("city", city);
		}
		if (groupType != null) {
			criteria.put("groupType", groupType);
		}
		if (joinType != null) {
			criteria.put("joinType", joinType);
		}
		if (state != null) {
			criteria.put("state", state);
		}
		if (joinStartTime != null) {
			criteria.put("joinStartTime",joinStartTime);
		}
		if (joinEndTime != null) {
			criteria.put("joinEndTime",joinEndTime);
		}
		if (startTime != null) {
			criteria.put("startTime", startTime);
		}
		if (endTime != null) {
			criteria.put("endTime", endTime);
		}
		if (discountSet != null) {
			criteria.put("discountSet", discountSet);
		}
		if (luckyType != null) {
			criteria.put("luckyType", luckyType);
		}
		if (joinProve != null) {
			criteria.put("joinProve", joinProve);
		}
		if (chargeType != null) {
			criteria.put("chargeType", chargeType);
		}
		if (peopleNum != null) {
			criteria.put("peopleNum", peopleNum);
		}
		if (groupNum != null) {
			criteria.put("groupNum", groupNum);
		}
		if (competiId != null) {
			criteria.put("competiId", competiId);
		}
		if (userId != null) {
			criteria.put("userId", userId);
		}
		if (productId != null) {
			criteria.put("productId", productId);
		}
		if (size != null) {
			criteria.put("size", size);
		}
		if (userName != null) {
			criteria.put("userName", userName);
		}
		if (age != null) {
			criteria.put("age", age);
		}
		if (contactName != null) {
			criteria.put("contactName", contactName);
		}
		if (contactNumber != null) {
			criteria.put("contactNumber", contactNumber);
		}
		if (idType != null) {
			criteria.put("idType", idType);
		}
		if (idCard != null) {
			criteria.put("idCard", idCard);
		}
		if (mobile != null) {
			criteria.put("mobile", mobile);
		}
		if (competiName != null) {
			criteria.put("competiName", competiName);
		}
		if (addr != null) {
			criteria.put("addr", addr);
		}
		if (state != null) {
			criteria.put("state", state);
		}
		return criteria;
	}
	
	@Override
	public void prepare() throws Exception {
		
	}
	
	public CompetitionService getCompetitionService() {
		return competitionService;
	}

	public void setCompetitionService(CompetitionService competitionService) {
		this.competitionService = competitionService;
	}
	
	public String getCompetiType() {
		return competiType;
	}

	public void setCompetiType(String competiType) {
		this.competiType = competiType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJoinType() {
		return joinType;
	}

	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}

	public Date getJoinStartTime() {
		return joinStartTime;
	}

	public void setJoinStartTime(Date joinStartTime) {
		this.joinStartTime = joinStartTime;
	}

	public Date getJoinEndTime() {
		return joinEndTime;
	}

	public void setJoinEndTime(Date joinEndTime) {
		this.joinEndTime = joinEndTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getDiscountSet() {
		return discountSet;
	}

	public void setDiscountSet(Integer discountSet) {
		this.discountSet = discountSet;
	}

	public Integer getLuckyType() {
		return luckyType;
	}

	public void setLuckyType(Integer luckyType) {
		this.luckyType = luckyType;
	}

	public Integer getJoinProve() {
		return joinProve;
	}

	public void setJoinProve(Integer joinProve) {
		this.joinProve = joinProve;
	}

	public Integer getChargeType() {
		return chargeType;
	}

	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}

	public Integer getGroupType() {
		return groupType;
	}

	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public Integer getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}

	public Integer getCompetiId() {
		return competiId;
	}

	public void setCompetiId(Integer competiId) {
		this.competiId = competiId;
	}

	public Integer getJoinId() {
		return joinId;
	}

	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getDefineIds() {
		return defineIds;
	}

	public void setDefineIds(String defineIds) {
		this.defineIds = defineIds;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getRequireds() {
		return requireds;
	}

	public void setRequireds(String requireds) {
		this.requireds = requireds;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getRuleIds() {
		return ruleIds;
	}

	public void setRuleIds(String ruleIds) {
		this.ruleIds = ruleIds;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getDiscounts() {
		return discounts;
	}

	public void setDiscounts(String discounts) {
		this.discounts = discounts;
	}

	public String getDisNums() {
		return disNums;
	}

	public void setDisNums(String disNums) {
		this.disNums = disNums;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getCompetiName() {
		return competiName;
	}

	public void setCompetiName(String competiName) {
		this.competiName = competiName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}


	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getDiscountNum() {
		return discountNum;
	}

	public void setDiscountNum(Integer discountNum) {
		this.discountNum = discountNum;
	}

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}


	
}