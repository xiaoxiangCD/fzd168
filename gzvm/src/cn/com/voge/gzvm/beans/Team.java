package cn.com.voge.gzvm.beans;


import com.voyageci.core.beans.support.BaseBean;

public class Team extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2625036639122201336L;
	private Integer teamId;
	private Integer competiId;
	private String teamCode;
	private String teamName;
	private Integer teamType;
	
	@Override
	public String getIdName() {
		return "teamId";
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getCompetiId() {
		return competiId;
	}

	public void setCompetiId(Integer competiId) {
		this.competiId = competiId;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamType() {
		return teamType;
	}

	public void setTeamType(Integer teamType) {
		this.teamType = teamType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((competiId == null) ? 0 : competiId.hashCode());
		result = prime * result + ((teamCode == null) ? 0 : teamCode.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		result = prime * result + ((teamType == null) ? 0 : teamType.hashCode());
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
		Team other = (Team) obj;
		if (competiId == null) {
			if (other.competiId != null)
				return false;
		} else if (!competiId.equals(other.competiId))
			return false;
		if (teamCode == null) {
			if (other.teamCode != null)
				return false;
		} else if (!teamCode.equals(other.teamCode))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		if (teamType == null) {
			if (other.teamType != null)
				return false;
		} else if (!teamType.equals(other.teamType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", competiId=" + competiId + ", teamCode=" + teamCode + ", teamName="
				+ teamName + ", teamType=" + teamType + "]";
	}

}
