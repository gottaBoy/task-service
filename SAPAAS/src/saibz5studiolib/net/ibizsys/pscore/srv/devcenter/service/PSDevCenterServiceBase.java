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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSDCServerStateService;
import net.ibizsys.pscore.srv.appdesign.service.PSDCServerStateServiceBase;
import net.ibizsys.pscore.srv.config.service.PSDBValueFuncService;
import net.ibizsys.pscore.srv.config.service.PSDBValueFuncServiceBase;
import net.ibizsys.pscore.srv.config.service.PSDCASGroupService;
import net.ibizsys.pscore.srv.config.service.PSDCASGroupServiceBase;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplService;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSHelpPrjTemplService;
import net.ibizsys.pscore.srv.config.service.PSHelpPrjTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerCDNServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFResourceService;
import net.ibizsys.pscore.srv.config.service.PSPFResourceServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleParamService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleParamServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueServiceBase;
import net.ibizsys.pscore.srv.config.service.PSViewEngineService;
import net.ibizsys.pscore.srv.config.service.PSViewEngineServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBulletinService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBulletinServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCNWFlowService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCNWFlowServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCPFPluginService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCPFPluginServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCProductService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCProductServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryServerServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCResRepService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCResRepServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotAbilityServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSVNBKServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSearchEngineInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSyncData2Service;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSyncData2ServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSyncDataService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSyncDataServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysModelRepoServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysResService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysResServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCTaskLogService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCTaskLogServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterLogService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterLogServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterPFService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterPFServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterResService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterResServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSrvService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSrvServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevServerLeaseService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevServerLeaseServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSPMSServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSPMSServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRTWXAccount;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRTWXAccountBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepoBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerGrp;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerGrpBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrProvider;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrProviderBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenRepoServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysKeyService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysKeyServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEngineCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEngineCfgServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstServiceBase;
import net.ibizsys.pscore.srv.sysrt.service.PSDCOrgSectorService;
import net.ibizsys.pscore.srv.sysrt.service.PSDCOrgSectorServiceBase;
import net.ibizsys.pscore.srv.sysrt.service.PSDCOrgService;
import net.ibizsys.pscore.srv.sysrt.service.PSDCOrgServiceBase;
import net.ibizsys.pscore.srv.sysrt.service.PSDCOrgUserService;
import net.ibizsys.pscore.srv.sysrt.service.PSDCOrgUserServiceBase;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCAppPolicyService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCAppPolicyServiceBase;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstServiceBase;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleService;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleServiceBase;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityServiceBase;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppInstService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppInstServiceBase;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCEngineInstService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCEngineInstServiceBase;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWFCatService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWFCatServiceBase;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWorkflowService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWorkflowServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterServiceBase
extends PSCoreSysServiceBase<PSDevCenter> {
    private static final Log log = LogFactory.getLog(PSDevCenterServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CHANGELEVEL = "ChangeLevel";
    public static final String ACTION_GENRESREP = "GENRESREP";
    public static final String ACTION_INITDCRES = "INITDCRES";
    public static final String ACTION_INITDCWORKSPACES = "InitDCWorkspaces";
    public static final String ACTION_RESETDC = "ResetDC";
    public static final String ACTION_TOGGLEINVALID = "ToggleInvalid";
    public static final String ACTION_TOGGLEVALID = "ToggleValid";
    private PSDevCenterDEModel pSDevCenterDEModel;
    private PSDevCenterDAO pSDevCenterDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService";
    }

    public PSDevCenterDEModel getPSDevCenterDEModel() {
        if (this.pSDevCenterDEModel == null) {
            try {
                this.pSDevCenterDEModel = (PSDevCenterDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevCenterDEModel();
    }

    public PSDevCenterDAO getPSDevCenterDAO() {
        if (this.pSDevCenterDAO == null) {
            try {
                this.pSDevCenterDAO = (PSDevCenterDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevCenterDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CHANGELEVEL, (boolean)true) == 0) {
            this.changeLevel((PSDevCenter)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GENRESREP, (boolean)true) == 0) {
            this.genResRep((PSDevCenter)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_INITDCRES, (boolean)true) == 0) {
            this.initDCRes((PSDevCenter)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_INITDCWORKSPACES, (boolean)true) == 0) {
            this.initDCWorkspaces((PSDevCenter)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_RESETDC, (boolean)true) == 0) {
            this.resetDC((PSDevCenter)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_TOGGLEINVALID, (boolean)true) == 0) {
            this.toggleInvalid((PSDevCenter)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_TOGGLEVALID, (boolean)true) == 0) {
            this.toggleValid((PSDevCenter)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void changeLevel(PSDevCenter pSDevCenter) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGELEVEL, 0, (IEntity)pSDevCenter, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenter, ACTION_CHANGELEVEL);
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterServiceBase.this.getService(), PSDevCenterServiceBase.ACTION_CHANGELEVEL, 40, (IEntity)pSDevCenter2, null).getResult() != 1) {
                    PSDevCenterServiceBase.this.onChangeLevel(pSDevCenter2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGELEVEL, 99, (IEntity)pSDevCenter, null);
        }
    }

    protected void onChangeLevel(PSDevCenter pSDevCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeLevel]");
    }

    public void genResRep(PSDevCenter pSDevCenter) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GENRESREP, 0, (IEntity)pSDevCenter, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenter, ACTION_GENRESREP);
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterServiceBase.this.getService(), PSDevCenterServiceBase.ACTION_GENRESREP, 40, (IEntity)pSDevCenter2, null).getResult() != 1) {
                    PSDevCenterServiceBase.this.onGenResRep(pSDevCenter2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GENRESREP, 99, (IEntity)pSDevCenter, null);
        }
    }

    protected void onGenResRep(PSDevCenter pSDevCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GENRESREP]");
    }

    public void initDCRes(PSDevCenter pSDevCenter) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDCRES, 0, (IEntity)pSDevCenter, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenter, ACTION_INITDCRES);
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterServiceBase.this.getService(), PSDevCenterServiceBase.ACTION_INITDCRES, 40, (IEntity)pSDevCenter2, null).getResult() != 1) {
                    PSDevCenterServiceBase.this.onInitDCRes(pSDevCenter2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDCRES, 99, (IEntity)pSDevCenter, null);
        }
    }

    protected void onInitDCRes(PSDevCenter pSDevCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[INITDCRES]");
    }

    public void initDCWorkspaces(PSDevCenter pSDevCenter) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDCWORKSPACES, 0, (IEntity)pSDevCenter, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenter, ACTION_INITDCWORKSPACES);
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterServiceBase.this.getService(), PSDevCenterServiceBase.ACTION_INITDCWORKSPACES, 40, (IEntity)pSDevCenter2, null).getResult() != 1) {
                    PSDevCenterServiceBase.this.onInitDCWorkspaces(pSDevCenter2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDCWORKSPACES, 99, (IEntity)pSDevCenter, null);
        }
    }

    protected void onInitDCWorkspaces(PSDevCenter pSDevCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDCWorkspaces]");
    }

    public void resetDC(PSDevCenter pSDevCenter) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_RESETDC, 0, (IEntity)pSDevCenter, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenter, ACTION_RESETDC);
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterServiceBase.this.getService(), PSDevCenterServiceBase.ACTION_RESETDC, 40, (IEntity)pSDevCenter2, null).getResult() != 1) {
                    PSDevCenterServiceBase.this.onResetDC(pSDevCenter2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_RESETDC, 99, (IEntity)pSDevCenter, null);
        }
    }

    protected void onResetDC(PSDevCenter pSDevCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ResetDC]");
    }

    public void toggleInvalid(PSDevCenter pSDevCenter) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEINVALID, 0, (IEntity)pSDevCenter, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenter, ACTION_TOGGLEINVALID);
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterServiceBase.this.getService(), PSDevCenterServiceBase.ACTION_TOGGLEINVALID, 40, (IEntity)pSDevCenter2, null).getResult() != 1) {
                    PSDevCenterServiceBase.this.onToggleInvalid(pSDevCenter2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEINVALID, 99, (IEntity)pSDevCenter, null);
        }
    }

    protected void onToggleInvalid(PSDevCenter pSDevCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ToggleInvalid]");
    }

    public void toggleValid(PSDevCenter pSDevCenter) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEVALID, 0, (IEntity)pSDevCenter, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenter, ACTION_TOGGLEVALID);
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterServiceBase.this.getService(), PSDevCenterServiceBase.ACTION_TOGGLEVALID, 40, (IEntity)pSDevCenter2, null).getResult() != 1) {
                    PSDevCenterServiceBase.this.onToggleValid(pSDevCenter2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_TOGGLEVALID, 99, (IEntity)pSDevCenter, null);
        }
    }

    protected void onToggleValid(PSDevCenter pSDevCenter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ToggleValid]");
    }

    protected void onFillParentInfo(PSDevCenter pSDevCenter, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSDCINST_PSDCINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDCInstService", (SessionFactory)this.getSessionFactory());
            PSDCInst pSDCInst = (PSDCInst)iService.getDEModel().createEntity();
            pSDCInst.set("PSDCINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCInst);
            } else {
                iService.get((IEntity)pSDCInst);
            }
            this.onFillParentInfo_PSDCInst(pSDevCenter, pSDCInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSPMSSERVER_PSPMSSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSPMSServerService", (SessionFactory)this.getSessionFactory());
            PSPMSServer pSPMSServer = (PSPMSServer)iService.getDEModel().createEntity();
            pSPMSServer.set("PSPMSSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPMSServer);
            } else {
                iService.get((IEntity)pSPMSServer);
            }
            this.onFillParentInfo_PSPMSServer(pSDevCenter, pSPMSServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSRTWXACCOUNT_PSRTWXACCOUNTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRTWXAccountService", (SessionFactory)this.getSessionFactory());
            PSRTWXAccount pSRTWXAccount = (PSRTWXAccount)iService.getDEModel().createEntity();
            pSRTWXAccount.set("PSRTWXACCOUNTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSRTWXAccount);
            } else {
                iService.get((IEntity)pSRTWXAccount);
            }
            this.onFillParentInfo_PSRTWXAccount(pSDevCenter, pSRTWXAccount);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSSTUDIOSERVERGRP_PSSTUDIOSERVERGRPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpService", (SessionFactory)this.getSessionFactory());
            PSStudioServerGrp pSStudioServerGrp = (PSStudioServerGrp)iService.getDEModel().createEntity();
            pSStudioServerGrp.set("PSSTUDIOSERVERGRPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSStudioServerGrp);
            } else {
                iService.get((IEntity)pSStudioServerGrp);
            }
            this.onFillParentInfo_PSStudioServerGrp(pSDevCenter, pSStudioServerGrp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSSVNINSTREPO_PSSVNINSTREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService", (SessionFactory)this.getSessionFactory());
            PSSVNInstRepo pSSVNInstRepo = (PSSVNInstRepo)iService.getDEModel().createEntity();
            pSSVNInstRepo.set("PSSVNINSTREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSVNInstRepo);
            } else {
                iService.get((IEntity)pSSVNInstRepo);
            }
            this.onFillParentInfo_PSSvnInstRepo(pSDevCenter, pSSVNInstRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSSVNINSTREPO_ROPSSVNINSTREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService", (SessionFactory)this.getSessionFactory());
            PSSVNInstRepo pSSVNInstRepo = (PSSVNInstRepo)iService.getDEModel().createEntity();
            pSSVNInstRepo.set("PSSVNINSTREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSVNInstRepo);
            } else {
                iService.get((IEntity)pSSVNInstRepo);
            }
            this.onFillParentInfo_ROPSSvnInstRepo(pSDevCenter, pSSVNInstRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSSVNINSTREPO_V6PSSVNINSTREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService", (SessionFactory)this.getSessionFactory());
            PSSVNInstRepo pSSVNInstRepo = (PSSVNInstRepo)iService.getDEModel().createEntity();
            pSSVNInstRepo.set("PSSVNINSTREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSVNInstRepo);
            } else {
                iService.get((IEntity)pSSVNInstRepo);
            }
            this.onFillParentInfo_V6PSSvnInstRepo(pSDevCenter, pSSVNInstRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSvrDomain);
            } else {
                iService.get((IEntity)pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSDevCenter, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTER_PSSVRPROVIDER_PSSVRPROVIDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrProviderService", (SessionFactory)this.getSessionFactory());
            PSSvrProvider pSSvrProvider = (PSSvrProvider)iService.getDEModel().createEntity();
            pSSvrProvider.set("PSSVRPROVIDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSvrProvider);
            } else {
                iService.get((IEntity)pSSvrProvider);
            }
            this.onFillParentInfo_PSSvrProvider(pSDevCenter, pSSvrProvider);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevCenter, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCInst(PSDevCenter pSDevCenter, PSDCInst pSDCInst) throws Exception {
        pSDevCenter.setPSDCInstId(pSDCInst.getPSDCInstId());
        pSDevCenter.setPSDCInstName(pSDCInst.getPSDCInstName());
    }

    protected void onFillParentInfo_PSPMSServer(PSDevCenter pSDevCenter, PSPMSServer pSPMSServer) throws Exception {
        pSDevCenter.setPSPMSServerId(pSPMSServer.getPSPMSServerId());
        pSDevCenter.setPSPMSServerName(pSPMSServer.getPSPMSServerName());
    }

    protected void onFillParentInfo_PSRTWXAccount(PSDevCenter pSDevCenter, PSRTWXAccount pSRTWXAccount) throws Exception {
        pSDevCenter.setPSRTWXAccountId(pSRTWXAccount.getPSRTWXAccountId());
        pSDevCenter.setPSRTWXAccountName(pSRTWXAccount.getPSRTWXAccountName());
    }

    protected void onFillParentInfo_PSStudioServerGrp(PSDevCenter pSDevCenter, PSStudioServerGrp pSStudioServerGrp) throws Exception {
        pSDevCenter.setPSStudioServerGrpId(pSStudioServerGrp.getPSStudioServerGrpId());
        pSDevCenter.setPSStudioServerGrpName(pSStudioServerGrp.getPSStudioServerGrpName());
    }

    protected void onFillParentInfo_PSSvnInstRepo(PSDevCenter pSDevCenter, PSSVNInstRepo pSSVNInstRepo) throws Exception {
        pSDevCenter.setPSSvnInstRepoId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenter.setPSSvnInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
    }

    protected void onFillParentInfo_ROPSSvnInstRepo(PSDevCenter pSDevCenter, PSSVNInstRepo pSSVNInstRepo) throws Exception {
        pSDevCenter.setROPSSvnInstRepoId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenter.setROPSSvnInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
    }

    protected void onFillParentInfo_V6PSSvnInstRepo(PSDevCenter pSDevCenter, PSSVNInstRepo pSSVNInstRepo) throws Exception {
        pSDevCenter.setV6PSSvnInstRepoId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenter.setV6PSSvnInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSDevCenter pSDevCenter, PSSvrDomain pSSvrDomain) throws Exception {
        pSDevCenter.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSDevCenter.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_PSSvrProvider(PSDevCenter pSDevCenter, PSSvrProvider pSSvrProvider) throws Exception {
        pSDevCenter.setPSSvrProviderId(pSSvrProvider.getPSSvrProviderId());
        pSDevCenter.setPSSvrProviderName(pSSvrProvider.getPSSvrProviderName());
    }

    protected void onFillEntityFullInfo(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        if (bl) {
            if (pSDevCenter.getSPFlag() == null) {
                pSDevCenter.setSPFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevCenter.getValidFlag() == null) {
                pSDevCenter.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevCenter, bl);
        this.onFillEntityFullInfo_PSDCInst(pSDevCenter, bl);
        this.onFillEntityFullInfo_PSPMSServer(pSDevCenter, bl);
        this.onFillEntityFullInfo_PSRTWXAccount(pSDevCenter, bl);
        this.onFillEntityFullInfo_PSStudioServerGrp(pSDevCenter, bl);
        this.onFillEntityFullInfo_PSSvnInstRepo(pSDevCenter, bl);
        this.onFillEntityFullInfo_ROPSSvnInstRepo(pSDevCenter, bl);
        this.onFillEntityFullInfo_V6PSSvnInstRepo(pSDevCenter, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSDevCenter, bl);
        this.onFillEntityFullInfo_PSSvrProvider(pSDevCenter, bl);
    }

    protected void onFillEntityFullInfo_PSDCInst(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        if (pSDevCenter.isPSDCInstIdDirty()) {
            if (pSDevCenter.getPSDCInstId() != null) {
                if (pSDevCenter.getPSDCInstId() == null || pSDevCenter.getPSDCInstName() == null) {
                    PSDCInst pSDCInst = pSDevCenter.getPSDCInst();
                    pSDevCenter.setPSDCInstName(pSDCInst.getPSDCInstName());
                }
            } else {
                pSDevCenter.setPSDCInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPMSServer(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        if (pSDevCenter.isPSPMSServerIdDirty()) {
            if (pSDevCenter.getPSPMSServerId() != null) {
                if (pSDevCenter.getPSPMSServerId() == null || pSDevCenter.getPSPMSServerName() == null) {
                    PSPMSServer pSPMSServer = pSDevCenter.getPSPMSServer();
                    pSDevCenter.setPSPMSServerName(pSPMSServer.getPSPMSServerName());
                }
            } else {
                pSDevCenter.setPSPMSServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSRTWXAccount(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        if (pSDevCenter.isPSRTWXAccountIdDirty()) {
            if (pSDevCenter.getPSRTWXAccountId() != null) {
                if (pSDevCenter.getPSRTWXAccountId() == null || pSDevCenter.getPSRTWXAccountName() == null) {
                    PSRTWXAccount pSRTWXAccount = pSDevCenter.getPSRTWXAccount();
                    pSDevCenter.setPSRTWXAccountName(pSRTWXAccount.getPSRTWXAccountName());
                }
            } else {
                pSDevCenter.setPSRTWXAccountName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSStudioServerGrp(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        if (pSDevCenter.isPSStudioServerGrpIdDirty()) {
            if (pSDevCenter.getPSStudioServerGrpId() != null) {
                if (pSDevCenter.getPSStudioServerGrpId() == null || pSDevCenter.getPSStudioServerGrpName() == null) {
                    PSStudioServerGrp pSStudioServerGrp = pSDevCenter.getPSStudioServerGrp();
                    pSDevCenter.setPSStudioServerGrpName(pSStudioServerGrp.getPSStudioServerGrpName());
                }
            } else {
                pSDevCenter.setPSStudioServerGrpName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvnInstRepo(PSDevCenter pSDevCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ROPSSvnInstRepo(PSDevCenter pSDevCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_V6PSSvnInstRepo(PSDevCenter pSDevCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSDevCenter pSDevCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSvrProvider(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        if (pSDevCenter.isPSSvrProviderIdDirty()) {
            if (pSDevCenter.getPSSvrProviderId() != null) {
                if (pSDevCenter.getPSSvrProviderId() == null || pSDevCenter.getPSSvrProviderName() == null) {
                    PSSvrProvider pSSvrProvider = pSDevCenter.getPSSvrProvider();
                    pSDevCenter.setPSSvrProviderName(pSSvrProvider.getPSSvrProviderName());
                }
            } else {
                pSDevCenter.setPSSvrProviderName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevCenter, bl);
    }

    public ArrayList<PSDevCenter> selectByPSDCInst(PSDCInstBase pSDCInstBase) throws Exception {
        return this.selectByPSDCInst(pSDCInstBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByPSDCInst(PSDCInstBase pSDCInstBase, String string) throws Exception {
        return this.selectByPSDCInst(pSDCInstBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByPSDCInst(PSDCInstBase pSDCInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCINSTID", (Object)pSDCInstBase.getPSDCInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenter> selectByPSPMSServer(PSPMSServerBase pSPMSServerBase) throws Exception {
        return this.selectByPSPMSServer(pSPMSServerBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByPSPMSServer(PSPMSServerBase pSPMSServerBase, String string) throws Exception {
        return this.selectByPSPMSServer(pSPMSServerBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByPSPMSServer(PSPMSServerBase pSPMSServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPMSSERVERID", (Object)pSPMSServerBase.getPSPMSServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPMSServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPMSServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenter> selectByPSRTWXAccount(PSRTWXAccountBase pSRTWXAccountBase) throws Exception {
        return this.selectByPSRTWXAccount(pSRTWXAccountBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByPSRTWXAccount(PSRTWXAccountBase pSRTWXAccountBase, String string) throws Exception {
        return this.selectByPSRTWXAccount(pSRTWXAccountBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByPSRTWXAccount(PSRTWXAccountBase pSRTWXAccountBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSRTWXACCOUNTID", (Object)pSRTWXAccountBase.getPSRTWXAccountId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRTWXAccountCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRTWXAccountCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenter> selectByPSStudioServerGrp(PSStudioServerGrpBase pSStudioServerGrpBase) throws Exception {
        return this.selectByPSStudioServerGrp(pSStudioServerGrpBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByPSStudioServerGrp(PSStudioServerGrpBase pSStudioServerGrpBase, String string) throws Exception {
        return this.selectByPSStudioServerGrp(pSStudioServerGrpBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByPSStudioServerGrp(PSStudioServerGrpBase pSStudioServerGrpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSTUDIOSERVERGRPID", (Object)pSStudioServerGrpBase.getPSStudioServerGrpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSStudioServerGrpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSStudioServerGrpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenter> selectByPSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase) throws Exception {
        return this.selectByPSSvnInstRepo(pSSVNInstRepoBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByPSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string) throws Exception {
        return this.selectByPSSvnInstRepo(pSSVNInstRepoBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByPSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVNINSTREPOID", (Object)pSSVNInstRepoBase.getPSSVNInstRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSvnInstRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSvnInstRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenter> selectByROPSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase) throws Exception {
        return this.selectByROPSSvnInstRepo(pSSVNInstRepoBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByROPSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string) throws Exception {
        return this.selectByROPSSvnInstRepo(pSSVNInstRepoBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByROPSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ROPSSVNINSTREPOID", (Object)pSSVNInstRepoBase.getPSSVNInstRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByROPSSvnInstRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByROPSSvnInstRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenter> selectByV6PSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase) throws Exception {
        return this.selectByV6PSSvnInstRepo(pSSVNInstRepoBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByV6PSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string) throws Exception {
        return this.selectByV6PSSvnInstRepo(pSSVNInstRepoBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByV6PSSvnInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("V6PSSVNINSTREPOID", (Object)pSSVNInstRepoBase.getPSSVNInstRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByV6PSSvnInstRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByV6PSSvnInstRepoCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenter> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenter> selectByPSSvrProvider(PSSvrProviderBase pSSvrProviderBase) throws Exception {
        return this.selectByPSSvrProvider(pSSvrProviderBase, "", -1);
    }

    public ArrayList<PSDevCenter> selectByPSSvrProvider(PSSvrProviderBase pSSvrProviderBase, String string) throws Exception {
        return this.selectByPSSvrProvider(pSSvrProviderBase, string, -1);
    }

    public ArrayList<PSDevCenter> selectByPSSvrProvider(PSSvrProviderBase pSSvrProviderBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVRPROVIDERID", (Object)pSSvrProviderBase.getPSSvrProviderId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSvrProviderCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSvrProviderCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCInst(PSDCInst pSDCInst) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSDCInst(pSDCInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSDCINST_PSDCINSTID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSDCInst), arrayList.get(0)));
        }
    }

    public void resetPSDCInst(PSDCInst pSDCInst) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSDCInst(pSDCInst);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setPSDCInstId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByPSDCInst(PSDCInst pSDCInst) throws Exception {
        final PSDCInst pSDCInst2 = pSDCInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByPSDCInst(pSDCInst2);
                PSDevCenterServiceBase.this.internalRemoveByPSDCInst(pSDCInst2);
                PSDevCenterServiceBase.this.onAfterRemoveByPSDCInst(pSDCInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCInst(PSDCInst pSDCInst) throws Exception {
    }

    protected void internalRemoveByPSDCInst(PSDCInst pSDCInst) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSDCInst(pSDCInst);
        this.onBeforeRemoveByPSDCInst(pSDCInst, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByPSDCInst(pSDCInst, arrayList);
    }

    protected void onAfterRemoveByPSDCInst(PSDCInst pSDCInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDCInst(PSDCInst pSDCInst, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCInst(PSDCInst pSDCInst, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSPMSServer(PSPMSServer pSPMSServer) throws Exception {
    }

    public void resetPSPMSServer(PSPMSServer pSPMSServer) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSPMSServer(pSPMSServer);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setPSPMSServerId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByPSPMSServer(PSPMSServer pSPMSServer) throws Exception {
        final PSPMSServer pSPMSServer2 = pSPMSServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByPSPMSServer(pSPMSServer2);
                PSDevCenterServiceBase.this.internalRemoveByPSPMSServer(pSPMSServer2);
                PSDevCenterServiceBase.this.onAfterRemoveByPSPMSServer(pSPMSServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSPMSServer(PSPMSServer pSPMSServer) throws Exception {
    }

    protected void internalRemoveByPSPMSServer(PSPMSServer pSPMSServer) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSPMSServer(pSPMSServer);
        this.onBeforeRemoveByPSPMSServer(pSPMSServer, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByPSPMSServer(pSPMSServer, arrayList);
    }

    protected void onAfterRemoveByPSPMSServer(PSPMSServer pSPMSServer) throws Exception {
    }

    protected void onBeforeRemoveByPSPMSServer(PSPMSServer pSPMSServer, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPMSServer(PSPMSServer pSPMSServer, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSRTWXAccount(PSRTWXAccount pSRTWXAccount) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSRTWXAccount(pSRTWXAccount, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSRTWXACCOUNT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSRTWXAccount);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSRTWXACCOUNT_PSRTWXACCOUNTID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSRTWXAccount), arrayList.get(0)));
        }
    }

    public void resetPSRTWXAccount(PSRTWXAccount pSRTWXAccount) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSRTWXAccount(pSRTWXAccount);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setPSRTWXAccountId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByPSRTWXAccount(PSRTWXAccount pSRTWXAccount) throws Exception {
        final PSRTWXAccount pSRTWXAccount2 = pSRTWXAccount;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByPSRTWXAccount(pSRTWXAccount2);
                PSDevCenterServiceBase.this.internalRemoveByPSRTWXAccount(pSRTWXAccount2);
                PSDevCenterServiceBase.this.onAfterRemoveByPSRTWXAccount(pSRTWXAccount2);
            }
        });
    }

    protected void onBeforeRemoveByPSRTWXAccount(PSRTWXAccount pSRTWXAccount) throws Exception {
    }

    protected void internalRemoveByPSRTWXAccount(PSRTWXAccount pSRTWXAccount) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSRTWXAccount(pSRTWXAccount);
        this.onBeforeRemoveByPSRTWXAccount(pSRTWXAccount, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByPSRTWXAccount(pSRTWXAccount, arrayList);
    }

    protected void onAfterRemoveByPSRTWXAccount(PSRTWXAccount pSRTWXAccount) throws Exception {
    }

    protected void onBeforeRemoveByPSRTWXAccount(PSRTWXAccount pSRTWXAccount, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRTWXAccount(PSRTWXAccount pSRTWXAccount, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSStudioServerGrp(pSStudioServerGrp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSTUDIOSERVERGRP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSStudioServerGrp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSSTUDIOSERVERGRP_PSSTUDIOSERVERGRPID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSStudioServerGrp), arrayList.get(0)));
        }
    }

    public void resetPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSStudioServerGrp(pSStudioServerGrp);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setPSStudioServerGrpId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        final PSStudioServerGrp pSStudioServerGrp2 = pSStudioServerGrp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByPSStudioServerGrp(pSStudioServerGrp2);
                PSDevCenterServiceBase.this.internalRemoveByPSStudioServerGrp(pSStudioServerGrp2);
                PSDevCenterServiceBase.this.onAfterRemoveByPSStudioServerGrp(pSStudioServerGrp2);
            }
        });
    }

    protected void onBeforeRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
    }

    protected void internalRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSStudioServerGrp(pSStudioServerGrp);
        this.onBeforeRemoveByPSStudioServerGrp(pSStudioServerGrp, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByPSStudioServerGrp(pSStudioServerGrp, arrayList);
    }

    protected void onAfterRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp) throws Exception {
    }

    protected void onBeforeRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSStudioServerGrp(PSStudioServerGrp pSStudioServerGrp, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvnInstRepo(pSSVNInstRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVNINSTREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSVNInstRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSSVNINSTREPO_PSSVNINSTREPOID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSSVNInstRepo), arrayList.get(0)));
        }
    }

    public void resetPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvnInstRepo(pSSVNInstRepo);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setPSSvnInstRepoId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        final PSSVNInstRepo pSSVNInstRepo2 = pSSVNInstRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByPSSvnInstRepo(pSSVNInstRepo2);
                PSDevCenterServiceBase.this.internalRemoveByPSSvnInstRepo(pSSVNInstRepo2);
                PSDevCenterServiceBase.this.onAfterRemoveByPSSvnInstRepo(pSSVNInstRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void internalRemoveByPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvnInstRepo(pSSVNInstRepo);
        this.onBeforeRemoveByPSSvnInstRepo(pSSVNInstRepo, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByPSSvnInstRepo(pSSVNInstRepo, arrayList);
    }

    protected void onAfterRemoveByPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByROPSSvnInstRepo(pSSVNInstRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVNINSTREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSVNInstRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSSVNINSTREPO_ROPSSVNINSTREPOID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSSVNInstRepo), arrayList.get(0)));
        }
    }

    public void resetROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByROPSSvnInstRepo(pSSVNInstRepo);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setROPSSvnInstRepoId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        final PSSVNInstRepo pSSVNInstRepo2 = pSSVNInstRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByROPSSvnInstRepo(pSSVNInstRepo2);
                PSDevCenterServiceBase.this.internalRemoveByROPSSvnInstRepo(pSSVNInstRepo2);
                PSDevCenterServiceBase.this.onAfterRemoveByROPSSvnInstRepo(pSSVNInstRepo2);
            }
        });
    }

    protected void onBeforeRemoveByROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void internalRemoveByROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByROPSSvnInstRepo(pSSVNInstRepo);
        this.onBeforeRemoveByROPSSvnInstRepo(pSSVNInstRepo, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByROPSSvnInstRepo(pSSVNInstRepo, arrayList);
    }

    protected void onAfterRemoveByROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void onBeforeRemoveByROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByROPSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByV6PSSvnInstRepo(pSSVNInstRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVNINSTREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSVNInstRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSSVNINSTREPO_V6PSSVNINSTREPOID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSSVNInstRepo), arrayList.get(0)));
        }
    }

    public void resetV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByV6PSSvnInstRepo(pSSVNInstRepo);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setV6PSSvnInstRepoId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        final PSSVNInstRepo pSSVNInstRepo2 = pSSVNInstRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByV6PSSvnInstRepo(pSSVNInstRepo2);
                PSDevCenterServiceBase.this.internalRemoveByV6PSSvnInstRepo(pSSVNInstRepo2);
                PSDevCenterServiceBase.this.onAfterRemoveByV6PSSvnInstRepo(pSSVNInstRepo2);
            }
        });
    }

    protected void onBeforeRemoveByV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void internalRemoveByV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByV6PSSvnInstRepo(pSSVNInstRepo);
        this.onBeforeRemoveByV6PSSvnInstRepo(pSSVNInstRepo, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByV6PSSvnInstRepo(pSSVNInstRepo, arrayList);
    }

    protected void onAfterRemoveByV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void onBeforeRemoveByV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByV6PSSvnInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setPSSvrDomainId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSDevCenterServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSDevCenterServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrProvider(PSSvrProvider pSSvrProvider) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvrProvider(pSSvrProvider, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRPROVIDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSvrProvider);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTER_PSSVRPROVIDER_PSSVRPROVIDERID", "", iDataEntityModel.getName(), "PSDEVCENTER", iDataEntityModel.getDataInfo((IEntity)pSSvrProvider), arrayList.get(0)));
        }
    }

    public void resetPSSvrProvider(PSSvrProvider pSSvrProvider) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvrProvider(pSSvrProvider);
        for (PSDevCenter pSDevCenter : arrayList) {
            PSDevCenter pSDevCenter2 = (PSDevCenter)this.getDEModel().createEntity();
            pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevCenter2.setPSSvrProviderId(null);
            this.update(pSDevCenter2);
        }
    }

    public void removeByPSSvrProvider(PSSvrProvider pSSvrProvider) throws Exception {
        final PSSvrProvider pSSvrProvider2 = pSSvrProvider;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterServiceBase.this.onBeforeRemoveByPSSvrProvider(pSSvrProvider2);
                PSDevCenterServiceBase.this.internalRemoveByPSSvrProvider(pSSvrProvider2);
                PSDevCenterServiceBase.this.onAfterRemoveByPSSvrProvider(pSSvrProvider2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrProvider(PSSvrProvider pSSvrProvider) throws Exception {
    }

    protected void internalRemoveByPSSvrProvider(PSSvrProvider pSSvrProvider) throws Exception {
        ArrayList<PSDevCenter> arrayList = this.selectByPSSvrProvider(pSSvrProvider);
        this.onBeforeRemoveByPSSvrProvider(pSSvrProvider, arrayList);
        for (PSDevCenter pSDevCenter : arrayList) {
            this.remove((IEntity)pSDevCenter);
        }
        this.onAfterRemoveByPSSvrProvider(pSSvrProvider, arrayList);
    }

    protected void onAfterRemoveByPSSvrProvider(PSSvrProvider pSSvrProvider) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrProvider(PSSvrProvider pSSvrProvider, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrProvider(PSSvrProvider pSSvrProvider, ArrayList<PSDevCenter> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevCenter pSDevCenter) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSASBookingService)ServiceGlobal.getService(PSASBookingService.class, (SessionFactory)this.getSessionFactory());
        ((PSASBookingServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
        ((PSCredentialServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSCredentialServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDBValueFuncService)ServiceGlobal.getService(PSDBValueFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDBValueFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDBValueFuncServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCAbilityService)ServiceGlobal.getService(PSDCAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCASGroupService)ServiceGlobal.getService(PSDCASGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCASGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCBDInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCBDInstServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCBKTaskServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCBKTaskServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCBulletinService)ServiceGlobal.getService(PSDCBulletinService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCBulletinServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCBulletinServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCClusterServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCClusterServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCodeSnippetServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCContainerSpecServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCContainerSpecServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCCorePrdIssueService)ServiceGlobal.getService(PSDCCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCCorePrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCDBInstBKService)ServiceGlobal.getService(PSDCDBInstBKService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDBInstBKServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDeployCenterServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCDeployServerService)ServiceGlobal.getService(PSDCDeployServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDeployServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCDETemplService)ServiceGlobal.getService(PSDCDETemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDETemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCDETemplServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCFileServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCFileServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCMavenRepoService)ServiceGlobal.getService(PSDCMavenRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMavenRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCMobAppTestDeviceService)ServiceGlobal.getService(PSDCMobAppTestDeviceService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMobAppTestDeviceServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCMobAppTestDeviceServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCModelTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCModelTemplServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCNWFlowService)ServiceGlobal.getService(PSDCNWFlowService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCNWFlowServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCOrgSectorService)ServiceGlobal.getService(PSDCOrgSectorService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCOrgSectorServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCOrgUserService)ServiceGlobal.getService(PSDCOrgUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCOrgUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCOrgService)ServiceGlobal.getService(PSDCOrgService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCOrgServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCPFPluginService)ServiceGlobal.getService(PSDCPFPluginService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCPFPluginServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCProductService)ServiceGlobal.getService(PSDCProductService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCProductServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCProductServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCRegistryServerService)ServiceGlobal.getService(PSDCRegistryServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCResRepService)ServiceGlobal.getService(PSDCResRepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCResRepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCResRepServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCRobotAbilityService)ServiceGlobal.getService(PSDCRobotAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRobotAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRobotServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCRobotServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSearchEngineInstService)ServiceGlobal.getService(PSDCSearchEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSearchEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCSearchEngineInstServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCServerStateService)ServiceGlobal.getService(PSDCServerStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCServerStateServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCServerStateServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSVNBKService)ServiceGlobal.getService(PSDCSVNBKService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSVNBKServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSyncData2Service)ServiceGlobal.getService(PSDCSyncData2Service.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSyncData2ServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCSyncData2ServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSyncDataService)ServiceGlobal.getService(PSDCSyncDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSyncDataServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCSyncDataServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSysInstActionService)ServiceGlobal.getService(PSDCSysInstActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysInstActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysLicServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSysModelInstService)ServiceGlobal.getService(PSDCSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysModelInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCSysModelInstServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSysModelRepoService)ServiceGlobal.getService(PSDCSysModelRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysModelRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCSysModelRepoServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCSysResService)ServiceGlobal.getService(PSDCSysResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSysResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCSysResServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCTaskLogService)ServiceGlobal.getService(PSDCTaskLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCTaskLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCWFEngineInstService)ServiceGlobal.getService(PSDCWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCWFEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDCWFEngineInstServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDCWorkshopServerService)ServiceGlobal.getService(PSDCWorkshopServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCWorkshopServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDepSlnSysKeyService)ServiceGlobal.getService(PSDepSlnSysKeyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysKeyServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDepSlnSysKeyServiceBase)pSCoreSysServiceBase).resetPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDepSlnServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDepSysService)ServiceGlobal.getService(PSDepSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDERTAWService)ServiceGlobal.getService(PSDERTAWService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERTAWServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterASServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterASServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterDBInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterDBInstServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterFileServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterLogService)ServiceGlobal.getService(PSDevCenterLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterLogServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterMQService)ServiceGlobal.getService(PSDevCenterMQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterMQServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterMQServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterPFService)ServiceGlobal.getService(PSDevCenterPFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterPFServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterPFServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterResService)ServiceGlobal.getService(PSDevCenterResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterServerServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterSrvService)ServiceGlobal.getService(PSDevCenterSrvService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterSrvServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterSrvServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterSVNServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterSVNServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterTSServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSDevCenterTSServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevServerLeaseService)ServiceGlobal.getService(PSDevServerLeaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevServerLeaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysBakServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDepInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevUserObjService)ServiceGlobal.getService(PSDevUserObjService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevUserObjServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDevUserRecentService)ServiceGlobal.getService(PSDevUserRecentService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevUserRecentServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSDSBookingService)ServiceGlobal.getService(PSDSBookingService.class, (SessionFactory)this.getSessionFactory());
        ((PSDSBookingServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSGitUserService)ServiceGlobal.getService(PSGitUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSGitUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSGitUserServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSHelpArticleTemplService)ServiceGlobal.getService(PSHelpArticleTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpArticleTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSHelpPrjTemplService)ServiceGlobal.getService(PSHelpPrjTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpPrjTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSHelpSectionTemplService)ServiceGlobal.getService(PSHelpSectionTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSMavenRepoService)ServiceGlobal.getService(PSMavenRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSMavenRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSMavenRepoServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSPFPkgVerCDNService)ServiceGlobal.getService(PSPFPkgVerCDNService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPkgVerCDNServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSPFResourceService)ServiceGlobal.getService(PSPFResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFResourceServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSPFResourceServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSRegistryRepoService)ServiceGlobal.getService(PSRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSRegistryRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSRegistryRepoServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSSaaSSysService)ServiceGlobal.getService(PSSaaSSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSSFStyleParamService)ServiceGlobal.getService(PSSFStyleParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSSysEngineCfgService)ServiceGlobal.getService(PSSysEngineCfgService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEngineCfgServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSSysEngineCfgServiceBase)pSCoreSysServiceBase).removeByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSSystemServiceBase)pSCoreSysServiceBase).resetPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSUSDCAppPolicyService)ServiceGlobal.getService(PSUSDCAppPolicyService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSDCAppPolicyServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSUSDCModuleInstService)ServiceGlobal.getService(PSUSDCModuleInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSDCModuleInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSUSDCModuleService)ServiceGlobal.getService(PSUSDCModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSUSDCModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSVarSampleValueService)ServiceGlobal.getService(PSVarSampleValueService.class, (SessionFactory)this.getSessionFactory());
        ((PSVarSampleValueServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSVarSampleValueServiceBase)pSCoreSysServiceBase).resetPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSViewEngineService)ServiceGlobal.getService(PSViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        ((PSViewEngineServiceBase)pSCoreSysServiceBase).resetPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSWPDCAppEntityService)ServiceGlobal.getService(PSWPDCAppEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSWPDCAppEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSWPDCAppInstService)ServiceGlobal.getService(PSWPDCAppInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSWPDCAppInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSWPDCEngineInstService)ServiceGlobal.getService(PSWPDCEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSWPDCEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSWPDCWFCatService)ServiceGlobal.getService(PSWPDCWFCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSWPDCWFCatServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        pSCoreSysServiceBase = (PSWPDCWorkflowService)ServiceGlobal.getService(PSWPDCWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWPDCWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenter(pSDevCenter);
        super.onBeforeRemove(pSDevCenter);
    }

    protected void replaceParentInfo(PSDevCenter pSDevCenter, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevCenter, cloneSession);
        if (pSDevCenter.getPSDCInstId() != null && (iEntity = cloneSession.getEntity("PSDCINST", (Object)pSDevCenter.getPSDCInstId())) != null) {
            this.onFillParentInfo_PSDCInst(pSDevCenter, (PSDCInst)iEntity);
        }
        if (pSDevCenter.getPSPMSServerId() != null && (iEntity = cloneSession.getEntity("PSPMSSERVER", (Object)pSDevCenter.getPSPMSServerId())) != null) {
            this.onFillParentInfo_PSPMSServer(pSDevCenter, (PSPMSServer)iEntity);
        }
        if (pSDevCenter.getPSRTWXAccountId() != null && (iEntity = cloneSession.getEntity("PSRTWXACCOUNT", (Object)pSDevCenter.getPSRTWXAccountId())) != null) {
            this.onFillParentInfo_PSRTWXAccount(pSDevCenter, (PSRTWXAccount)iEntity);
        }
        if (pSDevCenter.getPSStudioServerGrpId() != null && (iEntity = cloneSession.getEntity("PSSTUDIOSERVERGRP", (Object)pSDevCenter.getPSStudioServerGrpId())) != null) {
            this.onFillParentInfo_PSStudioServerGrp(pSDevCenter, (PSStudioServerGrp)iEntity);
        }
        if (pSDevCenter.getPSSvnInstRepoId() != null && (iEntity = cloneSession.getEntity("PSSVNINSTREPO", (Object)pSDevCenter.getPSSvnInstRepoId())) != null) {
            this.onFillParentInfo_PSSvnInstRepo(pSDevCenter, (PSSVNInstRepo)iEntity);
        }
        if (pSDevCenter.getROPSSvnInstRepoId() != null && (iEntity = cloneSession.getEntity("PSSVNINSTREPO", (Object)pSDevCenter.getROPSSvnInstRepoId())) != null) {
            this.onFillParentInfo_ROPSSvnInstRepo(pSDevCenter, (PSSVNInstRepo)iEntity);
        }
        if (pSDevCenter.getV6PSSvnInstRepoId() != null && (iEntity = cloneSession.getEntity("PSSVNINSTREPO", (Object)pSDevCenter.getV6PSSvnInstRepoId())) != null) {
            this.onFillParentInfo_V6PSSvnInstRepo(pSDevCenter, (PSSVNInstRepo)iEntity);
        }
        if (pSDevCenter.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSDevCenter.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSDevCenter, (PSSvrDomain)iEntity);
        }
        if (pSDevCenter.getPSSvrProviderId() != null && (iEntity = cloneSession.getEntity("PSSVRPROVIDER", (Object)pSDevCenter.getPSSvrProviderId())) != null) {
            this.onFillParentInfo_PSSvrProvider(pSDevCenter, (PSSvrProvider)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevCenter, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DCAPIFlag(bl, pSDevCenter, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCAPIToken(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCLevel(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCRowKey(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCTag(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCTag2(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCTag3(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCTag4(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCType(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDeployCenter(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableWorkspace(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableWSServer(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EntityCnt(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Experience(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredTime(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullDomainName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IPAddrs(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LicInfo(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LicKey(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkIBiz5Flag(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxActiveUserCnt(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxEntityCnt(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxSysCnt(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobCertChgTime(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobTDChgTime(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCInstId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCInstName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPMSServerId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPMSServerName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRTWXAccountId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRTWXAccountName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerGrpId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerGrpName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvnInstRepoId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrProviderId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrProviderName(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RobotChgTime(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPSSvnInstRepoId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SPFlag(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag2(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioVer(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysAPIFlag(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysCnt(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysSN(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalEnergy(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V6PSSvnInstRepoId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebFolder(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebSiteUrl(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXDeptId(bl, pSDevCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevCenter, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DCAPIFlag(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCAPIFlagDirty() : !pSDevCenter.isDCAPIFlagDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getDCAPIFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCAPIFlag_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCAPIFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCAPIToken(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCAPITokenDirty() : !pSDevCenter.isDCAPITokenDirty()) {
            return null;
        }
        String string = pSDevCenter.getDCAPIToken();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCAPIToken_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCAPITOKEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCLevel(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCLevelDirty() : !pSDevCenter.isDCLevelDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getDCLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCLevel_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCRowKey(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCRowKeyDirty() : !pSDevCenter.isDCRowKeyDirty()) {
            return null;
        }
        String string = pSDevCenter.getDCRowKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCRowKey_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCROWKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCTag(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCTagDirty() : !pSDevCenter.isDCTagDirty()) {
            return null;
        }
        String string = pSDevCenter.getDCTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCTag_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCTag2(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCTag2Dirty() : !pSDevCenter.isDCTag2Dirty()) {
            return null;
        }
        String string = pSDevCenter.getDCTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCTag2_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCTag3(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCTag3Dirty() : !pSDevCenter.isDCTag3Dirty()) {
            return null;
        }
        String string = pSDevCenter.getDCTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCTag3_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCTag4(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCTag4Dirty() : !pSDevCenter.isDCTag4Dirty()) {
            return null;
        }
        String string = pSDevCenter.getDCTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCTag4_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCType(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDCTypeDirty() && !bl2 : !pSDevCenter.isDCTypeDirty()) {
            return null;
        }
        String string = pSDevCenter.getDCType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCType_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isDomainNameDirty() && !bl2 : !pSDevCenter.isDomainNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getDomainName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainName_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDevCenterDEModel(), "DOMAINNAME", string3, pSDevCenter, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DOMAINNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDeployCenter(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isEnableDeployCenterDirty() : !pSDevCenter.isEnableDeployCenterDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getEnableDeployCenter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDeployCenter_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDEPLOYCENTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableWorkspace(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isEnableWorkspaceDirty() : !pSDevCenter.isEnableWorkspaceDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getEnableWorkspace();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableWorkspace_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEWORKSPACE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableWSServer(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isEnableWSServerDirty() : !pSDevCenter.isEnableWSServerDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getEnableWSServer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableWSServer_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEWSSERVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EntityCnt(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isEntityCntDirty() : !pSDevCenter.isEntityCntDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getEntityCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EntityCnt_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENTITYCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Experience(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isExperienceDirty() : !pSDevCenter.isExperienceDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getExperience();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Experience_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPERIENCE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredTime(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isExpiredTimeDirty() : !pSDevCenter.isExpiredTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenter.getExpiredTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredTime_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullDomainName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isFullDomainNameDirty() && !bl2 : !pSDevCenter.isFullDomainNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getFullDomainName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLDOMAINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullDomainName_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLDOMAINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IPAddrs(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isIPAddrsDirty() : !pSDevCenter.isIPAddrsDirty()) {
            return null;
        }
        String string = pSDevCenter.getIPAddrs();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IPAddrs_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDRS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LicInfo(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isLicInfoDirty() : !pSDevCenter.isLicInfoDirty()) {
            return null;
        }
        String string = pSDevCenter.getLicInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LicInfo_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LICINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LicKey(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isLicKeyDirty() : !pSDevCenter.isLicKeyDirty()) {
            return null;
        }
        String string = pSDevCenter.getLicKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LicKey_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LICKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkIBiz5Flag(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isLinkIBiz5FlagDirty() : !pSDevCenter.isLinkIBiz5FlagDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getLinkIBiz5Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LinkIBiz5Flag_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKIBIZ5FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxActiveUserCnt(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isMaxActiveUserCntDirty() : !pSDevCenter.isMaxActiveUserCntDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getMaxActiveUserCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxActiveUserCnt_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXACTIVEUSERCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxEntityCnt(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isMaxEntityCntDirty() : !pSDevCenter.isMaxEntityCntDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getMaxEntityCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxEntityCnt_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXENTITYCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxSysCnt(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isMaxSysCntDirty() : !pSDevCenter.isMaxSysCntDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getMaxSysCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxSysCnt_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXSYSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isMemoDirty() : !pSDevCenter.isMemoDirty()) {
            return null;
        }
        String string = pSDevCenter.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobCertChgTime(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isMobCertChgTimeDirty() : !pSDevCenter.isMobCertChgTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenter.getMobCertChgTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobCertChgTime_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBCERTCHGTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobTDChgTime(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isMobTDChgTimeDirty() : !pSDevCenter.isMobTDChgTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenter.getMobTDChgTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobTDChgTime_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBTDCHGTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCInstId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSDCInstIdDirty() : !pSDevCenter.isPSDCInstIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSDCInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCInstId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCInstName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSDCInstNameDirty() : !pSDevCenter.isPSDCInstNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSDCInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCInstName_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSDevCenterIdDirty() && !bl2 : !pSDevCenter.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSDevCenterNameDirty() && !bl2 : !pSDevCenter.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPMSServerId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSPMSServerIdDirty() : !pSDevCenter.isPSPMSServerIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSPMSServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPMSServerId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPMSSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPMSServerName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSPMSServerNameDirty() : !pSDevCenter.isPSPMSServerNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSPMSServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPMSServerName_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPMSSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRTWXAccountId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSRTWXAccountIdDirty() : !pSDevCenter.isPSRTWXAccountIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSRTWXAccountId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRTWXAccountId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSRTWXACCOUNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRTWXAccountName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSRTWXAccountNameDirty() : !pSDevCenter.isPSRTWXAccountNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSRTWXAccountName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRTWXAccountName_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSRTWXACCOUNTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerGrpId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSStudioServerGrpIdDirty() : !pSDevCenter.isPSStudioServerGrpIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSStudioServerGrpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerGrpId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERGRPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerGrpName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSStudioServerGrpNameDirty() : !pSDevCenter.isPSStudioServerGrpNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSStudioServerGrpName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerGrpName_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERGRPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvnInstRepoId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSSvnInstRepoIdDirty() : !pSDevCenter.isPSSvnInstRepoIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSSvnInstRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvnInstRepoId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVNINSTREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSSvrDomainIdDirty() : !pSDevCenter.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrProviderId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSSvrProviderIdDirty() : !pSDevCenter.isPSSvrProviderIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSSvrProviderId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrProviderId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRPROVIDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrProviderName(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isPSSvrProviderNameDirty() : !pSDevCenter.isPSSvrProviderNameDirty()) {
            return null;
        }
        String string = pSDevCenter.getPSSvrProviderName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrProviderName_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRPROVIDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RobotChgTime(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isRobotChgTimeDirty() : !pSDevCenter.isRobotChgTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenter.getRobotChgTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RobotChgTime_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTCHGTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROPSSvnInstRepoId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isROPSSvnInstRepoIdDirty() : !pSDevCenter.isROPSSvnInstRepoIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getROPSSvnInstRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPSSvnInstRepoId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPSSVNINSTREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SPFlag(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isSPFlagDirty() && !bl2 : !pSDevCenter.isSPFlagDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getSPFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_SPFlag_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioTag(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isStudioTagDirty() : !pSDevCenter.isStudioTagDirty()) {
            return null;
        }
        String string = pSDevCenter.getStudioTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_StudioTag2(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isStudioTag2Dirty() : !pSDevCenter.isStudioTag2Dirty()) {
            return null;
        }
        String string = pSDevCenter.getStudioTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag2_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_StudioVer(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isStudioVerDirty() : !pSDevCenter.isStudioVerDirty()) {
            return null;
        }
        String string = pSDevCenter.getStudioVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioVer_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_SysAPIFlag(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isSysAPIFlagDirty() : !pSDevCenter.isSysAPIFlagDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getSysAPIFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysAPIFlag_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_SysCnt(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isSysCntDirty() : !pSDevCenter.isSysCntDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getSysCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysCnt_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysSN(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isSysSNDirty() : !pSDevCenter.isSysSNDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getSysSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysSN_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TotalEnergy(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isTotalEnergyDirty() : !pSDevCenter.isTotalEnergyDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getTotalEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TotalEnergy_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V6PSSvnInstRepoId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isV6PSSvnInstRepoIdDirty() : !pSDevCenter.isV6PSSvnInstRepoIdDirty()) {
            return null;
        }
        String string = pSDevCenter.getV6PSSvnInstRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V6PSSvnInstRepoId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V6PSSVNINSTREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isValidFlagDirty() : !pSDevCenter.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_WebFolder(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isWebFolderDirty() : !pSDevCenter.isWebFolderDirty()) {
            return null;
        }
        String string = pSDevCenter.getWebFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebFolder_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WEBFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WebSiteUrl(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isWebSiteUrlDirty() : !pSDevCenter.isWebSiteUrlDirty()) {
            return null;
        }
        String string = pSDevCenter.getWebSiteUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebSiteUrl_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WEBSITEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXDeptId(boolean bl, PSDevCenter pSDevCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenter.isWXDeptIdDirty() : !pSDevCenter.isWXDeptIdDirty()) {
            return null;
        }
        Integer n = pSDevCenter.getWXDeptId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WXDeptId_Default((IEntity)pSDevCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXDEPTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevCenter, bl);
    }

    protected void onSyncIndexEntities(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevCenter, bl);
    }

    public Object getDataContextValue(PSDevCenter pSDevCenter, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevCenter, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevCenter pSDevCenter, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevCenter, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCAPIFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCAPIFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCAPITOKEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCAPIToken_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCROWKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCRowKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDEPLOYCENTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDeployCenter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEWORKSPACE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableWorkspace_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEWSSERVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableWSServer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENTITYCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EntityCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPERIENCE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Experience_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDRS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IPAddrs_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LICINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LicInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LICKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LicKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKIBIZ5FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkIBiz5Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXACTIVEUSERCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxActiveUserCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXENTITYCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxEntityCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXSYSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxSysCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBCERTCHGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobCertChgTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBTDCHGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobTDChgTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPMSSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPMSServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPMSSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPMSServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSRTWXACCOUNTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRTWXAccountId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSRTWXACCOUNTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRTWXAccountName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERGRPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerGrpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERGRPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerGrpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVNINSTREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvnInstRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVNINSTREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvnInstRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRPROVIDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrProviderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRPROVIDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrProviderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROBOTCHGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RobotChgTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSSVNINSTREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSSvnInstRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSSVNINSTREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSSvnInstRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SPFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SYSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOTALENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TotalEnergy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V6PSSVNINSTREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V6PSSvnInstRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V6PSSVNINSTREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V6PSSvnInstRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WEBFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WEBSITEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebSiteUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WXDEPTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WXDeptId_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DCAPIFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DCAPIToken_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCAPITOKEN", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DCRowKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCROWKEY", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DomainName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableDeployCenter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableWorkspace_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableWSServer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EntityCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Experience_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FullDomainName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLDOMAINNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IPAddrs_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDRS", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LicInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LICINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LicKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LICKEY", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkIBiz5Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxActiveUserCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxEntityCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxSysCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MobCertChgTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MobTDChgTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSPMSServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPMSSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPMSServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPMSSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRTWXAccountId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSRTWXACCOUNTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRTWXAccountName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSRTWXACCOUNTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioServerGrpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERGRPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioServerGrpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERGRPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvnInstRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVNINSTREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvnInstRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVNINSTREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSvrProviderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRPROVIDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrProviderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRPROVIDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RobotChgTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ROPSSvnInstRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSSVNINSTREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSSvnInstRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSSVNINSTREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SPFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_SysCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TotalEnergy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_V6PSSvnInstRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V6PSSVNINSTREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V6PSSvnInstRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V6PSSVNINSTREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WebFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WEBFOLDER", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WebSiteUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WEBSITEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WXDeptId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevCenter pSDevCenter) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevCenter)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevCenter pSDevCenter) throws Exception {
        super.onUpdateParent((IEntity)pSDevCenter);
    }

    @Override
    protected void exportCurXmlModel(PSDevCenter pSDevCenter, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVCENTER");
        if (!bl) {
            pSDevCenter.setCreateDate(null);
            pSDevCenter.setCreateMan(null);
            pSDevCenter.setLicInfo(null);
            pSDevCenter.setPSDevCenterId(null);
            pSDevCenter.setUpdateDate(null);
            pSDevCenter.setUpdateMan(null);
            super.exportCurXmlModel(pSDevCenter, xmlNode, bl);
        }
    }
}

