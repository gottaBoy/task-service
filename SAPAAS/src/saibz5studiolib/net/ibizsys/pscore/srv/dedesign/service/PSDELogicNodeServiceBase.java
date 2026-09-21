/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgentBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactoryBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgentBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgentBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDSchemeBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTable;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTableBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBISchemeBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDELogicNodeDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicNodeDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDTSQueue;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDTSQueueBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSyncBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELNParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParamBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotifyBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrint;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrintBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReportBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUtilDE;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUtilDEBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkServiceBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAISchemeBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDocBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysBackService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysBackServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTableBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDELogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDELogicNodeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgentBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniStateBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDEBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELogicNodeServiceBase
extends PSCoreSysServiceBase<PSDELogicNode> {
    private static final Log log = LogFactory.getLog(PSDELogicNodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String DATASET_ULFORMTYPE = "ULFormType";
    private PSDELogicNodeDEModel pSDELogicNodeDEModel;
    private PSDELogicNodeDAO pSDELogicNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService";
    }

    public PSDELogicNodeDEModel getPSDELogicNodeDEModel() {
        if (this.pSDELogicNodeDEModel == null) {
            try {
                this.pSDELogicNodeDEModel = (PSDELogicNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDELogicNodeDEModel();
    }

    public PSDELogicNodeDAO getPSDELogicNodeDAO() {
        if (this.pSDELogicNodeDAO == null) {
            try {
                this.pSDELogicNodeDAO = (PSDELogicNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDELogicNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDELogicNodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_ULFORMTYPE, (boolean)true) == 0) {
            return this.fetchULFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_ULFORMTYPE, (boolean)true) == 0) {
            return this.fetchTempULFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
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

    public DBFetchResult fetchULFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ULFORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempULFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ULFORMTYPE, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDELogicNode pSDELogicNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDATAENTITY_DSTPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_DstPSDE(pSDELogicNode, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEACTION_DSTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_DstPSDEAction(pSDELogicNode, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEDATAEXP_DSTPSDEDATAEXPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService", (SessionFactory)this.getSessionFactory());
            PSDEDataExp pSDEDataExp = (PSDEDataExp)iService.getDEModel().createEntity();
            pSDEDataExp.set("PSDEDATAEXPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataExp);
            } else {
                iService.get((IEntity)pSDEDataExp);
            }
            this.onFillParentInfo_DstPSDEDataExp(pSDELogicNode, pSDEDataExp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEDATAIMP_DSTPSDEDATAIMPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService", (SessionFactory)this.getSessionFactory());
            PSDEDataImp pSDEDataImp = (PSDEDataImp)iService.getDEModel().createEntity();
            pSDEDataImp.set("PSDEDATAIMPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataImp);
            } else {
                iService.get((IEntity)pSDEDataImp);
            }
            this.onFillParentInfo_DstPSDEDataImp(pSDELogicNode, pSDEDataImp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEDATAQUERY_DSTPSDEDATAQUERYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_DstPSDEDataQuery(pSDELogicNode, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEDATASET_DSTPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_DstPSDEDataSet(pSDELogicNode, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEDATASYNC_DSTPSDEDATASYNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService", (SessionFactory)this.getSessionFactory());
            PSDEDataSync pSDEDataSync = (PSDEDataSync)iService.getDEModel().createEntity();
            pSDEDataSync.set("PSDEDATASYNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSync);
            } else {
                iService.get((IEntity)pSDEDataSync);
            }
            this.onFillParentInfo_DstPSDEDataSync(pSDELogicNode, pSDEDataSync);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEDTSQUEUE_DSTPSDEDTSQUEUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService", (SessionFactory)this.getSessionFactory());
            PSDEDTSQueue pSDEDTSQueue = (PSDEDTSQueue)iService.getDEModel().createEntity();
            pSDEDTSQueue.set("PSDEDTSQUEUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDTSQueue);
            } else {
                iService.get((IEntity)pSDEDTSQueue);
            }
            this.onFillParentInfo_DstPSDEDTSQueue(pSDELogicNode, pSDEDTSQueue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEFGROUP_DSTPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFGroup);
            } else {
                iService.get((IEntity)pSDEFGroup);
            }
            this.onFillParentInfo_DstPSDEFGroup(pSDELogicNode, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEFORM_DSTPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_DstPSDEForm(pSDELogicNode, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEFVALUERULE_DSTPSDEFVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFValueRule);
            } else {
                iService.get((IEntity)pSDEFValueRule);
            }
            this.onFillParentInfo_DstPSDEFValueRule(pSDELogicNode, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGICPARAM_DSTPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicParam);
            } else {
                iService.get((IEntity)pSDELogicParam);
            }
            this.onFillParentInfo_DstPSDLParam(pSDELogicNode, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGICPARAM_ISPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicParam);
            } else {
                iService.get((IEntity)pSDELogicParam);
            }
            this.onFillParentInfo_ISPSDLParam(pSDELogicNode, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGICPARAM_OPTPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicParam);
            } else {
                iService.get((IEntity)pSDELogicParam);
            }
            this.onFillParentInfo_OptPSDLParam(pSDELogicNode, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGICPARAM_OSPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicParam);
            } else {
                iService.get((IEntity)pSDELogicParam);
            }
            this.onFillParentInfo_OSPSDLParam(pSDELogicNode, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGICPARAM_RETPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicParam);
            } else {
                iService.get((IEntity)pSDELogicParam);
            }
            this.onFillParentInfo_RetPSDLParam(pSDELogicNode, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGICPARAM_SRCPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogicParam);
            } else {
                iService.get((IEntity)pSDELogicParam);
            }
            this.onFillParentInfo_SrcPSDLParam(pSDELogicNode, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGIC_DSTPSDEDATAFLOWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_DstPSDEDataFlow(pSDELogicNode, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGIC_DSTPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_DstPSDELogic(pSDELogicNode, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGIC_DSTPSDEUILOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_DstPSDEUILogic(pSDELogicNode, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDELogicNode, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEMainState);
            } else {
                iService.get((IEntity)pSDEMainState);
            }
            this.onFillParentInfo_PSDEMainState(pSDELogicNode, pSDEMainState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEMAP_DSTPSDEMAPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapService", (SessionFactory)this.getSessionFactory());
            PSDEMap pSDEMap = (PSDEMap)iService.getDEModel().createEntity();
            pSDEMap.set("PSDEMAPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEMap);
            } else {
                iService.get((IEntity)pSDEMap);
            }
            this.onFillParentInfo_DstPSDEMap(pSDELogicNode, pSDEMap);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDENOTIFY_DSTPSDENOTIFYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService", (SessionFactory)this.getSessionFactory());
            PSDENotify pSDENotify = (PSDENotify)iService.getDEModel().createEntity();
            pSDENotify.set("PSDENOTIFYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDENotify);
            } else {
                iService.get((IEntity)pSDENotify);
            }
            this.onFillParentInfo_DstPSDENotify(pSDELogicNode, pSDENotify);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEPRINT_DSTPSDEPRINTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService", (SessionFactory)this.getSessionFactory());
            PSDEPrint pSDEPrint = (PSDEPrint)iService.getDEModel().createEntity();
            pSDEPrint.set("PSDEPRINTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEPrint);
            } else {
                iService.get((IEntity)pSDEPrint);
            }
            this.onFillParentInfo_DstPSDEPrint(pSDELogicNode, pSDEPrint);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEREPORT_DSTPSDEREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory());
            PSDEReport pSDEReport = (PSDEReport)iService.getDEModel().createEntity();
            pSDEReport.set("PSDEREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEReport);
            } else {
                iService.get((IEntity)pSDEReport);
            }
            this.onFillParentInfo_DstPSDEReport(pSDELogicNode, pSDEReport);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDESAMPLEDATA_DSTPSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESampleData);
            } else {
                iService.get((IEntity)pSDESampleData);
            }
            this.onFillParentInfo_DstPSDESampleData(pSDELogicNode, pSDESampleData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEUAGROUP_DSTPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_DstPSDEUAGroup(pSDELogicNode, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUIAction);
            } else {
                iService.get((IEntity)pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDELogicNode, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEUTILDE_DSTDEUTILDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService", (SessionFactory)this.getSessionFactory());
            PSDEUtilDE pSDEUtilDE = (PSDEUtilDE)iService.getDEModel().createEntity();
            pSDEUtilDE.set("PSDEUTILDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUtilDE);
            } else {
                iService.get((IEntity)pSDEUtilDE);
            }
            this.onFillParentInfo_DstPSDEUtilDE(pSDELogicNode, pSDEUtilDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEVIEWBASE_DSTPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_DstPSDEView(pSDELogicNode, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEVRGROUP_DSTPSDEVRGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService", (SessionFactory)this.getSessionFactory());
            PSDEVRGroup pSDEVRGroup = (PSDEVRGroup)iService.getDEModel().createEntity();
            pSDEVRGroup.set("PSDEVRGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEVRGroup);
            } else {
                iService.get((IEntity)pSDEVRGroup);
            }
            this.onFillParentInfo_DstPSDEVRGroup(pSDELogicNode, pSDEVRGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSDEWIZARD_DSTPSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEWizard);
            } else {
                iService.get((IEntity)pSDEWizard);
            }
            this.onFillParentInfo_DstPSDEWizard(pSDELogicNode, pSDEWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSLANGUAGERES_MSGPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_MsgPSLanRes(pSDELogicNode, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADetail pSSubSysSADetail = (PSSubSysSADetail)iService.getDEModel().createEntity();
            pSSubSysSADetail.set("PSSUBSYSSADETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADetail);
            } else {
                iService.get((IEntity)pSSubSysSADetail);
            }
            this.onFillParentInfo_PSSubSysSADetail(pSDELogicNode, pSSubSysSADetail);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysServiceAPI);
            } else {
                iService.get((IEntity)pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSDELogicNode, pSSubSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSAICHATAGENT_PSSYSAICHATAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIChatAgent pSSysAIChatAgent = (PSSysAIChatAgent)iService.getDEModel().createEntity();
            pSSysAIChatAgent.set("PSSYSAICHATAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIChatAgent);
            } else {
                iService.get((IEntity)pSSysAIChatAgent);
            }
            this.onFillParentInfo_PSSysAIChatAgent(pSDELogicNode, pSSysAIChatAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSAIFACTORY_PSSYSAIFACTORYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory());
            PSSysAIFactory pSSysAIFactory = (PSSysAIFactory)iService.getDEModel().createEntity();
            pSSysAIFactory.set("PSSYSAIFACTORYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIFactory);
            } else {
                iService.get((IEntity)pSSysAIFactory);
            }
            this.onFillParentInfo_PSSysAIFactory(pSDELogicNode, pSSysAIFactory);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIPipelineAgent pSSysAIPipelineAgent = (PSSysAIPipelineAgent)iService.getDEModel().createEntity();
            pSSysAIPipelineAgent.set("PSSYSAIPIPELINEAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIPipelineAgent);
            } else {
                iService.get((IEntity)pSSysAIPipelineAgent);
            }
            this.onFillParentInfo_PSSysAIPipelineAgent(pSDELogicNode, pSSysAIPipelineAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSAIWORKERAGENT_PSSYSAIWORKERAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIWorkerAgent pSSysAIWorkerAgent = (PSSysAIWorkerAgent)iService.getDEModel().createEntity();
            pSSysAIWorkerAgent.set("PSSYSAIWORKERAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIWorkerAgent);
            } else {
                iService.get((IEntity)pSSysAIWorkerAgent);
            }
            this.onFillParentInfo_PSSysAIWorkerAgent(pSDELogicNode, pSSysAIWorkerAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSBACKSERVICE_PSSYSBACKSERVICEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService", (SessionFactory)this.getSessionFactory());
            PSSysBackService pSSysBackService = (PSSysBackService)iService.getDEModel().createEntity();
            pSSysBackService.set("PSSYSBACKSERVICEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBackService);
            } else {
                iService.get((IEntity)pSSysBackService);
            }
            this.onFillParentInfo_PSSysBackService(pSDELogicNode, pSSysBackService);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBDScheme pSSysBDScheme = (PSSysBDScheme)iService.getDEModel().createEntity();
            pSSysBDScheme.set("PSSYSBDSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDScheme);
            } else {
                iService.get((IEntity)pSSysBDScheme);
            }
            this.onFillParentInfo_PSSysBDScheme(pSDELogicNode, pSSysBDScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDTable);
            } else {
                iService.get((IEntity)pSSysBDTable);
            }
            this.onFillParentInfo_PSSysBDTable(pSDELogicNode, pSSysBDTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService", (SessionFactory)this.getSessionFactory());
            PSSysBIAggTable pSSysBIAggTable = (PSSysBIAggTable)iService.getDEModel().createEntity();
            pSSysBIAggTable.set("PSSYSBIAGGTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIAggTable);
            } else {
                iService.get((IEntity)pSSysBIAggTable);
            }
            this.onFillParentInfo_PSSysBIAggTable(pSDELogicNode, pSSysBIAggTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService", (SessionFactory)this.getSessionFactory());
            PSSysBICube pSSysBICube = (PSSysBICube)iService.getDEModel().createEntity();
            pSSysBICube.set("PSSYSBICUBEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBICube);
            } else {
                iService.get((IEntity)pSSysBICube);
            }
            this.onFillParentInfo_PSSysBICube(pSDELogicNode, pSSysBICube);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSBIREPORT_PSSYSBIREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService", (SessionFactory)this.getSessionFactory());
            PSSysBIReport pSSysBIReport = (PSSysBIReport)iService.getDEModel().createEntity();
            pSSysBIReport.set("PSSYSBIREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIReport);
            } else {
                iService.get((IEntity)pSSysBIReport);
            }
            this.onFillParentInfo_PSSysBIReport(pSDELogicNode, pSSysBIReport);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSBISCHEME_PSSYSBISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBIScheme pSSysBIScheme = (PSSysBIScheme)iService.getDEModel().createEntity();
            pSSysBIScheme.set("PSSYSBISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIScheme);
            } else {
                iService.get((IEntity)pSSysBIScheme);
            }
            this.onFillParentInfo_PSSysBIScheme(pSDELogicNode, pSSysBIScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSDATASYNCAGENT_PSSYSDATASYNCAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService", (SessionFactory)this.getSessionFactory());
            PSSysDataSyncAgent pSSysDataSyncAgent = (PSSysDataSyncAgent)iService.getDEModel().createEntity();
            pSSysDataSyncAgent.set("PSSYSDATASYNCAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDataSyncAgent);
            } else {
                iService.get((IEntity)pSSysDataSyncAgent);
            }
            this.onFillParentInfo_PSSysDatasyncAgent(pSDELogicNode, pSSysDataSyncAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSDBSCHEME_PSSYSDBSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysDBScheme pSSysDBScheme = (PSSysDBScheme)iService.getDEModel().createEntity();
            pSSysDBScheme.set("PSSYSDBSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBScheme);
            } else {
                iService.get((IEntity)pSSysDBScheme);
            }
            this.onFillParentInfo_PSSysDBScheme(pSDELogicNode, pSSysDBScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSDBTABLE_PSSYSDBTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService", (SessionFactory)this.getSessionFactory());
            PSSysDBTable pSSysDBTable = (PSSysDBTable)iService.getDEModel().createEntity();
            pSSysDBTable.set("PSSYSDBTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBTable);
            } else {
                iService.get((IEntity)pSSysDBTable);
            }
            this.onFillParentInfo_PSSysDBTable(pSDELogicNode, pSSysDBTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSDELOGICNODE_PSSYSDELOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService", (SessionFactory)this.getSessionFactory());
            PSSysDELogicNode pSSysDELogicNode = (PSSysDELogicNode)iService.getDEModel().createEntity();
            pSSysDELogicNode.set("PSSYSDELOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDELogicNode);
            } else {
                iService.get((IEntity)pSSysDELogicNode);
            }
            this.onFillParentInfo_PSSysDELogicNode(pSDELogicNode, pSSysDELogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElement pSSysEAIElement = (PSSysEAIElement)iService.getDEModel().createEntity();
            pSSysEAIElement.set("PSSYSEAIELEMENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIElement);
            } else {
                iService.get((IEntity)pSSysEAIElement);
            }
            this.onFillParentInfo_PSSysEAIElement(pSDELogicNode, pSSysEAIElement);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSEAISCHEME_PSSYSEAISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIScheme pSSysEAIScheme = (PSSysEAIScheme)iService.getDEModel().createEntity();
            pSSysEAIScheme.set("PSSYSEAISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIScheme);
            } else {
                iService.get((IEntity)pSSysEAIScheme);
            }
            this.onFillParentInfo_PSSysEAIScheme(pSDELogicNode, pSSysEAIScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMsgTempl);
            } else {
                iService.get((IEntity)pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSDELogicNode, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDELogicNode, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSDELogicNode, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDocService", (SessionFactory)this.getSessionFactory());
            PSSysSearchDoc pSSysSearchDoc = (PSSysSearchDoc)iService.getDEModel().createEntity();
            pSSysSearchDoc.set("PSSYSSEARCHDOCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSearchDoc);
            } else {
                iService.get((IEntity)pSSysSearchDoc);
            }
            this.onFillParentInfo_PSSysSearchDoc(pSDELogicNode, pSSysSearchDoc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysSearchScheme pSSysSearchScheme = (PSSysSearchScheme)iService.getDEModel().createEntity();
            pSSysSearchScheme.set("PSSYSSEARCHSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSearchScheme);
            } else {
                iService.get((IEntity)pSSysSearchScheme);
            }
            this.onFillParentInfo_PSSysSearchScheme(pSDELogicNode, pSSysSearchScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDELogicNode, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSSQLCMD_PSSYSSQLCMDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdService", (SessionFactory)this.getSessionFactory());
            PSSysSQLCmd pSSysSQLCmd = (PSSysSQLCmd)iService.getDEModel().createEntity();
            pSSysSQLCmd.set("PSSYSSQLCMDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSQLCmd);
            } else {
                iService.get((IEntity)pSSysSQLCmd);
            }
            this.onFillParentInfo_PSSysSqlCmd(pSDELogicNode, pSSysSQLCmd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSUNISTATE_PSSYSUNISTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService", (SessionFactory)this.getSessionFactory());
            PSSysUniState pSSysUniState = (PSSysUniState)iService.getDEModel().createEntity();
            pSSysUniState.set("PSSYSUNISTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniState);
            } else {
                iService.get((IEntity)pSSysUniState);
            }
            this.onFillParentInfo_PSSysUniState(pSDELogicNode, pSSysUniState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSSYSUTILDE_PSSYSUTILDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService", (SessionFactory)this.getSessionFactory());
            PSSysUtilDE pSSysUtilDE = (PSSysUtilDE)iService.getDEModel().createEntity();
            pSSysUtilDE.set("PSSYSUTILDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUtilDE);
            } else {
                iService.get((IEntity)pSSysUtilDE);
            }
            this.onFillParentInfo_PSSysUtilDE(pSDELogicNode, pSSysUtilDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSVIEWMSG_PSVIEWMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService", (SessionFactory)this.getSessionFactory());
            PSViewMsg pSViewMsg = (PSViewMsg)iService.getDEModel().createEntity();
            pSViewMsg.set("PSVIEWMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsg);
            } else {
                iService.get((IEntity)pSViewMsg);
            }
            this.onFillParentInfo_PSViewMsg(pSDELogicNode, pSViewMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSWFDE_PSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFDE);
            } else {
                iService.get((IEntity)pSWFDE);
            }
            this.onFillParentInfo_PSWF(pSDELogicNode, pSWFDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELOGICNODE_PSWORKFLOW_PSWORKFLOWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWorkflow);
            } else {
                iService.get((IEntity)pSWorkflow);
            }
            this.onFillParentInfo_PSWorkflow(pSDELogicNode, pSWorkflow);
            return;
        }
        super.onFillParentInfo((IEntity)pSDELogicNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDELOGICNODE_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", string2);
            return this.onSyncDER1NData_PSDELogic(pSDELogic, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDE(PSDELogicNode pSDELogicNode, PSDataEntity pSDataEntity) throws Exception {
        pSDELogicNode.setDstPSDEId(pSDataEntity.getPSDataEntityId());
        pSDELogicNode.setDstPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_DstPSDEAction(PSDELogicNode pSDELogicNode, PSDEAction pSDEAction) throws Exception {
        pSDELogicNode.setDstPSDEActionId(pSDEAction.getPSDEActionId());
        pSDELogicNode.setDstPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_DstPSDEDataExp(PSDELogicNode pSDELogicNode, PSDEDataExp pSDEDataExp) throws Exception {
        pSDELogicNode.setDstPSDEDataExpId(pSDEDataExp.getPSDEDataExpId());
        pSDELogicNode.setDstPSDEDataExpName(pSDEDataExp.getPSDEDataExpName());
    }

    protected void onFillParentInfo_DstPSDEDataImp(PSDELogicNode pSDELogicNode, PSDEDataImp pSDEDataImp) throws Exception {
        pSDELogicNode.setDstPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
        pSDELogicNode.setDstPSDEDataImpName(pSDEDataImp.getPSDEDataImpName());
    }

    protected void onFillParentInfo_DstPSDEDataQuery(PSDELogicNode pSDELogicNode, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDELogicNode.setDstPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
        pSDELogicNode.setDstPSDEDataQueryName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_DstPSDEDataSet(PSDELogicNode pSDELogicNode, PSDEDataSet pSDEDataSet) throws Exception {
        pSDELogicNode.setDstPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDELogicNode.setDstPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_DstPSDEDataSync(PSDELogicNode pSDELogicNode, PSDEDataSync pSDEDataSync) throws Exception {
        pSDELogicNode.setDstPSDEDataSyncId(pSDEDataSync.getPSDEDataSyncId());
        pSDELogicNode.setDstPSDEDataSyncName(pSDEDataSync.getPSDEDataSyncName());
    }

    protected void onFillParentInfo_DstPSDEDTSQueue(PSDELogicNode pSDELogicNode, PSDEDTSQueue pSDEDTSQueue) throws Exception {
        pSDELogicNode.setDstPSDEDTSQueueId(pSDEDTSQueue.getPSDEDTSQueueId());
        pSDELogicNode.setDstPSDEDTSQueueName(pSDEDTSQueue.getPSDEDTSQueueName());
    }

    protected void onFillParentInfo_DstPSDEFGroup(PSDELogicNode pSDELogicNode, PSDEFGroup pSDEFGroup) throws Exception {
        pSDELogicNode.setDstPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDELogicNode.setDstPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_DstPSDEForm(PSDELogicNode pSDELogicNode, PSDEForm pSDEForm) throws Exception {
        pSDELogicNode.setDstPSDEFormId(pSDEForm.getPSDEFormId());
        pSDELogicNode.setDstPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_DstPSDEFValueRule(PSDELogicNode pSDELogicNode, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDELogicNode.setDstPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDELogicNode.setDstPSDEFValueRuleName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_DstPSDLParam(PSDELogicNode pSDELogicNode, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELogicNode.setDstPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELogicNode.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_ISPSDLParam(PSDELogicNode pSDELogicNode, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELogicNode.setISPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELogicNode.setISPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_OptPSDLParam(PSDELogicNode pSDELogicNode, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELogicNode.setOptPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELogicNode.setOptPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_OSPSDLParam(PSDELogicNode pSDELogicNode, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELogicNode.setOSPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELogicNode.setOSPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_RetPSDLParam(PSDELogicNode pSDELogicNode, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELogicNode.setRetPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELogicNode.setRetPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_SrcPSDLParam(PSDELogicNode pSDELogicNode, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELogicNode.setSrcPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELogicNode.setSrcPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_DstPSDEDataFlow(PSDELogicNode pSDELogicNode, PSDELogic pSDELogic) throws Exception {
        pSDELogicNode.setDstPSDEDataFlowId(pSDELogic.getPSDELogicId());
        pSDELogicNode.setDstPSDEDataFlowName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_DstPSDELogic(PSDELogicNode pSDELogicNode, PSDELogic pSDELogic) throws Exception {
        pSDELogicNode.setDstPSDELogicId(pSDELogic.getPSDELogicId());
        pSDELogicNode.setDstPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_DstPSDEUILogic(PSDELogicNode pSDELogicNode, PSDELogic pSDELogic) throws Exception {
        pSDELogicNode.setDstPSDEUILogicId(pSDELogic.getPSDELogicId());
        pSDELogicNode.setDstPSDEUILogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDELogic(PSDELogicNode pSDELogicNode, PSDELogic pSDELogic) throws Exception {
        pSDELogicNode.setPSDEId(pSDELogic.getPSDEId());
        pSDELogicNode.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDELogicNode.setPSDELogicName(pSDELogic.getPSDELogicName());
        pSDELogicNode.setPSSystemId(pSDELogic.getPSSystemId());
    }

    protected String onSyncDER1NData_PSDELogic(PSDELogic pSDELogic, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDELogic(pSDELogic);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDELogicNode> arrayList = this.selectByPSDELogic(pSDELogic);
            for (PSDELogicNode pSDELogicNode : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDELogicNode, (String)"PSDELOGICNODEID", (String)""))) continue;
                this.remove((IEntity)pSDELogicNode);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEMainState(PSDELogicNode pSDELogicNode, PSDEMainState pSDEMainState) throws Exception {
        pSDELogicNode.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
        pSDELogicNode.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillParentInfo_DstPSDEMap(PSDELogicNode pSDELogicNode, PSDEMap pSDEMap) throws Exception {
        pSDELogicNode.setDstPSDEMapId(pSDEMap.getPSDEMapId());
        pSDELogicNode.setDstPSDEMapName(pSDEMap.getPSDEMapName());
    }

    protected void onFillParentInfo_DstPSDENotify(PSDELogicNode pSDELogicNode, PSDENotify pSDENotify) throws Exception {
        pSDELogicNode.setDstPSDENotifyId(pSDENotify.getPSDENotifyId());
        pSDELogicNode.setDstPSDENotifyName(pSDENotify.getPSDENotifyName());
    }

    protected void onFillParentInfo_DstPSDEPrint(PSDELogicNode pSDELogicNode, PSDEPrint pSDEPrint) throws Exception {
        pSDELogicNode.setDstPSDEPrintId(pSDEPrint.getPSDEPrintId());
        pSDELogicNode.setDstPSDEPrintName(pSDEPrint.getPSDEPrintName());
    }

    protected void onFillParentInfo_DstPSDEReport(PSDELogicNode pSDELogicNode, PSDEReport pSDEReport) throws Exception {
        pSDELogicNode.setDstPSDEReportId(pSDEReport.getPSDEReportId());
        pSDELogicNode.setDstPSDEReportName(pSDEReport.getPSDEReportName());
    }

    protected void onFillParentInfo_DstPSDESampleData(PSDELogicNode pSDELogicNode, PSDESampleData pSDESampleData) throws Exception {
        pSDELogicNode.setDstPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSDELogicNode.setDstPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillParentInfo_DstPSDEUAGroup(PSDELogicNode pSDELogicNode, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDELogicNode.setDstPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDELogicNode.setDstPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDELogicNode pSDELogicNode, PSDEUIAction pSDEUIAction) throws Exception {
        pSDELogicNode.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDELogicNode.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_DstPSDEUtilDE(PSDELogicNode pSDELogicNode, PSDEUtilDE pSDEUtilDE) throws Exception {
        pSDELogicNode.setDstPSDEUtilDEId(pSDEUtilDE.getPSDEUtilDEId());
        pSDELogicNode.setDstPSDEUtilDEName(pSDEUtilDE.getPSDEUtilDEName());
    }

    protected void onFillParentInfo_DstPSDEView(PSDELogicNode pSDELogicNode, PSDEViewBase pSDEViewBase) throws Exception {
        pSDELogicNode.setDstPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDELogicNode.setDstPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_DstPSDEVRGroup(PSDELogicNode pSDELogicNode, PSDEVRGroup pSDEVRGroup) throws Exception {
        pSDELogicNode.setDstPSDEVRGroupId(pSDEVRGroup.getPSDEVRGroupId());
        pSDELogicNode.setDstPSDEVRGroupName(pSDEVRGroup.getPSDEVRGroupName());
    }

    protected void onFillParentInfo_DstPSDEWizard(PSDELogicNode pSDELogicNode, PSDEWizard pSDEWizard) throws Exception {
        pSDELogicNode.setDstPSDEWizardId(pSDEWizard.getPSDEWizardId());
        pSDELogicNode.setDstPSDEWizardName(pSDEWizard.getPSDEWizardName());
    }

    protected void onFillParentInfo_MsgPSLanRes(PSDELogicNode pSDELogicNode, PSLanguageRes pSLanguageRes) throws Exception {
        pSDELogicNode.setMsgPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDELogicNode.setMsgPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSubSysSADetail(PSDELogicNode pSDELogicNode, PSSubSysSADetail pSSubSysSADetail) throws Exception {
        pSDELogicNode.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
        pSDELogicNode.setPSSubSysSADetailName(pSSubSysSADetail.getPSSubSysSADetailName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSDELogicNode pSDELogicNode, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSDELogicNode.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSDELogicNode.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysAIChatAgent(PSDELogicNode pSDELogicNode, PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        pSDELogicNode.setPSSysAIChatAgentId(pSSysAIChatAgent.getPSSysAIChatAgentId());
        pSDELogicNode.setPSSysAIChatAgentName(pSSysAIChatAgent.getPSSysAIChatAgentName());
    }

    protected void onFillParentInfo_PSSysAIFactory(PSDELogicNode pSDELogicNode, PSSysAIFactory pSSysAIFactory) throws Exception {
        pSDELogicNode.setPSSysAIFactoryId(pSSysAIFactory.getPSSysAIFactoryId());
        pSDELogicNode.setPSSysAIFactoryName(pSSysAIFactory.getPSSysAIFactoryName());
    }

    protected void onFillParentInfo_PSSysAIPipelineAgent(PSDELogicNode pSDELogicNode, PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        pSDELogicNode.setPSSysAIPipelineAgentId(pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
        pSDELogicNode.setPSSysAIPipelineAgentName(pSSysAIPipelineAgent.getPSSysAIPipelineAgentName());
    }

    protected void onFillParentInfo_PSSysAIWorkerAgent(PSDELogicNode pSDELogicNode, PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        pSDELogicNode.setPSSysAIWorkerAgentId(pSSysAIWorkerAgent.getPSSysAIWorkerAgentId());
        pSDELogicNode.setPSSysAIWorkerAgentName(pSSysAIWorkerAgent.getPSSysAIWorkerAgentName());
    }

    protected void onFillParentInfo_PSSysBackService(PSDELogicNode pSDELogicNode, PSSysBackService pSSysBackService) throws Exception {
        pSDELogicNode.setPSSysBackServiceId(pSSysBackService.getPSSysBackServiceId());
        pSDELogicNode.setPSSysBackServiceName(pSSysBackService.getPSSysBackServiceName());
    }

    protected void onFillParentInfo_PSSysBDScheme(PSDELogicNode pSDELogicNode, PSSysBDScheme pSSysBDScheme) throws Exception {
        pSDELogicNode.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
        pSDELogicNode.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
    }

    protected void onFillParentInfo_PSSysBDTable(PSDELogicNode pSDELogicNode, PSSysBDTable pSSysBDTable) throws Exception {
        pSDELogicNode.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSDELogicNode.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
    }

    protected void onFillParentInfo_PSSysBIAggTable(PSDELogicNode pSDELogicNode, PSSysBIAggTable pSSysBIAggTable) throws Exception {
        pSDELogicNode.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
        pSDELogicNode.setPSSysBIAggTableName(pSSysBIAggTable.getPSSysBIAggTableName());
    }

    protected void onFillParentInfo_PSSysBICube(PSDELogicNode pSDELogicNode, PSSysBICube pSSysBICube) throws Exception {
        pSDELogicNode.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
        pSDELogicNode.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
    }

    protected void onFillParentInfo_PSSysBIReport(PSDELogicNode pSDELogicNode, PSSysBIReport pSSysBIReport) throws Exception {
        pSDELogicNode.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
        pSDELogicNode.setPSSysBIReportName(pSSysBIReport.getPSSysBIReportName());
    }

    protected void onFillParentInfo_PSSysBIScheme(PSDELogicNode pSDELogicNode, PSSysBIScheme pSSysBIScheme) throws Exception {
        pSDELogicNode.setPSSysBISchemeId(pSSysBIScheme.getPSSysBISchemeId());
        pSDELogicNode.setPSSysBISchemeName(pSSysBIScheme.getPSSysBISchemeName());
    }

    protected void onFillParentInfo_PSSysDatasyncAgent(PSDELogicNode pSDELogicNode, PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        pSDELogicNode.setPSSysDataSyncAgentId(pSSysDataSyncAgent.getPSSysDataSyncAgentId());
        pSDELogicNode.setPSSysDataSyncAgentName(pSSysDataSyncAgent.getPSSysDataSyncAgentName());
    }

    protected void onFillParentInfo_PSSysDBScheme(PSDELogicNode pSDELogicNode, PSSysDBScheme pSSysDBScheme) throws Exception {
        pSDELogicNode.setPSSysDBSchemeId(pSSysDBScheme.getPSSysDBSchemeId());
        pSDELogicNode.setPSSysDBSchemeName(pSSysDBScheme.getPSSysDBSchemeName());
    }

    protected void onFillParentInfo_PSSysDBTable(PSDELogicNode pSDELogicNode, PSSysDBTable pSSysDBTable) throws Exception {
        pSDELogicNode.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
        pSDELogicNode.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
    }

    protected void onFillParentInfo_PSSysDELogicNode(PSDELogicNode pSDELogicNode, PSSysDELogicNode pSSysDELogicNode) throws Exception {
        pSDELogicNode.setPSSysDELogicNodeId(pSSysDELogicNode.getPSSysDELogicNodeId());
        pSDELogicNode.setPSSysDELogicNodeName(pSSysDELogicNode.getPSSysDELogicNodeName());
    }

    protected void onFillParentInfo_PSSysEAIElement(PSDELogicNode pSDELogicNode, PSSysEAIElement pSSysEAIElement) throws Exception {
        pSDELogicNode.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
        pSDELogicNode.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
    }

    protected void onFillParentInfo_PSSysEAIScheme(PSDELogicNode pSDELogicNode, PSSysEAIScheme pSSysEAIScheme) throws Exception {
        pSDELogicNode.setPSSysEAISchemeId(pSSysEAIScheme.getPSSysEAISchemeId());
        pSDELogicNode.setPSSysEAISchemeName(pSSysEAIScheme.getPSSysEAISchemeName());
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSDELogicNode pSDELogicNode, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSDELogicNode.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSDELogicNode.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDELogicNode pSDELogicNode, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDELogicNode.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDELogicNode.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysResource(PSDELogicNode pSDELogicNode, PSSysResource pSSysResource) throws Exception {
        pSDELogicNode.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSDELogicNode.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSearchDoc(PSDELogicNode pSDELogicNode, PSSysSearchDoc pSSysSearchDoc) throws Exception {
        pSDELogicNode.setPSSysSearchDocId(pSSysSearchDoc.getPSSysSearchDocId());
        pSDELogicNode.setPSSysSearchDocName(pSSysSearchDoc.getPSSysSearchDocName());
    }

    protected void onFillParentInfo_PSSysSearchScheme(PSDELogicNode pSDELogicNode, PSSysSearchScheme pSSysSearchScheme) throws Exception {
        pSDELogicNode.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
        pSDELogicNode.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDELogicNode pSDELogicNode, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDELogicNode.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDELogicNode.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysSqlCmd(PSDELogicNode pSDELogicNode, PSSysSQLCmd pSSysSQLCmd) throws Exception {
        pSDELogicNode.setPSSysSQLCmdId(pSSysSQLCmd.getPSSysSQLCmdId());
        pSDELogicNode.setPSSysSQLCmdName(pSSysSQLCmd.getLogicName());
    }

    protected void onFillParentInfo_PSSysUniState(PSDELogicNode pSDELogicNode, PSSysUniState pSSysUniState) throws Exception {
        pSDELogicNode.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
        pSDELogicNode.setPSSysUniStateName(pSSysUniState.getPSSysUniStateName());
    }

    protected void onFillParentInfo_PSSysUtilDE(PSDELogicNode pSDELogicNode, PSSysUtilDE pSSysUtilDE) throws Exception {
        pSDELogicNode.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
        pSDELogicNode.setPSSysUtilDEName(pSSysUtilDE.getPSSysUtilDEName());
    }

    protected void onFillParentInfo_PSViewMsg(PSDELogicNode pSDELogicNode, PSViewMsg pSViewMsg) throws Exception {
        pSDELogicNode.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
        pSDELogicNode.setPSViewMsgName(pSViewMsg.getPSViewMsgName());
    }

    protected void onFillParentInfo_PSWF(PSDELogicNode pSDELogicNode, PSWFDE pSWFDE) throws Exception {
        pSDELogicNode.setPSWFDEId(pSWFDE.getPSWFDEId());
        pSDELogicNode.setPSWFDEName(pSWFDE.getPSWFDEName());
        if (pSWFDE.getPSWF() != null) {
            this.onFillParentInfo_PSWorkflow(pSDELogicNode, pSWFDE.getPSWF());
        }
    }

    protected void onFillParentInfo_PSWorkflow(PSDELogicNode pSDELogicNode, PSWorkflow pSWorkflow) throws Exception {
        pSDELogicNode.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
        pSDELogicNode.setPSWorkflowName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDE(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEAction(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEDataExp(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEDataImp(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEDataQuery(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEDataSet(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEDataSync(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEDTSQueue(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEFGroup(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEForm(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEFValueRule(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDLParam(pSDELogicNode, bl);
        this.onFillEntityFullInfo_ISPSDLParam(pSDELogicNode, bl);
        this.onFillEntityFullInfo_OptPSDLParam(pSDELogicNode, bl);
        this.onFillEntityFullInfo_OSPSDLParam(pSDELogicNode, bl);
        this.onFillEntityFullInfo_RetPSDLParam(pSDELogicNode, bl);
        this.onFillEntityFullInfo_SrcPSDLParam(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEDataFlow(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDELogic(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEUILogic(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSDEMainState(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEMap(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDENotify(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEPrint(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEReport(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDESampleData(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEUAGroup(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEUtilDE(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEView(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEVRGroup(pSDELogicNode, bl);
        this.onFillEntityFullInfo_DstPSDEWizard(pSDELogicNode, bl);
        this.onFillEntityFullInfo_MsgPSLanRes(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSubSysSADetail(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysAIChatAgent(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysAIFactory(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysAIPipelineAgent(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysAIWorkerAgent(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysBackService(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysBDScheme(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysBDTable(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysBIAggTable(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysBICube(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysBIReport(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysBIScheme(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysDatasyncAgent(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysDBScheme(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysDBTable(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysDELogicNode(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysEAIElement(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysEAIScheme(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysResource(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysSearchDoc(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysSearchScheme(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysSqlCmd(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysUniState(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSSysUtilDE(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSViewMsg(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSWF(pSDELogicNode, bl);
        this.onFillEntityFullInfo_PSWorkflow(pSDELogicNode, bl);
    }

    protected void onFillEntityFullInfo_DstPSDE(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isDstPSDEIdDirty()) {
            if (pSDELogicNode.getDstPSDEId() != null) {
                if (pSDELogicNode.getDstPSDEId() == null || pSDELogicNode.getDstPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDELogicNode.getDstPSDE();
                    pSDELogicNode.setDstPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDELogicNode.setDstPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEAction(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isDstPSDEActionIdDirty()) {
            if (pSDELogicNode.getDstPSDEActionId() != null) {
                if (pSDELogicNode.getDstPSDEActionId() == null || pSDELogicNode.getDstPSDEActionName() == null) {
                    PSDEAction pSDEAction = pSDELogicNode.getDstPSDEAction();
                    pSDELogicNode.setDstPSDEActionName(pSDEAction.getPSDEActionName());
                }
            } else {
                pSDELogicNode.setDstPSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEDataExp(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEDataImp(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEDataQuery(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEDataSet(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEDataSync(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEDTSQueue(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEFGroup(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEForm(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEFValueRule(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDLParam(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isDstPSDLParamIdDirty()) {
            if (pSDELogicNode.getDstPSDLParamId() != null) {
                if (pSDELogicNode.getDstPSDLParamId() == null || pSDELogicNode.getDstPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELogicNode.getDstPSDLParam();
                    pSDELogicNode.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELogicNode.setDstPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ISPSDLParam(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isISPSDLParamIdDirty()) {
            if (pSDELogicNode.getISPSDLParamId() != null) {
                if (pSDELogicNode.getISPSDLParamId() == null || pSDELogicNode.getISPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELogicNode.getISPSDLParam();
                    pSDELogicNode.setISPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELogicNode.setISPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OptPSDLParam(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isOptPSDLParamIdDirty()) {
            if (pSDELogicNode.getOptPSDLParamId() != null) {
                if (pSDELogicNode.getOptPSDLParamId() == null || pSDELogicNode.getOptPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELogicNode.getOptPSDLParam();
                    pSDELogicNode.setOptPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELogicNode.setOptPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OSPSDLParam(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isOSPSDLParamIdDirty()) {
            if (pSDELogicNode.getOSPSDLParamId() != null) {
                if (pSDELogicNode.getOSPSDLParamId() == null || pSDELogicNode.getOSPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELogicNode.getOSPSDLParam();
                    pSDELogicNode.setOSPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELogicNode.setOSPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RetPSDLParam(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isRetPSDLParamIdDirty()) {
            if (pSDELogicNode.getRetPSDLParamId() != null) {
                if (pSDELogicNode.getRetPSDLParamId() == null || pSDELogicNode.getRetPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELogicNode.getRetPSDLParam();
                    pSDELogicNode.setRetPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELogicNode.setRetPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SrcPSDLParam(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isSrcPSDLParamIdDirty()) {
            if (pSDELogicNode.getSrcPSDLParamId() != null) {
                if (pSDELogicNode.getSrcPSDLParamId() == null || pSDELogicNode.getSrcPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELogicNode.getSrcPSDLParam();
                    pSDELogicNode.setSrcPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELogicNode.setSrcPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEDataFlow(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDELogic(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEUILogic(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isPSDELogicIdDirty()) {
            if (pSDELogicNode.getPSDELogicId() != null) {
                if (pSDELogicNode.getPSDEId() == null || pSDELogicNode.getPSDELogicId() == null || pSDELogicNode.getPSSystemId() == null) {
                    PSDELogic pSDELogic = pSDELogicNode.getPSDELogic();
                    pSDELogicNode.setPSDEId(pSDELogic.getPSDEId());
                    pSDELogicNode.setPSDELogicName(pSDELogic.getPSDELogicName());
                    pSDELogicNode.setPSSystemId(pSDELogic.getPSSystemId());
                }
            } else {
                pSDELogicNode.setPSDEId(null);
                pSDELogicNode.setPSDELogicName(null);
                pSDELogicNode.setPSSystemId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEMainState(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEMap(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDENotify(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEPrint(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEReport(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDESampleData(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEUAGroup(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEUtilDE(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEView(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEVRGroup(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DstPSDEWizard(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MsgPSLanRes(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (pSDELogicNode.isMsgPSLanResIdDirty()) {
            if (pSDELogicNode.getMsgPSLanResId() != null) {
                if (pSDELogicNode.getMsgPSLanResId() == null || pSDELogicNode.getMsgPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDELogicNode.getMsgPSLanRes();
                    pSDELogicNode.setMsgPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDELogicNode.setMsgPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSysSADetail(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIChatAgent(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIFactory(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIPipelineAgent(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIWorkerAgent(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBackService(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDScheme(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDTable(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIAggTable(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICube(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIReport(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIScheme(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDatasyncAgent(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDBScheme(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDBTable(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDELogicNode(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIElement(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIScheme(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchDoc(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchScheme(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSqlCmd(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniState(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUtilDE(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsg(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWF(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWorkflow(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDELogicNode, bl);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByDstPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByDstPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByDstPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataExp(PSDEDataExpBase pSDEDataExpBase) throws Exception {
        return this.selectByDstPSDEDataExp(pSDEDataExpBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataExp(PSDEDataExpBase pSDEDataExpBase, String string) throws Exception {
        return this.selectByDstPSDEDataExp(pSDEDataExpBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataExp(PSDEDataExpBase pSDEDataExpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATAEXPID", (Object)pSDEDataExpBase.getPSDEDataExpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataExpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataExpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataImp(PSDEDataImpBase pSDEDataImpBase) throws Exception {
        return this.selectByDstPSDEDataImp(pSDEDataImpBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string) throws Exception {
        return this.selectByDstPSDEDataImp(pSDEDataImpBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATAIMPID", (Object)pSDEDataImpBase.getPSDEDataImpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataImpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataImpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByDstPSDEDataQuery(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByDstPSDEDataQuery(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATAQUERYID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataQueryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataQueryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByDstPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByDstPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataSync(PSDEDataSyncBase pSDEDataSyncBase) throws Exception {
        return this.selectByDstPSDEDataSync(pSDEDataSyncBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataSync(PSDEDataSyncBase pSDEDataSyncBase, String string) throws Exception {
        return this.selectByDstPSDEDataSync(pSDEDataSyncBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataSync(PSDEDataSyncBase pSDEDataSyncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATASYNCID", (Object)pSDEDataSyncBase.getPSDEDataSyncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataSyncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataSyncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDTSQueue(PSDEDTSQueueBase pSDEDTSQueueBase) throws Exception {
        return this.selectByDstPSDEDTSQueue(pSDEDTSQueueBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDTSQueue(PSDEDTSQueueBase pSDEDTSQueueBase, String string) throws Exception {
        return this.selectByDstPSDEDTSQueue(pSDEDTSQueueBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDTSQueue(PSDEDTSQueueBase pSDEDTSQueueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDTSQUEUEID", (Object)pSDEDTSQueueBase.getPSDEDTSQueueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDTSQueueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDTSQueueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByDstPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByDstPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByDstPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByDstPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByDstPSDEFValueRule(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByDstPSDEFValueRule(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEFVALUERULEID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEFValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEFValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByDstPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELogicNode> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByISPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByISPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByISPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByISPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByISPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ISPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByISPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByISPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectTempByISPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByISPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELogicNode> selectTempByISPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ISPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByISPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByISPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByOptPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByOptPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByOptPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByOptPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByOptPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOptPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOptPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectTempByOptPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByOptPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELogicNode> selectTempByOptPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByOptPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByOptPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByOSPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByOSPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByOSPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByOSPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByOSPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OSPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOSPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOSPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectTempByOSPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByOSPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELogicNode> selectTempByOSPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OSPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByOSPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByOSPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByRetPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByRetPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByRetPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByRetPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByRetPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RETPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRetPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRetPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectTempByRetPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByRetPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELogicNode> selectTempByRetPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RETPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByRetPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByRetPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectBySrcPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectBySrcPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectTempBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempBySrcPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELogicNode> selectTempBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempBySrcPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempBySrcPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataFlow(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByDstPSDEDataFlow(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataFlow(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByDstPSDEDataFlow(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEDataFlow(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEDATAFLOWID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEDataFlowCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEDataFlowCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByDstPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByDstPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUILogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByDstPSDEUILogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUILogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByDstPSDEUILogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUILogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEUILOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEUILogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEUILogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectTempByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectTempByPSDELogic(pSDELogicBase, "");
    }

    public ArrayList<PSDELogicNode> selectTempByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDELogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAINSTATEID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMainStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMainStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectByDstPSDEMap(pSDEMapBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        return this.selectByDstPSDEMap(pSDEMapBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEMap(PSDEMapBase pSDEMapBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEMAPID", (Object)pSDEMapBase.getPSDEMapId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEMapCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDENotify(PSDENotifyBase pSDENotifyBase) throws Exception {
        return this.selectByDstPSDENotify(pSDENotifyBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDENotify(PSDENotifyBase pSDENotifyBase, String string) throws Exception {
        return this.selectByDstPSDENotify(pSDENotifyBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDENotify(PSDENotifyBase pSDENotifyBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDENOTIFYID", (Object)pSDENotifyBase.getPSDENotifyId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDENotifyCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDENotifyCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEPrint(PSDEPrintBase pSDEPrintBase) throws Exception {
        return this.selectByDstPSDEPrint(pSDEPrintBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEPrint(PSDEPrintBase pSDEPrintBase, String string) throws Exception {
        return this.selectByDstPSDEPrint(pSDEPrintBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEPrint(PSDEPrintBase pSDEPrintBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEPRINTID", (Object)pSDEPrintBase.getPSDEPrintId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEPrintCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEPrintCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectByDstPSDEReport(pSDEReportBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        return this.selectByDstPSDEReport(pSDEReportBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEReport(PSDEReportBase pSDEReportBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEREPORTID", (Object)pSDEReportBase.getPSDEReportId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEReportCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEReportCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByDstPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByDstPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByDstPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByDstPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUtilDE(PSDEUtilDEBase pSDEUtilDEBase) throws Exception {
        return this.selectByDstPSDEUtilDE(pSDEUtilDEBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUtilDE(PSDEUtilDEBase pSDEUtilDEBase, String string) throws Exception {
        return this.selectByDstPSDEUtilDE(pSDEUtilDEBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEUtilDE(PSDEUtilDEBase pSDEUtilDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTDEUTILDEID", (Object)pSDEUtilDEBase.getPSDEUtilDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEUtilDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEUtilDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByDstPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByDstPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase) throws Exception {
        return this.selectByDstPSDEVRGroup(pSDEVRGroupBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase, String string) throws Exception {
        return this.selectByDstPSDEVRGroup(pSDEVRGroupBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEVRGroup(PSDEVRGroupBase pSDEVRGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEVRGROUPID", (Object)pSDEVRGroupBase.getPSDEVRGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEVRGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEVRGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectByDstPSDEWizard(pSDEWizardBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        return this.selectByDstPSDEWizard(pSDEWizardBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByDstPSDEWizard(PSDEWizardBase pSDEWizardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEWIZARDID", (Object)pSDEWizardBase.getPSDEWizardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEWizardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByMsgPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByMsgPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByMsgPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByMsgPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByMsgPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MSGPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMsgPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMsgPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADETAILID", (Object)pSSubSysSADetailBase.getPSSubSysSADetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysSADetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysSADetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSERVICEAPIID", (Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIChatAgent(PSSysAIChatAgentBase pSSysAIChatAgentBase) throws Exception {
        return this.selectByPSSysAIChatAgent(pSSysAIChatAgentBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIChatAgent(PSSysAIChatAgentBase pSSysAIChatAgentBase, String string) throws Exception {
        return this.selectByPSSysAIChatAgent(pSSysAIChatAgentBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIChatAgent(PSSysAIChatAgentBase pSSysAIChatAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAICHATAGENTID", (Object)pSSysAIChatAgentBase.getPSSysAIChatAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIChatAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIChatAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIFACTORYID", (Object)pSSysAIFactoryBase.getPSSysAIFactoryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIFactoryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIFactoryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase) throws Exception {
        return this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string) throws Exception {
        return this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIPIPELINEAGENTID", (Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIPipelineAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIPipelineAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase) throws Exception {
        return this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgentBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, String string) throws Exception {
        return this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgentBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIWORKERAGENTID", (Object)pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIWorkerAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIWorkerAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysBackService(PSSysBackServiceBase pSSysBackServiceBase) throws Exception {
        return this.selectByPSSysBackService(pSSysBackServiceBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBackService(PSSysBackServiceBase pSSysBackServiceBase, String string) throws Exception {
        return this.selectByPSSysBackService(pSSysBackServiceBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBackService(PSSysBackServiceBase pSSysBackServiceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBACKSERVICEID", (Object)pSSysBackServiceBase.getPSSysBackServiceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBackServiceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBackServiceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDSCHEMEID", (Object)pSSysBDSchemeBase.getPSSysBDSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDTABLEID", (Object)pSSysBDTableBase.getPSSysBDTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase) throws Exception {
        return this.selectByPSSysBIAggTable(pSSysBIAggTableBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase, String string) throws Exception {
        return this.selectByPSSysBIAggTable(pSSysBIAggTableBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIAGGTABLEID", (Object)pSSysBIAggTableBase.getPSSysBIAggTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIAggTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIAggTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEID", (Object)pSSysBICubeBase.getPSSysBICubeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase) throws Exception {
        return this.selectByPSSysBIReport(pSSysBIReportBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase, String string) throws Exception {
        return this.selectByPSSysBIReport(pSSysBIReportBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIREPORTID", (Object)pSSysBIReportBase.getPSSysBIReportId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIReportCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIReportCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBISCHEMEID", (Object)pSSysBISchemeBase.getPSSysBISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBISchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysDatasyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase) throws Exception {
        return this.selectByPSSysDatasyncAgent(pSSysDataSyncAgentBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDatasyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string) throws Exception {
        return this.selectByPSSysDatasyncAgent(pSSysDataSyncAgentBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDatasyncAgent(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDATASYNCAGENTID", (Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDatasyncAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDatasyncAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBSCHEMEID", (Object)pSSysDBSchemeBase.getPSSysDBSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase) throws Exception {
        return this.selectByPSSysDBTable(pSSysDBTableBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string) throws Exception {
        return this.selectByPSSysDBTable(pSSysDBTableBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBTABLEID", (Object)pSSysDBTableBase.getPSSysDBTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysDELogicNode(PSSysDELogicNodeBase pSSysDELogicNodeBase) throws Exception {
        return this.selectByPSSysDELogicNode(pSSysDELogicNodeBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDELogicNode(PSSysDELogicNodeBase pSSysDELogicNodeBase, String string) throws Exception {
        return this.selectByPSSysDELogicNode(pSSysDELogicNodeBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysDELogicNode(PSSysDELogicNodeBase pSSysDELogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDELOGICNODEID", (Object)pSSysDELogicNodeBase.getPSSysDELogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDELogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTID", (Object)pSSysEAIElementBase.getPSSysEAIElementId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIElementCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIElementCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAISCHEMEID", (Object)pSSysEAISchemeBase.getPSSysEAISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAISchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHDOCID", (Object)pSSysSearchDocBase.getPSSysSearchDocId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchDocCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchDocCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHSCHEMEID", (Object)pSSysSearchSchemeBase.getPSSysSearchSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysSqlCmd(PSSysSQLCmdBase pSSysSQLCmdBase) throws Exception {
        return this.selectByPSSysSqlCmd(pSSysSQLCmdBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSqlCmd(PSSysSQLCmdBase pSSysSQLCmdBase, String string) throws Exception {
        return this.selectByPSSysSqlCmd(pSSysSQLCmdBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysSqlCmd(PSSysSQLCmdBase pSSysSQLCmdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSQLCMDID", (Object)pSSysSQLCmdBase.getPSSysSQLCmdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSqlCmdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSqlCmdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNISTATEID", (Object)pSSysUniStateBase.getPSSysUniStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUTILDEID", (Object)pSSysUtilDEBase.getPSSysUtilDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUtilDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUtilDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSViewMsg(PSViewMsgBase pSViewMsgBase) throws Exception {
        return this.selectByPSViewMsg(pSViewMsgBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSViewMsg(PSViewMsgBase pSViewMsgBase, String string) throws Exception {
        return this.selectByPSViewMsg(pSViewMsgBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSViewMsg(PSViewMsgBase pSViewMsgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGID", (Object)pSViewMsgBase.getPSViewMsgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSWF(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByPSWF(pSWFDEBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSWF(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByPSWF(pSWFDEBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSWF(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFDEID", (Object)pSWFDEBase.getPSWFDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELogicNode> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWorkflow(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSDELogicNode> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWorkflow(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSDELogicNode> selectByPSWorkflow(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWORKFLOWID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWorkflowCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWorkflowCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDATAENTITY_DSTPSDEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDE(pSDataEntity);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDE(pSDataEntity2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDE(pSDataEntity2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDE(pSDataEntity);
        this.onBeforeRemoveByDstPSDE(pSDataEntity, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDE(PSDataEntity pSDataEntity, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEACTION_DSTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEAction(pSDEAction);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEActionId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEAction(pSDEAction2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEAction(pSDEAction2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEAction(pSDEAction);
        this.onBeforeRemoveByDstPSDEAction(pSDEAction, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByDstPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEAction(PSDEAction pSDEAction, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEAction(PSDEAction pSDEAction, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataExp(pSDEDataExp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAEXP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataExp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEDATAEXP_DSTPSDEDATAEXPID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEDataExp), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataExp(pSDEDataExp);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEDataExpId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        final PSDEDataExp pSDEDataExp2 = pSDEDataExp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEDataExp(pSDEDataExp2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEDataExp(pSDEDataExp2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEDataExp(pSDEDataExp2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataExp(pSDEDataExp);
        this.onBeforeRemoveByDstPSDEDataExp(pSDEDataExp, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEDataExp(pSDEDataExp, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataExp(PSDEDataExp pSDEDataExp, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataExp(PSDEDataExp pSDEDataExp, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataImp(pSDEDataImp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAIMP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataImp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEDATAIMP_DSTPSDEDATAIMPID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEDataImp), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataImp(pSDEDataImp);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEDataImpId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        final PSDEDataImp pSDEDataImp2 = pSDEDataImp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEDataImp(pSDEDataImp2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEDataImp(pSDEDataImp2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEDataImp(pSDEDataImp2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataImp(pSDEDataImp);
        this.onBeforeRemoveByDstPSDEDataImp(pSDEDataImp, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEDataImp(pSDEDataImp, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEDATAQUERY_DSTPSDEDATAQUERYID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEDataQueryId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEDataQuery(pSDEDataQuery2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEDataQuery(pSDEDataQuery2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEDataQuery(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataQuery(pSDEDataQuery);
        this.onBeforeRemoveByDstPSDEDataQuery(pSDEDataQuery, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEDataQuery(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEDATASET_DSTPSDEDATASETID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEDataSetId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEDataSet(pSDEDataSet2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEDataSet(pSDEDataSet2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByDstPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataSync(pSDEDataSync, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASYNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSync);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEDATASYNC_DSTPSDEDATASYNCID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEDataSync), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataSync(pSDEDataSync);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEDataSyncId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        final PSDEDataSync pSDEDataSync2 = pSDEDataSync;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEDataSync(pSDEDataSync2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEDataSync(pSDEDataSync2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEDataSync(pSDEDataSync2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataSync(pSDEDataSync);
        this.onBeforeRemoveByDstPSDEDataSync(pSDEDataSync, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEDataSync(pSDEDataSync, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataSync(PSDEDataSync pSDEDataSync) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataSync(PSDEDataSync pSDEDataSync, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataSync(PSDEDataSync pSDEDataSync, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDTSQueue(pSDEDTSQueue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDTSQUEUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDTSQueue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEDTSQUEUE_DSTPSDEDTSQUEUEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEDTSQueue), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDTSQueue(pSDEDTSQueue);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEDTSQueueId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue) throws Exception {
        final PSDEDTSQueue pSDEDTSQueue2 = pSDEDTSQueue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEDTSQueue(pSDEDTSQueue2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEDTSQueue(pSDEDTSQueue2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEDTSQueue(pSDEDTSQueue2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue) throws Exception {
    }

    protected void internalRemoveByDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDTSQueue(pSDEDTSQueue);
        this.onBeforeRemoveByDstPSDEDTSQueue(pSDEDTSQueue, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEDTSQueue(pSDEDTSQueue, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDTSQueue(PSDEDTSQueue pSDEDTSQueue, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEFGROUP_DSTPSDEFGROUPID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetDstPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEFGroup(pSDEFGroup);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEFGroupId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEFGroup(pSDEFGroup2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEFGroup(pSDEFGroup2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByDstPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByDstPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByDstPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEFORM_DSTPSDEFORMID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetDstPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEForm(pSDEForm);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEFormId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEForm(pSDEForm2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEForm(pSDEForm2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByDstPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEForm(pSDEForm);
        this.onBeforeRemoveByDstPSDEForm(pSDEForm, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByDstPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEForm(PSDEForm pSDEForm, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEForm(PSDEForm pSDEForm, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEFValueRule(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEFVALUERULE_DSTPSDEFVALUERULEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEFValueRule(pSDEFValueRule);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEFValueRuleId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEFValueRule(pSDEFValueRule2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEFValueRule(pSDEFValueRule2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEFValueRule(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEFValueRule(pSDEFValueRule);
        this.onBeforeRemoveByDstPSDEFValueRule(pSDEFValueRule, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEFValueRule(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    public void resetDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDLParamId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void resetTempDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDLParamId(null);
            this.updateTemp((IEntity)pSDELogicNode2);
        }
    }

    public void removeByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByISPSDLParam(pSDELogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDELOGICPARAM_ISPSDLPARAMID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDELogicParam), arrayList.get(0)));
        }
    }

    public void resetISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByISPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setISPSDLParamId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void resetTempISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByISPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setISPSDLParamId(null);
            this.updateTemp((IEntity)pSDELogicNode2);
        }
    }

    public void removeByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByISPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveByISPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByISPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByISPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByISPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByISPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByISPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByISPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByOptPSDLParam(pSDELogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDELOGICPARAM_OPTPSDLPARAMID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDELogicParam), arrayList.get(0)));
        }
    }

    public void resetOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByOptPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setOptPSDLParamId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void resetTempOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByOptPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setOptPSDLParamId(null);
            this.updateTemp((IEntity)pSDELogicNode2);
        }
    }

    public void removeByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByOptPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveByOptPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByOptPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByOptPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByOptPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByOptPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByOptPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOptPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByOSPSDLParam(pSDELogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDELOGICPARAM_OSPSDLPARAMID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDELogicParam), arrayList.get(0)));
        }
    }

    public void resetOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByOSPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setOSPSDLParamId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void resetTempOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByOSPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setOSPSDLParamId(null);
            this.updateTemp((IEntity)pSDELogicNode2);
        }
    }

    public void removeByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByOSPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveByOSPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByOSPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByOSPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByOSPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByOSPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByOSPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOSPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByRetPSDLParam(pSDELogicParam, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGICPARAM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogicParam);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDELOGICPARAM_RETPSDLPARAMID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDELogicParam), arrayList.get(0)));
        }
    }

    public void resetRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByRetPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setRetPSDLParamId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void resetTempRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByRetPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setRetPSDLParamId(null);
            this.updateTemp((IEntity)pSDELogicNode2);
        }
    }

    public void removeByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByRetPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveByRetPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByRetPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByRetPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByRetPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByRetPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByRetPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRetPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    public void resetSrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectBySrcPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setSrcPSDLParamId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void resetTempSrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempBySrcPSDLParam(pSDELogicParam);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setSrcPSDLParamId(null);
            this.updateTemp((IEntity)pSDELogicNode2);
        }
    }

    public void removeBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveBySrcPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveBySrcPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveBySrcPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectBySrcPSDLParam(pSDELogicParam);
        this.onBeforeRemoveBySrcPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveBySrcPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataFlow(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDELOGIC_DSTPSDEDATAFLOWID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetDstPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataFlow(pSDELogic);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEDataFlowId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEDataFlow(pSDELogic2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEDataFlow(pSDELogic2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEDataFlow(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByDstPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEDataFlow(pSDELogic);
        this.onBeforeRemoveByDstPSDEDataFlow(pSDELogic, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEDataFlow(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByDstPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEDataFlow(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEDataFlow(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDELOGIC_DSTPSDELOGICID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDELogic(pSDELogic);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDELogicId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDELogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDELogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDELogic(pSDELogic);
        this.onBeforeRemoveByDstPSDELogic(pSDELogic, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByDstPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEUILogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUILogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDELOGIC_DSTPSDEUILOGICID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetDstPSDEUILogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUILogic(pSDELogic);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEUILogicId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEUILogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEUILogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEUILogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEUILogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEUILogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByDstPSDEUILogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUILogic(pSDELogic);
        this.onBeforeRemoveByDstPSDEUILogic(pSDELogic, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEUILogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByDstPSDEUILogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEUILogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEUILogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSDELogicId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void resetTempPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByPSDELogic(pSDELogic);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSDELogicId(null);
            this.updateTemp((IEntity)pSDELogicNode2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDEMainState(pSDEMainState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEMAINSTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEMainState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEMAINSTATE_PSDEMAINSTATEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEMainState), arrayList.get(0)));
        }
    }

    public void resetPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDEMainState(pSDEMainState);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSDEMainStateId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSDEMainState(pSDEMainState2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSDEMainState(pSDEMainState2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveByPSDEMainState(pSDEMainState, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEMap(pSDEMap, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEMAP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEMap);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEMAP_DSTPSDEMAPID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEMap), arrayList.get(0)));
        }
    }

    public void resetDstPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEMap(pSDEMap);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEMapId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEMap(pSDEMap2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEMap(pSDEMap2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveByDstPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEMap(pSDEMap);
        this.onBeforeRemoveByDstPSDEMap(pSDEMap, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveByDstPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEMap(PSDEMap pSDEMap, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEMap(PSDEMap pSDEMap, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDENotify(pSDENotify, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDENOTIFY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDENotify);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDENOTIFY_DSTPSDENOTIFYID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDENotify), arrayList.get(0)));
        }
    }

    public void resetDstPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDENotify(pSDENotify);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDENotifyId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDENotify(PSDENotify pSDENotify) throws Exception {
        final PSDENotify pSDENotify2 = pSDENotify;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDENotify(pSDENotify2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDENotify(pSDENotify2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDENotify(pSDENotify2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void internalRemoveByDstPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDENotify(pSDENotify);
        this.onBeforeRemoveByDstPSDENotify(pSDENotify, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDENotify(pSDENotify, arrayList);
    }

    protected void onAfterRemoveByDstPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDENotify(PSDENotify pSDENotify, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDENotify(PSDENotify pSDENotify, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEPrint(pSDEPrint, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPRINT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEPrint);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEPRINT_DSTPSDEPRINTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEPrint), arrayList.get(0)));
        }
    }

    public void resetDstPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEPrint(pSDEPrint);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEPrintId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        final PSDEPrint pSDEPrint2 = pSDEPrint;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEPrint(pSDEPrint2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEPrint(pSDEPrint2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEPrint(pSDEPrint2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
    }

    protected void internalRemoveByDstPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEPrint(pSDEPrint);
        this.onBeforeRemoveByDstPSDEPrint(pSDEPrint, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEPrint(pSDEPrint, arrayList);
    }

    protected void onAfterRemoveByDstPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEPrint(PSDEPrint pSDEPrint, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEPrint(PSDEPrint pSDEPrint, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEReport(pSDEReport, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEREPORT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEReport);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEREPORT_DSTPSDEREPORTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEReport), arrayList.get(0)));
        }
    }

    public void resetDstPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEReport(pSDEReport);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEReportId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEReport(pSDEReport2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEReport(pSDEReport2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveByDstPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEReport(pSDEReport);
        this.onBeforeRemoveByDstPSDEReport(pSDEReport, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveByDstPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEReport(PSDEReport pSDEReport, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEReport(PSDEReport pSDEReport, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDESampleData(pSDESampleData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESAMPLEDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDESampleData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDESAMPLEDATA_DSTPSDESAMPLEDATAID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDESampleData), arrayList.get(0)));
        }
    }

    public void resetDstPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDESampleData(pSDESampleData);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDESampleDataId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDESampleData(pSDESampleData2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDESampleData(pSDESampleData2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByDstPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByDstPSDESampleData(pSDESampleData, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByDstPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEUAGROUP_DSTPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUAGroup(pSDEUAGroup);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEUAGroupId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEUAGroup(pSDEUAGroup2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEUAGroup(pSDEUAGroup2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByDstPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSDEUIActionId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUtilDE(pSDEUtilDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUTILDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUtilDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEUTILDE_DSTDEUTILDEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEUtilDE), arrayList.get(0)));
        }
    }

    public void resetDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUtilDE(pSDEUtilDE);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEUtilDEId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE) throws Exception {
        final PSDEUtilDE pSDEUtilDE2 = pSDEUtilDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEUtilDE(pSDEUtilDE2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEUtilDE(pSDEUtilDE2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEUtilDE(pSDEUtilDE2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE) throws Exception {
    }

    protected void internalRemoveByDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEUtilDE(pSDEUtilDE);
        this.onBeforeRemoveByDstPSDEUtilDE(pSDEUtilDE, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEUtilDE(pSDEUtilDE, arrayList);
    }

    protected void onAfterRemoveByDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEUtilDE(PSDEUtilDE pSDEUtilDE, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEVIEWBASE_DSTPSDEVIEWID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetDstPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEView(pSDEViewBase);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEViewId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEView(pSDEViewBase2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEView(pSDEViewBase2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByDstPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEView(pSDEViewBase);
        this.onBeforeRemoveByDstPSDEView(pSDEViewBase, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByDstPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEVRGroup(pSDEVRGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVRGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEVRGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEVRGROUP_DSTPSDEVRGROUPID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEVRGroup), arrayList.get(0)));
        }
    }

    public void resetDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEVRGroup(pSDEVRGroup);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEVRGroupId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        final PSDEVRGroup pSDEVRGroup2 = pSDEVRGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEVRGroup(pSDEVRGroup2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEVRGroup(pSDEVRGroup2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEVRGroup(pSDEVRGroup2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void internalRemoveByDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEVRGroup(pSDEVRGroup);
        this.onBeforeRemoveByDstPSDEVRGroup(pSDEVRGroup, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEVRGroup(pSDEVRGroup, arrayList);
    }

    protected void onAfterRemoveByDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEVRGroup(PSDEVRGroup pSDEVRGroup, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEWizard(pSDEWizard, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEWIZARD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEWizard);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSDEWIZARD_DSTPSDEWIZARDID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSDEWizard), arrayList.get(0)));
        }
    }

    public void resetDstPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEWizard(pSDEWizard);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setDstPSDEWizardId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByDstPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByDstPSDEWizard(pSDEWizard2);
                PSDELogicNodeServiceBase.this.internalRemoveByDstPSDEWizard(pSDEWizard2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByDstPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveByDstPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByDstPSDEWizard(pSDEWizard);
        this.onBeforeRemoveByDstPSDEWizard(pSDEWizard, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByDstPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveByDstPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByMsgPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByMsgPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSLANGUAGERES_MSGPSLANRESID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetMsgPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByMsgPSLanRes(pSLanguageRes);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setMsgPSLanResId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByMsgPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByMsgPSLanRes(pSLanguageRes2);
                PSDELogicNodeServiceBase.this.internalRemoveByMsgPSLanRes(pSLanguageRes2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByMsgPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByMsgPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByMsgPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByMsgPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByMsgPSLanRes(pSLanguageRes, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByMsgPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByMsgPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByMsgPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMsgPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADETAIL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADetail);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADetail), arrayList.get(0)));
        }
    }

    public void resetPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSubSysSADetailId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        final PSSubSysSADetail pSSubSysSADetail2 = pSSubSysSADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSubSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSubSysServiceAPIId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIChatAgent(pSSysAIChatAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAICHATAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIChatAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSAICHATAGENT_PSSYSAICHATAGENTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysAIChatAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIChatAgent(pSSysAIChatAgent);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysAIChatAgentId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        final PSSysAIChatAgent pSSysAIChatAgent2 = pSSysAIChatAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysAIChatAgent(pSSysAIChatAgent2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysAIChatAgent(pSSysAIChatAgent2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysAIChatAgent(pSSysAIChatAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIChatAgent(pSSysAIChatAgent);
        this.onBeforeRemoveByPSSysAIChatAgent(pSSysAIChatAgent, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysAIChatAgent(pSSysAIChatAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIChatAgent(PSSysAIChatAgent pSSysAIChatAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIFACTORY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIFactory);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSAIFACTORY_PSSYSAIFACTORYID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysAIFactory), arrayList.get(0)));
        }
    }

    public void resetPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysAIFactoryId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        final PSSysAIFactory pSSysAIFactory2 = pSSysAIFactory;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void internalRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIPIPELINEAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIPipelineAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysAIPipelineAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysAIPipelineAgentId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        final PSSysAIPipelineAgent pSSysAIPipelineAgent2 = pSSysAIPipelineAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        this.onBeforeRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIWORKERAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIWorkerAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSAIWORKERAGENT_PSSYSAIWORKERAGENTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysAIWorkerAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysAIWorkerAgentId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        final PSSysAIWorkerAgent pSSysAIWorkerAgent2 = pSSysAIWorkerAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        this.onBeforeRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBackService(PSSysBackService pSSysBackService) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBackService(pSSysBackService, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBACKSERVICE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBackService);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSBACKSERVICE_PSSYSBACKSERVICEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysBackService), arrayList.get(0)));
        }
    }

    public void resetPSSysBackService(PSSysBackService pSSysBackService) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBackService(pSSysBackService);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysBackServiceId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysBackService(PSSysBackService pSSysBackService) throws Exception {
        final PSSysBackService pSSysBackService2 = pSSysBackService;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysBackService(pSSysBackService2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysBackService(pSSysBackService2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysBackService(pSSysBackService2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBackService(PSSysBackService pSSysBackService) throws Exception {
    }

    protected void internalRemoveByPSSysBackService(PSSysBackService pSSysBackService) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBackService(pSSysBackService);
        this.onBeforeRemoveByPSSysBackService(pSSysBackService, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysBackService(pSSysBackService, arrayList);
    }

    protected void onAfterRemoveByPSSysBackService(PSSysBackService pSSysBackService) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBackService(PSSysBackService pSSysBackService, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBackService(PSSysBackService pSSysBackService, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysBDScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysBDSchemeId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        final PSSysBDScheme pSSysBDScheme2 = pSSysBDScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBDTable(pSSysBDTable, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDTABLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDTable);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSBDTABLE_PSSYSBDTABLEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysBDTable), arrayList.get(0)));
        }
    }

    public void resetPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysBDTableId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysBDTable(pSSysBDTable2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysBDTable(pSSysBDTable2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByPSSysBDTable(pSSysBDTable, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIAggTable(pSSysBIAggTable, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBIAGGTABLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBIAggTable);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysBIAggTable), arrayList.get(0)));
        }
    }

    public void resetPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIAggTable(pSSysBIAggTable);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysBIAggTableId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        final PSSysBIAggTable pSSysBIAggTable2 = pSSysBIAggTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysBIAggTable(pSSysBIAggTable2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysBIAggTable(pSSysBIAggTable2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysBIAggTable(pSSysBIAggTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
    }

    protected void internalRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIAggTable(pSSysBIAggTable);
        this.onBeforeRemoveByPSSysBIAggTable(pSSysBIAggTable, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysBIAggTable(pSSysBIAggTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBICube(pSSysBICube, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBICube);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSBICUBE_PSSYSBICUBEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysBICube), arrayList.get(0)));
        }
    }

    public void resetPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBICube(pSSysBICube);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysBICubeId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        final PSSysBICube pSSysBICube2 = pSSysBICube;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysBICube(pSSysBICube2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysBICube(pSSysBICube2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysBICube(pSSysBICube2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void internalRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBICube(pSSysBICube);
        this.onBeforeRemoveByPSSysBICube(pSSysBICube, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysBICube(pSSysBICube, arrayList);
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIReport(pSSysBIReport, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBIREPORT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBIReport);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSBIREPORT_PSSYSBIREPORTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysBIReport), arrayList.get(0)));
        }
    }

    public void resetPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIReport(pSSysBIReport);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysBIReportId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        final PSSysBIReport pSSysBIReport2 = pSSysBIReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysBIReport(pSSysBIReport2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysBIReport(pSSysBIReport2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysBIReport(pSSysBIReport2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
    }

    protected void internalRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIReport(pSSysBIReport);
        this.onBeforeRemoveByPSSysBIReport(pSSysBIReport, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysBIReport(pSSysBIReport, arrayList);
    }

    protected void onAfterRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSBISCHEME_PSSYSBISCHEMEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysBIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysBISchemeId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        final PSSysBIScheme pSSysBIScheme2 = pSSysBIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDatasyncAgent(pSSysDataSyncAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDATASYNCAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDataSyncAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSDATASYNCAGENT_PSSYSDATASYNCAGENTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysDataSyncAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDatasyncAgent(pSSysDataSyncAgent);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysDataSyncAgentId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        final PSSysDataSyncAgent pSSysDataSyncAgent2 = pSSysDataSyncAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysDatasyncAgent(pSSysDataSyncAgent2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysDatasyncAgent(pSSysDataSyncAgent2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysDatasyncAgent(pSSysDataSyncAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void internalRemoveByPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDatasyncAgent(pSSysDataSyncAgent);
        this.onBeforeRemoveByPSSysDatasyncAgent(pSSysDataSyncAgent, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysDatasyncAgent(pSSysDataSyncAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDatasyncAgent(PSSysDataSyncAgent pSSysDataSyncAgent, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDBScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSDBSCHEME_PSSYSDBSCHEMEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysDBScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysDBSchemeId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        final PSSysDBScheme pSSysDBScheme2 = pSSysDBScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void internalRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDBTable(pSSysDBTable, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBTABLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDBTable);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSDBTABLE_PSSYSDBTABLEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysDBTable), arrayList.get(0)));
        }
    }

    public void resetPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDBTable(pSSysDBTable);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysDBTableId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        final PSSysDBTable pSSysDBTable2 = pSSysDBTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysDBTable(pSSysDBTable2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysDBTable(pSSysDBTable2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysDBTable(pSSysDBTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void internalRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDBTable(pSSysDBTable);
        this.onBeforeRemoveByPSSysDBTable(pSSysDBTable, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysDBTable(pSSysDBTable, arrayList);
    }

    protected void onAfterRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDELogicNode(pSSysDELogicNode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDELOGICNODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDELogicNode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSDELOGICNODE_PSSYSDELOGICNODEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysDELogicNode), arrayList.get(0)));
        }
    }

    public void resetPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDELogicNode(pSSysDELogicNode);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysDELogicNodeId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        final PSSysDELogicNode pSSysDELogicNode2 = pSSysDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysDELogicNode(pSSysDELogicNode2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysDELogicNode(pSSysDELogicNode2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysDELogicNode(pSSysDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
    }

    protected void internalRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysDELogicNode(pSSysDELogicNode);
        this.onBeforeRemoveByPSSysDELogicNode(pSSysDELogicNode, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysDELogicNode(pSSysDELogicNode, arrayList);
    }

    protected void onAfterRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDELogicNode(PSSysDELogicNode pSSysDELogicNode, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIELEMENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIElement);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysEAIElement), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysEAIElementId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSEAISCHEME_PSSYSEAISCHEMEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysEAIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysEAISchemeId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        final PSSysEAIScheme pSSysEAIScheme2 = pSSysEAIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysMsgTemplId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysPFPluginId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysResourceId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHDOC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSearchDoc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysSearchDoc), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysSearchDocId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        final PSSysSearchDoc pSSysSearchDoc2 = pSSysSearchDoc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void internalRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSearchScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysSearchScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysSearchSchemeId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        final PSSysSearchScheme pSSysSearchScheme2 = pSSysSearchScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void internalRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysSFPluginId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSqlCmd(pSSysSQLCmd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSQLCMD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSQLCmd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSSQLCMD_PSSYSSQLCMDID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysSQLCmd), arrayList.get(0)));
        }
    }

    public void resetPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSqlCmd(pSSysSQLCmd);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysSQLCmdId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
        final PSSysSQLCmd pSSysSQLCmd2 = pSSysSQLCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysSqlCmd(pSSysSQLCmd2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysSqlCmd(pSSysSQLCmd2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysSqlCmd(pSSysSQLCmd2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
    }

    protected void internalRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysSqlCmd(pSSysSQLCmd);
        this.onBeforeRemoveByPSSysSqlCmd(pSSysSQLCmd, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysSqlCmd(pSSysSQLCmd, arrayList);
    }

    protected void onAfterRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysUniState(pSSysUniState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNISTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSUNISTATE_PSSYSUNISTATEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysUniState), arrayList.get(0)));
        }
    }

    public void resetPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysUniState(pSSysUniState);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysUniStateId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        final PSSysUniState pSSysUniState2 = pSSysUniState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysUniState(pSSysUniState2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysUniState(pSSysUniState2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysUniState(pSSysUniState2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void internalRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysUniState(pSSysUniState);
        this.onBeforeRemoveByPSSysUniState(pSSysUniState, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysUniState(pSSysUniState, arrayList);
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUTILDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUtilDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSSYSUTILDE_PSSYSUTILDEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSSysUtilDE), arrayList.get(0)));
        }
    }

    public void resetPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSSysUtilDEId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        final PSSysUtilDE pSSysUtilDE2 = pSSysUtilDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void internalRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSViewMsg(pSViewMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSVIEWMSG_PSVIEWMSGID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSViewMsg), arrayList.get(0)));
        }
    }

    public void resetPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSViewMsg(pSViewMsg);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSViewMsgId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        final PSViewMsg pSViewMsg2 = pSViewMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSViewMsg(pSViewMsg2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSViewMsg(pSViewMsg2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSViewMsg(pSViewMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
    }

    protected void internalRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSViewMsg(pSViewMsg);
        this.onBeforeRemoveByPSViewMsg(pSViewMsg, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSViewMsg(pSViewMsg, arrayList);
    }

    protected void onAfterRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsg(PSViewMsg pSViewMsg, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsg(PSViewMsg pSViewMsg, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSWF(pSWFDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWFDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSWFDE_PSWFDEID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSWFDE), arrayList.get(0)));
        }
    }

    public void resetPSWF(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSWF(pSWFDE);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSWFDEId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSWF(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSWF(pSWFDE2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSWF(pSWFDE2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSWF(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSWF(pSWFDE);
        this.onBeforeRemoveByPSWF(pSWFDE, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSWF(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWFDE pSWFDE, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWFDE pSWFDE, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSWorkflow(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELOGICNODE_PSWORKFLOW_PSWORKFLOWID", "", iDataEntityModel.getName(), "PSDELOGICNODE", iDataEntityModel.getDataInfo((IEntity)pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSWorkflow(pSWorkflow);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            PSDELogicNode pSDELogicNode2 = (PSDELogicNode)this.getDEModel().createEntity();
            pSDELogicNode2.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            pSDELogicNode2.setPSWorkflowId(null);
            this.update(pSDELogicNode2);
        }
    }

    public void removeByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveByPSWorkflow(pSWorkflow2);
                PSDELogicNodeServiceBase.this.internalRemoveByPSWorkflow(pSWorkflow2);
                PSDELogicNodeServiceBase.this.onAfterRemoveByPSWorkflow(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectByPSWorkflow(pSWorkflow);
        this.onBeforeRemoveByPSWorkflow(pSWorkflow, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.remove((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveByPSWorkflow(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWorkflow(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkflow(PSWorkflow pSWorkflow, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkflow(PSWorkflow pSWorkflow, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDELogicNode pSDELogicNode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDELogicNode(pSDELogicNode);
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).removeByPSDELogicNode(pSDELogicNode);
        pSCoreSysServiceBase = (PSDELogicLinkService)ServiceGlobal.getService(PSDELogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicLinkServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDELogicNode(pSDELogicNode);
        ((PSDELogicLinkServiceBase)pSCoreSysServiceBase).removeByDstPSDELogicNode(pSDELogicNode);
        pSCoreSysServiceBase = (PSDELogicLinkService)ServiceGlobal.getService(PSDELogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicLinkServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSDELogicNode(pSDELogicNode);
        ((PSDELogicLinkServiceBase)pSCoreSysServiceBase).removeBySrcPSDELogicNode(pSDELogicNode);
        super.onBeforeRemove(pSDELogicNode);
    }

    protected void onBeforeRemoveTemp(PSDELogicNode pSDELogicNode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).removeTempByPSDELogicNode(pSDELogicNode);
        pSCoreSysServiceBase = (PSDELogicLinkService)ServiceGlobal.getService(PSDELogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicLinkServiceBase)pSCoreSysServiceBase).resetTempSrcPSDELogicNode(pSDELogicNode);
        pSCoreSysServiceBase = (PSDELogicLinkService)ServiceGlobal.getService(PSDELogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicLinkServiceBase)pSCoreSysServiceBase).resetTempDstPSDELogicNode(pSDELogicNode);
        super.onBeforeRemoveTemp((IEntity)pSDELogicNode);
    }

    public void removeTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.removeTemp((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void removeTempByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveTempByISPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveTempByISPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveTempByISPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByISPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByISPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.removeTemp((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveTempByISPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByISPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByISPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByISPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void removeTempByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveTempByOptPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveTempByOptPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveTempByOptPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByOptPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByOptPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.removeTemp((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveTempByOptPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByOptPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByOptPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByOptPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void removeTempByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveTempByOSPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveTempByOSPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveTempByOSPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByOSPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByOSPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.removeTemp((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveTempByOSPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByOSPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByOSPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByOSPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void removeTempByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveTempByRetPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveTempByRetPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveTempByRetPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByRetPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByRetPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.removeTemp((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveTempByRetPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByRetPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByRetPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByRetPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void removeTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveTempBySrcPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.internalRemoveTempBySrcPSDLParam(pSDELogicParam2);
                PSDELogicNodeServiceBase.this.onAfterRemoveTempBySrcPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempBySrcPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempBySrcPSDLParam(pSDELogicParam, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.removeTemp((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveTempBySrcPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    public void removeTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicNodeServiceBase.this.onBeforeRemoveTempByPSDELogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.internalRemoveTempByPSDELogic(pSDELogic2);
                PSDELogicNodeServiceBase.this.onAfterRemoveTempByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDELogicNode> arrayList = this.selectTempByPSDELogic(pSDELogic);
        this.onBeforeRemoveTempByPSDELogic(pSDELogic, arrayList);
        for (PSDELogicNode pSDELogicNode : arrayList) {
            this.removeTemp((IEntity)pSDELogicNode);
        }
        this.onAfterRemoveTempByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveTempByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDELogicNode> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDELogicNode pSDELogicNode) throws Exception {
        this.getRelatedDataTempMajor_PSDELNParam(pSDELogicNode);
        super.getRelatedDataTempMajor((IEntity)pSDELogicNode);
    }

    protected void getRelatedDataTempMajor_PSDELNParam(PSDELogicNode pSDELogicNode) throws Exception {
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELNParam> arrayList = null;
        String string = pSDELogicNode.getPSDELogicNodeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDELNParamService.selectByPSDELogicNode(pSDELogicNode) : pSDELNParamService.selectTempByPSDELogicNode(pSDELogicNode);
        for (PSDELNParam pSDELNParam : arrayList) {
            pSDELNParamService.getTempMajor(pSDELNParam);
        }
    }

    protected void updateRelatedDataTempMajor(PSDELogicNode pSDELogicNode, PSDELogicNode pSDELogicNode2) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.updateRelatedDataTempMajor_removePSDELNParam(pSDELogicNode, pSDELogicNode2);
        this.updateRelatedDataTempMajor_updatePSDELNParam(pSDELogicNode, pSDELogicNode2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDELogicNode, (IEntity)pSDELogicNode2);
    }

    protected ArrayList<PSDELNParam> updateRelatedDataTempMajor_removePSDELNParam(PSDELogicNode pSDELogicNode, PSDELogicNode pSDELogicNode2) throws Exception {
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELNParam> arrayList = pSDELNParamService.selectTempByPSDELogicNode(pSDELogicNode);
        ArrayList<PSDELNParam> arrayList2 = pSDELNParamService.selectByPSDELogicNode(pSDELogicNode2);
        HashMap<String, PSDELNParam> hashMap = new HashMap<String, PSDELNParam>();
        for (PSDELNParam pSDELNParam : arrayList2) {
            hashMap.put(pSDELNParam.getPSDELNParamId(), pSDELNParam);
        }
        for (PSDELNParam pSDELNParam : arrayList) {
            Object object = pSDELNParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDELNParam pSDELNParam : hashMap.values()) {
            pSDELNParamService.remove((IEntity)pSDELNParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDELNParam(PSDELogicNode pSDELogicNode, PSDELogicNode pSDELogicNode2, ArrayList<PSDELNParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSDELNParam pSDELNParam : arrayList) {
            pSDELNParamService.updateTempMajor(pSDELNParam);
        }
    }

    protected void replaceParentInfo(PSDELogicNode pSDELogicNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDELogicNode, cloneSession);
        if (pSDELogicNode.getDstPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDELogicNode.getDstPSDEId())) != null) {
            this.onFillParentInfo_DstPSDE(pSDELogicNode, (PSDataEntity)iEntity);
        }
        if (pSDELogicNode.getDstPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDELogicNode.getDstPSDEActionId())) != null) {
            this.onFillParentInfo_DstPSDEAction(pSDELogicNode, (PSDEAction)iEntity);
        }
        if (pSDELogicNode.getDstPSDEDataExpId() != null && (iEntity = cloneSession.getEntity("PSDEDATAEXP", (Object)pSDELogicNode.getDstPSDEDataExpId())) != null) {
            this.onFillParentInfo_DstPSDEDataExp(pSDELogicNode, (PSDEDataExp)iEntity);
        }
        if (pSDELogicNode.getDstPSDEDataImpId() != null && (iEntity = cloneSession.getEntity("PSDEDATAIMP", (Object)pSDELogicNode.getDstPSDEDataImpId())) != null) {
            this.onFillParentInfo_DstPSDEDataImp(pSDELogicNode, (PSDEDataImp)iEntity);
        }
        if (pSDELogicNode.getDstPSDEDataQueryId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDELogicNode.getDstPSDEDataQueryId())) != null) {
            this.onFillParentInfo_DstPSDEDataQuery(pSDELogicNode, (PSDEDataQuery)iEntity);
        }
        if (pSDELogicNode.getDstPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDELogicNode.getDstPSDEDataSetId())) != null) {
            this.onFillParentInfo_DstPSDEDataSet(pSDELogicNode, (PSDEDataSet)iEntity);
        }
        if (pSDELogicNode.getDstPSDEDataSyncId() != null && (iEntity = cloneSession.getEntity("PSDEDATASYNC", (Object)pSDELogicNode.getDstPSDEDataSyncId())) != null) {
            this.onFillParentInfo_DstPSDEDataSync(pSDELogicNode, (PSDEDataSync)iEntity);
        }
        if (pSDELogicNode.getDstPSDEDTSQueueId() != null && (iEntity = cloneSession.getEntity("PSDEDTSQUEUE", (Object)pSDELogicNode.getDstPSDEDTSQueueId())) != null) {
            this.onFillParentInfo_DstPSDEDTSQueue(pSDELogicNode, (PSDEDTSQueue)iEntity);
        }
        if (pSDELogicNode.getDstPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDELogicNode.getDstPSDEFGroupId())) != null) {
            this.onFillParentInfo_DstPSDEFGroup(pSDELogicNode, (PSDEFGroup)iEntity);
        }
        if (pSDELogicNode.getDstPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDELogicNode.getDstPSDEFormId())) != null) {
            this.onFillParentInfo_DstPSDEForm(pSDELogicNode, (PSDEForm)iEntity);
        }
        if (pSDELogicNode.getDstPSDEFValueRuleId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDELogicNode.getDstPSDEFValueRuleId())) != null) {
            this.onFillParentInfo_DstPSDEFValueRule(pSDELogicNode, (PSDEFValueRule)iEntity);
        }
        if (pSDELogicNode.getDstPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELogicNode.getDstPSDLParamId())) != null) {
            this.onFillParentInfo_DstPSDLParam(pSDELogicNode, (PSDELogicParam)iEntity);
        }
        if (pSDELogicNode.getISPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELogicNode.getISPSDLParamId())) != null) {
            this.onFillParentInfo_ISPSDLParam(pSDELogicNode, (PSDELogicParam)iEntity);
        }
        if (pSDELogicNode.getOptPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELogicNode.getOptPSDLParamId())) != null) {
            this.onFillParentInfo_OptPSDLParam(pSDELogicNode, (PSDELogicParam)iEntity);
        }
        if (pSDELogicNode.getOSPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELogicNode.getOSPSDLParamId())) != null) {
            this.onFillParentInfo_OSPSDLParam(pSDELogicNode, (PSDELogicParam)iEntity);
        }
        if (pSDELogicNode.getRetPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELogicNode.getRetPSDLParamId())) != null) {
            this.onFillParentInfo_RetPSDLParam(pSDELogicNode, (PSDELogicParam)iEntity);
        }
        if (pSDELogicNode.getSrcPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELogicNode.getSrcPSDLParamId())) != null) {
            this.onFillParentInfo_SrcPSDLParam(pSDELogicNode, (PSDELogicParam)iEntity);
        }
        if (pSDELogicNode.getDstPSDEDataFlowId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDELogicNode.getDstPSDEDataFlowId())) != null) {
            this.onFillParentInfo_DstPSDEDataFlow(pSDELogicNode, (PSDELogic)iEntity);
        }
        if (pSDELogicNode.getDstPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDELogicNode.getDstPSDELogicId())) != null) {
            this.onFillParentInfo_DstPSDELogic(pSDELogicNode, (PSDELogic)iEntity);
        }
        if (pSDELogicNode.getDstPSDEUILogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDELogicNode.getDstPSDEUILogicId())) != null) {
            this.onFillParentInfo_DstPSDEUILogic(pSDELogicNode, (PSDELogic)iEntity);
        }
        if (pSDELogicNode.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDELogicNode.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDELogicNode, (PSDELogic)iEntity);
        }
        if (pSDELogicNode.getPSDEMainStateId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDELogicNode.getPSDEMainStateId())) != null) {
            this.onFillParentInfo_PSDEMainState(pSDELogicNode, (PSDEMainState)iEntity);
        }
        if (pSDELogicNode.getDstPSDEMapId() != null && (iEntity = cloneSession.getEntity("PSDEMAP", (Object)pSDELogicNode.getDstPSDEMapId())) != null) {
            this.onFillParentInfo_DstPSDEMap(pSDELogicNode, (PSDEMap)iEntity);
        }
        if (pSDELogicNode.getDstPSDENotifyId() != null && (iEntity = cloneSession.getEntity("PSDENOTIFY", (Object)pSDELogicNode.getDstPSDENotifyId())) != null) {
            this.onFillParentInfo_DstPSDENotify(pSDELogicNode, (PSDENotify)iEntity);
        }
        if (pSDELogicNode.getDstPSDEPrintId() != null && (iEntity = cloneSession.getEntity("PSDEPRINT", (Object)pSDELogicNode.getDstPSDEPrintId())) != null) {
            this.onFillParentInfo_DstPSDEPrint(pSDELogicNode, (PSDEPrint)iEntity);
        }
        if (pSDELogicNode.getDstPSDEReportId() != null && (iEntity = cloneSession.getEntity("PSDEREPORT", (Object)pSDELogicNode.getDstPSDEReportId())) != null) {
            this.onFillParentInfo_DstPSDEReport(pSDELogicNode, (PSDEReport)iEntity);
        }
        if (pSDELogicNode.getDstPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSDELogicNode.getDstPSDESampleDataId())) != null) {
            this.onFillParentInfo_DstPSDESampleData(pSDELogicNode, (PSDESampleData)iEntity);
        }
        if (pSDELogicNode.getDstPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDELogicNode.getDstPSDEUAGroupId())) != null) {
            this.onFillParentInfo_DstPSDEUAGroup(pSDELogicNode, (PSDEUAGroup)iEntity);
        }
        if (pSDELogicNode.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDELogicNode.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDELogicNode, (PSDEUIAction)iEntity);
        }
        if (pSDELogicNode.getDstPSDEUtilDEId() != null && (iEntity = cloneSession.getEntity("PSDEUTILDE", (Object)pSDELogicNode.getDstPSDEUtilDEId())) != null) {
            this.onFillParentInfo_DstPSDEUtilDE(pSDELogicNode, (PSDEUtilDE)iEntity);
        }
        if (pSDELogicNode.getDstPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDELogicNode.getDstPSDEViewId())) != null) {
            this.onFillParentInfo_DstPSDEView(pSDELogicNode, (PSDEViewBase)iEntity);
        }
        if (pSDELogicNode.getDstPSDEVRGroupId() != null && (iEntity = cloneSession.getEntity("PSDEVRGROUP", (Object)pSDELogicNode.getDstPSDEVRGroupId())) != null) {
            this.onFillParentInfo_DstPSDEVRGroup(pSDELogicNode, (PSDEVRGroup)iEntity);
        }
        if (pSDELogicNode.getDstPSDEWizardId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARD", (Object)pSDELogicNode.getDstPSDEWizardId())) != null) {
            this.onFillParentInfo_DstPSDEWizard(pSDELogicNode, (PSDEWizard)iEntity);
        }
        if (pSDELogicNode.getMsgPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDELogicNode.getMsgPSLanResId())) != null) {
            this.onFillParentInfo_MsgPSLanRes(pSDELogicNode, (PSLanguageRes)iEntity);
        }
        if (pSDELogicNode.getPSSubSysSADetailId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADETAIL", (Object)pSDELogicNode.getPSSubSysSADetailId())) != null) {
            this.onFillParentInfo_PSSubSysSADetail(pSDELogicNode, (PSSubSysSADetail)iEntity);
        }
        if (pSDELogicNode.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSDELogicNode.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSDELogicNode, (PSSubSysServiceAPI)iEntity);
        }
        if (pSDELogicNode.getPSSysAIChatAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAICHATAGENT", (Object)pSDELogicNode.getPSSysAIChatAgentId())) != null) {
            this.onFillParentInfo_PSSysAIChatAgent(pSDELogicNode, (PSSysAIChatAgent)iEntity);
        }
        if (pSDELogicNode.getPSSysAIFactoryId() != null && (iEntity = cloneSession.getEntity("PSSYSAIFACTORY", (Object)pSDELogicNode.getPSSysAIFactoryId())) != null) {
            this.onFillParentInfo_PSSysAIFactory(pSDELogicNode, (PSSysAIFactory)iEntity);
        }
        if (pSDELogicNode.getPSSysAIPipelineAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAIPIPELINEAGENT", (Object)pSDELogicNode.getPSSysAIPipelineAgentId())) != null) {
            this.onFillParentInfo_PSSysAIPipelineAgent(pSDELogicNode, (PSSysAIPipelineAgent)iEntity);
        }
        if (pSDELogicNode.getPSSysAIWorkerAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAIWORKERAGENT", (Object)pSDELogicNode.getPSSysAIWorkerAgentId())) != null) {
            this.onFillParentInfo_PSSysAIWorkerAgent(pSDELogicNode, (PSSysAIWorkerAgent)iEntity);
        }
        if (pSDELogicNode.getPSSysBackServiceId() != null && (iEntity = cloneSession.getEntity("PSSYSBACKSERVICE", (Object)pSDELogicNode.getPSSysBackServiceId())) != null) {
            this.onFillParentInfo_PSSysBackService(pSDELogicNode, (PSSysBackService)iEntity);
        }
        if (pSDELogicNode.getPSSysBDSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBDSCHEME", (Object)pSDELogicNode.getPSSysBDSchemeId())) != null) {
            this.onFillParentInfo_PSSysBDScheme(pSDELogicNode, (PSSysBDScheme)iEntity);
        }
        if (pSDELogicNode.getPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSDELogicNode.getPSSysBDTableId())) != null) {
            this.onFillParentInfo_PSSysBDTable(pSDELogicNode, (PSSysBDTable)iEntity);
        }
        if (pSDELogicNode.getPSSysBIAggTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBIAGGTABLE", (Object)pSDELogicNode.getPSSysBIAggTableId())) != null) {
            this.onFillParentInfo_PSSysBIAggTable(pSDELogicNode, (PSSysBIAggTable)iEntity);
        }
        if (pSDELogicNode.getPSSysBICubeId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBE", (Object)pSDELogicNode.getPSSysBICubeId())) != null) {
            this.onFillParentInfo_PSSysBICube(pSDELogicNode, (PSSysBICube)iEntity);
        }
        if (pSDELogicNode.getPSSysBIReportId() != null && (iEntity = cloneSession.getEntity("PSSYSBIREPORT", (Object)pSDELogicNode.getPSSysBIReportId())) != null) {
            this.onFillParentInfo_PSSysBIReport(pSDELogicNode, (PSSysBIReport)iEntity);
        }
        if (pSDELogicNode.getPSSysBISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBISCHEME", (Object)pSDELogicNode.getPSSysBISchemeId())) != null) {
            this.onFillParentInfo_PSSysBIScheme(pSDELogicNode, (PSSysBIScheme)iEntity);
        }
        if (pSDELogicNode.getPSSysDataSyncAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSDATASYNCAGENT", (Object)pSDELogicNode.getPSSysDataSyncAgentId())) != null) {
            this.onFillParentInfo_PSSysDatasyncAgent(pSDELogicNode, (PSSysDataSyncAgent)iEntity);
        }
        if (pSDELogicNode.getPSSysDBSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSDBSCHEME", (Object)pSDELogicNode.getPSSysDBSchemeId())) != null) {
            this.onFillParentInfo_PSSysDBScheme(pSDELogicNode, (PSSysDBScheme)iEntity);
        }
        if (pSDELogicNode.getPSSysDBTableId() != null && (iEntity = cloneSession.getEntity("PSSYSDBTABLE", (Object)pSDELogicNode.getPSSysDBTableId())) != null) {
            this.onFillParentInfo_PSSysDBTable(pSDELogicNode, (PSSysDBTable)iEntity);
        }
        if (pSDELogicNode.getPSSysDELogicNodeId() != null && (iEntity = cloneSession.getEntity("PSSYSDELOGICNODE", (Object)pSDELogicNode.getPSSysDELogicNodeId())) != null) {
            this.onFillParentInfo_PSSysDELogicNode(pSDELogicNode, (PSSysDELogicNode)iEntity);
        }
        if (pSDELogicNode.getPSSysEAIElementId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENT", (Object)pSDELogicNode.getPSSysEAIElementId())) != null) {
            this.onFillParentInfo_PSSysEAIElement(pSDELogicNode, (PSSysEAIElement)iEntity);
        }
        if (pSDELogicNode.getPSSysEAISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAISCHEME", (Object)pSDELogicNode.getPSSysEAISchemeId())) != null) {
            this.onFillParentInfo_PSSysEAIScheme(pSDELogicNode, (PSSysEAIScheme)iEntity);
        }
        if (pSDELogicNode.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSDELogicNode.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSDELogicNode, (PSSysMsgTempl)iEntity);
        }
        if (pSDELogicNode.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDELogicNode.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDELogicNode, (PSSysPFPlugin)iEntity);
        }
        if (pSDELogicNode.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSDELogicNode.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSDELogicNode, (PSSysResource)iEntity);
        }
        if (pSDELogicNode.getPSSysSearchDocId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHDOC", (Object)pSDELogicNode.getPSSysSearchDocId())) != null) {
            this.onFillParentInfo_PSSysSearchDoc(pSDELogicNode, (PSSysSearchDoc)iEntity);
        }
        if (pSDELogicNode.getPSSysSearchSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHSCHEME", (Object)pSDELogicNode.getPSSysSearchSchemeId())) != null) {
            this.onFillParentInfo_PSSysSearchScheme(pSDELogicNode, (PSSysSearchScheme)iEntity);
        }
        if (pSDELogicNode.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDELogicNode.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDELogicNode, (PSSysSFPlugin)iEntity);
        }
        if (pSDELogicNode.getPSSysSQLCmdId() != null && (iEntity = cloneSession.getEntity("PSSYSSQLCMD", (Object)pSDELogicNode.getPSSysSQLCmdId())) != null) {
            this.onFillParentInfo_PSSysSqlCmd(pSDELogicNode, (PSSysSQLCmd)iEntity);
        }
        if (pSDELogicNode.getPSSysUniStateId() != null && (iEntity = cloneSession.getEntity("PSSYSUNISTATE", (Object)pSDELogicNode.getPSSysUniStateId())) != null) {
            this.onFillParentInfo_PSSysUniState(pSDELogicNode, (PSSysUniState)iEntity);
        }
        if (pSDELogicNode.getPSSysUtilDEId() != null && (iEntity = cloneSession.getEntity("PSSYSUTILDE", (Object)pSDELogicNode.getPSSysUtilDEId())) != null) {
            this.onFillParentInfo_PSSysUtilDE(pSDELogicNode, (PSSysUtilDE)iEntity);
        }
        if (pSDELogicNode.getPSViewMsgId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSG", (Object)pSDELogicNode.getPSViewMsgId())) != null) {
            this.onFillParentInfo_PSViewMsg(pSDELogicNode, (PSViewMsg)iEntity);
        }
        if (pSDELogicNode.getPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSDELogicNode.getPSWFDEId())) != null) {
            this.onFillParentInfo_PSWF(pSDELogicNode, (PSWFDE)iEntity);
        }
        if (pSDELogicNode.getPSWorkflowId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSDELogicNode.getPSWorkflowId())) != null) {
            this.onFillParentInfo_PSWorkflow(pSDELogicNode, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDELogicNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDELogicNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomDSTParam(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomSrcParam(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DebugMode(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEUtilDEId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstIndex(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstParamAction(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEActionId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEActionName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataExpId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataFlowId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataImpId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataQueryId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataSetId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDataSyncId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEDTSQueueId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFGroupId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFormId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFValueRuleId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDELogicId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEMapId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDENotifyId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEPrintId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEReportId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDESampleDataId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEUAGroupId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEUILogicId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEViewId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEVRGroupId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEWizardId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstSortDir(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ISPSDLParamId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ISPSDLParamName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicNodeSubType(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicNodeType(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgPSLanResId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgPSLanResName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeParams(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OptPSDLParamId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OptPSDLParamName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSPSDLParamId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSPSDLParamName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParallelOutput(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param1(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param10(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param11(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param12(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param13(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param14(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param2(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param3(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param4(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param5(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param6(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param7(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param8(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Param9(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicNodeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicNodeName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIChatAgentId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIFactoryId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineAgentId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIWorkerAgentId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBackServiceId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIAggTableId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIReportId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBISchemeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDataSyncAgentId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBSchemeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBTableId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDELogicNodeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAISchemeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDocId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchSchemeId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSQLCmdId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniStateId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUtilDEId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkflowId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetPSDLParamId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetPSDLParamName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeParams(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcIndex(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDLParamId(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDLParamName(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcSize(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadRunMode(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadRunTimer(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSMode(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDELogicNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isCodeNameDirty() && !bl2 : !pSDELogicNode.isCodeNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDELOGICID";
                String string4 = this.checkFieldDupRule(this.getPSDELogicNodeDEModel(), "CODENAME", string3, pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomDSTParam(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isCustomDSTParamDirty() : !pSDELogicNode.isCustomDSTParamDirty()) {
            return null;
        }
        String string = pSDELogicNode.getCustomDSTParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomDSTParam_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMDSTPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomSrcParam(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isCustomSrcParamDirty() : !pSDELogicNode.isCustomSrcParamDirty()) {
            return null;
        }
        String string = pSDELogicNode.getCustomSrcParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomSrcParam_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMSRCPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DebugMode(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDebugModeDirty() : !pSDELogicNode.isDebugModeDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getDebugMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DebugMode_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEBUGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEUtilDEId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEUtilDEIdDirty() : !pSDELogicNode.isDstPSDEUtilDEIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEUtilDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEUtilDEId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTDEUTILDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstIndex(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstIndexDirty() : !pSDELogicNode.isDstIndexDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getDstIndex();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DstIndex_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTINDEX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstParamAction(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstParamActionDirty() : !pSDELogicNode.isDstParamActionDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstParamAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstParamAction_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPARAMACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEActionId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEActionIdDirty() : !pSDELogicNode.isDstPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEActionId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEActionName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEActionNameDirty() : !pSDELogicNode.isDstPSDEActionNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEActionName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataExpId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEDataExpIdDirty() : !pSDELogicNode.isDstPSDEDataExpIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEDataExpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataExpId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATAEXPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataFlowId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEDataFlowIdDirty() : !pSDELogicNode.isDstPSDEDataFlowIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEDataFlowId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataFlowId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATAFLOWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataImpId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEDataImpIdDirty() : !pSDELogicNode.isDstPSDEDataImpIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEDataImpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataImpId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATAIMPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataQueryId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEDataQueryIdDirty() : !pSDELogicNode.isDstPSDEDataQueryIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEDataQueryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataQueryId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATAQUERYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataSetId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEDataSetIdDirty() : !pSDELogicNode.isDstPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataSetId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDataSyncId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEDataSyncIdDirty() : !pSDELogicNode.isDstPSDEDataSyncIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEDataSyncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDataSyncId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDATASYNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEDTSQueueId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEDTSQueueIdDirty() : !pSDELogicNode.isDstPSDEDTSQueueIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEDTSQueueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEDTSQueueId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEDTSQUEUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFGroupId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEFGroupIdDirty() : !pSDELogicNode.isDstPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFGroupId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFormId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEFormIdDirty() : !pSDELogicNode.isDstPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFormId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFValueRuleId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEFValueRuleIdDirty() : !pSDELogicNode.isDstPSDEFValueRuleIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEFValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFValueRuleId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEIdDirty() : !pSDELogicNode.isDstPSDEIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDELogicId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDELogicIdDirty() : !pSDELogicNode.isDstPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDELogicId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEMapId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEMapIdDirty() : !pSDELogicNode.isDstPSDEMapIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEMapId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEMapId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDENameDirty() : !pSDELogicNode.isDstPSDENameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDENotifyId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDENotifyIdDirty() : !pSDELogicNode.isDstPSDENotifyIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDENotifyId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDENotifyId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDENOTIFYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEPrintId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEPrintIdDirty() : !pSDELogicNode.isDstPSDEPrintIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEPrintId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEPrintId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEPRINTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEReportId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEReportIdDirty() : !pSDELogicNode.isDstPSDEReportIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEReportId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEReportId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDESampleDataId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDESampleDataIdDirty() : !pSDELogicNode.isDstPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDESampleDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDESampleDataId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEUAGroupId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEUAGroupIdDirty() : !pSDELogicNode.isDstPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEUAGroupId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEUILogicId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEUILogicIdDirty() : !pSDELogicNode.isDstPSDEUILogicIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEUILogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEUILogicId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEUILOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEViewId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEViewIdDirty() : !pSDELogicNode.isDstPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEViewId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEVRGroupId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEVRGroupIdDirty() : !pSDELogicNode.isDstPSDEVRGroupIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEVRGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEVRGroupId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVRGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEWizardId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDEWizardIdDirty() : !pSDELogicNode.isDstPSDEWizardIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDEWizardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEWizardId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDLParamId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDLParamIdDirty() : !pSDELogicNode.isDstPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDLParamName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstPSDLParamNameDirty() : !pSDELogicNode.isDstPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstSortDir(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDstSortDirDirty() : !pSDELogicNode.isDstSortDirDirty()) {
            return null;
        }
        String string = pSDELogicNode.getDstSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstSortDir_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isDynaModelFlagDirty() : !pSDELogicNode.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ISPSDLParamId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isISPSDLParamIdDirty() : !pSDELogicNode.isISPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getISPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ISPSDLParamId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ISPSDLParamName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isISPSDLParamNameDirty() : !pSDELogicNode.isISPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getISPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ISPSDLParamName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isLeftPosDirty() : !pSDELogicNode.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicNodeSubType(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isLogicNodeSubTypeDirty() : !pSDELogicNode.isLogicNodeSubTypeDirty()) {
            return null;
        }
        String string = pSDELogicNode.getLogicNodeSubType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicNodeSubType_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNODESUBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicNodeType(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isLogicNodeTypeDirty() && !bl2 : !pSDELogicNode.isLogicNodeTypeDirty()) {
            return null;
        }
        String string = pSDELogicNode.getLogicNodeType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNODETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicNodeType_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNODETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isMemoDirty() : !pSDELogicNode.isMemoDirty()) {
            return null;
        }
        String string = pSDELogicNode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_MsgPSLanResId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isMsgPSLanResIdDirty() : !pSDELogicNode.isMsgPSLanResIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getMsgPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgPSLanResId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgPSLanResName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isMsgPSLanResNameDirty() : !pSDELogicNode.isMsgPSLanResNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getMsgPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgPSLanResName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeParams(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isNodeParamsDirty() : !pSDELogicNode.isNodeParamsDirty()) {
            return null;
        }
        String string = pSDELogicNode.getNodeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeParams_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OptPSDLParamId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isOptPSDLParamIdDirty() : !pSDELogicNode.isOptPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getOptPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OptPSDLParamId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPTPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OptPSDLParamName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isOptPSDLParamNameDirty() : !pSDELogicNode.isOptPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getOptPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OptPSDLParamName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPTPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isOrderValueDirty() : !pSDELogicNode.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_OSPSDLParamId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isOSPSDLParamIdDirty() : !pSDELogicNode.isOSPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getOSPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSPSDLParamId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OSPSDLParamName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isOSPSDLParamNameDirty() : !pSDELogicNode.isOSPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getOSPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSPSDLParamName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParallelOutput(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParallelOutputDirty() : !pSDELogicNode.isParallelOutputDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getParallelOutput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ParallelOutput_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARALLELOUTPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param1(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam1Dirty() : !pSDELogicNode.isParam1Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam1();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param1_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM1");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param10(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam10Dirty() : !pSDELogicNode.isParam10Dirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param10_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param11(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam11Dirty() : !pSDELogicNode.isParam11Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param11_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param12(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam12Dirty() : !pSDELogicNode.isParam12Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param12_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param13(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam13Dirty() : !pSDELogicNode.isParam13Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam13();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param13_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM13");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param14(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam14Dirty() : !pSDELogicNode.isParam14Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam14();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param14_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM14");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param2(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam2Dirty() : !pSDELogicNode.isParam2Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param2_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param3(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam3Dirty() : !pSDELogicNode.isParam3Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param3_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param4(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam4Dirty() : !pSDELogicNode.isParam4Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param4_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Param5(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam5Dirty() : !pSDELogicNode.isParam5Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param5_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param6(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam6Dirty() : !pSDELogicNode.isParam6Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Param6_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param7(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam7Dirty() : !pSDELogicNode.isParam7Dirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param7_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param8(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam8Dirty() : !pSDELogicNode.isParam8Dirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param8_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Param9(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isParam9Dirty() : !pSDELogicNode.isParam9Dirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Param9_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSDEIdDirty() : !pSDELogicNode.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSDELogicIdDirty() && !bl2 : !pSDELogicNode.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSDELogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicNodeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSDELogicNodeIdDirty() && !bl2 : !pSDELogicNode.isPSDELogicNodeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSDELogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicNodeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicNodeName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSDELogicNodeNameDirty() && !bl2 : !pSDELogicNode.isPSDELogicNodeNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSDELogicNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicNodeName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSDEMainStateIdDirty() : !pSDELogicNode.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSDEMainStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSDEUIActionIdDirty() : !pSDELogicNode.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSDynaInstIdDirty() : !pSDELogicNode.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADetailId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSubSysSADetailIdDirty() : !pSDELogicNode.isPSSubSysSADetailIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSubSysSADetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSubSysServiceAPIIdDirty() : !pSDELogicNode.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIChatAgentId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysAIChatAgentIdDirty() : !pSDELogicNode.isPSSysAIChatAgentIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysAIChatAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIChatAgentId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAICHATAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIFactoryId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysAIFactoryIdDirty() : !pSDELogicNode.isPSSysAIFactoryIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysAIFactoryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIFactoryId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIFACTORYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIPipelineAgentId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysAIPipelineAgentIdDirty() : !pSDELogicNode.isPSSysAIPipelineAgentIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysAIPipelineAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineAgentId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIWorkerAgentId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysAIWorkerAgentIdDirty() : !pSDELogicNode.isPSSysAIWorkerAgentIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysAIWorkerAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIWorkerAgentId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIWORKERAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBackServiceId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysBackServiceIdDirty() : !pSDELogicNode.isPSSysBackServiceIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysBackServiceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBackServiceId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBACKSERVICEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDSchemeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysBDSchemeIdDirty() : !pSDELogicNode.isPSSysBDSchemeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysBDSchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysBDTableIdDirty() : !pSDELogicNode.isPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysBDTableId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIAggTableId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysBIAggTableIdDirty() : !pSDELogicNode.isPSSysBIAggTableIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysBIAggTableId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIAggTableId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysBICubeIdDirty() : !pSDELogicNode.isPSSysBICubeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysBICubeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIReportId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysBIReportIdDirty() : !pSDELogicNode.isPSSysBIReportIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysBIReportId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIReportId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBISchemeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysBISchemeIdDirty() : !pSDELogicNode.isPSSysBISchemeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysBISchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBISchemeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDataSyncAgentId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysDataSyncAgentIdDirty() : !pSDELogicNode.isPSSysDataSyncAgentIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysDataSyncAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDataSyncAgentId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDATASYNCAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBSchemeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysDBSchemeIdDirty() : !pSDELogicNode.isPSSysDBSchemeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysDBSchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBSchemeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBTableId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysDBTableIdDirty() : !pSDELogicNode.isPSSysDBTableIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysDBTableId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBTableId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDELogicNodeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysDELogicNodeIdDirty() : !pSDELogicNode.isPSSysDELogicNodeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysDELogicNodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDELogicNodeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDELOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysEAIElementIdDirty() : !pSDELogicNode.isPSSysEAIElementIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysEAIElementId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAISchemeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysEAISchemeIdDirty() : !pSDELogicNode.isPSSysEAISchemeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysEAISchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAISchemeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysMsgTemplIdDirty() : !pSDELogicNode.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysPFPluginIdDirty() : !pSDELogicNode.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysResourceIdDirty() : !pSDELogicNode.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDocId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysSearchDocIdDirty() : !pSDELogicNode.isPSSysSearchDocIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysSearchDocId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDocId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchSchemeId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysSearchSchemeIdDirty() : !pSDELogicNode.isPSSysSearchSchemeIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysSearchSchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchSchemeId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysSFPluginIdDirty() : !pSDELogicNode.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSQLCmdId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysSQLCmdIdDirty() : !pSDELogicNode.isPSSysSQLCmdIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysSQLCmdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSQLCmdId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSQLCMDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSystemIdDirty() : !pSDELogicNode.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniStateId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysUniStateIdDirty() : !pSDELogicNode.isPSSysUniStateIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysUniStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniStateId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNISTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUtilDEId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSSysUtilDEIdDirty() : !pSDELogicNode.isPSSysUtilDEIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSSysUtilDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUtilDEId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUTILDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSViewMsgIdDirty() : !pSDELogicNode.isPSViewMsgIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSViewMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSWFDEIdDirty() : !pSDELogicNode.isPSWFDEIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSWFDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkflowId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isPSWorkflowIdDirty() : !pSDELogicNode.isPSWorkflowIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getPSWorkflowId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkflowId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKFLOWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RetPSDLParamId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isRetPSDLParamIdDirty() : !pSDELogicNode.isRetPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getRetPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RetPSDLParamId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RetPSDLParamName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isRetPSDLParamNameDirty() : !pSDELogicNode.isRetPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getRetPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RetPSDLParamName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeParams(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isShapeParamsDirty() : !pSDELogicNode.isShapeParamsDirty()) {
            return null;
        }
        String string = pSDELogicNode.getShapeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeParams_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcIndex(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isSrcIndexDirty() : !pSDELogicNode.isSrcIndexDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getSrcIndex();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SrcIndex_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCINDEX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDLParamId(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isSrcPSDLParamIdDirty() : !pSDELogicNode.isSrcPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELogicNode.getSrcPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDLParamId_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDLParamName(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isSrcPSDLParamNameDirty() : !pSDELogicNode.isSrcPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELogicNode.getSrcPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDLParamName_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcSize(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isSrcSizeDirty() : !pSDELogicNode.isSrcSizeDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getSrcSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SrcSize_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadRunMode(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isThreadRunModeDirty() : !pSDELogicNode.isThreadRunModeDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getThreadRunMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadRunMode_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADRUNMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadRunTimer(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isThreadRunTimerDirty() : !pSDELogicNode.isThreadRunTimerDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getThreadRunTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadRunTimer_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADRUNTIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isTopPosDirty() : !pSDELogicNode.isTopPosDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSMode(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isTSModeDirty() : !pSDELogicNode.isTSModeDirty()) {
            return null;
        }
        Integer n = pSDELogicNode.getTSMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TSMode_Default((IEntity)pSDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isUserCatDirty() : !pSDELogicNode.isUserCatDirty()) {
            return null;
        }
        String string = pSDELogicNode.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isUserParamsDirty() : !pSDELogicNode.isUserParamsDirty()) {
            return null;
        }
        String string = pSDELogicNode.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isUserTagDirty() : !pSDELogicNode.isUserTagDirty()) {
            return null;
        }
        String string = pSDELogicNode.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isUserTag2Dirty() : !pSDELogicNode.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isUserTag3Dirty() : !pSDELogicNode.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDELogicNode pSDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELogicNode.isUserTag4Dirty() : !pSDELogicNode.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDELogicNode.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDELogicNode, bl2, bl3);
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

    protected void onSyncEntity(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDELogicNode, bl);
    }

    protected void onSyncIndexEntities(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDELogicNode, bl);
    }

    public Object getDataContextValue(PSDELogicNode pSDELogicNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACTION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEACTIONID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEACTIONNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATAEXP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAEXPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAEXPNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATAIMP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAIMPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAIMPNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATAQUERY", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAQUERYID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAQUERYNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASYNC", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATASYNCID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATASYNCNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDTSQUEUE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDTSQUEUEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDTSQUEUENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFGROUP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFGROUPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFGROUPNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFORM", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFORMID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFORMNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFVALUERULE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFVALUERULEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFVALUERULENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDELOGIC", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAFLOWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAFLOWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDELOGIC", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDELOGICID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDELOGICNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDELOGIC", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEUILOGICID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEUILOGICNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEMAP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEMAPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEMAPNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDENOTIFY", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDENOTIFYID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDENOTIFYNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEPRINT", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEPRINTID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEPRINTNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEREPORT", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEREPORTID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEREPORTNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDESAMPLEDATA", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDESAMPLEDATAID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDESAMPLEDATANAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEUAGROUP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEUAGROUPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEUAGROUPNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEUIACTION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEUIACTIONID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEUIACTIONNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEUTILDE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTDEUTILDEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTDEUTILDENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVRGROUP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEVRGROUPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEVRGROUPNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEWIZARD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEWIZARDID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEWIZARDNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "dstpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSWFDE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSWFID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSWFDEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSWFDENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDELogicNode, "psworkflowid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSDELogicNode, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSDELogicNode pSDELogicNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDELNParam_PSDELogicNode(pSDELogicNode, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDELogicNode, arrayList, n);
    }

    protected void onExportRelatedModel_PSDELNParam_PSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELNParam> arrayList2 = pSDELNParamService.selectByPSDELogicNode(pSDELogicNode);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"3c4aa0019094c4afb506564afbc94060");
            jSONObject.put("srfdename", (Object)"PSDELNPARAM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDELogicNode, (String)"PSDELOGICNODEID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDELNParam pSDELNParam : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDELNParam, (String)"srfsyspub", (int)1) == 0) continue;
            pSDELNParamService.exportModel(pSDELNParam, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDELogicNode pSDELogicNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDELogicNode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMDSTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomDSTParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMSRCPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomSrcParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEBUGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DebugMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTDEUTILDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEUtilDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTDEUTILDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEUtilDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTINDEX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstIndex_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPARAMACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstParamAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAEXPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataExpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAEXPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataExpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAFLOWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataFlowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAFLOWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataFlowName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAIMPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataImpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAIMPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataImpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAQUERYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataQueryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATAQUERYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataQueryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASYNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSyncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDATASYNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDataSyncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDTSQUEUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDTSQueueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEDTSQUEUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEDTSQueueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDENOTIFYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDENotifyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDENOTIFYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDENotifyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEPRINTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEPrintId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEPRINTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEPrintName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEUILOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEUILogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEUILOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEUILogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVRGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEVRGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVRGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEVRGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ISPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ISPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ISPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNODESUBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicNodeSubType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNODETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicNodeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPTPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OptPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPTPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OptPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OSPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OSPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OSPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OSPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARALLELOUTPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParallelOutput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM1", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param1_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM13", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param13_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM14", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param14_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Param9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAICHATAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIChatAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAICHATAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIChatAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBACKSERVICEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBackServiceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBACKSERVICENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBackServiceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDATASYNCAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDataSyncAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDATASYNCAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDataSyncAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDELOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDELogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDELOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDELogicNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSQLCMDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSQLCmdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSQLCMDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSQLCmdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCINDEX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcIndex_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADRUNMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadRunMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADRUNTIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadRunTimer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TSMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TSMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CustomDSTParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMDSTPARAM", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomSrcParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMSRCPARAM", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DebugMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DstPSDEUtilDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTDEUTILDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEUtilDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTDEUTILDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstIndex_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DstParamAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPARAMACTION", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataExpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAEXPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataExpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAEXPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataFlowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAFLOWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataFlowName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAFLOWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataImpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAIMPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataImpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAIMPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataQueryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAQUERYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataQueryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATAQUERYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataSyncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASYNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDataSyncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDATASYNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDTSQueueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDTSQUEUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEDTSQueueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEDTSQUEUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDENotifyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDENOTIFYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDENotifyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDENOTIFYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEPrintId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEPRINTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEPrintName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEPRINTNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEREPORTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEUILogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEUILOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEUILogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEUILOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEVRGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVRGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEVRGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVRGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ISPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ISPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ISPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ISPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicNodeSubType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNODESUBTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicNodeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNODETYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_MsgPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OptPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPTPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OptPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPTPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_OSPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OSPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OSPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OSPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParallelOutput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param1_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM1", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM11", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM12", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param13_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM13", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param14_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM14", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM4", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM5", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAM6", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Param7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Param9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIChatAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAICHATAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIChatAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAICHATAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIFactoryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIFACTORYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIFactoryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIFACTORYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIPipelineAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIPipelineAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIWorkerAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIWORKERAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIWorkerAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIWORKERAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBackServiceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBACKSERVICEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBackServiceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBACKSERVICENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIAggTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIAggTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGTABLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDataSyncAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDATASYNCAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDataSyncAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDATASYNCAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBTABLENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDELogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDELOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDELogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDELOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSQLCmdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSQLCMDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSQLCmdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSQLCMDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUtilDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUtilDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkflowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKFLOWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkflowName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKFLOWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RetPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RetPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcIndex_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SrcPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ThreadRunMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ThreadRunTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TopPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TSMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected boolean onMergeChild(String string, String string2, PSDELogicNode pSDELogicNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDELogicNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDELogicNode pSDELogicNode) throws Exception {
        super.onUpdateParent((IEntity)pSDELogicNode);
    }

    @Override
    protected void exportCurXmlModel(PSDELogicNode pSDELogicNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDELOGICNODE");
        if (!bl) {
            pSDELogicNode.setCreateDate(null);
            pSDELogicNode.setCreateMan(null);
            pSDELogicNode.setPSDEId(null);
            pSDELogicNode.setPSDELogicNodeId(null);
            pSDELogicNode.setPSSysSQLCmdName(null);
            pSDELogicNode.setPSSystemId(null);
            pSDELogicNode.setUpdateDate(null);
            pSDELogicNode.setUpdateMan(null);
            pSDELogicNode.setDstPSDLParamId(null);
            pSDELogicNode.setISPSDLParamId(null);
            pSDELogicNode.setOptPSDLParamId(null);
            pSDELogicNode.setOSPSDLParamId(null);
            pSDELogicNode.setRetPSDLParamId(null);
            pSDELogicNode.setSrcPSDLParamId(null);
            pSDELogicNode.setPSDEId(null);
            pSDELogicNode.setPSDELogicId(null);
            pSDELogicNode.setPSDELogicName(null);
            pSDELogicNode.setPSSystemId(null);
            super.exportCurXmlModel(pSDELogicNode, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDELogicNode pSDELogicNode, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDELNParam(pSDELogicNode, xmlNode);
        super.onExportRelatedXmlModel(pSDELogicNode, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDELNParam(PSDELogicNode pSDELogicNode, XmlNode xmlNode) throws Exception {
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELNParam> arrayList = null;
        String string = pSDELogicNode.getPSDELogicNodeId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDELNParamService.selectByPSDELogicNode(pSDELogicNode, "ORDER BY ORDERVALUE ASC") : pSDELNParamService.selectTempByPSDELogicNode(pSDELogicNode, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDELNPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSDELNParam pSDELNParam : arrayList) {
                pSDELNParam.set("ORDERVALUE", null);
                pSDELNParamService.exportXmlModel(pSDELNParam, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDELogicNode pSDELogicNode, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDELNPARAMS");
        this.importRelatedXmlModel_PSDELNParam(pSDELogicNode, xmlNode2);
        super.onImportRelatedXmlModel(pSDELogicNode, xmlNode);
    }

    protected void importRelatedXmlModel_PSDELNParam(PSDELogicNode pSDELogicNode, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDELogicNode.getPSDELogicNodeId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDELNParamService.removeByPSDELogicNode(pSDELogicNode);
        } else {
            pSDELNParamService.removeTempByPSDELogicNode(pSDELogicNode);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDELNParam pSDELNParam = new PSDELNParam();
                pSDELNParam.setOrderValue(n);
                n += 100;
                pSDELNParamService.fillParentInfo((IEntity)pSDELNParam, "DER1N", "DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID", pSDELogicNode.getPSDELogicNodeId());
                pSDELNParamService.importXmlModel(pSDELNParam, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDELogicNode pSDELogicNode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDELogicNode, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDELOGIC#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDELOGICNODE_PSDELOGIC_PSDELOGICID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDELOGIC", (boolean)true) == 0) {
            iEntity.set("PSDELOGICID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDELOGICID"};
    }

    @Override
    public String getModelV2Tag(PSDELogicNode pSDELogicNode) {
        if (!StringHelper.isNullOrEmpty((String)pSDELogicNode.getCodeName())) {
            return pSDELogicNode.getCodeName();
        }
        return super.getModelV2Tag(pSDELogicNode);
    }

    @Override
    public boolean setModelV2Tag(PSDELogicNode pSDELogicNode, String string) {
        pSDELogicNode.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDELOGICID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDELogicNode pSDELogicNode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDELogicNode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDELogicNode, true);
        pSDELogicNode.set("CODENAME", string);
        if (this.select(pSDELogicNode, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDELogicNode, true);
        return super.getModelV2Entity(pSDELogicNode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDELogicNode pSDELogicNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDELogicNode, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDELogicNode pSDELogicNode, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDELogicNode, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDELogicNode pSDELogicNode, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID")) {
            Object object;
            PSDELNParam pSDELNParam2;
            Object object2;
            Object object3;
            Object object4;
            PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDELNParam> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDELOGICNODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDELNPARAM", (Object)pSDELogicNode.getPSDELogicNodeId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDELNParam2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDELNParam2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDELNParam>();
                object4 = pSDELNParamService.selectByPSDELogicNode(pSDELogicNode);
                object3 = StringHelper.format((String)"PSDELOGICNODE#%1$s", (Object)pSDELogicNode.getPSDELogicNodeId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDELNParam2 = object2.next();
                    object = pSDELNParamService.getModelV2ResScope((IEntity)pSDELNParam2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDELNParam)PSModelV2Helper.toJSONObject((IEntity)pSDELNParam2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDELNParamService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdelnparamname")) {
                            string = objectNode.get("psdelnparamname").asText();
                        }
                        if (objectNode2.has("psdelnparamname")) {
                            string2 = objectNode2.get("psdelnparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDELNParam pSDELNParam2 : arrayList) {
                    object = new PSDELNParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDELNParam2, false);
                    object3.add((JsonNode)pSDELNParamService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDELogicNode, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDELogicNode pSDELogicNode) throws Exception {
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELNParam> arrayList = pSDELNParamService.selectByPSDELogicNode(pSDELogicNode);
        String string = StringHelper.format((String)"PSDELOGICNODE#%1$s", (Object)pSDELogicNode.getPSDELogicNodeId());
        for (PSDELNParam pSDELNParam : arrayList) {
            String string2 = pSDELNParamService.getModelV2ResScope((IEntity)pSDELNParam);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDELNParamService.emptyModelV2(pSDELNParam);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDELogicNode.getPSDELogicNodeId());
        pSDELNParamService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDELNParamService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDELNPARAM WHERE PSDELOGICNODEID = ?", sqlParamList);
        super.onEmptyModelV2(pSDELogicNode);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSDELNParamService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDELogicNode pSDELogicNode, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDELNParam pSDELNParam = new PSDELNParam();
        pSDELNParam.set("PSDELOGICNODEID", pSDELogicNode.getPSDELogicNodeId());
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDELNParamService.getModelV2Entity(pSDELNParam, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDELogicNode, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDELogicNode pSDELogicNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDELNParamService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDELNParam pSDELNParam = new PSDELNParam();
                pSDELNParam.setPSDELogicId(pSDELogicNode.getPSDELogicId());
                pSDELNParam.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
                pSDELNParam.setPSDELogicNodeName(pSDELogicNode.getPSDELogicNodeName());
                pSDELNParamService.compileModelV2(pSDELNParam, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDELNParam pSDELNParam = new PSDELNParam();
                    pSDELNParam.setPSDELogicId(pSDELogicNode.getPSDELogicId());
                    pSDELNParam.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
                    pSDELNParam.setPSDELogicNodeName(pSDELogicNode.getPSDELogicNodeName());
                    pSDELNParamService.compileModelV2(pSDELNParam, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDELogicNode, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDELogicNode pSDELogicNode, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDELNParams(pSDELogicNode, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDELogicNode, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDELNParams(PSDELogicNode pSDELogicNode, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDELNPARAM", true), (boolean)false) == 0) {
            PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
            PSDELNParam pSDELNParam = new PSDELNParam();
            pSDELNParam.setPSDELNParamId(pSMOSFile.getPSModelId());
            if (!pSDELNParamService.get((IEntity)pSDELNParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDELNParam.getPSDELogicNodeId(), (String)pSDELogicNode.getPSDELogicNodeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDELNParamService.exportModelV2(pSDELNParam);
            pSDELNParam.reset();
            if (!pSDELNParamService.setModelV2ResScope((IEntity)pSDELNParam, "PSDELOGICNODE", pSDELogicNode.getPSDELogicNodeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDELNParamService.importModelV2(pSDELNParam, objectNode);
            SessionFactoryManager.commit();
            return pSDELNParamService.getFile((IEntity)pSDELNParam);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDELogicNode pSDELogicNode, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDELNParams(pSDELogicNode, list);
        super.onFillPasteHelps(pSDELogicNode, list);
    }

    protected void onFillPasteHelps_PSDELNParams(PSDELogicNode pSDELogicNode, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDELNPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9]\u7684[\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDELogicNode pSDELogicNode) throws Exception {
        return pSDELogicNode.getLogicNodeType();
    }
}

