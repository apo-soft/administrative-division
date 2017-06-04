/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.io.Serializable;
import java.util.Date;

/**
 * 行政区划列表项
 * 
 * @author LiuJian
 *
 */
public class AdministrativeDivisionListItem implements Serializable {
	private static final long serialVersionUID = -5293218515051398059L;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 统计截止日期
	 */
	private Date finalDate;
	/**
	 * 标题对应URL
	 */
	private String contentUrl;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime
	 *            the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * @return the contentUrl
	 */
	public String getContentUrl() {
		return contentUrl;
	}

	/**
	 * @param contentUrl
	 *            the contentUrl to set
	 */
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	/**
	 * @return the finalDate
	 */
	public Date getFinalDate() {
		return finalDate;
	}

	/**
	 * @param finalDate
	 *            the finalDate to set
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

}
