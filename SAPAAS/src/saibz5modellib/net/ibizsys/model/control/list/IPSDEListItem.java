/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSListItem;

public interface IPSDEListItem
extends IPSListItem {
    public IPSDEList getPSDEList();

    public int getWidth();

    public String getDataItemName();

    public String getValueFormat();
}

