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
import net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO;
import net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDGroup;
import net.ibizsys.psrt.srv.common.entity.TSSDGroupBase;
import net.ibizsys.psrt.srv.common.entity.TSSDGroupDetail;
import net.ibizsys.psrt.srv.common.entity.TSSDItem;
import net.ibizsys.psrt.srv.common.entity.TSSDItemBase;
import net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class TSSDGroupDetailServiceBase
extends PSRuntimeSysServiceBase<TSSDGroupDetail> {
    private static final Log log = LogFactory.getLog(TSSDGroupDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private TSSDGroupDetailDEModel tSSDGroupDetailDEModel;
    private TSSDGroupDetailDAO tSSDGroupDetailDAO;

    public static TSSDGroupDetailService getInstance() throws Exception {
        return TSSDGroupDetailServiceBase.getInstance(null);
    }

    public static TSSDGroupDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (TSSDGroupDetailService)ServiceGlobal.getService(TSSDGroupDetailService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService";
    }

    public TSSDGroupDetailDEModel getTSSDGroupDetailDEModel() {
        if (this.tSSDGroupDetailDEModel == null) {
            try {
                this.tSSDGroupDetailDEModel = (TSSDGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDGroupDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getTSSDGroupDetailDEModel();
    }

    public TSSDGroupDetailDAO getTSSDGroupDetailDAO() {
        if (this.tSSDGroupDetailDAO == null) {
            try {
                this.tSSDGroupDetailDAO = (TSSDGroupDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.tSSDGroupDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getTSSDGroupDetailDAO();
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
    protected void onFillParentInfo(TSSDGroupDetail et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDGroupService", this.getSessionFactory());
            TSSDGroup parentEntity = (TSSDGroup)iService.getDEModel().createEntity();
            parentEntity.set("TSSDGROUPID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_TSSDGroup(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDItemService", this.getSessionFactory());
            TSSDItem parentEntity = (TSSDItem)iService.getDEModel().createEntity();
            parentEntity.set("TSSDITEMID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_TSSDItem(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_TSSDGroup(TSSDGroupDetail et, TSSDGroup parentEntity) throws Exception {
        et.setTSSDGroupId(parentEntity.getTSSDGroupId());
        et.setTSSDGroupName(parentEntity.getTSSDGroupName());
    }

    protected void onFillParentInfo_TSSDItem(TSSDGroupDetail et, TSSDItem parentEntity) throws Exception {
        et.setTSSDItemId(parentEntity.getTSSDItemId());
        et.setTSSDItemName(parentEntity.getTSSDItemName());
    }

    @Override
    protected void onFillEntityFullInfo(TSSDGroupDetail et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_TSSDGroup(et, bCreate);
        this.onFillEntityFullInfo_TSSDItem(et, bCreate);
    }

    protected void onFillEntityFullInfo_TSSDGroup(TSSDGroupDetail et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_TSSDItem(TSSDGroupDetail et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(TSSDGroupDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<TSSDGroupDetail> selectByTSSDGroup(TSSDGroupBase parentEntity) throws Exception {
        return this.selectByTSSDGroup(parentEntity, "");
    }

    public ArrayList<TSSDGroupDetail> selectByTSSDGroup(TSSDGroupBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TSSDGROUPID", parentEntity.getTSSDGroupId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByTSSDGroupCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByTSSDGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<TSSDGroupDetail> selectByTSSDItem(TSSDItemBase parentEntity) throws Exception {
        return this.selectByTSSDItem(parentEntity, "");
    }

    public ArrayList<TSSDGroupDetail> selectByTSSDItem(TSSDItemBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TSSDITEMID", parentEntity.getTSSDItemId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByTSSDItemCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByTSSDItemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByTSSDGroup(TSSDGroup parentEntity) throws Exception {
    }

    public void resetTSSDGroup(TSSDGroup parentEntity) throws Exception {
        ArrayList<TSSDGroupDetail> list = this.selectByTSSDGroup(parentEntity);
        for (TSSDGroupDetail item : list) {
            TSSDGroupDetail item2 = (TSSDGroupDetail)this.getDEModel().createEntity();
            item2.setTSSDGroupDetailId(item.getTSSDGroupDetailId());
            item2.setTSSDGroupId(null);
            this.update(item2);
        }
    }

    public void removeByTSSDGroup(TSSDGroup parentEntity) throws Exception {
        final TSSDGroup parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                TSSDGroupDetailServiceBase.this.onBeforeRemoveByTSSDGroup(parentEntity2);
                TSSDGroupDetailServiceBase.this.internalRemoveByTSSDGroup(parentEntity2);
                TSSDGroupDetailServiceBase.this.onAfterRemoveByTSSDGroup(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByTSSDGroup(TSSDGroup parentEntity) throws Exception {
    }

    protected void internalRemoveByTSSDGroup(TSSDGroup parentEntity) throws Exception {
        ArrayList<TSSDGroupDetail> removeList = this.selectByTSSDGroup(parentEntity);
        this.onBeforeRemoveByTSSDGroup(parentEntity, removeList);
        for (TSSDGroupDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByTSSDGroup(parentEntity, removeList);
    }

    protected void onAfterRemoveByTSSDGroup(TSSDGroup parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByTSSDGroup(TSSDGroup parentEntity, ArrayList<TSSDGroupDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByTSSDGroup(TSSDGroup parentEntity, ArrayList<TSSDGroupDetail> removeList) throws Exception {
    }

    public void testRemoveByTSSDItem(TSSDItem parentEntity) throws Exception {
    }

    public void resetTSSDItem(TSSDItem parentEntity) throws Exception {
        ArrayList<TSSDGroupDetail> list = this.selectByTSSDItem(parentEntity);
        for (TSSDGroupDetail item : list) {
            TSSDGroupDetail item2 = (TSSDGroupDetail)this.getDEModel().createEntity();
            item2.setTSSDGroupDetailId(item.getTSSDGroupDetailId());
            item2.setTSSDItemId(null);
            this.update(item2);
        }
    }

    public void removeByTSSDItem(TSSDItem parentEntity) throws Exception {
        final TSSDItem parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                TSSDGroupDetailServiceBase.this.onBeforeRemoveByTSSDItem(parentEntity2);
                TSSDGroupDetailServiceBase.this.internalRemoveByTSSDItem(parentEntity2);
                TSSDGroupDetailServiceBase.this.onAfterRemoveByTSSDItem(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByTSSDItem(TSSDItem parentEntity) throws Exception {
    }

    protected void internalRemoveByTSSDItem(TSSDItem parentEntity) throws Exception {
        ArrayList<TSSDGroupDetail> removeList = this.selectByTSSDItem(parentEntity);
        this.onBeforeRemoveByTSSDItem(parentEntity, removeList);
        for (TSSDGroupDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByTSSDItem(parentEntity, removeList);
    }

    protected void onAfterRemoveByTSSDItem(TSSDItem parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByTSSDItem(TSSDItem parentEntity, ArrayList<TSSDGroupDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByTSSDItem(TSSDItem parentEntity, ArrayList<TSSDGroupDetail> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(TSSDGroupDetail et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(TSSDGroupDetail et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getTSSDGroupId() != null && (entity = cloneSession.getEntity("TSSDGROUP", et.getTSSDGroupId())) != null) {
            this.onFillParentInfo_TSSDGroup(et, (TSSDGroup)entity);
        }
        if (et.getTSSDItemId() != null && (entity = cloneSession.getEntity("TSSDITEM", et.getTSSDItemId())) != null) {
            this.onFillParentInfo_TSSDItem(et, (TSSDItem)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(TSSDGroupDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, TSSDGroupDetail et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_TSSDGroupDetailId(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSSDGroupDetailName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSSDGroupId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSSDItemId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_TSSDGroupDetailId(boolean bBaseMode, TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDGroupDetailIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getTSSDGroupDetailId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDGroupDetailId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDGROUPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSSDGroupDetailName(boolean bBaseMode, TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDGroupDetailNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getTSSDGroupDetailName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDGroupDetailName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDGROUPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSSDGroupId(boolean bBaseMode, TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDGroupIdDirty()) {
            return null;
        }
        String value = et.getTSSDGroupId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDGroupId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSSDItemId(boolean bBaseMode, TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTSSDItemIdDirty()) {
            return null;
        }
        String value = et.getTSSDItemId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TSSDItemId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSSDITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(TSSDGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(TSSDGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(TSSDGroupDetail et, String strField, IDataContextParam iDataContextParam) throws Exception {
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
        if (StringHelper.compare(strDEFieldName, "TSSDGROUPDETAILID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDGroupDetailId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDGROUPDETAILNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDGroupDetailName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDGROUPID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDGroupId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDGROUPNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDGroupName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDITEMID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDItemId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TSSDITEMNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TSSDItemName_Default(et, bCreate, bTempMode);
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

    protected String onTestValueRule_TSSDGroupDetailId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDGROUPDETAILID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDGroupDetailName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDGROUPDETAILNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDGroupId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDGROUPID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDGroupName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDGROUPNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDItemId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDITEMID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TSSDItemName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSSDITEMNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, TSSDGroupDetail et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(TSSDGroupDetail et) throws Exception {
        super.onUpdateParent(et);
    }
}

