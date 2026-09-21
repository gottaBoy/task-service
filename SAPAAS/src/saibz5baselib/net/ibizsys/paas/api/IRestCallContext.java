/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IServiceWebContext;
import net.ibizsys.paas.api.RestCallResult;
import net.ibizsys.paas.web.IWebContext;

public interface IRestCallContext
extends IWebContext,
IServiceWebContext {
    public RestCallResult getRestCallResult();
}

