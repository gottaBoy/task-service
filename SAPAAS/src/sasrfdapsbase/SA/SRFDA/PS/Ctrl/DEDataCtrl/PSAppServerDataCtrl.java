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

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSvrServerDataCtrl;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.PS.Data.PSSvrServer;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppServerDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSAppServerDataCtrl.class);
    public static final String CUSTOMCALL_CLONEAS = "CLONEAS";
    public static final String CUSTOMCALL_CLONEAS2 = "CLONEAS2";
    public static final String CUSTOMCALL_CLONEAS3 = "CLONEAS3";

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
        String strPSAppServerId = dataEntity.getParamStringValue("PSAPPSERVERID", "");
        this.getPSModelStorage().resetPSAppServer(strPSAppServerId);
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLONEAS, (boolean)true) == 0) {
            return this.cloneAS(dataEntity, 1);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLONEAS2, (boolean)true) == 0) {
            return this.cloneAS(dataEntity, 2);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLONEAS3, (boolean)true) == 0) {
            return this.cloneAS(dataEntity, 3);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult cloneAS(BaseDataEntity dataEntity, int nMode) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSAppServer psAppServer = new PSAppServer();
            psAppServer.proxy(dataEntity);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSvrServerDataCtrl psSvrServerDataCtrl = (PSSvrServerDataCtrl)this.GetRelatedDataCtrl("DE1890");
            PSSvrServer psSvrServer = new PSSvrServer();
            psSvrServer.setPSSVRSERVERID(psAppServer.getPSSVRSERVERID());
            return psSvrServerDataCtrl.initAppServer(psSvrServer, nMode, psAppServer);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u514b\u9686\u5e94\u7528\u670d\u52a1\u5668\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

