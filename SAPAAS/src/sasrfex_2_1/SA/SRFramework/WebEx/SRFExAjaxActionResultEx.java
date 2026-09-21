/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import net.sf.json.JSONObject;

public class SRFExAjaxActionResultEx
extends SRFExAjaxActionResult {
    protected JSONObject item = new JSONObject();

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        objJSON.put("item", (Object)this.item);
    }

    public JSONObject getItemObject() {
        return this.item;
    }

    public void setItemObject(JSONObject item) {
        this.item = item;
    }
}

