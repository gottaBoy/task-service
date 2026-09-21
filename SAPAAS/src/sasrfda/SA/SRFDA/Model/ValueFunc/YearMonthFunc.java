/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Model.ValueFunc;

import SA.SRFDA.Model.ValueFunc.BaseDateValueFunc;

public class YearMonthFunc
extends BaseDateValueFunc {
    @Override
    public String GetFuncFormat() {
        return "FU_SRFYEARMONTH(%1$s)";
    }

    @Override
    public String GetDataType() {
        return "VARCHAR";
    }
}

