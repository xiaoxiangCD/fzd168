package cn.com.voge.gzvm.beans;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class JoinPhoto extends BaseBean {
	
	private static final long serialVersionUID = 522748745586602001L;
	private Integer photoId;
	private Integer joinId;
	private String photoName;
	private Integer photoTime;
	
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

	public Integer getJoinId() {
		return joinId;
	}

	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Integer getPhotoTime() {
		return photoTime;
	}

	public void setPhotoTime(Integer photoTime) {
		this.photoTime = photoTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((joinId == null) ? 0 : joinId.hashCode());
		result = prime * result + ((photoId == null) ? 0 : photoId.hashCode());
		result = prime * result
				+ ((photoName == null) ? 0 : photoName.hashCode());
		result = prime * result
				+ ((photoTime == null) ? 0 : photoTime.hashCode());
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
		JoinPhoto other = (JoinPhoto) obj;
		if (joinId == null) {
			if (other.joinId != null)
				return false;
		} else if (!joinId.equals(other.joinId))
			return false;
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
		return true;
	}

	@Override
	public String toString() {
		return "JoinPhoto [photoId=" + photoId + ", joinId=" + joinId
				+ ", photoName=" + photoName + ", photoTime=" + photoTime + "]";
	}
	
}
