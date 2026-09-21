/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IRestServiceAPIAction;
import net.ibizsys.paas.api.ServiceAPIActionModel;

public class RestServiceAPIActionModel
extends ServiceAPIActionModel
implements IRestServiceAPIAction {
    private String strActionPath = "";
    private String strRequestMethod = "GET";
    private String strKeyField = null;

    @Override
    public String getActionPath() {
        return this.strActionPath;
    }

    public void setActionPath(String strActionPath) {
        this.strActionPath = strActionPath;
    }

    @Override
    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    public void setRequestMethod(String strRequestMethod) {
        this.strRequestMethod = strRequestMethod;
    }

    @Override
    public String getKeyField() {
        return this.strKeyField;
    }

    public void setKeyField(String strKeyField) {
        this.strKeyField = strKeyField;
    }
}

