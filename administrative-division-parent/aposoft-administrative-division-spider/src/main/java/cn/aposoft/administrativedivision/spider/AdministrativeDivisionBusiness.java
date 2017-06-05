/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.io.Closeable;
import java.util.List;

/**
 * 用于发现最新报表内容
 * <p>
 * 读取列表页是否有最新列表,如果有,读取最新列表,否则结束
 * 
 * @author LiuJian
 *
 */
public interface AdministrativeDivisionBusiness extends Closeable {

	String getDefaultListPageUrl();

	/**
	 * 判定是否存在新的统计文件
	 * 
	 * @param listPageUrl
	 *            统计发布列表页地址
	 * @return 当有最新版本时,返回最新版本URL,否则返列表项
	 * @throws AdministrativeDivisionBusinessException
	 */
	List<AdministrativeDivisionListItem> getContentUrl(String listPageUrl)
			throws AdministrativeDivisionBusinessException;

	/**
	 * 读取最新行政区划内容
	 * 
	 * @param url
	 *            最新行政区划内容地址
	 * @return 行政区划详情解析结果
	 */
	AdministrativeDivisionContent getContent(String url) throws AdministrativeDivisionBusinessException;

	/**
	 * 根据列表页地址最新版本的行政区划统计表
	 * 
	 * @param listPageUrl
	 *            列表页最新地址
	 * @return 最新版本的行政区划统计表
	 * @throws AdministrativeDivisionBusinessException
	 */
	AdministrativeDivisionContent getLatestContent(String listPageUrl) throws AdministrativeDivisionBusinessException;

	@Override
	public void close();
}
