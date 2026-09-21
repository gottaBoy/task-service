/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SRFWF.Ctrl.ISRFWFContext
 *  SRFWF.Ctrl.SRFWFProcess
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.WF.Data.DAWFDataCtrl;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.SRFWFProcess;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFUpdateProcess
extends SRFWFProcess {
    private static final Log log = LogFactory.getLog(WFUpdateProcess.class);
    public static final String TAG_ACTIONMODE = "SRFACTIONMODE";

    public CallResult Execute(ISRFWFContext context) {
        CallResult callResult = new CallResult();
        GlobalHelperEx globalHelperEx = (GlobalHelperEx)context.getContextHelper().getServletContext().getAttribute("SRFDACONTEXTHELPER");
        IDEHelper iUserDEHelper = WFUpdateProcess.GetUserDataDEHelper(context, context.GetWorkflowId());
        if (iUserDEHelper == null) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u5bf9\u5e94\u7684\u7528\u6237\u6570\u636e\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)context.GetWorkflowId()));
            callResult.setRetCode(1);
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strKeyName = iUserDEHelper.GetKeyDEFHelper().getName();
        DEWF dewf = iUserDEHelper.GetDEWF();
        if (dewf == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e\u4fe1\u606f", (Object)iUserDEHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(strKeyName, context.getActiveObject().GetParamValue(strKeyName));
        String strDBActionMode = PropertiesHelper.GetProperty((Properties)dewf.getWFParams(), (String)"UPDATEACTIONMODE", (String)"WFACTION");
        try {
            strDBActionMode = context.getCurProcessConfig().getProcessParam(TAG_ACTIONMODE, strDBActionMode);
            WFUpdateProcess.FillDataEntity(context, globalHelperEx, iUserDEHelper, dataEntity);
            IDEDataCtrl iUserDEDataCtrl = iUserDEHelper.GetDEDataCtrl(context.getCurUserId(), null);
            if (iUserDEDataCtrl == null) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iUserDEHelper.GetFullName()));
                callResult.setRetCode(1);
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = iUserDEDataCtrl.Save(false, strDBActionMode, dataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.CopyTo(context.getActiveObject(), true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38"));
            callResult.setRetCode(1);
            return callResult;
        }
        return super.Execute(context);
    }

    public static IDEHelper GetUserDataDEHelper(ISRFWFContext context, String strWorkflowId) {
        DAWFDataCtrl daWFDataCtrl = new DAWFDataCtrl();
        daWFDataCtrl.Init(context.getContextHelper().getServletContext(), context.getDBCallerHelperEx());
        return daWFDataCtrl.GetUserDataDEHelper(strWorkflowId, context.getInstance().getUSERDATA4());
    }

    public static CallResult FillDataEntity(ISRFWFContext context, GlobalHelperEx globalHelperEx, IDEHelper iUserDEHelper, BaseDataEntity dataEntity) throws Exception {
        CallResult callResult = new CallResult();
        Properties properties = PropertiesHelper.Load((String)context.getCurProcessConfig().getParams());
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            IDEFHelper iDEFHelper = iUserDEHelper.GetDEFHelper(strKey);
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (MacroHelper.isRemoveFunc((String)strValue)) {
                dataEntity.RemoveParam(strKey);
                continue;
            }
            callResult = MacroHelper.GetValue((String)strValue, (ISRFDAGlobalHelper)globalHelperEx, (String)context.getCurUserId(), (BaseDataEntity)context.getActiveObject());
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                log.error((Object)callResult.getErrorInfo());
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
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                    callResult.setRetCode(1);
                    log.error((Object)callResult.getErrorInfo());
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

