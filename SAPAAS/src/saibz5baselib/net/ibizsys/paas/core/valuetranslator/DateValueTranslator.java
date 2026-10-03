package net.ibizsys.paas.core.valuetranslator;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

/**
 * 时间日期处理器
 * 
 * @author Administrator
 *
 */
public class DateValueTranslator extends ValueTranslatorBase {
	/**
	 * 日期时间格式 YYYY-MM-DD HH:mm:ss
	 */
	public final static String DATETIME = "DATE|YYYY-MM-DD HH:mm:ss";
	/**
	 * 日期格式 YYYY-MM-DD
	 */
	public final static String DATE = "DATE|YYYY-MM-DD";
	/**
	 * 时间格式 HH:mm:ss
	 */
	public final static String TIME = "DATE|HH:mm:ss";
	/**
	 * 日期时间格式 精确到小时 YYYY-MM-DD HH
	 */
	public final static String DATETIME_NOMINUTE = "DATE|YYYY-MM-DD HH";
	/**
	 * 日期时间格式 精确到分钟 YYYY-MM-DD HH:mm
	 */
	public final static String DATETIME_NOSECOND = "DATE|YYYY-MM-DD HH:mm";
	/**
	 * 时间格式 精确到小时分钟 HH:mm
	 */
	public final static String TIME_NOSECOND = "DATE|HH:mm";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IValueTranslator#convert(java.lang.String)
	 */
	@Override
	public Object convert(String strValue) throws Exception {
		if (StringHelper.isNullOrEmpty(strValue)) return null;

		String strDataTimeString = strValue;
		if (StringHelper.compare(DATE, this.getParam(), true) == 0) {
			strDataTimeString = StringHelper.format("%1$s 00:00:00", strValue);
		} else if (StringHelper.compare(TIME, this.getParam(), true) == 0) {
			strDataTimeString = StringHelper.format("1970-01-01 %1$s", strValue);
		} else if (StringHelper.compare(DATETIME_NOMINUTE, this.getParam(), true) == 0) {
			strDataTimeString = StringHelper.format("%1$s:00:00", strValue);
		} else if (StringHelper.compare(DATETIME_NOSECOND, this.getParam(), true) == 0) {
			strDataTimeString = StringHelper.format("%1$s:00", strValue);
		} else if (StringHelper.compare(TIME_NOSECOND, this.getParam(), true) == 0) {
			strDataTimeString = StringHelper.format("1970-01-01 %1$s:00", strValue);
		}

		return DataTypeHelper.parse(DataTypes.DATETIME, strDataTimeString);
	}

}
