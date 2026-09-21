/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDevCenterFile;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevCenterFileDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDevCenterFileDataCtrl.class);
    public static final String CUSTOMCALL_CALCSIZE = "CALCSIZE";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CALCSIZE, (boolean)true) == 0) {
            return this.calcSize(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult calcSize(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSDevCenterFile psDevCenterFile = new PSDevCenterFile();
            psDevCenterFile.proxy(dataEntity);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevCenterFileDataCtrl.this.onCalcSize(psDevCenterFile);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u8ba1\u7b97\u6587\u4ef6\u5927\u5c0f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCalcSize(PSDevCenterFile psDevCenterFile) throws Exception {
        PSDevCenterFileService psDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class);
        net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile psDevCenterFile2 = new net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile();
        psDevCenterFile2.setPSDevCenterFileId(psDevCenterFile.getPSDEVCENTERFILEID());
        psDevCenterFileService.calcFolderSize(psDevCenterFile2);
    }
}

