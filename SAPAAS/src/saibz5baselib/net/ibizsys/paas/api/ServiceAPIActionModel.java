/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.core.ModelBase2Impl;

public class ServiceAPIActionModel
extends ModelBase2Impl
implements IServiceAPIAction {
    private String strActionType = null;
    private String strUniqueTag = null;
    private String strDEName = null;

    @Override
    public String getActionType() {
        return this.strActionType;
    }

    public void setActionType(String strActionType) {
        this.strActionType = strActionType;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    public void setUniqueTag(String strUniqueTag) {
        this.strUniqueTag = strUniqueTag;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }
}

