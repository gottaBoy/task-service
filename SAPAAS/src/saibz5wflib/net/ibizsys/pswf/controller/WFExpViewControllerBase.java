/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.ExpViewControllerBase
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.ExpViewControllerBase;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public abstract class WFExpViewControllerBase
extends ExpViewControllerBase
implements IWFDEViewController {
    private IWFModel iWFModel = null;
    private IDEWF iDEWF = null;
    private String strWFStepValue = "";
    private int nWFVersion = -1;

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

    @Override
    public IDEWF getDEWF() {
        return this.iDEWF;
    }

    protected void setDEWF(IDEWF iDEWF) {
        this.iDEWF = iDEWF;
    }

    @Override
    public boolean isWFIAMode() {
        return false;
    }

    @Override
    public String getWFStepValue() {
        return this.strWFStepValue;
    }

    public void setWFStepValue(String strWFStepValue) {
        this.strWFStepValue = strWFStepValue;
    }

    @Override
    public int getWFVersion() {
        return this.nWFVersion;
    }

    public void setWFVersion(int nWFVersion) {
        this.nWFVersion = nWFVersion;
    }
}

