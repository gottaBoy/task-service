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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSCtrlTypeModelDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeModelDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlModelBase;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeModel;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeModelServiceBase
extends PSCoreSysServiceBase<PSCtrlTypeModel> {
    private static final Log log = LogFactory.getLog(PSCtrlTypeModelServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCtrlTypeModelDEModel pSCtrlTypeModelDEModel;
    private PSCtrlTypeModelDAO pSCtrlTypeModelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCtrlTypeModelService";
    }

    public PSCtrlTypeModelDEModel getPSCtrlTypeModelDEModel() {
        if (this.pSCtrlTypeModelDEModel == null) {
            try {
                this.pSCtrlTypeModelDEModel = (PSCtrlTypeModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeModelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlTypeModelDEModel();
    }

    public PSCtrlTypeModelDAO getPSCtrlTypeModelDAO() {
        if (this.pSCtrlTypeModelDAO == null) {
            try {
                this.pSCtrlTypeModelDAO = (PSCtrlTypeModelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCtrlTypeModelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlTypeModelDAO();
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

    protected void onFillParentInfo(PSCtrlTypeModel pSCtrlTypeModel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEMODEL_PSCTRLMODEL_PSCTRLMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlModelService", (SessionFactory)this.getSessionFactory());
            PSCtrlModel pSCtrlModel = (PSCtrlModel)iService.getDEModel().createEntity();
            pSCtrlModel.set("PSCTRLMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlModel);
            } else {
                iService.get(pSCtrlModel);
            }
            this.onFillParentInfo_PSCtrlModel(pSCtrlTypeModel, pSCtrlModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEMODEL_PSCTRLTYPE_PSCTRLTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeService", (SessionFactory)this.getSessionFactory());
            PSCtrlType pSCtrlType = (PSCtrlType)iService.getDEModel().createEntity();
            pSCtrlType.set("PSCTRLTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlType);
            } else {
                iService.get(pSCtrlType);
            }
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeModel, pSCtrlType);
            return;
        }
        super.onFillParentInfo(pSCtrlTypeModel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlModel(PSCtrlTypeModel pSCtrlTypeModel, PSCtrlModel pSCtrlModel) throws Exception {
        pSCtrlTypeModel.setPSCtrlModelId(pSCtrlModel.getPSCtrlModelId());
        pSCtrlTypeModel.setPSCtrlModelName(pSCtrlModel.getPSCtrlModelName());
    }

    protected void onFillParentInfo_PSCtrlType(PSCtrlTypeModel pSCtrlTypeModel, PSCtrlType pSCtrlType) throws Exception {
        pSCtrlTypeModel.setPSCtrlTypeId(pSCtrlType.getPSCtrlTypeId());
        pSCtrlTypeModel.setPSCtrlTypeName(pSCtrlType.getPSCtrlTypeName());
    }

    protected void onFillEntityFullInfo(PSCtrlTypeModel pSCtrlTypeModel, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSCtrlTypeModel, bl);
        this.onFillEntityFullInfo_PSCtrlModel(pSCtrlTypeModel, bl);
        this.onFillEntityFullInfo_PSCtrlType(pSCtrlTypeModel, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlModel(PSCtrlTypeModel pSCtrlTypeModel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlType(PSCtrlTypeModel pSCtrlTypeModel, boolean bl) throws Exception {
        if (pSCtrlTypeModel.isPSCtrlTypeIdDirty()) {
            if (pSCtrlTypeModel.getPSCtrlTypeId() != null) {
                if (pSCtrlTypeModel.getPSCtrlTypeId() == null || pSCtrlTypeModel.getPSCtrlTypeName() == null) {
                    PSCtrlType pSCtrlType = pSCtrlTypeModel.getPSCtrlType();
                    pSCtrlTypeModel.setPSCtrlTypeName(pSCtrlType.getPSCtrlTypeName());
                }
            } else {
                pSCtrlTypeModel.setPSCtrlTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCtrlTypeModel pSCtrlTypeModel, boolean bl) throws Exception {
        super.onWriteBackParent(pSCtrlTypeModel, bl);
    }

    public ArrayList<PSCtrlTypeModel> selectByPSCtrlModel(PSCtrlModelBase pSCtrlModelBase) throws Exception {
        return this.selectByPSCtrlModel(pSCtrlModelBase, "", -1);
    }

    public ArrayList<PSCtrlTypeModel> selectByPSCtrlModel(PSCtrlModelBase pSCtrlModelBase, String string) throws Exception {
        return this.selectByPSCtrlModel(pSCtrlModelBase, string, -1);
    }

    public ArrayList<PSCtrlTypeModel> selectByPSCtrlModel(PSCtrlModelBase pSCtrlModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMODELID", (Object)pSCtrlModelBase.getPSCtrlModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCtrlTypeModel> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, "", -1);
    }

    public ArrayList<PSCtrlTypeModel> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, string, -1);
    }

    public ArrayList<PSCtrlTypeModel> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLTYPEID", (Object)pSCtrlTypeBase.getPSCtrlTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlModel(PSCtrlModel pSCtrlModel) throws Exception {
        ArrayList<PSCtrlTypeModel> arrayList = this.selectByPSCtrlModel(pSCtrlModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLTYPEMODEL_PSCTRLMODEL_PSCTRLMODELID", "", iDataEntityModel.getName(), "PSCTRLTYPEMODEL", iDataEntityModel.getDataInfo(pSCtrlModel), arrayList.get(0)));
        }
    }

    public void resetPSCtrlModel(PSCtrlModel pSCtrlModel) throws Exception {
        ArrayList<PSCtrlTypeModel> arrayList = this.selectByPSCtrlModel(pSCtrlModel);
        for (PSCtrlTypeModel pSCtrlTypeModel : arrayList) {
            PSCtrlTypeModel pSCtrlTypeModel2 = (PSCtrlTypeModel)this.getDEModel().createEntity();
            pSCtrlTypeModel2.setPSCtrlTypeModelId(pSCtrlTypeModel.getPSCtrlTypeModelId());
            pSCtrlTypeModel2.setPSCtrlModelId(null);
            this.update(pSCtrlTypeModel2);
        }
    }

    public void removeByPSCtrlModel(PSCtrlModel pSCtrlModel) throws Exception {
        final PSCtrlModel pSCtrlModel2 = pSCtrlModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeModelServiceBase.this.onBeforeRemoveByPSCtrlModel(pSCtrlModel2);
                PSCtrlTypeModelServiceBase.this.internalRemoveByPSCtrlModel(pSCtrlModel2);
                PSCtrlTypeModelServiceBase.this.onAfterRemoveByPSCtrlModel(pSCtrlModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlModel(PSCtrlModel pSCtrlModel) throws Exception {
    }

    protected void internalRemoveByPSCtrlModel(PSCtrlModel pSCtrlModel) throws Exception {
        ArrayList<PSCtrlTypeModel> arrayList = this.selectByPSCtrlModel(pSCtrlModel);
        this.onBeforeRemoveByPSCtrlModel(pSCtrlModel, arrayList);
        for (PSCtrlTypeModel pSCtrlTypeModel : arrayList) {
            this.remove(pSCtrlTypeModel);
        }
        this.onAfterRemoveByPSCtrlModel(pSCtrlModel, arrayList);
    }

    protected void onAfterRemoveByPSCtrlModel(PSCtrlModel pSCtrlModel) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlModel(PSCtrlModel pSCtrlModel, ArrayList<PSCtrlTypeModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlModel(PSCtrlModel pSCtrlModel, ArrayList<PSCtrlTypeModel> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    public void resetPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeModel> arrayList = this.selectByPSCtrlType(pSCtrlType);
        for (PSCtrlTypeModel pSCtrlTypeModel : arrayList) {
            PSCtrlTypeModel pSCtrlTypeModel2 = (PSCtrlTypeModel)this.getDEModel().createEntity();
            pSCtrlTypeModel2.setPSCtrlTypeModelId(pSCtrlTypeModel.getPSCtrlTypeModelId());
            pSCtrlTypeModel2.setPSCtrlTypeId(null);
            this.update(pSCtrlTypeModel2);
        }
    }

    public void removeByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        final PSCtrlType pSCtrlType2 = pSCtrlType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeModelServiceBase.this.onBeforeRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeModelServiceBase.this.internalRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeModelServiceBase.this.onAfterRemoveByPSCtrlType(pSCtrlType2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void internalRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeModel> arrayList = this.selectByPSCtrlType(pSCtrlType);
        this.onBeforeRemoveByPSCtrlType(pSCtrlType, arrayList);
        for (PSCtrlTypeModel pSCtrlTypeModel : arrayList) {
            this.remove(pSCtrlTypeModel);
        }
        this.onAfterRemoveByPSCtrlType(pSCtrlType, arrayList);
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeModel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlTypeModel pSCtrlTypeModel) throws Exception {
        super.onBeforeRemove(pSCtrlTypeModel);
    }

    protected void replaceParentInfo(PSCtrlTypeModel pSCtrlTypeModel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCtrlTypeModel, cloneSession);
        if (pSCtrlTypeModel.getPSCtrlModelId() != null && (iEntity = cloneSession.getEntity("PSCTRLMODEL", (Object)pSCtrlTypeModel.getPSCtrlModelId())) != null) {
            this.onFillParentInfo_PSCtrlModel(pSCtrlTypeModel, (PSCtrlModel)iEntity);
        }
        if (pSCtrlTypeModel.getPSCtrlTypeId() != null && (iEntity = cloneSession.getEntity("PSCTRLTYPE", (Object)pSCtrlTypeModel.getPSCtrlTypeId())) != null) {
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeModel, (PSCtrlType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlTypeModel pSCtrlTypeModel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCtrlTypeModel, bl);
    }

    protected void onCheckEntity(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSCtrlTypeModel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlModelId(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeId(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeModelId(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeModelName(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeName(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R7DExample(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSCtrlTypeModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCtrlTypeModel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isMemoDirty() : !pSCtrlTypeModel.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlTypeModel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCtrlTypeModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isOrderValueDirty() : !pSCtrlTypeModel.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSCtrlTypeModel.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlModelId(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isPSCtrlModelIdDirty() : !pSCtrlTypeModel.isPSCtrlModelIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeModel.getPSCtrlModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlModelId_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeId(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isPSCtrlTypeIdDirty() : !pSCtrlTypeModel.isPSCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeModel.getPSCtrlTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeId_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeModelId(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isPSCtrlTypeModelIdDirty() && !bl2 : !pSCtrlTypeModel.isPSCtrlTypeModelIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeModel.getPSCtrlTypeModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeModelId_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeModelName(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isPSCtrlTypeModelNameDirty() && !bl2 : !pSCtrlTypeModel.isPSCtrlTypeModelNameDirty()) {
            return null;
        }
        String string = pSCtrlTypeModel.getPSCtrlTypeModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeModelName_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeName(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isPSCtrlTypeNameDirty() : !pSCtrlTypeModel.isPSCtrlTypeNameDirty()) {
            return null;
        }
        String string = pSCtrlTypeModel.getPSCtrlTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeName_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R7DExample(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isR7DExampleDirty() : !pSCtrlTypeModel.isR7DExampleDirty()) {
            return null;
        }
        String string = pSCtrlTypeModel.getR7DExample();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_R7DExample_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R7DEXAMPLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSCtrlTypeModel pSCtrlTypeModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeModel.isValidFlagDirty() && !bl2 : !pSCtrlTypeModel.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSCtrlTypeModel.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSCtrlTypeModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCtrlTypeModel pSCtrlTypeModel, boolean bl) throws Exception {
        super.onSyncEntity(pSCtrlTypeModel, bl);
    }

    protected void onSyncIndexEntities(PSCtrlTypeModel pSCtrlTypeModel, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCtrlTypeModel, bl);
    }

    public Object getDataContextValue(PSCtrlTypeModel pSCtrlTypeModel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCtrlTypeModel, string, iDataContextParam)) != null) {
            return object;
        }
        PSCtrlModel pSCtrlModel = pSCtrlTypeModel.getPSCtrlModel();
        if (pSCtrlModel != null && pSCtrlModel.contains(string)) {
            return pSCtrlModel.get(string);
        }
        PSCtrlType pSCtrlType = pSCtrlTypeModel.getPSCtrlType();
        if (pSCtrlType != null && pSCtrlType.contains(string)) {
            return pSCtrlType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlTypeModel pSCtrlTypeModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCtrlTypeModel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"R7DEXAMPLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_R7DExample_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSCtrlModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_R7DExample_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R7DEXAMPLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSCtrlTypeModel pSCtrlTypeModel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCtrlTypeModel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlTypeModel pSCtrlTypeModel) throws Exception {
        super.onUpdateParent(pSCtrlTypeModel);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlTypeModel pSCtrlTypeModel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLTYPEMODEL");
        if (!bl) {
            pSCtrlTypeModel.setCreateDate(null);
            pSCtrlTypeModel.setCreateMan(null);
            pSCtrlTypeModel.setPSCtrlModelName(null);
            pSCtrlTypeModel.setPSCtrlTypeModelId(null);
            pSCtrlTypeModel.setUpdateDate(null);
            pSCtrlTypeModel.setUpdateMan(null);
            super.exportCurXmlModel(pSCtrlTypeModel, xmlNode, bl);
        }
    }
}

