package cn.aposoft.administrativedivision.db.mappers;

import cn.aposoft.administrativedivision.db.DivisionYearlyHistory;
import cn.aposoft.administrativedivision.db.DivisionYearlyHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DivisionYearlyHistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	long countByExample(DivisionYearlyHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int deleteByExample(DivisionYearlyHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int insert(DivisionYearlyHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int insertSelective(DivisionYearlyHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	List<DivisionYearlyHistory> selectByExample(DivisionYearlyHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	DivisionYearlyHistory selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int updateByExampleSelective(@Param("record") DivisionYearlyHistory record,
			@Param("example") DivisionYearlyHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int updateByExample(@Param("record") DivisionYearlyHistory record,
			@Param("example") DivisionYearlyHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int updateByPrimaryKeySelective(DivisionYearlyHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table division_yearly_history
	 * @mbg.generated  Mon Jun 05 17:51:45 CST 2017
	 */
	int updateByPrimaryKey(DivisionYearlyHistory record);
}