package cn.aposoft.administrativedivision.db;

import java.util.Date;

import cn.aposoft.administrativedivision.Division;
import cn.aposoft.administrativedivision.DivisionLevel;

public class AdministrativeDivision implements Division {
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column administrative_division.id
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	private Integer id;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column administrative_division.code
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	private String code;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column administrative_division.name
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	private String name;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column administrative_division.parent
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	private String parent;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column administrative_division.division_level
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	private DivisionLevel divisionLevel;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column administrative_division.establish_date
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	private Date establishDate;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column administrative_division.version
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	private Integer version;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column administrative_division.id
	 *
	 * @return the value of administrative_division.id
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column administrative_division.id
	 *
	 * @param id
	 *            the value for administrative_division.id
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column administrative_division.code
	 *
	 * @return the value of administrative_division.code
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column administrative_division.code
	 *
	 * @param code
	 *            the value for administrative_division.code
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column administrative_division.name
	 *
	 * @return the value of administrative_division.name
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column administrative_division.name
	 *
	 * @param name
	 *            the value for administrative_division.name
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column administrative_division.parent
	 *
	 * @return the value of administrative_division.parent
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column administrative_division.parent
	 *
	 * @param parent
	 *            the value for administrative_division.parent
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column administrative_division.division_level
	 *
	 * @return the value of administrative_division.division_level
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public DivisionLevel getDivisionLevel() {
		return divisionLevel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column administrative_division.division_level
	 *
	 * @param divisionLevel
	 *            the value for administrative_division.division_level
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public void setDivisionLevel(DivisionLevel divisionLevel) {
		this.divisionLevel = divisionLevel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column administrative_division.establish_date
	 *
	 * @return the value of administrative_division.establish_date
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public Date getEstablishDate() {
		return establishDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column administrative_division.establish_date
	 *
	 * @param establishDate
	 *            the value for administrative_division.establish_date
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column administrative_division.version
	 *
	 * @return the value of administrative_division.version
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column administrative_division.version
	 *
	 * @param version
	 *            the value for administrative_division.version
	 *
	 * @mbg.generated Mon Jun 05 17:51:45 CST 2017
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}