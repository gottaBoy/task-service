/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBarParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u65e5\u5386\u5bfc\u822a\u680f\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSCalendarExpBarParam
extends IPSExpBarParam {
    public String getPSSysCalendarId();

    public Boolean isEnableEdit();
}

