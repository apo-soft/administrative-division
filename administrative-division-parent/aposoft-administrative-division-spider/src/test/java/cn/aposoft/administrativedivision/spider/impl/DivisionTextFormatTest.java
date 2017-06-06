/**
 * 
 */
package cn.aposoft.administrativedivision.spider.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author LiuJian
 *
 */
public class DivisionTextFormatTest {

	@Test
	public void testTextCodeFormat() {
		String text = ">110100<span>";
		String pattern_format = "\\d{6}";
		Pattern pattern = Pattern.compile(pattern_format);
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			String code = matcher.group(0);
			System.out.println(code);
		}
	}

	@Test
	public void testTextNameFormat() {
		String text = "市辖区</span></p>";
		String pattern_format = "([\u4e00-\u9fa5]+)<\\/span>";
		Pattern pattern = Pattern.compile(pattern_format);
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			String name = matcher.group(1);
			System.out.println(name);
		}
	}
}
