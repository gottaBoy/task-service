/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3ParameterListOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3RequestBodyOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3ResponsesOwner;
import java.util.Iterator;

public interface IPSOpenAPI3Operation
extends IPSOpenAPI3Object,
IPSOpenAPI3ParameterListOwner,
IPSOpenAPI3RequestBodyOwner,
IPSOpenAPI3ResponsesOwner {
    public static final String FIELD_TAGS = "tags";
    public static final String FIELD_SUMMARY = "summary";
    public static final String FIELD_EXTERNALDOCS = "externalDocs";
    public static final String FIELD_OPERATIONID = "operationId";
    public static final String FIELD_PARAMETERS = "parameters";
    public static final String FIELD_REQUESTBODY = "requestBody";
    public static final String FIELD_RESPONSES = "responses";
    public static final String FIELD_CALLBACKS = "callbacks";
    public static final String FIELD_DEPRECATED = "deprecated";
    public static final String FIELD_SECURITY = "security";

    public Iterator<String> getTags();

    public String getOperationId();

    public String getSummary();
}

