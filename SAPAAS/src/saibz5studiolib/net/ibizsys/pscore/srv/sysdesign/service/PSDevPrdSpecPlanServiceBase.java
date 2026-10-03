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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSpecPlanDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSpecPlanDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpec;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpecBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpecPlan;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSpecPlanServiceBase
extends PSCoreSysServiceBase<PSDevPrdSpecPlan> {
    private static final Log log = LogFactory.getLog(PSDevPrdSpecPlanServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevPrdSpecPlanDEModel pSDevPrdSpecPlanDEModel;
    private PSDevPrdSpecPlanDAO pSDevPrdSpecPlanDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanService";
    }

    public PSDevPrdSpecPlanDEModel getPSDevPrdSpecPlanDEModel() {
        if (this.pSDevPrdSpecPlanDEModel == null) {
            try {
                this.pSDevPrdSpecPlanDEModel = (PSDevPrdSpecPlanDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSpecPlanDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSpecPlanDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdSpecPlanDEModel();
    }

    public PSDevPrdSpecPlanDAO getPSDevPrdSpecPlanDAO() {
        if (this.pSDevPrdSpecPlanDAO == null) {
            try {
                this.pSDevPrdSpecPlanDAO = (PSDevPrdSpecPlanDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSpecPlanDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSpecPlanDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdSpecPlanDAO();
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

    protected void onFillParentInfo(PSDevPrdSpecPlan pSDevPrdSpecPlan, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSPECPLAN_PSDEVPRDSPEC_PSDEVPRDSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSpec pSDevPrdSpec = (PSDevPrdSpec)iService.getDEModel().createEntity();
            pSDevPrdSpec.set("PSDEVPRDSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdSpec);
            } else {
                iService.get(pSDevPrdSpec);
            }
            this.onFillParentInfo_PSDevPrdSpec(pSDevPrdSpecPlan, pSDevPrdSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSPECPLAN_PSDEVPRDSUBVER_PSDEVPRDSUBVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSubVer pSDevPrdSubVer = (PSDevPrdSubVer)iService.getDEModel().createEntity();
            pSDevPrdSubVer.set("PSDEVPRDSUBVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdSubVer);
            } else {
                iService.get(pSDevPrdSubVer);
            }
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdSpecPlan, pSDevPrdSubVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSPECPLAN_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdVer);
            } else {
                iService.get(pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSpecPlan, pSDevPrdVer);
            return;
        }
        super.onFillParentInfo(pSDevPrdSpecPlan, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdSpec(PSDevPrdSpecPlan pSDevPrdSpecPlan, PSDevPrdSpec pSDevPrdSpec) throws Exception {
        pSDevPrdSpecPlan.setPSDevPrdSpecId(pSDevPrdSpec.getPSDevPrdSpecId());
        pSDevPrdSpecPlan.setPSDevPrdSpecName(pSDevPrdSpec.getPSDevPrdSpecName());
        if (pSDevPrdSpec.getPSDevPrdVer() != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSpecPlan, pSDevPrdSpec.getPSDevPrdVer());
        }
    }

    protected void onFillParentInfo_PSDevPrdSubVer(PSDevPrdSpecPlan pSDevPrdSpecPlan, PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        pSDevPrdSpecPlan.setPSDevPrdSubVerId(pSDevPrdSubVer.getPSDevPrdSubVerId());
        pSDevPrdSpecPlan.setPSDevPrdSubVerName(pSDevPrdSubVer.getPSDevPrdSubVerName());
        if (pSDevPrdSubVer.getPSDevPrdVer() != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSpecPlan, pSDevPrdSubVer.getPSDevPrdVer());
        }
    }

    protected void onFillParentInfo_PSDevPrdVer(PSDevPrdSpecPlan pSDevPrdSpecPlan, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSDevPrdSpecPlan.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSDevPrdSpecPlan.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
    }

    protected void onFillEntityFullInfo(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevPrdSpecPlan, bl);
        this.onFillEntityFullInfo_PSDevPrdSpec(pSDevPrdSpecPlan, bl);
        this.onFillEntityFullInfo_PSDevPrdSubVer(pSDevPrdSpecPlan, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSDevPrdSpecPlan, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdSpec(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdSubVer(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
        if (pSDevPrdSpecPlan.isPSDevPrdVerIdDirty()) {
            if (pSDevPrdSpecPlan.getPSDevPrdVerId() != null) {
                if (pSDevPrdSpecPlan.getPSDevPrdVerId() == null || pSDevPrdSpecPlan.getPSDevPrdVerName() == null) {
                    PSDevPrdVer pSDevPrdVer = pSDevPrdSpecPlan.getPSDevPrdVer();
                    pSDevPrdSpecPlan.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
                }
            } else {
                pSDevPrdSpecPlan.setPSDevPrdVerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevPrdSpecPlan, bl);
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdSpec(PSDevPrdSpecBase pSDevPrdSpecBase) throws Exception {
        return this.selectByPSDevPrdSpec(pSDevPrdSpecBase, "", -1);
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdSpec(PSDevPrdSpecBase pSDevPrdSpecBase, String string) throws Exception {
        return this.selectByPSDevPrdSpec(pSDevPrdSpecBase, string, -1);
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdSpec(PSDevPrdSpecBase pSDevPrdSpecBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDSPECID", (Object)pSDevPrdSpecBase.getPSDevPrdSpecId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdSpecCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdSpecCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, "", -1);
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, string, -1);
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSDevPrdSpecPlan> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdSpec(pSDevPrdSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSPECPLAN_PSDEVPRDSPEC_PSDEVPRDSPECID", "", iDataEntityModel.getName(), "PSDEVPRDSPECPLAN", iDataEntityModel.getDataInfo(pSDevPrdSpec), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdSpec(pSDevPrdSpec);
        for (PSDevPrdSpecPlan pSDevPrdSpecPlan : arrayList) {
            PSDevPrdSpecPlan pSDevPrdSpecPlan2 = (PSDevPrdSpecPlan)this.getDEModel().createEntity();
            pSDevPrdSpecPlan2.setPSDevPrdSpecPlanId(pSDevPrdSpecPlan.getPSDevPrdSpecPlanId());
            pSDevPrdSpecPlan2.setPSDevPrdSpecId(null);
            this.update(pSDevPrdSpecPlan2);
        }
    }

    public void removeByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        final PSDevPrdSpec pSDevPrdSpec2 = pSDevPrdSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSpecPlanServiceBase.this.onBeforeRemoveByPSDevPrdSpec(pSDevPrdSpec2);
                PSDevPrdSpecPlanServiceBase.this.internalRemoveByPSDevPrdSpec(pSDevPrdSpec2);
                PSDevPrdSpecPlanServiceBase.this.onAfterRemoveByPSDevPrdSpec(pSDevPrdSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
    }

    protected void internalRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdSpec(pSDevPrdSpec);
        this.onBeforeRemoveByPSDevPrdSpec(pSDevPrdSpec, arrayList);
        for (PSDevPrdSpecPlan pSDevPrdSpecPlan : arrayList) {
            this.remove(pSDevPrdSpecPlan);
        }
        this.onAfterRemoveByPSDevPrdSpec(pSDevPrdSpec, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec, ArrayList<PSDevPrdSpecPlan> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec, ArrayList<PSDevPrdSpecPlan> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSUBVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdSubVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSPECPLAN_PSDEVPRDSUBVER_PSDEVPRDSUBVERID", "", iDataEntityModel.getName(), "PSDEVPRDSPECPLAN", iDataEntityModel.getDataInfo(pSDevPrdSubVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        for (PSDevPrdSpecPlan pSDevPrdSpecPlan : arrayList) {
            PSDevPrdSpecPlan pSDevPrdSpecPlan2 = (PSDevPrdSpecPlan)this.getDEModel().createEntity();
            pSDevPrdSpecPlan2.setPSDevPrdSpecPlanId(pSDevPrdSpecPlan.getPSDevPrdSpecPlanId());
            pSDevPrdSpecPlan2.setPSDevPrdSubVerId(null);
            this.update(pSDevPrdSpecPlan2);
        }
    }

    public void removeByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        final PSDevPrdSubVer pSDevPrdSubVer2 = pSDevPrdSubVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSpecPlanServiceBase.this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdSpecPlanServiceBase.this.internalRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdSpecPlanServiceBase.this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
        for (PSDevPrdSpecPlan pSDevPrdSpecPlan : arrayList) {
            this.remove(pSDevPrdSpecPlan);
        }
        this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdSpecPlan> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdSpecPlan> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSDevPrdSpecPlan pSDevPrdSpecPlan : arrayList) {
            PSDevPrdSpecPlan pSDevPrdSpecPlan2 = (PSDevPrdSpecPlan)this.getDEModel().createEntity();
            pSDevPrdSpecPlan2.setPSDevPrdSpecPlanId(pSDevPrdSpecPlan.getPSDevPrdSpecPlanId());
            pSDevPrdSpecPlan2.setPSDevPrdVerId(null);
            this.update(pSDevPrdSpecPlan2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSpecPlanServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSpecPlanServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSpecPlanServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSpecPlan> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSDevPrdSpecPlan pSDevPrdSpecPlan : arrayList) {
            this.remove(pSDevPrdSpecPlan);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSpecPlan> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSpecPlan> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdSpecPlan pSDevPrdSpecPlan) throws Exception {
        super.onBeforeRemove(pSDevPrdSpecPlan);
    }

    protected void replaceParentInfo(PSDevPrdSpecPlan pSDevPrdSpecPlan, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevPrdSpecPlan, cloneSession);
        if (pSDevPrdSpecPlan.getPSDevPrdSpecId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSPEC", (Object)pSDevPrdSpecPlan.getPSDevPrdSpecId())) != null) {
            this.onFillParentInfo_PSDevPrdSpec(pSDevPrdSpecPlan, (PSDevPrdSpec)iEntity);
        }
        if (pSDevPrdSpecPlan.getPSDevPrdSubVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSUBVER", (Object)pSDevPrdSpecPlan.getPSDevPrdSubVerId())) != null) {
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdSpecPlan, (PSDevPrdSubVer)iEntity);
        }
        if (pSDevPrdSpecPlan.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSDevPrdSpecPlan.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSpecPlan, (PSDevPrdVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevPrdSpecPlan, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevPrdSpecPlan, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanState(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSpecId(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSpecPlanId(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSpecPlanName(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSubVerId(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerName(bl, pSDevPrdSpecPlan, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevPrdSpecPlan, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isMemoDirty() : !pSDevPrdSpecPlan.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdSpecPlan.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevPrdSpecPlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isOrderValueDirty() : !pSDevPrdSpecPlan.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevPrdSpecPlan.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDevPrdSpecPlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_PlanState(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isPlanStateDirty() && !bl2 : !pSDevPrdSpecPlan.isPlanStateDirty()) {
            return null;
        }
        Integer n = pSDevPrdSpecPlan.getPlanState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PlanState_Default(pSDevPrdSpecPlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdSpecId(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isPSDevPrdSpecIdDirty() && !bl2 : !pSDevPrdSpecPlan.isPSDevPrdSpecIdDirty()) {
            return null;
        }
        String string = pSDevPrdSpecPlan.getPSDevPrdSpecId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSpecId_Default(pSDevPrdSpecPlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVPRDSUBVERID";
                String string4 = this.checkFieldDupRule(this.getPSDevPrdSpecPlanDEModel(), "PSDEVPRDSPECID", string3, pSDevPrdSpecPlan, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVPRDSPECID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSpecPlanId(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isPSDevPrdSpecPlanIdDirty() && !bl2 : !pSDevPrdSpecPlan.isPSDevPrdSpecPlanIdDirty()) {
            return null;
        }
        String string = pSDevPrdSpecPlan.getPSDevPrdSpecPlanId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECPLANID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSpecPlanId_Default(pSDevPrdSpecPlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECPLANID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSpecPlanName(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isPSDevPrdSpecPlanNameDirty() && !bl2 : !pSDevPrdSpecPlan.isPSDevPrdSpecPlanNameDirty()) {
            return null;
        }
        String string = pSDevPrdSpecPlan.getPSDevPrdSpecPlanName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECPLANNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSpecPlanName_Default(pSDevPrdSpecPlan, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECPLANNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSubVerId(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isPSDevPrdSubVerIdDirty() && !bl2 : !pSDevPrdSpecPlan.isPSDevPrdSubVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSpecPlan.getPSDevPrdSubVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSubVerId_Default(pSDevPrdSpecPlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isPSDevPrdVerIdDirty() : !pSDevPrdSpecPlan.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSpecPlan.getPSDevPrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default(pSDevPrdSpecPlan, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdVerName(boolean bl, PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpecPlan.isPSDevPrdVerNameDirty() : !pSDevPrdSpecPlan.isPSDevPrdVerNameDirty()) {
            return null;
        }
        String string = pSDevPrdSpecPlan.getPSDevPrdVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerName_Default(pSDevPrdSpecPlan, bl2, bl3);
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

    protected void onSyncEntity(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
        super.onSyncEntity(pSDevPrdSpecPlan, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdSpecPlan pSDevPrdSpecPlan, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevPrdSpecPlan, bl);
    }

    public Object getDataContextValue(PSDevPrdSpecPlan pSDevPrdSpecPlan, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevPrdSpecPlan, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevPrdSpec pSDevPrdSpec = pSDevPrdSpecPlan.getPSDevPrdSpec();
        if (pSDevPrdSpec != null && pSDevPrdSpec.contains(string)) {
            return pSDevPrdSpec.get(string);
        }
        PSDevPrdSubVer pSDevPrdSubVer = pSDevPrdSpecPlan.getPSDevPrdSubVer();
        if (pSDevPrdSubVer != null && pSDevPrdSubVer.contains(string)) {
            return pSDevPrdSubVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdSpecPlan pSDevPrdSpecPlan, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevPrdSpecPlan, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECPLANID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecPlanId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECPLANNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecPlanName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDevPrdSpecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSpecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSpecPlanId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECPLANID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSpecPlanName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECPLANNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevPrdSpecPlan pSDevPrdSpecPlan) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevPrdSpecPlan)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdSpecPlan pSDevPrdSpecPlan) throws Exception {
        super.onUpdateParent(pSDevPrdSpecPlan);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdSpecPlan pSDevPrdSpecPlan, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDSPECPLAN");
        if (!bl) {
            pSDevPrdSpecPlan.setCreateDate(null);
            pSDevPrdSpecPlan.setCreateMan(null);
            pSDevPrdSpecPlan.setPSDevPrdSpecPlanId(null);
            pSDevPrdSpecPlan.setUpdateDate(null);
            pSDevPrdSpecPlan.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdSpecPlan, xmlNode, bl);
        }
    }
}

