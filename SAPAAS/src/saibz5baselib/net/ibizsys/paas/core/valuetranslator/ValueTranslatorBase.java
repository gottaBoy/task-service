package net.ibizsys.paas.core.valuetranslator;

import net.ibizsys.paas.core.IValueTranslator;

/**
 * 值转换器对象
 * 
 * @author Administrator
 *
 */
public abstract class ValueTranslatorBase implements IValueTranslator {
	private String strParam = "";

	/**
	 * 设置参数
	 * 
	 * @param strParam
	 */
	public void setParam(String strParam) {
		this.strParam = strParam;
	}

	/**
	 * 获取参数
	 * 
	 * @return
	 */
	public String getParam() {
		return this.strParam;
	}
}
