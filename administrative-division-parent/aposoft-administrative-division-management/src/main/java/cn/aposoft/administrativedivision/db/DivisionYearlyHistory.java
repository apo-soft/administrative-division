package cn.aposoft.administrativedivision.db;

import java.util.Date;

public class DivisionYearlyHistory {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column division_yearly_history.id
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column division_yearly_history.publish_time
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	private Date publishTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column division_yearly_history.final_date
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	private Date finalDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column division_yearly_history.source
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	private String source;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column division_yearly_history.url
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	private String url;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column division_yearly_history.id
	 * @return  the value of division_yearly_history.id
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column division_yearly_history.id
	 * @param id  the value for division_yearly_history.id
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column division_yearly_history.publish_time
	 * @return  the value of division_yearly_history.publish_time
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column division_yearly_history.publish_time
	 * @param publishTime  the value for division_yearly_history.publish_time
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column division_yearly_history.final_date
	 * @return  the value of division_yearly_history.final_date
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public Date getFinalDate() {
		return finalDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column division_yearly_history.final_date
	 * @param finalDate  the value for division_yearly_history.final_date
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column division_yearly_history.source
	 * @return  the value of division_yearly_history.source
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public String getSource() {
		return source;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column division_yearly_history.source
	 * @param source  the value for division_yearly_history.source
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column division_yearly_history.url
	 * @return  the value of division_yearly_history.url
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column division_yearly_history.url
	 * @param url  the value for division_yearly_history.url
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}