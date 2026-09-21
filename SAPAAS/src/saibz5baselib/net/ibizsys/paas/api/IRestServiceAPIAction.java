/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IServiceAPIAction;

public interface IRestServiceAPIAction
extends IServiceAPIAction {
    public static final String REQUESTMETHOD_GET = "GET";
    public static final String REQUESTMETHOD_HEAD = "HEAD";
    public static final String REQUESTMETHOD_POST = "POST";
    public static final String REQUESTMETHOD_PUT = "PUT";
    public static final String REQUESTMETHOD_PATCH = "PATCH";
    public static final String REQUESTMETHOD_DELETE = "DELETE";
    public static final String REQUESTMETHOD_OPTIONS = "OPTIONS";
    public static final String REQUESTMETHOD_TRACE = "TRACE";

    public String getActionPath();

    public String getRequestMethod();

    public String getKeyField();
}

