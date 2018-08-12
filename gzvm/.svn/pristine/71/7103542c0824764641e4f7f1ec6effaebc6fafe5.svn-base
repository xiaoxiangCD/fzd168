package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

public class Sms extends BaseBean {

	private static final long serialVersionUID = 3927602044079457821L;
	private Integer smsId;
	private Integer userId;
	private String mobile;
	private String content;
	private Integer authCode;
	private Integer usefulLife;
	private Date sendTime;
	
	
	@Override
	public String getIdName() {
		return "smsId";
	}


	public Integer getSmsId() {
		return smsId;
	}


	public void setSmsId(Integer smsId) {
		this.smsId = smsId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getAuthCode() {
		return authCode;
	}


	public void setAuthCode(Integer authCode) {
		this.authCode = authCode;
	}


	public Integer getUsefulLife() {
		return usefulLife;
	}


	public void setUsefulLife(Integer usefulLife) {
		this.usefulLife = usefulLife;
	}


	public Date getSendTime() {
		return sendTime;
	}


	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((authCode == null) ? 0 : authCode.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((sendTime == null) ? 0 : sendTime.hashCode());
		result = prime * result + ((smsId == null) ? 0 : smsId.hashCode());
		result = prime * result + ((usefulLife == null) ? 0 : usefulLife.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Sms other = (Sms) obj;
		if (authCode == null) {
			if (other.authCode != null)
				return false;
		} else if (!authCode.equals(other.authCode))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (sendTime == null) {
			if (other.sendTime != null)
				return false;
		} else if (!sendTime.equals(other.sendTime))
			return false;
		if (smsId == null) {
			if (other.smsId != null)
				return false;
		} else if (!smsId.equals(other.smsId))
			return false;
		if (usefulLife == null) {
			if (other.usefulLife != null)
				return false;
		} else if (!usefulLife.equals(other.usefulLife))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Sms [smsId=" + smsId + ", userId=" + userId + ", mobile=" + mobile + ", content=" + content
				+ ", authCode=" + authCode + ", usefulLife=" + usefulLife + ", sendTime=" + sendTime + "]";
	}



}
