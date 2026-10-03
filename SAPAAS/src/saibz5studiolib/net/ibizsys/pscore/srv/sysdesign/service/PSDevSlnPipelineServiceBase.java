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
import java.util.Map;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippetBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineServiceBase
extends PSCoreSysServiceBase<PSDevSlnPipeline> {
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLNMAJORNOTSYS = "CurSlnMajorNotSys";
    public static final String DATASET_CURSLNNOTSYS = "CurSlnNotSys";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSALL = "CurSysAll";
    public static final String DATASET_CURSYSMAJOR = "CurSysMajor";
    public static final String DATASET_CURSYSMAJORALL = "CurSysMajorAll";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDevSlnPipelineDEModel pSDevSlnPipelineDEModel;
    private PSDevSlnPipelineDAO pSDevSlnPipelineDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService";
    }

    public PSDevSlnPipelineDEModel getPSDevSlnPipelineDEModel() {
        if (this.pSDevSlnPipelineDEModel == null) {
            try {
                this.pSDevSlnPipelineDEModel = (PSDevSlnPipelineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineDEModel();
    }

    public PSDevSlnPipelineDAO getPSDevSlnPipelineDAO() {
        if (this.pSDevSlnPipelineDAO == null) {
            try {
                this.pSDevSlnPipelineDAO = (PSDevSlnPipelineDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnPipelineDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNMAJORNOTSYS, (boolean)true) == 0) {
            return this.fetchCurSlnMajorNotSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNNOTSYS, (boolean)true) == 0) {
            return this.fetchCurSlnNotSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSALL, (boolean)true) == 0) {
            return this.fetchCurSysAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMAJOR, (boolean)true) == 0) {
            return this.fetchCurSysMajor(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMAJORALL, (boolean)true) == 0) {
            return this.fetchCurSysMajorAll(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchTempCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNMAJORNOTSYS, (boolean)true) == 0) {
            return this.fetchTempCurSlnMajorNotSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNNOTSYS, (boolean)true) == 0) {
            return this.fetchTempCurSlnNotSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSALL, (boolean)true) == 0) {
            return this.fetchTempCurSysAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMAJOR, (boolean)true) == 0) {
            return this.fetchTempCurSysMajor(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMAJORALL, (boolean)true) == 0) {
            return this.fetchTempCurSysMajorAll(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnMajorNotSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNMAJORNOTSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSlnMajorNotSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNMAJORNOTSYS, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnNotSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNNOTSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSlnNotSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNNOTSYS, true);
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

    public DBFetchResult fetchCurSysAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSALL, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysMajor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMAJOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysMajor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMAJOR, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysMajorAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMAJORALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysMajorAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMAJORALL, true);
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

    protected void onFillParentInfo(PSDevSlnPipeline pSDevSlnPipeline, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINE_PSDCCODESNIPPET_PSDCCODESNIPPETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService", (SessionFactory)this.getSessionFactory());
            PSDCCodeSnippet pSDCCodeSnippet = (PSDCCodeSnippet)iService.getDEModel().createEntity();
            pSDCCodeSnippet.set("PSDCCODESNIPPETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCodeSnippet);
            } else {
                iService.get(pSDCCodeSnippet);
            }
            this.onFillParentInfo_PSDCCodeSnippet(pSDevSlnPipeline, pSDCCodeSnippet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINE_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDCDeployCenter pSDCDeployCenter = (PSDCDeployCenter)iService.getDEModel().createEntity();
            pSDCDeployCenter.set("PSDCDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCDeployCenter);
            } else {
                iService.get(pSDCDeployCenter);
            }
            this.onFillParentInfo_PSDCDeployCenter(pSDevSlnPipeline, pSDCDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINE_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnPipeline, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINE_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnPipeline, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINE_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnPipeline, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDevSlnPipeline, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCCodeSnippet(PSDevSlnPipeline pSDevSlnPipeline, PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        pSDevSlnPipeline.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
        pSDevSlnPipeline.setPSDCCodeSnippetName(pSDCCodeSnippet.getPSDCCodeSnippetName());
    }

    protected void onFillParentInfo_PSDCDeployCenter(PSDevSlnPipeline pSDevSlnPipeline, PSDCDeployCenter pSDCDeployCenter) throws Exception {
        pSDevSlnPipeline.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
        pSDevSlnPipeline.setPSDCDeployCenterName(pSDCDeployCenter.getPSDCDeployCenterName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDevSlnPipeline pSDevSlnPipeline, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnPipeline.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnPipeline.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnPipeline pSDevSlnPipeline, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnPipeline.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnPipeline.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnPipeline pSDevSlnPipeline, PSDevSln pSDevSln) throws Exception {
        pSDevSlnPipeline.setPSDevCenterId(pSDevSln.getPSDevCenterId());
        pSDevSlnPipeline.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnPipeline.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnPipeline.getCodeName() == null) {
                pSDevSlnPipeline.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Pipeline", 25));
            }
            if (pSDevSlnPipeline.getMajorFlag() == null) {
                pSDevSlnPipeline.setMajorFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDevSlnPipeline.getPipelineType() == null) {
                pSDevSlnPipeline.setPipelineType((String)this.getDefaultValue(this.getWebContext(), "", "NORMAL", 25));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnPipeline, bl);
        this.onFillEntityFullInfo_PSDCCodeSnippet(pSDevSlnPipeline, bl);
        this.onFillEntityFullInfo_PSDCDeployCenter(pSDevSlnPipeline, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDevSlnPipeline, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnPipeline, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnPipeline, bl);
    }

    protected void onFillEntityFullInfo_PSDCCodeSnippet(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCDeployCenter(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
        if (pSDevSlnPipeline.isPSDCDeployCenterIdDirty()) {
            if (pSDevSlnPipeline.getPSDCDeployCenterId() != null) {
                if (pSDevSlnPipeline.getPSDCDeployCenterId() == null || pSDevSlnPipeline.getPSDCDeployCenterName() == null) {
                    PSDCDeployCenter pSDCDeployCenter = pSDevSlnPipeline.getPSDCDeployCenter();
                    pSDevSlnPipeline.setPSDCDeployCenterName(pSDCDeployCenter.getPSDCDeployCenterName());
                }
            } else {
                pSDevSlnPipeline.setPSDCDeployCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnPipeline, bl);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, "", -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, string, -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipeline> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipeline> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipeline> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipeline> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnPipeline> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCODESNIPPET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCCodeSnippet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINE_PSDCCODESNIPPET_PSDCCODESNIPPETID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINE", iDataEntityModel.getDataInfo(pSDCCodeSnippet), arrayList.get(0)));
        }
    }

    public void resetPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            PSDevSlnPipeline pSDevSlnPipeline2 = (PSDevSlnPipeline)this.getDEModel().createEntity();
            pSDevSlnPipeline2.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
            pSDevSlnPipeline2.setPSDCCodeSnippetId(null);
            this.update(pSDevSlnPipeline2);
        }
    }

    public void removeByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineServiceBase.this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDevSlnPipelineServiceBase.this.internalRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDevSlnPipelineServiceBase.this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void internalRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            this.remove(pSDevSlnPipeline);
        }
        this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    public void testRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINE_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINE", iDataEntityModel.getDataInfo(pSDCDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            PSDevSlnPipeline pSDevSlnPipeline2 = (PSDevSlnPipeline)this.getDEModel().createEntity();
            pSDevSlnPipeline2.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
            pSDevSlnPipeline2.setPSDCDeployCenterId(null);
            this.update(pSDevSlnPipeline2);
        }
    }

    public void removeByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        final PSDCDeployCenter pSDCDeployCenter2 = pSDCDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineServiceBase.this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDevSlnPipelineServiceBase.this.internalRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDevSlnPipelineServiceBase.this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            this.remove(pSDevSlnPipeline);
        }
        this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINE_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINE", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            PSDevSlnPipeline pSDevSlnPipeline2 = (PSDevSlnPipeline)this.getDEModel().createEntity();
            pSDevSlnPipeline2.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
            pSDevSlnPipeline2.setPSDevCenterSVNId(null);
            this.update(pSDevSlnPipeline2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnPipelineServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            this.remove(pSDevSlnPipeline);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            PSDevSlnPipeline pSDevSlnPipeline2 = (PSDevSlnPipeline)this.getDEModel().createEntity();
            pSDevSlnPipeline2.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
            pSDevSlnPipeline2.setPSDevSlnSysId(null);
            this.update(pSDevSlnPipeline2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnPipelineServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnPipelineServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            this.remove(pSDevSlnPipeline);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            PSDevSlnPipeline pSDevSlnPipeline2 = (PSDevSlnPipeline)this.getDEModel().createEntity();
            pSDevSlnPipeline2.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
            pSDevSlnPipeline2.setPSDevSlnId(null);
            this.update(pSDevSlnPipeline2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnPipelineServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnPipelineServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnPipeline> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnPipeline pSDevSlnPipeline : arrayList) {
            this.remove(pSDevSlnPipeline);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnPipeline> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnPipelineRefService)ServiceGlobal.getService(PSDevSlnPipelineRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnPipeline(pSDevSlnPipeline);
        ((PSDevSlnPipelineRefServiceBase)pSCoreSysServiceBase).removeByPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnPipelineRefService)ServiceGlobal.getService(PSDevSlnPipelineRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStageServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnPipeline(pSDevSlnPipeline);
        ((PSDevSlnPipelineStageServiceBase)pSCoreSysServiceBase).removeByPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnPipeline(pSDevSlnPipeline);
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).removeByPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDevSlnPipeline(pSDevSlnPipeline);
        super.onBeforeRemove(pSDevSlnPipeline);
    }

    protected void onBeforeRemoveTemp(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).removeTempByPSDevSlnPipeline(pSDevSlnPipeline);
        pSCoreSysServiceBase = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStageServiceBase)pSCoreSysServiceBase).removeTempByPSDevSlnPipeline(pSDevSlnPipeline);
        super.onBeforeRemoveTemp(pSDevSlnPipeline);
    }

    protected void getRelatedDataTempMajor(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        this.getRelatedDataTempMajor_PSDevSlnPipelineStage(pSDevSlnPipeline);
        this.getRelatedDataTempMajor_PSDevSlnPipelineStep(pSDevSlnPipeline);
        super.getRelatedDataTempMajor(pSDevSlnPipeline);
    }

    protected void getRelatedDataTempMajor_PSDevSlnPipelineStage(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        PSDevSlnPipelineStageService pSDevSlnPipelineStageService = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnPipelineStage> arrayList = null;
        String string = pSDevSlnPipeline.getPSDevSlnPipelineId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDevSlnPipelineStageService.selectByPSDevSlnPipeline(pSDevSlnPipeline) : pSDevSlnPipelineStageService.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            pSDevSlnPipelineStageService.getTempMajor(pSDevSlnPipelineStage);
        }
    }

    protected void getRelatedDataTempMajor_PSDevSlnPipelineStep(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnPipelineStep> arrayList = null;
        String string = pSDevSlnPipeline.getPSDevSlnPipelineId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDevSlnPipelineStepService.selectByPSDevSlnPipeline(pSDevSlnPipeline) : pSDevSlnPipelineStepService.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            pSDevSlnPipelineStepService.getTempMajor(pSDevSlnPipelineStep);
        }
    }

    protected void updateRelatedDataTempMajor(PSDevSlnPipeline pSDevSlnPipeline, PSDevSlnPipeline pSDevSlnPipeline2) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList = this.updateRelatedDataTempMajor_removePSDevSlnPipelineStep(pSDevSlnPipeline, pSDevSlnPipeline2);
        ArrayList<PSDevSlnPipelineStage> arrayList2 = this.updateRelatedDataTempMajor_removePSDevSlnPipelineStage(pSDevSlnPipeline, pSDevSlnPipeline2);
        this.updateRelatedDataTempMajor_updatePSDevSlnPipelineStage(pSDevSlnPipeline, pSDevSlnPipeline2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDevSlnPipelineStep(pSDevSlnPipeline, pSDevSlnPipeline2, arrayList);
        super.updateRelatedDataTempMajor(pSDevSlnPipeline, pSDevSlnPipeline2);
    }

    protected ArrayList<PSDevSlnPipelineStage> updateRelatedDataTempMajor_removePSDevSlnPipelineStage(PSDevSlnPipeline pSDevSlnPipeline, PSDevSlnPipeline pSDevSlnPipeline2) throws Exception {
        PSDevSlnPipelineStageService pSDevSlnPipelineStageService = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnPipelineStage> arrayList = pSDevSlnPipelineStageService.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        ArrayList<PSDevSlnPipelineStage> arrayList2 = pSDevSlnPipelineStageService.selectByPSDevSlnPipeline(pSDevSlnPipeline2);
        HashMap<String, PSDevSlnPipelineStage> hashMap = new HashMap<String, PSDevSlnPipelineStage>();
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList2) {
            hashMap.put(pSDevSlnPipelineStage.getPSDevSlnPipelineStageId(), pSDevSlnPipelineStage);
        }
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            Object object = pSDevSlnPipelineStage.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : hashMap.values()) {
            pSDevSlnPipelineStageService.remove(pSDevSlnPipelineStage);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDevSlnPipelineStage(PSDevSlnPipeline pSDevSlnPipeline, PSDevSlnPipeline pSDevSlnPipeline2, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDevSlnPipelineStageService pSDevSlnPipelineStageService = (PSDevSlnPipelineStageService)ServiceGlobal.getService(PSDevSlnPipelineStageService.class, (SessionFactory)this.getSessionFactory());
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            pSDevSlnPipelineStageService.updateTempMajor(pSDevSlnPipelineStage);
        }
    }

    protected ArrayList<PSDevSlnPipelineStep> updateRelatedDataTempMajor_removePSDevSlnPipelineStep(PSDevSlnPipeline pSDevSlnPipeline, PSDevSlnPipeline pSDevSlnPipeline2) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnPipelineStep> arrayList = pSDevSlnPipelineStepService.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        ArrayList<PSDevSlnPipelineStep> arrayList2 = pSDevSlnPipelineStepService.selectByPSDevSlnPipeline(pSDevSlnPipeline2);
        HashMap<String, PSDevSlnPipelineStep> hashMap = new HashMap<String, PSDevSlnPipelineStep>();
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList2) {
            hashMap.put(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId(), pSDevSlnPipelineStep);
        }
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            Object object = pSDevSlnPipelineStep.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : hashMap.values()) {
            pSDevSlnPipelineStepService.remove(pSDevSlnPipelineStep);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDevSlnPipelineStep(PSDevSlnPipeline pSDevSlnPipeline, PSDevSlnPipeline pSDevSlnPipeline2, ArrayList<PSDevSlnPipelineStep> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
            pSDevSlnPipelineStepService.updateTempMajor(pSDevSlnPipelineStep);
        }
    }

    protected void replaceParentInfo(PSDevSlnPipeline pSDevSlnPipeline, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnPipeline, cloneSession);
        if (pSDevSlnPipeline.getPSDCCodeSnippetId() != null && (iEntity = cloneSession.getEntity("PSDCCODESNIPPET", (Object)pSDevSlnPipeline.getPSDCCodeSnippetId())) != null) {
            this.onFillParentInfo_PSDCCodeSnippet(pSDevSlnPipeline, (PSDCCodeSnippet)iEntity);
        }
        if (pSDevSlnPipeline.getPSDCDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDCDEPLOYCENTER", (Object)pSDevSlnPipeline.getPSDCDeployCenterId())) != null) {
            this.onFillParentInfo_PSDCDeployCenter(pSDevSlnPipeline, (PSDCDeployCenter)iEntity);
        }
        if (pSDevSlnPipeline.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnPipeline.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnPipeline, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnPipeline.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnPipeline.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnPipeline, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnPipeline.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnPipeline.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnPipeline, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnPipeline, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AgentTags(bl, pSDevSlnPipeline, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorFlag(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Model(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PipelineModel(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PipelineParams(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PipelineTag(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PipelineTag2(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PipelineTag3(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PipelineTag4(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PipelineType(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetId(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterId(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterName(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineName(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TriggerParams(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TriggerType(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnPipeline, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnPipeline, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AgentTags(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isAgentTagsDirty() : !pSDevSlnPipeline.isAgentTagsDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getAgentTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentTags_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTTAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isCodeNameDirty() && !bl2 : !pSDevSlnPipeline.isCodeNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDevSlnPipeline, bl2, bl3);
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
                string3 = "PSDEVSLNID";
                string3 = string3 + ";";
                string3 = string3 + "PSDEVSLNSYSID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnPipelineDEModel(), "CODENAME", string3, pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isCustomCodeDirty() : !pSDevSlnPipeline.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_MajorFlag(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isMajorFlagDirty() : !pSDevSlnPipeline.isMajorFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipeline.getMajorFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MajorFlag_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isMemoDirty() : !pSDevSlnPipeline.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_Model(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isModelDirty() : !pSDevSlnPipeline.isModelDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Model_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PipelineModel(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPipelineModelDirty() : !pSDevSlnPipeline.isPipelineModelDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPipelineModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PipelineModel_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINEMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PipelineParams(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPipelineParamsDirty() : !pSDevSlnPipeline.isPipelineParamsDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPipelineParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PipelineParams_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PipelineTag(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPipelineTagDirty() : !pSDevSlnPipeline.isPipelineTagDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPipelineTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PipelineTag_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PipelineTag2(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPipelineTag2Dirty() : !pSDevSlnPipeline.isPipelineTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPipelineTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PipelineTag2_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PipelineTag3(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPipelineTag3Dirty() : !pSDevSlnPipeline.isPipelineTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPipelineTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PipelineTag3_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINETAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PipelineTag4(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPipelineTag4Dirty() : !pSDevSlnPipeline.isPipelineTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPipelineTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PipelineTag4_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINETAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PipelineType(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPipelineTypeDirty() && !bl2 : !pSDevSlnPipeline.isPipelineTypeDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPipelineType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PipelineType_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PIPELINETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCodeSnippetId(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDCCodeSnippetIdDirty() : !pSDevSlnPipeline.isPSDCCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDCCodeSnippetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetId_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDeployCenterId(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDCDeployCenterIdDirty() : !pSDevSlnPipeline.isPSDCDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDCDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterId_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDeployCenterName(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDCDeployCenterNameDirty() : !pSDevSlnPipeline.isPSDCDeployCenterNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDCDeployCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterName_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDevCenterSVNIdDirty() : !pSDevSlnPipeline.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDevSlnIdDirty() && !bl2 : !pSDevSlnPipeline.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDevSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDevSlnPipelineIdDirty() && !bl2 : !pSDevSlnPipeline.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineName(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDevSlnPipelineNameDirty() && !bl2 : !pSDevSlnPipeline.isPSDevSlnPipelineNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDevSlnPipelineName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineName_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isPSDevSlnSysIdDirty() : !pSDevSlnPipeline.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isTemplateModeDirty() : !pSDevSlnPipeline.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipeline.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_TriggerParams(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isTriggerParamsDirty() : !pSDevSlnPipeline.isTriggerParamsDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getTriggerParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TriggerParams_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TriggerType(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isTriggerTypeDirty() : !pSDevSlnPipeline.isTriggerTypeDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getTriggerType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TriggerType_Default(pSDevSlnPipeline, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRIGGERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isUserCatDirty() : !pSDevSlnPipeline.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isUserTagDirty() : !pSDevSlnPipeline.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isUserTag2Dirty() : !pSDevSlnPipeline.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isUserTag3Dirty() : !pSDevSlnPipeline.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnPipeline pSDevSlnPipeline, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipeline.isUserTag4Dirty() : !pSDevSlnPipeline.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnPipeline.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDevSlnPipeline, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnPipeline, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnPipeline, bl);
    }

    public Object getDataContextValue(PSDevSlnPipeline pSDevSlnPipeline, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnPipeline, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnPipeline, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGENTTAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentTags_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Model_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PIPELINEMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PipelineModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PIPELINEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PipelineParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PIPELINETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PipelineTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PIPELINETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PipelineTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PIPELINETAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PipelineTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PIPELINETAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PipelineTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PIPELINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PipelineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRIGGERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TriggerParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRIGGERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TriggerType_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AgentTags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTTAGS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_MajorFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Model_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PipelineModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PIPELINEMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PipelineParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PIPELINEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PipelineTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PIPELINETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PipelineTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PIPELINETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PipelineTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PIPELINETAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PipelineTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PIPELINETAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PipelineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PIPELINETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TriggerParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRIGGERPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TriggerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRIGGERTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnPipeline)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        super.onUpdateParent(pSDevSlnPipeline);
    }

    protected void onCopyDetails(PSDevSlnPipeline pSDevSlnPipeline, Object object) throws Exception {
        PSDevSlnPipeline pSDevSlnPipeline2 = new PSDevSlnPipeline();
        pSDevSlnPipeline2.set("PSDEVSLNPIPELINEID", object);
        String string = DataObject.getStringValue((Object)pSDevSlnPipeline.get("PSDEVSLNPIPELINEID"));
        super.onCopyDetails(pSDevSlnPipeline, object);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnPipeline pSDevSlnPipeline, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNPIPELINE");
        if (!bl) {
            pSDevSlnPipeline.setCreateDate(null);
            pSDevSlnPipeline.setCreateMan(null);
            pSDevSlnPipeline.setPSDevSlnPipelineId(null);
            pSDevSlnPipeline.setUpdateDate(null);
            pSDevSlnPipeline.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnPipeline, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDevSlnPipeline pSDevSlnPipeline, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDevSlnPipelineStep(pSDevSlnPipeline, xmlNode);
        super.onExportRelatedXmlModel(pSDevSlnPipeline, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDevSlnPipelineStep(PSDevSlnPipeline pSDevSlnPipeline, XmlNode xmlNode) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnPipelineStep> arrayList = null;
        String string = pSDevSlnPipeline.getPSDevSlnPipelineId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDevSlnPipelineStepService.selectByPSDevSlnPipeline(pSDevSlnPipeline, "ORDER BY ORDERVALUE ASC") : pSDevSlnPipelineStepService.selectTempByPSDevSlnPipeline(pSDevSlnPipeline, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEVSLNPIPELINESTEPS");
            xmlNode.addNode(xmlNode2);
            for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
                pSDevSlnPipelineStep.set("ORDERVALUE", null);
                pSDevSlnPipelineStepService.exportXmlModel(pSDevSlnPipelineStep, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDevSlnPipeline pSDevSlnPipeline, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEVSLNPIPELINESTEPS");
        this.importRelatedXmlModel_PSDevSlnPipelineStep(pSDevSlnPipeline, xmlNode2);
        super.onImportRelatedXmlModel(pSDevSlnPipeline, xmlNode);
    }

    protected void importRelatedXmlModel_PSDevSlnPipelineStep(PSDevSlnPipeline pSDevSlnPipeline, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDevSlnPipeline.getPSDevSlnPipelineId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDevSlnPipelineStepService.removeByPSDevSlnPipeline(pSDevSlnPipeline);
        } else {
            pSDevSlnPipelineStepService.removeTempByPSDevSlnPipeline(pSDevSlnPipeline);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDevSlnPipelineStep pSDevSlnPipelineStep = new PSDevSlnPipelineStep();
                pSDevSlnPipelineStep.setOrderValue(n);
                n += 100;
                pSDevSlnPipelineStepService.fillParentInfo(pSDevSlnPipelineStep, "DER1N", "DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", pSDevSlnPipeline.getPSDevSlnPipelineId());
                pSDevSlnPipelineStepService.importXmlModel(pSDevSlnPipelineStep, xmlNode2);
            }
        }
    }

    @Override
    public Object getDataType(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        return pSDevSlnPipeline.getPipelineType();
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDevSlnPipeline pSDevSlnPipeline, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Pipeline");
    }
}

