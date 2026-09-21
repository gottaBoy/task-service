/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.calendar.ICalendar
 */
package net.ibizsys.model.control.calendar;

import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.paas.control.calendar.ICalendar;

public interface IPSCalendar
extends IPSMDAjaxControl,
ICalendar {
    public static final String CALENDARSTYLE_DAY = "DAY";
    public static final String CALENDARSTYLE_WEEK = "WEEK";
    public static final String CALENDARSTYLE_MONTH = "MONTH";
    public static final String CALENDARSTYLE_USER = "USER";
    public static final String CALENDARSTYLE_USER2 = "USER2";

    public String getCalendarStyle();

    public String getEmptyText();

    public boolean isBufferRenderer();
}

