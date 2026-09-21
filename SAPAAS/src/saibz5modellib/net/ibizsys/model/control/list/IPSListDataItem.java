/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.list.IListDataItem
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.paas.control.list.IListDataItem;

public interface IPSListDataItem
extends IPSDataItem,
IListDataItem {
    public IPSCodeList getFrontPSCodeList();
}

