/**
 * 
 */
package cn.aposoft.administrativedivision;

import java.util.List;

/**
 * 行政区划查询功能
 * 
 * @author LiuJian
 *
 */
public interface DivisionService {
	/**
	 * 
	 * @return 行政区划列表集合
	 */
	List<Division> getAllDivisions();

	/**
	 * 
	 * @return 1级(省,直辖市,自治区)行政区划集合
	 */
	List<Division> getLevel1Divisions();

	/**
	 * @return 行政区划列表集合
	 */
	List<Division> getDivisions(final String parentCode);

	/**
	 * 根据行政区划编码,获取行政区划信息
	 * 
	 * @param code
	 *            行政区划编码
	 * @return 行政区划信息
	 */
	Division getDivision(final String code);
}
