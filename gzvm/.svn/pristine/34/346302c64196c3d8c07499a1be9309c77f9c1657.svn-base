package cn.com.voge.gzvm.template.beans;

import com.voyageci.core.beans.support.BaseBean;

public class OperModule extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8497662513753444905L;
	/**
	 * xzq
	 */
	private Integer operId;
	private Integer moduleId;
	private Integer roleId;	
	private Integer roleName;	

	@Override
	public String getIdName() {
		return "operId";
	}

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRoleName() {
		return roleName;
	}

	public void setRoleName(Integer roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((moduleId == null) ? 0 : moduleId.hashCode());
		result = prime * result + ((operId == null) ? 0 : operId.hashCode());
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
		OperModule other = (OperModule) obj;
		if (moduleId == null) {
			if (other.moduleId != null)
				return false;
		} else if (!moduleId.equals(other.moduleId))
			return false;
		if (operId == null) {
			if (other.operId != null)
				return false;
		} else if (!operId.equals(other.operId))
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
		return "OperModule [operId=" + operId + ", moduleId=" + moduleId + ", roleId=" + roleId + ", roleName="
				+ roleName + "]";
	}



}
