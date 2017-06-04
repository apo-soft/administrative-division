/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author LiuJian
 *
 */
public class AdministrativeDivisionItemParserImpl implements AdministrativeDivisionItemParser {

	@Override
	public AdministrativeDivisionContent parse(String itemContentHtml, String itemContentUrl) {
		Document document = Jsoup.parse(itemContentHtml, itemContentUrl);
		return null;
	}

}
