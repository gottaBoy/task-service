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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppSubAppDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppSubAppDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSubApp;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubAppBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppSubAppServiceBase
extends PSCoreSysServiceBase<PSAppSubApp> {
    private static final Log log = LogFactory.getLog(PSAppSubAppServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppSubAppDEModel pSAppSubAppDEModel;
    private PSAppSubAppDAO pSAppSubAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppService";
    }

    public PSAppSubAppDEModel getPSAppSubAppDEModel() {
        if (this.pSAppSubAppDEModel == null) {
            try {
                this.pSAppSubAppDEModel = (PSAppSubAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppSubAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppSubAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppSubAppDEModel();
    }

    public PSAppSubAppDAO getPSAppSubAppDAO() {
        if (this.pSAppSubAppDAO == null) {
            try {
                this.pSAppSubAppDAO = (PSAppSubAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppSubAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppSubAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppSubAppDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSAppSubApp pSAppSubApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSUBAPP_PSSUBAPP_PSSUBAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubAppService", (SessionFactory)this.getSessionFactory());
            PSSubApp pSSubApp = (PSSubApp)iService.getDEModel().createEntity();
            pSSubApp.set("PSSUBAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubApp);
            } else {
                iService.get(pSSubApp);
            }
            this.onFillParentInfo_PSSubApp(pSAppSubApp, pSSubApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSUBAPP_PSSUBSYS_PSSUBSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysService", (SessionFactory)this.getSessionFactory());
            PSSubSys pSSubSys = (PSSubSys)iService.getDEModel().createEntity();
            pSSubSys.set("PSSUBSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSys);
            } else {
                iService.get(pSSubSys);
            }
            this.onFillParentInfo_PSSubSys(pSAppSubApp, pSSubSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSUBAPP_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppSubApp, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSAppSubApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSubApp(PSAppSubApp pSAppSubApp, PSSubApp pSSubApp) throws Exception {
        pSAppSubApp.setPSSubAppId(pSSubApp.getPSSubAppId());
        pSAppSubApp.setPSSubAppName(pSSubApp.getPSSubAppName());
    }

    protected void onFillParentInfo_PSSubSys(PSAppSubApp pSAppSubApp, PSSubSys pSSubSys) throws Exception {
        pSAppSubApp.setPSSubSysId(pSSubSys.getPSSubSysId());
        pSAppSubApp.setPSSubSysName(pSSubSys.getPSSubSysName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppSubApp pSAppSubApp, PSSysApp pSSysApp) throws Exception {
        pSAppSubApp.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppSubApp.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillEntityFullInfo(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSAppSubApp, bl);
        this.onFillEntityFullInfo_PSSubApp(pSAppSubApp, bl);
        this.onFillEntityFullInfo_PSSubSys(pSAppSubApp, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppSubApp, bl);
    }

    protected void onFillEntityFullInfo_PSSubApp(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSys(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppSubApp, bl);
    }

    public ArrayList<PSAppSubApp> selectByPSSubApp(PSSubAppBase pSSubAppBase) throws Exception {
        return this.selectByPSSubApp(pSSubAppBase, "", -1);
    }

    public ArrayList<PSAppSubApp> selectByPSSubApp(PSSubAppBase pSSubAppBase, String string) throws Exception {
        return this.selectByPSSubApp(pSSubAppBase, string, -1);
    }

    public ArrayList<PSAppSubApp> selectByPSSubApp(PSSubAppBase pSSubAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppSubApp> selectByPSSubSys(PSSubSysBase pSSubSysBase) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, "", -1);
    }

    public ArrayList<PSAppSubApp> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, string, -1);
    }

    public ArrayList<PSAppSubApp> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSID", (Object)pSSubSysBase.getPSSubSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSubApp> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppSubApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppSubApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSubApp(pSSubApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPSUBAPP_PSSUBAPP_PSSUBAPPID", "", iDataEntityModel.getName(), "PSAPPSUBAPP", iDataEntityModel.getDataInfo(pSSubApp), arrayList.get(0)));
        }
    }

    public void resetPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSubApp(pSSubApp);
        for (PSAppSubApp pSAppSubApp : arrayList) {
            PSAppSubApp pSAppSubApp2 = (PSAppSubApp)this.getDEModel().createEntity();
            pSAppSubApp2.setPSAppSubAppId(pSAppSubApp.getPSAppSubAppId());
            pSAppSubApp2.setPSSubAppId(null);
            this.update(pSAppSubApp2);
        }
    }

    public void removeByPSSubApp(PSSubApp pSSubApp) throws Exception {
        final PSSubApp pSSubApp2 = pSSubApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSubAppServiceBase.this.onBeforeRemoveByPSSubApp(pSSubApp2);
                PSAppSubAppServiceBase.this.internalRemoveByPSSubApp(pSSubApp2);
                PSAppSubAppServiceBase.this.onAfterRemoveByPSSubApp(pSSubApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
    }

    protected void internalRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSubApp(pSSubApp);
        this.onBeforeRemoveByPSSubApp(pSSubApp, arrayList);
        for (PSAppSubApp pSAppSubApp : arrayList) {
            this.remove(pSAppSubApp);
        }
        this.onAfterRemoveByPSSubApp(pSSubApp, arrayList);
    }

    protected void onAfterRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSubApp(PSSubApp pSSubApp, ArrayList<PSAppSubApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubApp(PSSubApp pSSubApp, ArrayList<PSAppSubApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSubSys(pSSubSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPSUBAPP_PSSUBSYS_PSSUBSYSID", "", iDataEntityModel.getName(), "PSAPPSUBAPP", iDataEntityModel.getDataInfo(pSSubSys), arrayList.get(0)));
        }
    }

    public void resetPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSubSys(pSSubSys);
        for (PSAppSubApp pSAppSubApp : arrayList) {
            PSAppSubApp pSAppSubApp2 = (PSAppSubApp)this.getDEModel().createEntity();
            pSAppSubApp2.setPSAppSubAppId(pSAppSubApp.getPSAppSubAppId());
            pSAppSubApp2.setPSSubSysId(null);
            this.update(pSAppSubApp2);
        }
    }

    public void removeByPSSubSys(PSSubSys pSSubSys) throws Exception {
        final PSSubSys pSSubSys2 = pSSubSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSubAppServiceBase.this.onBeforeRemoveByPSSubSys(pSSubSys2);
                PSAppSubAppServiceBase.this.internalRemoveByPSSubSys(pSSubSys2);
                PSAppSubAppServiceBase.this.onAfterRemoveByPSSubSys(pSSubSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void internalRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSubSys(pSSubSys);
        this.onBeforeRemoveByPSSubSys(pSSubSys, arrayList);
        for (PSAppSubApp pSAppSubApp : arrayList) {
            this.remove(pSAppSubApp);
        }
        this.onAfterRemoveByPSSubSys(pSSubSys, arrayList);
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSAppSubApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSAppSubApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppSubApp pSAppSubApp : arrayList) {
            PSAppSubApp pSAppSubApp2 = (PSAppSubApp)this.getDEModel().createEntity();
            pSAppSubApp2.setPSAppSubAppId(pSAppSubApp.getPSAppSubAppId());
            pSAppSubApp2.setPSSysAppId(null);
            this.update(pSAppSubApp2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSubAppServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppSubAppServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppSubAppServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppSubApp> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppSubApp pSAppSubApp : arrayList) {
            this.remove(pSAppSubApp);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppSubApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppSubApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppSubApp pSAppSubApp) throws Exception {
        PSAppFuncService pSAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        pSAppFuncService.testRemoveByPSAppSubApp(pSAppSubApp);
        super.onBeforeRemove(pSAppSubApp);
    }

    protected void replaceParentInfo(PSAppSubApp pSAppSubApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppSubApp, cloneSession);
        if (pSAppSubApp.getPSSubAppId() != null && (iEntity = cloneSession.getEntity("PSSUBAPP", (Object)pSAppSubApp.getPSSubAppId())) != null) {
            this.onFillParentInfo_PSSubApp(pSAppSubApp, (PSSubApp)iEntity);
        }
        if (pSAppSubApp.getPSSubSysId() != null && (iEntity = cloneSession.getEntity("PSSUBSYS", (Object)pSAppSubApp.getPSSubSysId())) != null) {
            this.onFillParentInfo_PSSubSys(pSAppSubApp, (PSSubSys)iEntity);
        }
        if (pSAppSubApp.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppSubApp.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppSubApp, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppSubApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FolderName(bl, pSAppSubApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppSubApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppSubAppId(bl, pSAppSubApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppSubAppName(bl, pSAppSubApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubAppId(bl, pSAppSubApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysId(bl, pSAppSubApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppSubApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppSubApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FolderName(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSubApp.isFolderNameDirty() : !pSAppSubApp.isFolderNameDirty()) {
            return null;
        }
        String string = pSAppSubApp.getFolderName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FolderName_Default(pSAppSubApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOLDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSubApp.isMemoDirty() : !pSAppSubApp.isMemoDirty()) {
            return null;
        }
        String string = pSAppSubApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppSubApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppSubAppId(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSubApp.isPSAppSubAppIdDirty() && !bl2 : !pSAppSubApp.isPSAppSubAppIdDirty()) {
            return null;
        }
        String string = pSAppSubApp.getPSAppSubAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSUBAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppSubAppId_Default(pSAppSubApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSUBAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppSubAppName(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSubApp.isPSAppSubAppNameDirty() && !bl2 : !pSAppSubApp.isPSAppSubAppNameDirty()) {
            return null;
        }
        String string = pSAppSubApp.getPSAppSubAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSUBAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppSubAppName_Default(pSAppSubApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSUBAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppSubAppDEModel(), "PSAPPSUBAPPNAME", string3, pSAppSubApp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPSUBAPPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubAppId(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSubApp.isPSSubAppIdDirty() && !bl2 : !pSAppSubApp.isPSSubAppIdDirty()) {
            return null;
        }
        String string = pSAppSubApp.getPSSubAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubAppId_Default(pSAppSubApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppSubAppDEModel(), "PSSUBAPPID", string3, pSAppSubApp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSUBAPPID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysId(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSubApp.isPSSubSysIdDirty() && !bl2 : !pSAppSubApp.isPSSubSysIdDirty()) {
            return null;
        }
        String string = pSAppSubApp.getPSSubSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysId_Default(pSAppSubApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppSubApp pSAppSubApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSubApp.isPSSysAppIdDirty() && !bl2 : !pSAppSubApp.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppSubApp.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppSubApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
        super.onSyncEntity(pSAppSubApp, bl);
    }

    protected void onSyncIndexEntities(PSAppSubApp pSAppSubApp, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppSubApp, bl);
    }

    public Object getDataContextValue(PSAppSubApp pSAppSubApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppSubApp, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppSubApp.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppSubApp pSAppSubApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppSubApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSUBAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSubAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSUBAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSubAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_FolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FOLDERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("FOLDERNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppSubAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSUBAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppSubAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSUBAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSubSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppSubApp pSAppSubApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppSubApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppSubApp pSAppSubApp) throws Exception {
        super.onUpdateParent(pSAppSubApp);
    }

    @Override
    protected void exportCurXmlModel(PSAppSubApp pSAppSubApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPSUBAPP");
        if (!bl) {
            super.exportCurXmlModel(pSAppSubApp, xmlNode, bl);
        }
    }
}

