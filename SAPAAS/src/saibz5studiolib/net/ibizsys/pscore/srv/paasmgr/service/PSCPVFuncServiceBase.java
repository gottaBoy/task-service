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
package net.ibizsys.pscore.srv.paasmgr.service;

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
import net.ibizsys.pscore.srv.paasmgr.dao.PSCPVFuncDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCPVFuncDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCPVFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFuncBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCPVFuncServiceBase
extends PSCoreSysServiceBase<PSCPVFunc> {
    private static final Log log = LogFactory.getLog(PSCPVFuncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCPVFuncDEModel pSCPVFuncDEModel;
    private PSCPVFuncDAO pSCPVFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCPVFuncService";
    }

    public PSCPVFuncDEModel getPSCPVFuncDEModel() {
        if (this.pSCPVFuncDEModel == null) {
            try {
                this.pSCPVFuncDEModel = (PSCPVFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCPVFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCPVFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCPVFuncDEModel();
    }

    public PSCPVFuncDAO getPSCPVFuncDAO() {
        if (this.pSCPVFuncDAO == null) {
            try {
                this.pSCPVFuncDAO = (PSCPVFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCPVFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCPVFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCPVFuncDAO();
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

    protected void onFillParentInfo(PSCPVFunc pSCPVFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCPVFUNC_PSCOREPRDFUNC_PSCOREPRDFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService", (SessionFactory)this.getSessionFactory());
            PSCorePrdFunc pSCorePrdFunc = (PSCorePrdFunc)iService.getDEModel().createEntity();
            pSCorePrdFunc.set("PSCOREPRDFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdFunc);
            } else {
                iService.get((IEntity)pSCorePrdFunc);
            }
            this.onFillParentInfo_PSCorePrdFunc(pSCPVFunc, pSCorePrdFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCPVFUNC_PSCOREPRDVER_PSCOREPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService", (SessionFactory)this.getSessionFactory());
            PSCorePrdVer pSCorePrdVer = (PSCorePrdVer)iService.getDEModel().createEntity();
            pSCorePrdVer.set("PSCOREPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdVer);
            } else {
                iService.get((IEntity)pSCorePrdVer);
            }
            this.onFillParentInfo_PSCorePrdVer(pSCPVFunc, pSCorePrdVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSCPVFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdFunc(PSCPVFunc pSCPVFunc, PSCorePrdFunc pSCorePrdFunc) throws Exception {
        pSCPVFunc.setPSCorePrdFuncId(pSCorePrdFunc.getPSCorePrdFuncId());
        pSCPVFunc.setPSCorePrdFuncName(pSCorePrdFunc.getPSCorePrdFuncName());
    }

    protected void onFillParentInfo_PSCorePrdVer(PSCPVFunc pSCPVFunc, PSCorePrdVer pSCorePrdVer) throws Exception {
        pSCPVFunc.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
        pSCPVFunc.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
    }

    protected void onFillEntityFullInfo(PSCPVFunc pSCPVFunc, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSCPVFunc, bl);
        this.onFillEntityFullInfo_PSCorePrdFunc(pSCPVFunc, bl);
        this.onFillEntityFullInfo_PSCorePrdVer(pSCPVFunc, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdFunc(PSCPVFunc pSCPVFunc, boolean bl) throws Exception {
        if (pSCPVFunc.isPSCorePrdFuncIdDirty()) {
            if (pSCPVFunc.getPSCorePrdFuncId() != null) {
                if (pSCPVFunc.getPSCorePrdFuncId() == null || pSCPVFunc.getPSCorePrdFuncName() == null) {
                    PSCorePrdFunc pSCorePrdFunc = pSCPVFunc.getPSCorePrdFunc();
                    pSCPVFunc.setPSCorePrdFuncName(pSCorePrdFunc.getPSCorePrdFuncName());
                }
            } else {
                pSCPVFunc.setPSCorePrdFuncName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrdVer(PSCPVFunc pSCPVFunc, boolean bl) throws Exception {
        if (pSCPVFunc.isPSCorePrdVerIdDirty()) {
            if (pSCPVFunc.getPSCorePrdVerId() != null) {
                if (pSCPVFunc.getPSCorePrdVerId() == null || pSCPVFunc.getPSCorePrdVerName() == null) {
                    PSCorePrdVer pSCorePrdVer = pSCPVFunc.getPSCorePrdVer();
                    pSCPVFunc.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
                }
            } else {
                pSCPVFunc.setPSCorePrdVerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCPVFunc pSCPVFunc, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCPVFunc, bl);
    }

    public ArrayList<PSCPVFunc> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase) throws Exception {
        return this.selectByPSCorePrdFunc(pSCorePrdFuncBase, "", -1);
    }

    public ArrayList<PSCPVFunc> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase, String string) throws Exception {
        return this.selectByPSCorePrdFunc(pSCorePrdFuncBase, string, -1);
    }

    public ArrayList<PSCPVFunc> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDFUNCID", (Object)pSCorePrdFuncBase.getPSCorePrdFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCPVFunc> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, "", -1);
    }

    public ArrayList<PSCPVFunc> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, string, -1);
    }

    public ArrayList<PSCPVFunc> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDVERID", (Object)pSCorePrdVerBase.getPSCorePrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        ArrayList<PSCPVFunc> arrayList = this.selectByPSCorePrdFunc(pSCorePrdFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCOREPRDFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCorePrdFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCPVFUNC_PSCOREPRDFUNC_PSCOREPRDFUNCID", "", iDataEntityModel.getName(), "PSCPVFUNC", iDataEntityModel.getDataInfo((IEntity)pSCorePrdFunc), arrayList.get(0)));
        }
    }

    public void resetPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        ArrayList<PSCPVFunc> arrayList = this.selectByPSCorePrdFunc(pSCorePrdFunc);
        for (PSCPVFunc pSCPVFunc : arrayList) {
            PSCPVFunc pSCPVFunc2 = (PSCPVFunc)this.getDEModel().createEntity();
            pSCPVFunc2.setPSCPVFuncId(pSCPVFunc.getPSCPVFuncId());
            pSCPVFunc2.setPSCorePrdFuncId(null);
            this.update(pSCPVFunc2);
        }
    }

    public void removeByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        final PSCorePrdFunc pSCorePrdFunc2 = pSCorePrdFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCPVFuncServiceBase.this.onBeforeRemoveByPSCorePrdFunc(pSCorePrdFunc2);
                PSCPVFuncServiceBase.this.internalRemoveByPSCorePrdFunc(pSCorePrdFunc2);
                PSCPVFuncServiceBase.this.onAfterRemoveByPSCorePrdFunc(pSCorePrdFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    protected void internalRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        ArrayList<PSCPVFunc> arrayList = this.selectByPSCorePrdFunc(pSCorePrdFunc);
        this.onBeforeRemoveByPSCorePrdFunc(pSCorePrdFunc, arrayList);
        for (PSCPVFunc pSCPVFunc : arrayList) {
            this.remove((IEntity)pSCPVFunc);
        }
        this.onAfterRemoveByPSCorePrdFunc(pSCorePrdFunc, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc, ArrayList<PSCPVFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc, ArrayList<PSCPVFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    public void resetPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCPVFunc> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        for (PSCPVFunc pSCPVFunc : arrayList) {
            PSCPVFunc pSCPVFunc2 = (PSCPVFunc)this.getDEModel().createEntity();
            pSCPVFunc2.setPSCPVFuncId(pSCPVFunc.getPSCPVFuncId());
            pSCPVFunc2.setPSCorePrdVerId(null);
            this.update(pSCPVFunc2);
        }
    }

    public void removeByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        final PSCorePrdVer pSCorePrdVer2 = pSCorePrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCPVFuncServiceBase.this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSCPVFuncServiceBase.this.internalRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSCPVFuncServiceBase.this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void internalRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCPVFunc> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
        for (PSCPVFunc pSCPVFunc : arrayList) {
            this.remove((IEntity)pSCPVFunc);
        }
        this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCPVFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCPVFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCPVFunc pSCPVFunc) throws Exception {
        super.onBeforeRemove(pSCPVFunc);
    }

    protected void replaceParentInfo(PSCPVFunc pSCPVFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCPVFunc, cloneSession);
        if (pSCPVFunc.getPSCorePrdFuncId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDFUNC", (Object)pSCPVFunc.getPSCorePrdFuncId())) != null) {
            this.onFillParentInfo_PSCorePrdFunc(pSCPVFunc, (PSCorePrdFunc)iEntity);
        }
        if (pSCPVFunc.getPSCorePrdVerId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDVER", (Object)pSCPVFunc.getPSCorePrdVerId())) != null) {
            this.onFillParentInfo_PSCorePrdVer(pSCPVFunc, (PSCorePrdVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCPVFunc pSCPVFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCPVFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FuncSN(bl, pSCPVFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCPVFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdFuncId(bl, pSCPVFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdFuncName(bl, pSCPVFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerId(bl, pSCPVFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerName(bl, pSCPVFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCPVFuncId(bl, pSCPVFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCPVFuncName(bl, pSCPVFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCPVFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FuncSN(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isFuncSNDirty() : !pSCPVFunc.isFuncSNDirty()) {
            return null;
        }
        Integer n = pSCPVFunc.getFuncSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FuncSN_Default((IEntity)pSCPVFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isMemoDirty() : !pSCPVFunc.isMemoDirty()) {
            return null;
        }
        String string = pSCPVFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSCPVFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdFuncId(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isPSCorePrdFuncIdDirty() : !pSCPVFunc.isPSCorePrdFuncIdDirty()) {
            return null;
        }
        String string = pSCPVFunc.getPSCorePrdFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdFuncId_Default((IEntity)pSCPVFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdFuncName(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isPSCorePrdFuncNameDirty() : !pSCPVFunc.isPSCorePrdFuncNameDirty()) {
            return null;
        }
        String string = pSCPVFunc.getPSCorePrdFuncName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdFuncName_Default((IEntity)pSCPVFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdVerId(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isPSCorePrdVerIdDirty() : !pSCPVFunc.isPSCorePrdVerIdDirty()) {
            return null;
        }
        String string = pSCPVFunc.getPSCorePrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerId_Default((IEntity)pSCPVFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdVerName(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isPSCorePrdVerNameDirty() : !pSCPVFunc.isPSCorePrdVerNameDirty()) {
            return null;
        }
        String string = pSCPVFunc.getPSCorePrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerName_Default((IEntity)pSCPVFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCPVFuncId(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isPSCPVFuncIdDirty() && !bl2 : !pSCPVFunc.isPSCPVFuncIdDirty()) {
            return null;
        }
        String string = pSCPVFunc.getPSCPVFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCPVFuncId_Default((IEntity)pSCPVFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCPVFuncName(boolean bl, PSCPVFunc pSCPVFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVFunc.isPSCPVFuncNameDirty() && !bl2 : !pSCPVFunc.isPSCPVFuncNameDirty()) {
            return null;
        }
        String string = pSCPVFunc.getPSCPVFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCPVFuncName_Default((IEntity)pSCPVFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCPVFunc pSCPVFunc, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCPVFunc, bl);
    }

    protected void onSyncIndexEntities(PSCPVFunc pSCPVFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCPVFunc, bl);
    }

    public Object getDataContextValue(PSCPVFunc pSCPVFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCPVFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSCorePrdFunc pSCorePrdFunc = pSCPVFunc.getPSCorePrdFunc();
        if (pSCorePrdFunc != null && pSCorePrdFunc.contains(string)) {
            return pSCorePrdFunc.get(string);
        }
        PSCorePrdVer pSCorePrdVer = pSCPVFunc.getPSCorePrdVer();
        if (pSCorePrdVer != null && pSCorePrdVer.contains(string)) {
            return pSCorePrdVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCPVFunc pSCPVFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSCPVFunc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCPVFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCPVFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCPVFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCPVFuncName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FuncSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSCorePrdFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCPVFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCPVFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCPVFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCPVFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCPVFunc pSCPVFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSCPVFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCPVFunc pSCPVFunc) throws Exception {
        super.onUpdateParent((IEntity)pSCPVFunc);
    }

    @Override
    protected void exportCurXmlModel(PSCPVFunc pSCPVFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCPVFUNC");
        if (!bl) {
            pSCPVFunc.setCreateDate(null);
            pSCPVFunc.setCreateMan(null);
            pSCPVFunc.setPSCPVFuncId(null);
            pSCPVFunc.setUpdateDate(null);
            pSCPVFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSCPVFunc, xmlNode, bl);
        }
    }
}

