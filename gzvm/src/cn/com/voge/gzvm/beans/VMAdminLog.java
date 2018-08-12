package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月3日 下午6:04:11 
 * 类说明 
 */
public class VMAdminLog extends BaseBean {
	
	private static final long serialVersionUID = 210974184477295446L;
	private Integer logId;
	private Integer adminId;
	private String adminName;
	private String module;
	private String method;
	private String describe;
	private Date logTime;
	private Integer logState;
	private String errMsg;
	   
	@Override
	public String getIdName() {
		return "logId";
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public Integer getLogState() {
		return logState;
	}

	public void setLogState(Integer logState) {
		this.logState = logState;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result
				+ ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result
				+ ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((errMsg == null) ? 0 : errMsg.hashCode());
		result = prime * result + ((logId == null) ? 0 : logId.hashCode());
		result = prime * result
				+ ((logState == null) ? 0 : logState.hashCode());
		result = prime * result + ((logTime == null) ? 0 : logTime.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
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
		VMAdminLog other = (VMAdminLog) obj;
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
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (errMsg == null) {
			if (other.errMsg != null)
				return false;
		} else if (!errMsg.equals(other.errMsg))
			return false;
		if (logId == null) {
			if (other.logId != null)
				return false;
		} else if (!logId.equals(other.logId))
			return false;
		if (logState == null) {
			if (other.logState != null)
				return false;
		} else if (!logState.equals(other.logState))
			return false;
		if (logTime == null) {
			if (other.logTime != null)
				return false;
		} else if (!logTime.equals(other.logTime))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VMAdminLog [logId=" + logId + ", adminId=" + adminId
				+ ", adminName=" + adminName + ", module=" + module
				+ ", method=" + method + ", describe=" + describe
				+ ", logTime=" + logTime + ", logState=" + logState
				+ ", errMsg=" + errMsg + "]";
	}
	
}
