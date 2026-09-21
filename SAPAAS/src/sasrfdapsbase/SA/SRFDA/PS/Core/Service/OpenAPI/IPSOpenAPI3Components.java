/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefsOwner;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3JsonNodeSchemas;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameters;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3Components
extends IPSOpenAPI3Object,
IPSJsonDefsOwner {
    public static final String FIELD_SCHEMAS = "schemas";
    public static final String FIELD_RESPONSES = "responses";
    public static final String FIELD_PARAMETERS = "parameters";
    public static final String FIELD_EXAMPLES = "examples";
    public static final String FIELD_REQUESTBODIES = "requestBodies";
    public static final String FIELD_HEADERS = "headers";
    public static final String FIELD_SECURITYSCHEMES = "securitySchemes";
    public static final String FIELD_LINKS = "links";
    public static final String FIELD_CALLBACKS = "callbacks";

    public IPSOpenAPI3JsonNodeSchemas getPSOpenAPI3JsonNodeSchemas();

    public IPSOpenAPI3Parameters getPSOpenAPI3Parameters();
}

