package cn.com.voge.gzvm.beans;


import com.voyageci.core.beans.support.BaseBean;

public class OrderPackage extends BaseBean {
	
	private static final long serialVersionUID = 8975147283231693549L;
	private Integer relaId;
	private Integer orderId;
	private Integer competiId;
	private Integer packageId;
	private Integer count;
	private String number;
	
	@Override
	public String getIdName() {
		return "relaId";
	}

	public Integer getRelaId() {
		return relaId;
	}

	public void setRelaId(Integer relaId) {
		this.relaId = relaId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCompetiId() {
		return competiId;
	}

	public void setCompetiId(Integer competiId) {
		this.competiId = competiId;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((competiId == null) ? 0 : competiId.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((packageId == null) ? 0 : packageId.hashCode());
		result = prime * result + ((relaId == null) ? 0 : relaId.hashCode());
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
		OrderPackage other = (OrderPackage) obj;
		if (competiId == null) {
			if (other.competiId != null)
				return false;
		} else if (!competiId.equals(other.competiId))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		if (relaId == null) {
			if (other.relaId != null)
				return false;
		} else if (!relaId.equals(other.relaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderPackage [relaId=" + relaId + ", orderId=" + orderId
				+ ", competiId=" + competiId + ", packageId=" + packageId
				+ ", count=" + count + ", number=" + number + "]";
	}

}
