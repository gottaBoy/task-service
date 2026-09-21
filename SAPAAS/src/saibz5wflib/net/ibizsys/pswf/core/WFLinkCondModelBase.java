/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBaseImpl
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.pswf.core.IWFLinkCondModel;

public abstract class WFLinkCondModelBase
extends ModelBaseImpl
implements IWFLinkCondModel {
    private String strPId = "";

    @Override
    public String getPId() {
        return this.strPId;
    }

    public void setPId(String strPId) {
        this.strPId = strPId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }
}

