/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefsOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonObjectSchema;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSJsonSchema
extends IPSJsonObjectSchema,
IPSJsonDefsOwner {
    public static final String FIELD_SCHEMAID = "$id";
    public static final String FIELD_DEFS = "$defs";

    public String getSchemaId();
}

