/**
 * 
 */
package cn.aposoft.administrativedivision.spider.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 日期工具类
 * 
 * @author LiuJian
 *
 */
public class DateUtil {
	static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	static final SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
	static final SimpleDateFormat publishTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	static final String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
	static final String CHINESE_DATE_PATTERN_FORMAT = "\\d{4}[\u4e00-\u9fa5]{1}\\d{1,2}[\u4e00-\u9fa5]{1}\\d{1,2}[\u4e00-\u9fa5]{1}";
	static final String PUBLISH_TIME_PATTERN_FORMAT = "\\d{4}-\\d{2}-\\d{2}(.)+\\d{2}:\\d{2}";
	static final Pattern CHINESE_DATE_PATTERN = Pattern.compile(CHINESE_DATE_PATTERN_FORMAT);
	static final Pattern PUBLISH_TIME_PATTERN = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}).+(\\d{2}:\\d{2})");

	public static Date parsePublishDate(String text) throws ParseException {
		return dateFormat.parse(text);
	}

	public static Date parseChineseDate(String finalDateStr) throws ParseException {
		return chineseDateFormat.parse(finalDateStr);
	}

	public static Date parsePublishTime(String dateStr) throws ParseException {
		return publishTimeFormat.parse(dateStr);
	}

}
