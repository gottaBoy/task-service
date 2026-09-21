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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.wf.dao.WFUCPolicyDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFUCPolicyDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserBase;
import net.ibizsys.psrt.srv.wf.service.WFUCPolicyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WFUCPolicyServiceBase
extends PSRuntimeSysServiceBase<WFUCPolicy> {
    private static final Log log = LogFactory.getLog(WFUCPolicyServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_ENABLEPOLICY = "EnablePolicy";
    public static final String ACTION_DISABLEPOLICY = "DisablePolicy";
    private WFUCPolicyDEModel wFUCPolicyDEModel;
    private WFUCPolicyDAO wFUCPolicyDAO;

    public static WFUCPolicyService getInstance() throws Exception {
        return WFUCPolicyServiceBase.getInstance(null);
    }

    public static WFUCPolicyService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFUCPolicyService)ServiceGlobal.getService(WFUCPolicyService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFUCPolicyService";
    }

    public WFUCPolicyDEModel getWFUCPolicyDEModel() {
        if (this.wFUCPolicyDEModel == null) {
            try {
                this.wFUCPolicyDEModel = (WFUCPolicyDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUCPolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUCPolicyDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUCPolicyDEModel();
    }

    public WFUCPolicyDAO getWFUCPolicyDAO() {
        if (this.wFUCPolicyDAO == null) {
            try {
                this.wFUCPolicyDAO = (WFUCPolicyDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFUCPolicyDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUCPolicyDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWFUCPolicyDAO();
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
        if (StringHelper.compare(strAction, ACTION_ENABLEPOLICY, true) == 0) {
            this.enablePolicy((WFUCPolicy)entity);
            return;
        }
        if (StringHelper.compare(strAction, ACTION_DISABLEPOLICY, true) == 0) {
            this.disablePolicy((WFUCPolicy)entity);
            return;
        }
        super.onExecuteAction(strAction, entity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dbFetchResult;
    }

    public void enablePolicy(WFUCPolicy wFUCPolicy) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", ACTION_ENABLEPOLICY), wFUCPolicy);
            return;
        }
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction(this, ACTION_ENABLEPOLICY, 0, wFUCPolicy, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(wFUCPolicy, ACTION_ENABLEPOLICY);
        final WFUCPolicy wFUCPolicy2 = wFUCPolicy;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(WFUCPolicyServiceBase.this.getService(), WFUCPolicyServiceBase.ACTION_ENABLEPOLICY, 40, wFUCPolicy2, null).getResult() != 1) {
                    WFUCPolicyServiceBase.this.onEnablePolicy(wFUCPolicy2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction(this, ACTION_ENABLEPOLICY, 99, wFUCPolicy, null);
        }
    }

    protected void onEnablePolicy(WFUCPolicy wFUCPolicy) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[EnablePolicy]");
    }

    public void disablePolicy(WFUCPolicy wFUCPolicy) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", ACTION_DISABLEPOLICY), wFUCPolicy);
            return;
        }
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction(this, ACTION_DISABLEPOLICY, 0, wFUCPolicy, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(wFUCPolicy, ACTION_DISABLEPOLICY);
        final WFUCPolicy wFUCPolicy2 = wFUCPolicy;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(WFUCPolicyServiceBase.this.getService(), WFUCPolicyServiceBase.ACTION_DISABLEPOLICY, 40, wFUCPolicy2, null).getResult() != 1) {
                    WFUCPolicyServiceBase.this.onDisablePolicy(wFUCPolicy2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction(this, ACTION_DISABLEPOLICY, 99, wFUCPolicy, null);
        }
    }

    protected void onDisablePolicy(WFUCPolicy wFUCPolicy) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[DisablePolicy]");
    }

    @Override
    protected void onFillParentInfo(WFUCPolicy et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory());
            WFUser parentEntity = (WFUser)iService.getDEModel().createEntity();
            parentEntity.set("WFUSERID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_MajorWFUser(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory());
            WFUser parentEntity = (WFUser)iService.getDEModel().createEntity();
            parentEntity.set("WFUSERID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_MinorWFUser(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_MajorWFUser(WFUCPolicy et, WFUser parentEntity) throws Exception {
        et.setMajorWFUserId(parentEntity.getWFUserId());
        et.setMajorWFUserName(parentEntity.getWFUserName());
    }

    protected void onFillParentInfo_MinorWFUser(WFUCPolicy et, WFUser parentEntity) throws Exception {
        et.setMinorWFUserId(parentEntity.getWFUserId());
        et.setMinorWFUserName(parentEntity.getWFUserName());
    }

    @Override
    protected void onFillEntityFullInfo(WFUCPolicy et, boolean bCreate) throws Exception {
        if (bCreate && et.getValidFlag() == null) {
            et.setValidFlag((Integer)DefaultValueHelper.getValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_MajorWFUser(et, bCreate);
        this.onFillEntityFullInfo_MinorWFUser(et, bCreate);
    }

    protected void onFillEntityFullInfo_MajorWFUser(WFUCPolicy et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorWFUser(WFUCPolicy et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(WFUCPolicy et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WFUCPolicy> selectByMajorWFUser(WFUserBase parentEntity) throws Exception {
        return this.selectByMajorWFUser(parentEntity, "");
    }

    public ArrayList<WFUCPolicy> selectByMajorWFUser(WFUserBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORWFUSERID", parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByMajorWFUserCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByMajorWFUserCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFUCPolicy> selectByMinorWFUser(WFUserBase parentEntity) throws Exception {
        return this.selectByMinorWFUser(parentEntity, "");
    }

    public ArrayList<WFUCPolicy> selectByMinorWFUser(WFUserBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORWFUSERID", parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByMinorWFUserCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByMinorWFUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUCPolicy> list = this.selectByMajorWFUser(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFUSER");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID", "", parentDEModel.getName(), "WFUCPOLICY", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetMajorWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUCPolicy> list = this.selectByMajorWFUser(parentEntity);
        for (WFUCPolicy item : list) {
            WFUCPolicy item2 = (WFUCPolicy)this.getDEModel().createEntity();
            item2.setWFUCPolicyId(item.getWFUCPolicyId());
            item2.setMajorWFUserId(null);
            this.update(item2);
        }
    }

    public void removeByMajorWFUser(WFUser parentEntity) throws Exception {
        final WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFUCPolicyServiceBase.this.onBeforeRemoveByMajorWFUser(parentEntity2);
                WFUCPolicyServiceBase.this.internalRemoveByMajorWFUser(parentEntity2);
                WFUCPolicyServiceBase.this.onAfterRemoveByMajorWFUser(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMajorWFUser(WFUser parentEntity) throws Exception {
    }

    protected void internalRemoveByMajorWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUCPolicy> removeList = this.selectByMajorWFUser(parentEntity);
        this.onBeforeRemoveByMajorWFUser(parentEntity, removeList);
        for (WFUCPolicy item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByMajorWFUser(parentEntity, removeList);
    }

    protected void onAfterRemoveByMajorWFUser(WFUser parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByMajorWFUser(WFUser parentEntity, ArrayList<WFUCPolicy> removeList) throws Exception {
    }

    protected void onAfterRemoveByMajorWFUser(WFUser parentEntity, ArrayList<WFUCPolicy> removeList) throws Exception {
    }

    public void testRemoveByMinorWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUCPolicy> list = this.selectByMinorWFUser(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFUSER");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID", "", parentDEModel.getName(), "WFUCPOLICY", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetMinorWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUCPolicy> list = this.selectByMinorWFUser(parentEntity);
        for (WFUCPolicy item : list) {
            WFUCPolicy item2 = (WFUCPolicy)this.getDEModel().createEntity();
            item2.setWFUCPolicyId(item.getWFUCPolicyId());
            item2.setMinorWFUserId(null);
            this.update(item2);
        }
    }

    public void removeByMinorWFUser(WFUser parentEntity) throws Exception {
        final WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFUCPolicyServiceBase.this.onBeforeRemoveByMinorWFUser(parentEntity2);
                WFUCPolicyServiceBase.this.internalRemoveByMinorWFUser(parentEntity2);
                WFUCPolicyServiceBase.this.onAfterRemoveByMinorWFUser(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMinorWFUser(WFUser parentEntity) throws Exception {
    }

    protected void internalRemoveByMinorWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUCPolicy> removeList = this.selectByMinorWFUser(parentEntity);
        this.onBeforeRemoveByMinorWFUser(parentEntity, removeList);
        for (WFUCPolicy item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByMinorWFUser(parentEntity, removeList);
    }

    protected void onAfterRemoveByMinorWFUser(WFUser parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByMinorWFUser(WFUser parentEntity, ArrayList<WFUCPolicy> removeList) throws Exception {
    }

    protected void onAfterRemoveByMinorWFUser(WFUser parentEntity, ArrayList<WFUCPolicy> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WFUCPolicy et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WFUCPolicy et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getMajorWFUserId() != null && (entity = cloneSession.getEntity("WFUSER", et.getMajorWFUserId())) != null) {
            this.onFillParentInfo_MajorWFUser(et, (WFUser)entity);
        }
        if (et.getMinorWFUserId() != null && (entity = cloneSession.getEntity("WFUSER", et.getMinorWFUserId())) != null) {
            this.onFillParentInfo_MinorWFUser(et, (WFUser)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WFUCPolicy et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorWFUserId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorWFUserId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PolicyState(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUCPolicyId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUCPolicyName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isBeginTimeDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Timestamp value = et.getBeginTime();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_BeginTime_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isEndTimeDirty()) {
            return null;
        }
        Timestamp value = et.getEndTime();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_EndTime_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorWFUserId(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMajorWFUserIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORWFUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getMajorWFUserId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORWFUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MajorWFUserId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORWFUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_MinorWFUserId(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMinorWFUserIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORWFUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getMinorWFUserId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORWFUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MinorWFUserId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORWFUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PolicyState(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPolicyStateDirty()) {
            return null;
        }
        Integer value = et.getPolicyState();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PolicyState_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDataDirty()) {
            return null;
        }
        String value = et.getUserData();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserData_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserData2Dirty()) {
            return null;
        }
        String value = et.getUserData2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserData2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isValidFlagDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getValidFlag();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ValidFlag_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUCPolicyId(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUCPolicyIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUCPOLICYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFUCPolicyId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUCPOLICYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUCPolicyId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUCPOLICYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUCPolicyName(boolean bBaseMode, WFUCPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUCPolicyNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUCPOLICYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFUCPolicyName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUCPOLICYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUCPolicyName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUCPOLICYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(WFUCPolicy et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WFUCPolicy et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WFUCPolicy et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        WFUser majorWFUser = et.getMajorWFUser();
        if (majorWFUser != null && majorWFUser.contains(strField)) {
            return majorWFUser.get(strField);
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "BEGINTIME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_BeginTime_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ENDTIME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_EndTime_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MAJORWFUSERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MajorWFUserId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MAJORWFUSERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MajorWFUserName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MINORWFUSERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MinorWFUserId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MINORWFUSERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MinorWFUserName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "POLICYSTATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PolicyState_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDATA", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserData_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDATA2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserData2_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "VALIDFLAG", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUCPOLICYID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUCPolicyId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUCPOLICYNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUCPolicyName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_BeginTime_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
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

    protected String onTestValueRule_EndTime_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_MajorWFUserId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORWFUSERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MajorWFUserName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORWFUSERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_MinorWFUserId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if ((this.checkFieldSimpleRule("MINORWFUSERID", et, bTempMode, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("MAJORWFUSERID", et, bTempMode, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("MINORWFUSERID", et, bTempMode, "NOTEQ", "ENTITYFIELD", "MAJORWFUSERID", "\u6d41\u7a0b\u7528\u6237\u4e0e\u59d4\u6258\u7528\u6237\u4e0d\u80fd\u4e00\u81f4", true)) && this.checkFieldStringLengthRule("MINORWFUSERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u6d41\u7a0b\u7528\u6237\u4e0e\u59d4\u6258\u7528\u6237\u4e0d\u80fd\u4e00\u81f4\u3002";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MinorWFUserName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORWFUSERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PolicyState_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected String onTestValueRule_UserData_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFUCPolicyId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUCPOLICYID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUCPolicyName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUCPOLICYNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFUCPolicy et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WFUCPolicy et) throws Exception {
        super.onUpdateParent(et);
    }
}

