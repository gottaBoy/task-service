/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.expbar;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.util.StringHelper;

public class ExpBarRootItem
extends ExpBarItem {
    protected HashMap<String, ExpBarItem> expBarItemMap = new HashMap();

    public ExpBarItem addItem(String strId, String strPId) throws Exception {
        ExpBarItem expBarItem = new ExpBarItem();
        expBarItem.setId(strId);
        expBarItem.setPId(strPId);
        this.expBarItemMap.put(strId, expBarItem);
        if (StringHelper.isNullOrEmpty(strPId)) {
            this.getItems().add(expBarItem);
        } else {
            ExpBarItem parentExpBarItem = this.expBarItemMap.get(strPId);
            if (parentExpBarItem == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9\uff0c\u6807\u8bc6\u4e3a[%1$s]", strPId));
            }
            parentExpBarItem.getItems().add(expBarItem);
        }
        return expBarItem;
    }

    public ExpBarItem getItem(String strId, boolean bTryMode) throws Exception {
        ExpBarItem expBarItem = this.expBarItemMap.get(strId);
        if (expBarItem == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8282\u70b9\uff0c\u6807\u8bc6\u4e3a[%1$s]", strId));
        }
        return expBarItem;
    }

    public ArrayList<IExpBarItem> getAllItems() {
        ArrayList<IExpBarItem> allItems = new ArrayList<IExpBarItem>();
        for (IExpBarItem iExpBarItem : this.getItems()) {
            allItems.add(iExpBarItem);
            this.fillItems(iExpBarItem, allItems);
        }
        return allItems;
    }

    protected void fillItems(IExpBarItem expBarItem, ArrayList<IExpBarItem> allItems) {
        for (IExpBarItem childItem : expBarItem.getItems()) {
            if (childItem instanceof ExpBarItem) {
                ((ExpBarItem)childItem).setPId(expBarItem.getId());
            }
            allItems.add(childItem);
            this.fillItems(childItem, allItems);
        }
    }
}

