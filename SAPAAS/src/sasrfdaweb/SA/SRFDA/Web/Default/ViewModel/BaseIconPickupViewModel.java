/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BaseIconPickupViewModel
extends MainViewModel {
    protected String strTypeName = "";
    protected Vector items = null;

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getTypeName())) {
            jo.put("typename", (Object)this.getTypeName());
        }
        if (this.getItems() != null) {
            jo.put("items", (Object)JSONArray.fromArray((Object[])this.getItems().toArray()));
        }
    }

    public String getTypeName() {
        return this.strTypeName;
    }

    public void setTypeName(String strTypeName) {
        this.strTypeName = strTypeName;
    }

    public Vector getItems() {
        return this.items;
    }

    public void setItems(Vector items) {
        this.items = items;
    }
}

