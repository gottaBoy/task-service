/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Model.ValueFunc;

import SA.SRFDA.Model.ValueFunc.BaseStringValueFunc;

public class StringLengthFunc
extends BaseStringValueFunc {
    @Override
    public String GetFuncFormat() {
        return "LENGTH(%1$s)";
    }

    @Override
    public String GetDataType() {
        return "Int";
    }
}

