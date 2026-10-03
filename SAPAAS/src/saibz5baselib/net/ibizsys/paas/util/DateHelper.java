package net.ibizsys.paas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期数据辅助类
 * 
 * @author Administrator
 * 
 */

public final class DateHelper {
	/**
	 * 每天的毫秒数
	 */
	public final static long MILLISECONDS_OF_DAY = 86400000;

	public DateHelper() {
	}

	/**
	 * 转换字符串到时间对象
	 * 
	 * @param strTimeString
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static Date parse(String strTimeString) throws ParseException, Exception {
		return parse(strTimeString, null);
	}

	/**
	 * 分析时间串
	 * 
	 * @param strTimeString MM/dd/yy yy-MM-dd HH:mm:ss 格式
	 * @param timeZone
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static Date parse(String strTimeString, TimeZone timeZone) throws ParseException, Exception {
		strTimeString = strTimeString.trim();
		if(StringHelper.isNullOrEmpty(strTimeString)){
			throw new Exception("unknown date(time) string");
		}
		if(strTimeString.indexOf("Z")!=-1){
			//有时区
			String[] parts = strTimeString.split("[Z]");
			if(parts.length>=1){
				strTimeString = parts[0];
			}
			if(parts.length>=2){
				if(timeZone == null){
					if(!StringHelper.isNullOrEmpty(parts[1])){
						timeZone = TimeZone.getTimeZone(parts[1]);
					}
				}
			}
		}
		
		// 判断是长数据还是短数据
		String strPart[] = null;
		if(strTimeString.indexOf("T")!=-1){
			strPart = strTimeString.split("[T]");
		}
		else
			strPart = strTimeString.split(" ");
		if (strPart.length == 2) {
			// 两个部分
			String strDate = "";
			String strTime = "";
			if (strPart[0].indexOf(":") != -1) {
				strTime = strPart[0];
				strDate = strPart[1];
			} else {
				strTime = strPart[1];
				strDate = strPart[0];
			}
			strDate = strDate.trim();
			strTime = strTime.trim();
			strDate = getFormatDateString(strDate);
			strTime = getFormatTimeString(strTime);
			DateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (timeZone != null) {
				dtFormat.setTimeZone(timeZone);
			}
			return dtFormat.parse(strDate + " " + strTime);
		} else {
			// 一个部分
			if (strTimeString.indexOf(":") != -1) {
				// 时间
				strTimeString = getFormatTimeString(strTimeString);
				DateFormat dtFormat = new SimpleDateFormat("HH:mm:ss");
				if (timeZone != null) {
					dtFormat.setTimeZone(timeZone);
				}
				return dtFormat.parse(strTimeString);
			} else {
				// 作为日期处理
				strTimeString = getFormatDateString(strTimeString);
				DateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (timeZone != null) {
					dtFormat.setTimeZone(timeZone);
				}
				return dtFormat.parse(strTimeString);
			}
		}

	}

	/**
	 * 获取时间格式化串
	 * 
	 * @param strOrigin
	 * @return
	 */
	private static String getFormatTimeString(String strOrigin) {
		int nDotPos = strOrigin.indexOf(".");
		if (nDotPos != -1) {
			strOrigin = strOrigin.substring(0, nDotPos);
		}

		Object Time[] = new Object[3];
		Time[0] = 0;
		Time[1] = 0;
		Time[2] = 0;

		String timepart[] = strOrigin.split(":");
		int nTimePartLength = timepart.length;
		if (nTimePartLength > 3) {
			nTimePartLength = 3;
		}

		for (int i = 0; i < nTimePartLength; i++) {
			Time[i] = Integer.parseInt(timepart[i]);
		}

		return StringHelper.format("%1$02d:%2$02d:%3$02d", Time);

	}

	/**
	 * 获取时日期格式化串
	 * 
	 * @param strOrigin
	 * @return
	 * @throws Exception
	 */
	private static String getFormatDateString(String strOrigin) throws Exception {
		return getFormatDateString(strOrigin, true);
	}

