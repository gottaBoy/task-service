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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdIssueDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssueDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssuePlanService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdIssueServiceBase
extends PSCoreSysServiceBase<PSDevPrdIssue> {
    private static final Log log = LogFactory.getLog(PSDevPrdIssueServiceBase.class);
    public static final String DATASET_CURPRD = "CurPrd";
    public static final String DATASET_CURPRDVER = "CurPrdVer";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevPrdIssueDEModel pSDevPrdIssueDEModel;
    private PSDevPrdIssueDAO pSDevPrdIssueDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueService";
    }

    public PSDevPrdIssueDEModel getPSDevPrdIssueDEModel() {
        if (this.pSDevPrdIssueDEModel == null) {
            try {
                this.pSDevPrdIssueDEModel = (PSDevPrdIssueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdIssueDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdIssueDEModel();
    }

    public PSDevPrdIssueDAO getPSDevPrdIssueDAO() {
        if (this.pSDevPrdIssueDAO == null) {
            try {
                this.pSDevPrdIssueDAO = (PSDevPrdIssueDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdIssueDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdIssueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdIssueDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPRD, (boolean)true) == 0) {
            return this.fetchCurPrd(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPRDVER, (boolean)true) == 0) {
            return this.fetchCurPrdVer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurPrd(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPrdVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRDVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevPrdIssue pSDevPrdIssue, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDISSUE_PSDEVPRDSUBVER_PSDEVPRDSUBVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSubVer pSDevPrdSubVer = (PSDevPrdSubVer)iService.getDEModel().createEntity();
            pSDevPrdSubVer.set("PSDEVPRDSUBVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdSubVer);
            } else {
                iService.get((IEntity)pSDevPrdSubVer);
            }
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdIssue, pSDevPrdSubVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDISSUE_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdVer);
            } else {
                iService.get((IEntity)pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdIssue, pSDevPrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDISSUE_PSDEVPRD_PSDEVPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory());
            PSDevPrd pSDevPrd = (PSDevPrd)iService.getDEModel().createEntity();
            pSDevPrd.set("PSDEVPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrd);
            } else {
                iService.get((IEntity)pSDevPrd);
            }
            this.onFillParentInfo_PSDevPrd(pSDevPrdIssue, pSDevPrd);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevPrdIssue, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdSubVer(PSDevPrdIssue pSDevPrdIssue, PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        pSDevPrdIssue.setPSDevPrdSubVerId(pSDevPrdSubVer.getPSDevPrdSubVerId());
        pSDevPrdIssue.setPSDevPrdSubVerName(pSDevPrdSubVer.getPSDevPrdSubVerName());
        if (pSDevPrdSubVer.getPSDevPrdVer() != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdIssue, pSDevPrdSubVer.getPSDevPrdVer());
        }
    }

    protected void onFillParentInfo_PSDevPrdVer(PSDevPrdIssue pSDevPrdIssue, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSDevPrdIssue.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSDevPrdIssue.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
        if (pSDevPrdVer.getPSDevPrd() != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdIssue, pSDevPrdVer.getPSDevPrd());
        }
    }

    protected void onFillParentInfo_PSDevPrd(PSDevPrdIssue pSDevPrdIssue, PSDevPrd pSDevPrd) throws Exception {
        pSDevPrdIssue.setPSDevPrdId(pSDevPrd.getPSDevPrdId());
        pSDevPrdIssue.setPSDevPrdName(pSDevPrd.getPSDevPrdName());
    }

    protected void onFillEntityFullInfo(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevPrdIssue, bl);
        this.onFillEntityFullInfo_PSDevPrdSubVer(pSDevPrdIssue, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSDevPrdIssue, bl);
        this.onFillEntityFullInfo_PSDevPrd(pSDevPrdIssue, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdSubVer(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrd(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevPrdIssue, bl);
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, "", -1);
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, string, -1);
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDSUBVERID", (Object)pSDevPrdSubVerBase.getPSDevPrdSubVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdSubVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdSubVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDVERID", (Object)pSDevPrdVerBase.getPSDevPrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, "", -1);
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, string, -1);
    }

    public ArrayList<PSDevPrdIssue> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDID", (Object)pSDevPrdBase.getPSDevPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSUBVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrdSubVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDISSUE_PSDEVPRDSUBVER_PSDEVPRDSUBVERID", "", iDataEntityModel.getName(), "PSDEVPRDISSUE", iDataEntityModel.getDataInfo((IEntity)pSDevPrdSubVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        for (PSDevPrdIssue pSDevPrdIssue : arrayList) {
            PSDevPrdIssue pSDevPrdIssue2 = (PSDevPrdIssue)this.getDEModel().createEntity();
            pSDevPrdIssue2.setPSDevPrdIssueId(pSDevPrdIssue.getPSDevPrdIssueId());
            pSDevPrdIssue2.setPSDevPrdSubVerId(null);
            this.update(pSDevPrdIssue2);
        }
    }

    public void removeByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        final PSDevPrdSubVer pSDevPrdSubVer2 = pSDevPrdSubVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdIssueServiceBase.this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdIssueServiceBase.this.internalRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdIssueServiceBase.this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
        for (PSDevPrdIssue pSDevPrdIssue : arrayList) {
            this.remove((IEntity)pSDevPrdIssue);
        }
        this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDISSUE_PSDEVPRDVER_PSDEVPRDVERID", "", iDataEntityModel.getName(), "PSDEVPRDISSUE", iDataEntityModel.getDataInfo((IEntity)pSDevPrdVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSDevPrdIssue pSDevPrdIssue : arrayList) {
            PSDevPrdIssue pSDevPrdIssue2 = (PSDevPrdIssue)this.getDEModel().createEntity();
            pSDevPrdIssue2.setPSDevPrdIssueId(pSDevPrdIssue.getPSDevPrdIssueId());
            pSDevPrdIssue2.setPSDevPrdVerId(null);
            this.update(pSDevPrdIssue2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdIssueServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdIssueServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdIssueServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSDevPrdIssue pSDevPrdIssue : arrayList) {
            this.remove((IEntity)pSDevPrdIssue);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdIssue> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrd(pSDevPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDISSUE_PSDEVPRD_PSDEVPRDID", "", iDataEntityModel.getName(), "PSDEVPRDISSUE", iDataEntityModel.getDataInfo((IEntity)pSDevPrd), arrayList.get(0)));
        }
    }

    public void resetPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrd(pSDevPrd);
        for (PSDevPrdIssue pSDevPrdIssue : arrayList) {
            PSDevPrdIssue pSDevPrdIssue2 = (PSDevPrdIssue)this.getDEModel().createEntity();
            pSDevPrdIssue2.setPSDevPrdIssueId(pSDevPrdIssue.getPSDevPrdIssueId());
            pSDevPrdIssue2.setPSDevPrdId(null);
            this.update(pSDevPrdIssue2);
        }
    }

    public void removeByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        final PSDevPrd pSDevPrd2 = pSDevPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdIssueServiceBase.this.onBeforeRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdIssueServiceBase.this.internalRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdIssueServiceBase.this.onAfterRemoveByPSDevPrd(pSDevPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void internalRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdIssue> arrayList = this.selectByPSDevPrd(pSDevPrd);
        this.onBeforeRemoveByPSDevPrd(pSDevPrd, arrayList);
        for (PSDevPrdIssue pSDevPrdIssue : arrayList) {
            this.remove((IEntity)pSDevPrdIssue);
        }
        this.onAfterRemoveByPSDevPrd(pSDevPrd, arrayList);
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdIssue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdIssue> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdIssue pSDevPrdIssue) throws Exception {
        PSDevPrdIssuePlanService pSDevPrdIssuePlanService = (PSDevPrdIssuePlanService)ServiceGlobal.getService(PSDevPrdIssuePlanService.class, (SessionFactory)this.getSessionFactory());
        pSDevPrdIssuePlanService.testRemoveByPSDevPrdIssue(pSDevPrdIssue);
        super.onBeforeRemove(pSDevPrdIssue);
    }

    protected void replaceParentInfo(PSDevPrdIssue pSDevPrdIssue, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevPrdIssue, cloneSession);
        if (pSDevPrdIssue.getPSDevPrdSubVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSUBVER", (Object)pSDevPrdIssue.getPSDevPrdSubVerId())) != null) {
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdIssue, (PSDevPrdSubVer)iEntity);
        }
        if (pSDevPrdIssue.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSDevPrdIssue.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdIssue, (PSDevPrdVer)iEntity);
        }
        if (pSDevPrdIssue.getPSDevPrdId() != null && (iEntity = cloneSession.getEntity("PSDEVPRD", (Object)pSDevPrdIssue.getPSDevPrdId())) != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdIssue, (PSDevPrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevPrdIssue, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSDevPrdIssue, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueSN(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueState(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IssueType(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogTime(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdId(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdIssueId(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdIssueName(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSubVerId(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SolvedContent(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SolvedTime(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevPrdIssue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevPrdIssue, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isContentDirty() : !pSDevPrdIssue.isContentDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueSN(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isIssueSNDirty() : !pSDevPrdIssue.isIssueSNDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getIssueSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueSN_Default((IEntity)pSDevPrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_IssueState(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isIssueStateDirty() && !bl2 : !pSDevPrdIssue.isIssueStateDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getIssueState();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_IssueState_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUESTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IssueType(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isIssueTypeDirty() && !bl2 : !pSDevPrdIssue.isIssueTypeDirty()) {
            return null;
        }
        Integer n = pSDevPrdIssue.getIssueType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_IssueType_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSUETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogTime(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isLogTimeDirty() && !bl2 : !pSDevPrdIssue.isLogTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevPrdIssue.getLogTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_LogTime_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isMemoDirty() : !pSDevPrdIssue.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevPrdIssue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdId(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isPSDevPrdIdDirty() && !bl2 : !pSDevPrdIssue.isPSDevPrdIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getPSDevPrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdId_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdIssueId(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isPSDevPrdIssueIdDirty() && !bl2 : !pSDevPrdIssue.isPSDevPrdIssueIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getPSDevPrdIssueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdIssueId_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdIssueName(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isPSDevPrdIssueNameDirty() && !bl2 : !pSDevPrdIssue.isPSDevPrdIssueNameDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getPSDevPrdIssueName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdIssueName_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSubVerId(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isPSDevPrdSubVerIdDirty() : !pSDevPrdIssue.isPSDevPrdSubVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getPSDevPrdSubVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSubVerId_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isPSDevPrdVerIdDirty() && !bl2 : !pSDevPrdIssue.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getPSDevPrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SolvedContent(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isSolvedContentDirty() : !pSDevPrdIssue.isSolvedContentDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getSolvedContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SolvedContent_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SOLVEDCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SolvedTime(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isSolvedTimeDirty() : !pSDevPrdIssue.isSolvedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevPrdIssue.getSolvedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SolvedTime_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SOLVEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isUserTagDirty() : !pSDevPrdIssue.isUserTagDirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevPrdIssue pSDevPrdIssue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssue.isUserTag2Dirty() : !pSDevPrdIssue.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevPrdIssue.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDevPrdIssue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevPrdIssue, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdIssue pSDevPrdIssue, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevPrdIssue, bl);
    }

    public Object getDataContextValue(PSDevPrdIssue pSDevPrdIssue, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevPrdIssue, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdIssue pSDevPrdIssue, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevPrdIssue, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"ISSUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IssueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdIssueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSUBVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSubVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSUBVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSubVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SOLVEDCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SolvedContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SOLVEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SolvedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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
        try {
            if (this.checkFieldStringLengthRule("ISSUESTATE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IssueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdIssueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDISSUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdIssueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDISSUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSubVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSUBVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSubVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSUBVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SolvedContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SOLVEDCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SolvedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDevPrdIssue pSDevPrdIssue) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevPrdIssue)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdIssue pSDevPrdIssue) throws Exception {
        super.onUpdateParent((IEntity)pSDevPrdIssue);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdIssue pSDevPrdIssue, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDISSUE");
        if (!bl) {
            pSDevPrdIssue.setCreateDate(null);
            pSDevPrdIssue.setCreateMan(null);
            pSDevPrdIssue.setPSDevPrdIssueId(null);
            pSDevPrdIssue.setUpdateDate(null);
            pSDevPrdIssue.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdIssue, xmlNode, bl);
        }
    }
}

