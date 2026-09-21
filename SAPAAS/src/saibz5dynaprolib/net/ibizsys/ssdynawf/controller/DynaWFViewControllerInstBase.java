/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 *  net.ibizsys.model.app.view.IPSAppDEWFView
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.pswf.controller.IWFDEViewController
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.ssdynawf.controller;

import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.ssdyna.controller.DynaViewControllerInstBase;

public abstract class DynaWFViewControllerInstBase
extends DynaViewControllerInstBase
implements IWFDEViewController {
    private IWFModel iWFModel = null;
    private IDEWF iDEWF = null;
    private boolean bWFIAMode = false;
    private String strWFStepValue = "";
    private int nWFVersion = -1;

    @Override
    protected void onPrepareDynaViewController() throws Exception {
        super.onPrepareDynaViewController();
        if (this.getPSAppView().isEnableWF() && this.getPSAppView() instanceof IPSAppDEWFView) {
            IPSAppDEWFView iPSAppDEWFView = (IPSAppDEWFView)this.getPSAppView();
            this.setWFModel(this.getSystemModel().getWFModel(iPSAppDEWFView.getPSWorkflow().getId()));
            if (iPSAppDEWFView.isWFIAMode()) {
                IPSAppDEWFActionView iPSAppDEWFActionView = (IPSAppDEWFActionView)iPSAppDEWFView;
                this.setWFIAMode(true);
                this.setWFStepValue(iPSAppDEWFActionView.getWFStepValue());
            }
            if (iPSAppDEWFView.getPSDEWF() != null) {
                this.setDEWF(this.getDEModel().getDEWF(iPSAppDEWFView.getPSDEWF().getId()));
            }
        }
    }

    public IWFModel getWFModel() {
        return this.iWFModel;
    }

    protected void setWFModel(IWFModel iWFModel) {
        this.iWFModel = iWFModel;
    }

    public IWFVersionModel getWFVersionModel() {
        return this.getWFModel().getLastWFVersionModel();
    }

    public boolean isWFIAMode() {
        return this.bWFIAMode;
    }

    protected void setWFIAMode(boolean bWFIAMode) {
        this.bWFIAMode = bWFIAMode;
    }

    public IDEWF getDEWF() {
        return this.iDEWF;
    }

    protected void setDEWF(IDEWF iDEWF) {
        this.iDEWF = iDEWF;
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

