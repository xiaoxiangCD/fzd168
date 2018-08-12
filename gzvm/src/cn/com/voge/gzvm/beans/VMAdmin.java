package cn.com.voge.gzvm.beans;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class VMAdmin extends BaseBean {
	
	private static final long serialVersionUID = -8391226365390761829L;
	private Integer adminId;
	private String adminCode;
	private String adminName;
	private String adminType;
	private String mobile;
	private String qq;
	private String password;
	private Integer dispIndex;
	
	@Override
	public String getIdName() {
		return "adminId";
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
				+ ((adminCode == null) ? 0 : adminCode.hashCode());
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result
				+ ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result
				+ ((adminType == null) ? 0 : adminType.hashCode());
		result = prime * result
				+ ((dispIndex == null) ? 0 : dispIndex.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
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
		VMAdmin other = (VMAdmin) obj;
		if (adminCode == null) {
			if (other.adminCode != null)
				return false;
		} else if (!adminCode.equals(other.adminCode))
			return false;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminType == null) {
			if (other.adminType != null)
				return false;
		} else if (!adminType.equals(other.adminType))
			return false;
		if (dispIndex == null) {
			if (other.dispIndex != null)
				return false;
		} else if (!dispIndex.equals(other.dispIndex))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VMAdmin [adminId=" + adminId + ", adminCode=" + adminCode
				+ ", adminName=" + adminName + ", adminType=" + adminType
				+ ", mobile=" + mobile + ", qq=" + qq + ", password="
				+ password + ", dispIndex=" + dispIndex + "]";
	}
	
}
