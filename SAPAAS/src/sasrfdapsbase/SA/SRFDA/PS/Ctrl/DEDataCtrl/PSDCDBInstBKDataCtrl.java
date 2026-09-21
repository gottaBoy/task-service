/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.PS.Data.PSDCDBInstBK;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCDBInstBKDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCDBInstBKDataCtrl.class);
    public static final String CUSTOMCALL_ASYNCRESTORE = "ASYNCRESTORE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ASYNCRESTORE, (boolean)true) == 0) {
            return this.asyncRestoreDBInst(dataEntity, false);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult asyncRestoreDBInst(BaseDataEntity dataEntity, boolean bOffline) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDCDBInstBK psDCDBInstBK = new PSDCDBInstBK();
            boolean bOffline2 = bOffline;
            psDCDBInstBK.proxy(dataEntity);
            this.Get(psDCDBInstBK);
            this.onAsyncRestoreDBInst(psDCDBInstBK, bOffline2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6062\u590d\u6570\u636e\u5e93\u5b9e\u4f8b\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAsyncRestoreDBInst(PSDCDBInstBK psDCDBInstBK, boolean bOffline) throws Exception {
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDEVCENTERID(psDCDBInstBK.getPSDEVCENTERID());
        psDCBKTask.setPSDEVCENTERNAME(psDCDBInstBK.getPSDEVCENTERNAME());
        psDCBKTask.setPSDCBKTASKNAME(StringHelper.Format((String)"\u521b\u5efa\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u6062\u590d", (Object)psDCDBInstBK.getPSDEVCENTERDBINSTNAME()));
        psDCBKTask.setTASKSTATE(10);
        psDCBKTask.setORDERVALUE(100);
        psDCBKTask.setTASKTYPE("RESTOREDCDBINST");
        psDCBKTask.setTASKPARAM(psDCDBInstBK.getPSDEVCENTERDBINSTID());
        psDCBKTask.setTASKPARAM2(psDCDBInstBK.getPSDCDBINSTBKID());
        IDEDataCtrl psDCBKTaskDataCtrl = this.GetRelatedDataCtrl("DE2984");
        CallResult callResult = psDCBKTaskDataCtrl.Save(true, (BaseDataEntity)psDCBKTask);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u521b\u5efa\u5e94\u7528\u4e2d\u5fc3\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask);
    }
}

