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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCSearchEngineInstDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSearchEngineInstDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpecBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSearchEngineInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSearchEngineInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSearchEngineInstBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSearchEngineInstServiceBase
extends PSCoreSysServiceBase<PSDCSearchEngineInst> {
    private static final Log log = LogFactory.getLog(PSDCSearchEngineInstServiceBase.class);
    private PSDCSearchEngineInstDEModel pSDCSearchEngineInstDEModel;
    private PSDCSearchEngineInstDAO pSDCSearchEngineInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstService";
    }

    public PSDCSearchEngineInstDEModel getPSDCSearchEngineInstDEModel() {
        if (this.pSDCSearchEngineInstDEModel == null) {
            try {
                this.pSDCSearchEngineInstDEModel = (PSDCSearchEngineInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSearchEngineInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSearchEngineInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCSearchEngineInstDEModel();
    }

    public PSDCSearchEngineInstDAO getPSDCSearchEngineInstDAO() {
        if (this.pSDCSearchEngineInstDAO == null) {
            try {
                this.pSDCSearchEngineInstDAO = (PSDCSearchEngineInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCSearchEngineInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSearchEngineInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCSearchEngineInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDCSearchEngineInst pSDCSearchEngineInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSEARCHENGINEINST_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory());
            PSDCContainerSpec pSDCContainerSpec = (PSDCContainerSpec)iService.getDEModel().createEntity();
            pSDCContainerSpec.set("PSDCCONTAINERSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCContainerSpec);
            } else {
                iService.get(pSDCContainerSpec);
            }
            this.onFillParentInfo_PSDCContainerSpec(pSDCSearchEngineInst, pSDCContainerSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSEARCHENGINEINST_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCFile);
            } else {
                iService.get(pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDCSearchEngineInst, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSEARCHENGINEINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCSearchEngineInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSEARCHENGINEINST_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCSearchEngineInst, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSEARCHENGINEINST_PSSEARCHENGINEINST_PSSEARCHENGINEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSearchEngineInstService", (SessionFactory)this.getSessionFactory());
            PSSearchEngineInst pSSearchEngineInst = (PSSearchEngineInst)iService.getDEModel().createEntity();
            pSSearchEngineInst.set("PSSEARCHENGINEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSearchEngineInst);
            } else {
                iService.get(pSSearchEngineInst);
            }
            this.onFillParentInfo_PSSearchEngineInst(pSDCSearchEngineInst, pSSearchEngineInst);
            return;
        }
        super.onFillParentInfo(pSDCSearchEngineInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCContainerSpec(PSDCSearchEngineInst pSDCSearchEngineInst, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        pSDCSearchEngineInst.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
        pSDCSearchEngineInst.setPSDCContainerSpecName(pSDCContainerSpec.getPSDCContainerSpecName());
    }

    protected void onFillParentInfo_PSDCFile(PSDCSearchEngineInst pSDCSearchEngineInst, PSDCFile pSDCFile) throws Exception {
        pSDCSearchEngineInst.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDCSearchEngineInst.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCSearchEngineInst pSDCSearchEngineInst, PSDevCenter pSDevCenter) throws Exception {
        pSDCSearchEngineInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCSearchEngineInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCSearchEngineInst pSDCSearchEngineInst, PSDevSln pSDevSln) throws Exception {
        pSDCSearchEngineInst.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCSearchEngineInst.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSSearchEngineInst(PSDCSearchEngineInst pSDCSearchEngineInst, PSSearchEngineInst pSSearchEngineInst) throws Exception {
        pSDCSearchEngineInst.setPSSearchEngineInstId(pSSearchEngineInst.getPSSearchEngineInstId());
        pSDCSearchEngineInst.setPSSearchEngineInstName(pSSearchEngineInst.getPSSearchEngineInstName());
    }

    protected void onFillEntityFullInfo(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCSearchEngineInst, bl);
        this.onFillEntityFullInfo_PSDCContainerSpec(pSDCSearchEngineInst, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDCSearchEngineInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCSearchEngineInst, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCSearchEngineInst, bl);
        this.onFillEntityFullInfo_PSSearchEngineInst(pSDCSearchEngineInst, bl);
    }

    protected void onFillEntityFullInfo_PSDCContainerSpec(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
        if (pSDCSearchEngineInst.isPSDevCenterIdDirty()) {
            if (pSDCSearchEngineInst.getPSDevCenterId() != null) {
                if (pSDCSearchEngineInst.getPSDevCenterId() == null || pSDCSearchEngineInst.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCSearchEngineInst.getPSDevCenter();
                    pSDCSearchEngineInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCSearchEngineInst.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSearchEngineInst(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
        if (pSDCSearchEngineInst.isPSSearchEngineInstIdDirty()) {
            if (pSDCSearchEngineInst.getPSSearchEngineInstId() != null) {
                if (pSDCSearchEngineInst.getPSSearchEngineInstId() == null || pSDCSearchEngineInst.getPSSearchEngineInstName() == null) {
                    PSSearchEngineInst pSSearchEngineInst = pSDCSearchEngineInst.getPSSearchEngineInst();
                    pSDCSearchEngineInst.setPSSearchEngineInstName(pSSearchEngineInst.getPSSearchEngineInstName());
                }
            } else {
                pSDCSearchEngineInst.setPSSearchEngineInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCSearchEngineInst, bl);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, "", -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, string, -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCONTAINERSPECID", (Object)pSDCContainerSpecBase.getPSDCContainerSpecId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCContainerSpecCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCContainerSpecCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCFILEID", (Object)pSDCFileBase.getPSDCFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCSearchEngineInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCSearchEngineInst> selectByPSSearchEngineInst(PSSearchEngineInstBase pSSearchEngineInstBase) throws Exception {
        return this.selectByPSSearchEngineInst(pSSearchEngineInstBase, "", -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSSearchEngineInst(PSSearchEngineInstBase pSSearchEngineInstBase, String string) throws Exception {
        return this.selectByPSSearchEngineInst(pSSearchEngineInstBase, string, -1);
    }

    public ArrayList<PSDCSearchEngineInst> selectByPSSearchEngineInst(PSSearchEngineInstBase pSSearchEngineInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSEARCHENGINEINSTID", (Object)pSSearchEngineInstBase.getPSSearchEngineInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSearchEngineInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSearchEngineInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCONTAINERSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCContainerSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSEARCHENGINEINST_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", "", iDataEntityModel.getName(), "PSDCSEARCHENGINEINST", iDataEntityModel.getDataInfo(pSDCContainerSpec), arrayList.get(0)));
        }
    }

    public void resetPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            PSDCSearchEngineInst pSDCSearchEngineInst2 = (PSDCSearchEngineInst)this.getDEModel().createEntity();
            pSDCSearchEngineInst2.setPSDCSearchEngineInstId(pSDCSearchEngineInst.getPSDCSearchEngineInstId());
            pSDCSearchEngineInst2.setPSDCContainerSpecId(null);
            this.update(pSDCSearchEngineInst2);
        }
    }

    public void removeByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        final PSDCContainerSpec pSDCContainerSpec2 = pSDCContainerSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSearchEngineInstServiceBase.this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCSearchEngineInstServiceBase.this.internalRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCSearchEngineInstServiceBase.this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void internalRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            this.remove(pSDCSearchEngineInst);
        }
        this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSEARCHENGINEINST_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDCSEARCHENGINEINST", iDataEntityModel.getDataInfo(pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            PSDCSearchEngineInst pSDCSearchEngineInst2 = (PSDCSearchEngineInst)this.getDEModel().createEntity();
            pSDCSearchEngineInst2.setPSDCSearchEngineInstId(pSDCSearchEngineInst.getPSDCSearchEngineInstId());
            pSDCSearchEngineInst2.setPSDCFileId(null);
            this.update(pSDCSearchEngineInst2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSearchEngineInstServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDCSearchEngineInstServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDCSearchEngineInstServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            this.remove(pSDCSearchEngineInst);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            PSDCSearchEngineInst pSDCSearchEngineInst2 = (PSDCSearchEngineInst)this.getDEModel().createEntity();
            pSDCSearchEngineInst2.setPSDCSearchEngineInstId(pSDCSearchEngineInst.getPSDCSearchEngineInstId());
            pSDCSearchEngineInst2.setPSDevCenterId(null);
            this.update(pSDCSearchEngineInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSearchEngineInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCSearchEngineInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCSearchEngineInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            this.remove(pSDCSearchEngineInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSEARCHENGINEINST_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCSEARCHENGINEINST", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            PSDCSearchEngineInst pSDCSearchEngineInst2 = (PSDCSearchEngineInst)this.getDEModel().createEntity();
            pSDCSearchEngineInst2.setPSDCSearchEngineInstId(pSDCSearchEngineInst.getPSDCSearchEngineInstId());
            pSDCSearchEngineInst2.setPSDevSlnId(null);
            this.update(pSDCSearchEngineInst2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSearchEngineInstServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCSearchEngineInstServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCSearchEngineInstServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            this.remove(pSDCSearchEngineInst);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    public void testRemoveByPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSSearchEngineInst(pSSearchEngineInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSEARCHENGINEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSearchEngineInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSEARCHENGINEINST_PSSEARCHENGINEINST_PSSEARCHENGINEINSTID", "", iDataEntityModel.getName(), "PSDCSEARCHENGINEINST", iDataEntityModel.getDataInfo(pSSearchEngineInst), arrayList.get(0)));
        }
    }

    public void resetPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSSearchEngineInst(pSSearchEngineInst);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            PSDCSearchEngineInst pSDCSearchEngineInst2 = (PSDCSearchEngineInst)this.getDEModel().createEntity();
            pSDCSearchEngineInst2.setPSDCSearchEngineInstId(pSDCSearchEngineInst.getPSDCSearchEngineInstId());
            pSDCSearchEngineInst2.setPSSearchEngineInstId(null);
            this.update(pSDCSearchEngineInst2);
        }
    }

    public void removeByPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst) throws Exception {
        final PSSearchEngineInst pSSearchEngineInst2 = pSSearchEngineInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSearchEngineInstServiceBase.this.onBeforeRemoveByPSSearchEngineInst(pSSearchEngineInst2);
                PSDCSearchEngineInstServiceBase.this.internalRemoveByPSSearchEngineInst(pSSearchEngineInst2);
                PSDCSearchEngineInstServiceBase.this.onAfterRemoveByPSSearchEngineInst(pSSearchEngineInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst) throws Exception {
    }

    protected void internalRemoveByPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst) throws Exception {
        ArrayList<PSDCSearchEngineInst> arrayList = this.selectByPSSearchEngineInst(pSSearchEngineInst);
        this.onBeforeRemoveByPSSearchEngineInst(pSSearchEngineInst, arrayList);
        for (PSDCSearchEngineInst pSDCSearchEngineInst : arrayList) {
            this.remove(pSDCSearchEngineInst);
        }
        this.onAfterRemoveByPSSearchEngineInst(pSSearchEngineInst, arrayList);
    }

    protected void onAfterRemoveByPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSearchEngineInst(PSSearchEngineInst pSSearchEngineInst, ArrayList<PSDCSearchEngineInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCSearchEngineInst pSDCSearchEngineInst) throws Exception {
        super.onBeforeRemove(pSDCSearchEngineInst);
    }

    protected void replaceParentInfo(PSDCSearchEngineInst pSDCSearchEngineInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCSearchEngineInst, cloneSession);
        if (pSDCSearchEngineInst.getPSDCContainerSpecId() != null && (iEntity = cloneSession.getEntity("PSDCCONTAINERSPEC", (Object)pSDCSearchEngineInst.getPSDCContainerSpecId())) != null) {
            this.onFillParentInfo_PSDCContainerSpec(pSDCSearchEngineInst, (PSDCContainerSpec)iEntity);
        }
        if (pSDCSearchEngineInst.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDCSearchEngineInst.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDCSearchEngineInst, (PSDCFile)iEntity);
        }
        if (pSDCSearchEngineInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCSearchEngineInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCSearchEngineInst, (PSDevCenter)iEntity);
        }
        if (pSDCSearchEngineInst.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCSearchEngineInst.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCSearchEngineInst, (PSDevSln)iEntity);
        }
        if (pSDCSearchEngineInst.getPSSearchEngineInstId() != null && (iEntity = cloneSession.getEntity("PSSEARCHENGINEINST", (Object)pSDCSearchEngineInst.getPSSearchEngineInstId())) != null) {
            this.onFillParentInfo_PSSearchEngineInst(pSDCSearchEngineInst, (PSSearchEngineInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCSearchEngineInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSDCSearchEngineInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSearchEngineInstId(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSearchEngineInstName(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSearchEngineInstId(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSearchEngineInstName(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResVer(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEngineType(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsageMode(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDCSearchEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCSearchEngineInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isConnStrDirty() && !bl2 : !pSDCSearchEngineInst.isConnStrDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getConnStr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isExpriedTimeDirty() : !pSDCSearchEngineInst.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCSearchEngineInst.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isIpAddrDirty() && !bl2 : !pSDCSearchEngineInst.isIpAddrDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getIpAddr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isMemoDirty() : !pSDCSearchEngineInst.isMemoDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCSearchEngineInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isParamDirty() : !pSDCSearchEngineInst.isParamDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param2(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isParam2Dirty() : !pSDCSearchEngineInst.isParam2Dirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Port(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPortDirty() && !bl2 : !pSDCSearchEngineInst.isPortDirty()) {
            return null;
        }
        Integer n = pSDCSearchEngineInst.getPort();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSDCContainerSpecIdDirty() : !pSDCSearchEngineInst.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSDCContainerSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCONTAINERSPECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSDCFileIdDirty() : !pSDCSearchEngineInst.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSearchEngineInstId(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSDCSearchEngineInstIdDirty() && !bl2 : !pSDCSearchEngineInst.isPSDCSearchEngineInstIdDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSDCSearchEngineInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSEARCHENGINEINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSearchEngineInstId_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSEARCHENGINEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSearchEngineInstName(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSDCSearchEngineInstNameDirty() && !bl2 : !pSDCSearchEngineInst.isPSDCSearchEngineInstNameDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSDCSearchEngineInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSEARCHENGINEINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSearchEngineInstName_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSEARCHENGINEINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSDevCenterIdDirty() : !pSDCSearchEngineInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCSearchEngineInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSDevCenterNameDirty() : !pSDCSearchEngineInst.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSDevSlnIdDirty() : !pSDCSearchEngineInst.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCSearchEngineInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSearchEngineInstId(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSSearchEngineInstIdDirty() : !pSDCSearchEngineInst.isPSSearchEngineInstIdDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSSearchEngineInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSearchEngineInstId_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSEARCHENGINEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSearchEngineInstName(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isPSSearchEngineInstNameDirty() : !pSDCSearchEngineInst.isPSSearchEngineInstNameDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getPSSearchEngineInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSearchEngineInstName_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSEARCHENGINEINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isResPosDirty() : !pSDCSearchEngineInst.isResPosDirty()) {
            return null;
        }
        Integer n = pSDCSearchEngineInst.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isResReadyTimeDirty() : !pSDCSearchEngineInst.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCSearchEngineInst.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isResStateDirty() : !pSDCSearchEngineInst.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCSearchEngineInst.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResVer(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isResVerDirty() : !pSDCSearchEngineInst.isResVerDirty()) {
            return null;
        }
        Integer n = pSDCSearchEngineInst.getResVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResVer_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchEngineType(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isSearchEngineTypeDirty() : !pSDCSearchEngineInst.isSearchEngineTypeDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getSearchEngineType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchEngineType_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHENGINETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsageMode(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isUsageModeDirty() && !bl2 : !pSDCSearchEngineInst.isUsageModeDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getUsageMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGEMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UsageMode_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isUserNameDirty() : !pSDCSearchEngineInst.isUserNameDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isUserTagDirty() : !pSDCSearchEngineInst.isUserTagDirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCSearchEngineInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isUserTag2Dirty() : !pSDCSearchEngineInst.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCSearchEngineInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isUserTag3Dirty() : !pSDCSearchEngineInst.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSearchEngineInst.isUserTag4Dirty() : !pSDCSearchEngineInst.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDCSearchEngineInst.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDCSearchEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDCSearchEngineInst, bl);
    }

    protected void onSyncIndexEntities(PSDCSearchEngineInst pSDCSearchEngineInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCSearchEngineInst, bl);
    }

    public Object getDataContextValue(PSDCSearchEngineInst pSDCSearchEngineInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCSearchEngineInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCSearchEngineInst pSDCSearchEngineInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCSearchEngineInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Param2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSEARCHENGINEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSearchEngineInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSEARCHENGINEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSearchEngineInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSEARCHENGINEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSearchEngineInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSEARCHENGINEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSearchEngineInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ResVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHENGINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SearchEngineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UsageMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_Param_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Port_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCContainerSpecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCContainerSpecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSearchEngineInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSEARCHENGINEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSearchEngineInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSEARCHENGINEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSearchEngineInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSEARCHENGINEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSearchEngineInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSEARCHENGINEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SearchEngineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHENGINETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_UsageMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USAGEMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCSearchEngineInst pSDCSearchEngineInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCSearchEngineInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCSearchEngineInst pSDCSearchEngineInst) throws Exception {
        super.onUpdateParent(pSDCSearchEngineInst);
    }

    @Override
    protected void exportCurXmlModel(PSDCSearchEngineInst pSDCSearchEngineInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCSEARCHENGINEINST");
        if (!bl) {
            pSDCSearchEngineInst.setCreateDate(null);
            pSDCSearchEngineInst.setCreateMan(null);
            pSDCSearchEngineInst.setPSDCContainerSpecName(null);
            pSDCSearchEngineInst.setPSDCFileName(null);
            pSDCSearchEngineInst.setPSDCSearchEngineInstId(null);
            pSDCSearchEngineInst.setPSDevSlnName(null);
            pSDCSearchEngineInst.setUpdateDate(null);
            pSDCSearchEngineInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDCSearchEngineInst, xmlNode, bl);
        }
    }
}

