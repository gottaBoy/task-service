package net.ibizsys.paas.core;

/**
 * 值转换器接口
 * 
 * @author Administrator
 *
 */
public interface IValueTranslator {

	/**
	 * 值转换
	 * 
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	Object convert(String strValue) throws Exception;
}
