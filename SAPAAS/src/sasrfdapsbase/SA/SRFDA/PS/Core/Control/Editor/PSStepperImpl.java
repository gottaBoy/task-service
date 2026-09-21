/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSStepper;
import SA.SRFDA.PS.Core.Control.Editor.PSNumberEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"STEPPER", "MOBSTEPPER"})
public class PSStepperImpl
extends PSNumberEditorImpl
implements IPSStepper {
    @Override
    @PSModelRTMeta(description="\u6b65\u8fdb\u503c[STEPVALUE]")
    public Double getStepValue() {
        return this.getEditorParam("STEPVALUE", this.getDefaultStepValue());
    }

    protected Double getDefaultStepValue() {
        return 1.0;
    }
}

