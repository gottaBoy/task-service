/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  net.sf.json.JSONObject
 */
package SA.TM.Web;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMActionResult
extends SRFExAjaxActionResult {
    protected Vector items = null;

    public Vector getItems() {
        return this.items;
    }

    public void setItems(Vector items) {
        this.items = items;
    }

    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (this.items != null) {
            objJSON.put("items", (Object)this.items.toArray());
        }
    }
}

