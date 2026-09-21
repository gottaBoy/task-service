/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.ServiceAPIModelBase;

public abstract class RestServiceAPIModelBase
extends ServiceAPIModelBase {
    @Override
    public String getAPIType() {
        return "RESTFUL";
    }
}

