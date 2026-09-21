/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.NavFrameViewModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class NavFramePickupViewModel
extends NavFrameViewModel {
    protected String strPickupText = "";
    protected String strPickupValue = "";
    protected String strSelectedDataTitle = "";

    public String getPickupText() {
        return this.strPickupText;
    }

    public void setPickupText(String strPickupText) {
        this.strPickupText = strPickupText;
    }

    public String getPickupValue() {
        return this.strPickupValue;
    }

    public void setPickupValue(String strPickupValue) {
        this.strPickupValue = strPickupValue;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getPickupValue())) {
            jo.put("pickupvalue", (Object)this.getPickupValue());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPickupText())) {
            jo.put("pickuptext", (Object)this.getPickupText());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getSelectedDataTitle())) {
            jo.put("selecteddatatitile", (Object)this.getSelectedDataTitle());
        }
    }

    public String getSelectedDataTitle() {
        return this.strSelectedDataTitle;
    }

    public void setSelectedDataTitle(String strSelectedDataTitle) {
        this.strSelectedDataTitle = strSelectedDataTitle;
    }
}

