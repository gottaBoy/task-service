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
import net.ibizsys.paas.db.SelectCond;
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
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDynaModelDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDynaModelDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelAttr;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysChartThemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysChartThemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentServiceBase;
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
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserModeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserModeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewWizardGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewWizardGroupServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDynaModelServiceBase
extends PSCoreSysServiceBase<PSSysDynaModel> {
    private static final Log log = LogFactory.getLog(PSSysDynaModelServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_ADDIMPORTMODELTASK = "X_ADDIMPORTMODELTASK";
    private PSSysDynaModelDEModel pSSysDynaModelDEModel;
    private PSSysDynaModelDAO pSSysDynaModelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService";
    }

    public PSSysDynaModelDEModel getPSSysDynaModelDEModel() {
        if (this.pSSysDynaModelDEModel == null) {
            try {
                this.pSSysDynaModelDEModel = (PSSysDynaModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDynaModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDynaModelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDynaModelDEModel();
    }

    public PSSysDynaModelDAO getPSSysDynaModelDAO() {
        if (this.pSSysDynaModelDAO == null) {
            try {
                this.pSSysDynaModelDAO = (PSSysDynaModelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDynaModelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDynaModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDynaModelDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDIMPORTMODELTASK, (boolean)true) == 0) {
            this.addImportModelTask((PSSysDynaModel)iEntity);
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

    public void addImportModelTask(PSSysDynaModel pSSysDynaModel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDIMPORTMODELTASK, 0, (IEntity)pSSysDynaModel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysDynaModel, ACTION_X_ADDIMPORTMODELTASK);
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysDynaModelServiceBase.this.getService(), PSSysDynaModelServiceBase.ACTION_X_ADDIMPORTMODELTASK, 40, (IEntity)pSSysDynaModel2, null).getResult() != 1) {
                    PSSysDynaModelServiceBase.this.onAddImportModelTask(pSSysDynaModel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDIMPORTMODELTASK, 99, (IEntity)pSSysDynaModel, null);
        }
    }

    protected void onAddImportModelTask(PSSysDynaModel pSSysDynaModel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDIMPORTMODELTASK]");
    }

    protected void onFillParentInfo(PSSysDynaModel pSSysDynaModel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODEL_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysDynaModel, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODEL_PSSYSDYNAMODELCAT_PSSYSDYNAMODELCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelCatService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModelCat pSSysDynaModelCat = (PSSysDynaModelCat)iService.getDEModel().createEntity();
            pSSysDynaModelCat.set("PSSYSDYNAMODELCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModelCat);
            } else {
                iService.get((IEntity)pSSysDynaModelCat);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysDynaModel, pSSysDynaModelCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODEL_PSSYSDYNAMODEL_PPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel2 = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel2.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel2);
            } else {
                iService.get((IEntity)pSSysDynaModel2);
            }
            this.onFillParentInfo_PPSSysDynaModel(pSSysDynaModel, pSSysDynaModel2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODEL_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysDynaModel, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDynaModel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysDynaModel pSSysDynaModel, PSModule pSModule) throws Exception {
        pSSysDynaModel.setPSModuleId(pSModule.getPSModuleId());
        pSSysDynaModel.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysDynaModel pSSysDynaModel, PSSysDynaModelCat pSSysDynaModelCat) throws Exception {
        pSSysDynaModel.setPSSysDynaModelCatId(pSSysDynaModelCat.getPSSysDynaModelCatId());
        pSSysDynaModel.setPSSysDynaModelCatName(pSSysDynaModelCat.getPSSysDynaModelCatName());
    }

    protected void onFillParentInfo_PPSSysDynaModel(PSSysDynaModel pSSysDynaModel, PSSysDynaModel pSSysDynaModel2) throws Exception {
        pSSysDynaModel.setPPSSysDynaModelId(pSSysDynaModel2.getPSSysDynaModelId());
        pSSysDynaModel.setPPSSysDynaModelName(pSSysDynaModel2.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSystem(PSSysDynaModel pSSysDynaModel, PSSystem pSSystem) throws Exception {
        pSSysDynaModel.setPSSystemId(pSSystem.getPSSystemId());
        pSSysDynaModel.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
        if (bl && pSSysDynaModel.getDefaultFlag() == null) {
            pSSysDynaModel.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysDynaModel, bl);
        this.onFillEntityFullInfo_PSModule(pSSysDynaModel, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysDynaModel, bl);
        this.onFillEntityFullInfo_PPSSysDynaModel(pSSysDynaModel, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysDynaModel, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysDynaModel(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
        if (pSSysDynaModel.isPSSystemIdDirty()) {
            if (pSSysDynaModel.getPSSystemId() != null) {
                if (pSSysDynaModel.getPSSystemId() == null || pSSysDynaModel.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysDynaModel.getPSSystem();
                    pSSysDynaModel.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysDynaModel.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDynaModel, bl);
    }

    public ArrayList<PSSysDynaModel> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysDynaModel> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysDynaModel> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDynaModel> selectByPSSysDynaModel(PSSysDynaModelCatBase pSSysDynaModelCatBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelCatBase, "", -1);
    }

    public ArrayList<PSSysDynaModel> selectByPSSysDynaModel(PSSysDynaModelCatBase pSSysDynaModelCatBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelCatBase, string, -1);
    }

    public ArrayList<PSSysDynaModel> selectByPSSysDynaModel(PSSysDynaModelCatBase pSSysDynaModelCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELCATID", (Object)pSSysDynaModelCatBase.getPSSysDynaModelCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDynaModel> selectByPPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysDynaModel> selectByPPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysDynaModel> selectByPPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDynaModel> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysDynaModel> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysDynaModel> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDYNAMODEL_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSDYNAMODEL", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSModule(pSModule);
        for (PSSysDynaModel pSSysDynaModel : arrayList) {
            PSSysDynaModel pSSysDynaModel2 = (PSSysDynaModel)this.getDEModel().createEntity();
            pSSysDynaModel2.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
            pSSysDynaModel2.setPSModuleId(null);
            this.update(pSSysDynaModel2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysDynaModelServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysDynaModelServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysDynaModel pSSysDynaModel : arrayList) {
            this.remove((IEntity)pSSysDynaModel);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSSysDynaModel(pSSysDynaModelCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODELCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModelCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDYNAMODEL_PSSYSDYNAMODELCAT_PSSYSDYNAMODELCATID", "", iDataEntityModel.getName(), "PSSYSDYNAMODEL", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModelCat), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSSysDynaModel(pSSysDynaModelCat);
        for (PSSysDynaModel pSSysDynaModel : arrayList) {
            PSSysDynaModel pSSysDynaModel2 = (PSSysDynaModel)this.getDEModel().createEntity();
            pSSysDynaModel2.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
            pSSysDynaModel2.setPSSysDynaModelCatId(null);
            this.update(pSSysDynaModel2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat) throws Exception {
        final PSSysDynaModelCat pSSysDynaModelCat2 = pSSysDynaModelCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModelCat2);
                PSSysDynaModelServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModelCat2);
                PSSysDynaModelServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModelCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSSysDynaModel(pSSysDynaModelCat);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModelCat, arrayList);
        for (PSSysDynaModel pSSysDynaModel : arrayList) {
            this.remove((IEntity)pSSysDynaModel);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModelCat, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModelCat pSSysDynaModelCat, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    public void resetPPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPPSSysDynaModel(pSSysDynaModel);
        for (PSSysDynaModel pSSysDynaModel2 : arrayList) {
            PSSysDynaModel pSSysDynaModel3 = (PSSysDynaModel)this.getDEModel().createEntity();
            pSSysDynaModel3.setPSSysDynaModelId(pSSysDynaModel2.getPSSysDynaModelId());
            pSSysDynaModel3.setPPSSysDynaModelId(null);
            this.update(pSSysDynaModel3);
        }
    }

    public void removeByPPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelServiceBase.this.onBeforeRemoveByPPSSysDynaModel(pSSysDynaModel2);
                PSSysDynaModelServiceBase.this.internalRemoveByPPSSysDynaModel(pSSysDynaModel2);
                PSSysDynaModelServiceBase.this.onAfterRemoveByPPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysDynaModel pSSysDynaModel2 : arrayList) {
            this.remove((IEntity)pSSysDynaModel2);
        }
        this.onAfterRemoveByPPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysDynaModel pSSysDynaModel : arrayList) {
            PSSysDynaModel pSSysDynaModel2 = (PSSysDynaModel)this.getDEModel().createEntity();
            pSSysDynaModel2.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
            pSSysDynaModel2.setPSSystemId(null);
            this.update(pSSysDynaModel2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysDynaModelServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysDynaModelServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDynaModel> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysDynaModel pSSysDynaModel : arrayList) {
            this.remove((IEntity)pSSysDynaModel);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDynaModel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDynaModel pSSysDynaModel) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUtilServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByInPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByOutPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEChartAxesService)ServiceGlobal.getService(PSDEChartAxesService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartAxesServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByCSPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByInPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupServiceBase)pSCoreSysServiceBase).testRemoveByInitPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGroupServiceBase)pSCoreSysServiceBase).testRemoveByInitPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERGroupServiceBase)pSCoreSysServiceBase).testRemoveByInitPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEUtilDEService)ServiceGlobal.getService(PSDEUtilDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUtilDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADetailServiceBase)pSCoreSysServiceBase).testRemoveByInPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADetailServiceBase)pSCoreSysServiceBase).testRemoveByOutPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysAIFactoryService)ServiceGlobal.getService(PSSysAIFactoryService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIFactoryServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysBackServiceService)ServiceGlobal.getService(PSSysBackServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBackServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysChartThemeService)ServiceGlobal.getService(PSSysChartThemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysChartThemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysContentCatServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysContentServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCounterServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDataSyncAgentServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBVFServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDELogicNodeService)ServiceGlobal.getService(PSSysDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDictCatService)ServiceGlobal.getService(PSSysDictCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDictCatServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDynaModelAttrServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        ((PSSysDynaModelAttrServiceBase)pSCoreSysServiceBase).removeByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDynaModelAttrServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDynaModelServiceBase)pSCoreSysServiceBase).testRemoveByPPSSysDynaModel(pSSysDynaModel);
        ((PSSysDynaModelServiceBase)pSCoreSysServiceBase).removeByPPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgQueueServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysMsgTargetService)ServiceGlobal.getService(PSSysMsgTargetService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTargetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMsgTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPFPITemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysRunSessionServiceBase)pSCoreSysServiceBase).testRemoveByRunPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysSAHandlerService)ServiceGlobal.getService(PSSysSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSAHandlerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSequenceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPITemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSFPubServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemRunServiceBase)pSCoreSysServiceBase).testRemoveByRunPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTranslatorServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniResServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUserDRServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysUserModeService)ServiceGlobal.getService(PSSysUserModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUserModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUtilDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        pSCoreSysServiceBase = (PSViewWizardGroupService)ServiceGlobal.getService(PSViewWizardGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewWizardGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDynaModel(pSSysDynaModel);
        super.onBeforeRemove(pSSysDynaModel);
    }

    protected void replaceParentInfo(PSSysDynaModel pSSysDynaModel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDynaModel, cloneSession);
        if (pSSysDynaModel.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysDynaModel.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysDynaModel, (PSModule)iEntity);
        }
        if (pSSysDynaModel.getPSSysDynaModelCatId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODELCAT", (Object)pSSysDynaModel.getPSSysDynaModelCatId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysDynaModel, (PSSysDynaModelCat)iEntity);
        }
        if (pSSysDynaModel.getPPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysDynaModel.getPPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PPSSysDynaModel(pSSysDynaModel, (PSSysDynaModel)iEntity);
        }
        if (pSSysDynaModel.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysDynaModel.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysDynaModel, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDynaModel, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysDynaModel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DTOCodeName(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModel(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModel2(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFmt(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelUsage(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelTag(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelTag2(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelTag3(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelTag4(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysDynaModelId(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelCatId(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysDynaModel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDynaModel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isCodeNameDirty() : !pSSysDynaModel.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysDynaModel, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysDynaModelDEModel(), "CODENAME", string3, pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isDefaultFlagDirty() : !pSSysDynaModel.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSysDynaModel.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSTEMID";
                string = string + ";";
                string = string + "PSMODULEID";
                String string2 = this.checkFieldDupRule(this.getPSSysDynaModelDEModel(), "DEFAULTFLAG", string, pSSysDynaModel, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DTOCodeName(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isDTOCodeNameDirty() : !pSSysDynaModel.isDTOCodeNameDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getDTOCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DTOCodeName_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DTOCODENAME");
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
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDynaModelDEModel(), "DTOCODENAME", string3, pSSysDynaModel, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DTOCODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModel(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isDynaModelDirty() : !pSSysDynaModel.isDynaModelDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getDynaModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModel_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModel2(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isDynaModel2Dirty() : !pSSysDynaModel.isDynaModel2Dirty()) {
            return null;
        }
        String string = pSSysDynaModel.getDynaModel2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModel2_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODEL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFmt(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isDynaModelFmtDirty() : !pSSysDynaModel.isDynaModelFmtDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getDynaModelFmt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModelFmt_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFMT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelUsage(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isDynaModelUsageDirty() : !pSSysDynaModel.isDynaModelUsageDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getDynaModelUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaModelUsage_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELUSAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isLockFlagDirty() : !pSSysDynaModel.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysDynaModel.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isLogicNameDirty() : !pSSysDynaModel.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isMemoDirty() : !pSSysDynaModel.isMemoDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelTag(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isModelTagDirty() : !pSSysDynaModel.isModelTagDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getModelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelTag_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG");
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
                String string4 = this.checkFieldDupRule(this.getPSSysDynaModelDEModel(), "MODELTAG", string3, pSSysDynaModel, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MODELTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelTag2(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isModelTag2Dirty() : !pSSysDynaModel.isModelTag2Dirty()) {
            return null;
        }
        String string = pSSysDynaModel.getModelTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelTag2_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelTag3(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isModelTag3Dirty() : !pSSysDynaModel.isModelTag3Dirty()) {
            return null;
        }
        String string = pSSysDynaModel.getModelTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelTag3_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelTag4(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isModelTag4Dirty() : !pSSysDynaModel.isModelTag4Dirty()) {
            return null;
        }
        String string = pSSysDynaModel.getModelTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelTag4_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysDynaModelId(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isPPSSysDynaModelIdDirty() : !pSSysDynaModel.isPPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getPPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysDynaModelId_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isPSModuleIdDirty() : !pSSysDynaModel.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelCatId(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isPSSysDynaModelCatIdDirty() : !pSSysDynaModel.isPSSysDynaModelCatIdDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getPSSysDynaModelCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelCatId_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isPSSysDynaModelIdDirty() && !bl2 : !pSSysDynaModel.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getPSSysDynaModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isPSSysDynaModelNameDirty() && !bl2 : !pSSysDynaModel.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getPSSysDynaModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default((IEntity)pSSysDynaModel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysDynaModelDEModel(), "PSSYSDYNAMODELNAME", string3, pSSysDynaModel, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isPSSystemIdDirty() && !bl2 : !pSSysDynaModel.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isPSSystemNameDirty() : !pSSysDynaModel.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isUserCatDirty() : !pSSysDynaModel.isUserCatDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isUserTagDirty() : !pSSysDynaModel.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDynaModel.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isUserTag2Dirty() : !pSSysDynaModel.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDynaModel.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isUserTag3Dirty() : !pSSysDynaModel.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysDynaModel.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysDynaModel pSSysDynaModel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModel.isUserTag4Dirty() : !pSSysDynaModel.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysDynaModel.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysDynaModel, bl2, bl3);
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

    protected void onSyncEntity(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDynaModel, bl);
    }

    protected void onSyncIndexEntities(PSSysDynaModel pSSysDynaModel, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDynaModel, bl);
    }

    public Object getDataContextValue(PSSysDynaModel pSSysDynaModel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDynaModel, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSSysDynaModel pSSysDynaModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSSysDynaModelAttr_PSSysDynaModel(pSSysDynaModel, arrayList, n);
        super.onExportRelatedModel((IEntity)pSSysDynaModel, arrayList, n);
    }

    protected void onExportRelatedModel_PSSysDynaModelAttr_PSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysDynaModelAttr> arrayList2 = pSSysDynaModelAttrService.selectByPSSysDynaModel(pSSysDynaModel);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"399cfef9d8a2abb2e2bfb4e9d16cc226");
            jSONObject.put("srfdename", (Object)"PSSYSDYNAMODELATTR");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSSysDynaModel, (String)"PSSYSDYNAMODELID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSSysDynaModelAttr, (String)"srfsyspub", (int)1) == 0) continue;
            pSSysDynaModelAttrService.exportModel(pSSysDynaModelAttr, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSSysDynaModel pSSysDynaModel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDynaModel, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DTOCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DTOCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODEL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModel2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFMT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFmt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELUSAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelUsage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DTOCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DTOCODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("DTOCODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODEL", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModel2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODEL2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFmt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODELFMT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelUsage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODELUSAGE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ModelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("MODELTAG", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSSYSDYNAMODELID", "PSSYSDYNAMODEL", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysDynaModelCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDynaModel pSSysDynaModel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDynaModel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDynaModel pSSysDynaModel) throws Exception {
        super.onUpdateParent((IEntity)pSSysDynaModel);
    }

    protected void onCopyDetails(PSSysDynaModel pSSysDynaModel, Object object) throws Exception {
        PSSysDynaModel pSSysDynaModel2 = new PSSysDynaModel();
        pSSysDynaModel2.set("PSSYSDYNAMODELID", object);
        String string = DataObject.getStringValue((Object)pSSysDynaModel.get("PSSYSDYNAMODELID"));
        PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysDynaModelAttr> arrayList = pSSysDynaModelAttrService.selectByPSSysDynaModel(pSSysDynaModel2);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            Object object2 = pSSysDynaModelAttr.get("PSSYSDYNAMODELATTRID");
            pSSysDynaModelAttrService.getDraftFrom((IEntity)pSSysDynaModelAttr);
            pSSysDynaModelAttrService.fillParentInfo((IEntity)pSSysDynaModelAttr, "DER1N", "DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID", string);
            pSSysDynaModelAttrService.create(pSSysDynaModelAttr);
            pSSysDynaModelAttrService.copyDetails(pSSysDynaModelAttr, object2);
        }
        super.onCopyDetails((IEntity)pSSysDynaModel, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysDynaModel pSSysDynaModel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDYNAMODEL");
        if (!bl) {
            pSSysDynaModel.setCreateDate(null);
            pSSysDynaModel.setCreateMan(null);
            pSSysDynaModel.setPSSysDynaModelId(null);
            pSSysDynaModel.setUpdateDate(null);
            pSSysDynaModel.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDynaModel, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDynaModel pSSysDynaModel, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDynaModel, string);
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
            return "DER1N_PSSYSDYNAMODEL_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDYNAMODEL_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysDynaModel pSSysDynaModel) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDynaModel.getCodeName())) {
            return pSSysDynaModel.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDynaModel.getPSSysDynaModelName())) {
            return pSSysDynaModel.getPSSysDynaModelName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDynaModel.getCodeName())) {
            return pSSysDynaModel.getCodeName();
        }
        return super.getModelV2Tag(pSSysDynaModel);
    }

    @Override
    public boolean setModelV2Tag(PSSysDynaModel pSSysDynaModel, String string) {
        pSSysDynaModel.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSDYNAMODELNAME", "");
        map.put("CODENAME", "");
        map.put("DTOCODENAME", "");
        map.put("MODELTAG", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDynaModel pSSysDynaModel, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDynaModel.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDynaModel, true);
        pSSysDynaModel.set("CODENAME", string);
        if (this.select(pSSysDynaModel, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDynaModel, true);
        return super.getModelV2Entity(pSSysDynaModel, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDynaModel pSSysDynaModel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysDynaModel, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysDynaModel pSSysDynaModel, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSDYNAMODEL#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSDYNAMODELATTR", (Object)pSSysDynaModel.getPSSysDynaModelId()))).exists()) {
            PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysDynaModelAttrService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysDynaModelAttr pSSysDynaModelAttr = new PSSysDynaModelAttr();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysDynaModelAttr, objectNode, false);
                String string6 = pSSysDynaModelAttrService.getModelV2Tag(pSSysDynaModelAttr);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSDYNAMODELATTR", (Object)pSSysDynaModelAttr.getPSSysDynaModelAttrId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysDynaModelAttrService.exportModelV2(pSSysDynaModelAttr, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysDynaModel, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysDynaModel pSSysDynaModel, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID")) {
            Object object;
            PSSysDynaModelAttr pSSysDynaModelAttr2;
            Object object2;
            Object object3;
            Object object4;
            PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysDynaModelAttr> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSDYNAMODEL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSDYNAMODELATTR", (Object)pSSysDynaModel.getPSSysDynaModelId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysDynaModelAttr2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysDynaModelAttr2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysDynaModelAttr>();
                object4 = pSSysDynaModelAttrService.selectByPSSysDynaModel(pSSysDynaModel);
                object3 = StringHelper.format((String)"PSSYSDYNAMODEL#%1$s", (Object)pSSysDynaModel.getPSSysDynaModelId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysDynaModelAttr2 = object2.next();
                    object = pSSysDynaModelAttrService.getModelV2ResScope((IEntity)pSSysDynaModelAttr2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysDynaModelAttr)PSModelV2Helper.toJSONObject((IEntity)pSSysDynaModelAttr2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysDynaModelAttrService.getModelV2Name(false);
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
                        if (objectNode.has("pssysdynamodelattrname")) {
                            string = objectNode.get("pssysdynamodelattrname").asText();
                        }
                        if (objectNode2.has("pssysdynamodelattrname")) {
                            string2 = objectNode2.get("pssysdynamodelattrname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysDynaModelAttr pSSysDynaModelAttr2 : arrayList) {
                    object = new PSSysDynaModelAttr();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysDynaModelAttr2, false);
                    object3.add((JsonNode)pSSysDynaModelAttrService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysDynaModel, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysDynaModel pSSysDynaModel) throws Exception {
        super.onEmptyModelV2(pSSysDynaModel);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysDynaModelAttrService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysDynaModel pSSysDynaModel, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysDynaModelAttr pSSysDynaModelAttr = new PSSysDynaModelAttr();
        pSSysDynaModelAttr.set("PSSYSDYNAMODELID", pSSysDynaModel.getPSSysDynaModelId());
        PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysDynaModelAttrService.getModelV2Entity(pSSysDynaModelAttr, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysDynaModel, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysDynaModel pSSysDynaModel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysDynaModelServiceBase.isSimpleImportExportMode("")) {
            PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysDynaModelAttrService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysDynaModelAttr pSSysDynaModelAttr = new PSSysDynaModelAttr();
                    pSSysDynaModelAttr.setDynaModelUsage(pSSysDynaModel.getDynaModelUsage());
                    pSSysDynaModelAttr.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
                    pSSysDynaModelAttr.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                    pSSysDynaModelAttrService.compileModelV2(pSSysDynaModelAttr, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysDynaModelAttr pSSysDynaModelAttr = new PSSysDynaModelAttr();
                        pSSysDynaModelAttr.setDynaModelUsage(pSSysDynaModel.getDynaModelUsage());
                        pSSysDynaModelAttr.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
                        pSSysDynaModelAttr.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                        pSSysDynaModelAttrService.compileModelV2(pSSysDynaModelAttr, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysDynaModel, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysDynaModel pSSysDynaModel, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysDynaModelAttrs(pSSysDynaModel, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysDynaModel, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysDynaModelAttrs(PSSysDynaModel pSSysDynaModel, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSDYNAMODELATTR", true), (boolean)false) == 0) {
            PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
            PSSysDynaModelAttr pSSysDynaModelAttr = new PSSysDynaModelAttr();
            pSSysDynaModelAttr.setPSSysDynaModelAttrId(pSMOSFile.getPSModelId());
            if (!pSSysDynaModelAttrService.get((IEntity)pSSysDynaModelAttr, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysDynaModelAttr.getPSSysDynaModelId(), (String)pSSysDynaModel.getPSSysDynaModelId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysDynaModelAttrService.exportModelV2(pSSysDynaModelAttr);
            pSSysDynaModelAttr.reset();
            if (!pSSysDynaModelAttrService.setModelV2ResScope((IEntity)pSSysDynaModelAttr, "PSSYSDYNAMODEL", pSSysDynaModel.getPSSysDynaModelId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysDynaModelAttrService.importModelV2(pSSysDynaModelAttr, objectNode);
            SessionFactoryManager.commit();
            return pSSysDynaModelAttrService.getFile((IEntity)pSSysDynaModelAttr);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysDynaModel pSSysDynaModel, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysDynaModelAttrs(pSSysDynaModel, list);
        super.onFillPasteHelps(pSSysDynaModel, list);
    }

    protected void onFillPasteHelps_PSSysDynaModelAttrs(PSSysDynaModel pSSysDynaModel, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSDYNAMODELATTR");
        pSHelpSection.setSectionParam2("DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u5bf9\u8c61]\u7684[\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u5c5e\u6027]");
        list.add(pSHelpSection);
    }
}

