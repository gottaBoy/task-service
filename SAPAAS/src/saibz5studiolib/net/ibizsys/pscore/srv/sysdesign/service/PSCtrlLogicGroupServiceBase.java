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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlLogicGroupDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlLogicGroupDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGrpDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlLogicGroupServiceBase
extends PSCoreSysServiceBase<PSCtrlLogicGroup> {
    private static final Log log = LogFactory.getLog(PSCtrlLogicGroupServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEALL = "CurDEAll";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSALL = "CurSysAll";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSCtrlLogicGroupDEModel pSCtrlLogicGroupDEModel;
    private PSCtrlLogicGroupDAO pSCtrlLogicGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService";
    }

    public PSCtrlLogicGroupDEModel getPSCtrlLogicGroupDEModel() {
        if (this.pSCtrlLogicGroupDEModel == null) {
            try {
                this.pSCtrlLogicGroupDEModel = (PSCtrlLogicGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlLogicGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlLogicGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlLogicGroupDEModel();
    }

    public PSCtrlLogicGroupDAO getPSCtrlLogicGroupDAO() {
        if (this.pSCtrlLogicGroupDAO == null) {
            try {
                this.pSCtrlLogicGroupDAO = (PSCtrlLogicGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlLogicGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlLogicGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlLogicGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEALL, (boolean)true) == 0) {
            return this.fetchCurDEAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSALL, (boolean)true) == 0) {
            return this.fetchCurSysAll(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURDEALL, (boolean)true) == 0) {
            return this.fetchTempCurDEAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSALL, (boolean)true) == 0) {
            return this.fetchTempCurSysAll(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDEAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEALL, true);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSCtrlLogicGroup pSCtrlLogicGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLLOGICGROUP_PSCTRLLOGICGROUP_PPSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup2 = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup2.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup2);
            } else {
                iService.get(pSCtrlLogicGroup2);
            }
            this.onFillParentInfo_PPSCtrlLogicGroup(pSCtrlLogicGroup, pSCtrlLogicGroup2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLLOGICGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSCtrlLogicGroup, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLLOGICGROUP_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSCtrlLogicGroup, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLLOGICGROUP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSCtrlLogicGroup, pSSystem);
            return;
        }
        super.onFillParentInfo(pSCtrlLogicGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, PSCtrlLogicGroup pSCtrlLogicGroup2) throws Exception {
        pSCtrlLogicGroup.setPPSCtrlLogicGroupId(pSCtrlLogicGroup2.getPSCtrlLogicGroupId());
        pSCtrlLogicGroup.setPPSCtrlLogicGroupName(pSCtrlLogicGroup2.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSDE(PSCtrlLogicGroup pSCtrlLogicGroup, PSDataEntity pSDataEntity) throws Exception {
        pSCtrlLogicGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSCtrlLogicGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSModule(PSCtrlLogicGroup pSCtrlLogicGroup, PSModule pSModule) throws Exception {
        pSCtrlLogicGroup.setPSModuleId(pSModule.getPSModuleId());
        pSCtrlLogicGroup.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSCtrlLogicGroup pSCtrlLogicGroup, PSSystem pSSystem) throws Exception {
        pSCtrlLogicGroup.setPSSystemId(pSSystem.getPSSystemId());
        pSCtrlLogicGroup.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
        if (bl) {
            if (pSCtrlLogicGroup.getCodeName() == null) {
                pSCtrlLogicGroup.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "UILogicGroup", 25));
            }
            if (pSCtrlLogicGroup.getPSCtrlLogicGroupName() == null) {
                pSCtrlLogicGroup.setPSCtrlLogicGroupName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u754c\u9762\u903b\u8f91\u7ec4", 25));
            }
            if (pSCtrlLogicGroup.getValidFlag() == null) {
                pSCtrlLogicGroup.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSCtrlLogicGroup, bl);
        this.onFillEntityFullInfo_PPSCtrlLogicGroup(pSCtrlLogicGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSCtrlLogicGroup, bl);
        this.onFillEntityFullInfo_PSModule(pSCtrlLogicGroup, bl);
        this.onFillEntityFullInfo_PSSystem(pSCtrlLogicGroup, bl);
    }

    protected void onFillEntityFullInfo_PPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
        if (pSCtrlLogicGroup.isPSDEIdDirty()) {
            if (pSCtrlLogicGroup.getPSDEId() != null) {
                if (pSCtrlLogicGroup.getPSDEId() == null || pSCtrlLogicGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSCtrlLogicGroup.getPSDE();
                    pSCtrlLogicGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSCtrlLogicGroup.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
        if (pSCtrlLogicGroup.isPSSystemIdDirty()) {
            if (pSCtrlLogicGroup.getPSSystemId() != null) {
                if (pSCtrlLogicGroup.getPSSystemId() == null || pSCtrlLogicGroup.getPSSystemName() == null) {
                    PSSystem pSSystem = pSCtrlLogicGroup.getPSSystem();
                    pSCtrlLogicGroup.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSCtrlLogicGroup.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSCtrlLogicGroup, bl);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSCTRLLOGICGROUPID", (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSCtrlLogicGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSCtrlLogicGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCtrlLogicGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSCtrlLogicGroup> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSCtrlLogicGroup> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSCtrlLogicGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLLOGICGROUP_PSCTRLLOGICGROUP_PPSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSCTRLLOGICGROUP", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSCtrlLogicGroup pSCtrlLogicGroup2 : arrayList) {
            PSCtrlLogicGroup pSCtrlLogicGroup3 = (PSCtrlLogicGroup)this.getDEModel().createEntity();
            pSCtrlLogicGroup3.setPSCtrlLogicGroupId(pSCtrlLogicGroup2.getPSCtrlLogicGroupId());
            pSCtrlLogicGroup3.setPPSCtrlLogicGroupId(null);
            this.update(pSCtrlLogicGroup3);
        }
    }

    public void removeByPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlLogicGroupServiceBase.this.onBeforeRemoveByPPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSCtrlLogicGroupServiceBase.this.internalRemoveByPPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSCtrlLogicGroupServiceBase.this.onAfterRemoveByPPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSCtrlLogicGroup pSCtrlLogicGroup2 : arrayList) {
            this.remove(pSCtrlLogicGroup2);
        }
        this.onAfterRemoveByPPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLLOGICGROUP_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSCTRLLOGICGROUP", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSCtrlLogicGroup pSCtrlLogicGroup : arrayList) {
            PSCtrlLogicGroup pSCtrlLogicGroup2 = (PSCtrlLogicGroup)this.getDEModel().createEntity();
            pSCtrlLogicGroup2.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
            pSCtrlLogicGroup2.setPSDEId(null);
            this.update(pSCtrlLogicGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlLogicGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSCtrlLogicGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSCtrlLogicGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSCtrlLogicGroup pSCtrlLogicGroup : arrayList) {
            this.remove(pSCtrlLogicGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLLOGICGROUP_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSCTRLLOGICGROUP", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSModule(pSModule);
        for (PSCtrlLogicGroup pSCtrlLogicGroup : arrayList) {
            PSCtrlLogicGroup pSCtrlLogicGroup2 = (PSCtrlLogicGroup)this.getDEModel().createEntity();
            pSCtrlLogicGroup2.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
            pSCtrlLogicGroup2.setPSModuleId(null);
            this.update(pSCtrlLogicGroup2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlLogicGroupServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSCtrlLogicGroupServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSCtrlLogicGroupServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSCtrlLogicGroup pSCtrlLogicGroup : arrayList) {
            this.remove(pSCtrlLogicGroup);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLLOGICGROUP_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSCTRLLOGICGROUP", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSSystem(pSSystem);
        for (PSCtrlLogicGroup pSCtrlLogicGroup : arrayList) {
            PSCtrlLogicGroup pSCtrlLogicGroup2 = (PSCtrlLogicGroup)this.getDEModel().createEntity();
            pSCtrlLogicGroup2.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
            pSCtrlLogicGroup2.setPSSystemId(null);
            this.update(pSCtrlLogicGroup2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlLogicGroupServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSCtrlLogicGroupServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSCtrlLogicGroupServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCtrlLogicGroup> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSCtrlLogicGroup pSCtrlLogicGroup : arrayList) {
            this.remove(pSCtrlLogicGroup);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSCtrlLogicGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlLogicGroupServiceBase)pSCoreSysServiceBase).testRemoveByPPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlLogicGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        ((PSCtrlLogicGrpDetailServiceBase)pSCoreSysServiceBase).removeByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataRelationServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapViewServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup);
        super.onBeforeRemove(pSCtrlLogicGroup);
    }

    protected void onBeforeRemoveTemp(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        pSCtrlLogicGrpDetailService.removeTempByPSCtrlLogicGroup(pSCtrlLogicGroup);
        super.onBeforeRemoveTemp(pSCtrlLogicGroup);
    }

    protected void getRelatedDataTempMajor(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        this.getRelatedDataTempMajor_PSCtrlLogicGrpDetail(pSCtrlLogicGroup);
        super.getRelatedDataTempMajor(pSCtrlLogicGroup);
    }

    protected void getRelatedDataTempMajor_PSCtrlLogicGrpDetail(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlLogicGrpDetail> arrayList = null;
        String string = pSCtrlLogicGroup.getPSCtrlLogicGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSCtrlLogicGrpDetailService.selectByPSCtrlLogicGroup(pSCtrlLogicGroup) : pSCtrlLogicGrpDetailService.selectTempByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : arrayList) {
            pSCtrlLogicGrpDetailService.getTempMajor(pSCtrlLogicGrpDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSCtrlLogicGroup pSCtrlLogicGroup, PSCtrlLogicGroup pSCtrlLogicGroup2) throws Exception {
        ArrayList<PSCtrlLogicGrpDetail> arrayList = this.updateRelatedDataTempMajor_removePSCtrlLogicGrpDetail(pSCtrlLogicGroup, pSCtrlLogicGroup2);
        this.updateRelatedDataTempMajor_updatePSCtrlLogicGrpDetail(pSCtrlLogicGroup, pSCtrlLogicGroup2, arrayList);
        super.updateRelatedDataTempMajor(pSCtrlLogicGroup, pSCtrlLogicGroup2);
    }

    protected ArrayList<PSCtrlLogicGrpDetail> updateRelatedDataTempMajor_removePSCtrlLogicGrpDetail(PSCtrlLogicGroup pSCtrlLogicGroup, PSCtrlLogicGroup pSCtrlLogicGroup2) throws Exception {
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlLogicGrpDetail> arrayList = pSCtrlLogicGrpDetailService.selectTempByPSCtrlLogicGroup(pSCtrlLogicGroup);
        ArrayList<PSCtrlLogicGrpDetail> arrayList2 = pSCtrlLogicGrpDetailService.selectByPSCtrlLogicGroup(pSCtrlLogicGroup2);
        HashMap<String, PSCtrlLogicGrpDetail> hashMap = new HashMap<String, PSCtrlLogicGrpDetail>();
        for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : arrayList2) {
            hashMap.put(pSCtrlLogicGrpDetail.getPSCtrlLogicGrpDetailId(), pSCtrlLogicGrpDetail);
        }
        for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : arrayList) {
            Object object = pSCtrlLogicGrpDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : hashMap.values()) {
            pSCtrlLogicGrpDetailService.remove(pSCtrlLogicGrpDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSCtrlLogicGrpDetail(PSCtrlLogicGroup pSCtrlLogicGroup, PSCtrlLogicGroup pSCtrlLogicGroup2, ArrayList<PSCtrlLogicGrpDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : arrayList) {
            pSCtrlLogicGrpDetailService.updateTempMajor(pSCtrlLogicGrpDetail);
        }
    }

    protected void replaceParentInfo(PSCtrlLogicGroup pSCtrlLogicGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCtrlLogicGroup, cloneSession);
        if (pSCtrlLogicGroup.getPPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSCtrlLogicGroup.getPPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PPSCtrlLogicGroup(pSCtrlLogicGroup, (PSCtrlLogicGroup)iEntity);
        }
        if (pSCtrlLogicGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSCtrlLogicGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSCtrlLogicGroup, (PSDataEntity)iEntity);
        }
        if (pSCtrlLogicGroup.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSCtrlLogicGroup.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSCtrlLogicGroup, (PSModule)iEntity);
        }
        if (pSCtrlLogicGroup.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSCtrlLogicGroup.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSCtrlLogicGroup, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCtrlLogicGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSCtrlLogicGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlType(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSCtrlLogicGroupId(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupName(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSCtrlLogicGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCtrlLogicGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isCodeNameDirty() : !pSCtrlLogicGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSCtrlLogicGroup, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSCtrlLogicGroupDEModel(), "CODENAME", string3, pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlType(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isCtrlTypeDirty() : !pSCtrlLogicGroup.isCtrlTypeDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getCtrlType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlType_Default(pSCtrlLogicGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isMemoDirty() : !pSCtrlLogicGroup.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSCtrlLogicGroupId(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPPSCtrlLogicGroupIdDirty() : !pSCtrlLogicGroup.isPPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSCtrlLogicGroupId_Default(pSCtrlLogicGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPSCtrlLogicGroupIdDirty() && !bl2 : !pSCtrlLogicGroup.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSCtrlLogicGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupName(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPSCtrlLogicGroupNameDirty() && !bl2 : !pSCtrlLogicGroup.isPSCtrlLogicGroupNameDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPSCtrlLogicGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupName_Default(pSCtrlLogicGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSCtrlLogicGroupDEModel(), "PSCTRLLOGICGROUPNAME", string3, pSCtrlLogicGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSCTRLLOGICGROUPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPSDEIdDirty() : !pSCtrlLogicGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPSDENameDirty() : !pSCtrlLogicGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPSModuleIdDirty() : !pSCtrlLogicGroup.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPSSystemIdDirty() : !pSCtrlLogicGroup.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isPSSystemNameDirty() : !pSCtrlLogicGroup.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isUserCatDirty() : !pSCtrlLogicGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isUserTagDirty() : !pSCtrlLogicGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isUserTag2Dirty() : !pSCtrlLogicGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isUserTag3Dirty() : !pSCtrlLogicGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isUserTag4Dirty() : !pSCtrlLogicGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSCtrlLogicGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlLogicGroup.isValidFlagDirty() && !bl2 : !pSCtrlLogicGroup.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSCtrlLogicGroup.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSCtrlLogicGroup, bl2, bl3);
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

    protected void onSyncEntity(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSCtrlLogicGroup, bl);
    }

    protected void onSyncIndexEntities(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCtrlLogicGroup, bl);
    }

    public Object getDataContextValue(PSCtrlLogicGroup pSCtrlLogicGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCtrlLogicGroup, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSCtrlLogicGroup.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCtrlLogicGroup, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"CTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
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

    protected String onTestValueRule_PPSCtrlLogicGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSCTRLLOGICGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSCTRLLOGICGROUPID", "PSCTRLLOGICGROUP", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSCtrlLogicGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSCTRLLOGICGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCtrlLogicGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        super.onUpdateParent(pSCtrlLogicGroup);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlLogicGroup pSCtrlLogicGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLLOGICGROUP");
        if (!bl) {
            pSCtrlLogicGroup.setCreateDate(null);
            pSCtrlLogicGroup.setCreateMan(null);
            pSCtrlLogicGroup.setPSCtrlLogicGroupId(null);
            pSCtrlLogicGroup.setUpdateDate(null);
            pSCtrlLogicGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSCtrlLogicGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSCtrlLogicGroup pSCtrlLogicGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSCtrlLogicGrpDetail(pSCtrlLogicGroup, xmlNode);
        super.onExportRelatedXmlModel(pSCtrlLogicGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSCtrlLogicGrpDetail(PSCtrlLogicGroup pSCtrlLogicGroup, XmlNode xmlNode) throws Exception {
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlLogicGrpDetail> arrayList = null;
        String string = pSCtrlLogicGroup.getPSCtrlLogicGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSCtrlLogicGrpDetailService.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, "ORDER BY ORDERVALUE ASC") : pSCtrlLogicGrpDetailService.selectTempByPSCtrlLogicGroup(pSCtrlLogicGroup, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSCTRLLOGICGRPDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : arrayList) {
                pSCtrlLogicGrpDetail.set("ORDERVALUE", null);
                pSCtrlLogicGrpDetailService.exportXmlModel(pSCtrlLogicGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSCtrlLogicGroup pSCtrlLogicGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSCTRLLOGICGRPDETAILS");
        this.importRelatedXmlModel_PSCtrlLogicGrpDetail(pSCtrlLogicGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSCtrlLogicGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSCtrlLogicGrpDetail(PSCtrlLogicGroup pSCtrlLogicGroup, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSCtrlLogicGroup.getPSCtrlLogicGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSCtrlLogicGrpDetailService.removeByPSCtrlLogicGroup(pSCtrlLogicGroup);
        } else {
            pSCtrlLogicGrpDetailService.removeTempByPSCtrlLogicGroup(pSCtrlLogicGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail = new PSCtrlLogicGrpDetail();
                pSCtrlLogicGrpDetail.setOrderValue(n);
                n += 100;
                pSCtrlLogicGrpDetailService.fillParentInfo(pSCtrlLogicGrpDetail, "DER1N", "DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", pSCtrlLogicGroup.getPSCtrlLogicGroupId());
                pSCtrlLogicGrpDetailService.importXmlModel(pSCtrlLogicGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSCtrlLogicGroup pSCtrlLogicGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSCtrlLogicGroup, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
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
            return "DER1N_PSCTRLLOGICGROUP_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCTRLLOGICGROUP_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCTRLLOGICGROUP_PSSYSTEM_PSSYSTEMID";
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
        return new String[]{"PSDEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSCtrlLogicGroup pSCtrlLogicGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSCtrlLogicGroup.getCodeName())) {
            return pSCtrlLogicGroup.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSCtrlLogicGroup.getPSCtrlLogicGroupName())) {
            return pSCtrlLogicGroup.getPSCtrlLogicGroupName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSCtrlLogicGroup.getCodeName())) {
            return pSCtrlLogicGroup.getCodeName();
        }
        return super.getModelV2Tag(pSCtrlLogicGroup);
    }

    @Override
    public boolean setModelV2Tag(PSCtrlLogicGroup pSCtrlLogicGroup, String string) {
        pSCtrlLogicGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSCTRLLOGICGROUPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSCTRLLOGICGROUPNAME", "");
        map.put("PSDEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSCtrlLogicGroup pSCtrlLogicGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSCtrlLogicGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSCtrlLogicGroup, true);
        pSCtrlLogicGroup.set("CODENAME", string);
        if (this.select(pSCtrlLogicGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSCtrlLogicGroup, true);
        return super.getModelV2Entity(pSCtrlLogicGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSCtrlLogicGroup pSCtrlLogicGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSCtrlLogicGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSCtrlLogicGroup pSCtrlLogicGroup, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSCtrlLogicGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSCtrlLogicGroup pSCtrlLogicGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID")) {
            PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> detailNodes = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSCTRLLOGICGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSCTRLLOGICGRPDETAIL", (Object)pSCtrlLogicGroup.getPSCtrlLogicGroupId()));
                if (file.exists()) {
                    detailNodes = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        detailNodes.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                detailNodes = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSCTRLLOGICGROUP#%1$s", (Object)pSCtrlLogicGroup.getPSCtrlLogicGroupId());
                for (PSCtrlLogicGrpDetail detail : pSCtrlLogicGrpDetailService.selectByPSCtrlLogicGroup(pSCtrlLogicGroup)) {
                    String detailScope = pSCtrlLogicGrpDetailService.getModelV2ResScope(detail);
                    if (StringHelper.compare(scope, detailScope, false) != 0) continue;
                    detailNodes.add(PSModelV2Helper.toJSONObject(detail, false));
                }
            }
            if (detailNodes != null && detailNodes.size() > 0) {
                ArrayNode childNodes = objectNode.putArray(pSCtrlLogicGrpDetailService.getModelV2Name(false).toLowerCase());
                Collections.sort(detailNodes, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("psctrllogicgrpdetailname")) {
                            string = objectNode.get("psctrllogicgrpdetailname").asText();
                        }
                        if (objectNode2.has("psctrllogicgrpdetailname")) {
                            string2 = objectNode2.get("psctrllogicgrpdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode detailNode : detailNodes) {
                    PSCtrlLogicGrpDetail detail = new PSCtrlLogicGrpDetail();
                    PSModelV2Helper.fromJSONObject(detail, detailNode, false);
                    childNodes.add(pSCtrlLogicGrpDetailService.exportModelV2(detail, string));
                }
            }
        }
        super.onExportCurModelV2(pSCtrlLogicGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlLogicGrpDetail> arrayList = pSCtrlLogicGrpDetailService.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        String string = StringHelper.format((String)"PSCTRLLOGICGROUP#%1$s", (Object)pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : arrayList) {
            String string2 = pSCtrlLogicGrpDetailService.getModelV2ResScope(pSCtrlLogicGrpDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSCtrlLogicGrpDetailService.emptyModelV2(pSCtrlLogicGrpDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSCtrlLogicGrpDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSCtrlLogicGrpDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSCTRLLOGICGRPDETAIL WHERE PSCTRLLOGICGROUPID = ?", sqlParamList);
        super.onEmptyModelV2(pSCtrlLogicGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCtrlLogicGrpDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSCtrlLogicGroup pSCtrlLogicGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail = new PSCtrlLogicGrpDetail();
        pSCtrlLogicGrpDetail.set("PSCTRLLOGICGROUPID", pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCtrlLogicGrpDetailService.getModelV2Entity(pSCtrlLogicGrpDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSCtrlLogicGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSCtrlLogicGroup pSCtrlLogicGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCtrlLogicGrpDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail = new PSCtrlLogicGrpDetail();
                pSCtrlLogicGrpDetail.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
                pSCtrlLogicGrpDetail.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
                pSCtrlLogicGrpDetailService.compileModelV2(pSCtrlLogicGrpDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail = new PSCtrlLogicGrpDetail();
                    pSCtrlLogicGrpDetail.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
                    pSCtrlLogicGrpDetail.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
                    pSCtrlLogicGrpDetailService.compileModelV2(pSCtrlLogicGrpDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSCtrlLogicGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSCtrlLogicGroup pSCtrlLogicGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSCtrlLogicGrpDetails(pSCtrlLogicGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSCtrlLogicGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSCtrlLogicGrpDetails(PSCtrlLogicGroup pSCtrlLogicGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSCTRLLOGICGRPDETAIL", true), (boolean)false) == 0) {
            PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail = new PSCtrlLogicGrpDetail();
            pSCtrlLogicGrpDetail.setPSCtrlLogicGrpDetailId(pSMOSFile.getPSModelId());
            if (!pSCtrlLogicGrpDetailService.get(pSCtrlLogicGrpDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSCtrlLogicGrpDetail.getPSCtrlLogicGroupId(), (String)pSCtrlLogicGroup.getPSCtrlLogicGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSCtrlLogicGrpDetailService.exportModelV2(pSCtrlLogicGrpDetail);
            pSCtrlLogicGrpDetail.reset();
            if (!pSCtrlLogicGrpDetailService.setModelV2ResScope(pSCtrlLogicGrpDetail, "PSCTRLLOGICGROUP", pSCtrlLogicGroup.getPSCtrlLogicGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSCtrlLogicGrpDetailService.importModelV2(pSCtrlLogicGrpDetail, objectNode);
            SessionFactoryManager.commit();
            return pSCtrlLogicGrpDetailService.getFile(pSCtrlLogicGrpDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSCtrlLogicGroup pSCtrlLogicGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSCtrlLogicGrpDetails(pSCtrlLogicGroup, list);
        super.onFillPasteHelps(pSCtrlLogicGroup, list);
    }

    protected void onFillPasteHelps_PSCtrlLogicGrpDetails(PSCtrlLogicGroup pSCtrlLogicGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSCTRLLOGICGRPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u90e8\u4ef6\u903b\u8f91\u7ec4]\u7684[\u90e8\u4ef6\u903b\u8f91\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7ec4\u6210\u5458>", "DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "PSCTRLLOGICGROUPID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSCtrlLogicGroupServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7ec4\u6210\u5458>");
            } else if (PSCtrlLogicGroupServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psctrllogicgrpdetails");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID|PSCTRLLOGICGROUPID");
            pSMOSFile2.setFileTag3("PSCTRLLOGICGRPDETAIL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "PSCTRLLOGICGROUPID", pSMOSFile.getPSModelId(), "", "")) {
                PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCtrlLogicGrpDetailService, "DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "PSCTRLLOGICGROUPID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSCtrlLogicGrpDetailService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSCtrlLogicGroupServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSCtrlLogicGroupServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7ec4\u6210\u5458>", (boolean)false) == 0 || PSCtrlLogicGroupServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSCtrlLogicGrpDetails", (boolean)true) == 0) {
            PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCtrlLogicGrpDetailService, "DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "PSCTRLLOGICGROUPID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSCtrlLogicGrpDetail> arrayList2 = pSCtrlLogicGrpDetailService.selectEx((ISelectContext)selectContext);
            for (PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail : arrayList2) {
                PSMOSFile pSMOSFile2 = pSCtrlLogicGrpDetailService.getFile(pSMOSFile, pSCtrlLogicGrpDetail, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSCTRLLOGICGRPDETAIL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)false) == 0) {
            if (PSCtrlLogicGroupServiceBase.getMOSVer() == 1) {
                return "<\u7ec4\u6210\u5458>";
            }
            if (PSCtrlLogicGroupServiceBase.getMOSVer() == 2) {
                return "psctrllogicgrpdetails";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSCtrlLogicGroup pSCtrlLogicGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "UILogicGroup");
        defaultValueMap.put("PSCTRLLOGICGROUPNAME", "\u754c\u9762\u903b\u8f91\u7ec4");
    }
}
