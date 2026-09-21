/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.api;

import net.sf.json.JSONObject;

public interface IServiceCallContext {
    public String getResultRaw();

    public JSONObject getResultJO();

    public void setResultRaw(String var1);

    public void setResultJO(JSONObject var1);
}

