package cn.com.voge.gzvm.template.beans;

import java.util.Date;

import com.voyageci.core.beans.support.BaseBean;

/** 
 * @author lianzw 
 * @version 创建时间：2017年6月9日 下午5:34:51 
 * 类说明 
 */
public class ItemContent extends BaseBean {

	private static final long serialVersionUID = 5060287323069832837L;
	private Integer contentId;
	private Integer itemId;
	private Integer adminId;
	private String contentTitle;
	private String contentType;
	private String content;
	private Date pubTime;
	private String description;

	@Override
	public String getIdName() {
		return "itemId";
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result
				+ ((contentTitle == null) ? 0 : contentTitle.hashCode());
		result = prime * result
				+ ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((pubTime == null) ? 0 : pubTime.hashCode());
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
		ItemContent other = (ItemContent) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (contentTitle == null) {
			if (other.contentTitle != null)
				return false;
		} else if (!contentTitle.equals(other.contentTitle))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (pubTime == null) {
			if (other.pubTime != null)
				return false;
		} else if (!pubTime.equals(other.pubTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemContent [contentId=" + contentId + ", itemId=" + itemId
				+ ", adminId=" + adminId + ", contentTitle=" + contentTitle
				+ ", contentType=" + contentType + ", content=" + content
				+ ", pubTime=" + pubTime + ", description=" + description + "]";
	}
	
}