/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

public class AppDataAjaxActionResult
extends AjaxActionResult {
    protected JSONObject localAppDataJO = null;
    protected JSONObject remoteAppDataJO = null;
    protected JSONObject appUIJO = null;

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() == 0) {
            if (this.getLocalAppData(false) != null) {
                objJSON.put("local", (Object)this.getLocalAppData(false));
            }
            if (this.getRemoteAppData(false) != null) {
                String strRemoteTag = Base64Helper.encodeBytes(this.getRemoteAppData(false).toString().getBytes()).replace("\r", "").replace("\n", "");
                objJSON.put("remotetag", (Object)strRemoteTag);
            }
            if (this.getUIConfig(false) != null) {
                objJSON.put("ui", (Object)this.getUIConfig(false));
            }
        }
    }

    public JSONObject getLocalAppData(boolean bCreate) {
        if (this.localAppDataJO != null) {
            return this.localAppDataJO;
        }
        if (bCreate) {
            this.localAppDataJO = new JSONObject();
        }
        return this.localAppDataJO;
    }

    public JSONObject getRemoteAppData(boolean bCreate) {
        if (this.remoteAppDataJO != null) {
            return this.remoteAppDataJO;
        }
        if (bCreate) {
            this.remoteAppDataJO = new JSONObject();
        }
        return this.remoteAppDataJO;
    }

    public JSONObject getUIConfig(boolean bCreate) {
        if (this.appUIJO != null) {
            return this.appUIJO;
        }
        if (bCreate) {
            this.appUIJO = new JSONObject();
        }
        return this.appUIJO;
    }
}

