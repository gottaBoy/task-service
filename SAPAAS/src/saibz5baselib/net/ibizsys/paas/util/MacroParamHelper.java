package net.ibizsys.paas.util;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;

/**
 * 宏参数辅助对象
 * 
 * @author Administrator
 *
 */
public class MacroParamHelper {
	private static final Log log = LogFactory.getLog(MacroParamHelper.class);

	public final static String TAG_SRFTAGHEADER = "%%SRF";
	public final static String TAG_SRFTAGEND = ")%%";

	/**
	 * 获取当前日期时间 %%SRFDATE()%%
	 */
	public final static String TAG_SRFDATE = "SRFDATE";

	/**
	 * 获取当前日期时间 %%SRFDATETIME()%%
	 */
	public final static String TAG_SRFDATETIME = "SRFDATETIME";

	/**
	 * 获取当前时间 %%SRFTIME()%%
	 */
	public final static String TAG_SRFTIME = "SRFTIME";

	/**
	 * 获取当前用户 %%SRFOPPERSON()%%
	 */
	public final static String TAG_SRFOPPERSON = "SRFOPPERSON";

	/**
	 * 来自数据对象的参数 %%SRFDEF(PARAM)%%
	 */
	public final static String TAG_SRFDEF = "SRFDEF";

	/**
	 * 来自APPLICATION的参数 %%SRFGV(PARAM)%%
	 */
	public final static String TAG_SRFGV = "SRFGV";

	/**
	 * 来自SESSION的参数 %%SRFSV(PARAM)%%
	 */
	public final static String TAG_SRFSV = "SRFSV";

	/**
	 * 来自URL的参数 %%SRFUV(PARAM)%%
	 */
	public final static String TAG_SRFUV = "SRFUV";

	/**
	 * 来自URL 或 数据对象 的参数 %%SRFUD(PARAM)%%
	 */
	public final static String TAG_SRFUD = "SRFUD";

	/**
	 * 来自URL的参数 %%SRFUVEX(PARAM)%%
	 */
	public final static String TAG_SRFUVEX = "SRFUVEX";

	/**
	 * 来自URL的参数 %%SRFUVINT(PARAM)%%
	 */
	public final static String TAG_SRFUVINT = "SRFUVINT";

	/**
	 * 来自URL的参数 %%SRFUVDATE(PARAM,[ENDOFDAY])%% 如果指定了 ENDOFDAY 参数，则可以将输入的时间转换为最后天的最后一秒
	 */
	public final static String TAG_SRFUVDATE = "SRFUVDATE";

	/**
	 * 来自URL的参数 %%SRFUVDOUBLE(PARAM)%%
	 */
	public final static String TAG_SRFUVDOUBLE = "SRFUVDOUBLE";

	/**
	 * 来自URL的参数 %%SRFUVFLOAT(PARAM)%%
	 */
	public final static String TAG_SRFUVFLOAT = "SRFUVFLOAT";

	/**
	 * 转换参数值%%SRFV(PARAM,DATATYPE)%%
	 */
	public final static String TAG_SRFV = "SRFV";

	/**
	 * 删除指定属性 %%SRFREMOVE()%%
	 */
	public final static String TAG_SRFREMOVE = "%%SRFREMOVE%%";

	/**
	 * 删除指定属性 %%SRFREMOVE()%%
	 */
	public final static String TAG_SRFREMOVE2 = "%%SRFREMOVE()%%";

	/**
	 * 获取指定注册表值 %%SRFREG(路径,缺省值)%%
	 */
	public final static String TAG_SRFREG = "SRFREG";

	/**
	 * 获取时间维度
	 */
	public final static String TAG_SRFTD = "SRFTD";

	/**
	 * 扩展时间函数,参数为 参数1 Y 年 m 月 d 日 H小时 M 分 S 秒 #表示为常量 +1表示增加一个单位 -1表示减少一个单位 没有表示编号
	 * 
	 * 参数2为偏移单位 S-1
	 * 
	 */
	public final static String TAG_SRFDATETIMEEX = "SRFDATETIMEEX";

