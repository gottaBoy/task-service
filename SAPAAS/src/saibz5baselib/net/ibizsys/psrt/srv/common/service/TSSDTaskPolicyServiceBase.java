/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.common.service;

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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO;
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDPolicy;
import net.ibizsys.psrt.srv.common.entity.TSSDPolicyBase;
import net.ibizsys.psrt.srv.common.entity.TSSDTask;
import net.ibizsys.psrt.srv.common.entity.TSSDTaskBase;
import net.ibizsys.psrt.srv.common.entity.TSSDTaskPolicy;
import net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class TSSDTaskPolicyServiceBase
extends PSRuntimeSysServiceBase<TSSDTaskPolicy> {
    private static final Log log = LogFactory.getLog(TSSDTaskPolicyServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private TSSDTaskPolicyDEModel tSSDTaskPolicyDEModel;
    private TSSDTaskPolicyDAO tSSDTaskPolicyDAO;

    public static TSSDTaskPolicyService getInstance() throws Exception {
        return TSSDTaskPolicyServiceBase.getInstance(null);
    }

    public static TSSDTaskPolicyService getInstance(SessionFactory sessionFactory) throws Exception {
        return (TSSDTaskPolicyService)ServiceGlobal.getService(TSSDTaskPolicyService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService";
    }

    public TSSDTaskPolicyDEModel getTSSDTaskPolicyDEModel() {
        if (this.tSSDTaskPolicyDEModel == null) {
            try {
                this.tSSDTaskPolicyDEModel = (TSSDTaskPolicyDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDTaskPolicyDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDTaskPolicyDEModel();
    }

    public TSSDTaskPolicyDAO getTSSDTaskPolicyDAO() {
        if (this.tSSDTaskPolicyDAO == null) {
            try {
                this.tSSDTaskPolicyDAO = (TSSDTaskPolicyDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDTaskPolicyDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getTSSDTaskPolicyDAO();
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
    protected void onFillParentInfo(TSSDTaskPolicy et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDPolicyService", this.getSessionFactory());
            TSSDPolicy parentEntity = (TSSDPolicy)iService.getDEModel().createEntity();
            parentEntity.set("TSSDPOLICYID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_TSSDPolicy(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskService", this.getSessionFactory());
            TSSDTask parentEntity = (TSSDTask)iService.getDEModel().createEntity();
            parentEntity.set("TSSDTASKID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_TSSDTask(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_TSSDPolicy(TSSDTaskPolicy et, TSSDPolicy parentEntity) throws Exception {
        et.setTSSDPolicyId(parentEntity.getTSSDPolicyId());
        et.setTSSDPolicyName(parentEntity.getTSSDPolicyName());
    }

    protected void onFillParentInfo_TSSDTask(TSSDTaskPolicy et, TSSDTask parentEntity) throws Exception {
        et.setTSSDTaskId(parentEntity.getTSSDTaskId());
        et.setTSSDTaskName(parentEntity.getTSSDTaskName());
    }

    @Override
    protected void onFillEntityFullInfo(TSSDTaskPolicy et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_TSSDPolicy(et, bCreate);
        this.onFillEntityFullInfo_TSSDTask(et, bCreate);
    }

    protected void onFillEntityFullInfo_TSSDPolicy(TSSDTaskPolicy et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_TSSDTask(TSSDTaskPolicy et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(TSSDTaskPolicy et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<TSSDTaskPolicy> selectByTSSDPolicy(TSSDPolicyBase parentEntity) throws Exception {
        return this.selectByTSSDPolicy(parentEntity, "");
    }

    public ArrayList<TSSDTaskPolicy> selectByTSSDPolicy(TSSDPolicyBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TSSDPOLICYID", parentEntity.getTSSDPolicyId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByTSSDPolicyCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByTSSDPolicyCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<TSSDTaskPolicy> selectByTSSDTask(TSSDTaskBase parentEntity) throws Exception {
        return this.selectByTSSDTask(parentEntity, "");
    }

    public ArrayList<TSSDTaskPolicy> selectByTSSDTask(TSSDTaskBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TSSDTASKID", parentEntity.getTSSDTaskId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByTSSDTaskCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByTSSDTaskCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByTSSDPolicy(TSSDPolicy parentEntity) throws Exception {
    }

    public void resetTSSDPolicy(TSSDPolicy parentEntity) throws Exception {
        ArrayList<TSSDTaskPolicy> list = this.selectByTSSDPolicy(parentEntity);
        for (TSSDTaskPolicy item : list) {
            TSSDTaskPolicy item2 = (TSSDTaskPolicy)this.getDEModel().createEntity();
            item2.setTSSDTaskPolicyId(item.getTSSDTaskPolicyId());
            item2.setTSSDPolicyId(null);
            this.update(item2);
        }
    }

    public void removeByTSSDPolicy(TSSDPolicy parentEntity) throws Exception {
        final TSSDPolicy parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                TSSDTaskPolicyServiceBase.this.onBeforeRemoveByTSSDPolicy(parentEntity2);
                TSSDTaskPolicyServiceBase.this.internalRemoveByTSSDPolicy(parentEntity2);
                TSSDTaskPolicyServiceBase.this.onAfterRemoveByTSSDPolicy(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByTSSDPolicy(TSSDPolicy parentEntity) throws Exception {
    }

    protected void internalRemoveByTSSDPolicy(TSSDPolicy parentEntity) throws Exception {
        ArrayList<TSSDTaskPolicy> removeList = this.selectByTSSDPolicy(parentEntity);
        this.onBeforeRemoveByTSSDPolicy(parentEntity, removeList);
        for (TSSDTaskPolicy item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByTSSDPolicy(parentEntity, removeList);
    }

    protected void onAfterRemoveByTSSDPolicy(TSSDPolicy parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByTSSDPolicy(TSSDPolicy parentEntity, ArrayList<TSSDTaskPolicy> removeList) throws Exception {
    }

    protected void onAfterRemoveByTSSDPolicy(TSSDPolicy parentEntity, ArrayList<TSSDTaskPolicy> removeList) throws Exception {
    }

    public void testRemoveByTSSDTask(TSSDTask parentEntity) throws Exception {
    }

    public void resetTSSDTask(TSSDTask parentEntity) throws Exception {
        ArrayList<TSSDTaskPolicy> list = this.selectByTSSDTask(parentEntity);
        for (TSSDTaskPolicy item : list) {
            TSSDTaskPolicy item2 = (TSSDTaskPolicy)this.getDEModel().createEntity();
            item2.setTSSDTaskPolicyId(item.getTSSDTaskPolicyId());
            item2.setTSSDTaskId(null);
            this.update(item2);
        }
    }

    public void removeByTSSDTask(TSSDTask parentEntity) throws Exception {
        final TSSDTask parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                TSSDTaskPolicyServiceBase.this.onBeforeRemoveByTSSDTask(parentEntity2);
                TSSDTaskPolicyServiceBase.this.internalRemoveByTSSDTask(parentEntity2);
                TSSDTaskPolicyServiceBase.this.onAfterRemoveByTSSDTask(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByTSSDTask(TSSDTask parentEntity) throws Exception {
    }

    protected void internalRemoveByTSSDTask(TSSDTask parentEntity) throws Exception {
        ArrayList<TSSDTaskPolicy> removeList = this.selectByTSSDTask(parentEntity);
        this.onBeforeRemoveByTSSDTask(parentEntity, removeList);
        for (TSSDTaskPolicy item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByTSSDTask(parentEntity, removeList);
    }

    protected void onAfterRemoveByTSSDTask(TSSDTask parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByTSSDTask(TSSDTask parentEntity, ArrayList<TSSDTaskPolicy> removeList) throws Exception {
    }

    protected void onAfterRemoveByTSSDTask(TSSDTask parentEntity, ArrayList<TSSDTaskPolicy> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(TSSDTaskPolicy et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(TSSDTaskPolicy et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getTSSDPolicyId() != null && (entity = cloneSession.getEntity("TSSDPOLICY", et.getTSSDPolicyId())) != null) {
            this.onFillParentInfo_TSSDPolicy(et, (TSSDPolicy)entity);
        }
        if (et.getTSSDTaskId() != null && (entity = cloneSession.getEntity("TSSDTASK", et.getTSSDTaskId())) != null) {
            this.onFillParentInfo_TSSDTask(et, (TSSDTask)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(TSSDTaskPolicy et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Reserver(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver3(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver4(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSSDPolicyId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSSDTaskId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSSDTaskPolicyId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSSDTaskPolicyName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserverDirty()) {
            return null;
        }
        String value = et.getReserver();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver2Dirty()) {
            return null;
        }
        String value = et.getReserver2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver3Dirty()) {
            return null;
        }
        String value = et.getReserver3();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver3_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver4Dirty()) {
            return null;
        }
        String value = et.getReserver4();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver4_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSSDPolicyId(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDPolicyIdDirty()) {
            return null;
        }
        String value = et.getTSSDPolicyId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDPolicyId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDPOLICYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSSDTaskId(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDTaskIdDirty()) {
            return null;
        }
        String value = et.getTSSDTaskId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDTaskId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSSDTaskPolicyId(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDTaskPolicyIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDTASKPOLICYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getTSSDTaskPolicyId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDTASKPOLICYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDTaskPolicyId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDTASKPOLICYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSSDTaskPolicyName(boolean bBaseMode, TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDTaskPolicyNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDTASKPOLICYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getTSSDTaskPolicyName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDTASKPOLICYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDTaskPolicyName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDTASKPOLICYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(TSSDTaskPolicy et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(TSSDTaskPolicy et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(TSSDTaskPolicy et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        TSSDTask tSSDTask = et.getTSSDTask();
        if (tSSDTask != null && tSSDTask.contains(strField)) {
            return tSSDTask.get(strField);
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver2_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER3", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver3_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER4", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver4_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDPOLICYID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDPolicyId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDPOLICYNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDPolicyName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDTASKID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDTaskId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDTASKNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDTaskName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDTASKPOLICYID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDTaskPolicyId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDTASKPOLICYNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDTaskPolicyName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
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

    protected String onTestValueRule_Reserver_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER2", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver3_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER3", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver4_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER4", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDPolicyId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDPOLICYID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDPolicyName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDPOLICYNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDTaskId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDTASKID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDTaskName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDTASKNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDTaskPolicyId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDTASKPOLICYID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDTaskPolicyName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDTASKPOLICYNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, TSSDTaskPolicy et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(TSSDTaskPolicy et) throws Exception {
        super.onUpdateParent(et);
    }
}

