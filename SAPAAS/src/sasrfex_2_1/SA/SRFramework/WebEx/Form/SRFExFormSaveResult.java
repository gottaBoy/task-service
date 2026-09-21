/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.Form.SRFExFormActionResult;
import net.sf.json.JSONObject;

public class SRFExFormSaveResult
extends SRFExFormActionResult {
    protected String strSaveTag = "";

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        objJSON.put("savetag", (Object)this.strSaveTag);
    }

    public String getSaveTag() {
        return this.strSaveTag;
    }

    public void setSaveTag(String strSaveTag) {
        this.strSaveTag = strSaveTag;
    }
}

