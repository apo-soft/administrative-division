/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author LiuJian
 *
 */
public class DateFormatTest {

	@Test
	public void testParsePublishTime() throws ParseException {
		String date = "2017-03-10 10:33";
		Date d = DateUtil.parsePublishTime(date);
		assertNotNull(d);
	}

	/**
	 * 要求覆盖
	 * 
	 * <pre>
	 * {@code  "yyyy年M月d日"} 
	 * {@code  "yyyy年MM月d日"} 
	 * {@code  "yyyy年M月dd日"}
	 * {@code  "yyyy年MM月dd日"}
	 * </pre>
	 * 
	 * @param args
	 */
	@Test
	public void testChineseDateFormat() {
		String date = "2002年12月31日";
		assertTrue(Pattern.matches(DateUtil.CHINESE_DATE_PATTERN_FORMAT, date));
		String date1 = "2016年7月31日";
		assertTrue(Pattern.matches(DateUtil.CHINESE_DATE_PATTERN_FORMAT, date1));
		String date2 = "2002年12月1日";
		assertTrue(Pattern.matches(DateUtil.CHINESE_DATE_PATTERN_FORMAT, date2));
		String date3 = "2002年2月1日";
		assertTrue(Pattern.matches(DateUtil.CHINESE_DATE_PATTERN_FORMAT, date3));
	}

}
