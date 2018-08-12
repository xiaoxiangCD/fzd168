package cn.com.voge.gzvm.beans;


import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

public class UserCode extends BaseBean {
	private Integer codeId;
	private Integer userId;
	private Integer year;
	private Date joinDate;
	private String entryCode;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -239895041566788743L;

	@Override
	public String getIdName() {
		return "codeId";
	}

	public Integer getCodeId() {
		return codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
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

	public String getEntryCode() {
		return entryCode;
	}

	public void setEntryCode(String entryCode) {
		this.entryCode = entryCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codeId == null) ? 0 : codeId.hashCode());
		result = prime * result + ((entryCode == null) ? 0 : entryCode.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
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
		UserCode other = (UserCode) obj;
		if (codeId == null) {
			if (other.codeId != null)
				return false;
		} else if (!codeId.equals(other.codeId))
			return false;
		if (entryCode == null) {
			if (other.entryCode != null)
				return false;
		} else if (!entryCode.equals(other.entryCode))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
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
		return "UserCode [codeId=" + codeId + ", userId=" + userId + ", year=" + year + ", joinDate=" + joinDate
				+ ", entryCode=" + entryCode + "]";
	}


}