	public static Object getValue(String strFunc, IWebContext webContext) throws Exception {
		return getValue(strFunc, webContext, webContext.getGlobalContext(), webContext.getCurUserId(), null);
	}

	public static Object getValue(String strFunc, IWebContext webContext, IDataObject dataEntity) throws Exception {
		return getValue(strFunc, webContext, webContext.getGlobalContext(), webContext.getCurUserId(), dataEntity);
	}

	public static Object getValue(String strFunc, IGlobalContext iGlobalContext, String strCurPersonId, IDataObject dataEntity) throws Exception {
		return getValue(strFunc, null, iGlobalContext, strCurPersonId, dataEntity);
	}

	public static Object getValue(String strFunc, IWebContext webContext, IGlobalContext iGlobalContext, IDataObject dataEntity) throws Exception {
		return getValue(strFunc, webContext, iGlobalContext, webContext.getCurUserId(), dataEntity);
	}

	public static Object getValue(String strFunc, IWebContext webContext, IGlobalContext iGlobalContext, String strCurPersonId, IDataObject dataEntity) throws Exception {
		// 判断是否为框架宏
		if (!isSRFFunc(strFunc)) return strFunc;

		Vector<String> argList = new Vector<String>();
		String strFuncName = ParseSRFFunc(strFunc, argList);
		if (StringHelper.isNullOrEmpty(strFuncName)) return "";

		// 判断函数类型
		if (StringHelper.compare(strFuncName, TAG_SRFDATE, true) == 0) {
			String strFormat = "%1$tY-%1$tm-%1$td";
			if (argList.size() > 0) strFormat = argList.get(0);
			return StringHelper.format(strFormat, new java.util.Date());
		}

		if (StringHelper.compare(strFuncName, TAG_SRFDATETIME, true) == 0) {
			String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
			if (argList.size() > 0) strFormat = argList.get(0);
			java.util.Date date = new java.util.Date();

			return StringHelper.format(strFormat, date);
		}

		if (StringHelper.compare(strFuncName, TAG_SRFTIME, true) == 0) {
			String strFormat = "%1$tH:%1$tM:%1$tS";
			if (argList.size() > 0) strFormat = argList.get(0);
			return StringHelper.format(strFormat, new java.util.Date());
		}

		if (StringHelper.compare(strFuncName, TAG_SRFOPPERSON, true) == 0) {
			if (!StringHelper.isNullOrEmpty(strCurPersonId))
				return strCurPersonId;
			else {
				if (webContext != null) return webContext.getCurUserId();
			}
			return strCurPersonId;
		}

		if (StringHelper.compare(strFuncName, TAG_SRFGV, true) == 0) {
			if (webContext == null && iGlobalContext == null) {
				throw new Exception("上下文对象及全局对象无效");
			}
			String strFieldName = "";
			if (argList.size() > 0) strFieldName = argList.get(0);

			if (StringHelper.isNullOrEmpty(strFieldName)) {
				throw new Exception("没有指定属性");
			}

			if (webContext != null)
				return webContext.getGlobalValue(strFieldName);
			else
				return iGlobalContext.getValue(strFieldName);
		}

		if (StringHelper.compare(strFuncName, TAG_SRFSV, true) == 0) {
			if (webContext == null) {
				throw new Exception("上下文对象无效");
			}
			String strFieldName = "";
			if (argList.size() > 0) strFieldName = argList.get(0);

			if (StringHelper.isNullOrEmpty(strFieldName)) {
				throw new Exception("没有指定属性");
			}

			return webContext.getSessionValue(strFieldName);
		}

		if (StringHelper.compare(strFuncName, TAG_SRFUV, true) == 0) {
			if (webContext == null) {
				throw new Exception("上下文对象无效");
			}
			String strFieldName = "";
			if (argList.size() > 0) strFieldName = argList.get(0);

			if (StringHelper.isNullOrEmpty(strFieldName)) {
				throw new Exception("没有指定属性");
			}

			String strValue = webContext.getParamValue(strFieldName);
			if (StringHelper.isNullOrEmpty(strValue)) {
				strValue = webContext.getPostValue(strFieldName.toLowerCase());
			}

			return strValue;
		}

		// if(StringHelper.compare(strFuncName, TAG_SRFREG, true) == 0)
		// {
		// if(iGlobalContext == null)
		// {
		// throw new Exception("上下文对象无效");
		// return Return(Errors.INPUTERROR,"错误:上下文对象无效");
		// }
		// String strRegPath = "";
		// if(argList.size()>0)
		// strRegPath = argList.get(0);
		//
		// String strDefault = "";
		// if(argList.size()>=2)
		// {
		// strDefault=argList.get(1);
		// }
		//
		//
		// if(StringHelper.isNullOrEmpty(strRegPath))
		// {
		// throw new Exception("没有指定注册表路径");
		// return Return(Errors.INPUTERROR,"错误:没有指定注册表路径");
		// }
		//
		// return Return(iGlobalContext.getRegisterMgr().GetRegistryParam(strRegPath, strDefault));
		// }

		if ((StringHelper.compare(strFuncName, TAG_SRFUVINT, true) == 0) || (StringHelper.compare(strFuncName, TAG_SRFUVDATE, true) == 0) || (StringHelper.compare(strFuncName, TAG_SRFUVDOUBLE, true) == 0) || (StringHelper.compare(strFuncName, TAG_SRFUVFLOAT, true) == 0)) {
			if (webContext == null) {
				throw new Exception("上下文对象无效");
			}
			String strFieldName = "";
			if (argList.size() > 0) strFieldName = argList.get(0);

			if (StringHelper.isNullOrEmpty(strFieldName)) {
				throw new Exception("没有指定属性");
			}

			String strValue = "";

			strValue = webContext.getParamValue(strFieldName);
			if (StringHelper.isNullOrEmpty(strValue)) strValue = webContext.getPostValue(strFieldName.toLowerCase());

			if (StringHelper.isNullOrEmpty(strValue)) {
				return null;
			}
			if (StringHelper.compare(strFuncName, TAG_SRFUVINT, true) == 0) return DataTypeHelper.testInteger(strValue);
			if (StringHelper.compare(strFuncName, TAG_SRFUVDATE, true) == 0) {
				Object objValue = DataTypeHelper.testDateTime(strValue);

				if (objValue != null && objValue instanceof java.sql.Timestamp) {
					if (argList.size() >= 2 && StringHelper.compare(argList.get(1), "ENDOFDAY", true) == 0) {
						java.sql.Timestamp endTime = (java.sql.Timestamp) objValue;
						Calendar cal = Calendar.getInstance();
						cal.setTime(new java.util.Date(endTime.getTime()));

						cal.set(Calendar.HOUR_OF_DAY, 23);
						cal.set(Calendar.MINUTE, 59);
						cal.set(Calendar.SECOND, 59);

						endTime.setTime(cal.getTime().getTime());
						return endTime;
					}
				}
				return objValue;
			}

			if (StringHelper.compare(strFuncName, TAG_SRFUVDOUBLE, true) == 0) return DataTypeHelper.testDouble(strValue);
			if (StringHelper.compare(strFuncName, TAG_SRFUVFLOAT, true) == 0) return DataTypeHelper.testFloat(strValue);
			return null;
		}

		if (StringHelper.compare(strFuncName, TAG_SRFDEF, true) == 0) {
			if (dataEntity == null) {
				throw new Exception("数据对象无效");
			}
			String strFieldName = "";
			int nDataType = DataTypes.UNKNOWN;

			if (argList.size() > 0) strFieldName = argList.get(0);
			if (argList.size() >= 2) {
				nDataType = DataTypeHelper.fromString(argList.get(1));
			}

			if (StringHelper.isNullOrEmpty(strFieldName)) {
				throw new Exception("没有指定属性");
			}

			Object objValue = dataEntity.get(strFieldName);
			if (objValue == null) {
				if (argList.size() >= 3 && nDataType != DataTypes.UNKNOWN) {
					return DataTypeHelper.parse(nDataType, argList.get(2));
				}
				return null;
			}
			if (nDataType == DataTypes.UNKNOWN) return objValue;

			switch (nDataType) {
			case DataTypes.DATETIME: {
				if (objValue instanceof String) {
					return DataTypeHelper.testDateTime((String) objValue);
				}
				return new java.sql.Timestamp(DataTypeHelper.getDateObjectTime(objValue));
			}
			case DataTypes.DATE: {
				if (objValue instanceof String) {
					return DataTypeHelper.testDate((String) objValue);
				}
				return new java.sql.Date(DataTypeHelper.getDateObjectTime(objValue));
			}
			default:
				return objValue;
			}

		}

		if (StringHelper.compare(strFuncName, TAG_SRFUD, true) == 0) {
			if (webContext != null) {
				String strFieldName = "";
				if (argList.size() > 0) strFieldName = argList.get(0);

				if (StringHelper.isNullOrEmpty(strFieldName)) {
					throw new Exception("没有指定属性");
				}

				String strValue = webContext.getParamValue(strFieldName);
				if (StringHelper.isNullOrEmpty(strValue)) {
					strValue = webContext.getPostValue(strFieldName.toLowerCase());
				}

				if (!StringHelper.isNullOrEmpty(strValue)) return strValue;

			}

			if (dataEntity != null) {
				String strFieldName = "";
				int nDataType = DataTypes.UNKNOWN;

				if (argList.size() > 0) strFieldName = argList.get(0);
				if (argList.size() >= 2) {
					nDataType = DataTypeHelper.fromString(argList.get(1));
				}

				if (StringHelper.isNullOrEmpty(strFieldName)) {
					throw new Exception("没有指定属性");
				}

				Object objValue = dataEntity.get(strFieldName);
				if (objValue == null) {
					if (argList.size() >= 3 && nDataType != DataTypes.UNKNOWN) {
						return DataTypeHelper.parse(nDataType, argList.get(2));
					}
					return null;
				}
				if (nDataType == DataTypes.UNKNOWN) return objValue;

				switch (nDataType) {
				case DataTypes.DATETIME: {
					if (objValue instanceof String) {
						return DataTypeHelper.testDateTime((String) objValue);
					}
					return new java.sql.Timestamp(DataTypeHelper.getDateObjectTime(objValue));
				}
				case DataTypes.DATE: {
					if (objValue instanceof String) {
						return DataTypeHelper.testDate((String) objValue);
					}
					return new java.sql.Date(DataTypeHelper.getDateObjectTime(objValue));
				}
				default:
					return objValue;
				}
			}
			throw new Exception("网页上下文对象及数据对象无效");
		}

		if (StringHelper.compare(strFuncName, TAG_SRFV, true) == 0) {
			if (argList.size() == 0) {
				throw new Exception("参数值无效");
			}

			String strValue = argList.get(0);
			String strDataType = "VARCHAR";
			if (argList.size() >= 2) {
				strDataType = argList.get(1);
			}

			return DataTypeHelper.parse(strDataType, strValue);
		}

		// if(StringHelper.compare(strFuncName, TAG_SRFTD, true) == 0)
		// {
		// String strDTType = "";
		// int nAddTime = 0;
		// if(argList.size()>0)
		// strDTType = argList.get(0);
		//
		// if(argList.size()>1)
		// nAddTime = Integer.parseInt(argList.get(1));
		//
		// Calendar cal = Calendar.getInstance();
		// if(StringHelper.compare(TimeDimension.TDTYPE_YM, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.MONTH, nAddTime);
		// }
		//
		// return Return(StringHelper.format("M%1$tY%1$tm",cal.getTime()));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMD, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.MONDAY, nAddTime);
		// }
		//
		// return Return(StringHelper.format("D%1$tY%1$tm%1$td",cal.getTime()));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMDH, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.HOUR_OF_DAY, nAddTime);
		// }
		// return Return(StringHelper.format("H%1$tY%1$tm%1$td%1$tH",cal.getTime()));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMW, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.WEEK_OF_MONTH, nAddTime);
		// }
		//
		// return Return(StringHelper.format("W%1$tY%1$tm%2$s",cal.getTime(),cal.get(Calendar.WEEK_OF_MONTH)));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMWD, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, nAddTime);
		// }
		//
		// return Return(StringHelper.format("O%1$tY%1$tm%2$s%3$s",cal.getTime(),cal.get(Calendar.WEEK_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMWDH, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.HOUR_OF_DAY, nAddTime);
		// }
		//
		// return Return(StringHelper.format("P%1$tY%1$tm%2$s%3$s%1$tH",cal.getTime(),cal.get(Calendar.WEEK_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YW, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.WEEK_OF_YEAR, nAddTime);
		// }
		//
		// return Return(StringHelper.format("Z%1$tY%2$02d",cal.getTime(),cal.get(Calendar.WEEK_OF_YEAR)));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YWD, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.DAY_OF_WEEK, nAddTime);
		// }
		//
		// return Return(StringHelper.format("R%1$tY%2$02d%3$s",cal.getTime(),cal.get(Calendar.WEEK_OF_YEAR),cal.get(Calendar.DAY_OF_WEEK)));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YWDH, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.HOUR_OF_DAY, nAddTime);
		// }
		//
		// return Return(StringHelper.format("S%1$tY%2$02d%3$s%1$tH",cal.getTime(),cal.get(Calendar.WEEK_OF_YEAR),cal.get(Calendar.DAY_OF_WEEK)));
		// }
		// log.error(StringHelper.format("错误:无法识别的时间维度类型[%1$s]",strDTType));
		// return Return(Errors.INPUTERROR,StringHelper.format("错误:无法识别的类型[%1$s]",strDTType));
		//
		// }

		if (StringHelper.compare(strFuncName, TAG_SRFDATETIMEEX, true) == 0) {
			String strTimeFormat = "";
			if (argList.size() > 0) strTimeFormat = argList.get(0);

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
					CalcDateTimeEx(cal, strCurType, strCurValue);
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
			CalcDateTimeEx(cal, strCurType, strCurValue);

			if (argList.size() > 1) {
				String strTimeFormat2 = argList.get(1);
				if (!StringHelper.isNullOrEmpty(strTimeFormat2)) {
					strCurType = strTimeFormat2.substring(0, 1);
					strCurValue = strTimeFormat2.substring(1);
					CalcDateTimeEx(cal, strCurType, strCurValue);
				}
			}

			String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
			return StringHelper.format(strFormat, cal.getTime());
		}

		return strFunc;
	}

