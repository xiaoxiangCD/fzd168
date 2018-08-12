package cn.com.voge.gzvm.beans;


import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

public class OldUser extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5258642847271717230L;
	private Integer oldId;
	private Integer userId;
	private Integer year;
	private Date joinDate;
	private Date joinTime;
	
	
	@Override
	public String getIdName() {
		return "oldId";
	}


	public Integer getOldId() {
		return oldId;
	}


	public void setOldId(Integer oldId) {
		this.oldId = oldId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
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
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((joinTime == null) ? 0 : joinTime.hashCode());
		result = prime * result + ((oldId == null) ? 0 : oldId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		OldUser other = (OldUser) obj;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (joinTime == null) {
			if (other.joinTime != null)
				return false;
		} else if (!joinTime.equals(other.joinTime))
			return false;
		if (oldId == null) {
			if (other.oldId != null)
				return false;
		} else if (!oldId.equals(other.oldId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "OldUser [oldId=" + oldId + ", userId=" + userId + ", year=" + year + ", joinDate=" + joinDate
				+ ", joinTime=" + joinTime + "]";
	}



}
