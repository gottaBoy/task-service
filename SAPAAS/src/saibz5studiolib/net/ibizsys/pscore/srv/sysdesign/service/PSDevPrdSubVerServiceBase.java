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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSubVerDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSubVerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssuePlanService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssuePlanServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSubVerServiceBase
extends PSCoreSysServiceBase<PSDevPrdSubVer> {
    private static final Log log = LogFactory.getLog(PSDevPrdSubVerServiceBase.class);
    public static final String DATASET_CURSUBVER = "CurSubVer";
    public static final String DATASET_CURVER = "CurVer";
    public static final String DATASET_CURVERROOT = "CurVerRoot";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_ROOT = "Root";
    private PSDevPrdSubVerDEModel pSDevPrdSubVerDEModel;
    private PSDevPrdSubVerDAO pSDevPrdSubVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService";
    }

    public PSDevPrdSubVerDEModel getPSDevPrdSubVerDEModel() {
        if (this.pSDevPrdSubVerDEModel == null) {
            try {
                this.pSDevPrdSubVerDEModel = (PSDevPrdSubVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSubVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSubVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdSubVerDEModel();
    }

    public PSDevPrdSubVerDAO getPSDevPrdSubVerDAO() {
        if (this.pSDevPrdSubVerDAO == null) {
            try {
                this.pSDevPrdSubVerDAO = (PSDevPrdSubVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSubVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSubVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdSubVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSUBVER, (boolean)true) == 0) {
            return this.fetchCurSubVer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURVER, (boolean)true) == 0) {
            return this.fetchCurVer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURVERROOT, (boolean)true) == 0) {
            return this.fetchCurVerRoot(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_ROOT, (boolean)true) == 0) {
            return this.fetchRoot(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSubVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSUBVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurVerRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVERROOT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchRoot(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ROOT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevPrdSubVer pSDevPrdSubVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSUBVER_PSDEVPRDSUBVER_PPSDEVPRDSUBVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSubVer pSDevPrdSubVer2 = (PSDevPrdSubVer)iService.getDEModel().createEntity();
            pSDevPrdSubVer2.set("PSDEVPRDSUBVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdSubVer2);
            } else {
                iService.get(pSDevPrdSubVer2);
            }
            this.onFillParentInfo_PPSDevPrdSubVer(pSDevPrdSubVer, pSDevPrdSubVer2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSUBVER_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdVer);
            } else {
                iService.get(pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSubVer, pSDevPrdVer);
            return;
        }
        super.onFillParentInfo(pSDevPrdSubVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, PSDevPrdSubVer pSDevPrdSubVer2) throws Exception {
        pSDevPrdSubVer.setPPSDevPrdSubVerId(pSDevPrdSubVer2.getPSDevPrdSubVerId());
        pSDevPrdSubVer.setPPSDevPrdSubVerName(pSDevPrdSubVer2.getPSDevPrdSubVerName());
        if (pSDevPrdSubVer2.getPSDevPrdVer() != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSubVer, pSDevPrdSubVer2.getPSDevPrdVer());
        }
    }

    protected void onFillParentInfo_PSDevPrdVer(PSDevPrdSubVer pSDevPrdSubVer, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSDevPrdSubVer.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSDevPrdSubVer.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
    }

    protected void onFillEntityFullInfo(PSDevPrdSubVer pSDevPrdSubVer, boolean bl) throws Exception {
        if (bl) {
            if (pSDevPrdSubVer.getSubVerState() == null) {
                pSDevPrdSubVer.setSubVerState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevPrdSubVer.getValidFlag() == null) {
                pSDevPrdSubVer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevPrdSubVer, bl);
        this.onFillEntityFullInfo_PPSDevPrdSubVer(pSDevPrdSubVer, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSDevPrdSubVer, bl);
    }

    protected void onFillEntityFullInfo_PPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSDevPrdSubVer pSDevPrdSubVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevPrdSubVer pSDevPrdSubVer, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevPrdSubVer, bl);
    }

    public ArrayList<PSDevPrdSubVer> selectByPPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase) throws Exception {
        return this.selectByPPSDevPrdSubVer(pSDevPrdSubVerBase, "", -1);
    }

    public ArrayList<PSDevPrdSubVer> selectByPPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string) throws Exception {
        return this.selectByPPSDevPrdSubVer(pSDevPrdSubVerBase, string, -1);
    }

    public ArrayList<PSDevPrdSubVer> selectByPPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVPRDSUBVERID", (Object)pSDevPrdSubVerBase.getPSDevPrdSubVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevPrdSubVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevPrdSubVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSubVer> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSDevPrdSubVer> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSDevPrdSubVer> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
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

    public void testRemoveByPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSubVer> arrayList = this.selectByPPSDevPrdSubVer(pSDevPrdSubVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSUBVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdSubVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSUBVER_PSDEVPRDSUBVER_PPSDEVPRDSUBVERID", "", iDataEntityModel.getName(), "PSDEVPRDSUBVER", iDataEntityModel.getDataInfo(pSDevPrdSubVer), arrayList.get(0)));
        }
    }

    public void resetPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSubVer> arrayList = this.selectByPPSDevPrdSubVer(pSDevPrdSubVer);
        for (PSDevPrdSubVer pSDevPrdSubVer2 : arrayList) {
            PSDevPrdSubVer pSDevPrdSubVer3 = (PSDevPrdSubVer)this.getDEModel().createEntity();
            pSDevPrdSubVer3.setPSDevPrdSubVerId(pSDevPrdSubVer2.getPSDevPrdSubVerId());
            pSDevPrdSubVer3.setPPSDevPrdSubVerId(null);
            this.update(pSDevPrdSubVer3);
        }
    }

    public void removeByPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        final PSDevPrdSubVer pSDevPrdSubVer2 = pSDevPrdSubVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSubVerServiceBase.this.onBeforeRemoveByPPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdSubVerServiceBase.this.internalRemoveByPPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdSubVerServiceBase.this.onAfterRemoveByPPSDevPrdSubVer(pSDevPrdSubVer2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void internalRemoveByPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSubVer> arrayList = this.selectByPPSDevPrdSubVer(pSDevPrdSubVer);
        this.onBeforeRemoveByPPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
        for (PSDevPrdSubVer pSDevPrdSubVer2 : arrayList) {
            this.remove(pSDevPrdSubVer2);
        }
        this.onAfterRemoveByPPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
    }

    protected void onAfterRemoveByPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdSubVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdSubVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSubVer> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSUBVER_PSDEVPRDVER_PSDEVPRDVERID", "", iDataEntityModel.getName(), "PSDEVPRDSUBVER", iDataEntityModel.getDataInfo(pSDevPrdVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSubVer> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSDevPrdSubVer pSDevPrdSubVer : arrayList) {
            PSDevPrdSubVer pSDevPrdSubVer2 = (PSDevPrdSubVer)this.getDEModel().createEntity();
            pSDevPrdSubVer2.setPSDevPrdSubVerId(pSDevPrdSubVer.getPSDevPrdSubVerId());
            pSDevPrdSubVer2.setPSDevPrdVerId(null);
            this.update(pSDevPrdSubVer2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSubVerServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSubVerServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSubVerServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSubVer> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSDevPrdSubVer pSDevPrdSubVer : arrayList) {
            this.remove(pSDevPrdSubVer);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSubVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSubVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevPrdIssuePlanService)ServiceGlobal.getService(PSDevPrdIssuePlanService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdIssuePlanServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdSubVer(pSDevPrdSubVer);
        ((PSDevPrdIssuePlanServiceBase)pSCoreSysServiceBase).removeByPSDevPrdSubVer(pSDevPrdSubVer);
        pSCoreSysServiceBase = (PSDevPrdIssueService)ServiceGlobal.getService(PSDevPrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdSubVer(pSDevPrdSubVer);
        pSCoreSysServiceBase = (PSDevPrdSpecPlanService)ServiceGlobal.getService(PSDevPrdSpecPlanService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSpecPlanServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdSubVer(pSDevPrdSubVer);
        pSCoreSysServiceBase = (PSDevPrdSubVerService)ServiceGlobal.getService(PSDevPrdSubVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSubVerServiceBase)pSCoreSysServiceBase).testRemoveByPPSDevPrdSubVer(pSDevPrdSubVer);
        pSCoreSysServiceBase = (PSDevPrdSysService)ServiceGlobal.getService(PSDevPrdSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdSubVer(pSDevPrdSubVer);
        super.onBeforeRemove(pSDevPrdSubVer);
    }

    protected void replaceParentInfo(PSDevPrdSubVer pSDevPrdSubVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevPrdSubVer, cloneSession);
        if (pSDevPrdSubVer.getPPSDevPrdSubVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSUBVER", (Object)pSDevPrdSubVer.getPPSDevPrdSubVerId())) != null) {
            this.onFillParentInfo_PPSDevPrdSubVer(pSDevPrdSubVer, (PSDevPrdSubVer)iEntity);
        }
        if (pSDevPrdSubVer.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSDevPrdSubVer.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSubVer, (PSDevPrdVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdSubVer pSDevPrdSubVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevPrdSubVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevPrdSubVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevPrdSubVerId(bl, pSDevPrdSubVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSubVerId(bl, pSDevPrdSubVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSubVerName(bl, pSDevPrdSubVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSDevPrdSubVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubVerState(bl, pSDevPrdSubVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevPrdSubVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Ver(bl, pSDevPrdSubVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevPrdSubVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isMemoDirty() : !pSDevPrdSubVer.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdSubVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevPrdSubVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDevPrdSubVerId(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isPPSDevPrdSubVerIdDirty() : !pSDevPrdSubVer.isPPSDevPrdSubVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSubVer.getPPSDevPrdSubVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevPrdSubVerId_Default(pSDevPrdSubVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVPRDSUBVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSubVerId(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isPSDevPrdSubVerIdDirty() && !bl2 : !pSDevPrdSubVer.isPSDevPrdSubVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSubVer.getPSDevPrdSubVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSubVerId_Default(pSDevPrdSubVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdSubVerName(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isPSDevPrdSubVerNameDirty() && !bl2 : !pSDevPrdSubVer.isPSDevPrdSubVerNameDirty()) {
            return null;
        }
        String string = pSDevPrdSubVer.getPSDevPrdSubVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSubVerName_Default(pSDevPrdSubVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isPSDevPrdVerIdDirty() && !bl2 : !pSDevPrdSubVer.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSubVer.getPSDevPrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default(pSDevPrdSubVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_SubVerState(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isSubVerStateDirty() && !bl2 : !pSDevPrdSubVer.isSubVerStateDirty()) {
            return null;
        }
        Integer n = pSDevPrdSubVer.getSubVerState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBVERSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_SubVerState_Default(pSDevPrdSubVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBVERSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isValidFlagDirty() && !bl2 : !pSDevPrdSubVer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevPrdSubVer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevPrdSubVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Ver(boolean bl, PSDevPrdSubVer pSDevPrdSubVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSubVer.isVerDirty() && !bl2 : !pSDevPrdSubVer.isVerDirty()) {
            return null;
        }
        String string = pSDevPrdSubVer.getVer();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Ver_Default(pSDevPrdSubVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdSubVer pSDevPrdSubVer, boolean bl) throws Exception {
        super.onSyncEntity(pSDevPrdSubVer, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdSubVer pSDevPrdSubVer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevPrdSubVer, bl);
    }

    public Object getDataContextValue(PSDevPrdSubVer pSDevPrdSubVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevPrdSubVer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevPrdSubVer, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PPSDEVPRDSUBVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevPrdSubVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVPRDSUBVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevPrdSubVerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SUBVERSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubVerState_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Ver_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevPrdSubVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVPRDSUBVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSDEVPRDSUBVERID", "PSDEVPRDSUBVER", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevPrdSubVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVPRDSUBVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SubVerState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Ver_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevPrdSubVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        super.onUpdateParent(pSDevPrdSubVer);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdSubVer pSDevPrdSubVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDSUBVER");
        if (!bl) {
            pSDevPrdSubVer.setCreateDate(null);
            pSDevPrdSubVer.setCreateMan(null);
            pSDevPrdSubVer.setPSDevPrdSubVerId(null);
            pSDevPrdSubVer.setUpdateDate(null);
            pSDevPrdSubVer.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdSubVer, xmlNode, bl);
        }
    }
}

