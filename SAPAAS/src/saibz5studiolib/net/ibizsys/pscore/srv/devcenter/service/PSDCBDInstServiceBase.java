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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCBDInstDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCBDInstDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBDDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBDDevInstBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCBDInstServiceBase
extends PSCoreSysServiceBase<PSDCBDInst> {
    private static final Log log = LogFactory.getLog(PSDCBDInstServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCBDInstDEModel pSDCBDInstDEModel;
    private PSDCBDInstDAO pSDCBDInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService";
    }

    public PSDCBDInstDEModel getPSDCBDInstDEModel() {
        if (this.pSDCBDInstDEModel == null) {
            try {
                this.pSDCBDInstDEModel = (PSDCBDInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCBDInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCBDInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCBDInstDEModel();
    }

    public PSDCBDInstDAO getPSDCBDInstDAO() {
        if (this.pSDCBDInstDAO == null) {
            try {
                this.pSDCBDInstDAO = (PSDCBDInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCBDInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCBDInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCBDInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCBDInst pSDCBDInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBDINST_PSBDDEVINST_PSBDDEVINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSBDDevInstService", (SessionFactory)this.getSessionFactory());
            PSBDDevInst pSBDDevInst = (PSBDDevInst)iService.getDEModel().createEntity();
            pSBDDevInst.set("PSBDDEVINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSBDDevInst);
            } else {
                iService.get(pSBDDevInst);
            }
            this.onFillParentInfo_PSBDDevInst(pSDCBDInst, pSBDDevInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBDINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCBDInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBDINST_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCBDInst, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDCBDInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSBDDevInst(PSDCBDInst pSDCBDInst, PSBDDevInst pSBDDevInst) throws Exception {
        pSDCBDInst.setPSBDDevInstId(pSBDDevInst.getPSBDDevInstId());
        pSDCBDInst.setPSBDDevInstName(pSBDDevInst.getPSBDDevInstName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCBDInst pSDCBDInst, PSDevCenter pSDevCenter) throws Exception {
        pSDCBDInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCBDInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCBDInst pSDCBDInst, PSDevSln pSDevSln) throws Exception {
        pSDCBDInst.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCBDInst.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCBDInst, bl);
        this.onFillEntityFullInfo_PSBDDevInst(pSDCBDInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCBDInst, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCBDInst, bl);
    }

    protected void onFillEntityFullInfo_PSBDDevInst(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCBDInst, bl);
    }

    public ArrayList<PSDCBDInst> selectByPSBDDevInst(PSBDDevInstBase pSBDDevInstBase) throws Exception {
        return this.selectByPSBDDevInst(pSBDDevInstBase, "", -1);
    }

    public ArrayList<PSDCBDInst> selectByPSBDDevInst(PSBDDevInstBase pSBDDevInstBase, String string) throws Exception {
        return this.selectByPSBDDevInst(pSBDDevInstBase, string, -1);
    }

    public ArrayList<PSDCBDInst> selectByPSBDDevInst(PSBDDevInstBase pSBDDevInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSBDDEVINSTID", (Object)pSBDDevInstBase.getPSBDDevInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSBDDevInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSBDDevInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCBDInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCBDInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCBDInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCBDInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCBDInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCBDInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSBDDevInst(PSBDDevInst pSBDDevInst) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSBDDevInst(pSBDDevInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSBDDEVINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSBDDevInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCBDINST_PSBDDEVINST_PSBDDEVINSTID", "", iDataEntityModel.getName(), "PSDCBDINST", iDataEntityModel.getDataInfo(pSBDDevInst), arrayList.get(0)));
        }
    }

    public void resetPSBDDevInst(PSBDDevInst pSBDDevInst) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSBDDevInst(pSBDDevInst);
        for (PSDCBDInst pSDCBDInst : arrayList) {
            PSDCBDInst pSDCBDInst2 = (PSDCBDInst)this.getDEModel().createEntity();
            pSDCBDInst2.setPSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
            pSDCBDInst2.setPSBDDevInstId(null);
            this.update(pSDCBDInst2);
        }
    }

    public void removeByPSBDDevInst(PSBDDevInst pSBDDevInst) throws Exception {
        final PSBDDevInst pSBDDevInst2 = pSBDDevInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBDInstServiceBase.this.onBeforeRemoveByPSBDDevInst(pSBDDevInst2);
                PSDCBDInstServiceBase.this.internalRemoveByPSBDDevInst(pSBDDevInst2);
                PSDCBDInstServiceBase.this.onAfterRemoveByPSBDDevInst(pSBDDevInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSBDDevInst(PSBDDevInst pSBDDevInst) throws Exception {
    }

    protected void internalRemoveByPSBDDevInst(PSBDDevInst pSBDDevInst) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSBDDevInst(pSBDDevInst);
        this.onBeforeRemoveByPSBDDevInst(pSBDDevInst, arrayList);
        for (PSDCBDInst pSDCBDInst : arrayList) {
            this.remove(pSDCBDInst);
        }
        this.onAfterRemoveByPSBDDevInst(pSBDDevInst, arrayList);
    }

    protected void onAfterRemoveByPSBDDevInst(PSBDDevInst pSBDDevInst) throws Exception {
    }

    protected void onBeforeRemoveByPSBDDevInst(PSBDDevInst pSBDDevInst, ArrayList<PSDCBDInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSBDDevInst(PSBDDevInst pSBDDevInst, ArrayList<PSDCBDInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCBDInst pSDCBDInst : arrayList) {
            PSDCBDInst pSDCBDInst2 = (PSDCBDInst)this.getDEModel().createEntity();
            pSDCBDInst2.setPSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
            pSDCBDInst2.setPSDevCenterId(null);
            this.update(pSDCBDInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBDInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCBDInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCBDInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCBDInst pSDCBDInst : arrayList) {
            this.remove(pSDCBDInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCBDInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCBDInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCBDINST_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCBDINST", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCBDInst pSDCBDInst : arrayList) {
            PSDCBDInst pSDCBDInst2 = (PSDCBDInst)this.getDEModel().createEntity();
            pSDCBDInst2.setPSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
            pSDCBDInst2.setPSDevSlnId(null);
            this.update(pSDCBDInst2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBDInstServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCBDInstServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCBDInstServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCBDInst> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCBDInst pSDCBDInst : arrayList) {
            this.remove(pSDCBDInst);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCBDInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCBDInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCBDInst pSDCBDInst) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnBDInstService)ServiceGlobal.getService(PSDepSlnBDInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnBDInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDCBDInst(pSDCBDInst);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDCBDInst(pSDCBDInst);
        pSCoreSysServiceBase = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysResServiceBase)pSCoreSysServiceBase).testRemoveByHBasePSDCBDInst(pSDCBDInst);
        pSCoreSysServiceBase = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysResServiceBase)pSCoreSysServiceBase).testRemoveByUHBasePSDCBDInst(pSDCBDInst);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByHBasePSDCDBInst(pSDCBDInst);
        pSCoreSysServiceBase = (PSSysBDInstCfgService)ServiceGlobal.getService(PSSysBDInstCfgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDInstCfgServiceBase)pSCoreSysServiceBase).testRemoveByPSDCBDInst(pSDCBDInst);
        super.onBeforeRemove(pSDCBDInst);
    }

    protected void replaceParentInfo(PSDCBDInst pSDCBDInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCBDInst, cloneSession);
        if (pSDCBDInst.getPSBDDevInstId() != null && (iEntity = cloneSession.getEntity("PSBDDEVINST", (Object)pSDCBDInst.getPSBDDevInstId())) != null) {
            this.onFillParentInfo_PSBDDevInst(pSDCBDInst, (PSBDDevInst)iEntity);
        }
        if (pSDCBDInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCBDInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCBDInst, (PSDevCenter)iEntity);
        }
        if (pSDCBDInst.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCBDInst.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCBDInst, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCBDInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BDType(bl, pSDCBDInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockMode(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockObjId(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockObjType(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSBDDevInstId(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBDInstId(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBDInstName(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCount(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefInfo(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysMemo(bl, pSDCBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCBDInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BDType(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isBDTypeDirty() && !bl2 : !pSDCBDInst.isBDTypeDirty()) {
            return null;
        }
        String string = pSDCBDInst.getBDType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BDTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BDType_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockMode(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isLockModeDirty() : !pSDCBDInst.isLockModeDirty()) {
            return null;
        }
        Integer n = pSDCBDInst.getLockMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockMode_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockObjId(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isLockObjIdDirty() : !pSDCBDInst.isLockObjIdDirty()) {
            return null;
        }
        String string = pSDCBDInst.getLockObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LockObjId_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockObjType(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isLockObjTypeDirty() : !pSDCBDInst.isLockObjTypeDirty()) {
            return null;
        }
        String string = pSDCBDInst.getLockObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LockObjType_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isMemoDirty() : !pSDCBDInst.isMemoDirty()) {
            return null;
        }
        String string = pSDCBDInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCBDInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSBDDevInstId(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isPSBDDevInstIdDirty() : !pSDCBDInst.isPSBDDevInstIdDirty()) {
            return null;
        }
        String string = pSDCBDInst.getPSBDDevInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSBDDevInstId_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSBDDEVINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCBDInstId(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isPSDCBDInstIdDirty() && !bl2 : !pSDCBDInst.isPSDCBDInstIdDirty()) {
            return null;
        }
        String string = pSDCBDInst.getPSDCBDInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBDINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBDInstId_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBDINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCBDInstName(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isPSDCBDInstNameDirty() && !bl2 : !pSDCBDInst.isPSDCBDInstNameDirty()) {
            return null;
        }
        String string = pSDCBDInst.getPSDCBDInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBDINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBDInstName_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBDINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isPSDevCenterIdDirty() && !bl2 : !pSDCBDInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCBDInst.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isPSDevSlnIdDirty() : !pSDCBDInst.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCBDInst.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCount(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isRefCountDirty() : !pSDCBDInst.isRefCountDirty()) {
            return null;
        }
        Integer n = pSDCBDInst.getRefCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefCount_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefInfo(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isRefInfoDirty() : !pSDCBDInst.isRefInfoDirty()) {
            return null;
        }
        String string = pSDCBDInst.getRefInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefInfo_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysMemo(boolean bl, PSDCBDInst pSDCBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBDInst.isSysMemoDirty() : !pSDCBDInst.isSysMemoDirty()) {
            return null;
        }
        String string = pSDCBDInst.getSysMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysMemo_Default(pSDCBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDCBDInst, bl);
    }

    protected void onSyncIndexEntities(PSDCBDInst pSDCBDInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCBDInst, bl);
    }

    public Object getDataContextValue(PSDCBDInst pSDCBDInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCBDInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCBDInst pSDCBDInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCBDInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BDType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSBDDEVINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSBDDevInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSBDDEVINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSBDDevInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysMemo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BDType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BDTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_LockMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LockObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOCKOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOCKOBJTYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_PSBDDevInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSBDDEVINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSBDDevInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSBDDEVINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCBDInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBDINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCBDInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBDINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysMemo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSMEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected boolean onMergeChild(String string, String string2, PSDCBDInst pSDCBDInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCBDInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCBDInst pSDCBDInst) throws Exception {
        super.onUpdateParent(pSDCBDInst);
    }

    @Override
    protected void exportCurXmlModel(PSDCBDInst pSDCBDInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCBDINST");
        if (!bl) {
            pSDCBDInst.setCreateDate(null);
            pSDCBDInst.setCreateMan(null);
            pSDCBDInst.setPSDCBDInstId(null);
            pSDCBDInst.setPSDevSlnName(null);
            pSDCBDInst.setRefCount(null);
            pSDCBDInst.setRefInfo(null);
            pSDCBDInst.setUpdateDate(null);
            pSDCBDInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDCBDInst, xmlNode, bl);
        }
    }
}

