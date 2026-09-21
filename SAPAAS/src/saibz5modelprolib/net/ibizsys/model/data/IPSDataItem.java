/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.data.IDataItem
 */
package net.ibizsys.model.data;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.data.IDataItem;

public interface IPSDataItem
extends IDataItem,
IPSModelObject {
    public IPSCodeList getPSCodeList();
}

