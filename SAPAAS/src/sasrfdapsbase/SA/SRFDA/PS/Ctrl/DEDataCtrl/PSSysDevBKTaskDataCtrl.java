/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysDevBKTask;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDevBKTaskDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskDataCtrl.class);
    public static final String CUSTOMCALL_CANCELTASK = "CANCELTASK";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CANCELTASK, (boolean)true) == 0) {
            return this.cancelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult cancelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.proxy(dataEntity);
            this.onCancelTask(psSysDevBKTask);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d6\u6d88\u540e\u53f0\u5f00\u53d1\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCancelTask(PSSysDevBKTask psSysDevBKTask) throws Exception {
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().cancelPSSysDevBKTask(psSysDevBKTask);
    }
}

