/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.TreePageModel
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.TreePageModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class WFBaseTreeGridViewModel
extends TreePageModel {
    protected String strActiveFolder = "";
    protected String strWFId = "";

    public String getWFId() {
        return this.strWFId;
    }

    public void setWFId(String strWFId) {
        this.strWFId = strWFId;
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getWFId())) {
            jo.put("wfid", (Object)this.getWFId());
        }
    }
}

