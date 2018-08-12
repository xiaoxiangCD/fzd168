package cn.com.voge.gzvm.beans;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class SMBanner extends BaseBean {
	
	private static final long serialVersionUID = 5660427534490411446L;
	private Integer bannerId;
	private String bannerName;
	private String bannerLink;
	private Integer dispIndex;
	
	@Override
	public String getIdName() {
		return "bannerId";
	}

	public Integer getBannerId() {
		return bannerId;
	}

	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getBannerLink() {
		return bannerLink;
	}

	public void setBannerLink(String bannerLink) {
		this.bannerLink = bannerLink;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((bannerId == null) ? 0 : bannerId.hashCode());
		result = prime * result
				+ ((bannerLink == null) ? 0 : bannerLink.hashCode());
		result = prime * result
				+ ((bannerName == null) ? 0 : bannerName.hashCode());
		result = prime * result
				+ ((dispIndex == null) ? 0 : dispIndex.hashCode());
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
		SMBanner other = (SMBanner) obj;
		if (bannerId == null) {
			if (other.bannerId != null)
				return false;
		} else if (!bannerId.equals(other.bannerId))
			return false;
		if (bannerLink == null) {
			if (other.bannerLink != null)
				return false;
		} else if (!bannerLink.equals(other.bannerLink))
			return false;
		if (bannerName == null) {
			if (other.bannerName != null)
				return false;
		} else if (!bannerName.equals(other.bannerName))
			return false;
		if (dispIndex == null) {
			if (other.dispIndex != null)
				return false;
		} else if (!dispIndex.equals(other.dispIndex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SMBanner [bannerId=" + bannerId + ", bannerName=" + bannerName
				+ ", bannerLink=" + bannerLink + ", dispIndex=" + dispIndex
				+ "]";
	}
	
}
