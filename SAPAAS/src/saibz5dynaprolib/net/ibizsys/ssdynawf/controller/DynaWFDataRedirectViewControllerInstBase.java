/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdynawf.controller;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.ssdyna.controller.DynaRedirectViewControllerInstBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DynaWFDataRedirectViewControllerInstBase
extends DynaRedirectViewControllerInstBase {
    private ThreadLocal<IDataEntityModel> curDEModel = new ThreadLocal();
    private static final Log log = LogFactory.getLog(DynaWFDataRedirectViewControllerInstBase.class);

    public DynaWFDataRedirectViewControllerInstBase() throws Exception {
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

    @Override
    public IDataEntityModel getDEModel() {
        return this.getRealDEModel();
    }

    @Override
    public IService getService() {
        return this.getRealService();
    }

    public IDataEntityModel getRealDEModel() {
        return this.curDEModel.get();
    }

    public IService getRealService() {
        try {
            return this.getRealDEModel().getService(this.getSessionFactory());
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
            return null;
        }
    }
}

