package cn.com.voge.gzvm.beans;


import com.voyageci.core.beans.support.BaseBean;

public class BlackList extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8085984837021750416L;
	/**
	 * 
	 */
	private Integer blackId;
	private Integer userId;
	private Integer description;
	
	@Override
	public String getIdName() {
		return "blackId";
	}

	public Integer getBlackId() {
		return blackId;
	}

	public void setBlackId(Integer blackId) {
		this.blackId = blackId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDescription() {
		return description;
	}

	public void setDescription(Integer description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((blackId == null) ? 0 : blackId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		BlackList other = (BlackList) obj;
		if (blackId == null) {
			if (other.blackId != null)
				return false;
		} else if (!blackId.equals(other.blackId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		return "BlackList [blackId=" + blackId + ", userId=" + userId + ", description=" + description + "]";
	}


}
