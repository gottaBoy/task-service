/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchemaOwner;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3Parameter
extends IPSOpenAPI3Object,
IPSJsonNodeSchemaOwner {
    public static final String FIELD_REQUIRED = "required";
    public static final String FIELD_SCHEMA = "schema";
    public static final String FIELD_IN = "in";

    public boolean isRequired();

    public String getIn();
}

