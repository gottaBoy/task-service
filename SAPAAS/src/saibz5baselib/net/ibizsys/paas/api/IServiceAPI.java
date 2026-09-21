/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.core.IModelBase2;

public interface IServiceAPI
extends IModelBase2 {
    public static final String APITYPE_RESTFUL = "RESTFUL";
    public static final String APITYPE_JAXRS = "JAXRS";
    public static final String APITYPE_WEBSERVICE = "WEBSERVICE";

    public String getAPIType();
}

