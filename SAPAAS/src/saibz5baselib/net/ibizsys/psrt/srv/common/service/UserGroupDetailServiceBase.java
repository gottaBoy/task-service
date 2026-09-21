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
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO;
import net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.entity.UserGroupBase;
import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;
import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.entity.UserObjectBase;
import net.ibizsys.psrt.srv.common.service.UserGroupDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class UserGroupDetailServiceBase
extends PSRuntimeSysServiceBase<UserGroupDetail> {
    private static final Log log = LogFactory.getLog(UserGroupDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private UserGroupDetailDEModel userGroupDetailDEModel;
    private UserGroupDetailDAO userGroupDetailDAO;

    public static UserGroupDetailService getInstance() throws Exception {
        return UserGroupDetailServiceBase.getInstance(null);
    }

    public static UserGroupDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserGroupDetailService)ServiceGlobal.getService(UserGroupDetailService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.UserGroupDetailService";
    }

    public UserGroupDetailDEModel getUserGroupDetailDEModel() {
        if (this.userGroupDetailDEModel == null) {
            try {
                this.userGroupDetailDEModel = (UserGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userGroupDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserGroupDetailDEModel();
    }

    public UserGroupDetailDAO getUserGroupDetailDAO() {
        if (this.userGroupDetailDAO == null) {
            try {
                this.userGroupDetailDAO = (UserGroupDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userGroupDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getUserGroupDetailDAO();
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
    protected void onFillParentInfo(UserGroupDetail et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserGroupService", this.getSessionFactory());
            UserGroup parentEntity = (UserGroup)iService.getDEModel().createEntity();
            parentEntity.set("USERGROUPID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_UserGroup(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserObjectService", this.getSessionFactory());
            UserObject parentEntity = (UserObject)iService.getDEModel().createEntity();
            parentEntity.set("USEROBJECTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_UserObject(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_UserGroup(UserGroupDetail et, UserGroup parentEntity) throws Exception {
        et.setUserGroupId(parentEntity.getUserGroupId());
        et.setUserGroupName(parentEntity.getUserGroupName());
    }

    protected void onFillParentInfo_UserObject(UserGroupDetail et, UserObject parentEntity) throws Exception {
        et.setUserObjectId(parentEntity.getUserObjectId());
        et.setUserObjectName(parentEntity.getUserObjectName());
    }

    @Override
    protected boolean onFillEntityKeyValue(UserGroupDetail et, boolean bTempMode) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Object objUserGroupId = et.get("USERGROUPID");
        if (objUserGroupId == null) {
            objUserGroupId = "__EMTPY__";
        }
        sb.append("%1$s", objUserGroupId);
        sb.append("||");
        Object objUserObjectId = et.get("USEROBJECTID");
        if (objUserObjectId == null) {
            objUserObjectId = "__EMTPY__";
        }
        sb.append("%1$s", objUserObjectId);
        String strValue = sb.toString();
        et.set(this.getUserGroupDetailDEModel().getUniTagDEField().getName(), KeyValueHelper.genUniqueId(strValue));
        return true;
    }

    @Override
    protected void onFillEntityFullInfo(UserGroupDetail et, boolean bCreate) throws Exception {
        if (bCreate && et.getUserGroupDetailName() == null) {
            et.setUserGroupDetailName((String)DefaultValueHelper.getValue(this.getWebContext(), "", "\u6210\u5458\u540d\u79f0", 25));
        }
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_UserGroup(et, bCreate);
        this.onFillEntityFullInfo_UserObject(et, bCreate);
    }

    protected void onFillEntityFullInfo_UserGroup(UserGroupDetail et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_UserObject(UserGroupDetail et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(UserGroupDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<UserGroupDetail> selectByUserGroup(UserGroupBase parentEntity) throws Exception {
        return this.selectByUserGroup(parentEntity, "");
    }

    public ArrayList<UserGroupDetail> selectByUserGroup(UserGroupBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERGROUPID", parentEntity.getUserGroupId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByUserGroupCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByUserGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<UserGroupDetail> selectByUserObject(UserObjectBase parentEntity) throws Exception {
        return this.selectByUserObject(parentEntity, "");
    }

    public ArrayList<UserGroupDetail> selectByUserObject(UserObjectBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USEROBJECTID", parentEntity.getUserObjectId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByUserObjectCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByUserObjectCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByUserGroup(UserGroup parentEntity) throws Exception {
        ArrayList<UserGroupDetail> list = this.selectByUserGroup(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("USERGROUP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID", "", parentDEModel.getName(), "USERGROUPDETAIL", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetUserGroup(UserGroup parentEntity) throws Exception {
        ArrayList<UserGroupDetail> list = this.selectByUserGroup(parentEntity);
        for (UserGroupDetail item : list) {
            UserGroupDetail item2 = (UserGroupDetail)this.getDEModel().createEntity();
            item2.setUserGroupDetailId(item.getUserGroupDetailId());
            item2.setUserGroupId(null);
            this.update(item2);
        }
    }

    public void removeByUserGroup(UserGroup parentEntity) throws Exception {
        final UserGroup parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserGroupDetailServiceBase.this.onBeforeRemoveByUserGroup(parentEntity2);
                UserGroupDetailServiceBase.this.internalRemoveByUserGroup(parentEntity2);
                UserGroupDetailServiceBase.this.onAfterRemoveByUserGroup(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUserGroup(UserGroup parentEntity) throws Exception {
    }

    protected void internalRemoveByUserGroup(UserGroup parentEntity) throws Exception {
        ArrayList<UserGroupDetail> removeList = this.selectByUserGroup(parentEntity);
        this.onBeforeRemoveByUserGroup(parentEntity, removeList);
        for (UserGroupDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByUserGroup(parentEntity, removeList);
    }

    protected void onAfterRemoveByUserGroup(UserGroup parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByUserGroup(UserGroup parentEntity, ArrayList<UserGroupDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByUserGroup(UserGroup parentEntity, ArrayList<UserGroupDetail> removeList) throws Exception {
    }

    public void testRemoveByUserObject(UserObject parentEntity) throws Exception {
    }

    public void resetUserObject(UserObject parentEntity) throws Exception {
        ArrayList<UserGroupDetail> list = this.selectByUserObject(parentEntity);
        for (UserGroupDetail item : list) {
            UserGroupDetail item2 = (UserGroupDetail)this.getDEModel().createEntity();
            item2.setUserGroupDetailId(item.getUserGroupDetailId());
            item2.setUserObjectId(null);
            this.update(item2);
        }
    }

    public void removeByUserObject(UserObject parentEntity) throws Exception {
        final UserObject parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserGroupDetailServiceBase.this.onBeforeRemoveByUserObject(parentEntity2);
                UserGroupDetailServiceBase.this.internalRemoveByUserObject(parentEntity2);
                UserGroupDetailServiceBase.this.onAfterRemoveByUserObject(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUserObject(UserObject parentEntity) throws Exception {
    }

    protected void internalRemoveByUserObject(UserObject parentEntity) throws Exception {
        ArrayList<UserGroupDetail> removeList = this.selectByUserObject(parentEntity);
        this.onBeforeRemoveByUserObject(parentEntity, removeList);
        for (UserGroupDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByUserObject(parentEntity, removeList);
    }

    protected void onAfterRemoveByUserObject(UserObject parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByUserObject(UserObject parentEntity, ArrayList<UserGroupDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByUserObject(UserObject parentEntity, ArrayList<UserGroupDetail> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(UserGroupDetail et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(UserGroupDetail et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getUserGroupId() != null && (entity = cloneSession.getEntity("USERGROUP", et.getUserGroupId())) != null) {
            this.onFillParentInfo_UserGroup(et, (UserGroup)entity);
        }
        if (et.getUserObjectId() != null && (entity = cloneSession.getEntity("USEROBJECT", et.getUserObjectId())) != null) {
            this.onFillParentInfo_UserObject(et, (UserObject)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(UserGroupDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, UserGroupDetail et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_UserData(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserGroupDetailId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserGroupDetailName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserGroupId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserObjectId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_UserData(boolean bBaseMode, UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_UserData2(boolean bBaseMode, UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_UserGroupDetailId(boolean bBaseMode, UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserGroupDetailIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserGroupDetailId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserGroupDetailId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserGroupDetailName(boolean bBaseMode, UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserGroupDetailNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserGroupDetailName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserGroupDetailName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserGroupId(boolean bBaseMode, UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserGroupIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserGroupId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserGroupId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserObjectId(boolean bBaseMode, UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserObjectIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEROBJECTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserObjectId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEROBJECTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserObjectId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEROBJECTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(UserGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(UserGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(UserGroupDetail et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        UserGroup userGroup = et.getUserGroup();
        if (userGroup != null && userGroup.contains(strField)) {
            return userGroup.get(strField);
        }
        UserObject userObject = et.getUserObject();
        if (userObject != null && userObject.contains(strField)) {
            return userObject.get(strField);
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
        if (StringHelper.compare(strDEFieldName, "USERGROUPDETAILID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserGroupDetailId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERGROUPDETAILNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserGroupDetailName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERGROUPID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserGroupId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERGROUPNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserGroupName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USEROBJECTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserObjectId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USEROBJECTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserObjectName_Default(et, bCreate, bTempMode);
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
            if (this.checkFieldStringLengthRule("USERDATA", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserGroupDetailId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERGROUPDETAILID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserGroupDetailName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERGROUPDETAILNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserGroupId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERGROUPID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserGroupName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERGROUPNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserObjectId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USEROBJECTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserObjectName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USEROBJECTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserGroupDetail et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(UserGroupDetail et) throws Exception {
        super.onUpdateParent(et);
    }
}

