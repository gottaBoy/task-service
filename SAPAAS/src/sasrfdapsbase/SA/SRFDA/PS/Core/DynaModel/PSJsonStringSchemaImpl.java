/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonStringSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonSimpleSchemaImpl;

public class PSJsonStringSchemaImpl
extends PSJsonSimpleSchemaImpl
implements IPSJsonStringSchema {
    @Override
    protected String onGetType() {
        return "string";
    }

    @Override
    protected int onGetStdDataType() {
        return 25;
    }
}

