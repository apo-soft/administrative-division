/**
 * 
 */
package cn.aposoft.administrativedivision;

import java.util.Date;

/**
 * 行政区划:包含省市区三级统一行政区划
 * 
 * @author LiuJian
 * @since 1.0
 */
public interface Division {
	/**
	 * 
	 * @return 数据库顺序ID
	 */
	Integer getId();

	/**
	 * 
	 * @return 行政区划编码
	 */
	String getCode();

	/**
	 * 
	 * @return 行政区划名称
	 */
	String getName();

	/**
	 * 
	 * @return 上级行政区划编码
	 */
	String getParent();

	/**
	 * 
	 * @return 行政区划级别
	 */
	DivisionLevel getDivisionLevel();

	/**
	 * 
	 * @return 最晚变更年份,早于2002年按2002年记
	 */
	Date establishDate();

	/**
	 * 
	 * @return 当前记录变更版本,初始化为0,每次变更 +1
	 */
	Integer getVersion();
}
