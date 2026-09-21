/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNullSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaImplBase;

public class PSJsonNullSchemaImpl
extends PSJsonNodeSchemaImplBase
implements IPSJsonNullSchema {
    @Override
    protected String onGetType() {
        return "null";
    }
}

