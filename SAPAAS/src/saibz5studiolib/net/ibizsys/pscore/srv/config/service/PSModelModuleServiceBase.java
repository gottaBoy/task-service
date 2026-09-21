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
import net.ibizsys.pscore.srv.config.dao.PSModelModuleDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelModuleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelModule;
import net.ibizsys.pscore.srv.config.entity.PSModelModuleBase;
import net.ibizsys.pscore.srv.config.service.PSModelModuleService;
import net.ibizsys.pscore.srv.config.service.PSModelSectionService;
import net.ibizsys.pscore.srv.config.service.PSModelSectionServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelModuleServiceBase
extends PSCoreSysServiceBase<PSModelModule> {
    private static final Log log = LogFactory.getLog(PSModelModuleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelModuleDEModel pSModelModuleDEModel;
    private PSModelModuleDAO pSModelModuleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelModuleService";
    }

    public PSModelModuleDEModel getPSModelModuleDEModel() {
        if (this.pSModelModuleDEModel == null) {
            try {
                this.pSModelModuleDEModel = (PSModelModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelModuleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelModuleDEModel();
    }

    public PSModelModuleDAO getPSModelModuleDAO() {
        if (this.pSModelModuleDAO == null) {
            try {
                this.pSModelModuleDAO = (PSModelModuleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelModuleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelModuleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelModuleDAO();
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

    protected void onFillParentInfo(PSModelModule pSModelModule, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELMODULE_PSMODELMODULE_PPSMODELMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelModuleService", (SessionFactory)this.getSessionFactory());
            PSModelModule pSModelModule2 = (PSModelModule)iService.getDEModel().createEntity();
            pSModelModule2.set("PSMODELMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelModule2);
            } else {
                iService.get((IEntity)pSModelModule2);
            }
            this.onFillParentInfo_Ppsmodelmodule(pSModelModule, pSModelModule2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELMODULE_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModel);
            } else {
                iService.get((IEntity)pSModel);
            }
            this.onFillParentInfo_Psmodel(pSModelModule, pSModel);
            return;
        }
        super.onFillParentInfo((IEntity)pSModelModule, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Ppsmodelmodule(PSModelModule pSModelModule, PSModelModule pSModelModule2) throws Exception {
        pSModelModule.setPPSModelModuleId(pSModelModule2.getPSModelModuleId());
        pSModelModule.setPPSModelModuleName(pSModelModule2.getPSModelModuleName());
    }

    protected void onFillParentInfo_Psmodel(PSModelModule pSModelModule, PSModel pSModel) throws Exception {
        pSModelModule.setPSModelId(pSModel.getPSModelId());
        pSModelModule.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSModelModule pSModelModule, boolean bl) throws Exception {
        if (bl && pSModelModule.getValidFlag() == null) {
            pSModelModule.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSModelModule, bl);
        this.onFillEntityFullInfo_Ppsmodelmodule(pSModelModule, bl);
        this.onFillEntityFullInfo_Psmodel(pSModelModule, bl);
    }

    protected void onFillEntityFullInfo_Ppsmodelmodule(PSModelModule pSModelModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Psmodel(PSModelModule pSModelModule, boolean bl) throws Exception {
        if (pSModelModule.isPSModelIdDirty()) {
            if (pSModelModule.getPSModelId() != null) {
                if (pSModelModule.getPSModelId() == null || pSModelModule.getPSModelName() == null) {
                    PSModel pSModel = pSModelModule.getPsmodel();
                    pSModelModule.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSModelModule.setPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelModule pSModelModule, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSModelModule, bl);
    }

    public ArrayList<PSModelModule> selectByPpsmodelmodule(PSModelModuleBase pSModelModuleBase) throws Exception {
        return this.selectByPpsmodelmodule(pSModelModuleBase, "", -1);
    }

    public ArrayList<PSModelModule> selectByPpsmodelmodule(PSModelModuleBase pSModelModuleBase, String string) throws Exception {
        return this.selectByPpsmodelmodule(pSModelModuleBase, string, -1);
    }

    public ArrayList<PSModelModule> selectByPpsmodelmodule(PSModelModuleBase pSModelModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSMODELMODULEID", (Object)pSModelModuleBase.getPSModelModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPpsmodelmoduleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPpsmodelmoduleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelModule> selectByPsmodel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPsmodel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelModule> selectByPsmodel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPsmodel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelModule> selectByPsmodel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsmodelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsmodelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPpsmodelmodule(PSModelModule pSModelModule) throws Exception {
        ArrayList<PSModelModule> arrayList = this.selectByPpsmodelmodule(pSModelModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModelModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELMODULE_PSMODELMODULE_PPSMODELMODULEID", "", iDataEntityModel.getName(), "PSMODELMODULE", iDataEntityModel.getDataInfo((IEntity)pSModelModule), arrayList.get(0)));
        }
    }

    public void resetPpsmodelmodule(PSModelModule pSModelModule) throws Exception {
        ArrayList<PSModelModule> arrayList = this.selectByPpsmodelmodule(pSModelModule);
        for (PSModelModule pSModelModule2 : arrayList) {
            PSModelModule pSModelModule3 = (PSModelModule)this.getDEModel().createEntity();
            pSModelModule3.setPSModelModuleId(pSModelModule2.getPSModelModuleId());
            pSModelModule3.setPPSModelModuleId(null);
            this.update(pSModelModule3);
        }
    }

    public void removeByPpsmodelmodule(PSModelModule pSModelModule) throws Exception {
        final PSModelModule pSModelModule2 = pSModelModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelModuleServiceBase.this.onBeforeRemoveByPpsmodelmodule(pSModelModule2);
                PSModelModuleServiceBase.this.internalRemoveByPpsmodelmodule(pSModelModule2);
                PSModelModuleServiceBase.this.onAfterRemoveByPpsmodelmodule(pSModelModule2);
            }
        });
    }

    protected void onBeforeRemoveByPpsmodelmodule(PSModelModule pSModelModule) throws Exception {
    }

    protected void internalRemoveByPpsmodelmodule(PSModelModule pSModelModule) throws Exception {
        ArrayList<PSModelModule> arrayList = this.selectByPpsmodelmodule(pSModelModule);
        this.onBeforeRemoveByPpsmodelmodule(pSModelModule, arrayList);
        for (PSModelModule pSModelModule2 : arrayList) {
            this.remove((IEntity)pSModelModule2);
        }
        this.onAfterRemoveByPpsmodelmodule(pSModelModule, arrayList);
    }

    protected void onAfterRemoveByPpsmodelmodule(PSModelModule pSModelModule) throws Exception {
    }

    protected void onBeforeRemoveByPpsmodelmodule(PSModelModule pSModelModule, ArrayList<PSModelModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPpsmodelmodule(PSModelModule pSModelModule, ArrayList<PSModelModule> arrayList) throws Exception {
    }

    public void testRemoveByPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelModule> arrayList = this.selectByPsmodel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELMODULE_PSMODEL_PSMODELID", "", iDataEntityModel.getName(), "PSMODELMODULE", iDataEntityModel.getDataInfo((IEntity)pSModel), arrayList.get(0)));
        }
    }

    public void resetPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelModule> arrayList = this.selectByPsmodel(pSModel);
        for (PSModelModule pSModelModule : arrayList) {
            PSModelModule pSModelModule2 = (PSModelModule)this.getDEModel().createEntity();
            pSModelModule2.setPSModelModuleId(pSModelModule.getPSModelModuleId());
            pSModelModule2.setPSModelId(null);
            this.update(pSModelModule2);
        }
    }

    public void removeByPsmodel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelModuleServiceBase.this.onBeforeRemoveByPsmodel(pSModel2);
                PSModelModuleServiceBase.this.internalRemoveByPsmodel(pSModel2);
                PSModelModuleServiceBase.this.onAfterRemoveByPsmodel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPsmodel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelModule> arrayList = this.selectByPsmodel(pSModel);
        this.onBeforeRemoveByPsmodel(pSModel, arrayList);
        for (PSModelModule pSModelModule : arrayList) {
            this.remove((IEntity)pSModelModule);
        }
        this.onAfterRemoveByPsmodel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPsmodel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPsmodel(PSModel pSModel, ArrayList<PSModelModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsmodel(PSModel pSModel, ArrayList<PSModelModule> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelModule pSModelModule) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModelModuleService)ServiceGlobal.getService(PSModelModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelModuleServiceBase)pSCoreSysServiceBase).testRemoveByPpsmodelmodule(pSModelModule);
        pSCoreSysServiceBase = (PSModelSectionService)ServiceGlobal.getService(PSModelSectionService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelSectionServiceBase)pSCoreSysServiceBase).testRemoveByPsmodelmodule(pSModelModule);
        super.onBeforeRemove(pSModelModule);
    }

    protected void replaceParentInfo(PSModelModule pSModelModule, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSModelModule, cloneSession);
        if (pSModelModule.getPPSModelModuleId() != null && (iEntity = cloneSession.getEntity("PSMODELMODULE", (Object)pSModelModule.getPPSModelModuleId())) != null) {
            this.onFillParentInfo_Ppsmodelmodule(pSModelModule, (PSModelModule)iEntity);
        }
        if (pSModelModule.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelModule.getPSModelId())) != null) {
            this.onFillParentInfo_Psmodel(pSModelModule, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelModule pSModelModule, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSModelModule, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSModelModule, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleType(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSModelModuleId(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelModuleId(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelModuleName(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSModelModule, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isMemoDirty() : !pSModelModule.isMemoDirty()) {
            return null;
        }
        String string = pSModelModule.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSModelModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModuleType(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isModuleTypeDirty() && !bl2 : !pSModelModule.isModuleTypeDirty()) {
            return null;
        }
        String string = pSModelModule.getModuleType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleType_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isOrderValueDirty() : !pSModelModule.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelModule.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSModelModuleId(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isPPSModelModuleIdDirty() : !pSModelModule.isPPSModelModuleIdDirty()) {
            return null;
        }
        String string = pSModelModule.getPPSModelModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSModelModuleId_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMODELMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isPSModelIdDirty() : !pSModelModule.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelModule.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelModuleId(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isPSModelModuleIdDirty() && !bl2 : !pSModelModule.isPSModelModuleIdDirty()) {
            return null;
        }
        String string = pSModelModule.getPSModelModuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMODULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelModuleId_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelModuleName(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isPSModelModuleNameDirty() && !bl2 : !pSModelModule.isPSModelModuleNameDirty()) {
            return null;
        }
        String string = pSModelModule.getPSModelModuleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMODULENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelModuleName_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMODULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isPSModelNameDirty() : !pSModelModule.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModelModule.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelModule pSModelModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelModule.isValidFlagDirty() && !bl2 : !pSModelModule.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelModule.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSModelModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelModule pSModelModule, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSModelModule, bl);
    }

    protected void onSyncIndexEntities(PSModelModule pSModelModule, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSModelModule, bl);
    }

    public Object getDataContextValue(PSModelModule pSModelModule, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSModelModule, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelModule pSModelModule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSModelModule, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MODULETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ModuleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSModelModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSMODELMODULEID", "PSMODELMODULE", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSModelModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSModelModule pSModelModule) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSModelModule)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelModule pSModelModule) throws Exception {
        super.onUpdateParent((IEntity)pSModelModule);
    }

    @Override
    protected void exportCurXmlModel(PSModelModule pSModelModule, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELMODULE");
        if (!bl) {
            pSModelModule.setCreateDate(null);
            pSModelModule.setCreateMan(null);
            pSModelModule.setPSModelModuleId(null);
            pSModelModule.setUpdateDate(null);
            pSModelModule.setUpdateMan(null);
            super.exportCurXmlModel(pSModelModule, xmlNode, bl);
        }
    }
}

