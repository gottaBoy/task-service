/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.Control.Calendar.IPSDECalendar;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u65e5\u5386\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCalendar")
public interface IPSSysCalendar
extends IPSDECalendar {
    public Iterator<IPSSysCalendarItem> getPSSysCalendarItems();

    public IPSSysCalendarItem getPSSysCalendarItem(String var1) throws Exception;

    public Iterator<? extends IPSSysCalendarLogic> getPSSysCalendarLogics();
}

