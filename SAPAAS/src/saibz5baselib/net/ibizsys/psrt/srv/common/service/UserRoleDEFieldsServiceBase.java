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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRole;
import net.ibizsys.psrt.srv.common.entity.UserRoleBase;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEField;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEFieldBase;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEFields;
import net.ibizsys.psrt.srv.common.service.UserRoleDEFieldsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class UserRoleDEFieldsServiceBase
extends PSRuntimeSysServiceBase<UserRoleDEFields> {
    private static final Log log = LogFactory.getLog(UserRoleDEFieldsServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private UserRoleDEFieldsDEModel userRoleDEFieldsDEModel;
    private UserRoleDEFieldsDAO userRoleDEFieldsDAO;

    public static UserRoleDEFieldsService getInstance() throws Exception {
        return UserRoleDEFieldsServiceBase.getInstance(null);
    }

    public static UserRoleDEFieldsService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserRoleDEFieldsService)ServiceGlobal.getService(UserRoleDEFieldsService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.UserRoleDEFieldsService";
    }

    public UserRoleDEFieldsDEModel getUserRoleDEFieldsDEModel() {
        if (this.userRoleDEFieldsDEModel == null) {
            try {
                this.userRoleDEFieldsDEModel = (UserRoleDEFieldsDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDEFieldsDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDEFieldsDEModel();
    }

    public UserRoleDEFieldsDAO getUserRoleDEFieldsDAO() {
        if (this.userRoleDEFieldsDAO == null) {
            try {
                this.userRoleDEFieldsDAO = (UserRoleDEFieldsDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDEFieldsDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getUserRoleDEFieldsDAO();
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
    protected void onFillParentInfo(UserRoleDEFields et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDEFieldService", this.getSessionFactory());
            UserRoleDEField parentEntity = (UserRoleDEField)iService.getDEModel().createEntity();
            parentEntity.set("USERROLEDEFIELDID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_UserRoleDEField(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleService", this.getSessionFactory());
            UserRole parentEntity = (UserRole)iService.getDEModel().createEntity();
            parentEntity.set("USERROLEID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_UserRole(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_UserRoleDEField(UserRoleDEFields et, UserRoleDEField parentEntity) throws Exception {
        et.setUserRoleDEFieldId(parentEntity.getUserRoleDEFieldId());
        et.setUserRoleDEFieldName(parentEntity.getUserRoleDEFieldName());
    }

    protected void onFillParentInfo_UserRole(UserRoleDEFields et, UserRole parentEntity) throws Exception {
        et.setUserRoleId(parentEntity.getUserRoleId());
        et.setUserRoleName(parentEntity.getUserRoleName());
    }

    @Override
    protected boolean onFillEntityKeyValue(UserRoleDEFields et, boolean bTempMode) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Object objUserRoleId = et.get("USERROLEID");
        if (objUserRoleId == null) {
            objUserRoleId = "__EMTPY__";
        }
        sb.append("%1$s", objUserRoleId);
        sb.append("||");
        Object objUserRoleDEFieldId = et.get("USERROLEDEFIELDID");
        if (objUserRoleDEFieldId == null) {
            objUserRoleDEFieldId = "__EMTPY__";
        }
        sb.append("%1$s", objUserRoleDEFieldId);
        String strValue = sb.toString();
        et.set(this.getUserRoleDEFieldsDEModel().getUniTagDEField().getName(), KeyValueHelper.genUniqueId(strValue));
        return true;
    }

    @Override
    protected void onFillEntityFullInfo(UserRoleDEFields et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_UserRoleDEField(et, bCreate);
        this.onFillEntityFullInfo_UserRole(et, bCreate);
    }

    protected void onFillEntityFullInfo_UserRoleDEField(UserRoleDEFields et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_UserRole(UserRoleDEFields et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(UserRoleDEFields et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<UserRoleDEFields> selectByUserRoleDEField(UserRoleDEFieldBase parentEntity) throws Exception {
        return this.selectByUserRoleDEField(parentEntity, "");
    }

    public ArrayList<UserRoleDEFields> selectByUserRoleDEField(UserRoleDEFieldBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERROLEDEFIELDID", parentEntity.getUserRoleDEFieldId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByUserRoleDEFieldCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByUserRoleDEFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<UserRoleDEFields> selectByUserRole(UserRoleBase parentEntity) throws Exception {
        return this.selectByUserRole(parentEntity, "");
    }

    public ArrayList<UserRoleDEFields> selectByUserRole(UserRoleBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERROLEID", parentEntity.getUserRoleId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByUserRoleCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByUserRoleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByUserRoleDEField(UserRoleDEField parentEntity) throws Exception {
        ArrayList<UserRoleDEFields> list = this.selectByUserRoleDEField(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("USERROLEDEFIELD");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID", "", parentDEModel.getName(), "USERROLEDEFIELDS", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetUserRoleDEField(UserRoleDEField parentEntity) throws Exception {
        ArrayList<UserRoleDEFields> list = this.selectByUserRoleDEField(parentEntity);
        for (UserRoleDEFields item : list) {
            UserRoleDEFields item2 = (UserRoleDEFields)this.getDEModel().createEntity();
            item2.setUserRoleDEFieldsId(item.getUserRoleDEFieldsId());
            item2.setUserRoleDEFieldId(null);
            this.update(item2);
        }
    }

    public void removeByUserRoleDEField(UserRoleDEField parentEntity) throws Exception {
        final UserRoleDEField parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserRoleDEFieldsServiceBase.this.onBeforeRemoveByUserRoleDEField(parentEntity2);
                UserRoleDEFieldsServiceBase.this.internalRemoveByUserRoleDEField(parentEntity2);
                UserRoleDEFieldsServiceBase.this.onAfterRemoveByUserRoleDEField(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUserRoleDEField(UserRoleDEField parentEntity) throws Exception {
    }

    protected void internalRemoveByUserRoleDEField(UserRoleDEField parentEntity) throws Exception {
        ArrayList<UserRoleDEFields> removeList = this.selectByUserRoleDEField(parentEntity);
        this.onBeforeRemoveByUserRoleDEField(parentEntity, removeList);
        for (UserRoleDEFields item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByUserRoleDEField(parentEntity, removeList);
    }

    protected void onAfterRemoveByUserRoleDEField(UserRoleDEField parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByUserRoleDEField(UserRoleDEField parentEntity, ArrayList<UserRoleDEFields> removeList) throws Exception {
    }

    protected void onAfterRemoveByUserRoleDEField(UserRoleDEField parentEntity, ArrayList<UserRoleDEFields> removeList) throws Exception {
    }

    public void testRemoveByUserRole(UserRole parentEntity) throws Exception {
        ArrayList<UserRoleDEFields> list = this.selectByUserRole(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("USERROLE");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID", "", parentDEModel.getName(), "USERROLEDEFIELDS", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetUserRole(UserRole parentEntity) throws Exception {
        ArrayList<UserRoleDEFields> list = this.selectByUserRole(parentEntity);
        for (UserRoleDEFields item : list) {
            UserRoleDEFields item2 = (UserRoleDEFields)this.getDEModel().createEntity();
            item2.setUserRoleDEFieldsId(item.getUserRoleDEFieldsId());
            item2.setUserRoleId(null);
            this.update(item2);
        }
    }

    public void removeByUserRole(UserRole parentEntity) throws Exception {
        final UserRole parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserRoleDEFieldsServiceBase.this.onBeforeRemoveByUserRole(parentEntity2);
                UserRoleDEFieldsServiceBase.this.internalRemoveByUserRole(parentEntity2);
                UserRoleDEFieldsServiceBase.this.onAfterRemoveByUserRole(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUserRole(UserRole parentEntity) throws Exception {
    }

    protected void internalRemoveByUserRole(UserRole parentEntity) throws Exception {
        ArrayList<UserRoleDEFields> removeList = this.selectByUserRole(parentEntity);
        this.onBeforeRemoveByUserRole(parentEntity, removeList);
        for (UserRoleDEFields item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByUserRole(parentEntity, removeList);
    }

    protected void onAfterRemoveByUserRole(UserRole parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByUserRole(UserRole parentEntity, ArrayList<UserRoleDEFields> removeList) throws Exception {
    }

    protected void onAfterRemoveByUserRole(UserRole parentEntity, ArrayList<UserRoleDEFields> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(UserRoleDEFields et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(UserRoleDEFields et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getUserRoleDEFieldId() != null && (entity = cloneSession.getEntity("USERROLEDEFIELD", et.getUserRoleDEFieldId())) != null) {
            this.onFillParentInfo_UserRoleDEField(et, (UserRoleDEField)entity);
        }
        if (et.getUserRoleId() != null && (entity = cloneSession.getEntity("USERROLE", et.getUserRoleId())) != null) {
            this.onFillParentInfo_UserRole(et, (UserRole)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(UserRoleDEFields et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
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
        if ((entityFieldError = this.onCheckField_UserRoleDEFieldId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRoleDEFieldsId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRoleDEFieldsName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRoleId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_UserRoleDEFieldId(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserRoleDEFieldIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserRoleDEFieldId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserRoleDEFieldId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserRoleDEFieldsId(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserRoleDEFieldsIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserRoleDEFieldsId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserRoleDEFieldsId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserRoleDEFieldsName(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserRoleDEFieldsNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserRoleDEFieldsName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserRoleDEFieldsName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDEFIELDSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserRoleId(boolean bBaseMode, UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserRoleIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserRoleId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserRoleId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(UserRoleDEFields et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(UserRoleDEFields et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(UserRoleDEFields et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        UserRoleDEField userRoleDEField = et.getUserRoleDEField();
        if (userRoleDEField != null && userRoleDEField.contains(strField)) {
            return userRoleDEField.get(strField);
        }
        UserRole userRole = et.getUserRole();
        if (userRole != null && userRole.contains(strField)) {
            return userRole.get(strField);
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
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLEDEFIELDID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleDEFieldId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLEDEFIELDNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleDEFieldName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLEDEFIELDSID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleDEFieldsId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLEDEFIELDSNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleDEFieldsName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLEID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLENAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleName_Default(et, bCreate, bTempMode);
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

    protected String onTestValueRule_UserRoleDEFieldId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLEDEFIELDID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserRoleDEFieldName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLEDEFIELDNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserRoleDEFieldsId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLEDEFIELDSID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserRoleDEFieldsName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLEDEFIELDSNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserRoleId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLEID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserRoleName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLENAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserRoleDEFields et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(UserRoleDEFields et) throws Exception {
        super.onUpdateParent(et);
    }
}

