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
import net.ibizsys.pscore.srv.paasmgr.dao.PSCPVIssueDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCPVIssueDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCPVIssue;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssue;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssueBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCPVIssueServiceBase
extends PSCoreSysServiceBase<PSCPVIssue> {
    private static final Log log = LogFactory.getLog(PSCPVIssueServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCPVIssueDEModel pSCPVIssueDEModel;
    private PSCPVIssueDAO pSCPVIssueDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCPVIssueService";
    }

    public PSCPVIssueDEModel getPSCPVIssueDEModel() {
        if (this.pSCPVIssueDEModel == null) {
            try {
                this.pSCPVIssueDEModel = (PSCPVIssueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCPVIssueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCPVIssueDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCPVIssueDEModel();
    }

    public PSCPVIssueDAO getPSCPVIssueDAO() {
        if (this.pSCPVIssueDAO == null) {
            try {
                this.pSCPVIssueDAO = (PSCPVIssueDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCPVIssueDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCPVIssueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCPVIssueDAO();
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

    protected void onFillParentInfo(PSCPVIssue pSCPVIssue, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCPVISSUE_PSCOREPRDISSUE_PSCOREPRDISSUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService", (SessionFactory)this.getSessionFactory());
            PSCorePrdIssue pSCorePrdIssue = (PSCorePrdIssue)iService.getDEModel().createEntity();
            pSCorePrdIssue.set("PSCOREPRDISSUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdIssue);
            } else {
                iService.get((IEntity)pSCorePrdIssue);
            }
            this.onFillParentInfo_PSCorePrdIssue(pSCPVIssue, pSCorePrdIssue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCPVISSUE_PSCOREPRDVER_PSCOREPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService", (SessionFactory)this.getSessionFactory());
            PSCorePrdVer pSCorePrdVer = (PSCorePrdVer)iService.getDEModel().createEntity();
            pSCorePrdVer.set("PSCOREPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCorePrdVer);
            } else {
                iService.get((IEntity)pSCorePrdVer);
            }
            this.onFillParentInfo_PSCorePrdVer(pSCPVIssue, pSCorePrdVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSCPVIssue, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCorePrdIssue(PSCPVIssue pSCPVIssue, PSCorePrdIssue pSCorePrdIssue) throws Exception {
        pSCPVIssue.setPSCorePrdIssueId(pSCorePrdIssue.getPSCorePrdIssueId());
        pSCPVIssue.setPSCorePrdIssueName(pSCorePrdIssue.getPSCorePrdIssueName());
    }

    protected void onFillParentInfo_PSCorePrdVer(PSCPVIssue pSCPVIssue, PSCorePrdVer pSCorePrdVer) throws Exception {
        pSCPVIssue.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
        pSCPVIssue.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
    }

    protected void onFillEntityFullInfo(PSCPVIssue pSCPVIssue, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSCPVIssue, bl);
        this.onFillEntityFullInfo_PSCorePrdIssue(pSCPVIssue, bl);
        this.onFillEntityFullInfo_PSCorePrdVer(pSCPVIssue, bl);
    }

    protected void onFillEntityFullInfo_PSCorePrdIssue(PSCPVIssue pSCPVIssue, boolean bl) throws Exception {
        if (pSCPVIssue.isPSCorePrdIssueIdDirty()) {
            if (pSCPVIssue.getPSCorePrdIssueId() != null) {
                if (pSCPVIssue.getPSCorePrdIssueId() == null || pSCPVIssue.getPSCorePrdIssueName() == null) {
                    PSCorePrdIssue pSCorePrdIssue = pSCPVIssue.getPSCorePrdIssue();
                    pSCPVIssue.setPSCorePrdIssueName(pSCorePrdIssue.getPSCorePrdIssueName());
                }
            } else {
                pSCPVIssue.setPSCorePrdIssueName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrdVer(PSCPVIssue pSCPVIssue, boolean bl) throws Exception {
        if (pSCPVIssue.isPSCorePrdVerIdDirty()) {
            if (pSCPVIssue.getPSCorePrdVerId() != null) {
                if (pSCPVIssue.getPSCorePrdVerId() == null || pSCPVIssue.getPSCorePrdVerName() == null) {
                    PSCorePrdVer pSCorePrdVer = pSCPVIssue.getPSCorePrdVer();
                    pSCPVIssue.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
                }
            } else {
                pSCPVIssue.setPSCorePrdVerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCPVIssue pSCPVIssue, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSCPVIssue, bl);
    }

    public ArrayList<PSCPVIssue> selectByPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase) throws Exception {
        return this.selectByPSCorePrdIssue(pSCorePrdIssueBase, "", -1);
    }

    public ArrayList<PSCPVIssue> selectByPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase, String string) throws Exception {
        return this.selectByPSCorePrdIssue(pSCorePrdIssueBase, string, -1);
    }

    public ArrayList<PSCPVIssue> selectByPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDISSUEID", (Object)pSCorePrdIssueBase.getPSCorePrdIssueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCorePrdIssueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCorePrdIssueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCPVIssue> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, "", -1);
    }

    public ArrayList<PSCPVIssue> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string) throws Exception {
        return this.selectByPSCorePrdVer(pSCorePrdVerBase, string, -1);
    }

    public ArrayList<PSCPVIssue> selectByPSCorePrdVer(PSCorePrdVerBase pSCorePrdVerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSCPVIssue> arrayList = this.selectByPSCorePrdIssue(pSCorePrdIssue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCOREPRDISSUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCorePrdIssue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCPVISSUE_PSCOREPRDISSUE_PSCOREPRDISSUEID", "", iDataEntityModel.getName(), "PSCPVISSUE", iDataEntityModel.getDataInfo((IEntity)pSCorePrdIssue), arrayList.get(0)));
        }
    }

    public void resetPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSCPVIssue> arrayList = this.selectByPSCorePrdIssue(pSCorePrdIssue);
        for (PSCPVIssue pSCPVIssue : arrayList) {
            PSCPVIssue pSCPVIssue2 = (PSCPVIssue)this.getDEModel().createEntity();
            pSCPVIssue2.setPSCPVIssueId(pSCPVIssue.getPSCPVIssueId());
            pSCPVIssue2.setPSCorePrdIssueId(null);
            this.update(pSCPVIssue2);
        }
    }

    public void removeByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        final PSCorePrdIssue pSCorePrdIssue2 = pSCorePrdIssue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCPVIssueServiceBase.this.onBeforeRemoveByPSCorePrdIssue(pSCorePrdIssue2);
                PSCPVIssueServiceBase.this.internalRemoveByPSCorePrdIssue(pSCorePrdIssue2);
                PSCPVIssueServiceBase.this.onAfterRemoveByPSCorePrdIssue(pSCorePrdIssue2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
    }

    protected void internalRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSCPVIssue> arrayList = this.selectByPSCorePrdIssue(pSCorePrdIssue);
        this.onBeforeRemoveByPSCorePrdIssue(pSCorePrdIssue, arrayList);
        for (PSCPVIssue pSCPVIssue : arrayList) {
            this.remove((IEntity)pSCPVIssue);
        }
        this.onAfterRemoveByPSCorePrdIssue(pSCorePrdIssue, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, ArrayList<PSCPVIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, ArrayList<PSCPVIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    public void resetPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCPVIssue> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        for (PSCPVIssue pSCPVIssue : arrayList) {
            PSCPVIssue pSCPVIssue2 = (PSCPVIssue)this.getDEModel().createEntity();
            pSCPVIssue2.setPSCPVIssueId(pSCPVIssue.getPSCPVIssueId());
            pSCPVIssue2.setPSCorePrdVerId(null);
            this.update(pSCPVIssue2);
        }
    }

    public void removeByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        final PSCorePrdVer pSCorePrdVer2 = pSCorePrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCPVIssueServiceBase.this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSCPVIssueServiceBase.this.internalRemoveByPSCorePrdVer(pSCorePrdVer2);
                PSCPVIssueServiceBase.this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void internalRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCPVIssue> arrayList = this.selectByPSCorePrdVer(pSCorePrdVer);
        this.onBeforeRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
        for (PSCPVIssue pSCPVIssue : arrayList) {
            this.remove((IEntity)pSCPVIssue);
        }
        this.onAfterRemoveByPSCorePrdVer(pSCorePrdVer, arrayList);
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCPVIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrdVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCPVIssue> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCPVIssue pSCPVIssue) throws Exception {
        super.onBeforeRemove(pSCPVIssue);
    }

    protected void replaceParentInfo(PSCPVIssue pSCPVIssue, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSCPVIssue, cloneSession);
        if (pSCPVIssue.getPSCorePrdIssueId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDISSUE", (Object)pSCPVIssue.getPSCorePrdIssueId())) != null) {
            this.onFillParentInfo_PSCorePrdIssue(pSCPVIssue, (PSCorePrdIssue)iEntity);
        }
        if (pSCPVIssue.getPSCorePrdVerId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDVER", (Object)pSCPVIssue.getPSCorePrdVerId())) != null) {
            this.onFillParentInfo_PSCorePrdVer(pSCPVIssue, (PSCorePrdVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCPVIssue pSCPVIssue, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSCPVIssue, bl);
    }

    protected void onCheckEntity(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IssueSN(bl, pSCPVIssue, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCPVIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdIssueId(bl, pSCPVIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdIssueName(bl, pSCPVIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerId(bl, pSCPVIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerName(bl, pSCPVIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCPVIssueId(bl, pSCPVIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCPVIssueName(bl, pSCPVIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSCPVIssue, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IssueSN(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isIssueSNDirty() && !bl2 : !pSCPVIssue.isIssueSNDirty()) {
            return null;
        }
        Integer n = pSCPVIssue.getIssueSN();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESN");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_IssueSN_Default((IEntity)pSCPVIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isMemoDirty() : !pSCPVIssue.isMemoDirty()) {
            return null;
        }
        String string = pSCPVIssue.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSCPVIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdIssueId(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isPSCorePrdIssueIdDirty() : !pSCPVIssue.isPSCorePrdIssueIdDirty()) {
            return null;
        }
        String string = pSCPVIssue.getPSCorePrdIssueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdIssueId_Default((IEntity)pSCPVIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDISSUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdIssueName(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isPSCorePrdIssueNameDirty() : !pSCPVIssue.isPSCorePrdIssueNameDirty()) {
            return null;
        }
        String string = pSCPVIssue.getPSCorePrdIssueName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdIssueName_Default((IEntity)pSCPVIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDISSUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCorePrdVerId(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isPSCorePrdVerIdDirty() : !pSCPVIssue.isPSCorePrdVerIdDirty()) {
            return null;
        }
        String string = pSCPVIssue.getPSCorePrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerId_Default((IEntity)pSCPVIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerName(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isPSCorePrdVerNameDirty() : !pSCPVIssue.isPSCorePrdVerNameDirty()) {
            return null;
        }
        String string = pSCPVIssue.getPSCorePrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerName_Default((IEntity)pSCPVIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCPVIssueId(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isPSCPVIssueIdDirty() && !bl2 : !pSCPVIssue.isPSCPVIssueIdDirty()) {
            return null;
        }
        String string = pSCPVIssue.getPSCPVIssueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVISSUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCPVIssueId_Default((IEntity)pSCPVIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVISSUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCPVIssueName(boolean bl, PSCPVIssue pSCPVIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCPVIssue.isPSCPVIssueNameDirty() && !bl2 : !pSCPVIssue.isPSCPVIssueNameDirty()) {
            return null;
        }
        String string = pSCPVIssue.getPSCPVIssueName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVISSUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCPVIssueName_Default((IEntity)pSCPVIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCPVISSUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCPVIssue pSCPVIssue, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSCPVIssue, bl);
    }

    protected void onSyncIndexEntities(PSCPVIssue pSCPVIssue, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSCPVIssue, bl);
    }

    public Object getDataContextValue(PSCPVIssue pSCPVIssue, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSCPVIssue, string, iDataContextParam)) != null) {
            return object;
        }
        PSCorePrdIssue pSCorePrdIssue = pSCPVIssue.getPSCorePrdIssue();
        if (pSCorePrdIssue != null && pSCorePrdIssue.contains(string)) {
            return pSCorePrdIssue.get(string);
        }
        PSCorePrdVer pSCorePrdVer = pSCPVIssue.getPSCorePrdVer();
        if (pSCorePrdVer != null && pSCorePrdVer.contains(string)) {
            return pSCorePrdVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCPVIssue pSCPVIssue, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSCPVIssue, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISSUESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdIssueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCPVISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCPVIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCPVISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCPVIssueName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_IssueSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSCorePrdIssueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDISSUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCorePrdIssueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCOREPRDISSUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSCPVIssueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCPVISSUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCPVIssueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCPVISSUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCPVIssue pSCPVIssue) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSCPVIssue)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCPVIssue pSCPVIssue) throws Exception {
        super.onUpdateParent((IEntity)pSCPVIssue);
    }

    @Override
    protected void exportCurXmlModel(PSCPVIssue pSCPVIssue, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCPVISSUE");
        if (!bl) {
            pSCPVIssue.setCreateDate(null);
            pSCPVIssue.setCreateMan(null);
            pSCPVIssue.setPSCPVIssueId(null);
            pSCPVIssue.setUpdateDate(null);
            pSCPVIssue.setUpdateMan(null);
            super.exportCurXmlModel(pSCPVIssue, xmlNode, bl);
        }
    }
}

