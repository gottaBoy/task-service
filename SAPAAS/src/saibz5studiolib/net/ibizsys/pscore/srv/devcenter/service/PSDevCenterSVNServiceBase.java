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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterSVNDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterSVNDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCClusterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpecBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredentialBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser;
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUserBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepoBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterSVNServiceBase
extends PSCoreSysServiceBase<PSDevCenterSVN> {
    private static final Log log = LogFactory.getLog(PSDevCenterSVNServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDC2 = "CurDC2";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLN2 = "CurSln2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_BIND = "Bind";
    public static final String ACTION_UNBIND = "Unbind";
    private PSDevCenterSVNDEModel pSDevCenterSVNDEModel;
    private PSDevCenterSVNDAO pSDevCenterSVNDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService";
    }

    public PSDevCenterSVNDEModel getPSDevCenterSVNDEModel() {
        if (this.pSDevCenterSVNDEModel == null) {
            try {
                this.pSDevCenterSVNDEModel = (PSDevCenterSVNDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterSVNDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterSVNDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevCenterSVNDEModel();
    }

    public PSDevCenterSVNDAO getPSDevCenterSVNDAO() {
        if (this.pSDevCenterSVNDAO == null) {
            try {
                this.pSDevCenterSVNDAO = (PSDevCenterSVNDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterSVNDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterSVNDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevCenterSVNDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC2, (boolean)true) == 0) {
            return this.fetchCurDC2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN2, (boolean)true) == 0) {
            return this.fetchCurSln2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_BIND, (boolean)true) == 0) {
            this.bind((PSDevCenterSVN)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UNBIND, (boolean)true) == 0) {
            this.unbind((PSDevCenterSVN)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void bind(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_BIND, 0, pSDevCenterSVN, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevCenterSVN, ACTION_BIND);
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterSVNServiceBase.this.getService(), PSDevCenterSVNServiceBase.ACTION_BIND, 40, pSDevCenterSVN2, null).getResult() != 1) {
                    PSDevCenterSVNServiceBase.this.onBind(pSDevCenterSVN2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_BIND, 99, pSDevCenterSVN, null);
        }
    }

    protected void onBind(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[Bind]");
    }

    public void unbind(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UNBIND, 0, pSDevCenterSVN, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevCenterSVN, ACTION_UNBIND);
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterSVNServiceBase.this.getService(), PSDevCenterSVNServiceBase.ACTION_UNBIND, 40, pSDevCenterSVN2, null).getResult() != 1) {
                    PSDevCenterSVNServiceBase.this.onUnbind(pSDevCenterSVN2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UNBIND, 99, pSDevCenterSVN, null);
        }
    }

    protected void onUnbind(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[Unbind]");
    }

    protected void onFillParentInfo(PSDevCenterSVN pSDevCenterSVN, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSCREDENTIAL_PSCREDENTIALID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService", (SessionFactory)this.getSessionFactory());
            PSCredential pSCredential = (PSCredential)iService.getDEModel().createEntity();
            pSCredential.set("PSCREDENTIALID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCredential);
            } else {
                iService.get(pSCredential);
            }
            this.onFillParentInfo_PSCredential(pSDevCenterSVN, pSCredential);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSCREDENTIAL_ROPSCREDENTIALID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService", (SessionFactory)this.getSessionFactory());
            PSCredential pSCredential = (PSCredential)iService.getDEModel().createEntity();
            pSCredential.set("PSCREDENTIALID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCredential);
            } else {
                iService.get(pSCredential);
            }
            this.onFillParentInfo_ROPSCredential(pSDevCenterSVN, pSCredential);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSDCCLUSTER_PSDCCLUSTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService", (SessionFactory)this.getSessionFactory());
            PSDCCluster pSDCCluster = (PSDCCluster)iService.getDEModel().createEntity();
            pSDCCluster.set("PSDCCLUSTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCluster);
            } else {
                iService.get(pSDCCluster);
            }
            this.onFillParentInfo_PSDCCluster(pSDevCenterSVN, pSDCCluster);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory());
            PSDCContainerSpec pSDCContainerSpec = (PSDCContainerSpec)iService.getDEModel().createEntity();
            pSDCContainerSpec.set("PSDCCONTAINERSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCContainerSpec);
            } else {
                iService.get(pSDCContainerSpec);
            }
            this.onFillParentInfo_PSDCContainerSpec(pSDevCenterSVN, pSDCContainerSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCFile);
            } else {
                iService.get(pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDevCenterSVN, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevCenterSVN, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevCenterSVN, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSGITUSER_PSGITUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService", (SessionFactory)this.getSessionFactory());
            PSGitUser pSGitUser = (PSGitUser)iService.getDEModel().createEntity();
            pSGitUser.set("PSGITUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSGitUser);
            } else {
                iService.get(pSGitUser);
            }
            this.onFillParentInfo_PSGitUser(pSDevCenterSVN, pSGitUser);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERSVN_PSSVNINSTREPO_PSSVNINSTREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService", (SessionFactory)this.getSessionFactory());
            PSSVNInstRepo pSSVNInstRepo = (PSSVNInstRepo)iService.getDEModel().createEntity();
            pSSVNInstRepo.set("PSSVNINSTREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSVNInstRepo);
            } else {
                iService.get(pSSVNInstRepo);
            }
            this.onFillParentInfo_PSSVNInstRepo(pSDevCenterSVN, pSSVNInstRepo);
            return;
        }
        super.onFillParentInfo(pSDevCenterSVN, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCredential(PSDevCenterSVN pSDevCenterSVN, PSCredential pSCredential) throws Exception {
        pSDevCenterSVN.setPSCredentialId(pSCredential.getPSCredentialId());
        pSDevCenterSVN.setPSCredentialName(pSCredential.getPSCredentialName());
    }

    protected void onFillParentInfo_ROPSCredential(PSDevCenterSVN pSDevCenterSVN, PSCredential pSCredential) throws Exception {
        pSDevCenterSVN.setROPSCredentialId(pSCredential.getPSCredentialId());
        pSDevCenterSVN.setROPSCredentialName(pSCredential.getPSCredentialName());
    }

    protected void onFillParentInfo_PSDCCluster(PSDevCenterSVN pSDevCenterSVN, PSDCCluster pSDCCluster) throws Exception {
        pSDevCenterSVN.setPSDCClusterId(pSDCCluster.getPSDCClusterId());
        pSDevCenterSVN.setPSDCClusterName(pSDCCluster.getPSDCClusterName());
    }

    protected void onFillParentInfo_PSDCContainerSpec(PSDevCenterSVN pSDevCenterSVN, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        pSDevCenterSVN.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
        pSDevCenterSVN.setPSDCContainerSpecName(pSDCContainerSpec.getPSDCContainerSpecName());
    }

    protected void onFillParentInfo_PSDCFile(PSDevCenterSVN pSDevCenterSVN, PSDCFile pSDCFile) throws Exception {
        pSDevCenterSVN.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDevCenterSVN.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDevCenterSVN pSDevCenterSVN, PSDevCenter pSDevCenter) throws Exception {
        pSDevCenterSVN.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevCenterSVN.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevCenterSVN pSDevCenterSVN, PSDevSln pSDevSln) throws Exception {
        pSDevCenterSVN.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevCenterSVN.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSGitUser(PSDevCenterSVN pSDevCenterSVN, PSGitUser pSGitUser) throws Exception {
        pSDevCenterSVN.setPSGitUserId(pSGitUser.getPSGitUserId());
        pSDevCenterSVN.setPSGitUserName(pSGitUser.getPSGitUserName());
    }

    protected void onFillParentInfo_PSSVNInstRepo(PSDevCenterSVN pSDevCenterSVN, PSSVNInstRepo pSSVNInstRepo) throws Exception {
        pSDevCenterSVN.setPSSVNInstRepoId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenterSVN.setPSSVNInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
        pSDevCenterSVN.setPSSVNServerId(pSSVNInstRepo.getPSSVNServerId());
    }

    protected void onFillEntityFullInfo(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSCredential(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_ROPSCredential(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSDCCluster(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSDCContainerSpec(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSGitUser(pSDevCenterSVN, bl);
        this.onFillEntityFullInfo_PSSVNInstRepo(pSDevCenterSVN, bl);
    }

    protected void onFillEntityFullInfo_PSCredential(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ROPSCredential(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCCluster(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCContainerSpec(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSGitUser(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
        if (pSDevCenterSVN.isPSGitUserIdDirty()) {
            if (pSDevCenterSVN.getPSGitUserId() != null) {
                if (pSDevCenterSVN.getPSGitUserId() == null || pSDevCenterSVN.getPSGitUserName() == null) {
                    PSGitUser pSGitUser = pSDevCenterSVN.getPSGitUser();
                    pSDevCenterSVN.setPSGitUserName(pSGitUser.getPSGitUserName());
                }
            } else {
                pSDevCenterSVN.setPSGitUserName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSVNInstRepo(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
        if (pSDevCenterSVN.isPSSVNInstRepoIdDirty()) {
            if (pSDevCenterSVN.getPSSVNInstRepoId() != null) {
                if (pSDevCenterSVN.getPSSVNInstRepoId() == null || pSDevCenterSVN.getPSSVNInstRepoName() == null) {
                    PSSVNInstRepo pSSVNInstRepo = pSDevCenterSVN.getPSSVNInstRepo();
                    pSDevCenterSVN.setPSSVNInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
                    pSDevCenterSVN.setPSSVNServerId(pSSVNInstRepo.getPSSVNServerId());
                }
            } else {
                pSDevCenterSVN.setPSSVNInstRepoName(null);
                pSDevCenterSVN.setPSSVNServerId(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevCenterSVN, bl);
    }

    public ArrayList<PSDevCenterSVN> selectByPSCredential(PSCredentialBase pSCredentialBase) throws Exception {
        return this.selectByPSCredential(pSCredentialBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSCredential(PSCredentialBase pSCredentialBase, String string) throws Exception {
        return this.selectByPSCredential(pSCredentialBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSCredential(PSCredentialBase pSCredentialBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterSVN> selectByROPSCredential(PSCredentialBase pSCredentialBase) throws Exception {
        return this.selectByROPSCredential(pSCredentialBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByROPSCredential(PSCredentialBase pSCredentialBase, String string) throws Exception {
        return this.selectByROPSCredential(pSCredentialBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByROPSCredential(PSCredentialBase pSCredentialBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterSVN> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string) throws Exception {
        return this.selectByPSDCCluster(pSDCClusterBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDCCluster(PSDCClusterBase pSDCClusterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterSVN> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterSVN> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterSVN> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterSVN> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterSVN> selectByPSGitUser(PSGitUserBase pSGitUserBase) throws Exception {
        return this.selectByPSGitUser(pSGitUserBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSGitUser(PSGitUserBase pSGitUserBase, String string) throws Exception {
        return this.selectByPSGitUser(pSGitUserBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSGitUser(PSGitUserBase pSGitUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSGITUSERID", (Object)pSGitUserBase.getPSGitUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSGitUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSGitUserCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenterSVN> selectByPSSVNInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase) throws Exception {
        return this.selectByPSSVNInstRepo(pSSVNInstRepoBase, "", -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSSVNInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string) throws Exception {
        return this.selectByPSSVNInstRepo(pSSVNInstRepoBase, string, -1);
    }

    public ArrayList<PSDevCenterSVN> selectByPSSVNInstRepo(PSSVNInstRepoBase pSSVNInstRepoBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVNINSTREPOID", (Object)pSSVNInstRepoBase.getPSSVNInstRepoId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSVNInstRepoCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSVNInstRepoCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSCredential(pSCredential, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCREDENTIAL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCredential);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSCREDENTIAL_PSCREDENTIALID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSCredential), arrayList.get(0)));
        }
    }

    public void resetPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSCredential(pSCredential);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSCredentialId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSCredential(PSCredential pSCredential) throws Exception {
        final PSCredential pSCredential2 = pSCredential;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSCredential(pSCredential2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSCredential(pSCredential2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSCredential(pSCredential2);
            }
        });
    }

    protected void onBeforeRemoveByPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void internalRemoveByPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSCredential(pSCredential);
        this.onBeforeRemoveByPSCredential(pSCredential, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSCredential(pSCredential, arrayList);
    }

    protected void onAfterRemoveByPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void onBeforeRemoveByPSCredential(PSCredential pSCredential, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCredential(PSCredential pSCredential, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByROPSCredential(pSCredential, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCREDENTIAL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCredential);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSCREDENTIAL_ROPSCREDENTIALID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSCredential), arrayList.get(0)));
        }
    }

    public void resetROPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByROPSCredential(pSCredential);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setROPSCredentialId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByROPSCredential(PSCredential pSCredential) throws Exception {
        final PSCredential pSCredential2 = pSCredential;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByROPSCredential(pSCredential2);
                PSDevCenterSVNServiceBase.this.internalRemoveByROPSCredential(pSCredential2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByROPSCredential(pSCredential2);
            }
        });
    }

    protected void onBeforeRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void internalRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByROPSCredential(pSCredential);
        this.onBeforeRemoveByROPSCredential(pSCredential, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByROPSCredential(pSCredential, arrayList);
    }

    protected void onAfterRemoveByROPSCredential(PSCredential pSCredential) throws Exception {
    }

    protected void onBeforeRemoveByROPSCredential(PSCredential pSCredential, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByROPSCredential(PSCredential pSCredential, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCCluster(pSDCCluster, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCLUSTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCCluster);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSDCCLUSTER_PSDCCLUSTERID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSDCCluster), arrayList.get(0)));
        }
    }

    public void resetPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCCluster(pSDCCluster);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSDCClusterId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        final PSDCCluster pSDCCluster2 = pSDCCluster;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSDCCluster(pSDCCluster2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSDCCluster(pSDCCluster2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSDCCluster(pSDCCluster2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void internalRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCCluster(pSDCCluster);
        this.onBeforeRemoveByPSDCCluster(pSDCCluster, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSDCCluster(pSDCCluster, arrayList);
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCluster(PSDCCluster pSDCCluster, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCONTAINERSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCContainerSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSDCContainerSpec), arrayList.get(0)));
        }
    }

    public void resetPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSDCContainerSpecId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        final PSDCContainerSpec pSDCContainerSpec2 = pSDCContainerSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void internalRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSDCFileId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSDevCenterId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSDevSlnId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByPSGitUser(PSGitUser pSGitUser) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSGitUser(pSGitUser, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSGITUSER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSGitUser);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSGITUSER_PSGITUSERID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSGitUser), arrayList.get(0)));
        }
    }

    public void resetPSGitUser(PSGitUser pSGitUser) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSGitUser(pSGitUser);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSGitUserId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSGitUser(PSGitUser pSGitUser) throws Exception {
        final PSGitUser pSGitUser2 = pSGitUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSGitUser(pSGitUser2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSGitUser(pSGitUser2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSGitUser(pSGitUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSGitUser(PSGitUser pSGitUser) throws Exception {
    }

    protected void internalRemoveByPSGitUser(PSGitUser pSGitUser) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSGitUser(pSGitUser);
        this.onBeforeRemoveByPSGitUser(pSGitUser, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSGitUser(pSGitUser, arrayList);
    }

    protected void onAfterRemoveByPSGitUser(PSGitUser pSGitUser) throws Exception {
    }

    protected void onBeforeRemoveByPSGitUser(PSGitUser pSGitUser, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSGitUser(PSGitUser pSGitUser, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    public void testRemoveByPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSSVNInstRepo(pSSVNInstRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVNINSTREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSVNInstRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERSVN_PSSVNINSTREPO_PSSVNINSTREPOID", "", iDataEntityModel.getName(), "PSDEVCENTERSVN", iDataEntityModel.getDataInfo(pSSVNInstRepo), arrayList.get(0)));
        }
    }

    public void resetPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSSVNInstRepo(pSSVNInstRepo);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            PSDevCenterSVN pSDevCenterSVN2 = (PSDevCenterSVN)this.getDEModel().createEntity();
            pSDevCenterSVN2.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevCenterSVN2.setPSSVNInstRepoId(null);
            this.update(pSDevCenterSVN2);
        }
    }

    public void removeByPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        final PSSVNInstRepo pSSVNInstRepo2 = pSSVNInstRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterSVNServiceBase.this.onBeforeRemoveByPSSVNInstRepo(pSSVNInstRepo2);
                PSDevCenterSVNServiceBase.this.internalRemoveByPSSVNInstRepo(pSSVNInstRepo2);
                PSDevCenterSVNServiceBase.this.onAfterRemoveByPSSVNInstRepo(pSSVNInstRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void internalRemoveByPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
        ArrayList<PSDevCenterSVN> arrayList = this.selectByPSSVNInstRepo(pSSVNInstRepo);
        this.onBeforeRemoveByPSSVNInstRepo(pSSVNInstRepo, arrayList);
        for (PSDevCenterSVN pSDevCenterSVN : arrayList) {
            this.remove(pSDevCenterSVN);
        }
        this.onAfterRemoveByPSSVNInstRepo(pSSVNInstRepo, arrayList);
    }

    protected void onAfterRemoveByPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSVNInstRepo(PSSVNInstRepo pSSVNInstRepo, ArrayList<PSDevCenterSVN> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDeployCenterServiceBase)pSCoreSysServiceBase).testRemoveByCfgPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDepSysService)ServiceGlobal.getService(PSDepSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDepSysService)ServiceGlobal.getService(PSDepSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysServiceBase)pSCoreSysServiceBase).testRemoveByROPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByModelPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByTemplPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDepInstServiceBase)pSCoreSysServiceBase).testRemoveByInstPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDepInstServiceBase)pSCoreSysServiceBase).testRemoveByModelPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByCfgPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByModelPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysResServiceBase)pSCoreSysServiceBase).testRemoveByROPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByDocPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByModelPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByROPSDevCenterSvn(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByRTModelPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        pSCoreSysServiceBase = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterSVN(pSDevCenterSVN);
        super.onBeforeRemove(pSDevCenterSVN);
    }

    protected void replaceParentInfo(PSDevCenterSVN pSDevCenterSVN, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevCenterSVN, cloneSession);
        if (pSDevCenterSVN.getPSCredentialId() != null && (iEntity = cloneSession.getEntity("PSCREDENTIAL", (Object)pSDevCenterSVN.getPSCredentialId())) != null) {
            this.onFillParentInfo_PSCredential(pSDevCenterSVN, (PSCredential)iEntity);
        }
        if (pSDevCenterSVN.getROPSCredentialId() != null && (iEntity = cloneSession.getEntity("PSCREDENTIAL", (Object)pSDevCenterSVN.getROPSCredentialId())) != null) {
            this.onFillParentInfo_ROPSCredential(pSDevCenterSVN, (PSCredential)iEntity);
        }
        if (pSDevCenterSVN.getPSDCClusterId() != null && (iEntity = cloneSession.getEntity("PSDCCLUSTER", (Object)pSDevCenterSVN.getPSDCClusterId())) != null) {
            this.onFillParentInfo_PSDCCluster(pSDevCenterSVN, (PSDCCluster)iEntity);
        }
        if (pSDevCenterSVN.getPSDCContainerSpecId() != null && (iEntity = cloneSession.getEntity("PSDCCONTAINERSPEC", (Object)pSDevCenterSVN.getPSDCContainerSpecId())) != null) {
            this.onFillParentInfo_PSDCContainerSpec(pSDevCenterSVN, (PSDCContainerSpec)iEntity);
        }
        if (pSDevCenterSVN.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDevCenterSVN.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDevCenterSVN, (PSDCFile)iEntity);
        }
        if (pSDevCenterSVN.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevCenterSVN.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevCenterSVN, (PSDevCenter)iEntity);
        }
        if (pSDevCenterSVN.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevCenterSVN.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevCenterSVN, (PSDevSln)iEntity);
        }
        if (pSDevCenterSVN.getPSGitUserId() != null && (iEntity = cloneSession.getEntity("PSGITUSER", (Object)pSDevCenterSVN.getPSGitUserId())) != null) {
            this.onFillParentInfo_PSGitUser(pSDevCenterSVN, (PSGitUser)iEntity);
        }
        if (pSDevCenterSVN.getPSSVNInstRepoId() != null && (iEntity = cloneSession.getEntity("PSSVNINSTREPO", (Object)pSDevCenterSVN.getPSSVNInstRepoId())) != null) {
            this.onFillParentInfo_PSSVNInstRepo(pSDevCenterSVN, (PSSVNInstRepo)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevCenterSVN, bl);
        pSDevCenterSVN.resetPSGitUserId();
        pSDevCenterSVN.resetPSGitUserName();
        pSDevCenterSVN.resetPSSVNInstRepoId();
        pSDevCenterSVN.resetPSSVNInstRepoName();
    }

    protected void onCheckEntity(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevCenterSVN, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitBranch(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitPath(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitPrj(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitRepo(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockMode(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockObjId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockObjType(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCredentialId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCClusterId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNName(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSGitUserId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSGitUserName(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSVNInstRepoId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSVNInstRepoName(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefFlag(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjName(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjType(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResVer(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPSCredentialId(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SVNType(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Usage(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevCenterSVN, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevCenterSVN, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isExpriedTimeDirty() : !pSDevCenterSVN.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenterSVN.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_GitBranch(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isGitBranchDirty() : !pSDevCenterSVN.isGitBranchDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getGitBranch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitBranch_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITBRANCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GitPath(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isGitPathDirty() : !pSDevCenterSVN.isGitPathDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getGitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitPath_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GitPrj(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isGitPrjDirty() : !pSDevCenterSVN.isGitPrjDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getGitPrj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitPrj_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITPRJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GitRepo(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isGitRepoDirty() : !pSDevCenterSVN.isGitRepoDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getGitRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitRepo_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITREPO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockMode(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isLockModeDirty() : !pSDevCenterSVN.isLockModeDirty()) {
            return null;
        }
        Integer n = pSDevCenterSVN.getLockMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockMode_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockObjId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isLockObjIdDirty() : !pSDevCenterSVN.isLockObjIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getLockObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LockObjId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockObjType(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isLockObjTypeDirty() : !pSDevCenterSVN.isLockObjTypeDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getLockObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LockObjType_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isMemoDirty() : !pSDevCenterSVN.isMemoDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isParamDirty() : !pSDevCenterSVN.isParamDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param2(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isParam2Dirty() : !pSDevCenterSVN.isParam2Dirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCredentialId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSCredentialIdDirty() : !pSDevCenterSVN.isPSCredentialIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSCredentialId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCredentialId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCClusterId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSDCClusterIdDirty() : !pSDevCenterSVN.isPSDCClusterIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSDCClusterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCClusterId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSDCContainerSpecIdDirty() : !pSDevCenterSVN.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSDCContainerSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSDCFileIdDirty() : !pSDevCenterSVN.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSDevCenterIdDirty() && !bl2 : !pSDevCenterSVN.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSDevCenterSVNIdDirty() && !bl2 : !pSDevCenterSVN.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSDevCenterSVNId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNName(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSDevCenterSVNNameDirty() && !bl2 : !pSDevCenterSVN.isPSDevCenterSVNNameDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSDevCenterSVNName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNName_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSDevSlnIdDirty() : !pSDevCenterSVN.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSGitUserId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSGitUserIdDirty() : !pSDevCenterSVN.isPSGitUserIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSGitUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSGitUserId_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSGITUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSGitUserName(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSGitUserNameDirty() : !pSDevCenterSVN.isPSGitUserNameDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSGitUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSGitUserName_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSGITUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSVNInstRepoId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSSVNInstRepoIdDirty() : !pSDevCenterSVN.isPSSVNInstRepoIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSSVNInstRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSVNInstRepoId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSVNInstRepoName(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isPSSVNInstRepoNameDirty() : !pSDevCenterSVN.isPSSVNInstRepoNameDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getPSSVNInstRepoName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSVNInstRepoName_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVNINSTREPONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefFlag(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isRefFlagDirty() && !bl2 : !pSDevCenterSVN.isRefFlagDirty()) {
            return null;
        }
        Integer n = pSDevCenterSVN.getRefFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RefFlag_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isRefObjIdDirty() : !pSDevCenterSVN.isRefObjIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getRefObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjId_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjName(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isRefObjNameDirty() : !pSDevCenterSVN.isRefObjNameDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getRefObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjName_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjType(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isRefObjTypeDirty() : !pSDevCenterSVN.isRefObjTypeDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getRefObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjType_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isResPosDirty() : !pSDevCenterSVN.isResPosDirty()) {
            return null;
        }
        Integer n = pSDevCenterSVN.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isResStateDirty() : !pSDevCenterSVN.isResStateDirty()) {
            return null;
        }
        Integer n = pSDevCenterSVN.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResVer(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isResVerDirty() : !pSDevCenterSVN.isResVerDirty()) {
            return null;
        }
        Integer n = pSDevCenterSVN.getResVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResVer_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_ROPSCredentialId(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isROPSCredentialIdDirty() : !pSDevCenterSVN.isROPSCredentialIdDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getROPSCredentialId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPSCredentialId_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_SVNType(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isSVNTypeDirty() : !pSDevCenterSVN.isSVNTypeDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getSVNType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SVNType_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SVNTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isTagsDirty() : !pSDevCenterSVN.isTagsDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Usage(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isUsageDirty() : !pSDevCenterSVN.isUsageDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Usage_Default(pSDevCenterSVN, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isUserTagDirty() : !pSDevCenterSVN.isUserTagDirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isUserTag2Dirty() : !pSDevCenterSVN.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isUserTag3Dirty() : !pSDevCenterSVN.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDevCenterSVN, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevCenterSVN pSDevCenterSVN, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterSVN.isUserTag4Dirty() : !pSDevCenterSVN.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevCenterSVN.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDevCenterSVN, bl2, bl3);
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

    protected void onSyncEntity(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
        super.onSyncEntity(pSDevCenterSVN, bl);
    }

    protected void onSyncIndexEntities(PSDevCenterSVN pSDevCenterSVN, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevCenterSVN, bl);
    }

    public Object getDataContextValue(PSDevCenterSVN pSDevCenterSVN, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevCenterSVN, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDevCenterSVN.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevCenterSVN pSDevCenterSVN, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevCenterSVN, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITBRANCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitBranch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPRJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitPrj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitRepo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSGITUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSGitUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSGITUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSGitUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVNINSTREPOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSVNInstRepoId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVNINSTREPONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSVNInstRepoName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVNSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSVNServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSCREDENTIALID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSCredentialId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSCREDENTIALNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSCredentialName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SVNTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SVNType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tags_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Usage_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GitBranch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITBRANCH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitPrj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPRJ", iEntity, bl2, null, false, 400, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitRepo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITREPO", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSGitUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSGITUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSGitUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSGITUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSVNInstRepoId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSVNInstRepoName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSVNServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVNSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_ResVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_SVNType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SVNTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_Usage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USAGE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevCenterSVN)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        super.onUpdateParent(pSDevCenterSVN);
    }

    @Override
    protected void exportCurXmlModel(PSDevCenterSVN pSDevCenterSVN, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVCENTERSVN");
        if (!bl) {
            pSDevCenterSVN.setPSDCClusterName(null);
            pSDevCenterSVN.setPSDCContainerSpecName(null);
            pSDevCenterSVN.setPSDCFileName(null);
            super.exportCurXmlModel(pSDevCenterSVN, xmlNode, bl);
        }
    }
}

