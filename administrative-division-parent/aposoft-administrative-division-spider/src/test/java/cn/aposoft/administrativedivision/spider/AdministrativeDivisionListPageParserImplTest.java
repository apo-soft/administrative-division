/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author LiuJian
 *
 */
public class AdministrativeDivisionListPageParserImplTest {

	@Test
	public void testParseListPageHtml() throws IOException, AdministrativeDivisionBusinessException {
		try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("list-page.html");) {
			String html = IOUtils.toString(input, StandardCharsets.UTF_8);
			AdministrativeDivisionListPageParser parser = new AdministrativeDivisionListPageParserImpl();
			List<AdministrativeDivisionListItem> result = parser.parse(html, UrlConstant.LIST_PAGE_URL);
			System.out.println(JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd",
					new SerializerFeature[] { SerializerFeature.PrettyFormat }));
		}
	}
}
