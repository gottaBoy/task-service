/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.web.ViewModelAjaxActionResult
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import java.util.ArrayList;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DynaViewModelAjaxActionResult
extends ViewModelAjaxActionResult {
    public static final String ATTR_UIACTIONS = "uiactions";
    public static final String ATTR_CTRLS = "ctrls";
    protected ArrayList uiActionList = new ArrayList();
    protected ArrayList ctrlList = new ArrayList();

    public ArrayList getUIActions() {
        return this.uiActionList;
    }

    public ArrayList getCtrls() {
        return this.ctrlList;
    }

    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() == 0) {
            objJSON.put(ATTR_UIACTIONS, (Object)JSONArray.fromArray((Object[])this.getUIActions().toArray()));
            objJSON.put(ATTR_CTRLS, (Object)JSONArray.fromArray((Object[])this.getCtrls().toArray()));
        }
    }
}

