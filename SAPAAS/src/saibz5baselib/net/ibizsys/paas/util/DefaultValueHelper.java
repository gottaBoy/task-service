package net.ibizsys.paas.util;

import java.util.Calendar;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 默认值辅助对象
 * 
 * @author lionlau
 *
 */
public class DefaultValueHelper {

	/**
	 * 缺省值来自Session
	 */
	public final static String DVT_SESSION = "SESSION";

	/**
	 * 缺省值来自Application
	 */
	public final static String DVT_APPLICATION = "APPLICATION";

	/**
	 * 缺省值来自GUID
	 */
	public final static String DVT_UNIQUEID = "UNIQUEID";

	/**
	 * 缺省值来自上下文对象
	 */
	public final static String DVT_CONTEXT = "CONTEXT";

	/**
	 * 默认值，当前操作者
	 */
	public final static String DVT_OPERATOR = "OPERATOR";

	/**
	 * 默认值，当前操作者名称
	 */
	public final static String DVT_OPERATORNAME = "OPERATORNAME";

	/**
	 * 当前时间
	 */
	public final static String DVT_CURTIME = "CURTIME";

	/**
	 * 缺省值其它属性
	 */
	public final static String DVT_COPY = "COPY";

	/**
	 * 缺省值来自于参数
	 */
	public final static String DVT_PARAM = "PARAM";

	/**
	 * 当前应用数据
	 */
	public final static String DVT_APPDATA = "APPDATA";

	/**
	 * 参数类型（当前时间）
	 */
	public final static String PARAMTYPE_CURTIME = "CURTIME";

	/**
	 * 参数类型（实体属性）
	 */
	public final static String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";

	/**
	 * 获取对象的默认值
	 * 
	 * @param webContext
	 * @param strDVT
	 * @param strDV
	 * @param strDataType
	 * @return
	 */
	public static String getValue(IWebContext webContext, String strDVT, String strDV) throws Exception {
		// 无任何定义
		if (StringHelper.length(strDVT) == 0 && StringHelper.length(strDV) == 0) return "";

		if (StringHelper.compare(strDVT, DVT_UNIQUEID, true) == 0) {
			return KeyValueHelper.genGuidEx();
		}

		if (StringHelper.compare(strDVT, DVT_APPLICATION, true) == 0) {
			Object objValue = webContext.getGlobalValue(strDV);
			if (objValue != null) return objValue.toString();
			return "";
		}

		if (StringHelper.compare(strDVT, DVT_SESSION, true) == 0) {
			Object objValue = webContext.getSessionValue(strDV);
			if (objValue != null) return objValue.toString();
			return "";
		}

		if (StringHelper.compare(strDVT, DVT_CONTEXT, true) == 0) {
			String strValue = webContext.getPostValue(strDV);
			if (StringHelper.isNullOrEmpty(strValue)) strValue = webContext.getParamValue(strDV);
			return strValue;
		}

		if (StringHelper.compare(strDVT, DVT_OPERATOR, true) == 0) {
			return webContext.getCurUserId();
		}

		if (StringHelper.compare(strDVT, DVT_OPERATORNAME, true) == 0) {
			return webContext.getCurUserName();
		}

		if (StringHelper.compare(strDVT, DVT_CURTIME, true) == 0) {
			if (StringHelper.isNullOrEmpty(strDV))
				return DateHelper.toDateTimeString(new java.util.Date());
			else {
				return DateHelper.toDateTimeString(calcCurTime(strDV));
			}
		}

		return strDV;
	}

	/**
	 * 获取默认值
	 * 
	 * @param webContext
	 * @param strDVT
	 * @param strDV
	 * @param nDataType
	 * @param dataEntity
	 * @return
	 * @throws Exception
	 */
	public static Object getValue(IWebContext webContext, String strDVT, String strDV, int nDataType, IDataObject dataEntity) throws Exception {
		// 无任何定义
		if (StringHelper.length(strDVT) == 0 && StringHelper.length(strDV) == 0) return null;

		if (StringHelper.compare(strDVT, DVT_UNIQUEID, true) == 0) {
			return KeyValueHelper.genGuidEx();
		}
		if (StringHelper.compare(strDVT, DVT_APPLICATION, true) == 0) {
			Object objValue = webContext.getGlobalValue(strDV);
			return objValue;
		}

		if (StringHelper.compare(strDVT, DVT_SESSION, true) == 0) {
			Object objValue = webContext.getSessionValue(strDV);
			return objValue;
		}

		if (StringHelper.compare(strDVT, DVT_CONTEXT, true) == 0) {
			String strValue = webContext.getPostValue(strDV);
			if (StringHelper.isNullOrEmpty(strValue)) strValue = webContext.getParamValue(strDV);
			return DataTypeHelper.parse(nDataType, strValue);
		}

		if (StringHelper.compare(strDVT, DVT_APPDATA, true) == 0) {
			JSONObject jo = WebContext.getAppData();
			if (jo != null) {
				return jo.opt(strDV);
			}
			return null;
		}

		if (StringHelper.compare(strDVT, DVT_OPERATOR, true) == 0) {
			return DataTypeHelper.parse(nDataType, webContext.getCurUserId());
		}

		if (StringHelper.compare(strDVT, DVT_OPERATORNAME, true) == 0) {
			return DataTypeHelper.parse(nDataType, webContext.getCurUserName());
		}

		if (StringHelper.compare(strDVT, DVT_CURTIME, true) == 0) {
			if (StringHelper.isNullOrEmpty(strDV))
				return DataTypeHelper.parse(DataTypes.DATETIME, DateHelper.toDateTimeString(new java.util.Date()));
			else
				return DataTypeHelper.parse(DataTypes.DATETIME, DateHelper.toDateTimeString(calcCurTime(strDV)));
		}

		if (dataEntity != null && ((StringHelper.compare(strDVT, DVT_PARAM, true) == 0) || StringHelper.compare(strDVT, PARAMTYPE_ENTITYFIELD, true) == 0)) {
			return dataEntity.get(strDV);
		}

		return DataTypeHelper.parse(nDataType, strDV);
	}

