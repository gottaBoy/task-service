/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.calendar;

import java.util.Iterator;
import net.ibizsys.model.control.calendar.IPSCalendar;
import net.ibizsys.model.control.calendar.IPSSysCalendarItem;

public interface IPSSysCalendar
extends IPSCalendar {
    public Iterator<IPSSysCalendarItem> getPSSysCalendarItems();

    public IPSSysCalendarItem getPSSysCalendarItem(String var1) throws Exception;
}

