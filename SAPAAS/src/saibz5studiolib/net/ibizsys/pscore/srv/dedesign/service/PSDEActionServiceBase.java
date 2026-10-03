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
 *  net.ibizsys.paas.db.SqlParamList
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SqlParamList;
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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEActionDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionTempl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionTemplBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionVRBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProcBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAGDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateRSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDEActionParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDEActionParamBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTaskBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniStateBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCaseBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputService;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXLogicServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionServiceBase
extends PSCoreSysServiceBase<PSDEAction> {
    private static final Log log = LogFactory.getLog(PSDEActionServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSNOTBUILTIN = "CurSysNotBuiltin";
    public static final String DATASET_CURSYSNOTSUBSYS = "CurSysNotSubSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEActionDEModel pSDEActionDEModel;
    private PSDEActionDAO pSDEActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEActionService";
    }

    public PSDEActionDEModel getPSDEActionDEModel() {
        if (this.pSDEActionDEModel == null) {
            try {
                this.pSDEActionDEModel = (PSDEActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEActionDEModel();
    }

    public PSDEActionDAO getPSDEActionDAO() {
        if (this.pSDEActionDAO == null) {
            try {
                this.pSDEActionDAO = (PSDEActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEActionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOTBUILTIN, (boolean)true) == 0) {
            return this.fetchCurSysNotBuiltin(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOTSUBSYS, (boolean)true) == 0) {
            return this.fetchCurSysNotSubSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOTBUILTIN, (boolean)true) == 0) {
            return this.fetchTempCurSysNotBuiltin(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOTSUBSYS, (boolean)true) == 0) {
            return this.fetchTempCurSysNotSubSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, true);
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

    public DBFetchResult fetchCurSysNotBuiltin(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOTBUILTIN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysNotBuiltin(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOTBUILTIN, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysNotSubSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOTSUBSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysNotSubSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOTSUBSYS, true);
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

    protected void onFillParentInfo(PSDEAction pSDEAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDATAENTITY_OUTREFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_OutRefPSDE(pSDEAction, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEAction, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDEACTIONTEMPL_PSDEACTIONTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionTemplService", (SessionFactory)this.getSessionFactory());
            PSDEActionTempl pSDEActionTempl = (PSDEActionTempl)iService.getDEModel().createEntity();
            pSDEActionTempl.set("PSDEACTIONTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEActionTempl);
            } else {
                iService.get(pSDEActionTempl);
            }
            this.onFillParentInfo_PSDEActionTempl(pSDEAction, pSDEActionTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDEDATAQUERY_PSDEDATAQUERYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataQuery);
            } else {
                iService.get(pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDataQuery(pSDEAction, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEAction, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDEFGROUP_INPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_InPSDEFGroup(pSDEAction, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDEFGROUP_OUTPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_OutPSDEFGroup(pSDEAction, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDEFGROUP_OUTREFPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_OutRefPSDEFGroup(pSDEAction, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDELOGIC_PSDEDATAFLOWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDEDataFlow(pSDEAction, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEAction, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDEAction, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDESAMPLEDATA_INPSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDESampleData);
            } else {
                iService.get(pSDESampleData);
            }
            this.onFillParentInfo_InPSDESampleData(pSDEAction, pSDESampleData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDESAMPLEDATA_OUTPSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDESampleData);
            } else {
                iService.get(pSDESampleData);
            }
            this.onFillParentInfo_OutPSDESampleData(pSDEAction, pSDESampleData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSDESYSPROC_PSDESYSPROCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService", (SessionFactory)this.getSessionFactory());
            PSDESysProc pSDESysProc = (PSDESysProc)iService.getDEModel().createEntity();
            pSDESysProc.set("PSDESYSPROCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDESysProc);
            } else {
                iService.get(pSDESysProc);
            }
            this.onFillParentInfo_PSDESysProc(pSDEAction, pSDESysProc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADetail pSSubSysSADetail = (PSSubSysSADetail)iService.getDEModel().createEntity();
            pSSubSysSADetail.set("PSSUBSYSSADETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysSADetail);
            } else {
                iService.get(pSSubSysSADetail);
            }
            this.onFillParentInfo_PSSubSysSADetail(pSDEAction, pSSubSysSADetail);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSDYNAMODEL_INPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_InPSSysDynaModel(pSDEAction, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSDYNAMODEL_OUTPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_OutPSSysDynaModel(pSDEAction, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEAction, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEAction, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEAction, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEAction, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSTASK_PSSYSTASKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService", (SessionFactory)this.getSessionFactory());
            PSSysTask pSSysTask = (PSSysTask)iService.getDEModel().createEntity();
            pSSysTask.set("PSSYSTASKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTask);
            } else {
                iService.get(pSSysTask);
            }
            this.onFillParentInfo_PSSysTask(pSDEAction, pSSysTask);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTION_PSSYSUNISTATE_PSSYSUNISTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService", (SessionFactory)this.getSessionFactory());
            PSSysUniState pSSysUniState = (PSSysUniState)iService.getDEModel().createEntity();
            pSSysUniState.set("PSSYSUNISTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniState);
            } else {
                iService.get(pSSysUniState);
            }
            this.onFillParentInfo_PSSysUniState(pSDEAction, pSSysUniState);
            return;
        }
        super.onFillParentInfo(pSDEAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_OutRefPSDE(PSDEAction pSDEAction, PSDataEntity pSDataEntity) throws Exception {
        pSDEAction.setOutRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEAction.setOutRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEAction pSDEAction, PSDataEntity pSDataEntity) throws Exception {
        pSDEAction.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEAction.setPSDEName(pSDataEntity.getPSDataEntityName());
        pSDEAction.setPSSubSysSADEId(pSDataEntity.getPSSubSysSADEId());
    }

    protected void onFillParentInfo_PSDEActionTempl(PSDEAction pSDEAction, PSDEActionTempl pSDEActionTempl) throws Exception {
        pSDEAction.setPSDEActionTemplId(pSDEActionTempl.getPSDEActionTemplId());
        pSDEAction.setPSDEActionTemplName(pSDEActionTempl.getPSDEActionTemplName());
    }

    protected void onFillParentInfo_PSDEDataQuery(PSDEAction pSDEAction, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEAction.setPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEAction.setPSDEDataQueryName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEAction pSDEAction, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEAction.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEAction.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_InPSDEFGroup(PSDEAction pSDEAction, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEAction.setInPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEAction.setInPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_OutPSDEFGroup(PSDEAction pSDEAction, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEAction.setOutPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEAction.setOutPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_OutRefPSDEFGroup(PSDEAction pSDEAction, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEAction.setOutRefPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEAction.setOutRefPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_PSDEDataFlow(PSDEAction pSDEAction, PSDELogic pSDELogic) throws Exception {
        pSDEAction.setPSDEDataFlowId(pSDELogic.getPSDELogicId());
        pSDEAction.setPSDEDataFlowName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDELogic(PSDEAction pSDEAction, PSDELogic pSDELogic) throws Exception {
        pSDEAction.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEAction.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDEAction pSDEAction, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEAction.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEAction.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_InPSDESampleData(PSDEAction pSDEAction, PSDESampleData pSDESampleData) throws Exception {
        pSDEAction.setInPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSDEAction.setInPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillParentInfo_OutPSDESampleData(PSDEAction pSDEAction, PSDESampleData pSDESampleData) throws Exception {
        pSDEAction.setOutPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSDEAction.setOutPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillParentInfo_PSDESysProc(PSDEAction pSDEAction, PSDESysProc pSDESysProc) throws Exception {
        pSDEAction.setPSDESysProcId(pSDESysProc.getPSDESysProcId());
        pSDEAction.setPSDESysProcName(pSDESysProc.getPSDESysProcName());
    }

    protected void onFillParentInfo_PSSubSysSADetail(PSDEAction pSDEAction, PSSubSysSADetail pSSubSysSADetail) throws Exception {
        pSDEAction.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
        pSDEAction.setPSSubSysSADetailName(pSSubSysSADetail.getPSSubSysSADetailName());
    }

    protected void onFillParentInfo_InPSSysDynaModel(PSDEAction pSDEAction, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEAction.setInPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEAction.setInPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_OutPSSysDynaModel(PSDEAction pSDEAction, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEAction.setOutPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEAction.setOutPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEAction pSDEAction, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEAction.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEAction.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEAction pSDEAction, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEAction.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEAction.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEAction pSDEAction, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEAction.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEAction.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEAction pSDEAction, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEAction.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEAction.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysTask(PSDEAction pSDEAction, PSSysTask pSSysTask) throws Exception {
        pSDEAction.setFinishFlag(pSSysTask.getFinishFlag());
        pSDEAction.setPSSysTaskId(pSSysTask.getPSSysTaskId());
        pSDEAction.setPSSysTaskName(pSSysTask.getPSSysTaskName());
    }

    protected void onFillParentInfo_PSSysUniState(PSDEAction pSDEAction, PSSysUniState pSSysUniState) throws Exception {
        pSDEAction.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
        pSDEAction.setPSSysUniStateName(pSSysUniState.getPSSysUniStateName());
    }

    protected void onFillEntityFullInfo(PSDEAction pSDEAction, boolean bl) throws Exception {
        if (bl) {
            if (pSDEAction.getLogicName() == null) {
                pSDEAction.setLogicName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u884c\u4e3a", 25));
            }
            if (pSDEAction.getPSDEActionLogicsCnt() == null) {
                pSDEAction.setPSDEActionLogicsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEAction.getPSDEMSActionsCnt() == null) {
                pSDEAction.setPSDEMSActionsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEAction.getPSSysTestCasesCnt() == null) {
                pSDEAction.setPSSysTestCasesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEAction, bl);
        this.onFillEntityFullInfo_OutRefPSDE(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDE(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDEActionTempl(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDEDataQuery(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEAction, bl);
        this.onFillEntityFullInfo_InPSDEFGroup(pSDEAction, bl);
        this.onFillEntityFullInfo_OutPSDEFGroup(pSDEAction, bl);
        this.onFillEntityFullInfo_OutRefPSDEFGroup(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDEDataFlow(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDEAction, bl);
        this.onFillEntityFullInfo_InPSDESampleData(pSDEAction, bl);
        this.onFillEntityFullInfo_OutPSDESampleData(pSDEAction, bl);
        this.onFillEntityFullInfo_PSDESysProc(pSDEAction, bl);
        this.onFillEntityFullInfo_PSSubSysSADetail(pSDEAction, bl);
        this.onFillEntityFullInfo_InPSSysDynaModel(pSDEAction, bl);
        this.onFillEntityFullInfo_OutPSSysDynaModel(pSDEAction, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEAction, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEAction, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEAction, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEAction, bl);
        this.onFillEntityFullInfo_PSSysTask(pSDEAction, bl);
        this.onFillEntityFullInfo_PSSysUniState(pSDEAction, bl);
    }

    protected void onFillEntityFullInfo_OutRefPSDE(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEAction pSDEAction, boolean bl) throws Exception {
        if (pSDEAction.isPSDEIdDirty()) {
            if (pSDEAction.getPSDEId() != null) {
                if (pSDEAction.getPSDEId() == null || pSDEAction.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEAction.getPSDE();
                    pSDEAction.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEAction.setPSSubSysSADEId(pSDataEntity.getPSSubSysSADEId());
                }
            } else {
                pSDEAction.setPSDEName(null);
                pSDEAction.setPSSubSysSADEId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEActionTempl(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataQuery(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSDEFGroup(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSDEFGroup(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutRefPSDEFGroup(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataFlow(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEAction pSDEAction, boolean bl) throws Exception {
        if (pSDEAction.isPSDELogicIdDirty()) {
            if (pSDEAction.getPSDELogicId() != null) {
                if (pSDEAction.getPSDELogicId() == null || pSDEAction.getPSDELogicName() == null) {
                    PSDELogic pSDELogic = pSDEAction.getPSDELogic();
                    pSDEAction.setPSDELogicName(pSDELogic.getPSDELogicName());
                }
            } else {
                pSDEAction.setPSDELogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSDESampleData(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSDESampleData(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDESysProc(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysSADetail(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSSysDynaModel(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSSysDynaModel(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTask(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniState(PSDEAction pSDEAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEAction pSDEAction, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEAction, bl);
    }

    public ArrayList<PSDEAction> selectByOutRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByOutRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByOutRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByOutRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByOutRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTREFPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutRefPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutRefPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSDEActionTempl(PSDEActionTemplBase pSDEActionTemplBase) throws Exception {
        return this.selectByPSDEActionTempl(pSDEActionTemplBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDEActionTempl(PSDEActionTemplBase pSDEActionTemplBase, String string) throws Exception {
        return this.selectByPSDEActionTempl(pSDEActionTemplBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDEActionTempl(PSDEActionTemplBase pSDEActionTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONTEMPLID", (Object)pSDEActionTemplBase.getPSDEActionTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDataQuery(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDataQuery(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAQUERYID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataQueryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataQueryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByInPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByInPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByInPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByInPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByInPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByOutPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByOutPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByOutPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByOutPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByOutPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByOutRefPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByOutRefPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByOutRefPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByOutRefPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByOutRefPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTREFPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutRefPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutRefPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSDEDataFlow(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDEDataFlow(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDEDataFlow(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDEDataFlow(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDEDataFlow(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAFLOWID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataFlowCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataFlowCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEAction> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByInPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByInPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByInPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByInPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByInPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByOutPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByOutPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByOutPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByOutPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByOutPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSDESysProc(PSDESysProcBase pSDESysProcBase) throws Exception {
        return this.selectByPSDESysProc(pSDESysProcBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSDESysProc(PSDESysProcBase pSDESysProcBase, String string) throws Exception {
        return this.selectByPSDESysProc(pSDESysProcBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSDESysProc(PSDESysProcBase pSDESysProcBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESYSPROCID", (Object)pSDESysProcBase.getPSDESysProcId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESysProcCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESysProcCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string) throws Exception {
        return this.selectByPSSubSysSADetail(pSSubSysSADetailBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSSubSysSADetail(PSSubSysSADetailBase pSSubSysSADetailBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEAction> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByInPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByInPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByOutPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByOutPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByOutPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByOutPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByOutPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
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

    public ArrayList<PSDEAction> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEAction> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEAction> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEAction> selectByPSSysTask(PSSysTaskBase pSSysTaskBase) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTASKID", (Object)pSSysTaskBase.getPSSysTaskId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTaskCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTaskCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAction> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, "", -1);
    }

    public ArrayList<PSDEAction> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, string, -1);
    }

    public ArrayList<PSDEAction> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string, int n) throws Exception {
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

    public void testRemoveByOutRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDATAENTITY_OUTREFPSDEID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetOutRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutRefPSDE(pSDataEntity);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setOutRefPSDEId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByOutRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByOutRefPSDE(pSDataEntity2);
                PSDEActionServiceBase.this.internalRemoveByOutRefPSDE(pSDataEntity2);
                PSDEActionServiceBase.this.onAfterRemoveByOutRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByOutRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByOutRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutRefPSDE(pSDataEntity);
        this.onBeforeRemoveByOutRefPSDE(pSDataEntity, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByOutRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByOutRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByOutRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDEId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEActionServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEActionTempl(PSDEActionTempl pSDEActionTempl) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEActionTempl(pSDEActionTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTIONTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEActionTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDEACTIONTEMPL_PSDEACTIONTEMPLID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDEActionTempl), arrayList.get(0)));
        }
    }

    public void resetPSDEActionTempl(PSDEActionTempl pSDEActionTempl) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEActionTempl(pSDEActionTempl);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDEActionTemplId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDEActionTempl(PSDEActionTempl pSDEActionTempl) throws Exception {
        final PSDEActionTempl pSDEActionTempl2 = pSDEActionTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDEActionTempl(pSDEActionTempl2);
                PSDEActionServiceBase.this.internalRemoveByPSDEActionTempl(pSDEActionTempl2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDEActionTempl(pSDEActionTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEActionTempl(PSDEActionTempl pSDEActionTempl) throws Exception {
    }

    protected void internalRemoveByPSDEActionTempl(PSDEActionTempl pSDEActionTempl) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEActionTempl(pSDEActionTempl);
        this.onBeforeRemoveByPSDEActionTempl(pSDEActionTempl, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDEActionTempl(pSDEActionTempl, arrayList);
    }

    protected void onAfterRemoveByPSDEActionTempl(PSDEActionTempl pSDEActionTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDEActionTempl(PSDEActionTempl pSDEActionTempl, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEActionTempl(PSDEActionTempl pSDEActionTempl, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDEDATAQUERY_PSDEDATAQUERYID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDEDataQueryId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDEDataQuery(pSDEDataQuery2);
                PSDEActionServiceBase.this.internalRemoveByPSDEDataQuery(pSDEDataQuery2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDEDataQuery(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDataQuery(pSDEDataQuery, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDEDataQuery(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDEDataSetId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEActionServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDEFGROUP_INPSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSDEFGroup(pSDEFGroup);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setInPSDEFGroupId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByInPSDEFGroup(pSDEFGroup2);
                PSDEActionServiceBase.this.internalRemoveByInPSDEFGroup(pSDEFGroup2);
                PSDEActionServiceBase.this.onAfterRemoveByInPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByInPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByInPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDEFGROUP_OUTPSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSDEFGroup(pSDEFGroup);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setOutPSDEFGroupId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByOutPSDEFGroup(pSDEFGroup2);
                PSDEActionServiceBase.this.internalRemoveByOutPSDEFGroup(pSDEFGroup2);
                PSDEActionServiceBase.this.onAfterRemoveByOutPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByOutPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByOutPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByOutRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutRefPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDEFGROUP_OUTREFPSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetOutRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutRefPSDEFGroup(pSDEFGroup);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setOutRefPSDEFGroupId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByOutRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByOutRefPSDEFGroup(pSDEFGroup2);
                PSDEActionServiceBase.this.internalRemoveByOutRefPSDEFGroup(pSDEFGroup2);
                PSDEActionServiceBase.this.onAfterRemoveByOutRefPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByOutRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByOutRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutRefPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByOutRefPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByOutRefPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByOutRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByOutRefPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutRefPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataFlow(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDELOGIC_PSDEDATAFLOWID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataFlow(pSDELogic);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDEDataFlowId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDEDataFlow(pSDELogic2);
                PSDEActionServiceBase.this.internalRemoveByPSDEDataFlow(pSDELogic2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDEDataFlow(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEDataFlow(pSDELogic);
        this.onBeforeRemoveByPSDEDataFlow(pSDELogic, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDEDataFlow(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDEDataFlow(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataFlow(PSDELogic pSDELogic, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataFlow(PSDELogic pSDELogic, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDELogicId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEActionServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDEOPPrivId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEActionServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSDESampleData(pSDESampleData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESAMPLEDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDESampleData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDESAMPLEDATA_INPSDESAMPLEDATAID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDESampleData), arrayList.get(0)));
        }
    }

    public void resetInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSDESampleData(pSDESampleData);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setInPSDESampleDataId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByInPSDESampleData(pSDESampleData2);
                PSDEActionServiceBase.this.internalRemoveByInPSDESampleData(pSDESampleData2);
                PSDEActionServiceBase.this.onAfterRemoveByInPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByInPSDESampleData(pSDESampleData, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByInPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByInPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByInPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSDESampleData(pSDESampleData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESAMPLEDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDESampleData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDESAMPLEDATA_OUTPSDESAMPLEDATAID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDESampleData), arrayList.get(0)));
        }
    }

    public void resetOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSDESampleData(pSDESampleData);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setOutPSDESampleDataId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByOutPSDESampleData(pSDESampleData2);
                PSDEActionServiceBase.this.internalRemoveByOutPSDESampleData(pSDESampleData2);
                PSDEActionServiceBase.this.onAfterRemoveByOutPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByOutPSDESampleData(pSDESampleData, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByOutPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByOutPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByOutPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDESysProc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDESysProc(pSDESysProc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESYSPROC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDESysProc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSDESYSPROC_PSDESYSPROCID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSDESysProc), arrayList.get(0)));
        }
    }

    public void resetPSDESysProc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDESysProc(pSDESysProc);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSDESysProcId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSDESysProc(PSDESysProc pSDESysProc) throws Exception {
        final PSDESysProc pSDESysProc2 = pSDESysProc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSDESysProc(pSDESysProc2);
                PSDEActionServiceBase.this.internalRemoveByPSDESysProc(pSDESysProc2);
                PSDEActionServiceBase.this.onAfterRemoveByPSDESysProc(pSDESysProc2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESysProc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void internalRemoveByPSDESysProc(PSDESysProc pSDESysProc) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSDESysProc(pSDESysProc);
        this.onBeforeRemoveByPSDESysProc(pSDESysProc, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSDESysProc(pSDESysProc, arrayList);
    }

    protected void onAfterRemoveByPSDESysProc(PSDESysProc pSDESysProc) throws Exception {
    }

    protected void onBeforeRemoveByPSDESysProc(PSDESysProc pSDESysProc, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESysProc(PSDESysProc pSDESysProc, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADETAIL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSysSADetail);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSubSysSADetail), arrayList.get(0)));
        }
    }

    public void resetPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSSubSysSADetailId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        final PSSubSysSADetail pSSubSysSADetail2 = pSSubSysSADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSDEActionServiceBase.this.internalRemoveByPSSubSysSADetail(pSSubSysSADetail2);
                PSDEActionServiceBase.this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSubSysSADetail(pSSubSysSADetail);
        this.onBeforeRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSSubSysSADetail(pSSubSysSADetail, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADetail(PSSubSysSADetail pSSubSysSADetail, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSDYNAMODEL_INPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setInPSSysDynaModelId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByInPSSysDynaModel(pSSysDynaModel2);
                PSDEActionServiceBase.this.internalRemoveByInPSSysDynaModel(pSSysDynaModel2);
                PSDEActionServiceBase.this.onAfterRemoveByInPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByInPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByInPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSDYNAMODEL_OUTPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSSysDynaModel(pSSysDynaModel);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setOutPSSysDynaModelId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByOutPSSysDynaModel(pSSysDynaModel2);
                PSDEActionServiceBase.this.internalRemoveByOutPSSysDynaModel(pSSysDynaModel2);
                PSDEActionServiceBase.this.onAfterRemoveByOutPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByOutPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByOutPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByOutPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSSysDynaModelId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEActionServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEActionServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSSysPFPluginId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEActionServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEActionServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSSysReqItemId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEActionServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEActionServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSSysSFPluginId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEActionServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEActionServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysTask(pSSysTask, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTASK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTask);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSTASK_PSSYSTASKID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysTask), arrayList.get(0)));
        }
    }

    public void resetPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysTask(pSSysTask);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSSysTaskId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSSysTask(PSSysTask pSSysTask) throws Exception {
        final PSSysTask pSSysTask2 = pSSysTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSSysTask(pSSysTask2);
                PSDEActionServiceBase.this.internalRemoveByPSSysTask(pSSysTask2);
                PSDEActionServiceBase.this.onAfterRemoveByPSSysTask(pSSysTask2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void internalRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysTask(pSSysTask);
        this.onBeforeRemoveByPSSysTask(pSSysTask, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSSysTask(pSSysTask, arrayList);
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysUniState(pSSysUniState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNISTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEACTION_PSSYSUNISTATE_PSSYSUNISTATEID", "", iDataEntityModel.getName(), "PSDEACTION", iDataEntityModel.getDataInfo(pSSysUniState), arrayList.get(0)));
        }
    }

    public void resetPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysUniState(pSSysUniState);
        for (PSDEAction pSDEAction : arrayList) {
            PSDEAction pSDEAction2 = (PSDEAction)this.getDEModel().createEntity();
            pSDEAction2.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEAction2.setPSSysUniStateId(null);
            this.update(pSDEAction2);
        }
    }

    public void removeByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        final PSSysUniState pSSysUniState2 = pSSysUniState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEActionServiceBase.this.onBeforeRemoveByPSSysUniState(pSSysUniState2);
                PSDEActionServiceBase.this.internalRemoveByPSSysUniState(pSSysUniState2);
                PSDEActionServiceBase.this.onAfterRemoveByPSSysUniState(pSSysUniState2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void internalRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSDEAction> arrayList = this.selectByPSSysUniState(pSSysUniState);
        this.onBeforeRemoveByPSSysUniState(pSSysUniState, arrayList);
        for (PSDEAction pSDEAction : arrayList) {
            this.remove(pSDEAction);
        }
        this.onAfterRemoveByPSSysUniState(pSSysUniState, arrayList);
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSDEAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEAction pSDEAction) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByCopyPSDEAction(pSDEAction);
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).resetCopyPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByGetDraftPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByGetPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByGroupMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).removeByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).removeByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        ((PSDEActionVRServiceBase)pSCoreSysServiceBase).removeByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEAGDetailService)ServiceGlobal.getService(PSDEAGDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEAGDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSyncServiceBase)pSCoreSysServiceBase).testRemoveByImportPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSyncServiceBase)pSCoreSysServiceBase).testRemoveByInPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSyncServiceBase)pSCoreSysServiceBase).testRemoveByOutPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByCopyPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGetDraftPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGetPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByTestPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).testRemoveByTestPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByFinishPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByPushPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDTSQueueServiceBase)pSCoreSysServiceBase).testRemoveByRefreshPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByCopyPSDEAction(pSDEAction);
        ((PSDEFormServiceBase)pSCoreSysServiceBase).resetCopyPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByGetDraftPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByGetPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEAction(pSDEAction);
        ((PSDEFormServiceBase)pSCoreSysServiceBase).resetUser2PSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEAction(pSDEAction);
        ((PSDEFormServiceBase)pSCoreSysServiceBase).resetUserPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByAggPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByCopyPSDEAction(pSDEAction);
        ((PSDEGridServiceBase)pSCoreSysServiceBase).resetCopyPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGetDraftPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGetPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEAction(pSDEAction);
        ((PSDEGridServiceBase)pSCoreSysServiceBase).resetUser2PSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEAction(pSDEAction);
        ((PSDEGridServiceBase)pSCoreSysServiceBase).resetUserPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByCopyPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGetDraftPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGetPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGroupMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).testRemoveByEnterPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByEnterPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapActionServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByGetDataPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEViewServiceService)ServiceGlobal.getService(PSDEViewServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).testRemoveByLoadPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).testRemoveByPrevPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).testRemoveBySavePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).testRemoveByInitPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).testRemoveByNextPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByFinishPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByInitPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysBackServiceService)ServiceGlobal.getService(PSSysBackServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBackServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCounterServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCInputServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByGetPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByFinishPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFDEServiceBase)pSCoreSysServiceBase).testRemoveByInitPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSWXLogicService)ServiceGlobal.getService(PSWXLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEAction(pSDEAction);
        super.onBeforeRemove(pSDEAction);
    }

    protected void onBeforeRemoveTemp(PSDEAction pSDEAction) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionVRServiceBase)pSCoreSysServiceBase).removeTempByPSDEAction(pSDEAction);
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).removeTempByPSDEAction(pSDEAction);
        super.onBeforeRemoveTemp(pSDEAction);
    }

    protected void getRelatedDataTempMajor(PSDEAction pSDEAction) throws Exception {
        this.getRelatedDataTempMajor_PSDEActionParam(pSDEAction);
        this.getRelatedDataTempMajor_PSDEActionVR(pSDEAction);
        super.getRelatedDataTempMajor(pSDEAction);
    }

    protected void getRelatedDataTempMajor_PSDEActionParam(PSDEAction pSDEAction) throws Exception {
        PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionParam> arrayList = null;
        String string = pSDEAction.getPSDEActionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEActionParamService.selectByPSDEAction(pSDEAction) : pSDEActionParamService.selectTempByPSDEAction(pSDEAction);
        for (PSDEActionParam pSDEActionParam : arrayList) {
            pSDEActionParamService.getTempMajor(pSDEActionParam);
        }
    }

    protected void getRelatedDataTempMajor_PSDEActionVR(PSDEAction pSDEAction) throws Exception {
        PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionVR> arrayList = null;
        String string = pSDEAction.getPSDEActionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEActionVRService.selectByPSDEAction(pSDEAction) : pSDEActionVRService.selectTempByPSDEAction(pSDEAction);
        for (PSDEActionVR pSDEActionVR : arrayList) {
            pSDEActionVRService.getTempMajor(pSDEActionVR);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEAction pSDEAction, PSDEAction pSDEAction2) throws Exception {
        ArrayList<PSDEActionVR> arrayList = this.updateRelatedDataTempMajor_removePSDEActionVR(pSDEAction, pSDEAction2);
        ArrayList<PSDEActionParam> arrayList2 = this.updateRelatedDataTempMajor_removePSDEActionParam(pSDEAction, pSDEAction2);
        this.updateRelatedDataTempMajor_updatePSDEActionParam(pSDEAction, pSDEAction2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEActionVR(pSDEAction, pSDEAction2, arrayList);
        super.updateRelatedDataTempMajor(pSDEAction, pSDEAction2);
    }

    protected ArrayList<PSDEActionParam> updateRelatedDataTempMajor_removePSDEActionParam(PSDEAction pSDEAction, PSDEAction pSDEAction2) throws Exception {
        PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionParam> arrayList = pSDEActionParamService.selectTempByPSDEAction(pSDEAction);
        ArrayList<PSDEActionParam> arrayList2 = pSDEActionParamService.selectByPSDEAction(pSDEAction2);
        HashMap<String, PSDEActionParam> hashMap = new HashMap<String, PSDEActionParam>();
        for (PSDEActionParam pSDEActionParam : arrayList2) {
            hashMap.put(pSDEActionParam.getPSDEActionParamId(), pSDEActionParam);
        }
        for (PSDEActionParam pSDEActionParam : arrayList) {
            Object object = pSDEActionParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEActionParam pSDEActionParam : hashMap.values()) {
            pSDEActionParamService.remove(pSDEActionParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEActionParam(PSDEAction pSDEAction, PSDEAction pSDEAction2, ArrayList<PSDEActionParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEActionParam pSDEActionParam : arrayList) {
            pSDEActionParamService.updateTempMajor(pSDEActionParam);
        }
    }

    protected ArrayList<PSDEActionVR> updateRelatedDataTempMajor_removePSDEActionVR(PSDEAction pSDEAction, PSDEAction pSDEAction2) throws Exception {
        PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionVR> arrayList = pSDEActionVRService.selectTempByPSDEAction(pSDEAction);
        ArrayList<PSDEActionVR> arrayList2 = pSDEActionVRService.selectByPSDEAction(pSDEAction2);
        HashMap<String, PSDEActionVR> hashMap = new HashMap<String, PSDEActionVR>();
        for (PSDEActionVR pSDEActionVR : arrayList2) {
            hashMap.put(pSDEActionVR.getPSDEActionVRId(), pSDEActionVR);
        }
        for (PSDEActionVR pSDEActionVR : arrayList) {
            Object object = pSDEActionVR.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEActionVR pSDEActionVR : hashMap.values()) {
            pSDEActionVRService.remove(pSDEActionVR);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEActionVR(PSDEAction pSDEAction, PSDEAction pSDEAction2, ArrayList<PSDEActionVR> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEActionVR pSDEActionVR : arrayList) {
            pSDEActionVRService.updateTempMajor(pSDEActionVR);
        }
    }

    protected void replaceParentInfo(PSDEAction pSDEAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEAction, cloneSession);
        if (pSDEAction.getOutRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEAction.getOutRefPSDEId())) != null) {
            this.onFillParentInfo_OutRefPSDE(pSDEAction, (PSDataEntity)iEntity);
        }
        if (pSDEAction.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEAction.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEAction, (PSDataEntity)iEntity);
        }
        if (pSDEAction.getPSDEActionTemplId() != null && (iEntity = cloneSession.getEntity("PSDEACTIONTEMPL", (Object)pSDEAction.getPSDEActionTemplId())) != null) {
            this.onFillParentInfo_PSDEActionTempl(pSDEAction, (PSDEActionTempl)iEntity);
        }
        if (pSDEAction.getPSDEDataQueryId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEAction.getPSDEDataQueryId())) != null) {
            this.onFillParentInfo_PSDEDataQuery(pSDEAction, (PSDEDataQuery)iEntity);
        }
        if (pSDEAction.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEAction.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEAction, (PSDEDataSet)iEntity);
        }
        if (pSDEAction.getInPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEAction.getInPSDEFGroupId())) != null) {
            this.onFillParentInfo_InPSDEFGroup(pSDEAction, (PSDEFGroup)iEntity);
        }
        if (pSDEAction.getOutPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEAction.getOutPSDEFGroupId())) != null) {
            this.onFillParentInfo_OutPSDEFGroup(pSDEAction, (PSDEFGroup)iEntity);
        }
        if (pSDEAction.getOutRefPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEAction.getOutRefPSDEFGroupId())) != null) {
            this.onFillParentInfo_OutRefPSDEFGroup(pSDEAction, (PSDEFGroup)iEntity);
        }
        if (pSDEAction.getPSDEDataFlowId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEAction.getPSDEDataFlowId())) != null) {
            this.onFillParentInfo_PSDEDataFlow(pSDEAction, (PSDELogic)iEntity);
        }
        if (pSDEAction.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEAction.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEAction, (PSDELogic)iEntity);
        }
        if (pSDEAction.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEAction.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDEAction, (PSDEOPPriv)iEntity);
        }
        if (pSDEAction.getInPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSDEAction.getInPSDESampleDataId())) != null) {
            this.onFillParentInfo_InPSDESampleData(pSDEAction, (PSDESampleData)iEntity);
        }
        if (pSDEAction.getOutPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSDEAction.getOutPSDESampleDataId())) != null) {
            this.onFillParentInfo_OutPSDESampleData(pSDEAction, (PSDESampleData)iEntity);
        }
        if (pSDEAction.getPSDESysProcId() != null && (iEntity = cloneSession.getEntity("PSDESYSPROC", (Object)pSDEAction.getPSDESysProcId())) != null) {
            this.onFillParentInfo_PSDESysProc(pSDEAction, (PSDESysProc)iEntity);
        }
        if (pSDEAction.getPSSubSysSADetailId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADETAIL", (Object)pSDEAction.getPSSubSysSADetailId())) != null) {
            this.onFillParentInfo_PSSubSysSADetail(pSDEAction, (PSSubSysSADetail)iEntity);
        }
        if (pSDEAction.getInPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEAction.getInPSSysDynaModelId())) != null) {
            this.onFillParentInfo_InPSSysDynaModel(pSDEAction, (PSSysDynaModel)iEntity);
        }
        if (pSDEAction.getOutPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEAction.getOutPSSysDynaModelId())) != null) {
            this.onFillParentInfo_OutPSSysDynaModel(pSDEAction, (PSSysDynaModel)iEntity);
        }
        if (pSDEAction.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEAction.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEAction, (PSSysDynaModel)iEntity);
        }
        if (pSDEAction.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEAction.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEAction, (PSSysPFPlugin)iEntity);
        }
        if (pSDEAction.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEAction.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEAction, (PSSysReqItem)iEntity);
        }
        if (pSDEAction.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEAction.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEAction, (PSSysSFPlugin)iEntity);
        }
        if (pSDEAction.getPSSysTaskId() != null && (iEntity = cloneSession.getEntity("PSSYSTASK", (Object)pSDEAction.getPSSysTaskId())) != null) {
            this.onFillParentInfo_PSSysTask(pSDEAction, (PSSysTask)iEntity);
        }
        if (pSDEAction.getPSSysUniStateId() != null && (iEntity = cloneSession.getEntity("PSSYSUNISTATE", (Object)pSDEAction.getPSSysUniStateId())) != null) {
            this.onFillParentInfo_PSSysUniState(pSDEAction, (PSSysUniState)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEAction pSDEAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionHolder(bl, pSDEAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionOption(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionParams(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionTag(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionTag2(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionTag3(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionTag4(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionType(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AfterCode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BatchActionMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeforeCode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheCat(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheScope(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTag(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTimeout(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CallerObj(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CallTimeout(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAudit(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCache(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDEFGroupId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDESampleDataId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSSysDynaModelId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NeedResourceKey(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDEFGroupId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDESampleDataId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSysDynaModelId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutRefPSDEFGroupId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutRefPSDEId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_POTime(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedTypeParam(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrepareLast(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionLogicsCnt(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionName(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionTemplId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataFlowId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataQueryId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicName(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMSActionsCnt(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESysProcId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTaskId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestCasesCnt(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniStateId(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceMethod(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceUrl(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestField(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestMethod(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestParamType(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestPath(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetStdDataType(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetValType(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubSysSADetailMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncEvent(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestActionMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCaseFlag(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSMode(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionHolder(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionHolderDirty() : !pSDEAction.isActionHolderDirty()) {
            return null;
        }
        Integer n = pSDEAction.getActionHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionHolder_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionModeDirty() : !pSDEAction.isActionModeDirty()) {
            return null;
        }
        String string = pSDEAction.getActionMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionOption(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionOptionDirty() : !pSDEAction.isActionOptionDirty()) {
            return null;
        }
        Integer n = pSDEAction.getActionOption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionOption_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONOPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionParams(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionParamsDirty() : !pSDEAction.isActionParamsDirty()) {
            return null;
        }
        String string = pSDEAction.getActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionParams_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_ActionTag(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionTagDirty() : !pSDEAction.isActionTagDirty()) {
            return null;
        }
        String string = pSDEAction.getActionTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionTag_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionTag2(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionTag2Dirty() : !pSDEAction.isActionTag2Dirty()) {
            return null;
        }
        String string = pSDEAction.getActionTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionTag2_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionTag3(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionTag3Dirty() : !pSDEAction.isActionTag3Dirty()) {
            return null;
        }
        String string = pSDEAction.getActionTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionTag3_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionTag4(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionTag4Dirty() : !pSDEAction.isActionTag4Dirty()) {
            return null;
        }
        String string = pSDEAction.getActionTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionTag4_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionType(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isActionTypeDirty() && !bl2 : !pSDEAction.isActionTypeDirty()) {
            return null;
        }
        String string = pSDEAction.getActionType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionType_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AfterCode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isAfterCodeDirty() : !pSDEAction.isAfterCodeDirty()) {
            return null;
        }
        String string = pSDEAction.getAfterCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AfterCode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AFTERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BatchActionMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isBatchActionModeDirty() : !pSDEAction.isBatchActionModeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getBatchActionMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BatchActionMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BATCHACTIONMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeforeCode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isBeforeCodeDirty() : !pSDEAction.isBeforeCodeDirty()) {
            return null;
        }
        String string = pSDEAction.getBeforeCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeforeCode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEFORECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheCat(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCacheCatDirty() : !pSDEAction.isCacheCatDirty()) {
            return null;
        }
        String string = pSDEAction.getCacheCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheCat_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHECAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheScope(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCacheScopeDirty() : !pSDEAction.isCacheScopeDirty()) {
            return null;
        }
        String string = pSDEAction.getCacheScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheScope_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHESCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTag(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCacheTagDirty() : !pSDEAction.isCacheTagDirty()) {
            return null;
        }
        String string = pSDEAction.getCacheTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheTag_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTimeout(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCacheTimeoutDirty() : !pSDEAction.isCacheTimeoutDirty()) {
            return null;
        }
        Integer n = pSDEAction.getCacheTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CacheTimeout_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CallerObj(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCallerObjDirty() : !pSDEAction.isCallerObjDirty()) {
            return null;
        }
        String string = pSDEAction.getCallerObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CallerObj_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CallTimeout(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCallTimeoutDirty() : !pSDEAction.isCallTimeoutDirty()) {
            return null;
        }
        Integer n = pSDEAction.getCallTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CallTimeout_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLTIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCodeNameDirty() : !pSDEAction.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEAction.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEAction, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEActionDEModel(), "CODENAME", string3, pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCustomCodeDirty() : !pSDEAction.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEAction.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isCustomModeDirty() : !pSDEAction.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isDynaModelFlagDirty() : !pSDEAction.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEAction.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableAudit(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isEnableAuditDirty() : !pSDEAction.isEnableAuditDirty()) {
            return null;
        }
        Integer n = pSDEAction.getEnableAudit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAudit_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEAUDIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCache(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isEnableCacheDirty() : !pSDEAction.isEnableCacheDirty()) {
            return null;
        }
        Integer n = pSDEAction.getEnableCache();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCache_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECACHE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isExtendModeDirty() : !pSDEAction.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDEFGroupId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isInPSDEFGroupIdDirty() : !pSDEAction.isInPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEAction.getInPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDEFGroupId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDESampleDataId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isInPSDESampleDataIdDirty() : !pSDEAction.isInPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDEAction.getInPSDESampleDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDESampleDataId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSSysDynaModelId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isInPSSysDynaModelIdDirty() : !pSDEAction.isInPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEAction.getInPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSSysDynaModelId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isLockFlagDirty() : !pSDEAction.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEAction.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isLogicNameDirty() : !pSDEAction.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEAction.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isMemoDirty() : !pSDEAction.isMemoDirty()) {
            return null;
        }
        String string = pSDEAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_NeedResourceKey(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isNeedResourceKeyDirty() : !pSDEAction.isNeedResourceKeyDirty()) {
            return null;
        }
        Integer n = pSDEAction.getNeedResourceKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NeedResourceKey_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEEDRESOURCEKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isOrderValueDirty() : !pSDEAction.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEAction.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutPSDEFGroupId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isOutPSDEFGroupIdDirty() : !pSDEAction.isOutPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEAction.getOutPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDEFGroupId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSDESampleDataId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isOutPSDESampleDataIdDirty() : !pSDEAction.isOutPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDEAction.getOutPSDESampleDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDESampleDataId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSSysDynaModelId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isOutPSSysDynaModelIdDirty() : !pSDEAction.isOutPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEAction.getOutPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSysDynaModelId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutRefPSDEFGroupId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isOutRefPSDEFGroupIdDirty() : !pSDEAction.isOutRefPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEAction.getOutRefPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutRefPSDEFGroupId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTREFPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutRefPSDEId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isOutRefPSDEIdDirty() : !pSDEAction.isOutRefPSDEIdDirty()) {
            return null;
        }
        String string = pSDEAction.getOutRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutRefPSDEId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTREFPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isParamTypeDirty() : !pSDEAction.isParamTypeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ParamType_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_POTime(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPOTimeDirty() : !pSDEAction.isPOTimeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getPOTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_POTime_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPredefinedTypeDirty() : !pSDEAction.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSDEAction.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedTypeParam(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPredefinedTypeParamDirty() : !pSDEAction.isPredefinedTypeParamDirty()) {
            return null;
        }
        String string = pSDEAction.getPredefinedTypeParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedTypeParam_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrepareLast(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPrepareLastDirty() : !pSDEAction.isPrepareLastDirty()) {
            return null;
        }
        Integer n = pSDEAction.getPrepareLast();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PrepareLast_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREPARELAST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEActionIdDirty() && !bl2 : !pSDEAction.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionLogicsCnt(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEActionLogicsCntDirty() : !pSDEAction.isPSDEActionLogicsCntDirty()) {
            return null;
        }
        Integer n = pSDEAction.getPSDEActionLogicsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEActionLogicsCnt_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONLOGICSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionName(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEActionNameDirty() && !bl2 : !pSDEAction.isPSDEActionNameDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionName_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONNAME");
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEActionDEModel(), "PSDEACTIONNAME", string3, pSDEAction, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEACTIONNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionTemplId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEActionTemplIdDirty() : !pSDEAction.isPSDEActionTemplIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEActionTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionTemplId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataFlowId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEDataFlowIdDirty() : !pSDEAction.isPSDEDataFlowIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEDataFlowId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataFlowId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAFLOWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataQueryId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEDataQueryIdDirty() : !pSDEAction.isPSDEDataQueryIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEDataQueryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataQueryId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEDataSetIdDirty() : !pSDEAction.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEIdDirty() && !bl2 : !pSDEAction.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDELogicIdDirty() : !pSDEAction.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicName(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDELogicNameDirty() : !pSDEAction.isPSDELogicNameDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDELogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicName_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMSActionsCnt(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEMSActionsCntDirty() : !pSDEAction.isPSDEMSActionsCntDirty()) {
            return null;
        }
        Integer n = pSDEAction.getPSDEMSActionsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEMSActionsCnt_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMSACTIONSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDENameDirty() && !bl2 : !pSDEAction.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDEOPPrivIdDirty() : !pSDEAction.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESysProcId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDESysProcIdDirty() : !pSDEAction.isPSDESysProcIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDESysProcId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESysProcId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESYSPROCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSDynaInstIdDirty() : !pSDEAction.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysSADetailId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSubSysSADetailIdDirty() : !pSDEAction.isPSSubSysSADetailIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSSubSysSADetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSysDynaModelIdDirty() : !pSDEAction.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSysPFPluginIdDirty() : !pSDEAction.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSysReqItemIdDirty() : !pSDEAction.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSysSFPluginIdDirty() : !pSDEAction.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTaskId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSysTaskIdDirty() : !pSDEAction.isPSSysTaskIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSSysTaskId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTaskId_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestCasesCnt(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSysTestCasesCntDirty() : !pSDEAction.isPSSysTestCasesCntDirty()) {
            return null;
        }
        Integer n = pSDEAction.getPSSysTestCasesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysTestCasesCnt_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTCASESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniStateId(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPSSysUniStateIdDirty() : !pSDEAction.isPSSysUniStateIdDirty()) {
            return null;
        }
        String string = pSDEAction.getPSSysUniStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniStateId_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isPubModeDirty() : !pSDEAction.isPubModeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceMethod(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRawServiceMethodDirty() : !pSDEAction.isRawServiceMethodDirty()) {
            return null;
        }
        String string = pSDEAction.getRawServiceMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceMethod_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceUrl(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRawServiceUrlDirty() : !pSDEAction.isRawServiceUrlDirty()) {
            return null;
        }
        String string = pSDEAction.getRawServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceUrl_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestField(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRequestFieldDirty() : !pSDEAction.isRequestFieldDirty()) {
            return null;
        }
        String string = pSDEAction.getRequestField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestField_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestMethod(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRequestMethodDirty() : !pSDEAction.isRequestMethodDirty()) {
            return null;
        }
        String string = pSDEAction.getRequestMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestMethod_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestParamType(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRequestParamTypeDirty() : !pSDEAction.isRequestParamTypeDirty()) {
            return null;
        }
        String string = pSDEAction.getRequestParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestParamType_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTPARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestPath(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRequestPathDirty() : !pSDEAction.isRequestPathDirty()) {
            return null;
        }
        String string = pSDEAction.getRequestPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestPath_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RetStdDataType(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRetStdDataTypeDirty() : !pSDEAction.isRetStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getRetStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RetStdDataType_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETSTDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RetValType(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isRetValTypeDirty() : !pSDEAction.isRetValTypeDirty()) {
            return null;
        }
        String string = pSDEAction.getRetValType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RetValType_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETVALTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isServiceCodeNameDirty() : !pSDEAction.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDEAction.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubSysSADetailMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isSubSysSADetailModeDirty() : !pSDEAction.isSubSysSADetailModeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getSubSysSADetailMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SubSysSADetailMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBSYSSADETAILMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncEvent(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isSyncEventDirty() : !pSDEAction.isSyncEventDirty()) {
            return null;
        }
        Integer n = pSDEAction.getSyncEvent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncEvent_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCEVENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestActionMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isTestActionModeDirty() : !pSDEAction.isTestActionModeDirty()) {
            return null;
        }
        Integer n = pSDEAction.getTestActionMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TestActionMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTACTIONMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCaseFlag(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isTestCaseFlagDirty() : !pSDEAction.isTestCaseFlagDirty()) {
            return null;
        }
        Integer n = pSDEAction.getTestCaseFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TestCaseFlag_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCASEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isToDoTaskDirty() : !pSDEAction.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEAction.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_TSMode(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isTSModeDirty() : !pSDEAction.isTSModeDirty()) {
            return null;
        }
        String string = pSDEAction.getTSMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TSMode_Default(pSDEAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isUserCatDirty() : !pSDEAction.isUserCatDirty()) {
            return null;
        }
        String string = pSDEAction.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isUserParamsDirty() : !pSDEAction.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEAction.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isUserTagDirty() : !pSDEAction.isUserTagDirty()) {
            return null;
        }
        String string = pSDEAction.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isUserTag2Dirty() : !pSDEAction.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEAction.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isUserTag3Dirty() : !pSDEAction.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEAction.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isUserTag4Dirty() : !pSDEAction.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEAction.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEAction pSDEAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAction.isValidFlagDirty() : !pSDEAction.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEAction.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEAction, bl2, bl3);
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

    protected void onSyncEntity(PSDEAction pSDEAction, boolean bl) throws Exception {
        super.onSyncEntity(pSDEAction, bl);
    }

    protected void onSyncIndexEntities(PSDEAction pSDEAction, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEAction, bl);
    }

    public Object getDataContextValue(PSDEAction pSDEAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFGROUP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"OUTREFPSDEFGROUPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"OUTREFPSDEFGROUPNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEAction, "outrefpsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDEAction, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEAction.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEAction pSDEAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEActionParam_PSDEAction(pSDEAction, arrayList, n);
        this.onExportRelatedModel_PSDEActionVR_PSDEAction(pSDEAction, arrayList, n);
        super.onExportRelatedModel(pSDEAction, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEActionParam_PSDEAction(PSDEAction pSDEAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionParam> arrayList2 = pSDEActionParamService.selectByPSDEAction(pSDEAction);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"3e37d785a125c66e9b7b6fd19cc81dc7");
            jSONObject.put("srfdename", (Object)"PSDEACTIONPARAM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEAction, (String)"PSDEACTIONID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEActionParam pSDEActionParam : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEActionParam, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEActionParamService.exportModel(pSDEActionParam, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEActionVR_PSDEAction(PSDEAction pSDEAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionVR> arrayList2 = pSDEActionVRService.selectByPSDEAction(pSDEAction);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"f30c1445450c707fd85ff4d8cb7baea7");
            jSONObject.put("srfdename", (Object)"PSDEACTIONVR");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEAction, (String)"PSDEACTIONID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEActionVR pSDEActionVR : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEActionVR, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEActionVRService.exportModel(pSDEActionVR, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEAction pSDEAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONOPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionOption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BATCHACTIONMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatchActionMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFORECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHECAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHESCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALLTIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallTimeout_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEAUDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAudit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECACHE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCache_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDynaModelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NEEDRESOURCEKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NeedResourceKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTREFPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutRefPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTREFPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutRefPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTREFPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutRefPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTREFPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutRefPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_POTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREPARELAST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrepareLast_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONLOGICSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionLogicsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAFLOWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataFlowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAFLOWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataFlowName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEMSACTIONSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMSActionsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESYSPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESysProcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTCASESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestCasesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTPARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETSTDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetStdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETVALTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetValType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBSYSSADETAILMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubSysSADetailMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCEVENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncEvent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTACTIONMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestActionMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCASEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCaseFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ActionMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionOption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ActionTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AfterCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BatchActionMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BeforeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFORECODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHECAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHESCOPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CallerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CallTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableAudit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCache_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FinishFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_NeedResourceKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutRefPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTREFPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutRefPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTREFPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutRefPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTREFPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutRefPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTREFPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_POTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPEPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrepareLast_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionLogicsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSDEACTIONNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataFlowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAFLOWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataFlowName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAFLOWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataQueryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataQueryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDEMSActionsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESysProcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESYSPROCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESysProcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESYSPROCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysTaskId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestCasesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RawServiceMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEURL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RequestField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTFIELD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RequestMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RequestParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTPARAMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RequestPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTPATH", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RetStdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RetValType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETVALTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubSysSADetailMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncEvent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestActionMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestCaseFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_TSMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEAction pSDEAction) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) && this.onMergeChild_PSDEActionLogics(pSDEAction)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMSACTION_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) && this.onMergeChild_PSDEMSActions(pSDEAction)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) && this.onMergeChild_PSSysTestCases(pSDEAction)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, pSDEAction)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDEActionLogics(PSDEAction pSDEAction) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEACTIONLOGICSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEAction.getPSDEActionId());
        PSDEActionLogicService iService = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEACTIONID", (Object)pSDEAction.getPSDEActionId());
        ArrayList<PSDEActionLogic> arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEAction, false);
        return true;
    }

    protected boolean onMergeChild_PSDEMSActions(PSDEAction pSDEAction) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEMSACTIONSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEAction.getPSDEActionId());
        PSDEMSActionService iService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEACTIONID", (Object)pSDEAction.getPSDEActionId());
        ArrayList<PSDEMSAction> arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEAction, false);
        return true;
    }

    protected boolean onMergeChild_PSSysTestCases(PSDEAction pSDEAction) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSTESTCASESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDEAction.getPSDEActionId());
        PSSysTestCaseService iService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDEACTIONID", (Object)pSDEAction.getPSDEActionId());
        ArrayList<PSSysTestCase> arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDEAction, false);
        return true;
    }

    protected void onUpdateParent(PSDEAction pSDEAction) throws Exception {
        Object object = pSDEAction.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEACTION_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEAction);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEAction pSDEAction, Object object) throws Exception {
        PSDEAction pSDEAction2 = new PSDEAction();
        pSDEAction2.set("PSDEACTIONID", object);
        String string = DataObject.getStringValue((Object)pSDEAction.get("PSDEACTIONID"));
        super.onCopyDetails(pSDEAction, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEAction pSDEAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEACTION");
        if (!bl) {
            pSDEAction.setCreateDate(null);
            pSDEAction.setCreateMan(null);
            pSDEAction.setPSDEActionId(null);
            pSDEAction.setPSDEActionLogicsCnt(null);
            pSDEAction.setPSDEMSActionsCnt(null);
            pSDEAction.setPSSysTestCasesCnt(null);
            pSDEAction.setUpdateDate(null);
            pSDEAction.setUpdateMan(null);
            super.exportCurXmlModel(pSDEAction, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEAction pSDEAction, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEActionParam(pSDEAction, xmlNode);
        this.exportRelatedXmlModel_PSDEActionVR(pSDEAction, xmlNode);
        super.onExportRelatedXmlModel(pSDEAction, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEActionParam(PSDEAction pSDEAction, XmlNode xmlNode) throws Exception {
        PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionParam> arrayList = null;
        String string = pSDEAction.getPSDEActionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEActionParamService.selectByPSDEAction(pSDEAction, "ORDER BY ORDERVALUE ASC") : pSDEActionParamService.selectTempByPSDEAction(pSDEAction, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEACTIONPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSDEActionParam pSDEActionParam : arrayList) {
                pSDEActionParam.set("ORDERVALUE", null);
                pSDEActionParamService.exportXmlModel(pSDEActionParam, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEActionVR(PSDEAction pSDEAction, XmlNode xmlNode) throws Exception {
        PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionVR> arrayList = null;
        String string = pSDEAction.getPSDEActionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEActionVRService.selectByPSDEAction(pSDEAction, "ORDER BY ORDERVALUE ASC") : pSDEActionVRService.selectTempByPSDEAction(pSDEAction, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEACTIONVRS");
            xmlNode.addNode(xmlNode2);
            for (PSDEActionVR pSDEActionVR : arrayList) {
                pSDEActionVR.set("ORDERVALUE", null);
                pSDEActionVRService.exportXmlModel(pSDEActionVR, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEAction pSDEAction, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEACTIONPARAMS");
        this.importRelatedXmlModel_PSDEActionParam(pSDEAction, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEACTIONVRS");
        this.importRelatedXmlModel_PSDEActionVR(pSDEAction, xmlNode3);
        super.onImportRelatedXmlModel(pSDEAction, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEActionParam(PSDEAction pSDEAction, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEAction.getPSDEActionId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEActionParamService.removeByPSDEAction(pSDEAction);
        } else {
            pSDEActionParamService.removeTempByPSDEAction(pSDEAction);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEActionParam pSDEActionParam = new PSDEActionParam();
                pSDEActionParam.setOrderValue(n);
                n += 100;
                pSDEActionParamService.fillParentInfo(pSDEActionParam, "DER1N", "DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", pSDEAction.getPSDEActionId());
                pSDEActionParamService.importXmlModel(pSDEActionParam, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEActionVR(PSDEAction pSDEAction, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEAction.getPSDEActionId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEActionVRService.removeByPSDEAction(pSDEAction);
        } else {
            pSDEActionVRService.removeTempByPSDEAction(pSDEAction);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEActionVR pSDEActionVR = new PSDEActionVR();
                pSDEActionVR.setOrderValue(n);
                n += 100;
                pSDEActionVRService.fillParentInfo(pSDEActionVR, "DER1N", "DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", pSDEAction.getPSDEActionId());
                pSDEActionVRService.importXmlModel(pSDEActionVR, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEAction pSDEAction, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEAction, string);
        objectNode.remove("psdeactionlogicscnt");
        objectNode.remove("psdemsactionscnt");
        objectNode.remove("pssystestcasescnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEACTION_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEAction pSDEAction) {
        if (!StringHelper.isNullOrEmpty((String)pSDEAction.getPSDEActionName())) {
            return pSDEAction.getPSDEActionName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEAction.getCodeName())) {
            return pSDEAction.getCodeName();
        }
        return super.getModelV2Tag(pSDEAction);
    }

    @Override
    public boolean setModelV2Tag(PSDEAction pSDEAction, String string) {
        pSDEAction.setPSDEActionName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEACTIONNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEACTIONNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEAction pSDEAction, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEAction.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEAction, true);
        pSDEAction.set("PSDEACTIONNAME", string);
        if (this.select(pSDEAction, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEAction, true);
        return super.getModelV2Entity(pSDEAction, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEAction pSDEAction, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEAction, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEAction pSDEAction, String string, String string2) throws Exception {
        String string3;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEACTIONLOGIC", (Object)pSDEAction.getPSDEActionId()))).exists()) {
            pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
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
                PSDEActionLogic entityBase = new PSDEActionLogic();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEActionLogic)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEACTIONLOGIC", (Object)entityBase.getPSDEActionLogicId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)pSDEAction.getPSDEActionId()))).exists()) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
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
                PSSysTestCase entityBase = new PSSysTestCase();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysTestCase)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSTESTCASE", (Object)entityBase.getPSSysTestCaseId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSDEAction, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEAction pSDEAction, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID")) {
            pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEACTIONLOGIC", (Object)pSDEAction.getPSDEActionId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEACTION#%1$s", (Object)pSDEAction.getPSDEActionId());
                for (PSDEActionLogic item : ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).selectByPSDEAction(pSDEAction)) {
                    String itemScope = ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item);
                    if (StringHelper.compare(scope, itemScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeactionlogicname")) {
                            string = objectNode.get("psdeactionlogicname").asText();
                        }
                        if (objectNode2.has("psdeactionlogicname")) {
                            string2 = objectNode2.get("psdeactionlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSDEActionLogic item = new PSDEActionLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(item, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID")) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)pSDEAction.getPSDEActionId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEACTION#%1$s", (Object)pSDEAction.getPSDEActionId());
                for (PSSysTestCase item : ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).selectByPSDEAction(pSDEAction)) {
                    String itemScope = ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item);
                    if (StringHelper.compare(scope, itemScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssystestcasename")) {
                            string = objectNode.get("pssystestcasename").asText();
                        }
                        if (objectNode2.has("pssystestcasename")) {
                            string2 = objectNode2.get("pssystestcasename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysTestCase item = new PSSysTestCase();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(item, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID")) {
            pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEACTIONPARAM", (Object)pSDEAction.getPSDEActionId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEACTION#%1$s", (Object)pSDEAction.getPSDEActionId());
                for (PSDEActionParam item : ((PSDEActionParamServiceBase)pSCoreSysServiceBase).selectByPSDEAction(pSDEAction)) {
                    String itemScope = ((PSDEActionParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item);
                    if (StringHelper.compare(scope, itemScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeactionparamname")) {
                            string = objectNode.get("psdeactionparamname").asText();
                        }
                        if (objectNode2.has("psdeactionparamname")) {
                            string2 = objectNode2.get("psdeactionparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSDEActionParam item = new PSDEActionParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(item, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID")) {
            pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEACTION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEACTIONVR", (Object)pSDEAction.getPSDEActionId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEACTION#%1$s", (Object)pSDEAction.getPSDEActionId());
                for (PSDEActionVR item : ((PSDEActionVRServiceBase)pSCoreSysServiceBase).selectByPSDEAction(pSDEAction)) {
                    String itemScope = ((PSDEActionVRServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item);
                    if (StringHelper.compare(scope, itemScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeactionvrname")) {
                            string = objectNode.get("psdeactionvrname").asText();
                        }
                        if (objectNode2.has("psdeactionvrname")) {
                            string2 = objectNode2.get("psdeactionvrname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSDEActionVR item = new PSDEActionVR();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEAction, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEAction pSDEAction) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionParam> arrayList = ((PSDEActionParamServiceBase)pSCoreSysServiceBase).selectByPSDEAction(pSDEAction);
        String string2 = StringHelper.format((String)"PSDEACTION#%1$s", (Object)pSDEAction.getPSDEActionId());
        for (PSDEActionParam entityBase : arrayList) {
            string = ((PSDEActionParamServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList object = new SqlParamList();
        object.addString(pSDEAction.getPSDEActionId());
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEACTIONPARAM WHERE PSDEACTIONID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEActionVR> actionVRs = ((PSDEActionVRServiceBase)pSCoreSysServiceBase).selectByPSDEAction(pSDEAction);
        string2 = StringHelper.format((String)"PSDEACTION#%1$s", (Object)pSDEAction.getPSDEActionId());
        for (PSDEActionVR pSDEActionVR : actionVRs) {
            string = ((PSDEActionVRServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEActionVR);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEActionVR);
        }
        object = new SqlParamList();
        object.addString(pSDEAction.getPSDEActionId());
        ((PSDEActionVRServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEActionVRServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEACTIONVR WHERE PSDEACTIONID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEAction);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEAction pSDEAction, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEActionLogic();
        entityBase.set("PSDEACTIONID", pSDEAction.getPSDEActionId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysTestCase();
        entityBase.set("PSDEACTIONID", pSDEAction.getPSDEActionId());
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEActionParam();
        entityBase.set("PSDEACTIONID", pSDEAction.getPSDEActionId());
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEActionVR();
        entityBase.set("PSDEACTIONID", pSDEAction.getPSDEActionId());
        pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEAction, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEAction pSDEAction, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSDEActionServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode child = (ObjectNode)arrayNode.get(n2);
                    PSDEActionLogic item = new PSDEActionLogic();
                    item.setPSDEActionId(pSDEAction.getPSDEActionId());
                    item.setPSDEActionName(pSDEAction.getPSDEActionName());
                    pSCoreSysServiceBase.compileModelV2(item, child, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File folder = new File(string4);
                if (folder.exists()) {
                    File[] files = folder.listFiles();
                    for (File child : files) {
                        if (!child.isDirectory()) continue;
                        PSDEActionLogic item = new PSDEActionLogic();
                        item.setPSDEActionId(pSDEAction.getPSDEActionId());
                        item.setPSDEActionName(pSDEAction.getPSDEActionName());
                        pSCoreSysServiceBase.compileModelV2(item, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEActionServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode child = (ObjectNode)arrayNode.get(n2);
                    PSSysTestCase item = new PSSysTestCase();
                    item.setPSDEActionId(pSDEAction.getPSDEActionId());
                    item.setPSDEActionName(pSDEAction.getPSDEActionName());
                    pSCoreSysServiceBase.compileModelV2(item, child, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File folder = new File(string5);
                if (folder.exists()) {
                    File[] files = folder.listFiles();
                    for (File child : files) {
                        if (!child.isDirectory()) continue;
                        PSSysTestCase item = new PSSysTestCase();
                        item.setPSDEActionId(pSDEAction.getPSDEActionId());
                        item.setPSDEActionName(pSDEAction.getPSDEActionName());
                        pSCoreSysServiceBase.compileModelV2(item, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode child = (ObjectNode)arrayNode.get(i);
                PSDEActionParam item = new PSDEActionParam();
                item.setPSDEActionId(pSDEAction.getPSDEActionId());
                item.setPSDEActionName(pSDEAction.getPSDEActionName());
                item.setPSDEId(pSDEAction.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(item, child, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File folder = new File(string6);
            if (folder.exists()) {
                File[] files = folder.listFiles();
                for (File child : files) {
                    if (!child.isDirectory()) continue;
                    PSDEActionParam item = new PSDEActionParam();
                    item.setPSDEActionId(pSDEAction.getPSDEActionId());
                    item.setPSDEActionName(pSDEAction.getPSDEActionName());
                    item.setPSDEId(pSDEAction.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(item, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode child = (ObjectNode)arrayNode.get(i);
                PSDEActionVR item = new PSDEActionVR();
                item.setPSDEActionId(pSDEAction.getPSDEActionId());
                item.setPSDEActionName(pSDEAction.getPSDEActionName());
                item.setPSDEId(pSDEAction.getPSDEId());
                pSCoreSysServiceBase.compileModelV2(item, child, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File folder = new File(string7);
            if (folder.exists()) {
                File[] files = folder.listFiles();
                for (File child : files) {
                    if (!child.isDirectory()) continue;
                    PSDEActionVR item = new PSDEActionVR();
                    item.setPSDEActionId(pSDEAction.getPSDEActionId());
                    item.setPSDEActionName(pSDEAction.getPSDEActionName());
                    item.setPSDEId(pSDEAction.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(item, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEAction, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEAction pSDEAction, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEActionLogics(pSDEAction, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysTestCases(pSDEAction, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEActionParams(pSDEAction, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEActionVRs(pSDEAction, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEAction, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEActionLogics(PSDEAction pSDEAction, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACTIONLOGIC", true), (boolean)false) == 0) {
            PSDEActionLogicService pSDEActionLogicService = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEActionLogic pSDEActionLogic = new PSDEActionLogic();
            pSDEActionLogic.setPSDEActionLogicId(pSMOSFile.getPSModelId());
            if (!pSDEActionLogicService.get(pSDEActionLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEActionLogic.getPSDEActionId(), (String)pSDEAction.getPSDEActionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEActionLogicService.exportModelV2(pSDEActionLogic);
            pSDEActionLogic.reset();
            if (!pSDEActionLogicService.setModelV2ResScope(pSDEActionLogic, "PSDEACTION", pSDEAction.getPSDEActionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEActionLogicService.importModelV2(pSDEActionLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEActionLogicService.getFile(pSDEActionLogic);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDELOGIC", true), (boolean)false) == 0) {
            PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = new PSDELogic();
            pSDELogic.setPSDELogicId(pSMOSFile.getPSModelId());
            if (!pSDELogicService.get(pSDELogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEActionLogicService pSDEActionLogicService = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEActionLogic pSDEActionLogic = new PSDEActionLogic();
            pSDEActionLogic.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEActionLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
            this.fillPasteEntity(pSDEActionLogic, "PASTETAG");
            pSDEActionLogicService.create(pSDEActionLogic);
            SessionFactoryManager.commit();
            return pSDEActionLogicService.getFile(pSDEActionLogic);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysTestCases(PSDEAction pSDEAction, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSTESTCASE", true), (boolean)false) == 0) {
            PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            PSSysTestCase pSSysTestCase = new PSSysTestCase();
            pSSysTestCase.setPSSysTestCaseId(pSMOSFile.getPSModelId());
            if (!pSSysTestCaseService.get(pSSysTestCase, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysTestCase.getPSDEActionId(), (String)pSDEAction.getPSDEActionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysTestCaseService.exportModelV2(pSSysTestCase);
            pSSysTestCase.reset();
            if (!pSSysTestCaseService.setModelV2ResScope(pSSysTestCase, "PSDEACTION", pSDEAction.getPSDEActionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysTestCaseService.importModelV2(pSSysTestCase, objectNode);
            SessionFactoryManager.commit();
            return pSSysTestCaseService.getFile(pSSysTestCase);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEActionParams(PSDEAction pSDEAction, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACTIONPARAM", true), (boolean)false) == 0) {
            PSDEActionParamService pSDEActionParamService = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
            PSDEActionParam pSDEActionParam = new PSDEActionParam();
            pSDEActionParam.setPSDEActionParamId(pSMOSFile.getPSModelId());
            if (!pSDEActionParamService.get(pSDEActionParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEActionParam.getPSDEActionId(), (String)pSDEAction.getPSDEActionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEActionParamService.exportModelV2(pSDEActionParam);
            pSDEActionParam.reset();
            if (!pSDEActionParamService.setModelV2ResScope(pSDEActionParam, "PSDEACTION", pSDEAction.getPSDEActionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEActionParamService.importModelV2(pSDEActionParam, objectNode);
            SessionFactoryManager.commit();
            return pSDEActionParamService.getFile(pSDEActionParam);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEActionVRs(PSDEAction pSDEAction, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACTIONVR", true), (boolean)false) == 0) {
            PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
            PSDEActionVR pSDEActionVR = new PSDEActionVR();
            pSDEActionVR.setPSDEActionVRId(pSMOSFile.getPSModelId());
            if (!pSDEActionVRService.get(pSDEActionVR, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEActionVR.getPSDEActionId(), (String)pSDEAction.getPSDEActionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEActionVRService.exportModelV2(pSDEActionVR);
            pSDEActionVR.reset();
            if (!pSDEActionVRService.setModelV2ResScope(pSDEActionVR, "PSDEACTION", pSDEAction.getPSDEActionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEActionVRService.importModelV2(pSDEActionVR, objectNode);
            SessionFactoryManager.commit();
            return pSDEActionVRService.getFile(pSDEActionVR);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFVALUERULE", true), (boolean)false) == 0) {
            PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
            pSDEFValueRule.setPSDEFValueRuleId(pSMOSFile.getPSModelId());
            if (!pSDEFValueRuleService.get(pSDEFValueRule, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEActionVRService pSDEActionVRService = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
            PSDEActionVR pSDEActionVR = new PSDEActionVR();
            pSDEActionVR.setPSDEActionId(pSDEAction.getPSDEActionId());
            pSDEActionVR.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
            this.fillPasteEntity(pSDEActionVR, "PASTETAG");
            pSDEActionVRService.create(pSDEActionVR);
            if (StringHelper.compare((String)pSDEFValueRule.getPSDEId(), (String)pSDEActionVR.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[PSDEID]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEActionVRService.getFile(pSDEActionVR);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEAction pSDEAction, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEActionLogics(pSDEAction, list);
        this.onFillPasteHelps_PSSysTestCases(pSDEAction, list);
        this.onFillPasteHelps_PSDEActionParams(pSDEAction, list);
        this.onFillPasteHelps_PSDEActionVRs(pSDEAction, list);
        super.onFillPasteHelps(pSDEAction, list);
    }

    protected void onFillPasteHelps_PSDEActionLogics(PSDEAction pSDEAction, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEACTIONLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u884c\u4e3a]\u7684[\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u903b\u8f91]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEACTIONLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setUserTag("DER1N_PSDEACTIONLOGIC_PSDELOGIC_PSDELOGICID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u5904\u7406\u903b\u8f91]\u6784\u5efa[\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysTestCases(PSDEAction pSDEAction, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSTESTCASE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u884c\u4e3a]\u7684[\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEActionParams(PSDEAction pSDEAction, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEACTIONPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u884c\u4e3a]\u7684[\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEActionVRs(PSDEAction pSDEAction, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEACTIONVR");
        pSHelpSection.setSectionParam2("DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u884c\u4e3a]\u7684[\u5b9e\u4f53\u884c\u4e3a\u503c\u89c4\u5219]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEACTIONVR");
        pSHelpSection.setSectionParam2("DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setUserTag("DER1N_PSDEACTIONVR_PSDEFVALUERULE_PSDEFVRID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219]\u6784\u5efa[\u5b9e\u4f53\u884c\u4e3a\u503c\u89c4\u5219]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u884c\u4e3a\u53c2\u6570>", "DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u884c\u4e3a\u53c2\u6570>");
            } else if (PSDEActionServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdeactionparams");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID|PSDEACTIONID");
            pSMOSFile2.setFileTag3("PSDEACTIONPARAM");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEActionServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u9644\u52a0\u903b\u8f91>", "DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u9644\u52a0\u903b\u8f91>");
            } else if (PSDEActionServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdeactionlogics");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID|PSDEACTIONID");
            pSMOSFile2.setFileTag3("PSDEACTIONLOGIC");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEActionServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u53c2\u6570\u503c\u89c4\u5219>", "DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u53c2\u6570\u503c\u89c4\u5219>");
            } else if (PSDEActionServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdeactionvrs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID|PSDEACTIONID");
            pSMOSFile2.setFileTag3("PSDEACTIONVR");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEActionServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSDEActionServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u6d4b\u8bd5\u7528\u4f8b>", "DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6d4b\u8bd5\u7528\u4f8b>");
            } else if (PSDEActionServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystestcases");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID|PSDEACTIONID");
            pSMOSFile2.setFileTag3("PSSYSTESTCASE");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEActionServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSDEActionServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u884c\u4e3a\u53c2\u6570>", (boolean)false) == 0 || PSDEActionServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEActionParams", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSDEActionParam> arrayList = ((PSDEActionParamServiceBase)pSCoreSysServiceBase).selectEx((ISelectContext)selectContext);
            for (PSDEActionParam item : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, item, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEActionServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u9644\u52a0\u903b\u8f91>", (boolean)false) == 0 || PSDEActionServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEActionLogics", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSDEActionLogic> arrayList = ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).selectEx((ISelectContext)selectContext);
            for (PSDEActionLogic item : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, item, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEActionServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u53c2\u6570\u503c\u89c4\u5219>", (boolean)false) == 0 || PSDEActionServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEActionVRs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEActionVRService)ServiceGlobal.getService(PSDEActionVRService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSDEActionVR> arrayList = ((PSDEActionVRServiceBase)pSCoreSysServiceBase).selectEx((ISelectContext)selectContext);
            for (PSDEActionVR item : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, item, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEActionServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u6d4b\u8bd5\u7528\u4f8b>", (boolean)false) == 0 || PSDEActionServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysTestCases", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", "PSDEACTIONID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSSysTestCase> arrayList = ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).selectEx((ISelectContext)selectContext);
            for (PSSysTestCase item : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, item, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEACTIONPARAM_PSDEACTION_PSDEACTIONID", (boolean)false) == 0) {
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                return "<\u884c\u4e3a\u53c2\u6570>";
            }
            if (PSDEActionServiceBase.getMOSVer() == 2) {
                return "psdeactionparams";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEACTIONLOGIC_PSDEACTION_PSDEACTIONID", (boolean)false) == 0) {
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                return "<\u9644\u52a0\u903b\u8f91>";
            }
            if (PSDEActionServiceBase.getMOSVer() == 2) {
                return "psdeactionlogics";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEACTIONVR_PSDEACTION_PSDEACTIONID", (boolean)false) == 0) {
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                return "<\u53c2\u6570\u503c\u89c4\u5219>";
            }
            if (PSDEActionServiceBase.getMOSVer() == 2) {
                return "psdeactionvrs";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", (boolean)false) == 0) {
            if (PSDEActionServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u6d4b\u8bd5\u7528\u4f8b>";
            }
            if (PSDEActionServiceBase.getMOSVer() == 2) {
                return "pssystestcases";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEAction pSDEAction, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("LOGICNAME", "\u884c\u4e3a");
    }
}
