package cn.com.voge.gzvm.beans;

import com.voyageci.core.beans.support.BaseBean;

public class AdminRole extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4929808635112753313L;
	/**
	 * xzq
	 */
	private Integer roleId;
	private String roleName;
	private String roleCode;
	private Integer dispIndex;
	private String roleDescribe;	
	

	@Override
	public String getIdName() {
		return "relaId";
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public Integer getDispIndex() {
		return dispIndex;
	}


	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}


	public String getRoleDescribe() {
		return roleDescribe;
	}


	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dispIndex == null) ? 0 : dispIndex.hashCode());
		result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
		result = prime * result + ((roleDescribe == null) ? 0 : roleDescribe.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		AdminRole other = (AdminRole) obj;
		if (dispIndex == null) {
			if (other.dispIndex != null)
				return false;
		} else if (!dispIndex.equals(other.dispIndex))
			return false;
		if (roleCode == null) {
			if (other.roleCode != null)
				return false;
		} else if (!roleCode.equals(other.roleCode))
			return false;
		if (roleDescribe == null) {
			if (other.roleDescribe != null)
				return false;
		} else if (!roleDescribe.equals(other.roleDescribe))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AdminRole [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + ", dispIndex="
				+ dispIndex + ", roleDescribe=" + roleDescribe + "]";
	}



}
