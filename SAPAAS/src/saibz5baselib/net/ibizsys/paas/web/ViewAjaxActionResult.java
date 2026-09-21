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
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ViewAjaxActionResult
extends AjaxActionResult {
    protected ArrayList itemList = new ArrayList();

    public ArrayList getItems() {
        return this.itemList;
    }

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            objJSON.put("items", (Object)new JSONArray());
        } else {
            objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.itemList.toArray()));
        }
    }

    @Override
    public void fromJSONObject(JSONObject jo) throws Exception {
        JSONArray ja = jo.optJSONArray("items");
        this.itemList.clear();
        if (ja != null) {
            int i = 0;
            while (i < ja.length()) {
                this.itemList.add(ja.get(i));
                ++i;
            }
        }
        JSONObjectHelper.remove(jo, "items");
        super.fromJSONObject(jo);
    }
}

