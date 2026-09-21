/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SRFExFormInitParamsResult
extends SRFExAjaxActionResult {
    protected Vector items = new Vector();

    public Vector getItems() {
        return this.items;
    }

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            return;
        }
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
    }
}

