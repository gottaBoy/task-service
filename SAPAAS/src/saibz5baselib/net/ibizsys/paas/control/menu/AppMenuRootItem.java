/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.menu;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.util.StringHelper;

public class AppMenuRootItem
extends AppMenuItem {
    protected HashMap<String, AppMenuItem> appMenuItemMap = new HashMap();

    public AppMenuItem addItem(String strId, String strPId) throws Exception {
        AppMenuItem appMenuItem = new AppMenuItem();
        appMenuItem.setId(strId);
        appMenuItem.setPId(strPId);
        this.appMenuItemMap.put(strId, appMenuItem);
        if (StringHelper.isNullOrEmpty(strPId)) {
            this.getItems().add(appMenuItem);
        } else {
            AppMenuItem parentExpBarItem = this.appMenuItemMap.get(strPId);
            if (parentExpBarItem == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9\uff0c\u6807\u8bc6\u4e3a[%1$s]", strPId));
            }
            parentExpBarItem.getItems().add(appMenuItem);
        }
        return appMenuItem;
    }

    public ArrayList<IAppMenuItem> getAllItems() {
        ArrayList<IAppMenuItem> allItems = new ArrayList<IAppMenuItem>();
        for (IAppMenuItem iExpBarItem : this.getItems()) {
            allItems.add(iExpBarItem);
            this.fillItems(iExpBarItem, allItems);
        }
        return allItems;
    }

    protected void fillItems(IAppMenuItem appMenuItem, ArrayList<IAppMenuItem> allItems) {
        if (appMenuItem.getItems() == null) {
            return;
        }
        for (IAppMenuItem childItem : appMenuItem.getItems()) {
            if (childItem instanceof AppMenuItem) {
                ((AppMenuItem)childItem).setPId(appMenuItem.getId());
            }
            allItems.add(childItem);
            this.fillItems(childItem, allItems);
        }
    }
}

