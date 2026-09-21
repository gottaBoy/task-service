/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 */
package SA.SRFDA.Dev.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Dev.Ctrl.ScriptSetHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;

public class ScriptSetDGActionHelper
extends BaseDADataGridActionHelper {
    public static final String CUSTOMACTION_EXPORTJS = "EXPORTJS";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)CUSTOMACTION_EXPORTJS, (String)strAction, (boolean)true) == 0) {
            this.OnExportJS();
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected void OnExportJS() {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        customActionResult.setReload(false);
        CallResult callResult = ScriptSetHelper.ExportJS((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), true);
        customActionResult.From(callResult);
        this.getPage().Output(customActionResult.ToJSONString());
    }
}

