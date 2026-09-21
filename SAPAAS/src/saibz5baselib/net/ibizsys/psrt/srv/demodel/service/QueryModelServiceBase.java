/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.demodel.service;

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
import net.ibizsys.psrt.srv.common.service.UserRoleDataDetailService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataDetailServiceBase;
import net.ibizsys.psrt.srv.demodel.dao.QueryModelDAO;
import net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.entity.DataEntityBase;
import net.ibizsys.psrt.srv.demodel.entity.QueryModel;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.ibizsys.psrt.srv.demodel.service.DataEntityServiceBase;
import net.ibizsys.psrt.srv.demodel.service.QueryModelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class QueryModelServiceBase
extends PSRuntimeSysServiceBase<QueryModel> {
    private static final Log log = LogFactory.getLog(QueryModelServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_CURDE = "CurDE";
    private QueryModelDEModel queryModelDEModel;
    private QueryModelDAO queryModelDAO;

    public static QueryModelService getInstance() throws Exception {
        return QueryModelServiceBase.getInstance(null);
    }

    public static QueryModelService getInstance(SessionFactory sessionFactory) throws Exception {
        return (QueryModelService)ServiceGlobal.getService(QueryModelService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.demodel.service.QueryModelService";
    }

    public QueryModelDEModel getQueryModelDEModel() {
        if (this.queryModelDEModel == null) {
            try {
                this.queryModelDEModel = (QueryModelDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.queryModelDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getQueryModelDEModel();
    }

    public QueryModelDAO getQueryModelDAO() {
        if (this.queryModelDAO == null) {
            try {
                this.queryModelDAO = (QueryModelDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.demodel.dao.QueryModelDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.queryModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getQueryModelDAO();
    }

    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare(strDataSetName, DATASET_DEFAULT, true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare(strDataSetName, DATASET_CURDE, true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dbFetchResult;
    }

    @Override
    protected void onFillParentInfo(QueryModel et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_QUERYMODEL_DATAENTITY_DEID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.demodel.service.DataEntityService", this.getSessionFactory());
            DataEntity parentEntity = (DataEntity)iService.getDEModel().createEntity();
            parentEntity.set("DEID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_DE(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_DE(QueryModel et, DataEntity parentEntity) throws Exception {
        et.setDEId(parentEntity.getDEId());
        et.setDEName(parentEntity.getDEName());
    }

    @Override
    protected void onFillEntityFullInfo(QueryModel et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_DE(et, bCreate);
    }

    protected void onFillEntityFullInfo_DE(QueryModel et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(QueryModel et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<QueryModel> selectByDE(DataEntityBase parentEntity) throws Exception {
        return this.selectByDE(parentEntity, "");
    }

    public ArrayList<QueryModel> selectByDE(DataEntityBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEID", parentEntity.getDEId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByDECond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDE(DataEntity parentEntity) throws Exception {
        ArrayList<QueryModel> list = this.selectByDE(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("DATAENTITY");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_QUERYMODEL_DATAENTITY_DEID", "", parentDEModel.getName(), "QUERYMODEL", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetDE(DataEntity parentEntity) throws Exception {
        ArrayList<QueryModel> list = this.selectByDE(parentEntity);
        for (QueryModel item : list) {
            QueryModel item2 = (QueryModel)this.getDEModel().createEntity();
            item2.setQueryModelId(item.getQueryModelId());
            item2.setDEId(null);
            this.update(item2);
        }
    }

    public void removeByDE(DataEntity parentEntity) throws Exception {
        final DataEntity parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                QueryModelServiceBase.this.onBeforeRemoveByDE(parentEntity2);
                QueryModelServiceBase.this.internalRemoveByDE(parentEntity2);
                QueryModelServiceBase.this.onAfterRemoveByDE(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDE(DataEntity parentEntity) throws Exception {
    }

    protected void internalRemoveByDE(DataEntity parentEntity) throws Exception {
        ArrayList<QueryModel> removeList = this.selectByDE(parentEntity);
        this.onBeforeRemoveByDE(parentEntity, removeList);
        for (QueryModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByDE(parentEntity, removeList);
    }

    protected void onAfterRemoveByDE(DataEntity parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByDE(DataEntity parentEntity, ArrayList<QueryModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByDE(DataEntity parentEntity, ArrayList<QueryModel> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(QueryModel et) throws Exception {
        PSRuntimeSysServiceBase service = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, this.getSessionFactory());
        ((DataEntityServiceBase)service).testRemoveByACQueryModel(et);
        service = (UserRoleDataDetailService)ServiceGlobal.getService(UserRoleDataDetailService.class, this.getSessionFactory());
        ((UserRoleDataDetailServiceBase)service).testRemoveByQueryModel(et);
        service = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, this.getSessionFactory());
        ((DataEntityServiceBase)service).resetACQueryModel(et);
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(QueryModel et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getDEId() != null && (entity = cloneSession.getEntity("DATAENTITY", et.getDEId())) != null) {
            this.onFillParentInfo_DE(et, (DataEntity)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(QueryModel et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DEId(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupModel(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IsRawMode(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QMVersion(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryCond(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryField(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryModel(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryModelId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryModelName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryObject(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryParam(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuerySQL(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SelectMode(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SelectOrder(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFUserPub(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_DEId(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDEIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getDEId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DEId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupModel(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isGroupModelDirty()) {
            return null;
        }
        String value = et.getGroupModel();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_GroupModel_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IsRawMode(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isIsRawModeDirty()) {
            return null;
        }
        Integer value = et.getIsRawMode();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_IsRawMode_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISRAWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_QMVersion(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQMVersionDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QMVERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getQMVersion();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QMVERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QMVersion_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QMVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryCond(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQueryCondDirty()) {
            return null;
        }
        String value = et.getQueryCond();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QueryCond_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryField(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQueryFieldDirty()) {
            return null;
        }
        String value = et.getQueryField();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QueryField_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryModel(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQueryModelDirty()) {
            return null;
        }
        String value = et.getQueryModel();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QueryModel_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryModelId(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQueryModelIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getQueryModelId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QueryModelId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryModelName(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQueryModelNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getQueryModelName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QueryModelName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryObject(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQueryObjectDirty()) {
            return null;
        }
        String value = et.getQueryObject();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QueryObject_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYOBJECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryParam(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQueryParamDirty()) {
            return null;
        }
        String value = et.getQueryParam();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QueryParam_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QuerySQL(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isQuerySQLDirty()) {
            return null;
        }
        String value = et.getQuerySQL();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_QuerySQL_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SelectMode(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSelectModeDirty()) {
            return null;
        }
        String value = et.getSelectMode();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SelectMode_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SELECTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SelectOrder(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSelectOrderDirty()) {
            return null;
        }
        String value = et.getSelectOrder();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SelectOrder_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SELECTORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSRFSysPubDirty()) {
            return null;
        }
        Integer value = et.getSRFSysPub();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SRFSysPub_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFSYSPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFUserPub(boolean bBaseMode, QueryModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSRFUserPubDirty()) {
            return null;
        }
        Integer value = et.getSRFUserPub();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SRFUserPub_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFUSERPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(QueryModel et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(QueryModel et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(QueryModel et, String strField, IDataContextParam iDataContextParam) throws Exception {
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
        if (StringHelper.compare(strDEFieldName, "DEID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DEId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DENAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DEName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "GROUPMODEL", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_GroupModel_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ISRAWMODE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_IsRawMode_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QMVERSION", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QMVersion_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYCOND", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QueryCond_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYFIELD", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QueryField_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYMODEL", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QueryModel_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYMODELID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QueryModelId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYMODELNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QueryModelName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYOBJECT", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QueryObject_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYPARAM", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QueryParam_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "QUERYSQL", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_QuerySQL_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SELECTMODE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SelectMode_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SELECTORDER", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SelectOrder_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SRFSYSPUB", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SRFUSERPUB", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SRFUserPub_Default(et, bCreate, bTempMode);
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

    protected String onTestValueRule_DEId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEID", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DEName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DENAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_GroupModel_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMODEL", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_IsRawMode_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected String onTestValueRule_QMVersion_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_QueryCond_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYCOND", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_QueryField_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYFIELD", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_QueryModel_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYMODEL", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_QueryModelId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYMODELID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_QueryModelName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYMODELNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_QueryObject_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYOBJECT", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_QueryParam_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYPARAM", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_QuerySQL_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYSQL", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_SelectMode_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SELECTMODE", et, bTempMode, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_SelectOrder_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SELECTORDER", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_SRFUserPub_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
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

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, QueryModel et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(QueryModel et) throws Exception {
        super.onUpdateParent(et);
    }
}

