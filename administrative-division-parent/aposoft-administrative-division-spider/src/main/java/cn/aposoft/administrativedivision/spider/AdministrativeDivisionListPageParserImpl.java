/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @see AdministrativeDivisionListPageParser
 * @author LiuJian
 *
 */
public class AdministrativeDivisionListPageParserImpl implements AdministrativeDivisionListPageParser {
	static final Logger logger = LoggerFactory.getLogger(AdministrativeDivisionListPageParserImpl.class);

	public List<AdministrativeDivisionListItem> parse(final String html, final String baseUrl)
			throws AdministrativeDivisionBusinessException {
		Document document = Jsoup.parse(html, baseUrl);

		Elements elements = document.select("ul[class=center_list_contlist]");

		if (elements == null || elements.isEmpty()) {
			throw new AdministrativeDivisionBusinessException("Parse Error : can not find page item from list page.");
		}
		// ul[class=center_list_contlist]
		List<AdministrativeDivisionListItem> result = parse(elements.get(0));

		return result;
	}

	/**
	 * <pre>
	 * {@code <div class="center_list">
				<h1 class="center_list_tit"><img src=
	"../../../images/b01.gif" />行政区划代码</h1>
				<ul class="center_list_contlist" style="min-height:350px;">
	
				  
					<li>
						<a href="./201703/t20170310_1471429.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2016年7月31日）</font><font class=
	"cont_tit02">2017-03-10</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./201608/t20160809_1386477.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2015年9月30日）</font><font class=
	"cont_tit02">2016-08-09</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./201504/t20150415_712722.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2014年10月31日）</font><font class=
	"cont_tit02">2015-04-15</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./201401/t20140116_501070.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2013年8月31日）</font><font class=
	"cont_tit02">2014-01-17</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./201301/t20130118_38316.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2012年10月31日）</font><font class=
	"cont_tit02">2013-01-18</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./201201/t20120105_38315.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2011年10月31日）</font><font class=
	"cont_tit02">2012-01-05</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./201107/t20110726_38314.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2010年10月31日）</font><font class=
	"cont_tit02">2011-07-26</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./201006/t20100623_38313.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2009年12月31日）</font><font class=
	"cont_tit02">2010-06-23</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200906/t20090626_38312.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2008年12月31日）</font><font class=
	"cont_tit02">2009-06-26</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200802/t20080215_38311.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2007年12月31日）</font><font class=
	"cont_tit02">2008-02-15</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200704/t20070411_38310.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2006年12月31日）</font><font class=
	"cont_tit02">2007-04-11</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200410/t20041022_38307.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2005年12月31日）</font><font class=
	"cont_tit02">2006-01-13</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200410/t20041022_38306.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2005年6月30日）</font><font class=
	"cont_tit02">2005-08-01</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200410/t20041022_38305.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2004年12月31日）</font><font class=
	"cont_tit02">2005-06-30</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200410/t20041022_38304.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2004年9月30日）</font><font class=
	"cont_tit02">2004-10-22</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200406/t20040607_38302.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2004年3月31日）</font><font class=
	"cont_tit02">2004-06-07</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200402/t20040211_38301.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2003年12月31日）</font><font class=
	"cont_tit02">2004-02-11</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200307/t20030722_38300.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2003年6月30日）</font><font class=
	"cont_tit02">2003-07-22</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					<li>
						<a href="./200302/t20030219_38299.html" target=
	"_blank" ><span class="cont_tit"><img src="../../../images/01.jpg" style=
	"float:left;margin-right:3px;margin-top:3px;" /><font class=
	"cont_tit03">最新县及县以上行政区划代码（截止2002年12月31日）</font><font class=
	"cont_tit02">2003-02-19</font></span></a>
					</li>
					<li class="cont_line">&nbsp;</li>
	
					
					
					<li>
						<dl class="fenye">
						<!-- <dl class="xxgkml_fenye"> -->
		 共1页&nbsp;&nbsp;<span id='pagenav_0' style=
	"color:#FF0000;padding-left:7px;padding-right:7px;">1</span> 	
	
						</dl>
					</li>
				</ul>
				
			</div>
			}
	 * </pre>
	 * 
	 * @param parentEl
	 *            UL 列表元素根
	 * @return {@code  List<AdministrativeDivisionListItem> }
	 * @throws AdministrativeDivisionBusinessException
	 */
	private List<AdministrativeDivisionListItem> parse(Element parentEl)
			throws AdministrativeDivisionBusinessException {
		if (parentEl == null || parentEl.childNodeSize() == 0) {
			throw new AdministrativeDivisionBusinessException("Parse Error : no item is found from list page.");
		}
		List<AdministrativeDivisionListItem> items = new ArrayList<>(parentEl.childNodeSize());
		for (Node node : parentEl.childNodes()) {
			AdministrativeDivisionListItem item = parseItem(node);
			if (item != null) {
				items.add(item);
			}
		}
		return items;
	}

	private AdministrativeDivisionListItem parseItem(Node node) {
		if (node == null || node.childNodeSize() == 0) {
			return null;
		} else {
			AdministrativeDivisionListItem item = null;
			for (Node n : node.childNodes()) {
				if ("a".equals(n.nodeName())) {
					item = new AdministrativeDivisionListItem();
					String itemUrl = n.absUrl("href");
					item.setContentUrl(itemUrl);
					try {
						parseItemContent(item, n);
					} catch (ParseException e) {
						logger.error("parse list page item error." + e.getMessage(), e);
					}
				}
			}
			return item;
		}

	}

	/**
	 * 从archorNode 中读取对应内容到ListItem对象中
	 * 
	 * @param item
	 *            待赋值对象
	 * @param aNode
	 *            archorNode
	 * @throws ParseException
	 */
	private void parseItemContent(AdministrativeDivisionListItem item, Node aNode) throws ParseException {
		for (Node span : aNode.childNodes()) {
			if ("span".equals(span.nodeName())) {
				// find font
				for (Node font : span.childNodes()) {
					if ("font".equals(font.nodeName().trim())) {
						StringBuilder builder = new StringBuilder();
						builder = font.html(builder);
						String text = builder.toString().trim();
						if (Pattern.matches(DateUtil.DATE_PATTERN, text)) {
							item.setPublishTime(DateUtil.parsePublishDate(text));
						} else {
							Matcher matcher = DateUtil.CHINESE_DATE_PATTERN.matcher(text);

							if (matcher.find()) {
								String finalDateStr = matcher.group(0);
								Date finalDate = DateUtil.parseChineseDate(finalDateStr);
								item.setFinalDate(finalDate);
							}
							item.setTitle(text);
						}
					}
				}
			}
		}
	}

}
