/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.calendar;

import net.ibizsys.model.control.calendar.IPSSysCalendarItem;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysCalendarItemRV
extends IPSModelObject {
    public String getPSDEViewBaseId();

    public IPSSysCalendarItem getPSSysCalendarItem();

    public String getViewParam();
}

