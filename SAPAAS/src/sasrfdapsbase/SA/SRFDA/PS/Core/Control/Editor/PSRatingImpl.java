/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSRating;
import SA.SRFDA.PS.Core.Control.Editor.PSStepperImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"RATING", "MOBRATING"})
public class PSRatingImpl
extends PSStepperImpl
implements IPSRating {
    @Override
    protected Double getDefaultMinValue() {
        Double fValue = super.getDefaultMinValue();
        if (fValue != null) {
            return fValue;
        }
        return 0.0;
    }

    @Override
    protected Double getDefaultMaxValue() {
        Double fValue = super.getDefaultMaxValue();
        if (fValue != null) {
            return fValue;
        }
        return 5.0;
    }
}

