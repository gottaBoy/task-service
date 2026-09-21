/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswx.core.IWXMenuItem
 *  net.sf.json.JSON
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.core;

import java.util.ArrayList;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswx.core.IWXMenuItem;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WXMenuItem
implements IWXMenuItem {
    public static final String WXMENUITEM_ID = "id";
    public static final String WXMENUITEM_PID = "pid";
    public static final String WXMENUITEM_TEXT = "text";
    private String strId = "";
    private String strText = "";
    private String strPId = "";
    private String strWXFunc = "";
    private String strClickTag = "";
    private ArrayList<IWXMenuItem> items = new ArrayList();

    public String getId() {
        return this.strId;
    }

    public String getText() {
        return this.strText;
    }

    public String getPId() {
        return this.strPId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public void setPId(String strPId) {
        this.strPId = strPId;
    }

    public String getWXFunc() {
        return this.strWXFunc;
    }

    public void setWXFunc(String strWXFunc) {
        this.strWXFunc = strWXFunc;
    }

    public ArrayList<IWXMenuItem> getItems() {
        return this.items;
    }

    public String getClickTag() {
        return this.strClickTag;
    }

    public void setClickTag(String strClickTag) {
        this.strClickTag = strClickTag;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("name", JSONObjectHelper.stripQuotes((String)this.getText(), (boolean)true));
        if (this.items.size() <= 0) {
            json.put("type", (Object)this.getWXFunc());
            if (StringHelper.isNullOrEmpty((String)this.getClickTag())) {
                json.put("key", (Object)this.getId());
            } else {
                json.put("key", (Object)this.getClickTag());
            }
        }
        JSONArray array = new JSONArray();
        for (IWXMenuItem item : this.items) {
            array.put((JSON)item.toJSON());
        }
        json.put("sub_button", (Object)array);
        return json;
    }
}

