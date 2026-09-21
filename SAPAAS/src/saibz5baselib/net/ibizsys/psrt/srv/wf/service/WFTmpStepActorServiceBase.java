/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.wf.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
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
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.wf.dao.WFTmpStepActorDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFTmpStepActorDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFActor;
import net.ibizsys.psrt.srv.wf.entity.WFActorBase;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepBase;
import net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor;
import net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WFTmpStepActorServiceBase
extends PSRuntimeSysServiceBase<WFTmpStepActor> {
    private static final Log log = LogFactory.getLog(WFTmpStepActorServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private WFTmpStepActorDEModel wFTmpStepActorDEModel;
    private WFTmpStepActorDAO wFTmpStepActorDAO;

    public static WFTmpStepActorService getInstance() throws Exception {
        return WFTmpStepActorServiceBase.getInstance(null);
    }

    public static WFTmpStepActorService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFTmpStepActorService)ServiceGlobal.getService(WFTmpStepActorService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService";
    }

    public WFTmpStepActorDEModel getWFTmpStepActorDEModel() {
        if (this.wFTmpStepActorDEModel == null) {
            try {
                this.wFTmpStepActorDEModel = (WFTmpStepActorDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFTmpStepActorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFTmpStepActorDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFTmpStepActorDEModel();
    }

    public WFTmpStepActorDAO getWFTmpStepActorDAO() {
        if (this.wFTmpStepActorDAO == null) {
            try {
                this.wFTmpStepActorDAO = (WFTmpStepActorDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFTmpStepActorDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFTmpStepActorDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWFTmpStepActorDAO();
    }

    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare(strDataSetName, DATASET_DEFAULT, true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(strDataSetName, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
        super.onExecuteAction(strAction, entity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dbFetchResult;
    }

    @Override
    protected void onFillParentInfo(WFTmpStepActor et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFActorService", this.getSessionFactory());
            WFActor parentEntity = (WFActor)iService.getDEModel().createEntity();
            parentEntity.set("WFACTORID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFActor(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepService", this.getSessionFactory());
            WFStep parentEntity = (WFStep)iService.getDEModel().createEntity();
            parentEntity.set("WFSTEPID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFStep(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_WFActor(WFTmpStepActor et, WFActor parentEntity) throws Exception {
        et.setWFActorId(parentEntity.getWFActorId());
        et.setWFActorName(parentEntity.getWFActorName());
    }

    protected void onFillParentInfo_WFStep(WFTmpStepActor et, WFStep parentEntity) throws Exception {
        et.setPrevWFStepId(parentEntity.getWFStepId());
        et.setPrevWFStepName(parentEntity.getWFPLogicName());
    }

    @Override
    protected void onFillEntityFullInfo(WFTmpStepActor et, boolean bCreate) throws Exception {
        if (bCreate && et.getWFTmpStepActorName() == null) {
            et.setWFTmpStepActorName((String)DefaultValueHelper.getValue(this.getWebContext(), "", "\u5de5\u4f5c\u6d41\u6b65\u9aa4\u64cd\u4f5c\u8005\uff08\u4e34\u65f6\uff09", 25));
        }
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_WFActor(et, bCreate);
        this.onFillEntityFullInfo_WFStep(et, bCreate);
    }

    protected void onFillEntityFullInfo_WFActor(WFTmpStepActor et, boolean bCreate) throws Exception {
        if (et.isWFActorIdDirty()) {
            if (et.getWFActorId() != null) {
                if (et.getWFActorId() == null || et.getWFActorName() == null) {
                    WFActor parentEntity = et.getWFActor();
                    et.setWFActorName(parentEntity.getWFActorName());
                }
            } else {
                et.setWFActorName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFStep(WFTmpStepActor et, boolean bCreate) throws Exception {
        if (et.isPrevWFStepIdDirty()) {
            if (et.getPrevWFStepId() != null) {
                if (et.getPrevWFStepId() == null || et.getPrevWFStepName() == null) {
                    WFStep parentEntity = et.getWFStep();
                    et.setPrevWFStepName(parentEntity.getWFPLogicName());
                }
            } else {
                et.setPrevWFStepName(null);
            }
        }
    }

    @Override
    protected void onWriteBackParent(WFTmpStepActor et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WFTmpStepActor> selectByWFActor(WFActorBase parentEntity) throws Exception {
        return this.selectByWFActor(parentEntity, "");
    }

    public ArrayList<WFTmpStepActor> selectByWFActor(WFActorBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFACTORID", parentEntity.getWFActorId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFActorCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFActorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFTmpStepActor> selectByWFStep(WFStepBase parentEntity) throws Exception {
        return this.selectByWFStep(parentEntity, "");
    }

    public ArrayList<WFTmpStepActor> selectByWFStep(WFStepBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PREVWFSTEPID", parentEntity.getWFStepId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFStepCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFStepCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByWFActor(WFActor parentEntity) throws Exception {
        ArrayList<WFTmpStepActor> list = this.selectByWFActor(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFACTOR");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID", "", parentDEModel.getName(), "WFTMPSTEPACTOR", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWFActor(WFActor parentEntity) throws Exception {
        ArrayList<WFTmpStepActor> list = this.selectByWFActor(parentEntity);
        for (WFTmpStepActor item : list) {
            WFTmpStepActor item2 = (WFTmpStepActor)this.getDEModel().createEntity();
            item2.setWFTmpStepActorId(item.getWFTmpStepActorId());
            item2.setWFActorId(null);
            this.update(item2);
        }
    }

    public void removeByWFActor(WFActor parentEntity) throws Exception {
        final WFActor parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFTmpStepActorServiceBase.this.onBeforeRemoveByWFActor(parentEntity2);
                WFTmpStepActorServiceBase.this.internalRemoveByWFActor(parentEntity2);
                WFTmpStepActorServiceBase.this.onAfterRemoveByWFActor(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFActor(WFActor parentEntity) throws Exception {
    }

    protected void internalRemoveByWFActor(WFActor parentEntity) throws Exception {
        ArrayList<WFTmpStepActor> removeList = this.selectByWFActor(parentEntity);
        this.onBeforeRemoveByWFActor(parentEntity, removeList);
        for (WFTmpStepActor item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFActor(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFActor(WFActor parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFActor(WFActor parentEntity, ArrayList<WFTmpStepActor> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFActor(WFActor parentEntity, ArrayList<WFTmpStepActor> removeList) throws Exception {
    }

    public void testRemoveByWFStep(WFStep parentEntity) throws Exception {
        ArrayList<WFTmpStepActor> list = this.selectByWFStep(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFSTEP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID", "", parentDEModel.getName(), "WFTMPSTEPACTOR", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWFStep(WFStep parentEntity) throws Exception {
        ArrayList<WFTmpStepActor> list = this.selectByWFStep(parentEntity);
        for (WFTmpStepActor item : list) {
            WFTmpStepActor item2 = (WFTmpStepActor)this.getDEModel().createEntity();
            item2.setWFTmpStepActorId(item.getWFTmpStepActorId());
            item2.setPrevWFStepId(null);
            this.update(item2);
        }
    }

    public void removeByWFStep(WFStep parentEntity) throws Exception {
        final WFStep parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFTmpStepActorServiceBase.this.onBeforeRemoveByWFStep(parentEntity2);
                WFTmpStepActorServiceBase.this.internalRemoveByWFStep(parentEntity2);
                WFTmpStepActorServiceBase.this.onAfterRemoveByWFStep(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFStep(WFStep parentEntity) throws Exception {
    }

    protected void internalRemoveByWFStep(WFStep parentEntity) throws Exception {
        ArrayList<WFTmpStepActor> removeList = this.selectByWFStep(parentEntity);
        this.onBeforeRemoveByWFStep(parentEntity, removeList);
        for (WFTmpStepActor item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFStep(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFStep(WFStep parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFStep(WFStep parentEntity, ArrayList<WFTmpStepActor> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFStep(WFStep parentEntity, ArrayList<WFTmpStepActor> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WFTmpStepActor et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WFTmpStepActor et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getWFActorId() != null && (entity = cloneSession.getEntity("WFACTOR", et.getWFActorId())) != null) {
            this.onFillParentInfo_WFActor(et, (WFActor)entity);
        }
        if (et.getPrevWFStepId() != null && (entity = cloneSession.getEntity("WFSTEP", et.getPrevWFStepId())) != null) {
            this.onFillParentInfo_WFStep(et, (WFStep)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WFTmpStepActor et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Connection(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevProcess(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevWFStepId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrevWFStepName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFActorId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFActorName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFTmpStepActorId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFTmpStepActorName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Connection(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isConnectionDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNECTION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getConnection();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNECTION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Connection_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNECTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMemoDirty()) {
            return null;
        }
        String value = et.getMemo();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevProcess(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPrevProcessDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPROCESS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getPrevProcess();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPROCESS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PrevProcess_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVPROCESS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevWFStepId(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPrevWFStepIdDirty()) {
            return null;
        }
        String value = et.getPrevWFStepId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PrevWFStepId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVWFSTEPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrevWFStepName(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPrevWFStepNameDirty()) {
            return null;
        }
        String value = et.getPrevWFStepName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PrevWFStepName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVWFSTEPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFActorId(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFActorIdDirty()) {
            return null;
        }
        String value = et.getWFActorId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFActorId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFActorName(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFActorNameDirty()) {
            return null;
        }
        String value = et.getWFActorName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFActorName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFACTORNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFTmpStepActorId(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFTmpStepActorIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTMPSTEPACTORID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFTmpStepActorId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTMPSTEPACTORID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFTmpStepActorId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTMPSTEPACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFTmpStepActorName(boolean bBaseMode, WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFTmpStepActorNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTMPSTEPACTORNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFTmpStepActorName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTMPSTEPACTORNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFTmpStepActorName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTMPSTEPACTORNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(WFTmpStepActor et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WFTmpStepActor et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WFTmpStepActor et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "CONNECTION", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Connection_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PREVPROCESS", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PrevProcess_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PREVWFSTEPID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PrevWFStepId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PREVWFSTEPNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PrevWFStepName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFACTORID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFActorId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFACTORNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFActorName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFTMPSTEPACTORID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFTmpStepActorId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFTMPSTEPACTORNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFTmpStepActorName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_Connection_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNECTION", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PrevProcess_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVPROCESS", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PrevWFStepId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVWFSTEPID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PrevWFStepName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVWFSTEPNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFActorId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFACTORID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFActorName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFACTORNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFTmpStepActorId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFTMPSTEPACTORID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFTmpStepActorName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFTMPSTEPACTORNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFTmpStepActor et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WFTmpStepActor et) throws Exception {
        super.onUpdateParent(et);
    }
}

