/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.io.Closeable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 行政区划业务逻辑实现
 * 
 * @author LiuJian
 *
 */
public class AdministrativeDivisionBusinessImpl implements AdministrativeDivisionBusiness, Closeable {
	static final Logger logger = LoggerFactory.getLogger(AdministrativeDivisionBusinessImpl.class);
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
			// logger.info(listPageHtml);
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
			System.out.println(itemContentHtml);
			return itemContentParser.parse(itemContentHtml, itemContentUrl);
		} catch (RemoteException e) {
			throw new AdministrativeDivisionBusinessException(e);
		}

	}

}
