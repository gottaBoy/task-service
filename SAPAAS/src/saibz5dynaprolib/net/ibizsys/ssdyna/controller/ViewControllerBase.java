/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.paas.control.IControl
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.controller.ViewControllerBase
 *  net.ibizsys.paas.core.IApplication
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IAjaxActionContext
 *  net.ibizsys.paas.web.ViewModelAjaxActionResult
 *  net.sf.json.JSONObject
 */
package net.ibizsys.ssdyna.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.ibizsys.ssdyna.appmodel.IDynaAppModel;
import net.ibizsys.ssdyna.controller.DynaViewControllerInst;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaInstModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.view.DynaUIActionModel;
import net.ibizsys.ssdyna.view.IDynaUIActionModel;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.ssdyna.web.DynaViewModelAjaxActionResult;
import net.ibizsys.ssdyna.web.WebContext;
import net.sf.json.JSONObject;

public abstract class ViewControllerBase
extends net.ibizsys.paas.controller.ViewControllerBase
implements IDynaViewModel {
    private Object objPrepareViewController = new Object();
    private Boolean bPrepareViewController = false;
    private IPSAppView iPSAppView = null;
    private long nLastCheckExpiredTime = 0L;
    private long nLastCheckExpiredInterval = 5000L;
    private HashMap<String, IDynaUIActionModel> uiActionModelMap = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void prepareViewController(boolean bReload) throws Exception {
        Object object = this.objPrepareViewController;
        synchronized (object) {
            this.bPrepareViewController = false;
        }
        super.prepareViewController(bReload);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void prepareViewController() throws Exception {
        if (this.isEnableDynaView()) {
            if (this.getPSAppView() != null && this.isCheckExpired()) {
                this.setLastCheckExpiredTime(System.currentTimeMillis());
                IPSAppView iPSAppView = this.getDynaAppModel().getPSApplication().getPSAppView(this.getId(), false);
                if (iPSAppView.getLastModifyTime() != this.getPSAppView().getLastModifyTime()) {
                    this.iPSAppView = iPSAppView;
                    this.prepareViewController(true);
                    return;
                }
            }
            if (this.iPSAppView == null) {
                if (this.getDynaAppModel().getPSApplication() == null) {
                    throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u52a8\u6001\u5e94\u7528\u6a21\u578b\u5bf9\u8c61");
                }
                this.iPSAppView = this.getDynaAppModel().getPSApplication().getPSAppView(this.getId(), false);
                this.setLastCheckExpiredTime(System.currentTimeMillis());
            }
            super.prepareViewController();
            Object object = this.objPrepareViewController;
            synchronized (object) {
                if (!this.bPrepareViewController.booleanValue()) {
                    this.onPrepareDynaViewController();
                    this.bPrepareViewController = true;
                }
            }
            return;
        }
        super.prepareViewController();
    }

    protected void onPrepareDynaViewController() throws Exception {
        this.prepareDynaViewParam();
        this.prepareDynaUIActions();
        this.prepareDynaCtrlModels();
        this.prepareDynaCtrlHandlers();
    }

    protected void prepareDynaViewParam() throws Exception {
    }

    protected void prepareDynaCtrlModels() throws Exception {
        ArrayList psControls = this.getPSAppView().getAllPSControls();
        for (IPSControl iPSControl : psControls) {
            IDynaCtrlModel iDynaCtrlModel;
            if (this.getCtrlModel(iPSControl.getName(), true) != null || (iDynaCtrlModel = this.createDynaCtrlModel(iPSControl)) == null) continue;
            if (iPSControl.getPSControlParam() != null && iPSControl.getPSControlParam().getCtrlParamNames() != null) {
                Iterator params = iPSControl.getPSControlParam().getCtrlParamNames();
                while (params.hasNext()) {
                    String strParamName = (String)params.next();
                    iDynaCtrlModel.setCtrlParam(strParamName, iPSControl.getPSControlParam().getCtrlParam(strParamName, ""));
                }
            }
            iDynaCtrlModel.init(this, iPSControl);
            this.registerCtrlModel(iPSControl.getName(), iDynaCtrlModel);
        }
    }

    @Override
    public IDynaCtrlModel createDynaCtrlModel(IPSControl iPSControl) throws Exception {
        return this.getDynaAppModel().createDynaCtrlModel(this, iPSControl);
    }

    protected void prepareDynaCtrlHandlers() throws Exception {
        ArrayList psAjaxControls = this.getPSAppView().getAllPSAjaxControls();
        for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
            IDynaCtrlHandler iDynaCtrlHandler;
            if (this.getCtrlHandler(iPSAjaxControl.getName(), true) != null || (iDynaCtrlHandler = this.createDynaCtrlHandler((IPSControl)iPSAjaxControl)) == null) continue;
            iDynaCtrlHandler.init(this, (IPSControl)iPSAjaxControl);
            this.registerCtrlHandler(iPSAjaxControl.getName(), iDynaCtrlHandler);
        }
    }

    @Override
    public IDynaCtrlHandler createDynaCtrlHandler(IPSControl iPSControl) throws Exception {
        return this.getDynaAppModel().createDynaCtrlHandler(this, iPSControl);
    }

    protected void prepareDynaUIActions() throws Exception {
        Iterator psUIActions = this.getPSAppView().getPSUIActions();
        while (psUIActions.hasNext()) {
            IPSUIAction iPSUIAction = (IPSUIAction)psUIActions.next();
            DynaUIActionModel dynaUIActionModel = new DynaUIActionModel();
            dynaUIActionModel.init(this, iPSUIAction);
            this.registerDynaUIActionModel(iPSUIAction.getUIActionTag(), dynaUIActionModel);
        }
    }

    @Override
    public void registerDynaUIActionModel(String strActionTag, IDynaUIActionModel iDynaUIActionModel) throws Exception {
        if (this.uiActionModelMap == null) {
            this.uiActionModelMap = new HashMap();
        }
        this.uiActionModelMap.put(strActionTag, iDynaUIActionModel);
        this.registerUIAction(strActionTag);
    }

    @Override
    public Iterator<IDynaUIActionModel> getDynaUIActionModels() {
        if (this.uiActionModelMap == null || this.uiActionModelMap.size() == 0) {
            return null;
        }
        return this.uiActionModelMap.values().iterator();
    }

    public IApplication getApplication() {
        return this.getDynaAppModel();
    }

    public String getViewType() {
        return this.getPSAppView().getViewType();
    }

    public IControl getControl(String strControlName) throws Exception {
        return this.getCtrlModel(strControlName);
    }

    public IDataEntity getDataEntity() {
        return this.getDEModel();
    }

    public AjaxActionResult process(IAjaxActionContext iAjaxActionContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getName() {
        return this.getTitle();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public IDynaAppModel getDynaAppModel() {
        return (IDynaAppModel)this.getAppModel();
    }

    @Override
    public IDynaSysModel getDynaSysModel() {
        return (IDynaSysModel)this.getSystemModel();
    }

    protected long getLastCheckExpiredTime() {
        return this.nLastCheckExpiredTime;
    }

    protected void setLastCheckExpiredTime(long nLastCheckExpiredTime) {
        this.nLastCheckExpiredTime = nLastCheckExpiredTime;
    }

    protected boolean isCheckExpired() {
        return System.currentTimeMillis() - this.getLastCheckExpiredTime() > this.nLastCheckExpiredInterval;
    }

    public boolean isEnableDynaView() {
        return this.isDynaViewInstMode();
    }

    @Override
    public boolean isDynaViewInstMode() {
        return false;
    }

    protected boolean isRegisterToVCGlobal() {
        return !this.isDynaViewInstMode();
    }

    protected IDynaViewControllerInst getDynaViewControllerInst(String strViewId) throws Exception {
        String strDynaInstId = WebContext.getDynaSysInstId(false);
        IDynaInstModel iDynaInstModel = this.getDynaSysModel().getDynaInstModel(strDynaInstId);
        IDynaViewControllerInst iDynaViewControllerInst = iDynaInstModel.getDynaViewControllerInst(strViewId, true);
        if (iDynaViewControllerInst == null) {
            IDynaViewInstModel iDynaViewInstModel = this.createDynaViewInstModel();
            SimpleEntity simpleEntity = new SimpleEntity();
            simpleEntity.set("PSAPPVIEWID", (Object)strViewId);
            iDynaViewInstModel.init(this, (IEntity)simpleEntity, null);
            iDynaInstModel.registerDynaViewControllerInst(iDynaViewInstModel);
            return iDynaViewInstModel;
        }
        return iDynaViewControllerInst;
    }

    protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
        return new DynaViewControllerInst();
    }

    protected AjaxActionResult onLoadViewModel() throws Exception {
        DynaViewModelAjaxActionResult viewModelAjaxActionResult = new DynaViewModelAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)viewModelAjaxActionResult);
        this.onFillViewModelAjaxActionResult(viewModelAjaxActionResult);
        return viewModelAjaxActionResult;
    }

    protected void onFillViewModelAjaxActionResult(ViewModelAjaxActionResult viewModelAjaxActionResult) throws Exception {
        Iterator<IDynaUIActionModel> dynaUIActionModels;
        super.onFillViewModelAjaxActionResult(viewModelAjaxActionResult);
        JSONObject viewObject = viewModelAjaxActionResult.getView(true);
        JSONObjectHelper.put((JSONObject)viewObject, (String)"title", (Object)this.getTitle());
        JSONObjectHelper.put((JSONObject)viewObject, (String)"caption", (Object)this.getCaption());
        DynaViewModelAjaxActionResult dynaViewModelAjaxActionResult = (DynaViewModelAjaxActionResult)viewModelAjaxActionResult;
        Iterator ctrlModels = this.getCtrlModels();
        if (ctrlModels != null) {
            while (ctrlModels.hasNext()) {
                ObjectNode objCtrlModel;
                IDynaCtrlModel iDynaCtrlModel;
                ICtrlModel iCtrlMode = (ICtrlModel)ctrlModels.next();
                if (!(iCtrlMode instanceof IDynaCtrlModel) || !(iDynaCtrlModel = (IDynaCtrlModel)iCtrlMode).isDynaCtrl() || (objCtrlModel = iDynaCtrlModel.toJsonObject(null)) == null) continue;
                dynaViewModelAjaxActionResult.getCtrls().add(objCtrlModel.toString());
            }
        }
        if ((dynaUIActionModels = this.getDynaUIActionModels()) != null) {
            while (dynaUIActionModels.hasNext()) {
                IDynaUIActionModel iDynaUIActionModel = dynaUIActionModels.next();
                ObjectNode objCtrlMode = iDynaUIActionModel.toJsonObject(null);
                if (objCtrlMode == null) continue;
                dynaViewModelAjaxActionResult.getUIActions().add(objCtrlMode.toString());
            }
        }
        if (this.getPSAppView() != null) {
            JSONObjectHelper.put((JSONObject)viewObject, (String)"dynamodel", (Object)this.getPSAppView().getDynaModelContent());
            Iterator appViewRefs = this.getPSAppView().getPSAppViewRefs();
            while (appViewRefs.hasNext()) {
                IPSAppViewRef iPSAppViewRef = (IPSAppViewRef)appViewRefs.next();
                ObjectNode objRefView = iPSAppViewRef.toJsonObject(null);
                if (objRefView == null) continue;
                dynaViewModelAjaxActionResult.getRefViews().add(objRefView.toString());
            }
            Iterator psCodeLists = this.getPSAppView().getAllRelatedPSCodeLists();
            while (psCodeLists.hasNext()) {
                IPSCodeList iPSCodeList = (IPSCodeList)psCodeLists.next();
                ObjectNode objCodeList = iPSCodeList.toJsonObject(null);
                if (objCodeList == null) continue;
                dynaViewModelAjaxActionResult.getCodeLists().add(objCodeList.toString());
            }
        }
    }

    protected boolean isCacheDynaViewControllerInst() {
        return false;
    }
}

