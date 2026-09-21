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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysRes;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysResBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnPrdDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPrdDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnPrdServiceBase
extends PSCoreSysServiceBase<PSDepSlnPrd> {
    private static final Log log = LogFactory.getLog(PSDepSlnPrdServiceBase.class);
    public static final String DATASET_CURDEPSLN = "CurDepSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnPrdDEModel pSDepSlnPrdDEModel;
    private PSDepSlnPrdDAO pSDepSlnPrdDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService";
    }

    public PSDepSlnPrdDEModel getPSDepSlnPrdDEModel() {
        if (this.pSDepSlnPrdDEModel == null) {
            try {
                this.pSDepSlnPrdDEModel = (PSDepSlnPrdDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPrdDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnPrdDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnPrdDEModel();
    }

    public PSDepSlnPrdDAO getPSDepSlnPrdDAO() {
        if (this.pSDepSlnPrdDAO == null) {
            try {
                this.pSDepSlnPrdDAO = (PSDepSlnPrdDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnPrdDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnPrdDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnPrdDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPSLN, (boolean)true) == 0) {
            return this.fetchCurDepSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDepSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnPrd pSDepSlnPrd, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNPRD_PSDCSYSRES_PSDCSYSRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysResService", (SessionFactory)this.getSessionFactory());
            PSDCSysRes pSDCSysRes = (PSDCSysRes)iService.getDEModel().createEntity();
            pSDCSysRes.set("PSDCSYSRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCSysRes);
            } else {
                iService.get((IEntity)pSDCSysRes);
            }
            this.onFillParentInfo_PSDCSysRes(pSDepSlnPrd, pSDCSysRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNPRD_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSln);
            } else {
                iService.get((IEntity)pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnPrd, pSDepSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNPRD_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysVer pSDevSlnSysVer = (PSDevSlnSysVer)iService.getDEModel().createEntity();
            pSDevSlnSysVer.set("PSDEVSLNSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysVer);
            } else {
                iService.get((IEntity)pSDevSlnSysVer);
            }
            this.onFillParentInfo_PSDevSlnSysVer(pSDepSlnPrd, pSDevSlnSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNPRD_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst);
            } else {
                iService.get((IEntity)pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSDepSlnPrd, pSSysModelInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnPrd, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCSysRes(PSDepSlnPrd pSDepSlnPrd, PSDCSysRes pSDCSysRes) throws Exception {
        pSDepSlnPrd.setPSDCSysResId(pSDCSysRes.getPSDCSysResId());
        pSDepSlnPrd.setPSDCSysResName(pSDCSysRes.getPSDCSysResName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnPrd pSDepSlnPrd, PSDepSln pSDepSln) throws Exception {
        pSDepSlnPrd.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnPrd.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillParentInfo_PSDevSlnSysVer(PSDepSlnPrd pSDepSlnPrd, PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        pSDepSlnPrd.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
        pSDepSlnPrd.setPSDevSlnSysVerName(pSDevSlnSysVer.getPSDevSlnSysVerName());
    }

    protected void onFillParentInfo_PSSysModelInst(PSDepSlnPrd pSDepSlnPrd, PSSysModelInst pSSysModelInst) throws Exception {
        pSDepSlnPrd.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDepSlnPrd.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnPrd, bl);
        this.onFillEntityFullInfo_PSDCSysRes(pSDepSlnPrd, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnPrd, bl);
        this.onFillEntityFullInfo_PSDevSlnSysVer(pSDepSlnPrd, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSDepSlnPrd, bl);
    }

    protected void onFillEntityFullInfo_PSDCSysRes(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysVer(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnPrd, bl);
    }

    public ArrayList<PSDepSlnPrd> selectByPSDCSysRes(PSDCSysResBase pSDCSysResBase) throws Exception {
        return this.selectByPSDCSysRes(pSDCSysResBase, "", -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSDCSysRes(PSDCSysResBase pSDCSysResBase, String string) throws Exception {
        return this.selectByPSDCSysRes(pSDCSysResBase, string, -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSDCSysRes(PSDCSysResBase pSDCSysResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCSYSRESID", (Object)pSDCSysResBase.getPSDCSysResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCSysResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCSysResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnPrd> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnPrd> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, "", -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, string, -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSVERID", (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnPrd> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSDepSlnPrd> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCSysRes(PSDCSysRes pSDCSysRes) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDCSysRes(pSDCSysRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCSYSRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCSysRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNPRD_PSDCSYSRES_PSDCSYSRESID", "", iDataEntityModel.getName(), "PSDEPSLNPRD", iDataEntityModel.getDataInfo((IEntity)pSDCSysRes), arrayList.get(0)));
        }
    }

    public void resetPSDCSysRes(PSDCSysRes pSDCSysRes) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDCSysRes(pSDCSysRes);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            PSDepSlnPrd pSDepSlnPrd2 = (PSDepSlnPrd)this.getDEModel().createEntity();
            pSDepSlnPrd2.setPSDepSlnPrdId(pSDepSlnPrd.getPSDepSlnPrdId());
            pSDepSlnPrd2.setPSDCSysResId(null);
            this.update(pSDepSlnPrd2);
        }
    }

    public void removeByPSDCSysRes(PSDCSysRes pSDCSysRes) throws Exception {
        final PSDCSysRes pSDCSysRes2 = pSDCSysRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnPrdServiceBase.this.onBeforeRemoveByPSDCSysRes(pSDCSysRes2);
                PSDepSlnPrdServiceBase.this.internalRemoveByPSDCSysRes(pSDCSysRes2);
                PSDepSlnPrdServiceBase.this.onAfterRemoveByPSDCSysRes(pSDCSysRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCSysRes(PSDCSysRes pSDCSysRes) throws Exception {
    }

    protected void internalRemoveByPSDCSysRes(PSDCSysRes pSDCSysRes) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDCSysRes(pSDCSysRes);
        this.onBeforeRemoveByPSDCSysRes(pSDCSysRes, arrayList);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            this.remove((IEntity)pSDepSlnPrd);
        }
        this.onAfterRemoveByPSDCSysRes(pSDCSysRes, arrayList);
    }

    protected void onAfterRemoveByPSDCSysRes(PSDCSysRes pSDCSysRes) throws Exception {
    }

    protected void onBeforeRemoveByPSDCSysRes(PSDCSysRes pSDCSysRes, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCSysRes(PSDCSysRes pSDCSysRes, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            PSDepSlnPrd pSDepSlnPrd2 = (PSDepSlnPrd)this.getDEModel().createEntity();
            pSDepSlnPrd2.setPSDepSlnPrdId(pSDepSlnPrd.getPSDepSlnPrdId());
            pSDepSlnPrd2.setPSDepSlnId(null);
            this.update(pSDepSlnPrd2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnPrdServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnPrdServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnPrdServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            this.remove((IEntity)pSDepSlnPrd);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNPRD_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", "", iDataEntityModel.getName(), "PSDEPSLNPRD", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            PSDepSlnPrd pSDepSlnPrd2 = (PSDepSlnPrd)this.getDEModel().createEntity();
            pSDepSlnPrd2.setPSDepSlnPrdId(pSDepSlnPrd.getPSDepSlnPrdId());
            pSDepSlnPrd2.setPSDevSlnSysVerId(null);
            this.update(pSDepSlnPrd2);
        }
    }

    public void removeByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnPrdServiceBase.this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDepSlnPrdServiceBase.this.internalRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDepSlnPrdServiceBase.this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            this.remove((IEntity)pSDepSlnPrd);
        }
        this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNPRD_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSDEPSLNPRD", iDataEntityModel.getDataInfo((IEntity)pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            PSDepSlnPrd pSDepSlnPrd2 = (PSDepSlnPrd)this.getDEModel().createEntity();
            pSDepSlnPrd2.setPSDepSlnPrdId(pSDepSlnPrd.getPSDepSlnPrdId());
            pSDepSlnPrd2.setPSSysModelInstId(null);
            this.update(pSDepSlnPrd2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnPrdServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSDepSlnPrdServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSDepSlnPrdServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSlnPrd> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSDepSlnPrd pSDepSlnPrd : arrayList) {
            this.remove((IEntity)pSDepSlnPrd);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDepSlnPrd> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnModePrdService)ServiceGlobal.getService(PSDepSlnModePrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnModePrdServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnPrd(pSDepSlnPrd);
        pSCoreSysServiceBase = (PSDepSlnRunLogService)ServiceGlobal.getService(PSDepSlnRunLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnRunLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnPrd(pSDepSlnPrd);
        super.onBeforeRemove(pSDepSlnPrd);
    }

    protected void replaceParentInfo(PSDepSlnPrd pSDepSlnPrd, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnPrd, cloneSession);
        if (pSDepSlnPrd.getPSDCSysResId() != null && (iEntity = cloneSession.getEntity("PSDCSYSRES", (Object)pSDepSlnPrd.getPSDCSysResId())) != null) {
            this.onFillParentInfo_PSDCSysRes(pSDepSlnPrd, (PSDCSysRes)iEntity);
        }
        if (pSDepSlnPrd.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnPrd.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnPrd, (PSDepSln)iEntity);
        }
        if (pSDepSlnPrd.getPSDevSlnSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSVER", (Object)pSDepSlnPrd.getPSDevSlnSysVerId())) != null) {
            this.onFillParentInfo_PSDevSlnSysVer(pSDepSlnPrd, (PSDevSlnSysVer)iEntity);
        }
        if (pSDepSlnPrd.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSDepSlnPrd.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSDepSlnPrd, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnPrd, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EnaDynamicMode(bl, pSDepSlnPrd, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrdType(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysResId(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPrdId(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPrdName(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysVerId(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSDepSlnPrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnPrd, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EnaDynamicMode(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isEnaDynamicModeDirty() : !pSDepSlnPrd.isEnaDynamicModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnPrd.getEnaDynamicMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaDynamicMode_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENADYNAMICMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isMemoDirty() : !pSDepSlnPrd.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnPrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrdType(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isPrdTypeDirty() && !bl2 : !pSDepSlnPrd.isPrdTypeDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getPrdType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRDTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrdType_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysResId(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isPSDCSysResIdDirty() : !pSDepSlnPrd.isPSDCSysResIdDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getPSDCSysResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysResId_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEPSLNID";
                String string4 = this.checkFieldDupRule(this.getPSDepSlnPrdDEModel(), "PSDCSYSRESID", string3, pSDepSlnPrd, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCSYSRESID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnPrd.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnPrdId(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isPSDepSlnPrdIdDirty() && !bl2 : !pSDepSlnPrd.isPSDepSlnPrdIdDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getPSDepSlnPrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPrdId_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnPrdName(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isPSDepSlnPrdNameDirty() && !bl2 : !pSDepSlnPrd.isPSDepSlnPrdNameDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getPSDepSlnPrdName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPrdName_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysVerId(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isPSDevSlnSysVerIdDirty() : !pSDepSlnPrd.isPSDevSlnSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getPSDevSlnSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysVerId_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEPSLNPRDID";
                String string4 = this.checkFieldDupRule(this.getPSDepSlnPrdDEModel(), "PSDEVSLNSYSVERID", string3, pSDepSlnPrd, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSDepSlnPrd pSDepSlnPrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnPrd.isPSSysModelInstIdDirty() : !pSDepSlnPrd.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnPrd.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSDepSlnPrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnPrd, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnPrd pSDepSlnPrd, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnPrd, bl);
    }

    public Object getDataContextValue(PSDepSlnPrd pSDepSlnPrd, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnPrd, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnPrd.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnPrd pSDepSlnPrd, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnPrd, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENADYNAMICMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaDynamicMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrdType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EnaDynamicMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PrdType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRDTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnPrd pSDepSlnPrd) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnPrd)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnPrd);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnPrd pSDepSlnPrd, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNPRD");
        if (!bl) {
            pSDepSlnPrd.setPSSysModelInstId(null);
            pSDepSlnPrd.setPSSysModelInstName(null);
            super.exportCurXmlModel(pSDepSlnPrd, xmlNode, bl);
        }
    }
}

