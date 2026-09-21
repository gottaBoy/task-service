/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCMSPlatformDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformDataCtrl.class);

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
        String strPSDCMSPlatformId = dataEntity.getParamStringValue("PSDCMSPLATFORMID", "");
        this.getPSModelStorage().resetPSDCMSPlatform(strPSDCMSPlatformId);
        IPSDCMSPlatform iPSDCMSPlatform = this.getPSModelStorage().getPSDCMSPlatform(strPSDCMSPlatformId);
    }
}

