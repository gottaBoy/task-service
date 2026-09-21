/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.ctrlmodel.AppMenuModelBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AppMenuModel
extends AppMenuModelBase {
    public JSONArray toJSONArray() throws Exception {
        ArrayList<JSONObject> items = new ArrayList<JSONObject>();
        for (IAppMenuItem iAppMenuItem : this.getRootItem().getItems()) {
            if (iAppMenuItem.getFiller() != null) {
                ArrayList<JSONObject> list = iAppMenuItem.getFiller().toJSONObjects(iAppMenuItem);
                if (list == null) continue;
                items.addAll(list);
                continue;
            }
            JSONObject jo = AppMenuItem.toJSONObject(iAppMenuItem, null);
            if (jo == null) continue;
            items.add(jo);
        }
        return JSONArray.fromArray((Object[])items.toArray());
    }
}

