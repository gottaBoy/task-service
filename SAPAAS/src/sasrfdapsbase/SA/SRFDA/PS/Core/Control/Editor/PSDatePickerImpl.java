/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSDatePicker;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"MOBDATE", "DATEPICKER", "DATEPICKEREX", "DATEPICKEREX_HOUR", "DATEPICKEREX_NODAY", "DATEPICKEREX_MINUTE", "DATEPICKEREX_NOTIME", "DATEPICKEREX_SECOND", "DATEPICKEREX_NODAY_NOSECOND"})
public class PSDatePickerImpl
extends PSEditorImpl
implements IPSDatePicker {
    @Override
    @PSModelRTMeta(description="\u65e5\u671f\u65f6\u95f4\u683c\u5f0f")
    public String getDateTimeFormat() {
        return this.getEditorParam("TIMEFMT");
    }
}

