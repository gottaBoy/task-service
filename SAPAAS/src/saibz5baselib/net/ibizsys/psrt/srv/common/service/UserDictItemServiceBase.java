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
import net.ibizsys.psrt.srv.common.dao.UserDictItemDAO;
import net.ibizsys.psrt.srv.common.demodel.UserDictItemDEModel;
import net.ibizsys.psrt.srv.common.entity.UserDict;
import net.ibizsys.psrt.srv.common.entity.UserDictBase;
import net.ibizsys.psrt.srv.common.entity.UserDictCat;
import net.ibizsys.psrt.srv.common.entity.UserDictCatBase;
import net.ibizsys.psrt.srv.common.entity.UserDictItem;
import net.ibizsys.psrt.srv.common.service.UserDictItemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class UserDictItemServiceBase
extends PSRuntimeSysServiceBase<UserDictItem> {
    private static final Log log = LogFactory.getLog(UserDictItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private UserDictItemDEModel userDictItemDEModel;
    private UserDictItemDAO userDictItemDAO;

    public static UserDictItemService getInstance() throws Exception {
        return UserDictItemServiceBase.getInstance(null);
    }

    public static UserDictItemService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserDictItemService)ServiceGlobal.getService(UserDictItemService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.UserDictItemService";
    }

    public UserDictItemDEModel getUserDictItemDEModel() {
        if (this.userDictItemDEModel == null) {
            try {
                this.userDictItemDEModel = (UserDictItemDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserDictItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDictItemDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserDictItemDEModel();
    }

    public UserDictItemDAO getUserDictItemDAO() {
        if (this.userDictItemDAO == null) {
            try {
                this.userDictItemDAO = (UserDictItemDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserDictItemDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDictItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getUserDictItemDAO();
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
    protected void onFillParentInfo(UserDictItem et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserDictCatService", this.getSessionFactory());
            UserDictCat parentEntity = (UserDictCat)iService.getDEModel().createEntity();
            parentEntity.set("USERDICTCATID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_UserDictCat(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERDICTITEM_USERDICT_USERDICTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserDictService", this.getSessionFactory());
            UserDict parentEntity = (UserDict)iService.getDEModel().createEntity();
            parentEntity.set("USERDICTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_UserDict(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_UserDictCat(UserDictItem et, UserDictCat parentEntity) throws Exception {
        et.setUserDictCatId(parentEntity.getUserDictCatId());
        et.setUserDictCatName(parentEntity.getUserDictCatName());
    }

    protected void onFillParentInfo_UserDict(UserDictItem et, UserDict parentEntity) throws Exception {
        et.setUserDictId(parentEntity.getUserDictId());
        et.setUserDictName(parentEntity.getUserDictName());
    }

    @Override
    protected void onFillEntityFullInfo(UserDictItem et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_UserDictCat(et, bCreate);
        this.onFillEntityFullInfo_UserDict(et, bCreate);
    }

    protected void onFillEntityFullInfo_UserDictCat(UserDictItem et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_UserDict(UserDictItem et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(UserDictItem et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<UserDictItem> selectByUserDictCat(UserDictCatBase parentEntity) throws Exception {
        return this.selectByUserDictCat(parentEntity, "");
    }

    public ArrayList<UserDictItem> selectByUserDictCat(UserDictCatBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERDICTCATID", parentEntity.getUserDictCatId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByUserDictCatCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByUserDictCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<UserDictItem> selectByUserDict(UserDictBase parentEntity) throws Exception {
        return this.selectByUserDict(parentEntity, "");
    }

    public ArrayList<UserDictItem> selectByUserDict(UserDictBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERDICTID", parentEntity.getUserDictId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByUserDictCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByUserDictCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByUserDictCat(UserDictCat parentEntity) throws Exception {
        ArrayList<UserDictItem> list = this.selectByUserDictCat(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("USERDICTCAT");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID", "", parentDEModel.getName(), "USERDICTITEM", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetUserDictCat(UserDictCat parentEntity) throws Exception {
        ArrayList<UserDictItem> list = this.selectByUserDictCat(parentEntity);
        for (UserDictItem item : list) {
            UserDictItem item2 = (UserDictItem)this.getDEModel().createEntity();
            item2.setUserDictItemId(item.getUserDictItemId());
            item2.setUserDictCatId(null);
            this.update(item2);
        }
    }

    public void removeByUserDictCat(UserDictCat parentEntity) throws Exception {
        final UserDictCat parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserDictItemServiceBase.this.onBeforeRemoveByUserDictCat(parentEntity2);
                UserDictItemServiceBase.this.internalRemoveByUserDictCat(parentEntity2);
                UserDictItemServiceBase.this.onAfterRemoveByUserDictCat(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUserDictCat(UserDictCat parentEntity) throws Exception {
    }

    protected void internalRemoveByUserDictCat(UserDictCat parentEntity) throws Exception {
        ArrayList<UserDictItem> removeList = this.selectByUserDictCat(parentEntity);
        this.onBeforeRemoveByUserDictCat(parentEntity, removeList);
        for (UserDictItem item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByUserDictCat(parentEntity, removeList);
    }

    protected void onAfterRemoveByUserDictCat(UserDictCat parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByUserDictCat(UserDictCat parentEntity, ArrayList<UserDictItem> removeList) throws Exception {
    }

    protected void onAfterRemoveByUserDictCat(UserDictCat parentEntity, ArrayList<UserDictItem> removeList) throws Exception {
    }

    public void testRemoveByUserDict(UserDict parentEntity) throws Exception {
    }

    public void resetUserDict(UserDict parentEntity) throws Exception {
        ArrayList<UserDictItem> list = this.selectByUserDict(parentEntity);
        for (UserDictItem item : list) {
            UserDictItem item2 = (UserDictItem)this.getDEModel().createEntity();
            item2.setUserDictItemId(item.getUserDictItemId());
            item2.setUserDictId(null);
            this.update(item2);
        }
    }

    public void removeByUserDict(UserDict parentEntity) throws Exception {
        final UserDict parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserDictItemServiceBase.this.onBeforeRemoveByUserDict(parentEntity2);
                UserDictItemServiceBase.this.internalRemoveByUserDict(parentEntity2);
                UserDictItemServiceBase.this.onAfterRemoveByUserDict(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUserDict(UserDict parentEntity) throws Exception {
    }

    protected void internalRemoveByUserDict(UserDict parentEntity) throws Exception {
        ArrayList<UserDictItem> removeList = this.selectByUserDict(parentEntity);
        this.onBeforeRemoveByUserDict(parentEntity, removeList);
        for (UserDictItem item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByUserDict(parentEntity, removeList);
    }

    protected void onAfterRemoveByUserDict(UserDict parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByUserDict(UserDict parentEntity, ArrayList<UserDictItem> removeList) throws Exception {
    }

    protected void onAfterRemoveByUserDict(UserDict parentEntity, ArrayList<UserDictItem> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(UserDictItem et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(UserDictItem et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getUserDictCatId() != null && (entity = cloneSession.getEntity("USERDICTCAT", et.getUserDictCatId())) != null) {
            this.onFillParentInfo_UserDictCat(et, (UserDictCat)entity);
        }
        if (et.getUserDictId() != null && (entity = cloneSession.getEntity("USERDICT", et.getUserDictId())) != null) {
            this.onFillParentInfo_UserDict(et, (UserDict)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(UserDictItem et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MarkFlag(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver(bBaseMode, et, bCreate, bTempMode)) != null) {
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
        if ((entityFieldError = this.onCheckField_UserDictCatId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDictId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDictItemId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDictItemName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isContentDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getContent();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Content_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MarkFlag(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMarkFlagDirty()) {
            return null;
        }
        Integer value = et.getMarkFlag();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MarkFlag_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MARKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_UserDictCatId(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDictCatIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTCATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserDictCatId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTCATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDictCatId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserDictId(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDictIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserDictId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDictId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserDictItemId(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDictItemIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserDictItemId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDictItemId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserDictItemName(boolean bBaseMode, UserDictItem et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDictItemNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserDictItemName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDictItemName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDICTITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(UserDictItem et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(UserDictItem et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(UserDictItem et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        UserDict userDict = et.getUserDict();
        if (userDict != null && userDict.contains(strField)) {
            return userDict.get(strField);
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "CONTENT", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Content_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MARKFLAG", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MarkFlag_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
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
        if (StringHelper.compare(strDEFieldName, "USERDICTCATID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDictCatId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDICTCATNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDictCatName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDICTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDictId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDICTITEMID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDictItemId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDICTITEMNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDictItemName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDICTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDictName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_Content_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", et, bTempMode, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_MarkFlag_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
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

    protected String onTestValueRule_UserDictCatId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDICTCATID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserDictCatName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDICTCATNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserDictId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDICTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserDictItemId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDICTITEMID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserDictItemName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDICTITEMNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserDictName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDICTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserDictItem et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(UserDictItem et) throws Exception {
        super.onUpdateParent(et);
    }
}

