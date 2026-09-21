/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.WF.Web.JSGear.WFHistoryWorkDGEditJSGear;
import SA.SRFDA.WF.Web.Utility.WFHistoryWorkDGEditPageHelper;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class WFHistoryWorkGridViewPage
extends GridViewPage {
    protected boolean IsLoadDataGridNewEditJSGear() {
        return false;
    }

    protected String OnGetDataGridConfigId() {
        return "SRFWF.DG_WFSTEPDATA_HISTORY";
    }

    protected void OnInit() {
        super.OnInit();
        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            WFHistoryWorkDGEditJSGear.Load((SRFDAPage)this, this.getWebContext().GetParamValue("DEID"), this.dataGrid);
        } else {
            this.editPageInfo = new JSONObject();
            this.editPageInfo.put("dbclkedit", true);
            WFHistoryWorkDGEditPageHelper.Calc((SRFDAPage)this, this.dataGrid, this.getWebContext().GetParamValue("DEID"), this.editPageInfo);
        }
    }
}

