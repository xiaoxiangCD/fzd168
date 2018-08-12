package cn.com.voge.gzvm.template.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年6月9日 下午5:34:51 
 * 类说明 
 */
public class ItemContentPhoto extends BaseBean {

	private static final long serialVersionUID = 6789828231351871801L;
	private Integer photoId;
	private Integer contentId;
	private Integer photoType;
	private String photoName;
	private String remark;
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

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getPhotoType() {
		return photoType;
	}

	public void setPhotoType(Integer photoType) {
		this.photoType = photoType;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		result = prime * result
				+ ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result + ((photoId == null) ? 0 : photoId.hashCode());
		result = prime * result
				+ ((photoName == null) ? 0 : photoName.hashCode());
		result = prime * result
				+ ((photoTime == null) ? 0 : photoTime.hashCode());
		result = prime * result
				+ ((photoType == null) ? 0 : photoType.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		ItemContentPhoto other = (ItemContentPhoto) obj;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
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
		if (photoType == null) {
			if (other.photoType != null)
				return false;
		} else if (!photoType.equals(other.photoType))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemContentPhoto [photoId=" + photoId + ", contentId="
				+ contentId + ", photoType=" + photoType + ", photoName="
				+ photoName + ", remark=" + remark + ", photoTime=" + photoTime
				+ "]";
	}
	
}