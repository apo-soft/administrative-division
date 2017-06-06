/**
 * 
 */
package cn.aposoft.administrativedivision.spider.impl;

import java.io.Closeable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.administrativedivision.spider.AdministrativeDivisionBusiness;
import cn.aposoft.administrativedivision.spider.AdministrativeDivisionBusinessException;
import cn.aposoft.administrativedivision.spider.AdministrativeDivisionContent;

/**
 * 行政区划业务逻辑实现
 * 
 * @author LiuJian
 *
 */
public class AdministrativeDivisionBusinessImpl implements AdministrativeDivisionBusiness, Closeable {
	static final Logger logger = LoggerFactory.getLogger(AdministrativeDivisionBusinessImpl.class);
	final static String DEFAULT_LIST_PAGE_URL = "http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/";

	final HtmlPageClient client = new HtmlPageClient();
	private AdministrativeDivisionItemParser itemContentParser = new AdministrativeDivisionItemParserImpl();

	private AdministrativeDivisionListPageParser listPageParser = new AdministrativeDivisionListPageParserImpl();

	@Override
	public void close() {
		client.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.administrativedivision.spider.AdministrativeDivisionBusiness#
	 * getContentUrl(java.lang.String)
	 */
	@Override
	public List<AdministrativeDivisionListItem> getContentUrl(String listPageUrl)
			throws AdministrativeDivisionBusinessException {
		try {
			String listPageHtml = client.getPageContent(listPageUrl);
			return listPageParser.parse(listPageHtml, listPageUrl);
		} catch (RemoteException e) {
			throw new AdministrativeDivisionBusinessException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.administrativedivision.spider.AdministrativeDivisionBusiness#
	 * getContent(java.lang.String)
	 */
	@Override
	public AdministrativeDivisionContent getContent(String itemContentUrl)
			throws AdministrativeDivisionBusinessException {
		try {
			String itemContentHtml = client.getPageContent(itemContentUrl);
			return itemContentParser.parse(itemContentHtml, itemContentUrl);
		} catch (RemoteException e) {
			throw new AdministrativeDivisionBusinessException(e);
		}

	}

	/**
	 * 根据列表页地址,抓取最新的行政区划报表
	 * 
	 * @param listPageUrl
	 *            列表页地址
	 */
	@Override
	public AdministrativeDivisionContent getLatestContent(String listPageUrl)
			throws AdministrativeDivisionBusinessException {
		List<AdministrativeDivisionListItem> items = getContentUrl(listPageUrl);
		if (items != null && !items.isEmpty() && !StringUtils.isEmpty(items.get(0).getContentUrl())) {
			return getContent(items.get(0).getContentUrl());
		}
		throw new AdministrativeDivisionBusinessException("can not fetch the list,because of some unknown error.");
	}

	@Override
	public String getDefaultListPageUrl() {
		return DEFAULT_LIST_PAGE_URL;
	}
}
