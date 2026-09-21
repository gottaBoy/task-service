/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.sf.json.JSONObject
 */
package SA.WT.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import net.sf.json.JSONObject;

public class WTCallResult
extends CallResult {
    private JSONObject jo = null;

    public void FromJSONObject(JSONObject jo) {
        this.jo = jo;
        if (jo.has("errcode")) {
            this.setRetCode(jo.getInt("errcode"));
        }
        if (jo.has("errmsg")) {
            this.setErrorInfo(jo.getString("errmsg"));
        }
    }

    public JSONObject getRawObject() {
        return this.jo;
    }
}

