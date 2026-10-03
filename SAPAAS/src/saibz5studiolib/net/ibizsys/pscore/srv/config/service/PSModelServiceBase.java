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
import net.ibizsys.pscore.srv.config.dao.PSModelDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.service.PSModelAPIIntService;
import net.ibizsys.pscore.srv.config.service.PSModelAPIIntServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelErrorService;
import net.ibizsys.pscore.srv.config.service.PSModelErrorServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelFieldService;
import net.ibizsys.pscore.srv.config.service.PSModelFieldServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelHotCodeService;
import net.ibizsys.pscore.srv.config.service.PSModelHotCodeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelModuleService;
import net.ibizsys.pscore.srv.config.service.PSModelModuleServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelPluginService;
import net.ibizsys.pscore.srv.config.service.PSModelPluginServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelRSService;
import net.ibizsys.pscore.srv.config.service.PSModelRSServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.config.service.PSModelStateService;
import net.ibizsys.pscore.srv.config.service.PSModelStateServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelValueGroupService;
import net.ibizsys.pscore.srv.config.service.PSModelValueGroupServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelViewService;
import net.ibizsys.pscore.srv.config.service.PSModelViewServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSysModelFuncService;
import net.ibizsys.pscore.srv.config.service.PSSysModelFuncServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelServiceBase
extends PSCoreSysServiceBase<PSModel> {
    private static final Log log = LogFactory.getLog(PSModelServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelDEModel pSModelDEModel;
    private PSModelDAO pSModelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelService";
    }

    public PSModelDEModel getPSModelDEModel() {
        if (this.pSModelDEModel == null) {
            try {
                this.pSModelDEModel = (PSModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelDEModel();
    }

    public PSModelDAO getPSModelDAO() {
        if (this.pSModelDAO == null) {
            try {
                this.pSModelDAO = (PSModelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelDAO();
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

    protected void onFillParentInfo(PSModel pSModel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODEL_PSMODEL_PPSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel2 = (PSModel)iService.getDEModel().createEntity();
            pSModel2.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModel2);
            } else {
                iService.get(pSModel2);
            }
            this.onFillParentInfo_Ppsmodel(pSModel, pSModel2);
            return;
        }
        super.onFillParentInfo(pSModel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Ppsmodel(PSModel pSModel, PSModel pSModel2) throws Exception {
        pSModel.setPPSModelId(pSModel2.getPSModelId());
        pSModel.setPPSModelName(pSModel2.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSModel pSModel, boolean bl) throws Exception {
        if (bl) {
            if (pSModel.getModelStateFlag() == null) {
                pSModel.setModelStateFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSModel.getValidFlag() == null) {
                pSModel.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSModel, bl);
        this.onFillEntityFullInfo_Ppsmodel(pSModel, bl);
    }

    protected void onFillEntityFullInfo_Ppsmodel(PSModel pSModel, boolean bl) throws Exception {
        if (pSModel.isPPSModelIdDirty()) {
            if (pSModel.getPPSModelId() != null) {
                if (pSModel.getPPSModelId() == null || pSModel.getPPSModelName() == null) {
                    PSModel pSModel2 = pSModel.getPpsmodel();
                    pSModel.setPPSModelName(pSModel2.getPSModelName());
                }
            } else {
                pSModel.setPPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModel pSModel, boolean bl) throws Exception {
        super.onWriteBackParent(pSModel, bl);
    }

    public ArrayList<PSModel> selectByPpsmodel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPpsmodel(pSModelBase, "", -1);
    }

    public ArrayList<PSModel> selectByPpsmodel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPpsmodel(pSModelBase, string, -1);
    }

    public ArrayList<PSModel> selectByPpsmodel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPpsmodelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPpsmodelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPpsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModel> arrayList = this.selectByPpsmodel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODEL_PSMODEL_PPSMODELID", "", iDataEntityModel.getName(), "PSMODEL", iDataEntityModel.getDataInfo(pSModel), arrayList.get(0)));
        }
    }

    public void resetPpsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModel> arrayList = this.selectByPpsmodel(pSModel);
        for (PSModel pSModel2 : arrayList) {
            PSModel pSModel3 = (PSModel)this.getDEModel().createEntity();
            pSModel3.setPSModelId(pSModel2.getPSModelId());
            pSModel3.setPPSModelId(null);
            this.update(pSModel3);
        }
    }

    public void removeByPpsmodel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelServiceBase.this.onBeforeRemoveByPpsmodel(pSModel2);
                PSModelServiceBase.this.internalRemoveByPpsmodel(pSModel2);
                PSModelServiceBase.this.onAfterRemoveByPpsmodel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPpsmodel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPpsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModel> arrayList = this.selectByPpsmodel(pSModel);
        this.onBeforeRemoveByPpsmodel(pSModel, arrayList);
        for (PSModel pSModel2 : arrayList) {
            this.remove(pSModel2);
        }
        this.onAfterRemoveByPpsmodel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPpsmodel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPpsmodel(PSModel pSModel, ArrayList<PSModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPpsmodel(PSModel pSModel, ArrayList<PSModel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModel pSModel) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModelAPIIntService)ServiceGlobal.getService(PSModelAPIIntService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelAPIIntServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelErrorService)ServiceGlobal.getService(PSModelErrorService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelErrorServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelHotCodeService)ServiceGlobal.getService(PSModelHotCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelHotCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        ((PSModelHotCodeServiceBase)pSCoreSysServiceBase).removeByPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelModuleService)ServiceGlobal.getService(PSModelModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelModuleServiceBase)pSCoreSysServiceBase).testRemoveByPsmodel(pSModel);
        pSCoreSysServiceBase = (PSModelPluginService)ServiceGlobal.getService(PSModelPluginService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelPluginServiceBase)pSCoreSysServiceBase).testRemoveByPsmodel(pSModel);
        pSCoreSysServiceBase = (PSModelRSService)ServiceGlobal.getService(PSModelRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelRSServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelRSService)ServiceGlobal.getService(PSModelRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelRSServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelStateService)ServiceGlobal.getService(PSModelStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelStateServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelValueGroupService)ServiceGlobal.getService(PSModelValueGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelValueGroupServiceBase)pSCoreSysServiceBase).testRemoveByPsmodel(pSModel);
        pSCoreSysServiceBase = (PSModelViewService)ServiceGlobal.getService(PSModelViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelViewServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        pSCoreSysServiceBase = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelServiceBase)pSCoreSysServiceBase).testRemoveByPpsmodel(pSModel);
        pSCoreSysServiceBase = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFCodeTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        ((PSSFCodeTypeServiceBase)pSCoreSysServiceBase).resetPSModel(pSModel);
        pSCoreSysServiceBase = (PSSysModelFuncService)ServiceGlobal.getService(PSSysModelFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSModel(pSModel);
        super.onBeforeRemove(pSModel);
    }

    protected void replaceParentInfo(PSModel pSModel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModel, cloneSession);
        if (pSModel.getPPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModel.getPPSModelId())) != null) {
            this.onFillParentInfo_Ppsmodel(pSModel, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModel pSModel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModel, bl);
    }

    protected void onCheckEntity(boolean bl, PSModel pSModel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArticleUrl(bl, pSModel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableIBizBak(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableImport(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelCat(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelDEId(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelDesc(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelInstMode(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelStateFlag(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSModelId(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSModelName(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartErrorCode(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeField(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeValue(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArticleUrl(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isArticleUrlDirty() : !pSModel.isArticleUrlDirty()) {
            return null;
        }
        String string = pSModel.getArticleUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleUrl_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableIBizBak(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isEnableIBizBakDirty() : !pSModel.isEnableIBizBakDirty()) {
            return null;
        }
        Integer n = pSModel.getEnableIBizBak();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableIBizBak_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEIBIZBAK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableImport(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isEnableImportDirty() : !pSModel.isEnableImportDirty()) {
            return null;
        }
        Integer n = pSModel.getEnableImport();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableImport_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEIMPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isMemoDirty() : !pSModel.isMemoDirty()) {
            return null;
        }
        String string = pSModel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelCat(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isModelCatDirty() : !pSModel.isModelCatDirty()) {
            return null;
        }
        String string = pSModel.getModelCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelCat_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelDEId(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isModelDEIdDirty() : !pSModel.isModelDEIdDirty()) {
            return null;
        }
        String string = pSModel.getModelDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelDEId_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelDesc(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isModelDescDirty() : !pSModel.isModelDescDirty()) {
            return null;
        }
        String string = pSModel.getModelDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelDesc_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelInstMode(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isModelInstModeDirty() : !pSModel.isModelInstModeDirty()) {
            return null;
        }
        Integer n = pSModel.getModelInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelInstMode_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELINSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelStateFlag(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isModelStateFlagDirty() : !pSModel.isModelStateFlagDirty()) {
            return null;
        }
        Integer n = pSModel.getModelStateFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelStateFlag_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSTATEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSModelId(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isPPSModelIdDirty() : !pSModel.isPPSModelIdDirty()) {
            return null;
        }
        String string = pSModel.getPPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSModelId_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSModelName(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isPPSModelNameDirty() : !pSModel.isPPSModelNameDirty()) {
            return null;
        }
        String string = pSModel.getPPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSModelName_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isPSModelIdDirty() && !bl2 : !pSModel.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModel.getPSModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isPSModelNameDirty() && !bl2 : !pSModel.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModel.getPSModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default(pSModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_StartErrorCode(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isStartErrorCodeDirty() : !pSModel.isStartErrorCodeDirty()) {
            return null;
        }
        Integer n = pSModel.getStartErrorCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StartErrorCode_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTERRORCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeField(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isTypeFieldDirty() : !pSModel.isTypeFieldDirty()) {
            return null;
        }
        String string = pSModel.getTypeField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeField_Default(pSModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isTypeObjDirty() : !pSModel.isTypeObjDirty()) {
            return null;
        }
        String string = pSModel.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeValue(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isTypeValueDirty() : !pSModel.isTypeValueDirty()) {
            return null;
        }
        String string = pSModel.getTypeValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeValue_Default(pSModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModel pSModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModel.isValidFlagDirty() && !bl2 : !pSModel.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModel.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModel, bl2, bl3);
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

    protected void onSyncEntity(PSModel pSModel, boolean bl) throws Exception {
        super.onSyncEntity(pSModel, bl);
    }

    protected void onSyncIndexEntities(PSModel pSModel, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModel, bl);
    }

    public Object getDataContextValue(PSModel pSModel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModel, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModel pSModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARTICLEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEIBIZBAK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableIBizBak_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEIMPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableImport_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELINSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelInstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelStateFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTERRORCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartErrorCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeValue_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ArticleUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_EnableIBizBak_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableImport_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ModelCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELCAT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELDEID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelInstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ModelStateFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_StartErrorCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TypeField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEFIELD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSModel pSModel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModel pSModel) throws Exception {
        super.onUpdateParent(pSModel);
    }

    @Override
    protected void exportCurXmlModel(PSModel pSModel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODEL");
        if (!bl) {
            pSModel.setCreateDate(null);
            pSModel.setCreateMan(null);
            pSModel.setUpdateDate(null);
            pSModel.setUpdateMan(null);
            super.exportCurXmlModel(pSModel, xmlNode, bl);
        }
    }
}

