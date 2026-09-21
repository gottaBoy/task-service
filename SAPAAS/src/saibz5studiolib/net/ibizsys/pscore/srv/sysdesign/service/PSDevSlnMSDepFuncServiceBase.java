/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
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
import java.util.Iterator;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepFuncDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepFuncDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeployBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepFuncServiceBase
extends PSCoreSysServiceBase<PSDevSlnMSDepFunc> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncServiceBase.class);
    public static final String DATASET_CURDEPLOY = "CurDeploy";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnMSDepFuncDEModel pSDevSlnMSDepFuncDEModel;
    private PSDevSlnMSDepFuncDAO pSDevSlnMSDepFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService";
    }

    public PSDevSlnMSDepFuncDEModel getPSDevSlnMSDepFuncDEModel() {
        if (this.pSDevSlnMSDepFuncDEModel == null) {
            try {
                this.pSDevSlnMSDepFuncDEModel = (PSDevSlnMSDepFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDepFuncDEModel();
    }

    public PSDevSlnMSDepFuncDAO getPSDevSlnMSDepFuncDAO() {
        if (this.pSDevSlnMSDepFuncDAO == null) {
            try {
                this.pSDevSlnMSDepFuncDAO = (PSDevSlnMSDepFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnMSDepFuncDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPLOY, (boolean)true) == 0) {
            return this.fetchCurDeploy(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPLOY, (boolean)true) == 0) {
            return this.fetchTempCurDeploy(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchTempCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDeploy(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPLOY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDeploy(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPLOY, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, true);
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

    protected void onFillParentInfo(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNC_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = (PSDCMSPlatformNode)iService.getDEModel().createEntity();
            pSDCMSPlatformNode.set("PSDCMSPLATFORMNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCMSPlatformNode);
            } else {
                iService.get((IEntity)pSDCMSPlatformNode);
            }
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnMSDepFunc, pSDCMSPlatformNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterDBInst);
            } else {
                iService.get((IEntity)pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnMSDepFunc, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnMSDepFunc, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDeploy pSDevSlnMSDeploy = (PSDevSlnMSDeploy)iService.getDEModel().createEntity();
            pSDevSlnMSDeploy.set("PSDEVSLNMSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnMSDeploy);
            } else {
                iService.get((IEntity)pSDevSlnMSDeploy);
            }
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnMSDepFunc, pSDevSlnMSDeploy);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipeline);
            } else {
                iService.get((IEntity)pSDevSlnPipeline);
            }
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnMSDepFunc, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnMSDepFunc, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepFunc, pSDevSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnMSDepFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMSPlatformNode(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        pSDevSlnMSDepFunc.setPSDCMSPlatformNodeId(pSDCMSPlatformNode.getPSDCMSPlatformNodeId());
        pSDevSlnMSDepFunc.setPSDCMSPlatformNodeName(pSDCMSPlatformNode.getPSDCMSPlatformNodeName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnMSDepFunc.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnMSDepFunc.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnMSDepFunc.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnMSDepFunc.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevSlnMSDeploy(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        pSDevSlnMSDepFunc.setPSDCMSPlatformId(pSDevSlnMSDeploy.getPSDCMSPlatformId());
        pSDevSlnMSDepFunc.setPSDevSlnMSDeployId(pSDevSlnMSDeploy.getPSDevSlnMSDeployId());
        pSDevSlnMSDepFunc.setPSDevSlnMSDeployName(pSDevSlnMSDeploy.getPSDevSlnMSDeployName());
        if (pSDevSlnMSDeploy.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepFunc, pSDevSlnMSDeploy.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSlnPipeline(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnMSDepFunc.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnMSDepFunc.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnMSDepFunc.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnMSDepFunc.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
        if (pSDevSlnSys.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepFunc, pSDevSlnSys.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevSln pSDevSln) throws Exception {
        pSDevSlnMSDepFunc.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnMSDepFunc.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnMSDepFunc.getDeployState() == null) {
                pSDevSlnMSDepFunc.setDeployState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnMSDepFunc.getValidFlag() == null) {
                pSDevSlnMSDepFunc.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnMSDepFunc, bl);
        this.onFillEntityFullInfo_PSDCMSPlatformNode(pSDevSlnMSDepFunc, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSDevSlnMSDepFunc, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDevSlnMSDepFunc, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDeploy(pSDevSlnMSDepFunc, bl);
        this.onFillEntityFullInfo_PSDevSlnPipeline(pSDevSlnMSDepFunc, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnMSDepFunc, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnMSDepFunc, bl);
    }

    protected void onFillEntityFullInfo_PSDCMSPlatformNode(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDeploy(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnPipeline(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnMSDepFunc, bl);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string) throws Exception {
        return this.selectByPSDCMSPlatformNode(pSDCMSPlatformNodeBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDCMSPlatformNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeployBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnMSDeploy(PSDevSlnMSDeployBase pSDevSlnMSDeployBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnMSDepFunc> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMSPLATFORMNODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCMSPlatformNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNC_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNC", iDataEntityModel.getDataInfo((IEntity)pSDCMSPlatformNode), arrayList.get(0)));
        }
    }

    public void resetPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getDEModel().createEntity();
            pSDevSlnMSDepFunc2.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
            pSDevSlnMSDepFunc2.setPSDCMSPlatformNodeId(null);
            this.update(pSDevSlnMSDepFunc2);
        }
    }

    public void removeByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        final PSDCMSPlatformNode pSDCMSPlatformNode2 = pSDCMSPlatformNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncServiceBase.this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnMSDepFuncServiceBase.this.internalRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
                PSDevSlnMSDepFuncServiceBase.this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        this.onBeforeRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            this.remove((IEntity)pSDevSlnMSDepFunc);
        }
        this.onAfterRemoveByPSDCMSPlatformNode(pSDCMSPlatformNode, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatformNode(PSDCMSPlatformNode pSDCMSPlatformNode, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNC", iDataEntityModel.getDataInfo((IEntity)pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getDEModel().createEntity();
            pSDevSlnMSDepFunc2.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
            pSDevSlnMSDepFunc2.setPSDevCenterDBInstId(null);
            this.update(pSDevSlnMSDepFunc2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnMSDepFuncServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDevSlnMSDepFuncServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            this.remove((IEntity)pSDevSlnMSDepFunc);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNC", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getDEModel().createEntity();
            pSDevSlnMSDepFunc2.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
            pSDevSlnMSDepFunc2.setPSDevCenterSVNId(null);
            this.update(pSDevSlnMSDepFunc2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnMSDepFuncServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnMSDepFuncServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            this.remove((IEntity)pSDevSlnMSDepFunc);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNMSDEPLOY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnMSDeploy);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNC", iDataEntityModel.getDataInfo((IEntity)pSDevSlnMSDeploy), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getDEModel().createEntity();
            pSDevSlnMSDepFunc2.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
            pSDevSlnMSDepFunc2.setPSDevSlnMSDeployId(null);
            this.update(pSDevSlnMSDepFunc2);
        }
    }

    public void removeByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        final PSDevSlnMSDeploy pSDevSlnMSDeploy2 = pSDevSlnMSDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncServiceBase.this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnMSDepFuncServiceBase.this.internalRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
                PSDevSlnMSDepFuncServiceBase.this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnMSDeploy(pSDevSlnMSDeploy);
        this.onBeforeRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            this.remove((IEntity)pSDevSlnMSDepFunc);
        }
        this.onAfterRemoveByPSDevSlnMSDeploy(pSDevSlnMSDeploy, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDeploy(PSDevSlnMSDeploy pSDevSlnMSDeploy, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNPIPELINE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnPipeline);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNC", iDataEntityModel.getDataInfo((IEntity)pSDevSlnPipeline), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getDEModel().createEntity();
            pSDevSlnMSDepFunc2.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
            pSDevSlnMSDepFunc2.setPSDevSlnPipelineId(null);
            this.update(pSDevSlnMSDepFunc2);
        }
    }

    public void removeByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncServiceBase.this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnMSDepFuncServiceBase.this.internalRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnMSDepFuncServiceBase.this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            this.remove((IEntity)pSDevSlnMSDepFunc);
        }
        this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNMSDEPFUNC", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getDEModel().createEntity();
            pSDevSlnMSDepFunc2.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
            pSDevSlnMSDepFunc2.setPSDevSlnSysId(null);
            this.update(pSDevSlnMSDepFunc2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnMSDepFuncServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnMSDepFuncServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            this.remove((IEntity)pSDevSlnMSDepFunc);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getDEModel().createEntity();
            pSDevSlnMSDepFunc2.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
            pSDevSlnMSDepFunc2.setPSDevSlnId(null);
            this.update(pSDevSlnMSDepFunc2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnMSDepFuncServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDepFuncServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnMSDepFuncServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnMSDepFunc> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList) {
            this.remove((IEntity)pSDevSlnMSDepFunc);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnMSDepFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        ((PSDevSlnMSDepFuncItemServiceBase)pSCoreSysServiceBase).removeByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        super.onBeforeRemove(pSDevSlnMSDepFunc);
    }

    protected void onBeforeRemoveTemp(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnMSDepFuncItemService.removeTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        super.onBeforeRemoveTemp((IEntity)pSDevSlnMSDepFunc);
    }

    protected void getRelatedDataTempMajor(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        this.getRelatedDataTempMajor_PSDevSlnMSDepFuncItem(pSDevSlnMSDepFunc);
        super.getRelatedDataTempMajor((IEntity)pSDevSlnMSDepFunc);
    }

    protected void getRelatedDataTempMajor_PSDevSlnMSDepFuncItem(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = null;
        String string = pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDevSlnMSDepFuncItemService.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc) : pSDevSlnMSDepFuncItemService.selectTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            pSDevSlnMSDepFuncItemService.getTempMajor(pSDevSlnMSDepFuncItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevSlnMSDepFunc pSDevSlnMSDepFunc2) throws Exception {
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = this.updateRelatedDataTempMajor_removePSDevSlnMSDepFuncItem(pSDevSlnMSDepFunc, pSDevSlnMSDepFunc2);
        this.updateRelatedDataTempMajor_updatePSDevSlnMSDepFuncItem(pSDevSlnMSDepFunc, pSDevSlnMSDepFunc2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDevSlnMSDepFunc, (IEntity)pSDevSlnMSDepFunc2);
    }

    protected ArrayList<PSDevSlnMSDepFuncItem> updateRelatedDataTempMajor_removePSDevSlnMSDepFuncItem(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevSlnMSDepFunc pSDevSlnMSDepFunc2) throws Exception {
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = pSDevSlnMSDepFuncItemService.selectTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        ArrayList<PSDevSlnMSDepFuncItem> arrayList2 = pSDevSlnMSDepFuncItemService.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
        HashMap<String, PSDevSlnMSDepFuncItem> hashMap = new HashMap<String, PSDevSlnMSDepFuncItem>();
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList2) {
            hashMap.put(pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemId(), pSDevSlnMSDepFuncItem);
        }
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            Object object = pSDevSlnMSDepFuncItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : hashMap.values()) {
            pSDevSlnMSDepFuncItemService.remove((IEntity)pSDevSlnMSDepFuncItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDevSlnMSDepFuncItem(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, PSDevSlnMSDepFunc pSDevSlnMSDepFunc2, ArrayList<PSDevSlnMSDepFuncItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
            pSDevSlnMSDepFuncItemService.updateTempMajor(pSDevSlnMSDepFuncItem);
        }
    }

    protected void replaceParentInfo(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnMSDepFunc, cloneSession);
        if (pSDevSlnMSDepFunc.getPSDCMSPlatformNodeId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORMNODE", (Object)pSDevSlnMSDepFunc.getPSDCMSPlatformNodeId())) != null) {
            this.onFillParentInfo_PSDCMSPlatformNode(pSDevSlnMSDepFunc, (PSDCMSPlatformNode)iEntity);
        }
        if (pSDevSlnMSDepFunc.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnMSDepFunc.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSDevSlnMSDepFunc, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnMSDepFunc.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnMSDepFunc.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnMSDepFunc, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnMSDepFunc.getPSDevSlnMSDeployId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPLOY", (Object)pSDevSlnMSDepFunc.getPSDevSlnMSDeployId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDeploy(pSDevSlnMSDepFunc, (PSDevSlnMSDeploy)iEntity);
        }
        if (pSDevSlnMSDepFunc.getPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnMSDepFunc.getPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnMSDepFunc, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnMSDepFunc.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnMSDepFunc.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnMSDepFunc, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnMSDepFunc.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnMSDepFunc.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnMSDepFunc, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnMSDepFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DeployState(bl, pSDevSlnMSDepFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncType(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpAddress(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpsPort(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformNodeId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncName(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDeployId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnMSDepFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnMSDepFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DeployState(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isDeployStateDirty() && !bl2 : !pSDevSlnMSDepFunc.isDeployStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepFunc.getDeployState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DeployState_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_FuncType(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isFuncTypeDirty() : !pSDevSlnMSDepFunc.isFuncTypeDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getFuncType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncType_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpAddress(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isHttpAddressDirty() : !pSDevSlnMSDepFunc.isHttpAddressDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getHttpAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpAddress_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isHttpPortDirty() : !pSDevSlnMSDepFunc.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepFunc.getHttpPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_HttpsPort(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isHttpsPortDirty() : !pSDevSlnMSDepFunc.isHttpsPortDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepFunc.getHttpsPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpsPort_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isMemoDirty() : !pSDevSlnMSDepFunc.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMSPlatformNodeId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDCMSPlatformNodeIdDirty() && !bl2 : !pSDevSlnMSDepFunc.isPSDCMSPlatformNodeIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDCMSPlatformNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformNodeId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevCenterDBInstIdDirty() : !pSDevSlnMSDepFunc.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevCenterSVNIdDirty() : !pSDevSlnMSDepFunc.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevSlnIdDirty() && !bl2 : !pSDevSlnMSDepFunc.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevSlnMSDepFuncIdDirty() && !bl2 : !pSDevSlnMSDepFunc.isPSDevSlnMSDepFuncIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncName(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevSlnMSDepFuncNameDirty() && !bl2 : !pSDevSlnMSDepFunc.isPSDevSlnMSDepFuncNameDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncName_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDeployId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevSlnMSDeployIdDirty() && !bl2 : !pSDevSlnMSDepFunc.isPSDevSlnMSDeployIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevSlnMSDeployId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPLOYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDeployId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevSlnPipelineIdDirty() : !pSDevSlnMSDepFunc.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isPSDevSlnSysIdDirty() : !pSDevSlnMSDepFunc.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isUserParamsDirty() : !pSDevSlnMSDepFunc.isUserParamsDirty()) {
            return null;
        }
        String string = pSDevSlnMSDepFunc.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnMSDepFunc.isValidFlagDirty() && !bl2 : !pSDevSlnMSDepFunc.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnMSDepFunc.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevSlnMSDepFunc, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnMSDepFunc, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnMSDepFunc, bl);
    }

    public Object getDataContextValue(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnMSDepFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnMSDeploy pSDevSlnMSDeploy = pSDevSlnMSDepFunc.getPSDevSlnMSDeploy();
        if (pSDevSlnMSDeploy != null && pSDevSlnMSDeploy.contains(string)) {
            return pSDevSlnMSDeploy.get(string);
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnMSDepFunc.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnMSDepFunc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeployState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformNodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FuncType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnMSDepFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnMSDepFunc);
    }

    protected void onCopyDetails(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, Object object) throws Exception {
        PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = new PSDevSlnMSDepFunc();
        pSDevSlnMSDepFunc2.set("PSDEVSLNMSDEPFUNCID", object);
        String string = DataObject.getStringValue((Object)pSDevSlnMSDepFunc.get("PSDEVSLNMSDEPFUNCID"));
        super.onCopyDetails((IEntity)pSDevSlnMSDepFunc, object);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNMSDEPFUNC");
        if (!bl) {
            pSDevSlnMSDepFunc.setCreateDate(null);
            pSDevSlnMSDepFunc.setCreateMan(null);
            pSDevSlnMSDepFunc.setPSDevSlnMSDepFuncId(null);
            pSDevSlnMSDepFunc.setUpdateDate(null);
            pSDevSlnMSDepFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnMSDepFunc, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDevSlnMSDepFuncItem(pSDevSlnMSDepFunc, xmlNode);
        super.onExportRelatedXmlModel(pSDevSlnMSDepFunc, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDevSlnMSDepFuncItem(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, XmlNode xmlNode) throws Exception {
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDepFuncItem> arrayList = null;
        String string = pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDevSlnMSDepFuncItemService.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc) : pSDevSlnMSDepFuncItemService.selectTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEVSLNMSDEPFUNCITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList) {
                pSDevSlnMSDepFuncItemService.exportXmlModel(pSDevSlnMSDepFuncItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEVSLNMSDEPFUNCITEMS");
        this.importRelatedXmlModel_PSDevSlnMSDepFuncItem(pSDevSlnMSDepFunc, xmlNode2);
        super.onImportRelatedXmlModel(pSDevSlnMSDepFunc, xmlNode);
    }

    protected void importRelatedXmlModel_PSDevSlnMSDepFuncItem(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, XmlNode xmlNode) throws Exception {
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDevSlnMSDepFuncItemService.removeByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        } else {
            pSDevSlnMSDepFuncItemService.removeTempByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem = new PSDevSlnMSDepFuncItem();
                pSDevSlnMSDepFuncItemService.fillParentInfo((IEntity)pSDevSlnMSDepFuncItem, "DER1N", "DER1N_PSDEVSLNMSDEPFUNCITEM_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPFUNCID", pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
                pSDevSlnMSDepFuncItemService.importXmlModel(pSDevSlnMSDepFuncItem, xmlNode2);
            }
        }
    }
}