	//
	// private static Object Return(Object objValue)
	// {
	// return objValue;
	// }
	//
	//
	//
	//
	//
	//
	//
	// private static CallResult Return(int nError,String strError)
	// {
	// CallResult callResult = new CallResult();
	// callResult.setRetCode(nError);
	// callResult.setErrorInfo(strError);
	// return callResult;
	// }

	public static boolean isSRFFunc(String strFunc) {
		return strFunc.indexOf(TAG_SRFTAGHEADER, 0) == 0;
	}

	public static String ParseSRFFunc(String strFunc, Vector<String> argList) {
		int nPos = strFunc.indexOf(TAG_SRFTAGHEADER, 0);
		if (nPos != 0) return strFunc;

		nPos = strFunc.indexOf("(");
		if (nPos == -1) {
			return "";
		}

		String strFuncName = strFunc.substring(2, nPos);

		String strParams = strFunc.substring(nPos + 1, strFunc.length() - 3);
		strParams = strParams.trim();
		if (StringHelper.isNullOrEmpty(strParams)) return strFuncName;
		String params[] = strParams.split("[,]");
		for (int i = 0; i < params.length; i++) {
			argList.add(params[i].trim());
		}
		return strFuncName;
	}

	/**
	 * 是否为删除操作
	 * 
	 * @param strFunc
	 * @return
	 */
	public static boolean isRemoveFunc(String strFunc) {
		return (StringHelper.compare(strFunc, TAG_SRFREMOVE, true) == 0) || (StringHelper.compare(strFunc, TAG_SRFREMOVE2, true) == 0);

	}

