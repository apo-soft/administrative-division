/**
 * 
 */
package cn.aposoft.administrativedivision.spider.impl;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.aposoft.administrativedivision.spider.AdministrativeDivisionBusinessException;
import cn.aposoft.administrativedivision.spider.AdministrativeDivisionContent;
import cn.aposoft.administrativedivision.spider.impl.AdministrativeDivisionItemParser;
import cn.aposoft.administrativedivision.spider.impl.AdministrativeDivisionItemParserImpl;

/**
 * @author LiuJian
 *
 */
public class AdministrativeDivisionItemParserImplTest {
	@Test
	public void testParseItemContentPageHtml() throws IOException, AdministrativeDivisionBusinessException {
		try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("item-content.html");) {
			String html = IOUtils.toString(input, StandardCharsets.UTF_8);
			AdministrativeDivisionItemParser parser = new AdministrativeDivisionItemParserImpl();
			AdministrativeDivisionContent result = parser.parse(html, UrlConstant.ITEM_CONTENT_URL);
			assertNotNull(result);
			System.out.println(JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss",
					new SerializerFeature[] { SerializerFeature.PrettyFormat }));
		}
	}
}
