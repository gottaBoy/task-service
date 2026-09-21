/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3Contact
extends IPSOpenAPI3Object {
    public static final String FIELD_NAME = "name";
    public static final String FIELD_URL = "url";
    public static final String FIELD_EMAIL = "email";

    @Override
    public String getName();

    public String getUrl();

    public String getEmail();
}

