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

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBType4;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDBServerDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.PS.Data.PSDBDevInstBK;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBDevInstDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDBDevInstDataCtrl.class);
    public static final String CUSTOMCALL_CLONEDBINST = "CLONEDBINST";
    public static final String CUSTOMCALL_UPDATEUSEDSIZE = "UPDATEUSEDSIZE";
    public static final String CUSTOMCALL_BACKUP = "BACKUP";
    public static final String CUSTOMCALL_OFFLINE = "OFFLINE";
    public static final String CUSTOMCALL_RESTORE = "RESTORE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSDBDevInstId = dataEntity.getParamStringValue("PSDBDEVINSTID", "");
        this.getPSModelStorage().resetPSDBDevInst(strPSDBDevInstId);
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLONEDBINST, (boolean)true) == 0) {
            return this.cloneDBInst(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BACKUP, (boolean)true) == 0) {
            return this.backupDBInst(dataEntity, false);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_OFFLINE, (boolean)true) == 0) {
            return this.backupDBInst(dataEntity, true);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RESTORE, (boolean)true) == 0) {
            return this.restoreDBInst(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult cloneDBInst(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDBDevInst psDBDevInst = new PSDBDevInst();
            psDBDevInst.proxy(dataEntity);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDBServerDataCtrl psDBServerDataCtrl = (PSDBServerDataCtrl)this.GetRelatedDataCtrl("DE1891");
            PSDBServer psDBServer = new PSDBServer();
            psDBServer.setPSDBSERVERID(psDBDevInst.getPSDBSERVERID());
            return psDBServerDataCtrl.initDBDevInst(psDBServer, psDBDevInst, psDBDevInst.getUSAGEMODE());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u514b\u9686\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult backupDBInst(BaseDataEntity dataEntity, boolean bOffline) {
        CallResult callResult = new CallResult();
        try {
            final PSDBDevInst psDBDevInst = new PSDBDevInst();
            final boolean bOffline2 = bOffline;
            psDBDevInst.proxy(dataEntity);
            this.Get(psDBDevInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDBDevInstDataCtrl.this.onBackupDBInst(psDBDevInst, bOffline2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onBackupDBInst(PSDBDevInst psDBDevInst, boolean bOffline) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDBDevInst.getDBTYPE());
        if (!(iPSDBType instanceof IPSDBType4)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c", (Object)iPSDBType.getName()));
        }
        IPSDBType4 iPSDBType4 = (IPSDBType4)((Object)iPSDBType);
        PSDBDevInstBK psDBDevInstBk = new PSDBDevInstBK();
        psDBDevInstBk.setPSDBDEVINSTID(psDBDevInst.getPSDBDEVINSTID());
        psDBDevInstBk.setPSDBDEVINSTNAME(psDBDevInst.getPSDBDEVINSTNAME());
        psDBDevInstBk.setPSTASKSERVERID(this.getPSModelStorage().getPSTaskServerEnv().getId());
        psDBDevInstBk.setPSTASKSERVERNAME(this.getPSModelStorage().getPSTaskServerEnv().getName());
        iPSDBType4.backupDBInst("PSDBDEVINST", psDBDevInst, psDBDevInstBk, bOffline);
    }

    public CallResult restoreDBInst(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final PSDBDevInst psDBDevInst = new PSDBDevInst();
            psDBDevInst.proxy(dataEntity);
            this.Get(psDBDevInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDBDevInstDataCtrl.this.onRestoreDBInst(psDBDevInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6062\u590d\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onRestoreDBInst(PSDBDevInst psDBDevInst) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDBDevInst.getDBTYPE());
        if (!(iPSDBType instanceof IPSDBType4)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c", (Object)iPSDBType.getName()));
        }
        IPSDBType4 iPSDBType4 = (IPSDBType4)((Object)iPSDBType);
        PSDBDevInstBK psDBDevInstBk = new PSDBDevInstBK();
        iPSDBType4.restoreDBInst("PSDBDEVINST", psDBDevInst, psDBDevInstBk);
        psDBDevInstBk.setPSDBDEVINSTID(psDBDevInst.getPSDBDEVINSTID());
        psDBDevInstBk.setPSDBDEVINSTNAME(psDBDevInst.getPSDBDEVINSTNAME());
        psDBDevInstBk.setPSTASKSERVERID(this.getPSModelStorage().getPSTaskServerEnv().getId());
        psDBDevInstBk.setPSTASKSERVERNAME(this.getPSModelStorage().getPSTaskServerEnv().getName());
    }
}

