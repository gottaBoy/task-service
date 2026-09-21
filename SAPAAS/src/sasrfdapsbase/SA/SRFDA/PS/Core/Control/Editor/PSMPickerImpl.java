/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSMPicker;
import SA.SRFDA.PS.Core.Control.Editor.PSPickerImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"MOBMPICKER"})
public class PSMPickerImpl
extends PSPickerImpl
implements IPSMPicker {
    @Override
    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9", staticcode="false")
    public boolean isSingleSelect() {
        return false;
    }
}

