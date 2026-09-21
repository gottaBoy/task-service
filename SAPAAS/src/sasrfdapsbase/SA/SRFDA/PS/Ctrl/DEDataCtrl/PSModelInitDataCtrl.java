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

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelInitDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelInitDataCtrl.class);

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSModelInitId = dataEntity.getParamStringValue("PSMODELINITID", "");
        this.getPSModelStorage().resetPSModelInit(strPSModelInitId);
        this.getPSModelStorage().getPSModelInit(strPSModelInitId, false);
    }

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            dataEntity.setParamValue("PSMODELINITID", dataEntity.getParamValue("DEID"));
            dataEntity.setParamValue("PSMODELINITNAME", dataEntity.getParamValue("DENAME"));
        }
        return callResult;
    }
}

