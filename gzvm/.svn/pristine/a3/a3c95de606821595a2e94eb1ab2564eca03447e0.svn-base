package cn.com.voge.gzvm.beans;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class PackageNumber extends BaseBean {
	
	private static final long serialVersionUID = -4915264249080305380L;
	private Integer numberId;
	private Integer packageId;
	private String numberName;
	private Integer dispIndex;
	
	@Override
	public String getIdName() {
		return "numberId";
	}

	public Integer getNumberId() {
		return numberId;
	}

	public void setNumberId(Integer numberId) {
		this.numberId = numberId;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getNumberName() {
		return numberName;
	}

	public void setNumberName(String numberName) {
		this.numberName = numberName;
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
				+ ((dispIndex == null) ? 0 : dispIndex.hashCode());
		result = prime * result
				+ ((numberId == null) ? 0 : numberId.hashCode());
		result = prime * result
				+ ((numberName == null) ? 0 : numberName.hashCode());
		result = prime * result
				+ ((packageId == null) ? 0 : packageId.hashCode());
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
		PackageNumber other = (PackageNumber) obj;
		if (dispIndex == null) {
			if (other.dispIndex != null)
				return false;
		} else if (!dispIndex.equals(other.dispIndex))
			return false;
		if (numberId == null) {
			if (other.numberId != null)
				return false;
		} else if (!numberId.equals(other.numberId))
			return false;
		if (numberName == null) {
			if (other.numberName != null)
				return false;
		} else if (!numberName.equals(other.numberName))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PackageNumber [numberId=" + numberId + ", packageId="
				+ packageId + ", numberName=" + numberName + ", dispIndex="
				+ dispIndex + "]";
	}
	
}
