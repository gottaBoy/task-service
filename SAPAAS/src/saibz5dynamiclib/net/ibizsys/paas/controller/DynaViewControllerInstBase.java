/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.appmodel.IApplicationModel
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.controller.ViewControllerBase
 *  net.ibizsys.paas.ctrlhandler.CtrlHandler
 *  net.ibizsys.paas.ctrlhandler.ICtrlHandler
 *  net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IDynaViewSetting
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.ViewModelAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewControllerBase;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DefaultDynaBackendUIActionModel;
import net.ibizsys.paas.view.DefaultDynaFrontUIActionModel;
import net.ibizsys.paas.view.DefaultDynaUIActionModel;
import net.ibizsys.paas.view.DynaUIActionModelBase;
import net.ibizsys.paas.view.IDynaUIActionModel;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.view.IDynaViewSettingModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.DynaViewModelAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class DynaViewControllerInstBase
extends ViewControllerBase
implements IDynaViewControllerInst {
    private static final Log log = LogFactory.getLog(DynaViewControllerInstBase.class);
    private IDynaViewController iDynaViewController = null;
    private DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
    private String strViewType = null;
    private IDynaViewSettingModel iDynaViewSettingModel = null;
    private ArrayList<IDynaUIActionModel> dynaUIActionModeList = new ArrayList();
    private String strDynaViewMode = null;

    public void init(IDynaViewController iDynaViewController, IEntity dsDynaViewInst, IDynaViewSetting iDynaViewSetting) throws Exception {
        this.iDynaViewController = iDynaViewController;
        this.iDynaViewSettingModel = (IDynaViewSettingModel)iDynaViewSetting;
        dsDynaViewInst.copyTo((IDataObject)this.dsDynaViewInst, true);
        this.setId(this.dsDynaViewInst.getDSDynaViewInstId());
        this.strDynaViewMode = this.dsDynaViewInst.getPDVTParam();
        this.onInit();
    }

    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.dsDynaViewInst.getDynaModel())) {
            ObjectNode viewModelNode = (ObjectNode)JsonNodeHelper.fromString((String)this.dsDynaViewInst.getDynaModel());
            this.onLoadJsonObject(viewModelNode);
        }
    }

    public IDataEntityModel getDEModel() {
        return this.getDynaViewController().getDEModel();
    }

    public ISystemModel getSystemModel() {
        return this.getDynaViewController().getSystemModel();
    }

    public IService getService() {
        return this.getDynaViewController().getService();
    }

    public SessionFactory getSessionFactory() {
        return this.getDynaViewController().getSessionFactory();
    }

    protected void onLoadJsonObject(ObjectNode viewModelNode) throws Exception {
        ArrayNode arrayNode = JsonNodeHelper.getArray((ObjectNode)viewModelNode, (String)"uiactions");
        if (arrayNode != null) {
            int nSize = arrayNode.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode uiActionModelNode = (ObjectNode)arrayNode.get(i);
                IDynaUIActionModel iDynaUIActionModel = this.loadDynaUIActionModel(uiActionModelNode);
                this.registerDynaUIActionModel(iDynaUIActionModel);
                ++i;
            }
        }
        ArrayList<IDynaCtrlModel> dynaCtrlModelList = new ArrayList<IDynaCtrlModel>();
        ArrayNode arrayNode2 = JsonNodeHelper.getArray((ObjectNode)viewModelNode, (String)"ctrls");
        if (arrayNode2 != null) {
            int nSize = arrayNode2.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode ctrlModelNode = (ObjectNode)arrayNode2.get(i);
                IDynaCtrlModel iDynaCtrlModel = this.loadDynaCtrlModel(ctrlModelNode);
                if (iDynaCtrlModel != null) {
                    dynaCtrlModelList.add(iDynaCtrlModel);
                }
                ++i;
            }
        }
        for (IDynaCtrlModel iDynaCtrlModel : dynaCtrlModelList) {
            this.registerCtrlModel(iDynaCtrlModel.getName(), (ICtrlModel)iDynaCtrlModel);
        }
        for (IDynaCtrlModel iDynaCtrlModel : dynaCtrlModelList) {
            IDynaCtrlHandler iDynaCtrlHandler = this.createDynaCtrlHandler(iDynaCtrlModel);
            if (iDynaCtrlHandler != null) {
                iDynaCtrlHandler.init((IDynaViewControllerInst)this, iDynaCtrlModel);
                this.registerCtrlHandler(iDynaCtrlModel.getName(), (ICtrlHandler)iDynaCtrlHandler);
                continue;
            }
            ICtrlHandler iCtrlHandler = this.getDynaViewController().getCtrlHandler(iDynaCtrlModel.getName(), true);
            if (iCtrlHandler == null) continue;
            ICtrlHandler newCtrlHandler = (ICtrlHandler)iCtrlHandler.getClass().newInstance();
            if (newCtrlHandler instanceof IDynaCtrlHandler) {
                iDynaCtrlHandler = (IDynaCtrlHandler)newCtrlHandler;
                iDynaCtrlHandler.init((IDynaViewControllerInst)this, iDynaCtrlModel);
                this.registerCtrlHandler(iDynaCtrlModel.getName(), (ICtrlHandler)iDynaCtrlHandler);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u52a8\u6001\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61\u63a5\u53e3", (Object)iCtrlHandler.getClass().getName()));
        }
    }

    protected IDynaCtrlModel loadDynaCtrlModel(ObjectNode ctrlModelNode) throws Exception {
        String strCtrlType = JsonNodeHelper.getString((ObjectNode)ctrlModelNode, (String)"type", null);
        if (StringHelper.isNullOrEmpty((String)strCtrlType)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u89c6\u56fe\u90e8\u4ef6\u7c7b\u578b"));
        }
        String strCtrlName = JsonNodeHelper.getString((ObjectNode)ctrlModelNode, (String)"name", null);
        if (StringHelper.isNullOrEmpty((String)strCtrlName)) {
            strCtrlName = JsonNodeHelper.getString((ObjectNode)ctrlModelNode, (String)"id", null);
        }
        if (StringHelper.isNullOrEmpty((String)strCtrlName)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u89c6\u56fe\u90e8\u4ef6\u540d\u79f0"));
        }
        return this.onLoadDynaCtrlModel(strCtrlType, strCtrlName, ctrlModelNode);
    }

    protected IDynaCtrlModel onLoadDynaCtrlModel(String strCtrlType, String strCtrlName, ObjectNode ctrlModelNode) throws Exception {
        ICtrlModel iCtrlModel = this.getDynaViewController().getCtrlModel(strCtrlName, true);
        IDynaCtrlModel iDynaCtrlModel = null;
        if (iCtrlModel != null && iCtrlModel instanceof IDynaCtrlModel) {
            iDynaCtrlModel = (IDynaCtrlModel)iCtrlModel.getClass().newInstance();
        } else {
            iDynaCtrlModel = this.getDynaViewSettingModel().createDynaCtrlModel(strCtrlType, ctrlModelNode);
            if (iDynaCtrlModel == null) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u521b\u5efa\u52a8\u6001\u90e8\u4ef6\u6a21\u578b\uff0c\u7c7b\u578b\u4e3a[%1$s][%2$s]", (Object)strCtrlType, (Object)ctrlModelNode));
                return iDynaCtrlModel;
            }
        }
        iDynaCtrlModel.init((IDynaViewControllerInst)this, (Object)ctrlModelNode);
        return iDynaCtrlModel;
    }

    protected IDynaCtrlHandler createDynaCtrlHandler(IDynaCtrlModel iDynaCtrlModel) throws Exception {
        return this.getDynaViewSettingModel().createDynaCtrlHandler(iDynaCtrlModel);
    }

    public IDynaViewController getDynaViewController() {
        return this.iDynaViewController;
    }

    public IApplicationModel getAppModel() {
        return this.getDynaViewController().getAppModel();
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return WebContext.getCurrent();
    }

    public IDynaViewSetting getDynaViewSetting() {
        return this.iDynaViewSettingModel;
    }

    public IDynaViewSettingModel getDynaViewSettingModel() {
        return this.iDynaViewSettingModel;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
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

    protected AjaxActionResult onCtrlAjaxAction(HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction) throws Exception {
        ICtrlHandler iCtrlHandler = this.getCtrlHandler(strCtrlId, true);
        if (iCtrlHandler == null && (iCtrlHandler = this.getDynaViewController().getCtrlHandler(strCtrlId, true)) != null) {
            CtrlHandler.setCurrent((ICtrlHandler)iCtrlHandler);
            return this.getAppModel().doViewCtrlAjaxAction((IViewController)this, request, response, strCtrlId, strAction, iCtrlHandler);
        }
        return super.onCtrlAjaxAction(request, response, strCtrlId, strAction);
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
        DynaViewModelAjaxActionResult dynaViewModelAjaxActionResult = (DynaViewModelAjaxActionResult)viewModelAjaxActionResult;
        Iterator ctrlModels = this.getCtrlModels();
        if (ctrlModels != null) {
            while (ctrlModels.hasNext()) {
                IDynaModelJsonExporter iDynaModelJsonExporter;
                ObjectNode objCtrlMode;
                ICtrlModel iCtrlMode = (ICtrlModel)ctrlModels.next();
                if (!(iCtrlMode instanceof IDynaCtrlModel) || !(iCtrlMode instanceof IDynaModelJsonExporter) || (objCtrlMode = (iDynaModelJsonExporter = (IDynaModelJsonExporter)iCtrlMode).toJsonObject(null)) == null) continue;
                dynaViewModelAjaxActionResult.getCtrls().add(objCtrlMode.toString());
            }
        }
        if ((dynaUIActionModels = this.getDynaUIActionModels()) != null) {
            while (dynaUIActionModels.hasNext()) {
                IDynaUIActionModel iDynaModelJsonExporter;
                ObjectNode objCtrlMode;
                IDynaUIActionModel iDynaUIActionModel = dynaUIActionModels.next();
                if (!(iDynaUIActionModel instanceof IDynaModelJsonExporter) || (objCtrlMode = (iDynaModelJsonExporter = iDynaUIActionModel).toJsonObject(null)) == null) continue;
                dynaViewModelAjaxActionResult.getUIActions().add(objCtrlMode.toString());
            }
        }
    }

    protected IDynaUIActionModel loadDynaUIActionModel(ObjectNode uiActionModelNode) throws Exception {
        String strActionMode = JsonNodeHelper.getString((ObjectNode)uiActionModelNode, (String)"actionmode", null);
        if (StringHelper.isNullOrEmpty((String)strActionMode)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u754c\u9762\u884c\u4e3a\u6a21\u5f0f"));
        }
        return this.onLoadDynaUIActionModel(strActionMode, uiActionModelNode);
    }

    protected IDynaUIActionModel onLoadDynaUIActionModel(String strActionMode, ObjectNode uiActionModelNode) throws Exception {
        DynaUIActionModelBase iDynaUIActionModel = null;
        iDynaUIActionModel = StringHelper.compare((String)strActionMode, (String)"FRONT", (boolean)true) == 0 || StringHelper.compare((String)strActionMode, (String)"WFFRONT", (boolean)true) == 0 ? new DefaultDynaFrontUIActionModel() : (StringHelper.compare((String)strActionMode, (String)"BACKEND", (boolean)true) == 0 || StringHelper.compare((String)strActionMode, (String)"WFBACKEND", (boolean)true) == 0 ? new DefaultDynaBackendUIActionModel() : new DefaultDynaUIActionModel());
        iDynaUIActionModel.init(this.getDEModel(), uiActionModelNode);
        return iDynaUIActionModel;
    }

    protected void registerDynaUIActionModel(IDynaUIActionModel iDynaUIActionModel) throws Exception {
        this.dynaUIActionModeList.add(iDynaUIActionModel);
    }

    public Iterator<IDynaUIActionModel> getDynaUIActionModels() {
        if (this.dynaUIActionModeList.size() == 0) {
            return null;
        }
        return this.dynaUIActionModeList.iterator();
    }

    public String getDynaViewMode() {
        return this.strDynaViewMode;
    }
}

