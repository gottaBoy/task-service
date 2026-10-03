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
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEUAGroupDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUAGroupServiceBase
extends PSCoreSysServiceBase<PSDEUAGroup> {
    private static final Log log = LogFactory.getLog(PSDEUAGroupServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSANDDE = "CurSysAndDE";
    public static final String DATASET_CURSYSDE = "CurSysDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEUAGroupDEModel pSDEUAGroupDEModel;
    private PSDEUAGroupDAO pSDEUAGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService";
    }

    public PSDEUAGroupDEModel getPSDEUAGroupDEModel() {
        if (this.pSDEUAGroupDEModel == null) {
            try {
                this.pSDEUAGroupDEModel = (PSDEUAGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEUAGroupDEModel();
    }

    public PSDEUAGroupDAO getPSDEUAGroupDAO() {
        if (this.pSDEUAGroupDAO == null) {
            try {
                this.pSDEUAGroupDAO = (PSDEUAGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEUAGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEUAGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSANDDE, (boolean)true) == 0) {
            return this.fetchCurSysAndDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDE, (boolean)true) == 0) {
            return this.fetchCurSysDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSANDDE, (boolean)true) == 0) {
            return this.fetchTempCurSysAndDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDE, (boolean)true) == 0) {
            return this.fetchTempCurSysDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, true);
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

    public DBFetchResult fetchCurSysAndDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSANDDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysAndDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSANDDE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDE, true);
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

    protected void onFillParentInfo(PSDEUAGroup pSDEUAGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEUAGroup, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGROUP_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSDEUAGroup, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGROUP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEUAGroup, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGROUP_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFProcess);
            } else {
                iService.get(pSWFProcess);
            }
            this.onFillParentInfo_PSWFProcess(pSDEUAGroup, pSWFProcess);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSDEUAGroup, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGROUP_PSWORKFLOW_PSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkflow);
            } else {
                iService.get(pSWorkflow);
            }
            this.onFillParentInfo_PSWF(pSDEUAGroup, pSWorkflow);
            return;
        }
        super.onFillParentInfo(pSDEUAGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEUAGroup pSDEUAGroup, PSDataEntity pSDataEntity) throws Exception {
        pSDEUAGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEUAGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSModule(PSDEUAGroup pSDEUAGroup, PSModule pSModule) throws Exception {
        pSDEUAGroup.setPSModuleId(pSModule.getPSModuleId());
        pSDEUAGroup.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSDEUAGroup pSDEUAGroup, PSSystem pSSystem) throws Exception {
        pSDEUAGroup.setPSSystemId(pSSystem.getPSSystemId());
        pSDEUAGroup.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSWFProcess(PSDEUAGroup pSDEUAGroup, PSWFProcess pSWFProcess) throws Exception {
        pSDEUAGroup.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
    }

    protected void onFillParentInfo_PSWFVersion(PSDEUAGroup pSDEUAGroup, PSWFVersion pSWFVersion) throws Exception {
        pSDEUAGroup.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSDEUAGroup.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillParentInfo_PSWF(PSDEUAGroup pSDEUAGroup, PSWorkflow pSWorkflow) throws Exception {
        pSDEUAGroup.setPSWFId(pSWorkflow.getPSWorkflowId());
        pSDEUAGroup.setPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
        if (bl && pSDEUAGroup.getPSDEUAGroupName() == null) {
            pSDEUAGroup.setPSDEUAGroupName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u754c\u9762\u884c\u4e3a\u7ec4", 25));
        }
        super.onFillEntityFullInfo(pSDEUAGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSDEUAGroup, bl);
        this.onFillEntityFullInfo_PSModule(pSDEUAGroup, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEUAGroup, bl);
        this.onFillEntityFullInfo_PSWFProcess(pSDEUAGroup, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSDEUAGroup, bl);
        this.onFillEntityFullInfo_PSWF(pSDEUAGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
        if (pSDEUAGroup.isPSDEIdDirty()) {
            if (pSDEUAGroup.getPSDEId() != null) {
                if (pSDEUAGroup.getPSDEId() == null || pSDEUAGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEUAGroup.getPSDE();
                    pSDEUAGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUAGroup.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
        if (pSDEUAGroup.isPSSystemIdDirty()) {
            if (pSDEUAGroup.getPSSystemId() != null) {
                if (pSDEUAGroup.getPSSystemId() == null || pSDEUAGroup.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDEUAGroup.getPSSystem();
                    pSDEUAGroup.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDEUAGroup.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWFProcess(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWF(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEUAGroup, bl);
    }

    public ArrayList<PSDEUAGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUAGroup> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUAGroup> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUAGroup> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, "", -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, string, -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCESSID", (Object)pSWFProcessBase.getPSWFProcessId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFProcessCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFProcessCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroup> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroup> selectByPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSDEUAGroup> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            PSDEUAGroup pSDEUAGroup2 = (PSDEUAGroup)this.getDEModel().createEntity();
            pSDEUAGroup2.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
            pSDEUAGroup2.setPSDEId(null);
            this.update(pSDEUAGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEUAGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEUAGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            this.remove(pSDEUAGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGROUP_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSDEUAGROUP", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSModule(pSModule);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            PSDEUAGroup pSDEUAGroup2 = (PSDEUAGroup)this.getDEModel().createEntity();
            pSDEUAGroup2.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
            pSDEUAGroup2.setPSModuleId(null);
            this.update(pSDEUAGroup2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSDEUAGroupServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSDEUAGroupServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            this.remove(pSDEUAGroup);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            PSDEUAGroup pSDEUAGroup2 = (PSDEUAGroup)this.getDEModel().createEntity();
            pSDEUAGroup2.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
            pSDEUAGroup2.setPSSystemId(null);
            this.update(pSDEUAGroup2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEUAGroupServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEUAGroupServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            this.remove(pSDEUAGroup);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    public void resetPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSWFProcess(pSWFProcess);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            PSDEUAGroup pSDEUAGroup2 = (PSDEUAGroup)this.getDEModel().createEntity();
            pSDEUAGroup2.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
            pSDEUAGroup2.setPSWFProcessId(null);
            this.update(pSDEUAGroup2);
        }
    }

    public void removeByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupServiceBase.this.onBeforeRemoveByPSWFProcess(pSWFProcess2);
                PSDEUAGroupServiceBase.this.internalRemoveByPSWFProcess(pSWFProcess2);
                PSDEUAGroupServiceBase.this.onAfterRemoveByPSWFProcess(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSWFProcess(pSWFProcess);
        this.onBeforeRemoveByPSWFProcess(pSWFProcess, arrayList);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            this.remove(pSDEUAGroup);
        }
        this.onAfterRemoveByPSWFProcess(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            PSDEUAGroup pSDEUAGroup2 = (PSDEUAGroup)this.getDEModel().createEntity();
            pSDEUAGroup2.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
            pSDEUAGroup2.setPSWFVersionId(null);
            this.update(pSDEUAGroup2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSDEUAGroupServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSDEUAGroupServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            this.remove(pSDEUAGroup);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    public void resetPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSWF(pSWorkflow);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            PSDEUAGroup pSDEUAGroup2 = (PSDEUAGroup)this.getDEModel().createEntity();
            pSDEUAGroup2.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
            pSDEUAGroup2.setPSWFId(null);
            this.update(pSDEUAGroup2);
        }
    }

    public void removeByPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupServiceBase.this.onBeforeRemoveByPSWF(pSWorkflow2);
                PSDEUAGroupServiceBase.this.internalRemoveByPSWF(pSWorkflow2);
                PSDEUAGroupServiceBase.this.onAfterRemoveByPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSDEUAGroup> arrayList = this.selectByPSWF(pSWorkflow);
        this.onBeforeRemoveByPSWF(pSWorkflow, arrayList);
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            this.remove(pSDEUAGroup);
        }
        this.onAfterRemoveByPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSDEUAGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEUAGroup pSDEUAGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByNo3PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByNo4PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByNo5PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByNo6PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).removeByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByNo3PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByNo4PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByNo5PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByNo6PSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeServiceBase)pSCoreSysServiceBase).testRemoveByPortletPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByMobPSDEUAGroup(pSDEUAGroup);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAGroup(pSDEUAGroup);
        super.onBeforeRemove(pSDEUAGroup);
    }

    protected void onBeforeRemoveTemp(PSDEUAGroup pSDEUAGroup) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEUAGroupDetailService.removeTempByPSDEUAGroup(pSDEUAGroup);
        super.onBeforeRemoveTemp(pSDEUAGroup);
    }

    protected void getRelatedDataTempMajor(PSDEUAGroup pSDEUAGroup) throws Exception {
        this.getRelatedDataTempMajor_PSDEUAGroupDetail(pSDEUAGroup);
        super.getRelatedDataTempMajor(pSDEUAGroup);
    }

    protected void getRelatedDataTempMajor_PSDEUAGroupDetail(PSDEUAGroup pSDEUAGroup) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEUAGroupDetail> arrayList = null;
        String string = pSDEUAGroup.getPSDEUAGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEUAGroupDetailService.selectByPSDEUAGroup(pSDEUAGroup) : pSDEUAGroupDetailService.selectTempByPSDEUAGroup(pSDEUAGroup);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            pSDEUAGroupDetailService.getTempMajor(pSDEUAGroupDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEUAGroup pSDEUAGroup, PSDEUAGroup pSDEUAGroup2) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEUAGroupDetail(pSDEUAGroup, pSDEUAGroup2);
        this.updateRelatedDataTempMajor_updatePSDEUAGroupDetail(pSDEUAGroup, pSDEUAGroup2, arrayList);
        super.updateRelatedDataTempMajor(pSDEUAGroup, pSDEUAGroup2);
    }

    protected ArrayList<PSDEUAGroupDetail> updateRelatedDataTempMajor_removePSDEUAGroupDetail(PSDEUAGroup pSDEUAGroup, PSDEUAGroup pSDEUAGroup2) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEUAGroupDetail> arrayList = pSDEUAGroupDetailService.selectTempByPSDEUAGroup(pSDEUAGroup);
        ArrayList<PSDEUAGroupDetail> arrayList2 = pSDEUAGroupDetailService.selectByPSDEUAGroup(pSDEUAGroup2);
        HashMap<String, PSDEUAGroupDetail> hashMap = new HashMap<String, PSDEUAGroupDetail>();
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList2) {
            hashMap.put(pSDEUAGroupDetail.getPSDEUAGRPDetailId(), pSDEUAGroupDetail);
        }
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            Object object = pSDEUAGroupDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEUAGroupDetail pSDEUAGroupDetail : hashMap.values()) {
            pSDEUAGroupDetailService.remove(pSDEUAGroupDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEUAGroupDetail(PSDEUAGroup pSDEUAGroup, PSDEUAGroup pSDEUAGroup2, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            pSDEUAGroupDetailService.updateTempMajor(pSDEUAGroupDetail);
        }
    }

    protected void replaceParentInfo(PSDEUAGroup pSDEUAGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEUAGroup, cloneSession);
        if (pSDEUAGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUAGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEUAGroup, (PSDataEntity)iEntity);
        }
        if (pSDEUAGroup.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSDEUAGroup.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSDEUAGroup, (PSModule)iEntity);
        }
        if (pSDEUAGroup.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEUAGroup.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEUAGroup, (PSSystem)iEntity);
        }
        if (pSDEUAGroup.getPSWFProcessId() != null && (iEntity = cloneSession.getEntity("PSWFPROCESS", (Object)pSDEUAGroup.getPSWFProcessId())) != null) {
            this.onFillParentInfo_PSWFProcess(pSDEUAGroup, (PSWFProcess)iEntity);
        }
        if (pSDEUAGroup.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSDEUAGroup.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSDEUAGroup, (PSWFVersion)iEntity);
        }
        if (pSDEUAGroup.getPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSDEUAGroup.getPSWFId())) != null) {
            this.onFillParentInfo_PSWF(pSDEUAGroup, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEUAGroup, bl);
        pSDEUAGroup.resetCodeName();
        pSDEUAGroup.resetUAGTag();
        pSDEUAGroup.resetUAGTag2();
        pSDEUAGroup.resetUAGTag3();
        pSDEUAGroup.resetUAGTag4();
    }

    protected void onCheckEntity(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEUAGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupName(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessName(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UAGroupParam(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UAGTag(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UAGTag2(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UAGTag3(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UAGTag4(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRefFlag(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEUAGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEUAGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isCodeNameDirty() : !pSDEUAGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEUAGroup, bl2, bl3);
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
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSDEUAGroupDEModel(), "CODENAME", string3, pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isDynaModelFlagDirty() : !pSDEUAGroup.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEUAGroup.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isLockFlagDirty() : !pSDEUAGroup.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEUAGroup.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isMemoDirty() : !pSDEUAGroup.isMemoDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSDEIdDirty() : !pSDEUAGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSDENameDirty() : !pSDEUAGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSDEUAGroupIdDirty() && !bl2 : !pSDEUAGroup.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSDEUAGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUAGroupName(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSDEUAGroupNameDirty() && !bl2 : !pSDEUAGroup.isPSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSDEUAGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupName_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSDynaInstIdDirty() : !pSDEUAGroup.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSModuleIdDirty() : !pSDEUAGroup.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSSystemIdDirty() && !bl2 : !pSDEUAGroup.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSSystemNameDirty() && !bl2 : !pSDEUAGroup.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSWFIdDirty() : !pSDEUAGroup.isPSWFIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSWFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFId_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSWFProcessIdDirty() : !pSDEUAGroup.isPSWFProcessIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSWFProcessId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessId_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessName(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSWFProcessNameDirty() : !pSDEUAGroup.isPSWFProcessNameDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSWFProcessName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessName_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isPSWFVersionIdDirty() : !pSDEUAGroup.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UAGroupParam(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUAGroupParamDirty() : !pSDEUAGroup.isUAGroupParamDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUAGroupParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UAGroupParam_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UAGROUPPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UAGTag(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUAGTagDirty() : !pSDEUAGroup.isUAGTagDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUAGTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UAGTag_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UAGTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UAGTag2(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUAGTag2Dirty() : !pSDEUAGroup.isUAGTag2Dirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUAGTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UAGTag2_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UAGTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UAGTag3(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUAGTag3Dirty() : !pSDEUAGroup.isUAGTag3Dirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUAGTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UAGTag3_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UAGTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UAGTag4(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUAGTag4Dirty() : !pSDEUAGroup.isUAGTag4Dirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUAGTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UAGTag4_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UAGTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUserCatDirty() : !pSDEUAGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserRefFlag(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUserRefFlagDirty() : !pSDEUAGroup.isUserRefFlagDirty()) {
            return null;
        }
        Integer n = pSDEUAGroup.getUserRefFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserRefFlag_Default(pSDEUAGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERREFFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUserTagDirty() : !pSDEUAGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUserTag2Dirty() : !pSDEUAGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUserTag3Dirty() : !pSDEUAGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEUAGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEUAGroup pSDEUAGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroup.isUserTag4Dirty() : !pSDEUAGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEUAGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEUAGroup, bl2, bl3);
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

    protected void onSyncEntity(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSDEUAGroup, bl);
    }

    protected void onSyncIndexEntities(PSDEUAGroup pSDEUAGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEUAGroup, bl);
    }

    public Object getDataContextValue(PSDEUAGroup pSDEUAGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEUAGroup, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEUAGroup pSDEUAGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEUAGroupDetail_PSDEUAGroup(pSDEUAGroup, arrayList, n);
        super.onExportRelatedModel(pSDEUAGroup, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEUAGroupDetail_PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEUAGroupDetail> arrayList2 = pSDEUAGroupDetailService.selectByPSDEUAGroup(pSDEUAGroup);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"20579c163ae7b17195c74d0c424292d3");
            jSONObject.put("srfdename", (Object)"PSDEUAGRPDETAIL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEUAGroup, (String)"PSDEUAGROUPID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEUAGroupDetail, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEUAGroupDetailService.exportModel(pSDEUAGroupDetail, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEUAGroup pSDEUAGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEUAGroup, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UAGROUPPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UAGroupParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UAGTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UAGTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UAGTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UAGTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UAGTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UAGTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UAGTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UAGTag4_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERREFFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserRefFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UAGroupParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UAGROUPPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UAGTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UAGTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UAGTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UAGTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UAGTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UAGTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UAGTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UAGTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_UserRefFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDEUAGroup pSDEUAGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEUAGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEUAGroup pSDEUAGroup) throws Exception {
        IService iService;
        Object object = pSDEUAGroup.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEUAGROUP_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEUAGroup.get("PSWFVERSIONID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID", object);
        }
        super.onUpdateParent(pSDEUAGroup);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEUAGroup pSDEUAGroup, Object object) throws Exception {
        PSDEUAGroup pSDEUAGroup2 = new PSDEUAGroup();
        pSDEUAGroup2.set("PSDEUAGROUPID", object);
        String string = DataObject.getStringValue((Object)pSDEUAGroup.get("PSDEUAGROUPID"));
        super.onCopyDetails(pSDEUAGroup, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEUAGroup pSDEUAGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEUAGROUP");
        if (!bl) {
            pSDEUAGroup.setPSWFId(null);
            pSDEUAGroup.setPSWFName(null);
            pSDEUAGroup.setPSWFProcessName(null);
            pSDEUAGroup.setPSWFVersionId(null);
            pSDEUAGroup.setPSWFVersionName(null);
            super.exportCurXmlModel(pSDEUAGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEUAGroup pSDEUAGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEUAGroupDetail(pSDEUAGroup, xmlNode);
        super.onExportRelatedXmlModel(pSDEUAGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEUAGroupDetail(PSDEUAGroup pSDEUAGroup, XmlNode xmlNode) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEUAGroupDetail> arrayList = null;
        String string = pSDEUAGroup.getPSDEUAGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEUAGroupDetailService.selectByPSDEUAGroup(pSDEUAGroup, "ORDER BY ORDERVALUE ASC") : pSDEUAGroupDetailService.selectTempByPSDEUAGroup(pSDEUAGroup, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEUAGRPDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
                pSDEUAGroupDetail.set("ORDERVALUE", null);
                pSDEUAGroupDetailService.exportXmlModel(pSDEUAGroupDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEUAGroup pSDEUAGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEUAGRPDETAILS");
        this.importRelatedXmlModel_PSDEUAGroupDetail(pSDEUAGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSDEUAGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEUAGroupDetail(PSDEUAGroup pSDEUAGroup, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEUAGroup.getPSDEUAGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEUAGroupDetailService.removeByPSDEUAGroup(pSDEUAGroup);
        } else {
            pSDEUAGroupDetailService.removeTempByPSDEUAGroup(pSDEUAGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEUAGroupDetail pSDEUAGroupDetail = new PSDEUAGroupDetail();
                pSDEUAGroupDetail.setOrderValue(n);
                n += 100;
                pSDEUAGroupDetailService.fillParentInfo(pSDEUAGroupDetail, "DER1N", "DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", pSDEUAGroup.getPSDEUAGroupId());
                pSDEUAGroupDetailService.importXmlModel(pSDEUAGroupDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEUAGroup pSDEUAGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEUAGroup, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFVERSION#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)string);
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUAGROUP_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUAGROUP_PSWORKFLOW_PSWFID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUAGROUP_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUAGROUP_PSSYSTEM_PSSYSTEMID";
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFNAME", null);
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
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSION", (boolean)true) == 0) {
            iEntity.set("PSWFVERSIONID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOW", (boolean)true) == 0) {
            iEntity.set("PSWFID", (Object)string2);
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
        return new String[]{"PSDEID", "PSWFVERSIONID", "PSWFID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSDEUAGroup pSDEUAGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUAGroup.getCodeName())) {
            return pSDEUAGroup.getCodeName();
        }
        return super.getModelV2Tag(pSDEUAGroup);
    }

    @Override
    public boolean setModelV2Tag(PSDEUAGroup pSDEUAGroup, String string) {
        pSDEUAGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        map.put("PSWFVERSIONID", "");
        map.put("PSWFID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEUAGroup pSDEUAGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEUAGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEUAGroup, true);
        pSDEUAGroup.set("CODENAME", string);
        if (this.select(pSDEUAGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEUAGroup, true);
        return super.getModelV2Entity(pSDEUAGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEUAGroup pSDEUAGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEUAGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEUAGroup pSDEUAGroup, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEUAGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEUAGroup pSDEUAGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID")) {
            PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEUAGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEUAGRPDETAIL", (Object)pSDEUAGroup.getPSDEUAGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEUAGROUP#%1$s", (Object)pSDEUAGroup.getPSDEUAGroupId());
                for (PSDEUAGroupDetail detail : pSDEUAGroupDetailService.selectByPSDEUAGroup(pSDEUAGroup)) {
                    String detailScope = pSDEUAGroupDetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare((String)scope, (String)detailScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSDEUAGroupDetailService.getModelV2Name(false).toLowerCase());
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
                for (ObjectNode detailNode : arrayList) {
                    PSDEUAGroupDetail detail = new PSDEUAGroupDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)detail, detailNode, false);
                    output.add((JsonNode)pSDEUAGroupDetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEUAGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEUAGroup pSDEUAGroup) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEUAGroupDetail> arrayList = pSDEUAGroupDetailService.selectByPSDEUAGroup(pSDEUAGroup);
        String string = StringHelper.format((String)"PSDEUAGROUP#%1$s", (Object)pSDEUAGroup.getPSDEUAGroupId());
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            String string2 = pSDEUAGroupDetailService.getModelV2ResScope(pSDEUAGroupDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEUAGroupDetailService.emptyModelV2(pSDEUAGroupDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEUAGroup.getPSDEUAGroupId());
        pSDEUAGroupDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEUAGroupDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEUAGRPDETAIL WHERE PSDEUAGROUPID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEUAGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEUAGroupDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEUAGroup pSDEUAGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEUAGroupDetail pSDEUAGroupDetail = new PSDEUAGroupDetail();
        pSDEUAGroupDetail.set("PSDEUAGROUPID", pSDEUAGroup.getPSDEUAGroupId());
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEUAGroupDetailService.getModelV2Entity(pSDEUAGroupDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEUAGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEUAGroup pSDEUAGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEUAGroupDetailService.getModelV2Name(null, false);
        if (objectNode != null && (arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase())) == null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)"psdeuagroupdetails");
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEUAGroupDetail pSDEUAGroupDetail = new PSDEUAGroupDetail();
                pSDEUAGroupDetail.setPSDEId(pSDEUAGroup.getPSDEId());
                pSDEUAGroupDetail.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
                pSDEUAGroupDetail.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                pSDEUAGroupDetailService.compileModelV2(pSDEUAGroupDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (!file.exists()) {
                string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)"PSDEUAGROUPDETAILS");
                file = new File(string4);
            }
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEUAGroupDetail pSDEUAGroupDetail = new PSDEUAGroupDetail();
                    pSDEUAGroupDetail.setPSDEId(pSDEUAGroup.getPSDEId());
                    pSDEUAGroupDetail.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
                    pSDEUAGroupDetail.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                    pSDEUAGroupDetailService.compileModelV2(pSDEUAGroupDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEUAGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEUAGroup pSDEUAGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEUAGrpDetails(pSDEUAGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEUAGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEUAGrpDetails(PSDEUAGroup pSDEUAGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEUAGRPDETAIL", true), (boolean)false) == 0) {
            PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEUAGroupDetail pSDEUAGroupDetail = new PSDEUAGroupDetail();
            pSDEUAGroupDetail.setPSDEUAGRPDetailId(pSMOSFile.getPSModelId());
            if (!pSDEUAGroupDetailService.get(pSDEUAGroupDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEUAGroupDetail.getPSDEUAGroupId(), (String)pSDEUAGroup.getPSDEUAGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEUAGroupDetailService.exportModelV2(pSDEUAGroupDetail);
            pSDEUAGroupDetail.reset();
            if (!pSDEUAGroupDetailService.setModelV2ResScope(pSDEUAGroupDetail, "PSDEUAGROUP", pSDEUAGroup.getPSDEUAGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEUAGroupDetailService.importModelV2(pSDEUAGroupDetail, objectNode);
            SessionFactoryManager.commit();
            return pSDEUAGroupDetailService.getFile(pSDEUAGroupDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEUIACTION", true), (boolean)false) == 0) {
            PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = new PSDEUIAction();
            pSDEUIAction.setPSDEUIActionId(pSMOSFile.getPSModelId());
            if (!pSDEUIActionService.get(pSDEUIAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEUAGroupDetail pSDEUAGroupDetail = new PSDEUAGroupDetail();
            pSDEUAGroupDetail.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
            pSDEUAGroupDetail.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            this.fillPasteEntity(pSDEUAGroupDetail, "PASTETAG");
            pSDEUAGroupDetailService.create(pSDEUAGroupDetail);
            SessionFactoryManager.commit();
            return pSDEUAGroupDetailService.getFile(pSDEUAGroupDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEUAGroup pSDEUAGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEUAGrpDetails(pSDEUAGroup, list);
        super.onFillPasteHelps(pSDEUAGroup, list);
    }

    protected void onFillPasteHelps_PSDEUAGrpDetails(PSDEUAGroup pSDEUAGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEUAGRPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4]\u7684[\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEUAGRPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID");
        pSHelpSection.setUserTag("DER1N_PSDEUAGRPDETAIL_PSDEUIACTION_PSDEUIACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\uff08\u5168\u5c40\u53ca\u5b9e\u4f53\uff09\u7684[\u5b9e\u4f53\u754c\u9762\u884c\u4e3a]\u6784\u5efa[\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7ec4\u6210\u5458>", "DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", "PSDEUAGROUPID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSDEUAGroupServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7ec4\u6210\u5458>");
            } else if (PSDEUAGroupServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdeuagrpdetails");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID|PSDEUAGROUPID");
            pSMOSFile2.setFileTag3("PSDEUAGRPDETAIL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", "PSDEUAGROUPID", pSMOSFile.getPSModelId(), "", "")) {
                PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEUAGroupDetailService, "DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", "PSDEUAGROUPID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSDEUAGroupDetailService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEUAGroupServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSDEUAGroupServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7ec4\u6210\u5458>", (boolean)false) == 0 || PSDEUAGroupServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEUAGrpDetails", (boolean)true) == 0) {
            PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEUAGroupDetailService, "DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", "PSDEUAGROUPID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSDEUAGroupDetail> arrayList2 = pSDEUAGroupDetailService.selectEx((ISelectContext)selectContext);
            for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList2) {
                PSMOSFile pSMOSFile2 = pSDEUAGroupDetailService.getFile(pSMOSFile, pSDEUAGroupDetail, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)false) == 0) {
            if (PSDEUAGroupServiceBase.getMOSVer() == 1) {
                return "<\u7ec4\u6210\u5458>";
            }
            if (PSDEUAGroupServiceBase.getMOSVer() == 2) {
                return "psdeuagrpdetails";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEUAGroup pSDEUAGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSDEUAGROUPNAME", "\u754c\u9762\u884c\u4e3a\u7ec4");
    }
}
