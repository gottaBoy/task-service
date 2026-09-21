/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MacroParamHelper {
    private static final Log log = LogFactory.getLog(MacroParamHelper.class);
    public static final String TAG_SRFTAGHEADER = "%%SRF";
    public static final String TAG_SRFTAGEND = ")%%";
    public static final String TAG_SRFDATE = "SRFDATE";
    public static final String TAG_SRFDATETIME = "SRFDATETIME";
    public static final String TAG_SRFTIME = "SRFTIME";
    public static final String TAG_SRFOPPERSON = "SRFOPPERSON";
    public static final String TAG_SRFDEF = "SRFDEF";
    public static final String TAG_SRFGV = "SRFGV";
    public static final String TAG_SRFSV = "SRFSV";
    public static final String TAG_SRFUV = "SRFUV";
    public static final String TAG_SRFUD = "SRFUD";
    public static final String TAG_SRFUVEX = "SRFUVEX";
    public static final String TAG_SRFUVINT = "SRFUVINT";
    public static final String TAG_SRFUVDATE = "SRFUVDATE";
    public static final String TAG_SRFUVDOUBLE = "SRFUVDOUBLE";
    public static final String TAG_SRFUVFLOAT = "SRFUVFLOAT";
    public static final String TAG_SRFV = "SRFV";
    public static final String TAG_SRFREMOVE = "%%SRFREMOVE%%";
    public static final String TAG_SRFREMOVE2 = "%%SRFREMOVE()%%";
    public static final String TAG_SRFREG = "SRFREG";
    public static final String TAG_SRFTD = "SRFTD";
    public static final String TAG_SRFDATETIMEEX = "SRFDATETIMEEX";

    public static Object getValue(String strFunc, IWebContext webContext) throws Exception {
        return MacroParamHelper.getValue(strFunc, webContext, webContext.getGlobalContext(), webContext.getCurUserId(), null);
    }

    public static Object getValue(String strFunc, IWebContext webContext, IDataObject dataEntity) throws Exception {
        return MacroParamHelper.getValue(strFunc, webContext, webContext.getGlobalContext(), webContext.getCurUserId(), dataEntity);
    }

    public static Object getValue(String strFunc, IGlobalContext iGlobalContext, String strCurPersonId, IDataObject dataEntity) throws Exception {
        return MacroParamHelper.getValue(strFunc, null, iGlobalContext, strCurPersonId, dataEntity);
    }

    public static Object getValue(String strFunc, IWebContext webContext, IGlobalContext iGlobalContext, IDataObject dataEntity) throws Exception {
        return MacroParamHelper.getValue(strFunc, webContext, iGlobalContext, webContext.getCurUserId(), dataEntity);
    }

    public static Object getValue(String strFunc, IWebContext webContext, IGlobalContext iGlobalContext, String strCurPersonId, IDataObject dataEntity) throws Exception {
        if (!MacroParamHelper.isSRFFunc(strFunc)) {
            return strFunc;
        }
        Vector<String> argList = new Vector<String>();
        String strFuncName = MacroParamHelper.ParseSRFFunc(strFunc, argList);
        if (StringHelper.isNullOrEmpty(strFuncName)) {
            return "";
        }
        if (StringHelper.compare(strFuncName, TAG_SRFDATE, true) == 0) {
            String strFormat = "%1$tY-%1$tm-%1$td";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            return StringHelper.format(strFormat, new Date());
        }
        if (StringHelper.compare(strFuncName, TAG_SRFDATETIME, true) == 0) {
            String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            Date date = new Date();
            return StringHelper.format(strFormat, date);
        }
        if (StringHelper.compare(strFuncName, TAG_SRFTIME, true) == 0) {
            String strFormat = "%1$tH:%1$tM:%1$tS";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            return StringHelper.format(strFormat, new Date());
        }
        if (StringHelper.compare(strFuncName, TAG_SRFOPPERSON, true) == 0) {
            if (!StringHelper.isNullOrEmpty(strCurPersonId)) {
                return strCurPersonId;
            }
            if (webContext != null) {
                return webContext.getCurUserId();
            }
            return strCurPersonId;
        }
        if (StringHelper.compare(strFuncName, TAG_SRFGV, true) == 0) {
            if (webContext == null && iGlobalContext == null) {
                throw new Exception("\u4e0a\u4e0b\u6587\u5bf9\u8c61\u53ca\u5168\u5c40\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.isNullOrEmpty(strFieldName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            if (webContext != null) {
                return webContext.getGlobalValue(strFieldName);
            }
            return iGlobalContext.getValue(strFieldName);
        }
        if (StringHelper.compare(strFuncName, TAG_SRFSV, true) == 0) {
            if (webContext == null) {
                throw new Exception("\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.isNullOrEmpty(strFieldName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            return webContext.getSessionValue(strFieldName);
        }
        if (StringHelper.compare(strFuncName, TAG_SRFUV, true) == 0) {
            if (webContext == null) {
                throw new Exception("\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.isNullOrEmpty(strFieldName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            String strValue = webContext.getParamValue(strFieldName);
            if (StringHelper.isNullOrEmpty(strValue)) {
                strValue = webContext.getPostValue(strFieldName.toLowerCase());
            }
            return strValue;
        }
        if (StringHelper.compare(strFuncName, TAG_SRFUVINT, true) == 0 || StringHelper.compare(strFuncName, TAG_SRFUVDATE, true) == 0 || StringHelper.compare(strFuncName, TAG_SRFUVDOUBLE, true) == 0 || StringHelper.compare(strFuncName, TAG_SRFUVFLOAT, true) == 0) {
            if (webContext == null) {
                throw new Exception("\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.isNullOrEmpty(strFieldName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            String strValue = "";
            strValue = webContext.getParamValue(strFieldName);
            if (StringHelper.isNullOrEmpty(strValue)) {
                strValue = webContext.getPostValue(strFieldName.toLowerCase());
            }
            if (StringHelper.isNullOrEmpty(strValue)) {
                return null;
            }
            if (StringHelper.compare(strFuncName, TAG_SRFUVINT, true) == 0) {
                return DataTypeHelper.testInteger(strValue);
            }
            if (StringHelper.compare(strFuncName, TAG_SRFUVDATE, true) == 0) {
                Object objValue = DataTypeHelper.testDateTime(strValue);
                if (objValue != null && objValue instanceof Timestamp && argList.size() >= 2 && StringHelper.compare(argList.get(1), "ENDOFDAY", true) == 0) {
                    Timestamp endTime = (Timestamp)objValue;
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(new Date(endTime.getTime()));
                    cal.set(11, 23);
                    cal.set(12, 59);
                    cal.set(13, 59);
                    endTime.setTime(cal.getTime().getTime());
                    return endTime;
                }
                return objValue;
            }
            if (StringHelper.compare(strFuncName, TAG_SRFUVDOUBLE, true) == 0) {
                return DataTypeHelper.testDouble(strValue);
            }
            if (StringHelper.compare(strFuncName, TAG_SRFUVFLOAT, true) == 0) {
                return DataTypeHelper.testFloat(strValue);
            }
            return null;
        }
        if (StringHelper.compare(strFuncName, TAG_SRFDEF, true) == 0) {
            if (dataEntity == null) {
                throw new Exception("\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            int nDataType = 0;
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (argList.size() >= 2) {
                nDataType = DataTypeHelper.fromString(argList.get(1));
            }
            if (StringHelper.isNullOrEmpty(strFieldName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            Object objValue = dataEntity.get(strFieldName);
            if (objValue == null) {
                if (argList.size() >= 3 && nDataType != 0) {
                    return DataTypeHelper.parse(nDataType, argList.get(2));
                }
                return null;
            }
            if (nDataType == 0) {
                return objValue;
            }
            switch (nDataType) {
                case 5: {
                    if (objValue instanceof String) {
                        return DataTypeHelper.testDateTime((String)objValue);
                    }
                    return new Timestamp(DataTypeHelper.getDateObjectTime(objValue));
                }
                case 27: {
                    if (objValue instanceof String) {
                        return DataTypeHelper.testDate((String)objValue);
                    }
                    return new java.sql.Date(DataTypeHelper.getDateObjectTime(objValue));
                }
            }
            return objValue;
        }
        if (StringHelper.compare(strFuncName, TAG_SRFUD, true) == 0) {
            String strFieldName;
            if (webContext != null) {
                strFieldName = "";
                if (argList.size() > 0) {
                    strFieldName = argList.get(0);
                }
                if (StringHelper.isNullOrEmpty(strFieldName)) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                }
                String strValue = webContext.getParamValue(strFieldName);
                if (StringHelper.isNullOrEmpty(strValue)) {
                    strValue = webContext.getPostValue(strFieldName.toLowerCase());
                }
                if (!StringHelper.isNullOrEmpty(strValue)) {
                    return strValue;
                }
            }
            if (dataEntity != null) {
                strFieldName = "";
                int nDataType = 0;
                if (argList.size() > 0) {
                    strFieldName = argList.get(0);
                }
                if (argList.size() >= 2) {
                    nDataType = DataTypeHelper.fromString(argList.get(1));
                }
                if (StringHelper.isNullOrEmpty(strFieldName)) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                }
                Object objValue = dataEntity.get(strFieldName);
                if (objValue == null) {
                    if (argList.size() >= 3 && nDataType != 0) {
                        return DataTypeHelper.parse(nDataType, argList.get(2));
                    }
                    return null;
                }
                if (nDataType == 0) {
                    return objValue;
                }
                switch (nDataType) {
                    case 5: {
                        if (objValue instanceof String) {
                            return DataTypeHelper.testDateTime((String)objValue);
                        }
                        return new Timestamp(DataTypeHelper.getDateObjectTime(objValue));
                    }
                    case 27: {
                        if (objValue instanceof String) {
                            return DataTypeHelper.testDate((String)objValue);
                        }
                        return new java.sql.Date(DataTypeHelper.getDateObjectTime(objValue));
                    }
                }
                return objValue;
            }
            throw new Exception("\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u53ca\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
        }
        if (StringHelper.compare(strFuncName, TAG_SRFV, true) == 0) {
            if (argList.size() == 0) {
                throw new Exception("\u53c2\u6570\u503c\u65e0\u6548");
            }
            String strValue = argList.get(0);
            String strDataType = "VARCHAR";
            if (argList.size() >= 2) {
                strDataType = argList.get(1);
            }
            return DataTypeHelper.parse(strDataType, strValue);
        }
        if (StringHelper.compare(strFuncName, TAG_SRFDATETIMEEX, true) == 0) {
            String strTimeFormat2;
            String strTimeFormat = "";
            if (argList.size() > 0) {
                strTimeFormat = argList.get(0);
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
                        MacroParamHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
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
            MacroParamHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            if (argList.size() > 1 && !StringHelper.isNullOrEmpty(strTimeFormat2 = argList.get(1))) {
                strCurType = strTimeFormat2.substring(0, 1);
                strCurValue = strTimeFormat2.substring(1);
                MacroParamHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            }
            String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
            return StringHelper.format(strFormat, cal.getTime());
        }
        return strFunc;
    }

    public static boolean isSRFFunc(String strFunc) {
        return strFunc.indexOf(TAG_SRFTAGHEADER, 0) == 0;
    }

    public static String ParseSRFFunc(String strFunc, Vector<String> argList) {
        int nPos = strFunc.indexOf(TAG_SRFTAGHEADER, 0);
        if (nPos != 0) {
            return strFunc;
        }
        nPos = strFunc.indexOf("(");
        if (nPos == -1) {
            return "";
        }
        String strFuncName = strFunc.substring(2, nPos);
        String strParams = strFunc.substring(nPos + 1, strFunc.length() - 3);
        if (StringHelper.isNullOrEmpty(strParams = strParams.trim())) {
            return strFuncName;
        }
        String[] params = strParams.split("[,]");
        int i = 0;
        while (i < params.length) {
            argList.add(params[i].trim());
            ++i;
        }
        return strFuncName;
    }

    public static boolean isRemoveFunc(String strFunc) {
        return StringHelper.compare(strFunc, TAG_SRFREMOVE, true) == 0 || StringHelper.compare(strFunc, TAG_SRFREMOVE2, true) == 0;
    }

    public static Object getFormItemRuleArg(String strFunc, boolean bBackend) throws Exception {
        Vector<String> argList = new Vector<String>();
        String strFuncName = MacroParamHelper.ParseSRFFunc(strFunc, argList);
        if (StringHelper.isNullOrEmpty(strFuncName)) {
            return null;
        }
        if (StringHelper.compare(strFuncName, TAG_SRFOPPERSON, true) == 0) {
            return StringHelper.format("dp.CurOPPerson()");
        }
        if (StringHelper.compare(strFuncName, TAG_SRFSV, true) == 0) {
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.isNullOrEmpty(strFieldName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            return StringHelper.format("dp.SV('%1$s')", strFieldName);
        }
        if (StringHelper.compare(strFuncName, TAG_SRFDEF, true) == 0) {
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.isNullOrEmpty(strFieldName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            return StringHelper.format("dp.Val('%1$s')", strFieldName);
        }
        if (StringHelper.compare(strFuncName, TAG_SRFDATETIMEEX, true) == 0) {
            String strTimeFormat2;
            String strTimeFormat = "";
            if (argList.size() > 0) {
                strTimeFormat = argList.get(0);
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
                        MacroParamHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
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
            MacroParamHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            if (argList.size() > 1 && !StringHelper.isNullOrEmpty(strTimeFormat2 = argList.get(1))) {
                strCurType = strTimeFormat2.substring(0, 1);
                strCurValue = strTimeFormat2.substring(1);
                MacroParamHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            }
            String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
            return StringHelper.format(strFormat, cal.getTime());
        }
        return null;
    }

    private static void CalcDateTimeEx(Calendar cal, String strCurType, String strCurValue) {
        if (StringHelper.isNullOrEmpty(strCurValue) || StringHelper.isNullOrEmpty(strCurType)) {
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
            if (StringHelper.isNullOrEmpty(strCurValue = strCurValue.substring(1))) {
                return;
            }
            Integer nValue = Integer.parseInt(strCurValue);
            cal.set(nDateType, nValue);
        } else {
            if (strCurValue.charAt(0) == '+' && StringHelper.isNullOrEmpty(strCurValue = strCurValue.substring(1))) {
                return;
            }
            Integer nValue = Integer.parseInt(strCurValue);
            cal.add(nDateType, nValue);
        }
    }

    public static void fillDataObject(IDataEntity iDataEntity, Properties properties, IDataObject dataEntity, IWebContext webContext, IGlobalContext iGlobalContext, String strCurPersonId, IDataObject srcDataEntity) throws Exception {
        CallResult callResult = new CallResult();
        if (properties == null) {
            return;
        }
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.getProperty(properties, strKey);
            if (StringHelper.compare(TAG_SRFREMOVE2, strValue, true) == 0 || StringHelper.compare(TAG_SRFREMOVE, strValue, true) == 0) {
                dataEntity.remove(strKey);
                continue;
            }
            Object obj = MacroParamHelper.getValue(strValue, webContext, iGlobalContext, strCurPersonId, srcDataEntity);
            if (obj == null) {
                dataEntity.set(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.isNullOrEmpty(strValue)) {
                    dataEntity.set(strKey, null);
                    continue;
                }
                IDEField iDEField = null;
                if (iDataEntity != null) {
                    iDEField = iDataEntity.getDEField(strKey, true);
                }
                if (iDEField != null) {
                    obj = DataTypeHelper.parse(iDEField.getStdDataType(), strValue);
                }
                dataEntity.set(strKey, obj);
                continue;
            }
            dataEntity.set(strKey, obj);
        }
    }
}

