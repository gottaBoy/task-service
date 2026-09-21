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
package net.ibizsys.pscore.srv.unisys.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstDAO;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModule;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleBase;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstServiceBase;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstFuncService;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstFuncServiceBase;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstRefService;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstRefServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSModuleInstServiceBase
extends PSCoreSysServiceBase<PSUSModuleInst> {
    private static final Log log = LogFactory.getLog(PSUSModuleInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUSModuleInstDEModel pSUSModuleInstDEModel;
    private PSUSModuleInstDAO pSUSModuleInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService";
    }

    public PSUSModuleInstDEModel getPSUSModuleInstDEModel() {
        if (this.pSUSModuleInstDEModel == null) {
            try {
                this.pSUSModuleInstDEModel = (PSUSModuleInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUSModuleInstDEModel();
    }

    public PSUSModuleInstDAO getPSUSModuleInstDAO() {
        if (this.pSUSModuleInstDAO == null) {
            try {
                this.pSUSModuleInstDAO = (PSUSModuleInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUSModuleInstDAO();
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

    protected void onFillParentInfo(PSUSModuleInst pSUSModuleInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSMODULEINST_PSUSMODULE_PSUSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleService", (SessionFactory)this.getSessionFactory());
            PSUSModule pSUSModule = (PSUSModule)iService.getDEModel().createEntity();
            pSUSModule.set("PSUSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSModule);
            } else {
                iService.get((IEntity)pSUSModule);
            }
            this.onFillParentInfo_PSUSModule(pSUSModuleInst, pSUSModule);
            return;
        }
        super.onFillParentInfo((IEntity)pSUSModuleInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUSModule(PSUSModuleInst pSUSModuleInst, PSUSModule pSUSModule) throws Exception {
        pSUSModuleInst.setPSUSModuleId(pSUSModule.getPSUSModuleId());
        pSUSModuleInst.setPSUSModuleName(pSUSModule.getPSUSModuleName());
    }

    protected void onFillEntityFullInfo(PSUSModuleInst pSUSModuleInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSUSModuleInst, bl);
        this.onFillEntityFullInfo_PSUSModule(pSUSModuleInst, bl);
    }

    protected void onFillEntityFullInfo_PSUSModule(PSUSModuleInst pSUSModuleInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUSModuleInst pSUSModuleInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUSModuleInst, bl);
    }

    public ArrayList<PSUSModuleInst> selectByPSUSModule(PSUSModuleBase pSUSModuleBase) throws Exception {
        return this.selectByPSUSModule(pSUSModuleBase, "", -1);
    }

    public ArrayList<PSUSModuleInst> selectByPSUSModule(PSUSModuleBase pSUSModuleBase, String string) throws Exception {
        return this.selectByPSUSModule(pSUSModuleBase, string, -1);
    }

    public ArrayList<PSUSModuleInst> selectByPSUSModule(PSUSModuleBase pSUSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSMODULEID", (Object)pSUSModuleBase.getPSUSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSModuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUSModule(PSUSModule pSUSModule) throws Exception {
        ArrayList<PSUSModuleInst> arrayList = this.selectByPSUSModule(pSUSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSMODULEINST_PSUSMODULE_PSUSMODULEID", "", iDataEntityModel.getName(), "PSUSMODULEINST", iDataEntityModel.getDataInfo((IEntity)pSUSModule), arrayList.get(0)));
        }
    }

    public void resetPSUSModule(PSUSModule pSUSModule) throws Exception {
        ArrayList<PSUSModuleInst> arrayList = this.selectByPSUSModule(pSUSModule);
        for (PSUSModuleInst pSUSModuleInst : arrayList) {
            PSUSModuleInst pSUSModuleInst2 = (PSUSModuleInst)this.getDEModel().createEntity();
            pSUSModuleInst2.setPSUSModuleInstId(pSUSModuleInst.getPSUSModuleInstId());
            pSUSModuleInst2.setPSUSModuleId(null);
            this.update(pSUSModuleInst2);
        }
    }

    public void removeByPSUSModule(PSUSModule pSUSModule) throws Exception {
        final PSUSModule pSUSModule2 = pSUSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSModuleInstServiceBase.this.onBeforeRemoveByPSUSModule(pSUSModule2);
                PSUSModuleInstServiceBase.this.internalRemoveByPSUSModule(pSUSModule2);
                PSUSModuleInstServiceBase.this.onAfterRemoveByPSUSModule(pSUSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSModule(PSUSModule pSUSModule) throws Exception {
    }

    protected void internalRemoveByPSUSModule(PSUSModule pSUSModule) throws Exception {
        ArrayList<PSUSModuleInst> arrayList = this.selectByPSUSModule(pSUSModule);
        this.onBeforeRemoveByPSUSModule(pSUSModule, arrayList);
        for (PSUSModuleInst pSUSModuleInst : arrayList) {
            this.remove((IEntity)pSUSModuleInst);
        }
        this.onAfterRemoveByPSUSModule(pSUSModule, arrayList);
    }

    protected void onAfterRemoveByPSUSModule(PSUSModule pSUSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSUSModule(PSUSModule pSUSModule, ArrayList<PSUSModuleInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSModule(PSUSModule pSUSModule, ArrayList<PSUSModuleInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUSModuleInst pSUSModuleInst) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSUSDCModuleInstService)ServiceGlobal.getService(PSUSDCModuleInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSDCModuleInstServiceBase)pSCoreSysServiceBase).testRemoveByPSUSModuleInst(pSUSModuleInst);
        pSCoreSysServiceBase = (PSUSModuleInstFuncService)ServiceGlobal.getService(PSUSModuleInstFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSModuleInstFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSUSModuleInst(pSUSModuleInst);
        pSCoreSysServiceBase = (PSUSModuleInstRefService)ServiceGlobal.getService(PSUSModuleInstRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSModuleInstRefServiceBase)pSCoreSysServiceBase).testRemoveByPSUSModuleInst(pSUSModuleInst);
        pSCoreSysServiceBase = (PSUSModuleInstRefService)ServiceGlobal.getService(PSUSModuleInstRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSModuleInstRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSUSModuleInst(pSUSModuleInst);
        super.onBeforeRemove(pSUSModuleInst);
    }

    protected void replaceParentInfo(PSUSModuleInst pSUSModuleInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSUSModuleInst, cloneSession);
        if (pSUSModuleInst.getPSUSModuleId() != null && (iEntity = cloneSession.getEntity("PSUSMODULE", (Object)pSUSModuleInst.getPSUSModuleId())) != null) {
            this.onFillParentInfo_PSUSModule(pSUSModuleInst, (PSUSModule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUSModuleInst pSUSModuleInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUSModuleInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminServiceUrl(bl, pSUSModuleInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminUrl(bl, pSUSModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSUSModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleId(bl, pSUSModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstId(bl, pSUSModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstName(bl, pSUSModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSUSModuleInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUSModuleInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminServiceUrl(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInst.isAdminServiceUrlDirty() : !pSUSModuleInst.isAdminServiceUrlDirty()) {
            return null;
        }
        String string = pSUSModuleInst.getAdminServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminServiceUrl_Default((IEntity)pSUSModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AdminUrl(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInst.isAdminUrlDirty() : !pSUSModuleInst.isAdminUrlDirty()) {
            return null;
        }
        String string = pSUSModuleInst.getAdminUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminUrl_Default((IEntity)pSUSModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInst.isMemoDirty() : !pSUSModuleInst.isMemoDirty()) {
            return null;
        }
        String string = pSUSModuleInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSUSModuleInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUSModuleId(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInst.isPSUSModuleIdDirty() : !pSUSModuleInst.isPSUSModuleIdDirty()) {
            return null;
        }
        String string = pSUSModuleInst.getPSUSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleId_Default((IEntity)pSUSModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstId(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInst.isPSUSModuleInstIdDirty() && !bl2 : !pSUSModuleInst.isPSUSModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSModuleInst.getPSUSModuleInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstId_Default((IEntity)pSUSModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstName(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInst.isPSUSModuleInstNameDirty() && !bl2 : !pSUSModuleInst.isPSUSModuleInstNameDirty()) {
            return null;
        }
        String string = pSUSModuleInst.getPSUSModuleInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstName_Default((IEntity)pSUSModuleInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSUSModuleInst pSUSModuleInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInst.isValidFlagDirty() && !bl2 : !pSUSModuleInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSUSModuleInst.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSUSModuleInst, bl2, bl3);
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

    protected void onSyncEntity(PSUSModuleInst pSUSModuleInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUSModuleInst, bl);
    }

    protected void onSyncIndexEntities(PSUSModuleInst pSUSModuleInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUSModuleInst, bl);
    }

    public Object getDataContextValue(PSUSModuleInst pSUSModuleInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUSModuleInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSUSModule pSUSModule = pSUSModuleInst.getPSUSModule();
        if (pSUSModule != null && pSUSModule.contains(string)) {
            return pSUSModule.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUSModuleInst pSUSModuleInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUSModuleInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AdminServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINSERVICEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected String onTestValueRule_PSUSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSUSModuleInst pSUSModuleInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUSModuleInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUSModuleInst pSUSModuleInst) throws Exception {
        super.onUpdateParent((IEntity)pSUSModuleInst);
    }

    @Override
    protected void exportCurXmlModel(PSUSModuleInst pSUSModuleInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUSMODULEINST");
        if (!bl) {
            pSUSModuleInst.setCreateDate(null);
            pSUSModuleInst.setCreateMan(null);
            pSUSModuleInst.setPSUSModuleInstId(null);
            pSUSModuleInst.setPSUSModuleName(null);
            pSUSModuleInst.setUpdateDate(null);
            pSUSModuleInst.setUpdateMan(null);
            super.exportCurXmlModel(pSUSModuleInst, xmlNode, bl);
        }
    }
}

