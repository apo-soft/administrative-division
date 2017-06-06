package cn.aposoft.administrativedivision.spider.impl;

import java.util.List;

import cn.aposoft.administrativedivision.spider.AdministrativeDivisionBusinessException;

/**
 * 列表页面解析接口
 * 
 * @author LiuJian
 *
 */
public interface AdministrativeDivisionListPageParser {
	/**
	 * 需要完成对列表页面的解析
	 * 
	 * @param html
	 *            列表页HTML报文
	 * @param baseUrl
	 *            列表页Url
	 * @return 列表页中的统计内容项列表
	 * @throws AdministrativeDivisionBusinessException
	 */
	public List<AdministrativeDivisionListItem> parse(final String html, final String baseUrl)
			throws AdministrativeDivisionBusinessException;
}