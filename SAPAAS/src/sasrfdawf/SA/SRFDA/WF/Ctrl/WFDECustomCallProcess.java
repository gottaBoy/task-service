/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Ctrl.ISRFWFContext
 *  SRFWF.Ctrl.SRFWFProcess
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.WF.Ctrl.WFUpdateProcess;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.SRFWFProcess;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFDECustomCallProcess
extends SRFWFProcess {
    private static final Log log = LogFactory.getLog(WFDECustomCallProcess.class);
    public static final String UPDATEMODE_ALL = "ALL";

    public CallResult Execute(ISRFWFContext context) {
        CallResult callResult = new CallResult();
        GlobalHelperEx globalHelperEx = (GlobalHelperEx)context.getContextHelper().getServletContext().getAttribute("SRFDACONTEXTHELPER");
        String strDEId = context.getCurProcessConfig().getProcessParam2("DEID", "");
        String strCustomCall = context.getCurProcessConfig().getProcessParam2("CUSTOMCALL", "");
        String strUpdateMode = context.getCurProcessConfig().getProcessParam2("UPDATEMODE", "");
        String strUpdateField = context.getCurProcessConfig().getProcessParam2("UPDATEFIELD", "");
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u5904\u7406[%1$s][%2$s]\u9700\u8981\u7684\u5b9e\u4f53\u7f16\u53f7\u53c2\u6570", (Object)WFDECustomCallProcess.class.getName(), (Object)context.getCurProcessConfig().getLogicName()));
            callResult.setRetCode(1);
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strCustomCall)) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u5904\u7406[%1$s][%2$s]\u9700\u8981\u7684\u5b9e\u4f53\u8c03\u7528\u53c2\u6570", (Object)WFDECustomCallProcess.class.getName(), (Object)context.getCurProcessConfig().getLogicName()));
            callResult.setRetCode(1);
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl iDataCtrl = globalHelperEx.getDAModelStorage().FindDEDataCtrl(strDEId, context.getCurUserId(), null);
        if (iDataCtrl == null) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
            callResult.setRetCode(1);
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        context.getActiveObject().CopyTo(dataEntity, false);
        try {
            WFUpdateProcess.FillDataEntity(context, globalHelperEx, iDataCtrl.GetDEHelper(), dataEntity);
            callResult = iDataCtrl.CustomCall(strCustomCall, dataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53[%1$s]\u81ea\u5b9a\u4e49\u5904\u7406[%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEId, (Object)strCustomCall, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (StringHelper.Compare((String)strUpdateMode, (String)UPDATEMODE_ALL, (boolean)true) == 0) {
                dataEntity.CopyTo(context.getActiveObject(), true);
            } else if (!StringHelper.IsNullOrEmpty((String)strUpdateField)) {
                dataEntity.CopyTo(context.getActiveObject(), strUpdateField, false);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38"));
            callResult.setRetCode(1);
            return callResult;
        }
        return super.Execute(context);
    }
}

