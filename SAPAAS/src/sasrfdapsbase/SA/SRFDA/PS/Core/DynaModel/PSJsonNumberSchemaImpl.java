/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNumberSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonSimpleSchemaImpl;

public class PSJsonNumberSchemaImpl
extends PSJsonSimpleSchemaImpl
implements IPSJsonNumberSchema {
    @Override
    protected String onGetType() {
        return "number";
    }

    @Override
    protected int onGetStdDataType() {
        return 6;
    }
}

