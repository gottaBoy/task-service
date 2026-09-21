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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineLogDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineLogDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineLogBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineRefBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStepBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineLogServiceBase
extends PSCoreSysServiceBase<PSDevSlnPipelineLog> {
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnPipelineLogDEModel pSDevSlnPipelineLogDEModel;
    private PSDevSlnPipelineLogDAO pSDevSlnPipelineLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineLogService";
    }

    public PSDevSlnPipelineLogDEModel getPSDevSlnPipelineLogDEModel() {
        if (this.pSDevSlnPipelineLogDEModel == null) {
            try {
                this.pSDevSlnPipelineLogDEModel = (PSDevSlnPipelineLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineLogDEModel();
    }

    public PSDevSlnPipelineLogDAO getPSDevSlnPipelineLogDAO() {
        if (this.pSDevSlnPipelineLogDAO == null) {
            try {
                this.pSDevSlnPipelineLogDAO = (PSDevSlnPipelineLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnPipelineLogDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnPipelineLog pSDevSlnPipelineLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINELOG_PSDEVSLNPIPELINELOG_PPSDEVSLNPIPELINELOGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineLogService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipelineLog pSDevSlnPipelineLog2 = (PSDevSlnPipelineLog)iService.getDEModel().createEntity();
            pSDevSlnPipelineLog2.set("PSDEVSLNPIPELINELOGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipelineLog2);
            } else {
                iService.get((IEntity)pSDevSlnPipelineLog2);
            }
            this.onFillParentInfo_PPSDevSlnPipelineLog(pSDevSlnPipelineLog, pSDevSlnPipelineLog2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINELOG_PSDEVSLNPIPELINEREF_PSDEVSLNPIPELINEREFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineRefService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipelineRef pSDevSlnPipelineRef = (PSDevSlnPipelineRef)iService.getDEModel().createEntity();
            pSDevSlnPipelineRef.set("PSDEVSLNPIPELINEREFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipelineRef);
            } else {
                iService.get((IEntity)pSDevSlnPipelineRef);
            }
            this.onFillParentInfo_PSDevSlnPipelineRef(pSDevSlnPipelineLog, pSDevSlnPipelineRef);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINELOG_PSDEVSLNPIPELINESTAGE_PSDEVSLNPIPELINESTAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipelineStage pSDevSlnPipelineStage = (PSDevSlnPipelineStage)iService.getDEModel().createEntity();
            pSDevSlnPipelineStage.set("PSDEVSLNPIPELINESTAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipelineStage);
            } else {
                iService.get((IEntity)pSDevSlnPipelineStage);
            }
            this.onFillParentInfo_PSDevSlnPipelineStage(pSDevSlnPipelineLog, pSDevSlnPipelineStage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINELOG_PSDEVSLNPIPELINESTEP_PSDEVSLNPIPELINESTEPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipelineStep pSDevSlnPipelineStep = (PSDevSlnPipelineStep)iService.getDEModel().createEntity();
            pSDevSlnPipelineStep.set("PSDEVSLNPIPELINESTEPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipelineStep);
            } else {
                iService.get((IEntity)pSDevSlnPipelineStep);
            }
            this.onFillParentInfo_PSDevSlnPipelineStep(pSDevSlnPipelineLog, pSDevSlnPipelineStep);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINELOG_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnPipeline);
            } else {
                iService.get((IEntity)pSDevSlnPipeline);
            }
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineLog, pSDevSlnPipeline);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINELOG_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnPipelineLog, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINELOG_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnPipelineLog, pSDevSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnPipelineLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog, PSDevSlnPipelineLog pSDevSlnPipelineLog2) throws Exception {
        pSDevSlnPipelineLog.setPPSDevSlnPipelineLogId(pSDevSlnPipelineLog2.getPSDevSlnPipelineLogId());
        pSDevSlnPipelineLog.setPPSDevSlnPipelineLogName(pSDevSlnPipelineLog2.getPSDevSlnPipelineLogName());
    }

    protected void onFillParentInfo_PSDevSlnPipelineRef(PSDevSlnPipelineLog pSDevSlnPipelineLog, PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
        pSDevSlnPipelineLog.setPSDevSlnPipelineRefId(pSDevSlnPipelineRef.getPSDevSlnPipelineRefId());
        pSDevSlnPipelineLog.setPSDevSlnPipelineRefName(pSDevSlnPipelineRef.getPSDevSlnPipelineRefName());
    }

    protected void onFillParentInfo_PSDevSlnPipelineStage(PSDevSlnPipelineLog pSDevSlnPipelineLog, PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        pSDevSlnPipelineLog.setPSDevSlnPipelineStageId(pSDevSlnPipelineStage.getPSDevSlnPipelineStageId());
        pSDevSlnPipelineLog.setPSDevSlnPipelineStageName(pSDevSlnPipelineStage.getPSDevSlnPipelineStageName());
    }

    protected void onFillParentInfo_PSDevSlnPipelineStep(PSDevSlnPipelineLog pSDevSlnPipelineLog, PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        pSDevSlnPipelineLog.setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
        pSDevSlnPipelineLog.setPSDevSlnPipelineStepName(pSDevSlnPipelineStep.getPSDevSlnPipelineStepName());
    }

    protected void onFillParentInfo_PSDevSlnPipeline(PSDevSlnPipelineLog pSDevSlnPipelineLog, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnPipelineLog.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnPipelineLog.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnPipelineLog pSDevSlnPipelineLog, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnPipelineLog.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnPipelineLog.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnPipelineLog pSDevSlnPipelineLog, PSDevSln pSDevSln) throws Exception {
        pSDevSlnPipelineLog.setPSDevCenterId(pSDevSln.getPSDevCenterId());
        pSDevSlnPipelineLog.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnPipelineLog.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnPipelineLog, bl);
        this.onFillEntityFullInfo_PPSDevSlnPipelineLog(pSDevSlnPipelineLog, bl);
        this.onFillEntityFullInfo_PSDevSlnPipelineRef(pSDevSlnPipelineLog, bl);
        this.onFillEntityFullInfo_PSDevSlnPipelineStage(pSDevSlnPipelineLog, bl);
        this.onFillEntityFullInfo_PSDevSlnPipelineStep(pSDevSlnPipelineLog, bl);
        this.onFillEntityFullInfo_PSDevSlnPipeline(pSDevSlnPipelineLog, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnPipelineLog, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnPipelineLog, bl);
    }

    protected void onFillEntityFullInfo_PPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        if (pSDevSlnPipelineLog.isPPSDevSlnPipelineLogIdDirty()) {
            if (pSDevSlnPipelineLog.getPPSDevSlnPipelineLogId() != null) {
                if (pSDevSlnPipelineLog.getPPSDevSlnPipelineLogId() == null || pSDevSlnPipelineLog.getPPSDevSlnPipelineLogName() == null) {
                    PSDevSlnPipelineLog pSDevSlnPipelineLog2 = pSDevSlnPipelineLog.getPPSDevSlnPipelineLog();
                    pSDevSlnPipelineLog.setPPSDevSlnPipelineLogName(pSDevSlnPipelineLog2.getPSDevSlnPipelineLogName());
                }
            } else {
                pSDevSlnPipelineLog.setPPSDevSlnPipelineLogName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnPipelineRef(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        if (pSDevSlnPipelineLog.isPSDevSlnPipelineRefIdDirty()) {
            if (pSDevSlnPipelineLog.getPSDevSlnPipelineRefId() != null) {
                if (pSDevSlnPipelineLog.getPSDevSlnPipelineRefId() == null || pSDevSlnPipelineLog.getPSDevSlnPipelineRefName() == null) {
                    PSDevSlnPipelineRef pSDevSlnPipelineRef = pSDevSlnPipelineLog.getPSDevSlnPipelineRef();
                    pSDevSlnPipelineLog.setPSDevSlnPipelineRefName(pSDevSlnPipelineRef.getPSDevSlnPipelineRefName());
                }
            } else {
                pSDevSlnPipelineLog.setPSDevSlnPipelineRefName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnPipelineStage(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        if (pSDevSlnPipelineLog.isPSDevSlnPipelineStageIdDirty()) {
            if (pSDevSlnPipelineLog.getPSDevSlnPipelineStageId() != null) {
                if (pSDevSlnPipelineLog.getPSDevSlnPipelineStageId() == null || pSDevSlnPipelineLog.getPSDevSlnPipelineStageName() == null) {
                    PSDevSlnPipelineStage pSDevSlnPipelineStage = pSDevSlnPipelineLog.getPSDevSlnPipelineStage();
                    pSDevSlnPipelineLog.setPSDevSlnPipelineStageName(pSDevSlnPipelineStage.getPSDevSlnPipelineStageName());
                }
            } else {
                pSDevSlnPipelineLog.setPSDevSlnPipelineStageName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnPipelineStep(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        if (pSDevSlnPipelineLog.isPSDevSlnPipelineStepIdDirty()) {
            if (pSDevSlnPipelineLog.getPSDevSlnPipelineStepId() != null) {
                if (pSDevSlnPipelineLog.getPSDevSlnPipelineStepId() == null || pSDevSlnPipelineLog.getPSDevSlnPipelineStepName() == null) {
                    PSDevSlnPipelineStep pSDevSlnPipelineStep = pSDevSlnPipelineLog.getPSDevSlnPipelineStep();
                    pSDevSlnPipelineLog.setPSDevSlnPipelineStepName(pSDevSlnPipelineStep.getPSDevSlnPipelineStepName());
                }
            } else {
                pSDevSlnPipelineLog.setPSDevSlnPipelineStepName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnPipeline(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        if (pSDevSlnPipelineLog.isPSDevSlnPipelineIdDirty()) {
            if (pSDevSlnPipelineLog.getPSDevSlnPipelineId() != null) {
                if (pSDevSlnPipelineLog.getPSDevSlnPipelineId() == null || pSDevSlnPipelineLog.getPSDevSlnPipelineName() == null) {
                    PSDevSlnPipeline pSDevSlnPipeline = pSDevSlnPipelineLog.getPSDevSlnPipeline();
                    pSDevSlnPipelineLog.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
                }
            } else {
                pSDevSlnPipelineLog.setPSDevSlnPipelineName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        if (pSDevSlnPipelineLog.isPSDevSlnSysIdDirty()) {
            if (pSDevSlnPipelineLog.getPSDevSlnSysId() != null) {
                if (pSDevSlnPipelineLog.getPSDevSlnSysId() == null || pSDevSlnPipelineLog.getPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSDevSlnPipelineLog.getPSDevSlnSys();
                    pSDevSlnPipelineLog.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSDevSlnPipelineLog.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnPipelineLog, bl);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPPSDevSlnPipelineLog(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase) throws Exception {
        return this.selectByPPSDevSlnPipelineLog(pSDevSlnPipelineLogBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPPSDevSlnPipelineLog(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, String string) throws Exception {
        return this.selectByPPSDevSlnPipelineLog(pSDevSlnPipelineLogBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPPSDevSlnPipelineLog(PSDevSlnPipelineLogBase pSDevSlnPipelineLogBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVSLNPIPELINELOGID", (Object)pSDevSlnPipelineLogBase.getPSDevSlnPipelineLogId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevSlnPipelineLogCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevSlnPipelineLogCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineRef(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase) throws Exception {
        return this.selectByPSDevSlnPipelineRef(pSDevSlnPipelineRefBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineRef(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, String string) throws Exception {
        return this.selectByPSDevSlnPipelineRef(pSDevSlnPipelineRefBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineRef(PSDevSlnPipelineRefBase pSDevSlnPipelineRefBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINEREFID", (Object)pSDevSlnPipelineRefBase.getPSDevSlnPipelineRefId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnPipelineRefCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnPipelineRefCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase) throws Exception {
        return this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStageBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, String string) throws Exception {
        return this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStageBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineStage(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineStep(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase) throws Exception {
        return this.selectByPSDevSlnPipelineStep(pSDevSlnPipelineStepBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineStep(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, String string) throws Exception {
        return this.selectByPSDevSlnPipelineStep(pSDevSlnPipelineStepBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipelineStep(PSDevSlnPipelineStepBase pSDevSlnPipelineStepBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINESTEPID", (Object)pSDevSlnPipelineStepBase.getPSDevSlnPipelineStepId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnPipelineStepCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnPipelineStepCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineLog> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
    }

    public void resetPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPPSDevSlnPipelineLog(pSDevSlnPipelineLog);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog2 : arrayList) {
            PSDevSlnPipelineLog pSDevSlnPipelineLog3 = (PSDevSlnPipelineLog)this.getDEModel().createEntity();
            pSDevSlnPipelineLog3.setPSDevSlnPipelineLogId(pSDevSlnPipelineLog2.getPSDevSlnPipelineLogId());
            pSDevSlnPipelineLog3.setPPSDevSlnPipelineLogId(null);
            this.update(pSDevSlnPipelineLog3);
        }
    }

    public void removeByPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
        final PSDevSlnPipelineLog pSDevSlnPipelineLog2 = pSDevSlnPipelineLog;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineLogServiceBase.this.onBeforeRemoveByPPSDevSlnPipelineLog(pSDevSlnPipelineLog2);
                PSDevSlnPipelineLogServiceBase.this.internalRemoveByPPSDevSlnPipelineLog(pSDevSlnPipelineLog2);
                PSDevSlnPipelineLogServiceBase.this.onAfterRemoveByPPSDevSlnPipelineLog(pSDevSlnPipelineLog2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
    }

    protected void internalRemoveByPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPPSDevSlnPipelineLog(pSDevSlnPipelineLog);
        this.onBeforeRemoveByPPSDevSlnPipelineLog(pSDevSlnPipelineLog, arrayList);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog2 : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineLog2);
        }
        this.onAfterRemoveByPPSDevSlnPipelineLog(pSDevSlnPipelineLog, arrayList);
    }

    protected void onAfterRemoveByPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevSlnPipelineLog(PSDevSlnPipelineLog pSDevSlnPipelineLog, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
    }

    public void resetPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipelineRef(pSDevSlnPipelineRef);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            PSDevSlnPipelineLog pSDevSlnPipelineLog2 = (PSDevSlnPipelineLog)this.getDEModel().createEntity();
            pSDevSlnPipelineLog2.setPSDevSlnPipelineLogId(pSDevSlnPipelineLog.getPSDevSlnPipelineLogId());
            pSDevSlnPipelineLog2.setPSDevSlnPipelineRefId(null);
            this.update(pSDevSlnPipelineLog2);
        }
    }

    public void removeByPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
        final PSDevSlnPipelineRef pSDevSlnPipelineRef2 = pSDevSlnPipelineRef;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineLogServiceBase.this.onBeforeRemoveByPSDevSlnPipelineRef(pSDevSlnPipelineRef2);
                PSDevSlnPipelineLogServiceBase.this.internalRemoveByPSDevSlnPipelineRef(pSDevSlnPipelineRef2);
                PSDevSlnPipelineLogServiceBase.this.onAfterRemoveByPSDevSlnPipelineRef(pSDevSlnPipelineRef2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipelineRef(pSDevSlnPipelineRef);
        this.onBeforeRemoveByPSDevSlnPipelineRef(pSDevSlnPipelineRef, arrayList);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineLog);
        }
        this.onAfterRemoveByPSDevSlnPipelineRef(pSDevSlnPipelineRef, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipelineRef(PSDevSlnPipelineRef pSDevSlnPipelineRef, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    public void resetPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            PSDevSlnPipelineLog pSDevSlnPipelineLog2 = (PSDevSlnPipelineLog)this.getDEModel().createEntity();
            pSDevSlnPipelineLog2.setPSDevSlnPipelineLogId(pSDevSlnPipelineLog.getPSDevSlnPipelineLogId());
            pSDevSlnPipelineLog2.setPSDevSlnPipelineStageId(null);
            this.update(pSDevSlnPipelineLog2);
        }
    }

    public void removeByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        final PSDevSlnPipelineStage pSDevSlnPipelineStage2 = pSDevSlnPipelineStage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineLogServiceBase.this.onBeforeRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
                PSDevSlnPipelineLogServiceBase.this.internalRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
                PSDevSlnPipelineLogServiceBase.this.onAfterRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        this.onBeforeRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage, arrayList);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineLog);
        }
        this.onAfterRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipelineStage(PSDevSlnPipelineStage pSDevSlnPipelineStage, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
    }

    public void resetPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipelineStep(pSDevSlnPipelineStep);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            PSDevSlnPipelineLog pSDevSlnPipelineLog2 = (PSDevSlnPipelineLog)this.getDEModel().createEntity();
            pSDevSlnPipelineLog2.setPSDevSlnPipelineLogId(pSDevSlnPipelineLog.getPSDevSlnPipelineLogId());
            pSDevSlnPipelineLog2.setPSDevSlnPipelineStepId(null);
            this.update(pSDevSlnPipelineLog2);
        }
    }

    public void removeByPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        final PSDevSlnPipelineStep pSDevSlnPipelineStep2 = pSDevSlnPipelineStep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineLogServiceBase.this.onBeforeRemoveByPSDevSlnPipelineStep(pSDevSlnPipelineStep2);
                PSDevSlnPipelineLogServiceBase.this.internalRemoveByPSDevSlnPipelineStep(pSDevSlnPipelineStep2);
                PSDevSlnPipelineLogServiceBase.this.onAfterRemoveByPSDevSlnPipelineStep(pSDevSlnPipelineStep2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipelineStep(pSDevSlnPipelineStep);
        this.onBeforeRemoveByPSDevSlnPipelineStep(pSDevSlnPipelineStep, arrayList);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineLog);
        }
        this.onAfterRemoveByPSDevSlnPipelineStep(pSDevSlnPipelineStep, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipelineStep(PSDevSlnPipelineStep pSDevSlnPipelineStep, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    public void resetPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            PSDevSlnPipelineLog pSDevSlnPipelineLog2 = (PSDevSlnPipelineLog)this.getDEModel().createEntity();
            pSDevSlnPipelineLog2.setPSDevSlnPipelineLogId(pSDevSlnPipelineLog.getPSDevSlnPipelineLogId());
            pSDevSlnPipelineLog2.setPSDevSlnPipelineId(null);
            this.update(pSDevSlnPipelineLog2);
        }
    }

    public void removeByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineLogServiceBase.this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineLogServiceBase.this.internalRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineLogServiceBase.this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineLog);
        }
        this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            PSDevSlnPipelineLog pSDevSlnPipelineLog2 = (PSDevSlnPipelineLog)this.getDEModel().createEntity();
            pSDevSlnPipelineLog2.setPSDevSlnPipelineLogId(pSDevSlnPipelineLog.getPSDevSlnPipelineLogId());
            pSDevSlnPipelineLog2.setPSDevSlnSysId(null);
            this.update(pSDevSlnPipelineLog2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineLogServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnPipelineLogServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnPipelineLogServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineLog);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            PSDevSlnPipelineLog pSDevSlnPipelineLog2 = (PSDevSlnPipelineLog)this.getDEModel().createEntity();
            pSDevSlnPipelineLog2.setPSDevSlnPipelineLogId(pSDevSlnPipelineLog.getPSDevSlnPipelineLogId());
            pSDevSlnPipelineLog2.setPSDevSlnId(null);
            this.update(pSDevSlnPipelineLog2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineLogServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnPipelineLogServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnPipelineLogServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnPipelineLog> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnPipelineLog pSDevSlnPipelineLog : arrayList) {
            this.remove((IEntity)pSDevSlnPipelineLog);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnPipelineLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
        super.onBeforeRemove(pSDevSlnPipelineLog);
    }

    protected void replaceParentInfo(PSDevSlnPipelineLog pSDevSlnPipelineLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnPipelineLog, cloneSession);
        if (pSDevSlnPipelineLog.getPPSDevSlnPipelineLogId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINELOG", (Object)pSDevSlnPipelineLog.getPPSDevSlnPipelineLogId())) != null) {
            this.onFillParentInfo_PPSDevSlnPipelineLog(pSDevSlnPipelineLog, (PSDevSlnPipelineLog)iEntity);
        }
        if (pSDevSlnPipelineLog.getPSDevSlnPipelineRefId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINEREF", (Object)pSDevSlnPipelineLog.getPSDevSlnPipelineRefId())) != null) {
            this.onFillParentInfo_PSDevSlnPipelineRef(pSDevSlnPipelineLog, (PSDevSlnPipelineRef)iEntity);
        }
        if (pSDevSlnPipelineLog.getPSDevSlnPipelineStageId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINESTAGE", (Object)pSDevSlnPipelineLog.getPSDevSlnPipelineStageId())) != null) {
            this.onFillParentInfo_PSDevSlnPipelineStage(pSDevSlnPipelineLog, (PSDevSlnPipelineStage)iEntity);
        }
        if (pSDevSlnPipelineLog.getPSDevSlnPipelineStepId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINESTEP", (Object)pSDevSlnPipelineLog.getPSDevSlnPipelineStepId())) != null) {
            this.onFillParentInfo_PSDevSlnPipelineStep(pSDevSlnPipelineLog, (PSDevSlnPipelineStep)iEntity);
        }
        if (pSDevSlnPipelineLog.getPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnPipelineLog.getPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineLog, (PSDevSlnPipeline)iEntity);
        }
        if (pSDevSlnPipelineLog.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnPipelineLog.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnPipelineLog, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnPipelineLog.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnPipelineLog.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnPipelineLog, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnPipelineLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionParams(bl, pSDevSlnPipelineLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionResult(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionState(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginTime(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BuildNumber(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Duration(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnPipelineLogId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnPipelineLogName(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineLogId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineLogName(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineName(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineRefId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineRefName(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStageId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStageName(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStepId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStepName(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueueUrl(bl, pSDevSlnPipelineLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnPipelineLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionParams(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isActionParamsDirty() : !pSDevSlnPipelineLog.isActionParamsDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionParams_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_ActionResult(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isActionResultDirty() : !pSDevSlnPipelineLog.isActionResultDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getActionResult();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionResult_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONRESULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionState(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isActionStateDirty() && !bl2 : !pSDevSlnPipelineLog.isActionStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineLog.getActionState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ActionState_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isBeginTimeDirty() : !pSDevSlnPipelineLog.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnPipelineLog.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BuildNumber(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isBuildNumberDirty() : !pSDevSlnPipelineLog.isBuildNumberDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineLog.getBuildNumber();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BuildNumber_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUILDNUMBER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Duration(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isDurationDirty() : !pSDevSlnPipelineLog.isDurationDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineLog.getDuration();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Duration_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DURATION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isEndTimeDirty() : !pSDevSlnPipelineLog.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnPipelineLog.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnPipelineLogId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPPSDevSlnPipelineLogIdDirty() : !pSDevSlnPipelineLog.isPPSDevSlnPipelineLogIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPPSDevSlnPipelineLogId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnPipelineLogId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNPIPELINELOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnPipelineLogName(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPPSDevSlnPipelineLogNameDirty() : !pSDevSlnPipelineLog.isPPSDevSlnPipelineLogNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPPSDevSlnPipelineLogName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnPipelineLogName_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNPIPELINELOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnIdDirty() : !pSDevSlnPipelineLog.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineIdDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineLogId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineLogIdDirty() && !bl2 : !pSDevSlnPipelineLog.isPSDevSlnPipelineLogIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINELOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineLogId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINELOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineLogName(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineLogNameDirty() && !bl2 : !pSDevSlnPipelineLog.isPSDevSlnPipelineLogNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINELOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineLogName_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINELOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineName(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineNameDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineName_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineRefId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineRefIdDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineRefIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineRefId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineRefId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineRefName(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineRefNameDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineRefNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineRefName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineRefName_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineStageId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineStageIdDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineStageIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineStageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStageId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineStageName(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineStageNameDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineStageNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineStageName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStageName_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTAGENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineStepId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineStepIdDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineStepIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineStepId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStepId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnPipelineStepName(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnPipelineStepNameDirty() : !pSDevSlnPipelineLog.isPSDevSlnPipelineStepNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnPipelineStepName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStepName_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTEPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnSysIdDirty() : !pSDevSlnPipelineLog.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isPSDevSlnSysNameDirty() : !pSDevSlnPipelineLog.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueueUrl(boolean bl, PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineLog.isQueueUrlDirty() : !pSDevSlnPipelineLog.isQueueUrlDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineLog.getQueueUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueueUrl_Default((IEntity)pSDevSlnPipelineLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUEUEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnPipelineLog, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnPipelineLog pSDevSlnPipelineLog, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnPipelineLog, bl);
    }

    public Object getDataContextValue(PSDevSlnPipelineLog pSDevSlnPipelineLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnPipelineLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnPipelineLog pSDevSlnPipelineLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnPipelineLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONRESULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionResult_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUILDNUMBER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BuildNumber_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DURATION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Duration_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNPIPELINELOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnPipelineLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNPIPELINELOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnPipelineLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINELOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINELOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineRefName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUEUEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueueUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ActionResult_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONRESULT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BuildNumber_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Duration_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSDevSlnPipelineLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNPIPELINELOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSlnPipelineLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNPIPELINELOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnPipelineLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINELOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINELOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDevSlnPipelineRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINEREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINEREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_QueueUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUEUEURL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnPipelineLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnPipelineLog pSDevSlnPipelineLog) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnPipelineLog);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnPipelineLog pSDevSlnPipelineLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNPIPELINELOG");
        if (!bl) {
            pSDevSlnPipelineLog.setCreateDate(null);
            pSDevSlnPipelineLog.setCreateMan(null);
            pSDevSlnPipelineLog.setPSDevSlnPipelineLogId(null);
            pSDevSlnPipelineLog.setUpdateDate(null);
            pSDevSlnPipelineLog.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnPipelineLog, xmlNode, bl);
        }
    }
}

