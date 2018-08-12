package cn.com.voge.gzvm.action;


import java.util.Map;

import cn.com.voge.gzvm.action.GebileAction;
import cn.com.voge.gzvm.security.AdminSession;
import cn.com.voge.gzvm.service.CompetitionService;

import com.google.common.collect.Maps;
import com.opensymphony.xwork2.Preparable;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PackageAction extends GebileAction implements Preparable {

	private static final long serialVersionUID = -7446869150567157671L;
	private CompetitionService competitionService;
	private String numbers;
	private Integer competiId;
	private Integer packageId;
	private String searchLike;
	private String packageName;
	private Float cost;
	private Integer discountType;
	private String remark;
	
	/** 获取参赛包列表
	 * @author lianzw
	 */
	public void getPackages(){
		Map criteria = Maps.newHashMap();
		if (competiId != null) {
			criteria.put("competiId", competiId);
		}
		if (searchLike!= null) {
			criteria.put("searchLike", searchLike);
		}
		Map result = null;
		try {
			result = competitionService.getPackages(criteria, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result, "获取参赛包");
	}
	
	/** 保存参赛包
	 * @author lianzw
	 */
	public void savePackage(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if (packageId!=null) {
			values.put("packageId", packageId);
		}		
		values.put("packageName", packageName);
		values.put("cost", cost);
		values.put("discountType", discountType);
		values.put("remark", remark);
		Map result = null;
		try {
			result = competitionService.savePackage(values,numbers);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token, result, "PackageAction", "savePackage", "新增/编辑参赛包");
	}
	
	/** 删除参赛包
	 * @author lianzw
	 */
	public void delPackage(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = competitionService.deletePackage(packageId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token, result, "PackageAction", "delPackage", "删除参赛包");
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

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Integer getDiscountType() {
		return discountType;
	}

	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
