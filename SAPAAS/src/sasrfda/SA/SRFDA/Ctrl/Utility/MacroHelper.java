/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Utility;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.DEFMacroParam;
import SA.SRFDA.Ctrl.Utility.DEFMacroParamRemoveHtml;
import SA.SRFDA.Ctrl.Utility.SYSMacroParam;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MacroHelper {
    private static final Log log = LogFactory.getLog(MacroHelper.class);
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

    public static CallResult GetValue(String strFunc, ISRFDAWebContext webContext) {
        return MacroHelper.GetValue(strFunc, webContext, webContext.getGlobalHelper(), webContext.getCurUserId(), null);
    }

    public static CallResult GetValue(String strFunc, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity dataEntity) {
        return MacroHelper.GetValue(strFunc, null, globalHelperEx, strCurPersonId, dataEntity);
    }

    public static CallResult GetValue(String strFunc, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity dataEntity) {
        if (!MacroHelper.isSRFFunc(strFunc)) {
            return MacroHelper.Return(strFunc);
        }
        Vector<String> argList = new Vector<String>();
        String strFuncName = MacroHelper.ParseSRFFunc(strFunc, argList);
        if (StringHelper.IsNullOrEmpty((String)strFuncName)) {
            return MacroHelper.Return("");
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDATE, (boolean)true) == 0) {
            String strFormat = "%1$tY-%1$tm-%1$td";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            return MacroHelper.Return(StringHelper.Format((String)strFormat, (Object)new java.util.Date()));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDATETIME, (boolean)true) == 0) {
            String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            java.util.Date date = new java.util.Date();
            return MacroHelper.Return(StringHelper.Format((String)strFormat, (Object)date));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFTIME, (boolean)true) == 0) {
            String strFormat = "%1$tH:%1$tM:%1$tS";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            return MacroHelper.Return(StringHelper.Format((String)strFormat, (Object)new java.util.Date()));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFOPPERSON, (boolean)true) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)strCurPersonId)) {
                return MacroHelper.Return(strCurPersonId);
            }
            if (webContext != null) {
                return MacroHelper.Return(webContext.getCurUserId());
            }
            return MacroHelper.Return(strCurPersonId);
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFGV, (boolean)true) == 0) {
            if (webContext == null && globalHelperEx == null) {
                log.error((Object)"\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u53ca\u5168\u5c40\u5bf9\u8c61\u65e0\u6548");
                return MacroHelper.Return(5, "\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u53ca\u5168\u5c40\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            if (webContext != null) {
                return MacroHelper.Return(webContext.GetGlobalValue(strFieldName));
            }
            return MacroHelper.Return(globalHelperEx.GetGlobalValue(strFieldName));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFSV, (boolean)true) == 0) {
            if (webContext == null) {
                log.error((Object)"\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
                return MacroHelper.Return(5, "\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            return MacroHelper.Return(webContext.GetSessionValue(strFieldName));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFUV, (boolean)true) == 0) {
            if (webContext == null) {
                log.error((Object)"\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
                return MacroHelper.Return(5, "\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            String strValue = webContext.GetParamValue(strFieldName);
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = webContext.GetPostValue(strFieldName.toLowerCase());
            }
            return MacroHelper.Return(strValue);
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFREG, (boolean)true) == 0) {
            if (globalHelperEx == null) {
                log.error((Object)"\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
                return MacroHelper.Return(5, "\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
            }
            String strRegPath = "";
            if (argList.size() > 0) {
                strRegPath = argList.get(0);
            }
            String strDefault = "";
            if (argList.size() >= 2) {
                strDefault = argList.get(1);
            }
            if (StringHelper.IsNullOrEmpty((String)strRegPath)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u6ce8\u518c\u8868\u8def\u5f84");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u6ce8\u518c\u8868\u8def\u5f84");
            }
            return MacroHelper.Return(globalHelperEx.getRegisterMgr().GetRegistryParam(strRegPath, strDefault));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVINT, (boolean)true) == 0 || StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVDATE, (boolean)true) == 0 || StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVDOUBLE, (boolean)true) == 0 || StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVFLOAT, (boolean)true) == 0) {
            if (webContext == null) {
                log.error((Object)"\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
                return MacroHelper.Return(5, "\u9519\u8bef:\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            String strValue = "";
            strValue = webContext.GetParamValue(strFieldName);
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = webContext.GetPostValue(strFieldName.toLowerCase());
            }
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                return MacroHelper.Return(null);
            }
            if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVINT, (boolean)true) == 0) {
                return MacroHelper.Return(DataTypeParse.TestInteger((String)strValue));
            }
            if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVDATE, (boolean)true) == 0) {
                Object objValue = DataTypeParse.TestDateTime((String)strValue);
                if (objValue != null && objValue instanceof Timestamp && argList.size() >= 2 && StringHelper.Compare((String)argList.get(1), (String)"ENDOFDAY", (boolean)true) == 0) {
                    Timestamp endTime = (Timestamp)objValue;
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(new java.util.Date(endTime.getTime()));
                    cal.set(11, 23);
                    cal.set(12, 59);
                    cal.set(13, 59);
                    endTime.setTime(cal.getTime().getTime());
                    return MacroHelper.Return(endTime);
                }
                return MacroHelper.Return(objValue);
            }
            if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVDOUBLE, (boolean)true) == 0) {
                return MacroHelper.Return(DataTypeParse.TestDouble((String)strValue));
            }
            if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFUVFLOAT, (boolean)true) == 0) {
                return MacroHelper.Return(DataTypeParse.TestFloat((String)strValue));
            }
            return MacroHelper.Return(null);
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDEF, (boolean)true) == 0) {
            if (dataEntity == null) {
                log.error((Object)"\u9519\u8bef:\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
            }
            String strFieldName = "";
            int nDataType = 0;
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (argList.size() >= 2) {
                nDataType = DataTypeHelper.FromString((String)argList.get(1));
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            Object objValue = dataEntity.GetParamValue(strFieldName);
            if (objValue == null) {
                if (argList.size() >= 3 && nDataType != 0) {
                    return MacroHelper.Return(DataTypeParse.Parse((int)nDataType, (String)argList.get(2)));
                }
                return MacroHelper.Return(null);
            }
            if (nDataType == 0) {
                return MacroHelper.Return(objValue);
            }
            switch (nDataType) {
                case 5: {
                    if (objValue instanceof String) {
                        return MacroHelper.Return(DataTypeParse.TestDateTime((String)((String)objValue)));
                    }
                    return MacroHelper.Return(new Timestamp(DataTypeParse.GetDateObjectTime((Object)objValue)));
                }
                case 27: {
                    if (objValue instanceof String) {
                        return MacroHelper.Return(DataTypeParse.TestDate((String)((String)objValue)));
                    }
                    return MacroHelper.Return(new Date(DataTypeParse.GetDateObjectTime((Object)objValue)));
                }
            }
            return MacroHelper.Return(objValue);
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFUD, (boolean)true) == 0) {
            String strFieldName;
            if (webContext != null) {
                strFieldName = "";
                if (argList.size() > 0) {
                    strFieldName = argList.get(0);
                }
                if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                    log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                    return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                }
                String strValue = webContext.GetParamValue(strFieldName);
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    strValue = webContext.GetPostValue(strFieldName.toLowerCase());
                }
                if (!StringHelper.IsNullOrEmpty((String)strValue)) {
                    return MacroHelper.Return(strValue);
                }
            }
            if (dataEntity != null) {
                strFieldName = "";
                int nDataType = 0;
                if (argList.size() > 0) {
                    strFieldName = argList.get(0);
                }
                if (argList.size() >= 2) {
                    nDataType = DataTypeHelper.FromString((String)argList.get(1));
                }
                if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                    log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                    return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                }
                Object objValue = dataEntity.GetParamValue(strFieldName);
                if (objValue == null) {
                    if (argList.size() >= 3 && nDataType != 0) {
                        return MacroHelper.Return(DataTypeParse.Parse((int)nDataType, (String)argList.get(2)));
                    }
                    return MacroHelper.Return(null);
                }
                if (nDataType == 0) {
                    return MacroHelper.Return(objValue);
                }
                switch (nDataType) {
                    case 5: {
                        if (objValue instanceof String) {
                            return MacroHelper.Return(DataTypeParse.TestDateTime((String)((String)objValue)));
                        }
                        return MacroHelper.Return(new Timestamp(DataTypeParse.GetDateObjectTime((Object)objValue)));
                    }
                    case 27: {
                        if (objValue instanceof String) {
                            return MacroHelper.Return(DataTypeParse.TestDate((String)((String)objValue)));
                        }
                        return MacroHelper.Return(new Date(DataTypeParse.GetDateObjectTime((Object)objValue)));
                    }
                }
                return MacroHelper.Return(objValue);
            }
            log.error((Object)"\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u53ca\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
            return MacroHelper.Return(5, "\u9519\u8bef:\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u53ca\u6570\u636e\u5bf9\u8c61\u65e0\u6548");
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFV, (boolean)true) == 0) {
            if (argList.size() == 0) {
                log.error((Object)"\u9519\u8bef:\u53c2\u6570\u503c\u65e0\u6548");
                return MacroHelper.Return(5, "\u9519\u8bef:\u53c2\u6570\u503c\u65e0\u6548");
            }
            String strValue = argList.get(0);
            String strDataType = "VARCHAR";
            if (argList.size() >= 2) {
                strDataType = argList.get(1);
            }
            return MacroHelper.Return(DataTypeParse.Parse((String)strDataType, (String)strValue));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFTD, (boolean)true) == 0) {
            String strDTType = "";
            int nAddTime = 0;
            if (argList.size() > 0) {
                strDTType = argList.get(0);
            }
            if (argList.size() > 1) {
                nAddTime = Integer.parseInt(argList.get(1));
            }
            Calendar cal = Calendar.getInstance();
            if (StringHelper.Compare((String)"YM", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(2, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"M%1$tY%1$tm", (Object)cal.getTime()));
            }
            if (StringHelper.Compare((String)"YMD", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(2, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"D%1$tY%1$tm%1$td", (Object)cal.getTime()));
            }
            if (StringHelper.Compare((String)"YMDH", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(11, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"H%1$tY%1$tm%1$td%1$tH", (Object)cal.getTime()));
            }
            if (StringHelper.Compare((String)"YMW", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(4, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"W%1$tY%1$tm%2$s", (Object)cal.getTime(), (Object)cal.get(4)));
            }
            if (StringHelper.Compare((String)"YMWD", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(8, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"O%1$tY%1$tm%2$s%3$s", (Object)cal.getTime(), (Object)cal.get(4), (Object)cal.get(8)));
            }
            if (StringHelper.Compare((String)"YMWDH", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(11, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"P%1$tY%1$tm%2$s%3$s%1$tH", (Object)cal.getTime(), (Object)cal.get(4), (Object)cal.get(8)));
            }
            if (StringHelper.Compare((String)"YW", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(3, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"Z%1$tY%2$02d", (Object)cal.getTime(), (Object)cal.get(3)));
            }
            if (StringHelper.Compare((String)"YWD", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(7, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"R%1$tY%2$02d%3$s", (Object)cal.getTime(), (Object)cal.get(3), (Object)cal.get(7)));
            }
            if (StringHelper.Compare((String)"YWDH", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(11, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"S%1$tY%2$02d%3$s%1$tH", (Object)cal.getTime(), (Object)cal.get(3), (Object)cal.get(7)));
            }
            log.error((Object)StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u8bc6\u522b\u7684\u65f6\u95f4\u7ef4\u5ea6\u7c7b\u578b[%1$s]", (Object)strDTType));
            return MacroHelper.Return(5, StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u8bc6\u522b\u7684\u7c7b\u578b[%1$s]", (Object)strDTType));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDATETIMEEX, (boolean)true) == 0) {
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
                        MacroHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
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
            MacroHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            if (argList.size() > 1 && !StringHelper.IsNullOrEmpty((String)(strTimeFormat2 = argList.get(1)))) {
                strCurType = strTimeFormat2.substring(0, 1);
                strCurValue = strTimeFormat2.substring(1);
                MacroHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            }
            String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
            return MacroHelper.Return(StringHelper.Format((String)strFormat, (Object)cal.getTime()));
        }
        return MacroHelper.Return(strFunc);
    }

    private static CallResult Return(Object objValue) {
        CallResult callResult = new CallResult();
        callResult.setUserObject(objValue);
        return callResult;
    }

    private static CallResult Return(int nError, String strError) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(nError);
        callResult.setErrorInfo(strError);
        return callResult;
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
        if (StringHelper.IsNullOrEmpty((String)(strParams = strParams.trim()))) {
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
        return StringHelper.Compare((String)strFunc, (String)TAG_SRFREMOVE, (boolean)true) == 0 || StringHelper.Compare((String)strFunc, (String)TAG_SRFREMOVE2, (boolean)true) == 0;
    }

    public static void FillMacroParams(Map<String, Object> params, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, IDEHelper iDEHelper, BaseDataEntity dataEntity, String strLanguage) {
        if (dataEntity != null) {
            DEFMacroParam macroParam = new DEFMacroParam();
            macroParam.setDataEntity(dataEntity);
            macroParam.setDEHelper(iDEHelper);
            macroParam.setLanguage(strLanguage);
            params.put("def", macroParam);
            DEFMacroParamRemoveHtml macroParam2 = new DEFMacroParamRemoveHtml();
            macroParam2.setDataEntity(dataEntity);
            params.put("defnohtm", macroParam2);
        }
        params.put("macro", new SYSMacroParam(webContext, globalHelperEx, strCurPersonId, dataEntity));
    }

    public static void FillDEMacroParams(Map<String, Object> params, String strMacroName, IDEHelper iDEHelper, BaseDataEntity dataEntity, String strLanguage) {
        if (dataEntity != null) {
            DEFMacroParam macroParam = new DEFMacroParam();
            macroParam.setDataEntity(dataEntity);
            macroParam.setDEHelper(iDEHelper);
            macroParam.setLanguage(strLanguage);
            params.put(strMacroName, macroParam);
            DEFMacroParamRemoveHtml macroParam2 = new DEFMacroParamRemoveHtml();
            macroParam2.setDataEntity(dataEntity);
            params.put(String.valueOf(strMacroName) + "nohtm", macroParam2);
        }
    }

    public static CallResult GetFormItemRuleArg(String strFunc, boolean bBackend) {
        Vector<String> argList = new Vector<String>();
        String strFuncName = MacroHelper.ParseSRFFunc(strFunc, argList);
        if (StringHelper.IsNullOrEmpty((String)strFuncName)) {
            return MacroHelper.Return(null);
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFOPPERSON, (boolean)true) == 0) {
            return MacroHelper.Return(StringHelper.Format((String)"dp.CurOPPerson()"));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFSV, (boolean)true) == 0) {
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            return MacroHelper.Return(StringHelper.Format((String)"dp.SV('%1$s')", (Object)strFieldName));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDEF, (boolean)true) == 0) {
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                log.error((Object)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
                return MacroHelper.Return(5, "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
            }
            return MacroHelper.Return(StringHelper.Format((String)"dp.Val('%1$s')", (Object)strFieldName));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFTD, (boolean)true) == 0) {
            String strDTType = "";
            int nAddTime = 0;
            if (argList.size() > 0) {
                strDTType = argList.get(0);
            }
            if (argList.size() > 1) {
                nAddTime = Integer.parseInt(argList.get(1));
            }
            Calendar cal = Calendar.getInstance();
            if (StringHelper.Compare((String)"YM", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(2, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"M%1$tY%1$tm", (Object)cal.getTime()));
            }
            if (StringHelper.Compare((String)"YMD", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(2, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"D%1$tY%1$tm%1$td", (Object)cal.getTime()));
            }
            if (StringHelper.Compare((String)"YMDH", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(11, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"H%1$tY%1$tm%1$td%1$tH", (Object)cal.getTime()));
            }
            if (StringHelper.Compare((String)"YMW", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(4, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"W%1$tY%1$tm%2$s", (Object)cal.getTime(), (Object)cal.get(4)));
            }
            if (StringHelper.Compare((String)"YMWD", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(8, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"O%1$tY%1$tm%2$s%3$s", (Object)cal.getTime(), (Object)cal.get(4), (Object)cal.get(8)));
            }
            if (StringHelper.Compare((String)"YMWDH", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(11, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"P%1$tY%1$tm%2$s%3$s%1$tH", (Object)cal.getTime(), (Object)cal.get(4), (Object)cal.get(8)));
            }
            if (StringHelper.Compare((String)"YW", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(3, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"Z%1$tY%2$02d", (Object)cal.getTime(), (Object)cal.get(3)));
            }
            if (StringHelper.Compare((String)"YWD", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(7, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"R%1$tY%2$02d%3$s", (Object)cal.getTime(), (Object)cal.get(3), (Object)cal.get(7)));
            }
            if (StringHelper.Compare((String)"YWDH", (String)strDTType, (boolean)true) == 0) {
                if (nAddTime != 0) {
                    cal.add(11, nAddTime);
                }
                return MacroHelper.Return(StringHelper.Format((String)"S%1$tY%2$02d%3$s%1$tH", (Object)cal.getTime(), (Object)cal.get(3), (Object)cal.get(7)));
            }
            log.error((Object)StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u8bc6\u522b\u7684\u65f6\u95f4\u7ef4\u5ea6\u7c7b\u578b[%1$s]", (Object)strDTType));
            return MacroHelper.Return(5, StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u8bc6\u522b\u7684\u7c7b\u578b[%1$s]", (Object)strDTType));
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDATETIMEEX, (boolean)true) == 0) {
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
                        MacroHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
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
            MacroHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            if (argList.size() > 1 && !StringHelper.IsNullOrEmpty((String)(strTimeFormat2 = argList.get(1)))) {
                strCurType = strTimeFormat2.substring(0, 1);
                strCurValue = strTimeFormat2.substring(1);
                MacroHelper.CalcDateTimeEx(cal, strCurType, strCurValue);
            }
            String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
            return MacroHelper.Return(StringHelper.Format((String)strFormat, (Object)cal.getTime()));
        }
        return MacroHelper.Return(null);
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

    public static CallResult FillDataEntity(IDEHelper iDEHelper, Properties properties, BaseDataEntity dataEntity, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity srcDataEntity) {
        CallResult callResult = new CallResult();
        if (properties == null) {
            return callResult;
        }
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (StringHelper.Compare((String)TAG_SRFREMOVE2, (String)strValue, (boolean)true) == 0 || StringHelper.Compare((String)TAG_SRFREMOVE, (String)strValue, (boolean)true) == 0) {
                dataEntity.RemoveParam(strKey);
                continue;
            }
            callResult = MacroHelper.GetValue(strValue, webContext, globalHelperEx, strCurPersonId, srcDataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                return callResult;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                dataEntity.SetParamValue(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    dataEntity.SetParamValue(strKey, null);
                    continue;
                }
                IDEFHelper iDEFHelper = null;
                if (iDEHelper != null) {
                    iDEFHelper = iDEHelper.GetDEFHelper(strKey);
                }
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                    callResult.setRetCode(1);
                    return callResult;
                }
                dataEntity.SetParamValue(strKey, obj);
                continue;
            }
            dataEntity.SetParamValue(strKey, obj);
        }
        return callResult;
    }
}

