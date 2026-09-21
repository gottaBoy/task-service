/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import net.sf.json.JSONObject;

public class SRFExDGAjaxActionResult
extends SRFExAjaxActionResult {
    protected boolean bReload = true;
    protected JSONObject objRow = null;

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        objJSON.put("reload", this.bReload);
        if (this.objRow != null) {
            objJSON.put("row", (Object)this.objRow);
        }
    }

    public boolean isReload() {
        return this.bReload;
    }

    public void setReload(boolean reload) {
        this.bReload = reload;
    }

    public void setRow(JSONObject value) {
        this.objRow = value;
    }

    public JSONObject getRow() {
        return this.objRow;
    }
}

