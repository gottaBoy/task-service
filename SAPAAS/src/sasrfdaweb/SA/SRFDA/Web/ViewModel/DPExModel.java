/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.ControlModel;
import net.sf.json.JSONObject;

public class DPExModel
extends ControlModel {
    protected boolean bItemPrivilege = false;

    public boolean getItemPrivilege() {
        return this.bItemPrivilege;
    }

    public void setItemPrivilege(boolean bItemPrivilege) {
        this.bItemPrivilege = bItemPrivilege;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getItemPrivilege()) {
            jo.put("itemprivilege", this.getItemPrivilege());
        }
    }
}

