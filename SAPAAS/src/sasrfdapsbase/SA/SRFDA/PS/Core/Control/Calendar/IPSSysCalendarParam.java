/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.Control.Calendar.IPSCalendarParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u65e5\u5386\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEViewCtrl")
@PSModelRTIgnoreMeta
public interface IPSSysCalendarParam
extends IPSCalendarParam {
    public String getPSSysCalendarId();

    public Boolean isEnableEdit();
}

