/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Contact;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3License;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3Info
extends IPSOpenAPI3Object {
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_VERSION = "version";
    public static final String FIELD_TERMSOFSERVICE = "termsOfService";
    public static final String FIELD_CONTACT = "contact";
    public static final String FIELD_LICENSE = "license";

    public String getTitle();

    public String getAPIVersion();

    public String getTermsOfService();

    public IPSOpenAPI3Contact getPSOpenAPI3Contact();

    public IPSOpenAPI3License getPSOpenAPI3License();
}

