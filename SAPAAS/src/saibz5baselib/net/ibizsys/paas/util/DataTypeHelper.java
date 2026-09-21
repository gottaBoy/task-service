/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.util;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeMap;
import net.ibizsys.paas.data.DataObjectList;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataTypeHelper {
    private static final Log log = LogFactory.getLog(DataTypeHelper.class);
    protected static TreeMap<String, Integer> str2intMap = new TreeMap();
    protected static TreeMap<Integer, String> int2strMap = new TreeMap();

    static {
        str2intMap.put("BIGINT", 1);
        str2intMap.put("BINARY", 2);
        str2intMap.put("BIT", 3);
        str2intMap.put("CHAR", 4);
        str2intMap.put("DATETIME", 5);
        str2intMap.put("DECIMAL", 6);
        str2intMap.put("BIGDECIMAL", 29);
        str2intMap.put("FLOAT", 7);
        str2intMap.put("IMAGE", 8);
        str2intMap.put("INT", 9);
        str2intMap.put("MONEY", 10);
        str2intMap.put("NCHAR", 11);
        str2intMap.put("NTEXT", 12);
        str2intMap.put("NVARCHAR", 13);
        str2intMap.put("NUMERIC", 14);
        str2intMap.put("REAL", 15);
        str2intMap.put("SMALLDATETIME", 16);
        str2intMap.put("SMALLINT", 17);
        str2intMap.put("SMALLMONEY", 18);
        str2intMap.put("SQL_VARIANT", 19);
        str2intMap.put("SYSNAME", 20);
        str2intMap.put("TEXT", 21);
        str2intMap.put("TIMESTAMP", 22);
        str2intMap.put("TINYINT", 23);
        str2intMap.put("VARBINARY", 24);
        str2intMap.put("VARCHAR", 25);
        str2intMap.put("UNIQUEIDENTIFIER", 26);
        str2intMap.put("DATE", 27);
        str2intMap.put("TIME", 28);
    }

    public static Object parse(String strDataType, String strValue) throws Exception {
        int nDataType = DataTypeHelper.fromString(strDataType);
        return DataTypeHelper.parse(nDataType, strValue);
    }

    public static Object parse(int dataType, String strValue) throws Exception {
        if (dataType == 1) {
            return DataTypeHelper.testBigInt(strValue);
        }
        if (dataType == 9 || dataType == 17) {
            return DataTypeHelper.testInteger(strValue);
        }
        if (dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25) {
            return strValue;
        }
        if (dataType == 5 || dataType == 16) {
            return DataTypeHelper.testDateTime(strValue);
        }
        if (dataType == 27) {
            return DataTypeHelper.testDate(strValue);
        }
        if (dataType == 28) {
            return DataTypeHelper.testTime(strValue);
        }
        if (dataType == 6 || dataType == 10 || dataType == 14 || dataType == 18 || dataType == 7 || dataType == 15) {
            return DataTypeHelper.testDouble(strValue);
        }
        if (dataType == 29) {
            return DataTypeHelper.testDecimal(strValue);
        }
        return null;
    }

    public static Object parseDateTime(int dataType, String strValue, TimeZone timeZone) throws Exception {
        if (dataType == 5 || dataType == 16) {
            return DataTypeHelper.testDateTime(strValue, timeZone);
        }
        if (dataType == 27) {
            return DataTypeHelper.testDate(strValue, timeZone);
        }
        if (dataType == 28) {
            return DataTypeHelper.testTime(strValue, timeZone);
        }
        return null;
    }

    public static Object testBigInt(String strInput) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        strInput = strInput.replace(",", "");
        return BigInteger.valueOf(Long.parseLong(strInput));
    }

    public static Object testString(String strInput) throws Exception {
        return strInput;
    }

    public static Object testInteger(String strInput) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        strInput = strInput.replace(",", "");
        int nValue = Integer.parseInt(strInput);
        return nValue;
    }

    public static Object testDecimal(String strInput) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        Object objValue = DataTypeHelper.testDouble(strInput);
        if (objValue != null) {
            return BigDecimal.valueOf((Double)objValue);
        }
        return null;
    }

    public static Object testDouble(String strInput) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        strInput = strInput.replace(",", "");
        double fValue = Double.parseDouble(strInput);
        return fValue;
    }

    public static Object testFloat(String strInput) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        strInput = strInput.replace(",", "");
        float fValue = Float.parseFloat(strInput);
        return Float.valueOf(fValue);
    }

    public static Object testDate(String strInput, TimeZone timeZone) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        java.util.Date dtDate = DateHelper.parse(strInput, timeZone);
        Date retDate = new Date(dtDate.getTime());
        return retDate;
    }

    public static Object testDate(String strInput) throws Exception {
        return DataTypeHelper.testDate(strInput, null);
    }

    public static Object testTime(String strInput) throws Exception {
        return DataTypeHelper.testTime(strInput, null);
    }

    public static Object testTime(String strInput, TimeZone timeZone) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        java.util.Date dtDate = DateHelper.parse(strInput, timeZone);
        Time retTime = new Time(dtDate.getTime());
        return retTime;
    }

    public static Object testDateTime(String strInput) throws Exception {
        return DataTypeHelper.testDateTime(strInput, null);
    }

    public static Object testDateTime(String strInput, TimeZone timeZone) throws Exception {
        if (StringHelper.isNullOrEmpty(strInput)) {
            return null;
        }
        java.util.Date dtDate = DateHelper.parse(strInput, timeZone);
        Timestamp retDate = new Timestamp(dtDate.getTime());
        return retDate;
    }

    public static boolean checkLen(int dataType, Object objValue, int nLen) {
        if (objValue == null) {
            return false;
        }
        if (nLen <= 0) {
            return true;
        }
        if (dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25) {
            return objValue.toString().length() <= nLen;
        }
        return true;
    }

    public static boolean lessThan(int dataType, Object objValueFrom, Object objValueTo) {
        long nRet = DataTypeHelper.compare(dataType, objValueFrom, objValueTo);
        return nRet <= 0L;
    }

    public static long compare(String strDataType, Object objValue, Object objValueCompare) {
        return DataTypeHelper.compare(DataTypeHelper.fromString(strDataType), objValue, objValueCompare);
    }

    public static long compare(int dataType, Object objValue, Object objValueCompare) {
        if (objValue == null || objValueCompare == null) {
            if (objValue == null && objValueCompare == null) {
                return 0L;
            }
            if (objValue == null) {
                return 1L;
            }
            return -1L;
        }
        long nTemp = 0L;
        if (dataType == 1) {
            BigInteger nValue2 = !(objValue instanceof BigInteger) ? BigInteger.valueOf(Long.parseLong(objValue.toString())) : (BigInteger)objValue;
            BigInteger nValueCompare2 = !(objValueCompare instanceof BigInteger) ? BigInteger.valueOf(Long.parseLong(objValueCompare.toString())) : (BigInteger)objValueCompare;
            nTemp = nValue2.longValue() - nValueCompare2.longValue();
        } else if (dataType == 9 || dataType == 17) {
            Integer nValue = !(objValue instanceof Integer) ? Integer.valueOf(Integer.parseInt(objValue.toString())) : (Integer)objValue;
            Integer nValueCompare = !(objValueCompare instanceof Integer) ? Integer.valueOf(Integer.parseInt(objValueCompare.toString())) : (Integer)objValueCompare;
            nTemp = nValue - nValueCompare;
        } else if (dataType == 5 || dataType == 16 || dataType == 27 || dataType == 28) {
            long nTime1 = DataTypeHelper.getDateObjectTime(objValue);
            long nTime2 = DataTypeHelper.getDateObjectTime(objValueCompare);
            nTemp = nTime1 - nTime2;
        } else if (dataType == 6 || dataType == 10 || dataType == 14 || dataType == 18 || dataType == 7 || dataType == 15) {
            Double fValue = !(objValue instanceof Double) ? Double.valueOf(Double.parseDouble(objValue.toString())) : (Double)objValue;
            Double fValueCompare = !(objValueCompare instanceof Double) ? Double.valueOf(Double.parseDouble(objValueCompare.toString())) : (Double)objValueCompare;
            double fTemp = fValue - fValueCompare;
            nTemp = fTemp == 0.0 ? 0L : (fTemp > 0.0 ? 1L : -1L);
        } else if (dataType == 29) {
            BigDecimal fValue2 = !(objValue instanceof BigDecimal) ? BigDecimal.valueOf(Double.parseDouble(objValue.toString())) : (BigDecimal)objValue;
            BigDecimal fValueCompare2 = !(objValueCompare instanceof BigDecimal) ? BigDecimal.valueOf(Double.parseDouble(objValueCompare.toString())) : (BigDecimal)objValueCompare;
            double fTemp = fValue2.doubleValue() - fValueCompare2.doubleValue();
            nTemp = fTemp == 0.0 ? 0L : (fTemp > 0.0 ? 1L : -1L);
        } else if (dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25) {
            nTemp = objValue.toString().compareTo(objValueCompare.toString());
        }
        if (nTemp == 0L) {
            return 0L;
        }
        if (nTemp > 0L) {
            return 1L;
        }
        return -1L;
    }

    public static boolean isStringDataType(int dataType) {
        switch (dataType) {
            case 4: 
            case 11: 
            case 12: 
            case 13: 
            case 20: 
            case 21: 
            case 25: {
                return true;
            }
        }
        return false;
    }

    public static boolean isDateTimeDataType(int dataType) {
        switch (dataType) {
            case 5: 
            case 16: 
            case 22: 
            case 27: 
            case 28: {
                return true;
            }
        }
        return false;
    }

    public static long getDateObjectTime(Object obj) {
        if (obj instanceof Time) {
            return ((Time)obj).getTime();
        }
        if (obj instanceof Date) {
            return ((Date)obj).getTime();
        }
        if (obj instanceof Timestamp) {
            return ((Timestamp)obj).getTime();
        }
        if (obj instanceof java.util.Date) {
            return ((java.util.Date)obj).getTime();
        }
        return -1L;
    }

    public static final boolean isContainsDataType(String strValue) {
        strValue = strValue.toUpperCase();
        return str2intMap.containsKey(strValue);
    }

    public static final int fromString(String strValue) {
        if (str2intMap.containsKey(strValue = strValue.toUpperCase())) {
            return str2intMap.get(strValue);
        }
        log.warn((Object)StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u7c7b\u578b[%1$s]", strValue));
        return 25;
    }

    public static final int fromString(String strValue, boolean bTry) throws Exception {
        if (str2intMap.containsKey(strValue = strValue.toUpperCase())) {
            return str2intMap.get(strValue);
        }
        if (!bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u7c7b\u578b[%1$s]", strValue));
        }
        log.warn((Object)StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u7c7b\u578b[%1$s]", strValue));
        return 25;
    }

    public static final boolean isStringType(int dataType) {
        return dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25;
    }

    public static final boolean isStringType(String strDataType) {
        return DataTypeHelper.isStringType(DataTypeHelper.fromString(strDataType));
    }

    public static final boolean isLongStringType(int dataType) {
        return dataType == 8 || dataType == 12 || dataType == 13 || dataType == 21;
    }

    public static final boolean isDateTimeType(int dataType) {
        return dataType == 5 || dataType == 16 || dataType == 27 || dataType == 28;
    }

    public static final boolean isDateTimeType(String strDataType) {
        return DataTypeHelper.isDateTimeType(DataTypeHelper.fromString(strDataType));
    }

    public static final boolean isIntType(int dataType) {
        return dataType == 9 || dataType == 17 || dataType == 1 || dataType == 23;
    }

    public static final boolean isIntType(String strDataType) {
        return DataTypeHelper.isIntType(DataTypeHelper.fromString(strDataType));
    }

    public static final boolean isBigIntType(int dataType) {
        return dataType == 1;
    }

    public static final boolean isBigDecimalType(int dataType) {
        return dataType == 29;
    }

    public static final boolean isBigIntType(String strDataType) {
        return DataTypeHelper.isBigIntType(DataTypeHelper.fromString(strDataType));
    }

    public static final boolean isBigDecimalType(String strDataType) {
        return DataTypeHelper.isBigDecimalType(DataTypeHelper.fromString(strDataType));
    }

    public static final boolean isDoubleType(int dataType) {
        return dataType == 7 || dataType == 6 || dataType == 10 || dataType == 18 || dataType == 14 || dataType == 15;
    }

    public static final boolean isBinaryType(int dataType) {
        return dataType == 2 || dataType == 24;
    }

    public static final boolean isBinaryType(String strDataType) {
        return DataTypeHelper.isBinaryType(DataTypeHelper.fromString(strDataType));
    }

    public static String getTypeName(String strDataType) {
        return DataTypeHelper.getTypeName(DataTypeHelper.fromString(strDataType));
    }

    public static String getTypeName(int dataType) {
        if (dataType == 1 || dataType == 9 || dataType == 17) {
            return "\u6574\u6570\u578b";
        }
        if (dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25) {
            return "\u5b57\u7b26\u578b";
        }
        if (dataType == 5 || dataType == 16) {
            return "\u65e5\u671f\u65f6\u95f4\u578b";
        }
        if (dataType == 27) {
            return "\u65e5\u671f\u578b";
        }
        if (dataType == 28) {
            return "\u65f6\u95f4\u578b";
        }
        if (dataType == 6 || dataType == 29 || dataType == 10 || dataType == 14 || dataType == 18 || dataType == 7 || dataType == 15) {
            return "\u6570\u503c\u578b";
        }
        if (dataType == 2 || dataType == 24) {
            return "\u6570\u636e\u6d41\u578b";
        }
        return "\u672a\u77e5\u7c7b\u578b";
    }

    public static String getTypeName(int dataType, Locale local) {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext != null) {
            if (dataType == 1 || dataType == 9 || dataType == 17) {
                return iWebContext.getLocalization("COMMON.DATATYPE.INTEGER", "\u6574\u6570\u578b");
            }
            if (dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25) {
                return iWebContext.getLocalization("COMMON.DATATYPE.CHAR", "\u5b57\u7b26\u578b");
            }
            if (dataType == 5 || dataType == 16) {
                return iWebContext.getLocalization("COMMON.DATATYPE.DATETIME", "\u65e5\u671f\u65f6\u95f4\u578b");
            }
            if (dataType == 27) {
                return iWebContext.getLocalization("COMMON.DATATYPE.DATE", "\u65e5\u671f\u578b");
            }
            if (dataType == 28) {
                return iWebContext.getLocalization("COMMON.DATATYPE.TIME", "\u65f6\u95f4\u578b");
            }
            if (dataType == 6 || dataType == 29 || dataType == 10 || dataType == 14 || dataType == 18 || dataType == 7 || dataType == 15) {
                return iWebContext.getLocalization("COMMON.DATATYPE.DECIMAL", "\u6570\u503c\u578b");
            }
            if (dataType == 2 || dataType == 24) {
                return iWebContext.getLocalization("COMMON.DATATYPE.BINARY", "\u6570\u636e\u6d41\u578b");
            }
            return iWebContext.getLocalization("COMMON.DATATYPE.UNKNOWN", "\u672a\u77e5\u7c7b\u578b");
        }
        return DataTypeHelper.getTypeName(dataType);
    }

    public static int getObjectDataType(Object objValue) {
        if (objValue == null) {
            return 25;
        }
        if (objValue instanceof String || objValue instanceof Character) {
            return 25;
        }
        if (objValue instanceof Date || objValue instanceof java.util.Date || objValue instanceof Timestamp) {
            return 5;
        }
        if (objValue instanceof BigInteger) {
            return 1;
        }
        if (objValue instanceof Integer) {
            return 9;
        }
        if (objValue instanceof Float || objValue instanceof Double) {
            return 7;
        }
        if (objValue instanceof Byte[] || objValue instanceof byte[]) {
            return 24;
        }
        return 25;
    }

    public static boolean testCond(Object objSrcValue, String strOp, Object objDstValue) throws Exception {
        if (StringHelper.compare(strOp, "ISNULL", true) == 0) {
            return objSrcValue == null;
        }
        if (StringHelper.compare(strOp, "ISNOTNULL", true) == 0) {
            return objSrcValue != null;
        }
        if (objSrcValue == null) {
            if (StringHelper.compare(strOp, "EQ", true) == 0) {
                return objDstValue == null;
            }
            if (StringHelper.compare(strOp, "NOTEQ", true) == 0) {
                return objDstValue != null;
            }
            return false;
        }
        if (objSrcValue instanceof String) {
            String strSrcValue = (String)objSrcValue;
            String strDstValue = (String)objDstValue;
            if (StringHelper.compare(strOp, "LEFTLIKE", true) == 0) {
                return strSrcValue.toUpperCase().indexOf(strDstValue.toUpperCase()) == 0;
            }
            if (StringHelper.compare(strOp, "LIKE", true) == 0) {
                return strSrcValue.toUpperCase().indexOf(strDstValue.toUpperCase()) != -1;
            }
            if (StringHelper.compare(strOp, "RIGHTLIKE", true) == 0) {
                int nPos = strSrcValue.toUpperCase().indexOf(strDstValue.toUpperCase());
                if (nPos == -1) {
                    return false;
                }
                return nPos + strDstValue.length() == strSrcValue.length();
            }
        }
        int nDataType = DataTypeHelper.getObjectDataType(objSrcValue);
        long nRet = DataTypeHelper.compare(nDataType, objSrcValue, objDstValue);
        if (StringHelper.compare(strOp, "EQ", true) == 0) {
            return nRet == 0L;
        }
        if (StringHelper.compare(strOp, "NOTEQ", true) == 0) {
            return nRet != 0L;
        }
        if (StringHelper.compare(strOp, "GT", true) == 0) {
            return nRet > 0L;
        }
        if (StringHelper.compare(strOp, "GTANDEQ", true) == 0) {
            return nRet >= 0L;
        }
        if (StringHelper.compare(strOp, "LT", true) == 0) {
            return nRet < 0L;
        }
        if (StringHelper.compare(strOp, "LTANDEQ", true) == 0) {
            return nRet <= 0L;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u503c\u6bd4\u8f83\u64cd\u4f5c[%1$s](%2$s)[%3$s]", objSrcValue, strOp, objDstValue));
    }

    public static final int getIntegerValue(ISimpleDataObject iDataObject, String strParamName, int nDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        return Integer.parseInt(objValue.toString());
    }

    public static final Object getObjectValue(Object objValue) throws Exception {
        return objValue;
    }

    public static final Integer getIntegerValue(Object objValue) throws Exception {
        return DataTypeHelper.getIntegerValue(objValue, null);
    }

    public static final Integer getIntegerValue(Object objValue, Integer def) throws Exception {
        if (objValue == null) {
            return def;
        }
        if (objValue instanceof Integer) {
            return (Integer)objValue;
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return def;
        }
        return Integer.parseInt(strValue);
    }

    public static final Float getFloatValue(ISimpleDataObject iDataObject, String strParamName, float fDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return Float.valueOf(fDefault);
        }
        try {
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return Float.valueOf(fDefault);
            }
            return Float.valueOf(Float.parseFloat(strValue));
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return Float.valueOf(fDefault);
        }
    }

    public static final Float getFloatValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof Float) {
            return (Float)objValue;
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(strValue));
    }

    public static final BigDecimal getBigDecimalValue(ISimpleDataObject iDataObject, String strParamName, BigDecimal fDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return fDefault;
        }
        try {
            if (objValue instanceof Double) {
                return BigDecimal.valueOf((Double)objValue);
            }
            if (objValue instanceof Long) {
                return BigDecimal.valueOf((Long)objValue);
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return fDefault;
            }
            return BigDecimal.valueOf(Double.parseDouble(strValue));
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }

    public static final BigDecimal getBigDecimalValue(Object objValue, BigDecimal fDefault) throws Exception {
        if (objValue == null) {
            return fDefault;
        }
        try {
            if (objValue instanceof Double) {
                return BigDecimal.valueOf((Double)objValue);
            }
            if (objValue instanceof Long) {
                return BigDecimal.valueOf((Long)objValue);
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return fDefault;
            }
            return BigDecimal.valueOf(Double.parseDouble(strValue));
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }

    public static final BigInteger getBigIntegerValue(ISimpleDataObject iDataObject, String strParamName, BigInteger nDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Long) {
                return BigInteger.valueOf((Long)objValue);
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return nDefault;
            }
            return BigInteger.valueOf(Long.parseLong(strValue));
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public static final BigInteger getBigIntegerValue(Object objValue, BigInteger nDefault) throws Exception {
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Long) {
                return BigInteger.valueOf((Long)objValue);
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return nDefault;
            }
            return BigInteger.valueOf(Long.parseLong(strValue));
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public static final double getDoubleValue(ISimpleDataObject iDataObject, String strParamName, double fDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return fDefault;
        }
        try {
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return fDefault;
            }
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }

    public static final Double getDoubleValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof Double) {
            return (Double)objValue;
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        return Double.parseDouble(strValue);
    }

    public static final long getLongValue(ISimpleDataObject iDataObject, String strParamName, long nDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Long) {
                return (Long)objValue;
            }
            if (objValue instanceof Double) {
                return ((Double)objValue).longValue();
            }
            if (objValue instanceof BigDecimal) {
                return ((BigDecimal)objValue).longValue();
            }
            if (objValue instanceof BigInteger) {
                return ((BigInteger)objValue).longValue();
            }
            return Long.parseLong(objValue.toString());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public static final String getStringValue(ISimpleDataObject iDataObject, String strParamName, String strDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        try {
            return DataTypeHelper.getStringValue(objValue);
        }
        catch (Exception ex) {
            return strDefault;
        }
    }

    public static final String getStringValue(Object objValue) throws Exception {
        return DataTypeHelper.getStringValue(objValue, null);
    }

    public static final String getStringValue(Object objValue, String strDefault) throws Exception {
        if (objValue == null) {
            return strDefault;
        }
        if (objValue instanceof String) {
            return (String)objValue;
        }
        return objValue.toString();
    }

    public static final String getClobValue(ISimpleDataObject iDataObject, String strParamName, String strDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        try {
            if (objValue instanceof Clob) {
                boolean bFirst = true;
                Clob clob = (Clob)objValue;
                BufferedReader br = new BufferedReader(clob.getCharacterStream());
                String s = br.readLine();
                StringBuffer sb = new StringBuffer();
                while (s != null) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        sb.append("\r\n");
                    }
                    sb.append(s);
                    s = br.readLine();
                }
                return sb.toString();
            }
            return objValue.toString();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return strDefault;
        }
    }

    public static final Timestamp getTimestampValue(ISimpleDataObject iDataObject, String strParamName, Timestamp dtDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return dtDefault;
        }
        try {
            return DataTypeHelper.getTimestampValue(objValue);
        }
        catch (Exception ex) {
            return dtDefault;
        }
    }

    public static final Timestamp getTimestampValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof Timestamp) {
            Timestamp ti = (Timestamp)objValue;
            return ti;
        }
        if (objValue instanceof Date) {
            Date date = (Date)objValue;
            return new Timestamp(date.getTime());
        }
        if (objValue instanceof java.util.Date) {
            java.util.Date date = (java.util.Date)objValue;
            return new Timestamp(date.getTime());
        }
        if (objValue instanceof String) {
            String strValue = (String)objValue;
            if (StringHelper.isNullOrEmpty(strValue = strValue.trim())) {
                return null;
            }
            java.util.Date date = DateHelper.parse((String)objValue);
            return new Timestamp(date.getTime());
        }
        if (objValue instanceof Long) {
            Long lValue = (Long)objValue;
            return new Timestamp(lValue);
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8f6c\u6362\u65f6\u95f4[%1$s]", objValue));
    }

    public static final DataObjectList getDataObjectsValue(ISimpleDataObject iDataObject, String strParamName) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof DataObjectList) {
            return (DataObjectList)objValue;
        }
        return null;
    }
}

