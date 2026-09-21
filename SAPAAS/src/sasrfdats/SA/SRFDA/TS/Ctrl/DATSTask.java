/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFTS.Ctrl.ISRFTSTaskContext
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.TS.Ctrl.BaseDATSTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFTS.Ctrl.ISRFTSTaskContext;

public class DATSTask
extends BaseDATSTask {
    public CallResult Run(ISRFTSTaskContext context) {
        IDEDataCtrl iDEDataCtrl;
        CallResult callResult = new CallResult();
        ISRFDAGlobalHelper iDAGlobalHelper = DATSTask.GetGlobalHelper(context);
        String strDEId = context.getTaskItem().getTaskParam("DEID", "");
        String strCustomCall = context.getTaskItem().getTaskParam("CUSTOMCALL", "");
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7"));
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strCustomCall)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u8c03\u7528"));
            return callResult;
        }
        IDEHelper iDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(strDEId);
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u3002", (Object)strDEId));
            return callResult;
        }
        callResult = DATSTask.GetCallParam(iDEHelper, context);
        if (callResult.IsError()) {
            return callResult;
        }
        BaseDataEntity paramDataEntity = null;
        if (callResult.getUserObject() != null) {
            paramDataEntity = (BaseDataEntity)callResult.getUserObject();
        }
        if ((iDEDataCtrl = iDEHelper.GetDEDataCtrl("SYSTEM", null)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iDEHelper.getId()));
            return callResult;
        }
        return iDEDataCtrl.CustomCall(strCustomCall, paramDataEntity);
    }
}

