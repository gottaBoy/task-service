/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.map;

import net.ibizsys.paas.data.IDataItem;

public interface IMapItemDataItem
extends IDataItem {
    public boolean isDataAccessAction();

    public String getPrivilegeId();
}

