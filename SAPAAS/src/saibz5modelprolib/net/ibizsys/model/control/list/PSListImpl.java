/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.list.IPSList
 *  net.ibizsys.model.control.list.IPSListDataItem
 *  net.ibizsys.model.control.list.IPSListItem
 *  net.ibizsys.paas.control.list.IListDataItem
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.list;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.PSMDAjaxControlImpl;
import net.ibizsys.model.control.list.IPSList;
import net.ibizsys.model.control.list.IPSListDataItem;
import net.ibizsys.model.control.list.IPSListItem;
import net.ibizsys.paas.control.list.IListDataItem;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSListImpl
extends PSMDAjaxControlImpl
implements IPSList {
    private ArrayList<IPSListItem> psListItemList = new ArrayList();
    private ArrayList<IPSListDataItem> psListDataItemList = new ArrayList();
    private ArrayList<IListDataItem> listDataItemList = new ArrayList();

    protected void addPSListDataItem(IPSListDataItem iPSListDataItem) throws Exception {
        this.psListDataItemList.add(iPSListDataItem);
        this.listDataItemList.add((IListDataItem)iPSListDataItem);
    }

    protected void addPSListItem(IPSListItem iPSListItem) throws Exception {
        this.psListItemList.add(iPSListItem);
    }

    @PSModelRTMeta(description="\u5217\u8868\u9879\u96c6\u5408")
    public Iterator<IPSListItem> getPSListItems() {
        return this.psListItemList.iterator();
    }

    @PSModelRTMeta(description="\u5217\u8868\u6570\u636e\u9879\u96c6\u5408")
    public Iterator<IPSListDataItem> getPSListDataItems() {
        return this.psListDataItemList.iterator();
    }

    public Iterator<IListDataItem> getListDataItems() {
        return this.listDataItemList.iterator();
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSListItem psListItemList : this.psListItemList) {
            if (psListItemList.getPSCodeList() == null) continue;
            relatedPSCodeListList.add(psListItemList.getPSCodeList());
        }
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
    }

    public IPSListDataItem getPSListDataItem(String strDataItemName, boolean bTryMode) throws Exception {
        for (IPSListDataItem iPSListDataItem : this.psListDataItemList) {
            if (StringHelper.compare((String)strDataItemName, (String)iPSListDataItem.getName(), (boolean)false) != 0) continue;
            return iPSListDataItem;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5217\u8868\u6570\u636e\u9879[%1$s]", (Object)strDataItemName));
    }
}

