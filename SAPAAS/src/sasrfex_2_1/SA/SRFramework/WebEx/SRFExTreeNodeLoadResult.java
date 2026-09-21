/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SRFExTreeNodeLoadResult
extends SRFExAjaxActionResult {
    protected Vector items = new Vector();

    public Vector getItems() {
        return this.items;
    }

    @Override
    public String ToJSONString() {
        return JSONArray.fromArray((Object[])this.items.toArray()).toString();
    }

    public String ToJSONString(boolean bFullMode) {
        if (bFullMode) {
            return super.ToJSONString();
        }
        return JSONArray.fromArray((Object[])this.items.toArray()).toString();
    }

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
    }
}

