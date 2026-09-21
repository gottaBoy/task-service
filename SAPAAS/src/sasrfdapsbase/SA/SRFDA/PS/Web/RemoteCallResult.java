/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Web;

import SA.SRFramework.WebEx.SRFExAjaxListResult;
import net.sf.json.JSONObject;

public class RemoteCallResult
extends SRFExAjaxListResult {
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (!objJSON.has("content") && this.getUserObject() != null) {
            objJSON.put("content", this.getUserObject());
        }
    }
}

