/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.ExpressionHelper;
import SA.SRFramework.Utility.StringHelper;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataTypeParse {
    private static final Log log = LogFactory.getLog(DataTypeParse.class);

    public static Object Parse(String strDataType, String strValue) {
        int nDataType = DataTypeHelper.FromString(strDataType);
        return DataTypeParse.Parse(nDataType, strValue);
    }

    public static Object Parse(int dataType, String strValue) {
        if (dataType == 1 || dataType == 9 || dataType == 17) {
            return DataTypeParse.TestBigInt(strValue);
        }
        if (dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25) {
            return strValue;
        }
        if (dataType == 5 || dataType == 16) {
            return DataTypeParse.TestDateTime(strValue);
        }
        if (dataType == 27) {
            return DataTypeParse.TestDate(strValue);
        }
        if (dataType == 28) {
            return DataTypeParse.TestTime(strValue);
        }
        if (dataType == 6 || dataType == 10 || dataType == 14 || dataType == 18 || dataType == 7 || dataType == 15) {
            return DataTypeParse.TestDouble(strValue);
        }
        return null;
    }

    public static Object ParseDateTime(int dataType, String strValue, TimeZone timeZone) {
        if (dataType == 5 || dataType == 16) {
            return DataTypeParse.TestDateTime(strValue, timeZone);
        }
        if (dataType == 27) {
            return DataTypeParse.TestDate(strValue, timeZone);
        }
        if (dataType == 28) {
            return DataTypeParse.TestTime(strValue, timeZone);
        }
        return null;
    }

    public static Object TestBigInt(String strInput) {
        return DataTypeParse.TestInteger(strInput);
    }

    public static Object TestString(String strInput) {
        return strInput;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object TestInteger(String strInput) {
        try {
            if (StringHelper.IsNullOrEmpty(strInput)) {
                return null;
            }
            if ((strInput = strInput.replace("[,]", "")).indexOf("=") == 0) {
                Object objValue = DataTypeParse.GetExpressionValue(strInput);
                if (objValue == null) {
                    return null;
                }
                strInput = objValue.toString();
            }
            int nValue = Integer.parseInt(strInput);
            return nValue;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public static Object TestDecimal(String strInput) {
        block4: {
            try {
                if (!StringHelper.IsNullOrEmpty(strInput)) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format("TestDecimal(%1$s) \u51fa\u73b0\u9519\u8bef", strInput), (Throwable)ex);
                return null;
            }
        }
        Object objValue = DataTypeParse.TestDouble(strInput);
        if (objValue != null) {
            return BigDecimal.valueOf((Double)objValue);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object TestDouble(String strInput) {
        try {
            if (StringHelper.IsNullOrEmpty(strInput)) {
                return null;
            }
            if ((strInput = strInput.replace("[,]", "")).indexOf("=") == 0) {
                Object objValue = DataTypeParse.GetExpressionValue(strInput);
                if (objValue == null) {
                    return null;
                }
                strInput = objValue.toString();
            }
            double fValue = Double.parseDouble(strInput);
            return fValue;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format("TestDouble(%1$s) \u51fa\u73b0\u9519\u8bef", strInput), (Throwable)ex);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object TestFloat(String strInput) {
        try {
            if (StringHelper.IsNullOrEmpty(strInput)) {
                return null;
            }
            if ((strInput = strInput.replace("[,]", "")).indexOf("=") == 0) {
                Object objValue = DataTypeParse.GetExpressionValue(strInput);
                if (objValue == null) {
                    return null;
                }
                strInput = objValue.toString();
            }
            float fValue = Float.parseFloat(strInput);
            return Float.valueOf(fValue);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format("TestFloat(%1$s) \u51fa\u73b0\u9519\u8bef", strInput), (Throwable)ex);
            return null;
        }
    }

    public static Object TestDate(String strInput, TimeZone timeZone) {
        block3: {
            try {
                if (!StringHelper.IsNullOrEmpty(strInput)) break block3;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format("TestDate(%1$s) \u51fa\u73b0\u9519\u8bef", strInput), (Throwable)ex);
                return null;
            }
        }
        Date dtDate = DateParser.Parse(strInput, timeZone);
        java.sql.Date retDate = new java.sql.Date(dtDate.getTime());
        return retDate;
    }

    public static Object TestDate(String strInput) {
        return DataTypeParse.TestDate(strInput, null);
    }

    public static Object TestTime(String strInput) {
        return DataTypeParse.TestTime(strInput, null);
    }

    public static Object TestTime(String strInput, TimeZone timeZone) {
        block3: {
            try {
                if (!StringHelper.IsNullOrEmpty(strInput)) break block3;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format("TestTime(%1$s) \u51fa\u73b0\u9519\u8bef", strInput), (Throwable)ex);
                return null;
            }
        }
        Date dtDate = DateParser.Parse(strInput, timeZone);
        Time retTime = new Time(dtDate.getTime());
        return retTime;
    }

    public static Object TestDateTime(String strInput) {
        return DataTypeParse.TestDateTime(strInput, null);
    }

    public static Object TestDateTime(String strInput, TimeZone timeZone) {
        block3: {
            try {
                if (!StringHelper.IsNullOrEmpty(strInput)) break block3;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format("TestDateTime(%1$s) \u51fa\u73b0\u9519\u8bef", strInput), (Throwable)ex);
                return null;
            }
        }
        Date dtDate = DateParser.Parse(strInput, timeZone);
        Timestamp retDate = new Timestamp(dtDate.getTime());
        return retDate;
    }

    public static boolean CheckLen(int dataType, Object objValue, int nLen) {
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

    public static boolean LessThan(int dataType, Object objValueFrom, Object objValueTo) {
        long nRet = DataTypeParse.Compare(dataType, objValueFrom, objValueTo);
        return nRet <= 0L;
    }

    public static long Compare(String strDataType, Object objValue, Object objValueCompare) {
        return DataTypeParse.Compare(DataTypeHelper.FromString(strDataType), objValue, objValueCompare);
    }

    public static long Compare(int dataType, Object objValue, Object objValueCompare) {
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
        if (dataType == 1 || dataType == 9 || dataType == 17) {
            Integer nValue = !(objValue instanceof Integer) ? Integer.valueOf(Integer.parseInt(objValue.toString())) : (Integer)objValue;
            Integer nValueCompare = !(objValueCompare instanceof Integer) ? Integer.valueOf(Integer.parseInt(objValueCompare.toString())) : (Integer)objValueCompare;
            nTemp = nValue - nValueCompare;
        } else if (dataType == 5 || dataType == 16 || dataType == 27 || dataType == 28) {
            long nTime1 = DataTypeParse.GetDateObjectTime(objValue);
            long nTime2 = DataTypeParse.GetDateObjectTime(objValueCompare);
            nTemp = nTime1 - nTime2;
        } else if (dataType == 6 || dataType == 10 || dataType == 14 || dataType == 18 || dataType == 7 || dataType == 15) {
            Double fValue = !(objValue instanceof Double) ? Double.valueOf(Double.parseDouble(objValue.toString())) : (Double)objValue;
            Double fValueCompare = !(objValueCompare instanceof Double) ? Double.valueOf(Double.parseDouble(objValueCompare.toString())) : (Double)objValueCompare;
            double fTemp = fValue - fValueCompare;
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

    public static boolean IsStringDataType(int dataType) {
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

    public static boolean IsDateTimeDataType(int dataType) {
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

    public static long GetDateObjectTime(Object obj) {
        if (obj instanceof Time) {
            return ((Time)obj).getTime();
        }
        if (obj instanceof java.sql.Date) {
            return ((java.sql.Date)obj).getTime();
        }
        if (obj instanceof Timestamp) {
            return ((Timestamp)obj).getTime();
        }
        if (obj instanceof Date) {
            return ((Date)obj).getTime();
        }
        return -1L;
    }

    public static Object GetExpressionValue(String strExpression) {
        ExpressionHelper expressionHelper = new ExpressionHelper();
        return expressionHelper.GetValue(strExpression);
    }
}

