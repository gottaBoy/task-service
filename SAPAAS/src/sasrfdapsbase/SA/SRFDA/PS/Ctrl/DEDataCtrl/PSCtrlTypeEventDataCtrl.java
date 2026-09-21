/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public class PSCtrlTypeEventDataCtrl
extends PSDEDataCtrl {
    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        if (bInsert) {
            dataEntity.set("PSCTRLTYPEEVENTNAME", dataEntity.getParamValue("PSCTRLEVENTNAME"));
        }
        return super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
    }
}

