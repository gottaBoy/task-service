/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SRFExFormActionResult
extends SRFExAjaxActionResult {
    protected Vector items = new Vector();
    protected JSONObject fsObject = null;
    protected boolean bUpdateFlag = false;
    protected boolean bIgnoreDefault = false;
    protected String strDataUrl = "";

    public Vector getItems() {
        return this.items;
    }

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
        objJSON.put("uf", this.bUpdateFlag);
        if (this.fsObject != null) {
            objJSON.put("fs", (Object)this.fsObject);
        } else {
            objJSON.put("fs", (Object)new JSONObject());
        }
        if (this.isIgnoreDefault()) {
            objJSON.put("igndef", this.isIgnoreDefault());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getDataUrl())) {
            objJSON.put("dataurl", (Object)this.getDataUrl());
        }
    }

    public JSONObject getFormState() {
        return this.fsObject;
    }

    public void setFormState(JSONObject fsObject) {
        this.fsObject = fsObject;
    }

    public boolean isUpdateFlag() {
        return this.bUpdateFlag;
    }

    public void setUpdateFlag(boolean bUpdateFlag) {
        this.bUpdateFlag = bUpdateFlag;
    }

    public boolean isIgnoreDefault() {
        return this.bIgnoreDefault;
    }

    public void setIgnoreDefault(boolean bIgnoreDefault) {
        this.bIgnoreDefault = bIgnoreDefault;
    }

    public String getDataUrl() {
        return this.strDataUrl;
    }

    public void setDataUrl(String strDataUrl) {
        this.strDataUrl = strDataUrl;
    }
}

