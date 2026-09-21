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
import net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstFuncDAO;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstFuncDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstBase;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstFunc;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstFunc;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstFuncBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCModuleInstFuncServiceBase
extends PSCoreSysServiceBase<PSUSDCModuleInstFunc> {
    private static final Log log = LogFactory.getLog(PSUSDCModuleInstFuncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUSDCModuleInstFuncDEModel pSUSDCModuleInstFuncDEModel;
    private PSUSDCModuleInstFuncDAO pSUSDCModuleInstFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstFuncService";
    }

    public PSUSDCModuleInstFuncDEModel getPSUSDCModuleInstFuncDEModel() {
        if (this.pSUSDCModuleInstFuncDEModel == null) {
            try {
                this.pSUSDCModuleInstFuncDEModel = (PSUSDCModuleInstFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUSDCModuleInstFuncDEModel();
    }

    public PSUSDCModuleInstFuncDAO getPSUSDCModuleInstFuncDAO() {
        if (this.pSUSDCModuleInstFuncDAO == null) {
            try {
                this.pSUSDCModuleInstFuncDAO = (PSUSDCModuleInstFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUSDCModuleInstFuncDAO();
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

    protected void onFillParentInfo(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINSTFUNC_PSUSDCMODULEINST_PSUSDCMODULEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService", (SessionFactory)this.getSessionFactory());
            PSUSDCModuleInst pSUSDCModuleInst = (PSUSDCModuleInst)iService.getDEModel().createEntity();
            pSUSDCModuleInst.set("PSUSDCMODULEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSDCModuleInst);
            } else {
                iService.get((IEntity)pSUSDCModuleInst);
            }
            this.onFillParentInfo_PSUSDCModuleInst(pSUSDCModuleInstFunc, pSUSDCModuleInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINSTFUNC_PSUSMODULEINSTFUNC_PSUSMODULEINSTFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstFuncService", (SessionFactory)this.getSessionFactory());
            PSUSModuleInstFunc pSUSModuleInstFunc = (PSUSModuleInstFunc)iService.getDEModel().createEntity();
            pSUSModuleInstFunc.set("PSUSMODULEINSTFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSModuleInstFunc);
            } else {
                iService.get((IEntity)pSUSModuleInstFunc);
            }
            this.onFillParentInfo_PSUSModuleInstFunc(pSUSDCModuleInstFunc, pSUSModuleInstFunc);
            return;
        }
        super.onFillParentInfo((IEntity)pSUSDCModuleInstFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUSDCModuleInst(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        pSUSDCModuleInstFunc.setPSUSDCModuleInstId(pSUSDCModuleInst.getPSUSDCModuleInstId());
        pSUSDCModuleInstFunc.setPSUSDCModuleInstName(pSUSDCModuleInst.getPSUSDCModuleInstName());
    }

    protected void onFillParentInfo_PSUSModuleInstFunc(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        pSUSDCModuleInstFunc.setPSUSModuleInstFuncId(pSUSModuleInstFunc.getPSUSModuleInstFuncId());
        pSUSDCModuleInstFunc.setPSUSModuleInstFuncName(pSUSModuleInstFunc.getPSUSModuleInstFuncName());
    }

    protected void onFillEntityFullInfo(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSUSDCModuleInstFunc, bl);
        this.onFillEntityFullInfo_PSUSDCModuleInst(pSUSDCModuleInstFunc, bl);
        this.onFillEntityFullInfo_PSUSModuleInstFunc(pSUSDCModuleInstFunc, bl);
    }

    protected void onFillEntityFullInfo_PSUSDCModuleInst(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSUSModuleInstFunc(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUSDCModuleInstFunc, bl);
    }

    public ArrayList<PSUSDCModuleInstFunc> selectByPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase) throws Exception {
        return this.selectByPSUSDCModuleInst(pSUSDCModuleInstBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInstFunc> selectByPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase, String string) throws Exception {
        return this.selectByPSUSDCModuleInst(pSUSDCModuleInstBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInstFunc> selectByPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSDCMODULEINSTID", (Object)pSUSDCModuleInstBase.getPSUSDCModuleInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSDCModuleInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSDCModuleInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSUSDCModuleInstFunc> selectByPSUSModuleInstFunc(PSUSModuleInstFuncBase pSUSModuleInstFuncBase) throws Exception {
        return this.selectByPSUSModuleInstFunc(pSUSModuleInstFuncBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInstFunc> selectByPSUSModuleInstFunc(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, String string) throws Exception {
        return this.selectByPSUSModuleInstFunc(pSUSModuleInstFuncBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInstFunc> selectByPSUSModuleInstFunc(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSMODULEINSTFUNCID", (Object)pSUSModuleInstFuncBase.getPSUSModuleInstFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSModuleInstFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSModuleInstFuncCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstFunc> arrayList = this.selectByPSUSDCModuleInst(pSUSDCModuleInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSDCMODULEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSDCModuleInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINSTFUNC_PSUSDCMODULEINST_PSUSDCMODULEINSTID", "", iDataEntityModel.getName(), "PSUSDCMODULEINSTFUNC", iDataEntityModel.getDataInfo((IEntity)pSUSDCModuleInst), arrayList.get(0)));
        }
    }

    public void resetPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstFunc> arrayList = this.selectByPSUSDCModuleInst(pSUSDCModuleInst);
        for (PSUSDCModuleInstFunc pSUSDCModuleInstFunc : arrayList) {
            PSUSDCModuleInstFunc pSUSDCModuleInstFunc2 = (PSUSDCModuleInstFunc)this.getDEModel().createEntity();
            pSUSDCModuleInstFunc2.setPSUSDCModuleInstFuncId(pSUSDCModuleInstFunc.getPSUSDCModuleInstFuncId());
            pSUSDCModuleInstFunc2.setPSUSDCModuleInstId(null);
            this.update(pSUSDCModuleInstFunc2);
        }
    }

    public void removeByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        final PSUSDCModuleInst pSUSDCModuleInst2 = pSUSDCModuleInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstFuncServiceBase.this.onBeforeRemoveByPSUSDCModuleInst(pSUSDCModuleInst2);
                PSUSDCModuleInstFuncServiceBase.this.internalRemoveByPSUSDCModuleInst(pSUSDCModuleInst2);
                PSUSDCModuleInstFuncServiceBase.this.onAfterRemoveByPSUSDCModuleInst(pSUSDCModuleInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
    }

    protected void internalRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstFunc> arrayList = this.selectByPSUSDCModuleInst(pSUSDCModuleInst);
        this.onBeforeRemoveByPSUSDCModuleInst(pSUSDCModuleInst, arrayList);
        for (PSUSDCModuleInstFunc pSUSDCModuleInstFunc : arrayList) {
            this.remove((IEntity)pSUSDCModuleInstFunc);
        }
        this.onAfterRemoveByPSUSDCModuleInst(pSUSDCModuleInst, arrayList);
    }

    protected void onAfterRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
    }

    protected void onBeforeRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst, ArrayList<PSUSDCModuleInstFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst, ArrayList<PSUSDCModuleInstFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        ArrayList<PSUSDCModuleInstFunc> arrayList = this.selectByPSUSModuleInstFunc(pSUSModuleInstFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSMODULEINSTFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSModuleInstFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINSTFUNC_PSUSMODULEINSTFUNC_PSUSMODULEINSTFUNCID", "", iDataEntityModel.getName(), "PSUSDCMODULEINSTFUNC", iDataEntityModel.getDataInfo((IEntity)pSUSModuleInstFunc), arrayList.get(0)));
        }
    }

    public void resetPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        ArrayList<PSUSDCModuleInstFunc> arrayList = this.selectByPSUSModuleInstFunc(pSUSModuleInstFunc);
        for (PSUSDCModuleInstFunc pSUSDCModuleInstFunc : arrayList) {
            PSUSDCModuleInstFunc pSUSDCModuleInstFunc2 = (PSUSDCModuleInstFunc)this.getDEModel().createEntity();
            pSUSDCModuleInstFunc2.setPSUSDCModuleInstFuncId(pSUSDCModuleInstFunc.getPSUSDCModuleInstFuncId());
            pSUSDCModuleInstFunc2.setPSUSModuleInstFuncId(null);
            this.update(pSUSDCModuleInstFunc2);
        }
    }

    public void removeByPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        final PSUSModuleInstFunc pSUSModuleInstFunc2 = pSUSModuleInstFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstFuncServiceBase.this.onBeforeRemoveByPSUSModuleInstFunc(pSUSModuleInstFunc2);
                PSUSDCModuleInstFuncServiceBase.this.internalRemoveByPSUSModuleInstFunc(pSUSModuleInstFunc2);
                PSUSDCModuleInstFuncServiceBase.this.onAfterRemoveByPSUSModuleInstFunc(pSUSModuleInstFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
    }

    protected void internalRemoveByPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
        ArrayList<PSUSDCModuleInstFunc> arrayList = this.selectByPSUSModuleInstFunc(pSUSModuleInstFunc);
        this.onBeforeRemoveByPSUSModuleInstFunc(pSUSModuleInstFunc, arrayList);
        for (PSUSDCModuleInstFunc pSUSDCModuleInstFunc : arrayList) {
            this.remove((IEntity)pSUSDCModuleInstFunc);
        }
        this.onAfterRemoveByPSUSModuleInstFunc(pSUSModuleInstFunc, arrayList);
    }

    protected void onAfterRemoveByPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc, ArrayList<PSUSDCModuleInstFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSModuleInstFunc(PSUSModuleInstFunc pSUSModuleInstFunc, ArrayList<PSUSDCModuleInstFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUSDCModuleInstFunc pSUSDCModuleInstFunc) throws Exception {
        super.onBeforeRemove(pSUSDCModuleInstFunc);
    }

    protected void replaceParentInfo(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSUSDCModuleInstFunc, cloneSession);
        if (pSUSDCModuleInstFunc.getPSUSDCModuleInstId() != null && (iEntity = cloneSession.getEntity("PSUSDCMODULEINST", (Object)pSUSDCModuleInstFunc.getPSUSDCModuleInstId())) != null) {
            this.onFillParentInfo_PSUSDCModuleInst(pSUSDCModuleInstFunc, (PSUSDCModuleInst)iEntity);
        }
        if (pSUSDCModuleInstFunc.getPSUSModuleInstFuncId() != null && (iEntity = cloneSession.getEntity("PSUSMODULEINSTFUNC", (Object)pSUSDCModuleInstFunc.getPSUSModuleInstFuncId())) != null) {
            this.onFillParentInfo_PSUSModuleInstFunc(pSUSDCModuleInstFunc, (PSUSModuleInstFunc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUSDCModuleInstFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FuncTag(bl, pSUSDCModuleInstFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncType(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobileAppFlag(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleInstFuncId(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleInstFuncName(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleInstId(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstFuncId(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Url(bl, pSUSDCModuleInstFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUSDCModuleInstFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FuncTag(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isFuncTagDirty() : !pSUSDCModuleInstFunc.isFuncTagDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getFuncTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncTag_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_FuncType(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isFuncTypeDirty() && !bl2 : !pSUSDCModuleInstFunc.isFuncTypeDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getFuncType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncType_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isMemoDirty() : !pSUSDCModuleInstFunc.isMemoDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobileAppFlag(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isMobileAppFlagDirty() : !pSUSDCModuleInstFunc.isMobileAppFlagDirty()) {
            return null;
        }
        Integer n = pSUSDCModuleInstFunc.getMobileAppFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobileAppFlag_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUSDCModuleInstFuncId(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isPSUSDCModuleInstFuncIdDirty() && !bl2 : !pSUSDCModuleInstFunc.isPSUSDCModuleInstFuncIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getPSUSDCModuleInstFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstFuncId_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSDCModuleInstFuncName(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isPSUSDCModuleInstFuncNameDirty() && !bl2 : !pSUSDCModuleInstFunc.isPSUSDCModuleInstFuncNameDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getPSUSDCModuleInstFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstFuncName_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSDCModuleInstId(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isPSUSDCModuleInstIdDirty() : !pSUSDCModuleInstFunc.isPSUSDCModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getPSUSDCModuleInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstId_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstFuncId(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isPSUSModuleInstFuncIdDirty() : !pSUSDCModuleInstFunc.isPSUSModuleInstFuncIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getPSUSModuleInstFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstFuncId_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_Url(boolean bl, PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstFunc.isUrlDirty() : !pSUSDCModuleInstFunc.isUrlDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstFunc.getUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Url_Default((IEntity)pSUSDCModuleInstFunc, bl2, bl3);
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

    protected void onSyncEntity(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUSDCModuleInstFunc, bl);
    }

    protected void onSyncIndexEntities(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUSDCModuleInstFunc, bl);
    }

    public Object getDataContextValue(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUSDCModuleInstFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSUSDCModuleInst pSUSDCModuleInst = pSUSDCModuleInstFunc.getPSUSDCModuleInst();
        if (pSUSDCModuleInst != null && pSUSDCModuleInst.contains(string)) {
            return pSUSDCModuleInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUSDCModuleInstFunc, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstFuncName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSUSDCModuleInstFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected boolean onMergeChild(String string, String string2, PSUSDCModuleInstFunc pSUSDCModuleInstFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUSDCModuleInstFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUSDCModuleInstFunc pSUSDCModuleInstFunc) throws Exception {
        super.onUpdateParent((IEntity)pSUSDCModuleInstFunc);
    }

    @Override
    protected void exportCurXmlModel(PSUSDCModuleInstFunc pSUSDCModuleInstFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUSDCMODULEINSTFUNC");
        if (!bl) {
            pSUSDCModuleInstFunc.setCreateDate(null);
            pSUSDCModuleInstFunc.setCreateMan(null);
            pSUSDCModuleInstFunc.setPSUSDCModuleInstFuncId(null);
            pSUSDCModuleInstFunc.setPSUSDCModuleInstName(null);
            pSUSDCModuleInstFunc.setPSUSModuleInstFuncName(null);
            pSUSDCModuleInstFunc.setUpdateDate(null);
            pSUSDCModuleInstFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSUSDCModuleInstFunc, xmlNode, bl);
        }
    }
}

