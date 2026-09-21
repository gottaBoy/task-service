/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMavenRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMavenRepoBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServerBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCanvasService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCanvasServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineLogServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnRecentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnRecentServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnServiceBase
extends PSCoreSysServiceBase<PSDevSln> {
    private static final Log log = LogFactory.getLog(PSDevSlnServiceBase.class);
    public static final String DATASET_ALLDCSLNUSER = "AllDCSLNUser";
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDCSLNUSER = "CurDCSLNUser";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FROMDCSLNUSER = "FromDCSLNUser";
    public static final String ACTION_FIXPSDCSVNS = "FixPSDCSVNs";
    public static final String ACTION_PUBMSDCONFIGS = "PubMSDConfigs";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDevSlnDEModel pSDevSlnDEModel;
    private PSDevSlnDAO pSDevSlnDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService";
    }

    public PSDevSlnDEModel getPSDevSlnDEModel() {
        if (this.pSDevSlnDEModel == null) {
            try {
                this.pSDevSlnDEModel = (PSDevSlnDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnDEModel();
    }

    public PSDevSlnDAO getPSDevSlnDAO() {
        if (this.pSDevSlnDAO == null) {
            try {
                this.pSDevSlnDAO = (PSDevSlnDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_ALLDCSLNUSER, (boolean)true) == 0) {
            return this.fetchAllDCSLNUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCSLNUSER, (boolean)true) == 0) {
            return this.fetchCurDCSLNUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FROMDCSLNUSER, (boolean)true) == 0) {
            return this.fetchFromDCSLNUser(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_FIXPSDCSVNS, (boolean)true) == 0) {
            this.fixPSDCSVNs((PSDevSln)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PUBMSDCONFIGS, (boolean)true) == 0) {
            this.pubMSDConfigs((PSDevSln)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchAllDCSLNUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ALLDCSLNUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCSLNUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCSLNUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchFromDCSLNUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FROMDCSLNUSER, false);
        return dBFetchResult;
    }

    public void fixPSDCSVNs(PSDevSln pSDevSln) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_FIXPSDCSVNS, 0, (IEntity)pSDevSln, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSln, ACTION_FIXPSDCSVNS);
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnServiceBase.this.getService(), PSDevSlnServiceBase.ACTION_FIXPSDCSVNS, 40, (IEntity)pSDevSln2, null).getResult() != 1) {
                    PSDevSlnServiceBase.this.onFixPSDCSVNs(pSDevSln2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_FIXPSDCSVNS, 99, (IEntity)pSDevSln, null);
        }
    }

    protected void onFixPSDCSVNs(PSDevSln pSDevSln) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[FixPSDCSVNs]");
    }

    public void pubMSDConfigs(PSDevSln pSDevSln) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PUBMSDCONFIGS, 0, (IEntity)pSDevSln, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSln, ACTION_PUBMSDCONFIGS);
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnServiceBase.this.getService(), PSDevSlnServiceBase.ACTION_PUBMSDCONFIGS, 40, (IEntity)pSDevSln2, null).getResult() != 1) {
                    PSDevSlnServiceBase.this.onPubMSDConfigs(pSDevSln2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PUBMSDCONFIGS, 99, (IEntity)pSDevSln, null);
        }
    }

    protected void onPubMSDConfigs(PSDevSln pSDevSln) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PubMSDConfigs]");
    }

    protected void onFillParentInfo(PSDevSln pSDevSln, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLN_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDCDeployCenter pSDCDeployCenter = (PSDCDeployCenter)iService.getDEModel().createEntity();
            pSDCDeployCenter.set("PSDCDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCDeployCenter);
            } else {
                iService.get((IEntity)pSDCDeployCenter);
            }
            this.onFillParentInfo_PSDCDeployCenter(pSDevSln, pSDCDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLN_PSDCMAVENREPO_PSDCMAVENREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoService", (SessionFactory)this.getSessionFactory());
            PSDCMavenRepo pSDCMavenRepo = (PSDCMavenRepo)iService.getDEModel().createEntity();
            pSDCMavenRepo.set("PSDCMAVENREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCMavenRepo);
            } else {
                iService.get((IEntity)pSDCMavenRepo);
            }
            this.onFillParentInfo_PSDCMavenRepo(pSDevSln, pSDCMavenRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLN_PSDCWORKSHOPSERVER_PSDCWORKSHOPSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService", (SessionFactory)this.getSessionFactory());
            PSDCWorkshopServer pSDCWorkshopServer = (PSDCWorkshopServer)iService.getDEModel().createEntity();
            pSDCWorkshopServer.set("PSDCWORKSHOPSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCWorkshopServer);
            } else {
                iService.get((IEntity)pSDCWorkshopServer);
            }
            this.onFillParentInfo_PSDCWorkshopServer(pSDevSln, pSDCWorkshopServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLN_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDevSln, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLN_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevSln, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLN_PSDEVUSER_ADMINPSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevUser);
            } else {
                iService.get((IEntity)pSDevUser);
            }
            this.onFillParentInfo_AdminPSDevUser(pSDevSln, pSDevUser);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSln, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCDeployCenter(PSDevSln pSDevSln, PSDCDeployCenter pSDCDeployCenter) throws Exception {
        pSDevSln.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
        pSDevSln.setPSDCDeployCenterName(pSDCDeployCenter.getPSDCDeployCenterName());
    }

    protected void onFillParentInfo_PSDCMavenRepo(PSDevSln pSDevSln, PSDCMavenRepo pSDCMavenRepo) throws Exception {
        pSDevSln.setPSDCMavenRepoId(pSDCMavenRepo.getPSDCMavenRepoId());
        pSDevSln.setPSDCMavenRepoName(pSDCMavenRepo.getPSDCMavenRepoName());
    }

    protected void onFillParentInfo_PSDCWorkshopServer(PSDevSln pSDevSln, PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        pSDevSln.setPSDCWorkshopServerId(pSDCWorkshopServer.getPSDCWorkshopServerId());
        pSDevSln.setPSDCWorkshopServerName(pSDCWorkshopServer.getPSDCWorkshopServerName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDevSln pSDevSln, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSln.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSln.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDevSln pSDevSln, PSDevCenter pSDevCenter) throws Exception {
        pSDevSln.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevSln.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_AdminPSDevUser(PSDevSln pSDevSln, PSDevUser pSDevUser) throws Exception {
        pSDevSln.setAdminPSDevUserId(pSDevUser.getPSDevUserId());
        pSDevSln.setAdminPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected void onFillEntityFullInfo(PSDevSln pSDevSln, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSln.getCodeName() == null) {
                pSDevSln.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DevSln", 25));
            }
            if (pSDevSln.getPSDevSlnMSDeploysCnt() == null) {
                pSDevSln.setPSDevSlnMSDeploysCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSln.getPSDevSlnName() == null) {
                pSDevSln.setPSDevSlnName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5f00\u53d1\u65b9\u6848", 25));
            }
            if (pSDevSln.getPSDevSlnSyssCnt() == null) {
                pSDevSln.setPSDevSlnSyssCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSln.getPSDevSlnUsersCnt() == null) {
                pSDevSln.setPSDevSlnUsersCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSln.getSLNType() == null) {
                pSDevSln.setSLNType((String)this.getDefaultValue(this.getWebContext(), "", "DEVSYS", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSln, bl);
        this.onFillEntityFullInfo_PSDCDeployCenter(pSDevSln, bl);
        this.onFillEntityFullInfo_PSDCMavenRepo(pSDevSln, bl);
        this.onFillEntityFullInfo_PSDCWorkshopServer(pSDevSln, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDevSln, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevSln, bl);
        this.onFillEntityFullInfo_AdminPSDevUser(pSDevSln, bl);
    }

    protected void onFillEntityFullInfo_PSDCDeployCenter(PSDevSln pSDevSln, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCMavenRepo(PSDevSln pSDevSln, boolean bl) throws Exception {
        if (pSDevSln.isPSDCMavenRepoIdDirty()) {
            if (pSDevSln.getPSDCMavenRepoId() != null) {
                if (pSDevSln.getPSDCMavenRepoId() == null || pSDevSln.getPSDCMavenRepoName() == null) {
                    PSDCMavenRepo pSDCMavenRepo = pSDevSln.getPSDCMavenRepo();
                    pSDevSln.setPSDCMavenRepoName(pSDCMavenRepo.getPSDCMavenRepoName());
                }
            } else {
                pSDevSln.setPSDCMavenRepoName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDCWorkshopServer(PSDevSln pSDevSln, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDevSln pSDevSln, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevSln pSDevSln, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AdminPSDevUser(PSDevSln pSDevSln, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSln pSDevSln, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSln, bl);
    }

    public ArrayList<PSDevSln> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, "", -1);
    }

    public ArrayList<PSDevSln> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, string, -1);
    }

    public ArrayList<PSDevSln> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDEPLOYCENTERID", (Object)pSDCDeployCenterBase.getPSDCDeployCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCDeployCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCDeployCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSln> selectByPSDCMavenRepo(PSDCMavenRepoBase pSDCMavenRepoBase) throws Exception {
        return this.selectByPSDCMavenRepo(pSDCMavenRepoBase, "", -1);
    }

    public ArrayList<PSDevSln> selectByPSDCMavenRepo(PSDCMavenRepoBase pSDCMavenRepoBase, String string) throws Exception {
        return this.selectByPSDCMavenRepo(pSDCMavenRepoBase, string, -1);
    }

    public ArrayList<PSDevSln> selectByPSDCMavenRepo(PSDCMavenRepoBase pSDCMavenRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMAVENREPOID", (Object)pSDCMavenRepoBase.getPSDCMavenRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMavenRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMavenRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSln> selectByPSDCWorkshopServer(PSDCWorkshopServerBase pSDCWorkshopServerBase) throws Exception {
        return this.selectByPSDCWorkshopServer(pSDCWorkshopServerBase, "", -1);
    }

    public ArrayList<PSDevSln> selectByPSDCWorkshopServer(PSDCWorkshopServerBase pSDCWorkshopServerBase, String string) throws Exception {
        return this.selectByPSDCWorkshopServer(pSDCWorkshopServerBase, string, -1);
    }

    public ArrayList<PSDevSln> selectByPSDCWorkshopServer(PSDCWorkshopServerBase pSDCWorkshopServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCWORKSHOPSERVERID", (Object)pSDCWorkshopServerBase.getPSDCWorkshopServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCWorkshopServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCWorkshopServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSln> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSln> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSln> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSln> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevSln> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevSln> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSln> selectByAdminPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByAdminPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSDevSln> selectByAdminPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByAdminPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSDevSln> selectByAdminPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ADMINPSDEVUSERID", (Object)pSDevUserBase.getPSDevUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAdminPSDevUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAdminPSDevUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLN_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSDEVSLN", iDataEntityModel.getDataInfo((IEntity)pSDCDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        for (PSDevSln pSDevSln : arrayList) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getDEModel().createEntity();
            pSDevSln2.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            pSDevSln2.setPSDCDeployCenterId(null);
            this.update(pSDevSln2);
        }
    }

    public void removeByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        final PSDCDeployCenter pSDCDeployCenter2 = pSDCDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnServiceBase.this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDevSlnServiceBase.this.internalRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDevSlnServiceBase.this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
        for (PSDevSln pSDevSln : arrayList) {
            this.remove((IEntity)pSDevSln);
        }
        this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    public void testRemoveByPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCMavenRepo(pSDCMavenRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMAVENREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCMavenRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLN_PSDCMAVENREPO_PSDCMAVENREPOID", "", iDataEntityModel.getName(), "PSDEVSLN", iDataEntityModel.getDataInfo((IEntity)pSDCMavenRepo), arrayList.get(0)));
        }
    }

    public void resetPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCMavenRepo(pSDCMavenRepo);
        for (PSDevSln pSDevSln : arrayList) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getDEModel().createEntity();
            pSDevSln2.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            pSDevSln2.setPSDCMavenRepoId(null);
            this.update(pSDevSln2);
        }
    }

    public void removeByPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        final PSDCMavenRepo pSDCMavenRepo2 = pSDCMavenRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnServiceBase.this.onBeforeRemoveByPSDCMavenRepo(pSDCMavenRepo2);
                PSDevSlnServiceBase.this.internalRemoveByPSDCMavenRepo(pSDCMavenRepo2);
                PSDevSlnServiceBase.this.onAfterRemoveByPSDCMavenRepo(pSDCMavenRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo) throws Exception {
    }

    protected void internalRemoveByPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCMavenRepo(pSDCMavenRepo);
        this.onBeforeRemoveByPSDCMavenRepo(pSDCMavenRepo, arrayList);
        for (PSDevSln pSDevSln : arrayList) {
            this.remove((IEntity)pSDevSln);
        }
        this.onAfterRemoveByPSDCMavenRepo(pSDCMavenRepo, arrayList);
    }

    protected void onAfterRemoveByPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMavenRepo(PSDCMavenRepo pSDCMavenRepo, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    public void testRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCWorkshopServer(pSDCWorkshopServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCWORKSHOPSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCWorkshopServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLN_PSDCWORKSHOPSERVER_PSDCWORKSHOPSERVERID", "", iDataEntityModel.getName(), "PSDEVSLN", iDataEntityModel.getDataInfo((IEntity)pSDCWorkshopServer), arrayList.get(0)));
        }
    }

    public void resetPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCWorkshopServer(pSDCWorkshopServer);
        for (PSDevSln pSDevSln : arrayList) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getDEModel().createEntity();
            pSDevSln2.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            pSDevSln2.setPSDCWorkshopServerId(null);
            this.update(pSDevSln2);
        }
    }

    public void removeByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        final PSDCWorkshopServer pSDCWorkshopServer2 = pSDCWorkshopServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnServiceBase.this.onBeforeRemoveByPSDCWorkshopServer(pSDCWorkshopServer2);
                PSDevSlnServiceBase.this.internalRemoveByPSDCWorkshopServer(pSDCWorkshopServer2);
                PSDevSlnServiceBase.this.onAfterRemoveByPSDCWorkshopServer(pSDCWorkshopServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
    }

    protected void internalRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDCWorkshopServer(pSDCWorkshopServer);
        this.onBeforeRemoveByPSDCWorkshopServer(pSDCWorkshopServer, arrayList);
        for (PSDevSln pSDevSln : arrayList) {
            this.remove((IEntity)pSDevSln);
        }
        this.onAfterRemoveByPSDCWorkshopServer(pSDCWorkshopServer, arrayList);
    }

    protected void onAfterRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLN_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLN", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSln pSDevSln : arrayList) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getDEModel().createEntity();
            pSDevSln2.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            pSDevSln2.setPSDevCenterSVNId(null);
            this.update(pSDevSln2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSln pSDevSln : arrayList) {
            this.remove((IEntity)pSDevSln);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevSln pSDevSln : arrayList) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getDEModel().createEntity();
            pSDevSln2.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            pSDevSln2.setPSDevCenterId(null);
            this.update(pSDevSln2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevSln pSDevSln : arrayList) {
            this.remove((IEntity)pSDevSln);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    public void testRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByAdminPSDevUser(pSDevUser, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVUSER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevUser);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLN_PSDEVUSER_ADMINPSDEVUSERID", "", iDataEntityModel.getName(), "PSDEVSLN", iDataEntityModel.getDataInfo((IEntity)pSDevUser), arrayList.get(0)));
        }
    }

    public void resetAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByAdminPSDevUser(pSDevUser);
        for (PSDevSln pSDevSln : arrayList) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getDEModel().createEntity();
            pSDevSln2.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            pSDevSln2.setAdminPSDevUserId(null);
            this.update(pSDevSln2);
        }
    }

    public void removeByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnServiceBase.this.onBeforeRemoveByAdminPSDevUser(pSDevUser2);
                PSDevSlnServiceBase.this.internalRemoveByAdminPSDevUser(pSDevUser2);
                PSDevSlnServiceBase.this.onAfterRemoveByAdminPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevSln> arrayList = this.selectByAdminPSDevUser(pSDevUser);
        this.onBeforeRemoveByAdminPSDevUser(pSDevUser, arrayList);
        for (PSDevSln pSDevSln : arrayList) {
            this.remove((IEntity)pSDevSln);
        }
        this.onAfterRemoveByAdminPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByAdminPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByAdminPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAdminPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevSln> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSln pSDevSln) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
        ((PSCredentialServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCBDInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCodeSnippetServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDeployCenterServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCDETemplService)ServiceGlobal.getService(PSDCDETemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDETemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCFileServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCMavenRepoService)ServiceGlobal.getService(PSDCMavenRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMavenRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCModelTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCSearchEngineInstService)ServiceGlobal.getService(PSDCSearchEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSearchEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCSysModelInstService)ServiceGlobal.getService(PSDCSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysModelInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCSysModelRepoService)ServiceGlobal.getService(PSDCSysModelRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysModelRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCWFEngineInstService)ServiceGlobal.getService(PSDCWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCWFEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCWorkspaceServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterASServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterDBInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterSVNServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevPrdService)ServiceGlobal.getService(PSDevPrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnCanvasService)ServiceGlobal.getService(PSDevSlnCanvasService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnCanvasServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnCanvasServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnCodeServerService)ServiceGlobal.getService(PSDevSlnCodeServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnCodeServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnLinkService)ServiceGlobal.getService(PSDevSlnLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnMSDepAPIServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnMSDepFuncServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDeployServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnMSDepResService)ServiceGlobal.getService(PSDevSlnMSDepResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnPipelineLogService)ServiceGlobal.getService(PSDevSlnPipelineLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnPipelineLogServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnPipelineRefService)ServiceGlobal.getService(PSDevSlnPipelineRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnPipelineRefServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnPipelineServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnRecentService)ServiceGlobal.getService(PSDevSlnRecentService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnRecentServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnRecentServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnResService)ServiceGlobal.getService(PSDevSlnResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnSysGroupService)ServiceGlobal.getService(PSDevSlnSysGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnSysResServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnUserCSService)ServiceGlobal.getService(PSDevSlnUserCSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnUserCSServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSDevSlnUserServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        pSCoreSysServiceBase = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)this.getSessionFactory());
        ((PSTSCmdServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSln(pSDevSln);
        ((PSTSCmdServiceBase)pSCoreSysServiceBase).removeByPSDevSln(pSDevSln);
        super.onBeforeRemove(pSDevSln);
    }

    protected void replaceParentInfo(PSDevSln pSDevSln, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSln, cloneSession);
        if (pSDevSln.getPSDCDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDCDEPLOYCENTER", (Object)pSDevSln.getPSDCDeployCenterId())) != null) {
            this.onFillParentInfo_PSDCDeployCenter(pSDevSln, (PSDCDeployCenter)iEntity);
        }
        if (pSDevSln.getPSDCMavenRepoId() != null && (iEntity = cloneSession.getEntity("PSDCMAVENREPO", (Object)pSDevSln.getPSDCMavenRepoId())) != null) {
            this.onFillParentInfo_PSDCMavenRepo(pSDevSln, (PSDCMavenRepo)iEntity);
        }
        if (pSDevSln.getPSDCWorkshopServerId() != null && (iEntity = cloneSession.getEntity("PSDCWORKSHOPSERVER", (Object)pSDevSln.getPSDCWorkshopServerId())) != null) {
            this.onFillParentInfo_PSDCWorkshopServer(pSDevSln, (PSDCWorkshopServer)iEntity);
        }
        if (pSDevSln.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSln.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDevSln, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSln.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevSln.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevSln, (PSDevCenter)iEntity);
        }
        if (pSDevSln.getAdminPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSDevSln.getAdminPSDevUserId())) != null) {
            this.onFillParentInfo_AdminPSDevUser(pSDevSln, (PSDevUser)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSln pSDevSln, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSln, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPSDevUserId(bl, pSDevSln, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CallbackTag(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CallbackUrl(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCallback(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterId(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMavenRepoId(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMavenRepoName(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkshopServerId(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeploysCnt(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSyssCnt(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnUsersCnt(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SLNFolder(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SlnMDUrl(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SLNSN(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SlnTag(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SlnTag2(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SLNType(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SLNVer(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag2(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioVer(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysAPIFlag(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VCPassword(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VCUser(bl, pSDevSln, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSln, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPSDevUserId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isAdminPSDevUserIdDirty() : !pSDevSln.isAdminPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDevSln.getAdminPSDevUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPSDevUserId_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINPSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CallbackTag(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isCallbackTagDirty() : !pSDevSln.isCallbackTagDirty()) {
            return null;
        }
        String string = pSDevSln.getCallbackTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CallbackTag_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLBACKTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CallbackUrl(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isCallbackUrlDirty() : !pSDevSln.isCallbackUrlDirty()) {
            return null;
        }
        String string = pSDevSln.getCallbackUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CallbackUrl_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLBACKURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isCodeNameDirty() && !bl2 : !pSDevSln.isCodeNameDirty()) {
            return null;
        }
        String string = pSDevSln.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSDEVCENTERID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnDEModel(), "CODENAME", string3, pSDevSln, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCallback(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isEnableCallbackDirty() : !pSDevSln.isEnableCallbackDirty()) {
            return null;
        }
        Integer n = pSDevSln.getEnableCallback();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCallback_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECALLBACK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isLogicNameDirty() : !pSDevSln.isLogicNameDirty()) {
            return null;
        }
        String string = pSDevSln.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isMemoDirty() : !pSDevSln.isMemoDirty()) {
            return null;
        }
        String string = pSDevSln.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDeployCenterId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDCDeployCenterIdDirty() : !pSDevSln.isPSDCDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDCDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterId_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMavenRepoId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDCMavenRepoIdDirty() : !pSDevSln.isPSDCMavenRepoIdDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDCMavenRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMavenRepoId_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMAVENREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMavenRepoName(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDCMavenRepoNameDirty() : !pSDevSln.isPSDCMavenRepoNameDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDCMavenRepoName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMavenRepoName_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMAVENREPONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCWorkshopServerId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDCWorkshopServerIdDirty() : !pSDevSln.isPSDCWorkshopServerIdDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDCWorkshopServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkshopServerId_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSHOPSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDevCenterIdDirty() && !bl2 : !pSDevSln.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDevCenterSVNIdDirty() : !pSDevSln.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDevSlnIdDirty() && !bl2 : !pSDevSln.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDevSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDeploysCnt(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDevSlnMSDeploysCntDirty() : !pSDevSln.isPSDevSlnMSDeploysCntDirty()) {
            return null;
        }
        Integer n = pSDevSln.getPSDevSlnMSDeploysCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDevSlnMSDeploysCnt_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDevSlnNameDirty() && !bl2 : !pSDevSln.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSDevSln.getPSDevSlnName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVCENTERID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnDEModel(), "PSDEVSLNNAME", string3, pSDevSln, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSyssCnt(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDevSlnSyssCntDirty() : !pSDevSln.isPSDevSlnSyssCntDirty()) {
            return null;
        }
        Integer n = pSDevSln.getPSDevSlnSyssCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDevSlnSyssCnt_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnUsersCnt(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSDevSlnUsersCntDirty() : !pSDevSln.isPSDevSlnUsersCntDirty()) {
            return null;
        }
        Integer n = pSDevSln.getPSDevSlnUsersCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDevSlnUsersCnt_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isPSSystemIdDirty() : !pSDevSln.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDevSln.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SLNFolder(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSLNFolderDirty() : !pSDevSln.isSLNFolderDirty()) {
            return null;
        }
        String string = pSDevSln.getSLNFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SLNFolder_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SlnMDUrl(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSlnMDUrlDirty() : !pSDevSln.isSlnMDUrlDirty()) {
            return null;
        }
        String string = pSDevSln.getSlnMDUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SlnMDUrl_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNMDURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SLNSN(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSLNSNDirty() : !pSDevSln.isSLNSNDirty()) {
            return null;
        }
        String string = pSDevSln.getSLNSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SLNSN_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNSN");
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
                string3 = "PSDEVCENTERID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnDEModel(), "SLNSN", string3, pSDevSln, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("SLNSN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SlnTag(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSlnTagDirty() : !pSDevSln.isSlnTagDirty()) {
            return null;
        }
        String string = pSDevSln.getSlnTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SlnTag_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SlnTag2(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSlnTag2Dirty() : !pSDevSln.isSlnTag2Dirty()) {
            return null;
        }
        String string = pSDevSln.getSlnTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SlnTag2_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SLNType(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSLNTypeDirty() : !pSDevSln.isSLNTypeDirty()) {
            return null;
        }
        String string = pSDevSln.getSLNType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SLNType_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SLNVer(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSLNVerDirty() : !pSDevSln.isSLNVerDirty()) {
            return null;
        }
        Integer n = pSDevSln.getSLNVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SLNVer_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SLNVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioTag(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isStudioTagDirty() : !pSDevSln.isStudioTagDirty()) {
            return null;
        }
        String string = pSDevSln.getStudioTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioTag2(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isStudioTag2Dirty() : !pSDevSln.isStudioTag2Dirty()) {
            return null;
        }
        String string = pSDevSln.getStudioTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag2_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioVer(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isStudioVerDirty() : !pSDevSln.isStudioVerDirty()) {
            return null;
        }
        String string = pSDevSln.getStudioVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioVer_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysAPIFlag(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isSysAPIFlagDirty() : !pSDevSln.isSysAPIFlagDirty()) {
            return null;
        }
        Integer n = pSDevSln.getSysAPIFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysAPIFlag_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSAPIFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isUserCatDirty() : !pSDevSln.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSln.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isUserTagDirty() : !pSDevSln.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSln.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isUserTag2Dirty() : !pSDevSln.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSln.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isUserTag3Dirty() : !pSDevSln.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSln.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isUserTag4Dirty() : !pSDevSln.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSln.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDevSln, bl2, bl3);
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

    protected EntityFieldError onCheckField_VCPassword(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isVCPasswordDirty() : !pSDevSln.isVCPasswordDirty()) {
            return null;
        }
        String string = pSDevSln.getVCPassword();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VCPassword_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VCPASSWORD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VCUser(boolean bl, PSDevSln pSDevSln, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSln.isVCUserDirty() : !pSDevSln.isVCUserDirty()) {
            return null;
        }
        String string = pSDevSln.getVCUser();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VCUser_Default((IEntity)pSDevSln, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VCUSER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSln pSDevSln, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSln, bl);
    }

    protected void onSyncIndexEntities(PSDevSln pSDevSln, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSln, bl);
    }

    public Object getDataContextValue(PSDevSln pSDevSln, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSln, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDevSln.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSln pSDevSln, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSln, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINPSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALLBACKTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallbackTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALLBACKURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallbackUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECALLBACK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCallback_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMAVENREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMavenRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMAVENREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMavenRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSHOPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkshopServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSHOPSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkshopServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPLOYSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDeploysCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSyssCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNUSERSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnUsersCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SLNFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNMDURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SlnMDUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SLNSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SlnTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SlnTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SLNType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SLNVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SLNVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSAPIFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysAPIFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VCPASSWORD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VCPassword_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VCUSER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VCUser_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AdminPSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminPSDevUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPSDEVUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CallbackTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALLBACKTAG", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CallbackUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALLBACKURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_EnableCallback_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDCDeployCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMavenRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMAVENREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMavenRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMAVENREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkshopServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSHOPSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkshopServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSHOPSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnMSDeploysCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDevSlnSyssCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDevSlnUsersCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SLNFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNFOLDER", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SlnMDUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNMDURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SLNSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SlnTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SlnTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SLNType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SLNTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SLNVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StudioTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOVER", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysAPIFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_VCPassword_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VCPASSWORD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VCUser_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VCUSER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSln pSDevSln) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPLOY_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) && this.onMergeChild_PSDevSlnMSDeploys(pSDevSln)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) && this.onMergeChild_PSDevSlnSyss(pSDevSln)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSER_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) && this.onMergeChild_PSDevSlnUsers(pSDevSln)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSDevSln)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDevSlnMSDeploys(PSDevSln pSDevSln) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEVSLNMSDEPLOYSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDevSln.getPSDevSlnId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEVSLNID", (Object)pSDevSln.getPSDevSlnId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDevSln, false);
        return true;
    }

    protected boolean onMergeChild_PSDevSlnSyss(PSDevSln pSDevSln) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEVSLNSYSSCNT");
        selectContext.setDEDataQueryName("Trunk");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDevSln.getPSDevSlnId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEVSLNID", (Object)pSDevSln.getPSDevSlnId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDevSln, false);
        return true;
    }

    protected boolean onMergeChild_PSDevSlnUsers(PSDevSln pSDevSln) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEVSLNUSERSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDevSln.getPSDevSlnId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEVSLNID", (Object)pSDevSln.getPSDevSlnId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDevSln, false);
        return true;
    }

    protected void onUpdateParent(PSDevSln pSDevSln) throws Exception {
        super.onUpdateParent((IEntity)pSDevSln);
    }

    @Override
    protected void exportCurXmlModel(PSDevSln pSDevSln, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLN");
        if (!bl) {
            pSDevSln.setCreateDate(null);
            pSDevSln.setCreateMan(null);
            pSDevSln.setPSDevCenterSVNName(null);
            pSDevSln.setPSDevSlnId(null);
            pSDevSln.setPSDevSlnSyssCnt(null);
            pSDevSln.setPSDevSlnUsersCnt(null);
            pSDevSln.setSLNType(null);
            pSDevSln.setUpdateDate(null);
            pSDevSln.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSln, xmlNode, bl);
        }
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDevSln pSDevSln, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DevSln");
        defaultValueMap.put("PSDEVSLNNAME", "\u5f00\u53d1\u65b9\u6848");
    }
}

