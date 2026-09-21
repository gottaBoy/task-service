/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dataview.IDataViewDataItem
 */
package net.ibizsys.model.control.dataview;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;

public interface IPSDEDataViewDataItem
extends IPSDataItem,
IDataViewDataItem {
    public IPSCodeList getFrontPSCodeList();

    public IPSDEDataView getPSDEDataView();
}

