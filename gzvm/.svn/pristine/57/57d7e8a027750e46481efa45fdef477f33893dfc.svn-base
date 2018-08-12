package cn.com.voge.gzvm.beans;


import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class JoinInfo extends BaseBean {
	
	private static final long serialVersionUID = 344837535362873959L;
	private Integer infoId;
	private Integer memberId;
	private Integer defineId;
	private Integer competiId;
	private String dataName;
	private String dataType;
	private String value;
	private Integer required;
	private Integer dispIndex;
	
	@Override
	public String getIdName() {
		return "infoId";
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getDefineId() {
		return defineId;
	}

	public void setDefineId(Integer defineId) {
		this.defineId = defineId;
	}

	public Integer getCompetiId() {
		return competiId;
	}

	public void setCompetiId(Integer competiId) {
		this.competiId = competiId;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getRequired() {
		return required;
	}

	public void setRequired(Integer required) {
		this.required = required;
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
				+ ((competiId == null) ? 0 : competiId.hashCode());
		result = prime * result
				+ ((dataName == null) ? 0 : dataName.hashCode());
		result = prime * result
				+ ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result
				+ ((defineId == null) ? 0 : defineId.hashCode());
		result = prime * result
				+ ((dispIndex == null) ? 0 : dispIndex.hashCode());
		result = prime * result + ((infoId == null) ? 0 : infoId.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result
				+ ((required == null) ? 0 : required.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		JoinInfo other = (JoinInfo) obj;
		if (competiId == null) {
			if (other.competiId != null)
				return false;
		} else if (!competiId.equals(other.competiId))
			return false;
		if (dataName == null) {
			if (other.dataName != null)
				return false;
		} else if (!dataName.equals(other.dataName))
			return false;
		if (dataType == null) {
			if (other.dataType != null)
				return false;
		} else if (!dataType.equals(other.dataType))
			return false;
		if (defineId == null) {
			if (other.defineId != null)
				return false;
		} else if (!defineId.equals(other.defineId))
			return false;
		if (dispIndex == null) {
			if (other.dispIndex != null)
				return false;
		} else if (!dispIndex.equals(other.dispIndex))
			return false;
		if (infoId == null) {
			if (other.infoId != null)
				return false;
		} else if (!infoId.equals(other.infoId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (required == null) {
			if (other.required != null)
				return false;
		} else if (!required.equals(other.required))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinInfo [infoId=" + infoId + ", memberId=" + memberId
				+ ", defineId=" + defineId + ", competiId=" + competiId
				+ ", dataName=" + dataName + ", dataType=" + dataType
				+ ", value=" + value + ", required=" + required
				+ ", dispIndex=" + dispIndex + "]";
	}
}
