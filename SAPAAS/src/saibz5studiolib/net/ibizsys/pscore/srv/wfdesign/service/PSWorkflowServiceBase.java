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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.wfdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWorkflowDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWorkflowDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCat;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCatBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDEBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFSubWF;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFSubWFBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIActionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFSubWFServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionServiceBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccountBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkflowServiceBase
extends PSCoreSysServiceBase<PSWorkflow> {
    private static final Log log = LogFactory.getLog(PSWorkflowServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_TESTACTIVITYENGINE = "TestActivityEngine";
    public static final String ACTION_TESTEMBEDEDENGINE = "TestEmbededEngine";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSWorkflowDEModel pSWorkflowDEModel;
    private PSWorkflowDAO pSWorkflowDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService";
    }

    public PSWorkflowDEModel getPSWorkflowDEModel() {
        if (this.pSWorkflowDEModel == null) {
            try {
                this.pSWorkflowDEModel = (PSWorkflowDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWorkflowDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkflowDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWorkflowDEModel();
    }

    public PSWorkflowDAO getPSWorkflowDAO() {
        if (this.pSWorkflowDAO == null) {
            try {
                this.pSWorkflowDAO = (PSWorkflowDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWorkflowDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkflowDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWorkflowDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
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
        if (StringHelper.compare((String)string, (String)ACTION_TESTACTIVITYENGINE, (boolean)true) == 0) {
            this.testActivityEngine((PSWorkflow)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_TESTEMBEDEDENGINE, (boolean)true) == 0) {
            this.testEmbededEngine((PSWorkflow)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void testActivityEngine(PSWorkflow pSWorkflow) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_TESTACTIVITYENGINE, 0, (IEntity)pSWorkflow, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWorkflow, ACTION_TESTACTIVITYENGINE);
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWorkflowServiceBase.this.getService(), PSWorkflowServiceBase.ACTION_TESTACTIVITYENGINE, 40, (IEntity)pSWorkflow2, null).getResult() != 1) {
                    PSWorkflowServiceBase.this.onTestActivityEngine(pSWorkflow2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_TESTACTIVITYENGINE, 99, (IEntity)pSWorkflow, null);
        }
    }

    protected void onTestActivityEngine(PSWorkflow pSWorkflow) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[TestActivityEngine]");
    }

    public void testEmbededEngine(PSWorkflow pSWorkflow) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_TESTEMBEDEDENGINE, 0, (IEntity)pSWorkflow, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWorkflow, ACTION_TESTEMBEDEDENGINE);
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWorkflowServiceBase.this.getService(), PSWorkflowServiceBase.ACTION_TESTEMBEDEDENGINE, 40, (IEntity)pSWorkflow2, null).getResult() != 1) {
                    PSWorkflowServiceBase.this.onTestEmbededEngine(pSWorkflow2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_TESTEMBEDEDENGINE, 99, (IEntity)pSWorkflow, null);
        }
    }

    protected void onTestEmbededEngine(PSWorkflow pSWorkflow) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[TestEmbededEngine]");
    }

    protected void onFillParentInfo(PSWorkflow pSWorkflow, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSCODELIST_STATECODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_StateCodeList(pSWorkflow, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSCODELIST_WFSTEPCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_WFStepCodeList(pSWorkflow, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSDEVIEWBASE_ACTIONMOBPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_ActionMobPSDEView(pSWorkflow, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSDEVIEWBASE_ACTIONPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_ActionPSDEView(pSWorkflow, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSDEVIEWBASE_STARTMOBPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_StartMobPSDEView(pSWorkflow, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSDEVIEWBASE_STARTPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_StartPSDEView(pSWorkflow, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSLANGUAGERES_NAMEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_NamePSLanRes(pSWorkflow, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSWorkflow, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSSYSMSGTEMPL_REMINDPSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMsgTempl);
            } else {
                iService.get((IEntity)pSSysMsgTempl);
            }
            this.onFillParentInfo_RemindPSSysMsgTempl(pSWorkflow, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSWorkflow, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSWorkflow, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSSYSWFCAT_PSSYSWFCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSSysWFCatService", (SessionFactory)this.getSessionFactory());
            PSSysWFCat pSSysWFCat = (PSSysWFCat)iService.getDEModel().createEntity();
            pSSysWFCat.set("PSSYSWFCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysWFCat);
            } else {
                iService.get((IEntity)pSSysWFCat);
            }
            this.onFillParentInfo_PSSysWFCat(pSWorkflow, pSSysWFCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSWXACCOUNT_PSWXACCOUNTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService", (SessionFactory)this.getSessionFactory());
            PSWXAccount pSWXAccount = (PSWXAccount)iService.getDEModel().createEntity();
            pSWXAccount.set("PSWXACCOUNTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWXAccount);
            } else {
                iService.get((IEntity)pSWXAccount);
            }
            this.onFillParentInfo_PSWXAccount(pSWorkflow, pSWXAccount);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKFLOW_PSWXENTAPP_PSWXENTAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService", (SessionFactory)this.getSessionFactory());
            PSWXEntApp pSWXEntApp = (PSWXEntApp)iService.getDEModel().createEntity();
            pSWXEntApp.set("PSWXENTAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWXEntApp);
            } else {
                iService.get((IEntity)pSWXEntApp);
            }
            this.onFillParentInfo_PSWXEntApp(pSWorkflow, pSWXEntApp);
            return;
        }
        super.onFillParentInfo((IEntity)pSWorkflow, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_StateCodeList(PSWorkflow pSWorkflow, PSCodeList pSCodeList) throws Exception {
        pSWorkflow.setStateCodeListId(pSCodeList.getPSCodeListId());
        pSWorkflow.setStateCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_WFStepCodeList(PSWorkflow pSWorkflow, PSCodeList pSCodeList) throws Exception {
        pSWorkflow.setWFStepCodeListId(pSCodeList.getPSCodeListId());
        pSWorkflow.setWFStepCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_ActionMobPSDEView(PSWorkflow pSWorkflow, PSDEViewBase pSDEViewBase) throws Exception {
        pSWorkflow.setActionMobPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWorkflow.setActionMobPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_ActionPSDEView(PSWorkflow pSWorkflow, PSDEViewBase pSDEViewBase) throws Exception {
        pSWorkflow.setActionPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWorkflow.setActionPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_StartMobPSDEView(PSWorkflow pSWorkflow, PSDEViewBase pSDEViewBase) throws Exception {
        pSWorkflow.setStartMobPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWorkflow.setStartMobPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_StartPSDEView(PSWorkflow pSWorkflow, PSDEViewBase pSDEViewBase) throws Exception {
        pSWorkflow.setStartPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWorkflow.setStartPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_NamePSLanRes(PSWorkflow pSWorkflow, PSLanguageRes pSLanguageRes) throws Exception {
        pSWorkflow.setNamePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSWorkflow.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSWorkflow pSWorkflow, PSModule pSModule) throws Exception {
        pSWorkflow.setModColor(pSModule.getColor());
        pSWorkflow.setPSModuleId(pSModule.getPSModuleId());
        pSWorkflow.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_RemindPSSysMsgTempl(PSWorkflow pSWorkflow, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSWorkflow.setRemindPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSWorkflow.setRemindPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSWorkflow pSWorkflow, PSSysReqItem pSSysReqItem) throws Exception {
        pSWorkflow.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSWorkflow.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSystem(PSWorkflow pSWorkflow, PSSystem pSSystem) throws Exception {
        pSWorkflow.setPSSystemId(pSSystem.getPSSystemId());
        pSWorkflow.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysWFCat(PSWorkflow pSWorkflow, PSSysWFCat pSSysWFCat) throws Exception {
        pSWorkflow.setPSSysWFCatId(pSSysWFCat.getPSSysWFCatId());
        pSWorkflow.setPSSysWFCatName(pSSysWFCat.getPSSysWFCatName());
    }

    protected void onFillParentInfo_PSWXAccount(PSWorkflow pSWorkflow, PSWXAccount pSWXAccount) throws Exception {
        pSWorkflow.setPSWXAccountId(pSWXAccount.getPSWXAccountId());
        pSWorkflow.setPSWXAccountName(pSWXAccount.getPSWXAccountName());
    }

    protected void onFillParentInfo_PSWXEntApp(PSWorkflow pSWorkflow, PSWXEntApp pSWXEntApp) throws Exception {
        pSWorkflow.setPSWXEntAppId(pSWXEntApp.getPSWXEntAppId());
        pSWorkflow.setPSWXEntAppName(pSWXEntApp.getPSWXEntAppName());
    }

    protected void onFillEntityFullInfo(PSWorkflow pSWorkflow, boolean bl) throws Exception {
        if (bl) {
            if (pSWorkflow.getCodeName() == null) {
                pSWorkflow.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Workflow", 25));
            }
            if (pSWorkflow.getEnable() == null) {
                pSWorkflow.setEnable((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSWorkflow.getPSWFDEsCnt() == null) {
                pSWorkflow.setPSWFDEsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWorkflow.getPSWFVersionsCnt() == null) {
                pSWorkflow.setPSWFVersionsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWorkflow.getValidFlag() == null) {
                pSWorkflow.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSWorkflow, bl);
        this.onFillEntityFullInfo_StateCodeList(pSWorkflow, bl);
        this.onFillEntityFullInfo_WFStepCodeList(pSWorkflow, bl);
        this.onFillEntityFullInfo_ActionMobPSDEView(pSWorkflow, bl);
        this.onFillEntityFullInfo_ActionPSDEView(pSWorkflow, bl);
        this.onFillEntityFullInfo_StartMobPSDEView(pSWorkflow, bl);
        this.onFillEntityFullInfo_StartPSDEView(pSWorkflow, bl);
        this.onFillEntityFullInfo_NamePSLanRes(pSWorkflow, bl);
        this.onFillEntityFullInfo_PSModule(pSWorkflow, bl);
        this.onFillEntityFullInfo_RemindPSSysMsgTempl(pSWorkflow, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSWorkflow, bl);
        this.onFillEntityFullInfo_PSSystem(pSWorkflow, bl);
        this.onFillEntityFullInfo_PSSysWFCat(pSWorkflow, bl);
        this.onFillEntityFullInfo_PSWXAccount(pSWorkflow, bl);
        this.onFillEntityFullInfo_PSWXEntApp(pSWorkflow, bl);
    }

    protected void onFillEntityFullInfo_StateCodeList(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_WFStepCodeList(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ActionMobPSDEView(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ActionPSDEView(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_StartMobPSDEView(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_StartPSDEView(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NamePSLanRes(PSWorkflow pSWorkflow, boolean bl) throws Exception {
        if (pSWorkflow.isNamePSLanResIdDirty()) {
            if (pSWorkflow.getNamePSLanResId() != null) {
                if (pSWorkflow.getNamePSLanResId() == null || pSWorkflow.getNamePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSWorkflow.getNamePSLanRes();
                    pSWorkflow.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSWorkflow.setNamePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemindPSSysMsgTempl(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSWorkflow pSWorkflow, boolean bl) throws Exception {
        if (pSWorkflow.isPSSystemIdDirty()) {
            if (pSWorkflow.getPSSystemId() != null) {
                if (pSWorkflow.getPSSystemId() == null || pSWorkflow.getPSSystemName() == null) {
                    PSSystem pSSystem = pSWorkflow.getPSSystem();
                    pSWorkflow.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSWorkflow.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysWFCat(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXAccount(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWXEntApp(PSWorkflow pSWorkflow, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWorkflow pSWorkflow, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWorkflow, bl);
    }

    public ArrayList<PSWorkflow> selectByStateCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByStateCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByStateCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByStateCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByStateCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATECODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStateCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStateCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByWFStepCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByWFStepCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByWFStepCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByWFStepCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByWFStepCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFSTEPCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFStepCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFStepCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByActionMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByActionMobPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByActionMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByActionMobPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByActionMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ACTIONMOBPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByActionMobPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByActionMobPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByActionPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByActionPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByActionPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByActionPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByActionPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ACTIONPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByActionPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByActionPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByStartMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByStartMobPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByStartMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByStartMobPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByStartMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STARTMOBPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStartMobPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStartMobPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByStartPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByStartPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByStartPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByStartPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByStartPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STARTPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStartPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStartPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAMEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNamePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNamePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByRemindPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByRemindPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByRemindPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByRemindPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByRemindPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMINDPSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemindPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemindPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREQITEMID", (Object)pSSysReqItemBase.getPSSysReqItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysReqItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysReqItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByPSSysWFCat(PSSysWFCatBase pSSysWFCatBase) throws Exception {
        return this.selectByPSSysWFCat(pSSysWFCatBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByPSSysWFCat(PSSysWFCatBase pSSysWFCatBase, String string) throws Exception {
        return this.selectByPSSysWFCat(pSSysWFCatBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByPSSysWFCat(PSSysWFCatBase pSSysWFCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSWFCATID", (Object)pSSysWFCatBase.getPSSysWFCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysWFCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysWFCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string) throws Exception {
        return this.selectByPSWXAccount(pSWXAccountBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByPSWXAccount(PSWXAccountBase pSWXAccountBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXACCOUNTID", (Object)pSWXAccountBase.getPSWXAccountId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWXAccountCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWXAccountCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkflow> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, "", -1);
    }

    public ArrayList<PSWorkflow> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string) throws Exception {
        return this.selectByPSWXEntApp(pSWXEntAppBase, string, -1);
    }

    public ArrayList<PSWorkflow> selectByPSWXEntApp(PSWXEntAppBase pSWXEntAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXENTAPPID", (Object)pSWXEntAppBase.getPSWXEntAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWXEntAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWXEntAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByStateCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStateCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSCODELIST_STATECODELISTID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetStateCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStateCodeList(pSCodeList);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setStateCodeListId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByStateCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByStateCodeList(pSCodeList2);
                PSWorkflowServiceBase.this.internalRemoveByStateCodeList(pSCodeList2);
                PSWorkflowServiceBase.this.onAfterRemoveByStateCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByStateCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByStateCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStateCodeList(pSCodeList);
        this.onBeforeRemoveByStateCodeList(pSCodeList, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByStateCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByStateCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByStateCodeList(PSCodeList pSCodeList, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStateCodeList(PSCodeList pSCodeList, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByWFStepCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByWFStepCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSCODELIST_WFSTEPCODELISTID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetWFStepCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByWFStepCodeList(pSCodeList);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setWFStepCodeListId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByWFStepCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByWFStepCodeList(pSCodeList2);
                PSWorkflowServiceBase.this.internalRemoveByWFStepCodeList(pSCodeList2);
                PSWorkflowServiceBase.this.onAfterRemoveByWFStepCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByWFStepCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByWFStepCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByWFStepCodeList(pSCodeList);
        this.onBeforeRemoveByWFStepCodeList(pSCodeList, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByWFStepCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByWFStepCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByWFStepCodeList(PSCodeList pSCodeList, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFStepCodeList(PSCodeList pSCodeList, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByActionMobPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSDEVIEWBASE_ACTIONMOBPSDEVIEWID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByActionMobPSDEView(pSDEViewBase);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setActionMobPSDEViewId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByActionMobPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.internalRemoveByActionMobPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.onAfterRemoveByActionMobPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByActionMobPSDEView(pSDEViewBase);
        this.onBeforeRemoveByActionMobPSDEView(pSDEViewBase, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByActionMobPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByActionPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSDEVIEWBASE_ACTIONPSDEVIEWID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByActionPSDEView(pSDEViewBase);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setActionPSDEViewId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByActionPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.internalRemoveByActionPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.onAfterRemoveByActionPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByActionPSDEView(pSDEViewBase);
        this.onBeforeRemoveByActionPSDEView(pSDEViewBase, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByActionPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByActionPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByActionPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStartMobPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSDEVIEWBASE_STARTMOBPSDEVIEWID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStartMobPSDEView(pSDEViewBase);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setStartMobPSDEViewId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByStartMobPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.internalRemoveByStartMobPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.onAfterRemoveByStartMobPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStartMobPSDEView(pSDEViewBase);
        this.onBeforeRemoveByStartMobPSDEView(pSDEViewBase, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByStartMobPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStartPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSDEVIEWBASE_STARTPSDEVIEWID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStartPSDEView(pSDEViewBase);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setStartPSDEViewId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByStartPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.internalRemoveByStartPSDEView(pSDEViewBase2);
                PSWorkflowServiceBase.this.onAfterRemoveByStartPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByStartPSDEView(pSDEViewBase);
        this.onBeforeRemoveByStartPSDEView(pSDEViewBase, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByStartPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByStartPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStartPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByNamePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSLANGUAGERES_NAMEPSLANRESID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setNamePSLanResId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByNamePSLanRes(pSLanguageRes2);
                PSWorkflowServiceBase.this.internalRemoveByNamePSLanRes(pSLanguageRes2);
                PSWorkflowServiceBase.this.onAfterRemoveByNamePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByNamePSLanRes(pSLanguageRes, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByNamePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSModule(pSModule);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setPSModuleId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSWorkflowServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSWorkflowServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByRemindPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSSYSMSGTEMPL_REMINDPSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByRemindPSSysMsgTempl(pSSysMsgTempl);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setRemindPSSysMsgTemplId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByRemindPSSysMsgTempl(pSSysMsgTempl2);
                PSWorkflowServiceBase.this.internalRemoveByRemindPSSysMsgTempl(pSSysMsgTempl2);
                PSWorkflowServiceBase.this.onAfterRemoveByRemindPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByRemindPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByRemindPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByRemindPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemindPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setPSSysReqItemId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSWorkflowServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSWorkflowServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSystem(pSSystem);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setPSSystemId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSWorkflowServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSWorkflowServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSysWFCat(pSSysWFCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSWFCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysWFCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSSYSWFCAT_PSSYSWFCATID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSSysWFCat), arrayList.get(0)));
        }
    }

    public void resetPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSysWFCat(pSSysWFCat);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setPSSysWFCatId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        final PSSysWFCat pSSysWFCat2 = pSSysWFCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByPSSysWFCat(pSSysWFCat2);
                PSWorkflowServiceBase.this.internalRemoveByPSSysWFCat(pSSysWFCat2);
                PSWorkflowServiceBase.this.onAfterRemoveByPSSysWFCat(pSSysWFCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
    }

    protected void internalRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSSysWFCat(pSSysWFCat);
        this.onBeforeRemoveByPSSysWFCat(pSSysWFCat, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByPSSysWFCat(pSSysWFCat, arrayList);
    }

    protected void onAfterRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSWXAccount(pSWXAccount, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWXACCOUNT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWXAccount);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSWXACCOUNT_PSWXACCOUNTID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSWXAccount), arrayList.get(0)));
        }
    }

    public void resetPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSWXAccount(pSWXAccount);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setPSWXAccountId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        final PSWXAccount pSWXAccount2 = pSWXAccount;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByPSWXAccount(pSWXAccount2);
                PSWorkflowServiceBase.this.internalRemoveByPSWXAccount(pSWXAccount2);
                PSWorkflowServiceBase.this.onAfterRemoveByPSWXAccount(pSWXAccount2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void internalRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSWXAccount(pSWXAccount);
        this.onBeforeRemoveByPSWXAccount(pSWXAccount, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByPSWXAccount(pSWXAccount, arrayList);
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount) throws Exception {
    }

    protected void onBeforeRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXAccount(PSWXAccount pSWXAccount, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    public void testRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSWXEntApp(pSWXEntApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWXENTAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWXEntApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWORKFLOW_PSWXENTAPP_PSWXENTAPPID", "", iDataEntityModel.getName(), "PSWORKFLOW", iDataEntityModel.getDataInfo((IEntity)pSWXEntApp), arrayList.get(0)));
        }
    }

    public void resetPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        for (PSWorkflow pSWorkflow : arrayList) {
            PSWorkflow pSWorkflow2 = (PSWorkflow)this.getDEModel().createEntity();
            pSWorkflow2.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            pSWorkflow2.setPSWXEntAppId(null);
            this.update(pSWorkflow2);
        }
    }

    public void removeByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        final PSWXEntApp pSWXEntApp2 = pSWXEntApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkflowServiceBase.this.onBeforeRemoveByPSWXEntApp(pSWXEntApp2);
                PSWorkflowServiceBase.this.internalRemoveByPSWXEntApp(pSWXEntApp2);
                PSWorkflowServiceBase.this.onAfterRemoveByPSWXEntApp(pSWXEntApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void internalRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
        ArrayList<PSWorkflow> arrayList = this.selectByPSWXEntApp(pSWXEntApp);
        this.onBeforeRemoveByPSWXEntApp(pSWXEntApp, arrayList);
        for (PSWorkflow pSWorkflow : arrayList) {
            this.remove((IEntity)pSWorkflow);
        }
        this.onAfterRemoveByPSWXEntApp(pSWXEntApp, arrayList);
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp) throws Exception {
    }

    protected void onBeforeRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXEntApp(PSWXEntApp pSWXEntApp, ArrayList<PSWorkflow> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWorkflow pSWorkflow) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppWFServiceBase)pSCoreSysServiceBase).testRemoveByPSWorkflow(pSWorkflow);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSWorkflow(pSWorkflow);
        pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWorkflow);
        ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).removeByPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWorkflow);
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).removeByPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByEmbedPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcSubWFServiceBase)pSCoreSysServiceBase).testRemoveByEmbedPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFSubWFServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWorkflow);
        ((PSWFSubWFServiceBase)pSCoreSysServiceBase).removeByPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFSubWFServiceBase)pSCoreSysServiceBase).testRemoveBySubPSWF(pSWorkflow);
        pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFUtilUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSWorkflow(pSWorkflow);
        pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFVersionServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWorkflow);
        super.onBeforeRemove(pSWorkflow);
    }

    protected void replaceParentInfo(PSWorkflow pSWorkflow, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWorkflow, cloneSession);
        if (pSWorkflow.getStateCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSWorkflow.getStateCodeListId())) != null) {
            this.onFillParentInfo_StateCodeList(pSWorkflow, (PSCodeList)iEntity);
        }
        if (pSWorkflow.getWFStepCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSWorkflow.getWFStepCodeListId())) != null) {
            this.onFillParentInfo_WFStepCodeList(pSWorkflow, (PSCodeList)iEntity);
        }
        if (pSWorkflow.getActionMobPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWorkflow.getActionMobPSDEViewId())) != null) {
            this.onFillParentInfo_ActionMobPSDEView(pSWorkflow, (PSDEViewBase)iEntity);
        }
        if (pSWorkflow.getActionPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWorkflow.getActionPSDEViewId())) != null) {
            this.onFillParentInfo_ActionPSDEView(pSWorkflow, (PSDEViewBase)iEntity);
        }
        if (pSWorkflow.getStartMobPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWorkflow.getStartMobPSDEViewId())) != null) {
            this.onFillParentInfo_StartMobPSDEView(pSWorkflow, (PSDEViewBase)iEntity);
        }
        if (pSWorkflow.getStartPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWorkflow.getStartPSDEViewId())) != null) {
            this.onFillParentInfo_StartPSDEView(pSWorkflow, (PSDEViewBase)iEntity);
        }
        if (pSWorkflow.getNamePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSWorkflow.getNamePSLanResId())) != null) {
            this.onFillParentInfo_NamePSLanRes(pSWorkflow, (PSLanguageRes)iEntity);
        }
        if (pSWorkflow.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSWorkflow.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSWorkflow, (PSModule)iEntity);
        }
        if (pSWorkflow.getRemindPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSWorkflow.getRemindPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_RemindPSSysMsgTempl(pSWorkflow, (PSSysMsgTempl)iEntity);
        }
        if (pSWorkflow.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSWorkflow.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSWorkflow, (PSSysReqItem)iEntity);
        }
        if (pSWorkflow.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSWorkflow.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSWorkflow, (PSSystem)iEntity);
        }
        if (pSWorkflow.getPSSysWFCatId() != null && (iEntity = cloneSession.getEntity("PSSYSWFCAT", (Object)pSWorkflow.getPSSysWFCatId())) != null) {
            this.onFillParentInfo_PSSysWFCat(pSWorkflow, (PSSysWFCat)iEntity);
        }
        if (pSWorkflow.getPSWXAccountId() != null && (iEntity = cloneSession.getEntity("PSWXACCOUNT", (Object)pSWorkflow.getPSWXAccountId())) != null) {
            this.onFillParentInfo_PSWXAccount(pSWorkflow, (PSWXAccount)iEntity);
        }
        if (pSWorkflow.getPSWXEntAppId() != null && (iEntity = cloneSession.getEntity("PSWXENTAPP", (Object)pSWorkflow.getPSWXEntAppId())) != null) {
            this.onFillParentInfo_PSWXEntApp(pSWorkflow, (PSWXEntApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWorkflow pSWorkflow, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWorkflow, bl);
        pSWorkflow.resetWFTag();
        pSWorkflow.resetWFTag2();
        pSWorkflow.resetWFTag3();
        pSWorkflow.resetWFTag4();
    }

    protected void onCheckEntity(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionMobPSDEViewId(bl, pSWorkflow, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionPSDEViewId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditableWFStep(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Enable(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaSys(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaView(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMob(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtCntStates(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobWFEditViewType(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResName(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysWFCatId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEsCnt(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionsCnt(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkflowId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkflowName(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXAccountId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXEntAppId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemindPSSysMsgTemplId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoteEngineFlag(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartMobPSDEViewId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartPSDEViewId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StateCodeListId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFCancelValue(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFCancelValueText(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFEditViewType(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFEngineType(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFErrorValue(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFErrorValueText(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFFinishValue(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFFinishValueText(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFProxyMode(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFSN(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStateValue(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepCodeListId(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFTag(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFTag2(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFTag3(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFTag4(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFType(bl, pSWorkflow, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWorkflow, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionMobPSDEViewId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isActionMobPSDEViewIdDirty() : !pSWorkflow.isActionMobPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getActionMobPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionMobPSDEViewId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONMOBPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionPSDEViewId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isActionPSDEViewIdDirty() : !pSWorkflow.isActionPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getActionPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionPSDEViewId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isCodeNameDirty() && !bl2 : !pSWorkflow.isCodeNameDirty()) {
            return null;
        }
        String string = pSWorkflow.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSWorkflow, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSWorkflowDEModel(), "CODENAME", string3, pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isDynaModelFlagDirty() : !pSWorkflow.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditableWFStep(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isEditableWFStepDirty() : !pSWorkflow.isEditableWFStepDirty()) {
            return null;
        }
        String string = pSWorkflow.getEditableWFStep();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditableWFStep_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITABLEWFSTEP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Enable(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isEnableDirty() && !bl2 : !pSWorkflow.isEnableDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getEnable();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Enable_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaSys(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isEnableDynaSysDirty() : !pSWorkflow.isEnableDynaSysDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getEnableDynaSys();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaSys_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNASYS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaView(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isEnableDynaViewDirty() : !pSWorkflow.isEnableDynaViewDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getEnableDynaView();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaView_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNAVIEW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableMob(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isEnableMobDirty() : !pSWorkflow.isEnableMobDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getEnableMob();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableMob_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMOB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtCntStates(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isExtCntStatesDirty() : !pSWorkflow.isExtCntStatesDirty()) {
            return null;
        }
        String string = pSWorkflow.getExtCntStates();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtCntStates_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTCNTSTATES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isLockFlagDirty() : !pSWorkflow.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isMemoDirty() : !pSWorkflow.isMemoDirty()) {
            return null;
        }
        String string = pSWorkflow.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobWFEditViewType(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isMobWFEditViewTypeDirty() : !pSWorkflow.isMobWFEditViewTypeDirty()) {
            return null;
        }
        String string = pSWorkflow.getMobWFEditViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobWFEditViewType_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBWFEDITVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isNamePSLanResIdDirty() : !pSWorkflow.isNamePSLanResIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getNamePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResName(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isNamePSLanResNameDirty() : !pSWorkflow.isNamePSLanResNameDirty()) {
            return null;
        }
        String string = pSWorkflow.getNamePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResName_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSDynaInstIdDirty() : !pSWorkflow.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSModuleIdDirty() : !pSWorkflow.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSSysReqItemIdDirty() : !pSWorkflow.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSSystemIdDirty() && !bl2 : !pSWorkflow.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSSystemNameDirty() && !bl2 : !pSWorkflow.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysWFCatId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSSysWFCatIdDirty() : !pSWorkflow.isPSSysWFCatIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSSysWFCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysWFCatId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEsCnt(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSWFDEsCntDirty() : !pSWorkflow.isPSWFDEsCntDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getPSWFDEsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWFDEsCnt_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionsCnt(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSWFVersionsCntDirty() : !pSWorkflow.isPSWFVersionsCntDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getPSWFVersionsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSWFVersionsCnt_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkflowId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSWorkflowIdDirty() && !bl2 : !pSWorkflow.isPSWorkflowIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSWorkflowId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKFLOWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkflowId_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkflowName(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSWorkflowNameDirty() && !bl2 : !pSWorkflow.isPSWorkflowNameDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSWorkflowName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKFLOWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkflowName_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKFLOWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXAccountId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSWXAccountIdDirty() : !pSWorkflow.isPSWXAccountIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSWXAccountId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXAccountId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXACCOUNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXEntAppId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isPSWXEntAppIdDirty() : !pSWorkflow.isPSWXEntAppIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getPSWXEntAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXEntAppId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXENTAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemindPSSysMsgTemplId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isRemindPSSysMsgTemplIdDirty() : !pSWorkflow.isRemindPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getRemindPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemindPSSysMsgTemplId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMINDPSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoteEngineFlag(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isRemoteEngineFlagDirty() : !pSWorkflow.isRemoteEngineFlagDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getRemoteEngineFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoteEngineFlag_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOTEENGINEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartMobPSDEViewId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isStartMobPSDEViewIdDirty() : !pSWorkflow.isStartMobPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getStartMobPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StartMobPSDEViewId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTMOBPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartPSDEViewId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isStartPSDEViewIdDirty() : !pSWorkflow.isStartPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getStartPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StartPSDEViewId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StateCodeListId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isStateCodeListIdDirty() : !pSWorkflow.isStateCodeListIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getStateCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StateCodeListId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATECODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isToDoTaskDirty() : !pSWorkflow.isToDoTaskDirty()) {
            return null;
        }
        String string = pSWorkflow.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TODOTASK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isUserCatDirty() : !pSWorkflow.isUserCatDirty()) {
            return null;
        }
        String string = pSWorkflow.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isUserTagDirty() : !pSWorkflow.isUserTagDirty()) {
            return null;
        }
        String string = pSWorkflow.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isUserTag2Dirty() : !pSWorkflow.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWorkflow.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isUserTag3Dirty() : !pSWorkflow.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWorkflow.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isUserTag4Dirty() : !pSWorkflow.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWorkflow.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isValidFlagDirty() : !pSWorkflow.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSWorkflow, bl2, bl3);
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

    protected EntityFieldError onCheckField_WFCancelValue(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFCancelValueDirty() : !pSWorkflow.isWFCancelValueDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFCancelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFCancelValue_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFCANCELVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFCancelValueText(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFCancelValueTextDirty() : !pSWorkflow.isWFCancelValueTextDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFCancelValueText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFCancelValueText_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFCANCELVALUETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFEditViewType(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFEditViewTypeDirty() : !pSWorkflow.isWFEditViewTypeDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFEditViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFEditViewType_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFEDITVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFEngineType(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFEngineTypeDirty() : !pSWorkflow.isWFEngineTypeDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFEngineType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFEngineType_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFENGINETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFErrorValue(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFErrorValueDirty() : !pSWorkflow.isWFErrorValueDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFErrorValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFErrorValue_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFERRORVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFErrorValueText(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFErrorValueTextDirty() : !pSWorkflow.isWFErrorValueTextDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFErrorValueText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFErrorValueText_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFERRORVALUETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFFinishValue(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFFinishValueDirty() : !pSWorkflow.isWFFinishValueDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFFinishValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFFinishValue_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFFINISHEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFFinishValueText(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFFinishValueTextDirty() : !pSWorkflow.isWFFinishValueTextDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFFinishValueText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFFinishValueText_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFFINISHEVALUETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFProxyMode(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFProxyModeDirty() : !pSWorkflow.isWFProxyModeDirty()) {
            return null;
        }
        Integer n = pSWorkflow.getWFProxyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFProxyMode_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFPROXYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFSN(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFSNDirty() : !pSWorkflow.isWFSNDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFSN_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSN");
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
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSWorkflowDEModel(), "WFSN", string3, pSWorkflow, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("WFSN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStateValue(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFStateValueDirty() : !pSWorkflow.isWFStateValueDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFStateValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStateValue_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTATEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepCodeListId(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFStepCodeListIdDirty() : !pSWorkflow.isWFStepCodeListIdDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFStepCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStepCodeListId_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFTag(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFTagDirty() : !pSWorkflow.isWFTagDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFTag_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFTag2(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFTag2Dirty() : !pSWorkflow.isWFTag2Dirty()) {
            return null;
        }
        String string = pSWorkflow.getWFTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFTag2_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFTag3(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFTag3Dirty() : !pSWorkflow.isWFTag3Dirty()) {
            return null;
        }
        String string = pSWorkflow.getWFTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFTag3_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFTag4(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFTag4Dirty() : !pSWorkflow.isWFTag4Dirty()) {
            return null;
        }
        String string = pSWorkflow.getWFTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFTag4_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFType(boolean bl, PSWorkflow pSWorkflow, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkflow.isWFTypeDirty() : !pSWorkflow.isWFTypeDirty()) {
            return null;
        }
        String string = pSWorkflow.getWFType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFType_Default((IEntity)pSWorkflow, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWorkflow pSWorkflow, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWorkflow, bl);
    }

    protected void onSyncIndexEntities(PSWorkflow pSWorkflow, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWorkflow, bl);
    }

    public Object getDataContextValue(PSWorkflow pSWorkflow, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWorkflow, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSWorkflow.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWorkflow pSWorkflow, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_NamePSLanRes(pSWorkflow, arrayList, n);
        super.onExportMajorModel((IEntity)pSWorkflow, arrayList, n);
    }

    protected void onExportMajorModel_NamePSLanRes(PSWorkflow pSWorkflow, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSWorkflow.getNamePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSWorkflow.getNamePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONMOBPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionMobPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONMOBPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionMobPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionPSDEViewName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITABLEWFSTEP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditableWFStep_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Enable_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNASYS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaSys_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNAVIEW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaView_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMOB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMob_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTCNTSTATES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtCntStates_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBWFEDITVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobWFEditViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkflowName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXAccountId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXACCOUNTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXAccountName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXENTAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXEntAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXENTAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXEntAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMINDPSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemindPSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMINDPSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemindPSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOTEENGINEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoteEngineFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTMOBPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartMobPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTMOBPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartMobPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATECODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StateCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATECODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StateCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WFCANCELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFCancelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFCANCELVALUETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFCancelValueText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFEDITVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFEditViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFENGINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFEngineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFERRORVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFErrorValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFERRORVALUETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFErrorValueText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFFINISHEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFFinishValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFFINISHEVALUETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFFinishValueText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFPROXYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFProxyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTATEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStateValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionMobPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONMOBPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionMobPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONMOBPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditableWFStep_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITABLEWFSTEP", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Enable_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaSys_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaView_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMob_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtCntStates_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTCNTSTATES", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MobWFEditViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBWFEDITVIEWTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysWFCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysWFCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSWFVersionsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSWXAccountId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXACCOUNTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXAccountName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXACCOUNTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXEntAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXENTAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXEntAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXENTAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemindPSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMINDPSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemindPSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMINDPSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemoteEngineFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StartMobPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTMOBPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartMobPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTMOBPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StateCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATECODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StateCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATECODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToDoTask_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TODOTASK", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_WFCancelValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFCANCELVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFCancelValueText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFCANCELVALUETEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFEditViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFEDITVIEWTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFEngineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFENGINETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFErrorValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFERRORVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFErrorValueText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFERRORVALUETEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFFinishValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFFINISHEVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFFinishValueText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFFINISHEVALUETEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFProxyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStateValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTATEVALUE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWorkflow pSWorkflow) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSWORKFLOW_PSWFID", (boolean)true) == 0) && this.onMergeChild_PSWFDEs(pSWorkflow)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", (boolean)true) == 0) && this.onMergeChild_PSWFVersions(pSWorkflow)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSWorkflow)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSWFDEs(PSWorkflow pSWorkflow) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWFDESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWorkflow.getPSWorkflowId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWFID", (Object)pSWorkflow.getPSWorkflowId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWorkflow, false);
        return true;
    }

    protected boolean onMergeChild_PSWFVersions(PSWorkflow pSWorkflow) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSWFVERSIONSCNT");
        selectContext.setDEDataQueryName(DATASET_DEFAULT);
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWorkflow.getPSWorkflowId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWFID", (Object)pSWorkflow.getPSWorkflowId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWorkflow, false);
        return true;
    }

    protected void onUpdateParent(PSWorkflow pSWorkflow) throws Exception {
        Object object = pSWorkflow.get("PSSYSTEMID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWORKFLOW_PSSYSTEM_PSSYSTEMID", object);
        }
        super.onUpdateParent((IEntity)pSWorkflow);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSWorkflow pSWorkflow, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWORKFLOW");
        if (!bl) {
            pSWorkflow.setPSWFDEsCnt(null);
            pSWorkflow.setPSWFVersionsCnt(null);
            super.exportCurXmlModel(pSWorkflow, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWorkflow pSWorkflow, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWorkflow, string);
        objectNode.remove("pswfdescnt");
        objectNode.remove("pswfversionscnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWORKFLOW_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWORKFLOW_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSWorkflow pSWorkflow) {
        if (!StringHelper.isNullOrEmpty((String)pSWorkflow.getCodeName())) {
            return pSWorkflow.getCodeName();
        }
        return super.getModelV2Tag(pSWorkflow);
    }

    @Override
    public boolean setModelV2Tag(PSWorkflow pSWorkflow, String string) {
        pSWorkflow.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("WFSN", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWorkflow pSWorkflow, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWorkflow.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWorkflow, true);
        pSWorkflow.set("CODENAME", string);
        if (this.select(pSWorkflow, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWorkflow, true);
        return super.getModelV2Entity(pSWorkflow, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWorkflow pSWorkflow, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWorkflow, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEUAGROUP_PSWORKFLOW_PSWFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSDEUIACTION_PSWORKFLOW_PSWFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSWFDE_PSWORKFLOW_PSWFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSWFSUBWF_PSWORKFLOW_PSWFID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        if (StringHelper.compare((String)"DER1N_PSWFUTILUIACTION_PSWORKFLOW_PSWORKFLOWID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSWorkflow pSWorkflow, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEUAGROUP_PSWORKFLOW_PSWFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEUAGROUP", (Object)pSWorkflow.getPSWorkflowId()))).exists()) {
            pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEUAGroup();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEUAGroupService)pSCoreSysServiceBase).getModelV2Tag((PSDEUAGroup)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEUAGROUP", (Object)entityBase.getPSDEUAGroupId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEUIACTION_PSWORKFLOW_PSWFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEUIACTION", (Object)pSWorkflow.getPSWorkflowId()))).exists()) {
            pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEUIAction();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEUIActionService)pSCoreSysServiceBase).getModelV2Tag((PSDEUIAction)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEUIACTION", (Object)entityBase.getPSDEUIActionId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWFVERSION_PSWORKFLOW_PSWFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWFVERSION", (Object)pSWorkflow.getPSWorkflowId()))).exists()) {
            pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSWFVersion();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWFVersionService)pSCoreSysServiceBase).getModelV2Tag((PSWFVersion)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWFVERSION", (Object)entityBase.getPSWFVersionId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWFDE_PSWORKFLOW_PSWFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWFDE", (Object)pSWorkflow.getPSWorkflowId()))).exists()) {
            pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSWFDE();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWFDEServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSWFDE)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWFDE", (Object)entityBase.getPSWFDEId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWFSUBWF_PSWORKFLOW_PSWFID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWFSUBWF", (Object)pSWorkflow.getPSWorkflowId()))).exists()) {
            pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSWFSubWF();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWFSubWFServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSWFSubWF)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWFSUBWF", (Object)entityBase.getPSWFSubWFId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWFUTILUIACTION_PSWORKFLOW_PSWORKFLOWID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWFUTILUIACTION", (Object)pSWorkflow.getPSWorkflowId()))).exists()) {
            pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSWFUtilUIAction();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWFUtilUIActionService)pSCoreSysServiceBase).getModelV2Tag((PSWFUtilUIAction)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWFUTILUIACTION", (Object)entityBase.getPSWFUtilUIActionId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSWorkflow, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWorkflow pSWorkflow, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEUAGroup> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEUAGROUP_PSWORKFLOW_PSWFID")) {
            pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEUAGROUP", (Object)pSWorkflow.getPSWorkflowId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEUAGroup>();
                object4 = ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).selectByPSWF(pSWorkflow);
                object3 = StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)pSWorkflow.getPSWorkflowId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEUAGroup)object2.next();
                    object = ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdeuagroupname")) {
                            string = objectNode.get("psdeuagroupname").asText();
                        }
                        if (objectNode2.has("psdeuagroupname")) {
                            string2 = objectNode2.get("psdeuagroupname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEUAGroup();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEUIACTION_PSWORKFLOW_PSWFID")) {
            pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEUIACTION", (Object)pSWorkflow.getPSWorkflowId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEUIActionServiceBase)pSCoreSysServiceBase).selectByPSWF(pSWorkflow);
                object3 = StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)pSWorkflow.getPSWorkflowId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEUIAction)object2.next();
                    object = ((PSDEUIActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdeuiactionname")) {
                            string = objectNode.get("psdeuiactionname").asText();
                        }
                        if (objectNode2.has("psdeuiactionname")) {
                            string2 = objectNode2.get("psdeuiactionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEUIAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFVERSION_PSWORKFLOW_PSWFID")) {
            pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFVERSION", (Object)pSWorkflow.getPSWorkflowId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFVersionServiceBase)pSCoreSysServiceBase).selectByPSWF(pSWorkflow);
                object3 = StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)pSWorkflow.getPSWorkflowId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFVersion)object2.next();
                    object = ((PSWFVersionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pswfversionname")) {
                            string = objectNode.get("pswfversionname").asText();
                        }
                        if (objectNode2.has("pswfversionname")) {
                            string2 = objectNode2.get("pswfversionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFVersion();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFDE_PSWORKFLOW_PSWFID")) {
            pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFDE", (Object)pSWorkflow.getPSWorkflowId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFDEServiceBase)pSCoreSysServiceBase).selectByPSWF(pSWorkflow);
                object3 = StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)pSWorkflow.getPSWorkflowId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFDE)object2.next();
                    object = ((PSWFDEServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pswfdename")) {
                            string = objectNode.get("pswfdename").asText();
                        }
                        if (objectNode2.has("pswfdename")) {
                            string2 = objectNode2.get("pswfdename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFDE();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFSUBWF_PSWORKFLOW_PSWFID")) {
            pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFSUBWF", (Object)pSWorkflow.getPSWorkflowId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFSubWFServiceBase)pSCoreSysServiceBase).selectByPSWF(pSWorkflow);
                object3 = StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)pSWorkflow.getPSWorkflowId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFSubWF)object2.next();
                    object = ((PSWFSubWFServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pswfsubwfname")) {
                            string = objectNode.get("pswfsubwfname").asText();
                        }
                        if (objectNode2.has("pswfsubwfname")) {
                            string2 = objectNode2.get("pswfsubwfname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFSubWF();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFUTILUIACTION_PSWORKFLOW_PSWORKFLOWID")) {
            pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWORKFLOW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFUTILUIACTION", (Object)pSWorkflow.getPSWorkflowId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFUtilUIActionServiceBase)pSCoreSysServiceBase).selectByPSWorkflow(pSWorkflow);
                object3 = StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)pSWorkflow.getPSWorkflowId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFUtilUIAction)object2.next();
                    object = ((PSWFUtilUIActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pswfutiluiactionname")) {
                            string = objectNode.get("pswfutiluiactionname").asText();
                        }
                        if (objectNode2.has("pswfutiluiactionname")) {
                            string2 = objectNode2.get("pswfutiluiactionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFUtilUIAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSWorkflow, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWorkflow pSWorkflow) throws Exception {
        super.onEmptyModelV2(pSWorkflow);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWorkflow pSWorkflow, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEUAGroup();
        entityBase.set("PSWFID", pSWorkflow.getPSWorkflowId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEUIAction();
        entityBase.set("PSWFID", pSWorkflow.getPSWorkflowId());
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFVersion();
        entityBase.set("PSWFID", pSWorkflow.getPSWorkflowId());
        pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFDE();
        entityBase.set("PSWFID", pSWorkflow.getPSWorkflowId());
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFSubWF();
        entityBase.set("PSWFID", pSWorkflow.getPSWorkflowId());
        pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFUtilUIAction();
        entityBase.set("PSWORKFLOWID", pSWorkflow.getPSWorkflowId());
        pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWorkflow, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWorkflow pSWorkflow, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSWorkflowServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEUAGroup();
                    ((PSDEUAGroupBase)object).setPSWFId(pSWorkflow.getPSWorkflowId());
                    ((PSDEUAGroupBase)object).setPSWFName(pSWorkflow.getPSWorkflowName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEUAGroup();
                        entityBase.setPSWFId(pSWorkflow.getPSWorkflowId());
                        entityBase.setPSWFName(pSWorkflow.getPSWorkflowName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWorkflowServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEUIAction();
                    ((PSDEUIActionBase)object).setPSWFId(pSWorkflow.getPSWorkflowId());
                    ((PSDEUIActionBase)object).setPSWFName(pSWorkflow.getPSWorkflowName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEUIAction();
                        entityBase.setPSWFId(pSWorkflow.getPSWorkflowId());
                        entityBase.setPSWFName(pSWorkflow.getPSWorkflowName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWorkflowServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSWFVersion();
                    ((PSWFVersionBase)object).setPSSystemId(pSWorkflow.getPSSystemId());
                    ((PSWFVersionBase)object).setPSWFId(pSWorkflow.getPSWorkflowId());
                    ((PSWFVersionBase)object).setPSWFName(pSWorkflow.getPSWorkflowName());
                    ((PSWFVersionBase)object).setWFEngineType(pSWorkflow.getWFEngineType());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWFVersion();
                        entityBase.setPSSystemId(pSWorkflow.getPSSystemId());
                        entityBase.setPSWFId(pSWorkflow.getPSWorkflowId());
                        entityBase.setPSWFName(pSWorkflow.getPSWorkflowName());
                        entityBase.setWFEngineType(pSWorkflow.getWFEngineType());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWorkflowServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSWFDE();
                    ((PSWFDEBase)object).setPSWFId(pSWorkflow.getPSWorkflowId());
                    ((PSWFDEBase)object).setPSWFName(pSWorkflow.getPSWorkflowName());
                    ((PSWFDEBase)object).setWFCodeName(pSWorkflow.getCodeName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string7);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWFDE();
                        entityBase.setPSWFId(pSWorkflow.getPSWorkflowId());
                        entityBase.setPSWFName(pSWorkflow.getPSWorkflowName());
                        entityBase.setWFCodeName(pSWorkflow.getCodeName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWorkflowServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSWFSubWF();
                    ((PSWFSubWFBase)object).setPSWFId(pSWorkflow.getPSWorkflowId());
                    ((PSWFSubWFBase)object).setPSWFName(pSWorkflow.getPSWorkflowName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string8);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWFSubWF();
                        entityBase.setPSWFId(pSWorkflow.getPSWorkflowId());
                        entityBase.setPSWFName(pSWorkflow.getPSWorkflowName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWorkflowServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSWFUtilUIAction();
                    ((PSWFUtilUIActionBase)object).setPSWorkflowId(pSWorkflow.getPSWorkflowId());
                    ((PSWFUtilUIActionBase)object).setPSWorkflowName(pSWorkflow.getPSWorkflowName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string9 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string9);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSWFUtilUIAction();
                        entityBase.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
                        entityBase.setPSWorkflowName(pSWorkflow.getPSWorkflowName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSWorkflow, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWorkflow pSWorkflow, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFVersions(pSWorkflow, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFDE_PSWORKFLOW_PSWFID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFDEs(pSWorkflow, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSWorkflow, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSWFVersions(PSWorkflow pSWorkflow, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFVERSION", true), (boolean)false) == 0) {
            PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = new PSWFVersion();
            pSWFVersion.setPSWFVersionId(pSMOSFile.getPSModelId());
            if (!pSWFVersionService.get((IEntity)pSWFVersion, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFVersion.getPSWFId(), (String)pSWorkflow.getPSWorkflowId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFVersionService.exportModelV2(pSWFVersion);
            pSWFVersion.reset();
            if (!pSWFVersionService.setModelV2ResScope((IEntity)pSWFVersion, "PSWORKFLOW", pSWorkflow.getPSWorkflowId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFVersionService.importModelV2(pSWFVersion, objectNode);
            SessionFactoryManager.commit();
            return pSWFVersionService.getFile((IEntity)pSWFVersion);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWFDEs(PSWorkflow pSWorkflow, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFDE", true), (boolean)false) == 0) {
            PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = new PSWFDE();
            pSWFDE.setPSWFDEId(pSMOSFile.getPSModelId());
            if (!pSWFDEService.get((IEntity)pSWFDE, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFDE.getPSWFId(), (String)pSWorkflow.getPSWorkflowId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFDEService.exportModelV2(pSWFDE);
            pSWFDE.reset();
            if (!pSWFDEService.setModelV2ResScope((IEntity)pSWFDE, "PSWORKFLOW", pSWorkflow.getPSWorkflowId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFDEService.importModelV2(pSWFDE, objectNode);
            SessionFactoryManager.commit();
            return pSWFDEService.getFile((IEntity)pSWFDE);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSWorkflow pSWorkflow, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSWFVersions(pSWorkflow, list);
        this.onFillPasteHelps_PSWFDEs(pSWorkflow, list);
        super.onFillPasteHelps(pSWorkflow, list);
    }

    protected void onFillPasteHelps_PSWFVersions(PSWorkflow pSWorkflow, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFVERSION");
        pSHelpSection.setSectionParam2("DER1N_PSWFVERSION_PSWORKFLOW_PSWFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5de5\u4f5c\u6d41]\u7684[\u6d41\u7a0b\u5b9a\u4e49\u7248\u672c]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWFDEs(PSWorkflow pSWorkflow, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFDE");
        pSHelpSection.setSectionParam2("DER1N_PSWFDE_PSWORKFLOW_PSWFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5de5\u4f5c\u6d41]\u7684[\u5de5\u4f5c\u6d41\u5b9e\u4f53]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSMOSFile pSMOSFile2;
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7248\u672c>", "DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSWorkflowServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7248\u672c>");
            } else if (PSWorkflowServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pswfversions");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSWFVERSION_PSWORKFLOW_PSWFID|PSWFID");
            pSMOSFile2.setFileTag3("PSWFVERSION");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSWorkflowServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u76f8\u5173\u5b9e\u4f53>", "DER1N_PSWFDE_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSWorkflowServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u76f8\u5173\u5b9e\u4f53>");
            } else if (PSWorkflowServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pswfdes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSWFDE_PSWORKFLOW_PSWFID|PSWFID");
            pSMOSFile2.setFileTag3("PSWFDE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSWFDE_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSWFDE_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSWorkflowServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5de5\u4f5c\u6d41\u5e94\u7528>", "DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID", "PSWORKFLOWID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSWorkflowServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5de5\u4f5c\u6d41\u5e94\u7528>");
            } else if (PSWorkflowServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappwfs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID|PSWORKFLOWID");
            pSMOSFile2.setFileTag3("PSAPPWF");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID", "PSWORKFLOWID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID", "PSWORKFLOWID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSWorkflowServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        PSMOSFile pSMOSFile2;
        ArrayList arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSWorkflowServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7248\u672c>", (boolean)false) == 0 || PSWorkflowServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSWFVersions", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSWorkflowServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u76f8\u5173\u5b9e\u4f53>", (boolean)false) == 0 || PSWorkflowServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSWFDEs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSWFDE_PSWORKFLOW_PSWFID", "PSWFID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSWorkflowServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5de5\u4f5c\u6d41\u5e94\u7528>", (boolean)false) == 0 || PSWorkflowServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"psappwfs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID", "PSWORKFLOWID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (arrayList2.size() > 0) {
            return PSMOSFileUtil.append(arrayList2.toArray(new PSMOSFile[arrayList2.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", (boolean)false) == 0) {
            if (PSWorkflowServiceBase.getMOSVer() == 1) {
                return "<\u7248\u672c>";
            }
            if (PSWorkflowServiceBase.getMOSVer() == 2) {
                return "pswfversions";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFDE_PSWORKFLOW_PSWFID", (boolean)false) == 0) {
            if (PSWorkflowServiceBase.getMOSVer() == 1) {
                return "<\u76f8\u5173\u5b9e\u4f53>";
            }
            if (PSWorkflowServiceBase.getMOSVer() == 2) {
                return "pswfdes";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID", (boolean)false) == 0) {
            if (PSWorkflowServiceBase.getMOSVer() == 1) {
                return "<\u5de5\u4f5c\u6d41\u5e94\u7528>";
            }
            if (PSWorkflowServiceBase.getMOSVer() == 2) {
                return "psappwfs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSWorkflow pSWorkflow, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Workflow");
    }
}

