package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

public class AdminToken extends BaseBean{

	private static final long serialVersionUID = -2483918241446169257L;
	private int tokenId;
	private int adminId;
	private String token;
	private String adminCode;
	private String adminName;
	private String roleCode;
	private int roleId;
	private Date loginTime;
	private Date expTime;
	private String clientOs;
	private String terminal;
	private String userAgent;

	@Override
	public String getIdName() {
		return "tokenId";
	}

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getExpTime() {
		return expTime;
	}

	public void setExpTime(Date expTime) {
		this.expTime = expTime;
	}

	public String getClientOs() {
		return clientOs;
	}

	public void setClientOs(String clientOs) {
		this.clientOs = clientOs;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((adminCode == null) ? 0 : adminCode.hashCode());
		result = prime * result + adminId;
		result = prime * result
				+ ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result
				+ ((clientOs == null) ? 0 : clientOs.hashCode());
		result = prime * result + ((expTime == null) ? 0 : expTime.hashCode());
		result = prime * result
				+ ((loginTime == null) ? 0 : loginTime.hashCode());
		result = prime * result
				+ ((roleCode == null) ? 0 : roleCode.hashCode());
		result = prime * result + roleId;
		result = prime * result
				+ ((terminal == null) ? 0 : terminal.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + tokenId;
		result = prime * result
				+ ((userAgent == null) ? 0 : userAgent.hashCode());
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
		AdminToken other = (AdminToken) obj;
		if (adminCode == null) {
			if (other.adminCode != null)
				return false;
		} else if (!adminCode.equals(other.adminCode))
			return false;
		if (adminId != other.adminId)
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (clientOs == null) {
			if (other.clientOs != null)
				return false;
		} else if (!clientOs.equals(other.clientOs))
			return false;
		if (expTime == null) {
			if (other.expTime != null)
				return false;
		} else if (!expTime.equals(other.expTime))
			return false;
		if (loginTime == null) {
			if (other.loginTime != null)
				return false;
		} else if (!loginTime.equals(other.loginTime))
			return false;
		if (roleCode == null) {
			if (other.roleCode != null)
				return false;
		} else if (!roleCode.equals(other.roleCode))
			return false;
		if (roleId != other.roleId)
			return false;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (tokenId != other.tokenId)
			return false;
		if (userAgent == null) {
			if (other.userAgent != null)
				return false;
		} else if (!userAgent.equals(other.userAgent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminToken [tokenId=" + tokenId + ", adminId=" + adminId
				+ ", token=" + token + ", adminCode=" + adminCode
				+ ", adminName=" + adminName + ", roleCode=" + roleCode
				+ ", roleId=" + roleId + ", loginTime=" + loginTime
				+ ", expTime=" + expTime + ", clientOs=" + clientOs
				+ ", terminal=" + terminal + ", userAgent=" + userAgent + "]";
	}

}
