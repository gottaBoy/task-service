/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.EditView2Model
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.EditView2Model;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class WFIAActionViewModel
extends EditView2Model {
    protected boolean bNoPanelMode = false;
    protected String strSubmitIAActionUrl = "";

    public boolean getNoPanelMode() {
        return this.bNoPanelMode;
    }

    public void setNoPanelMode(boolean bNoPanelMode) {
        this.bNoPanelMode = bNoPanelMode;
    }

    public String getSubmitIAActionUrl() {
        return this.strSubmitIAActionUrl;
    }

    public void setSubmitIAActionUrl(String strSubmitIAActionUrl) {
        this.strSubmitIAActionUrl = strSubmitIAActionUrl;
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        jo.put("nopanelmode", this.getNoPanelMode());
        if (!StringHelper.IsNullOrEmpty((String)this.getSubmitIAActionUrl())) {
            jo.put("submitiaactionurl", (Object)this.getSubmitIAActionUrl());
        }
    }
}

