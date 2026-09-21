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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerInstService;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerInstServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerService;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSysModelActionService;
import net.ibizsys.pscore.srv.config.service.PSSysModelActionServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSSysModelInstDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSysModelInstDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstBKService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstBKServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstSumService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstSumServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelInstServiceBase
extends PSCoreSysServiceBase<PSSysModelInst> {
    private static final Log log = LogFactory.getLog(PSSysModelInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_CLONE = "X_CLONE";
    public static final String ACTION_CREATEBACKUP = "CreateBackup";
    public static final String ACTION_CREATEDRAFT = "CreateDraft";
    private PSSysModelInstDEModel pSSysModelInstDEModel;
    private PSSysModelInstDAO pSSysModelInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService";
    }

    public PSSysModelInstDEModel getPSSysModelInstDEModel() {
        if (this.pSSysModelInstDEModel == null) {
            try {
                this.pSSysModelInstDEModel = (PSSysModelInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSysModelInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelInstDEModel();
    }

    public PSSysModelInstDAO getPSSysModelInstDAO() {
        if (this.pSSysModelInstDAO == null) {
            try {
                this.pSSysModelInstDAO = (PSSysModelInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSSysModelInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_CLONE, (boolean)true) == 0) {
            this.cloneModel((PSSysModelInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEBACKUP, (boolean)true) == 0) {
            this.createBackup((PSSysModelInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDRAFT, (boolean)true) == 0) {
            this.createDraft((PSSysModelInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void cloneModel(PSSysModelInst pSSysModelInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_CLONE, 0, (IEntity)pSSysModelInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysModelInst, ACTION_X_CLONE);
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysModelInstServiceBase.this.getService(), PSSysModelInstServiceBase.ACTION_X_CLONE, 40, (IEntity)pSSysModelInst2, null).getResult() != 1) {
                    PSSysModelInstServiceBase.this.onCloneModel(pSSysModelInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_CLONE, 99, (IEntity)pSSysModelInst, null);
        }
    }

    protected void onCloneModel(PSSysModelInst pSSysModelInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_CLONE]");
    }

    public void createBackup(PSSysModelInst pSSysModelInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEBACKUP, 0, (IEntity)pSSysModelInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysModelInst, ACTION_CREATEBACKUP);
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysModelInstServiceBase.this.getService(), PSSysModelInstServiceBase.ACTION_CREATEBACKUP, 40, (IEntity)pSSysModelInst2, null).getResult() != 1) {
                    PSSysModelInstServiceBase.this.onCreateBackup(pSSysModelInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEBACKUP, 99, (IEntity)pSSysModelInst, null);
        }
    }

    protected void onCreateBackup(PSSysModelInst pSSysModelInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateBackup]");
    }

    public void createDraft(PSSysModelInst pSSysModelInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDRAFT, 0, (IEntity)pSSysModelInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysModelInst, ACTION_CREATEDRAFT);
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysModelInstServiceBase.this.getService(), PSSysModelInstServiceBase.ACTION_CREATEDRAFT, 40, (IEntity)pSSysModelInst2, null).getResult() != 1) {
                    PSSysModelInstServiceBase.this.onCreateDraft(pSSysModelInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDRAFT, 99, (IEntity)pSSysModelInst, null);
        }
    }

    protected void onCreateDraft(PSSysModelInst pSSysModelInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDraft]");
    }

    protected void onFillParentInfo(PSSysModelInst pSSysModelInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINST_PSDBSERVER_PSDBSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService", (SessionFactory)this.getSessionFactory());
            PSDBServer pSDBServer = (PSDBServer)iService.getDEModel().createEntity();
            pSDBServer.set("PSDBSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBServer);
            } else {
                iService.get((IEntity)pSDBServer);
            }
            this.onFillParentInfo_PSDBServer(pSSysModelInst, pSDBServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSSysModelInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINST_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSvrDomain);
            } else {
                iService.get((IEntity)pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSSysModelInst, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINST_PSSYSMODELINST_CONFPSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst2 = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst2.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst2);
            } else {
                iService.get((IEntity)pSSysModelInst2);
            }
            this.onFillParentInfo_ConfPSSysModelInst(pSSysModelInst, pSSysModelInst2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINST_PSSYSMODELINST_TEMPPSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst3 = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst3.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst3);
            } else {
                iService.get((IEntity)pSSysModelInst3);
            }
            this.onFillParentInfo_TempPSSysModelInst(pSSysModelInst, pSSysModelInst3);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysModelInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBServer(PSSysModelInst pSSysModelInst, PSDBServer pSDBServer) throws Exception {
        pSSysModelInst.setPSDBServerId(pSDBServer.getPSDBServerId());
        pSSysModelInst.setPSDBServerName(pSDBServer.getPSDBServerName());
    }

    protected void onFillParentInfo_PSDevCenter(PSSysModelInst pSSysModelInst, PSDevCenter pSDevCenter) throws Exception {
        pSSysModelInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSSysModelInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSSysModelInst pSSysModelInst, PSSvrDomain pSSvrDomain) throws Exception {
        pSSysModelInst.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSSysModelInst.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_ConfPSSysModelInst(PSSysModelInst pSSysModelInst, PSSysModelInst pSSysModelInst2) throws Exception {
        pSSysModelInst.setConfPSSysModelInstId(pSSysModelInst2.getPSSysModelInstId());
        pSSysModelInst.setConfPSSysModelInstName(pSSysModelInst2.getPSSysModelInstName());
    }

    protected void onFillParentInfo_TempPSSysModelInst(PSSysModelInst pSSysModelInst, PSSysModelInst pSSysModelInst2) throws Exception {
        pSSysModelInst.setTempPSSysModelInstId(pSSysModelInst2.getPSSysModelInstId());
        pSSysModelInst.setTempPSSysModelInstName(pSSysModelInst2.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
        if (bl && pSSysModelInst.getShareFlag() == null) {
            pSSysModelInst.setShareFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysModelInst, bl);
        this.onFillEntityFullInfo_PSDBServer(pSSysModelInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSSysModelInst, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSSysModelInst, bl);
        this.onFillEntityFullInfo_ConfPSSysModelInst(pSSysModelInst, bl);
        this.onFillEntityFullInfo_TempPSSysModelInst(pSSysModelInst, bl);
    }

    protected void onFillEntityFullInfo_PSDBServer(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ConfPSSysModelInst(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
        if (pSSysModelInst.isConfPSSysModelInstIdDirty()) {
            if (pSSysModelInst.getConfPSSysModelInstId() != null) {
                if (pSSysModelInst.getConfPSSysModelInstId() == null || pSSysModelInst.getConfPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst2 = pSSysModelInst.getConfPSSysModelInst();
                    pSSysModelInst.setConfPSSysModelInstName(pSSysModelInst2.getPSSysModelInstName());
                }
            } else {
                pSSysModelInst.setConfPSSysModelInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TempPSSysModelInst(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
        if (pSSysModelInst.isTempPSSysModelInstIdDirty()) {
            if (pSSysModelInst.getTempPSSysModelInstId() != null) {
                if (pSSysModelInst.getTempPSSysModelInstId() == null || pSSysModelInst.getTempPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst2 = pSSysModelInst.getTempPSSysModelInst();
                    pSSysModelInst.setTempPSSysModelInstName(pSSysModelInst2.getPSSysModelInstName());
                }
            } else {
                pSSysModelInst.setTempPSSysModelInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysModelInst, bl);
    }

    public ArrayList<PSSysModelInst> selectByPSDBServer(PSDBServerBase pSDBServerBase) throws Exception {
        return this.selectByPSDBServer(pSDBServerBase, "", -1);
    }

    public ArrayList<PSSysModelInst> selectByPSDBServer(PSDBServerBase pSDBServerBase, String string) throws Exception {
        return this.selectByPSDBServer(pSDBServerBase, string, -1);
    }

    public ArrayList<PSSysModelInst> selectByPSDBServer(PSDBServerBase pSDBServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBSERVERID", (Object)pSDBServerBase.getPSDBServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSSysModelInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSSysModelInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysModelInst> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSSysModelInst> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSSysModelInst> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVRDOMAINID", (Object)pSSvrDomainBase.getPSSvrDomainId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSvrDomainCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSvrDomainCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelInst> selectByConfPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByConfPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSSysModelInst> selectByConfPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByConfPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSSysModelInst> selectByConfPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONFPSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByConfPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByConfPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelInst> selectByTempPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByTempPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSSysModelInst> selectByTempPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByTempPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSSysModelInst> selectByTempPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEMPPSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTempPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTempPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSDBServer(pSDBServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELINST_PSDBSERVER_PSDBSERVERID", "", iDataEntityModel.getName(), "PSSYSMODELINST", iDataEntityModel.getDataInfo((IEntity)pSDBServer), arrayList.get(0)));
        }
    }

    public void resetPSDBServer(PSDBServer pSDBServer) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSDBServer(pSDBServer);
        for (PSSysModelInst pSSysModelInst : arrayList) {
            PSSysModelInst pSSysModelInst2 = (PSSysModelInst)this.getDEModel().createEntity();
            pSSysModelInst2.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
            pSSysModelInst2.setPSDBServerId(null);
            this.update(pSSysModelInst2);
        }
    }

    public void removeByPSDBServer(PSDBServer pSDBServer) throws Exception {
        final PSDBServer pSDBServer2 = pSDBServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstServiceBase.this.onBeforeRemoveByPSDBServer(pSDBServer2);
                PSSysModelInstServiceBase.this.internalRemoveByPSDBServer(pSDBServer2);
                PSSysModelInstServiceBase.this.onAfterRemoveByPSDBServer(pSDBServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
    }

    protected void internalRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSDBServer(pSDBServer);
        this.onBeforeRemoveByPSDBServer(pSDBServer, arrayList);
        for (PSSysModelInst pSSysModelInst : arrayList) {
            this.remove((IEntity)pSSysModelInst);
        }
        this.onAfterRemoveByPSDBServer(pSDBServer, arrayList);
    }

    protected void onAfterRemoveByPSDBServer(PSDBServer pSDBServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDBServer(PSDBServer pSDBServer, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBServer(PSDBServer pSDBServer, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELINST_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSSYSMODELINST", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSSysModelInst pSSysModelInst : arrayList) {
            PSSysModelInst pSSysModelInst2 = (PSSysModelInst)this.getDEModel().createEntity();
            pSSysModelInst2.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
            pSSysModelInst2.setPSDevCenterId(null);
            this.update(pSSysModelInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSSysModelInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSSysModelInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSSysModelInst pSSysModelInst : arrayList) {
            this.remove((IEntity)pSSysModelInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELINST_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSSYSMODELINST", iDataEntityModel.getDataInfo((IEntity)pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSSysModelInst pSSysModelInst : arrayList) {
            PSSysModelInst pSSysModelInst2 = (PSSysModelInst)this.getDEModel().createEntity();
            pSSysModelInst2.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
            pSSysModelInst2.setPSSvrDomainId(null);
            this.update(pSSysModelInst2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSSysModelInstServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSSysModelInstServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSSysModelInst pSSysModelInst : arrayList) {
            this.remove((IEntity)pSSysModelInst);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    public void testRemoveByConfPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByConfPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELINST_PSSYSMODELINST_CONFPSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSSYSMODELINST", iDataEntityModel.getDataInfo((IEntity)pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetConfPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByConfPSSysModelInst(pSSysModelInst);
        for (PSSysModelInst pSSysModelInst2 : arrayList) {
            PSSysModelInst pSSysModelInst3 = (PSSysModelInst)this.getDEModel().createEntity();
            pSSysModelInst3.setPSSysModelInstId(pSSysModelInst2.getPSSysModelInstId());
            pSSysModelInst3.setConfPSSysModelInstId(null);
            this.update(pSSysModelInst3);
        }
    }

    public void removeByConfPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstServiceBase.this.onBeforeRemoveByConfPSSysModelInst(pSSysModelInst2);
                PSSysModelInstServiceBase.this.internalRemoveByConfPSSysModelInst(pSSysModelInst2);
                PSSysModelInstServiceBase.this.onAfterRemoveByConfPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByConfPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByConfPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByConfPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByConfPSSysModelInst(pSSysModelInst, arrayList);
        for (PSSysModelInst pSSysModelInst2 : arrayList) {
            this.remove((IEntity)pSSysModelInst2);
        }
        this.onAfterRemoveByConfPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByConfPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByConfPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByConfPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    public void testRemoveByTempPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByTempPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELINST_PSSYSMODELINST_TEMPPSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSSYSMODELINST", iDataEntityModel.getDataInfo((IEntity)pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetTempPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByTempPSSysModelInst(pSSysModelInst);
        for (PSSysModelInst pSSysModelInst2 : arrayList) {
            PSSysModelInst pSSysModelInst3 = (PSSysModelInst)this.getDEModel().createEntity();
            pSSysModelInst3.setPSSysModelInstId(pSSysModelInst2.getPSSysModelInstId());
            pSSysModelInst3.setTempPSSysModelInstId(null);
            this.update(pSSysModelInst3);
        }
    }

    public void removeByTempPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstServiceBase.this.onBeforeRemoveByTempPSSysModelInst(pSSysModelInst2);
                PSSysModelInstServiceBase.this.internalRemoveByTempPSSysModelInst(pSSysModelInst2);
                PSSysModelInstServiceBase.this.onAfterRemoveByTempPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByTempPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByTempPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInst> arrayList = this.selectByTempPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByTempPSSysModelInst(pSSysModelInst, arrayList);
        for (PSSysModelInst pSSysModelInst2 : arrayList) {
            this.remove((IEntity)pSSysModelInst2);
        }
        this.onAfterRemoveByTempPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByTempPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByTempPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTempPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelInst pSSysModelInst) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCSysModelInstService)ServiceGlobal.getService(PSDCSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysModelInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSDepSlnPrdService)ServiceGlobal.getService(PSDepSlnPrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnPrdServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDepInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSubSysVerInstService)ServiceGlobal.getService(PSSubSysVerInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysVerInstServiceBase)pSCoreSysServiceBase).testRemoveByPssysmodelinst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSubSysVerService)ServiceGlobal.getService(PSSubSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSysModelActionService)ServiceGlobal.getService(PSSysModelActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        ((PSSysModelActionServiceBase)pSCoreSysServiceBase).removeByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSysModelActionService)ServiceGlobal.getService(PSSysModelActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelActionServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSSysModelInst(pSSysModelInst);
        ((PSSysModelActionServiceBase)pSCoreSysServiceBase).removeBySrcPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSysModelInstBKService)ServiceGlobal.getService(PSSysModelInstBKService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelInstBKServiceBase)pSCoreSysServiceBase).testRemoveByPssysmodelinst(pSSysModelInst);
        ((PSSysModelInstBKServiceBase)pSCoreSysServiceBase).removeByPssysmodelinst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSysModelInstSumService)ServiceGlobal.getService(PSSysModelInstSumService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelInstSumServiceBase)pSCoreSysServiceBase).testRemoveByPSSysModelInst(pSSysModelInst);
        ((PSSysModelInstSumServiceBase)pSCoreSysServiceBase).removeByPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelInstServiceBase)pSCoreSysServiceBase).testRemoveByConfPSSysModelInst(pSSysModelInst);
        pSCoreSysServiceBase = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelInstServiceBase)pSCoreSysServiceBase).testRemoveByTempPSSysModelInst(pSSysModelInst);
        super.onBeforeRemove(pSSysModelInst);
    }

    protected void replaceParentInfo(PSSysModelInst pSSysModelInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysModelInst, cloneSession);
        if (pSSysModelInst.getPSDBServerId() != null && (iEntity = cloneSession.getEntity("PSDBSERVER", (Object)pSSysModelInst.getPSDBServerId())) != null) {
            this.onFillParentInfo_PSDBServer(pSSysModelInst, (PSDBServer)iEntity);
        }
        if (pSSysModelInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSSysModelInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSSysModelInst, (PSDevCenter)iEntity);
        }
        if (pSSysModelInst.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSSysModelInst.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSSysModelInst, (PSSvrDomain)iEntity);
        }
        if (pSSysModelInst.getConfPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSSysModelInst.getConfPSSysModelInstId())) != null) {
            this.onFillParentInfo_ConfPSSysModelInst(pSSysModelInst, (PSSysModelInst)iEntity);
        }
        if (pSSysModelInst.getTempPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSSysModelInst.getTempPSSysModelInstId())) != null) {
            this.onFillParentInfo_TempPSSysModelInst(pSSysModelInst, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysModelInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginCalcTime(bl, pSSysModelInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginMaintainTime(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConfPSSysModelInstId(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConfPSSysModelInstName(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConnStr(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CurDBAction(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBName(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBType(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndCalcTime(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndMaintainTime(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitPoolSize(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstGroup(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstState(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxPoolSize(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinPoolSize(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelVer(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PassWD(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PatchNum(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBServerId(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstName(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefInfo(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RowCnt(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShareFlag(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysRowKey(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysType(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempPSSysModelInstId(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempPSSysModelInstName(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsedSize(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSSysModelInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysModelInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginCalcTime(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isBeginCalcTimeDirty() : !pSSysModelInst.isBeginCalcTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysModelInst.getBeginCalcTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginCalcTime_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINCALCTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginMaintainTime(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isBeginMaintainTimeDirty() : !pSSysModelInst.isBeginMaintainTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysModelInst.getBeginMaintainTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginMaintainTime_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINMAINTAINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConfPSSysModelInstId(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isConfPSSysModelInstIdDirty() : !pSSysModelInst.isConfPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysModelInst.getConfPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConfPSSysModelInstId_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONFPSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConfPSSysModelInstName(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isConfPSSysModelInstNameDirty() : !pSSysModelInst.isConfPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSSysModelInst.getConfPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConfPSSysModelInstName_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONFPSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isConnStrDirty() && !bl2 : !pSSysModelInst.isConnStrDirty()) {
            return null;
        }
        String string = pSSysModelInst.getConnStr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_CurDBAction(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isCurDBActionDirty() : !pSSysModelInst.isCurDBActionDirty()) {
            return null;
        }
        String string = pSSysModelInst.getCurDBAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CurDBAction_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURDBACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBName(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isDBNameDirty() && !bl2 : !pSSysModelInst.isDBNameDirty()) {
            return null;
        }
        String string = pSSysModelInst.getDBName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBName_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isDBTypeDirty() && !bl2 : !pSSysModelInst.isDBTypeDirty()) {
            return null;
        }
        String string = pSSysModelInst.getDBType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndCalcTime(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isEndCalcTimeDirty() : !pSSysModelInst.isEndCalcTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysModelInst.getEndCalcTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndCalcTime_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDCALCTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndMaintainTime(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isEndMaintainTimeDirty() : !pSSysModelInst.isEndMaintainTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysModelInst.getEndMaintainTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndMaintainTime_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDMAINTAINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isExpriedTimeDirty() : !pSSysModelInst.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysModelInst.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_InitPoolSize(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isInitPoolSizeDirty() : !pSSysModelInst.isInitPoolSizeDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getInitPoolSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InitPoolSize_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPOOLSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstGroup(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isInstGroupDirty() : !pSSysModelInst.isInstGroupDirty()) {
            return null;
        }
        String string = pSSysModelInst.getInstGroup();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstGroup_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTGROUP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstState(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isInstStateDirty() && !bl2 : !pSSysModelInst.isInstStateDirty()) {
            return null;
        }
        String string = pSSysModelInst.getInstState();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstState_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxPoolSize(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isMaxPoolSizeDirty() : !pSSysModelInst.isMaxPoolSizeDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getMaxPoolSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxPoolSize_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXPOOLSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isMemoDirty() : !pSSysModelInst.isMemoDirty()) {
            return null;
        }
        String string = pSSysModelInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinPoolSize(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isMinPoolSizeDirty() : !pSSysModelInst.isMinPoolSizeDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getMinPoolSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinPoolSize_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINPOOLSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelVer(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isModelVerDirty() : !pSSysModelInst.isModelVerDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getModelVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelVer_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isOrderValueDirty() : !pSSysModelInst.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParamDirty() : !pSSysModelInst.isParamDirty()) {
            return null;
        }
        String string = pSSysModelInst.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param2(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParam2Dirty() : !pSSysModelInst.isParam2Dirty()) {
            return null;
        }
        String string = pSSysModelInst.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param3(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParam3Dirty() : !pSSysModelInst.isParam3Dirty()) {
            return null;
        }
        String string = pSSysModelInst.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param4(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParam4Dirty() : !pSSysModelInst.isParam4Dirty()) {
            return null;
        }
        String string = pSSysModelInst.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param5(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParam5Dirty() : !pSSysModelInst.isParam5Dirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param5_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param6(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParam6Dirty() : !pSSysModelInst.isParam6Dirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param6_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param7(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParam7Dirty() : !pSSysModelInst.isParam7Dirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param7_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param8(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isParam8Dirty() : !pSSysModelInst.isParam8Dirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param8_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PassWD(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isPassWDDirty() && !bl2 : !pSSysModelInst.isPassWDDirty()) {
            return null;
        }
        String string = pSSysModelInst.getPassWD();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PassWD_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PatchNum(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isPatchNumDirty() : !pSSysModelInst.isPatchNumDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getPatchNum();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PatchNum_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PATCHNUM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBServerId(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isPSDBServerIdDirty() : !pSSysModelInst.isPSDBServerIdDirty()) {
            return null;
        }
        String string = pSSysModelInst.getPSDBServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBServerId_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isPSDevCenterIdDirty() : !pSSysModelInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSSysModelInst.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isPSSvrDomainIdDirty() : !pSSysModelInst.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSSysModelInst.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isPSSysModelInstIdDirty() && !bl2 : !pSSysModelInst.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysModelInst.getPSSysModelInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelInstName(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isPSSysModelInstNameDirty() && !bl2 : !pSSysModelInst.isPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSSysModelInst.getPSSysModelInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstName_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefInfo(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isRefInfoDirty() : !pSSysModelInst.isRefInfoDirty()) {
            return null;
        }
        String string = pSSysModelInst.getRefInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefInfo_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_RowCnt(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isRowCntDirty() : !pSSysModelInst.isRowCntDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getRowCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RowCnt_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROWCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShareFlag(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isShareFlagDirty() : !pSSysModelInst.isShareFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getShareFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShareFlag_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAREFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysRowKey(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isSysRowKeyDirty() : !pSSysModelInst.isSysRowKeyDirty()) {
            return null;
        }
        String string = pSSysModelInst.getSysRowKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysRowKey_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSROWKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysType(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isSysTypeDirty() : !pSSysModelInst.isSysTypeDirty()) {
            return null;
        }
        String string = pSSysModelInst.getSysType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysType_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempPSSysModelInstId(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isTempPSSysModelInstIdDirty() : !pSSysModelInst.isTempPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysModelInst.getTempPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TempPSSysModelInstId_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPPSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempPSSysModelInstName(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isTempPSSysModelInstNameDirty() : !pSSysModelInst.isTempPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSSysModelInst.getTempPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TempPSSysModelInstName_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPPSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsedSize(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isUsedSizeDirty() : !pSSysModelInst.isUsedSizeDirty()) {
            return null;
        }
        Integer n = pSSysModelInst.getUsedSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UsedSize_Default((IEntity)pSSysModelInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEDSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSSysModelInst pSSysModelInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInst.isUserNameDirty() && !bl2 : !pSSysModelInst.isUserNameDirty()) {
            return null;
        }
        String string = pSSysModelInst.getUserName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default((IEntity)pSSysModelInst, bl2, bl3);
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

    protected void onSyncEntity(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysModelInst, bl);
    }

    protected void onSyncIndexEntities(PSSysModelInst pSSysModelInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysModelInst, bl);
    }

    public Object getDataContextValue(PSSysModelInst pSSysModelInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysModelInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelInst pSSysModelInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysModelInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINCALCTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginCalcTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINMAINTAINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginMaintainTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONFPSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConfPSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONFPSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConfPSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURDBACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurDBAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDCALCTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndCalcTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDMAINTAINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndMaintainTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPOOLSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPoolSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTGROUP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstGroup_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXPOOLSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxPoolSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINPOOLSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinPoolSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PassWD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PATCHNUM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PatchNum_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROWCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RowCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAREFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShareFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSROWKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysRowKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPPSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempPSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPPSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempPSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEDSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsedSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BeginCalcTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BeginMaintainTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ConfPSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONFPSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConfPSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONFPSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_CurDBAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CURDBACTION", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EndCalcTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndMaintainTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InitPoolSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InstGroup_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTGROUP", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTSTATE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxPoolSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_MinPoolSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ModelVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_Param3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PassWD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PatchNum_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDBServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSvrDomainId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRDOMAINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrDomainName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRDOMAINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RowCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShareFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysRowKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSROWKEY", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TempPSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPPSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TempPSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPPSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UsedSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSysModelInst pSSysModelInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysModelInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelInst pSSysModelInst) throws Exception {
        super.onUpdateParent((IEntity)pSSysModelInst);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelInst pSSysModelInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELINST");
        if (!bl) {
            pSSysModelInst.setCreateDate(null);
            pSSysModelInst.setCreateMan(null);
            pSSysModelInst.setPSDevCenterId(null);
            pSSysModelInst.setPSDevCenterName(null);
            pSSysModelInst.setPSSysModelInstId(null);
            pSSysModelInst.setRefInfo(null);
            pSSysModelInst.setUpdateDate(null);
            pSSysModelInst.setUpdateMan(null);
            pSSysModelInst.setUsedSize(null);
            super.exportCurXmlModel(pSSysModelInst, xmlNode, bl);
        }
    }
}

