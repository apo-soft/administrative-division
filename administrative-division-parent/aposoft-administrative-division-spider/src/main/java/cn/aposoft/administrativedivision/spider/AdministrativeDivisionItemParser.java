/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

/**
 * 内容页面解析
 * 
 * @author LiuJian
 *
 */
public interface AdministrativeDivisionItemParser {

	AdministrativeDivisionContent parse(String itemContentHtml, String itemContentUrl);

}
