/**
 * 
 */
package cn.aposoft.administrativedivision;

/**
 * 行政区划级别
 * 
 * @author LiuJian
 * @version 1.0
 */
public enum DivisionLevel {
	/**
	 * 国家 level=0
	 */
	Country(0),
	/**
	 * 省,直辖市,自治区 level=1
	 */
	Province(1),
	/**
	 * 市,自治州 level=2
	 */
	City(2),
	/**
	 * 区,县 level=3
	 */
	District(3);

	private final int level;

	/**
	 * @return 行政区划级别 [0-3]
	 */
	public final int level() {
		return level;
	}

	private DivisionLevel(int level) {
		this.level = level;
	}

	/**
	 * 根据数字级别查询名称
	 * 
	 * @param level
	 *            数字级别[0-3]
	 * @return
	 */
	public static DivisionLevel toDivisionLevel(int level) {
		if (level < 0 || level > 3)
			return null;
		return DivisionLevel.values()[level];
	}
}
