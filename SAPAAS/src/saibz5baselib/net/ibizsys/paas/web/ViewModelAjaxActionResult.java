/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import java.util.ArrayList;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.ViewAjaxActionResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ViewModelAjaxActionResult
extends ViewAjaxActionResult {
    protected JSONObject dataAccAction = null;
    protected ArrayList msgList = new ArrayList();
    protected JSONObject lanResObject = null;
    protected JSONObject viewObject = null;

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() == 0) {
            if (this.getDataAccAction(false) != null) {
                objJSON.put("dataaccaction", (Object)this.getDataAccAction(false));
            }
            if (this.getLanRes(false) != null) {
                objJSON.put("lanres", (Object)this.getLanRes(false));
            }
            if (this.getView(false) != null) {
                objJSON.put("view", (Object)this.getView(false));
            }
            objJSON.put("msgs", (Object)JSONArray.fromArray((Object[])this.msgList.toArray()));
        }
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
        this.dataAccAction = jo.optJSONObject("dataaccaction");
        JSONObjectHelper.remove(jo, "dataaccaction");
        this.lanResObject = jo.optJSONObject("lanres");
        JSONObjectHelper.remove(jo, "lanres");
        this.viewObject = jo.optJSONObject("view");
        JSONObjectHelper.remove(jo, "view");
        JSONArray ja = jo.optJSONArray("msgs");
        this.msgList.clear();
        if (ja != null) {
            int i = 0;
            while (i < ja.length()) {
                this.msgList.add(ja.get(i));
                ++i;
            }
        }
        JSONObjectHelper.remove(jo, "msgs");
        super.fromJSONObject(jo);
    }

    public ArrayList getMsgs() {
        return this.msgList;
    }

    public JSONObject getLanRes(boolean bCreate) {
        if (this.lanResObject != null) {
            return this.lanResObject;
        }
        if (bCreate) {
            this.lanResObject = new JSONObject();
        }
        return this.lanResObject;
    }

    public JSONObject getView(boolean bCreate) {
        if (this.viewObject != null) {
            return this.viewObject;
        }
        if (bCreate) {
            this.viewObject = new JSONObject();
        }
        return this.viewObject;
    }
}

