/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IRestCallContext;
import net.ibizsys.paas.api.RestCallResult;
import net.ibizsys.paas.web.util.SimpleWebContext;

public class RestCallContext
extends SimpleWebContext
implements IRestCallContext {
    private RestCallResult restCallResult = null;

    @Override
    public RestCallResult getRestCallResult() {
        return this.restCallResult;
    }

    public void setRestCallResult(RestCallResult restCallResult) {
        this.restCallResult = restCallResult;
    }
}

