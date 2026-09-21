/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.pswf.controller.IWFDEViewController
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.controller.DynaExpViewControllerInstBase;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.pswf.controller.IDynaWFDEViewControllerInst;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public abstract class DynaWFExpViewControllerInstBase
extends DynaExpViewControllerInstBase
implements IDynaWFDEViewControllerInst {
    private IWFModel iWFModel = null;
    private IDEWF iDEWF = null;
    private String strWFStepValue = "";
    private int nWFVersion = -1;

    @Override
    protected void onInit() throws Exception {
        if (this.getDynaViewController() instanceof IWFDEViewController) {
            IWFDEViewController iWFDEViewController = (IWFDEViewController)this.getDynaViewController();
            this.setWFModel(iWFDEViewController.getWFModel());
            this.setDEWF(iWFDEViewController.getDEWF());
        }
        super.onInit();
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

    @Override
    protected void onLoadJsonObject(ObjectNode viewModelNode) throws Exception {
        super.onLoadJsonObject(viewModelNode);
        this.setWFStepValue(JsonNodeHelper.getString((ObjectNode)viewModelNode, (String)"wfstepvalue", (String)this.getWFStepValue()));
    }
}

