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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCRegistryRepoDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryRepoDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCClusterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpecBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryServerBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredentialBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepoBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRegistryRepoServiceBase
extends PSCoreSysServiceBase<PSDCRegistryRepo> {
    private static final Log log = LogFactory.getLog(PSDCRegistryRepoServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCRegistryRepoDEModel pSDCRegistryRepoDEModel;
    private PSDCRegistryRepoDAO pSDCRegistryRepoDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService";
    }

    public PSDCRegistryRepoDEModel getPSDCRegistryRepoDEModel() {
        if (this.pSDCRegistryRepoDEModel == null) {
            try {
                this.pSDCRegistryRepoDEModel = (PSDCRegistryRepoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryRepoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRegistryRepoDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCRegistryRepoDEModel();
    }

    public PSDCRegistryRepoDAO getPSDCRegistryRepoDAO() {
        if (this.pSDCRegistryRepoDAO == null) {
            try {
                this.pSDCRegistryRepoDAO = (PSDCRegistryRepoDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCRegistryRepoDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRegistryRepoDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCRegistryRepoDAO();
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

    protected void onFillParentInfo(PSDCRegistryRepo pSDCRegistryRepo, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSCREDENTIAL_PSCREDENTIALID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService", (SessionFactory)this.getSessionFactory());
            PSCredential pSCredential = (PSCredential)iService.getDEModel().createEntity();
            pSCredential.set("PSCREDENTIALID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCredential);
            } else {
                iService.get((IEntity)pSCredential);
            }
            this.onFillParentInfo_PSCredential(pSDCRegistryRepo, pSCredential);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSCREDENTIAL_ROPSCREDENTIALID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService", (SessionFactory)this.getSessionFactory());
            PSCredential pSCredential = (PSCredential)iService.getDEModel().createEntity();
            pSCredential.set("PSCREDENTIALID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCredential);
            } else {
                iService.get((IEntity)pSCredential);
            }
            this.onFillParentInfo_ROPSCredential(pSDCRegistryRepo, pSCredential);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSDCCLUSTER_PSDCCLUSTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService", (SessionFactory)this.getSessionFactory());
            PSDCCluster pSDCCluster = (PSDCCluster)iService.getDEModel().createEntity();
            pSDCCluster.set("PSDCCLUSTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCCluster);
            } else {
                iService.get((IEntity)pSDCCluster);
            }
            this.onFillParentInfo_PSDCCluster(pSDCRegistryRepo, pSDCCluster);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory());
            PSDCContainerSpec pSDCContainerSpec = (PSDCContainerSpec)iService.getDEModel().createEntity();
            pSDCContainerSpec.set("PSDCCONTAINERSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCContainerSpec);
            } else {
                iService.get((IEntity)pSDCContainerSpec);
            }
            this.onFillParentInfo_PSDCContainerSpec(pSDCRegistryRepo, pSDCContainerSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCFile);
            } else {
                iService.get((IEntity)pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDCRegistryRepo, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSDCREGISTRYSERVER_PSDCREGISTRYSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryServerService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryServer pSDCRegistryServer = (PSDCRegistryServer)iService.getDEModel().createEntity();
            pSDCRegistryServer.set("PSDCREGISTRYSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRegistryServer);
            } else {
                iService.get((IEntity)pSDCRegistryServer);
            }
            this.onFillParentInfo_PSDCRegistryServer(pSDCRegistryRepo, pSDCRegistryServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCRegistryRepo, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCRegistryRepo, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCREGISTRYREPO_PSREGISTRYREPO_PSREGISTRYREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService", (SessionFactory)this.getSessionFactory());
            PSRegistryRepo pSRegistryRepo = (PSRegistryRepo)iService.getDEModel().createEntity();
            pSRegistryRepo.set("PSREGISTRYREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSRegistryRepo);
            } else {
                iService.get((IEntity)pSRegistryRepo);
            }
            this.onFillParentInfo_PSRegistryRepo(pSDCRegistryRepo, pSRegistryRepo);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCRegistryRepo, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCredential(PSDCRegistryRepo pSDCRegistryRepo, PSCredential pSCredential) throws Exception {
        pSDCRegistryRepo.setPSCredentialId(pSCredential.getPSCredentialId());
        pSDCRegistryRepo.setPSCredentialName(pSCredential.getPSCredentialName());
    }

    protected void onFillParentInfo_ROPSCredential(PSDCRegistryRepo pSDCRegistryRepo, PSCredential pSCredential) throws Exception {
        pSDCRegistryRepo.setROPSCredentialId(pSCredential.getPSCredentialId());
        pSDCRegistryRepo.setROPSCredentialName(pSCredential.getPSCredentialName());
    }

    protected void onFillParentInfo_PSDCCluster(PSDCRegistryRepo pSDCRegistryRepo, PSDCCluster pSDCCluster) throws Exception {
        pSDCRegistryRepo.setPSDCClusterId(pSDCCluster.getPSDCClusterId());
        pSDCRegistryRepo.setPSDCClusterName(pSDCCluster.getPSDCClusterName());
    }

    protected void onFillParentInfo_PSDCContainerSpec(PSDCRegistryRepo pSDCRegistryRepo, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        pSDCRegistryRepo.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
        pSDCRegistryRepo.setPSDCContainerSpecName(pSDCContainerSpec.getPSDCContainerSpecName());
    }

    protected void onFillParentInfo_PSDCFile(PSDCRegistryRepo pSDCRegistryRepo, PSDCFile pSDCFile) throws Exception {
        pSDCRegistryRepo.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDCRegistryRepo.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDCRegistryServer(PSDCRegistryRepo pSDCRegistryRepo, PSDCRegistryServer pSDCRegistryServer) throws Exception {
        pSDCRegistryRepo.setPSDCRegistryServerId(pSDCRegistryServer.getPSDCRegistryServerId());
        pSDCRegistryRepo.setPSDCRegistryServerName(pSDCRegistryServer.getPSDCRegistryServerName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCRegistryRepo pSDCRegistryRepo, PSDevCenter pSDevCenter) throws Exception {
        pSDCRegistryRepo.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCRegistryRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCRegistryRepo pSDCRegistryRepo, PSDevSln pSDevSln) throws Exception {
        pSDCRegistryRepo.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCRegistryRepo.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, PSRegistryRepo pSRegistryRepo) throws Exception {
        pSDCRegistryRepo.setPSRegistryRepoId(pSRegistryRepo.getPSRegistryRepoId());
        pSDCRegistryRepo.setPSRegistryRepoName(pSRegistryRepo.getPSRegistryRepoName());
    }

    protected void onFillEntityFullInfo(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
        if (bl && pSDCRegistryRepo.getValidFlag() == null) {
            pSDCRegistryRepo.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSCredential(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_ROPSCredential(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSDCCluster(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSDCContainerSpec(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSDCRegistryServer(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCRegistryRepo, bl);
        this.onFillEntityFullInfo_PSRegistryRepo(pSDCRegistryRepo, bl);
    }

    protected void onFillEntityFullInfo_PSCredential(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ROPSCredential(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCCluster(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCContainerSpec(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCRegistryServer(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
        if (pSDCRegistryRepo.isPSDevCenterIdDirty()) {
            if (pSDCRegistryRepo.getPSDevCenterId() != null) {
                if (pSDCRegistryRepo.getPSDevCenterId() == null || pSDCRegistryRepo.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCRegistryRepo.getPSDevCenter();
                    pSDCRegistryRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCRegistryRepo.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCRegistryRepo, bl);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSCredential(PSCredentialBase pSCredentialBase) throws Exception {
        return this.selectByPSCredential(pSCredentialBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSCredential(PSCredentialBase pSCredentialBase, String string) throws Exception {
        return this.selectByPSCredential(pSCredentialBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSCredential(PSCredentialBase pSCredentialBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRegistryRepo> selectByROPSCredential(PSCredentialBase pSCredentialBase) throws Exception {
        return this.selectByROPSCredential(pSCredentialBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByROPSCredential(PSCredentialBase pSCredentialBase, String string) throws Exception {
        return this.selectByROPSCredential(pSCredentialBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByROPSCredential(PSCredentialBase pSCredentialBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ROPSCREDENTIALID", (Object)pSCredentialBase.getPSCredentialId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByROPSCredentialCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByROPSCredentialCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRegistryRepo> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRegistryRepo> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRegistryRepo> selectByPSDCRegistryServer(PSDCRegistryServerBase pSDCRegistryServerBase) throws Exception {
        return this.selectByPSDCRegistryServer(pSDCRegistryServerBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCRegistryServer(PSDCRegistryServerBase pSDCRegistryServerBase, String string) throws Exception {
        return this.selectByPSDCRegistryServer(pSDCRegistryServerBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDCRegistryServer(PSDCRegistryServerBase pSDCRegistryServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCREGISTRYSERVERID", (Object)pSDCRegistryServerBase.getPSDCRegistryServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRegistryServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRegistryServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRegistryRepo> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCRegistryRepo> selectByPSRegistryRepo(PSRegistryRepoBase pSRegistryRepoBase) throws Exception {
        return this.selectByPSRegistryRepo(pSRegistryRepoBase, "", -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSRegistryRepo(PSRegistryRepoBase pSRegistryRepoBase, String string) throws Exception {
        return this.selectByPSRegistryRepo(pSRegistryRepoBase, string, -1);
    }

    public ArrayList<PSDCRegistryRepo> selectByPSRegistryRepo(PSRegistryRepoBase pSRegistryRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSREGISTRYREPOID", (Object)pSRegistryRepoBase.getPSRegistryRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRegistryRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRegistryRepoCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSCredential(pSCredential, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCREDENTIAL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCredential);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSCREDENTIAL_PSCREDENTIALID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSCredential), arrayList.get(0)));
        }
    }

    public void resetPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSCredential(pSCredential);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSCredentialId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSCredential(PSCredential pSCredential) throws Exception {
        final PSCredential pSCredential2 = pSCredential;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSCredential(pSCredential2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSCredential(pSCredential2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSCredential(pSCredential2);
            }
        });
    }

    protected void onBeforeRemoveByPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void internalRemoveByPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSCredential(pSCredential);
        this.onBeforeRemoveByPSCredential(pSCredential, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSCredential(pSCredential, arrayList);
    }

    protected void onAfterRemoveByPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void onBeforeRemoveByPSCredential(PSCredential pSCredential, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCredential(PSCredential pSCredential, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByROPSCredential(pSCredential, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCREDENTIAL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCredential);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSCREDENTIAL_ROPSCREDENTIALID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSCredential), arrayList.get(0)));
        }
    }

    public void resetROPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByROPSCredential(pSCredential);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setROPSCredentialId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByROPSCredential(PSCredential pSCredential) throws Exception {
        final PSCredential pSCredential2 = pSCredential;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByROPSCredential(pSCredential2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByROPSCredential(pSCredential2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByROPSCredential(pSCredential2);
            }
        });
    }

    protected void onBeforeRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void internalRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByROPSCredential(pSCredential);
        this.onBeforeRemoveByROPSCredential(pSCredential, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByROPSCredential(pSCredential, arrayList);
    }

    protected void onAfterRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void onBeforeRemoveByROPSCredential(PSCredential pSCredential, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByROPSCredential(PSCredential pSCredential, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCCluster(pSDCCluster, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCLUSTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCCluster);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSDCCLUSTER_PSDCCLUSTERID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSDCCluster), arrayList.get(0)));
        }
    }

    public void resetPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCCluster(pSDCCluster);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSDCClusterId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        final PSDCCluster pSDCCluster2 = pSDCCluster;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSDCCluster(pSDCCluster2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSDCCluster(pSDCCluster2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSDCCluster(pSDCCluster2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void internalRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCCluster(pSDCCluster);
        this.onBeforeRemoveByPSDCCluster(pSDCCluster, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSDCCluster(pSDCCluster, arrayList);
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCONTAINERSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCContainerSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSDCContainerSpec), arrayList.get(0)));
        }
    }

    public void resetPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSDCContainerSpecId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        final PSDCContainerSpec pSDCContainerSpec2 = pSDCContainerSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void internalRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSDCFileId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCRegistryServer(pSDCRegistryServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCRegistryServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSDCREGISTRYSERVER_PSDCREGISTRYSERVERID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSDCRegistryServer), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCRegistryServer(pSDCRegistryServer);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSDCRegistryServerId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer) throws Exception {
        final PSDCRegistryServer pSDCRegistryServer2 = pSDCRegistryServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSDCRegistryServer(pSDCRegistryServer2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSDCRegistryServer(pSDCRegistryServer2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSDCRegistryServer(pSDCRegistryServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDCRegistryServer(pSDCRegistryServer);
        this.onBeforeRemoveByPSDCRegistryServer(pSDCRegistryServer, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSDCRegistryServer(pSDCRegistryServer, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryServer(PSDCRegistryServer pSDCRegistryServer, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSDevCenterId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSDevSlnId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    public void testRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSRegistryRepo(pSRegistryRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSREGISTRYREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSRegistryRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCREGISTRYREPO_PSREGISTRYREPO_PSREGISTRYREPOID", "", iDataEntityModel.getName(), "PSDCREGISTRYREPO", iDataEntityModel.getDataInfo((IEntity)pSRegistryRepo), arrayList.get(0)));
        }
    }

    public void resetPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSRegistryRepo(pSRegistryRepo);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            PSDCRegistryRepo pSDCRegistryRepo2 = (PSDCRegistryRepo)this.getDEModel().createEntity();
            pSDCRegistryRepo2.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
            pSDCRegistryRepo2.setPSRegistryRepoId(null);
            this.update(pSDCRegistryRepo2);
        }
    }

    public void removeByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        final PSRegistryRepo pSRegistryRepo2 = pSRegistryRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRegistryRepoServiceBase.this.onBeforeRemoveByPSRegistryRepo(pSRegistryRepo2);
                PSDCRegistryRepoServiceBase.this.internalRemoveByPSRegistryRepo(pSRegistryRepo2);
                PSDCRegistryRepoServiceBase.this.onAfterRemoveByPSRegistryRepo(pSRegistryRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
    }

    protected void internalRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
        ArrayList<PSDCRegistryRepo> arrayList = this.selectByPSRegistryRepo(pSRegistryRepo);
        this.onBeforeRemoveByPSRegistryRepo(pSRegistryRepo, arrayList);
        for (PSDCRegistryRepo pSDCRegistryRepo : arrayList) {
            this.remove((IEntity)pSDCRegistryRepo);
        }
        this.onAfterRemoveByPSRegistryRepo(pSRegistryRepo, arrayList);
    }

    protected void onAfterRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRegistryRepo(PSRegistryRepo pSRegistryRepo, ArrayList<PSDCRegistryRepo> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDeployCenterServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRegistryRepo(pSDCRegistryRepo);
        pSCoreSysServiceBase = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRegistryRepo(pSDCRegistryRepo);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRegistryRepo(pSDCRegistryRepo);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDCRegistryRepo(pSDCRegistryRepo);
        super.onBeforeRemove(pSDCRegistryRepo);
    }

    protected void replaceParentInfo(PSDCRegistryRepo pSDCRegistryRepo, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCRegistryRepo, cloneSession);
        if (pSDCRegistryRepo.getPSCredentialId() != null && (iEntity = cloneSession.getEntity("PSCREDENTIAL", (Object)pSDCRegistryRepo.getPSCredentialId())) != null) {
            this.onFillParentInfo_PSCredential(pSDCRegistryRepo, (PSCredential)iEntity);
        }
        if (pSDCRegistryRepo.getROPSCredentialId() != null && (iEntity = cloneSession.getEntity("PSCREDENTIAL", (Object)pSDCRegistryRepo.getROPSCredentialId())) != null) {
            this.onFillParentInfo_ROPSCredential(pSDCRegistryRepo, (PSCredential)iEntity);
        }
        if (pSDCRegistryRepo.getPSDCClusterId() != null && (iEntity = cloneSession.getEntity("PSDCCLUSTER", (Object)pSDCRegistryRepo.getPSDCClusterId())) != null) {
            this.onFillParentInfo_PSDCCluster(pSDCRegistryRepo, (PSDCCluster)iEntity);
        }
        if (pSDCRegistryRepo.getPSDCContainerSpecId() != null && (iEntity = cloneSession.getEntity("PSDCCONTAINERSPEC", (Object)pSDCRegistryRepo.getPSDCContainerSpecId())) != null) {
            this.onFillParentInfo_PSDCContainerSpec(pSDCRegistryRepo, (PSDCContainerSpec)iEntity);
        }
        if (pSDCRegistryRepo.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDCRegistryRepo.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDCRegistryRepo, (PSDCFile)iEntity);
        }
        if (pSDCRegistryRepo.getPSDCRegistryServerId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYSERVER", (Object)pSDCRegistryRepo.getPSDCRegistryServerId())) != null) {
            this.onFillParentInfo_PSDCRegistryServer(pSDCRegistryRepo, (PSDCRegistryServer)iEntity);
        }
        if (pSDCRegistryRepo.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCRegistryRepo.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCRegistryRepo, (PSDevCenter)iEntity);
        }
        if (pSDCRegistryRepo.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCRegistryRepo.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCRegistryRepo, (PSDevSln)iEntity);
        }
        if (pSDCRegistryRepo.getPSRegistryRepoId() != null && (iEntity = cloneSession.getEntity("PSREGISTRYREPO", (Object)pSDCRegistryRepo.getPSRegistryRepoId())) != null) {
            this.onFillParentInfo_PSRegistryRepo(pSDCRegistryRepo, (PSRegistryRepo)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCRegistryRepo, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSDCRegistryRepo, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCredentialId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCClusterId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryRepoId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryRepoName(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryServerId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRegistryRepoId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegistryPasswd(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegistryType(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegistryUserName(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPasswd(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPSCredentialId(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROUserName(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCRegistryRepo, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCRegistryRepo, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isConnStrDirty() && !bl2 : !pSDCRegistryRepo.isConnStrDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getConnStr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isDefaultFlagDirty() && !bl2 : !pSDCRegistryRepo.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDCRegistryRepo.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isMemoDirty() : !pSDCRegistryRepo.isMemoDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isParamDirty() : !pSDCRegistryRepo.isParamDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param2(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isParam2Dirty() : !pSDCRegistryRepo.isParam2Dirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param3(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isParam3Dirty() : !pSDCRegistryRepo.isParam3Dirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param4(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isParam4Dirty() : !pSDCRegistryRepo.isParam4Dirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCredentialId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSCredentialIdDirty() : !pSDCRegistryRepo.isPSCredentialIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSCredentialId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCredentialId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCClusterId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDCClusterIdDirty() : !pSDCRegistryRepo.isPSDCClusterIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDCClusterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCClusterId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDCContainerSpecIdDirty() : !pSDCRegistryRepo.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDCContainerSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDCFileIdDirty() : !pSDCRegistryRepo.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRegistryRepoId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDCRegistryRepoIdDirty() && !bl2 : !pSDCRegistryRepo.isPSDCRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDCRegistryRepoId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYREPOID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryRepoId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRegistryRepoName(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDCRegistryRepoNameDirty() && !bl2 : !pSDCRegistryRepo.isPSDCRegistryRepoNameDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDCRegistryRepoName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYREPONAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryRepoName_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYREPONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRegistryServerId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDCRegistryServerIdDirty() : !pSDCRegistryRepo.isPSDCRegistryServerIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDCRegistryServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryServerId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCREGISTRYSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDevCenterIdDirty() : !pSDCRegistryRepo.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDevCenterNameDirty() : !pSDCRegistryRepo.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSDevSlnIdDirty() : !pSDCRegistryRepo.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSRegistryRepoId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isPSRegistryRepoIdDirty() : !pSDCRegistryRepo.isPSRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getPSRegistryRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRegistryRepoId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSREGISTRYREPOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegistryPasswd(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isRegistryPasswdDirty() : !pSDCRegistryRepo.isRegistryPasswdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getRegistryPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegistryPasswd_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegistryType(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isRegistryTypeDirty() && !bl2 : !pSDCRegistryRepo.isRegistryTypeDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getRegistryType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegistryType_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegistryUserName(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isRegistryUserNameDirty() : !pSDCRegistryRepo.isRegistryUserNameDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getRegistryUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegistryUserName_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGISTRYUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isResPosDirty() : !pSDCRegistryRepo.isResPosDirty()) {
            return null;
        }
        Integer n = pSDCRegistryRepo.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isResStateDirty() : !pSDCRegistryRepo.isResStateDirty()) {
            return null;
        }
        Integer n = pSDCRegistryRepo.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_ROPasswd(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isROPasswdDirty() : !pSDCRegistryRepo.isROPasswdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getROPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPasswd_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROPSCredentialId(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isROPSCredentialIdDirty() : !pSDCRegistryRepo.isROPSCredentialIdDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getROPSCredentialId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPSCredentialId_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPSCREDENTIALID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROUserName(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isROUserNameDirty() : !pSDCRegistryRepo.isROUserNameDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getROUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROUserName_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isUserTagDirty() : !pSDCRegistryRepo.isUserTagDirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isUserTag2Dirty() : !pSDCRegistryRepo.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isUserTag3Dirty() : !pSDCRegistryRepo.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isUserTag4Dirty() : !pSDCRegistryRepo.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDCRegistryRepo.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCRegistryRepo pSDCRegistryRepo, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRegistryRepo.isValidFlagDirty() && !bl2 : !pSDCRegistryRepo.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCRegistryRepo.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDCRegistryRepo, bl2, bl3);
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

    protected void onSyncEntity(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCRegistryRepo, bl);
    }

    protected void onSyncIndexEntities(PSDCRegistryRepo pSDCRegistryRepo, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCRegistryRepo, bl);
    }

    public Object getDataContextValue(PSDCRegistryRepo pSDCRegistryRepo, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCRegistryRepo, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDCRegistryRepo.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCRegistryRepo, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSCREDENTIALID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCredentialId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCREDENTIALNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCredentialName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCREGISTRYSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRegistryServerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSREGISTRYREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSREGISTRYREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRegistryRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGISTRYPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegistryPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGISTRYTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegistryType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGISTRYUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegistryUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSCREDENTIALID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSCredentialId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSCREDENTIALNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSCredentialName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDCRegistryServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRegistryServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCREGISTRYSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSRegistryRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYREPOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRegistryRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSREGISTRYREPONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegistryPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGISTRYPASSWD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegistryType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGISTRYTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegistryUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGISTRYUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ROPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPASSWD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSCredentialId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSCREDENTIALID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSCredentialName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSCREDENTIALNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCRegistryRepo)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        super.onUpdateParent((IEntity)pSDCRegistryRepo);
    }

    @Override
    protected void exportCurXmlModel(PSDCRegistryRepo pSDCRegistryRepo, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCREGISTRYREPO");
        if (!bl) {
            pSDCRegistryRepo.setCreateDate(null);
            pSDCRegistryRepo.setCreateMan(null);
            pSDCRegistryRepo.setPSDCContainerSpecName(null);
            pSDCRegistryRepo.setPSDCRegistryRepoId(null);
            pSDCRegistryRepo.setUpdateDate(null);
            pSDCRegistryRepo.setUpdateMan(null);
            super.exportCurXmlModel(pSDCRegistryRepo, xmlNode, bl);
        }
    }
}

