/**
 * 
 */
package cn.aposoft.administrativedivision.spider.impl;

import cn.aposoft.administrativedivision.spider.AdministrativeDivisionBusinessException;
import cn.aposoft.administrativedivision.spider.AdministrativeDivisionContent;

/**
 * 内容页面解析
 * 
 * @author LiuJian
 *
 */
public interface AdministrativeDivisionItemParser {

	AdministrativeDivisionContent parse(String itemContentHtml, String itemContentUrl)
			throws AdministrativeDivisionBusinessException;

}
