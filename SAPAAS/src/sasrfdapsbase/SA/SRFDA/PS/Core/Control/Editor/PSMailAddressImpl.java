/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSMailAddress;
import SA.SRFDA.PS.Core.Control.Editor.PSPickerEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"ADDRESSPICKUP", "ADDRESSPICKUP_AC"})
public class PSMailAddressImpl
extends PSPickerEditorImpl
implements IPSMailAddress {
    @Override
    @PSModelRTMeta(description="\u652f\u6301\u9009\u62e9\u89c6\u56fe")
    public boolean isEnablePickupView() {
        return this.getEditorParam("PICKUPVIEW", true);
    }
}

