/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.list.IPSDEList
 *  net.ibizsys.model.control.list.IPSDEListDataItem
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSDEListDataItem;
import net.ibizsys.model.control.list.PSListDataItemImpl;

public class PSDEListDataItemImpl
extends PSListDataItemImpl
implements IPSDEListDataItem {
    private IPSDEList iPSDEList = null;

    public void init(IPSDEList iPSDEList) throws Exception {
        this.iPSDEList = iPSDEList;
        this.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDELISTDATAITEM";
    }

    public IPSDEList getPSDEList() {
        return this.iPSDEList;
    }
}

