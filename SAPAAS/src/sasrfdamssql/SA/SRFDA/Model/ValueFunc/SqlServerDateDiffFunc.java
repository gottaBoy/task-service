/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Model.ValueFunc.DateDiffFunc
 */
package SA.SRFDA.Model.ValueFunc;

import SA.SRFDA.Model.ValueFunc.DateDiffFunc;

public class SqlServerDateDiffFunc
extends DateDiffFunc {
    public String GetFuncFormat() {
        String str = super.GetFuncFormat();
        return "dbo." + str;
    }
}

