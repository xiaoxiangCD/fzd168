package cn.com.voge.gzvm.beans;



import com.voyageci.core.beans.support.BaseBean;

public class TeamMember extends BaseBean {
	private Integer menberId;
	private Integer teamId;
	private Integer userId;
	private String userCode;
	private Integer menberType;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4590101173743937287L;

	@Override
	public String getIdName() {
		return "menberId";
	}

	public Integer getMenberId() {
		return menberId;
	}

	public void setMenberId(Integer menberId) {
		this.menberId = menberId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Integer getMenberType() {
		return menberType;
	}

	public void setMenberType(Integer menberType) {
		this.menberType = menberType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((menberId == null) ? 0 : menberId.hashCode());
		result = prime * result + ((menberType == null) ? 0 : menberType.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((userCode == null) ? 0 : userCode.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		TeamMember other = (TeamMember) obj;
		if (menberId == null) {
			if (other.menberId != null)
				return false;
		} else if (!menberId.equals(other.menberId))
			return false;
		if (menberType == null) {
			if (other.menberType != null)
				return false;
		} else if (!menberType.equals(other.menberType))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		if (userCode == null) {
			if (other.userCode != null)
				return false;
		} else if (!userCode.equals(other.userCode))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeamMember [menberId=" + menberId + ", teamId=" + teamId + ", userId=" + userId + ", userCode="
				+ userCode + ", menberType=" + menberType + "]";
	}




}
