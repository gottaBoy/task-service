/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ExpBarModelBase
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.ExpBarModelBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.ctrlmodel.IWFExpBarModel;

public abstract class WFExpBarModelBase
extends ExpBarModelBase
implements IWFExpBarModel {
    private IWFModel iWFModel = null;

    public String getControlType() {
        return "WFEXPBAR";
    }

    @Override
    public IWFModel getWFModel() {
        return this.iWFModel;
    }

    protected void setWFModel(IWFModel iWFModel) {
        this.iWFModel = iWFModel;
    }

    @Override
    public IWFVersionModel getWFVersionModel() {
        return this.getWFModel().getLastWFVersionModel();
    }
}

