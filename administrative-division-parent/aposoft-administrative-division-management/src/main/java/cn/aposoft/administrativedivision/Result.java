/**
 * 
 */
package cn.aposoft.administrativedivision;

/**
 * 通用返回结果对象
 * 
 * @author LiuJian
 *
 */
public interface Result {
	/**
	 * 默认成功时返回此值
	 */
	int SUCCESS = 0;
	/**
	 * 服务发生非预期错误时,返回此值
	 */
	int UNKNOW_ERROR = -1;
	/**
	 * 未授权错误
	 */
	int UNAUTHORIZED = 401;

	/**
	 * 
	 * @return 结果编码
	 */
	int getCode();

	/**
	 * 
	 * @return 结果说明
	 */
	String getMessage();
}
