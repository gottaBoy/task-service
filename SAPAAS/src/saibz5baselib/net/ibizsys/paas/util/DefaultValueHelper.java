/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.util;

import java.util.Calendar;
import java.util.Date;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public class DefaultValueHelper {
    public static final String DVT_SESSION = "SESSION";
    public static final String DVT_APPLICATION = "APPLICATION";
    public static final String DVT_UNIQUEID = "UNIQUEID";
    public static final String DVT_CONTEXT = "CONTEXT";
    public static final String DVT_OPERATOR = "OPERATOR";
    public static final String DVT_OPERATORNAME = "OPERATORNAME";
    public static final String DVT_CURTIME = "CURTIME";
    public static final String DVT_COPY = "COPY";
    public static final String DVT_PARAM = "PARAM";
    public static final String DVT_APPDATA = "APPDATA";
    public static final String PARAMTYPE_CURTIME = "CURTIME";
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";

    public static String getValue(IWebContext webContext, String strDVT, String strDV) throws Exception {
        if (StringHelper.length(strDVT) == 0 && StringHelper.length(strDV) == 0) {
            return "";
        }
        if (StringHelper.compare(strDVT, DVT_UNIQUEID, true) == 0) {
            return KeyValueHelper.genGuidEx();
        }
        if (StringHelper.compare(strDVT, DVT_APPLICATION, true) == 0) {
            Object objValue = webContext.getGlobalValue(strDV);
            if (objValue != null) {
                return objValue.toString();
            }
            return "";
        }
        if (StringHelper.compare(strDVT, DVT_SESSION, true) == 0) {
            Object objValue = webContext.getSessionValue(strDV);
            if (objValue != null) {
                return objValue.toString();
            }
            return "";
        }
        if (StringHelper.compare(strDVT, DVT_CONTEXT, true) == 0) {
            String strValue = webContext.getPostValue(strDV);
            if (StringHelper.isNullOrEmpty(strValue)) {
                strValue = webContext.getParamValue(strDV);
            }
            return strValue;
        }
        if (StringHelper.compare(strDVT, DVT_OPERATOR, true) == 0) {
            return webContext.getCurUserId();
        }
        if (StringHelper.compare(strDVT, DVT_OPERATORNAME, true) == 0) {
            return webContext.getCurUserName();
        }
        if (StringHelper.compare(strDVT, "CURTIME", true) == 0) {
            if (StringHelper.isNullOrEmpty(strDV)) {
                return DateHelper.toDateTimeString(new Date());
            }
            return DateHelper.toDateTimeString(DefaultValueHelper.calcCurTime(strDV));
        }
        return strDV;
    }

    public static Object getValue(IWebContext webContext, String strDVT, String strDV, int nDataType, IDataObject dataEntity) throws Exception {
        if (StringHelper.length(strDVT) == 0 && StringHelper.length(strDV) == 0) {
            return null;
        }
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
            if (StringHelper.isNullOrEmpty(strValue)) {
                strValue = webContext.getParamValue(strDV);
            }
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
        if (StringHelper.compare(strDVT, "CURTIME", true) == 0) {
            if (StringHelper.isNullOrEmpty(strDV)) {
                return DataTypeHelper.parse(5, DateHelper.toDateTimeString(new Date()));
            }
            return DataTypeHelper.parse(5, DateHelper.toDateTimeString(DefaultValueHelper.calcCurTime(strDV)));
        }
        if (dataEntity != null && (StringHelper.compare(strDVT, DVT_PARAM, true) == 0 || StringHelper.compare(strDVT, PARAMTYPE_ENTITYFIELD, true) == 0)) {
            return dataEntity.get(strDV);
        }
        return DataTypeHelper.parse(nDataType, strDV);
    }

    public static Object getValue(IWebContext webContext, String strDVT, String strDV, int nDataType) throws Exception {
        return DefaultValueHelper.getValue(webContext, strDVT, strDV, nDataType, null);
    }

    public static Object getValue(IWebContext webContext, String strDVT, String strDV, String strDataType) throws Exception {
        return DefaultValueHelper.getValue(webContext, strDVT, strDV, DataTypeHelper.fromString(strDataType));
    }

    public static Date calcCurTime(String strValue) throws Exception {
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
                    DefaultValueHelper.calcDateTimeEx(cal, strCurType, strCurValue);
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
        DefaultValueHelper.calcDateTimeEx(cal, strCurType, strCurValue);
        if (parts.length > 1 && !StringHelper.isNullOrEmpty(strTimeFormat2 = parts[1])) {
            strCurType = strTimeFormat2.substring(0, 1);
            strCurValue = strTimeFormat2.substring(1);
            DefaultValueHelper.calcDateTimeEx(cal, strCurType, strCurValue);
        }
        return cal.getTime();
    }

    public static void calcDateTimeEx(Calendar cal, String strCurType, String strCurValue) {
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
}

