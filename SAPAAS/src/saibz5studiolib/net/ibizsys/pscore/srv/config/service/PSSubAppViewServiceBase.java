/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.config.dao.PSSubAppViewDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSubAppViewDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubAppBase;
import net.ibizsys.pscore.srv.config.entity.PSSubAppView;
import net.ibizsys.pscore.srv.config.entity.PSSubDEView;
import net.ibizsys.pscore.srv.config.entity.PSSubDEViewBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubAppViewServiceBase
extends PSCoreSysServiceBase<PSSubAppView> {
    private static final Log log = LogFactory.getLog(PSSubAppViewServiceBase.class);
    public static final String DATASET_CURSUBAPP = "CurSubApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubAppViewDEModel pSSubAppViewDEModel;
    private PSSubAppViewDAO pSSubAppViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSubAppViewService";
    }

    public PSSubAppViewDEModel getPSSubAppViewDEModel() {
        if (this.pSSubAppViewDEModel == null) {
            try {
                this.pSSubAppViewDEModel = (PSSubAppViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubAppViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubAppViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubAppViewDEModel();
    }

    public PSSubAppViewDAO getPSSubAppViewDAO() {
        if (this.pSSubAppViewDAO == null) {
            try {
                this.pSSubAppViewDAO = (PSSubAppViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSubAppViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubAppViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubAppViewDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSUBAPP, (boolean)true) == 0) {
            return this.fetchCurSubApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSubApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSUBAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSubAppView pSSubAppView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBAPPVIEW_PSSUBAPP_PSSUBAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubAppService", (SessionFactory)this.getSessionFactory());
            PSSubApp pSSubApp = (PSSubApp)iService.getDEModel().createEntity();
            pSSubApp.set("PSSUBAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubApp);
            } else {
                iService.get(pSSubApp);
            }
            this.onFillParentInfo_PSSubApp(pSSubAppView, pSSubApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBAPPVIEW_PSSUBDEVIEW_PSSUBDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubDEViewService", (SessionFactory)this.getSessionFactory());
            PSSubDEView pSSubDEView = (PSSubDEView)iService.getDEModel().createEntity();
            pSSubDEView.set("PSSUBDEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubDEView);
            } else {
                iService.get(pSSubDEView);
            }
            this.onFillParentInfo_PSSubDEView(pSSubAppView, pSSubDEView);
            return;
        }
        super.onFillParentInfo(pSSubAppView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSubApp(PSSubAppView pSSubAppView, PSSubApp pSSubApp) throws Exception {
        pSSubAppView.setPSSubAppId(pSSubApp.getPSSubAppId());
        pSSubAppView.setPSSubAppName(pSSubApp.getPSSubAppName());
    }

    protected void onFillParentInfo_PSSubDEView(PSSubAppView pSSubAppView, PSSubDEView pSSubDEView) throws Exception {
        pSSubAppView.setPSSubDEViewId(pSSubDEView.getPSSubDEViewId());
        pSSubAppView.setPSSubDEViewName(pSSubDEView.getPSSubDEViewName());
    }

    protected boolean onFillEntityKeyValue(PSSubAppView pSSubAppView, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSubAppView.get("PSSUBAPPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSubAppView.get("PSAPPVIEWID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSubAppView.set(this.getPSSubAppViewDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSubAppView pSSubAppView, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSubAppView, bl);
        this.onFillEntityFullInfo_PSSubApp(pSSubAppView, bl);
        this.onFillEntityFullInfo_PSSubDEView(pSSubAppView, bl);
    }

    protected void onFillEntityFullInfo_PSSubApp(PSSubAppView pSSubAppView, boolean bl) throws Exception {
        if (pSSubAppView.isPSSubAppIdDirty()) {
            if (pSSubAppView.getPSSubAppId() != null) {
                if (pSSubAppView.getPSSubAppId() == null || pSSubAppView.getPSSubAppName() == null) {
                    PSSubApp pSSubApp = pSSubAppView.getPSSubApp();
                    pSSubAppView.setPSSubAppName(pSSubApp.getPSSubAppName());
                }
            } else {
                pSSubAppView.setPSSubAppName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubDEView(PSSubAppView pSSubAppView, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSubAppView pSSubAppView, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubAppView, bl);
    }

    public ArrayList<PSSubAppView> selectByPSSubApp(PSSubAppBase pSSubAppBase) throws Exception {
        return this.selectByPSSubApp(pSSubAppBase, "", -1);
    }

    public ArrayList<PSSubAppView> selectByPSSubApp(PSSubAppBase pSSubAppBase, String string) throws Exception {
        return this.selectByPSSubApp(pSSubAppBase, string, -1);
    }

    public ArrayList<PSSubAppView> selectByPSSubApp(PSSubAppBase pSSubAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBAPPID", (Object)pSSubAppBase.getPSSubAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubAppView> selectByPSSubDEView(PSSubDEViewBase pSSubDEViewBase) throws Exception {
        return this.selectByPSSubDEView(pSSubDEViewBase, "", -1);
    }

    public ArrayList<PSSubAppView> selectByPSSubDEView(PSSubDEViewBase pSSubDEViewBase, String string) throws Exception {
        return this.selectByPSSubDEView(pSSubDEViewBase, string, -1);
    }

    public ArrayList<PSSubAppView> selectByPSSubDEView(PSSubDEViewBase pSSubDEViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBDEVIEWID", (Object)pSSubDEViewBase.getPSSubDEViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubDEViewCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
    }

    public void resetPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSSubAppView> arrayList = this.selectByPSSubApp(pSSubApp);
        for (PSSubAppView pSSubAppView : arrayList) {
            PSSubAppView pSSubAppView2 = (PSSubAppView)this.getDEModel().createEntity();
            pSSubAppView2.setPSSubAppViewId(pSSubAppView.getPSSubAppViewId());
            pSSubAppView2.setPSSubAppId(null);
            this.update(pSSubAppView2);
        }
    }

    public void removeByPSSubApp(PSSubApp pSSubApp) throws Exception {
        final PSSubApp pSSubApp2 = pSSubApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubAppViewServiceBase.this.onBeforeRemoveByPSSubApp(pSSubApp2);
                PSSubAppViewServiceBase.this.internalRemoveByPSSubApp(pSSubApp2);
                PSSubAppViewServiceBase.this.onAfterRemoveByPSSubApp(pSSubApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
    }

    protected void internalRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSSubAppView> arrayList = this.selectByPSSubApp(pSSubApp);
        this.onBeforeRemoveByPSSubApp(pSSubApp, arrayList);
        for (PSSubAppView pSSubAppView : arrayList) {
            this.remove(pSSubAppView);
        }
        this.onAfterRemoveByPSSubApp(pSSubApp, arrayList);
    }

    protected void onAfterRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSubApp(PSSubApp pSSubApp, ArrayList<PSSubAppView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubApp(PSSubApp pSSubApp, ArrayList<PSSubAppView> arrayList) throws Exception {
    }

    public void testRemoveByPSSubDEView(PSSubDEView pSSubDEView) throws Exception {
    }

    public void resetPSSubDEView(PSSubDEView pSSubDEView) throws Exception {
        ArrayList<PSSubAppView> arrayList = this.selectByPSSubDEView(pSSubDEView);
        for (PSSubAppView pSSubAppView : arrayList) {
            PSSubAppView pSSubAppView2 = (PSSubAppView)this.getDEModel().createEntity();
            pSSubAppView2.setPSSubAppViewId(pSSubAppView.getPSSubAppViewId());
            pSSubAppView2.setPSSubDEViewId(null);
            this.update(pSSubAppView2);
        }
    }

    public void removeByPSSubDEView(PSSubDEView pSSubDEView) throws Exception {
        final PSSubDEView pSSubDEView2 = pSSubDEView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubAppViewServiceBase.this.onBeforeRemoveByPSSubDEView(pSSubDEView2);
                PSSubAppViewServiceBase.this.internalRemoveByPSSubDEView(pSSubDEView2);
                PSSubAppViewServiceBase.this.onAfterRemoveByPSSubDEView(pSSubDEView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubDEView(PSSubDEView pSSubDEView) throws Exception {
    }

    protected void internalRemoveByPSSubDEView(PSSubDEView pSSubDEView) throws Exception {
        ArrayList<PSSubAppView> arrayList = this.selectByPSSubDEView(pSSubDEView);
        this.onBeforeRemoveByPSSubDEView(pSSubDEView, arrayList);
        for (PSSubAppView pSSubAppView : arrayList) {
            this.remove(pSSubAppView);
        }
        this.onAfterRemoveByPSSubDEView(pSSubDEView, arrayList);
    }

    protected void onAfterRemoveByPSSubDEView(PSSubDEView pSSubDEView) throws Exception {
    }

    protected void onBeforeRemoveByPSSubDEView(PSSubDEView pSSubDEView, ArrayList<PSSubAppView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubDEView(PSSubDEView pSSubDEView, ArrayList<PSSubAppView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubAppView pSSubAppView) throws Exception {
        PSAppFuncService pSAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        pSAppFuncService.testRemoveByPSSubAppView(pSSubAppView);
        super.onBeforeRemove(pSSubAppView);
    }

    protected void replaceParentInfo(PSSubAppView pSSubAppView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubAppView, cloneSession);
        if (pSSubAppView.getPSSubAppId() != null && (iEntity = cloneSession.getEntity("PSSUBAPP", (Object)pSSubAppView.getPSSubAppId())) != null) {
            this.onFillParentInfo_PSSubApp(pSSubAppView, (PSSubApp)iEntity);
        }
        if (pSSubAppView.getPSSubDEViewId() != null && (iEntity = cloneSession.getEntity("PSSUBDEVIEW", (Object)pSSubAppView.getPSSubDEViewId())) != null) {
            this.onFillParentInfo_PSSubDEView(pSSubAppView, (PSSubDEView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubAppView pSSubAppView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubAppView, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackendUrl(bl, pSSubAppView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullCodeName(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleCodeName(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleName(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageUrl(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubAppId(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubAppName(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubAppViewId(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubAppViewName(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubDEViewId(bl, pSSubAppView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubAppView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackendUrl(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isBackendUrlDirty() : !pSSubAppView.isBackendUrlDirty()) {
            return null;
        }
        String string = pSSubAppView.getBackendUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BackendUrl_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKENDURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isCodeNameDirty() : !pSSubAppView.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubAppView.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullCodeName(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isFullCodeNameDirty() : !pSSubAppView.isFullCodeNameDirty()) {
            return null;
        }
        String string = pSSubAppView.getFullCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullCodeName_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleCodeName(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isModuleCodeNameDirty() : !pSSubAppView.isModuleCodeNameDirty()) {
            return null;
        }
        String string = pSSubAppView.getModuleCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleCodeName_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleName(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isModuleNameDirty() : !pSSubAppView.isModuleNameDirty()) {
            return null;
        }
        String string = pSSubAppView.getModuleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleName_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageUrl(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPageUrlDirty() : !pSSubAppView.isPageUrlDirty()) {
            return null;
        }
        String string = pSSubAppView.getPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PageUrl_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPSAppViewIdDirty() && !bl2 : !pSSubAppView.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSSubAppView.getPSAppViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPSDEViewBaseIdDirty() : !pSSubAppView.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSSubAppView.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubAppId(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPSSubAppIdDirty() : !pSSubAppView.isPSSubAppIdDirty()) {
            return null;
        }
        String string = pSSubAppView.getPSSubAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubAppId_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubAppName(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPSSubAppNameDirty() && !bl2 : !pSSubAppView.isPSSubAppNameDirty()) {
            return null;
        }
        String string = pSSubAppView.getPSSubAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubAppName_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubAppViewId(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPSSubAppViewIdDirty() && !bl2 : !pSSubAppView.isPSSubAppViewIdDirty()) {
            return null;
        }
        String string = pSSubAppView.getPSSubAppViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubAppViewId_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubAppViewName(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPSSubAppViewNameDirty() && !bl2 : !pSSubAppView.isPSSubAppViewNameDirty()) {
            return null;
        }
        String string = pSSubAppView.getPSSubAppViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubAppViewName_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubDEViewId(boolean bl, PSSubAppView pSSubAppView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubAppView.isPSSubDEViewIdDirty() : !pSSubAppView.isPSSubDEViewIdDirty()) {
            return null;
        }
        String string = pSSubAppView.getPSSubDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubDEViewId_Default(pSSubAppView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSubAppView pSSubAppView, boolean bl) throws Exception {
        super.onSyncEntity(pSSubAppView, bl);
    }

    protected void onSyncIndexEntities(PSSubAppView pSSubAppView, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubAppView, bl);
    }

    public Object getDataContextValue(PSSubAppView pSSubAppView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubAppView, string, iDataContextParam)) != null) {
            return object;
        }
        PSSubApp pSSubApp = pSSubAppView.getPSSubApp();
        if (pSSubApp != null && pSSubApp.contains(string)) {
            return pSSubApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSubAppView pSSubAppView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubAppView, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BACKENDURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackendUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BackendUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BACKENDURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FullCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLCODENAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULECODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PageUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PAGEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSubAppView pSSubAppView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubAppView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubAppView pSSubAppView) throws Exception {
        super.onUpdateParent(pSSubAppView);
    }

    @Override
    protected void exportCurXmlModel(PSSubAppView pSSubAppView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBAPPVIEW");
        if (!bl) {
            super.exportCurXmlModel(pSSubAppView, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSubAppView pSSubAppView, PSSystem pSSystem) throws Exception {
        PSSubAppView pSSubAppView2 = new PSSubAppView();
        pSSubAppView2.setPSSubAppId(pSSubAppView.getPSSubAppId());
        pSSubAppView2.setPSAppViewId(pSSubAppView.getPSAppViewId());
        if (this.selectOne(pSSubAppView2, true)) {
            return pSSubAppView2.getPSSubAppViewId();
        }
        return super.getEntityFolderKeyValue(pSSubAppView, pSSystem);
    }
}

