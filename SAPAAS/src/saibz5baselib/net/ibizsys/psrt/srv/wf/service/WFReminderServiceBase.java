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

import java.sql.Timestamp;
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
import net.ibizsys.psrt.srv.wf.dao.WFReminderDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFReminder;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFStepActorBase;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserBase;
import net.ibizsys.psrt.srv.wf.service.WFReminderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WFReminderServiceBase
extends PSRuntimeSysServiceBase<WFReminder> {
    private static final Log log = LogFactory.getLog(WFReminderServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private WFReminderDEModel wFReminderDEModel;
    private WFReminderDAO wFReminderDAO;

    public static WFReminderService getInstance() throws Exception {
        return WFReminderServiceBase.getInstance(null);
    }

    public static WFReminderService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFReminderService)ServiceGlobal.getService(WFReminderService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFReminderService";
    }

    public WFReminderDEModel getWFReminderDEModel() {
        if (this.wFReminderDEModel == null) {
            try {
                this.wFReminderDEModel = (WFReminderDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFReminderDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFReminderDEModel();
    }

    public WFReminderDAO getWFReminderDAO() {
        if (this.wFReminderDAO == null) {
            try {
                this.wFReminderDAO = (WFReminderDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFReminderDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFReminderDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWFReminderDAO();
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
    protected void onFillParentInfo(WFReminder et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepActorService", this.getSessionFactory());
            WFStepActor parentEntity = (WFStepActor)iService.getDEModel().createEntity();
            parentEntity.set("WFSTEPACTORID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFStepActor(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFREMINDER_WFUSER_WFUSERID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory());
            WFUser parentEntity = (WFUser)iService.getDEModel().createEntity();
            parentEntity.set("WFUSERID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFUser(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_WFStepActor(WFReminder et, WFStepActor parentEntity) throws Exception {
        et.setActorId(parentEntity.getActorId());
        et.setReminderCount(parentEntity.getReminderCount());
        et.setWFCreateDate(parentEntity.getCreateDate());
        et.setWFStepActorId(parentEntity.getWFStepActorId());
        et.setWFStepActorName(parentEntity.getWFStepActorName());
    }

    protected void onFillParentInfo_WFUser(WFReminder et, WFUser parentEntity) throws Exception {
        et.setWFUserId(parentEntity.getWFUserId());
        et.setWFUserName(parentEntity.getWFUserName());
    }

    @Override
    protected void onFillEntityFullInfo(WFReminder et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_WFStepActor(et, bCreate);
        this.onFillEntityFullInfo_WFUser(et, bCreate);
    }

    protected void onFillEntityFullInfo_WFStepActor(WFReminder et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_WFUser(WFReminder et, boolean bCreate) throws Exception {
        if (et.isWFUserIdDirty()) {
            if (et.getWFUserId() != null) {
                if (et.getWFUserId() == null || et.getWFUserName() == null) {
                    WFUser parentEntity = et.getWFUser();
                    et.setWFUserName(parentEntity.getWFUserName());
                }
            } else {
                et.setWFUserName(null);
            }
        }
    }

    @Override
    protected void onWriteBackParent(WFReminder et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WFReminder> selectByWFStepActor(WFStepActorBase parentEntity) throws Exception {
        return this.selectByWFStepActor(parentEntity, "");
    }

    public ArrayList<WFReminder> selectByWFStepActor(WFStepActorBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFSTEPACTORID", parentEntity.getWFStepActorId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFStepActorCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFStepActorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFReminder> selectByWFUser(WFUserBase parentEntity) throws Exception {
        return this.selectByWFUser(parentEntity, "");
    }

    public ArrayList<WFReminder> selectByWFUser(WFUserBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFUSERID", parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFUserCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByWFStepActor(WFStepActor parentEntity) throws Exception {
    }

    public void resetWFStepActor(WFStepActor parentEntity) throws Exception {
        ArrayList<WFReminder> list = this.selectByWFStepActor(parentEntity);
        for (WFReminder item : list) {
            WFReminder item2 = (WFReminder)this.getDEModel().createEntity();
            item2.setWFReminderId(item.getWFReminderId());
            item2.setWFStepActorId(null);
            this.update(item2);
        }
    }

    public void removeByWFStepActor(WFStepActor parentEntity) throws Exception {
        final WFStepActor parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFReminderServiceBase.this.onBeforeRemoveByWFStepActor(parentEntity2);
                WFReminderServiceBase.this.internalRemoveByWFStepActor(parentEntity2);
                WFReminderServiceBase.this.onAfterRemoveByWFStepActor(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFStepActor(WFStepActor parentEntity) throws Exception {
    }

    protected void internalRemoveByWFStepActor(WFStepActor parentEntity) throws Exception {
        ArrayList<WFReminder> removeList = this.selectByWFStepActor(parentEntity);
        this.onBeforeRemoveByWFStepActor(parentEntity, removeList);
        for (WFReminder item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFStepActor(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFStepActor(WFStepActor parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFStepActor(WFStepActor parentEntity, ArrayList<WFReminder> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFStepActor(WFStepActor parentEntity, ArrayList<WFReminder> removeList) throws Exception {
    }

    public void testRemoveByWFUser(WFUser parentEntity) throws Exception {
    }

    public void resetWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFReminder> list = this.selectByWFUser(parentEntity);
        for (WFReminder item : list) {
            WFReminder item2 = (WFReminder)this.getDEModel().createEntity();
            item2.setWFReminderId(item.getWFReminderId());
            item2.setWFUserId(null);
            this.update(item2);
        }
    }

    public void removeByWFUser(WFUser parentEntity) throws Exception {
        final WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFReminderServiceBase.this.onBeforeRemoveByWFUser(parentEntity2);
                WFReminderServiceBase.this.internalRemoveByWFUser(parentEntity2);
                WFReminderServiceBase.this.onAfterRemoveByWFUser(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFUser(WFUser parentEntity) throws Exception {
    }

    protected void internalRemoveByWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFReminder> removeList = this.selectByWFUser(parentEntity);
        this.onBeforeRemoveByWFUser(parentEntity, removeList);
        for (WFReminder item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFUser(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFUser(WFUser parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFUser(WFUser parentEntity, ArrayList<WFReminder> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFUser(WFUser parentEntity, ArrayList<WFReminder> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WFReminder et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WFReminder et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getWFStepActorId() != null && (entity = cloneSession.getEntity("WFSTEPACTOR", et.getWFStepActorId())) != null) {
            this.onFillParentInfo_WFStepActor(et, (WFStepActor)entity);
        }
        if (et.getWFUserId() != null && (entity = cloneSession.getEntity("WFUSER", et.getWFUserId())) != null) {
            this.onFillParentInfo_WFUser(et, (WFUser)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WFReminder et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReminderTime(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFReminderId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFReminderName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepActorId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_ReminderTime(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReminderTimeDirty()) {
            return null;
        }
        Timestamp value = et.getReminderTime();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ReminderTime_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMINDERTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFReminderId(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFReminderIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFREMINDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFReminderId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFREMINDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFReminderId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFREMINDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFReminderName(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFReminderNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFREMINDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFReminderName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFREMINDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFReminderName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFREMINDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepActorId(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepActorIdDirty()) {
            return null;
        }
        String value = et.getWFStepActorId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepActorId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserId(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUserIdDirty()) {
            return null;
        }
        String value = et.getWFUserId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUserId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserName(boolean bBaseMode, WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUserNameDirty()) {
            return null;
        }
        String value = et.getWFUserName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUserName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(WFReminder et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WFReminder et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WFReminder et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "ACTORID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActorId_Default(et, bCreate, bTempMode);
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
        if (StringHelper.compare(strDEFieldName, "REMINDERCOUNT", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ReminderCount_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "REMINDERTIME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ReminderTime_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFCREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFCreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFREMINDERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFReminderId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFREMINDERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFReminderName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPACTORID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepActorId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPACTORNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepActorName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_ActorId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTORID", et, bTempMode, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
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
            if (this.checkFieldStringLengthRule("MEMO", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ReminderCount_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_ReminderTime_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
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

    protected String onTestValueRule_WFCreateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFReminderId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFREMINDERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFReminderName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFREMINDERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepActorId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPACTORID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepActorName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPACTORNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUserId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUserName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFReminder et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WFReminder et) throws Exception {
        super.onUpdateParent(et);
    }
}

