package net.ibizsys.paas.util;

import java.util.ArrayList;

/**
 * 字符串辅助对象
 * 
 * @author LionLau
 * 
 */
public final class StringHelper {
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(StringHelper.class);
	public StringHelper() {

	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @return
	 */
	final public static String format(String strFormat) {
		return strFormat;
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @return
	 */
	final public static String format(String strFormat, Object obj1) {
		return String.format(strFormat, obj1);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2) {
		return String.format(strFormat, obj1, obj2);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3) {
		return String.format(strFormat, obj1, obj2, obj3);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4) {
		return String.format(strFormat, obj1, obj2, obj3, obj4);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
		return String.format(strFormat, obj1, obj2, obj3, obj4, obj5);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
		return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
		return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
		return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 * @param obj9
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
		return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 * @param obj9
	 * @param obj10
	 * @return
	 */
	final public static String format(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
		return String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param strFormat
	 * @param arrList
	 * @return
	 */
	final public static String format(String strFormat, Object[] arrList) {
		int nArrCount = ((arrList ==null)?0:arrList.length);
		switch (nArrCount) {
		case 0:
			return strFormat;
		case 1:
			return String.format(strFormat, arrList[0]);
		case 2:
			return String.format(strFormat, arrList[0], arrList[1]);
		case 3:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2]);
		case 4:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3]);
		case 5:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4]);
		case 6:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5]);
		case 7:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6]);
		case 8:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7]);
		case 9:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8]);
		case 10:
			return String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8], arrList[9]);
		default:
			log.error("格式化参数数组溢出");
			break;
		}
		
		return strFormat;
	}

	/**
	 * 获取字符串长度，空值长度为0
	 * 
	 * @param strValue
	 * @return
	 */
	final public static int length(String strValue) {
		if (strValue == null) {
			return 0;
		}
		return strValue.length();
	}

	/**
	 * 是否为空或长度为0字符串
	 * 
	 * @param strValue
	 * @return
	 */
	final public static boolean isNullOrEmpty(String strValue) {
		return (length(strValue) == 0);
	}

	/**
	 * 是否为空或长度为0字符串
	 * 
	 * @param strValue
	 * @return
	 */
	final public static boolean isNullOrEmpty(Object objValue) {
		if (objValue == null) return true;
		return (length(objValue.toString()) == 0);
	}

	/**
	 * 对比两个字符串，空值最小
	 * 
	 * @param strValue1 String
	 * @param strValue2 String
	 * @param bIgnoreCase boolean
	 * @return int
	 */
	final public static int compare(String strValue1, String strValue2, boolean bIgnoreCase) {
		if (strValue1 == null && strValue2 == null) {
			return 0;
		}

		if (strValue1 == null && strValue2 != null) {
			return -1;
		}

		if (strValue1 != null && strValue2 == null) {
			return 1;
		}

		if (bIgnoreCase) {
			return strValue1.compareToIgnoreCase(strValue2);
		} else {
			return strValue1.compareTo(strValue2);
		}
	}

	/**
	 * 分解字符串
	 * 
	 * @param strValue
	 * @param chSeperator
	 * @return
	 */
	final public static String[] split(String strValue, char chSeperator) {
		if (StringHelper.length(strValue) == 0) return null;

		ArrayList arrList = new ArrayList();
		while (true) {
			int nPos = strValue.indexOf(chSeperator);
			if (nPos != -1) {
				String strPartA = strValue.substring(0, nPos);
				arrList.add(strPartA);
				strValue = strValue.substring(nPos + 1);
			} else {
				arrList.add(strValue);
				break;
			}
		}

		String[] strList = new String[arrList.size()];
		arrList.toArray(strList);
		return strList;

	}

	/**
	 * 分解字符串
	 * 
	 * @param strValue
	 * @param chSeperator
	 * @return
	 */
	final public static String[] split(String strValue, String chSeperator) {
		if (StringHelper.length(strValue) == 0) return null;

		ArrayList arrList = new ArrayList();
		while (true) {
			int nPos = strValue.indexOf(chSeperator);
			if (nPos != -1) {
				String strPartA = strValue.substring(0, nPos);
				arrList.add(strPartA);
				strValue = strValue.substring(nPos + chSeperator.length());
			} else {
				arrList.add(strValue);
				break;
			}
		}

		String[] strList = new String[arrList.size()];
		arrList.toArray(strList);
		return strList;

	}

	/**
	 * 剔除字符串左侧空格
	 * 
	 * @param strValue
	 * @return
	 */
	final public static String trimLeft(String strValue) {
		return trimLeft(strValue, ' ');
	}

	/**
	 * 剔除字符串左侧指定字符
	 * 
	 * @param strValue
	 * @param ch
	 * @return
	 */
	final public static String trimLeft(String strValue, char ch) {
		while (strValue.length() > 0) {
			if (strValue.charAt(0) == ch) {
				strValue = strValue.substring(1);
			} else
				break;
		}
		return strValue;
	}

	/**
	 * 剔除字符串右侧空格
	 * 
	 * @param strValue
	 * @return
	 */
	final public static String trimRight(String strValue) {
		return trimRight(strValue, ' ');
	}

	/**
	 * 剔除字符串右侧指定字符
	 * 
	 * @param strValue
	 * @param ch
	 * @return
	 */
	final public static String trimRight(String strValue, char ch) {
		while (strValue.length() > 0) {
			if (strValue.charAt(strValue.length() - 1) == ch) {
				strValue = strValue.substring(0, strValue.length() - 1);
			} else
				break;
		}
		return strValue;
	}

	/**
	 * 使用 ; | 字符分隔字符串
	 * 
	 * @param strValue
	 * @return
	 */
	final public static String[] splitEx(String strValue) {
		if (StringHelper.length(strValue) == 0) return null;

		strValue = strValue.replace("|", ";");
		// strValue = strValue.replaceAll("；", ";");
		// strValue = strValue.replaceAll("、", ";");

		return strValue.split("[;]");
	}

}
