/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.web.ViewModelAjaxActionResult
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.ssdyna.web;

import java.util.ArrayList;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DynaViewModelAjaxActionResult
extends ViewModelAjaxActionResult {
    public static final String ATTR_UIACTIONS = "uiactions";
    public static final String ATTR_CTRLS = "ctrls";
    public static final String ATTR_REFVIEWS = "refviews";
    public static final String ATTR_CODELISTS = "codelists";
    protected ArrayList uiActionList = new ArrayList();
    protected ArrayList ctrlList = new ArrayList();
    protected ArrayList refViewList = new ArrayList();
    protected ArrayList codeListList = new ArrayList();

    public ArrayList getUIActions() {
        return this.uiActionList;
    }

    public ArrayList getCtrls() {
        return this.ctrlList;
    }

    public ArrayList getRefViews() {
        return this.refViewList;
    }

    public ArrayList getCodeLists() {
        return this.codeListList;
    }

    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() == 0) {
            objJSON.put(ATTR_UIACTIONS, (Object)JSONArray.fromArray((Object[])this.getUIActions().toArray()));
            objJSON.put(ATTR_CTRLS, (Object)JSONArray.fromArray((Object[])this.getCtrls().toArray()));
            objJSON.put(ATTR_REFVIEWS, (Object)JSONArray.fromArray((Object[])this.getRefViews().toArray()));
            objJSON.put(ATTR_CODELISTS, (Object)JSONArray.fromArray((Object[])this.getCodeLists().toArray()));
        }
    }
}

