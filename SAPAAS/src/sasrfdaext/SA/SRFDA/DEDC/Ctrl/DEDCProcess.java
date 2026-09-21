/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessConfig
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.DEDC.Ctrl.BaseDEDCProcess;
import SA.SRFDA.DEDC.Ctrl.DEDCGrooveEngine;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;

public abstract class DEDCProcess
extends BaseDEDCProcess {
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        DEDCProcessConfig realProcessConfig = (DEDCProcessConfig)processConfig;
        dedcContext.setNext(realProcessConfig.getNext());
        return new CallResult();
    }

    protected CallResult FillDataEntity(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig, BaseDataEntity srcDataEntity, BaseDataEntity dstDataEntity) {
        Enumeration<Object> en;
        CallResult callResult = new CallResult();
        Properties properties = processConfig.getDEDCProcess().getParams();
        if (properties == null) {
            return callResult;
        }
        IDEHelper iDEHelper = null;
        String strDEId = processConfig.getDEDCProcess().getDEID();
        if (!StringHelper.IsNullOrEmpty((String)strDEId)) {
            iDEHelper = dedcContext.GetGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                return callResult;
            }
        } else {
            iDEHelper = dedcContext.GetDEHelper();
        }
        if ((en = properties.keys()).hasMoreElements()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5f00\u59cb\u8bbe\u7f6e\u6570\u636e\u5bf9\u8c61\u53c2\u6570"));
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5f53\u524d\u5b9e\u4f53\u5bf9\u8c61[%1$s][%2$s]", (Object)iDEHelper.getId(), (Object)iDEHelper.getName()));
        }
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (StringHelper.Compare((String)"%%SRFREMOVE()%%", (String)strValue, (boolean)true) == 0 || StringHelper.Compare((String)"%%SRFREMOVE%%", (String)strValue, (boolean)true) == 0) {
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u79fb\u9664\u53d8\u91cf[%1$s]", (Object)strKey));
                dstDataEntity.RemoveParam(strKey);
                continue;
            }
            callResult = MacroHelper.GetValue((String)strValue, (ISRFDAWebContext)dedcContext.GetWebContext(), (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)srcDataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                return callResult;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8bbe\u7f6e\u53d8\u91cf[%1$s]\u4e3a\u7a7a\u503c", (Object)strKey));
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8bbe\u7f6e\u53d8\u91cf[%1$s]\u4e3a\u7a7a\u503c", (Object)strKey));
                    dstDataEntity.SetParamValue(strKey, null);
                    continue;
                }
                IDEFHelper iDEFHelper = null;
                if (iDEHelper != null) {
                    iDEFHelper = iDEHelper.GetDEFHelper(strKey);
                }
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                    callResult.setRetCode(1);
                    dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                    return callResult;
                }
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8bbe\u7f6e\u53d8\u91cf[%1$s]\u4e3a[%2$s]", (Object)strKey, (Object)obj));
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8bbe\u7f6e\u53d8\u91cf[%1$s]\u4e3a[%2$s]", (Object)strKey, (Object)obj));
            dstDataEntity.SetParamValue(strKey, obj);
        }
        return callResult;
    }

    protected CallResult FillDataEntityEx(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = new CallResult();
        String strScipt = processConfig.getDEDCProcess().getSCRIPT();
        if (StringHelper.IsNullOrEmpty((String)strScipt)) {
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6267\u884c\u811a\u672c\r\n{\r\n%1$s\r\n}", (Object)strScipt));
        DEDCGrooveEngine dedcGrooveEngine = new DEDCGrooveEngine();
        return dedcGrooveEngine.Eval(dedcContext, strScipt);
    }
}

