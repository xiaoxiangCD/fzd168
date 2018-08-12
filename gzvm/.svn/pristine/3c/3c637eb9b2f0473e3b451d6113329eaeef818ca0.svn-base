package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

public class WXApiToken extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7125970016987400261L;
	private int tokenId;
	private String token;
	private String tokenType;
	private Date updateTime;
	private Date expiresTime;
	
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(Date expiresTime) {
		this.expiresTime = expiresTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((expiresTime == null) ? 0 : expiresTime.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + tokenId;
		result = prime * result
				+ ((tokenType == null) ? 0 : tokenType.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
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
		WXApiToken other = (WXApiToken) obj;
		if (expiresTime == null) {
			if (other.expiresTime != null)
				return false;
		} else if (!expiresTime.equals(other.expiresTime))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (tokenId != other.tokenId)
			return false;
		if (tokenType == null) {
			if (other.tokenType != null)
				return false;
		} else if (!tokenType.equals(other.tokenType))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WXApiToken [tokenId=" + tokenId + ", token=" + token
				+ ", tokenType=" + tokenType + ", updateTime=" + updateTime
				+ ", expiresTime=" + expiresTime + "]";
	}

}