	// /**
	// * 填充宏变量 ${def("实体属性")}
	// * @param params
	// * @param webContext
	// * @param iGlobalContext
	// * @param strCurPersonId
	// * @param dataEntity
	// */
	// public static void fillMacroParams(Map<String,Object> params,IWebContext webContext,IGlobalContext iGlobalContext,String strCurPersonId,IDataEntity iDataEntity, IDataObject dataEntity,String strLanguage)
	// {
	// if(dataEntity!=null)
	// {
	// DEFMacroParam macroParam= new DEFMacroParam();
	// macroParam.setDataEntity(dataEntity);
	// macroParam.setDEHelper(iDataEntity);
	// macroParam.setLanguage(strLanguage);
	// params.put("def", macroParam);
	// DEFMacroParamRemoveHtml macroParam2= new DEFMacroParamRemoveHtml();
	// macroParam2.setDataEntity(dataEntity);
	// params.put("defnohtm", macroParam2);
	// }
	//
	// params.put("macro", new SYSMacroParam(webContext,iGlobalContext,strCurPersonId,dataEntity));
	// }
	//
	// public static void fillDEMacroParams(Map<String,Object> params,String strMacroName,IDataEntity iDataEntity, IDataObject dataEntity,String strLanguage)
	// {
	// if(dataEntity!=null)
	// {
	// DEFMacroParam macroParam= new DEFMacroParam();
	// macroParam.setDataEntity(dataEntity);
	// macroParam.setDEHelper(iDataEntity);
	// macroParam.setLanguage(strLanguage);
	// params.put(strMacroName, macroParam);
	// DEFMacroParamRemoveHtml macroParam2= new DEFMacroParamRemoveHtml();
	// macroParam2.setDataEntity(dataEntity);
	// params.put(strMacroName+"nohtm", macroParam2);
	// }
	// }

