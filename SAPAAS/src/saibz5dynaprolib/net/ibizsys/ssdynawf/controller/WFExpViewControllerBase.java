/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.pswf.controller.IWFDEViewController
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.ssdynawf.controller;

import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.ssdyna.controller.ExpViewControllerBase;

public abstract class WFExpViewControllerBase
extends ExpViewControllerBase
implements IWFDEViewController {
    private IWFModel iWFModel = null;
    private IDEWF iDEWF = null;
    private String strWFStepValue = "";
    private int nWFVersion = -1;

    public IWFModel getWFModel() {
        return this.iWFModel;
    }

    protected void setWFModel(IWFModel iWFModel) {
        this.iWFModel = iWFModel;
    }

    public IWFVersionModel getWFVersionModel() {
        return this.getWFModel().getLastWFVersionModel();
    }

    public IDEWF getDEWF() {
        return this.iDEWF;
    }

    protected void setDEWF(IDEWF iDEWF) {
        this.iDEWF = iDEWF;
    }

    public boolean isWFIAMode() {
        return false;
    }

    public String getWFStepValue() {
        return this.strWFStepValue;
    }

    public void setWFStepValue(String strWFStepValue) {
        this.strWFStepValue = strWFStepValue;
    }

    public int getWFVersion() {
        return this.nWFVersion;
    }

    public void setWFVersion(int nWFVersion) {
        this.nWFVersion = nWFVersion;
    }
}

