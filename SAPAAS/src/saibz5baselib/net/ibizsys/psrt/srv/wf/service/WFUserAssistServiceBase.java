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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserAssist;
import net.ibizsys.psrt.srv.wf.entity.WFUserBase;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflowBase;
import net.ibizsys.psrt.srv.wf.service.WFUserAssistService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WFUserAssistServiceBase
extends PSRuntimeSysServiceBase<WFUserAssist> {
    private static final Log log = LogFactory.getLog(WFUserAssistServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private WFUserAssistDEModel wFUserAssistDEModel;
    private WFUserAssistDAO wFUserAssistDAO;

    public static WFUserAssistService getInstance() throws Exception {
        return WFUserAssistServiceBase.getInstance(null);
    }

    public static WFUserAssistService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFUserAssistService)ServiceGlobal.getService(WFUserAssistService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFUserAssistService";
    }

    public WFUserAssistDEModel getWFUserAssistDEModel() {
        if (this.wFUserAssistDEModel == null) {
            try {
                this.wFUserAssistDEModel = (WFUserAssistDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUserAssistDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUserAssistDEModel();
    }

    public WFUserAssistDAO getWFUserAssistDAO() {
        if (this.wFUserAssistDAO == null) {
            try {
                this.wFUserAssistDAO = (WFUserAssistDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUserAssistDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWFUserAssistDAO();
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
    protected void onFillParentInfo(WFUserAssist et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory());
            WFUser parentEntity = (WFUser)iService.getDEModel().createEntity();
            parentEntity.set("WFUSERID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFMajorUser(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory());
            WFUser parentEntity = (WFUser)iService.getDEModel().createEntity();
            parentEntity.set("WFUSERID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFMinorUser(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFWorkflowService", this.getSessionFactory());
            WFWorkflow parentEntity = (WFWorkflow)iService.getDEModel().createEntity();
            parentEntity.set("WFWORKFLOWID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFWorkflow(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_WFMajorUser(WFUserAssist et, WFUser parentEntity) throws Exception {
        et.setWFMajorUserId(parentEntity.getWFUserId());
        et.setWFMajorUserName(parentEntity.getWFUserName());
    }

    protected void onFillParentInfo_WFMinorUser(WFUserAssist et, WFUser parentEntity) throws Exception {
        et.setWFMinorUserId(parentEntity.getWFUserId());
        et.setWFMinorUserName(parentEntity.getWFUserName());
    }

    protected void onFillParentInfo_WFWorkflow(WFUserAssist et, WFWorkflow parentEntity) throws Exception {
        et.setWFWorkflowId(parentEntity.getWFWorkflowId());
        et.setWFWorkflowName(parentEntity.getWFWorkflowName());
    }

    @Override
    protected void onFillEntityFullInfo(WFUserAssist et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_WFMajorUser(et, bCreate);
        this.onFillEntityFullInfo_WFMinorUser(et, bCreate);
        this.onFillEntityFullInfo_WFWorkflow(et, bCreate);
    }

    protected void onFillEntityFullInfo_WFMajorUser(WFUserAssist et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_WFMinorUser(WFUserAssist et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_WFWorkflow(WFUserAssist et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(WFUserAssist et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WFUserAssist> selectByWFMajorUser(WFUserBase parentEntity) throws Exception {
        return this.selectByWFMajorUser(parentEntity, "");
    }

    public ArrayList<WFUserAssist> selectByWFMajorUser(WFUserBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFMAJORUSERID", parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFMajorUserCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFMajorUserCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFUserAssist> selectByWFMinorUser(WFUserBase parentEntity) throws Exception {
        return this.selectByWFMinorUser(parentEntity, "");
    }

    public ArrayList<WFUserAssist> selectByWFMinorUser(WFUserBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFMINORUSERID", parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFMinorUserCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFMinorUserCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFUserAssist> selectByWFWorkflow(WFWorkflowBase parentEntity) throws Exception {
        return this.selectByWFWorkflow(parentEntity, "");
    }

    public ArrayList<WFUserAssist> selectByWFWorkflow(WFWorkflowBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFWORKFLOWID", parentEntity.getWFWorkflowId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFWorkflowCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFWorkflowCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByWFMajorUser(WFUser parentEntity) throws Exception {
    }

    public void resetWFMajorUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUserAssist> list = this.selectByWFMajorUser(parentEntity);
        for (WFUserAssist item : list) {
            WFUserAssist item2 = (WFUserAssist)this.getDEModel().createEntity();
            item2.setWFUserAssistId(item.getWFUserAssistId());
            item2.setWFMajorUserId(null);
            this.update(item2);
        }
    }

    public void removeByWFMajorUser(WFUser parentEntity) throws Exception {
        final WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFUserAssistServiceBase.this.onBeforeRemoveByWFMajorUser(parentEntity2);
                WFUserAssistServiceBase.this.internalRemoveByWFMajorUser(parentEntity2);
                WFUserAssistServiceBase.this.onAfterRemoveByWFMajorUser(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFMajorUser(WFUser parentEntity) throws Exception {
    }

    protected void internalRemoveByWFMajorUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUserAssist> removeList = this.selectByWFMajorUser(parentEntity);
        this.onBeforeRemoveByWFMajorUser(parentEntity, removeList);
        for (WFUserAssist item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFMajorUser(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFMajorUser(WFUser parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFMajorUser(WFUser parentEntity, ArrayList<WFUserAssist> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFMajorUser(WFUser parentEntity, ArrayList<WFUserAssist> removeList) throws Exception {
    }

    public void testRemoveByWFMinorUser(WFUser parentEntity) throws Exception {
    }

    public void resetWFMinorUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUserAssist> list = this.selectByWFMinorUser(parentEntity);
        for (WFUserAssist item : list) {
            WFUserAssist item2 = (WFUserAssist)this.getDEModel().createEntity();
            item2.setWFUserAssistId(item.getWFUserAssistId());
            item2.setWFMinorUserId(null);
            this.update(item2);
        }
    }

    public void removeByWFMinorUser(WFUser parentEntity) throws Exception {
        final WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFUserAssistServiceBase.this.onBeforeRemoveByWFMinorUser(parentEntity2);
                WFUserAssistServiceBase.this.internalRemoveByWFMinorUser(parentEntity2);
                WFUserAssistServiceBase.this.onAfterRemoveByWFMinorUser(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFMinorUser(WFUser parentEntity) throws Exception {
    }

    protected void internalRemoveByWFMinorUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUserAssist> removeList = this.selectByWFMinorUser(parentEntity);
        this.onBeforeRemoveByWFMinorUser(parentEntity, removeList);
        for (WFUserAssist item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFMinorUser(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFMinorUser(WFUser parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFMinorUser(WFUser parentEntity, ArrayList<WFUserAssist> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFMinorUser(WFUser parentEntity, ArrayList<WFUserAssist> removeList) throws Exception {
    }

    public void testRemoveByWFWorkflow(WFWorkflow parentEntity) throws Exception {
    }

    public void resetWFWorkflow(WFWorkflow parentEntity) throws Exception {
        ArrayList<WFUserAssist> list = this.selectByWFWorkflow(parentEntity);
        for (WFUserAssist item : list) {
            WFUserAssist item2 = (WFUserAssist)this.getDEModel().createEntity();
            item2.setWFUserAssistId(item.getWFUserAssistId());
            item2.setWFWorkflowId(null);
            this.update(item2);
        }
    }

    public void removeByWFWorkflow(WFWorkflow parentEntity) throws Exception {
        final WFWorkflow parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFUserAssistServiceBase.this.onBeforeRemoveByWFWorkflow(parentEntity2);
                WFUserAssistServiceBase.this.internalRemoveByWFWorkflow(parentEntity2);
                WFUserAssistServiceBase.this.onAfterRemoveByWFWorkflow(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFWorkflow(WFWorkflow parentEntity) throws Exception {
    }

    protected void internalRemoveByWFWorkflow(WFWorkflow parentEntity) throws Exception {
        ArrayList<WFUserAssist> removeList = this.selectByWFWorkflow(parentEntity);
        this.onBeforeRemoveByWFWorkflow(parentEntity, removeList);
        for (WFUserAssist item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFWorkflow(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFWorkflow(WFWorkflow parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFWorkflow(WFWorkflow parentEntity, ArrayList<WFUserAssist> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFWorkflow(WFWorkflow parentEntity, ArrayList<WFUserAssist> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WFUserAssist et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WFUserAssist et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getWFMajorUserId() != null && (entity = cloneSession.getEntity("WFUSER", et.getWFMajorUserId())) != null) {
            this.onFillParentInfo_WFMajorUser(et, (WFUser)entity);
        }
        if (et.getWFMinorUserId() != null && (entity = cloneSession.getEntity("WFUSER", et.getWFMinorUserId())) != null) {
            this.onFillParentInfo_WFMinorUser(et, (WFUser)entity);
        }
        if (et.getWFWorkflowId() != null && (entity = cloneSession.getEntity("WFWORKFLOW", et.getWFWorkflowId())) != null) {
            this.onFillParentInfo_WFWorkflow(et, (WFWorkflow)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WFUserAssist et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFMajorUserId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFMinorUserId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStep(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserAssistId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserAssistName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFWorkflowId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_WFMajorUserId(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFMajorUserIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMAJORUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFMajorUserId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMAJORUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFMajorUserId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMAJORUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFMinorUserId(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFMinorUserIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMINORUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFMinorUserId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMINORUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFMinorUserId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMINORUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStep(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepDirty()) {
            return null;
        }
        String value = et.getWFStep();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStep_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserAssistId(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUserAssistIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERASSISTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFUserAssistId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERASSISTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUserAssistId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERASSISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserAssistName(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUserAssistNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERASSISTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFUserAssistName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERASSISTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUserAssistName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERASSISTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFWorkflowId(boolean bBaseMode, WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFWorkflowIdDirty()) {
            return null;
        }
        String value = et.getWFWorkflowId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFWorkflowId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFWORKFLOWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(WFUserAssist et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WFUserAssist et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WFUserAssist et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
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
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFMAJORUSERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFMajorUserId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFMAJORUSERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFMajorUserName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFMINORUSERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFMinorUserId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFMINORUSERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFMinorUserName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEP", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStep_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERASSISTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserAssistId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERASSISTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserAssistName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFWORKFLOWID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFWorkflowId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFWORKFLOWNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFWorkflowName_Default(et, bCreate, bTempMode);
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

    protected String onTestValueRule_Memo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", et, bTempMode, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_WFMajorUserId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFMAJORUSERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFMajorUserName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFMAJORUSERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFMinorUserId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFMINORUSERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFMinorUserName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFMINORUSERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStep_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEP", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUserAssistId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERASSISTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUserAssistName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERASSISTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFWorkflowId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFWORKFLOWID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFWorkflowName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFWORKFLOWNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFUserAssist et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WFUserAssist et) throws Exception {
        super.onUpdateParent(et);
    }
}

