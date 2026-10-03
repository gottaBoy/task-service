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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepAPIDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAPIDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeployBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepAPIServiceBase
extends PSCoreSysServiceBase<PSDevSlnMSDepAPI> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAPIServiceBase.class);
    public static final String DATASET_CURAPI = "CurAPI";
    public static final String DATASET_CURDEPLOY = "CurDeploy";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLNUNUSED = "CurSlnUnused";
    public static final String DATASET_CURSLNUSED = "CurSlnUsed";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnMSDepAPIDEModel pSDevSlnMSDepAPIDEModel;
    private PSDevSlnMSDepAPIDAO pSDevSlnMSDepAPIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService";
    }

    public PSDevSlnMSDepAPIDEModel getPSDevSlnMSDepAPIDEModel() {
        if (this.pSDevSlnMSDepAPIDEModel == null) {
            try {
                this.pSDevSlnMSDepAPIDEModel = (PSDevSlnMSDepAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepAPIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDepAPIDEModel();
    }

    public PSDevSlnMSDepAPIDAO getPSDevSlnMSDepAPIDAO() {
        if (this.pSDevSlnMSDepAPIDAO == null) {
            try {
                this.pSDevSlnMSDepAPIDAO = (PSDevSlnMSDepAPIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepAPIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepAPIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnMSDepAPIDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPI, (boolean)true) == 0) {
            return this.fetchCurAPI(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPI, false);
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

    protected void onFillParentInfo(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = (PSDCMSPlatformNode)iService.getDEModel().createEntity();
            pSDCMSPlatformNode.set("PSDCMSPLATFORMNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMSPlatformNode);
            } else {
                iService.get(pSDCMSPlatformNode);
            }
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnMSDepAPI, pSDCMSPlatformNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnMSDepAPI, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDeploy pSDevSlnMSDeploy = (PSDevSlnMSDeploy)iService.getDEModel().createEntity();
            pSDevSlnMSDeploy.set("PSDEVSLNMSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnMSDeploy);
            } else {
                iService.get(pSDevSlnMSDeploy);
            }
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnMSDepAPI, pSDevSlnMSDeploy);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnPipeline);
            } else {
                iService.get(pSDevSlnPipeline);
            }
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnMSDepAPI, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNSYSAPI_PSDEVSLNSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = (PSDevSlnSysAPI)iService.getDEModel().createEntity();
            pSDevSlnSysAPI.set("PSDEVSLNSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysAPI);
            } else {
                iService.get(pSDevSlnSysAPI);
            }
            this.onFillParentInfo_PSDevSlnSysAPI(pSDevSlnMSDepAPI, pSDevSlnSysAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnMSDepAPI, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPAPI_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepAPI, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDevSlnMSDepAPI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMSPlatformNode(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        pSDevSlnMSDepAPI.setNodeIPAddr(pSDCMSPlatformNode.getIpAddr());
        pSDevSlnMSDepAPI.setNodePort(pSDCMSPlatformNode.getPort());
        pSDevSlnMSDepAPI.setPSDCMSPlatformNodeId(pSDCMSPlatformNode.getPSDCMSPlatformNodeId());
        pSDevSlnMSDepAPI.setPSDCMSPlatformNodeName(pSDCMSPlatformNode.getPSDCMSPlatformNodeName());
        pSDevSlnMSDepAPI.setPSDCRegistryItemId(pSDCMSPlatformNode.getPSDCRegistryItemId());
        pSDevSlnMSDepAPI.setPSDCRegistryItemName(pSDCMSPlatformNode.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnMSDepAPI.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnMSDepAPI.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSDevSlnMSDeploy(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        pSDevSlnMSDepAPI.setPSDCMSPlatformId(pSDevSlnMSDeploy.getPSDCMSPlatformId());
        pSDevSlnMSDepAPI.setPSDevSlnMSDeployId(pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        pSDevSlnMSDepAPI.setPSDevSlnMSDeployName(pSDevSlnMSDeploy.getPSDevSlnMSDeployName());
        if (pSDevSlnMSDeploy.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepAPI, pSDevSlnMSDeploy.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSlnPipeline(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnMSDepAPI.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnMSDepAPI.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_PSDevSlnSysAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        pSDevSlnMSDepAPI.setAPIMode(pSDevSlnSysAPI.getAPIMode());
        pSDevSlnMSDepAPI.setAPITag(pSDevSlnSysAPI.getAPITag());
        pSDevSlnMSDepAPI.setAPITag2(pSDevSlnSysAPI.getAPITag2());
        pSDevSlnMSDepAPI.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        pSDevSlnMSDepAPI.setPSDevSlnSysAPIName(pSDevSlnSysAPI.getPSDevSlnSysAPIName());
        pSDevSlnMSDepAPI.setPSSysServiceAPIId(pSDevSlnSysAPI.getPSSysServiceAPIId());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnMSDepAPI.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnMSDepAPI.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
        if (pSDevSlnSys.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepAPI, pSDevSlnSys.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, PSDevSln pSDevSln) throws Exception {
        pSDevSlnMSDepAPI.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnMSDepAPI.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnMSDepAPI.getDeployState() == null) {
                pSDevSlnMSDepAPI.setDeployState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnMSDepAPI.getValidFlag() == null) {
                pSDevSlnMSDepAPI.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnMSDepAPI, bl);
        this.onFillEntityFullInfo_PSDCMSPlatformNode(pSDevSlnMSDepAPI, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSDevSlnMSDepAPI, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDeploy(pSDevSlnMSDepAPI, bl);
        this.onFillEntityFullInfo_PSDevSlnPipeline(pSDevSlnMSDepAPI, bl);
        this.onFillEntityFullInfo_PSDevSlnSysAPI(pSDevSlnMSDepAPI, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnMSDepAPI, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnMSDepAPI, bl);
    }

    protected void onFillEntityFullInfo_PSDCMSPlatformNode(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDeploy(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnPipeline(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnMSDepAPI, bl);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepAPI> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORMNODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCMSPlatformNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPI_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPI", iDataEntityModel.getDataInfo(pSDCMSPlatformNode), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getDEModel().createEntity();
            pSDevSlnMSDepAPI2.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
            pSDevSlnMSDepAPI2.setPSDCMSPlatformNodeId(null);
            this.update(pSDevSlnMSDepAPI2);
        }
    }

    public void removeByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        final PSDCMSPlatformNode pSDCMSPlatformNode2 = pSDCMSPlatformNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAPIServiceBase.this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnMSDepAPIServiceBase.this.internalRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnMSDepAPIServiceBase.this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            this.remove(pSDevSlnMSDepAPI);
        }
        this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPI_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPI", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getDEModel().createEntity();
            pSDevSlnMSDepAPI2.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
            pSDevSlnMSDepAPI2.setPSDevCenterDBInstId(null);
            this.update(pSDevSlnMSDepAPI2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAPIServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnMSDepAPIServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnMSDepAPIServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            this.remove(pSDevSlnMSDepAPI);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPLOY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnMSDeploy);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPI", iDataEntityModel.getDataInfo(pSDevSlnMSDeploy), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getDEModel().createEntity();
            pSDevSlnMSDepAPI2.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
            pSDevSlnMSDepAPI2.setPSDevSlnMSDeployId(null);
            this.update(pSDevSlnMSDepAPI2);
        }
    }

    public void removeByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        final PSDevSlnMSDeploy pSDevSlnMSDeploy2 = pSDevSlnMSDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAPIServiceBase.this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnMSDepAPIServiceBase.this.internalRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnMSDepAPIServiceBase.this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            this.remove(pSDevSlnMSDepAPI);
        }
        this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNPIPELINE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnPipeline);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPI", iDataEntityModel.getDataInfo(pSDevSlnPipeline), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getDEModel().createEntity();
            pSDevSlnMSDepAPI2.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
            pSDevSlnMSDepAPI2.setPSDevSlnPipelineId(null);
            this.update(pSDevSlnMSDepAPI2);
        }
    }

    public void removeByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAPIServiceBase.this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnMSDepAPIServiceBase.this.internalRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnMSDepAPIServiceBase.this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            this.remove(pSDevSlnMSDepAPI);
        }
        this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    public void resetPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getDEModel().createEntity();
            pSDevSlnMSDepAPI2.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
            pSDevSlnMSDepAPI2.setPSDevSlnSysAPIId(null);
            this.update(pSDevSlnMSDepAPI2);
        }
    }

    public void removeByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        final PSDevSlnSysAPI pSDevSlnSysAPI2 = pSDevSlnSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAPIServiceBase.this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnMSDepAPIServiceBase.this.internalRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnMSDepAPIServiceBase.this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            this.remove(pSDevSlnMSDepAPI);
        }
        this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPAPI", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getDEModel().createEntity();
            pSDevSlnMSDepAPI2.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
            pSDevSlnMSDepAPI2.setPSDevSlnSysId(null);
            this.update(pSDevSlnMSDepAPI2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAPIServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnMSDepAPIServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnMSDepAPIServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            this.remove(pSDevSlnMSDepAPI);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getDEModel().createEntity();
            pSDevSlnMSDepAPI2.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
            pSDevSlnMSDepAPI2.setPSDevSlnId(null);
            this.update(pSDevSlnMSDepAPI2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepAPIServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDepAPIServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDepAPIServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDepAPI> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI : arrayList) {
            this.remove(pSDevSlnMSDepAPI);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDepAPI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnPipelineStepService.testRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI);
        super.onBeforeRemove(pSDevSlnMSDepAPI);
    }

    protected void replaceParentInfo(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnMSDepAPI, cloneSession);
        if (pSDevSlnMSDepAPI.getPSDCMSPlatformNodeId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORMNODE", (Object)pSDevSlnMSDepAPI.getPSDCMSPlatformNodeId())) != null) {
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnMSDepAPI, (PSDCMSPlatformNode)iEntity);
        }
        if (pSDevSlnMSDepAPI.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnMSDepAPI.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnMSDepAPI, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnMSDepAPI.getPSDevSlnMSDeployId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPLOY", (Object)pSDevSlnMSDepAPI.getPSDevSlnMSDeployId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnMSDepAPI, (PSDevSlnMSDeploy)iEntity);
        }
        if (pSDevSlnMSDepAPI.getPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnMSDepAPI.getPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnMSDepAPI, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnMSDepAPI.getPSDevSlnSysAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPI", (Object)pSDevSlnMSDepAPI.getPSDevSlnSysAPIId())) != null) {
            this.onFillParentInfo_PSDevSlnSysAPI(pSDevSlnMSDepAPI, (PSDevSlnSysAPI)iEntity);
        }
        if (pSDevSlnMSDepAPI.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnMSDepAPI.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnMSDepAPI, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnMSDepAPI.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnMSDepAPI.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepAPI, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnMSDepAPI, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AuthCheckTokenUri(bl, pSDevSlnMSDepAPI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientSecret(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthMode(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployState(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag2(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag3(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeployTag4(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpAddress(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpsPort(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformNodeId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAPIId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAPIName(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAPIId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnMSDepAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnMSDepAPI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AuthCheckTokenUri(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isAuthCheckTokenUriDirty() : !pSDevSlnMSDepAPI.isAuthCheckTokenUriDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getAuthCheckTokenUri();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthCheckTokenUri_Default(pSDevSlnMSDepAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCHECKTOKENURI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isAuthClientIdDirty() : !pSDevSlnMSDepAPI.isAuthClientIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getAuthClientId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientId_Default(pSDevSlnMSDepAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientSecret(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isAuthClientSecretDirty() : !pSDevSlnMSDepAPI.isAuthClientSecretDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getAuthClientSecret();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientSecret_Default(pSDevSlnMSDepAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTSECRET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthMode(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isAuthModeDirty() : !pSDevSlnMSDepAPI.isAuthModeDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getAuthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthMode_Default(pSDevSlnMSDepAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeployState(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isDeployStateDirty() && !bl2 : !pSDevSlnMSDepAPI.isDeployStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepAPI.getDeployState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DeployState_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DeployTag(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isDeployTagDirty() : !pSDevSlnMSDepAPI.isDeployTagDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getDeployTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DeployTag2(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isDeployTag2Dirty() : !pSDevSlnMSDepAPI.isDeployTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getDeployTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag2_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DeployTag3(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isDeployTag3Dirty() : !pSDevSlnMSDepAPI.isDeployTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getDeployTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag3_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DeployTag4(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isDeployTag4Dirty() : !pSDevSlnMSDepAPI.isDeployTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getDeployTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeployTag4_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_HttpAddress(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isHttpAddressDirty() : !pSDevSlnMSDepAPI.isHttpAddressDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getHttpAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpAddress_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isHttpPortDirty() : !pSDevSlnMSDepAPI.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepAPI.getHttpPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_HttpsPort(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isHttpsPortDirty() : !pSDevSlnMSDepAPI.isHttpsPortDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepAPI.getHttpsPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpsPort_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isMemoDirty() : !pSDevSlnMSDepAPI.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isOrderValueDirty() : !pSDevSlnMSDepAPI.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepAPI.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMSPlatformNodeId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDCMSPlatformNodeIdDirty() && !bl2 : !pSDevSlnMSDepAPI.isPSDCMSPlatformNodeIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDCMSPlatformNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformNodeId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevCenterDBInstIdDirty() : !pSDevSlnMSDepAPI.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevSlnIdDirty() && !bl2 : !pSDevSlnMSDepAPI.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepAPIId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevSlnMSDepAPIIdDirty() && !bl2 : !pSDevSlnMSDepAPI.isPSDevSlnMSDepAPIIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAPIId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepAPIName(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevSlnMSDepAPINameDirty() && !bl2 : !pSDevSlnMSDepAPI.isPSDevSlnMSDepAPINameDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAPIName_Default(pSDevSlnMSDepAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDeployId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevSlnMSDeployIdDirty() && !bl2 : !pSDevSlnMSDepAPI.isPSDevSlnMSDeployIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevSlnMSDeployId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevSlnPipelineIdDirty() : !pSDevSlnMSDepAPI.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysAPIId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevSlnSysAPIIdDirty() : !pSDevSlnMSDepAPI.isPSDevSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevSlnSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAPIId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isPSDevSlnSysIdDirty() : !pSDevSlnMSDepAPI.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isUserParamsDirty() : !pSDevSlnMSDepAPI.isUserParamsDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepAPI.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepAPI.isValidFlagDirty() && !bl2 : !pSDevSlnMSDepAPI.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepAPI.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnMSDepAPI, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnMSDepAPI, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnMSDepAPI, bl);
    }

    public Object getDataContextValue(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnMSDepAPI, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnMSDeploy pSDevSlnMSDeploy = pSDevSlnMSDepAPI.getPSDevSlnMSDeploy();
        if (pSDevSlnMSDeploy != null && pSDevSlnMSDeploy.contains(string)) {
            return pSDevSlnMSDeploy.get(string);
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnMSDepAPI.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnMSDepAPI, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APIMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APIMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APITag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APITag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCHECKTOKENURI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthCheckTokenUri_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTSECRET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientSecret_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAPIName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_APIMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_APITag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APITAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APITag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APITAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthCheckTokenUri_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCHECKTOKENURI", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthClientId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthClientSecret_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTSECRET", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnMSDepAPI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        Object object = pSDevSlnMSDepAPI.get("PSDEVSLNMSDEPLOYID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVSLNMSDEPAPI_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", object);
        }
        super.onUpdateParent(pSDevSlnMSDepAPI);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNMSDEPAPI");
        if (!bl) {
            pSDevSlnMSDepAPI.setCreateDate(null);
            pSDevSlnMSDepAPI.setCreateMan(null);
            pSDevSlnMSDepAPI.setDeployState(null);
            pSDevSlnMSDepAPI.setPSDevSlnMSDepAPIId(null);
            pSDevSlnMSDepAPI.setPSDevSlnName(null);
            pSDevSlnMSDepAPI.setUpdateDate(null);
            pSDevSlnMSDepAPI.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnMSDepAPI, xmlNode, bl);
        }
    }
}

