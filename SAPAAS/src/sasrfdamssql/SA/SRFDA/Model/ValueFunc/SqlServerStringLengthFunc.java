/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Model.ValueFunc.StringLengthFunc
 */
package SA.SRFDA.Model.ValueFunc;

import SA.SRFDA.Model.ValueFunc.StringLengthFunc;

public class SqlServerStringLengthFunc
extends StringLengthFunc {
    public String GetFuncFormat() {
        return "LEN(%1$s)";
    }

    public String GetDataType() {
        return "Int";
    }
}

