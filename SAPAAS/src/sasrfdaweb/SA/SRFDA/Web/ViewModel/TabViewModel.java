/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class TabViewModel
extends ControlModel {
    protected String strFormView = "";

    public void setFormView(String strFormView) {
        this.strFormView = strFormView;
    }

    public String getFormView() {
        return this.strFormView;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getFormView())) {
            jo.put("formview", (Object)this.getFormView());
        }
    }
}

