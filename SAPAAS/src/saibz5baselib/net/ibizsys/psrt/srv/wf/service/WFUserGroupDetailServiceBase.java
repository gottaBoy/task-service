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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.wf.dao.WFUserGroupDetailDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDetailDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserBase;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroup;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroupBase;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WFUserGroupDetailServiceBase
extends PSRuntimeSysServiceBase<WFUserGroupDetail> {
    private static final Log log = LogFactory.getLog(WFUserGroupDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private WFUserGroupDetailDEModel wFUserGroupDetailDEModel;
    private WFUserGroupDetailDAO wFUserGroupDetailDAO;

    public static WFUserGroupDetailService getInstance() throws Exception {
        return WFUserGroupDetailServiceBase.getInstance(null);
    }

    public static WFUserGroupDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFUserGroupDetailService)ServiceGlobal.getService(WFUserGroupDetailService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService";
    }

    public WFUserGroupDetailDEModel getWFUserGroupDetailDEModel() {
        if (this.wFUserGroupDetailDEModel == null) {
            try {
                this.wFUserGroupDetailDEModel = (WFUserGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUserGroupDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFUserGroupDetailDEModel();
    }

    public WFUserGroupDetailDAO getWFUserGroupDetailDAO() {
        if (this.wFUserGroupDetailDAO == null) {
            try {
                this.wFUserGroupDetailDAO = (WFUserGroupDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFUserGroupDetailDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFUserGroupDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWFUserGroupDetailDAO();
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
    protected void onFillParentInfo(WFUserGroupDetail et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserGroupService", this.getSessionFactory());
            WFUserGroup parentEntity = (WFUserGroup)iService.getDEModel().createEntity();
            parentEntity.set("WFUSERGROUPID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFUserGroup(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID", true) == 0) {
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

    protected void onFillParentInfo_WFUserGroup(WFUserGroupDetail et, WFUserGroup parentEntity) throws Exception {
        et.setWFUserGroupId(parentEntity.getWFUserGroupId());
        et.setWFUserGroupName(parentEntity.getWFUserGroupName());
    }

    protected void onFillParentInfo_WFUser(WFUserGroupDetail et, WFUser parentEntity) throws Exception {
        et.setWFUserId(parentEntity.getWFUserId());
        et.setWFUserName(parentEntity.getWFUserName());
    }

    @Override
    protected boolean onFillEntityKeyValue(WFUserGroupDetail et, boolean bTempMode) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Object objWFUserGroupId = et.get("WFUSERGROUPID");
        if (objWFUserGroupId == null) {
            objWFUserGroupId = "__EMTPY__";
        }
        sb.append("%1$s", objWFUserGroupId);
        sb.append("||");
        Object objWFUserId = et.get("WFUSERID");
        if (objWFUserId == null) {
            objWFUserId = "__EMTPY__";
        }
        sb.append("%1$s", objWFUserId);
        String strValue = sb.toString();
        et.set(this.getWFUserGroupDetailDEModel().getUniTagDEField().getName(), KeyValueHelper.genUniqueId(strValue));
        return true;
    }

    @Override
    protected void onFillEntityFullInfo(WFUserGroupDetail et, boolean bCreate) throws Exception {
        if (bCreate && et.getWFUserGroupDetailName() == null) {
            et.setWFUserGroupDetailName((String)DefaultValueHelper.getValue(this.getWebContext(), "", "\u5de5\u4f5c\u6d41\u7528\u6237", 25));
        }
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_WFUserGroup(et, bCreate);
        this.onFillEntityFullInfo_WFUser(et, bCreate);
    }

    protected void onFillEntityFullInfo_WFUserGroup(WFUserGroupDetail et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_WFUser(WFUserGroupDetail et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(WFUserGroupDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WFUserGroupDetail> selectByWFUserGroup(WFUserGroupBase parentEntity) throws Exception {
        return this.selectByWFUserGroup(parentEntity, "");
    }

    public ArrayList<WFUserGroupDetail> selectByWFUserGroup(WFUserGroupBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFUSERGROUPID", parentEntity.getWFUserGroupId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFUserGroupCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFUserGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFUserGroupDetail> selectByWFUser(WFUserBase parentEntity) throws Exception {
        return this.selectByWFUser(parentEntity, "");
    }

    public ArrayList<WFUserGroupDetail> selectByWFUser(WFUserBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFUSERID", parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFUserCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByWFUserGroup(WFUserGroup parentEntity) throws Exception {
        ArrayList<WFUserGroupDetail> list = this.selectByWFUserGroup(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFUSERGROUP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID", "", parentDEModel.getName(), "WFUSERGROUPDETAIL", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWFUserGroup(WFUserGroup parentEntity) throws Exception {
        ArrayList<WFUserGroupDetail> list = this.selectByWFUserGroup(parentEntity);
        for (WFUserGroupDetail item : list) {
            WFUserGroupDetail item2 = (WFUserGroupDetail)this.getDEModel().createEntity();
            item2.setWFUserGroupDetailId(item.getWFUserGroupDetailId());
            item2.setWFUserGroupId(null);
            this.update(item2);
        }
    }

    public void removeByWFUserGroup(WFUserGroup parentEntity) throws Exception {
        final WFUserGroup parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFUserGroupDetailServiceBase.this.onBeforeRemoveByWFUserGroup(parentEntity2);
                WFUserGroupDetailServiceBase.this.internalRemoveByWFUserGroup(parentEntity2);
                WFUserGroupDetailServiceBase.this.onAfterRemoveByWFUserGroup(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFUserGroup(WFUserGroup parentEntity) throws Exception {
    }

    protected void internalRemoveByWFUserGroup(WFUserGroup parentEntity) throws Exception {
        ArrayList<WFUserGroupDetail> removeList = this.selectByWFUserGroup(parentEntity);
        this.onBeforeRemoveByWFUserGroup(parentEntity, removeList);
        for (WFUserGroupDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFUserGroup(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFUserGroup(WFUserGroup parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFUserGroup(WFUserGroup parentEntity, ArrayList<WFUserGroupDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFUserGroup(WFUserGroup parentEntity, ArrayList<WFUserGroupDetail> removeList) throws Exception {
    }

    public void testRemoveByWFUser(WFUser parentEntity) throws Exception {
    }

    public void resetWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUserGroupDetail> list = this.selectByWFUser(parentEntity);
        for (WFUserGroupDetail item : list) {
            WFUserGroupDetail item2 = (WFUserGroupDetail)this.getDEModel().createEntity();
            item2.setWFUserGroupDetailId(item.getWFUserGroupDetailId());
            item2.setWFUserId(null);
            this.update(item2);
        }
    }

    public void removeByWFUser(WFUser parentEntity) throws Exception {
        final WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFUserGroupDetailServiceBase.this.onBeforeRemoveByWFUser(parentEntity2);
                WFUserGroupDetailServiceBase.this.internalRemoveByWFUser(parentEntity2);
                WFUserGroupDetailServiceBase.this.onAfterRemoveByWFUser(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFUser(WFUser parentEntity) throws Exception {
    }

    protected void internalRemoveByWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFUserGroupDetail> removeList = this.selectByWFUser(parentEntity);
        this.onBeforeRemoveByWFUser(parentEntity, removeList);
        for (WFUserGroupDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFUser(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFUser(WFUser parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFUser(WFUser parentEntity, ArrayList<WFUserGroupDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFUser(WFUser parentEntity, ArrayList<WFUserGroupDetail> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WFUserGroupDetail et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WFUserGroupDetail et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getWFUserGroupId() != null && (entity = cloneSession.getEntity("WFUSERGROUP", et.getWFUserGroupId())) != null) {
            this.onFillParentInfo_WFUserGroup(et, (WFUserGroup)entity);
        }
        if (et.getWFUserId() != null && (entity = cloneSession.getEntity("WFUSER", et.getWFUserId())) != null) {
            this.onFillParentInfo_WFUser(et, (WFUser)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WFUserGroupDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WFUserGroupDetail et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserGroupDetailId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserGroupDetailName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserGroupId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_WFUserGroupDetailId(boolean bBaseMode, WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUserGroupDetailIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFUserGroupDetailId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUserGroupDetailId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERGROUPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserGroupDetailName(boolean bBaseMode, WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUserGroupDetailNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFUserGroupDetailName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUserGroupDetailName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERGROUPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserGroupId(boolean bBaseMode, WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFUserGroupIdDirty()) {
            return null;
        }
        String value = et.getWFUserGroupId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFUserGroupId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserId(boolean bBaseMode, WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
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

    @Override
    protected void onSyncEntity(WFUserGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WFUserGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WFUserGroupDetail et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        WFUserGroup wFUserGroup = et.getWFUserGroup();
        if (wFUserGroup != null && wFUserGroup.contains(strField)) {
            return wFUserGroup.get(strField);
        }
        WFUser wFUser = et.getWFUser();
        if (wFUser != null && wFUser.contains(strField)) {
            return wFUser.get(strField);
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
        if (StringHelper.compare(strDEFieldName, "WFUSERGROUPDETAILID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserGroupDetailId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERGROUPDETAILNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserGroupDetailName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERGROUPID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserGroupId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERGROUPNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserGroupName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFUSERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFUserName_Default(et, bCreate, bTempMode);
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

    protected String onTestValueRule_WFUserGroupDetailId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERGROUPDETAILID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUserGroupDetailName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERGROUPDETAILNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUserGroupId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERGROUPID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFUserGroupName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERGROUPNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFUserGroupDetail et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WFUserGroupDetail et) throws Exception {
        super.onUpdateParent(et);
    }
}

