/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.appmodel.IApplicationModel
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IDynaViewSetting
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.ssdyna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdyna.controller.ViewControllerBase;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class DynaViewControllerInstBase
extends ViewControllerBase
implements IDynaViewInstModel {
    private static final Log log = LogFactory.getLog(DynaViewControllerInstBase.class);
    private IDynaViewModel iDynaViewModel = null;
    private IDynaDEModel iDynaDEModel = null;
    private IService iService = null;

    public void init(IDynaViewController iDynaViewController, IEntity dsDynaViewInst, IDynaViewSetting iDynaViewSetting) throws Exception {
        this.iDynaViewModel = (IDynaViewModel)iDynaViewController;
        String strPSAppViewId = DataObject.getStringValue((Object)dsDynaViewInst.get("PSAPPVIEWID"), (String)"");
        if (StringHelper.isNullOrEmpty((String)strPSAppViewId)) {
            throw new Exception("\u6ca1\u6709\u4f20\u5165\u5e94\u7528\u89c6\u56fe\u6807\u8bc6");
        }
        this.setId(strPSAppViewId);
        this.prepareViewController();
    }

    @Override
    protected void onPrepareDynaViewController() throws Exception {
        if (this.getPSAppView() != null) {
            if (this.getPSAppView().getPSDataEntity() != null) {
                this.iDynaDEModel = this.getDynaSysModel().getDynaDEModel(this.getPSAppView().getPSDataEntity().getId());
                this.iService = this.iDynaDEModel.getService(this.getSessionFactory());
            }
            this.setTitle(this.getPSAppView().getTitle());
            this.setCaption(this.getPSAppView().getCaption());
        }
        super.onPrepareDynaViewController();
    }

    public boolean process(HttpServletRequest request, HttpServletResponse response, IWebContext iWebContext) throws Exception {
        String strCtrlId = WebContext.getCtrlId((IWebContext)iWebContext);
        String strCtrlAction = WebContext.getAction((IWebContext)iWebContext);
        if (!StringHelper.isNullOrEmpty((String)strCtrlId)) {
            AjaxActionResult ajaxActionResult = this.onCtrlAjaxAction(request, response, strCtrlId, strCtrlAction);
            response.getWriter().print(ajaxActionResult.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            return true;
        }
        String strCounterId = WebContext.getCounterId((IWebContext)iWebContext);
        if (!StringHelper.isNullOrEmpty((String)strCounterId)) {
            AjaxActionResult ajaxActionResult = this.onCounterAjaxAction(strCounterId, strCtrlAction);
            response.getWriter().print(ajaxActionResult.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            return true;
        }
        if (!StringHelper.isNullOrEmpty((String)strCtrlAction)) {
            AjaxActionResult ajaxActionResult = this.onViewAjaxAction(strCtrlAction);
            ajaxActionResult = this.getAppModel().doFilterViewAction((IViewController)this, request, response, strCtrlAction, ajaxActionResult);
            response.getWriter().print(ajaxActionResult.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            return true;
        }
        return false;
    }

    public IDynaViewController getDynaViewController() {
        return this.iDynaViewModel;
    }

    public IDynaViewSetting getDynaViewSetting() {
        return null;
    }

    public String getDynaViewMode() {
        return null;
    }

    @Override
    public IDynaCtrlModel createDynaCtrlModel(IPSControl iPSControl) throws Exception {
        return this.getDynaViewModel().createDynaCtrlModel(iPSControl);
    }

    @Override
    public IDynaCtrlHandler createDynaCtrlHandler(IPSControl iPSControl) throws Exception {
        return this.getDynaViewModel().createDynaCtrlHandler(iPSControl);
    }

    public IApplicationModel getAppModel() {
        return this.getDynaViewController().getAppModel();
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return WebContext.getCurrent();
    }

    public ISystemModel getSystemModel() {
        return this.getDynaViewController().getSystemModel();
    }

    public IDataEntityModel getDEModel() {
        if (this.iDynaDEModel != null) {
            return this.iDynaDEModel;
        }
        return this.getDynaViewController().getDEModel();
    }

    public IService getService() {
        if (this.iService != null) {
            return this.iService;
        }
        return this.getDynaViewController().getService();
    }

    public SessionFactory getSessionFactory() {
        return this.getDynaViewController().getSessionFactory();
    }

    @Override
    public IDynaViewModel getDynaViewModel() {
        return this.iDynaViewModel;
    }

    @Override
    public boolean isDynaViewInstMode() {
        return true;
    }
}

