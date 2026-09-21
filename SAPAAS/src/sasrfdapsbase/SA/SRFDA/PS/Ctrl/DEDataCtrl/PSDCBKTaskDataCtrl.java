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
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCBKTaskDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCBKTaskDataCtrl.class);
    public static final String CUSTOMCALL_STARTTASK = "STARTTASK";
    public static final String CUSTOMCALL_CANCELTASK = "CANCELTASK";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_STARTTASK, (boolean)true) == 0) {
            return this.startTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CANCELTASK, (boolean)true) == 0) {
            return this.cancelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult startTask(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        try {
            PSDCBKTask psDCBKTask = new PSDCBKTask();
            psDCBKTask.proxy(dataEntity);
            this.onStartTask(psDCBKTask);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u542f\u52a8\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onStartTask(PSDCBKTask psDCBKTask) throws Exception {
        this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask);
    }

    public CallResult cancelTask(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        try {
            PSDCBKTask psDCBKTask = new PSDCBKTask();
            psDCBKTask.proxy(dataEntity);
            this.onCancelTask(psDCBKTask);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d6\u6d88\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCancelTask(PSDCBKTask psDCBKTask) throws Exception {
        this.getPSModelStorage().getPSDevCenterBKTaskGlobal().cancelPSDCBKTask(psDCBKTask);
    }
}

