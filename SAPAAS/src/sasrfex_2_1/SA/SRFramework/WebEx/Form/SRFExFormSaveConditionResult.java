/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SRFExFormSaveConditionResult
extends SRFExAjaxActionResult {
    protected Vector items = new Vector();
    protected String strSearchThemeId = "";
    protected boolean bRefresh = false;

    public String getSearchThemeId() {
        return this.strSearchThemeId;
    }

    public void setSearchThemeId(String strSearchThemeId) {
        this.strSearchThemeId = strSearchThemeId;
    }

    public void setRefresh(boolean bRefresh) {
        this.bRefresh = bRefresh;
    }

    public boolean getRefresh() {
        return this.bRefresh;
    }

    public Vector getItems() {
        return this.items;
    }

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        objJSON.put("spid", (Object)this.strSearchThemeId);
        objJSON.put("refresh", this.bRefresh);
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
    }
}

