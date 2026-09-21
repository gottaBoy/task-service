/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.web.bind.annotation.RequestMapping
 */
package net.ibizsys.paas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerPlugin;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.ctrlhandler.CounterGlobal;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DataSetCache;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.view.IViewWizardModel;
import net.ibizsys.paas.view.ViewMessage;
import net.ibizsys.paas.view.ViewMsgGroupModelGlobal;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.UIActionAjaxActionResult;
import net.ibizsys.paas.web.ViewAjaxActionResult;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class ViewControllerBase
implements IViewController,
IDynaViewController {
    private static AjaxActionResult accessDenyResult = new AjaxActionResult();
    private static AjaxActionResult accessDenyResult2 = new AjaxActionResult();
    private static AjaxActionResult accessDenyResult3 = new AjaxActionResult();
    private static final Log log;
    private Boolean bPrepareViewController = false;
    private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal();
    protected HashMap<String, ICtrlModel> ctrlModelMap = new HashMap();
    protected HashMap<String, ICtrlHandler> ctrlHandlerMap = new HashMap();
    protected HashMap<String, String> uiActionMap = new HashMap();
    protected HashMap<String, ArrayList<String>> deDataAccActionMap = new HashMap();
    protected ArrayList<IViewControllerPlugin> viewControllerPluginList = null;
    private String strCaption = "";
    private String strTitle = "";
    private String strSubCaption = "";
    private String strCaptionLanResTag = "";
    private String strTitleLanResTag = "";
    private String strSubCaptionLanResTag = "";
    private String strMSTag = "";
    private int nAccessUserMode = AccessUserModes.ALLUSER;
    private String strAccessKey = null;
    private DataObject attributeDataObject = new DataObject();
    private String strId = null;
    private String strViewMsgGroupId = null;
    private IViewMsgGroupModel iViewMsgGroupModel = null;
    private String strViewWizardGroupId = null;
    private IViewWizardGroupModel iViewWizardGroupModel = null;
    private Object objPrepareViewController = new Object();
    private boolean bEnableDynaView = false;
    protected HashMap<String, IDynaViewControllerInst> dynaViewControllerInstMap = null;
    private ThreadLocal<IDynaViewControllerInst> dynaViewControllerInst = null;

    static {
        accessDenyResult.setRetCode(2);
        accessDenyResult2.setRetCode(2);
        accessDenyResult2.setErrorInfo("\u8bbf\u95ee\u88ab\u62d2\u7edd\uff0c\u7528\u6237\u8eab\u4efd\u65e0\u6548\uff0c\u9700\u8981\u91cd\u65b0\u767b\u5f55");
        accessDenyResult2.setNotLogin(true);
        accessDenyResult3.setRetCode(2);
        accessDenyResult3.setErrorInfo("\u8bbf\u95ee\u88ab\u62d2\u7edd\uff0c\u7528\u6237\u5bc6\u7801\u5df2\u8fc7\u671f\uff0c\u9700\u8981\u91cd\u65b0\u8bbe\u7f6e");
        accessDenyResult3.setNotLogin(true);
        accessDenyResult3.setNotLoginReason(1);
        log = LogFactory.getLog(ViewControllerBase.class);
    }

    @Override
    public String getId() {
        return this.strId;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public abstract IApplicationModel getAppModel();

    protected void prepareViewParam() throws Exception {
    }

    protected void prepareCtrlModels() throws Exception {
    }

    protected void prepareCtrlHandlers() throws Exception {
    }

    protected void prepareUIActions() throws Exception {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void prepareViewController(boolean bReload) throws Exception {
        if (bReload) {
            Object object = this.objPrepareViewController;
            synchronized (object) {
                this.bPrepareViewController = false;
                if (this.ctrlModelMap != null) {
                    this.ctrlModelMap.clear();
                }
                if (this.ctrlHandlerMap != null) {
                    this.ctrlHandlerMap.clear();
                }
                if (this.uiActionMap != null) {
                    this.uiActionMap.clear();
                }
                if (this.deDataAccActionMap != null) {
                    this.deDataAccActionMap.clear();
                }
                if (this.viewControllerPluginList != null) {
                    this.viewControllerPluginList.clear();
                }
                if (this.dynaViewControllerInstMap != null) {
                    this.dynaViewControllerInstMap.clear();
                }
            }
        }
        this.prepareViewController();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void prepareViewController() throws Exception {
        Object object = this.objPrepareViewController;
        synchronized (object) {
            if (!this.bPrepareViewController.booleanValue()) {
                this.onPrepareViewController();
                this.bPrepareViewController = true;
            }
        }
        if (this.isEnableDynaView() && this.dynaViewControllerInst != null) {
            this.dynaViewControllerInst.set(null);
        }
    }

    @Override
    public IDynaViewControllerInst prepareDynaViewControllerInst() throws Exception {
        if (this.isEnableDynaView() && WebContext.getCurrent() != null) {
            String strViewId = WebContext.getAppViewId(WebContext.getCurrent());
            if (StringHelper.isNullOrEmpty(strViewId)) {
                String strDynaSysInst = WebContext.getDynaSysInstId(WebContext.getCurrent());
                if (StringHelper.isNullOrEmpty(strDynaSysInst)) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u89c6\u56fe\u6807\u8bc6");
                }
                String strViewMode = WebContext.getAppViewMode(WebContext.getCurrent());
                if (StringHelper.isNullOrEmpty(strViewMode)) {
                    strViewMode = "";
                }
                strViewId = KeyValueHelper.genUniqueId(strDynaSysInst, this.getId(), strViewMode);
            }
            IDynaViewControllerInst iDynaViewControllerInst = null;
            if (this.isCacheDynaViewControllerInst()) {
                iDynaViewControllerInst = this.dynaViewControllerInstMap.get(strViewId);
                String strReload = WebContext.getCurrent().getParamValue("SRFRELOAD");
                if (StringHelper.compare(strReload, "TRUE", true) == 0) {
                    iDynaViewControllerInst = null;
                }
                if (iDynaViewControllerInst == null) {
                    iDynaViewControllerInst = this.getDynaViewControllerInst(strViewId);
                    this.dynaViewControllerInstMap.put(strViewId, iDynaViewControllerInst);
                }
            } else {
                iDynaViewControllerInst = this.getDynaViewControllerInst(strViewId);
            }
            this.dynaViewControllerInst.set(iDynaViewControllerInst);
            return iDynaViewControllerInst;
        }
        return null;
    }

    @Override
    public void resetDynaViewControllerInsts() throws Exception {
        if (this.dynaViewControllerInstMap != null) {
            this.dynaViewControllerInstMap.clear();
        }
    }

    protected void onPrepareViewController() throws Exception {
        if (this.isEnableDynaView()) {
            this.dynaViewControllerInstMap = new HashMap();
            this.dynaViewControllerInst = new ThreadLocal();
        }
        if (!StringHelper.isNullOrEmpty(this.getViewMsgGroupId())) {
            this.iViewMsgGroupModel = ViewMsgGroupModelGlobal.getViewMsgGroup(this.getViewMsgGroupId());
        }
        if (!StringHelper.isNullOrEmpty(this.getViewWizardGroupId()) && this.getDEModel() != null) {
            this.iViewWizardGroupModel = (IViewWizardGroupModel)((Object)this.getDEModel().getDEActionWizardGroup(this.getViewWizardGroupId()));
        }
        this.prepareViewParam();
        this.prepareUIActions();
        this.prepareCtrlModels();
        this.prepareCtrlHandlers();
    }

    @Override
    public final boolean isPrepareViewController() {
        return this.bPrepareViewController;
    }

    @RequestMapping(value={""})
    public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.prepareViewController();
        this.addTimeOutHeaders(response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            SessionFactoryManager.enter();
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent(iWebContext);
            ViewController.setCurrent(this);
            DataSetCache.enableCurrent();
            IDynaViewControllerInst iDynaViewControllerInst = null;
            if (this.isEnableDynaView()) {
                String strViewId = WebContext.getAppViewId(iWebContext);
                if (StringHelper.isNullOrEmpty(strViewId)) {
                    String strDynaSysInst = WebContext.getDynaSysInstId(WebContext.getCurrent());
                    if (StringHelper.isNullOrEmpty(strDynaSysInst)) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u89c6\u56fe\u6807\u8bc6");
                    }
                    String strViewMode = WebContext.getAppViewMode(WebContext.getCurrent());
                    if (StringHelper.isNullOrEmpty(strViewMode)) {
                        strViewMode = "";
                    }
                    strViewId = KeyValueHelper.genUniqueId(strDynaSysInst, this.getId(), strViewMode);
                }
                if (this.isCacheDynaViewControllerInst()) {
                    iDynaViewControllerInst = this.dynaViewControllerInstMap.get(strViewId);
                    if (iDynaViewControllerInst == null) {
                        iDynaViewControllerInst = this.getDynaViewControllerInst(strViewId);
                        this.dynaViewControllerInstMap.put(strViewId, iDynaViewControllerInst);
                    }
                } else {
                    iDynaViewControllerInst = this.getDynaViewControllerInst(strViewId);
                }
                this.dynaViewControllerInst.set(iDynaViewControllerInst);
            }
            if (!this.getAppModel().testUserViewAccess(this, iWebContext)) {
                this.resetCurrent();
                return;
            }
            if (this.getAppModel().doFilter(this, request, response)) {
                this.resetCurrent();
                return;
            }
            if (iDynaViewControllerInst != null && iDynaViewControllerInst.process(request, response, iWebContext)) {
                this.resetCurrent();
                return;
            }
            if (this.onProcess(request, response)) {
                this.resetCurrent();
                return;
            }
            String strCtrlId = WebContext.getCtrlId(iWebContext);
            String strCtrlAction = WebContext.getAction(iWebContext);
            if (!StringHelper.isNullOrEmpty(strCtrlId)) {
                AjaxActionResult ajaxActionResult = this.onCtrlAjaxAction(request, response, strCtrlId, strCtrlAction);
                response.getWriter().print(ajaxActionResult.toJSONString());
                response.getWriter().flush();
                response.getWriter().close();
                this.resetCurrent();
                return;
            }
            String strCounterId = WebContext.getCounterId(iWebContext);
            if (!StringHelper.isNullOrEmpty(strCounterId)) {
                AjaxActionResult ajaxActionResult = this.onCounterAjaxAction(strCounterId, strCtrlAction);
                response.getWriter().print(ajaxActionResult.toJSONString());
                response.getWriter().flush();
                response.getWriter().close();
                this.resetCurrent();
                return;
            }
            if (!StringHelper.isNullOrEmpty(strCtrlAction)) {
                AjaxActionResult ajaxActionResult = this.onViewAjaxAction(strCtrlAction);
                ajaxActionResult = this.getAppModel().doFilterViewAction(this, request, response, strCtrlAction, ajaxActionResult);
                response.getWriter().print(ajaxActionResult.toJSONString());
                response.getWriter().flush();
                response.getWriter().close();
                this.resetCurrent();
                return;
            }
            this.resetCurrent();
            return;
        }
        catch (Exception ex) {
            this.getAppModel().logException(this, ex, null, null);
            log.error((Object)ex.getMessage(), (Throwable)ex);
            this.resetCurrent();
            AjaxActionResult ajaxActionResult = new AjaxActionResult();
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            if (ex instanceof ErrorException) {
                ErrorException errorException = (ErrorException)ex;
                ajaxActionResult.setRetCode(errorException.getErrorCode());
            }
            response.getWriter().print(ajaxActionResult.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            return;
        }
    }

    protected boolean onProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return false;
    }

    protected void resetCurrent() {
        if (this.dynaViewControllerInst != null) {
            this.dynaViewControllerInst.set(null);
        }
        this.setSessionFactory(null);
        WebContext.setCurrent(null);
        ViewController.setCurrent(null);
        CtrlHandler.setCurrent(null);
        DataSetCache.resetCurrent();
        SessionFactoryManager.leave();
    }

    protected AjaxActionResult onCtrlAjaxAction(HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction) throws Exception {
        ICtrlHandler iCtrlHandler = this.ctrlHandlerMap.get(strCtrlId);
        if (iCtrlHandler == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61[%1$s]", strCtrlId));
        }
        CtrlHandler.setCurrent(iCtrlHandler);
        return this.getAppModel().doViewCtrlAjaxAction(this, request, response, strCtrlId, strAction, iCtrlHandler);
    }

    protected AjaxActionResult onCounterAjaxAction(String strCounterId, String strAction) throws Exception {
        ICounterHandler iCounterHandler = CounterGlobal.getCounterHandler(strCounterId);
        if (iCounterHandler == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8ba1\u6570\u5668\u5904\u7406\u5bf9\u8c61[%1$s]", strCounterId));
        }
        return iCounterHandler.processAction(strAction, this, this.getWebContext());
    }

    public AjaxActionResult processViewAction(String strAction) throws Exception {
        return this.onViewAjaxAction(strAction);
    }

    protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "loadmodel", true) == 0) {
            return this.onLoadViewModel();
        }
        if (StringHelper.compare(strAction, "fetchmsg", true) == 0) {
            return this.onFetchViewMessage();
        }
        if (StringHelper.compare(strAction, "fetchwizard", true) == 0) {
            return this.onFetchViewWizard();
        }
        if (StringHelper.compare(strAction, "loadappdata", true) == 0) {
            return this.onLoadAppData();
        }
        if (StringHelper.compare(strAction, "uiaction", true) == 0) {
            return this.onUIAction();
        }
        if (StringHelper.compare(strAction, "loaduiaction", true) == 0) {
            return this.onLoadUIAction();
        }
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5904\u7406\u89c6\u56fe\u8bf7\u6c42[%1$s]", strAction));
    }

    protected AjaxActionResult onLoadViewModel() throws Exception {
        ViewModelAjaxActionResult viewModelAjaxActionResult = new ViewModelAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(viewModelAjaxActionResult);
        this.onFillViewModelAjaxActionResult(viewModelAjaxActionResult);
        return viewModelAjaxActionResult;
    }

    protected IEntity getViewEntity() throws Exception {
        return this.getDEModel().createEntity();
    }

    protected void onFillViewModelAjaxActionResult(ViewModelAjaxActionResult viewModelAjaxActionResult) throws Exception {
        Iterator<IViewMessage> viewMessages;
        if (this.getDEModel() != null) {
            JSONObject jo = viewModelAjaxActionResult.getDataAccAction(true);
            Iterator<String> deDataAccessActions = this.getDEDataAccessActions(this.getDEModel().getName());
            if (deDataAccessActions != null) {
                IEntity iEntity = this.getViewEntity();
                while (deDataAccessActions.hasNext()) {
                    String strAccessAction = deDataAccessActions.next();
                    CallResult callResult = this.testDEDataAccessAction(this.getDEModel(), iEntity, strAccessAction, true);
                    if (callResult.isOk()) {
                        jo.put(strAccessAction, 1);
                        continue;
                    }
                    jo.put(strAccessAction, 0);
                }
            }
        }
        if (this.getViewMsgGroupModel() != null && (viewMessages = this.getAppModel().getViewMessages(this, this.getViewMsgGroupModel())) != null) {
            while (viewMessages.hasNext()) {
                IViewMessage iViewMessage = viewMessages.next();
                JSONObject item = ViewMessage.toJSONObject(null, iViewMessage);
                viewModelAjaxActionResult.getMsgs().add(item);
            }
        }
    }

    protected AjaxActionResult onFetchViewMessage() throws Exception {
        Iterator<IViewMessage> viewMessages;
        ViewAjaxActionResult viewAjaxActionResult = new ViewAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(viewAjaxActionResult);
        if (this.getViewMsgGroupModel() != null && (viewMessages = this.getAppModel().getViewMessages(this, this.getViewMsgGroupModel())) != null) {
            while (viewMessages.hasNext()) {
                IViewMessage iViewMessage = viewMessages.next();
                JSONObject item = ViewMessage.toJSONObject(null, iViewMessage);
                viewAjaxActionResult.getItems().add(item);
            }
        }
        return viewAjaxActionResult;
    }

    protected AjaxActionResult onFetchViewWizard() throws Exception {
        Iterator<IViewWizard> viewWizards;
        ViewAjaxActionResult viewAjaxActionResult = new ViewAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(viewAjaxActionResult);
        if (this.getViewWizardGroupModel() != null && (viewWizards = this.getAppModel().getViewWizards(this, this.getViewWizardGroupModel(), WebContext.getFetchQuickSearch(this.getWebContext()))) != null) {
            while (viewWizards.hasNext()) {
                IViewWizardModel iViewWizardModel = (IViewWizardModel)viewWizards.next();
                JSONObject item = iViewWizardModel.toJSONObject(true);
                viewAjaxActionResult.getItems().add(item);
            }
        }
        return viewAjaxActionResult;
    }

    protected void addTimeOutHeaders(HttpServletResponse response) {
        response.setDateHeader("Expires", System.currentTimeMillis());
    }

    @Override
    public IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    @Override
    public void registerCtrlModel(String strCtrlId, ICtrlModel iCtrlModel) throws Exception {
        this.ctrlModelMap.put(strCtrlId, iCtrlModel);
    }

    @Override
    public void registerCtrlHandler(String strCtrlId, ICtrlHandler iCtrlHandler) throws Exception {
        this.ctrlHandlerMap.put(strCtrlId, iCtrlHandler);
    }

    protected void registerUIAction(String strUIActionId) throws Exception {
        this.uiActionMap.put(strUIActionId, "");
    }

    @Override
    public ISystemModel getSystemModel() {
        return null;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return null;
    }

    @Override
    public IService getService() {
        return null;
    }

    @Override
    public ICtrlModel getCtrlModel(String strName) throws Exception {
        ICtrlModel iCtrlModel = this.ctrlModelMap.get(strName);
        if (iCtrlModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u6a21\u578b[%1$s]", strName));
        }
        return iCtrlModel;
    }

    @Override
    public ICtrlModel getCtrlModel(String strName, boolean bTryMode) throws Exception {
        ICtrlModel iCtrlModel = this.ctrlModelMap.get(strName);
        if (iCtrlModel == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61[%1$s]", strName));
        }
        return iCtrlModel;
    }

    @Override
    public ICtrlHandler getCtrlHandler(String strName) throws Exception {
        ICtrlHandler iCtrlHandler = this.ctrlHandlerMap.get(strName);
        if (iCtrlHandler == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61[%1$s]", strName));
        }
        return iCtrlHandler;
    }

    @Override
    public ICtrlHandler getCtrlHandler(String strName, boolean bTryMode) throws Exception {
        ICtrlHandler iCtrlHandler = this.ctrlHandlerMap.get(strName);
        if (iCtrlHandler == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61[%1$s]", strName));
        }
        return iCtrlHandler;
    }

    @Override
    public boolean isPickupView() {
        return false;
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.getAppModel().createWebContext(this, request, response);
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory.set(sessionFactory);
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory.get();
    }

    @Override
    public String getCaption() {
        String strContent;
        if (this.isEnableDynaView() && this.getDynaViewControllerInst() != null && !StringHelper.isNullOrEmpty(strContent = this.getDynaViewControllerInst().getCaption())) {
            return strContent;
        }
        return this.strCaption;
    }

    protected void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    public String getTitle() {
        String strContent;
        if (this.isEnableDynaView() && this.getDynaViewControllerInst() != null && !StringHelper.isNullOrEmpty(strContent = this.getDynaViewControllerInst().getTitle())) {
            return strContent;
        }
        return this.strTitle;
    }

    protected void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    @Override
    public String getSubCaption() {
        String strContent;
        if (this.isEnableDynaView() && this.getDynaViewControllerInst() != null && !StringHelper.isNullOrEmpty(strContent = this.getDynaViewControllerInst().getSubCaption())) {
            return strContent;
        }
        return this.strSubCaption;
    }

    protected void setSubCaption(String strSubCaption) {
        this.strSubCaption = strSubCaption;
    }

    @Override
    public String getViewMsgGroupId() {
        return this.strViewMsgGroupId;
    }

    protected void setViewMsgGroupId(String strViewMsgGroupId) {
        this.strViewMsgGroupId = strViewMsgGroupId;
    }

    protected IViewMsgGroupModel getViewMsgGroupModel() {
        return this.iViewMsgGroupModel;
    }

    @Override
    public String getViewWizardGroupId() {
        return this.strViewWizardGroupId;
    }

    protected void setViewWizardGroupId(String strViewWizardGroupId) {
        this.strViewWizardGroupId = strViewWizardGroupId;
    }

    protected IViewWizardGroupModel getViewWizardGroupModel() {
        return this.iViewWizardGroupModel;
    }

    @Override
    public Object getAttribute(String strKey) throws Exception {
        return this.attributeDataObject.get(strKey);
    }

    @Override
    public void setAttribute(String strKey, Object objValue) throws Exception {
        this.attributeDataObject.set(strKey, objValue);
    }

    @Override
    public boolean getAttribute(String strKey, boolean bDefault) throws Exception {
        return DataObject.getBoolValue(this.attributeDataObject, strKey, bDefault);
    }

    @Override
    public String getAttribute(String strKey, String strDefault) throws Exception {
        return DataObject.getStringValue(this.attributeDataObject, strKey, strDefault);
    }

    @Override
    public int getAttribute(String strKey, int nDefault) throws Exception {
        return DataObject.getIntegerValue(this.attributeDataObject, strKey, nDefault);
    }

    @Override
    public double getAttribute(String strKey, double fDefault) throws Exception {
        return DataObject.getDoubleValue(this.attributeDataObject, strKey, fDefault);
    }

    @Override
    public int getAccessUserMode() {
        return this.nAccessUserMode;
    }

    protected void setAccessUserMode(int nAccessUserMode) {
        this.nAccessUserMode = nAccessUserMode;
    }

    @Override
    public String getAccessKey() {
        return this.strAccessKey;
    }

    protected void setAccessKey(String strAccessKey) {
        this.strAccessKey = strAccessKey;
    }

    @Override
    public boolean testUserAccess(IWebContext iWebContext) throws Exception {
        return this.testUserAccess(iWebContext, true);
    }

    @Override
    public boolean testUserAccess(IWebContext iWebContext, boolean bSendBack) throws Exception {
        String strPersonId = iWebContext.getCurUserId();
        if (StringHelper.isNullOrEmpty(strPersonId)) {
            if ((this.getAccessUserMode() & AccessUserModes.ANONYMOUS) > 0) {
                return true;
            }
            if (bSendBack) {
                iWebContext.getResponse().getWriter().print(this.getAccessDenyResult(2).toJSONString());
                iWebContext.getResponse().getWriter().flush();
                iWebContext.getResponse().getWriter().close();
            }
            return false;
        }
        if (iWebContext.isCurUserPasswordExpired()) {
            if (bSendBack) {
                iWebContext.getResponse().getWriter().print(this.getAccessDenyResult(3).toJSONString());
                iWebContext.getResponse().getWriter().flush();
                iWebContext.getResponse().getWriter().close();
            }
            return false;
        }
        if ((this.getAccessUserMode() & AccessUserModes.LOGINUSER) > 0) {
            return true;
        }
        if ((this.getAccessUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0 && iWebContext.getUserPrivilegeMgr().test(this.getWebContext(), this.getAccessKey())) {
            return true;
        }
        if (bSendBack) {
            iWebContext.getResponse().getWriter().print(this.getAccessDenyResult(1).toJSONString());
            iWebContext.getResponse().getWriter().flush();
            iWebContext.getResponse().getWriter().close();
        }
        return false;
    }

    @Override
    public String getMSTag() {
        return this.strMSTag;
    }

    protected void setMSTag(String strMSTag) {
        this.strMSTag = strMSTag;
    }

    @Override
    public Iterator<String> getUIActions() throws Exception {
        if (this.uiActionMap.size() == 0) {
            return null;
        }
        return this.uiActionMap.keySet().iterator();
    }

    protected void registerDEDataAccessAction(String strDEName, String strDataAccAction) {
        ArrayList<String> list = this.deDataAccActionMap.get(strDEName);
        if (list == null) {
            list = new ArrayList();
            this.deDataAccActionMap.put(strDEName, list);
        }
        if (!list.contains(strDataAccAction)) {
            list.add(strDataAccAction);
        }
    }

    @Override
    public Iterator<String> getDEDataAccessActions(String strDEName) {
        ArrayList<String> list = this.deDataAccActionMap.get(strDEName);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    @Override
    public String getCapLanResTag() {
        return this.strCaptionLanResTag;
    }

    @Override
    public String getSubCapLanResTag() {
        return this.strSubCaptionLanResTag;
    }

    @Override
    public String getTitleLanResTag() {
        return this.strTitleLanResTag;
    }

    protected void setCapLanResTag(String strCaptionLanResTag) {
        this.strCaptionLanResTag = strCaptionLanResTag;
    }

    protected void setSubCapLanResTag(String strSubCaptionLanResTag) {
        this.strSubCaptionLanResTag = strSubCaptionLanResTag;
    }

    protected void setTitleLanResTag(String strTitleLanResTag) {
        this.strTitleLanResTag = strTitleLanResTag;
    }

    @Override
    public String getCaption(boolean bLocale) {
        if (bLocale && !StringHelper.isNullOrEmpty(this.getCapLanResTag())) {
            return this.getWebContext().getLocalization(this.getCapLanResTag(), this.getCaption());
        }
        return this.getCaption();
    }

    @Override
    public String getTitle(boolean bLocale) {
        if (bLocale && !StringHelper.isNullOrEmpty(this.getTitleLanResTag())) {
            return this.getWebContext().getLocalization(this.getTitleLanResTag(), this.getTitle());
        }
        return this.getTitle();
    }

    @Override
    public String getSubCaption(boolean bLocale) {
        if (bLocale && !StringHelper.isNullOrEmpty(this.getSubCapLanResTag())) {
            return this.getWebContext().getLocalization(this.getSubCapLanResTag(), this.getSubCaption());
        }
        return this.getSubCaption();
    }

    @Override
    public CallResult testDEDataAccessAction(IDataEntityModel iDataEntityModel, Object objValue, String strAction, boolean bCache) throws Exception {
        IWebContext iWebContext = this.getWebContext();
        if (iDataEntityModel == null) {
            iDataEntityModel = this.getDEModel();
        }
        if (objValue instanceof IEntity) {
            return iDataEntityModel.getDEDataAccMgr().test(iWebContext, (IEntity)objValue, strAction, bCache);
        }
        return iDataEntityModel.getDEDataAccMgr().test(iWebContext, objValue, strAction, bCache);
    }

    @Override
    public boolean isEnableDynaView() {
        return this.bEnableDynaView;
    }

    protected void setEnableDynaView(boolean bEnableDynaView) {
        this.bEnableDynaView = bEnableDynaView;
    }

    protected String getDynaViewInstId() {
        return WebContext.getAppViewId(WebContext.getCurrent());
    }

    protected AjaxActionResult getAccessDenyResult(int nMode) {
        switch (nMode) {
            case 1: {
                return accessDenyResult;
            }
            case 2: {
                return accessDenyResult2;
            }
            case 3: {
                return accessDenyResult3;
            }
        }
        return accessDenyResult;
    }

    protected IDynaViewControllerInst getDynaViewControllerInst(String strViewId) throws Exception {
        if (this.getSystemModel().getDynaSystemSetting() == null) {
            throw new Exception("\u5f53\u524d\u7cfb\u7edf\u4e0d\u652f\u6301\u52a8\u6001\u7cfb\u7edf");
        }
        return this.getSystemModel().getDynaSystemSetting().createDynaViewControllerInst(this, strViewId);
    }

    @Override
    public IDynaViewControllerInst getDynaViewControllerInst() {
        if (this.dynaViewControllerInst == null) {
            return null;
        }
        return this.dynaViewControllerInst.get();
    }

    public Iterator<ICtrlModel> getCtrlModels() {
        if (this.ctrlModelMap.size() == 0) {
            return null;
        }
        return this.ctrlModelMap.values().iterator();
    }

    public Iterator<String> getCtrlModelNames() {
        if (this.ctrlModelMap.size() == 0) {
            return null;
        }
        return this.ctrlModelMap.keySet().iterator();
    }

    public Iterator<ICtrlHandler> getCtrlHandlers() {
        if (this.ctrlHandlerMap.size() == 0) {
            return null;
        }
        return this.ctrlHandlerMap.values().iterator();
    }

    public Iterator<String> getCtrlHandlerNames() {
        if (this.ctrlHandlerMap.size() == 0) {
            return null;
        }
        return this.ctrlHandlerMap.keySet().iterator();
    }

    protected AjaxActionResult onLoadAppData() throws Exception {
        AppDataAjaxActionResult appDataAjaxActionResult = new AppDataAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(appDataAjaxActionResult);
        this.onFillAppDataAjaxActionResult(appDataAjaxActionResult);
        return appDataAjaxActionResult;
    }

    protected void onFillAppDataAjaxActionResult(AppDataAjaxActionResult appDataAjaxActionResult) throws Exception {
        this.getAppModel().fillAppDataAjaxActionResult(this, appDataAjaxActionResult);
    }

    protected AjaxActionResult onUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strDEUIActionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u754c\u9762\u884c\u4e3a\u6807\u8bc6");
        }
        IDEUIActionModel iDEUIActionModel = null;
        iDEUIActionModel = this.getDEModel() != null ? (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId) : this.getSystemModel().getDEUIActionModel(strDEUIActionId, false);
        return this.doUIAction(iDEUIActionModel);
    }

    protected AjaxActionResult onLoadUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strDEUIActionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u754c\u9762\u884c\u4e3a\u6807\u8bc6");
        }
        IDEUIActionModel iDEUIActionModel = null;
        iDEUIActionModel = this.getDEModel() != null ? (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId) : this.getSystemModel().getDEUIActionModel(strDEUIActionId, false);
        return this.onLoadUIAction(iDEUIActionModel);
    }

    protected AjaxActionResult onLoadUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        return iDEUIActionModel.getRuntimeModelAjaxActionResult(this.getSessionFactory());
    }

    protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        UIActionAjaxActionResult ajaxActionResult = new UIActionAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        IDataEntityModel iDEModel = iDEUIActionModel.getDEModel();
        if (StringHelper.compare(iDEUIActionModel.getActionTarget(), "NONE", true) == 0) {
            CallResult callResult;
            if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction()) && (callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction())).isError()) {
                ajaxActionResult.from(callResult);
                return ajaxActionResult;
            }
            iDEUIActionModel.execute(null, this.getSessionFactory());
        } else {
            String strKeys = WebContext.getKeys(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strKeys)) {
                strKeys = WebContext.getKey(this.getWebContext());
            }
            if (StringHelper.isNullOrEmpty(strKeys)) {
                ajaxActionResult.setRetCode(4);
                return ajaxActionResult;
            }
            ArrayList entities = iDEModel.createEntityList();
            String[] keys = strKeys.split("[;]");
            int i = 0;
            while (i < keys.length) {
                CallResult callResult;
                Object iEntity = iDEModel.createEntity();
                iEntity.set(iDEModel.getKeyDEField().getName(), keys[i]);
                if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction()) && (callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), (IEntity)iEntity, iDEUIActionModel.getDataAccessAction())).isError()) {
                    ajaxActionResult.from(callResult);
                    return ajaxActionResult;
                }
                if (this.getDEModel() != null && StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false) != 0) {
                    iEntity.set("srfdeid", this.getDEModel().getId());
                }
                entities.add(iEntity);
                ++i;
            }
            iDEUIActionModel.execute(entities, this.getSessionFactory());
        }
        ajaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
        ajaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
        return ajaxActionResult;
    }

    protected boolean isRegisterToVCGlobal() {
        return true;
    }

    protected boolean isCacheDynaViewControllerInst() {
        return true;
    }
}

