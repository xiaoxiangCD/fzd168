package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class PackagePhoto extends BaseBean {

	private static final long serialVersionUID = -5585535392157967685L;
	private Integer photoId;
	private Integer packageId;
	private String photoName;
	private Date photoTime;
	private String remark;
	
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

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((packageId == null) ? 0 : packageId.hashCode());
		result = prime * result + ((photoId == null) ? 0 : photoId.hashCode());
		result = prime * result
				+ ((photoName == null) ? 0 : photoName.hashCode());
		result = prime * result
				+ ((photoTime == null) ? 0 : photoTime.hashCode());
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
		PackagePhoto other = (PackagePhoto) obj;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
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
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PackagePhoto [photoId=" + photoId + ", packageId=" + packageId
				+ ", photoName=" + photoName + ", photoTime=" + photoTime
				+ ", remark=" + remark + "]";
	}
	
}
