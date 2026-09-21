/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.data.IDataItem;

public interface IGridDataItem
extends IDataItem {
    public static final String GROUPITEM_GROUP1 = "GROUP1";
    public static final String GROUPITEM_GROUP2 = "GROUP2";
    public static final String GROUPITEM_GROUP3 = "GROUP3";
    public static final String GROUPITEM_GROUP4 = "GROUP4";

    public boolean isDataAccessAction();

    public String getPrivilegeId();
}

