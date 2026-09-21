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
import net.ibizsys.psrt.srv.wf.dao.WFIAActionDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFIAActionDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFIAAction;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepBase;
import net.ibizsys.psrt.srv.wf.service.WFIAActionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WFIAActionServiceBase
extends PSRuntimeSysServiceBase<WFIAAction> {
    private static final Log log = LogFactory.getLog(WFIAActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private WFIAActionDEModel wFIAActionDEModel;
    private WFIAActionDAO wFIAActionDAO;

    public static WFIAActionService getInstance() throws Exception {
        return WFIAActionServiceBase.getInstance(null);
    }

    public static WFIAActionService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFIAActionService)ServiceGlobal.getService(WFIAActionService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFIAActionService";
    }

    public WFIAActionDEModel getWFIAActionDEModel() {
        if (this.wFIAActionDEModel == null) {
            try {
                this.wFIAActionDEModel = (WFIAActionDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFIAActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFIAActionDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFIAActionDEModel();
    }

    public WFIAActionDAO getWFIAActionDAO() {
        if (this.wFIAActionDAO == null) {
            try {
                this.wFIAActionDAO = (WFIAActionDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFIAActionDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFIAActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWFIAActionDAO();
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
    protected void onFillParentInfo(WFIAAction et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFIAACTION_WFSTEP_WFSTEPID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepService", this.getSessionFactory());
            WFStep parentEntity = (WFStep)iService.getDEModel().createEntity();
            parentEntity.set("WFSTEPID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_Wfstep(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_Wfstep(WFIAAction et, WFStep parentEntity) throws Exception {
        et.setWFStepId(parentEntity.getWFStepId());
        et.setWFStepName(parentEntity.getWFPLogicName());
    }

    @Override
    protected void onFillEntityFullInfo(WFIAAction et, boolean bCreate) throws Exception {
        if (bCreate && et.getWFIAActionName() == null) {
            et.setWFIAActionName((String)DefaultValueHelper.getValue(this.getWebContext(), "", "\u4ea4\u4e92\u64cd\u4f5c", 25));
        }
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_Wfstep(et, bCreate);
    }

    protected void onFillEntityFullInfo_Wfstep(WFIAAction et, boolean bCreate) throws Exception {
        if (et.isWFStepIdDirty()) {
            if (et.getWFStepId() != null) {
                if (et.getWFStepId() == null || et.getWFStepName() == null) {
                    WFStep parentEntity = et.getWfstep();
                    et.setWFStepName(parentEntity.getWFPLogicName());
                }
            } else {
                et.setWFStepName(null);
            }
        }
    }

    @Override
    protected void onWriteBackParent(WFIAAction et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WFIAAction> selectByWfstep(WFStepBase parentEntity) throws Exception {
        return this.selectByWfstep(parentEntity, "");
    }

    public ArrayList<WFIAAction> selectByWfstep(WFStepBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFSTEPID", parentEntity.getWFStepId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWfstepCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWfstepCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByWfstep(WFStep parentEntity) throws Exception {
        ArrayList<WFIAAction> list = this.selectByWfstep(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFSTEP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFIAACTION_WFSTEP_WFSTEPID", "", parentDEModel.getName(), "WFIAACTION", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWfstep(WFStep parentEntity) throws Exception {
        ArrayList<WFIAAction> list = this.selectByWfstep(parentEntity);
        for (WFIAAction item : list) {
            WFIAAction item2 = (WFIAAction)this.getDEModel().createEntity();
            item2.setWFIAActionId(item.getWFIAActionId());
            item2.setWFStepId(null);
            this.update(item2);
        }
    }

    public void removeByWfstep(WFStep parentEntity) throws Exception {
        final WFStep parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFIAActionServiceBase.this.onBeforeRemoveByWfstep(parentEntity2);
                WFIAActionServiceBase.this.internalRemoveByWfstep(parentEntity2);
                WFIAActionServiceBase.this.onAfterRemoveByWfstep(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWfstep(WFStep parentEntity) throws Exception {
    }

    protected void internalRemoveByWfstep(WFStep parentEntity) throws Exception {
        ArrayList<WFIAAction> removeList = this.selectByWfstep(parentEntity);
        this.onBeforeRemoveByWfstep(parentEntity, removeList);
        for (WFIAAction item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWfstep(parentEntity, removeList);
    }

    protected void onAfterRemoveByWfstep(WFStep parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWfstep(WFStep parentEntity, ArrayList<WFIAAction> removeList) throws Exception {
    }

    protected void onAfterRemoveByWfstep(WFStep parentEntity, ArrayList<WFIAAction> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WFIAAction et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WFIAAction et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getWFStepId() != null && (entity = cloneSession.getEntity("WFSTEP", et.getWFStepId())) != null) {
            this.onFillParentInfo_Wfstep(et, (WFStep)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WFIAAction et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionCount(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionLogicName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FAHelper(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextCondition(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextTo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderFlag(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PagePath(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFIAActionId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFIAActionName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_ActionCount(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isActionCountDirty()) {
            return null;
        }
        Integer value = et.getActionCount();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ActionCount_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionLogicName(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isActionLogicNameDirty()) {
            return null;
        }
        String value = et.getActionLogicName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ActionLogicName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionName(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isActionNameDirty()) {
            return null;
        }
        String value = et.getActionName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ActionName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FAHelper(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isFAHelperDirty()) {
            return null;
        }
        String value = et.getFAHelper();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_FAHelper_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FAHELPER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_NextCondition(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isNextConditionDirty()) {
            return null;
        }
        String value = et.getNextCondition();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_NextCondition_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTCONDITION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NextTo(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isNextToDirty()) {
            return null;
        }
        String value = et.getNextTo();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_NextTo_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTTO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderFlag(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isOrderFlagDirty()) {
            return null;
        }
        Integer value = et.getOrderFlag();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_OrderFlag_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PagePath(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPagePathDirty()) {
            return null;
        }
        String value = et.getPagePath();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PagePath_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelId(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPanelIdDirty()) {
            return null;
        }
        String value = et.getPanelId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PanelId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFIAActionId(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFIAActionIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIAACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFIAActionId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIAACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFIAActionId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIAACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFIAActionName(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFIAActionNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIAACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFIAActionName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIAACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFIAActionName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIAACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepId(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepIdDirty()) {
            return null;
        }
        String value = et.getWFStepId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepName(boolean bBaseMode, WFIAAction et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepNameDirty()) {
            return null;
        }
        String value = et.getWFStepName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(WFIAAction et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WFIAAction et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WFIAAction et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "ACTIONCOUNT", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActionCount_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ACTIONLOGICNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActionLogicName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ACTIONNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActionName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "FAHELPER", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_FAHelper_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "NEXTCONDITION", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_NextCondition_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "NEXTTO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_NextTo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ORDERFLAG", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_OrderFlag_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PAGEPATH", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PagePath_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PANELID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PanelId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFIAACTIONID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFIAActionId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFIAACTIONNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFIAActionName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_ActionCount_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_ActionLogicName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONLOGICNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ActionName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_FAHelper_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FAHELPER", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_NextCondition_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTCONDITION", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_NextTo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTTO", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_OrderFlag_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_PagePath_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PAGEPATH", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PanelId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PANELID", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_WFIAActionId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFIAACTIONID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFIAActionName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFIAACTIONNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFIAAction et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WFIAAction et) throws Exception {
        super.onUpdateParent(et);
    }
}