	/**
	 * 
	 * @param strFunc
	 * @param webContext
	 * @param iGlobalContext
	 * @param strCurPersonId
	 * @param dataEntity
	 * @param bBackend
	 * @return
	 */
	public static Object getFormItemRuleArg(String strFunc, boolean bBackend) throws Exception {
		Vector<String> argList = new Vector<String>();
		String strFuncName = ParseSRFFunc(strFunc, argList);
		if (StringHelper.isNullOrEmpty(strFuncName)) {
			return null;
		}

		// //判断函数类型
		// if(StringHelper.compare(strFuncName, TAG_SRFDATE, true) == 0)
		// {
		// String strFormat = "%1$tY-%1$tm-%1$td";
		// if(argList.size()>0)
		// strFormat = argList.get(0);
		// return Return(StringHelper.format(strFormat, new java.util.Date()));
		// }
		//
		//
		// if(StringHelper.compare(strFuncName, TAG_SRFDATETIME, true) == 0)
		// {
		// String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
		// if(argList.size()>0)
		// strFormat = argList.get(0);
		// java.util.Date date = new java.util.Date();
		//
		// return Return(StringHelper.format(strFormat,date));
		// }
		//
		// if(StringHelper.compare(strFuncName, TAG_SRFTIME, true) == 0)
		// {
		// String strFormat = "%1$tH:%1$tM:%1$tS";
		// if(argList.size()>0)
		// strFormat = argList.get(0);
		// return Return(StringHelper.format(strFormat, new java.util.Date()));
		// }

		if (StringHelper.compare(strFuncName, TAG_SRFOPPERSON, true) == 0) {
			return StringHelper.format("dp.CurOPPerson()");
		}

		// if(StringHelper.compare(strFuncName, TAG_SRFGV, true) == 0)
		// {
		// if(webContext == null && iGlobalContext == null )
		// {
		// throw new Exception("上下文对象及全局对象无效");
		// return Return(Errors.INPUTERROR,"错误:上下文对象及全局对象无效");
		// }
		// String strFieldName = "";
		// if(argList.size()>0)
		// strFieldName = argList.get(0);
		//
		//
		// if(StringHelper.isNullOrEmpty(strFieldName))
		// {
		// throw new Exception("没有指定属性");
		// return Return(Errors.INPUTERROR,"错误:没有指定属性");
		// }
		//
		// if(webContext!=null)
		// return webContext.getGlobalValue(strFieldName);
		// else
		// return iGlobalContext.getValue(strFieldName);
		// }

		if (StringHelper.compare(strFuncName, TAG_SRFSV, true) == 0) {
			String strFieldName = "";
			if (argList.size() > 0) strFieldName = argList.get(0);

			if (StringHelper.isNullOrEmpty(strFieldName)) {
				throw new Exception("没有指定属性");
			}

			return StringHelper.format("dp.SV('%1$s')", strFieldName);

		}

		if (StringHelper.compare(strFuncName, TAG_SRFDEF, true) == 0) {
			String strFieldName = "";

			if (argList.size() > 0) strFieldName = argList.get(0);

			if (StringHelper.isNullOrEmpty(strFieldName)) {
				throw new Exception("没有指定属性");
			}

			return StringHelper.format("dp.Val('%1$s')", strFieldName);

		}

		// if(StringHelper.compare(strFuncName, TAG_SRFTD, true) == 0)
		// {
		// String strDTType = "";
		// int nAddTime = 0;
		// if(argList.size()>0)
		// strDTType = argList.get(0);
		//
		// if(argList.size()>1)
		// nAddTime = Integer.parseInt(argList.get(1));
		//
		// Calendar cal = Calendar.getInstance();
		// if(StringHelper.compare(TimeDimension.TDTYPE_YM, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.MONTH, nAddTime);
		// }
		//
		// return Return(StringHelper.format("M%1$tY%1$tm",cal.getTime()));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMD, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.MONDAY, nAddTime);
		// }
		//
		// return Return(StringHelper.format("D%1$tY%1$tm%1$td",cal.getTime()));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMDH, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.HOUR_OF_DAY, nAddTime);
		// }
		// return Return(StringHelper.format("H%1$tY%1$tm%1$td%1$tH",cal.getTime()));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMW, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.WEEK_OF_MONTH, nAddTime);
		// }
		//
		// return Return(StringHelper.format("W%1$tY%1$tm%2$s",cal.getTime(),cal.get(Calendar.WEEK_OF_MONTH)));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMWD, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, nAddTime);
		// }
		//
		// return Return(StringHelper.format("O%1$tY%1$tm%2$s%3$s",cal.getTime(),cal.get(Calendar.WEEK_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YMWDH, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.HOUR_OF_DAY, nAddTime);
		// }
		//
		// return Return(StringHelper.format("P%1$tY%1$tm%2$s%3$s%1$tH",cal.getTime(),cal.get(Calendar.WEEK_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)));
		// }
		//
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YW, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.WEEK_OF_YEAR, nAddTime);
		// }
		//
		// return Return(StringHelper.format("Z%1$tY%2$02d",cal.getTime(),cal.get(Calendar.WEEK_OF_YEAR)));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YWD, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.DAY_OF_WEEK, nAddTime);
		// }
		//
		// return Return(StringHelper.format("R%1$tY%2$02d%3$s",cal.getTime(),cal.get(Calendar.WEEK_OF_YEAR),cal.get(Calendar.DAY_OF_WEEK)));
		// }
		//
		// if(StringHelper.compare(TimeDimension.TDTYPE_YWDH, strDTType, true) == 0)
		// {
		// if(nAddTime!=0)
		// {
		// cal.add(Calendar.HOUR_OF_DAY, nAddTime);
		// }
		//
		// return Return(StringHelper.format("S%1$tY%2$02d%3$s%1$tH",cal.getTime(),cal.get(Calendar.WEEK_OF_YEAR),cal.get(Calendar.DAY_OF_WEEK)));
		// }
		// log.error(StringHelper.format("错误:无法识别的时间维度类型[%1$s]",strDTType));
		// return Return(Errors.INPUTERROR,StringHelper.format("错误:无法识别的类型[%1$s]",strDTType));
		//
		// }

