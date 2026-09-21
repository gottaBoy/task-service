/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

public class SDAjaxActionResult
extends AjaxActionResult {
    protected JSONObject dataAccAction = null;
    protected JSONObject data = null;
    protected JSONObject error = null;
    private boolean bReloadData = false;

    public JSONObject getData(boolean bCreate) {
        if (this.data != null) {
            return this.data;
        }
        if (bCreate) {
            this.data = new JSONObject();
        }
        return this.data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public JSONObject getError(boolean bCreate) {
        if (this.error != null) {
            return this.error;
        }
        if (bCreate) {
            this.error = new JSONObject();
        }
        return this.error;
    }

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            if (this.getError(false) != null) {
                objJSON.put("error", (Object)this.getError(false));
            }
            return;
        }
        if (this.getData(false) != null) {
            objJSON.put("data", (Object)this.getData(false));
        }
        if (this.getDataAccAction(false) != null) {
            objJSON.put("dataaccaction", (Object)this.getDataAccAction(false));
        }
        if (this.isReloadData()) {
            objJSON.put("reloadData", true);
        }
    }

    public boolean isReloadData() {
        return this.bReloadData;
    }

    public void setReloadData(boolean bReloadData) {
        this.bReloadData = bReloadData;
    }

    public JSONObject getDataAccAction(boolean bCreate) {
        if (this.dataAccAction != null) {
            return this.dataAccAction;
        }
        if (bCreate) {
            this.dataAccAction = new JSONObject();
        }
        return this.dataAccAction;
    }

    @Override
    public void fromJSONObject(JSONObject jo) throws Exception {
        this.error = jo.optJSONObject("error");
        JSONObjectHelper.remove(jo, "error");
        this.data = jo.optJSONObject("data");
        JSONObjectHelper.remove(jo, "data");
        this.dataAccAction = jo.optJSONObject("dataaccaction");
        JSONObjectHelper.remove(jo, "dataaccaction");
        this.bReloadData = jo.optBoolean("reloadData", false);
        JSONObjectHelper.remove(jo, "reloadData");
        super.fromJSONObject(jo);
    }
}

