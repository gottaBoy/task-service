/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRRegExCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"REGEX"})
public class PSDEFVRRegExConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRRegExCondition {
    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f", fields={"CONDVALUE"})
    public String getRegExCode() {
        return this.psDEFValueRuleCond.getCONDVALUE();
    }
}

