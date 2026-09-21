/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEActionRESTfulAPI
extends IPSRESTfulAPI {
    public static final String REQUESTPARAMTYPE_NONE = "NONE";
    public static final String REQUESTPARAMTYPE_FIELD = "FIELD";
    public static final String REQUESTPARAMTYPE_FIELDS = "FIELDS";
    public static final String REQUESTPARAMTYPE_ENTITY = "ENTITY";
    public static final String REQUESTPARAMTYPE_ENTITIES = "ENTITIES";
    public static final String REQUESTPARAMTYPE_URIPARAM = "URIPARAM";

    public String getRequestParamType();

    public String getRequestField();
}

