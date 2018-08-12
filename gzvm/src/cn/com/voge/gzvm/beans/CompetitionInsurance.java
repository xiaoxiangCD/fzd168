package cn.com.voge.gzvm.beans;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月5日 下午6:06:56 
 * 类说明 
 */
public class CompetitionInsurance extends BaseBean{

	private static final long serialVersionUID = -5425664189426175869L;
	private Integer relaId;
	private Integer insuranceId;
	private Integer competiId;
	 
	@Override
	public String getIdName() {
		return "relaId";
	}

	public Integer getRelaId() {
		return relaId;
	}

	public void setRelaId(Integer relaId) {
		this.relaId = relaId;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Integer getCompetiId() {
		return competiId;
	}

	public void setCompetiId(Integer competiId) {
		this.competiId = competiId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((competiId == null) ? 0 : competiId.hashCode());
		result = prime * result
				+ ((insuranceId == null) ? 0 : insuranceId.hashCode());
		result = prime * result + ((relaId == null) ? 0 : relaId.hashCode());
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
		CompetitionInsurance other = (CompetitionInsurance) obj;
		if (competiId == null) {
			if (other.competiId != null)
				return false;
		} else if (!competiId.equals(other.competiId))
			return false;
		if (insuranceId == null) {
			if (other.insuranceId != null)
				return false;
		} else if (!insuranceId.equals(other.insuranceId))
			return false;
		if (relaId == null) {
			if (other.relaId != null)
				return false;
		} else if (!relaId.equals(other.relaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompetitionInsurance [relaId=" + relaId + ", insuranceId="
				+ insuranceId + ", competiId=" + competiId + "]";
	}
	
}
