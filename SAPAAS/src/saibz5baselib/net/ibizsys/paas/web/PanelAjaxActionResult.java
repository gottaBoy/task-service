/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.web.SDAjaxActionResult;
import net.sf.json.JSONObject;

public class PanelAjaxActionResult
extends SDAjaxActionResult {
    protected JSONObject config = null;

    public JSONObject getConfig(boolean bCreate) {
        if (this.config != null) {
            return this.config;
        }
        if (bCreate) {
            this.config = new JSONObject();
        }
        return this.config;
    }

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            return;
        }
        if (this.getConfig(false) != null) {
            objJSON.put("config", (Object)this.getConfig(false));
        }
    }
}

