/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.list.IListDataItem
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.List.IPSList;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Control.List.IPSListItem;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlContainerImpl2;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.list.IListDataItem;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSListImpl
extends PSMDAjaxControlContainerImpl2
implements IPSList {
    private ArrayList<IPSListItem> psListItemList = new ArrayList();
    private ArrayList<IPSListDataItem> psListDataItemList = new ArrayList();
    private ArrayList<IListDataItem> listDataItemList = new ArrayList();

    protected void addPSListDataItem(IPSListDataItem iPSListDataItem) throws Exception {
        this.psListDataItemList.add(iPSListDataItem);
        this.listDataItemList.add(iPSListDataItem);
    }

    protected void addPSListItem(IPSListItem iPSListItem) throws Exception {
        this.psListItemList.add(iPSListItem);
    }

    @Override
    @PSModelRTMeta(description="\u5217\u8868\u9879\u96c6\u5408")
    public Iterator<IPSListItem> getPSListItems() {
        return this.psListItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u8868\u6570\u636e\u9879\u96c6\u5408")
    public Iterator<IPSListDataItem> getPSListDataItems() {
        return this.psListDataItemList.iterator();
    }

    public Iterator<IListDataItem> getListDataItems() {
        return this.listDataItemList.iterator();
    }

    @Override
    public String getModelScope() {
        return null;
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSListItem psListItemList : this.psListItemList) {
            if (psListItemList.getPSCodeList() == null) continue;
            relatedPSCodeListList.add(psListItemList.getPSCodeList());
        }
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
    }

    @Override
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

