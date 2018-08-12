package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author xzq
 * @version 创建时间：2017年5月17日 下午6:04:11 
 * 类说明 
 */
public class UserPhoto extends BaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8001845722330713522L;
	private Integer photoId;
	private Integer userId;
	private String photoName;
	private Date photoTime;
	
	@Override
	public String getIdName() {
		return "photoId";
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Date getPhotoTime() {
		return photoTime;
	}

	public void setPhotoTime(Date photoTime) {
		this.photoTime = photoTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((photoId == null) ? 0 : photoId.hashCode());
		result = prime * result + ((photoName == null) ? 0 : photoName.hashCode());
		result = prime * result + ((photoTime == null) ? 0 : photoTime.hashCode());
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
		UserPhoto other = (UserPhoto) obj;
		if (photoId == null) {
			if (other.photoId != null)
				return false;
		} else if (!photoId.equals(other.photoId))
			return false;
		if (photoName == null) {
			if (other.photoName != null)
				return false;
		} else if (!photoName.equals(other.photoName))
			return false;
		if (photoTime == null) {
			if (other.photoTime != null)
				return false;
		} else if (!photoTime.equals(other.photoTime))
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
		return "UserPhoto [photoId=" + photoId + ", userId=" + userId + ", photoName=" + photoName + ", photoTime="
				+ photoTime + "]";
	}


}
