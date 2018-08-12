package cn.com.voge.gzvm.beans;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月5日 下午6:06:56 
 * 类说明 
 */
public class Discount extends BaseBean{

	private static final long serialVersionUID = -1164189047500026987L;
	private Integer ruleId;
	private Integer competiId;
	private String password;
	private Float discount;
	private Integer discountNum;
	 
	@Override
	public String getIdName() {
		return "ruleId";
	}

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public Integer getCompetiId() {
		return competiId;
	}

	public void setCompetiId(Integer competiId) {
		this.competiId = competiId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((competiId == null) ? 0 : competiId.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((discountNum == null) ? 0 : discountNum.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((ruleId == null) ? 0 : ruleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discount other = (Discount) obj;
		if (competiId == null) {
			if (other.competiId != null)
				return false;
		} else if (!competiId.equals(other.competiId))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (discountNum == null) {
			if (other.discountNum != null)
				return false;
		} else if (!discountNum.equals(other.discountNum))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (ruleId == null) {
			if (other.ruleId != null)
				return false;
		} else if (!ruleId.equals(other.ruleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Discount [ruleId=" + ruleId + ", competiId=" + competiId + ", password=" + password + ", discount="
				+ discount + ", discountNum=" + discountNum + "]";
	}

}
