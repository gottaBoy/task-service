/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.ValueRule.IValueRuleEngine;
import SA.SRFramework.ValueRule.ValueRuleConfig;
import SA.SRFramework.ValueRule.ValueRuleEngineContext;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultValueRuleEngine
implements IValueRuleEngine {
    private static final Log log = LogFactory.getLog(DefaultValueRuleEngine.class);

    @Override
    public boolean Check(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        if (!DefaultValueRuleEngine.CheckRule(engineContext, valueRuleConfig)) {
            engineContext.setErrorMessage(DefaultValueRuleEngine.GetRuleInfo(engineContext, valueRuleConfig));
            return false;
        }
        return true;
    }

    public static String GetRuleInfo(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        if (valueRuleConfig.IsGroupValueRule()) {
            return DefaultValueRuleEngine.GetGroupRuleInfo(engineContext, valueRuleConfig);
        }
        return DefaultValueRuleEngine.GetValueRuleInfo(engineContext, valueRuleConfig);
    }

    public static String GetGroupRuleInfo(ValueRuleEngineContext engineContext, ValueRuleConfig groupRuleConfig) {
        if (StringHelper.Length((String)groupRuleConfig.getRuleInfo()) > 0) {
            return groupRuleConfig.getRuleInfo();
        }
        ArrayList ruleList = groupRuleConfig.GetRuleList();
        if (ruleList == null) {
            return "";
        }
        int nRuleInfoCount = 0;
        String strGroupRuleInfo = "";
        if (groupRuleConfig.getOpAction() == 12) {
            int nCount = ruleList.size();
            int i = 0;
            while (i < nCount) {
                ValueRuleConfig valueRuleConfig = (ValueRuleConfig)((Object)ruleList.get(i));
                String strRuleInfo = DefaultValueRuleEngine.GetRuleInfo(engineContext, valueRuleConfig);
                if (StringHelper.Length((String)strRuleInfo) != 0) {
                    ++nRuleInfoCount;
                    if (StringHelper.Length((String)strGroupRuleInfo) > 0) {
                        strGroupRuleInfo = String.valueOf(strGroupRuleInfo) + " <B>\u4e14</B> ";
                    }
                    strGroupRuleInfo = String.valueOf(strGroupRuleInfo) + strRuleInfo;
                }
                ++i;
            }
            if (nRuleInfoCount >= 2) {
                return "{ " + strGroupRuleInfo + "}";
            }
            return strGroupRuleInfo;
        }
        if (groupRuleConfig.getOpAction() == 23) {
            int nCount = ruleList.size();
            int i = 0;
            while (i < nCount) {
                ValueRuleConfig valueRuleConfig = (ValueRuleConfig)((Object)ruleList.get(i));
                String strRuleInfo = DefaultValueRuleEngine.GetRuleInfo(engineContext, valueRuleConfig);
                if (StringHelper.Length((String)strRuleInfo) != 0) {
                    ++nRuleInfoCount;
                    if (StringHelper.Length((String)strGroupRuleInfo) > 0) {
                        strGroupRuleInfo = String.valueOf(strGroupRuleInfo) + " <B>\u6216</B> ";
                    }
                    strGroupRuleInfo = String.valueOf(strGroupRuleInfo) + strRuleInfo;
                }
                ++i;
            }
            if (nRuleInfoCount >= 2) {
                return "{ " + strGroupRuleInfo + " }";
            }
            return strGroupRuleInfo;
        }
        return "";
    }

    public static String GetValueRuleInfo(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        if (StringHelper.Length((String)valueRuleConfig.getRuleInfo()) > 0) {
            return valueRuleConfig.getRuleInfo();
        }
        switch (valueRuleConfig.getOpAction()) {
            case 9: {
                if (engineContext.getValueRuleMgr() == null) {
                    log.error((Object)"\u65e0\u6548\u7684\u9884\u5b9a\u4e49\u503c\u89c4\u5219\u7ba1\u7406\u5668");
                    return "";
                }
                ValueRuleConfig groupRuleConfig = engineContext.getValueRuleMgr().GetValueRuleConfig(valueRuleConfig.getParam());
                if (groupRuleConfig != null) {
                    return DefaultValueRuleEngine.GetRuleInfo(engineContext, groupRuleConfig);
                }
                return "";
            }
            case 7: 
            case 10: 
            case 11: {
                return valueRuleConfig.getRuleInfo();
            }
        }
        if (DataTypeHelper.IsStringType((int)engineContext.getDataType())) {
            return DefaultValueRuleEngine.GetStringValueRule("", engineContext, valueRuleConfig);
        }
        return DefaultValueRuleEngine.GetNumberValueRule("", engineContext, valueRuleConfig);
    }

    public static String GetStringValueRule(String strInputName, ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        if (StringHelper.Length((String)strInputName) == 0) {
            strInputName = "\u8f93\u5165\u5185\u5bb9";
        }
        if (StringHelper.StringLength((String)valueRuleConfig.getValueFunc()) > 0) {
            if (StringHelper.Compare((String)valueRuleConfig.getValueFunc(), (String)"LENGTH", (boolean)true) == 0) {
                return DefaultValueRuleEngine.GetNumberValueRule("\u8f93\u5165\u5185\u5bb9\u957f\u5ea6", engineContext, valueRuleConfig);
            }
            return "";
        }
        String strParamInfo = DefaultValueRuleEngine.GetParamInfo(engineContext, valueRuleConfig);
        String strOpName = "";
        switch (valueRuleConfig.getOpAction()) {
            case 1: {
                strOpName = "\u5927\u4e8e";
                break;
            }
            case 2: {
                strOpName = "\u5927\u4e8e\u7b49\u4e8e";
                break;
            }
            case 3: {
                strOpName = "\u7b49\u4e8e";
                break;
            }
            case 8: {
                strOpName = "\u4e0d\u7b49\u4e8e";
                break;
            }
            case 4: {
                strOpName = "\u5c0f\u4e8e";
                break;
            }
            case 5: {
                strOpName = "\u5c0f\u4e8e\u7b49\u4e8e";
                break;
            }
            case 6: {
                strOpName = "\u6b63\u5219\u5f0f\u89c4\u5219";
                break;
            }
            default: {
                strOpName = StringHelper.Format((String)"\u4e0d\u660e\u89c4\u5219");
            }
        }
        return StringHelper.Format((String)"%1$s\u5fc5\u987b%2$s%3$s[%4$s]", (Object)strInputName, (Object)strOpName, (Object)(valueRuleConfig.getIgnoreCase() ? "(\u5ffd\u7565\u5927\u5c0f\u5199)" : ""), (Object)strParamInfo);
    }

    public static String GetNumberValueRule(String strInputName, ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        if (StringHelper.Length((String)strInputName) == 0) {
            strInputName = "\u8f93\u5165\u5185\u5bb9";
        }
        String strParamInfo = DefaultValueRuleEngine.GetParamInfo(engineContext, valueRuleConfig);
        String strOpName = "";
        switch (valueRuleConfig.getOpAction()) {
            case 1: {
                strOpName = "\u5927\u4e8e";
                break;
            }
            case 2: {
                strOpName = "\u5927\u4e8e\u7b49\u4e8e";
                break;
            }
            case 3: {
                strOpName = "\u7b49\u4e8e";
                break;
            }
            case 8: {
                strOpName = "\u4e0d\u7b49\u4e8e";
                break;
            }
            case 4: {
                strOpName = "\u5c0f\u4e8e";
                break;
            }
            case 5: {
                strOpName = "\u5c0f\u4e8e\u7b49\u4e8e";
                break;
            }
            default: {
                strOpName = StringHelper.Format((String)"\u4e0d\u660e\u89c4\u5219");
            }
        }
        return StringHelper.Format((String)"%1$s\u5fc5\u987b%2$s[%3$s]", (Object)strInputName, (Object)strOpName, (Object)strParamInfo);
    }

    public static String GetParamInfo(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        String strParamInfo = DefaultValueRuleEngine.GetRealParamInfo(engineContext, valueRuleConfig);
        if (StringHelper.Length((String)strParamInfo) > 0) {
            return "<B>" + strParamInfo + "</B>";
        }
        return "";
    }

    public static String GetRealParamInfo(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        String strParamValue = valueRuleConfig.getParam();
        if (valueRuleConfig.getParamAsFunc()) {
            if (strParamValue.compareToIgnoreCase("@@DATETIME") == 0) {
                return "\u5f53\u524d\u65f6\u95f4";
            }
            if (strParamValue.compareToIgnoreCase("@@DATE") == 0) {
                return "\u5f53\u524d\u65e5\u671f";
            }
            if (strParamValue.compareToIgnoreCase("@@TIME") == 0) {
                return "\u5f53\u524d\u65f6\u95f4\uff08\u4e0d\u542b\u65e5\u671f\uff09";
            }
            if (strParamValue.indexOf("##") == 0) {
                strParamValue = strParamValue.substring(2);
                return engineContext.GetDataEntityParamInfo(strParamValue);
            }
        }
        return strParamValue;
    }

    public static boolean CheckRule(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        engineContext.setErrorMessage("");
        if (valueRuleConfig.IsGroupValueRule()) {
            return DefaultValueRuleEngine.CheckGroupRule(engineContext, valueRuleConfig);
        }
        return DefaultValueRuleEngine.CheckValueRule(engineContext, valueRuleConfig);
    }

    public static boolean CheckGroupRule(ValueRuleEngineContext engineContext, ValueRuleConfig groupRuleConfig) {
        ArrayList ruleList = groupRuleConfig.GetRuleList();
        if (ruleList == null) {
            return false;
        }
        if (groupRuleConfig.getOpAction() == 12) {
            int nCount = ruleList.size();
            int i = 0;
            while (i < nCount) {
                ValueRuleConfig valueRuleConfig = (ValueRuleConfig)((Object)ruleList.get(i));
                if (!DefaultValueRuleEngine.CheckRule(engineContext, valueRuleConfig)) {
                    return false;
                }
                ++i;
            }
            return true;
        }
        if (groupRuleConfig.getOpAction() == 23) {
            int nCount = ruleList.size();
            int i = nCount - 1;
            while (i >= 0) {
                ValueRuleConfig valueRuleConfig = (ValueRuleConfig)((Object)ruleList.get(i));
                if (DefaultValueRuleEngine.CheckRule(engineContext, valueRuleConfig)) {
                    return true;
                }
                --i;
            }
            return false;
        }
        return false;
    }

    public static boolean CheckValueRule(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        switch (valueRuleConfig.getOpAction()) {
            case 9: {
                if (engineContext.getValueRuleMgr() == null) {
                    log.error((Object)"\u65e0\u6548\u7684\u9884\u5b9a\u4e49\u503c\u89c4\u5219\u7ba1\u7406\u5668");
                    return false;
                }
                ValueRuleConfig groupRuleConfig = engineContext.getValueRuleMgr().GetValueRuleConfig(valueRuleConfig.getParam());
                if (groupRuleConfig == null) {
                    log.error((Object)StringHelper.Format((String)"\u9884\u5b9a\u4e49\u503c\u89c4\u5219\u914d\u7f6e[%1$s]\u65e0\u6548", (Object)valueRuleConfig.getParam()));
                    return false;
                }
                return DefaultValueRuleEngine.CheckRule(engineContext, groupRuleConfig);
            }
            case 7: {
                if (StringHelper.Length((String)valueRuleConfig.getParam()) == 0) {
                    log.error((Object)"\u81ea\u5b9a\u4e49\u7684\u503c\u89c4\u5219\u68c0\u67e5\u7f3a\u4e4f\u5bf9\u8c61\u7684\u5b9a\u4e49");
                    return false;
                }
                Object objChecker = ObjectHelper.Create(valueRuleConfig.getParam());
                if (objChecker == null) {
                    log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u7684\u503c\u89c4\u5219\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)valueRuleConfig.getParam()));
                    return false;
                }
                if (objChecker instanceof IValueRuleEngine) {
                    IValueRuleEngine iValueRuleEngine = (IValueRuleEngine)objChecker;
                    return iValueRuleEngine.Check(engineContext, valueRuleConfig);
                }
                log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u7684\u503c\u89c4\u5219\u5bf9\u8c61[%1$s]\u672a\u5305\u542b\u63a5\u53e3[IValueRuleEngine]", (Object)valueRuleConfig.getParam()));
                return false;
            }
            case 10: {
                Object destObj = DefaultValueRuleEngine.getDataEntityParam(engineContext, valueRuleConfig);
                return destObj == null;
            }
            case 11: {
                Object destObj = DefaultValueRuleEngine.getDataEntityParam(engineContext, valueRuleConfig);
                return destObj != null;
            }
        }
        if (DataTypeHelper.IsStringType((int)engineContext.getDataType())) {
            return DefaultValueRuleEngine.CheckStringValueRule(engineContext, valueRuleConfig);
        }
        return DefaultValueRuleEngine.CheckNumberValueRule(engineContext, valueRuleConfig);
    }

    public static boolean CheckStringValueRule(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        if (StringHelper.StringLength((String)valueRuleConfig.getValueFunc()) > 0) {
            if (StringHelper.Compare((String)valueRuleConfig.getValueFunc(), (String)"LENGTH", (boolean)true) == 0) {
                int nLength = engineContext.getValue().toString().length();
                Object destObj = DefaultValueRuleEngine.GetParamValue(9, engineContext, valueRuleConfig);
                if (destObj == null) {
                    return false;
                }
                return DefaultValueRuleEngine.CheckNumberValueRule(9, nLength, destObj, valueRuleConfig.getOpAction());
            }
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26\u4e32\u503c\u5904\u7406[%1$s]", (Object)valueRuleConfig.getValueFunc()));
            return false;
        }
        Object destObj = DefaultValueRuleEngine.GetParamValue(engineContext.getDataType(), engineContext, valueRuleConfig);
        if (destObj == null) {
            return false;
        }
        if (valueRuleConfig.getIgnoreCase()) {
            return DefaultValueRuleEngine.CheckStringValueRule(engineContext.getValue().toString().toLowerCase(), destObj.toString().toLowerCase(), valueRuleConfig.getOpAction());
        }
        return DefaultValueRuleEngine.CheckStringValueRule(engineContext.getValue().toString(), destObj.toString(), valueRuleConfig.getOpAction());
    }

    public static boolean CheckStringValueRule(String strSrc, String strDest, int nOp) {
        switch (nOp) {
            case 1: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) == 1L;
            }
            case 2: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) >= 0L;
            }
            case 3: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) == 0L;
            }
            case 8: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) != 0L;
            }
            case 4: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) == -1L;
            }
            case 5: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) <= 0L;
            }
            case 6: {
                log.warn((Object)"\u503c\u89c4\u5219\u5f15\u64ce\u76ee\u524d\u4e0d\u652f\u6301\u6b63\u5219\u5f0f\u89c4\u5219");
                return false;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26\u4e32\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOp));
        return false;
    }

    public static boolean CheckNumberValueRule(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        Object destObj = DefaultValueRuleEngine.GetParamValue(engineContext.getDataType(), engineContext, valueRuleConfig);
        if (destObj == null) {
            return false;
        }
        return DefaultValueRuleEngine.CheckNumberValueRule(engineContext.getDataType(), engineContext.getValue(), destObj, valueRuleConfig.getOpAction());
    }

    public static boolean CheckNumberValueRule(int nDataType, Object objSrc, Object objDest, int nOp) {
        switch (nOp) {
            case 1: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) == 1L;
            }
            case 2: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) >= 0L;
            }
            case 3: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) == 0L;
            }
            case 8: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) != 0L;
            }
            case 4: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) == -1L;
            }
            case 5: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) <= 0L;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u503c\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOp));
        return false;
    }

    public static Object GetParamValue(int nDataType, ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        String strParamValue = valueRuleConfig.getParam();
        if (valueRuleConfig.getParamAsFunc()) {
            try {
                if (strParamValue.compareToIgnoreCase("@@DATETIME") == 0) {
                    return DataTypeParse.Parse((int)5, (String)DateParser.toDateTimeString((Date)new Date()));
                }
                if (strParamValue.compareToIgnoreCase("@@DATE") == 0) {
                    return DataTypeParse.Parse((int)27, (String)DateParser.toDateString((Date)new Date()));
                }
                if (strParamValue.compareToIgnoreCase("@@TIME") == 0) {
                    return DataTypeParse.Parse((int)28, (String)DateParser.toTimeString((Date)new Date()));
                }
                if (strParamValue.indexOf("##") == 0) {
                    strParamValue = strParamValue.substring(2);
                    if (engineContext.getDataEntity() == null) {
                        log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)strParamValue));
                        return false;
                    }
                    return engineContext.getDataEntity().GetParamValue(strParamValue);
                }
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                return false;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue), (Throwable)ex);
                return false;
            }
        }
        Object objValue = DataTypeParse.Parse((int)nDataType, (String)strParamValue);
        if (objValue == null) {
            log.error((Object)StringHelper.Format((String)"\u8ba1\u7b97\u53c2\u6570\u503c[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strParamValue));
        }
        return objValue;
    }

    public static Object getDataEntityParam(ValueRuleEngineContext engineContext, ValueRuleConfig valueRuleConfig) {
        String strParamValue = valueRuleConfig.getParam();
        if (strParamValue.indexOf("##") == 0) {
            strParamValue = strParamValue.substring(2);
            if (engineContext.getDataEntity() == null) {
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)strParamValue));
                return null;
            }
            return engineContext.getDataEntity().GetParamValue(strParamValue);
        }
        return null;
    }
}

