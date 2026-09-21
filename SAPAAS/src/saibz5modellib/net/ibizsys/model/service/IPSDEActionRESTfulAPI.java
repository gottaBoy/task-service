/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.service;

import net.ibizsys.model.service.IPSRESTfulAPI;

public interface IPSDEActionRESTfulAPI
extends IPSRESTfulAPI {
    public static final String REQUESTPARAMTYPE_NONE = "NONE";
    public static final String REQUESTPARAMTYPE_FIELD = "FIELD";
    public static final String REQUESTPARAMTYPE_ENTITY = "ENTITY";

    public String getRequestParamType();

    public String getRequestField();
}

