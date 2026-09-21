/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.dynasys.service;

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
import net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFVerDAO;
import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFBase;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class DSDynaWFVerServiceBase
extends PSRuntimeSysServiceBase<DSDynaWFVer> {
    private static final Log log = LogFactory.getLog(DSDynaWFVerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private DSDynaWFVerDEModel dSDynaWFVerDEModel;
    private DSDynaWFVerDAO dSDynaWFVerDAO;

    public static DSDynaWFVerService getInstance() throws Exception {
        return DSDynaWFVerServiceBase.getInstance(null);
    }

    public static DSDynaWFVerService getInstance(SessionFactory sessionFactory) throws Exception {
        return (DSDynaWFVerService)ServiceGlobal.getService(DSDynaWFVerService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService";
    }

    public DSDynaWFVerDEModel getDSDynaWFVerDEModel() {
        if (this.dSDynaWFVerDEModel == null) {
            try {
                this.dSDynaWFVerDEModel = (DSDynaWFVerDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dSDynaWFVerDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDSDynaWFVerDEModel();
    }

    public DSDynaWFVerDAO getDSDynaWFVerDAO() {
        if (this.dSDynaWFVerDAO == null) {
            try {
                this.dSDynaWFVerDAO = (DSDynaWFVerDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFVerDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dSDynaWFVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getDSDynaWFVerDAO();
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
    protected void onFillParentInfo(DSDynaWFVer et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService", this.getSessionFactory());
            DSDynaWF parentEntity = (DSDynaWF)iService.getDEModel().createEntity();
            parentEntity.set("DSDYNAWFID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_DSDynaWF(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_DSDynaWF(DSDynaWFVer et, DSDynaWF parentEntity) throws Exception {
        et.setDSDynaWFId(parentEntity.getDSDynaWFId());
        et.setDSDynaWFName(parentEntity.getDSDynaWFName());
    }

    @Override
    protected void onFillEntityFullInfo(DSDynaWFVer et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_DSDynaWF(et, bCreate);
    }

    protected void onFillEntityFullInfo_DSDynaWF(DSDynaWFVer et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(DSDynaWFVer et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<DSDynaWFVer> selectByDSDynaWF(DSDynaWFBase parentEntity) throws Exception {
        return this.selectByDSDynaWF(parentEntity, "");
    }

    public ArrayList<DSDynaWFVer> selectByDSDynaWF(DSDynaWFBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSDYNAWFID", parentEntity.getDSDynaWFId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByDSDynaWFCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByDSDynaWFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDSDynaWF(DSDynaWF parentEntity) throws Exception {
        ArrayList<DSDynaWFVer> list = this.selectByDSDynaWF(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("DSDYNAWF");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID", "", parentDEModel.getName(), "DSDYNAWFVER", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetDSDynaWF(DSDynaWF parentEntity) throws Exception {
        ArrayList<DSDynaWFVer> list = this.selectByDSDynaWF(parentEntity);
        for (DSDynaWFVer item : list) {
            DSDynaWFVer item2 = (DSDynaWFVer)this.getDEModel().createEntity();
            item2.setDSDynaWFVerId(item.getDSDynaWFVerId());
            item2.setDSDynaWFId(null);
            this.update(item2);
        }
    }

    public void removeByDSDynaWF(DSDynaWF parentEntity) throws Exception {
        final DSDynaWF parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                DSDynaWFVerServiceBase.this.onBeforeRemoveByDSDynaWF(parentEntity2);
                DSDynaWFVerServiceBase.this.internalRemoveByDSDynaWF(parentEntity2);
                DSDynaWFVerServiceBase.this.onAfterRemoveByDSDynaWF(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDSDynaWF(DSDynaWF parentEntity) throws Exception {
    }

    protected void internalRemoveByDSDynaWF(DSDynaWF parentEntity) throws Exception {
        ArrayList<DSDynaWFVer> removeList = this.selectByDSDynaWF(parentEntity);
        this.onBeforeRemoveByDSDynaWF(parentEntity, removeList);
        for (DSDynaWFVer item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByDSDynaWF(parentEntity, removeList);
    }

    protected void onAfterRemoveByDSDynaWF(DSDynaWF parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByDSDynaWF(DSDynaWF parentEntity, ArrayList<DSDynaWFVer> removeList) throws Exception {
    }

    protected void onAfterRemoveByDSDynaWF(DSDynaWF parentEntity, ArrayList<DSDynaWFVer> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(DSDynaWFVer et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(DSDynaWFVer et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getDSDynaWFId() != null && (entity = cloneSession.getEntity("DSDYNAWF", et.getDSDynaWFId())) != null) {
            this.onFillParentInfo_DSDynaWF(et, (DSDynaWF)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(DSDynaWFVer et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, DSDynaWFVer et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DSDynaWFId(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSDynaWFVerId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSDynaWFVerName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModel(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaSysInstId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFVersion(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_DSDynaWFId(boolean bBaseMode, DSDynaWFVer et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDSDynaWFIdDirty()) {
            return null;
        }
        String value = et.getDSDynaWFId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DSDynaWFId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSDYNAWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSDynaWFVerId(boolean bBaseMode, DSDynaWFVer et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDSDynaWFVerIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSDYNAWFVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getDSDynaWFVerId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSDYNAWFVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DSDynaWFVerId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSDYNAWFVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSDynaWFVerName(boolean bBaseMode, DSDynaWFVer et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDSDynaWFVerNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSDYNAWFVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getDSDynaWFVerName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSDYNAWFVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DSDynaWFVerName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSDYNAWFVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModel(boolean bBaseMode, DSDynaWFVer et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDynaModelDirty()) {
            return null;
        }
        String value = et.getDynaModel();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DynaModel_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaSysInstId(boolean bBaseMode, DSDynaWFVer et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDynaSysInstIdDirty()) {
            return null;
        }
        String value = et.getDynaSysInstId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DynaSysInstId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNASYSINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFVersion(boolean bBaseMode, DSDynaWFVer et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFVersionDirty()) {
            return null;
        }
        Integer value = et.getWFVersion();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFVersion_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(DSDynaWFVer et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(DSDynaWFVer et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(DSDynaWFVer et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        DSDynaWF dSDynaWF = et.getDSDynaWF();
        if (dSDynaWF != null && dSDynaWF.contains(strField)) {
            return dSDynaWF.get(strField);
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
        if (StringHelper.compare(strDEFieldName, "DSDYNAWFID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DSDynaWFId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSDYNAWFNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DSDynaWFName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSDYNAWFVERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DSDynaWFVerId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSDYNAWFVERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DSDynaWFVerName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DYNAMODEL", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DynaModel_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DYNASYSINSTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DynaSysInstId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFVERSION", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFVersion_Default(et, bCreate, bTempMode);
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

    protected String onTestValueRule_DSDynaWFId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSDYNAWFID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DSDynaWFName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSDYNAWFNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DSDynaWFVerId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSDYNAWFVERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DSDynaWFVerName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSDYNAWFVERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DynaModel_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODEL", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DynaSysInstId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNASYSINSTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_WFVersion_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, DSDynaWFVer et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(DSDynaWFVer et) throws Exception {
        super.onUpdateParent(et);
    }
}

