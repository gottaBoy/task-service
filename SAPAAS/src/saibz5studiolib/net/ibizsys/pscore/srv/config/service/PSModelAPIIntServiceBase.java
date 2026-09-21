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
import net.ibizsys.pscore.srv.config.dao.PSModelAPIIntDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelAPIIntDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelAPI;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIBase;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIInt;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.service.PSModelAPIMethodService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelAPIIntServiceBase
extends PSCoreSysServiceBase<PSModelAPIInt> {
    private static final Log log = LogFactory.getLog(PSModelAPIIntServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelAPIIntDEModel pSModelAPIIntDEModel;
    private PSModelAPIIntDAO pSModelAPIIntDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelAPIIntService";
    }

    public PSModelAPIIntDEModel getPSModelAPIIntDEModel() {
        if (this.pSModelAPIIntDEModel == null) {
            try {
                this.pSModelAPIIntDEModel = (PSModelAPIIntDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelAPIIntDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIIntDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelAPIIntDEModel();
    }

    public PSModelAPIIntDAO getPSModelAPIIntDAO() {
        if (this.pSModelAPIIntDAO == null) {
            try {
                this.pSModelAPIIntDAO = (PSModelAPIIntDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelAPIIntDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIIntDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelAPIIntDAO();
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

    protected void onFillParentInfo(PSModelAPIInt pSModelAPIInt, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELAPIINT_PSMODELAPI_PSMODELAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelAPIService", (SessionFactory)this.getSessionFactory());
            PSModelAPI pSModelAPI = (PSModelAPI)iService.getDEModel().createEntity();
            pSModelAPI.set("PSMODELAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelAPI);
            } else {
                iService.get((IEntity)pSModelAPI);
            }
            this.onFillParentInfo_PSModelAPI(pSModelAPIInt, pSModelAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELAPIINT_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModel);
            } else {
                iService.get((IEntity)pSModel);
            }
            this.onFillParentInfo_PSModel(pSModelAPIInt, pSModel);
            return;
        }
        super.onFillParentInfo((IEntity)pSModelAPIInt, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelAPI(PSModelAPIInt pSModelAPIInt, PSModelAPI pSModelAPI) throws Exception {
        pSModelAPIInt.setPSModelAPIId(pSModelAPI.getPSModelAPIId());
        pSModelAPIInt.setPSModelAPIName(pSModelAPI.getPSModelAPIName());
    }

    protected void onFillParentInfo_PSModel(PSModelAPIInt pSModelAPIInt, PSModel pSModel) throws Exception {
        pSModelAPIInt.setPSModelId(pSModel.getPSModelId());
        pSModelAPIInt.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSModelAPIInt pSModelAPIInt, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSModelAPIInt, bl);
        this.onFillEntityFullInfo_PSModelAPI(pSModelAPIInt, bl);
        this.onFillEntityFullInfo_PSModel(pSModelAPIInt, bl);
    }

    protected void onFillEntityFullInfo_PSModelAPI(PSModelAPIInt pSModelAPIInt, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModel(PSModelAPIInt pSModelAPIInt, boolean bl) throws Exception {
        if (pSModelAPIInt.isPSModelIdDirty()) {
            if (pSModelAPIInt.getPSModelId() != null) {
                if (pSModelAPIInt.getPSModelId() == null || pSModelAPIInt.getPSModelName() == null) {
                    PSModel pSModel = pSModelAPIInt.getPSModel();
                    pSModelAPIInt.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSModelAPIInt.setPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelAPIInt pSModelAPIInt, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSModelAPIInt, bl);
    }

    public ArrayList<PSModelAPIInt> selectByPSModelAPI(PSModelAPIBase pSModelAPIBase) throws Exception {
        return this.selectByPSModelAPI(pSModelAPIBase, "", -1);
    }

    public ArrayList<PSModelAPIInt> selectByPSModelAPI(PSModelAPIBase pSModelAPIBase, String string) throws Exception {
        return this.selectByPSModelAPI(pSModelAPIBase, string, -1);
    }

    public ArrayList<PSModelAPIInt> selectByPSModelAPI(PSModelAPIBase pSModelAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELAPIID", (Object)pSModelAPIBase.getPSModelAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelAPIInt> selectByPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelAPIInt> selectByPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelAPIInt> selectByPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModelAPI(PSModelAPI pSModelAPI) throws Exception {
        ArrayList<PSModelAPIInt> arrayList = this.selectByPSModelAPI(pSModelAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModelAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELAPIINT_PSMODELAPI_PSMODELAPIID", "", iDataEntityModel.getName(), "PSMODELAPIINT", iDataEntityModel.getDataInfo((IEntity)pSModelAPI), arrayList.get(0)));
        }
    }

    public void resetPSModelAPI(PSModelAPI pSModelAPI) throws Exception {
        ArrayList<PSModelAPIInt> arrayList = this.selectByPSModelAPI(pSModelAPI);
        for (PSModelAPIInt pSModelAPIInt : arrayList) {
            PSModelAPIInt pSModelAPIInt2 = (PSModelAPIInt)this.getDEModel().createEntity();
            pSModelAPIInt2.setPSModelAPIIntId(pSModelAPIInt.getPSModelAPIIntId());
            pSModelAPIInt2.setPSModelAPIId(null);
            this.update(pSModelAPIInt2);
        }
    }

    public void removeByPSModelAPI(PSModelAPI pSModelAPI) throws Exception {
        final PSModelAPI pSModelAPI2 = pSModelAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelAPIIntServiceBase.this.onBeforeRemoveByPSModelAPI(pSModelAPI2);
                PSModelAPIIntServiceBase.this.internalRemoveByPSModelAPI(pSModelAPI2);
                PSModelAPIIntServiceBase.this.onAfterRemoveByPSModelAPI(pSModelAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelAPI(PSModelAPI pSModelAPI) throws Exception {
    }

    protected void internalRemoveByPSModelAPI(PSModelAPI pSModelAPI) throws Exception {
        ArrayList<PSModelAPIInt> arrayList = this.selectByPSModelAPI(pSModelAPI);
        this.onBeforeRemoveByPSModelAPI(pSModelAPI, arrayList);
        for (PSModelAPIInt pSModelAPIInt : arrayList) {
            this.remove((IEntity)pSModelAPIInt);
        }
        this.onAfterRemoveByPSModelAPI(pSModelAPI, arrayList);
    }

    protected void onAfterRemoveByPSModelAPI(PSModelAPI pSModelAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSModelAPI(PSModelAPI pSModelAPI, ArrayList<PSModelAPIInt> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelAPI(PSModelAPI pSModelAPI, ArrayList<PSModelAPIInt> arrayList) throws Exception {
    }

    public void testRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelAPIInt> arrayList = this.selectByPSModel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELAPIINT_PSMODEL_PSMODELID", "", iDataEntityModel.getName(), "PSMODELAPIINT", iDataEntityModel.getDataInfo((IEntity)pSModel), arrayList.get(0)));
        }
    }

    public void resetPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelAPIInt> arrayList = this.selectByPSModel(pSModel);
        for (PSModelAPIInt pSModelAPIInt : arrayList) {
            PSModelAPIInt pSModelAPIInt2 = (PSModelAPIInt)this.getDEModel().createEntity();
            pSModelAPIInt2.setPSModelAPIIntId(pSModelAPIInt.getPSModelAPIIntId());
            pSModelAPIInt2.setPSModelId(null);
            this.update(pSModelAPIInt2);
        }
    }

    public void removeByPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelAPIIntServiceBase.this.onBeforeRemoveByPSModel(pSModel2);
                PSModelAPIIntServiceBase.this.internalRemoveByPSModel(pSModel2);
                PSModelAPIIntServiceBase.this.onAfterRemoveByPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelAPIInt> arrayList = this.selectByPSModel(pSModel);
        this.onBeforeRemoveByPSModel(pSModel, arrayList);
        for (PSModelAPIInt pSModelAPIInt : arrayList) {
            this.remove((IEntity)pSModelAPIInt);
        }
        this.onAfterRemoveByPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel, ArrayList<PSModelAPIInt> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel, ArrayList<PSModelAPIInt> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelAPIInt pSModelAPIInt) throws Exception {
        PSModelAPIMethodService pSModelAPIMethodService = (PSModelAPIMethodService)ServiceGlobal.getService(PSModelAPIMethodService.class, (SessionFactory)this.getSessionFactory());
        pSModelAPIMethodService.testRemoveByPSModelAPIInt(pSModelAPIInt);
        pSModelAPIMethodService.removeByPSModelAPIInt(pSModelAPIInt);
        super.onBeforeRemove(pSModelAPIInt);
    }

    protected void replaceParentInfo(PSModelAPIInt pSModelAPIInt, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSModelAPIInt, cloneSession);
        if (pSModelAPIInt.getPSModelAPIId() != null && (iEntity = cloneSession.getEntity("PSMODELAPI", (Object)pSModelAPIInt.getPSModelAPIId())) != null) {
            this.onFillParentInfo_PSModelAPI(pSModelAPIInt, (PSModelAPI)iEntity);
        }
        if (pSModelAPIInt.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelAPIInt.getPSModelId())) != null) {
            this.onFillParentInfo_PSModel(pSModelAPIInt, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelAPIInt pSModelAPIInt, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSModelAPIInt, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IntDesc(bl, pSModelAPIInt, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIId(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIIntId(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIIntName(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeField(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeParam(bl, pSModelAPIInt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSModelAPIInt, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IntDesc(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isIntDescDirty() : !pSModelAPIInt.isIntDescDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getIntDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IntDesc_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INTDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isMemoDirty() : !pSModelAPIInt.isMemoDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSModelAPIInt, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isOrderValueDirty() : !pSModelAPIInt.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelAPIInt.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSModelAPIInt, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelAPIId(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isPSModelAPIIdDirty() : !pSModelAPIInt.isPSModelAPIIdDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getPSModelAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIId_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIIntId(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isPSModelAPIIntIdDirty() && !bl2 : !pSModelAPIInt.isPSModelAPIIntIdDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getPSModelAPIIntId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIINTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIIntId_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIINTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIIntName(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isPSModelAPIIntNameDirty() && !bl2 : !pSModelAPIInt.isPSModelAPIIntNameDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getPSModelAPIIntName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIINTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIIntName_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIINTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isPSModelIdDirty() : !pSModelAPIInt.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isPSModelNameDirty() : !pSModelAPIInt.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeField(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isTypeFieldDirty() : !pSModelAPIInt.isTypeFieldDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getTypeField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeField_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeParam(boolean bl, PSModelAPIInt pSModelAPIInt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIInt.isTypeParamDirty() : !pSModelAPIInt.isTypeParamDirty()) {
            return null;
        }
        String string = pSModelAPIInt.getTypeParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeParam_Default((IEntity)pSModelAPIInt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelAPIInt pSModelAPIInt, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSModelAPIInt, bl);
    }

    protected void onSyncIndexEntities(PSModelAPIInt pSModelAPIInt, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSModelAPIInt, bl);
    }

    public Object getDataContextValue(PSModelAPIInt pSModelAPIInt, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSModelAPIInt, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelAPIInt pSModelAPIInt, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSModelAPIInt, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INTDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IntDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIINTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIIntId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIINTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIIntName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeParam_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_IntDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INTDESC", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSModelAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIIntId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIINTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIIntName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIINTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEFIELD", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelAPIInt pSModelAPIInt) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSModelAPIInt)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelAPIInt pSModelAPIInt) throws Exception {
        super.onUpdateParent((IEntity)pSModelAPIInt);
    }

    @Override
    protected void exportCurXmlModel(PSModelAPIInt pSModelAPIInt, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELAPIINT");
        if (!bl) {
            pSModelAPIInt.setCreateDate(null);
            pSModelAPIInt.setCreateMan(null);
            pSModelAPIInt.setPSModelAPIIntId(null);
            pSModelAPIInt.setPSModelAPIName(null);
            pSModelAPIInt.setUpdateDate(null);
            pSModelAPIInt.setUpdateMan(null);
            super.exportCurXmlModel(pSModelAPIInt, xmlNode, bl);
        }
    }
}

