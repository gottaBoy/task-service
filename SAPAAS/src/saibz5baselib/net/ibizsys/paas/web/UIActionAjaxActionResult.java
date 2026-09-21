/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

public class UIActionAjaxActionResult
extends AjaxActionResult {
    public static final String ATTR_CLOSEEDITVIEW = "closeEditview";
    public static final String ATTR_RELOADDATA = "reloadData";
    private boolean bReloadData = false;

    public boolean isReloadData() {
        return this.bReloadData;
    }

    public void setReloadData(boolean bReloadData) {
        this.bReloadData = bReloadData;
    }

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.isReloadData()) {
            objJSON.put(ATTR_RELOADDATA, true);
        }
        if (this.getRetCode() != 0) {
            return;
        }
    }
}

