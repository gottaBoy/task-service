/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;

public class PSPFPluginTemplDataCtrl
extends PSDEDataCtrl {
    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSPFPluginTemplId = dataEntity.getParamStringValue("PSPFPLUGINTEMPLID", "");
        this.getPSModelStorage().resetPSPFPluginTempl(strPSPFPluginTemplId);
        this.getPSModelStorage().getPSPFPluginTempl(strPSPFPluginTemplId);
    }
}

