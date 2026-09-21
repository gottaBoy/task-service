/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.calendar;

import net.ibizsys.paas.data.IDataItem;

public interface ICalendarItemDataItem
extends IDataItem {
    public boolean isDataAccessAction();

    public String getPrivilegeId();
}

