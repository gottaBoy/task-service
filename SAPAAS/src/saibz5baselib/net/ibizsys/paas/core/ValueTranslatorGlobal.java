package net.ibizsys.paas.core;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.valuetranslator.DateValueTranslator;
import net.ibizsys.paas.util.StringHelper;

/**
 * 值转换器全局对象
 * 
 * @author lionlau
 *
 */
public class ValueTranslatorGlobal {
	private static final Log log = LogFactory.getLog(ValueTranslatorGlobal.class);
	private static HashMap<String, IValueTranslator> valueTranslatorMap = new HashMap<String, IValueTranslator>();

	static {
		String[] list = new String[] { DateValueTranslator.DATETIME, DateValueTranslator.DATE, DateValueTranslator.TIME, DateValueTranslator.DATETIME_NOMINUTE, DateValueTranslator.DATETIME_NOSECOND, DateValueTranslator.TIME_NOSECOND };
		for (String strType : list) {
			DateValueTranslator dateValueTranslator = new DateValueTranslator();
			dateValueTranslator.setParam(strType);
			registerValueTranslator(strType, dateValueTranslator);
		}
	}

	/**
	 * 注册值转换器
	 * 
	 * @param strValueTranslator
	 * @param iValueTranslator
	 */
	public static void registerValueTranslator(String strValueTranslator, IValueTranslator iValueTranslator) {
		valueTranslatorMap.put(strValueTranslator, iValueTranslator);
	}

	/**
	 * 获取指定值转换器对象
	 * 
	 * @param strValueTranslator
	 * @return
	 * @throws Exception
	 */
	public static IValueTranslator getValueTranslator(String strValueTranslator) throws Exception {
		IValueTranslator iValueTranslator = valueTranslatorMap.get(strValueTranslator);
		if (iValueTranslator == null) throw new Exception(StringHelper.format("无法获取指定值转换器[%1$s]", strValueTranslator));
		return iValueTranslator;
	}

}
