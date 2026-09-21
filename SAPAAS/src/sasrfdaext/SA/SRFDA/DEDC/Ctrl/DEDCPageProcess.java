/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;

public abstract class DEDCPageProcess
extends DEDCProcess {
    protected static CallResult FillWebContext(IDEDataCtrlEngineContext dedcContext, String strParamId, DEDCBaseProcessConfig processConfig, BaseDataEntity srcDataEntity) {
        CallResult callResult = new CallResult();
        Properties properties = processConfig.getDEDCProcess().getParams(strParamId);
        if (properties == null) {
            return callResult;
        }
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (MacroHelper.isRemoveFunc((String)strValue)) {
                dedcContext.DebugOutput(null, StringHelper.Format((String)"\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u79fb\u9664\u5c5e\u6027[%1$s]", (Object)strKey));
                dedcContext.GetWebContext().RemoveParam(strKey);
                continue;
            }
            callResult = MacroHelper.GetValue((String)strValue, (ISRFDAWebContext)dedcContext.GetWebContext(), (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)srcDataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                dedcContext.Log(1, (Object)dedcContext, callResult.getErrorInfo());
                return callResult;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                dedcContext.GetWebContext().SetParamValue(strKey, "");
                dedcContext.DebugOutput(null, StringHelper.Format((String)"\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u8bbe\u7f6e\u5c5e\u6027[%1$s]\u503c\u4e3a[]", (Object)strKey));
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    dedcContext.GetWebContext().SetParamValue(strKey, "");
                    dedcContext.DebugOutput(null, StringHelper.Format((String)"\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u8bbe\u7f6e\u5c5e\u6027[%1$s]\u503c\u4e3a[]", (Object)strKey));
                    continue;
                }
                dedcContext.GetWebContext().SetParamValue(strKey, obj.toString());
                dedcContext.DebugOutput(null, StringHelper.Format((String)"\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u8bbe\u7f6e\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strKey, (Object)obj));
                continue;
            }
            dedcContext.GetWebContext().SetParamValue(strKey, obj.toString());
            dedcContext.DebugOutput(null, StringHelper.Format((String)"\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61\u8bbe\u7f6e\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strKey, (Object)obj));
        }
        return callResult;
    }

    protected static CallResult FillPageParam(IDEDataCtrlEngineContext dedcContext, String strParamId, DEDCBaseProcessConfig processConfig, BaseDataEntity srcDataEntity) {
        CallResult callResult = new CallResult();
        Properties properties = processConfig.getDEDCProcess().getParams(strParamId);
        if (properties == null) {
            return callResult;
        }
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (MacroHelper.isRemoveFunc((String)strValue)) {
                dedcContext.DebugOutput(null, StringHelper.Format((String)"\u9875\u9762\u53c2\u6570\u79fb\u9664\u5c5e\u6027[%1$s]", (Object)strKey));
                dedcContext.GetPage().removePageParam(strKey);
                continue;
            }
            callResult = MacroHelper.GetValue((String)strValue, (ISRFDAWebContext)dedcContext.GetWebContext(), (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)srcDataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                dedcContext.Log(1, (Object)dedcContext, callResult.getErrorInfo());
                return callResult;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                dedcContext.DebugOutput(null, StringHelper.Format((String)"\u9875\u9762\u53c2\u6570\u8bbe\u7f6e\u5c5e\u6027[%1$s]\u503c\u4e3a\u7a7a", (Object)strKey));
                dedcContext.GetPage().setPageParam(strKey, null);
                continue;
            }
            dedcContext.DebugOutput(null, StringHelper.Format((String)"\u9875\u9762\u53c2\u6570\u8bbe\u7f6e\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strKey, (Object)obj));
            dedcContext.GetPage().setPageParam(strKey, obj);
        }
        return callResult;
    }
}