	/**
	 * 获取时日期格式化串
	 * 
	 * @param strOrigin
	 * @param bAdv
	 * @return
	 * @throws Exception
	 */
	private static String getFormatDateString(String strOrigin, boolean bAdv) throws Exception {
		Object Date[] = new Object[3];
		Date[0] = 1970;
		Date[1] = 1;
		Date[2] = 1;

		if (strOrigin.indexOf("-") != -1) {
			String datePart[] = strOrigin.split("-");
			if (datePart.length >= 1) {
				Date[0] = Integer.parseInt(datePart[0]);
			}

			if (datePart.length >= 2) {
				Date[1] = Integer.parseInt(datePart[1]);
			}

			if (datePart.length >= 3) {
				Date[2] = Integer.parseInt(datePart[2]);
			}
		}

		else if (strOrigin.indexOf("/") != -1) {
			String datePart[] = strOrigin.split("/");
			if (datePart.length >= 1) {
				Date[1] = Integer.parseInt(datePart[0]);
			}

			if (datePart.length >= 2) {
				Date[2] = Integer.parseInt(datePart[1]);
			}

			if (datePart.length >= 3) {
				Date[0] = Integer.parseInt(datePart[2]);
			}
		} else {
			if (bAdv) {
				strOrigin = strOrigin.replace(".", "-");
				strOrigin = strOrigin.replace("日", "");
				strOrigin = strOrigin.replace("天", "");
				strOrigin = strOrigin.replace("年", "-");
				strOrigin = strOrigin.replace("月", "-");
				return getFormatDateString(strOrigin, false);
			} else

				throw new Exception(StringHelper.format("无法识别的时间字符串,%1$s", strOrigin));
		}

		return StringHelper.format("%1$04d-%2$02d-%3$02d", Date);
	}

	/**
	 * 输出时间字符串 %1$tH:%1$tM:%1$tS
	 * 
	 * @param dt
	 * @return
	 */
	public static String toTimeString(Date dt) {
		if (dt == null) return "00:00:00";
		return String.format("%1$tH:%1$tM:%1$tS", dt);
	}

	/**
	 * 输出日期字符串 %1$tY-%1$tm-%1$td
	 * 
	 * @param dt
	 * @return
	 */
	public static String toDateString(Date dt) {
		if (dt == null) return "1970-01-01";
		return String.format("%1$tY-%1$tm-%1$td", dt);
	}

	/**
	 * 输出小时字符串 %1$tH
	 * 
	 * @param dt
	 * @return
	 */
	public static String toHourString(Date dt) {
		return String.format("%1$tH", dt);
	}

	/**
	 * 输出年份字符串 %1$tY
	 * 
	 * @param dt
	 * @return
	 */
	public static String toYearString(Date dt) {
		return String.format("%1$tY", dt);
	}

	/**
	 * 输出月份字符串 %1$tm
	 * 
	 * @param dt
	 * @return
	 */
	public static String toMonthString(Date dt) {
		return String.format("%1$tm", dt);
	}

	/**
	 * 输出月天字符串 %1$td
	 * 
	 * @param dt
	 * @return
	 */
	public static String toDayString(Date dt) {
		return String.format("%1$td", dt);
	}

	/**
	 * 输出分钟字符串 %1$tM
	 * 
	 * @param dt
	 * @return
	 */
	public static String toMinuteString(Date dt) {
		return String.format("%1$tM", dt);
	}

	/**
	 * 输出秒字符串 %1$tS
	 * 
	 * @param dt
	 * @return
	 */
	public static String toSecondString(Date dt) {
		return String.format("%1$tS", dt);
	}

	/**
	 * 输出日期时间字符串 %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS
	 * 
	 * @param dt
	 * @return
	 */
	public static String toDateTimeString(Date dt) {
		return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", dt);
	}

