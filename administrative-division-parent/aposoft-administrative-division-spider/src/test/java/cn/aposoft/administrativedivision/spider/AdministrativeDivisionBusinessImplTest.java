/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 行政区划业务实现类
 * 
 * @author LiuJian
 *
 */
public class AdministrativeDivisionBusinessImplTest {

	/**
	 * <pre>
	 * [
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201703/t20170310_1471429.html",
		"publishTime":"2017-03-10",
		"title":"最新县及县以上行政区划代码（截止2016年7月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201608/t20160809_1386477.html",
		"publishTime":"2016-08-09",
		"title":"最新县及县以上行政区划代码（截止2015年9月30日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201504/t20150415_712722.html",
		"finalDate":"2014-10-31",
		"publishTime":"2015-04-15",
		"title":"最新县及县以上行政区划代码（截止2014年10月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201401/t20140116_501070.html",
		"publishTime":"2014-01-17",
		"title":"最新县及县以上行政区划代码（截止2013年8月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201301/t20130118_38316.html",
		"finalDate":"2012-10-31",
		"publishTime":"2013-01-18",
		"title":"最新县及县以上行政区划代码（截止2012年10月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201201/t20120105_38315.html",
		"finalDate":"2011-10-31",
		"publishTime":"2012-01-05",
		"title":"最新县及县以上行政区划代码（截止2011年10月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201107/t20110726_38314.html",
		"finalDate":"2010-10-31",
		"publishTime":"2011-07-26",
		"title":"最新县及县以上行政区划代码（截止2010年10月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201006/t20100623_38313.html",
		"finalDate":"2009-12-31",
		"publishTime":"2010-06-23",
		"title":"最新县及县以上行政区划代码（截止2009年12月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200906/t20090626_38312.html",
		"finalDate":"2008-12-31",
		"publishTime":"2009-06-26",
		"title":"最新县及县以上行政区划代码（截止2008年12月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200802/t20080215_38311.html",
		"finalDate":"2007-12-31",
		"publishTime":"2008-02-15",
		"title":"最新县及县以上行政区划代码（截止2007年12月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200704/t20070411_38310.html",
		"finalDate":"2006-12-31",
		"publishTime":"2007-04-11",
		"title":"最新县及县以上行政区划代码（截止2006年12月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200410/t20041022_38307.html",
		"finalDate":"2005-12-31",
		"publishTime":"2006-01-13",
		"title":"最新县及县以上行政区划代码（截止2005年12月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200410/t20041022_38306.html",
		"publishTime":"2005-08-01",
		"title":"最新县及县以上行政区划代码（截止2005年6月30日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200410/t20041022_38305.html",
		"finalDate":"2004-12-31",
		"publishTime":"2005-06-30",
		"title":"最新县及县以上行政区划代码（截止2004年12月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200410/t20041022_38304.html",
		"publishTime":"2004-10-22",
		"title":"最新县及县以上行政区划代码（截止2004年9月30日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200406/t20040607_38302.html",
		"publishTime":"2004-06-07",
		"title":"最新县及县以上行政区划代码（截止2004年3月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200402/t20040211_38301.html",
		"finalDate":"2003-12-31",
		"publishTime":"2004-02-11",
		"title":"最新县及县以上行政区划代码（截止2003年12月31日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200307/t20030722_38300.html",
		"publishTime":"2003-07-22",
		"title":"最新县及县以上行政区划代码（截止2003年6月30日）"
	},
	{
		"contentUrl":"http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/200302/t20030219_38299.html",
		"finalDate":"2002-12-31",
		"publishTime":"2003-02-19",
		"title":"最新县及县以上行政区划代码（截止2002年12月31日）"
	}
	]
	 * </pre>
	 * 
	 * @throws AdministrativeDivisionBusinessException
	 */
	@Test
	public void testGetListPage() throws AdministrativeDivisionBusinessException {
		try (AdministrativeDivisionBusiness service = new AdministrativeDivisionBusinessImpl()) {
			List<AdministrativeDivisionListItem> items = service.getContentUrl(UrlConstant.LIST_PAGE_URL);
			System.out.println(JSON.toJSONStringWithDateFormat(items, "yyyy-MM-dd",
					new SerializerFeature[] { SerializerFeature.PrettyFormat }));
		}
	}

	@Test
	public void testGetItemContent() throws AdministrativeDivisionBusinessException {
		try (AdministrativeDivisionBusiness service = new AdministrativeDivisionBusinessImpl()) {
			AdministrativeDivisionContent item = service.getContent(UrlConstant.ITEM_CONTENT_URL);
			validateItem(item);
		}
	}

	@Test
	public void testGetLatestItemContent() throws AdministrativeDivisionBusinessException {
		try (AdministrativeDivisionBusiness service = new AdministrativeDivisionBusinessImpl()) {
			AdministrativeDivisionContent item = service.getLatestContent(service.getDefaultListPageUrl());
			validateItem(item);
		}
	}

	/**
	 * 验证记录项
	 * 
	 * @param item
	 *            记录项
	 */
	private void validateItem(AdministrativeDivisionContent item) {
		assertNotNull(item);
		assertNotNull(item.getTitle());
		assertNotNull(item.getSource());
		assertNotNull(item.getFinalDate());
		assertNotNull(item.getPublishTime());
		assertNotNull(item.getUrl());
		// System.out.println(JSON.toJSONStringWithDateFormat(item, "yyyy-MM-dd
		// HH:mm:ss",
		// new SerializerFeature[] { SerializerFeature.PrettyFormat }));
		validateKeyValue(item.getDivisions());
	}

	private void validateKeyValue(List<AdministrativeDivision> divisions) {
		assertNotNull(divisions);
		assertEquals(3508, divisions.size());
		for (AdministrativeDivision division : divisions) {
			assertNotNull(division);
			assertTrue(StringUtils.isNotBlank(division.getCode()));
			assertTrue(StringUtils.isNotBlank(division.getName()));
		}
	}

}
