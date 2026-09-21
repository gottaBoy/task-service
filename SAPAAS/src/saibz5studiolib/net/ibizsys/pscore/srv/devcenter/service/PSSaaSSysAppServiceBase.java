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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSSaaSSysAppDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSSaaSSysAppDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysApp;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysAppServiceBase
extends PSCoreSysServiceBase<PSSaaSSysApp> {
    private static final Log log = LogFactory.getLog(PSSaaSSysAppServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSaaSSysAppDEModel pSSaaSSysAppDEModel;
    private PSSaaSSysAppDAO pSSaaSSysAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService";
    }

    public PSSaaSSysAppDEModel getPSSaaSSysAppDEModel() {
        if (this.pSSaaSSysAppDEModel == null) {
            try {
                this.pSSaaSSysAppDEModel = (PSSaaSSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSSaaSSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSaaSSysAppDEModel();
    }

    public PSSaaSSysAppDAO getPSSaaSSysAppDAO() {
        if (this.pSSaaSSysAppDAO == null) {
            try {
                this.pSSaaSSysAppDAO = (PSSaaSSysAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSSaaSSysAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSaaSSysAppDAO();
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

    protected void onFillParentInfo(PSSaaSSysApp pSSaaSSysApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSAPP_PSAPPTYPE_PSAPPTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppTypeService", (SessionFactory)this.getSessionFactory());
            PSAppType pSAppType = (PSAppType)iService.getDEModel().createEntity();
            pSAppType.set("PSAPPTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppType);
            } else {
                iService.get((IEntity)pSAppType);
            }
            this.onFillParentInfo_PSAppType(pSSaaSSysApp, pSAppType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSAPP_PSSAASSYSVER_PSSAASSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysVer pSSaaSSysVer = (PSSaaSSysVer)iService.getDEModel().createEntity();
            pSSaaSSysVer.set("PSSAASSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSysVer);
            } else {
                iService.get((IEntity)pSSaaSSysVer);
            }
            this.onFillParentInfo_PSSaaSSysVer(pSSaaSSysApp, pSSaaSSysVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSSaaSSysApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppType(PSSaaSSysApp pSSaaSSysApp, PSAppType pSAppType) throws Exception {
        pSSaaSSysApp.setPSAppTypeId(pSAppType.getPSAppTypeId());
        pSSaaSSysApp.setPSAppTypeName(pSAppType.getPSAppTypeName());
    }

    protected void onFillParentInfo_PSSaaSSysVer(PSSaaSSysApp pSSaaSSysApp, PSSaaSSysVer pSSaaSSysVer) throws Exception {
        pSSaaSSysApp.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
        pSSaaSSysApp.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
    }

    protected void onFillEntityFullInfo(PSSaaSSysApp pSSaaSSysApp, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSaaSSysApp, bl);
        this.onFillEntityFullInfo_PSAppType(pSSaaSSysApp, bl);
        this.onFillEntityFullInfo_PSSaaSSysVer(pSSaaSSysApp, bl);
    }

    protected void onFillEntityFullInfo_PSAppType(PSSaaSSysApp pSSaaSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSaaSSysVer(PSSaaSSysApp pSSaaSSysApp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSaaSSysApp pSSaaSSysApp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSaaSSysApp, bl);
    }

    public ArrayList<PSSaaSSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, "", -1);
    }

    public ArrayList<PSSaaSSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, string, -1);
    }

    public ArrayList<PSSaaSSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPTYPEID", (Object)pSAppTypeBase.getPSAppTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSaaSSysApp> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, "", -1);
    }

    public ArrayList<PSSaaSSysApp> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, string, -1);
    }

    public ArrayList<PSSaaSSysApp> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSVERID", (Object)pSSaaSSysVerBase.getPSSaaSSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSSaaSSysApp> arrayList = this.selectByPSAppType(pSAppType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSAPP_PSAPPTYPE_PSAPPTYPEID", "", iDataEntityModel.getName(), "PSSAASSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSAppType), arrayList.get(0)));
        }
    }

    public void resetPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSSaaSSysApp> arrayList = this.selectByPSAppType(pSAppType);
        for (PSSaaSSysApp pSSaaSSysApp : arrayList) {
            PSSaaSSysApp pSSaaSSysApp2 = (PSSaaSSysApp)this.getDEModel().createEntity();
            pSSaaSSysApp2.setPSSaaSSysAppId(pSSaaSSysApp.getPSSaaSSysAppId());
            pSSaaSSysApp2.setPSAppTypeId(null);
            this.update(pSSaaSSysApp2);
        }
    }

    public void removeByPSAppType(PSAppType pSAppType) throws Exception {
        final PSAppType pSAppType2 = pSAppType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysAppServiceBase.this.onBeforeRemoveByPSAppType(pSAppType2);
                PSSaaSSysAppServiceBase.this.internalRemoveByPSAppType(pSAppType2);
                PSSaaSSysAppServiceBase.this.onAfterRemoveByPSAppType(pSAppType2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void internalRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSSaaSSysApp> arrayList = this.selectByPSAppType(pSAppType);
        this.onBeforeRemoveByPSAppType(pSAppType, arrayList);
        for (PSSaaSSysApp pSSaaSSysApp : arrayList) {
            this.remove((IEntity)pSSaaSSysApp);
        }
        this.onAfterRemoveByPSAppType(pSAppType, arrayList);
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSSaaSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSSaaSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysApp> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSAASSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSaaSSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSAPP_PSSAASSYSVER_PSSAASSYSVERID", "", iDataEntityModel.getName(), "PSSAASSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSaaSSysVer), arrayList.get(0)));
        }
    }

    public void resetPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysApp> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        for (PSSaaSSysApp pSSaaSSysApp : arrayList) {
            PSSaaSSysApp pSSaaSSysApp2 = (PSSaaSSysApp)this.getDEModel().createEntity();
            pSSaaSSysApp2.setPSSaaSSysAppId(pSSaaSSysApp.getPSSaaSSysAppId());
            pSSaaSSysApp2.setPSSaaSSysVerId(null);
            this.update(pSSaaSSysApp2);
        }
    }

    public void removeByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        final PSSaaSSysVer pSSaaSSysVer2 = pSSaaSSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysAppServiceBase.this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSSaaSSysAppServiceBase.this.internalRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSSaaSSysAppServiceBase.this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysApp> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
        for (PSSaaSSysApp pSSaaSSysApp : arrayList) {
            this.remove((IEntity)pSSaaSSysApp);
        }
        this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSSaaSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSSaaSSysApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        super.onBeforeRemove(pSSaaSSysApp);
    }

    protected void replaceParentInfo(PSSaaSSysApp pSSaaSSysApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSaaSSysApp, cloneSession);
        if (pSSaaSSysApp.getPSAppTypeId() != null && (iEntity = cloneSession.getEntity("PSAPPTYPE", (Object)pSSaaSSysApp.getPSAppTypeId())) != null) {
            this.onFillParentInfo_PSAppType(pSSaaSSysApp, (PSAppType)iEntity);
        }
        if (pSSaaSSysApp.getPSSaaSSysVerId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSVER", (Object)pSSaaSSysApp.getPSSaaSSysVerId())) != null) {
            this.onFillParentInfo_PSSaaSSysVer(pSSaaSSysApp, (PSSaaSSysVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSaaSSysApp pSSaaSSysApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSaaSSysApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppPKGName(bl, pSSaaSSysApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeId(bl, pSSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAppId(bl, pSSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAppName(bl, pSSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerId(bl, pSSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSaaSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSaaSSysApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppPKGName(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysApp.isAppPKGNameDirty() : !pSSaaSSysApp.isAppPKGNameDirty()) {
            return null;
        }
        String string = pSSaaSSysApp.getAppPKGName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppPKGName_Default((IEntity)pSSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysApp.isMemoDirty() : !pSSaaSSysApp.isMemoDirty()) {
            return null;
        }
        String string = pSSaaSSysApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSaaSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppTypeId(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysApp.isPSAppTypeIdDirty() : !pSSaaSSysApp.isPSAppTypeIdDirty()) {
            return null;
        }
        String string = pSSaaSSysApp.getPSAppTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeId_Default((IEntity)pSSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAppId(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysApp.isPSSaaSSysAppIdDirty() && !bl2 : !pSSaaSSysApp.isPSSaaSSysAppIdDirty()) {
            return null;
        }
        String string = pSSaaSSysApp.getPSSaaSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAppId_Default((IEntity)pSSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAppName(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysApp.isPSSaaSSysAppNameDirty() && !bl2 : !pSSaaSSysApp.isPSSaaSSysAppNameDirty()) {
            return null;
        }
        String string = pSSaaSSysApp.getPSSaaSSysAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAppName_Default((IEntity)pSSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerId(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysApp.isPSSaaSSysVerIdDirty() && !bl2 : !pSSaaSSysApp.isPSSaaSSysVerIdDirty()) {
            return null;
        }
        String string = pSSaaSSysApp.getPSSaaSSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerId_Default((IEntity)pSSaaSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSaaSSysApp pSSaaSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysApp.isPSSysAppIdDirty() && !bl2 : !pSSaaSSysApp.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSaaSSysApp.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSaaSSysApp, bl2, bl3);
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

    protected void onSyncEntity(PSSaaSSysApp pSSaaSSysApp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSaaSSysApp, bl);
    }

    protected void onSyncIndexEntities(PSSaaSSysApp pSSaaSSysApp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSaaSSysApp, bl);
    }

    public Object getDataContextValue(PSSaaSSysApp pSSaaSSysApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSaaSSysApp, string, iDataContextParam)) != null) {
            return object;
        }
        PSSaaSSysVer pSSaaSSysVer = pSSaaSSysApp.getPSSaaSSysVer();
        if (pSSaaSSysVer != null && pSSaaSSysVer.contains(string)) {
            return pSSaaSSysVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSaaSSysApp pSSaaSSysApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSaaSSysApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppPKGName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppPKGName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPPKGNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSAppTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSaaSSysApp pSSaaSSysApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSaaSSysApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSaaSSysApp pSSaaSSysApp) throws Exception {
        super.onUpdateParent((IEntity)pSSaaSSysApp);
    }

    @Override
    protected void exportCurXmlModel(PSSaaSSysApp pSSaaSSysApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSAASSYSAPP");
        if (!bl) {
            pSSaaSSysApp.setCreateDate(null);
            pSSaaSSysApp.setCreateMan(null);
            pSSaaSSysApp.setPSAppTypeName(null);
            pSSaaSSysApp.setPSSaaSSysAppId(null);
            pSSaaSSysApp.setUpdateDate(null);
            pSSaaSSysApp.setUpdateMan(null);
            super.exportCurXmlModel(pSSaaSSysApp, xmlNode, bl);
        }
    }
}

