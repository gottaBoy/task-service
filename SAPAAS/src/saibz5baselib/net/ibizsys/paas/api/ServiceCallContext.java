/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IServiceCallContext;
import net.sf.json.JSONObject;

public class ServiceCallContext
implements IServiceCallContext {
    private String strResultRaw = null;
    private JSONObject joResult = null;

    @Override
    public String getResultRaw() {
        return this.strResultRaw;
    }

    @Override
    public JSONObject getResultJO() {
        return this.joResult;
    }

    @Override
    public void setResultRaw(String strResultRaw) {
        this.strResultRaw = strResultRaw;
    }

    @Override
    public void setResultJO(JSONObject resultJO) {
        this.joResult = resultJO;
    }
}

