/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u65e5\u5386\u90e8\u4ef6\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCalendarLogic")
public interface IPSSysCalendarLogic
extends IPSDEUILogicGroupDetail,
IPSControlObject {
    public IPSSysCalendar getPSSysCalendar();

    public String getPSSysCalendarItemName();
}