		if (StringHelper.compare(strFuncName, TAG_SRFDATETIMEEX, true) == 0) {
			String strTimeFormat = "";
			if (argList.size() > 0) strTimeFormat = argList.get(0);

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
					CalcDateTimeEx(cal, strCurType, strCurValue);
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
			CalcDateTimeEx(cal, strCurType, strCurValue);

			if (argList.size() > 1) {
				String strTimeFormat2 = argList.get(1);
				if (!StringHelper.isNullOrEmpty(strTimeFormat2)) {
					strCurType = strTimeFormat2.substring(0, 1);
					strCurValue = strTimeFormat2.substring(1);
					CalcDateTimeEx(cal, strCurType, strCurValue);
				}
			}

			String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
			return StringHelper.format(strFormat, cal.getTime());
		}

		return null;
	}

	private static void CalcDateTimeEx(Calendar cal, String strCurType, String strCurValue) {
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

	/**
	 * 使用 Properties 填充实体数据对象
	 * 
	 * @param iDataEntity
	 * @param properties
	 * @param dataEntity
	 * @param webContext
	 * @param iGlobalContext
	 * @param strCurPersonId
	 * @param srcDataEntity
	 * @return
	 */
	public static void fillDataObject(IDataEntity iDataEntity, Properties properties, IDataObject dataEntity, IWebContext webContext, IGlobalContext iGlobalContext, String strCurPersonId, IDataObject srcDataEntity) throws Exception {
		// 实际值代码
		CallResult callResult = new CallResult();
		if (properties == null) {
			return;
		}

		Enumeration en = properties.keys();

		while (en.hasMoreElements()) {
			String strKey = (String) en.nextElement();

			String strValue = PropertiesHelper.getProperty(properties, strKey);
			if ((StringHelper.compare("%%SRFREMOVE()%%", strValue, true) == 0) || (StringHelper.compare(MacroParamHelper.TAG_SRFREMOVE, strValue, true) == 0)) {
				dataEntity.remove(strKey);
				continue;
			}

			Object obj = MacroParamHelper.getValue(strValue, webContext, iGlobalContext, strCurPersonId, srcDataEntity);
			if (obj == null) {
				dataEntity.set(strKey, obj);
			} else if (obj instanceof String) {
				strValue = obj.toString();
				if (StringHelper.isNullOrEmpty(strValue)) {
					dataEntity.set(strKey, null);
				} else {
					IDEField iDEField = null;
					if (iDataEntity != null) iDEField = iDataEntity.getDEField(strKey, true);
					if (iDEField != null) {
						obj = DataTypeHelper.parse(iDEField.getStdDataType(), strValue);
					}
					dataEntity.set(strKey, obj);
				}
			} else {
				dataEntity.set(strKey, obj);
			}
		}

	}
}
