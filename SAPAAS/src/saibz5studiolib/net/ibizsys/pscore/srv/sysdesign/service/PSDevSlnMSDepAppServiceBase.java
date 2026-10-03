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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNodeBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepAppDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAppDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeployBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepAppServiceBase
extends PSCoreSysServiceBase<PSDevSlnMSDepApp> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAppServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDEPLOY = "CurDeploy";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLNUNUSED = "CurSlnUnused";
    public static final String DATASET_CURSLNUSED = "CurSlnUsed";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnMSDepAppDEModel pSDevSlnMSDepAppDEModel;
    private PSDevSlnMSDepAppDAO pSDevSlnMSDepAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService";
    }

    public PSDevSlnMSDepAppDEModel getPSDevSlnMSDepAppDEModel() {
        if (this.pSDevSlnMSDepAppDEModel == null) {
            try {
                this.pSDevSlnMSDepAppDEModel = (PSDevSlnMSDepAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDepAppDEModel();
    }

    public PSDevSlnMSDepAppDAO getPSDevSlnMSDepAppDAO() {
        if (this.pSDevSlnMSDepAppDAO == null) {
            try {
                this.pSDevSlnMSDepAppDAO = (PSDevSlnMSDepAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnMSDepAppDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPLOY, (boolean)true) == 0) {
            return this.fetchCurDeploy(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNUNUSED, (boolean)true) == 0) {
            return this.fetchCurSlnUnused(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNUSED, (boolean)true) == 0) {
            return this.fetchCurSlnUsed(iDEDataSetFetchContext);
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
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDeploy(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPLOY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnUnused(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNUNUSED, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnUsed(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNUSED, false);
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

    protected void onFillParentInfo(PSDevSlnMSDepApp pSDevSlnMSDepApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = (PSDCMSPlatformNode)iService.getDEModel().createEntity();
            pSDCMSPlatformNode.set("PSDCMSPLATFORMNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMSPlatformNode);
            } else {
                iService.get(pSDCMSPlatformNode);
            }
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnMSDepApp, pSDCMSPlatformNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnMSDepApp, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDeploy pSDevSlnMSDeploy = (PSDevSlnMSDeploy)iService.getDEModel().createEntity();
            pSDevSlnMSDeploy.set("PSDEVSLNMSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnMSDeploy);
            } else {
                iService.get(pSDevSlnMSDeploy);
            }
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnMSDepApp, pSDevSlnMSDeploy);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnPipeline);
            } else {
                iService.get(pSDevSlnPipeline);
            }
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnMSDepApp, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = (PSDevSlnSysApp)iService.getDEModel().createEntity();
            pSDevSlnSysApp.set("PSDEVSLNSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysApp);
            } else {
                iService.get(pSDevSlnSysApp);
            }
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnMSDepApp, pSDevSlnSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnMSDepApp, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPP_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepApp, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDevSlnMSDepApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMSPlatformNode(PSDevSlnMSDepApp pSDevSlnMSDepApp, PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        pSDevSlnMSDepApp.setNodeIPAddr(pSDCMSPlatformNode.getIpAddr());
        pSDevSlnMSDepApp.setNodePort(pSDCMSPlatformNode.getPort());
        pSDevSlnMSDepApp.setPSDCMSPlatformNodeId(pSDCMSPlatformNode.getPSDCMSPlatformNodeId());
        pSDevSlnMSDepApp.setPSDCMSPlatformNodeName(pSDCMSPlatformNode.getPSDCMSPlatformNodeName());
        pSDevSlnMSDepApp.setPSDCRegistryItemId(pSDCMSPlatformNode.getPSDCRegistryItemId());
        pSDevSlnMSDepApp.setPSDCRegistryItemName(pSDCMSPlatformNode.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSDevSlnMSDepApp pSDevSlnMSDepApp, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnMSDepApp.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnMSDepApp.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSDevSlnMSDeploy(PSDevSlnMSDepApp pSDevSlnMSDepApp, PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        pSDevSlnMSDepApp.setPSDCMSPlatformId(pSDevSlnMSDeploy.getPSDCMSPlatformId());
        pSDevSlnMSDepApp.setPSDevSlnMSDeployId(pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        pSDevSlnMSDepApp.setPSDevSlnMSDeployName(pSDevSlnMSDeploy.getPSDevSlnMSDeployName());
        if (pSDevSlnMSDeploy.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepApp, pSDevSlnMSDeploy.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSlnPipeline(PSDevSlnMSDepApp pSDevSlnMSDepApp, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnMSDepApp.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnMSDepApp.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_PSDevSlnSysApp(PSDevSlnMSDepApp pSDevSlnMSDepApp, PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        pSDevSlnMSDepApp.setAppMode(pSDevSlnSysApp.getAppMode());
        pSDevSlnMSDepApp.setAppTag(pSDevSlnSysApp.getAppTag());
        pSDevSlnMSDepApp.setAppTag2(pSDevSlnSysApp.getAppTag2());
        pSDevSlnMSDepApp.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
        pSDevSlnMSDepApp.setPSDevSlnSysAppName(pSDevSlnSysApp.getPSDevSlnSysAppName());
        pSDevSlnMSDepApp.setPSSysAppId(pSDevSlnSysApp.getPSSysAppId());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnMSDepApp pSDevSlnMSDepApp, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnMSDepApp.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnMSDepApp.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
        if (pSDevSlnSys.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepApp, pSDevSlnSys.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnMSDepApp pSDevSlnMSDepApp, PSDevSln pSDevSln) throws Exception {
        pSDevSlnMSDepApp.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnMSDepApp.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnMSDepApp.getDeployState() == null) {
                pSDevSlnMSDepApp.setDeployState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnMSDepApp.getValidFlag() == null) {
                pSDevSlnMSDepApp.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnMSDepApp, bl);
        this.onFillEntityFullInfo_PSDCMSPlatformNode(pSDevSlnMSDepApp, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSDevSlnMSDepApp, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDeploy(pSDevSlnMSDepApp, bl);
        this.onFillEntityFullInfo_PSDevSlnPipeline(pSDevSlnMSDepApp, bl);
        this.onFillEntityFullInfo_PSDevSlnSysApp(pSDevSlnMSDepApp, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnMSDepApp, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnMSDepApp, bl);
    }

    protected void onFillEntityFullInfo_PSDCMSPlatformNode(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDeploy(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
        if (pSDevSlnMSDepApp.isPSDevSlnMSDeployIdDirty()) {
            if (pSDevSlnMSDepApp.getPSDevSlnMSDeployId() != null) {
                PSDevSlnMSDeploy pSDevSlnMSDeploy;
                if (pSDevSlnMSDepApp.getPSDevSlnMSDeployId() == null || pSDevSlnMSDepApp.getPSDevSlnMSDeployName() == null) {
                    pSDevSlnMSDeploy = pSDevSlnMSDepApp.getPSDevSlnMSDeploy();
                    pSDevSlnMSDepApp.setPSDCMSPlatformId(pSDevSlnMSDeploy.getPSDCMSPlatformId());
                    pSDevSlnMSDepApp.setPSDevSlnMSDeployName(pSDevSlnMSDeploy.getPSDevSlnMSDeployName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDevSlnMSDeploy = pSDevSlnMSDepApp.getPSDevSlnMSDeploy()).getPSDevSlnId(), (Object)pSDevSlnMSDepApp.getPSDevSlnId()) != 0L) {
                    pSDevSlnMSDepApp.setPSDevSlnId(pSDevSlnMSDeploy.getPSDevSlnId());
                    this.onFillEntityFullInfo_PSDevSln(pSDevSlnMSDepApp, bl);
                }
            } else {
                pSDevSlnMSDepApp.setPSDCMSPlatformId(null);
                pSDevSlnMSDepApp.setPSDevSlnMSDeployName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnPipeline(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysApp(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnMSDepApp, bl);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepApp> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORMNODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCMSPlatformNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPP_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPP", iDataEntityModel.getDataInfo(pSDCMSPlatformNode), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getDEModel().createEntity();
            pSDevSlnMSDepApp2.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
            pSDevSlnMSDepApp2.setPSDCMSPlatformNodeId(null);
            this.update(pSDevSlnMSDepApp2);
        }
    }

    public void removeByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        final PSDCMSPlatformNode pSDCMSPlatformNode2 = pSDCMSPlatformNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAppServiceBase.this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnMSDepAppServiceBase.this.internalRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnMSDepAppServiceBase.this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            this.remove(pSDevSlnMSDepApp);
        }
        this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPP_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPP", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getDEModel().createEntity();
            pSDevSlnMSDepApp2.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
            pSDevSlnMSDepApp2.setPSDevCenterDBInstId(null);
            this.update(pSDevSlnMSDepApp2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAppServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnMSDepAppServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnMSDepAppServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            this.remove(pSDevSlnMSDepApp);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPLOY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnMSDeploy);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPP", iDataEntityModel.getDataInfo(pSDevSlnMSDeploy), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getDEModel().createEntity();
            pSDevSlnMSDepApp2.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
            pSDevSlnMSDepApp2.setPSDevSlnMSDeployId(null);
            this.update(pSDevSlnMSDepApp2);
        }
    }

    public void removeByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        final PSDevSlnMSDeploy pSDevSlnMSDeploy2 = pSDevSlnMSDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAppServiceBase.this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnMSDepAppServiceBase.this.internalRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnMSDepAppServiceBase.this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            this.remove(pSDevSlnMSDepApp);
        }
        this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNPIPELINE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnPipeline);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPP", iDataEntityModel.getDataInfo(pSDevSlnPipeline), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getDEModel().createEntity();
            pSDevSlnMSDepApp2.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
            pSDevSlnMSDepApp2.setPSDevSlnPipelineId(null);
            this.update(pSDevSlnMSDepApp2);
        }
    }

    public void removeByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAppServiceBase.this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnMSDepAppServiceBase.this.internalRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnMSDepAppServiceBase.this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            this.remove(pSDevSlnMSDepApp);
        }
        this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    public void resetPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getDEModel().createEntity();
            pSDevSlnMSDepApp2.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
            pSDevSlnMSDepApp2.setPSDevSlnSysAppId(null);
            this.update(pSDevSlnMSDepApp2);
        }
    }

    public void removeByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        final PSDevSlnSysApp pSDevSlnSysApp2 = pSDevSlnSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAppServiceBase.this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnMSDepAppServiceBase.this.internalRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnMSDepAppServiceBase.this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            this.remove(pSDevSlnMSDepApp);
        }
        this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPP", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getDEModel().createEntity();
            pSDevSlnMSDepApp2.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
            pSDevSlnMSDepApp2.setPSDevSlnSysId(null);
            this.update(pSDevSlnMSDepApp2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAppServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnMSDepAppServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnMSDepAppServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            this.remove(pSDevSlnMSDepApp);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getDEModel().createEntity();
            pSDevSlnMSDepApp2.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
            pSDevSlnMSDepApp2.setPSDevSlnId(null);
            this.update(pSDevSlnMSDepApp2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAppServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDepAppServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDepAppServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDepApp> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList) {
            this.remove(pSDevSlnMSDepApp);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDepApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnPipelineStepService.testRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp);
        super.onBeforeRemove(pSDevSlnMSDepApp);
    }

    protected void replaceParentInfo(PSDevSlnMSDepApp pSDevSlnMSDepApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnMSDepApp, cloneSession);
        if (pSDevSlnMSDepApp.getPSDCMSPlatformNodeId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORMNODE", (Object)pSDevSlnMSDepApp.getPSDCMSPlatformNodeId())) != null) {
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnMSDepApp, (PSDCMSPlatformNode)iEntity);
        }
        if (pSDevSlnMSDepApp.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnMSDepApp.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnMSDepApp, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnMSDepApp.getPSDevSlnMSDeployId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPLOY", (Object)pSDevSlnMSDepApp.getPSDevSlnMSDeployId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnMSDepApp, (PSDevSlnMSDeploy)iEntity);
        }
        if (pSDevSlnMSDepApp.getPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnMSDepApp.getPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnMSDepApp, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnMSDepApp.getPSDevSlnSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPP", (Object)pSDevSlnMSDepApp.getPSDevSlnSysAppId())) != null) {
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnMSDepApp, (PSDevSlnSysApp)iEntity);
        }
        if (pSDevSlnMSDepApp.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnMSDepApp.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnMSDepApp, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnMSDepApp.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnMSDepApp.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepApp, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnMSDepApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DeployState(bl, pSDevSlnMSDepApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag2(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag3(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag4(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpAddress(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpsPort(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformNodeId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAppId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAppName(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployName(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnMSDepApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnMSDepApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DeployState(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isDeployStateDirty() && !bl2 : !pSDevSlnMSDepApp.isDeployStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepApp.getDeployState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DeployState_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeployTag(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isDeployTagDirty() : !pSDevSlnMSDepApp.isDeployTagDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getDeployTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeployTag2(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isDeployTag2Dirty() : !pSDevSlnMSDepApp.isDeployTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getDeployTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag2_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeployTag3(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isDeployTag3Dirty() : !pSDevSlnMSDepApp.isDeployTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getDeployTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag3_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeployTag4(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isDeployTag4Dirty() : !pSDevSlnMSDepApp.isDeployTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getDeployTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag4_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpAddress(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isHttpAddressDirty() : !pSDevSlnMSDepApp.isHttpAddressDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getHttpAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpAddress_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPADDRESS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isHttpPortDirty() : !pSDevSlnMSDepApp.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepApp.getHttpPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpsPort(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isHttpsPortDirty() : !pSDevSlnMSDepApp.isHttpsPortDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepApp.getHttpsPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpsPort_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPSPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isMemoDirty() : !pSDevSlnMSDepApp.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isOrderValueDirty() : !pSDevSlnMSDepApp.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepApp.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMSPlatformNodeId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDCMSPlatformNodeIdDirty() && !bl2 : !pSDevSlnMSDepApp.isPSDCMSPlatformNodeIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDCMSPlatformNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformNodeId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevCenterDBInstIdDirty() : !pSDevSlnMSDepApp.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnIdDirty() : !pSDevSlnMSDepApp.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepAppId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnMSDepAppIdDirty() && !bl2 : !pSDevSlnMSDepApp.isPSDevSlnMSDepAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnMSDepAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAppId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepAppName(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnMSDepAppNameDirty() && !bl2 : !pSDevSlnMSDepApp.isPSDevSlnMSDepAppNameDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnMSDepAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAppName_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDeployId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnMSDeployIdDirty() && !bl2 : !pSDevSlnMSDepApp.isPSDevSlnMSDeployIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnMSDeployId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDeployName(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnMSDeployNameDirty() && !bl2 : !pSDevSlnMSDepApp.isPSDevSlnMSDeployNameDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnMSDeployName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployName_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnPipelineIdDirty() : !pSDevSlnMSDepApp.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysAppId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnSysAppIdDirty() : !pSDevSlnMSDepApp.isPSDevSlnSysAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isPSDevSlnSysIdDirty() : !pSDevSlnMSDepApp.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isUserParamsDirty() : !pSDevSlnMSDepApp.isUserParamsDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepApp.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDevSlnMSDepApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepApp.isValidFlagDirty() && !bl2 : !pSDevSlnMSDepApp.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepApp.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnMSDepApp, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnMSDepApp, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnMSDepApp, bl);
    }

    public Object getDataContextValue(PSDevSlnMSDepApp pSDevSlnMSDepApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnMSDepApp, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnMSDeploy pSDevSlnMSDeploy = pSDevSlnMSDepApp.getPSDevSlnMSDeploy();
        if (pSDevSlnMSDeploy != null && pSDevSlnMSDeploy.contains(string)) {
            return pSDevSlnMSDeploy.get(string);
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnMSDepApp.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnMSDepApp pSDevSlnMSDepApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnMSDepApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPADDRESS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpAddress_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPSPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpsPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodePort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPLOYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDeployId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPLOYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDeployName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_DeployState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DeployTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeployTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeployTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeployTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpAddress_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTTPADDRESS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HttpsPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_NodeIPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEIPADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodePort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnMSDepApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        Object object = pSDevSlnMSDepApp.get("PSDEVSLNMSDEPLOYID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVSLNMSDEPAPP_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", object);
        }
        super.onUpdateParent(pSDevSlnMSDepApp);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnMSDepApp pSDevSlnMSDepApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNMSDEPAPP");
        if (!bl) {
            pSDevSlnMSDepApp.setCreateDate(null);
            pSDevSlnMSDepApp.setCreateMan(null);
            pSDevSlnMSDepApp.setDeployState(null);
            pSDevSlnMSDepApp.setPSDevSlnMSDepAppId(null);
            pSDevSlnMSDepApp.setUpdateDate(null);
            pSDevSlnMSDepApp.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnMSDepApp, xmlNode, bl);
        }
    }
}

