/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.CallResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RemoteCallResult
extends CallResult {
    private Object content = null;
    private Object items = null;
    private JSONArray jaContent = null;
    private JSONObject joContent = null;
    private JSONArray jaItems = null;

    public void from(JSONObject joRet) {
        this.setRetCode(joRet.optInt("ret", 0));
        this.setErrorInfo(joRet.optString("info"));
        this.content = joRet.opt("content");
        if (this.content != null) {
            if (this.content instanceof JSONArray) {
                this.jaContent = (JSONArray)this.content;
            }
            if (this.content instanceof JSONObject) {
                this.joContent = (JSONObject)this.content;
            }
        }
        this.items = joRet.opt("items");
        if (this.items != null && this.items instanceof JSONArray) {
            this.jaItems = (JSONArray)this.items;
        }
    }

    public Object getContent() {
        return this.content;
    }

    public JSONArray getJAContent() {
        return this.jaContent;
    }

    public JSONObject getJOContent() {
        return this.joContent;
    }

    public JSONArray getItems() {
        return this.jaItems;
    }
}

