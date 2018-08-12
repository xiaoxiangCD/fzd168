package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class JoinCompetition extends BaseBean {
	
	private static final long serialVersionUID = -3725422989382622466L;
	private Integer joinId;
	private Integer competiId;
	private Integer groupType;
	private Integer ownerId;
	private Integer joinType;
	private Integer payState;
	private Integer joinState;
	private Date joinTime;
	
	@Override
	public String getIdName() {
		return "joinId";
	}

	public Integer getJoinId() {
		return joinId;
	}

	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}

	public Integer getCompetiId() {
		return competiId;
	}

	public void setCompetiId(Integer competiId) {
		this.competiId = competiId;
	}

	public Integer getGroupType() {
		return groupType;
	}

	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getJoinType() {
		return joinType;
	}

	public void setJoinType(Integer joinType) {
		this.joinType = joinType;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public Integer getJoinState() {
		return joinState;
	}

	public void setJoinState(Integer joinState) {
		this.joinState = joinState;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((competiId == null) ? 0 : competiId.hashCode());
		result = prime * result
				+ ((groupType == null) ? 0 : groupType.hashCode());
		result = prime * result + ((joinId == null) ? 0 : joinId.hashCode());
		result = prime * result
				+ ((joinState == null) ? 0 : joinState.hashCode());
		result = prime * result
				+ ((joinTime == null) ? 0 : joinTime.hashCode());
		result = prime * result
				+ ((joinType == null) ? 0 : joinType.hashCode());
		result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
		result = prime * result
				+ ((payState == null) ? 0 : payState.hashCode());
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
		JoinCompetition other = (JoinCompetition) obj;
		if (competiId == null) {
			if (other.competiId != null)
				return false;
		} else if (!competiId.equals(other.competiId))
			return false;
		if (groupType == null) {
			if (other.groupType != null)
				return false;
		} else if (!groupType.equals(other.groupType))
			return false;
		if (joinId == null) {
			if (other.joinId != null)
				return false;
		} else if (!joinId.equals(other.joinId))
			return false;
		if (joinState == null) {
			if (other.joinState != null)
				return false;
		} else if (!joinState.equals(other.joinState))
			return false;
		if (joinTime == null) {
			if (other.joinTime != null)
				return false;
		} else if (!joinTime.equals(other.joinTime))
			return false;
		if (joinType == null) {
			if (other.joinType != null)
				return false;
		} else if (!joinType.equals(other.joinType))
			return false;
		if (ownerId == null) {
			if (other.ownerId != null)
				return false;
		} else if (!ownerId.equals(other.ownerId))
			return false;
		if (payState == null) {
			if (other.payState != null)
				return false;
		} else if (!payState.equals(other.payState))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinCompetition [joinId=" + joinId + ", competiId=" + competiId
				+ ", groupType=" + groupType + ", ownerId=" + ownerId
				+ ", joinType=" + joinType + ", payState=" + payState
				+ ", joinState=" + joinState + ", joinTime=" + joinTime + "]";
	}
	
}
