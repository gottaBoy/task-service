/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.calendar.ICalendar
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSMDControl2;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import net.ibizsys.paas.control.calendar.ICalendar;

@PSModelInterfaceMeta(title="\u65e5\u5386\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSCalendar
extends IPSMDAjaxControl,
ICalendar,
IPSControlContainer,
IPSControlNavigatable,
IPSMDControl2 {
    public static final String CALENDARSTYLE_DAY = "DAY";
    public static final String CALENDARSTYLE_WEEK = "WEEK";
    public static final String CALENDARSTYLE_MONTH = "MONTH";
    public static final String CALENDARSTYLE_TIMELINE = "TIMELINE";
    public static final String CALENDARSTYLE_WEEK_TIMELINE = "WEEK_TIMELINE";
    public static final String CALENDARSTYLE_MONTH_TIMELINE = "MONTH_TIMELINE";
    public static final String CALENDARSTYLE_USER = "USER";
    public static final String CALENDARSTYLE_USER2 = "USER2";

    public String getCalendarStyle();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    @Override
    public boolean isBufferRenderer();

    public boolean isEnableEdit();
}

