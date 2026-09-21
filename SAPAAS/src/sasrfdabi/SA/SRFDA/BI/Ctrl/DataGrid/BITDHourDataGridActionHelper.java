/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.BI.Ctrl.DataGrid;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBITD_HourDataCtrl;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class BITDHourDataGridActionHelper
extends BaseDADataGridActionHelper {
    public static final String ACTION_GENTD = "GENTD";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_GENTD, (boolean)true) == 0) {
            return this.OnGenTD();
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnGenTD() {
        SRFExDGAjaxActionResult ajaxCallResult = new SRFExDGAjaxActionResult();
        ajaxCallResult.setReload(true);
        IBITD_HourDataCtrl iTDDataCtrl = (IBITD_HourDataCtrl)this.getPage().GetDEDataCtrl();
        BaseDataEntity cond = new BaseDataEntity();
        CallResult callResult = iTDDataCtrl.GenTD(cond);
        if (callResult.IsError()) {
            ajaxCallResult.From(callResult);
        }
        this.getPage().Output(ajaxCallResult.ToJSONString());
        return true;
    }
}

