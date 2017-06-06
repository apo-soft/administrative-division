/**
 * 
 */
package cn.aposoft.administrativedivision.spider.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiuJian
 *
 */
public class DivisionUtil {
	final static String CODE_PATTERN_FORMAT = "\\d{6}";
	final static String NAME_PATTERN_FORMAT = "([\u4e00-\u9fa5]+)<\\/span>";
	final static Pattern CODE_PATTERN = Pattern.compile(CODE_PATTERN_FORMAT);
	final static Pattern NAME_PATTERN = Pattern.compile(NAME_PATTERN_FORMAT);

	public static String getCode(String content) {
		return find(content, CODE_PATTERN, 0);
	}

	public static String getName(String content) {
		return find(content, NAME_PATTERN, 1);
	}

	private static String find(String content, Pattern pattern, int group) {
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			return matcher.group(group);
		} else {
			return null;
		}
	}
}
