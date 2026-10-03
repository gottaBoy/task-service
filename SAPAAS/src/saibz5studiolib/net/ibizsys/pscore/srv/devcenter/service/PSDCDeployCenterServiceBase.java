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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCDeployCenterDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDeployCenterDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCClusterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpecBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepoBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredentialBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenter;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDeployCenterServiceBase
extends PSCoreSysServiceBase<PSDCDeployCenter> {
    private static final Log log = LogFactory.getLog(PSDCDeployCenterServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCDeployCenterDEModel pSDCDeployCenterDEModel;
    private PSDCDeployCenterDAO pSDCDeployCenterDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService";
    }

    public PSDCDeployCenterDEModel getPSDCDeployCenterDEModel() {
        if (this.pSDCDeployCenterDEModel == null) {
            try {
                this.pSDCDeployCenterDEModel = (PSDCDeployCenterDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDeployCenterDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDeployCenterDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCDeployCenterDEModel();
    }

    public PSDCDeployCenterDAO getPSDCDeployCenterDAO() {
        if (this.pSDCDeployCenterDAO == null) {
            try {
                this.pSDCDeployCenterDAO = (PSDCDeployCenterDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCDeployCenterDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDeployCenterDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCDeployCenterDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCDeployCenter pSDCDeployCenter, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSCREDENTIAL_CFGPSCREDENTIALID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService", (SessionFactory)this.getSessionFactory());
            PSCredential pSCredential = (PSCredential)iService.getDEModel().createEntity();
            pSCredential.set("PSCREDENTIALID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCredential);
            } else {
                iService.get(pSCredential);
            }
            this.onFillParentInfo_CfgPSCredential(pSDCDeployCenter, pSCredential);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSCREDENTIAL_PSCREDENTIALID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService", (SessionFactory)this.getSessionFactory());
            PSCredential pSCredential = (PSCredential)iService.getDEModel().createEntity();
            pSCredential.set("PSCREDENTIALID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCredential);
            } else {
                iService.get(pSCredential);
            }
            this.onFillParentInfo_PSCredential(pSDCDeployCenter, pSCredential);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDCCLUSTER_PSDCCLUSTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService", (SessionFactory)this.getSessionFactory());
            PSDCCluster pSDCCluster = (PSDCCluster)iService.getDEModel().createEntity();
            pSDCCluster.set("PSDCCLUSTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCluster);
            } else {
                iService.get(pSDCCluster);
            }
            this.onFillParentInfo_PSDCCluster(pSDCDeployCenter, pSDCCluster);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory());
            PSDCContainerSpec pSDCContainerSpec = (PSDCContainerSpec)iService.getDEModel().createEntity();
            pSDCContainerSpec.set("PSDCCONTAINERSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCContainerSpec);
            } else {
                iService.get(pSDCContainerSpec);
            }
            this.onFillParentInfo_PSDCContainerSpec(pSDCDeployCenter, pSDCContainerSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCFile);
            } else {
                iService.get(pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDCDeployCenter, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryRepo pSDCRegistryRepo = (PSDCRegistryRepo)iService.getDEModel().createEntity();
            pSDCRegistryRepo.set("PSDCREGISTRYREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRegistryRepo);
            } else {
                iService.get(pSDCRegistryRepo);
            }
            this.onFillParentInfo_PSDCRegistryRepo(pSDCDeployCenter, pSDCRegistryRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDEPLOYCENTER_PSDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDeployCenter pSDeployCenter = (PSDeployCenter)iService.getDEModel().createEntity();
            pSDeployCenter.set("PSDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDeployCenter);
            } else {
                iService.get(pSDeployCenter);
            }
            this.onFillParentInfo_PSDeployCenter(pSDCDeployCenter, pSDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDEVCENTERSVN_CFGPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_CfgPSDevCenterSVN(pSDCDeployCenter, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCDeployCenter, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDEPLOYCENTER_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCDeployCenter, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDCDeployCenter, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_CfgPSCredential(PSDCDeployCenter pSDCDeployCenter, PSCredential pSCredential) throws Exception {
        pSDCDeployCenter.setCfgPSCredentialId(pSCredential.getPSCredentialId());
        pSDCDeployCenter.setCfgPSCredentialName(pSCredential.getPSCredentialName());
    }

    protected void onFillParentInfo_PSCredential(PSDCDeployCenter pSDCDeployCenter, PSCredential pSCredential) throws Exception {
        pSDCDeployCenter.setPSCredentialId(pSCredential.getPSCredentialId());
        pSDCDeployCenter.setPSCredentialName(pSCredential.getPSCredentialName());
    }

    protected void onFillParentInfo_PSDCCluster(PSDCDeployCenter pSDCDeployCenter, PSDCCluster pSDCCluster) throws Exception {
        pSDCDeployCenter.setPSDCClusterId(pSDCCluster.getPSDCClusterId());
        pSDCDeployCenter.setPSDCClusterName(pSDCCluster.getPSDCClusterName());
    }

    protected void onFillParentInfo_PSDCContainerSpec(PSDCDeployCenter pSDCDeployCenter, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        pSDCDeployCenter.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
        pSDCDeployCenter.setPSDCContainerSpecName(pSDCContainerSpec.getPSDCContainerSpecName());
    }

    protected void onFillParentInfo_PSDCFile(PSDCDeployCenter pSDCDeployCenter, PSDCFile pSDCFile) throws Exception {
        pSDCDeployCenter.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDCDeployCenter.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDCRegistryRepo(PSDCDeployCenter pSDCDeployCenter, PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        pSDCDeployCenter.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
        pSDCDeployCenter.setPSDCRegistryRepoName(pSDCRegistryRepo.getPSDCRegistryRepoName());
    }

    protected void onFillParentInfo_PSDeployCenter(PSDCDeployCenter pSDCDeployCenter, PSDeployCenter pSDeployCenter) throws Exception {
        pSDCDeployCenter.setPSDeployCenterId(pSDeployCenter.getPSDeployCenterId());
        pSDCDeployCenter.setPSDeployCenterName(pSDeployCenter.getPSDeployCenterName());
    }

    protected void onFillParentInfo_CfgPSDevCenterSVN(PSDCDeployCenter pSDCDeployCenter, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDCDeployCenter.setCfgPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDCDeployCenter.setCfgPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCDeployCenter pSDCDeployCenter, PSDevCenter pSDevCenter) throws Exception {
        pSDCDeployCenter.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCDeployCenter.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCDeployCenter pSDCDeployCenter, PSDevSln pSDevSln) throws Exception {
        pSDCDeployCenter.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCDeployCenter.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
        if (bl) {
            if (pSDCDeployCenter.getDefaultFlag() == null) {
                pSDCDeployCenter.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCDeployCenter.getRefCount() == null) {
                pSDCDeployCenter.setRefCount((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCDeployCenter.getValidFlag() == null) {
                pSDCDeployCenter.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_CfgPSCredential(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSCredential(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSDCCluster(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSDCContainerSpec(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSDCRegistryRepo(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSDeployCenter(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_CfgPSDevCenterSVN(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCDeployCenter, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCDeployCenter, bl);
    }

    protected void onFillEntityFullInfo_CfgPSCredential(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCredential(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCCluster(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCContainerSpec(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCRegistryRepo(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDeployCenter(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
        if (pSDCDeployCenter.isPSDeployCenterIdDirty()) {
            if (pSDCDeployCenter.getPSDeployCenterId() != null) {
                if (pSDCDeployCenter.getPSDeployCenterId() == null || pSDCDeployCenter.getPSDeployCenterName() == null) {
                    PSDeployCenter pSDeployCenter = pSDCDeployCenter.getPSDeployCenter();
                    pSDCDeployCenter.setPSDeployCenterName(pSDeployCenter.getPSDeployCenterName());
                }
            } else {
                pSDCDeployCenter.setPSDeployCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CfgPSDevCenterSVN(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
        if (pSDCDeployCenter.isPSDevCenterIdDirty()) {
            if (pSDCDeployCenter.getPSDevCenterId() != null) {
                if (pSDCDeployCenter.getPSDevCenterId() == null || pSDCDeployCenter.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCDeployCenter.getPSDevCenter();
                    pSDCDeployCenter.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCDeployCenter.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCDeployCenter, bl);
    }

    public ArrayList<PSDCDeployCenter> selectByCfgPSCredential(PSCredentialBase pSCredentialBase) throws Exception {
        return this.selectByCfgPSCredential(pSCredentialBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByCfgPSCredential(PSCredentialBase pSCredentialBase, String string) throws Exception {
        return this.selectByCfgPSCredential(pSCredentialBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByCfgPSCredential(PSCredentialBase pSCredentialBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CFGPSCREDENTIALID", (Object)pSCredentialBase.getPSCredentialId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCfgPSCredentialCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCfgPSCredentialCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDeployCenter> selectByPSCredential(PSCredentialBase pSCredentialBase) throws Exception {
        return this.selectByPSCredential(pSCredentialBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSCredential(PSCredentialBase pSCredentialBase, String string) throws Exception {
        return this.selectByPSCredential(pSCredentialBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSCredential(PSCredentialBase pSCredentialBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCREDENTIALID", (Object)pSCredentialBase.getPSCredentialId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCredentialCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCredentialCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCLUSTERID", (Object)pSDCClusterBase.getPSDCClusterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCClusterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCClusterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCDeployCenter> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCDeployCenter> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCDeployCenter> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase) throws Exception {
        return this.selectByPSDeployCenter(pSDeployCenterBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase, String string) throws Exception {
        return this.selectByPSDeployCenter(pSDeployCenterBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPLOYCENTERID", (Object)pSDeployCenterBase.getPSDeployCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDeployCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDeployCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDeployCenter> selectByCfgPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByCfgPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByCfgPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByCfgPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByCfgPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CFGPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCfgPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCfgPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCDeployCenter> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCDeployCenter> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCDeployCenter> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByCfgPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByCfgPSCredential(pSCredential, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCREDENTIAL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCredential);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSCREDENTIAL_CFGPSCREDENTIALID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSCredential), arrayList.get(0)));
        }
    }

    public void resetCfgPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByCfgPSCredential(pSCredential);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setCfgPSCredentialId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByCfgPSCredential(PSCredential pSCredential) throws Exception {
        final PSCredential pSCredential2 = pSCredential;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByCfgPSCredential(pSCredential2);
                PSDCDeployCenterServiceBase.this.internalRemoveByCfgPSCredential(pSCredential2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByCfgPSCredential(pSCredential2);
            }
        });
    }

    protected void onBeforeRemoveByCfgPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void internalRemoveByCfgPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByCfgPSCredential(pSCredential);
        this.onBeforeRemoveByCfgPSCredential(pSCredential, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByCfgPSCredential(pSCredential, arrayList);
    }

    protected void onAfterRemoveByCfgPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void onBeforeRemoveByCfgPSCredential(PSCredential pSCredential, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCfgPSCredential(PSCredential pSCredential, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSCredential(pSCredential, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCREDENTIAL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCredential);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSCREDENTIAL_PSCREDENTIALID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSCredential), arrayList.get(0)));
        }
    }

    public void resetPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSCredential(pSCredential);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSCredentialId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSCredential(PSCredential pSCredential) throws Exception {
        final PSCredential pSCredential2 = pSCredential;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSCredential(pSCredential2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSCredential(pSCredential2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSCredential(pSCredential2);
            }
        });
    }

    protected void onBeforeRemoveByPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void internalRemoveByPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSCredential(pSCredential);
        this.onBeforeRemoveByPSCredential(pSCredential, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSCredential(pSCredential, arrayList);
    }

    protected void onAfterRemoveByPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void onBeforeRemoveByPSCredential(PSCredential pSCredential, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCredential(PSCredential pSCredential, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCCluster(pSDCCluster, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCLUSTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCCluster);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDCCLUSTER_PSDCCLUSTERID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDCCluster), arrayList.get(0)));
        }
    }

    public void resetPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCCluster(pSDCCluster);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSDCClusterId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        final PSDCCluster pSDCCluster2 = pSDCCluster;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSDCCluster(pSDCCluster2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSDCCluster(pSDCCluster2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSDCCluster(pSDCCluster2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void internalRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCCluster(pSDCCluster);
        this.onBeforeRemoveByPSDCCluster(pSDCCluster, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSDCCluster(pSDCCluster, arrayList);
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCONTAINERSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCContainerSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDCContainerSpec), arrayList.get(0)));
        }
    }

    public void resetPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSDCContainerSpecId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        final PSDCContainerSpec pSDCContainerSpec2 = pSDCContainerSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void internalRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSDCFileId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRegistryRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDCRegistryRepo), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSDCRegistryRepoId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        final PSDCRegistryRepo pSDCRegistryRepo2 = pSDCRegistryRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDeployCenter(pSDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDEPLOYCENTER_PSDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDeployCenter(pSDeployCenter);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSDeployCenterId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        final PSDeployCenter pSDeployCenter2 = pSDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSDeployCenter(pSDeployCenter2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSDeployCenter(pSDeployCenter2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSDeployCenter(pSDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDeployCenter(pSDeployCenter);
        this.onBeforeRemoveByPSDeployCenter(pSDeployCenter, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSDeployCenter(pSDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByCfgPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDEVCENTERSVN_CFGPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByCfgPSDevCenterSVN(pSDevCenterSVN);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setCfgPSDevCenterSVNId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByCfgPSDevCenterSVN(pSDevCenterSVN2);
                PSDCDeployCenterServiceBase.this.internalRemoveByCfgPSDevCenterSVN(pSDevCenterSVN2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByCfgPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByCfgPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByCfgPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByCfgPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSDevCenterId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCDEPLOYCENTER_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCDEPLOYCENTER", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            PSDCDeployCenter pSDCDeployCenter2 = (PSDCDeployCenter)this.getDEModel().createEntity();
            pSDCDeployCenter2.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
            pSDCDeployCenter2.setPSDevSlnId(null);
            this.update(pSDCDeployCenter2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDeployCenterServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCDeployCenterServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCDeployCenterServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCDeployCenter> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCDeployCenter pSDCDeployCenter : arrayList) {
            this.remove(pSDCDeployCenter);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCDeployCenter> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCDeployServerService)ServiceGlobal.getService(PSDCDeployServerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDeployServerServiceBase)pSCoreSysServiceBase).testRemoveByPSDCDeployCenter(pSDCDeployCenter);
        pSCoreSysServiceBase = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformServiceBase)pSCoreSysServiceBase).testRemoveByPSDCDeployCenter(pSDCDeployCenter);
        pSCoreSysServiceBase = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineServiceBase)pSCoreSysServiceBase).testRemoveByPSDCDeployCenter(pSDCDeployCenter);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDCDeployCenter(pSDCDeployCenter);
        pSCoreSysServiceBase = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnServiceBase)pSCoreSysServiceBase).testRemoveByPSDCDeployCenter(pSDCDeployCenter);
        super.onBeforeRemove(pSDCDeployCenter);
    }

    protected void replaceParentInfo(PSDCDeployCenter pSDCDeployCenter, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCDeployCenter, cloneSession);
        if (pSDCDeployCenter.getCfgPSCredentialId() != null && (iEntity = cloneSession.getEntity("PSCREDENTIAL", (Object)pSDCDeployCenter.getCfgPSCredentialId())) != null) {
            this.onFillParentInfo_CfgPSCredential(pSDCDeployCenter, (PSCredential)iEntity);
        }
        if (pSDCDeployCenter.getPSCredentialId() != null && (iEntity = cloneSession.getEntity("PSCREDENTIAL", (Object)pSDCDeployCenter.getPSCredentialId())) != null) {
            this.onFillParentInfo_PSCredential(pSDCDeployCenter, (PSCredential)iEntity);
        }
        if (pSDCDeployCenter.getPSDCClusterId() != null && (iEntity = cloneSession.getEntity("PSDCCLUSTER", (Object)pSDCDeployCenter.getPSDCClusterId())) != null) {
            this.onFillParentInfo_PSDCCluster(pSDCDeployCenter, (PSDCCluster)iEntity);
        }
        if (pSDCDeployCenter.getPSDCContainerSpecId() != null && (iEntity = cloneSession.getEntity("PSDCCONTAINERSPEC", (Object)pSDCDeployCenter.getPSDCContainerSpecId())) != null) {
            this.onFillParentInfo_PSDCContainerSpec(pSDCDeployCenter, (PSDCContainerSpec)iEntity);
        }
        if (pSDCDeployCenter.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDCDeployCenter.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDCDeployCenter, (PSDCFile)iEntity);
        }
        if (pSDCDeployCenter.getPSDCRegistryRepoId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYREPO", (Object)pSDCDeployCenter.getPSDCRegistryRepoId())) != null) {
            this.onFillParentInfo_PSDCRegistryRepo(pSDCDeployCenter, (PSDCRegistryRepo)iEntity);
        }
        if (pSDCDeployCenter.getPSDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDEPLOYCENTER", (Object)pSDCDeployCenter.getPSDeployCenterId())) != null) {
            this.onFillParentInfo_PSDeployCenter(pSDCDeployCenter, (PSDeployCenter)iEntity);
        }
        if (pSDCDeployCenter.getCfgPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDCDeployCenter.getCfgPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_CfgPSDevCenterSVN(pSDCDeployCenter, (PSDevCenterSVN)iEntity);
        }
        if (pSDCDeployCenter.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCDeployCenter.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCDeployCenter, (PSDevCenter)iEntity);
        }
        if (pSDCDeployCenter.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCDeployCenter.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCDeployCenter, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCDeployCenter, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPasswd(bl, pSDCDeployCenter, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminUserName(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APIToken(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APIUrl(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgBranch(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgPSCredentialId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgPSDevCenterSVNId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgUrl(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCType(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCType2(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCredentialId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCredentials(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCClusterId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterName(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryRepoId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployCenterId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployCenterName(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSGitUsers(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCount(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResVer(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebConsolePath(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDCDeployCenter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCDeployCenter, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPasswd(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isAdminPasswdDirty() : !pSDCDeployCenter.isAdminPasswdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getAdminPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPasswd_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AdminUserName(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isAdminUserNameDirty() : !pSDCDeployCenter.isAdminUserNameDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getAdminUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminUserName_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APIToken(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isAPITokenDirty() : !pSDCDeployCenter.isAPITokenDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getAPIToken();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APIToken_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APITOKEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APIUrl(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isAPIUrlDirty() : !pSDCDeployCenter.isAPIUrlDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getAPIUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APIUrl_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APIURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgBranch(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isCfgBranchDirty() : !pSDCDeployCenter.isCfgBranchDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getCfgBranch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgBranch_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGBRANCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgPSCredentialId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isCfgPSCredentialIdDirty() : !pSDCDeployCenter.isCfgPSCredentialIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getCfgPSCredentialId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgPSCredentialId_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGPSCREDENTIALID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgPSDevCenterSVNId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isCfgPSDevCenterSVNIdDirty() : !pSDCDeployCenter.isCfgPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getCfgPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgPSDevCenterSVNId_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgUrl(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isCfgUrlDirty() : !pSDCDeployCenter.isCfgUrlDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getCfgUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgUrl_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCType(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isDCTypeDirty() && !bl2 : !pSDCDeployCenter.isDCTypeDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getDCType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCType_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_DCType2(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isDCType2Dirty() : !pSDCDeployCenter.isDCType2Dirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getDCType2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DCType2_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTYPE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isDefaultFlagDirty() && !bl2 : !pSDCDeployCenter.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEVCENTERID";
                String string2 = this.checkFieldDupRule(this.getPSDCDeployCenterDEModel(), "DEFAULTFLAG", string, pSDCDeployCenter, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isExpriedTimeDirty() : !pSDCDeployCenter.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCDeployCenter.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isIpAddrDirty() : !pSDCDeployCenter.isIpAddrDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isIpAddr2Dirty() : !pSDCDeployCenter.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isMemoDirty() : !pSDCDeployCenter.isMemoDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPasswdDirty() : !pSDCDeployCenter.isPasswdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_Port(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPortDirty() : !pSDCDeployCenter.isPortDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCredentialId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSCredentialIdDirty() : !pSDCDeployCenter.isPSCredentialIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSCredentialId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCredentialId_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCREDENTIALID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCredentials(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSCredentialsDirty() : !pSDCDeployCenter.isPSCredentialsDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSCredentials();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCredentials_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCREDENTIALS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCClusterId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDCClusterIdDirty() : !pSDCDeployCenter.isPSDCClusterIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDCClusterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCClusterId_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCLUSTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDCContainerSpecIdDirty() : !pSDCDeployCenter.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDCContainerSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDeployCenterId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDCDeployCenterIdDirty() && !bl2 : !pSDCDeployCenter.isPSDCDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDCDeployCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterId_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDeployCenterName(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDCDeployCenterNameDirty() && !bl2 : !pSDCDeployCenter.isPSDCDeployCenterNameDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDCDeployCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterName_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDCDeployCenterDEModel(), "PSDCDEPLOYCENTERNAME", string3, pSDCDeployCenter, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCDEPLOYCENTERNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDCFileIdDirty() : !pSDCDeployCenter.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRegistryRepoId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDCRegistryRepoIdDirty() : !pSDCDeployCenter.isPSDCRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDCRegistryRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryRepoId_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDeployCenterId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDeployCenterIdDirty() : !pSDCDeployCenter.isPSDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployCenterId_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDeployCenterName(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDeployCenterNameDirty() : !pSDCDeployCenter.isPSDeployCenterNameDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDeployCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployCenterName_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDevCenterIdDirty() : !pSDCDeployCenter.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDevCenterNameDirty() : !pSDCDeployCenter.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSDevSlnIdDirty() : !pSDCDeployCenter.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSGitUsers(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isPSGitUsersDirty() : !pSDCDeployCenter.isPSGitUsersDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getPSGitUsers();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSGitUsers_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSGITUSERS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCount(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isRefCountDirty() : !pSDCDeployCenter.isRefCountDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getRefCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefCount_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isResPosDirty() : !pSDCDeployCenter.isResPosDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isResReadyTimeDirty() : !pSDCDeployCenter.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCDeployCenter.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isResStateDirty() : !pSDCDeployCenter.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResVer(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isResVerDirty() : !pSDCDeployCenter.isResVerDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getResVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResVer_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isSSHIPAddrDirty() : !pSDCDeployCenter.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHIPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isSSHPortDirty() : !pSDCDeployCenter.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isUploadFileModeDirty() : !pSDCDeployCenter.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADFILEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isUploadPathDirty() : !pSDCDeployCenter.isUploadPathDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isUserNameDirty() : !pSDCDeployCenter.isUserNameDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isValidFlagDirty() && !bl2 : !pSDCDeployCenter.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCDeployCenter.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCDeployCenter, bl2, bl3);
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

    protected EntityFieldError onCheckField_WebConsolePath(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isWebConsolePathDirty() : !pSDCDeployCenter.isWebConsolePathDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getWebConsolePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebConsolePath_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WEBCONSOLEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDCDeployCenter pSDCDeployCenter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDeployCenter.isWorkshopPathDirty() : !pSDCDeployCenter.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDCDeployCenter.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSDCDeployCenter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
        super.onSyncEntity(pSDCDeployCenter, bl);
    }

    protected void onSyncIndexEntities(PSDCDeployCenter pSDCDeployCenter, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCDeployCenter, bl);
    }

    public Object getDataContextValue(PSDCDeployCenter pSDCDeployCenter, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCDeployCenter, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCDeployCenter pSDCDeployCenter, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCDeployCenter, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITOKEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APIToken_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APIURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APIUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGBRANCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgBranch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGPSCREDENTIALID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgPSCredentialId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGPSCREDENTIALNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgPSCredentialName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTYPE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCType2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCREDENTIALID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCredentialId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCREDENTIALNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCredentialName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCREDENTIALS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCredentials_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCLUSTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCClusterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployCenterName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSGITUSERS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSGitUsers_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADFILEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadFileMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WEBCONSOLEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebConsolePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AdminPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APIToken_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APITOKEN", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APIUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APIURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgBranch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGBRANCH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgPSCredentialId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGPSCREDENTIALID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgPSCredentialName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGPSCREDENTIALNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
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

    protected String onTestValueRule_DCType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DCType2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DCTYPE2", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Port_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSCredentialId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCREDENTIALID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCredentialName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCREDENTIALNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCredentials_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCREDENTIALS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCClusterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCLUSTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCClusterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCLUSTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDeployCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDeployCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSGitUsers_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSGITUSERS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_SSHIPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SSHIPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UploadFileMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADFILEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UploadPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WebConsolePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WEBCONSOLEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WorkshopPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCDeployCenter pSDCDeployCenter) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCDeployCenter)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        super.onUpdateParent(pSDCDeployCenter);
    }

    @Override
    protected void exportCurXmlModel(PSDCDeployCenter pSDCDeployCenter, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCDEPLOYCENTER");
        if (!bl) {
            pSDCDeployCenter.setCreateDate(null);
            pSDCDeployCenter.setCreateMan(null);
            pSDCDeployCenter.setPSDCDeployCenterId(null);
            pSDCDeployCenter.setRefCount(null);
            pSDCDeployCenter.setUpdateDate(null);
            pSDCDeployCenter.setUpdateMan(null);
            super.exportCurXmlModel(pSDCDeployCenter, xmlNode, bl);
        }
    }
}

