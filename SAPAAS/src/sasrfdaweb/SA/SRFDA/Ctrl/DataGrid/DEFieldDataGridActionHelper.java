/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEField
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class DEFieldDataGridActionHelper
extends BaseDADataGridActionHelper {
    @Override
    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"SYNCINHERITDEFIELD", (boolean)true) == 0) {
            this.OnSyncInheritDEField();
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected void OnSyncInheritDEField() {
        SRFExDGAjaxActionResult callActionResult = new SRFExDGAjaxActionResult();
        callActionResult.setReload(false);
        String strDEId = this.getWebContext().GetParamValue("DEID");
        DEField defield = new DEField();
        defield.setDEID(strDEId);
        CallResult callResult = this.getDEDataCtrl().CustomCall("SYNCINHERITDEFIELD", (BaseDataEntity)defield);
        callActionResult.From(callResult);
        if (callResult.IsOk()) {
            callActionResult.setReload(true);
        }
        this.getPage().Output(callActionResult.ToJSONString());
    }
}

