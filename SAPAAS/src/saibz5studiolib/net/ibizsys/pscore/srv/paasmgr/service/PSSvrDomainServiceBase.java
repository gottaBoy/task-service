/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.service.PSASGroupService;
import net.ibizsys.pscore.srv.config.service.PSASGroupServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeService;
import net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerInstService;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerInstServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServiceBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSSvrDomainDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSvrDomainDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSBDDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSBDDevInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSBDServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSBDServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSConsoleServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSConsoleServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMQInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMQInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenRepoServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMobAppPackServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMobAppPackServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSPMSServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSPMSServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSROSServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSROSServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSRTWXAccountService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRTWXAccountServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSRobotService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRobotServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSearchEngineInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSearchEngineInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpService;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSWFEngineInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWFEngineInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkshopServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkshopServerServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSvrDomainServiceBase
extends PSCoreSysServiceBase<PSSvrDomain> {
    private static final Log log = LogFactory.getLog(PSSvrDomainServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_SYNCDOMAINDATA = "SyncDomainData";
    private PSSvrDomainDEModel pSSvrDomainDEModel;
    private PSSvrDomainDAO pSSvrDomainDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService";
    }

    public PSSvrDomainDEModel getPSSvrDomainDEModel() {
        if (this.pSSvrDomainDEModel == null) {
            try {
                this.pSSvrDomainDEModel = (PSSvrDomainDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSvrDomainDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSvrDomainDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSvrDomainDEModel();
    }

    public PSSvrDomainDAO getPSSvrDomainDAO() {
        if (this.pSSvrDomainDAO == null) {
            try {
                this.pSSvrDomainDAO = (PSSvrDomainDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSSvrDomainDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSvrDomainDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSvrDomainDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_SYNCDOMAINDATA, (boolean)true) == 0) {
            this.syncDomainData((PSSvrDomain)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void syncDomainData(PSSvrDomain pSSvrDomain) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_SYNCDOMAINDATA, 0, (IEntity)pSSvrDomain, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSvrDomain, ACTION_SYNCDOMAINDATA);
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSvrDomainServiceBase.this.getService(), PSSvrDomainServiceBase.ACTION_SYNCDOMAINDATA, 40, (IEntity)pSSvrDomain2, null).getResult() != 1) {
                    PSSvrDomainServiceBase.this.onSyncDomainData(pSSvrDomain2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_SYNCDOMAINDATA, 99, (IEntity)pSSvrDomain, null);
        }
    }

    protected void onSyncDomainData(PSSvrDomain pSSvrDomain) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[SyncDomainData]");
    }

    protected void onFillParentInfo(PSSvrDomain pSSvrDomain, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSSvrDomain, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSSvrDomain pSSvrDomain, boolean bl) throws Exception {
        if (bl && pSSvrDomain.getValidFlag() == null) {
            pSSvrDomain.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSvrDomain, bl);
    }

    protected void onWriteBackParent(PSSvrDomain pSSvrDomain, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSvrDomain, bl);
    }

    @Override
    protected void onBeforeRemove(PSSvrDomain pSSvrDomain) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSASBookingLogService)ServiceGlobal.getService(PSASBookingLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSASBookingLogServiceBase)pSCoreSysServiceBase).testRemoveByPssvrdomain(pSSvrDomain);
        ((PSASBookingLogServiceBase)pSCoreSysServiceBase).resetPssvrdomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSASBookingService)ServiceGlobal.getService(PSASBookingService.class, (SessionFactory)this.getSessionFactory());
        ((PSASBookingServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        ((PSASBookingServiceBase)pSCoreSysServiceBase).resetPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSASGroupService)ServiceGlobal.getService(PSASGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSASGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSBDDevInstService)ServiceGlobal.getService(PSBDDevInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSBDDevInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSBDServerService)ServiceGlobal.getService(PSBDServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSBDServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSConsoleServerService)ServiceGlobal.getService(PSConsoleServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSConsoleServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
        ((PSCredentialServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDBDevInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDBServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDCInstService)ServiceGlobal.getService(PSDCInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDCServerService)ServiceGlobal.getService(PSDCServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDeployCenterService)ServiceGlobal.getService(PSDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDeployCenterServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDeployServerService)ServiceGlobal.getService(PSDeployServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDeployServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDevServerService)ServiceGlobal.getService(PSDevServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDSBookingLogService)ServiceGlobal.getService(PSDSBookingLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDSBookingLogServiceBase)pSCoreSysServiceBase).testRemoveByPssvrdomain(pSSvrDomain);
        ((PSDSBookingLogServiceBase)pSCoreSysServiceBase).resetPssvrdomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSDSBookingService)ServiceGlobal.getService(PSDSBookingService.class, (SessionFactory)this.getSessionFactory());
        ((PSDSBookingServiceBase)pSCoreSysServiceBase).testRemoveByPssvrdomain(pSSvrDomain);
        ((PSDSBookingServiceBase)pSCoreSysServiceBase).resetPssvrdomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSGitUserService)ServiceGlobal.getService(PSGitUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSGitUserServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSMavenRepoService)ServiceGlobal.getService(PSMavenRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSMavenRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSMavenServerService)ServiceGlobal.getService(PSMavenServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSMavenServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSMobAppPackServerService)ServiceGlobal.getService(PSMobAppPackServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSMobAppPackServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSVRDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSMQInstService)ServiceGlobal.getService(PSMQInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSMQInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSMSPlatformService)ServiceGlobal.getService(PSMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        ((PSMSPlatformServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSPFPreviewNodeService)ServiceGlobal.getService(PSPFPreviewNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPreviewNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSPMSServerService)ServiceGlobal.getService(PSPMSServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSPMSServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSRegistryRepoService)ServiceGlobal.getService(PSRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSRegistryRepoServiceBase)pSCoreSysServiceBase).testRemoveByPssvrdomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSRegistryServerService)ServiceGlobal.getService(PSRegistryServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSRegistryServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSRobotService)ServiceGlobal.getService(PSRobotService.class, (SessionFactory)this.getSessionFactory());
        ((PSRobotServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSROSServerService)ServiceGlobal.getService(PSROSServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSROSServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSRTWXAccountService)ServiceGlobal.getService(PSRTWXAccountService.class, (SessionFactory)this.getSessionFactory());
        ((PSRTWXAccountServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSSearchEngineInstService)ServiceGlobal.getService(PSSearchEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSSearchEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSStudioServerGrpService)ServiceGlobal.getService(PSStudioServerGrpService.class, (SessionFactory)this.getSessionFactory());
        ((PSStudioServerGrpServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSStudioServerService)ServiceGlobal.getService(PSStudioServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSStudioServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSSubSysVerInstService)ServiceGlobal.getService(PSSubSysVerInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysVerInstServiceBase)pSCoreSysServiceBase).testRemoveByPssvrdomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)this.getSessionFactory());
        ((PSSVNInstRepoServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSVNServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSSvrServerService)ServiceGlobal.getService(PSSvrServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSvrServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelInstServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSTaskServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSWFEngineInstService)ServiceGlobal.getService(PSWFEngineInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFEngineInstServiceBase)pSCoreSysServiceBase).testRemoveByPssvrdomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSWorkshopServerService)ServiceGlobal.getService(PSWorkshopServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkshopServerServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        pSCoreSysServiceBase = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkspaceServiceBase)pSCoreSysServiceBase).testRemoveByPSSvrDomain(pSSvrDomain);
        super.onBeforeRemove(pSSvrDomain);
    }

    protected void onRemoveEntityUncopyValues(PSSvrDomain pSSvrDomain, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSvrDomain, bl);
    }

    protected void onCheckEntity(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DomainCode(bl, pSSvrDomain, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainParam(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainParam2(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainParam3(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainParam4(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainParam5(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainParam6(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DomainParams(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainName(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData10(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData2(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData3(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData4(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData5(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData6(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData7(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData8(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncData9(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSvrDomain, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSvrDomain, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DomainCode(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainCodeDirty() : !pSSvrDomain.isDomainCodeDirty()) {
            return null;
        }
        String string = pSSvrDomain.getDomainCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainCode_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainParam(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainParamDirty() : !pSSvrDomain.isDomainParamDirty()) {
            return null;
        }
        String string = pSSvrDomain.getDomainParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainParam_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainParam2(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainParam2Dirty() : !pSSvrDomain.isDomainParam2Dirty()) {
            return null;
        }
        String string = pSSvrDomain.getDomainParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainParam2_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainParam3(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainParam3Dirty() : !pSSvrDomain.isDomainParam3Dirty()) {
            return null;
        }
        String string = pSSvrDomain.getDomainParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainParam3_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainParam4(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainParam4Dirty() : !pSSvrDomain.isDomainParam4Dirty()) {
            return null;
        }
        String string = pSSvrDomain.getDomainParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainParam4_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainParam5(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainParam5Dirty() : !pSSvrDomain.isDomainParam5Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getDomainParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DomainParam5_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainParam6(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainParam6Dirty() : !pSSvrDomain.isDomainParam6Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getDomainParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DomainParam6_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DomainParams(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isDomainParamsDirty() : !pSSvrDomain.isDomainParamsDirty()) {
            return null;
        }
        String string = pSSvrDomain.getDomainParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DomainParams_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOMAINPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isIpAddrDirty() : !pSSvrDomain.isIpAddrDirty()) {
            return null;
        }
        String string = pSSvrDomain.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default((IEntity)pSSvrDomain, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isIpAddr2Dirty() : !pSSvrDomain.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSSvrDomain.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isMemoDirty() : !pSSvrDomain.isMemoDirty()) {
            return null;
        }
        String string = pSSvrDomain.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSvrDomain, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isPSSvrDomainIdDirty() && !bl2 : !pSSvrDomain.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSSvrDomain.getPSSvrDomainId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default((IEntity)pSSvrDomain, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainName(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isPSSvrDomainNameDirty() && !bl2 : !pSSvrDomain.isPSSvrDomainNameDirty()) {
            return null;
        }
        String string = pSSvrDomain.getPSSvrDomainName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainName_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncDataDirty() : !pSSvrDomain.isSyncDataDirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData10(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData10Dirty() : !pSSvrDomain.isSyncData10Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData10_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData2(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData2Dirty() : !pSSvrDomain.isSyncData2Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData2_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData3(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData3Dirty() : !pSSvrDomain.isSyncData3Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData3_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData4(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData4Dirty() : !pSSvrDomain.isSyncData4Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData4_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData5(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData5Dirty() : !pSSvrDomain.isSyncData5Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData5_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData6(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData6Dirty() : !pSSvrDomain.isSyncData6Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData6_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData7(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData7Dirty() : !pSSvrDomain.isSyncData7Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData7_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData8(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData8Dirty() : !pSSvrDomain.isSyncData8Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData8_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncData9(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isSyncData9Dirty() : !pSSvrDomain.isSyncData9Dirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getSyncData9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncData9_Default((IEntity)pSSvrDomain, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCDATA9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSvrDomain pSSvrDomain, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSvrDomain.isValidFlagDirty() && !bl2 : !pSSvrDomain.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSvrDomain.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSvrDomain, bl2, bl3);
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

    protected void onSyncEntity(PSSvrDomain pSSvrDomain, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSvrDomain, bl);
    }

    protected void onSyncIndexEntities(PSSvrDomain pSSvrDomain, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSvrDomain, bl);
    }

    public Object getDataContextValue(PSSvrDomain pSSvrDomain, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSvrDomain, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSvrDomain pSSvrDomain, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSvrDomain, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOMAINPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DomainParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCDATA9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncData9_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DomainCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINCODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DomainParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DomainParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DomainParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINPARAM3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DomainParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINPARAM4", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DomainParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DomainParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DomainParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOMAINPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_SyncData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncData9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSvrDomain pSSvrDomain) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSvrDomain)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSvrDomain pSSvrDomain) throws Exception {
        super.onUpdateParent((IEntity)pSSvrDomain);
    }

    @Override
    protected void exportCurXmlModel(PSSvrDomain pSSvrDomain, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSVRDOMAIN");
        if (!bl) {
            pSSvrDomain.setCreateDate(null);
            pSSvrDomain.setCreateMan(null);
            pSSvrDomain.setUpdateDate(null);
            pSSvrDomain.setUpdateMan(null);
            super.exportCurXmlModel(pSSvrDomain, xmlNode, bl);
        }
    }
}

