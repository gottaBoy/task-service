/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.Form.SRFExFormActionResult;
import net.sf.json.JSONObject;

public class SRFExFormLoadResult
extends SRFExFormActionResult {
    protected boolean bCopyMode = false;
    protected String strCopyId = "";

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            return;
        }
        objJSON.put("copymode", this.bCopyMode);
        objJSON.put("copyid", (Object)this.strCopyId);
    }

    public boolean isCopyMode() {
        return this.bCopyMode;
    }

    public void setCopyMode(boolean copyMode) {
        this.bCopyMode = copyMode;
    }

    public String getCopyId() {
        return this.strCopyId;
    }

    public void setCopyId(String strCopyId) {
        this.strCopyId = strCopyId;
    }
}

