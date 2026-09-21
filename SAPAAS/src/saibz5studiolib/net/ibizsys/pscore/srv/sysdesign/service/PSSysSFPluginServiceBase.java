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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentServiceBase;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryServiceBase;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentServiceBase;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSFPluginBase;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPluginDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPluginDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPITempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPluginServiceBase
extends PSCoreSysServiceBase<PSSysSFPlugin> {
    private static final Log log = LogFactory.getLog(PSSysSFPluginServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSWITHICON = "CurSysWithIcon";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCPLUGINTYPE = "CALCPLUGINTYPE";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysSFPluginDEModel pSSysSFPluginDEModel;
    private PSSysSFPluginDAO pSSysSFPluginDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService";
    }

    public PSSysSFPluginDEModel getPSSysSFPluginDEModel() {
        if (this.pSSysSFPluginDEModel == null) {
            try {
                this.pSSysSFPluginDEModel = (PSSysSFPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPluginDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSFPluginDEModel();
    }

    public PSSysSFPluginDAO getPSSysSFPluginDAO() {
        if (this.pSSysSFPluginDAO == null) {
            try {
                this.pSSysSFPluginDAO = (PSSysSFPluginDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPluginDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPluginDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSFPluginDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSWITHICON, (boolean)true) == 0) {
            return this.fetchCurSysWithIcon(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCPLUGINTYPE, (boolean)true) == 0) {
            this.calcPluginType((PSSysSFPlugin)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysWithIcon(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSWITHICON, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcPluginType(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCPLUGINTYPE, 0, (IEntity)pSSysSFPlugin, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysSFPlugin, ACTION_CALCPLUGINTYPE);
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysSFPluginServiceBase.this.getService(), PSSysSFPluginServiceBase.ACTION_CALCPLUGINTYPE, 40, (IEntity)pSSysSFPlugin2, null).getResult() != 1) {
                    PSSysSFPluginServiceBase.this.onCalcPluginType(pSSysSFPlugin2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCPLUGINTYPE, 99, (IEntity)pSSysSFPlugin, null);
        }
    }

    protected void onCalcPluginType(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CALCPLUGINTYPE]");
    }

    protected void onFillParentInfo(PSSysSFPlugin pSSysSFPlugin, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPLUGIN_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysSFPlugin, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPLUGIN_PSSFPLUGIN_PSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSFPlugin pSSFPlugin = (PSSFPlugin)iService.getDEModel().createEntity();
            pSSFPlugin.set("PSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFPlugin);
            } else {
                iService.get((IEntity)pSSFPlugin);
            }
            this.onFillParentInfo_PSSFPlugin(pSSysSFPlugin, pSSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPLUGIN_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysSFPlugin, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSFPlugin, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysSFPlugin pSSysSFPlugin, PSModule pSModule) throws Exception {
        pSSysSFPlugin.setPSModuleId(pSModule.getPSModuleId());
        pSSysSFPlugin.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSFPlugin(PSSysSFPlugin pSSysSFPlugin, PSSFPlugin pSSFPlugin) throws Exception {
        pSSysSFPlugin.setPSSFPluginId(pSSFPlugin.getPSSFPluginId());
        pSSysSFPlugin.setPSSFPluginName(pSSFPlugin.getPSSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysSFPlugin pSSysSFPlugin, PSSystem pSSystem) throws Exception {
        pSSysSFPlugin.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSFPlugin.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        if (bl) {
            if (pSSysSFPlugin.getCodeName() == null) {
                pSSysSFPlugin.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "SFPlugin", 25));
            }
            if (pSSysSFPlugin.getPSSysSFPITemplsCnt() == null) {
                pSSysSFPlugin.setPSSysSFPITemplsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysSFPlugin.getPSSysSFPluginName() == null) {
                pSSysSFPlugin.setPSSysSFPluginName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u540e\u53f0\u6a21\u677f\u63d2\u4ef6", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysSFPlugin, bl);
        this.onFillEntityFullInfo_PSModule(pSSysSFPlugin, bl);
        this.onFillEntityFullInfo_PSSFPlugin(pSSysSFPlugin, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysSFPlugin, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFPlugin(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        if (pSSysSFPlugin.isPSSFPluginIdDirty()) {
            if (pSSysSFPlugin.getPSSFPluginId() != null) {
                if (pSSysSFPlugin.getPSSFPluginId() == null || pSSysSFPlugin.getPSSFPluginName() == null) {
                    PSSFPlugin pSSFPlugin = pSSysSFPlugin.getPSSFPlugin();
                    pSSysSFPlugin.setPSSFPluginName(pSSFPlugin.getPSSFPluginName());
                }
            } else {
                pSSysSFPlugin.setPSSFPluginName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        if (pSSysSFPlugin.isPSSystemIdDirty()) {
            if (pSSysSFPlugin.getPSSystemId() != null) {
                if (pSSysSFPlugin.getPSSystemId() == null || pSSysSFPlugin.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysSFPlugin.getPSSystem();
                    pSSysSFPlugin.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysSFPlugin.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSFPlugin, bl);
    }

    public ArrayList<PSSysSFPlugin> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysSFPlugin> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysSFPlugin> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSFPlugin> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase) throws Exception {
        return this.selectByPSSFPlugin(pSSFPluginBase, "", -1);
    }

    public ArrayList<PSSysSFPlugin> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase, String string) throws Exception {
        return this.selectByPSSFPlugin(pSSFPluginBase, string, -1);
    }

    public ArrayList<PSSysSFPlugin> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFPLUGINID", (Object)pSSFPluginBase.getPSSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFPlugin> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysSFPlugin> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysSFPlugin> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFPLUGIN_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSSFPLUGIN", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSModule(pSModule);
        for (PSSysSFPlugin pSSysSFPlugin : arrayList) {
            PSSysSFPlugin pSSysSFPlugin2 = (PSSysSFPlugin)this.getDEModel().createEntity();
            pSSysSFPlugin2.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
            pSSysSFPlugin2.setPSModuleId(null);
            this.update(pSSysSFPlugin2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPluginServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysSFPluginServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysSFPluginServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysSFPlugin pSSysSFPlugin : arrayList) {
            this.remove((IEntity)pSSysSFPlugin);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSFPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSFPlugin> arrayList) throws Exception {
    }

    public void testRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    public void resetPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSSFPlugin(pSSFPlugin);
        for (PSSysSFPlugin pSSysSFPlugin : arrayList) {
            PSSysSFPlugin pSSysSFPlugin2 = (PSSysSFPlugin)this.getDEModel().createEntity();
            pSSysSFPlugin2.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
            pSSysSFPlugin2.setPSSFPluginId(null);
            this.update(pSSysSFPlugin2);
        }
    }

    public void removeByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        final PSSFPlugin pSSFPlugin2 = pSSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPluginServiceBase.this.onBeforeRemoveByPSSFPlugin(pSSFPlugin2);
                PSSysSFPluginServiceBase.this.internalRemoveByPSSFPlugin(pSSFPlugin2);
                PSSysSFPluginServiceBase.this.onAfterRemoveByPSSFPlugin(pSSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSSFPlugin(pSSFPlugin);
        this.onBeforeRemoveByPSSFPlugin(pSSFPlugin, arrayList);
        for (PSSysSFPlugin pSSysSFPlugin : arrayList) {
            this.remove((IEntity)pSSysSFPlugin);
        }
        this.onAfterRemoveByPSSFPlugin(pSSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin, ArrayList<PSSysSFPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin, ArrayList<PSSysSFPlugin> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFPLUGIN_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSSFPLUGIN", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysSFPlugin pSSysSFPlugin : arrayList) {
            PSSysSFPlugin pSSysSFPlugin2 = (PSSysSFPlugin)this.getDEModel().createEntity();
            pSSysSFPlugin2.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
            pSSysSFPlugin2.setPSSystemId(null);
            this.update(pSSysSFPlugin2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPluginServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysSFPluginServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysSFPluginServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSFPlugin> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysSFPlugin pSSysSFPlugin : arrayList) {
            this.remove((IEntity)pSSysSFPlugin);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSFPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSFPlugin> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataExpServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSyncServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDENotifyServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUserRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSDEUtilDEService)ServiceGlobal.getService(PSDEUtilDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUtilDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByDEPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysAIChatAgentService)ServiceGlobal.getService(PSSysAIChatAgentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIChatAgentServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysAIFactoryService)ServiceGlobal.getService(PSSysAIFactoryService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIFactoryServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysAIPipelineAgentService)ServiceGlobal.getService(PSSysAIPipelineAgentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineAgentServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysAIWorkerAgentService)ServiceGlobal.getService(PSSysAIWorkerAgentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIWorkerAgentServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByDEPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysBackServiceService)ServiceGlobal.getService(PSSysBackServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBackServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysBIDimensionService)ServiceGlobal.getService(PSSysBIDimensionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIDimensionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCounterServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDataSyncAgentServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBVFServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysDELogicNodeService)ServiceGlobal.getService(PSSysDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysResourceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByDEPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPITemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        ((PSSysSFPITemplServiceBase)pSCoreSysServiceBase).removeByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTranslatorServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniResServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniStateServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUserDRServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUtilDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSWFWorkTimeService)ServiceGlobal.getService(PSWFWorkTimeService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFWorkTimeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSWXAccountService)ServiceGlobal.getService(PSWXAccountService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXAccountServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXEntAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSFPlugin(pSSysSFPlugin);
        super.onBeforeRemove(pSSysSFPlugin);
    }

    protected void replaceParentInfo(PSSysSFPlugin pSSysSFPlugin, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSFPlugin, cloneSession);
        if (pSSysSFPlugin.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysSFPlugin.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysSFPlugin, (PSModule)iEntity);
        }
        if (pSSysSFPlugin.getPSSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSFPLUGIN", (Object)pSSysSFPlugin.getPSSFPluginId())) != null) {
            this.onFillParentInfo_PSSFPlugin(pSSysSFPlugin, (PSSFPlugin)iEntity);
        }
        if (pSSysSFPlugin.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysSFPlugin.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysSFPlugin, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSFPlugin, bl);
        pSSysSFPlugin.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysSFPlugin, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Keywords(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamDesc(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginModel(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginParams(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginTag(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginTag2(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginType(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPluginId(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPluginName(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPITemplsCnt(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginName(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepDefault(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectMode(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectName(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectRepo(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SingleInstMode(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioIcon(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempalteFunc(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSFPlugin, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isCodeNameDirty() : !pSSysSFPlugin.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysSFPluginDEModel(), "CODENAME", string3, pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_Keywords(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isKeywordsDirty() : !pSSysSFPlugin.isKeywordsDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getKeywords();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Keywords_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYWORDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isLockFlagDirty() : !pSSysSFPlugin.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysSFPlugin.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isMemoDirty() : !pSSysSFPlugin.isMemoDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isOrderValueDirty() : !pSSysSFPlugin.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysSFPlugin.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamDesc(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isParamDescDirty() : !pSSysSFPlugin.isParamDescDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getParamDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamDesc_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginModel(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPluginModelDirty() : !pSSysSFPlugin.isPluginModelDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPluginModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginModel_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginParams(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPluginParamsDirty() : !pSSysSFPlugin.isPluginParamsDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPluginParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginParams_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginTag(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPluginTagDirty() : !pSSysSFPlugin.isPluginTagDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPluginTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginTag_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginTag2(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPluginTag2Dirty() : !pSSysSFPlugin.isPluginTag2Dirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPluginTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginTag2_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginType(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPluginTypeDirty() && !bl2 : !pSSysSFPlugin.isPluginTypeDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPluginType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginType_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPreviewHtmlDirty() : !pSSysSFPlugin.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWHTML");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSModuleIdDirty() : !pSSysSFPlugin.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFPluginId(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSSFPluginIdDirty() : !pSSysSFPlugin.isPSSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPSSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPluginId_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPluginName(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSSFPluginNameDirty() : !pSSysSFPlugin.isPSSFPluginNameDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPSSFPluginName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPluginName_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPITemplsCnt(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSSysSFPITemplsCntDirty() : !pSSysSFPlugin.isPSSysSFPITemplsCntDirty()) {
            return null;
        }
        Integer n = pSSysSFPlugin.getPSSysSFPITemplsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysSFPITemplsCnt_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPITEMPLSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSSysSFPluginIdDirty() && !bl2 : !pSSysSFPlugin.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPSSysSFPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginName(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSSysSFPluginNameDirty() && !bl2 : !pSSysSFPlugin.isPSSysSFPluginNameDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPSSysSFPluginName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginName_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINNAME");
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysSFPluginDEModel(), "PSSYSSFPLUGINNAME", string3, pSSysSFPlugin, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSFPLUGINNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSSystemIdDirty() && !bl2 : !pSSysSFPlugin.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isPSSystemNameDirty() && !bl2 : !pSSysSFPlugin.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_RepDefault(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isRepDefaultDirty() : !pSSysSFPlugin.isRepDefaultDirty()) {
            return null;
        }
        Integer n = pSSysSFPlugin.getRepDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RepDefault_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectMode(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isRTObjectModeDirty() : !pSSysSFPlugin.isRTObjectModeDirty()) {
            return null;
        }
        Integer n = pSSysSFPlugin.getRTObjectMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RTObjectMode_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectName(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isRTObjectNameDirty() : !pSSysSFPlugin.isRTObjectNameDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getRTObjectName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RTObjectName_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectRepo(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isRTObjectRepoDirty() : !pSSysSFPlugin.isRTObjectRepoDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getRTObjectRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RTObjectRepo_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTREPO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SingleInstMode(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isSingleInstModeDirty() : !pSSysSFPlugin.isSingleInstModeDirty()) {
            return null;
        }
        Integer n = pSSysSFPlugin.getSingleInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SingleInstMode_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SINGLEINSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioIcon(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isStudioIconDirty() : !pSSysSFPlugin.isStudioIconDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getStudioIcon();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioIcon_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOICON");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempalteFunc(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isTempalteFuncDirty() : !pSSysSFPlugin.isTempalteFuncDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getTempalteFunc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TempalteFunc_Default((IEntity)pSSysSFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEFUNC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isTemplateModeDirty() : !pSSysSFPlugin.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSSysSFPlugin.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isUserCatDirty() : !pSSysSFPlugin.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isUserTagDirty() : !pSSysSFPlugin.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isUserTag2Dirty() : !pSSysSFPlugin.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isUserTag3Dirty() : !pSSysSFPlugin.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSFPlugin pSSysSFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPlugin.isUserTag4Dirty() : !pSSysSFPlugin.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSFPlugin.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysSFPlugin, bl2, bl3);
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

    protected void onSyncEntity(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSFPlugin, bl);
    }

    protected void onSyncIndexEntities(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSFPlugin, bl);
    }

    public Object getDataContextValue(PSSysSFPlugin pSSysSFPlugin, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSFPlugin, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSFPlugin pSSysSFPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSFPlugin, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"KEYWORDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Keywords_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPITEMPLSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPITemplsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepDefault_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectRepo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SINGLEINSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SingleInstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOICON", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioIcon_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEFUNC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempalteFunc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Keywords_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYWORDS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMDESC", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTAG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTAG2", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewHtml_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWHTML", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPITemplsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_RepDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RTObjectMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RTObjectName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTOBJECTNAME", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false) && this.checkFieldRegExRule("RTOBJECTNAME", iEntity, bl2, "[A-Za-z]+[\\w.]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RTObjectRepo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTOBJECTREPO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SingleInstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StudioIcon_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOICON", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TempalteFunc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLATEFUNC", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) && this.onMergeChild_PSSysSFPITempls(pSSysSFPlugin)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSSysSFPlugin)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSSysSFPITempls(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSSFPITEMPLSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysSFPlugin.getPSSysSFPluginId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSSFPLUGINID", (Object)pSSysSFPlugin.getPSSysSFPluginId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysSFPlugin, false);
        return true;
    }

    protected void onUpdateParent(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        super.onUpdateParent((IEntity)pSSysSFPlugin);
    }

    @Override
    protected void exportCurXmlModel(PSSysSFPlugin pSSysSFPlugin, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSFPLUGIN");
        if (!bl) {
            pSSysSFPlugin.setCreateDate(null);
            pSSysSFPlugin.setCreateMan(null);
            pSSysSFPlugin.setPSSysSFPluginId(null);
            pSSysSFPlugin.setUpdateDate(null);
            pSSysSFPlugin.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSFPlugin, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSFPlugin pSSysSFPlugin, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSFPlugin, string);
        objectNode.remove("pssyssfpitemplscnt");
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
            return "DER1N_PSSYSSFPLUGIN_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSFPLUGIN_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysSFPlugin pSSysSFPlugin) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSFPlugin.getCodeName())) {
            return pSSysSFPlugin.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSFPlugin.getPSSysSFPluginName())) {
            return pSSysSFPlugin.getPSSysSFPluginName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSFPlugin.getCodeName())) {
            return pSSysSFPlugin.getCodeName();
        }
        return super.getModelV2Tag(pSSysSFPlugin);
    }

    @Override
    public boolean setModelV2Tag(PSSysSFPlugin pSSysSFPlugin, String string) {
        pSSysSFPlugin.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSSFPLUGINNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSFPlugin pSSysSFPlugin, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSFPlugin.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSFPlugin, true);
        pSSysSFPlugin.set("CODENAME", string);
        if (this.select(pSSysSFPlugin, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSFPlugin, true);
        return super.getModelV2Entity(pSSysSFPlugin, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSFPlugin pSSysSFPlugin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSFPlugin, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysSFPlugin pSSysSFPlugin, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSFPLUGIN#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSFPITEMPL", (Object)pSSysSFPlugin.getPSSysSFPluginId()))).exists()) {
            PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysSFPITemplService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysSFPITempl pSSysSFPITempl = new PSSysSFPITempl();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysSFPITempl, objectNode, false);
                String string6 = pSSysSFPITemplService.getModelV2Tag(pSSysSFPITempl);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSFPITEMPL", (Object)pSSysSFPITempl.getPSSysSFPITemplId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysSFPITemplService.exportModelV2(pSSysSFPITempl, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysSFPlugin, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysSFPlugin pSSysSFPlugin, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID")) {
            Object object;
            PSSysSFPITempl pSSysSFPITempl2;
            Object object2;
            Object object3;
            Object object4;
            PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysSFPITempl> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSFPLUGIN#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSFPITEMPL", (Object)pSSysSFPlugin.getPSSysSFPluginId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysSFPITempl2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysSFPITempl2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysSFPITempl>();
                object4 = pSSysSFPITemplService.selectByPSSysSFPlugin(pSSysSFPlugin);
                object3 = StringHelper.format((String)"PSSYSSFPLUGIN#%1$s", (Object)pSSysSFPlugin.getPSSysSFPluginId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysSFPITempl2 = object2.next();
                    object = pSSysSFPITemplService.getModelV2ResScope((IEntity)pSSysSFPITempl2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysSFPITempl)PSModelV2Helper.toJSONObject((IEntity)pSSysSFPITempl2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysSFPITemplService.getModelV2Name(false);
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
                        if (objectNode.has("pssyssfpitemplname")) {
                            string = objectNode.get("pssyssfpitemplname").asText();
                        }
                        if (objectNode2.has("pssyssfpitemplname")) {
                            string2 = objectNode2.get("pssyssfpitemplname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysSFPITempl pSSysSFPITempl2 : arrayList) {
                    object = new PSSysSFPITempl();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysSFPITempl2, false);
                    object3.add((JsonNode)pSSysSFPITemplService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysSFPlugin, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        super.onEmptyModelV2(pSSysSFPlugin);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysSFPITemplService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysSFPlugin pSSysSFPlugin, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysSFPITempl pSSysSFPITempl = new PSSysSFPITempl();
        pSSysSFPITempl.set("PSSYSSFPLUGINID", pSSysSFPlugin.getPSSysSFPluginId());
        PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysSFPITemplService.getModelV2Entity(pSSysSFPITempl, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysSFPlugin, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysSFPlugin pSSysSFPlugin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysSFPluginServiceBase.isSimpleImportExportMode("")) {
            PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysSFPITemplService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysSFPITempl pSSysSFPITempl = new PSSysSFPITempl();
                    pSSysSFPITempl.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
                    pSSysSFPITempl.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
                    pSSysSFPITemplService.compileModelV2(pSSysSFPITempl, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysSFPITempl pSSysSFPITempl = new PSSysSFPITempl();
                        pSSysSFPITempl.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
                        pSSysSFPITempl.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
                        pSSysSFPITemplService.compileModelV2(pSSysSFPITempl, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysSFPlugin, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysSFPlugin pSSysSFPlugin, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSFPITempls(pSSysSFPlugin, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysSFPlugin, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysSFPITempls(PSSysSFPlugin pSSysSFPlugin, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSFPITEMPL", true), (boolean)false) == 0) {
            PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
            PSSysSFPITempl pSSysSFPITempl = new PSSysSFPITempl();
            pSSysSFPITempl.setPSSysSFPITemplId(pSMOSFile.getPSModelId());
            if (!pSSysSFPITemplService.get((IEntity)pSSysSFPITempl, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSFPITempl.getPSSysSFPluginId(), (String)pSSysSFPlugin.getPSSysSFPluginId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSFPITemplService.exportModelV2(pSSysSFPITempl);
            pSSysSFPITempl.reset();
            if (!pSSysSFPITemplService.setModelV2ResScope((IEntity)pSSysSFPITempl, "PSSYSSFPLUGIN", pSSysSFPlugin.getPSSysSFPluginId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSFPITemplService.importModelV2(pSSysSFPITempl, objectNode);
            SessionFactoryManager.commit();
            return pSSysSFPITemplService.getFile((IEntity)pSSysSFPITempl);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysSFPlugin pSSysSFPlugin, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysSFPITempls(pSSysSFPlugin, list);
        super.onFillPasteHelps(pSSysSFPlugin, list);
    }

    protected void onFillPasteHelps_PSSysSFPITempls(PSSysSFPlugin pSSysSFPlugin, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSFPITEMPL");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u540e\u53f0\u6a21\u677f\u63d2\u4ef6]\u7684[\u540e\u53f0\u6a21\u677f\u63d2\u4ef6\u4ee3\u7801]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u63d2\u4ef6\u6a21\u677f>", "DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "PSSYSSFPLUGINID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysSFPluginServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u63d2\u4ef6\u6a21\u677f>");
            } else if (PSSysSFPluginServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssfpitempls");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID|PSSYSSFPLUGINID");
            pSMOSFile2.setFileTag3("PSSYSSFPITEMPL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "PSSYSSFPLUGINID", pSMOSFile.getPSModelId(), "", "")) {
                PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysSFPITemplService, "DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "PSSYSSFPLUGINID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSSysSFPITemplService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSFPluginServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSSysSFPluginServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u63d2\u4ef6\u6a21\u677f>", (boolean)false) == 0 || PSSysSFPluginServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysSFPITempls", (boolean)true) == 0) {
            PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysSFPITemplService, "DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "PSSYSSFPLUGINID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSSysSFPITemplService.selectEx((ISelectContext)selectContext);
            for (PSSysSFPITempl pSSysSFPITempl : arrayList2) {
                PSMOSFile pSMOSFile2 = pSSysSFPITemplService.getFile(pSMOSFile, (IEntity)pSSysSFPITempl, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)false) == 0) {
            if (PSSysSFPluginServiceBase.getMOSVer() == 1) {
                return "<\u63d2\u4ef6\u6a21\u677f>";
            }
            if (PSSysSFPluginServiceBase.getMOSVer() == 2) {
                return "pssyssfpitempls";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysSFPlugin pSSysSFPlugin, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "SFPlugin");
        defaultValueMap.put("PSSYSSFPLUGINNAME", "\u540e\u53f0\u6a21\u677f\u63d2\u4ef6");
    }
}

