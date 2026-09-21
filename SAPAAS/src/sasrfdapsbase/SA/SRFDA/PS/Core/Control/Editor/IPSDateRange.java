/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSDatePicker;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u65e5\u671f\u8303\u56f4\u9009\u62e9\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DATERANGE", "MOBDATERANGE"})
public interface IPSDateRange
extends IPSDatePicker {
    @Override
    public String getDateTimeFormat();
}

