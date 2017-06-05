/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 行政区划信息
 * 
 * @author LiuJian
 *
 */
public class AdministrativeDivisionContent implements Serializable {
	private static final long serialVersionUID = 458294241183694884L;

	/**
	 * 区划明细发布URL
	 */
	private String url;
	/**
	 * 内容来源
	 */
	private String source;

	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 截止日期
	 */
	private Date finalDate;
	/**
	 * 标题
	 */
	private String title;

	private List<AdministrativeDivision> divisions;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public List<AdministrativeDivision> getDivisions() {
		return divisions;
	}

	public void setDivisions(List<AdministrativeDivision> divisions) {
		this.divisions = divisions;
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
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
