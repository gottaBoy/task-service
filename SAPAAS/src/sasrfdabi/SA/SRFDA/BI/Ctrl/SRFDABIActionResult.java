/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import net.sf.json.JSONObject;

public class SRFDABIActionResult
extends SRFExAjaxActionResult {
    protected JSONObject model = null;

    public JSONObject getModel() {
        return this.model;
    }

    public void setModel(JSONObject model) {
        this.model = model;
    }

    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (this.model != null) {
            objJSON.put("model", (Object)this.model);
        }
    }
}

