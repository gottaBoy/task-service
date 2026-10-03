/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSysPolicyModelDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysPolicyModelDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicy;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicyBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicyModel;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPolicyModelServiceBase
extends PSCoreSysServiceBase<PSSysPolicyModel> {
    private static final Log log = LogFactory.getLog(PSSysPolicyModelServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysPolicyModelDEModel pSSysPolicyModelDEModel;
    private PSSysPolicyModelDAO pSSysPolicyModelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysPolicyModelService";
    }

    public PSSysPolicyModelDEModel getPSSysPolicyModelDEModel() {
        if (this.pSSysPolicyModelDEModel == null) {
            try {
                this.pSSysPolicyModelDEModel = (PSSysPolicyModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysPolicyModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPolicyModelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysPolicyModelDEModel();
    }

    public PSSysPolicyModelDAO getPSSysPolicyModelDAO() {
        if (this.pSSysPolicyModelDAO == null) {
            try {
                this.pSSysPolicyModelDAO = (PSSysPolicyModelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysPolicyModelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPolicyModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysPolicyModelDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysPolicyModel pSSysPolicyModel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPOLICYMODEL_PSSYSPOLICY_PSSYSPOLICYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPolicyService", (SessionFactory)this.getSessionFactory());
            PSSysPolicy pSSysPolicy = (PSSysPolicy)iService.getDEModel().createEntity();
            pSSysPolicy.set("PSSYSPOLICYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPolicy);
            } else {
                iService.get(pSSysPolicy);
            }
            this.onFillParentInfo_PSSysPolicy(pSSysPolicyModel, pSSysPolicy);
            return;
        }
        super.onFillParentInfo(pSSysPolicyModel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysPolicy(PSSysPolicyModel pSSysPolicyModel, PSSysPolicy pSSysPolicy) throws Exception {
        pSSysPolicyModel.setPSSysPolicyId(pSSysPolicy.getPSSysPolicyId());
        pSSysPolicyModel.setPSSysPolicyName(pSSysPolicy.getPSSysPolicyName());
    }

    protected void onFillEntityFullInfo(PSSysPolicyModel pSSysPolicyModel, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysPolicyModel, bl);
        this.onFillEntityFullInfo_PSSysPolicy(pSSysPolicyModel, bl);
    }

    protected void onFillEntityFullInfo_PSSysPolicy(PSSysPolicyModel pSSysPolicyModel, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysPolicyModel pSSysPolicyModel, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysPolicyModel, bl);
    }

    public ArrayList<PSSysPolicyModel> selectByPSSysPolicy(PSSysPolicyBase pSSysPolicyBase) throws Exception {
        return this.selectByPSSysPolicy(pSSysPolicyBase, "", -1);
    }

    public ArrayList<PSSysPolicyModel> selectByPSSysPolicy(PSSysPolicyBase pSSysPolicyBase, String string) throws Exception {
        return this.selectByPSSysPolicy(pSSysPolicyBase, string, -1);
    }

    public ArrayList<PSSysPolicyModel> selectByPSSysPolicy(PSSysPolicyBase pSSysPolicyBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPOLICYID", (Object)pSSysPolicyBase.getPSSysPolicyId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPolicyCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPolicyCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
    }

    public void resetPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
        ArrayList<PSSysPolicyModel> arrayList = this.selectByPSSysPolicy(pSSysPolicy);
        for (PSSysPolicyModel pSSysPolicyModel : arrayList) {
            PSSysPolicyModel pSSysPolicyModel2 = (PSSysPolicyModel)this.getDEModel().createEntity();
            pSSysPolicyModel2.setPSSysPolicyModelId(pSSysPolicyModel.getPSSysPolicyModelId());
            pSSysPolicyModel2.setPSSysPolicyId(null);
            this.update(pSSysPolicyModel2);
        }
    }

    public void removeByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
        final PSSysPolicy pSSysPolicy2 = pSSysPolicy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPolicyModelServiceBase.this.onBeforeRemoveByPSSysPolicy(pSSysPolicy2);
                PSSysPolicyModelServiceBase.this.internalRemoveByPSSysPolicy(pSSysPolicy2);
                PSSysPolicyModelServiceBase.this.onAfterRemoveByPSSysPolicy(pSSysPolicy2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
    }

    protected void internalRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
        ArrayList<PSSysPolicyModel> arrayList = this.selectByPSSysPolicy(pSSysPolicy);
        this.onBeforeRemoveByPSSysPolicy(pSSysPolicy, arrayList);
        for (PSSysPolicyModel pSSysPolicyModel : arrayList) {
            this.remove(pSSysPolicyModel);
        }
        this.onAfterRemoveByPSSysPolicy(pSSysPolicy, arrayList);
    }

    protected void onAfterRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy, ArrayList<PSSysPolicyModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy, ArrayList<PSSysPolicyModel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysPolicyModel pSSysPolicyModel) throws Exception {
        super.onBeforeRemove(pSSysPolicyModel);
    }

    protected void replaceParentInfo(PSSysPolicyModel pSSysPolicyModel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysPolicyModel, cloneSession);
        if (pSSysPolicyModel.getPSSysPolicyId() != null && (iEntity = cloneSession.getEntity("PSSYSPOLICY", (Object)pSSysPolicyModel.getPSSysPolicyId())) != null) {
            this.onFillParentInfo_PSSysPolicy(pSSysPolicyModel, (PSSysPolicy)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysPolicyModel pSSysPolicyModel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysPolicyModel, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CurCnt(bl, pSSysPolicyModel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Fields(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxCnt(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelTag(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PolicyInfo(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPolicyId(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPolicyModelId(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPolicyModelName(bl, pSSysPolicyModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysPolicyModel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CurCnt(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isCurCntDirty() : !pSSysPolicyModel.isCurCntDirty()) {
            return null;
        }
        Integer n = pSSysPolicyModel.getCurCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CurCnt_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Fields(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isFieldsDirty() : !pSSysPolicyModel.isFieldsDirty()) {
            return null;
        }
        String string = pSSysPolicyModel.getFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Fields_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxCnt(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isMaxCntDirty() : !pSSysPolicyModel.isMaxCntDirty()) {
            return null;
        }
        Integer n = pSSysPolicyModel.getMaxCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxCnt_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isMemoDirty() : !pSSysPolicyModel.isMemoDirty()) {
            return null;
        }
        String string = pSSysPolicyModel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelTag(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isModelTagDirty() && !bl2 : !pSSysPolicyModel.isModelTagDirty()) {
            return null;
        }
        String string = pSSysPolicyModel.getModelTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelTag_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PolicyInfo(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isPolicyInfoDirty() : !pSSysPolicyModel.isPolicyInfoDirty()) {
            return null;
        }
        String string = pSSysPolicyModel.getPolicyInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PolicyInfo_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPolicyId(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isPSSysPolicyIdDirty() : !pSSysPolicyModel.isPSSysPolicyIdDirty()) {
            return null;
        }
        String string = pSSysPolicyModel.getPSSysPolicyId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPolicyId_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPOLICYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPolicyModelId(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isPSSysPolicyModelIdDirty() && !bl2 : !pSSysPolicyModel.isPSSysPolicyModelIdDirty()) {
            return null;
        }
        String string = pSSysPolicyModel.getPSSysPolicyModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPOLICYMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPolicyModelId_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPOLICYMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPolicyModelName(boolean bl, PSSysPolicyModel pSSysPolicyModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPolicyModel.isPSSysPolicyModelNameDirty() && !bl2 : !pSSysPolicyModel.isPSSysPolicyModelNameDirty()) {
            return null;
        }
        String string = pSSysPolicyModel.getPSSysPolicyModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPOLICYMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPolicyModelName_Default(pSSysPolicyModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPOLICYMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysPolicyModel pSSysPolicyModel, boolean bl) throws Exception {
        super.onSyncEntity(pSSysPolicyModel, bl);
    }

    protected void onSyncIndexEntities(PSSysPolicyModel pSSysPolicyModel, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysPolicyModel, bl);
    }

    public Object getDataContextValue(PSSysPolicyModel pSSysPolicyModel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysPolicyModel, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysPolicy pSSysPolicy = pSSysPolicyModel.getPSSysPolicy();
        if (pSSysPolicy != null && pSSysPolicy.contains(string)) {
            return pSSysPolicy.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysPolicyModel pSSysPolicyModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysPolicyModel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Fields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POLICYINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PolicyInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPOLICYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPolicyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPOLICYMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPolicyModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPOLICYMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPolicyModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPOLICYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPolicyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CurCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Fields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PolicyInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POLICYINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPolicyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPOLICYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPolicyModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPOLICYMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPolicyModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPOLICYMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPolicyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPOLICYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSysPolicyModel pSSysPolicyModel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysPolicyModel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysPolicyModel pSSysPolicyModel) throws Exception {
        super.onUpdateParent(pSSysPolicyModel);
    }

    @Override
    protected void exportCurXmlModel(PSSysPolicyModel pSSysPolicyModel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSPOLICYMODEL");
        if (!bl) {
            pSSysPolicyModel.setCreateDate(null);
            pSSysPolicyModel.setCreateMan(null);
            pSSysPolicyModel.setPSSysPolicyModelId(null);
            pSSysPolicyModel.setPSSysPolicyName(null);
            pSSysPolicyModel.setUpdateDate(null);
            pSSysPolicyModel.setUpdateMan(null);
            super.exportCurXmlModel(pSSysPolicyModel, xmlNode, bl);
        }
    }
}

