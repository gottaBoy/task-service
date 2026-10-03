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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppDEViewRefDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppDEViewRefDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEViewRef;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppDEViewRefServiceBase
extends PSCoreSysServiceBase<PSAppDEViewRef> {
    private static final Log log = LogFactory.getLog(PSAppDEViewRefServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppDEViewRefDEModel pSAppDEViewRefDEModel;
    private PSAppDEViewRefDAO pSAppDEViewRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefService";
    }

    public PSAppDEViewRefDEModel getPSAppDEViewRefDEModel() {
        if (this.pSAppDEViewRefDEModel == null) {
            try {
                this.pSAppDEViewRefDEModel = (PSAppDEViewRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppDEViewRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppDEViewRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppDEViewRefDEModel();
    }

    public PSAppDEViewRefDAO getPSAppDEViewRefDAO() {
        if (this.pSAppDEViewRefDAO == null) {
            try {
                this.pSAppDEViewRefDAO = (PSAppDEViewRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppDEViewRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppDEViewRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppDEViewRefDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSAppDEViewRef pSAppDEViewRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPDEVIEWREF_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSAppDEViewRef, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPDEVIEWREF_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppDEViewRef, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSAppDEViewRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEViewBase(PSAppDEViewRef pSAppDEViewRef, PSDEViewBase pSDEViewBase) throws Exception {
        pSAppDEViewRef.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSAppDEViewRef.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppDEViewRef pSAppDEViewRef, PSSysApp pSSysApp) throws Exception {
        pSAppDEViewRef.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppDEViewRef.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillEntityFullInfo(PSAppDEViewRef pSAppDEViewRef, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSAppDEViewRef, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSAppDEViewRef, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppDEViewRef, bl);
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSAppDEViewRef pSAppDEViewRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppDEViewRef pSAppDEViewRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppDEViewRef pSAppDEViewRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppDEViewRef, bl);
    }

    public ArrayList<PSAppDEViewRef> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSAppDEViewRef> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSAppDEViewRef> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppDEViewRef> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppDEViewRef> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppDEViewRef> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppDEViewRef> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSAppDEViewRef pSAppDEViewRef : arrayList) {
            PSAppDEViewRef pSAppDEViewRef2 = (PSAppDEViewRef)this.getDEModel().createEntity();
            pSAppDEViewRef2.setPSAppDEViewRefId(pSAppDEViewRef.getPSAppDEViewRefId());
            pSAppDEViewRef2.setPSDEViewBaseId(null);
            this.update(pSAppDEViewRef2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppDEViewRefServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSAppDEViewRefServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSAppDEViewRefServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppDEViewRef> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSAppDEViewRef pSAppDEViewRef : arrayList) {
            this.remove(pSAppDEViewRef);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSAppDEViewRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSAppDEViewRef> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppDEViewRef> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppDEViewRef pSAppDEViewRef : arrayList) {
            PSAppDEViewRef pSAppDEViewRef2 = (PSAppDEViewRef)this.getDEModel().createEntity();
            pSAppDEViewRef2.setPSAppDEViewRefId(pSAppDEViewRef.getPSAppDEViewRefId());
            pSAppDEViewRef2.setPSSysAppId(null);
            this.update(pSAppDEViewRef2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppDEViewRefServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppDEViewRefServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppDEViewRefServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppDEViewRef> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppDEViewRef pSAppDEViewRef : arrayList) {
            this.remove(pSAppDEViewRef);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppDEViewRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppDEViewRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppDEViewRef pSAppDEViewRef) throws Exception {
        super.onBeforeRemove(pSAppDEViewRef);
    }

    protected void replaceParentInfo(PSAppDEViewRef pSAppDEViewRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppDEViewRef, cloneSession);
        if (pSAppDEViewRef.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSAppDEViewRef.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSAppDEViewRef, (PSDEViewBase)iEntity);
        }
        if (pSAppDEViewRef.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppDEViewRef.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppDEViewRef, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppDEViewRef pSAppDEViewRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppDEViewRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppDEViewRef pSAppDEViewRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSAppDEViewRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppDEViewRefId(bl, pSAppDEViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppDEViewRefName(bl, pSAppDEViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSAppDEViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppDEViewRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppDEViewRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppDEViewRef pSAppDEViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDEViewRef.isMemoDirty() : !pSAppDEViewRef.isMemoDirty()) {
            return null;
        }
        String string = pSAppDEViewRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppDEViewRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppDEViewRefId(boolean bl, PSAppDEViewRef pSAppDEViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDEViewRef.isPSAppDEViewRefIdDirty() && !bl2 : !pSAppDEViewRef.isPSAppDEViewRefIdDirty()) {
            return null;
        }
        String string = pSAppDEViewRef.getPSAppDEViewRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDEVIEWREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppDEViewRefId_Default(pSAppDEViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDEVIEWREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppDEViewRefName(boolean bl, PSAppDEViewRef pSAppDEViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDEViewRef.isPSAppDEViewRefNameDirty() && !bl2 : !pSAppDEViewRef.isPSAppDEViewRefNameDirty()) {
            return null;
        }
        String string = pSAppDEViewRef.getPSAppDEViewRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDEVIEWREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppDEViewRefName_Default(pSAppDEViewRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDEVIEWREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSAppDEViewRef pSAppDEViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDEViewRef.isPSDEViewBaseIdDirty() && !bl2 : !pSAppDEViewRef.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSAppDEViewRef.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSAppDEViewRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppDEViewRef pSAppDEViewRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDEViewRef.isPSSysAppIdDirty() && !bl2 : !pSAppDEViewRef.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppDEViewRef.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppDEViewRef, bl2, bl3);
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

    protected void onSyncEntity(PSAppDEViewRef pSAppDEViewRef, boolean bl) throws Exception {
        super.onSyncEntity(pSAppDEViewRef, bl);
    }

    protected void onSyncIndexEntities(PSAppDEViewRef pSAppDEViewRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppDEViewRef, bl);
    }

    public Object getDataContextValue(PSAppDEViewRef pSAppDEViewRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppDEViewRef, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSAppDEViewRef pSAppDEViewRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppDEViewRef, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSAPPDEVIEWREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDEViewRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPDEVIEWREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDEViewRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSAppDEViewRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDEVIEWREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppDEViewRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDEVIEWREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSAppDEViewRef pSAppDEViewRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppDEViewRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppDEViewRef pSAppDEViewRef) throws Exception {
        super.onUpdateParent(pSAppDEViewRef);
    }

    @Override
    protected void exportCurXmlModel(PSAppDEViewRef pSAppDEViewRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPDEVIEWREF");
        if (!bl) {
            pSAppDEViewRef.setCreateDate(null);
            pSAppDEViewRef.setCreateMan(null);
            pSAppDEViewRef.setPSAppDEViewRefId(null);
            pSAppDEViewRef.setUpdateDate(null);
            pSAppDEViewRef.setUpdateMan(null);
            super.exportCurXmlModel(pSAppDEViewRef, xmlNode, bl);
        }
    }
}

