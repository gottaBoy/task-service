/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Components;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Info;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Paths;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(implement="PSOpenAPI3SchemaImpl")
public interface IPSOpenAPI3Schema
extends IPSOpenAPI3Object {
    public static final String FIELD_COMPONENTS = "components";
    public static final String FIELD_PATHS = "paths";
    public static final String FIELD_INFO = "info";

    public IPSOpenAPI3Info getPSOpenAPI3Info();

    public IPSOpenAPI3Components getPSOpenAPI3Components();

    public IPSOpenAPI3Paths getPSOpenAPI3Paths();
}

