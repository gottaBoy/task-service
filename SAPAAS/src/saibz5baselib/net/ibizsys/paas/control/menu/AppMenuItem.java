/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.menu;

import java.util.ArrayList;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.control.menu.MenuItem;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public class AppMenuItem
extends MenuItem
implements IAppMenuItem {
    public static final String APPMENUITEM_APPFUNCID = "appfuncid";
    public static final String APPMENUITEM_HIDESIDEBAR = "hidesidebar";
    public static final String APPMENUITEM_OPENDEFAULT = "opendefault";
    public static final String APPMENUITEM_HIDDEN = "hidden";
    public static final String APPMENUITEM_STATE = "state";
    private ArrayList<IAppMenuItem> items = new ArrayList();
    private String strAppFuncId = null;
    private boolean bSeperator = false;
    private boolean bHideSideBar = false;
    private boolean bOpenDefault = false;
    private String strCounterId = null;
    private int nAppMenuItemState = 0;

    @Override
    public String getAppFuncId() {
        return this.strAppFuncId;
    }

    public void setAppFuncId(String strAppFuncId) {
        this.strAppFuncId = strAppFuncId;
    }

    @Override
    public ArrayList<IAppMenuItem> getItems() {
        return this.items;
    }

    public static JSONObject toJSONObject(IAppMenuItem iAppMenuItem, JSONObject jsonObject) throws Exception {
        String strPersonId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty(strPersonId = WebContext.getCurrent().getCurUserId()) && (iAppMenuItem.getAccUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0 && !WebContext.getCurrent().getUserPrivilegeMgr().test(WebContext.getCurrent(), iAppMenuItem.getAccessKey())) {
            return null;
        }
        jsonObject = MenuItem.toJSONObject(iAppMenuItem, jsonObject);
        if (!StringHelper.isNullOrEmpty(iAppMenuItem.getAppFuncId())) {
            jsonObject.put(APPMENUITEM_APPFUNCID, JSONObjectHelper.stripQuotes(iAppMenuItem.getAppFuncId(), true));
        }
        if (iAppMenuItem.isHideSideBar()) {
            jsonObject.put(APPMENUITEM_HIDESIDEBAR, iAppMenuItem.isHideSideBar());
        }
        if (iAppMenuItem.isOpenDefault()) {
            jsonObject.put(APPMENUITEM_OPENDEFAULT, iAppMenuItem.isOpenDefault());
        }
        if (iAppMenuItem.isHidden()) {
            jsonObject.put(APPMENUITEM_HIDDEN, iAppMenuItem.isHidden());
        }
        if (iAppMenuItem.getAppMenuItemState() > 0) {
            jsonObject.put(APPMENUITEM_STATE, iAppMenuItem.getAppMenuItemState());
        }
        if (iAppMenuItem.getItems().size() == 0) {
            jsonObject.put("leaf", true);
        } else {
            ArrayList<JSONObject> items = new ArrayList<JSONObject>();
            for (IAppMenuItem childExpBarItem : iAppMenuItem.getItems()) {
                if (childExpBarItem.getFiller() != null) {
                    ArrayList<JSONObject> list = childExpBarItem.getFiller().toJSONObjects(childExpBarItem);
                    if (list == null) continue;
                    items.addAll(list);
                    continue;
                }
                JSONObject jsonItem = AppMenuItem.toJSONObject(childExpBarItem, null);
                if (jsonItem == null) continue;
                items.add(jsonItem);
            }
            if (items.size() == 0) {
                jsonObject.put("leaf", true);
            } else {
                jsonObject.put("items", (Object)items.toArray());
            }
        }
        return jsonObject;
    }

    @Override
    public boolean isSeperator() {
        return this.bSeperator;
    }

    public void setSeperator(boolean bSeperator) {
        this.bSeperator = bSeperator;
    }

    @Override
    public boolean isHideSideBar() {
        return this.bHideSideBar;
    }

    public void setHideSideBar(boolean bHideSideBar) {
        this.bHideSideBar = bHideSideBar;
    }

    @Override
    public boolean isOpenDefault() {
        return this.bOpenDefault;
    }

    public void setOpenDefault(boolean bOpenDefault) {
        this.bOpenDefault = bOpenDefault;
    }

    @Override
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    public void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }

    @Override
    public int getAppMenuItemState() {
        return this.nAppMenuItemState;
    }

    public void setAppMenuItemState(int nAppMenuItemState) {
        this.nAppMenuItemState = nAppMenuItemState;
    }
}

