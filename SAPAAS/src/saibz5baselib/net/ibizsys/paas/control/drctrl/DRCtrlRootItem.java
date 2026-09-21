/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.drctrl;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.util.StringHelper;

public class DRCtrlRootItem
extends DRCtrlItem {
    protected HashMap<String, DRCtrlItem> expBarItemMap = new HashMap();
    private boolean bRootVisible = true;

    public DRCtrlItem addItem(String strId, String strPId) throws Exception {
        DRCtrlItem expBarItem = new DRCtrlItem();
        expBarItem.setId(strId);
        expBarItem.setPId(strPId);
        this.expBarItemMap.put(strId, expBarItem);
        if (StringHelper.isNullOrEmpty(strPId)) {
            this.getItems().add(expBarItem);
        } else {
            DRCtrlItem parentExpBarItem = this.expBarItemMap.get(strPId);
            if (parentExpBarItem == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9\uff0c\u6807\u8bc6\u4e3a[%1$s]", strPId));
            }
            parentExpBarItem.getItems().add(expBarItem);
        }
        return expBarItem;
    }

    public ArrayList<IDRCtrlItem> getAllItems() {
        ArrayList<IDRCtrlItem> allItems = new ArrayList<IDRCtrlItem>();
        for (IDRCtrlItem iExpBarItem : this.getItems()) {
            allItems.add(iExpBarItem);
            this.fillItems(iExpBarItem, allItems);
        }
        return allItems;
    }

    protected void fillItems(IDRCtrlItem expBarItem, ArrayList<IDRCtrlItem> allItems) {
        for (IDRCtrlItem childItem : expBarItem.getItems()) {
            if (childItem instanceof DRCtrlItem) {
                ((DRCtrlItem)childItem).setPId(expBarItem.getId());
            }
            allItems.add(childItem);
            this.fillItems(childItem, allItems);
        }
    }

    public boolean isRootVisible() {
        return this.bRootVisible;
    }

    public void setRootVisible(boolean bRootVisible) {
        this.bRootVisible = bRootVisible;
    }
}