	/**
	 * 将传入对象转换为 java.sql.Date 类型输出
	 * 
	 * @param objValue
	 * @return
	 */
	public static java.sql.Date getDateValue(Object objValue) {
		try {
			if (objValue == null) return null;

			if (objValue instanceof java.sql.Date) return (java.sql.Date) objValue;

			if (objValue instanceof java.sql.Timestamp) {
				java.sql.Timestamp ti = (java.sql.Timestamp) objValue;
				return new java.sql.Date(ti.getTime());
			}

			if (objValue instanceof java.util.Date) {
				return new java.sql.Date(((java.util.Date) objValue).getTime());
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将传入对象转换为 java.sql.Timestamp 类型输出
	 * 
	 * @param objValue
	 * @return
	 */
	public static java.sql.Timestamp getTimestampValue(Object objValue) {
		try {
			if (objValue == null) return null;

			if (objValue instanceof java.sql.Timestamp) return (java.sql.Timestamp) objValue;

			if (objValue instanceof java.sql.Date) {
				java.sql.Date ti = (java.sql.Date) objValue;
				return new java.sql.Timestamp(ti.getTime());
			}

			if (objValue instanceof java.util.Date) {
				return new java.sql.Timestamp(((java.util.Date) objValue).getTime());
			}

			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 判断数据类型是否为时间日期型
	 * 
	 * @param objValue
	 * @return
	 */
	public final static boolean isDateTimeType(Object objValue) {
		if (objValue == null) return false;

		if (objValue instanceof java.sql.Date) return true;

		if (objValue instanceof java.sql.Timestamp) {
			return true;
		}

		if (objValue instanceof java.util.Date) {
			return true;
		}
		return false;
	}

	/**
	 * 将传入时间对象转换为 long 类型输出
	 * 
	 * @param obj
	 * @return
	 */
	public static long getTime(Object obj) {
		if (obj instanceof java.sql.Time) {
			return ((java.sql.Time) obj).getTime();
		}

		if (obj instanceof java.sql.Date) {
			return ((java.sql.Date) obj).getTime();
		}

		if (obj instanceof java.sql.Timestamp) {
			return ((java.sql.Timestamp) obj).getTime();
		}

		if (obj instanceof java.util.Date) {
			return ((java.util.Date) obj).getTime();
		}

		return -1;
	}

	/**
	 * 调整时区
	 * 
	 * @param objValue
	 * @param timeZone
	 * @return
	 */
	public final static Object adjustByTimeZone(Object objValue, TimeZone timeZone, boolean bSave) {
		if (timeZone == null || objValue == null) return objValue;

		long nCurTime = System.currentTimeMillis();
		int offset1 = 0;
		int offset2 = 0;
		if (bSave) {
			offset2 = TimeZone.getDefault().getOffset(nCurTime);
			offset1 = timeZone.getOffset(nCurTime);
		} else {
			offset1 = TimeZone.getDefault().getOffset(nCurTime);
			offset2 = timeZone.getOffset(nCurTime);
		}

		if (offset1 == offset2) return objValue;

		if (objValue instanceof java.sql.Timestamp) {
			return new java.sql.Timestamp(((java.sql.Timestamp) objValue).getTime() - offset1 + offset2);
		}

		if (objValue instanceof java.sql.Date) {
			return new java.sql.Date(((java.sql.Date) objValue).getTime() - offset1 + offset2);

		}

		if (objValue instanceof java.util.Date) {
			return new java.util.Date(((java.util.Date) objValue).getTime() - offset1 + offset2);
		}

		return objValue;

	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static java.sql.Timestamp getCurTime() {
		return new java.sql.Timestamp((new java.util.Date()).getTime());
	}

	/**
	 * 获取当前时间字符串
	 * 
	 * @return
	 */
	public static String getCurTimeString() {
		return StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", getCurTime());
	}

	/**
	 * 获取实际的Java格式串
	 * 
	 * @param strFormat
	 * @return
	 */
	public static String getTimeJavaFormat(String strFormat) {
		if (StringHelper.compare(strFormat, "YYYY-mm-dd HH:MM:SS", false) == 0) {
			return "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
		}
		return strFormat;
	}
}
