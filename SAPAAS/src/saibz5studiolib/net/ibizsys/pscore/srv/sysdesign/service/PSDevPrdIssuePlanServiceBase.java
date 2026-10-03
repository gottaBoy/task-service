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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdIssuePlanDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssuePlanDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssueBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssuePlan;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdIssuePlanServiceBase
extends PSCoreSysServiceBase<PSDevPrdIssuePlan> {
    private static final Log log = LogFactory.getLog(PSDevPrdIssuePlanServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevPrdIssuePlanDEModel pSDevPrdIssuePlanDEModel;
    private PSDevPrdIssuePlanDAO pSDevPrdIssuePlanDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssuePlanService";
    }

    public PSDevPrdIssuePlanDEModel getPSDevPrdIssuePlanDEModel() {
        if (this.pSDevPrdIssuePlanDEModel == null) {
            try {
                this.pSDevPrdIssuePlanDEModel = (PSDevPrdIssuePlanDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssuePlanDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdIssuePlanDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdIssuePlanDEModel();
    }

    public PSDevPrdIssuePlanDAO getPSDevPrdIssuePlanDAO() {
        if (this.pSDevPrdIssuePlanDAO == null) {
            try {
                this.pSDevPrdIssuePlanDAO = (PSDevPrdIssuePlanDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdIssuePlanDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdIssuePlanDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdIssuePlanDAO();
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

    protected void onFillParentInfo(PSDevPrdIssuePlan pSDevPrdIssuePlan, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDISSUEPLAN_PSDEVPRDISSUE_PSDEVPRDISSUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueService", (SessionFactory)this.getSessionFactory());
            PSDevPrdIssue pSDevPrdIssue = (PSDevPrdIssue)iService.getDEModel().createEntity();
            pSDevPrdIssue.set("PSDEVPRDISSUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdIssue);
            } else {
                iService.get(pSDevPrdIssue);
            }
            this.onFillParentInfo_PSDevPrdIssue(pSDevPrdIssuePlan, pSDevPrdIssue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDISSUEPLAN_PSDEVPRDSUBVER_PSDEVPRDSUBVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSubVer pSDevPrdSubVer = (PSDevPrdSubVer)iService.getDEModel().createEntity();
            pSDevPrdSubVer.set("PSDEVPRDSUBVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdSubVer);
            } else {
                iService.get(pSDevPrdSubVer);
            }
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdIssuePlan, pSDevPrdSubVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDISSUEPLAN_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdVer);
            } else {
                iService.get(pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdIssuePlan, pSDevPrdVer);
            return;
        }
        super.onFillParentInfo(pSDevPrdIssuePlan, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdIssue(PSDevPrdIssuePlan pSDevPrdIssuePlan, PSDevPrdIssue pSDevPrdIssue) throws Exception {
        pSDevPrdIssuePlan.setPSDevPrdIssueId(pSDevPrdIssue.getPSDevPrdIssueId());
        pSDevPrdIssuePlan.setPSDevPrdIssueName(pSDevPrdIssue.getPSDevPrdIssueName());
        if (pSDevPrdIssue.getPSDevPrdVer() != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdIssuePlan, pSDevPrdIssue.getPSDevPrdVer());
        }
    }

    protected void onFillParentInfo_PSDevPrdSubVer(PSDevPrdIssuePlan pSDevPrdIssuePlan, PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        pSDevPrdIssuePlan.setPSDevPrdSubVerId(pSDevPrdSubVer.getPSDevPrdSubVerId());
        pSDevPrdIssuePlan.setPSDevPrdSubVerName(pSDevPrdSubVer.getPSDevPrdSubVerName());
        if (pSDevPrdSubVer.getPSDevPrdVer() != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdIssuePlan, pSDevPrdSubVer.getPSDevPrdVer());
        }
    }

    protected void onFillParentInfo_PSDevPrdVer(PSDevPrdIssuePlan pSDevPrdIssuePlan, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSDevPrdIssuePlan.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSDevPrdIssuePlan.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
    }

    protected void onFillEntityFullInfo(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevPrdIssuePlan, bl);
        this.onFillEntityFullInfo_PSDevPrdIssue(pSDevPrdIssuePlan, bl);
        this.onFillEntityFullInfo_PSDevPrdSubVer(pSDevPrdIssuePlan, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSDevPrdIssuePlan, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdIssue(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdSubVer(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
        if (pSDevPrdIssuePlan.isPSDevPrdVerIdDirty()) {
            if (pSDevPrdIssuePlan.getPSDevPrdVerId() != null) {
                if (pSDevPrdIssuePlan.getPSDevPrdVerId() == null || pSDevPrdIssuePlan.getPSDevPrdVerName() == null) {
                    PSDevPrdVer pSDevPrdVer = pSDevPrdIssuePlan.getPSDevPrdVer();
                    pSDevPrdIssuePlan.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
                }
            } else {
                pSDevPrdIssuePlan.setPSDevPrdVerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevPrdIssuePlan, bl);
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdIssue(PSDevPrdIssueBase pSDevPrdIssueBase) throws Exception {
        return this.selectByPSDevPrdIssue(pSDevPrdIssueBase, "", -1);
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdIssue(PSDevPrdIssueBase pSDevPrdIssueBase, String string) throws Exception {
        return this.selectByPSDevPrdIssue(pSDevPrdIssueBase, string, -1);
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdIssue(PSDevPrdIssueBase pSDevPrdIssueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDISSUEID", (Object)pSDevPrdIssueBase.getPSDevPrdIssueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdIssueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdIssueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, "", -1);
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, string, -1);
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSDevPrdIssuePlan> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue) throws Exception {
        ArrayList<PSDevPrdIssuePlan> arrayList = this.selectByPSDevPrdIssue(pSDevPrdIssue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDISSUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdIssue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDISSUEPLAN_PSDEVPRDISSUE_PSDEVPRDISSUEID", "", iDataEntityModel.getName(), "PSDEVPRDISSUEPLAN", iDataEntityModel.getDataInfo(pSDevPrdIssue), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue) throws Exception {
        ArrayList<PSDevPrdIssuePlan> arrayList = this.selectByPSDevPrdIssue(pSDevPrdIssue);
        for (PSDevPrdIssuePlan pSDevPrdIssuePlan : arrayList) {
            PSDevPrdIssuePlan pSDevPrdIssuePlan2 = (PSDevPrdIssuePlan)this.getDEModel().createEntity();
            pSDevPrdIssuePlan2.setPSDevPrdIssuePlanId(pSDevPrdIssuePlan.getPSDevPrdIssuePlanId());
            pSDevPrdIssuePlan2.setPSDevPrdIssueId(null);
            this.update(pSDevPrdIssuePlan2);
        }
    }

    public void removeByPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue) throws Exception {
        final PSDevPrdIssue pSDevPrdIssue2 = pSDevPrdIssue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdIssuePlanServiceBase.this.onBeforeRemoveByPSDevPrdIssue(pSDevPrdIssue2);
                PSDevPrdIssuePlanServiceBase.this.internalRemoveByPSDevPrdIssue(pSDevPrdIssue2);
                PSDevPrdIssuePlanServiceBase.this.onAfterRemoveByPSDevPrdIssue(pSDevPrdIssue2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue) throws Exception {
    }

    protected void internalRemoveByPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue) throws Exception {
        ArrayList<PSDevPrdIssuePlan> arrayList = this.selectByPSDevPrdIssue(pSDevPrdIssue);
        this.onBeforeRemoveByPSDevPrdIssue(pSDevPrdIssue, arrayList);
        for (PSDevPrdIssuePlan pSDevPrdIssuePlan : arrayList) {
            this.remove(pSDevPrdIssuePlan);
        }
        this.onAfterRemoveByPSDevPrdIssue(pSDevPrdIssue, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue, ArrayList<PSDevPrdIssuePlan> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdIssue(PSDevPrdIssue pSDevPrdIssue, ArrayList<PSDevPrdIssuePlan> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    public void resetPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdIssuePlan> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        for (PSDevPrdIssuePlan pSDevPrdIssuePlan : arrayList) {
            PSDevPrdIssuePlan pSDevPrdIssuePlan2 = (PSDevPrdIssuePlan)this.getDEModel().createEntity();
            pSDevPrdIssuePlan2.setPSDevPrdIssuePlanId(pSDevPrdIssuePlan.getPSDevPrdIssuePlanId());
            pSDevPrdIssuePlan2.setPSDevPrdSubVerId(null);
            this.update(pSDevPrdIssuePlan2);
        }
    }

    public void removeByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        final PSDevPrdSubVer pSDevPrdSubVer2 = pSDevPrdSubVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdIssuePlanServiceBase.this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdIssuePlanServiceBase.this.internalRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdIssuePlanServiceBase.this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdIssuePlan> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
        for (PSDevPrdIssuePlan pSDevPrdIssuePlan : arrayList) {
            this.remove(pSDevPrdIssuePlan);
        }
        this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdIssuePlan> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdIssuePlan> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdIssuePlan> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSDevPrdIssuePlan pSDevPrdIssuePlan : arrayList) {
            PSDevPrdIssuePlan pSDevPrdIssuePlan2 = (PSDevPrdIssuePlan)this.getDEModel().createEntity();
            pSDevPrdIssuePlan2.setPSDevPrdIssuePlanId(pSDevPrdIssuePlan.getPSDevPrdIssuePlanId());
            pSDevPrdIssuePlan2.setPSDevPrdVerId(null);
            this.update(pSDevPrdIssuePlan2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdIssuePlanServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdIssuePlanServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdIssuePlanServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdIssuePlan> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSDevPrdIssuePlan pSDevPrdIssuePlan : arrayList) {
            this.remove(pSDevPrdIssuePlan);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdIssuePlan> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdIssuePlan> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdIssuePlan pSDevPrdIssuePlan) throws Exception {
        super.onBeforeRemove(pSDevPrdIssuePlan);
    }

    protected void replaceParentInfo(PSDevPrdIssuePlan pSDevPrdIssuePlan, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevPrdIssuePlan, cloneSession);
        if (pSDevPrdIssuePlan.getPSDevPrdIssueId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDISSUE", (Object)pSDevPrdIssuePlan.getPSDevPrdIssueId())) != null) {
            this.onFillParentInfo_PSDevPrdIssue(pSDevPrdIssuePlan, (PSDevPrdIssue)iEntity);
        }
        if (pSDevPrdIssuePlan.getPSDevPrdSubVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSUBVER", (Object)pSDevPrdIssuePlan.getPSDevPrdSubVerId())) != null) {
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdIssuePlan, (PSDevPrdSubVer)iEntity);
        }
        if (pSDevPrdIssuePlan.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSDevPrdIssuePlan.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdIssuePlan, (PSDevPrdVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevPrdIssuePlan, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevPrdIssuePlan, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanState(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdIssueId(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdIssuePlanId(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdIssuePlanName(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSubVerId(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerName(bl, pSDevPrdIssuePlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevPrdIssuePlan, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isMemoDirty() : !pSDevPrdIssuePlan.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdIssuePlan.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevPrdIssuePlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isOrderValueDirty() : !pSDevPrdIssuePlan.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevPrdIssuePlan.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDevPrdIssuePlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlanState(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isPlanStateDirty() && !bl2 : !pSDevPrdIssuePlan.isPlanStateDirty()) {
            return null;
        }
        Integer n = pSDevPrdIssuePlan.getPlanState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PlanState_Default(pSDevPrdIssuePlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdIssueId(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isPSDevPrdIssueIdDirty() && !bl2 : !pSDevPrdIssuePlan.isPSDevPrdIssueIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssuePlan.getPSDevPrdIssueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdIssueId_Default(pSDevPrdIssuePlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVPRDSUBVERID";
                String string4 = this.checkFieldDupRule(this.getPSDevPrdIssuePlanDEModel(), "PSDEVPRDISSUEID", string3, pSDevPrdIssuePlan, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVPRDISSUEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdIssuePlanId(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isPSDevPrdIssuePlanIdDirty() && !bl2 : !pSDevPrdIssuePlan.isPSDevPrdIssuePlanIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssuePlan.getPSDevPrdIssuePlanId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEPLANID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdIssuePlanId_Default(pSDevPrdIssuePlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEPLANID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdIssuePlanName(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isPSDevPrdIssuePlanNameDirty() && !bl2 : !pSDevPrdIssuePlan.isPSDevPrdIssuePlanNameDirty()) {
            return null;
        }
        String string = pSDevPrdIssuePlan.getPSDevPrdIssuePlanName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEPLANNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdIssuePlanName_Default(pSDevPrdIssuePlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDISSUEPLANNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSubVerId(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isPSDevPrdSubVerIdDirty() && !bl2 : !pSDevPrdIssuePlan.isPSDevPrdSubVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssuePlan.getPSDevPrdSubVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSubVerId_Default(pSDevPrdIssuePlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isPSDevPrdVerIdDirty() : !pSDevPrdIssuePlan.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdIssuePlan.getPSDevPrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default(pSDevPrdIssuePlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdVerName(boolean bl, PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdIssuePlan.isPSDevPrdVerNameDirty() : !pSDevPrdIssuePlan.isPSDevPrdVerNameDirty()) {
            return null;
        }
        String string = pSDevPrdIssuePlan.getPSDevPrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerName_Default(pSDevPrdIssuePlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
        super.onSyncEntity(pSDevPrdIssuePlan, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdIssuePlan pSDevPrdIssuePlan, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevPrdIssuePlan, bl);
    }

    public Object getDataContextValue(PSDevPrdIssuePlan pSDevPrdIssuePlan, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevPrdIssuePlan, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevPrdSubVer pSDevPrdSubVer = pSDevPrdIssuePlan.getPSDevPrdSubVer();
        if (pSDevPrdSubVer != null && pSDevPrdSubVer.contains(string)) {
            return pSDevPrdSubVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdIssuePlan pSDevPrdIssuePlan, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevPrdIssuePlan, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLANSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlanState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDISSUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdIssueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDISSUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdIssueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDISSUEPLANID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdIssuePlanId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDISSUEPLANNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdIssuePlanName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PlanState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDevPrdIssuePlanId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDISSUEPLANID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdIssuePlanName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDISSUEPLANNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevPrdIssuePlan pSDevPrdIssuePlan) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevPrdIssuePlan)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdIssuePlan pSDevPrdIssuePlan) throws Exception {
        super.onUpdateParent(pSDevPrdIssuePlan);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdIssuePlan pSDevPrdIssuePlan, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDISSUEPLAN");
        if (!bl) {
            pSDevPrdIssuePlan.setCreateDate(null);
            pSDevPrdIssuePlan.setCreateMan(null);
            pSDevPrdIssuePlan.setPSDevPrdIssuePlanId(null);
            pSDevPrdIssuePlan.setUpdateDate(null);
            pSDevPrdIssuePlan.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdIssuePlan, xmlNode, bl);
        }
    }
}

