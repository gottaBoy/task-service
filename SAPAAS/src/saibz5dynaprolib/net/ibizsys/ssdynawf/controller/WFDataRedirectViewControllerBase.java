/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.pswf.controller.IWFDEViewController
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdynawf.controller;

import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.ssdyna.controller.RedirectViewControllerBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFDataRedirectViewControllerBase
extends RedirectViewControllerBase
implements IWFDEViewController {
    private ThreadLocal<IDataEntityModel> curDEModel = new ThreadLocal();
    private static final Log log = LogFactory.getLog(WFDataRedirectViewControllerBase.class);
    private IWFModel iWFModel = null;
    private IDEWF iDEWF = null;
    private boolean bWFIAMode = false;
    private String strWFStepValue = "";
    private int nWFVersion = -1;

    public WFDataRedirectViewControllerBase() throws Exception {
        this.setEnableWorkflow(true);
    }

    @Override
    protected AjaxActionResult onGetRDView(boolean bUrlMode) throws Exception {
        String strDEId = this.getWebContext().getViewParamValue("srfdeid");
        if (StringHelper.isNullOrEmpty((String)strDEId)) {
            strDEId = this.getWebContext().getPostOrParamValue("srfdeid");
        }
        if (StringHelper.isNullOrEmpty((String)strDEId)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u5b9e\u4f53"));
        }
        this.curDEModel.set(this.getSystemModel().getDataEntityModel(strDEId));
        return super.onGetRDView(bUrlMode);
    }

    public IDataEntityModel getDEModel() {
        return this.getRealDEModel();
    }

    public IService getService() {
        return this.getRealService();
    }

    @Override
    public IDataEntityModel getRealDEModel() {
        return this.curDEModel.get();
    }

    @Override
    public IService getRealService() {
        try {
            return this.getRealDEModel().getService(this.getSessionFactory());
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
            return null;
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

