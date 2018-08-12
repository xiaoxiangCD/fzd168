package cn.com.voge.gzvm.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

public class Attachment extends BaseBean {
	private static final long serialVersionUID = 5989256277050907342L;
	private int attachId;// ATTACH_ID 附件ID
	private Integer ownerType;// OWNER_TYPE 情报类型
	private Integer ownerId;// OWNER_ID 情报ID
	private Integer extType;
	private String attachName;// ATTACH_NAME 附件文件名称
	private String attachExt;// ATTACH_EXT 附件扩展名
	private String attachPath;// ATTACH_PATH 文件存放路径
	private Integer fileSize;
	private Integer dispIndex;// DISP_INDEX 顺序
	private Date attachTime;

	@Override
	public String getIdName() {
		return "attachId";
	}

	public int getAttachId() {
		return attachId;
	}

	public void setAttachId(int attachId) {
		this.attachId = attachId;
	}

	public Integer getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachExt() {
		return attachExt;
	}

	public void setAttachExt(String attachExt) {
		this.attachExt = attachExt;
	}

	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public Date getAttachTime() {
		return attachTime;
	}

	public void setAttachTime(Date attachTime) {
		this.attachTime = attachTime;
	}

	public Integer getExtType() {
		return extType;
	}

	public void setExtType(Integer extType) {
		this.extType = extType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((attachExt == null) ? 0 : attachExt.hashCode());
		result = prime * result + attachId;
		result = prime * result
				+ ((attachName == null) ? 0 : attachName.hashCode());
		result = prime * result
				+ ((attachPath == null) ? 0 : attachPath.hashCode());
		result = prime * result
				+ ((attachTime == null) ? 0 : attachTime.hashCode());
		result = prime * result
				+ ((dispIndex == null) ? 0 : dispIndex.hashCode());
		result = prime * result + ((extType == null) ? 0 : extType.hashCode());
		result = prime * result
				+ ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
		result = prime * result
				+ ((ownerType == null) ? 0 : ownerType.hashCode());
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
		Attachment other = (Attachment) obj;
		if (attachExt == null) {
			if (other.attachExt != null)
				return false;
		} else if (!attachExt.equals(other.attachExt))
			return false;
		if (attachId != other.attachId)
			return false;
		if (attachName == null) {
			if (other.attachName != null)
				return false;
		} else if (!attachName.equals(other.attachName))
			return false;
		if (attachPath == null) {
			if (other.attachPath != null)
				return false;
		} else if (!attachPath.equals(other.attachPath))
			return false;
		if (attachTime == null) {
			if (other.attachTime != null)
				return false;
		} else if (!attachTime.equals(other.attachTime))
			return false;
		if (dispIndex == null) {
			if (other.dispIndex != null)
				return false;
		} else if (!dispIndex.equals(other.dispIndex))
			return false;
		if (extType == null) {
			if (other.extType != null)
				return false;
		} else if (!extType.equals(other.extType))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (ownerId == null) {
			if (other.ownerId != null)
				return false;
		} else if (!ownerId.equals(other.ownerId))
			return false;
		if (ownerType == null) {
			if (other.ownerType != null)
				return false;
		} else if (!ownerType.equals(other.ownerType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attachment [attachId=" + attachId + ", ownerType=" + ownerType
				+ ", ownerId=" + ownerId + ", extType=" + extType
				+ ", attachName=" + attachName + ", attachExt=" + attachExt
				+ ", attachPath=" + attachPath + ", fileSize=" + fileSize
				+ ", dispIndex=" + dispIndex + ", attachTime=" + attachTime
				+ "]";
	}

}
