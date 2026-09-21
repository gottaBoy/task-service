/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.appmodel.IApplicationModel
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.controller.ViewControllerBase
 *  net.ibizsys.paas.controller.ViewControllerGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.Controller;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewParam;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import SA.SRFDA.PS.Core.JIT.Controller.IPSJITViewController;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITControlType;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import SA.SRFDA.PS.Core.JIT.Web.IPSJITWebContext;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewControllerBase;
import net.ibizsys.paas.controller.ViewControllerGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.hibernate.SessionFactory;

public class PSJITViewController
extends ViewControllerBase
implements IPSJITViewController {
    private IPSAppView iPSAppView = null;
    private IPSJITAppModel iPSJITAppModel = null;

    public void init(IPSJITAppModel iPSJITAppModel, IPSAppView iPSAppView) throws Exception {
        this.iPSAppView = iPSAppView;
        this.iPSJITAppModel = iPSJITAppModel;
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
        if (this.getPSAppView().getPSAppViewParams() != null) {
            Iterator<IPSAppViewParam> psAppViewParams = this.getPSAppView().getPSAppViewParams();
            while (psAppViewParams.hasNext()) {
                IPSAppViewParam iPSAppViewParam = psAppViewParams.next();
                this.setAttribute(iPSAppViewParam.getKey(), iPSAppViewParam.getValue());
            }
        }
        ViewControllerGlobal.registerViewController((String)StringHelper.format((String)"/%1$s/%2$s/%3$s.do", (Object)iPSJITAppModel.getPSApplication().getPKGCodeName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getCodeName()), (IViewController)this);
    }

    protected void prepareViewParam() throws Exception {
        super.prepareViewParam();
    }

    public IApplicationModel getAppModel() {
        return this.getPSJITWebContext().getAppModel();
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return WebContext.getCurrent();
    }

    public IPSJITWebContext getPSJITWebContext() {
        return (IPSJITWebContext)this.getWebContext();
    }

    @Override
    public IPSJITAppModel getPSJITAppModel() {
        return this.iPSJITAppModel;
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public ISystemModel getSystemModel() {
        return this.getPSJITAppModel().getPSJITSystemModel();
    }

    public IDataEntityModel getDEModel() {
        if (this.getPSAppView().getDataEntity() != null) {
            try {
                return this.getSystemModel().getDataEntityModel(this.getPSAppView().getDataEntity().getName());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return super.getDEModel();
    }

    protected void prepareCtrlModels() throws Exception {
        ArrayList<IPSAjaxControl> psAjaxControls = this.iPSAppView.getAllPSAjaxControls();
        for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
            if (!iPSAjaxControl.hasCtrlModel()) continue;
            IPSJITCtrlModel iPSJITCtrlModel = ((IPSJITControlType)iPSAjaxControl.getPSControlType()).createPSJITCtrlModel(iPSAjaxControl);
            if (iPSAjaxControl.getPSControlParam() != null && iPSAjaxControl.getPSControlParam().getCtrlParamNames() != null) {
                Iterator<String> params = iPSAjaxControl.getPSControlParam().getCtrlParamNames();
                while (params.hasNext()) {
                    String strParamName = params.next();
                    iPSJITCtrlModel.setCtrlParam(strParamName, iPSAjaxControl.getPSControlParam().getCtrlParam(strParamName, ""));
                }
            }
            iPSJITCtrlModel.init(this, iPSAjaxControl);
            this.registerCtrlModel(iPSAjaxControl.getName(), iPSJITCtrlModel);
        }
    }

    protected void prepareCtrlHandlers() throws Exception {
        ArrayList<IPSAjaxControl> psAjaxControls = this.iPSAppView.getAllPSAjaxControls();
        for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
            IPSJITCtrlHandler iPSJITCtrlHandler = ((IPSJITControlType)iPSAjaxControl.getPSControlType()).createPSJITCtrlHandler(iPSAjaxControl);
            iPSJITCtrlHandler.init(this, iPSAjaxControl);
            this.registerCtrlHandler(iPSAjaxControl.getName(), iPSJITCtrlHandler);
        }
    }

    protected void prepareUIActions() throws Exception {
        if (this.iPSAppView.getPSUIActions() != null) {
            Iterator<IPSUIAction> psUIActions = this.iPSAppView.getPSUIActions();
            while (psUIActions.hasNext()) {
                IPSUIAction iPSUIAction = psUIActions.next();
                if (StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"BACKEND", (boolean)false) == 0) {
                    this.registerUIAction(iPSUIAction.getCodeName());
                }
                if (StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"DEUIACTION", (boolean)false) != 0) continue;
                StringHelper.isNullOrEmpty((String)iPSUIAction.getDataAccessAction());
            }
        }
    }

    public SessionFactory getSessionFactory() {
        return this.getPSJITAppModel().getPSJITSystemModel().getSessionFactory();
    }
}

