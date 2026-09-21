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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysReqItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpec;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpecBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemData;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemDataBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemHis;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemHisBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemDataServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemHisService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemHisServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysReqItemServiceBase
extends PSCoreSysServiceBase<PSSysReqItem> {
    private static final Log log = LogFactory.getLog(PSSysReqItemServiceBase.class);
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VIEW = "VIEW";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysReqItemDEModel pSSysReqItemDEModel;
    private PSSysReqItemDAO pSSysReqItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService";
    }

    public PSSysReqItemDEModel getPSSysReqItemDEModel() {
        if (this.pSSysReqItemDEModel == null) {
            try {
                this.pSSysReqItemDEModel = (PSSysReqItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysReqItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysReqItemDEModel();
    }

    public PSSysReqItemDAO getPSSysReqItemDAO() {
        if (this.pSSysReqItemDAO == null) {
            try {
                this.pSSysReqItemDAO = (PSSysReqItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysReqItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysReqItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysReqItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VIEW, (boolean)true) == 0) {
            return this.fetchView(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, false);
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

    public DBFetchResult fetchView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VIEW, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysReqItem pSSysReqItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSDEVPRDSPEC_PSDEVPRDSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSpec pSDevPrdSpec = (PSDevPrdSpec)iService.getDEModel().createEntity();
            pSDevPrdSpec.set("PSDEVPRDSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdSpec);
            } else {
                iService.get((IEntity)pSDevPrdSpec);
            }
            this.onFillParentInfo_PSDevPrdSpec(pSSysReqItem, pSDevPrdSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdVer);
            } else {
                iService.get((IEntity)pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSSysReqItem, pSDevPrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSDEVPRD_PSDEVPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory());
            PSDevPrd pSDevPrd = (PSDevPrd)iService.getDEModel().createEntity();
            pSDevPrd.set("PSDEVPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrd);
            } else {
                iService.get((IEntity)pSDevPrd);
            }
            this.onFillParentInfo_PSDevPrd(pSSysReqItem, pSDevPrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysReqItem, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSSYSREQITEM_PPSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem2.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem2);
            } else {
                iService.get((IEntity)pSSysReqItem2);
            }
            this.onFillParentInfo_PPSysReqItem(pSSysReqItem, pSSysReqItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSSYSREQMODULE_PSSYSREQMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService", (SessionFactory)this.getSessionFactory());
            PSSysReqModule pSSysReqModule = (PSSysReqModule)iService.getDEModel().createEntity();
            pSSysReqModule.set("PSSYSREQMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqModule);
            } else {
                iService.get((IEntity)pSSysReqModule);
            }
            this.onFillParentInfo_PSSysReqModule(pSSysReqItem, pSSysReqModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysReqItem, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEM_PSSYSUSERCASE_PSSYSUSERCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUserCase);
            } else {
                iService.get((IEntity)pSSysUserCase);
            }
            this.onFillParentInfo_PSSysUserCase(pSSysReqItem, pSSysUserCase);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysReqItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdSpec(PSSysReqItem pSSysReqItem, PSDevPrdSpec pSDevPrdSpec) throws Exception {
        pSSysReqItem.setPSDevPrdSpecId(pSDevPrdSpec.getPSDevPrdSpecId());
        pSSysReqItem.setPSDevPrdSpecName(pSDevPrdSpec.getPSDevPrdSpecName());
    }

    protected void onFillParentInfo_PSDevPrdVer(PSSysReqItem pSSysReqItem, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSSysReqItem.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSSysReqItem.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
    }

    protected void onFillParentInfo_PSDevPrd(PSSysReqItem pSSysReqItem, PSDevPrd pSDevPrd) throws Exception {
        pSSysReqItem.setPSDevPrdId(pSDevPrd.getPSDevPrdId());
        pSSysReqItem.setPSDevPrdName(pSDevPrd.getPSDevPrdName());
    }

    protected void onFillParentInfo_PSModule(PSSysReqItem pSSysReqItem, PSModule pSModule) throws Exception {
        pSSysReqItem.setPSModuleId(pSModule.getPSModuleId());
        pSSysReqItem.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PPSysReqItem(PSSysReqItem pSSysReqItem, PSSysReqItem pSSysReqItem2) throws Exception {
        pSSysReqItem.setPPSSysReqItemId(pSSysReqItem2.getPSSysReqItemId());
        pSSysReqItem.setPPSSysReqItemName(pSSysReqItem2.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysReqModule(PSSysReqItem pSSysReqItem, PSSysReqModule pSSysReqModule) throws Exception {
        pSSysReqItem.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
        pSSysReqItem.setPSSysReqModuleName(pSSysReqModule.getPSSysReqModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSSysReqItem pSSysReqItem, PSSystem pSSystem) throws Exception {
        pSSysReqItem.setPSSystemId(pSSystem.getPSSystemId());
        pSSysReqItem.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUserCase(PSSysReqItem pSSysReqItem, PSSysUserCase pSSysUserCase) throws Exception {
        pSSysReqItem.setPSSysUserCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSSysReqItem.setPSSysUserCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillEntityFullInfo(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
        if (bl) {
            if (pSSysReqItem.getCodeName() == null) {
                pSSysReqItem.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ReqItem", 25));
            }
            if (pSSysReqItem.getItemType() == null) {
                pSSysReqItem.setItemType((String)this.getDefaultValue(this.getWebContext(), "", "NORMAL", 25));
            }
            if (pSSysReqItem.getPSSysReqItemDatasCnt() == null) {
                pSSysReqItem.setPSSysReqItemDatasCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysReqItem.getPSSysReqItemHisesCnt() == null) {
                pSSysReqItem.setPSSysReqItemHisesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysReqItem.getPSSysReqItemName() == null) {
                pSSysReqItem.setPSSysReqItemName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u9700\u6c42\u9879", 25));
            }
            if (pSSysReqItem.getValidFlag() == null) {
                pSSysReqItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSysReqItem.getVer() == null) {
                pSSysReqItem.setVer((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysReqItem, bl);
        this.onFillEntityFullInfo_PSDevPrdSpec(pSSysReqItem, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSSysReqItem, bl);
        this.onFillEntityFullInfo_PSDevPrd(pSSysReqItem, bl);
        this.onFillEntityFullInfo_PSModule(pSSysReqItem, bl);
        this.onFillEntityFullInfo_PPSysReqItem(pSSysReqItem, bl);
        this.onFillEntityFullInfo_PSSysReqModule(pSSysReqItem, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysReqItem, bl);
        this.onFillEntityFullInfo_PSSysUserCase(pSSysReqItem, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdSpec(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrd(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSysReqItem(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqModule(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
        if (pSSysReqItem.isPSSystemIdDirty()) {
            if (pSSysReqItem.getPSSystemId() != null) {
                if (pSSysReqItem.getPSSystemId() == null || pSSysReqItem.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysReqItem.getPSSystem();
                    pSSysReqItem.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysReqItem.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysUserCase(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysReqItem, bl);
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrdSpec(PSDevPrdSpecBase pSDevPrdSpecBase) throws Exception {
        return this.selectByPSDevPrdSpec(pSDevPrdSpecBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrdSpec(PSDevPrdSpecBase pSDevPrdSpecBase, String string) throws Exception {
        return this.selectByPSDevPrdSpec(pSDevPrdSpecBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrdSpec(PSDevPrdSpecBase pSDevPrdSpecBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDSPECID", (Object)pSDevPrdSpecBase.getPSDevPrdSpecId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdSpecCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdSpecCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDVERID", (Object)pSDevPrdVerBase.getPSDevPrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDID", (Object)pSDevPrdBase.getPSDevPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqItem> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysReqItem> selectByPPSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPPSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPPSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPPSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPPSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSREQITEMID", (Object)pSSysReqItemBase.getPSSysReqItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSysReqItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSysReqItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqItem> selectByPSSysReqModule(PSSysReqModuleBase pSSysReqModuleBase) throws Exception {
        return this.selectByPSSysReqModule(pSSysReqModuleBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPSSysReqModule(PSSysReqModuleBase pSSysReqModuleBase, String string) throws Exception {
        return this.selectByPSSysReqModule(pSSysReqModuleBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPSSysReqModule(PSSysReqModuleBase pSSysReqModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREQMODULEID", (Object)pSSysReqModuleBase.getPSSysReqModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysReqModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysReqModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqItem> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysReqItem> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSSysReqItem> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSSysReqItem> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERCASEID", (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserCaseCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrdSpec(pSDevPrdSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrdSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQITEM_PSDEVPRDSPEC_PSDEVPRDSPECID", "", iDataEntityModel.getName(), "PSSYSREQITEM", iDataEntityModel.getDataInfo((IEntity)pSDevPrdSpec), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrdSpec(pSDevPrdSpec);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem2.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItem2.setPSDevPrdSpecId(null);
            this.update(pSSysReqItem2);
        }
    }

    public void removeByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        final PSDevPrdSpec pSDevPrdSpec2 = pSDevPrdSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPSDevPrdSpec(pSDevPrdSpec2);
                PSSysReqItemServiceBase.this.internalRemoveByPSDevPrdSpec(pSDevPrdSpec2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPSDevPrdSpec(pSDevPrdSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
    }

    protected void internalRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrdSpec(pSDevPrdSpec);
        this.onBeforeRemoveByPSDevPrdSpec(pSDevPrdSpec, arrayList);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            this.remove((IEntity)pSSysReqItem);
        }
        this.onAfterRemoveByPSDevPrdSpec(pSDevPrdSpec, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdSpec(PSDevPrdSpec pSDevPrdSpec, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQITEM_PSDEVPRDVER_PSDEVPRDVERID", "", iDataEntityModel.getName(), "PSSYSREQITEM", iDataEntityModel.getDataInfo((IEntity)pSDevPrdVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem2.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItem2.setPSDevPrdVerId(null);
            this.update(pSSysReqItem2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSSysReqItemServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            this.remove((IEntity)pSSysReqItem);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrd(pSDevPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQITEM_PSDEVPRD_PSDEVPRDID", "", iDataEntityModel.getName(), "PSSYSREQITEM", iDataEntityModel.getDataInfo((IEntity)pSDevPrd), arrayList.get(0)));
        }
    }

    public void resetPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrd(pSDevPrd);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem2.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItem2.setPSDevPrdId(null);
            this.update(pSSysReqItem2);
        }
    }

    public void removeByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        final PSDevPrd pSDevPrd2 = pSDevPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPSDevPrd(pSDevPrd2);
                PSSysReqItemServiceBase.this.internalRemoveByPSDevPrd(pSDevPrd2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPSDevPrd(pSDevPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void internalRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSDevPrd(pSDevPrd);
        this.onBeforeRemoveByPSDevPrd(pSDevPrd, arrayList);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            this.remove((IEntity)pSSysReqItem);
        }
        this.onAfterRemoveByPSDevPrd(pSDevPrd, arrayList);
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQITEM_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSREQITEM", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSModule(pSModule);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem2.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItem2.setPSModuleId(null);
            this.update(pSSysReqItem2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysReqItemServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            this.remove((IEntity)pSSysReqItem);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    public void testRemoveByPPSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    public void resetPPSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPPSysReqItem(pSSysReqItem);
        for (PSSysReqItem pSSysReqItem2 : arrayList) {
            PSSysReqItem pSSysReqItem3 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem3.setPSSysReqItemId(pSSysReqItem2.getPSSysReqItemId());
            pSSysReqItem3.setPPSSysReqItemId(null);
            this.update(pSSysReqItem3);
        }
    }

    public void removeByPPSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPPSysReqItem(pSSysReqItem2);
                PSSysReqItemServiceBase.this.internalRemoveByPPSysReqItem(pSSysReqItem2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPPSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPPSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPPSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPPSysReqItem(pSSysReqItem, arrayList);
        for (PSSysReqItem pSSysReqItem2 : arrayList) {
            this.remove((IEntity)pSSysReqItem2);
        }
        this.onAfterRemoveByPPSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPPSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSysReqModule(pSSysReqModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQITEM_PSSYSREQMODULE_PSSYSREQMODULEID", "", iDataEntityModel.getName(), "PSSYSREQITEM", iDataEntityModel.getDataInfo((IEntity)pSSysReqModule), arrayList.get(0)));
        }
    }

    public void resetPSSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSysReqModule(pSSysReqModule);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem2.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItem2.setPSSysReqModuleId(null);
            this.update(pSSysReqItem2);
        }
    }

    public void removeByPSSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        final PSSysReqModule pSSysReqModule2 = pSSysReqModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPSSysReqModule(pSSysReqModule2);
                PSSysReqItemServiceBase.this.internalRemoveByPSSysReqModule(pSSysReqModule2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPSSysReqModule(pSSysReqModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
    }

    protected void internalRemoveByPSSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSysReqModule(pSSysReqModule);
        this.onBeforeRemoveByPSSysReqModule(pSSysReqModule, arrayList);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            this.remove((IEntity)pSSysReqItem);
        }
        this.onAfterRemoveByPSSysReqModule(pSSysReqModule, arrayList);
    }

    protected void onAfterRemoveByPSSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqModule(PSSysReqModule pSSysReqModule, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqModule(PSSysReqModule pSSysReqModule, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem2.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItem2.setPSSystemId(null);
            this.update(pSSysReqItem2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysReqItemServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            this.remove((IEntity)pSSysReqItem);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSysUserCase(pSSysUserCase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERCASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUserCase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQITEM_PSSYSUSERCASE_PSSYSUSERCASEID", "", iDataEntityModel.getName(), "PSSYSREQITEM", iDataEntityModel.getDataInfo((IEntity)pSSysUserCase), arrayList.get(0)));
        }
    }

    public void resetPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getDEModel().createEntity();
            pSSysReqItem2.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItem2.setPSSysUserCaseId(null);
            this.update(pSSysReqItem2);
        }
    }

    public void removeByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqItemServiceBase.this.onBeforeRemoveByPSSysUserCase(pSSysUserCase2);
                PSSysReqItemServiceBase.this.internalRemoveByPSSysUserCase(pSSysUserCase2);
                PSSysReqItemServiceBase.this.onAfterRemoveByPSSysUserCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysReqItem> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        this.onBeforeRemoveByPSSysUserCase(pSSysUserCase, arrayList);
        for (PSSysReqItem pSSysReqItem : arrayList) {
            this.remove((IEntity)pSSysReqItem);
        }
        this.onAfterRemoveByPSSysUserCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysReqItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysReqItem pSSysReqItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        ((PSAppSBItemRSServiceBase)pSCoreSysServiceBase).resetPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).resetPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataExpServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSyncServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFValueRuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESampleDataServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysDELogicNodeService)ServiceGlobal.getService(PSSysDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqItemDataServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        ((PSSysReqItemDataServiceBase)pSCoreSysServiceBase).removeByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqItemHisServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        ((PSSysReqItemHisServiceBase)pSCoreSysServiceBase).removeByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqItemServiceBase)pSCoreSysServiceBase).testRemoveByPPSysReqItem(pSSysReqItem);
        ((PSSysReqItemServiceBase)pSCoreSysServiceBase).removeByPPSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTaskServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestDataServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFVersionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        pSCoreSysServiceBase = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        ((PSWorkflowServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqItem(pSSysReqItem);
        super.onBeforeRemove(pSSysReqItem);
    }

    protected void replaceParentInfo(PSSysReqItem pSSysReqItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysReqItem, cloneSession);
        if (pSSysReqItem.getPSDevPrdSpecId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSPEC", (Object)pSSysReqItem.getPSDevPrdSpecId())) != null) {
            this.onFillParentInfo_PSDevPrdSpec(pSSysReqItem, (PSDevPrdSpec)iEntity);
        }
        if (pSSysReqItem.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSSysReqItem.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSSysReqItem, (PSDevPrdVer)iEntity);
        }
        if (pSSysReqItem.getPSDevPrdId() != null && (iEntity = cloneSession.getEntity("PSDEVPRD", (Object)pSSysReqItem.getPSDevPrdId())) != null) {
            this.onFillParentInfo_PSDevPrd(pSSysReqItem, (PSDevPrd)iEntity);
        }
        if (pSSysReqItem.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysReqItem.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysReqItem, (PSModule)iEntity);
        }
        if (pSSysReqItem.getPPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSysReqItem.getPPSSysReqItemId())) != null) {
            this.onFillParentInfo_PPSysReqItem(pSSysReqItem, (PSSysReqItem)iEntity);
        }
        if (pSSysReqItem.getPSSysReqModuleId() != null && (iEntity = cloneSession.getEntity("PSSYSREQMODULE", (Object)pSSysReqItem.getPSSysReqModuleId())) != null) {
            this.onFillParentInfo_PSSysReqModule(pSSysReqItem, (PSSysReqModule)iEntity);
        }
        if (pSSysReqItem.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysReqItem.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysReqItem, (PSSystem)iEntity);
        }
        if (pSSysReqItem.getPSSysUserCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSSysReqItem.getPSSysUserCaseId())) != null) {
            this.onFillParentInfo_PSSysUserCase(pSSysReqItem, (PSSysUserCase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysReqItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AIBuildMode(bl, pSSysReqItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIBuildParams(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIBuildState(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIChoices(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPrompt(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices2(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices3(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices4(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemSN(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag2(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag3(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag4(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemType(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysReqItemId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSpecId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemDatasCnt(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemHisesCnt(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemName(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqModuleId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseId(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReqContent(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReqModel(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReqModelType(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Subject(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncModelMode(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Ver(bl, pSSysReqItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysReqItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AIBuildMode(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIBuildModeDirty() : !pSSysReqItem.isAIBuildModeDirty()) {
            return null;
        }
        Integer n = pSSysReqItem.getAIBuildMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AIBuildMode_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIBUILDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIBuildParams(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIBuildParamsDirty() : !pSSysReqItem.isAIBuildParamsDirty()) {
            return null;
        }
        String string = pSSysReqItem.getAIBuildParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIBuildParams_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIBUILDPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIBuildState(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIBuildStateDirty() : !pSSysReqItem.isAIBuildStateDirty()) {
            return null;
        }
        Integer n = pSSysReqItem.getAIBuildState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AIBuildState_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIBUILDSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIChoices(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIChoicesDirty() : !pSSysReqItem.isAIChoicesDirty()) {
            return null;
        }
        String string = pSSysReqItem.getAIChoices();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIChoices_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AICHOICES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPrompt(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIPromptDirty() : !pSSysReqItem.isAIPromptDirty()) {
            return null;
        }
        String string = pSSysReqItem.getAIPrompt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPrompt_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIPromptChoicesDirty() : !pSSysReqItem.isAIPromptChoicesDirty()) {
            return null;
        }
        String string = pSSysReqItem.getAIPromptChoices();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices2(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIPromptChoices2Dirty() : !pSSysReqItem.isAIPromptChoices2Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getAIPromptChoices2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices2_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices3(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIPromptChoices3Dirty() : !pSSysReqItem.isAIPromptChoices3Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getAIPromptChoices3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices3_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices4(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isAIPromptChoices4Dirty() : !pSSysReqItem.isAIPromptChoices4Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getAIPromptChoices4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices4_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isCodeNameDirty() : !pSSysReqItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysReqItem.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysReqItem, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSREQMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysReqItemDEModel(), "CODENAME", string3, pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ItemSN(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isItemSNDirty() : !pSSysReqItem.isItemSNDirty()) {
            return null;
        }
        String string = pSSysReqItem.getItemSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemSN_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMSN");
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
                String string4 = this.checkFieldDupRule(this.getPSSysReqItemDEModel(), "ITEMSN", string3, pSSysReqItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ITEMSN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isItemTagDirty() : !pSSysReqItem.isItemTagDirty()) {
            return null;
        }
        String string = pSSysReqItem.getItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag2(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isItemTag2Dirty() : !pSSysReqItem.isItemTag2Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getItemTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag2_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag3(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isItemTag3Dirty() : !pSSysReqItem.isItemTag3Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getItemTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag3_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag4(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isItemTag4Dirty() : !pSSysReqItem.isItemTag4Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getItemTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag4_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemType(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isItemTypeDirty() && !bl2 : !pSSysReqItem.isItemTypeDirty()) {
            return null;
        }
        String string = pSSysReqItem.getItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemType_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isMemoDirty() : !pSSysReqItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysReqItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isOrderValueDirty() : !pSSysReqItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysReqItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysReqItemId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPPSSysReqItemIdDirty() : !pSSysReqItem.isPPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysReqItemId_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSREQITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSDevPrdIdDirty() : !pSSysReqItem.isPSDevPrdIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSDevPrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdId_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSpecId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSDevPrdSpecIdDirty() : !pSSysReqItem.isPSDevPrdSpecIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSDevPrdSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSpecId_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSDevPrdVerIdDirty() : !pSSysReqItem.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSDevPrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSModuleIdDirty() : !pSSysReqItem.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemDatasCnt(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSysReqItemDatasCntDirty() : !pSSysReqItem.isPSSysReqItemDatasCntDirty()) {
            return null;
        }
        Integer n = pSSysReqItem.getPSSysReqItemDatasCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysReqItemDatasCnt_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMDATASCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemHisesCnt(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSysReqItemHisesCntDirty() : !pSSysReqItem.isPSSysReqItemHisesCntDirty()) {
            return null;
        }
        Integer n = pSSysReqItem.getPSSysReqItemHisesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysReqItemHisesCnt_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMHISESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSysReqItemIdDirty() && !bl2 : !pSSysReqItem.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSSysReqItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemName(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSysReqItemNameDirty() && !bl2 : !pSSysReqItem.isPSSysReqItemNameDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSSysReqItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemName_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqModuleId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSysReqModuleIdDirty() : !pSSysReqItem.isPSSysReqModuleIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSSysReqModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqModuleId_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSystemIdDirty() : !pSSysReqItem.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSystemNameDirty() : !pSSysReqItem.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUserCaseId(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isPSSysUserCaseIdDirty() : !pSSysReqItem.isPSSysUserCaseIdDirty()) {
            return null;
        }
        String string = pSSysReqItem.getPSSysUserCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseId_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReqContent(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isReqContentDirty() : !pSSysReqItem.isReqContentDirty()) {
            return null;
        }
        String string = pSSysReqItem.getReqContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReqContent_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReqModel(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isReqModelDirty() : !pSSysReqItem.isReqModelDirty()) {
            return null;
        }
        String string = pSSysReqItem.getReqModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReqModel_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReqModelType(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isReqModelTypeDirty() : !pSSysReqItem.isReqModelTypeDirty()) {
            return null;
        }
        String string = pSSysReqItem.getReqModelType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReqModelType_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQMODELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Subject(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isSubjectDirty() : !pSSysReqItem.isSubjectDirty()) {
            return null;
        }
        String string = pSSysReqItem.getSubject();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Subject_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBJECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncModelMode(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isSyncModelModeDirty() : !pSSysReqItem.isSyncModelModeDirty()) {
            return null;
        }
        String string = pSSysReqItem.getSyncModelMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncModelMode_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCMODELMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isTagsDirty() : !pSSysReqItem.isTagsDirty()) {
            return null;
        }
        String string = pSSysReqItem.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isUserCatDirty() : !pSSysReqItem.isUserCatDirty()) {
            return null;
        }
        String string = pSSysReqItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isUserTagDirty() : !pSSysReqItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysReqItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isUserTag2Dirty() : !pSSysReqItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isUserTag3Dirty() : !pSSysReqItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isUserTag4Dirty() : !pSSysReqItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysReqItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isValidFlagDirty() && !bl2 : !pSSysReqItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysReqItem.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysReqItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Ver(boolean bl, PSSysReqItem pSSysReqItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqItem.isVerDirty() : !pSSysReqItem.isVerDirty()) {
            return null;
        }
        Integer n = pSSysReqItem.getVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Ver_Default((IEntity)pSSysReqItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysReqItem, bl);
    }

    protected void onSyncIndexEntities(PSSysReqItem pSSysReqItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysReqItem, bl);
    }

    public Object getDataContextValue(PSSysReqItem pSSysReqItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysReqItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysReqItem.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysReqItem pSSysReqItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysReqItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AIBUILDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIBuildMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIBUILDPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIBuildParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIBUILDSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIBuildState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AICHOICES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIChoices_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPrompt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices4_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ITEMSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMDATASCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemDatasCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMHISESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemHisesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReqContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReqModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQMODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReqModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBJECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Subject_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCMODELMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncModelMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tags_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Ver_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AIBuildMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AIBuildParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIBUILDPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIBuildState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AIChoices_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AICHOICES", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPrompt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES3", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES4", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ItemSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSSysReqItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSREQITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysReqItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSREQITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSpecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSpecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysReqItemDatasCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysReqItemHisesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysReqModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUserCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReqContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReqModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReqModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQMODELTYPE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Subject_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBJECT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncModelMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCMODELMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_Ver_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysReqItem pSSysReqItem) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQITEMDATA_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) && this.onMergeChild_PSSysReqItemDatas(pSSysReqItem)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSSysReqItem)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSSysReqItemDatas(PSSysReqItem pSSysReqItem) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSREQITEMDATASCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysReqItem.getPSSysReqItemId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemDataService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSREQITEMID", (Object)pSSysReqItem.getPSSysReqItemId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysReqItem, false);
        return true;
    }

    protected void onUpdateParent(PSSysReqItem pSSysReqItem) throws Exception {
        super.onUpdateParent((IEntity)pSSysReqItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysReqItem pSSysReqItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSREQITEM");
        if (!bl) {
            pSSysReqItem.setCreateDate(null);
            pSSysReqItem.setCreateMan(null);
            pSSysReqItem.setPSSysReqItemId(null);
            pSSysReqItem.setUpdateDate(null);
            pSSysReqItem.setUpdateMan(null);
            super.exportCurXmlModel(pSSysReqItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysReqItem pSSysReqItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysReqItem, string);
        objectNode.remove("pssysreqitemdatascnt");
        objectNode.remove("pssysreqitemhisescnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSREQITEM#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSREQMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSREQMODULE#%1$s", (Object)string);
        }
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSREQITEM_PSSYSREQITEM_PPSSYSREQITEMID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSREQMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSREQITEM_PSSYSREQMODULE_PSSYSREQMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSREQITEM_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSREQITEM_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQITEMNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSREQMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSREQMODULENAME", null);
        }
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
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEM", (boolean)true) == 0) {
            iEntity.set("PPSSYSREQITEMID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQMODULE", (boolean)true) == 0) {
            iEntity.set("PSSYSREQMODULEID", (Object)string2);
            return true;
        }
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
        return new String[]{"PPSSYSREQITEMID", "PSSYSREQMODULEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysReqItem pSSysReqItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysReqItem.getCodeName())) {
            return pSSysReqItem.getCodeName();
        }
        return super.getModelV2Tag(pSSysReqItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysReqItem pSSysReqItem, String string) {
        pSSysReqItem.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("ITEMSN", "");
        map.put("PSSYSREQMODULEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        map.put("PPSSYSREQITEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysReqItem pSSysReqItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysReqItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysReqItem, true);
        pSSysReqItem.set("CODENAME", string);
        if (this.select(pSSysReqItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysReqItem, true);
        return super.getModelV2Entity(pSSysReqItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysReqItem pSSysReqItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysReqItem, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSREQITEMHIS_PSSYSREQITEM_PSSYSREQITEMID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSREQITEM_PSSYSREQITEM_PPSSYSREQITEMID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSREQITEMDATA_PSSYSREQITEM_PSSYSREQITEMID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysReqItem pSSysReqItem, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSREQITEMHIS_PSSYSREQITEM_PSSYSREQITEMID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQITEM#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSREQITEMHIS", (Object)pSSysReqItem.getPSSysReqItemId()))).exists()) {
            pSCoreSysServiceBase = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysReqItemHis();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysReqItemHisServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysReqItemHis)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSREQITEMHIS", (Object)entityBase.getPSSysReqItemHisId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSREQITEM_PSSYSREQITEM_PPSSYSREQITEMID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQITEM#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSREQITEM", (Object)pSSysReqItem.getPSSysReqItemId()))).exists()) {
            pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysReqItem();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysReqItemServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysReqItem)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSREQITEM", (Object)entityBase.getPSSysReqItemId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSREQITEMDATA_PSSYSREQITEM_PSSYSREQITEMID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQITEM#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSREQITEMDATA", (Object)pSSysReqItem.getPSSysReqItemId()))).exists()) {
            pSCoreSysServiceBase = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysReqItemData();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysReqItemDataServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysReqItemData)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSREQITEMDATA", (Object)entityBase.getPSSysReqItemDataId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysReqItem, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysReqItem pSSysReqItem, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSSysReqItemHis> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSREQITEMHIS_PSSYSREQITEM_PSSYSREQITEMID")) {
            pSCoreSysServiceBase = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSREQITEMHIS", (Object)pSSysReqItem.getPSSysReqItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysReqItemHis)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysReqItemHis>();
                object4 = ((PSSysReqItemHisServiceBase)pSCoreSysServiceBase).selectByPSSysReqItem(pSSysReqItem);
                object3 = StringHelper.format((String)"PSSYSREQITEM#%1$s", (Object)pSSysReqItem.getPSSysReqItemId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysReqItemHis)object2.next();
                    object = ((PSSysReqItemHisServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysReqItemHis)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssysreqitemhisname")) {
                            string = objectNode.get("pssysreqitemhisname").asText();
                        }
                        if (objectNode2.has("pssysreqitemhisname")) {
                            string2 = objectNode2.get("pssysreqitemhisname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysReqItemHis();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSREQITEM_PSSYSREQITEM_PPSSYSREQITEMID")) {
            pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSREQITEM", (Object)pSSysReqItem.getPSSysReqItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysReqItemHis)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysReqItemServiceBase)pSCoreSysServiceBase).selectByPPSysReqItem(pSSysReqItem);
                object3 = StringHelper.format((String)"PSSYSREQITEM#%1$s", (Object)pSSysReqItem.getPSSysReqItemId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysReqItem)object2.next();
                    object = ((PSSysReqItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysReqItemHis)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssysreqitemname")) {
                            string = objectNode.get("pssysreqitemname").asText();
                        }
                        if (objectNode2.has("pssysreqitemname")) {
                            string2 = objectNode2.get("pssysreqitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysReqItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSREQITEMDATA_PSSYSREQITEM_PSSYSREQITEMID")) {
            pSCoreSysServiceBase = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSREQITEMDATA", (Object)pSSysReqItem.getPSSysReqItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysReqItemHis)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysReqItemDataServiceBase)pSCoreSysServiceBase).selectByPSSysReqItem(pSSysReqItem);
                object3 = StringHelper.format((String)"PSSYSREQITEM#%1$s", (Object)pSSysReqItem.getPSSysReqItemId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysReqItemData)object2.next();
                    object = ((PSSysReqItemDataServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysReqItemHis)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssysreqitemdataname")) {
                            string = objectNode.get("pssysreqitemdataname").asText();
                        }
                        if (objectNode2.has("pssysreqitemdataname")) {
                            string2 = objectNode2.get("pssysreqitemdataname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysReqItemData();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysReqItem, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysReqItem pSSysReqItem) throws Exception {
        super.onEmptyModelV2(pSSysReqItem);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysReqItem pSSysReqItem, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysReqItemHis();
        entityBase.set("PSSYSREQITEMID", pSSysReqItem.getPSSysReqItemId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysReqItem();
        entityBase.set("PPSSYSREQITEMID", pSSysReqItem.getPSSysReqItemId());
        pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysReqItemData();
        entityBase.set("PSSYSREQITEMID", pSSysReqItem.getPSSysReqItemId());
        pSCoreSysServiceBase = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysReqItem, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysReqItem pSSysReqItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysReqItemServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysReqItemHis();
                    ((PSSysReqItemHisBase)object).setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
                    ((PSSysReqItemHisBase)object).setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysReqItemHis();
                        entityBase.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
                        entityBase.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysReqItemServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysReqItem();
                    ((PSSysReqItemBase)object).setPPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
                    ((PSSysReqItemBase)object).setPPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysReqItem();
                        entityBase.setPPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
                        entityBase.setPPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysReqItemServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSSysReqItemData();
                    ((PSSysReqItemDataBase)object).setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
                    ((PSSysReqItemDataBase)object).setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysReqItemData();
                        entityBase.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
                        entityBase.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysReqItem, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysReqItem pSSysReqItem, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSREQITEMHIS_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysReqItemHises(pSSysReqItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSREQITEM_PSSYSREQITEM_PPSSYSREQITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysReqItems(pSSysReqItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSREQITEMDATA_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysReqItemDatas(pSSysReqItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysReqItem, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysReqItemHises(PSSysReqItem pSSysReqItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSREQITEMHIS", true), (boolean)false) == 0) {
            PSSysReqItemHisService pSSysReqItemHisService = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
            PSSysReqItemHis pSSysReqItemHis = new PSSysReqItemHis();
            pSSysReqItemHis.setPSSysReqItemHisId(pSMOSFile.getPSModelId());
            if (!pSSysReqItemHisService.get((IEntity)pSSysReqItemHis, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysReqItemHis.getPSSysReqItemId(), (String)pSSysReqItem.getPSSysReqItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysReqItemHisService.exportModelV2(pSSysReqItemHis);
            pSSysReqItemHis.reset();
            if (!pSSysReqItemHisService.setModelV2ResScope((IEntity)pSSysReqItemHis, "PSSYSREQITEM", pSSysReqItem.getPSSysReqItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysReqItemHisService.importModelV2(pSSysReqItemHis, objectNode);
            SessionFactoryManager.commit();
            return pSSysReqItemHisService.getFile((IEntity)pSSysReqItemHis);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysReqItems(PSSysReqItem pSSysReqItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSREQITEM", true), (boolean)false) == 0) {
            PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem2 = new PSSysReqItem();
            pSSysReqItem2.setPSSysReqItemId(pSMOSFile.getPSModelId());
            if (!pSSysReqItemService.get((IEntity)pSSysReqItem2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysReqItem2.getPPSSysReqItemId(), (String)pSSysReqItem.getPSSysReqItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysReqItemService.exportModelV2(pSSysReqItem2);
            pSSysReqItem2.reset();
            if (!pSSysReqItemService.setModelV2ResScope((IEntity)pSSysReqItem2, "PSSYSREQITEM", pSSysReqItem.getPSSysReqItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysReqItemService.importModelV2(pSSysReqItem2, objectNode);
            SessionFactoryManager.commit();
            return pSSysReqItemService.getFile((IEntity)pSSysReqItem2);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysReqItemDatas(PSSysReqItem pSSysReqItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSREQITEMDATA", true), (boolean)false) == 0) {
            PSSysReqItemDataService pSSysReqItemDataService = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
            PSSysReqItemData pSSysReqItemData = new PSSysReqItemData();
            pSSysReqItemData.setPSSysReqItemDataId(pSMOSFile.getPSModelId());
            if (!pSSysReqItemDataService.get((IEntity)pSSysReqItemData, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysReqItemData.getPSSysReqItemId(), (String)pSSysReqItem.getPSSysReqItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysReqItemDataService.exportModelV2(pSSysReqItemData);
            pSSysReqItemData.reset();
            if (!pSSysReqItemDataService.setModelV2ResScope((IEntity)pSSysReqItemData, "PSSYSREQITEM", pSSysReqItem.getPSSysReqItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysReqItemDataService.importModelV2(pSSysReqItemData, objectNode);
            SessionFactoryManager.commit();
            return pSSysReqItemDataService.getFile((IEntity)pSSysReqItemData);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysReqItem pSSysReqItem, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysReqItemHises(pSSysReqItem, list);
        this.onFillPasteHelps_PSSysReqItems(pSSysReqItem, list);
        this.onFillPasteHelps_PSSysReqItemDatas(pSSysReqItem, list);
        super.onFillPasteHelps(pSSysReqItem, list);
    }

    protected void onFillPasteHelps_PSSysReqItemHises(PSSysReqItem pSSysReqItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSREQITEMHIS");
        pSHelpSection.setSectionParam2("DER1N_PSSYSREQITEMHIS_PSSYSREQITEM_PSSYSREQITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9700\u6c42\u4f5c\u4e1a\u5355]\u7684[\u9700\u6c42\u9879\u5907\u4efd]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysReqItems(PSSysReqItem pSSysReqItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSREQITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSREQITEM_PSSYSREQITEM_PPSSYSREQITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9700\u6c42\u4f5c\u4e1a\u5355]\u7684[\u9700\u6c42\u4f5c\u4e1a\u5355]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysReqItemDatas(PSSysReqItem pSSysReqItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSREQITEMDATA");
        pSHelpSection.setSectionParam2("DER1N_PSSYSREQITEMDATA_PSSYSREQITEM_PSSYSREQITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9700\u6c42\u4f5c\u4e1a\u5355]\u7684[\u9700\u6c42\u9879\u8ba8\u8bba]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysReqItem pSSysReqItem, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ReqItem");
        defaultValueMap.put("PSSYSREQITEMNAME", "\u9700\u6c42\u9879");
    }
}