	/**
	 * 获取默认值
	 * 
	 * @param webContext
	 * @param strDVT
	 * @param strDV
	 * @param nDataType
	 * @return
	 * @throws Exception
	 */
	public static Object getValue(IWebContext webContext, String strDVT, String strDV, int nDataType) throws Exception {
		return getValue(webContext, strDVT, strDV, nDataType, null);
	}

	/**
	 * 获取默认值
	 * 
	 * @param webContext
	 * @param strDVT
	 * @param strDV
	 * @param strDataType
	 * @return
	 * @throws Exception
	 */
	public static Object getValue(IWebContext webContext, String strDVT, String strDV, String strDataType) throws Exception {
		return getValue(webContext, strDVT, strDV, DataTypeHelper.fromString(strDataType));

	}

	/**
	 * 计算时间，基于当前时间偏移
	 * 
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date calcCurTime(String strValue) throws Exception {
		String[] parts = strValue.split("[,]");
		String strTimeFormat = "";
		if (parts.length > 0) strTimeFormat = parts[0];

		Calendar cal = Calendar.getInstance();
		// 进行分析
		String strCurType = "";
		String strCurValue = "";
		for (int i = 0; i < strTimeFormat.length(); i++) {
			char ch = strTimeFormat.charAt(i);
			switch (ch) {
			case 'Y':
			case 'm':
			case 'd':
			case 'H':
			case 'M':
			case 'S': {
				// 计算上次内容
				calcDateTimeEx(cal, strCurType, strCurValue);
				strCurValue = "";
				strCurType = "";
				strCurType += ch;
			}
				break;
			default:
				strCurValue += ch;
				break;
			}
		}
		calcDateTimeEx(cal, strCurType, strCurValue);

		if (parts.length > 1) {
			String strTimeFormat2 = parts[1];
			if (!StringHelper.isNullOrEmpty(strTimeFormat2)) {
				strCurType = strTimeFormat2.substring(0, 1);
				strCurValue = strTimeFormat2.substring(1);
				calcDateTimeEx(cal, strCurType, strCurValue);
			}
		}

		return cal.getTime();
	}

	/**
	 * 计算时间，基于当前时间偏移
	 * 
	 * @param cal
	 * @param strCurType
	 * @param strCurValue
	 */
	public static void calcDateTimeEx(Calendar cal, String strCurType, String strCurValue) {
		if (StringHelper.isNullOrEmpty(strCurValue) || StringHelper.isNullOrEmpty(strCurType)) return;

		int nDateType = 0;
		switch (strCurType.charAt(0)) {
		case 'Y':
			nDateType = Calendar.YEAR;
			break;
		case 'm':
			nDateType = Calendar.MONTH;
			break;
		case 'd':
			nDateType = Calendar.DAY_OF_MONTH;
			break;
		case 'H':
			nDateType = Calendar.HOUR_OF_DAY;
			break;
		case 'M':
			nDateType = Calendar.MINUTE;
			break;
		case 'S':
			nDateType = Calendar.SECOND;
			break;
		default:
			return;
		}

		if (strCurValue.charAt(0) == '#') {
			strCurValue = strCurValue.substring(1);
			if (StringHelper.isNullOrEmpty(strCurValue)) {
				return;
			}

			Integer nValue = Integer.parseInt(strCurValue);
			cal.set(nDateType, nValue);
		} else {
			if (strCurValue.charAt(0) == '+') {
				strCurValue = strCurValue.substring(1);
				if (StringHelper.isNullOrEmpty(strCurValue)) {
					return;
				}
			}
			Integer nValue = Integer.parseInt(strCurValue);
			cal.add(nDateType, nValue);
		}
	}
}
