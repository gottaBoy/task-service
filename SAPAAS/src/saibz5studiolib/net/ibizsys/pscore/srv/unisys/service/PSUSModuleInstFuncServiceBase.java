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
import net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstFuncDAO;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstFuncDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstBase;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstFunc;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstFuncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSModuleInstFuncServiceBase
extends PSCoreSysServiceBase<PSUSModuleInstFunc> {
    private static final Log log = LogFactory.getLog(PSUSModuleInstFuncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUSModuleInstFuncDEModel pSUSModuleInstFuncDEModel;
    private PSUSModuleInstFuncDAO pSUSModuleInstFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstFuncService";
    }

    public PSUSModuleInstFuncDEModel getPSUSModuleInstFuncDEModel() {
        if (this.pSUSModuleInstFuncDEModel == null) {
            try {
                this.pSUSModuleInstFuncDEModel = (PSUSModuleInstFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUSModuleInstFuncDEModel();
    }

    public PSUSModuleInstFuncDAO getPSUSModuleInstFuncDAO() {
        if (this.pSUSModuleInstFuncDAO == null) {
            try {
                this.pSUSModuleInstFuncDAO = (PSUSModuleInstFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUSModuleInstFuncDAO();
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

    protected void onFillParentInfo(PSUSModuleInstFunc pSUSModuleInstFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSMODULEINSTFUNC_PSUSMODULEINST_PSUSMODULEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService", (SessionFactory)this.getSessionFactory());
            PSUSModuleInst pSUSModuleInst = (PSUSModuleInst)iService.getDEModel().createEntity();
            pSUSModuleInst.set("PSUSMODULEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSModuleInst);
            } else {
                iService.get((IEntity)pSUSModuleInst);
            }
            this.onFillParentInfo_PSUSModuleInst(pSUSModuleInstFunc, pSUSModuleInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSUSModuleInstFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUSModuleInst(PSUSModuleInstFunc pSUSModuleInstFunc, PSUSModuleInst pSUSModuleInst) throws Exception {
        pSUSModuleInstFunc.setPSUSModuleInstId(pSUSModuleInst.getPSUSModuleInstId());
        pSUSModuleInstFunc.setPSUSModuleInstName(pSUSModuleInst.getPSUSModuleInstName());
    }

    protected void onFillEntityFullInfo(PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSUSModuleInstFunc, bl);
        this.onFillEntityFullInfo_PSUSModuleInst(pSUSModuleInstFunc, bl);
    }

    protected void onFillEntityFullInfo_PSUSModuleInst(PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUSModuleInstFunc, bl);
    }

    public ArrayList<PSUSModuleInstFunc> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase) throws Exception {
        return this.selectByPSUSModuleInst(pSUSModuleInstBase, "", -1);
    }

    public ArrayList<PSUSModuleInstFunc> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string) throws Exception {
        return this.selectByPSUSModuleInst(pSUSModuleInstBase, string, -1);
    }

    public ArrayList<PSUSModuleInstFunc> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSMODULEINSTID", (Object)pSUSModuleInstBase.getPSUSModuleInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSModuleInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSModuleInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstFunc> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSMODULEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSModuleInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSMODULEINSTFUNC_PSUSMODULEINST_PSUSMODULEINSTID", "", iDataEntityModel.getName(), "PSUSMODULEINSTFUNC", iDataEntityModel.getDataInfo((IEntity)pSUSModuleInst), arrayList.get(0)));
        }
    }

    public void resetPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstFunc> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst);
        for (PSUSModuleInstFunc pSUSModuleInstFunc : arrayList) {
            PSUSModuleInstFunc pSUSModuleInstFunc2 = (PSUSModuleInstFunc)this.getDEModel().createEntity();
            pSUSModuleInstFunc2.setPSUSModuleInstFuncId(pSUSModuleInstFunc.getPSUSModuleInstFuncId());
            pSUSModuleInstFunc2.setPSUSModuleInstId(null);
            this.update(pSUSModuleInstFunc2);
        }
    }

    public void removeByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        final PSUSModuleInst pSUSModuleInst2 = pSUSModuleInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSModuleInstFuncServiceBase.this.onBeforeRemoveByPSUSModuleInst(pSUSModuleInst2);
                PSUSModuleInstFuncServiceBase.this.internalRemoveByPSUSModuleInst(pSUSModuleInst2);
                PSUSModuleInstFuncServiceBase.this.onAfterRemoveByPSUSModuleInst(pSUSModuleInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void internalRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstFunc> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst);
        this.onBeforeRemoveByPSUSModuleInst(pSUSModuleInst, arrayList);
        for (PSUSModuleInstFunc pSUSModuleInstFunc : arrayList) {
            this.remove((IEntity)pSUSModuleInstFunc);
        }
        this.onAfterRemoveByPSUSModuleInst(pSUSModuleInst, arrayList);
    }

    protected void onAfterRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void onBeforeRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSModuleInstFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSModuleInstFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        PSUSDCModuleInstFuncService pSUSDCModuleInstFuncService = (PSUSDCModuleInstFuncService)ServiceGlobal.getService(PSUSDCModuleInstFuncService.class, (SessionFactory)this.getSessionFactory());
        pSUSDCModuleInstFuncService.testRemoveByPSUSModuleInstFunc(pSUSModuleInstFunc);
        super.onBeforeRemove(pSUSModuleInstFunc);
    }

    protected void replaceParentInfo(PSUSModuleInstFunc pSUSModuleInstFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSUSModuleInstFunc, cloneSession);
        if (pSUSModuleInstFunc.getPSUSModuleInstId() != null && (iEntity = cloneSession.getEntity("PSUSMODULEINST", (Object)pSUSModuleInstFunc.getPSUSModuleInstId())) != null) {
            this.onFillParentInfo_PSUSModuleInst(pSUSModuleInstFunc, (PSUSModuleInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUSModuleInstFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FuncTag(bl, pSUSModuleInstFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncType(bl, pSUSModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSUSModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobileAppFlag(bl, pSUSModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstFuncId(bl, pSUSModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstFuncName(bl, pSUSModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstId(bl, pSUSModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Url(bl, pSUSModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUSModuleInstFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FuncTag(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isFuncTagDirty() : !pSUSModuleInstFunc.isFuncTagDirty()) {
            return null;
        }
        String string = pSUSModuleInstFunc.getFuncTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncTag_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncType(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isFuncTypeDirty() && !bl2 : !pSUSModuleInstFunc.isFuncTypeDirty()) {
            return null;
        }
        String string = pSUSModuleInstFunc.getFuncType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncType_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isMemoDirty() : !pSUSModuleInstFunc.isMemoDirty()) {
            return null;
        }
        String string = pSUSModuleInstFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobileAppFlag(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isMobileAppFlagDirty() : !pSUSModuleInstFunc.isMobileAppFlagDirty()) {
            return null;
        }
        Integer n = pSUSModuleInstFunc.getMobileAppFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobileAppFlag_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBILEAPPFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstFuncId(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isPSUSModuleInstFuncIdDirty() && !bl2 : !pSUSModuleInstFunc.isPSUSModuleInstFuncIdDirty()) {
            return null;
        }
        String string = pSUSModuleInstFunc.getPSUSModuleInstFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstFuncId_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstFuncName(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isPSUSModuleInstFuncNameDirty() && !bl2 : !pSUSModuleInstFunc.isPSUSModuleInstFuncNameDirty()) {
            return null;
        }
        String string = pSUSModuleInstFunc.getPSUSModuleInstFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstFuncName_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstId(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isPSUSModuleInstIdDirty() : !pSUSModuleInstFunc.isPSUSModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSModuleInstFunc.getPSUSModuleInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstId_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_Url(boolean bl, PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstFunc.isUrlDirty() : !pSUSModuleInstFunc.isUrlDirty()) {
            return null;
        }
        String string = pSUSModuleInstFunc.getUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Url_Default((IEntity)pSUSModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("URL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUSModuleInstFunc, bl);
    }

    protected void onSyncIndexEntities(PSUSModuleInstFunc pSUSModuleInstFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUSModuleInstFunc, bl);
    }

    public Object getDataContextValue(PSUSModuleInstFunc pSUSModuleInstFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUSModuleInstFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSUSModuleInst pSUSModuleInst = pSUSModuleInstFunc.getPSUSModuleInst();
        if (pSUSModuleInst != null && pSUSModuleInst.contains(string)) {
            return pSUSModuleInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUSModuleInstFunc pSUSModuleInstFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUSModuleInstFunc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBILEAPPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobileAppFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"URL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Url_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FuncTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_MobileAppFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSUSModuleInstFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_Url_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("URL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUSModuleInstFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        super.onUpdateParent((IEntity)pSUSModuleInstFunc);
    }

    @Override
    protected void exportCurXmlModel(PSUSModuleInstFunc pSUSModuleInstFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUSMODULEINSTFUNC");
        if (!bl) {
            pSUSModuleInstFunc.setCreateDate(null);
            pSUSModuleInstFunc.setCreateMan(null);
            pSUSModuleInstFunc.setPSUSModuleInstFuncId(null);
            pSUSModuleInstFunc.setPSUSModuleInstName(null);
            pSUSModuleInstFunc.setUpdateDate(null);
            pSUSModuleInstFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSUSModuleInstFunc, xmlNode, bl);
        }
    }
}

