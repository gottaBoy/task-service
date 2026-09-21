/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.gantt;

import net.ibizsys.paas.data.IDataItem;

public interface IGanttItemDataItem
extends IDataItem {
    public boolean isDataAccessAction();

    public String getPrivilegeId();
}

