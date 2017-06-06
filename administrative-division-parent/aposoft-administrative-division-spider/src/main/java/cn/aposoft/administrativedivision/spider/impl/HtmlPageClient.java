/**
 * 
 */
package cn.aposoft.administrativedivision.spider.impl;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiuJian
 *
 */
public class HtmlPageClient implements Closeable {
	static final Logger logger = LoggerFactory.getLogger(HtmlPageClient.class);
	final CloseableHttpClient httpClient = HttpClients.createMinimal();

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 读取统计局HTML报文内容
	 * 
	 * @param url
	 *            统计局相关地址url
	 * @return 读取远程报文
	 * @throws RemoteException
	 */
	public String getPageContent(final String url) throws RemoteException {
		if (StringUtils.isBlank(url))
			throw new IllegalArgumentException("url must not be blank.");
		try (CloseableHttpResponse resp = httpClient.execute(new HttpGet(url));) {
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(resp.getEntity(), StandardCharsets.UTF_8);

			} else {
				String message = "";
				if (resp.getEntity() != null) {
					message = EntityUtils.toString(resp.getEntity(), StandardCharsets.UTF_8);
				}
				throw new RemoteException("access remote url error" + resp.getStatusLine() + "\r\n" + message);
			}
		} catch (ClientProtocolException e) {
			throw new RemoteException(e);
		} catch (IOException e) {
			throw new RemoteException(e);
		}

	}

}
