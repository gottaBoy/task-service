/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u65e5\u671f\u65f6\u95f4\u9009\u62e9\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"MOBDATE", "DATEPICKER", "DATEPICKEREX", "DATEPICKEREX_HOUR", "DATEPICKEREX_NODAY", "DATEPICKEREX_MINUTE", "DATEPICKEREX_NOTIME", "DATEPICKEREX_SECOND", "DATEPICKEREX_NODAY_NOSECOND"})
public interface IPSDatePicker
extends IPSEditor {
    public static final String EDITORPARAM_TIMEFMT = "TIMEFMT";

    public String getDateTimeFormat();
}

