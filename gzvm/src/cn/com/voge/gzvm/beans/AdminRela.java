package cn.com.voge.gzvm.beans;


import com.voyageci.core.beans.support.BaseBean;

public class AdminRela extends BaseBean{

	/**
	 * xzq
	 */
	private static final long serialVersionUID = -8425459501523064318L;
	private Integer relaId;
	private Integer adminId;
	private Integer roleId;	

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

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((relaId == null) ? 0 : relaId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		AdminRela other = (AdminRela) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (relaId == null) {
			if (other.relaId != null)
				return false;
		} else if (!relaId.equals(other.relaId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminRela [relaId=" + relaId + ", adminId=" + adminId + ", roleId=" + roleId + "]";
	}


}
