/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Model.ValueFunc;

import SA.SRFDA.Model.ValueFunc.BaseDateValueFunc;

public class DateDiffFunc
extends BaseDateValueFunc {
    @Override
    public String GetFuncFormat() {
        return "fu_SRFDateDiff(%1$s,'" + this.valueFuncConfig.GetExtValue("DIFFTYPE", "D") + "')";
    }

    @Override
    public String GetDataType() {
        return "Int";
    }
}

