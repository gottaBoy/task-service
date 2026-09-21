/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFEmbedWFReturnModel;
import net.ibizsys.pswf.core.WFLinkModelBase;

public abstract class WFEmbedWFReturnModelBase
extends WFLinkModelBase
implements IWFEmbedWFReturnModel {
    private String strNextCondition = "ALL";
    private String strReturnValue = "";

    @Override
    public String getNextCondition() {
        return this.strNextCondition;
    }

    @Override
    protected void setNextCondition(String strNextCondition) {
        this.strNextCondition = strNextCondition;
    }

    @Override
    public String getReturnValue() {
        return this.strReturnValue;
    }

    protected void setReturnValue(String strReturnValue) {
        this.strReturnValue = strReturnValue;
    }
}

