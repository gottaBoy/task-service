/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.list.IPSDEList
 *  net.ibizsys.model.control.list.IPSDEListItem
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSDEListItem;
import net.ibizsys.model.entity.PSDEListItem;

public interface IPSDEListItemRuntime
extends IPSDEListItem {
    public void init(IPSModelStorageContext var1, IPSDEList var2, PSDEListItem var3) throws Exception;
}

