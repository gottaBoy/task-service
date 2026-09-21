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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippetBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFileBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFuncBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNodeBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItemBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepoBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineStepDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStepDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeployBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrvBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineStepServiceBase
extends PSCoreSysServiceBase<PSDevSlnPipelineStep> {
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineStepServiceBase.class);
    public static final String DATASET_CURPIPELINE = "CurPipeline";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDevSlnPipelineStepDEModel pSDevSlnPipelineStepDEModel;
    private PSDevSlnPipelineStepDAO pSDevSlnPipelineStepDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService";
    }

    public PSDevSlnPipelineStepDEModel getPSDevSlnPipelineStepDEModel() {
        if (this.pSDevSlnPipelineStepDEModel == null) {
            try {
                this.pSDevSlnPipelineStepDEModel = (PSDevSlnPipelineStepDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineStepDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineStepDEModel();
    }

    public PSDevSlnPipelineStepDAO getPSDevSlnPipelineStepDAO() {
        if (this.pSDevSlnPipelineStepDAO == null) {
            try {
                this.pSDevSlnPipelineStepDAO = (PSDevSlnPipelineStepDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineStepDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineStepDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnPipelineStepDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPIPELINE, (boolean)true) == 0) {
            return this.fetchCurPipeline(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPIPELINE, (boolean)true) == 0) {
            return this.fetchTempCurPipeline(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurPipeline(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPIPELINE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPipeline(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPIPELINE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnPipelineStep pSDevSlnPipelineStep, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCBDINST_PSDCBDINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService", (SessionFactory)this.getSessionFactory());
            PSDCBDInst pSDCBDInst = (PSDCBDInst)iService.getDEModel().createEntity();
            pSDCBDInst.set("PSDCBDINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCBDInst);
            } else {
                iService.get((IEntity)pSDCBDInst);
            }
            this.onFillParentInfo_PSDCBDInst(pSDevSlnPipelineStep, pSDCBDInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCCODESNIPPET_PSDCCODESNIPPETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService", (SessionFactory)this.getSessionFactory());
            PSDCCodeSnippet pSDCCodeSnippet = (PSDCCodeSnippet)iService.getDEModel().createEntity();
            pSDCCodeSnippet.set("PSDCCODESNIPPETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCCodeSnippet);
            } else {
                iService.get((IEntity)pSDCCodeSnippet);
            }
            this.onFillParentInfo_PSDCCodeSnippet(pSDevSlnPipelineStep, pSDCCodeSnippet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCFILE_PSDCFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCFileService", (SessionFactory)this.getSessionFactory());
            PSDCFile pSDCFile = (PSDCFile)iService.getDEModel().createEntity();
            pSDCFile.set("PSDCFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCFile);
            } else {
                iService.get((IEntity)pSDCFile);
            }
            this.onFillParentInfo_PSDCFile(pSDevSlnPipelineStep, pSDCFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCMSPLATFORMFUNC_PSDCMSPLATFORMFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformFunc pSDCMSPlatformFunc = (PSDCMSPlatformFunc)iService.getDEModel().createEntity();
            pSDCMSPlatformFunc.set("PSDCMSPLATFORMFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCMSPlatformFunc);
            } else {
                iService.get((IEntity)pSDCMSPlatformFunc);
            }
            this.onFillParentInfo_PSDCMSPlatformFunc(pSDevSlnPipelineStep, pSDCMSPlatformFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = (PSDCMSPlatformNode)iService.getDEModel().createEntity();
            pSDCMSPlatformNode.set("PSDCMSPLATFORMNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCMSPlatformNode);
            } else {
                iService.get((IEntity)pSDCMSPlatformNode);
            }
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnPipelineStep, pSDCMSPlatformNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCMSPLATFORM_PSDCMSPLATFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatform pSDCMSPlatform = (PSDCMSPlatform)iService.getDEModel().createEntity();
            pSDCMSPlatform.set("PSDCMSPLATFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCMSPlatform);
            } else {
                iService.get((IEntity)pSDCMSPlatform);
            }
            this.onFillParentInfo_PSDCMSPlatform(pSDevSlnPipelineStep, pSDCMSPlatform);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYITEM_AGENTPSDCREGISTRYITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryItem pSDCRegistryItem = (PSDCRegistryItem)iService.getDEModel().createEntity();
            pSDCRegistryItem.set("PSDCREGISTRYITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRegistryItem);
            } else {
                iService.get((IEntity)pSDCRegistryItem);
            }
            this.onFillParentInfo_AgentPSDCRegistryItem(pSDevSlnPipelineStep, pSDCRegistryItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYITEM_PSDCREGISTRYITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryItem pSDCRegistryItem = (PSDCRegistryItem)iService.getDEModel().createEntity();
            pSDCRegistryItem.set("PSDCREGISTRYITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRegistryItem);
            } else {
                iService.get((IEntity)pSDCRegistryItem);
            }
            this.onFillParentInfo_PSDCRegistryItem(pSDevSlnPipelineStep, pSDCRegistryItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYITEM_TOOLPSDCREGISTRYITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryItem pSDCRegistryItem = (PSDCRegistryItem)iService.getDEModel().createEntity();
            pSDCRegistryItem.set("PSDCREGISTRYITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRegistryItem);
            } else {
                iService.get((IEntity)pSDCRegistryItem);
            }
            this.onFillParentInfo_ToolPSDCRegistryItem(pSDevSlnPipelineStep, pSDCRegistryItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryRepo pSDCRegistryRepo = (PSDCRegistryRepo)iService.getDEModel().createEntity();
            pSDCRegistryRepo.set("PSDCREGISTRYREPOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRegistryRepo);
            } else {
                iService.get((IEntity)pSDCRegistryRepo);
            }
            this.onFillParentInfo_PSDCRegistryRepo(pSDevSlnPipelineStep, pSDCRegistryRepo);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterDBInst);
            } else {
                iService.get((IEntity)pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnPipelineStep, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnPipelineStep, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnPipelineStep, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERSVN_TEMPLPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_TemplPSDevCenterSVN(pSDevSlnPipelineStep, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPAPI_PSDEVSLNMSDEPAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI = (PSDevSlnMSDepAPI)iService.getDEModel().createEntity();
            pSDevSlnMSDepAPI.set("PSDEVSLNMSDEPAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnMSDepAPI);
            } else {
                iService.get((IEntity)pSDevSlnMSDepAPI);
            }
            this.onFillParentInfo_PSDevSlnMSDepAPI(pSDevSlnPipelineStep, pSDevSlnMSDepAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPAPP_PSDEVSLNMSDEPAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDepApp pSDevSlnMSDepApp = (PSDevSlnMSDepApp)iService.getDEModel().createEntity();
            pSDevSlnMSDepApp.set("PSDEVSLNMSDEPAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnMSDepApp);
            } else {
                iService.get((IEntity)pSDevSlnMSDepApp);
            }
            this.onFillParentInfo_PSDevSlnMSDepApp(pSDevSlnPipelineStep, pSDevSlnMSDepApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc = (PSDevSlnMSDepFunc)iService.getDEModel().createEntity();
            pSDevSlnMSDepFunc.set("PSDEVSLNMSDEPFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnMSDepFunc);
            } else {
                iService.get((IEntity)pSDevSlnMSDepFunc);
            }
            this.onFillParentInfo_PSDevSlnMSDepFunc(pSDevSlnPipelineStep, pSDevSlnMSDepFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDeploy pSDevSlnMSDeploy = (PSDevSlnMSDeploy)iService.getDEModel().createEntity();
            pSDevSlnMSDeploy.set("PSDEVSLNMSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnMSDeploy);
            } else {
                iService.get((IEntity)pSDevSlnMSDeploy);
            }
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnPipelineStep, pSDevSlnMSDeploy);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNPIPELINESTAGE_PSDEVSLNPIPELINESTAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipelineStage pSDevSlnPipelineStage = (PSDevSlnPipelineStage)iService.getDEModel().createEntity();
            pSDevSlnPipelineStage.set("PSDEVSLNPIPELINESTAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipelineStage);
            } else {
                iService.get((IEntity)pSDevSlnPipelineStage);
            }
            this.onFillParentInfo_PSDevSlnPipelineStage(pSDevSlnPipelineStep, pSDevSlnPipelineStage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipeline);
            } else {
                iService.get((IEntity)pSDevSlnPipeline);
            }
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineStep, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNPIPELINE_REFPSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipeline);
            } else {
                iService.get((IEntity)pSDevSlnPipeline);
            }
            this.onFillParentInfo_RefPSDevSlnPipeline(pSDevSlnPipelineStep, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSAPI_PSDEVSLNSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = (PSDevSlnSysAPI)iService.getDEModel().createEntity();
            pSDevSlnSysAPI.set("PSDEVSLNSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysAPI);
            } else {
                iService.get((IEntity)pSDevSlnSysAPI);
            }
            this.onFillParentInfo_PSDevSlnSysAPI(pSDevSlnPipelineStep, pSDevSlnSysAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = (PSDevSlnSysApp)iService.getDEModel().createEntity();
            pSDevSlnSysApp.set("PSDEVSLNSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysApp);
            } else {
                iService.get((IEntity)pSDevSlnSysApp);
            }
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnPipelineStep, pSDevSlnSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysSrv pSDevSlnSysSrv = (PSDevSlnSysSrv)iService.getDEModel().createEntity();
            pSDevSlnSysSrv.set("PSDEVSLNSYSSRVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysSrv);
            } else {
                iService.get((IEntity)pSDevSlnSysSrv);
            }
            this.onFillParentInfo_PSDevSlnSysSrv(pSDevSlnPipelineStep, pSDevSlnSysSrv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysVer pSDevSlnSysVer = (PSDevSlnSysVer)iService.getDEModel().createEntity();
            pSDevSlnSysVer.set("PSDEVSLNSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysVer);
            } else {
                iService.get((IEntity)pSDevSlnSysVer);
            }
            this.onFillParentInfo_PSDevSlnSysVer(pSDevSlnPipelineStep, pSDevSlnSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnPipelineStep, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnTempl);
            } else {
                iService.get((IEntity)pSDevSlnTempl);
            }
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnPipelineStep, pSDevSlnTempl);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnPipelineStep, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCBDInst(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCBDInst pSDCBDInst) throws Exception {
        pSDevSlnPipelineStep.setPSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
        pSDevSlnPipelineStep.setPSDCBDInstName(pSDCBDInst.getPSDCBDInstName());
    }

    protected void onFillParentInfo_PSDCCodeSnippet(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        pSDevSlnPipelineStep.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
        pSDevSlnPipelineStep.setPSDCCodeSnippetName(pSDCCodeSnippet.getPSDCCodeSnippetName());
    }

    protected void onFillParentInfo_PSDCFile(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCFile pSDCFile) throws Exception {
        pSDevSlnPipelineStep.setPSDCFileId(pSDCFile.getPSDCFileId());
        pSDevSlnPipelineStep.setPSDCFileName(pSDCFile.getPSDCFileName());
    }

    protected void onFillParentInfo_PSDCMSPlatformFunc(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        pSDevSlnPipelineStep.setPSDCMSPlatformFuncId(pSDCMSPlatformFunc.getPSDCMSPlatformFuncId());
        pSDevSlnPipelineStep.setPSDCMSPlatformFuncName(pSDCMSPlatformFunc.getPSDCMSPlatformFuncName());
    }

    protected void onFillParentInfo_PSDCMSPlatformNode(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        pSDevSlnPipelineStep.setPSDCMSPlatformNodeId(pSDCMSPlatformNode.getPSDCMSPlatformNodeId());
        pSDevSlnPipelineStep.setPSDCMSPlatformNodeName(pSDCMSPlatformNode.getPSDCMSPlatformNodeName());
    }

    protected void onFillParentInfo_PSDCMSPlatform(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCMSPlatform pSDCMSPlatform) throws Exception {
        pSDevSlnPipelineStep.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
        pSDevSlnPipelineStep.setPSDCMSPlatformName(pSDCMSPlatform.getPSDCMSPlatformName());
    }

    protected void onFillParentInfo_AgentPSDCRegistryItem(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCRegistryItem pSDCRegistryItem) throws Exception {
        pSDevSlnPipelineStep.setAgentPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
        pSDevSlnPipelineStep.setAgentPSDCRegistryItemName(pSDCRegistryItem.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_PSDCRegistryItem(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCRegistryItem pSDCRegistryItem) throws Exception {
        pSDevSlnPipelineStep.setPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
        pSDevSlnPipelineStep.setPSDCRegistryItemName(pSDCRegistryItem.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_ToolPSDCRegistryItem(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCRegistryItem pSDCRegistryItem) throws Exception {
        pSDevSlnPipelineStep.setToolPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
        pSDevSlnPipelineStep.setToolPSDCRegistryItemName(pSDCRegistryItem.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_PSDCRegistryRepo(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        pSDevSlnPipelineStep.setPSDCRegistryRepoId(pSDCRegistryRepo.getPSDCRegistryRepoId());
        pSDevSlnPipelineStep.setPSDCRegistryRepoName(pSDCRegistryRepo.getPSDCRegistryRepoName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnPipelineStep.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnPipelineStep.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_ModelPSDevCenterSVN(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnPipelineStep.setModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnPipelineStep.setModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnPipelineStep.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnPipelineStep.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_TemplPSDevCenterSVN(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnPipelineStep.setTemplPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnPipelineStep.setTemplPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevSlnMSDepAPI(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
        pSDevSlnPipelineStep.setPSDevSlnMSDepAPIName(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIName());
    }

    protected void onFillParentInfo_PSDevSlnMSDepApp(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
        pSDevSlnPipelineStep.setPSDevSlnMSDepAppName(pSDevSlnMSDepApp.getPSDevSlnMSDepAppName());
    }

    protected void onFillParentInfo_PSDevSlnMSDepFunc(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
        pSDevSlnPipelineStep.setPSDevSlnMSDepFuncName(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncName());
    }

    protected void onFillParentInfo_PSDevSlnMSDeploy(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnMSDeployId(pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        pSDevSlnPipelineStep.setPSDevSlnMSDeployName(pSDevSlnMSDeploy.getPSDevSlnMSDeployName());
    }

    protected void onFillParentInfo_PSDevSlnPipelineStage(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnPipelineStageId(pSDevSlnPipelineStage.getPSDevSlnPipelineStageId());
        pSDevSlnPipelineStep.setPSDevSlnPipelineStageName(pSDevSlnPipelineStage.getPSDevSlnPipelineStageName());
        if (pSDevSlnPipelineStage.getPSDevSlnPipeline() != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineStep, pSDevSlnPipelineStage.getPSDevSlnPipeline());
        }
    }

    protected void onFillParentInfo_PSDevSlnPipeline(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnId(pSDevSlnPipeline.getPSDevSlnId());
        pSDevSlnPipelineStep.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnPipelineStep.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_RefPSDevSlnPipeline(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnPipelineStep.setRefPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnPipelineStep.setRefPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_PSDevSlnSysAPI(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        pSDevSlnPipelineStep.setPSDevSlnSysAPIName(pSDevSlnSysAPI.getPSDevSlnSysAPIName());
    }

    protected void onFillParentInfo_PSDevSlnSysApp(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
        pSDevSlnPipelineStep.setPSDevSlnSysAppName(pSDevSlnSysApp.getPSDevSlnSysAppName());
    }

    protected void onFillParentInfo_PSDevSlnSysSrv(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
        pSDevSlnPipelineStep.setPSDevSlnSysSrvName(pSDevSlnSysSrv.getPSDevSlnSysSrvName());
    }

    protected void onFillParentInfo_PSDevSlnSysVer(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
        pSDevSlnPipelineStep.setPSDevSlnSysVerName(pSDevSlnSysVer.getPSDevSlnSysVerName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnPipelineStep.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSlnTempl(PSDevSlnPipelineStep pSDevSlnPipelineStep, PSDevSlnTempl pSDevSlnTempl) throws Exception {
        pSDevSlnPipelineStep.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
        pSDevSlnPipelineStep.setPSDevSlnTemplName(pSDevSlnTempl.getPSDevSlnTemplName());
    }

    protected void onFillEntityFullInfo(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnPipelineStep.getCodeName() == null) {
                pSDevSlnPipelineStep.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Step", 25));
            }
            if (pSDevSlnPipelineStep.getCondModelFlag() == null) {
                pSDevSlnPipelineStep.setCondModelFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnPipelineStep.getValidFlag() == null) {
                pSDevSlnPipelineStep.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCBDInst(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCCodeSnippet(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCFile(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCMSPlatformFunc(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCMSPlatformNode(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCMSPlatform(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_AgentPSDCRegistryItem(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCRegistryItem(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_ToolPSDCRegistryItem(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDCRegistryRepo(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_ModelPSDevCenterSVN(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_TemplPSDevCenterSVN(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDepAPI(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDepApp(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDepFunc(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDeploy(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnPipelineStage(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnPipeline(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_RefPSDevSlnPipeline(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnSysAPI(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnSysApp(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnSysSrv(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnSysVer(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnPipelineStep, bl);
        this.onFillEntityFullInfo_PSDevSlnTempl(pSDevSlnPipelineStep, bl);
    }

    protected void onFillEntityFullInfo_PSDCBDInst(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCCodeSnippet(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCFile(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCMSPlatformFunc(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCMSPlatformNode(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCMSPlatform(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AgentPSDCRegistryItem(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCRegistryItem(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ToolPSDCRegistryItem(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCRegistryRepo(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ModelPSDevCenterSVN(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TemplPSDevCenterSVN(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDepAPI(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDepApp(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDepFunc(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDeploy(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnPipelineStage(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnPipeline(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDevSlnPipeline(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysAPI(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysApp(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysSrv(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysVer(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnTempl(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnPipelineStep, bl);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase) throws Exception {
        return this.selectByPSDCBDInst(pSDCBDInstBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string) throws Exception {
        return this.selectByPSDCBDInst(pSDCBDInstBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCBDINSTID", (Object)pSDCBDInstBase.getPSDCBDInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCBDInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCBDInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCODESNIPPETID", (Object)pSDCCodeSnippetBase.getPSDCCodeSnippetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCCodeSnippetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCCodeSnippetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCFile(PSDCFileBase pSDCFileBase) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string) throws Exception {
        return this.selectByPSDCFile(pSDCFileBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCFile(PSDCFileBase pSDCFileBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatformFunc(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase) throws Exception {
        return this.selectByPSDCMSPlatformFunc(pSDCMSPlatformFuncBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatformFunc(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, String string) throws Exception {
        return this.selectByPSDCMSPlatformFunc(pSDCMSPlatformFuncBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatformFunc(PSDCMSPlatformFuncBase pSDCMSPlatformFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMSPLATFORMFUNCID", (Object)pSDCMSPlatformFuncBase.getPSDCMSPlatformFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMSPlatformFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMSPlatformFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMSPLATFORMNODEID", (Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMSPlatformNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMSPlatformNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMSPLATFORMID", (Object)pSDCMSPlatformBase.getPSDCMSPlatformId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMSPlatformCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMSPlatformCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByAgentPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase) throws Exception {
        return this.selectByAgentPSDCRegistryItem(pSDCRegistryItemBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByAgentPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string) throws Exception {
        return this.selectByAgentPSDCRegistryItem(pSDCRegistryItemBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByAgentPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AGENTPSDCREGISTRYITEMID", (Object)pSDCRegistryItemBase.getPSDCRegistryItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAgentPSDCRegistryItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAgentPSDCRegistryItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase) throws Exception {
        return this.selectByPSDCRegistryItem(pSDCRegistryItemBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string) throws Exception {
        return this.selectByPSDCRegistryItem(pSDCRegistryItemBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineStep> selectByToolPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase) throws Exception {
        return this.selectByToolPSDCRegistryItem(pSDCRegistryItemBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByToolPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string) throws Exception {
        return this.selectByToolPSDCRegistryItem(pSDCRegistryItemBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByToolPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TOOLPSDCREGISTRYITEMID", (Object)pSDCRegistryItemBase.getPSDCRegistryItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByToolPSDCRegistryItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByToolPSDCRegistryItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string) throws Exception {
        return this.selectByPSDCRegistryRepo(pSDCRegistryRepoBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDCRegistryRepo(PSDCRegistryRepoBase pSDCRegistryRepoBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineStep> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MODELPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByModelPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByModelPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineStep> selectByTemplPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByTemplPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByTemplPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByTemplPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByTemplPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEMPLPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTemplPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTemplPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepAPI(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase) throws Exception {
        return this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPIBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepAPI(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPIBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepAPI(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPAPIID", (Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDepAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDepAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepApp(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase) throws Exception {
        return this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepAppBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepApp(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepAppBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepApp(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPAPPID", (Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDepAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDepAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase) throws Exception {
        return this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFuncBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFuncBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPFUNCID", (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDepFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDepFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPLOYID", (Object)pSDevSlnMSDeployBase.getPSDevSlnMSDeployId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDeployCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDeployCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase) throws Exception {
        return this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStageBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, String string) throws Exception {
        return this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStageBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINESTAGEID", (Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnPipelineStageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnPipelineStageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectTempByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase) throws Exception {
        return this.selectTempByPSDevSlnPipelineStage(pSDevSlnPipelineStageBase, "");
    }

    public ArrayList<PSDevSlnPipelineStep> selectTempByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINESTAGEID", (Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDevSlnPipelineStageCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDevSlnPipelineStageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINEID", (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnPipelineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnPipelineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectTempByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectTempByPSDevSlnPipeline(pSDevSlnPipelineBase, "");
    }

    public ArrayList<PSDevSlnPipelineStep> selectTempByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINEID", (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDevSlnPipelineCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDevSlnPipelineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByRefPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByRefPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByRefPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByRefPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByRefPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNPIPELINEID", (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnPipelineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnPipelineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPIID", (Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPPID", (Object)pSDevSlnSysAppBase.getPSDevSlnSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase) throws Exception {
        return this.selectByPSDevSlnSysSrv(pSDevSlnSysSrvBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string) throws Exception {
        return this.selectByPSDevSlnSysSrv(pSDevSlnSysSrvBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSSRVID", (Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysSrvCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysSrvCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSVERID", (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStep> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCBDInst(pSDCBDInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCBDINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCBDInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCBDINST_PSDCBDINSTID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCBDInst), arrayList.get(0)));
        }
    }

    public void resetPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCBDInst(pSDCBDInst);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCBDInstId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        final PSDCBDInst pSDCBDInst2 = pSDCBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCBDInst(pSDCBDInst2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCBDInst(pSDCBDInst2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCBDInst(pSDCBDInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void internalRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCBDInst(pSDCBDInst);
        this.onBeforeRemoveByPSDCBDInst(pSDCBDInst, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCBDInst(pSDCBDInst, arrayList);
    }

    protected void onAfterRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCODESNIPPET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCCodeSnippet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCCODESNIPPET_PSDCCODESNIPPETID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCCodeSnippet), arrayList.get(0)));
        }
    }

    public void resetPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCCodeSnippetId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void internalRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCFile(pSDCFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCFILE_PSDCFILEID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCFile), arrayList.get(0)));
        }
    }

    public void resetPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCFile(pSDCFile);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCFileId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCFile(PSDCFile pSDCFile) throws Exception {
        final PSDCFile pSDCFile2 = pSDCFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCFile(pSDCFile2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCFile(pSDCFile2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCFile(pSDCFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void internalRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCFile(pSDCFile);
        this.onBeforeRemoveByPSDCFile(pSDCFile, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCFile(pSDCFile, arrayList);
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile) throws Exception {
    }

    protected void onBeforeRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCFile(PSDCFile pSDCFile, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatformFunc(pSDCMSPlatformFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORMFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCMSPlatformFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCMSPLATFORMFUNC_PSDCMSPLATFORMFUNCID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCMSPlatformFunc), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatformFunc(pSDCMSPlatformFunc);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCMSPlatformFuncId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        final PSDCMSPlatformFunc pSDCMSPlatformFunc2 = pSDCMSPlatformFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCMSPlatformFunc(pSDCMSPlatformFunc2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCMSPlatformFunc(pSDCMSPlatformFunc2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCMSPlatformFunc(pSDCMSPlatformFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatformFunc(pSDCMSPlatformFunc);
        this.onBeforeRemoveByPSDCMSPlatformFunc(pSDCMSPlatformFunc, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCMSPlatformFunc(pSDCMSPlatformFunc, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORMNODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCMSPlatformNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCMSPlatformNode), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCMSPlatformNodeId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        final PSDCMSPlatformNode pSDCMSPlatformNode2 = pSDCMSPlatformNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCMSPlatform);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCMSPLATFORM_PSDCMSPLATFORMID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCMSPlatform), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCMSPlatformId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        final PSDCMSPlatform pSDCMSPlatform2 = pSDCMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByAgentPSDCRegistryItem(pSDCRegistryItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCRegistryItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYITEM_AGENTPSDCREGISTRYITEMID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCRegistryItem), arrayList.get(0)));
        }
    }

    public void resetAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByAgentPSDCRegistryItem(pSDCRegistryItem);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setAgentPSDCRegistryItemId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        final PSDCRegistryItem pSDCRegistryItem2 = pSDCRegistryItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByAgentPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByAgentPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByAgentPSDCRegistryItem(pSDCRegistryItem2);
            }
        });
    }

    protected void onBeforeRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void internalRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByAgentPSDCRegistryItem(pSDCRegistryItem);
        this.onBeforeRemoveByAgentPSDCRegistryItem(pSDCRegistryItem, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByAgentPSDCRegistryItem(pSDCRegistryItem, arrayList);
    }

    protected void onAfterRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void onBeforeRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCRegistryItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYITEM_PSDCREGISTRYITEMID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCRegistryItem), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCRegistryItemId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        final PSDCRegistryItem pSDCRegistryItem2 = pSDCRegistryItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCRegistryItem(pSDCRegistryItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCRegistryItem(pSDCRegistryItem);
        this.onBeforeRemoveByPSDCRegistryItem(pSDCRegistryItem, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCRegistryItem(pSDCRegistryItem, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByToolPSDCRegistryItem(pSDCRegistryItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCRegistryItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYITEM_TOOLPSDCREGISTRYITEMID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCRegistryItem), arrayList.get(0)));
        }
    }

    public void resetToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByToolPSDCRegistryItem(pSDCRegistryItem);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setToolPSDCRegistryItemId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        final PSDCRegistryItem pSDCRegistryItem2 = pSDCRegistryItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByToolPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByToolPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByToolPSDCRegistryItem(pSDCRegistryItem2);
            }
        });
    }

    protected void onBeforeRemoveByToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void internalRemoveByToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByToolPSDCRegistryItem(pSDCRegistryItem);
        this.onBeforeRemoveByToolPSDCRegistryItem(pSDCRegistryItem, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByToolPSDCRegistryItem(pSDCRegistryItem, arrayList);
    }

    protected void onAfterRemoveByToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void onBeforeRemoveByToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByToolPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYREPO");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCRegistryRepo);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDCREGISTRYREPO_PSDCREGISTRYREPOID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDCRegistryRepo), arrayList.get(0)));
        }
    }

    public void resetPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDCRegistryRepoId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        final PSDCRegistryRepo pSDCRegistryRepo2 = pSDCRegistryRepo;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void internalRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDCRegistryRepo(pSDCRegistryRepo);
        this.onBeforeRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDCRegistryRepo(pSDCRegistryRepo, arrayList);
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRegistryRepo(PSDCRegistryRepo pSDCRegistryRepo, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevCenterDBInstId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setModelPSDevCenterSVNId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevCenterSVNId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByTemplPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVCENTERSVN_TEMPLPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByTemplPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setTemplPSDevCenterSVNId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByTemplPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByTemplPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByTemplPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByTemplPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByTemplPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByTemplPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTemplPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnMSDepAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPAPI_PSDEVSLNMSDEPAPIID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnMSDepAPI), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnMSDepAPIId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        final PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = pSDevSlnMSDepAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI);
        this.onBeforeRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnMSDepApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPAPP_PSDEVSLNMSDEPAPPID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnMSDepApp), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepApp);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnMSDepAppId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        final PSDevSlnMSDepApp pSDevSlnMSDepApp2 = pSDevSlnMSDepApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepApp);
        this.onBeforeRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnMSDepFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPFUNCID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnMSDepFunc), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnMSDepFuncId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        final PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = pSDevSlnMSDepFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        this.onBeforeRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPLOY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnMSDeploy);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnMSDeploy), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnMSDeployId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        final PSDevSlnMSDeploy pSDevSlnMSDeploy2 = pSDevSlnMSDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    public void resetPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStageId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void resetTempPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStageId(null);
            this.updateTemp((IEntity)pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        final PSDevSlnPipelineStage pSDevSlnPipelineStage2 = pSDevSlnPipelineStage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        this.onBeforeRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    public void resetPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnPipelineId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void resetTempPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnPipelineId(null);
            this.updateTemp((IEntity)pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByRefPSDevSlnPipeline(pSDevSlnPipeline, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNPIPELINE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnPipeline);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNPIPELINE_REFPSDEVSLNPIPELINEID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnPipeline), arrayList.get(0)));
        }
    }

    public void resetRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByRefPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setRefPSDevSlnPipelineId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByRefPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSAPI_PSDEVSLNSYSAPIID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysAPI), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnSysAPIId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        final PSDevSlnSysAPI pSDevSlnSysAPI2 = pSDevSlnSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysApp), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnSysAppId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        final PSDevSlnSysApp pSDevSlnSysApp2 = pSDevSlnSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSSRV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysSrv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysSrv), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnSysSrvId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        final PSDevSlnSysSrv pSDevSlnSysSrv2 = pSDevSlnSysSrv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv);
        this.onBeforeRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnSysVerId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnSysId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTEP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnTempl), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            PSDevSlnPipelineStep pSDevSlnPipelineStep2 = (PSDevSlnPipelineStep)this.getDEModel().createEntity();
            pSDevSlnPipelineStep2.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
            pSDevSlnPipelineStep2.setPSDevSlnTemplId(null);
            this.update(pSDevSlnPipelineStep2);
        }
    }

    public void removeByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        super.onBeforeRemove(pSDevSlnPipelineStep);
    }

    public void removeTempByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        final PSDevSlnPipelineStage pSDevSlnPipelineStage2 = pSDevSlnPipelineStage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    protected void internalRemoveTempByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        this.onBeforeRemoveTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.removeTemp((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage, arrayList);
    }

    protected void onAfterRemoveTempByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    public void removeTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStepServiceBase.this.onBeforeRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStepServiceBase.this.internalRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStepServiceBase.this.onAfterRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            this.removeTemp((IEntity)pSDevSlnPipelineStep);
        }
        this.onAfterRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDevSlnPipelineStep pSDevSlnPipelineStep, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnPipelineStep, cloneSession);
        if (pSDevSlnPipelineStep.getPSDCBDInstId() != null && (iEntity = cloneSession.getEntity("PSDCBDINST", (Object)pSDevSlnPipelineStep.getPSDCBDInstId())) != null) {
            this.onFillParentInfo_PSDCBDInst(pSDevSlnPipelineStep, (PSDCBDInst)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDCCodeSnippetId() != null && (iEntity = cloneSession.getEntity("PSDCCODESNIPPET", (Object)pSDevSlnPipelineStep.getPSDCCodeSnippetId())) != null) {
            this.onFillParentInfo_PSDCCodeSnippet(pSDevSlnPipelineStep, (PSDCCodeSnippet)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDCFileId() != null && (iEntity = cloneSession.getEntity("PSDCFILE", (Object)pSDevSlnPipelineStep.getPSDCFileId())) != null) {
            this.onFillParentInfo_PSDCFile(pSDevSlnPipelineStep, (PSDCFile)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDCMSPlatformFuncId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORMFUNC", (Object)pSDevSlnPipelineStep.getPSDCMSPlatformFuncId())) != null) {
            this.onFillParentInfo_PSDCMSPlatformFunc(pSDevSlnPipelineStep, (PSDCMSPlatformFunc)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDCMSPlatformNodeId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORMNODE", (Object)pSDevSlnPipelineStep.getPSDCMSPlatformNodeId())) != null) {
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnPipelineStep, (PSDCMSPlatformNode)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDCMSPlatformId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORM", (Object)pSDevSlnPipelineStep.getPSDCMSPlatformId())) != null) {
            this.onFillParentInfo_PSDCMSPlatform(pSDevSlnPipelineStep, (PSDCMSPlatform)iEntity);
        }
        if (pSDevSlnPipelineStep.getAgentPSDCRegistryItemId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYITEM", (Object)pSDevSlnPipelineStep.getAgentPSDCRegistryItemId())) != null) {
            this.onFillParentInfo_AgentPSDCRegistryItem(pSDevSlnPipelineStep, (PSDCRegistryItem)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDCRegistryItemId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYITEM", (Object)pSDevSlnPipelineStep.getPSDCRegistryItemId())) != null) {
            this.onFillParentInfo_PSDCRegistryItem(pSDevSlnPipelineStep, (PSDCRegistryItem)iEntity);
        }
        if (pSDevSlnPipelineStep.getToolPSDCRegistryItemId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYITEM", (Object)pSDevSlnPipelineStep.getToolPSDCRegistryItemId())) != null) {
            this.onFillParentInfo_ToolPSDCRegistryItem(pSDevSlnPipelineStep, (PSDCRegistryItem)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDCRegistryRepoId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYREPO", (Object)pSDevSlnPipelineStep.getPSDCRegistryRepoId())) != null) {
            this.onFillParentInfo_PSDCRegistryRepo(pSDevSlnPipelineStep, (PSDCRegistryRepo)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnPipelineStep.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnPipelineStep, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnPipelineStep.getModelPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnPipelineStep.getModelPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnPipelineStep, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnPipelineStep.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnPipelineStep, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnPipelineStep.getTemplPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnPipelineStep.getTemplPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_TemplPSDevCenterSVN(pSDevSlnPipelineStep, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnMSDepAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPAPI", (Object)pSDevSlnPipelineStep.getPSDevSlnMSDepAPIId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDepAPI(pSDevSlnPipelineStep, (PSDevSlnMSDepAPI)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnMSDepAppId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPAPP", (Object)pSDevSlnPipelineStep.getPSDevSlnMSDepAppId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDepApp(pSDevSlnPipelineStep, (PSDevSlnMSDepApp)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnMSDepFuncId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPFUNC", (Object)pSDevSlnPipelineStep.getPSDevSlnMSDepFuncId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDepFunc(pSDevSlnPipelineStep, (PSDevSlnMSDepFunc)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnMSDeployId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPLOY", (Object)pSDevSlnPipelineStep.getPSDevSlnMSDeployId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnPipelineStep, (PSDevSlnMSDeploy)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnPipelineStageId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINESTAGE", (Object)pSDevSlnPipelineStep.getPSDevSlnPipelineStageId())) != null) {
            this.onFillParentInfo_PSDevSlnPipelineStage(pSDevSlnPipelineStep, (PSDevSlnPipelineStage)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnPipelineStep.getPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineStep, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnPipelineStep.getRefPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnPipelineStep.getRefPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_RefPSDevSlnPipeline(pSDevSlnPipelineStep, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnSysAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPI", (Object)pSDevSlnPipelineStep.getPSDevSlnSysAPIId())) != null) {
            this.onFillParentInfo_PSDevSlnSysAPI(pSDevSlnPipelineStep, (PSDevSlnSysAPI)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPP", (Object)pSDevSlnPipelineStep.getPSDevSlnSysAppId())) != null) {
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnPipelineStep, (PSDevSlnSysApp)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnSysSrvId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSSRV", (Object)pSDevSlnPipelineStep.getPSDevSlnSysSrvId())) != null) {
            this.onFillParentInfo_PSDevSlnSysSrv(pSDevSlnPipelineStep, (PSDevSlnSysSrv)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSVER", (Object)pSDevSlnPipelineStep.getPSDevSlnSysVerId())) != null) {
            this.onFillParentInfo_PSDevSlnSysVer(pSDevSlnPipelineStep, (PSDevSlnSysVer)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnPipelineStep.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnPipelineStep, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnPipelineStep.getPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSDevSlnPipelineStep.getPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnPipelineStep, (PSDevSlnTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnPipelineStep, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionParams(bl, pSDevSlnPipelineStep, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionType(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AgentPSDCRegistryItemId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CheckinMode(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModel(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModelFlag(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCheckout(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelPSDevCenterSVNId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBDInstId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCFileId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformFuncId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformNodeId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryItemId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRegistryRepoId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAPIId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAppId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStageId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStepId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStepName(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAPIId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrvId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysVerId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnPipelineId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunCmd(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepTag(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepTag2(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepTag3(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepTag4(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplPSDevCenterSVNId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToolPSDCRegistryItemId(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkFolder(bl, pSDevSlnPipelineStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnPipelineStep, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionParams(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isActionParamsDirty() : !pSDevSlnPipelineStep.isActionParamsDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionParams_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionType(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isActionTypeDirty() && !bl2 : !pSDevSlnPipelineStep.isActionTypeDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getActionType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionType_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AgentPSDCRegistryItemId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isAgentPSDCRegistryItemIdDirty() : !pSDevSlnPipelineStep.isAgentPSDCRegistryItemIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getAgentPSDCRegistryItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentPSDCRegistryItemId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTPSDCREGISTRYITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CheckinMode(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isCheckinModeDirty() : !pSDevSlnPipelineStep.isCheckinModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStep.getCheckinMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CheckinMode_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHECKINMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isCodeNameDirty() && !bl2 : !pSDevSlnPipelineStep.isCodeNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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
                string3 = "PSDEVSLNPIPELINEID";
                string3 = string3 + ";";
                string3 = string3 + "PSDEVSLNPIPELINESTAGEID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnPipelineStepDEModel(), "CODENAME", string3, pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_CondModel(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isCondModelDirty() : !pSDevSlnPipelineStep.isCondModelDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getCondModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondModel_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondModelFlag(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isCondModelFlagDirty() : !pSDevSlnPipelineStep.isCondModelFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStep.getCondModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CondModelFlag_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCheckout(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isCustomCheckoutDirty() : !pSDevSlnPipelineStep.isCustomCheckoutDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStep.getCustomCheckout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomCheckout_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCHECKOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isCustomCodeDirty() : !pSDevSlnPipelineStep.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isMemoDirty() : !pSDevSlnPipelineStep.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelPSDevCenterSVNId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isModelPSDevCenterSVNIdDirty() : !pSDevSlnPipelineStep.isModelPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getModelPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelPSDevCenterSVNId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isOrderValueDirty() && !bl2 : !pSDevSlnPipelineStep.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStep.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCBDInstId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCBDInstIdDirty() : !pSDevSlnPipelineStep.isPSDCBDInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCBDInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBDInstId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCCodeSnippetId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCCodeSnippetIdDirty() : !pSDevSlnPipelineStep.isPSDCCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCCodeSnippetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCFileId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCFileIdDirty() : !pSDevSlnPipelineStep.isPSDCFileIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCFileId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMSPlatformFuncId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCMSPlatformFuncIdDirty() : !pSDevSlnPipelineStep.isPSDCMSPlatformFuncIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCMSPlatformFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformFuncId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCMSPlatformIdDirty() : !pSDevSlnPipelineStep.isPSDCMSPlatformIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCMSPlatformId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformNodeId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCMSPlatformNodeIdDirty() : !pSDevSlnPipelineStep.isPSDCMSPlatformNodeIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCMSPlatformNodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformNodeId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRegistryItemId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCRegistryItemIdDirty() : !pSDevSlnPipelineStep.isPSDCRegistryItemIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCRegistryItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryItemId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRegistryRepoId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDCRegistryRepoIdDirty() : !pSDevSlnPipelineStep.isPSDCRegistryRepoIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDCRegistryRepoId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRegistryRepoId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevCenterDBInstIdDirty() : !pSDevSlnPipelineStep.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevCenterSVNIdDirty() : !pSDevSlnPipelineStep.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepAPIId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnMSDepAPIIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnMSDepAPIIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnMSDepAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAPIId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepAppId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnMSDepAppIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnMSDepAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnMSDepAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAppId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnMSDepFuncIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnMSDepFuncIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnMSDepFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDeployId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnMSDeployIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnMSDeployIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnMSDeployId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnPipelineIdDirty() && !bl2 : !pSDevSlnPipelineStep.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineStageId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnPipelineStageIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnPipelineStageIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnPipelineStageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStageId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineStepId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnPipelineStepIdDirty() && !bl2 : !pSDevSlnPipelineStep.isPSDevSlnPipelineStepIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnPipelineStepId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTEPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStepId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTEPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineStepName(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnPipelineStepNameDirty() && !bl2 : !pSDevSlnPipelineStep.isPSDevSlnPipelineStepNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnPipelineStepName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTEPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStepName_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTEPNAME");
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
                string3 = "PSDEVSLNPIPELINEID";
                string3 = string3 + ";";
                string3 = string3 + "PSDEVSLNPIPELINESTAGEID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnPipelineStepDEModel(), "PSDEVSLNPIPELINESTEPNAME", string3, pSDevSlnPipelineStep, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNPIPELINESTEPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAPIId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnSysAPIIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAPIId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAppId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnSysAppIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnSysAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnSysIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysSrvId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnSysSrvIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnSysSrvIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnSysSrvId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrvId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysVerId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnSysVerIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnSysVerIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysVerId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnTemplId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isPSDevSlnTemplIdDirty() : !pSDevSlnPipelineStep.isPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getPSDevSlnTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnPipelineId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isRefPSDevSlnPipelineIdDirty() : !pSDevSlnPipelineStep.isRefPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getRefPSDevSlnPipelineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnPipelineId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunCmd(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isRunCmdDirty() : !pSDevSlnPipelineStep.isRunCmdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getRunCmd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunCmd_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNCMD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepTag(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isStepTagDirty() : !pSDevSlnPipelineStep.isStepTagDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getStepTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepTag_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepTag2(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isStepTag2Dirty() : !pSDevSlnPipelineStep.isStepTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getStepTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepTag2_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepTag3(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isStepTag3Dirty() : !pSDevSlnPipelineStep.isStepTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getStepTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepTag3_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepTag4(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isStepTag4Dirty() : !pSDevSlnPipelineStep.isStepTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getStepTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepTag4_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isTemplateModeDirty() : !pSDevSlnPipelineStep.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStep.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplPSDevCenterSVNId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isTemplPSDevCenterSVNIdDirty() : !pSDevSlnPipelineStep.isTemplPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getTemplPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplPSDevCenterSVNId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToolPSDCRegistryItemId(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isToolPSDCRegistryItemIdDirty() : !pSDevSlnPipelineStep.isToolPSDCRegistryItemIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getToolPSDCRegistryItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToolPSDCRegistryItemId_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLPSDCREGISTRYITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isUserCatDirty() : !pSDevSlnPipelineStep.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isUserTagDirty() : !pSDevSlnPipelineStep.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isUserTag2Dirty() : !pSDevSlnPipelineStep.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isUserTag3Dirty() : !pSDevSlnPipelineStep.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isUserTag4Dirty() : !pSDevSlnPipelineStep.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isValidFlagDirty() && !bl2 : !pSDevSlnPipelineStep.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStep.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_WorkFolder(boolean bl, PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStep.isWorkFolderDirty() : !pSDevSlnPipelineStep.isWorkFolderDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStep.getWorkFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkFolder_Default((IEntity)pSDevSlnPipelineStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnPipelineStep, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnPipelineStep, bl);
    }

    public Object getDataContextValue(PSDevSlnPipelineStep pSDevSlnPipelineStep, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnPipelineStep, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnPipelineStage pSDevSlnPipelineStage = pSDevSlnPipelineStep.getPSDevSlnPipelineStage();
        if (pSDevSlnPipelineStage != null && pSDevSlnPipelineStage.contains(string)) {
            return pSDevSlnPipelineStage.get(string);
        }
        PSDevSlnPipeline pSDevSlnPipeline = pSDevSlnPipelineStep.getPSDevSlnPipeline();
        if (pSDevSlnPipeline != null && pSDevSlnPipeline.contains(string)) {
            return pSDevSlnPipeline.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnPipelineStep pSDevSlnPipelineStep, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnPipelineStep, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTPSDCREGISTRYITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentPSDCRegistryItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTPSDCREGISTRYITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentPSDCRegistryItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHECKINMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CheckinMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCHECKOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCheckout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformNodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPLOYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDeployId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPLOYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDeployName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINESTAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineStageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINESTAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineStageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINESTEPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineStepId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINESTEPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineStepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrvId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrvName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNPIPELINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnPipelineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnPipelineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNCMD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunCmd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLPSDCREGISTRYITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToolPSDCRegistryItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLPSDCREGISTRYITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToolPSDCRegistryItemName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WORKFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkFolder_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentPSDCRegistryItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTPSDCREGISTRYITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentPSDCRegistryItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTPSDCREGISTRYITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CheckinMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CustomCheckout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ModelPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDCCodeSnippetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDCMSPlatformFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDevSlnMSDepAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDeployId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPLOYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDeployName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPLOYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineStageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINESTAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineStageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINESTAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineStepId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINESTEPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineStepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINESTEPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDevSlnSysSrvId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysSrvName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnPipelineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNPIPELINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnPipelineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNPIPELINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunCmd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNCMD", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToolPSDCRegistryItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLPSDCREGISTRYITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToolPSDCRegistryItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLPSDCREGISTRYITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_WorkFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKFOLDER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnPipelineStep)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnPipelineStep);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnPipelineStep pSDevSlnPipelineStep, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNPIPELINESTEP");
        if (!bl) {
            pSDevSlnPipelineStep.setCreateDate(null);
            pSDevSlnPipelineStep.setCreateMan(null);
            pSDevSlnPipelineStep.setPSDevSlnPipelineStepId(null);
            pSDevSlnPipelineStep.setUpdateDate(null);
            pSDevSlnPipelineStep.setUpdateMan(null);
            pSDevSlnPipelineStep.setPSDevSlnPipelineStageId(null);
            pSDevSlnPipelineStep.setPSDevSlnId(null);
            pSDevSlnPipelineStep.setPSDevSlnPipelineId(null);
            pSDevSlnPipelineStep.setPSDevSlnPipelineName(null);
            super.exportCurXmlModel(pSDevSlnPipelineStep, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        return pSDevSlnPipelineStep.getActionType();
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDevSlnPipelineStep pSDevSlnPipelineStep, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Step");
    }
}

