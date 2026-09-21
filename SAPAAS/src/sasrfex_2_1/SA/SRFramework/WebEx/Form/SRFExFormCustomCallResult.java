/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import net.sf.json.JSONObject;

public class SRFExFormCustomCallResult
extends SRFExFormLoadResult {
    protected boolean bFill = false;

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        objJSON.put("fill", this.bFill);
    }

    public boolean getFillForm() {
        return this.bFill;
    }

    public void setFillForm(boolean bFill) {
        this.bFill = bFill;
    }
}

