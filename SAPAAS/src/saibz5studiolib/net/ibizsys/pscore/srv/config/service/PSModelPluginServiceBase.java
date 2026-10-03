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
import net.ibizsys.pscore.srv.config.dao.PSModelPluginDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelPluginDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelPlugin;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelPluginServiceBase
extends PSCoreSysServiceBase<PSModelPlugin> {
    private static final Log log = LogFactory.getLog(PSModelPluginServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelPluginDEModel pSModelPluginDEModel;
    private PSModelPluginDAO pSModelPluginDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelPluginService";
    }

    public PSModelPluginDEModel getPSModelPluginDEModel() {
        if (this.pSModelPluginDEModel == null) {
            try {
                this.pSModelPluginDEModel = (PSModelPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelPluginDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelPluginDEModel();
    }

    public PSModelPluginDAO getPSModelPluginDAO() {
        if (this.pSModelPluginDAO == null) {
            try {
                this.pSModelPluginDAO = (PSModelPluginDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelPluginDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelPluginDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelPluginDAO();
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

    protected void onFillParentInfo(PSModelPlugin pSModelPlugin, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELPLUGIN_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModel);
            } else {
                iService.get(pSModel);
            }
            this.onFillParentInfo_Psmodel(pSModelPlugin, pSModel);
            return;
        }
        super.onFillParentInfo(pSModelPlugin, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psmodel(PSModelPlugin pSModelPlugin, PSModel pSModel) throws Exception {
        pSModelPlugin.setPSModelId(pSModel.getPSModelId());
        pSModelPlugin.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSModelPlugin pSModelPlugin, boolean bl) throws Exception {
        if (bl && pSModelPlugin.getValidFlag() == null) {
            pSModelPlugin.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSModelPlugin, bl);
        this.onFillEntityFullInfo_Psmodel(pSModelPlugin, bl);
    }

    protected void onFillEntityFullInfo_Psmodel(PSModelPlugin pSModelPlugin, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelPlugin pSModelPlugin, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelPlugin, bl);
    }

    public ArrayList<PSModelPlugin> selectByPsmodel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPsmodel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelPlugin> selectByPsmodel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPsmodel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelPlugin> selectByPsmodel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsmodelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsmodelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelPlugin> arrayList = this.selectByPsmodel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELPLUGIN_PSMODEL_PSMODELID", "", iDataEntityModel.getName(), "PSMODELPLUGIN", iDataEntityModel.getDataInfo(pSModel), arrayList.get(0)));
        }
    }

    public void resetPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelPlugin> arrayList = this.selectByPsmodel(pSModel);
        for (PSModelPlugin pSModelPlugin : arrayList) {
            PSModelPlugin pSModelPlugin2 = (PSModelPlugin)this.getDEModel().createEntity();
            pSModelPlugin2.setPSModelPluginId(pSModelPlugin.getPSModelPluginId());
            pSModelPlugin2.setPSModelId(null);
            this.update(pSModelPlugin2);
        }
    }

    public void removeByPsmodel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelPluginServiceBase.this.onBeforeRemoveByPsmodel(pSModel2);
                PSModelPluginServiceBase.this.internalRemoveByPsmodel(pSModel2);
                PSModelPluginServiceBase.this.onAfterRemoveByPsmodel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPsmodel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelPlugin> arrayList = this.selectByPsmodel(pSModel);
        this.onBeforeRemoveByPsmodel(pSModel, arrayList);
        for (PSModelPlugin pSModelPlugin : arrayList) {
            this.remove(pSModelPlugin);
        }
        this.onAfterRemoveByPsmodel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPsmodel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPsmodel(PSModel pSModel, ArrayList<PSModelPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsmodel(PSModel pSModel, ArrayList<PSModelPlugin> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelPlugin pSModelPlugin) throws Exception {
        super.onBeforeRemove(pSModelPlugin);
    }

    protected void replaceParentInfo(PSModelPlugin pSModelPlugin, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelPlugin, cloneSession);
        if (pSModelPlugin.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelPlugin.getPSModelId())) != null) {
            this.onFillParentInfo_Psmodel(pSModelPlugin, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelPlugin pSModelPlugin, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelPlugin, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DiffObj(bl, pSModelPlugin, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JSCode(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginParams(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginType(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelPluginId(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelPluginName(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelPlugin, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DiffObj(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isDiffObjDirty() : !pSModelPlugin.isDiffObjDirty()) {
            return null;
        }
        String string = pSModelPlugin.getDiffObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DiffObj_Default(pSModelPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DIFFOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JSCode(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isJSCodeDirty() : !pSModelPlugin.isJSCodeDirty()) {
            return null;
        }
        String string = pSModelPlugin.getJSCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JSCode_Default(pSModelPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isMemoDirty() : !pSModelPlugin.isMemoDirty()) {
            return null;
        }
        String string = pSModelPlugin.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PluginParams(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isPluginParamsDirty() : !pSModelPlugin.isPluginParamsDirty()) {
            return null;
        }
        String string = pSModelPlugin.getPluginParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginParams_Default(pSModelPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginType(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isPluginTypeDirty() && !bl2 : !pSModelPlugin.isPluginTypeDirty()) {
            return null;
        }
        String string = pSModelPlugin.getPluginType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginType_Default(pSModelPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isPSModelIdDirty() : !pSModelPlugin.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelPlugin.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSModelPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelPluginId(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isPSModelPluginIdDirty() && !bl2 : !pSModelPlugin.isPSModelPluginIdDirty()) {
            return null;
        }
        String string = pSModelPlugin.getPSModelPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelPluginId_Default(pSModelPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelPluginName(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isPSModelPluginNameDirty() && !bl2 : !pSModelPlugin.isPSModelPluginNameDirty()) {
            return null;
        }
        String string = pSModelPlugin.getPSModelPluginName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELPLUGINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelPluginName_Default(pSModelPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELPLUGINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelPlugin pSModelPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelPlugin.isValidFlagDirty() && !bl2 : !pSModelPlugin.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelPlugin.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModelPlugin, bl2, bl3);
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

    protected void onSyncEntity(PSModelPlugin pSModelPlugin, boolean bl) throws Exception {
        super.onSyncEntity(pSModelPlugin, bl);
    }

    protected void onSyncIndexEntities(PSModelPlugin pSModelPlugin, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelPlugin, bl);
    }

    public Object getDataContextValue(PSModelPlugin pSModelPlugin, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelPlugin, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelPlugin pSModelPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelPlugin, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DIFFOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DiffObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JSCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelPluginName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DiffObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DIFFOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JSCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PluginParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_PSModelPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelPlugin pSModelPlugin) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelPlugin)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelPlugin pSModelPlugin) throws Exception {
        super.onUpdateParent(pSModelPlugin);
    }

    @Override
    protected void exportCurXmlModel(PSModelPlugin pSModelPlugin, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELPLUGIN");
        if (!bl) {
            pSModelPlugin.setCreateDate(null);
            pSModelPlugin.setCreateMan(null);
            pSModelPlugin.setUpdateDate(null);
            pSModelPlugin.setUpdateMan(null);
            super.exportCurXmlModel(pSModelPlugin, xmlNode, bl);
        }
    }
}

