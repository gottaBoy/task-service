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
import net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdIssueDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdIssueDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssue;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssueBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVerBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCPVIssueServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdIssueServiceBase
extends PSCoreSysServiceBase<PSCorePrdIssue> {
    private static final Log log = LogFactory.getLog(PSCorePrdIssueServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCorePrdIssueDEModel pSCorePrdIssueDEModel;
    private PSCorePrdIssueDAO pSCorePrdIssueDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService";
    }

    public PSCorePrdIssueDEModel getPSCorePrdIssueDEModel() {
        if (this.pSCorePrdIssueDEModel == null) {
            try {
                this.pSCorePrdIssueDEModel = (PSCorePrdIssueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdIssueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdIssueDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCorePrdIssueDEModel();
    }

    public PSCorePrdIssueDAO getPSCorePrdIssueDAO() {
        if (this.pSCorePrdIssueDAO == null) {
            try {
                this.pSCorePrdIssueDAO = (PSCorePrdIssueDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdIssueDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdIssueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCorePrdIssueDAO();
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

    protected void onFillParentInfo(PSCorePrdIssue pSCorePrdIssue, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDISSUE_PSCOREPRDISSUE_REFPSCOREPRDISSUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService", (SessionFactory)this.getSessionFactory());
            PSCorePrdIssue pSCorePrdIssue2 = (PSCorePrdIssue)iService.getDEModel().createEntity();
            pSCorePrdIssue2.set("PSCOREPRDISSUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrdIssue2);
            } else {
                iService.get(pSCorePrdIssue2);
            }
            this.onFillParentInfo_RefPSCorePrdIssue(pSCorePrdIssue, pSCorePrdIssue2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDISSUE_PSCOREPRDVER_PSCOREPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService", (SessionFactory)this.getSessionFactory());
            PSCorePrdVer pSCorePrdVer = (PSCorePrdVer)iService.getDEModel().createEntity();
            pSCorePrdVer.set("PSCOREPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrdVer);
            } else {
                iService.get(pSCorePrdVer);
            }
            this.onFillParentInfo_PSCoreRepVer(pSCorePrdIssue, pSCorePrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCOREPRDISSUE_PSCOREPRD_PSCOREPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService", (SessionFactory)this.getSessionFactory());
            PSCorePrd pSCorePrd = (PSCorePrd)iService.getDEModel().createEntity();
            pSCorePrd.set("PSCOREPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCorePrd);
            } else {
                iService.get(pSCorePrd);
            }
            this.onFillParentInfo_PSCorePrd(pSCorePrdIssue, pSCorePrd);
            return;
        }
        super.onFillParentInfo(pSCorePrdIssue, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_RefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, PSCorePrdIssue pSCorePrdIssue2) throws Exception {
        pSCorePrdIssue.setRefPSCorePrdIssueId(pSCorePrdIssue2.getPSCorePrdIssueId());
        pSCorePrdIssue.setRefPSCorePrdIssueName(pSCorePrdIssue2.getPSCorePrdIssueName());
    }

    protected void onFillParentInfo_PSCoreRepVer(PSCorePrdIssue pSCorePrdIssue, PSCorePrdVer pSCorePrdVer) throws Exception {
        pSCorePrdIssue.setPSCorePrdVerId(pSCorePrdVer.getPSCorePrdVerId());
        pSCorePrdIssue.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
    }

    protected void onFillParentInfo_PSCorePrd(PSCorePrdIssue pSCorePrdIssue, PSCorePrd pSCorePrd) throws Exception {
        pSCorePrdIssue.setPSCorePrdId(pSCorePrd.getPSCorePrdId());
        pSCorePrdIssue.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
    }

    protected void onFillEntityFullInfo(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSCorePrdIssue, bl);
        this.onFillEntityFullInfo_RefPSCorePrdIssue(pSCorePrdIssue, bl);
        this.onFillEntityFullInfo_PSCoreRepVer(pSCorePrdIssue, bl);
        this.onFillEntityFullInfo_PSCorePrd(pSCorePrdIssue, bl);
    }

    protected void onFillEntityFullInfo_RefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCoreRepVer(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
        if (pSCorePrdIssue.isPSCorePrdVerIdDirty()) {
            if (pSCorePrdIssue.getPSCorePrdVerId() != null) {
                if (pSCorePrdIssue.getPSCorePrdVerId() == null || pSCorePrdIssue.getPSCorePrdVerName() == null) {
                    PSCorePrdVer pSCorePrdVer = pSCorePrdIssue.getPSCoreRepVer();
                    pSCorePrdIssue.setPSCorePrdVerName(pSCorePrdVer.getPSCorePrdVerName());
                }
            } else {
                pSCorePrdIssue.setPSCorePrdVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCorePrd(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
        if (pSCorePrdIssue.isPSCorePrdIdDirty()) {
            if (pSCorePrdIssue.getPSCorePrdId() != null) {
                if (pSCorePrdIssue.getPSCorePrdId() == null || pSCorePrdIssue.getPSCorePrdName() == null) {
                    PSCorePrd pSCorePrd = pSCorePrdIssue.getPSCorePrd();
                    pSCorePrdIssue.setPSCorePrdName(pSCorePrd.getPSCorePrdName());
                }
            } else {
                pSCorePrdIssue.setPSCorePrdName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
        super.onWriteBackParent(pSCorePrdIssue, bl);
    }

    public ArrayList<PSCorePrdIssue> selectByRefPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase) throws Exception {
        return this.selectByRefPSCorePrdIssue(pSCorePrdIssueBase, "", -1);
    }

    public ArrayList<PSCorePrdIssue> selectByRefPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase, String string) throws Exception {
        return this.selectByRefPSCorePrdIssue(pSCorePrdIssueBase, string, -1);
    }

    public ArrayList<PSCorePrdIssue> selectByRefPSCorePrdIssue(PSCorePrdIssueBase pSCorePrdIssueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSCOREPRDISSUEID", (Object)pSCorePrdIssueBase.getPSCorePrdIssueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSCorePrdIssueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSCorePrdIssueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCorePrdIssue> selectByPSCoreRepVer(PSCorePrdVerBase pSCorePrdVerBase) throws Exception {
        return this.selectByPSCoreRepVer(pSCorePrdVerBase, "", -1);
    }

    public ArrayList<PSCorePrdIssue> selectByPSCoreRepVer(PSCorePrdVerBase pSCorePrdVerBase, String string) throws Exception {
        return this.selectByPSCoreRepVer(pSCorePrdVerBase, string, -1);
    }

    public ArrayList<PSCorePrdIssue> selectByPSCoreRepVer(PSCorePrdVerBase pSCorePrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCOREPRDVERID", (Object)pSCorePrdVerBase.getPSCorePrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCoreRepVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCoreRepVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCorePrdIssue> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, "", -1);
    }

    public ArrayList<PSCorePrdIssue> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string) throws Exception {
        return this.selectByPSCorePrd(pSCorePrdBase, string, -1);
    }

    public ArrayList<PSCorePrdIssue> selectByPSCorePrd(PSCorePrdBase pSCorePrdBase, String string, int n) throws Exception {
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

    public void testRemoveByRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByRefPSCorePrdIssue(pSCorePrdIssue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCOREPRDISSUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCorePrdIssue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCOREPRDISSUE_PSCOREPRDISSUE_REFPSCOREPRDISSUEID", "", iDataEntityModel.getName(), "PSCOREPRDISSUE", iDataEntityModel.getDataInfo(pSCorePrdIssue), arrayList.get(0)));
        }
    }

    public void resetRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByRefPSCorePrdIssue(pSCorePrdIssue);
        for (PSCorePrdIssue pSCorePrdIssue2 : arrayList) {
            PSCorePrdIssue pSCorePrdIssue3 = (PSCorePrdIssue)this.getDEModel().createEntity();
            pSCorePrdIssue3.setPSCorePrdIssueId(pSCorePrdIssue2.getPSCorePrdIssueId());
            pSCorePrdIssue3.setRefPSCorePrdIssueId(null);
            this.update(pSCorePrdIssue3);
        }
    }

    public void removeByRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        final PSCorePrdIssue pSCorePrdIssue2 = pSCorePrdIssue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdIssueServiceBase.this.onBeforeRemoveByRefPSCorePrdIssue(pSCorePrdIssue2);
                PSCorePrdIssueServiceBase.this.internalRemoveByRefPSCorePrdIssue(pSCorePrdIssue2);
                PSCorePrdIssueServiceBase.this.onAfterRemoveByRefPSCorePrdIssue(pSCorePrdIssue2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
    }

    protected void internalRemoveByRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByRefPSCorePrdIssue(pSCorePrdIssue);
        this.onBeforeRemoveByRefPSCorePrdIssue(pSCorePrdIssue, arrayList);
        for (PSCorePrdIssue pSCorePrdIssue2 : arrayList) {
            this.remove(pSCorePrdIssue2);
        }
        this.onAfterRemoveByRefPSCorePrdIssue(pSCorePrdIssue, arrayList);
    }

    protected void onAfterRemoveByRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue) throws Exception {
    }

    protected void onBeforeRemoveByRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, ArrayList<PSCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSCorePrdIssue(PSCorePrdIssue pSCorePrdIssue, ArrayList<PSCorePrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSCoreRepVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByPSCoreRepVer(pSCorePrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCOREPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCorePrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCOREPRDISSUE_PSCOREPRDVER_PSCOREPRDVERID", "", iDataEntityModel.getName(), "PSCOREPRDISSUE", iDataEntityModel.getDataInfo(pSCorePrdVer), arrayList.get(0)));
        }
    }

    public void resetPSCoreRepVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByPSCoreRepVer(pSCorePrdVer);
        for (PSCorePrdIssue pSCorePrdIssue : arrayList) {
            PSCorePrdIssue pSCorePrdIssue2 = (PSCorePrdIssue)this.getDEModel().createEntity();
            pSCorePrdIssue2.setPSCorePrdIssueId(pSCorePrdIssue.getPSCorePrdIssueId());
            pSCorePrdIssue2.setPSCorePrdVerId(null);
            this.update(pSCorePrdIssue2);
        }
    }

    public void removeByPSCoreRepVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        final PSCorePrdVer pSCorePrdVer2 = pSCorePrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdIssueServiceBase.this.onBeforeRemoveByPSCoreRepVer(pSCorePrdVer2);
                PSCorePrdIssueServiceBase.this.internalRemoveByPSCoreRepVer(pSCorePrdVer2);
                PSCorePrdIssueServiceBase.this.onAfterRemoveByPSCoreRepVer(pSCorePrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSCoreRepVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void internalRemoveByPSCoreRepVer(PSCorePrdVer pSCorePrdVer) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByPSCoreRepVer(pSCorePrdVer);
        this.onBeforeRemoveByPSCoreRepVer(pSCorePrdVer, arrayList);
        for (PSCorePrdIssue pSCorePrdIssue : arrayList) {
            this.remove(pSCorePrdIssue);
        }
        this.onAfterRemoveByPSCoreRepVer(pSCorePrdVer, arrayList);
    }

    protected void onAfterRemoveByPSCoreRepVer(PSCorePrdVer pSCorePrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSCoreRepVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCoreRepVer(PSCorePrdVer pSCorePrdVer, ArrayList<PSCorePrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    public void resetPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByPSCorePrd(pSCorePrd);
        for (PSCorePrdIssue pSCorePrdIssue : arrayList) {
            PSCorePrdIssue pSCorePrdIssue2 = (PSCorePrdIssue)this.getDEModel().createEntity();
            pSCorePrdIssue2.setPSCorePrdIssueId(pSCorePrdIssue.getPSCorePrdIssueId());
            pSCorePrdIssue2.setPSCorePrdId(null);
            this.update(pSCorePrdIssue2);
        }
    }

    public void removeByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        final PSCorePrd pSCorePrd2 = pSCorePrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCorePrdIssueServiceBase.this.onBeforeRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdIssueServiceBase.this.internalRemoveByPSCorePrd(pSCorePrd2);
                PSCorePrdIssueServiceBase.this.onAfterRemoveByPSCorePrd(pSCorePrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void internalRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
        ArrayList<PSCorePrdIssue> arrayList = this.selectByPSCorePrd(pSCorePrd);
        this.onBeforeRemoveByPSCorePrd(pSCorePrd, arrayList);
        for (PSCorePrdIssue pSCorePrdIssue : arrayList) {
            this.remove(pSCorePrdIssue);
        }
        this.onAfterRemoveByPSCorePrd(pSCorePrd, arrayList);
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd) throws Exception {
    }

    protected void onBeforeRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCorePrd(PSCorePrd pSCorePrd, ArrayList<PSCorePrdIssue> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCorePrdIssueService)ServiceGlobal.getService(PSCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSCorePrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByRefPSCorePrdIssue(pSCorePrdIssue);
        pSCoreSysServiceBase = (PSCPVIssueService)ServiceGlobal.getService(PSCPVIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSCPVIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdIssue(pSCorePrdIssue);
        pSCoreSysServiceBase = (PSDCCorePrdIssueService)ServiceGlobal.getService(PSDCCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCorePrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSCorePrdIssue(pSCorePrdIssue);
        ((PSDCCorePrdIssueServiceBase)pSCoreSysServiceBase).resetPSCorePrdIssue(pSCorePrdIssue);
        super.onBeforeRemove(pSCorePrdIssue);
    }

    protected void replaceParentInfo(PSCorePrdIssue pSCorePrdIssue, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCorePrdIssue, cloneSession);
        if (pSCorePrdIssue.getRefPSCorePrdIssueId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDISSUE", (Object)pSCorePrdIssue.getRefPSCorePrdIssueId())) != null) {
            this.onFillParentInfo_RefPSCorePrdIssue(pSCorePrdIssue, (PSCorePrdIssue)iEntity);
        }
        if (pSCorePrdIssue.getPSCorePrdVerId() != null && (iEntity = cloneSession.getEntity("PSCOREPRDVER", (Object)pSCorePrdIssue.getPSCorePrdVerId())) != null) {
            this.onFillParentInfo_PSCoreRepVer(pSCorePrdIssue, (PSCorePrdVer)iEntity);
        }
        if (pSCorePrdIssue.getPSCorePrdId() != null && (iEntity = cloneSession.getEntity("PSCOREPRD", (Object)pSCorePrdIssue.getPSCorePrdId())) != null) {
            this.onFillParentInfo_PSCorePrd(pSCorePrdIssue, (PSCorePrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCorePrdIssue, bl);
    }

    protected void onCheckEntity(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IssueSN(bl, pSCorePrdIssue, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueState(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueTag(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueTag2(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueUrl(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdId(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdIssueId(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdIssueName(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdName(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerId(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCorePrdVerName(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSCorePrdIssueId(bl, pSCorePrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCorePrdIssue, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IssueSN(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isIssueSNDirty() : !pSCorePrdIssue.isIssueSNDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getIssueSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueSN_Default(pSCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueState(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isIssueStateDirty() && !bl2 : !pSCorePrdIssue.isIssueStateDirty()) {
            return null;
        }
        Integer n = pSCorePrdIssue.getIssueState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_IssueState_Default(pSCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueTag(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isIssueTagDirty() : !pSCorePrdIssue.isIssueTagDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getIssueTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueTag_Default(pSCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueTag2(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isIssueTag2Dirty() : !pSCorePrdIssue.isIssueTag2Dirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getIssueTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueTag2_Default(pSCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueUrl(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isIssueUrlDirty() : !pSCorePrdIssue.isIssueUrlDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getIssueUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueUrl_Default(pSCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isMemoDirty() : !pSCorePrdIssue.isMemoDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdId(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isPSCorePrdIdDirty() : !pSCorePrdIssue.isPSCorePrdIdDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getPSCorePrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdId_Default(pSCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdIssueId(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isPSCorePrdIssueIdDirty() && !bl2 : !pSCorePrdIssue.isPSCorePrdIssueIdDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getPSCorePrdIssueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDISSUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdIssueId_Default(pSCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdIssueName(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isPSCorePrdIssueNameDirty() && !bl2 : !pSCorePrdIssue.isPSCorePrdIssueNameDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getPSCorePrdIssueName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCOREPRDISSUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdIssueName_Default(pSCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdName(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isPSCorePrdNameDirty() : !pSCorePrdIssue.isPSCorePrdNameDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getPSCorePrdName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdName_Default(pSCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerId(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isPSCorePrdVerIdDirty() : !pSCorePrdIssue.isPSCorePrdVerIdDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getPSCorePrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerId_Default(pSCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCorePrdVerName(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isPSCorePrdVerNameDirty() : !pSCorePrdIssue.isPSCorePrdVerNameDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getPSCorePrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCorePrdVerName_Default(pSCorePrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSCorePrdIssueId(boolean bl, PSCorePrdIssue pSCorePrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCorePrdIssue.isRefPSCorePrdIssueIdDirty() : !pSCorePrdIssue.isRefPSCorePrdIssueIdDirty()) {
            return null;
        }
        String string = pSCorePrdIssue.getRefPSCorePrdIssueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSCorePrdIssueId_Default(pSCorePrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSCOREPRDISSUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
        super.onSyncEntity(pSCorePrdIssue, bl);
    }

    protected void onSyncIndexEntities(PSCorePrdIssue pSCorePrdIssue, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCorePrdIssue, bl);
    }

    public Object getDataContextValue(PSCorePrdIssue pSCorePrdIssue, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCorePrdIssue, string, iDataContextParam)) != null) {
            return object;
        }
        PSCorePrd pSCorePrd = pSCorePrdIssue.getPSCorePrd();
        if (pSCorePrd != null && pSCorePrd.contains(string)) {
            return pSCorePrd.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCorePrdIssue pSCorePrdIssue, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCorePrdIssue, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ISSUESTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISSUETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISSUETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISSUEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCOREPRDISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCorePrdIssueName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REFPSCOREPRDISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSCorePrdIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSCOREPRDISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSCorePrdIssueName_Default(iEntity, bl, bl2);
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
        try {
            if (this.checkFieldStringLengthRule("ISSUESN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IssueState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IssueTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ISSUETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IssueTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ISSUETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IssueUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ISSUEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_RefPSCorePrdIssueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSCOREPRDISSUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSCorePrdIssueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSCOREPRDISSUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCorePrdIssue pSCorePrdIssue) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCorePrdIssue)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCorePrdIssue pSCorePrdIssue) throws Exception {
        super.onUpdateParent(pSCorePrdIssue);
    }

    @Override
    protected void exportCurXmlModel(PSCorePrdIssue pSCorePrdIssue, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCOREPRDISSUE");
        if (!bl) {
            pSCorePrdIssue.setCreateDate(null);
            pSCorePrdIssue.setCreateMan(null);
            pSCorePrdIssue.setPSCorePrdIssueId(null);
            pSCorePrdIssue.setRefPSCorePrdIssueName(null);
            pSCorePrdIssue.setUpdateDate(null);
            pSCorePrdIssue.setUpdateMan(null);
            super.exportCurXmlModel(pSCorePrdIssue, xmlNode, bl);
        }
    }
}

