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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItemBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepoBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFileBase;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysVerDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysVerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysPatchService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysPatchServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysVerServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysVer> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysVerServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_DOWNLOADPRD = "DownloadPrd";
    public static final String ACTION_X_PACK = "X_PACK";
    private PSDevSlnSysVerDEModel pSDevSlnSysVerDEModel;
    private PSDevSlnSysVerDAO pSDevSlnSysVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService";
    }

    public PSDevSlnSysVerDEModel getPSDevSlnSysVerDEModel() {
        if (this.pSDevSlnSysVerDEModel == null) {
            try {
                this.pSDevSlnSysVerDEModel = (PSDevSlnSysVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysVerDEModel();
    }

    public PSDevSlnSysVerDAO getPSDevSlnSysVerDAO() {
        if (this.pSDevSlnSysVerDAO == null) {
            try {
                this.pSDevSlnSysVerDAO = (PSDevSlnSysVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_DOWNLOADPRD, (boolean)true) == 0) {
            this.downloadPrd((PSDevSlnSysVer)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_PACK, (boolean)true) == 0) {
            this.packagePrd((PSDevSlnSysVer)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void downloadPrd(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_DOWNLOADPRD, 0, pSDevSlnSysVer, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSysVer, ACTION_DOWNLOADPRD);
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysVerServiceBase.this.getService(), PSDevSlnSysVerServiceBase.ACTION_DOWNLOADPRD, 40, pSDevSlnSysVer2, null).getResult() != 1) {
                    PSDevSlnSysVerServiceBase.this.onDownloadPrd(pSDevSlnSysVer2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_DOWNLOADPRD, 99, pSDevSlnSysVer, null);
        }
    }

    protected void onDownloadPrd(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[DownloadPrd]");
    }

    public void packagePrd(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_PACK, 0, pSDevSlnSysVer, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSysVer, ACTION_X_PACK);
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysVerServiceBase.this.getService(), PSDevSlnSysVerServiceBase.ACTION_X_PACK, 40, pSDevSlnSysVer2, null).getResult() != 1) {
                    PSDevSlnSysVerServiceBase.this.onPackagePrd(pSDevSlnSysVer2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_PACK, 99, pSDevSlnSysVer, null);
        }
    }

    protected void onPackagePrd(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_PACK]");
    }

    protected void onFillParentInfo(PSDevSlnSysVer pSDevSlnSysVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDCREGISTRYITEM_PSDCREGISTRYITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryItem pSDCRegistryItem = (PSDCRegistryItem)iService.getDEModel().createEntity();
            pSDCRegistryItem.set("PSDCREGISTRYITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRegistryItem);
            } else {
                iService.get(pSDCRegistryItem);
            }
            this.onFillParentInfo_PSDCRegistryItem(pSDevSlnSysVer, pSDCRegistryItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryRepo pSDCRegistryRepo = (PSDCRegistryRepo)iService.getDEModel().createEntity();
            pSDCRegistryRepo.set("PSDCREGISTRYREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRegistryRepo);
            } else {
                iService.get(pSDCRegistryRepo);
            }
            this.onFillParentInfo_PSDCRegistryRepo(pSDevSlnSysVer, pSDCRegistryRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnSysVer, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDEVCENTERFILE_PSDEVCENTERFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService", (SessionFactory)this.getSessionFactory());
            PSDevCenterFile pSDevCenterFile = (PSDevCenterFile)iService.getDEModel().createEntity();
            pSDevCenterFile.set("PSDEVCENTERFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterFile);
            } else {
                iService.get(pSDevCenterFile);
            }
            this.onFillParentInfo_PSDevCenterFile(pSDevSlnSysVer, pSDevCenterFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysVer, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysVer, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDEVSLNSYS_VERPSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_VerPSDevSlnSys(pSDevSlnSysVer, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnSysVer, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSVER_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelInst);
            } else {
                iService.get(pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSDevSlnSysVer, pSSysModelInst);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCRegistryItem(PSDevSlnSysVer pSDevSlnSysVer, PSDCRegistryItem pSDCRegistryItem) throws Exception {
        pSDevSlnSysVer.setPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
        pSDevSlnSysVer.setPSDCRegistryItemName(pSDCRegistryItem.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_PSDCRegistryRepo(PSDevSlnSysVer pSDevSlnSysVer, PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        pSDevSlnSysVer.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
        pSDevSlnSysVer.setPSDCRegistryRepoName(pSDCRegistryRepo.getPSDCRegistryRepoName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSDevSlnSysVer pSDevSlnSysVer, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSysVer.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSysVer.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSDevCenterFile(PSDevSlnSysVer pSDevSlnSysVer, PSDevCenterFile pSDevCenterFile) throws Exception {
        pSDevSlnSysVer.setPSDevCenterFileId(pSDevCenterFile.getPSDevCenterFileId());
        pSDevSlnSysVer.setPSDevCenterFileName(pSDevCenterFile.getPSDevCenterFileName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDevSlnSysVer pSDevSlnSysVer, PSDevCenter pSDevCenter) throws Exception {
        pSDevSlnSysVer.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevSlnSysVer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysVer pSDevSlnSysVer, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysVer.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysVer.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
        if (pSDevSlnSys.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnSysVer, pSDevSlnSys.getPSDevSln());
        }
    }

    protected void onFillParentInfo_VerPSDevSlnSys(PSDevSlnSysVer pSDevSlnSysVer, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysVer.setVerPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysVer.setVerPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnSysVer pSDevSlnSysVer, PSDevSln pSDevSln) throws Exception {
        pSDevSlnSysVer.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnSysVer.setPSDevSlnName(pSDevSln.getPSDevSlnName());
        if (pSDevSln.getPSDevCenter() != null) {
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysVer, pSDevSln.getPSDevCenter());
        }
    }

    protected void onFillParentInfo_PSSysModelInst(PSDevSlnSysVer pSDevSlnSysVer, PSSysModelInst pSSysModelInst) throws Exception {
        pSDevSlnSysVer.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDevSlnSysVer.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnSysVer.getPackState() == null) {
                pSDevSlnSysVer.setPackState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnSysVer.getValidFlag() == null) {
                pSDevSlnSysVer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSDCRegistryItem(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSDCRegistryRepo(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSDevCenterFile(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_VerPSDevSlnSys(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnSysVer, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSDevSlnSysVer, bl);
    }

    protected void onFillEntityFullInfo_PSDCRegistryItem(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCRegistryRepo(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterFile(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        if (pSDevSlnSysVer.isPSDevCenterFileIdDirty()) {
            if (pSDevSlnSysVer.getPSDevCenterFileId() != null) {
                if (pSDevSlnSysVer.getPSDevCenterFileId() == null || pSDevSlnSysVer.getPSDevCenterFileName() == null) {
                    PSDevCenterFile pSDevCenterFile = pSDevSlnSysVer.getPSDevCenterFile();
                    pSDevSlnSysVer.setPSDevCenterFileName(pSDevCenterFile.getPSDevCenterFileName());
                }
            } else {
                pSDevSlnSysVer.setPSDevCenterFileName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        if (pSDevSlnSysVer.isPSDevCenterIdDirty()) {
            if (pSDevSlnSysVer.getPSDevCenterId() != null) {
                if (pSDevSlnSysVer.getPSDevCenterId() == null || pSDevSlnSysVer.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevSlnSysVer.getPSDevCenter();
                    pSDevSlnSysVer.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevSlnSysVer.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        if (pSDevSlnSysVer.isPSDevSlnSysIdDirty()) {
            if (pSDevSlnSysVer.getPSDevSlnSysId() != null) {
                PSDevSlnSys pSDevSlnSys;
                if (pSDevSlnSysVer.getPSDevSlnSysId() == null || pSDevSlnSysVer.getPSDevSlnSysName() == null) {
                    pSDevSlnSys = pSDevSlnSysVer.getPSDevSlnSys();
                    pSDevSlnSysVer.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDevSlnSys = pSDevSlnSysVer.getPSDevSlnSys()).getPSDevSlnId(), (Object)pSDevSlnSysVer.getPSDevSlnId()) != 0L) {
                    pSDevSlnSysVer.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
                    this.onFillEntityFullInfo_PSDevSln(pSDevSlnSysVer, bl);
                }
            } else {
                pSDevSlnSysVer.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_VerPSDevSlnSys(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        if (pSDevSlnSysVer.isVerPSDevSlnSysIdDirty()) {
            if (pSDevSlnSysVer.getVerPSDevSlnSysId() != null) {
                if (pSDevSlnSysVer.getVerPSDevSlnSysId() == null || pSDevSlnSysVer.getVerPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSDevSlnSysVer.getVerPSDevSlnSys();
                    pSDevSlnSysVer.setVerPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSDevSlnSysVer.setVerPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        if (pSDevSlnSysVer.isPSSysModelInstIdDirty()) {
            if (pSDevSlnSysVer.getPSSysModelInstId() != null) {
                if (pSDevSlnSysVer.getPSSysModelInstId() == null || pSDevSlnSysVer.getPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst = pSDevSlnSysVer.getPSSysModelInst();
                    pSDevSlnSysVer.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                }
            } else {
                pSDevSlnSysVer.setPSSysModelInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysVer, bl);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase) throws Exception {
        return this.selectByPSDCRegistryItem(pSDCRegistryItemBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string) throws Exception {
        return this.selectByPSDCRegistryItem(pSDCRegistryItemBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCREGISTRYITEMID", (Object)pSDCRegistryItemBase.getPSDCRegistryItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRegistryItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRegistryItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCREGISTRYREPOID", (Object)pSDCRegistryRepoBase.getPSDCRegistryRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRegistryRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRegistryRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase) throws Exception {
        return this.selectByPSDevCenterFile(pSDevCenterFileBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string) throws Exception {
        return this.selectByPSDevCenterFile(pSDevCenterFileBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERFILEID", (Object)pSDevCenterFileBase.getPSDevCenterFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysVer> selectByVerPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByVerPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByVerPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByVerPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByVerPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("VERPSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByVerPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByVerPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysVer> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysVer> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRegistryItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSDCREGISTRYITEM_PSDCREGISTRYITEMID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSDCRegistryItem), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSDCRegistryItemId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        final PSDCRegistryItem pSDCRegistryItem2 = pSDCRegistryItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSDCRegistryItem(pSDCRegistryItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem);
        this.onBeforeRemoveByPSDCRegistryItem(pSDCRegistryItem, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSDCRegistryItem(pSDCRegistryItem, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRegistryRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSDCRegistryRepo), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSDCRegistryRepoId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        final PSDCRegistryRepo pSDCRegistryRepo2 = pSDCRegistryRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSDevCenterDBInstId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenterFile(pSDevCenterFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSDEVCENTERFILE_PSDEVCENTERFILEID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSDevCenterFile), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenterFile(pSDevCenterFile);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSDevCenterFileId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        final PSDevCenterFile pSDevCenterFile2 = pSDevCenterFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSDevCenterFile(pSDevCenterFile2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSDevCenterFile(pSDevCenterFile2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSDevCenterFile(pSDevCenterFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void internalRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenterFile(pSDevCenterFile);
        this.onBeforeRemoveByPSDevCenterFile(pSDevCenterFile, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSDevCenterFile(pSDevCenterFile, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSDevCenterId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByVerPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSDEVSLNSYS_VERPSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByVerPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setVerPSDevSlnSysId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByVerPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByVerPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByVerPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByVerPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByVerPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByVerPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByVerPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSDevSlnId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSVER_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSVER", iDataEntityModel.getDataInfo(pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            PSDevSlnSysVer pSDevSlnSysVer2 = (PSDevSlnSysVer)this.getDEModel().createEntity();
            pSDevSlnSysVer2.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
            pSDevSlnSysVer2.setPSSysModelInstId(null);
            this.update(pSDevSlnSysVer2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysVerServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSDevSlnSysVerServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSDevSlnSysVerServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSysVer> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSDevSlnSysVer pSDevSlnSysVer : arrayList) {
            this.remove(pSDevSlnSysVer);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDevSlnSysVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnPrdService)ServiceGlobal.getService(PSDepSlnPrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnPrdServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysVer(pSDevSlnSysVer);
        pSCoreSysServiceBase = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysVer(pSDevSlnSysVer);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysVer(pSDevSlnSysVer);
        pSCoreSysServiceBase = (PSDevSlnSysPatchService)ServiceGlobal.getService(PSDevSlnSysPatchService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysPatchServiceBase)pSCoreSysServiceBase).testRemoveByFromPSDevSlnSysVer(pSDevSlnSysVer);
        pSCoreSysServiceBase = (PSDevSlnSysPatchService)ServiceGlobal.getService(PSDevSlnSysPatchService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysPatchServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysVer(pSDevSlnSysVer);
        pSCoreSysServiceBase = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysVer(pSDevSlnSysVer);
        super.onBeforeRemove(pSDevSlnSysVer);
    }

    protected void replaceParentInfo(PSDevSlnSysVer pSDevSlnSysVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysVer, cloneSession);
        if (pSDevSlnSysVer.getPSDCRegistryItemId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYITEM", (Object)pSDevSlnSysVer.getPSDCRegistryItemId())) != null) {
            this.onFillParentInfo_PSDCRegistryItem(pSDevSlnSysVer, (PSDCRegistryItem)iEntity);
        }
        if (pSDevSlnSysVer.getPSDCRegistryRepoId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYREPO", (Object)pSDevSlnSysVer.getPSDCRegistryRepoId())) != null) {
            this.onFillParentInfo_PSDCRegistryRepo(pSDevSlnSysVer, (PSDCRegistryRepo)iEntity);
        }
        if (pSDevSlnSysVer.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSysVer.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnSysVer, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSysVer.getPSDevCenterFileId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERFILE", (Object)pSDevSlnSysVer.getPSDevCenterFileId())) != null) {
            this.onFillParentInfo_PSDevCenterFile(pSDevSlnSysVer, (PSDevCenterFile)iEntity);
        }
        if (pSDevSlnSysVer.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevSlnSysVer.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysVer, (PSDevCenter)iEntity);
        }
        if (pSDevSlnSysVer.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysVer.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysVer, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysVer.getVerPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysVer.getVerPSDevSlnSysId())) != null) {
            this.onFillParentInfo_VerPSDevSlnSys(pSDevSlnSysVer, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysVer.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnSysVer.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnSysVer, (PSDevSln)iEntity);
        }
        if (pSDevSlnSysVer.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSDevSlnSysVer.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSDevSlnSysVer, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysVer, bl);
        pSDevSlnSysVer.resetPackState();
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PackState(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PackSysModelInst(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryItemId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryRepoId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterFileId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterFileName(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysVerId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysVerName(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstName(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerDetail(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerLog(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerPSDevSlnSysId(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerPSDevSlnSysName(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Version(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag2(bl, pSDevSlnSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isMemoDirty() : !pSDevSlnSysVer.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PackState(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPackStateDirty() && !bl2 : !pSDevSlnSysVer.isPackStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysVer.getPackState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PackState_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PackSysModelInst(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPackSysModelInstDirty() : !pSDevSlnSysVer.isPackSysModelInstDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysVer.getPackSysModelInst();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PackSysModelInst_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKSYSMODELINST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRegistryItemId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDCRegistryItemIdDirty() : !pSDevSlnSysVer.isPSDCRegistryItemIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDCRegistryItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryItemId_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRegistryRepoId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDCRegistryRepoIdDirty() : !pSDevSlnSysVer.isPSDCRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDCRegistryRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryRepoId_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevCenterDBInstIdDirty() : !pSDevSlnSysVer.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterFileId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevCenterFileIdDirty() : !pSDevSlnSysVer.isPSDevCenterFileIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevCenterFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterFileId_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterFileName(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevCenterFileNameDirty() : !pSDevSlnSysVer.isPSDevCenterFileNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevCenterFileName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterFileName_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevCenterIdDirty() && !bl2 : !pSDevSlnSysVer.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevCenterNameDirty() && !bl2 : !pSDevSlnSysVer.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevSlnIdDirty() : !pSDevSlnSysVer.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysVer.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevSlnSysNameDirty() && !bl2 : !pSDevSlnSysVer.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevSlnSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysVerId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevSlnSysVerIdDirty() && !bl2 : !pSDevSlnSysVer.isPSDevSlnSysVerIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevSlnSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysVerId_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysVerName(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSDevSlnSysVerNameDirty() : !pSDevSlnSysVer.isPSDevSlnSysVerNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSDevSlnSysVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysVerName_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNSYSID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnSysVerDEModel(), "PSDEVSLNSYSVERNAME", string3, pSDevSlnSysVer, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSVERNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSSysModelInstIdDirty() : !pSDevSlnSysVer.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelInstName(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isPSSysModelInstNameDirty() : !pSDevSlnSysVer.isPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstName_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isUserCatDirty() : !pSDevSlnSysVer.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isUserTagDirty() : !pSDevSlnSysVer.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isUserTag2Dirty() : !pSDevSlnSysVer.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isUserTag3Dirty() : !pSDevSlnSysVer.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isUserTag4Dirty() : !pSDevSlnSysVer.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isValidFlagDirty() : !pSDevSlnSysVer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysVer.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnSysVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerDetail(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isVerDetailDirty() : !pSDevSlnSysVer.isVerDetailDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getVerDetail();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerDetail_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERDETAIL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerLog(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isVerLogDirty() : !pSDevSlnSysVer.isVerLogDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getVerLog();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerLog_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERLOG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerPSDevSlnSysId(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isVerPSDevSlnSysIdDirty() : !pSDevSlnSysVer.isVerPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getVerPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerPSDevSlnSysId_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERPSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerPSDevSlnSysName(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isVerPSDevSlnSysNameDirty() : !pSDevSlnSysVer.isVerPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getVerPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerPSDevSlnSysName_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERPSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Version(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isVersionDirty() && !bl2 : !pSDevSlnSysVer.isVersionDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getVersion();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Version_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNSYSID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnSysVerDEModel(), "VERSION", string3, pSDevSlnSysVer, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("VERSION");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isVerTagDirty() : !pSDevSlnSysVer.isVerTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getVerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag2(boolean bl, PSDevSlnSysVer pSDevSlnSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysVer.isVerTag2Dirty() : !pSDevSlnSysVer.isVerTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysVer.getVerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag2_Default(pSDevSlnSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysVer, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysVer pSDevSlnSysVer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysVer, bl);
    }

    public Object getDataContextValue(PSDevSlnSysVer pSDevSlnSysVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVSLNSYS", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"MAINPSDEVSLNSYSID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"VERPSDEVSLNSYSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"VERPSDEVSLNSYSNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDevSlnSysVer, "psdevslnsysid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDevSlnSysVer, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysVer.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysVer, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PACKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PackState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PACKSYSMODELINST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PackSysModelInst_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterFileName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERDETAIL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerDetail_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERLOG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerLog_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERPSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerPSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERPSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerPSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Version_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PackState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PackSysModelInst_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCRegistryItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_VerDetail_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERDETAIL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerLog_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERLOG", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerPSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERPSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerPSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERPSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Version_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERSION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        super.onUpdateParent(pSDevSlnSysVer);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysVer pSDevSlnSysVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSVER");
        if (!bl) {
            pSDevSlnSysVer.setPSDCRegistryItemName(null);
            pSDevSlnSysVer.setVerDetail(null);
            super.exportCurXmlModel(pSDevSlnSysVer, xmlNode, bl);
        }
    }
}

