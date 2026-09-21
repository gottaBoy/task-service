/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.cache.CacheManager;
import net.ibizsys.paas.cache.ICacheable;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlItemHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class CtrlHandlerBase
implements ICtrlHandler,
ICacheable,
IDynaCtrlHandler {
    private static final Log log = LogFactory.getLog(CtrlHandlerBase.class);
    private ThreadLocal<IWebContext> webContext = new ThreadLocal();
    private IViewController iViewController = null;
    private IDynaViewControllerInst iDynaViewControllerInst = null;
    private IDynaCtrlModel iDynaCtrlModel = null;
    private HashMap<String, String> dataAccessActionMap = new HashMap();
    private HashMap<String, ICtrlItemHandler> ctrlItemHandlerMap = new HashMap();
    private boolean bEnableCache = false;
    private int nCacheTimeout = -1;
    private int nCacheScope = 0;
    private String strUniStateId = null;
    private Object objUniStateKeyValue = null;
    private String strUniStateField = null;
    private IUniStateModel iUniStateModel = null;
    private boolean bHasUniStateModel = false;
    private String strName = null;
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;

    @Override
    public void init(IViewController iViewController) throws Exception {
        this.setViewController(iViewController);
        this.onInit();
        this.prepareCtrlItemHandlers();
        this.prepareDataAccessActions();
    }

    @Override
    public void init(IDynaViewControllerInst iDynaViewControllerInst, IDynaCtrlModel iDynaCtrlModel) throws Exception {
        this.iDynaViewControllerInst = iDynaViewControllerInst;
        this.iDynaCtrlModel = iDynaCtrlModel;
        this.init(this.iDynaViewControllerInst);
    }

    protected void onInit() throws Exception {
    }

    @Override
    public IDynaCtrlModel getDynaCtrlModel() {
        return this.iDynaCtrlModel;
    }

    protected void prepareCtrlItemHandlers() throws Exception {
    }

    protected void prepareDataAccessActions() throws Exception {
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    @Override
    public AjaxActionResult processAction(String strAction, IWebContext iWebContext) throws Exception {
        try {
            this.setWebContext(iWebContext);
            AjaxActionResult ajaxActionResult = null;
            String strCacheDataTag = null;
            Object objCacheDataState = null;
            if (this.isEnableCache() && !StringHelper.isNullOrEmpty(strCacheDataTag = this.getCacheDataTag(strAction))) {
                Object objData;
                if (this.hasUniStateModel() && this.getUniStateModel().isEnabled()) {
                    objCacheDataState = this.getUniStateModel().get(this.getUniStateKeyValue(), this.getUniStateField());
                }
                if ((objData = CacheManager.getInstance(this.getCacheScope()).getData(strCacheDataTag, objCacheDataState)) != null) {
                    ajaxActionResult = (AjaxActionResult)objData;
                }
            }
            if (ajaxActionResult == null) {
                ajaxActionResult = this.onProcessAction(strAction);
                if (this.isEnableCache() && !StringHelper.isNullOrEmpty(strCacheDataTag)) {
                    CacheManager.getInstance(this.getCacheScope()).updateData(strCacheDataTag, objCacheDataState, ajaxActionResult, this.getCacheTimeout());
                }
            }
            ajaxActionResult.setAjaxAction(strAction);
            ICtrlRender iCtrlRender = this.getCtrlRender();
            if (iCtrlRender != null) {
                ajaxActionResult.setCtrlRender(iCtrlRender);
            }
            return ajaxActionResult;
        }
        catch (Exception ex) {
            this.getViewController().getAppModel().logException(this, ex, null, null);
            throw ex;
        }
    }

    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0\u8fdc\u7a0b\u8bf7\u6c42[%1$s]", strAction));
    }

    @Override
    public IViewController getViewController() {
        return this.iViewController;
    }

    protected void setViewController(IViewController iViewController) {
        this.iViewController = iViewController;
    }

    @Override
    public IWebContext getWebContext() {
        return this.webContext.get();
    }

    private void setWebContext(IWebContext value) {
        this.webContext.set(value);
    }

    protected ISystemModel getSystemModel() {
        return this.getViewController().getSystemModel();
    }

    protected IDataEntityModel getDEModel() {
        if (this.getCtrlModel() != null && this.getCtrlModel().getDEModel() != null) {
            return this.getCtrlModel().getDEModel();
        }
        return this.getViewController().getDEModel();
    }

    protected IService getService() {
        if (this.getCtrlModel() != null && this.getCtrlModel().getDEModel() != null) {
            try {
                return this.getCtrlModel().getDEModel().getService(this.getSessionFactory());
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
        if (this.getViewController().getDEModel() == null && this.getCtrlModel() != null && this.getCtrlModel().getDEModel() != null) {
            try {
                return this.getCtrlModel().getDEModel().getService(this.getSessionFactory());
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
        if (this.getViewController().getDEModel() != null && this.getCtrlModel() != null && this.getCtrlModel().getDEModel() != null && StringHelper.compare(this.getCtrlModel().getDEModel().getId(), this.getViewController().getDEModel().getId(), false) != 0) {
            try {
                return this.getCtrlModel().getDEModel().getService(this.getSessionFactory());
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
        return this.getViewController().getService();
    }

    protected String getDataAccessAction(String strAjaxActionName) {
        return this.dataAccessActionMap.get(strAjaxActionName.toUpperCase());
    }

    protected void registerDataAccessAction(String strAjaxActionName, String strDataAction) {
        this.dataAccessActionMap.put(strAjaxActionName.toUpperCase(), strDataAction);
    }

    protected CallResult testDataAccessAction(Object objValue, String strDataAccessAction) throws Exception {
        if (this.isUseServiceAPI()) {
            return new CallResult();
        }
        return this.testDataAccessAction(this.getSimpleEntity(objValue), strDataAccessAction);
    }

    protected CallResult testDataAccessAction(IEntity iEntity, String strDataAccessAction) throws Exception {
        if (this.isUseServiceAPI()) {
            return new CallResult();
        }
        return this.getWebContext().getUserPrivilegeMgr().testDataAccessAction(this.getWebContext(), this.getDEModel(), iEntity, strDataAccessAction);
    }

    protected CallResult testDataAccessAction(String strDataAccessAction) throws Exception {
        CallResult callResult = new CallResult();
        if (StringHelper.compare(strDataAccessAction, "DENY", true) == 0) {
            callResult.setRetCode(2);
            return callResult;
        }
        return callResult;
    }

    protected ICtrlItemHandler getCtrlItemHandler(String strItemName) throws Exception {
        ICtrlItemHandler iCtrlItemHandler = this.ctrlItemHandlerMap.get(strItemName.toUpperCase());
        if (iCtrlItemHandler == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6\u6210\u5458[%1$s]\u5904\u7406\u5bf9\u8c61", strItemName));
        }
        return iCtrlItemHandler;
    }

    protected void registerCtrlItemHandler(String strItemName, ICtrlItemHandler iCtrlItemHandler) {
        this.ctrlItemHandlerMap.put(strItemName.toUpperCase(), iCtrlItemHandler);
    }

    @Override
    public int getTempMode() {
        return 0;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.iViewController.getSessionFactory();
    }

    protected ICtrlRender getCtrlRender() throws Exception {
        String strRender = WebContext.getRender(this.getWebContext());
        if (!StringHelper.isNullOrEmpty(strRender)) {
            return this.getViewController().getAppModel().getCtrlRender(this.getCtrlModel().getControlType(), strRender);
        }
        return null;
    }

    @Override
    public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
        return false;
    }

    protected IEntity getSimpleEntity(Object objKey) throws Exception {
        Object iEntity;
        if (objKey != null && objKey instanceof String && ((String)objKey).indexOf("SRFTEMPKEY:") == 0) {
            if (this.getTempMode() == 2) {
                return null;
            }
            iEntity = this.getDEModel().createEntity();
            iEntity.set(this.getDEModel().getKeyDEField().getName(), objKey);
            this.getService().getTemp(iEntity);
            objKey = EntityBase.getOriginKey(iEntity);
            if (StringHelper.isNullOrEmpty(objKey)) {
                return null;
            }
        }
        iEntity = this.getDEModel().createEntity();
        iEntity.set(this.getDEModel().getKeyDEField().getName(), objKey);
        this.getService().get(iEntity);
        return iEntity;
    }

    protected IEntity getSimpleEntity(IDataEntityModel iDataEntityModel, Object objKey) throws Exception {
        Object iEntity;
        if (objKey != null && objKey instanceof String && ((String)objKey).indexOf("SRFTEMPKEY:") == 0) {
            if (this.getTempMode() == 2) {
                return null;
            }
            iEntity = iDataEntityModel.createEntity();
            iEntity.set(iDataEntityModel.getKeyDEField().getName(), objKey);
            iDataEntityModel.getService(this.getSessionFactory()).getTemp(iEntity);
            objKey = EntityBase.getOriginKey(iEntity);
            if (StringHelper.isNullOrEmpty(objKey)) {
                return null;
            }
        }
        iEntity = iDataEntityModel.createEntity();
        iEntity.set(iDataEntityModel.getKeyDEField().getName(), objKey);
        iDataEntityModel.getService(this.getSessionFactory()).get(iEntity);
        return iEntity;
    }

    protected Iterator<String> getDataAccessActions() throws Exception {
        if (this.dataAccessActionMap.size() == 0) {
            return null;
        }
        return this.dataAccessActionMap.values().iterator();
    }

    protected String getGetEntityAction() {
        return null;
    }

    @Override
    public abstract ICtrlModel getCtrlModel();

    protected void fillDataAccActions(JSONObject dataAccObject, boolean bOk) throws Exception {
        Iterator<String> uiActions;
        Iterator<String> accActions = this.getDataAccessActions();
        if (accActions != null) {
            while (accActions.hasNext()) {
                String strAction = accActions.next();
                if (StringHelper.isNullOrEmpty(strAction) || dataAccObject.has(strAction)) continue;
                if (!bOk) {
                    dataAccObject.put(strAction, 0);
                    continue;
                }
                dataAccObject.put(strAction, 1);
            }
        }
        if ((uiActions = this.getViewController().getUIActions()) != null) {
            while (uiActions.hasNext()) {
                String strUIActionId = uiActions.next();
                IDEUIAction iDEUIAction = this.getDEModel().getDEUIAction(strUIActionId);
                String strDataAccAction = iDEUIAction.getDataAccessAction();
                if (StringHelper.isNullOrEmpty(strDataAccAction) || dataAccObject.has(strDataAccAction)) continue;
                if (!bOk) {
                    dataAccObject.put(strDataAccAction, 0);
                    continue;
                }
                dataAccObject.put(strDataAccAction, 1);
            }
        }
    }

    protected void fillDataAccActions(JSONObject dataAccObject, IEntity iEntity) throws Exception {
        Iterator<String> deDataAccessActions;
        Iterator<String> accActions = this.getDataAccessActions();
        if (accActions != null) {
            while (accActions.hasNext()) {
                String strAction = accActions.next();
                if (StringHelper.isNullOrEmpty(strAction) || dataAccObject.has(strAction)) continue;
                CallResult callResult = this.testDataAccessAction(iEntity, strAction);
                if (callResult.isError()) {
                    dataAccObject.put(strAction, 0);
                    continue;
                }
                dataAccObject.put(strAction, 1);
            }
        }
        if ((deDataAccessActions = this.getViewController().getDEDataAccessActions(this.getDEModel().getName())) != null) {
            while (deDataAccessActions.hasNext()) {
                String strDataAccAction = deDataAccessActions.next();
                if (StringHelper.isNullOrEmpty(strDataAccAction) || dataAccObject.has(strDataAccAction)) continue;
                CallResult callResult = this.testDataAccessAction(iEntity, strDataAccAction);
                if (callResult.isError()) {
                    dataAccObject.put(strDataAccAction, 0);
                    continue;
                }
                dataAccObject.put(strDataAccAction, 1);
            }
        }
    }

    @Override
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    protected void setEnableCache(boolean bEnableCache) {
        this.bEnableCache = bEnableCache;
    }

    @Override
    public int getCacheScope() {
        return this.nCacheScope;
    }

    protected void setCacheScope(int nCacheScope) {
        this.nCacheScope = nCacheScope;
    }

    @Override
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    protected void setCacheTimeout(int nCacheTimeout) {
        this.nCacheTimeout = nCacheTimeout;
    }

    @Override
    public String getUniStateId() {
        return this.strUniStateId;
    }

    protected void setUniStateId(String strUniStateId) {
        this.strUniStateId = strUniStateId;
        this.bHasUniStateModel = !StringHelper.isNullOrEmpty(this.strUniStateId);
    }

    @Override
    public Object getUniStateKeyValue() {
        return this.objUniStateKeyValue;
    }

    protected void setUniStateKeyValue(Object objUniStateKeyValue) {
        this.objUniStateKeyValue = objUniStateKeyValue;
    }

    @Override
    public String getUniStateField() {
        return this.strUniStateField;
    }

    protected void setUniStateField(String strUniStateField) {
        this.strUniStateField = strUniStateField;
    }

    protected boolean hasUniStateModel() {
        return this.bHasUniStateModel;
    }

    protected IUniStateModel getUniStateModel() throws Exception {
        if (StringHelper.isNullOrEmpty(this.getUniStateId())) {
            return null;
        }
        if (this.iUniStateModel != null) {
            return this.iUniStateModel;
        }
        this.iUniStateModel = this.getSystemModel().getUniStateModel(this.getUniStateId());
        return this.iUniStateModel;
    }

    protected String getCacheDataTag(String strAction) throws Exception {
        return null;
    }

    public String getUserTag() {
        return this.strUserTag;
    }

    protected void setUserTag(String strUserTag) {
        this.strUserTag = strUserTag;
    }

    public String getUserTag2() {
        return this.strUserTag2;
    }

    protected void setUserTag2(String strUserTag2) {
        this.strUserTag2 = strUserTag2;
    }

    public String getUserTag3() {
        return this.strUserTag3;
    }

    protected void setUserTag3(String strUserTag3) {
        this.strUserTag3 = strUserTag3;
    }

    public String getUserTag4() {
        return this.strUserTag4;
    }

    protected void setUserTag4(String strUserTag4) {
        this.strUserTag4 = strUserTag4;
    }

    public boolean isUseServiceAPI() {
        if (this.getService() != null) {
            return this.getService().isUseServiceAPI();
        }
        return false;
    }
}

