/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.PSJsonNumberSchemaImpl;

public class PSJsonIntegerSchemaImpl
extends PSJsonNumberSchemaImpl {
    @Override
    protected String onGetType() {
        return "integer";
    }

    @Override
    protected int onGetStdDataType() {
        return 9;
    }
}

