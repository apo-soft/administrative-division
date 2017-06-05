/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiuJian
 *
 */
public class AdministrativeDivisionItemParserImpl implements AdministrativeDivisionItemParser {
	static final Logger logger = LoggerFactory.getLogger(AdministrativeDivisionItemParserImpl.class);

	@Override
	public AdministrativeDivisionContent parse(String itemContentHtml, String itemContentUrl)
			throws AdministrativeDivisionBusinessException {
		AdministrativeDivisionContent content = new AdministrativeDivisionContent();
		content.setUrl(itemContentUrl);
		Document document = Jsoup.parse(itemContentHtml, itemContentUrl);

		// parse Title and final Date
		String title = parseTitle(document);
		content.setTitle(title);
		if (StringUtils.isNotBlank(title)) {
			Date finalDate = parseFinalDate(content.getTitle());
			content.setFinalDate(finalDate);
		}

		// parse source and publish date
		content.setSource(parseSource(document));
		// parse publish date
		try {
			Date publishTime = parsePublishDate(document);
			content.setPublishTime(publishTime);
		} catch (ParseException e) {
			logger.error("Can not read publish time:" + e.getMessage(), e);
		}

		List<AdministrativeDivision> divisions = parseDivisionList(document);
		content.setDivisions(divisions);
		return content;

	}

	private Date parsePublishDate(Document document) throws ParseException {
		Elements el = document.select("font[class=xilan_titf]");
		if (el != null && el.hasText()) {
			// 遍历 text
			Matcher matcher = DateUtil.PUBLISH_TIME_PATTERN.matcher(el.text());
			if (matcher.find()) {
				String dateStr = matcher.group(1) + " " + matcher.group(2);
				try {
					return DateUtil.parsePublishTime(dateStr);
				} catch (ParseException e) {
					logger.error("Parse date error,text:" + dateStr, e);
					throw e;
				}
			}
		}
		return null;
	}

	// 读取数据发布来源
	private String parseSource(Document document) {
		Elements el = document.select("font[class=xilan_titf]");
		// 遍历 text
		if (el != null && !el.isEmpty()) {
			for (Node node : el.get(0).childNodes()) {
				if ("font".equals(node.nodeName())) {
					for (Node innerNode : node.childNodes()) {
						if ("font".equals(innerNode.nodeName())) {
							StringBuilder builder = innerNode.html(new StringBuilder());
							return builder.toString().trim();
						}
					}

				}
			}
		}
		return null;
	}

	private Date parseFinalDate(String title) throws AdministrativeDivisionBusinessException {
		Matcher matcher = DateUtil.CHINESE_DATE_PATTERN.matcher(title);
		if (matcher.find()) {
			String dateStr = matcher.group(0);
			try {
				return (DateUtil.parseChineseDate(dateStr));
			} catch (ParseException e) {
				throw new AdministrativeDivisionBusinessException(e);
			}
		}
		return null;
	}

	private String parseTitle(Document document) {
		Elements titleEl = document.select("h2[class=xilan_tit]");
		if (titleEl != null && !titleEl.isEmpty()) {
			return titleEl.get(0).text();
		} else {
			return null;
		}
	}

	/**
	 * 地区编码/名称列表解析方法
	 * 
	 * @param document
	 *            待解析html文档
	 * @return 解析后的地区编码和名称列表
	 */
	private List<AdministrativeDivision> parseDivisionList(Document document) {
		Elements el = document.select("div[class=TRS_PreAppend]");

		if (el == null || el.isEmpty()) {
			return null;
		} else {
			List<AdministrativeDivision> divisionList = new ArrayList<>(el.get(0).children().size());
			for (Element itemEl : el.get(0).children()) {
				String content = itemEl.html();
				String code = DivisionUtil.getCode(content);
				String name = DivisionUtil.getName(content);
				if (StringUtils.isBlank(code) && StringUtils.isBlank(name)) {
					logger.error("there is empty code or name:{},{}", code, name);
				} else {
					AdministrativeDivision pair = new AdministrativeDivision();
					pair.setCode(code);
					pair.setName(name);
					divisionList.add(pair);
				}
			}
			if (divisionList.size() != el.get(0).children().size()) {
				logger.error("miss some divisions,diff-size:{},total:{}", divisionList.size(),
						el.get(0).children().size());
			}
			return divisionList;
		}
	}

}
