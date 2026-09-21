/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.web.SDAjaxActionResult;
import net.sf.json.JSONObject;

public class FormAjaxActionResult
extends SDAjaxActionResult {
    public static final String ATTR_CLOSEEDITVIEW = "closeEditview";
    protected JSONObject state = null;
    protected JSONObject config = null;

    public JSONObject getState(boolean bCreate) {
        if (this.state != null) {
            return this.state;
        }
        if (bCreate) {
            this.state = new JSONObject();
        }
        return this.state;
    }

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
        if (this.getState(false) != null) {
            objJSON.put("state", (Object)this.getState(false));
        }
        if (this.getConfig(false) != null) {
            objJSON.put("config", (Object)this.getConfig(false));
        }
    }
}

