/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonBooleanSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonSimpleSchemaImpl;

public class PSJsonBooleanSchemaImpl
extends PSJsonSimpleSchemaImpl
implements IPSJsonBooleanSchema {
    @Override
    protected String onGetType() {
        return "boolean";
    }

    @Override
    protected int onGetStdDataType() {
        return 9;
    }
}

