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

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdVerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdVerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFuncBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVFuncServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVIssueServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdVerServiceBase
extends PSCoreSysServiceBase<PSCorePrdVer> {
    private static final Log log = LogFactory.getLog(PSCorePrdVerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCorePrdVerDEModel pSCorePrdVerDEModel;
    private PSCorePrdVerDAO pSCorePrdVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService";
    }

    public PSCorePrdVerDEModel getPSCorePrdVerDEModel() {
        if (this.pSCorePrdVerDEModel == null) {
            try {
                this.pSCorePrdVerDEModel = (PSCorePrdVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCorePrdVerDEModel();
    }

    public PSCorePrdVerDAO getPSCorePrdVerDAO() {
        if (this.pSCorePrdVerDAO == null) {
            try {
                this.pSCorePrdVerDAO = (PSCorePrdVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCorePrdVerDAO();
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

    protected void onFillParentInfo(PSCorePrdVer pSCorePrdVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDVER_PSCOREPRDFUNC_PSCOREPRDFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService", (SessionFactory)this.getSessionFactory());
            PSCorePrdFunc pSCorePrdFunc = (PSCorePrdFunc)iService.getDEModel().createEntity();
            pSCorePrdFunc.set("PSCOREPRDFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdFunc);
            } else {
                iService.get((IEntity)pSCorePrdFunc);
            }
            this.onFillParentInfo_PSCorePrdFunc(pSCorePrdVer, pSCorePrdFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDVER_PSCOREPRD_PSCOREPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory());
            PSCorePrd pSCorePrd = (PSCorePrd)iService.getDEModel().createEntity();
            pSCorePrd.set("PSCOREPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrd);
            } else {
                iService.get((IEntity)pSCorePrd);
            }
            this.onFillParentInfo_PSCorePrd(pSCorePrdVer, pSCorePrd);
            return;
        }
        super.onFillParentInfo((IEntity)pSCorePrdVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdFunc(PSCorePrdVer pSCorePrdVer, PSCorePrdFunc pSCorePrdFunc) throws Exception {
        pSCorePrdVer.setPSCorePrdFuncId(pSCorePrdFunc.getPSCorePrdFuncId());
        pSCorePrdVer.setPSCorePrdFuncName(pSCorePrdFunc.getPSCorePrdFuncName());
    }

    protected void onFillParentInfo_PSCorePrd(PSCorePrdVer pSCorePrdVer, PSCorePrd pSCorePrd) throws Exception {
        pSCorePrdVer.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
        pSCorePrdVer.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
    }

    protected void onFillEntityFullInfo(PSCorePrdVer pSCorePrdVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSCorePrdVer, bl);
        this.onFillEntityFullInfo_PSCorePrdFunc(pSCorePrdVer, bl);
        this.onFillEntityFullInfo_PSCorePrd(pSCorePrdVer, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdFunc(PSCorePrdVer pSCorePrdVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCorePrd(PSCorePrdVer pSCorePrdVer, boolean bl) throws Exception {
        if (pSCorePrdVer.isPSCorePrdIdDirty()) {
            if (pSCorePrdVer.getPSCorePrdId() != null) {
                if (pSCorePrdVer.getPSCorePrdId() == null || pSCorePrdVer.getPSCorePrdName() == null) {
                    PSCorePrd pSCorePrd = pSCorePrdVer.getPSCorePrd();
                    pSCorePrdVer.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
                }
            } else {
                pSCorePrdVer.setPSCorePrdName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCorePrdVer pSCorePrdVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCorePrdVer, bl);
    }

    public ArrayList<PSCorePrdVer> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase) throws Exception {
        return this.selectByPSCorePrdFunc(pSCorePrdFuncBase, "", -1);
    }

    public ArrayList<PSCorePrdVer> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase, String string) throws Exception {
        return this.selectByPSCorePrdFunc(pSCorePrdFuncBase, string, -1);
    }

    public ArrayList<PSCorePrdVer> selectByPSCorePrdFunc(PSCorePrdFuncBase pSCorePrdFuncBase, String string, int n) throws Exception {
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

    public ArrayList<PSCorePrdVer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, "", -1);
    }

    public ArrayList<PSCorePrdVer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, string, -1);
    }

    public ArrayList<PSCorePrdVer> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDID", (Object)pSCorePrdBase.getPSCorePrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    public void resetPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        ArrayList<PSCorePrdVer> arrayList = this.selectByPSCorePrdFunc(pSCorePrdFunc);
        for (PSCorePrdVer pSCorePrdVer : arrayList) {
            PSCorePrdVer pSCorePrdVer2 = (PSCorePrdVer)this.getDEModel().createEntity();
            pSCorePrdVer2.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
            pSCorePrdVer2.setPSCorePrdFuncId(null);
            this.update(pSCorePrdVer2);
        }
    }

    public void removeByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        final PSCorePrdFunc pSCorePrdFunc2 = pSCorePrdFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdVerServiceBase.this.onBeforeRemoveByPSCorePrdFunc(pSCorePrdFunc2);
                PSCorePrdVerServiceBase.this.internalRemoveByPSCorePrdFunc(pSCorePrdFunc2);
                PSCorePrdVerServiceBase.this.onAfterRemoveByPSCorePrdFunc(pSCorePrdFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    protected void internalRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
        ArrayList<PSCorePrdVer> arrayList = this.selectByPSCorePrdFunc(pSCorePrdFunc);
        this.onBeforeRemoveByPSCorePrdFunc(pSCorePrdFunc, arrayList);
        for (PSCorePrdVer pSCorePrdVer : arrayList) {
            this.remove((IEntity)pSCorePrdVer);
        }
        this.onAfterRemoveByPSCorePrdFunc(pSCorePrdFunc, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc, ArrayList<PSCorePrdVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdFunc(PSCorePrdFunc pSCorePrdFunc, ArrayList<PSCorePrdVer> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdVer> arrayList = this.selectByPSCorePrd(pSCorePrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCOREPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCorePrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCOREPRDVER_PSCOREPRD_PSCOREPRDID", "", iDataEntityModel.getName(), "PSCOREPRDVER", iDataEntityModel.getDataInfo((IEntity)pSCorePrd), arrayList.get(0)));
        }
    }

    public void resetPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdVer> arrayList = this.selectByPSCorePrd(pSCorePrd);
        for (PSCorePrdVer pSCorePrdVer : arrayList) {
            PSCorePrdVer pSCorePrdVer2 = (PSCorePrdVer)this.getDEModel().createEntity();
            pSCorePrdVer2.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
            pSCorePrdVer2.setPSCorePrdId(null);
            this.update(pSCorePrdVer2);
        }
    }

    public void removeByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        final PSCorePrd pSCorePrd2 = pSCorePrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdVerServiceBase.this.onBeforeRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdVerServiceBase.this.internalRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdVerServiceBase.this.onAfterRemoveByPSCorePrd(pSCorePrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void internalRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdVer> arrayList = this.selectByPSCorePrd(pSCorePrd);
        this.onBeforeRemoveByPSCorePrd(pSCorePrd, arrayList);
        for (PSCorePrdVer pSCorePrdVer : arrayList) {
            this.remove((IEntity)pSCorePrdVer);
        }
        this.onAfterRemoveByPSCorePrd(pSCorePrd, arrayList);
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCorePrdVer pSCorePrdVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCorePrdIssueService)ServiceGlobal.getService(PSCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSCoreRepVer(pSCorePrdVer);
        pSCoreSysServiceBase = (PSCPVFuncService)ServiceGlobal.getService(PSCPVFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSCPVFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdVer(pSCorePrdVer);
        ((PSCPVFuncServiceBase)pSCoreSysServiceBase).removeByPSCorePrdVer(pSCorePrdVer);
        pSCoreSysServiceBase = (PSCPVIssueService)ServiceGlobal.getService(PSCPVIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSCPVIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdVer(pSCorePrdVer);
        ((PSCPVIssueServiceBase)pSCoreSysServiceBase).removeByPSCorePrdVer(pSCorePrdVer);
        super.onBeforeRemove(pSCorePrdVer);
    }

    protected void replaceParentInfo(PSCorePrdVer pSCorePrdVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCorePrdVer, cloneSession);
        if (pSCorePrdVer.getPSCorePrdFuncId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDFUNC", (Object)pSCorePrdVer.getPSCorePrdFuncId())) != null) {
            this.onFillParentInfo_PSCorePrdFunc(pSCorePrdVer, (PSCorePrdFunc)iEntity);
        }
        if (pSCorePrdVer.getPSCorePrdId() != null && (iEntity = cloneSession.getEntity("PSCOREPRD", (Object)pSCorePrdVer.getPSCorePrdId())) != null) {
            this.onFillParentInfo_PSCorePrd(pSCorePrdVer, (PSCorePrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCorePrdVer pSCorePrdVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCorePrdVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefaultFlag(bl, pSCorePrdVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanPubDate(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdFuncId(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerId(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerName(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubDate(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubState(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerSN(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag2(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerType(bl, pSCorePrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCorePrdVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isDefaultFlagDirty() : !pSCorePrdVer.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSCorePrdVer.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isMemoDirty() : !pSCorePrdVer.isMemoDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSCorePrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PlanPubDate(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPlanPubDateDirty() : !pSCorePrdVer.isPlanPubDateDirty()) {
            return null;
        }
        Timestamp timestamp = pSCorePrdVer.getPlanPubDate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PlanPubDate_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANPUBDATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdFuncId(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPSCorePrdFuncIdDirty() : !pSCorePrdVer.isPSCorePrdFuncIdDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getPSCorePrdFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdFuncId_Default((IEntity)pSCorePrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPSCorePrdIdDirty() : !pSCorePrdVer.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getPSCorePrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPSCorePrdNameDirty() : !pSCorePrdVer.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getPSCorePrdName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdVerId(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPSCorePrdVerIdDirty() && !bl2 : !pSCorePrdVer.isPSCorePrdVerIdDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getPSCorePrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerId_Default((IEntity)pSCorePrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerName(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPSCorePrdVerNameDirty() && !bl2 : !pSCorePrdVer.isPSCorePrdVerNameDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getPSCorePrdVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerName_Default((IEntity)pSCorePrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubDate(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPubDateDirty() : !pSCorePrdVer.isPubDateDirty()) {
            return null;
        }
        Timestamp timestamp = pSCorePrdVer.getPubDate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubDate_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBDATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubState(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isPubStateDirty() && !bl2 : !pSCorePrdVer.isPubStateDirty()) {
            return null;
        }
        Integer n = pSCorePrdVer.getPubState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PubState_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerSN(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isVerSNDirty() && !bl2 : !pSCorePrdVer.isVerSNDirty()) {
            return null;
        }
        Integer n = pSCorePrdVer.getVerSN();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSN");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_VerSN_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isVerTagDirty() : !pSCorePrdVer.isVerTagDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getVerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag2(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isVerTag2Dirty() : !pSCorePrdVer.isVerTag2Dirty()) {
            return null;
        }
        String string = pSCorePrdVer.getVerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag2_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerType(boolean bl, PSCorePrdVer pSCorePrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdVer.isVerTypeDirty() : !pSCorePrdVer.isVerTypeDirty()) {
            return null;
        }
        String string = pSCorePrdVer.getVerType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerType_Default((IEntity)pSCorePrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCorePrdVer pSCorePrdVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCorePrdVer, bl);
    }

    protected void onSyncIndexEntities(PSCorePrdVer pSCorePrdVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCorePrdVer, bl);
    }

    public Object getDataContextValue(PSCorePrdVer pSCorePrdVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCorePrdVer, string, iDataContextParam)) != null) {
            return object;
        }
        PSCorePrd pSCorePrd = pSCorePrdVer.getPSCorePrd();
        if (pSCorePrd != null && pSCorePrd.contains(string)) {
            return pSCorePrd.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCorePrdVer pSCorePrdVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSCorePrdVer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLANPUBDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlanPubDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PlanPubDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSCorePrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PubDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PubState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_VerSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_VerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSCorePrdVer pSCorePrdVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSCorePrdVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCorePrdVer pSCorePrdVer) throws Exception {
        super.onUpdateParent((IEntity)pSCorePrdVer);
    }

    @Override
    protected void exportCurXmlModel(PSCorePrdVer pSCorePrdVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCOREPRDVER");
        if (!bl) {
            pSCorePrdVer.setCreateDate(null);
            pSCorePrdVer.setCreateMan(null);
            pSCorePrdVer.setPSCorePrdVerId(null);
            pSCorePrdVer.setUpdateDate(null);
            pSCorePrdVer.setUpdateMan(null);
            super.exportCurXmlModel(pSCorePrdVer, xmlNode, bl);
        }
    }
}

