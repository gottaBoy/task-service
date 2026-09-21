/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3OperationListOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3ParameterListOwner;

public interface IPSOpenAPI3Path
extends IPSOpenAPI3Object,
IPSOpenAPI3ParameterListOwner,
IPSOpenAPI3OperationListOwner {
    public static final String FIELD_SUMMARY = "summary";
    public static final String FIELD_GET = "get";
    public static final String FIELD_PUT = "put";
    public static final String FIELD_POST = "post";
    public static final String FIELD_DELETE = "delete";
    public static final String FIELD_OPTIONS = "options";
    public static final String FIELD_HEADER = "header";
    public static final String FIELD_PATCH = "patch";
    public static final String FIELD_TRACE = "trace";
    public static final String FIELD_PARAMETERS = "parameters";

    public String getSummary();

    public IPSOpenAPI3Operation getGetPSOpenAPI3Operation();

    public IPSOpenAPI3Operation getPutPSOpenAPI3Operation();

    public IPSOpenAPI3Operation getPostPSOpenAPI3Operation();

    public IPSOpenAPI3Operation getDeletePSOpenAPI3Operation();

    public IPSOpenAPI3Operation getOptionsPSOpenAPI3Operation();

    public IPSOpenAPI3Operation getHeaderPSOpenAPI3Operation();

    public IPSOpenAPI3Operation getPatchPSOpenAPI3Operation();

    public IPSOpenAPI3Operation getTracePSOpenAPI3Operation();

    public IPSOpenAPI3Operation getPSOpenAPI3Operation(String var1, boolean var2) throws Exception;
}

