/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DAHelperActionResult
extends CallResult {
    protected Vector items = new Vector();

    public Vector getItems() {
        return this.items;
    }

    public String ToJSONString() {
        JSONObject objJSON = new JSONObject();
        this.FillJSONObject(objJSON);
        return objJSON.toString();
    }

    protected void FillJSONObject(JSONObject objJSON) {
        objJSON.put("ret", this.nRetCode);
        objJSON.put("info", (Object)this.strErrorInfo);
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
    }
}

