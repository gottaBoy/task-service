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
import net.ibizsys.pscore.srv.config.dao.PSSysModelFuncDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelAPI;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIBase;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.entity.PSModelFieldBase;
import net.ibizsys.pscore.srv.config.entity.PSSysModelFunc;
import net.ibizsys.pscore.srv.config.service.PSSysModelFuncTemplService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFuncServiceBase
extends PSCoreSysServiceBase<PSSysModelFunc> {
    private static final Log log = LogFactory.getLog(PSSysModelFuncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysModelFuncDEModel pSSysModelFuncDEModel;
    private PSSysModelFuncDAO pSSysModelFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysModelFuncService";
    }

    public PSSysModelFuncDEModel getPSSysModelFuncDEModel() {
        if (this.pSSysModelFuncDEModel == null) {
            try {
                this.pSSysModelFuncDEModel = (PSSysModelFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelFuncDEModel();
    }

    public PSSysModelFuncDAO getPSSysModelFuncDAO() {
        if (this.pSSysModelFuncDAO == null) {
            try {
                this.pSSysModelFuncDAO = (PSSysModelFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysModelFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelFuncDAO();
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

    protected void onFillParentInfo(PSSysModelFunc pSSysModelFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELFUNC_PSMODELAPI_PSMODELAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelAPIService", (SessionFactory)this.getSessionFactory());
            PSModelAPI pSModelAPI = (PSModelAPI)iService.getDEModel().createEntity();
            pSModelAPI.set("PSMODELAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelAPI);
            } else {
                iService.get((IEntity)pSModelAPI);
            }
            this.onFillParentInfo_PSModelApi(pSSysModelFunc, pSModelAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELFUNC_PSMODELFIELD_PSMODELFIELDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelFieldService", (SessionFactory)this.getSessionFactory());
            PSModelField pSModelField = (PSModelField)iService.getDEModel().createEntity();
            pSModelField.set("PSMODELFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelField);
            } else {
                iService.get((IEntity)pSModelField);
            }
            this.onFillParentInfo_PSModelField(pSSysModelFunc, pSModelField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELFUNC_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModel);
            } else {
                iService.get((IEntity)pSModel);
            }
            this.onFillParentInfo_PSModel(pSSysModelFunc, pSModel);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysModelFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelApi(PSSysModelFunc pSSysModelFunc, PSModelAPI pSModelAPI) throws Exception {
        pSSysModelFunc.setPSModelAPIId(pSModelAPI.getPSModelAPIId());
        pSSysModelFunc.setPSModelAPIName(pSModelAPI.getPSModelAPIName());
    }

    protected void onFillParentInfo_PSModelField(PSSysModelFunc pSSysModelFunc, PSModelField pSModelField) throws Exception {
        pSSysModelFunc.setPSModelFieldId(pSModelField.getPSModelFieldId());
        pSSysModelFunc.setPSModelFieldName(pSModelField.getPSModelFieldName());
    }

    protected void onFillParentInfo_PSModel(PSSysModelFunc pSSysModelFunc, PSModel pSModel) throws Exception {
        pSSysModelFunc.setPSModelId(pSModel.getPSModelId());
        pSSysModelFunc.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
        if (bl && pSSysModelFunc.getValidFlag() == null) {
            pSSysModelFunc.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysModelFunc, bl);
        this.onFillEntityFullInfo_PSModelApi(pSSysModelFunc, bl);
        this.onFillEntityFullInfo_PSModelField(pSSysModelFunc, bl);
        this.onFillEntityFullInfo_PSModel(pSSysModelFunc, bl);
    }

    protected void onFillEntityFullInfo_PSModelApi(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModelField(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
        if (pSSysModelFunc.isPSModelFieldIdDirty()) {
            if (pSSysModelFunc.getPSModelFieldId() != null) {
                if (pSSysModelFunc.getPSModelFieldId() == null || pSSysModelFunc.getPSModelFieldName() == null) {
                    PSModelField pSModelField = pSSysModelFunc.getPSModelField();
                    pSSysModelFunc.setPSModelFieldName(pSModelField.getPSModelFieldName());
                }
            } else {
                pSSysModelFunc.setPSModelFieldName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModel(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
        if (pSSysModelFunc.isPSModelIdDirty()) {
            if (pSSysModelFunc.getPSModelId() != null) {
                if (pSSysModelFunc.getPSModelId() == null || pSSysModelFunc.getPSModelName() == null) {
                    PSModel pSModel = pSSysModelFunc.getPSModel();
                    pSSysModelFunc.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSSysModelFunc.setPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysModelFunc, bl);
    }

    public ArrayList<PSSysModelFunc> selectByPSModelApi(PSModelAPIBase pSModelAPIBase) throws Exception {
        return this.selectByPSModelApi(pSModelAPIBase, "", -1);
    }

    public ArrayList<PSSysModelFunc> selectByPSModelApi(PSModelAPIBase pSModelAPIBase, String string) throws Exception {
        return this.selectByPSModelApi(pSModelAPIBase, string, -1);
    }

    public ArrayList<PSSysModelFunc> selectByPSModelApi(PSModelAPIBase pSModelAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELAPIID", (Object)pSModelAPIBase.getPSModelAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelApiCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelApiCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelFunc> selectByPSModelField(PSModelFieldBase pSModelFieldBase) throws Exception {
        return this.selectByPSModelField(pSModelFieldBase, "", -1);
    }

    public ArrayList<PSSysModelFunc> selectByPSModelField(PSModelFieldBase pSModelFieldBase, String string) throws Exception {
        return this.selectByPSModelField(pSModelFieldBase, string, -1);
    }

    public ArrayList<PSSysModelFunc> selectByPSModelField(PSModelFieldBase pSModelFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELFIELDID", (Object)pSModelFieldBase.getPSModelFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelFieldCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelFunc> selectByPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSSysModelFunc> selectByPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSSysModelFunc> selectByPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
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

    public void testRemoveByPSModelApi(PSModelAPI pSModelAPI) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModelApi(pSModelAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModelAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELFUNC_PSMODELAPI_PSMODELAPIID", "", iDataEntityModel.getName(), "PSSYSMODELFUNC", iDataEntityModel.getDataInfo((IEntity)pSModelAPI), arrayList.get(0)));
        }
    }

    public void resetPSModelApi(PSModelAPI pSModelAPI) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModelApi(pSModelAPI);
        for (PSSysModelFunc pSSysModelFunc : arrayList) {
            PSSysModelFunc pSSysModelFunc2 = (PSSysModelFunc)this.getDEModel().createEntity();
            pSSysModelFunc2.setPSSysModelFuncId(pSSysModelFunc.getPSSysModelFuncId());
            pSSysModelFunc2.setPSModelAPIId(null);
            this.update(pSSysModelFunc2);
        }
    }

    public void removeByPSModelApi(PSModelAPI pSModelAPI) throws Exception {
        final PSModelAPI pSModelAPI2 = pSModelAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelFuncServiceBase.this.onBeforeRemoveByPSModelApi(pSModelAPI2);
                PSSysModelFuncServiceBase.this.internalRemoveByPSModelApi(pSModelAPI2);
                PSSysModelFuncServiceBase.this.onAfterRemoveByPSModelApi(pSModelAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelApi(PSModelAPI pSModelAPI) throws Exception {
    }

    protected void internalRemoveByPSModelApi(PSModelAPI pSModelAPI) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModelApi(pSModelAPI);
        this.onBeforeRemoveByPSModelApi(pSModelAPI, arrayList);
        for (PSSysModelFunc pSSysModelFunc : arrayList) {
            this.remove((IEntity)pSSysModelFunc);
        }
        this.onAfterRemoveByPSModelApi(pSModelAPI, arrayList);
    }

    protected void onAfterRemoveByPSModelApi(PSModelAPI pSModelAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSModelApi(PSModelAPI pSModelAPI, ArrayList<PSSysModelFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelApi(PSModelAPI pSModelAPI, ArrayList<PSSysModelFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSModelField(PSModelField pSModelField) throws Exception {
    }

    public void resetPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModelField(pSModelField);
        for (PSSysModelFunc pSSysModelFunc : arrayList) {
            PSSysModelFunc pSSysModelFunc2 = (PSSysModelFunc)this.getDEModel().createEntity();
            pSSysModelFunc2.setPSSysModelFuncId(pSSysModelFunc.getPSSysModelFuncId());
            pSSysModelFunc2.setPSModelFieldId(null);
            this.update(pSSysModelFunc2);
        }
    }

    public void removeByPSModelField(PSModelField pSModelField) throws Exception {
        final PSModelField pSModelField2 = pSModelField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelFuncServiceBase.this.onBeforeRemoveByPSModelField(pSModelField2);
                PSSysModelFuncServiceBase.this.internalRemoveByPSModelField(pSModelField2);
                PSSysModelFuncServiceBase.this.onAfterRemoveByPSModelField(pSModelField2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelField(PSModelField pSModelField) throws Exception {
    }

    protected void internalRemoveByPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModelField(pSModelField);
        this.onBeforeRemoveByPSModelField(pSModelField, arrayList);
        for (PSSysModelFunc pSSysModelFunc : arrayList) {
            this.remove((IEntity)pSSysModelFunc);
        }
        this.onAfterRemoveByPSModelField(pSModelField, arrayList);
    }

    protected void onAfterRemoveByPSModelField(PSModelField pSModelField) throws Exception {
    }

    protected void onBeforeRemoveByPSModelField(PSModelField pSModelField, ArrayList<PSSysModelFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelField(PSModelField pSModelField, ArrayList<PSSysModelFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELFUNC_PSMODEL_PSMODELID", "", iDataEntityModel.getName(), "PSSYSMODELFUNC", iDataEntityModel.getDataInfo((IEntity)pSModel), arrayList.get(0)));
        }
    }

    public void resetPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModel(pSModel);
        for (PSSysModelFunc pSSysModelFunc : arrayList) {
            PSSysModelFunc pSSysModelFunc2 = (PSSysModelFunc)this.getDEModel().createEntity();
            pSSysModelFunc2.setPSSysModelFuncId(pSSysModelFunc.getPSSysModelFuncId());
            pSSysModelFunc2.setPSModelId(null);
            this.update(pSSysModelFunc2);
        }
    }

    public void removeByPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelFuncServiceBase.this.onBeforeRemoveByPSModel(pSModel2);
                PSSysModelFuncServiceBase.this.internalRemoveByPSModel(pSModel2);
                PSSysModelFuncServiceBase.this.onAfterRemoveByPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSSysModelFunc> arrayList = this.selectByPSModel(pSModel);
        this.onBeforeRemoveByPSModel(pSModel, arrayList);
        for (PSSysModelFunc pSSysModelFunc : arrayList) {
            this.remove((IEntity)pSSysModelFunc);
        }
        this.onAfterRemoveByPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel, ArrayList<PSSysModelFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel, ArrayList<PSSysModelFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelFunc pSSysModelFunc) throws Exception {
        PSSysModelFuncTemplService pSSysModelFuncTemplService = (PSSysModelFuncTemplService)ServiceGlobal.getService(PSSysModelFuncTemplService.class, (SessionFactory)this.getSessionFactory());
        pSSysModelFuncTemplService.testRemoveByPSSysModelFunc(pSSysModelFunc);
        super.onBeforeRemove(pSSysModelFunc);
    }

    protected void replaceParentInfo(PSSysModelFunc pSSysModelFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysModelFunc, cloneSession);
        if (pSSysModelFunc.getPSModelAPIId() != null && (iEntity = cloneSession.getEntity("PSMODELAPI", (Object)pSSysModelFunc.getPSModelAPIId())) != null) {
            this.onFillParentInfo_PSModelApi(pSSysModelFunc, (PSModelAPI)iEntity);
        }
        if (pSSysModelFunc.getPSModelFieldId() != null && (iEntity = cloneSession.getEntity("PSMODELFIELD", (Object)pSSysModelFunc.getPSModelFieldId())) != null) {
            this.onFillParentInfo_PSModelField(pSSysModelFunc, (PSModelField)iEntity);
        }
        if (pSSysModelFunc.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSSysModelFunc.getPSModelId())) != null) {
            this.onFillParentInfo_PSModel(pSSysModelFunc, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysModelFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FuncDesc(bl, pSSysModelFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncSN(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIId(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldId(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldName(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFuncId(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFuncName(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysModelFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysModelFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FuncDesc(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isFuncDescDirty() : !pSSysModelFunc.isFuncDescDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getFuncDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncDesc_Default((IEntity)pSSysModelFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncSN(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isFuncSNDirty() && !bl2 : !pSSysModelFunc.isFuncSNDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getFuncSN();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCSN");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncSN_Default((IEntity)pSSysModelFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isMemoDirty() : !pSSysModelFunc.isMemoDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysModelFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isOrderValueDirty() : !pSSysModelFunc.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysModelFunc.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysModelFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelAPIId(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isPSModelAPIIdDirty() : !pSSysModelFunc.isPSModelAPIIdDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getPSModelAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIId_Default((IEntity)pSSysModelFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelFieldId(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isPSModelFieldIdDirty() : !pSSysModelFunc.isPSModelFieldIdDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getPSModelFieldId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldId_Default((IEntity)pSSysModelFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelFieldName(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isPSModelFieldNameDirty() : !pSSysModelFunc.isPSModelFieldNameDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getPSModelFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldName_Default((IEntity)pSSysModelFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isPSModelIdDirty() : !pSSysModelFunc.isPSModelIdDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default((IEntity)pSSysModelFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isPSModelNameDirty() : !pSSysModelFunc.isPSModelNameDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default((IEntity)pSSysModelFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelFuncId(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isPSSysModelFuncIdDirty() && !bl2 : !pSSysModelFunc.isPSSysModelFuncIdDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getPSSysModelFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFuncId_Default((IEntity)pSSysModelFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFuncName(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isPSSysModelFuncNameDirty() && !bl2 : !pSSysModelFunc.isPSSysModelFuncNameDirty()) {
            return null;
        }
        String string = pSSysModelFunc.getPSSysModelFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFuncName_Default((IEntity)pSSysModelFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysModelFunc pSSysModelFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFunc.isValidFlagDirty() && !bl2 : !pSSysModelFunc.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelFunc.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysModelFunc, bl2, bl3);
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

    protected void onSyncEntity(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysModelFunc, bl);
    }

    protected void onSyncIndexEntities(PSSysModelFunc pSSysModelFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysModelFunc, bl);
    }

    public Object getDataContextValue(PSSysModelFunc pSSysModelFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysModelFunc, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelFunc pSSysModelFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysModelFunc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncSN_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSMODELAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFuncName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FuncDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSModelFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysModelFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysModelFunc pSSysModelFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysModelFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelFunc pSSysModelFunc) throws Exception {
        super.onUpdateParent((IEntity)pSSysModelFunc);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelFunc pSSysModelFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELFUNC");
        if (!bl) {
            pSSysModelFunc.setCreateDate(null);
            pSSysModelFunc.setCreateMan(null);
            pSSysModelFunc.setPSModelAPIName(null);
            pSSysModelFunc.setPSSysModelFuncId(null);
            pSSysModelFunc.setUpdateDate(null);
            pSSysModelFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelFunc, xmlNode, bl);
        }
    }
}

