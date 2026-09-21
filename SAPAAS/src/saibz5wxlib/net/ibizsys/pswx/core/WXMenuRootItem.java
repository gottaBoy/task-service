/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswx.core.IWXMenuItem
 *  net.sf.json.JSON
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.core;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswx.core.IWXMenuItem;
import net.ibizsys.pswx.core.WXMenuItem;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WXMenuRootItem
extends WXMenuItem {
    protected HashMap<String, WXMenuItem> wxMenuItemMap = new HashMap();

    public WXMenuItem addItem(String strId, String strPId) throws Exception {
        WXMenuItem wxMenuItem = new WXMenuItem();
        wxMenuItem.setId(strId);
        wxMenuItem.setPId(strPId);
        this.wxMenuItemMap.put(strId, wxMenuItem);
        if (StringHelper.isNullOrEmpty((String)strPId)) {
            this.getItems().add(wxMenuItem);
        } else {
            WXMenuItem parentExpBarItem = this.wxMenuItemMap.get(strPId);
            if (parentExpBarItem == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strPId));
            }
            parentExpBarItem.getItems().add(wxMenuItem);
        }
        return wxMenuItem;
    }

    public ArrayList<IWXMenuItem> getAllItems() {
        ArrayList<IWXMenuItem> allItems = new ArrayList<IWXMenuItem>();
        for (IWXMenuItem iExpBarItem : this.getItems()) {
            allItems.add(iExpBarItem);
            this.fillItems(iExpBarItem, allItems);
        }
        return allItems;
    }

    protected void fillItems(IWXMenuItem wxMenuItem, ArrayList<IWXMenuItem> allItems) {
        if (wxMenuItem.getItems() == null) {
            return;
        }
        for (IWXMenuItem childItem : wxMenuItem.getItems()) {
            if (childItem instanceof WXMenuItem) {
                ((WXMenuItem)childItem).setPId(wxMenuItem.getId());
            }
            allItems.add(childItem);
            this.fillItems(childItem, allItems);
        }
    }

    @Override
    public JSONObject toJSON() {
        JSONArray array = new JSONArray();
        for (IWXMenuItem iWXMenuItem : this.wxMenuItemMap.values()) {
            if (!StringHelper.isNullOrEmpty((String)iWXMenuItem.getPId())) continue;
            array.put((JSON)iWXMenuItem.toJSON());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("button", (Object)array);
        return jSONObject;
    }
}

