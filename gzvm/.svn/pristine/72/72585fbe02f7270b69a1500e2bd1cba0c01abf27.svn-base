package cn.com.voge.gzvm.beans;


import com.voyageci.core.beans.support.BaseBean;

public class ProductAttrData extends BaseBean {
	
	private static final long serialVersionUID = 7906439740701408657L;
	private Integer attrId;
	private Integer relaId;
	private String itemName;
	private Integer productId;
	private String classifyName;
	private Integer dispIndex;
	
	@Override
	public String getIdName() {
		return "attrId";
	}

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public Integer getRelaId() {
		return relaId;
	}

	public void setRelaId(Integer relaId) {
		this.relaId = relaId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
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
		result = prime * result + ((attrId == null) ? 0 : attrId.hashCode());
		result = prime * result
				+ ((classifyName == null) ? 0 : classifyName.hashCode());
		result = prime * result
				+ ((dispIndex == null) ? 0 : dispIndex.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
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
		ProductAttrData other = (ProductAttrData) obj;
		if (attrId == null) {
			if (other.attrId != null)
				return false;
		} else if (!attrId.equals(other.attrId))
			return false;
		if (classifyName == null) {
			if (other.classifyName != null)
				return false;
		} else if (!classifyName.equals(other.classifyName))
			return false;
		if (dispIndex == null) {
			if (other.dispIndex != null)
				return false;
		} else if (!dispIndex.equals(other.dispIndex))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
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
		return "ProductAttrData [attrId=" + attrId + ", relaId=" + relaId
				+ ", itemName=" + itemName + ", productId=" + productId
				+ ", classifyName=" + classifyName + ", dispIndex=" + dispIndex
				+ "]";
	}

}
