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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDeployAppDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDeployAppDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeployApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeployBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDeployAppServiceBase
extends PSCoreSysServiceBase<PSSysDeployApp> {
    private static final Log log = LogFactory.getLog(PSSysDeployAppServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDeployAppDEModel pSSysDeployAppDEModel;
    private PSSysDeployAppDAO pSSysDeployAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployAppService";
    }

    public PSSysDeployAppDEModel getPSSysDeployAppDEModel() {
        if (this.pSSysDeployAppDEModel == null) {
            try {
                this.pSSysDeployAppDEModel = (PSSysDeployAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDeployAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDeployAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDeployAppDEModel();
    }

    public PSSysDeployAppDAO getPSSysDeployAppDAO() {
        if (this.pSSysDeployAppDAO == null) {
            try {
                this.pSSysDeployAppDAO = (PSSysDeployAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDeployAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDeployAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDeployAppDAO();
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

    protected void onFillParentInfo(PSSysDeployApp pSSysDeployApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEPLOYAPP_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysDeployApp, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEPLOYAPP_PSSYSDEPLOY_PSSYSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService", (SessionFactory)this.getSessionFactory());
            PSSysDeploy pSSysDeploy = (PSSysDeploy)iService.getDEModel().createEntity();
            pSSysDeploy.set("PSSYSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDeploy);
            } else {
                iService.get((IEntity)pSSysDeploy);
            }
            this.onFillParentInfo_Pssysdeploy(pSSysDeployApp, pSSysDeploy);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDeployApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysApp(PSSysDeployApp pSSysDeployApp, PSSysApp pSSysApp) throws Exception {
        pSSysDeployApp.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysDeployApp.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_Pssysdeploy(PSSysDeployApp pSSysDeployApp, PSSysDeploy pSSysDeploy) throws Exception {
        pSSysDeployApp.setPSSysDeployId(pSSysDeploy.getPSSysDeployId());
        pSSysDeployApp.setPSSysDeployName(pSSysDeploy.getPSSysDeployName());
    }

    protected void onFillEntityFullInfo(PSSysDeployApp pSSysDeployApp, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysDeployApp, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysDeployApp, bl);
        this.onFillEntityFullInfo_Pssysdeploy(pSSysDeployApp, bl);
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysDeployApp pSSysDeployApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pssysdeploy(PSSysDeployApp pSSysDeployApp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDeployApp pSSysDeployApp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDeployApp, bl);
    }

    public ArrayList<PSSysDeployApp> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysDeployApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysDeployApp> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDeployApp> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase) throws Exception {
        return this.selectByPssysdeploy(pSSysDeployBase, "", -1);
    }

    public ArrayList<PSSysDeployApp> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase, String string) throws Exception {
        return this.selectByPssysdeploy(pSSysDeployBase, string, -1);
    }

    public ArrayList<PSSysDeployApp> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDEPLOYID", (Object)pSSysDeployBase.getPSSysDeployId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssysdeployCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssysdeployCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysDeployApp> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDEPLOYAPP_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSSYSDEPLOYAPP", iDataEntityModel.getDataInfo((IEntity)pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysDeployApp> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysDeployApp pSSysDeployApp : arrayList) {
            PSSysDeployApp pSSysDeployApp2 = (PSSysDeployApp)this.getDEModel().createEntity();
            pSSysDeployApp2.setPSSysDeployAppId(pSSysDeployApp.getPSSysDeployAppId());
            pSSysDeployApp2.setPSSysAppId(null);
            this.update(pSSysDeployApp2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDeployAppServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysDeployAppServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysDeployAppServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysDeployApp> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysDeployApp pSSysDeployApp : arrayList) {
            this.remove((IEntity)pSSysDeployApp);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysDeployApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysDeployApp> arrayList) throws Exception {
    }

    public void testRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    public void resetPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        ArrayList<PSSysDeployApp> arrayList = this.selectByPssysdeploy(pSSysDeploy);
        for (PSSysDeployApp pSSysDeployApp : arrayList) {
            PSSysDeployApp pSSysDeployApp2 = (PSSysDeployApp)this.getDEModel().createEntity();
            pSSysDeployApp2.setPSSysDeployAppId(pSSysDeployApp.getPSSysDeployAppId());
            pSSysDeployApp2.setPSSysDeployId(null);
            this.update(pSSysDeployApp2);
        }
    }

    public void removeByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        final PSSysDeploy pSSysDeploy2 = pSSysDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDeployAppServiceBase.this.onBeforeRemoveByPssysdeploy(pSSysDeploy2);
                PSSysDeployAppServiceBase.this.internalRemoveByPssysdeploy(pSSysDeploy2);
                PSSysDeployAppServiceBase.this.onAfterRemoveByPssysdeploy(pSSysDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    protected void internalRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        ArrayList<PSSysDeployApp> arrayList = this.selectByPssysdeploy(pSSysDeploy);
        this.onBeforeRemoveByPssysdeploy(pSSysDeploy, arrayList);
        for (PSSysDeployApp pSSysDeployApp : arrayList) {
            this.remove((IEntity)pSSysDeployApp);
        }
        this.onAfterRemoveByPssysdeploy(pSSysDeploy, arrayList);
    }

    protected void onAfterRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPssysdeploy(PSSysDeploy pSSysDeploy, ArrayList<PSSysDeployApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssysdeploy(PSSysDeploy pSSysDeploy, ArrayList<PSSysDeployApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDeployApp pSSysDeployApp) throws Exception {
        super.onBeforeRemove(pSSysDeployApp);
    }

    protected void replaceParentInfo(PSSysDeployApp pSSysDeployApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDeployApp, cloneSession);
        if (pSSysDeployApp.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysDeployApp.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysDeployApp, (PSSysApp)iEntity);
        }
        if (pSSysDeployApp.getPSSysDeployId() != null && (iEntity = cloneSession.getEntity("PSSYSDEPLOY", (Object)pSSysDeployApp.getPSSysDeployId())) != null) {
            this.onFillParentInfo_Pssysdeploy(pSSysDeployApp, (PSSysDeploy)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDeployApp pSSysDeployApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDeployApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDeployApp pSSysDeployApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysDeployApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysDeployApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployAppId(bl, pSSysDeployApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployAppName(bl, pSSysDeployApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployId(bl, pSSysDeployApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDeployApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDeployApp pSSysDeployApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployApp.isMemoDirty() : !pSSysDeployApp.isMemoDirty()) {
            return null;
        }
        String string = pSSysDeployApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysDeployApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysDeployApp pSSysDeployApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployApp.isPSSysAppIdDirty() && !bl2 : !pSSysDeployApp.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysDeployApp.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSysDeployApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDeployAppId(boolean bl, PSSysDeployApp pSSysDeployApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployApp.isPSSysDeployAppIdDirty() && !bl2 : !pSSysDeployApp.isPSSysDeployAppIdDirty()) {
            return null;
        }
        String string = pSSysDeployApp.getPSSysDeployAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployAppId_Default((IEntity)pSSysDeployApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDeployAppName(boolean bl, PSSysDeployApp pSSysDeployApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployApp.isPSSysDeployAppNameDirty() && !bl2 : !pSSysDeployApp.isPSSysDeployAppNameDirty()) {
            return null;
        }
        String string = pSSysDeployApp.getPSSysDeployAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployAppName_Default((IEntity)pSSysDeployApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDeployId(boolean bl, PSSysDeployApp pSSysDeployApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployApp.isPSSysDeployIdDirty() && !bl2 : !pSSysDeployApp.isPSSysDeployIdDirty()) {
            return null;
        }
        String string = pSSysDeployApp.getPSSysDeployId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployId_Default((IEntity)pSSysDeployApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDeployApp pSSysDeployApp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDeployApp, bl);
    }

    protected void onSyncIndexEntities(PSSysDeployApp pSSysDeployApp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDeployApp, bl);
    }

    public Object getDataContextValue(PSSysDeployApp pSSysDeployApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDeployApp, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDeployApp pSSysDeployApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDeployApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysDeployAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDeployApp pSSysDeployApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDeployApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDeployApp pSSysDeployApp) throws Exception {
        super.onUpdateParent((IEntity)pSSysDeployApp);
    }

    @Override
    protected void exportCurXmlModel(PSSysDeployApp pSSysDeployApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDEPLOYAPP");
        if (!bl) {
            super.exportCurXmlModel(pSSysDeployApp, xmlNode, bl);
        }
    }
}

