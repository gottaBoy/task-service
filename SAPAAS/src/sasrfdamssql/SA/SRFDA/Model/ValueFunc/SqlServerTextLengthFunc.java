/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Model.ValueFunc.StringLengthFunc
 */
package SA.SRFDA.Model.ValueFunc;

import SA.SRFDA.Model.ValueFunc.StringLengthFunc;

public class SqlServerTextLengthFunc
extends StringLengthFunc {
    public String GetFuncFormat() {
        return "DATALENGTH(%1$s)";
    }

    public String GetDataType() {
        return "Int";
    }
}

