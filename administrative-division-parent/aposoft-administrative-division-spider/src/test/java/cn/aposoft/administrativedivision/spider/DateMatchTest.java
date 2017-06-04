/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.util.regex.Pattern;

/**
 * @author LiuJian
 *
 */
public class DateMatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "2002年12月31日";
		if (Pattern.matches("\\d{4}[\u4e00-\u9fa5]{1}\\d{2}[\u4e00-\u9fa5]{1}\\d{2}[\u4e00-\u9fa5]{1}", date))
			System.out.println("match");
		;
	}

}
