package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

public class Competition extends BaseBean {

	private static final long serialVersionUID = 4318552608486116031L;
	private int competiId;// 
	private String competiName;//
	private String competiCode;// 
	private String competiType;
	private String level;//
	private String city;// 
	private String addr;// 
	private Integer joinType;// 
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
	private Integer groupPerNum;
	private Integer groupNum;
	private String descr;

	@Override
	public String getIdName() {
		return "competiId";
	}

	public int getCompetiId() {
		return competiId;
	}

	public void setCompetiId(int competiId) {
		this.competiId = competiId;
	}

	public String getCompetiName() {
		return competiName;
	}

	public void setCompetiName(String competiName) {
		this.competiName = competiName;
	}

	public String getCompetiCode() {
		return competiCode;
	}

	public void setCompetiCode(String competiCode) {
		this.competiCode = competiCode;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getJoinType() {
		return joinType;
	}

	public void setJoinType(Integer joinType) {
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

	public Integer getGroupPerNum() {
		return groupPerNum;
	}

	public void setGroupPerNum(Integer groupPerNum) {
		this.groupPerNum = groupPerNum;
	}

	public Integer getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result
				+ ((chargeType == null) ? 0 : chargeType.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((competiCode == null) ? 0 : competiCode.hashCode());
		result = prime * result + competiId;
		result = prime * result
				+ ((competiName == null) ? 0 : competiName.hashCode());
		result = prime * result
				+ ((competiType == null) ? 0 : competiType.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result
				+ ((discountSet == null) ? 0 : discountSet.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((groupNum == null) ? 0 : groupNum.hashCode());
		result = prime * result
				+ ((groupPerNum == null) ? 0 : groupPerNum.hashCode());
		result = prime * result
				+ ((groupType == null) ? 0 : groupType.hashCode());
		result = prime * result
				+ ((joinEndTime == null) ? 0 : joinEndTime.hashCode());
		result = prime * result
				+ ((joinProve == null) ? 0 : joinProve.hashCode());
		result = prime * result
				+ ((joinStartTime == null) ? 0 : joinStartTime.hashCode());
		result = prime * result
				+ ((joinType == null) ? 0 : joinType.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result
				+ ((luckyType == null) ? 0 : luckyType.hashCode());
		result = prime * result
				+ ((peopleNum == null) ? 0 : peopleNum.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
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
		Competition other = (Competition) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (chargeType == null) {
			if (other.chargeType != null)
				return false;
		} else if (!chargeType.equals(other.chargeType))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (competiCode == null) {
			if (other.competiCode != null)
				return false;
		} else if (!competiCode.equals(other.competiCode))
			return false;
		if (competiId != other.competiId)
			return false;
		if (competiName == null) {
			if (other.competiName != null)
				return false;
		} else if (!competiName.equals(other.competiName))
			return false;
		if (competiType == null) {
			if (other.competiType != null)
				return false;
		} else if (!competiType.equals(other.competiType))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (discountSet == null) {
			if (other.discountSet != null)
				return false;
		} else if (!discountSet.equals(other.discountSet))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (groupNum == null) {
			if (other.groupNum != null)
				return false;
		} else if (!groupNum.equals(other.groupNum))
			return false;
		if (groupPerNum == null) {
			if (other.groupPerNum != null)
				return false;
		} else if (!groupPerNum.equals(other.groupPerNum))
			return false;
		if (groupType == null) {
			if (other.groupType != null)
				return false;
		} else if (!groupType.equals(other.groupType))
			return false;
		if (joinEndTime == null) {
			if (other.joinEndTime != null)
				return false;
		} else if (!joinEndTime.equals(other.joinEndTime))
			return false;
		if (joinProve == null) {
			if (other.joinProve != null)
				return false;
		} else if (!joinProve.equals(other.joinProve))
			return false;
		if (joinStartTime == null) {
			if (other.joinStartTime != null)
				return false;
		} else if (!joinStartTime.equals(other.joinStartTime))
			return false;
		if (joinType == null) {
			if (other.joinType != null)
				return false;
		} else if (!joinType.equals(other.joinType))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (luckyType == null) {
			if (other.luckyType != null)
				return false;
		} else if (!luckyType.equals(other.luckyType))
			return false;
		if (peopleNum == null) {
			if (other.peopleNum != null)
				return false;
		} else if (!peopleNum.equals(other.peopleNum))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Competition [competiId=" + competiId + ", competiName="
				+ competiName + ", competiCode=" + competiCode
				+ ", competiType=" + competiType + ", level=" + level
				+ ", city=" + city + ", addr=" + addr + ", joinType="
				+ joinType + ", joinStartTime=" + joinStartTime
				+ ", joinEndTime=" + joinEndTime + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", discountSet=" + discountSet
				+ ", luckyType=" + luckyType + ", joinProve=" + joinProve
				+ ", chargeType=" + chargeType + ", groupType=" + groupType
				+ ", peopleNum=" + peopleNum + ", groupPerNum=" + groupPerNum
				+ ", groupNum=" + groupNum + ", descr=" + descr + "]";
	}
	
}