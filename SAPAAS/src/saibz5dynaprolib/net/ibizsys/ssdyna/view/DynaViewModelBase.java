/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.paas.appmodel.IApplicationModel
 *  net.ibizsys.paas.control.IControl
 *  net.ibizsys.paas.controller.ViewControllerBase
 *  net.ibizsys.paas.core.IApplication
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IAjaxActionContext
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.ssdyna.view;

import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.controller.ViewControllerBase;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdyna.appmodel.IDynaAppModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.hibernate.SessionFactory;

public abstract class DynaViewModelBase
extends ViewControllerBase
implements IDynaViewModel {
    private IDynaAppModel iDynaAppModel = null;
    private IPSAppView iPSAppView = null;

    public void init(IDynaAppModel iDynaAppModel, IPSAppView iPSAppView) throws Exception {
        this.iPSAppView = iPSAppView;
        this.iDynaAppModel = iDynaAppModel;
        this.setId(this.iPSAppView.getId());
        if (this.iPSAppView.getCaption() != null) {
            this.setCaption(this.iPSAppView.getCaption());
        }
        if (this.iPSAppView.getSubCaption() != null) {
            this.setSubCaption(this.iPSAppView.getSubCaption());
        }
        if (this.iPSAppView.getTitle() != null) {
            this.setTitle(this.iPSAppView.getTitle());
        }
    }

    public IApplication getApplication() {
        return this.getAppModel();
    }

    public String getViewType() {
        return null;
    }

    public IControl getControl(String strControlName) throws Exception {
        return null;
    }

    public IDataEntity getDataEntity() {
        return null;
    }

    public AjaxActionResult process(IAjaxActionContext iAjaxActionContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getName() {
        return null;
    }

    public IApplicationModel getAppModel() {
        return this.iDynaAppModel;
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return WebContext.getCurrent();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public ISystemModel getSystemModel() {
        return this.getAppModel().getSystemModel();
    }

    public IDataEntityModel getDEModel() {
        if (this.getPSAppView().getPSDataEntity() != null) {
            try {
                return this.getSystemModel().getDataEntityModel(this.getPSAppView().getPSDataEntity().getName());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return super.getDEModel();
    }

    protected void prepareCtrlModels() throws Exception {
        ArrayList psAjaxControls = this.iPSAppView.getAllPSAjaxControls();
        for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
            if (!iPSAjaxControl.hasCtrlModel()) continue;
            IDynaCtrlModel iDynaCtrlModel = this.getDynaAppModel().createDynaCtrlModel(this, (IPSControl)iPSAjaxControl);
            if (iPSAjaxControl.getPSControlParam() != null && iPSAjaxControl.getPSControlParam().getCtrlParamNames() != null) {
                Iterator params = iPSAjaxControl.getPSControlParam().getCtrlParamNames();
                while (params.hasNext()) {
                    String strParamName = (String)params.next();
                    iDynaCtrlModel.setCtrlParam(strParamName, iPSAjaxControl.getPSControlParam().getCtrlParam(strParamName, ""));
                }
            }
            iDynaCtrlModel.init(this, (IPSControl)iPSAjaxControl);
            this.registerCtrlModel(iPSAjaxControl.getName(), iDynaCtrlModel);
        }
    }

    protected void prepareCtrlHandlers() throws Exception {
        ArrayList psAjaxControls = this.iPSAppView.getAllPSAjaxControls();
        for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
            IDynaCtrlHandler iDynaCtrlHandler = this.getDynaAppModel().createDynaCtrlHandler(this, (IPSControl)iPSAjaxControl);
            iDynaCtrlHandler.init(this, (IPSControl)iPSAjaxControl);
            this.registerCtrlHandler(iPSAjaxControl.getName(), iDynaCtrlHandler);
        }
    }

    protected void prepareUIActions() throws Exception {
        if (this.iPSAppView.getPSUIActions() != null) {
            Iterator psUIActions = this.iPSAppView.getPSUIActions();
            while (psUIActions.hasNext()) {
                IPSUIAction iPSUIAction = (IPSUIAction)psUIActions.next();
                if (StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"BACKEND", (boolean)false) == 0) {
                    this.registerUIAction(iPSUIAction.getCodeName());
                }
                if (StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"DEUIACTION", (boolean)false) != 0) continue;
                StringHelper.isNullOrEmpty((String)iPSUIAction.getDataAccessAction());
            }
        }
    }

    public SessionFactory getSessionFactory() {
        return this.iDynaAppModel.getDynaSysModel().getSessionFactory();
    }

    @Override
    public IDynaAppModel getDynaAppModel() {
        return this.iDynaAppModel;
    }
}

