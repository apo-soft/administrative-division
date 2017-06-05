/**
 * 
 */
package cn.aposoft.administrativedivision.spider;

import java.io.Serializable;

/**
 * 统计局原始报文解析出的KeyValue组合
 * 
 * @author LiuJian
 *
 */
public class AdministrativeDivision implements Serializable {
	private static final long serialVersionUID = 6594989035808579782L;
	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
