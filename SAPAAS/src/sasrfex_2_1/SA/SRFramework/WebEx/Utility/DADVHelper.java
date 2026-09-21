/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.util.Calendar;
import java.util.Date;

public class DADVHelper {
    public static String GetDefaultValue(SRFExWebContext webContext, String strDVT, String strDV) {
        if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0) {
            return "";
        }
        if (StringHelper.Compare((String)strDVT, (String)"UNIQUEID", (boolean)true) == 0) {
            return Helper.GenGuidEx();
        }
        if (StringHelper.Compare((String)strDVT, (String)"APPLICATION", (boolean)true) == 0) {
            Object objValue = webContext.GetGlobalValue(strDV);
            if (objValue != null) {
                return objValue.toString();
            }
            return "";
        }
        if (StringHelper.Compare((String)strDVT, (String)"SESSION", (boolean)true) == 0) {
            Object objValue = webContext.GetSessionValue(strDV);
            if (objValue != null) {
                return objValue.toString();
            }
            return "";
        }
        if (StringHelper.Compare((String)strDVT, (String)"CONTEXT", (boolean)true) == 0) {
            return webContext.GetParamValue(strDV);
        }
        if (StringHelper.Compare((String)strDVT, (String)"OPERATOR", (boolean)true) == 0) {
            return webContext.getCurUserId();
        }
        if (StringHelper.Compare((String)strDVT, (String)"OPERATORNAME", (boolean)true) == 0) {
            return webContext.getCurUserName();
        }
        if (StringHelper.Compare((String)strDVT, (String)"CURTIME", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strDV)) {
                return DateParser.toDateTimeString((Date)new Date());
            }
            return DateParser.toDateTimeString((Date)DADVHelper.CalcCurTime(strDV));
        }
        return strDV;
    }

    public static Object GetDefaultValue(SRFExWebContext webContext, String strDVT, String strDV, int nDataType, BaseDataEntity dataEntity) {
        if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0) {
            return null;
        }
        if (StringHelper.Compare((String)strDVT, (String)"UNIQUEID", (boolean)true) == 0) {
            return Helper.GenGuidEx();
        }
        if (StringHelper.Compare((String)strDVT, (String)"APPLICATION", (boolean)true) == 0) {
            Object objValue = webContext.GetGlobalValue(strDV);
            return objValue;
        }
        if (StringHelper.Compare((String)strDVT, (String)"SESSION", (boolean)true) == 0) {
            Object objValue = webContext.GetSessionValue(strDV);
            return objValue;
        }
        if (StringHelper.Compare((String)strDVT, (String)"CONTEXT", (boolean)true) == 0) {
            return DataTypeParse.Parse((int)nDataType, (String)webContext.GetParamValue(strDV));
        }
        if (StringHelper.Compare((String)strDVT, (String)"OPERATOR", (boolean)true) == 0) {
            return DataTypeParse.Parse((int)nDataType, (String)webContext.getCurUserId());
        }
        if (StringHelper.Compare((String)strDVT, (String)"OPERATORNAME", (boolean)true) == 0) {
            return DataTypeParse.Parse((int)nDataType, (String)webContext.getCurUserName());
        }
        if (StringHelper.Compare((String)strDVT, (String)"CURTIME", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strDV)) {
                return DataTypeParse.Parse((int)5, (String)DateParser.toDateTimeString((Date)new Date()));
            }
            return DataTypeParse.Parse((int)5, (String)DateParser.toDateTimeString((Date)DADVHelper.CalcCurTime(strDV)));
        }
        if (StringHelper.Compare((String)strDVT, (String)"PARAM", (boolean)true) == 0 && dataEntity != null) {
            return dataEntity.GetParamValue(strDV);
        }
        return DataTypeParse.Parse((int)nDataType, (String)strDV);
    }

    public static Object GetDefaultValue(SRFExWebContext webContext, String strDVT, String strDV, int nDataType) {
        return DADVHelper.GetDefaultValue(webContext, strDVT, strDV, nDataType, null);
    }

    public static Object GetDefaultValue(SRFExWebContext webContext, String strDVT, String strDV, String strDataType) {
        return DADVHelper.GetDefaultValue(webContext, strDVT, strDV, DataTypeHelper.FromString((String)strDataType));
    }

    private static Date CalcCurTime(String strValue) {
        String strTimeFormat2;
        String[] parts = strValue.split("[,]");
        String strTimeFormat = "";
        if (parts.length > 0) {
            strTimeFormat = parts[0];
        }
        Calendar cal = Calendar.getInstance();
        String strCurType = "";
        String strCurValue = "";
        int i = 0;
        while (i < strTimeFormat.length()) {
            char ch = strTimeFormat.charAt(i);
            switch (ch) {
                case 'H': 
                case 'M': 
                case 'S': 
                case 'Y': 
                case 'd': 
                case 'm': {
                    DADVHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
                    strCurValue = "";
                    strCurType = "";
                    strCurType = String.valueOf(strCurType) + ch;
                    break;
                }
                default: {
                    strCurValue = String.valueOf(strCurValue) + ch;
                }
            }
            ++i;
        }
        DADVHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
        if (parts.length > 1 && !StringHelper.IsNullOrEmpty((String)(strTimeFormat2 = parts[1]))) {
            strCurType = strTimeFormat2.substring(0, 1);
            strCurValue = strTimeFormat2.substring(1);
            DADVHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
        }
        return cal.getTime();
    }

    private static void CalcDateTimeEx(Calendar cal, String strCurType, String strCurValue) {
        if (StringHelper.IsNullOrEmpty((String)strCurValue) || StringHelper.IsNullOrEmpty((String)strCurType)) {
            return;
        }
        int nDateType = 0;
        switch (strCurType.charAt(0)) {
            case 'Y': {
                nDateType = 1;
                break;
            }
            case 'm': {
                nDateType = 2;
                break;
            }
            case 'd': {
                nDateType = 5;
                break;
            }
            case 'H': {
                nDateType = 11;
                break;
            }
            case 'M': {
                nDateType = 12;
                break;
            }
            case 'S': {
                nDateType = 13;
                break;
            }
            default: {
                return;
            }
        }
        if (strCurValue.charAt(0) == '#') {
            if (StringHelper.IsNullOrEmpty((String)(strCurValue = strCurValue.substring(1)))) {
                return;
            }
            Integer nValue = Integer.parseInt(strCurValue);
            cal.set(nDateType, nValue);
        } else {
            if (strCurValue.charAt(0) == '+' && StringHelper.IsNullOrEmpty((String)(strCurValue = strCurValue.substring(1)))) {
                return;
            }
            Integer nValue = Integer.parseInt(strCurValue);
            cal.add(nDateType, nValue);
        }
    }
}

