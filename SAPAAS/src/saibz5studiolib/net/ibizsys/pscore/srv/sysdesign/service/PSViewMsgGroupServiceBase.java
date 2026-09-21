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
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSViewMsgGroupDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSViewMsgGroupDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGrpDetail;
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
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewMsgGroupServiceBase
extends PSCoreSysServiceBase<PSViewMsgGroup> {
    private static final Log log = LogFactory.getLog(PSViewMsgGroupServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSViewMsgGroupDEModel pSViewMsgGroupDEModel;
    private PSViewMsgGroupDAO pSViewMsgGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService";
    }

    public PSViewMsgGroupDEModel getPSViewMsgGroupDEModel() {
        if (this.pSViewMsgGroupDEModel == null) {
            try {
                this.pSViewMsgGroupDEModel = (PSViewMsgGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSViewMsgGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewMsgGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewMsgGroupDEModel();
    }

    public PSViewMsgGroupDAO getPSViewMsgGroupDAO() {
        if (this.pSViewMsgGroupDAO == null) {
            try {
                this.pSViewMsgGroupDAO = (PSViewMsgGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSViewMsgGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewMsgGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewMsgGroupDAO();
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

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, true);
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

    protected void onFillParentInfo(PSViewMsgGroup pSViewMsgGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSViewMsgGroup, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGROUP_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSViewMsgGroup, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGROUP_PSSYSCSS_BODYMSGPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_BodyMsgPSSysCss(pSViewMsgGroup, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGROUP_PSSYSCSS_BOTTOMMSGPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_BottomMsgPSSysCss(pSViewMsgGroup, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGROUP_PSSYSCSS_TOPMSGPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_TopMsgPSSysCss(pSViewMsgGroup, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGROUP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSViewMsgGroup, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGROUP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSViewMsgGroup, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSViewMsgGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSViewMsgGroup pSViewMsgGroup, PSDataEntity pSDataEntity) throws Exception {
        pSViewMsgGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSViewMsgGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSModule(PSViewMsgGroup pSViewMsgGroup, PSModule pSModule) throws Exception {
        pSViewMsgGroup.setPSModuleId(pSModule.getPSModuleId());
        pSViewMsgGroup.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_BodyMsgPSSysCss(PSViewMsgGroup pSViewMsgGroup, PSSysCss pSSysCss) throws Exception {
        pSViewMsgGroup.setBodyMsgPSSysCssId(pSSysCss.getPSSysCssId());
        pSViewMsgGroup.setBodyMsgPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_BottomMsgPSSysCss(PSViewMsgGroup pSViewMsgGroup, PSSysCss pSSysCss) throws Exception {
        pSViewMsgGroup.setBottomMsgPSSysCssId(pSSysCss.getPSSysCssId());
        pSViewMsgGroup.setBottomMsgPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_TopMsgPSSysCss(PSViewMsgGroup pSViewMsgGroup, PSSysCss pSSysCss) throws Exception {
        pSViewMsgGroup.setTopMsgPSSysCssId(pSSysCss.getPSSysCssId());
        pSViewMsgGroup.setTopMsgPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSViewMsgGroup pSViewMsgGroup, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSViewMsgGroup.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSViewMsgGroup.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSystem(PSViewMsgGroup pSViewMsgGroup, PSSystem pSSystem) throws Exception {
        pSViewMsgGroup.setPSSystemId(pSSystem.getPSSystemId());
        pSViewMsgGroup.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
        if (bl) {
            if (pSViewMsgGroup.getCodeName() == null) {
                pSViewMsgGroup.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "VMGroup", 25));
            }
            if (pSViewMsgGroup.getDynamicMode() == null) {
                pSViewMsgGroup.setDynamicMode((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSViewMsgGroup.getPSViewMsgGroupName() == null) {
                pSViewMsgGroup.setPSViewMsgGroupName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u89c6\u56fe\u6d88\u606f\u7ec4", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSViewMsgGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSViewMsgGroup, bl);
        this.onFillEntityFullInfo_PSModule(pSViewMsgGroup, bl);
        this.onFillEntityFullInfo_BodyMsgPSSysCss(pSViewMsgGroup, bl);
        this.onFillEntityFullInfo_BottomMsgPSSysCss(pSViewMsgGroup, bl);
        this.onFillEntityFullInfo_TopMsgPSSysCss(pSViewMsgGroup, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSViewMsgGroup, bl);
        this.onFillEntityFullInfo_PSSystem(pSViewMsgGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
        if (pSViewMsgGroup.isPSDEIdDirty()) {
            if (pSViewMsgGroup.getPSDEId() != null) {
                if (pSViewMsgGroup.getPSDEId() == null || pSViewMsgGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSViewMsgGroup.getPSDE();
                    pSViewMsgGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSViewMsgGroup.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BodyMsgPSSysCss(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BottomMsgPSSysCss(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TopMsgPSSysCss(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
        if (pSViewMsgGroup.isPSSystemIdDirty()) {
            if (pSViewMsgGroup.getPSSystemId() != null) {
                if (pSViewMsgGroup.getPSSystemId() == null || pSViewMsgGroup.getPSSystemName() == null) {
                    PSSystem pSSystem = pSViewMsgGroup.getPSSystem();
                    pSViewMsgGroup.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSViewMsgGroup.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSViewMsgGroup, bl);
    }

    public ArrayList<PSViewMsgGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsgGroup> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsgGroup> selectByBodyMsgPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByBodyMsgPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSViewMsgGroup> selectByBodyMsgPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByBodyMsgPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSViewMsgGroup> selectByBodyMsgPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BODYMSGPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBodyMsgPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBodyMsgPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsgGroup> selectByBottomMsgPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByBottomMsgPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSViewMsgGroup> selectByBottomMsgPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByBottomMsgPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSViewMsgGroup> selectByBottomMsgPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BOTTOMMSGPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBottomMsgPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBottomMsgPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsgGroup> selectByTopMsgPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByTopMsgPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSViewMsgGroup> selectByTopMsgPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByTopMsgPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSViewMsgGroup> selectByTopMsgPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TOPMSGPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTopMsgPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTopMsgPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsgGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewMsgGroup> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSViewMsgGroup> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSGGROUP_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSVIEWMSGGROUP", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            PSViewMsgGroup pSViewMsgGroup2 = (PSViewMsgGroup)this.getDEModel().createEntity();
            pSViewMsgGroup2.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGroup2.setPSDEId(null);
            this.update(pSViewMsgGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSViewMsgGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSViewMsgGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            this.remove((IEntity)pSViewMsgGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSGGROUP_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSVIEWMSGGROUP", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSModule(pSModule);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            PSViewMsgGroup pSViewMsgGroup2 = (PSViewMsgGroup)this.getDEModel().createEntity();
            pSViewMsgGroup2.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGroup2.setPSModuleId(null);
            this.update(pSViewMsgGroup2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGroupServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSViewMsgGroupServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSViewMsgGroupServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            this.remove((IEntity)pSViewMsgGroup);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    public void testRemoveByBodyMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByBodyMsgPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSGGROUP_PSSYSCSS_BODYMSGPSSYSCSSID", "", iDataEntityModel.getName(), "PSVIEWMSGGROUP", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetBodyMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByBodyMsgPSSysCss(pSSysCss);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            PSViewMsgGroup pSViewMsgGroup2 = (PSViewMsgGroup)this.getDEModel().createEntity();
            pSViewMsgGroup2.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGroup2.setBodyMsgPSSysCssId(null);
            this.update(pSViewMsgGroup2);
        }
    }

    public void removeByBodyMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGroupServiceBase.this.onBeforeRemoveByBodyMsgPSSysCss(pSSysCss2);
                PSViewMsgGroupServiceBase.this.internalRemoveByBodyMsgPSSysCss(pSSysCss2);
                PSViewMsgGroupServiceBase.this.onAfterRemoveByBodyMsgPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByBodyMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByBodyMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByBodyMsgPSSysCss(pSSysCss);
        this.onBeforeRemoveByBodyMsgPSSysCss(pSSysCss, arrayList);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            this.remove((IEntity)pSViewMsgGroup);
        }
        this.onAfterRemoveByBodyMsgPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByBodyMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByBodyMsgPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBodyMsgPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    public void testRemoveByBottomMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByBottomMsgPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSGGROUP_PSSYSCSS_BOTTOMMSGPSSYSCSSID", "", iDataEntityModel.getName(), "PSVIEWMSGGROUP", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetBottomMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByBottomMsgPSSysCss(pSSysCss);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            PSViewMsgGroup pSViewMsgGroup2 = (PSViewMsgGroup)this.getDEModel().createEntity();
            pSViewMsgGroup2.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGroup2.setBottomMsgPSSysCssId(null);
            this.update(pSViewMsgGroup2);
        }
    }

    public void removeByBottomMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGroupServiceBase.this.onBeforeRemoveByBottomMsgPSSysCss(pSSysCss2);
                PSViewMsgGroupServiceBase.this.internalRemoveByBottomMsgPSSysCss(pSSysCss2);
                PSViewMsgGroupServiceBase.this.onAfterRemoveByBottomMsgPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByBottomMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByBottomMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByBottomMsgPSSysCss(pSSysCss);
        this.onBeforeRemoveByBottomMsgPSSysCss(pSSysCss, arrayList);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            this.remove((IEntity)pSViewMsgGroup);
        }
        this.onAfterRemoveByBottomMsgPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByBottomMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByBottomMsgPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBottomMsgPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    public void testRemoveByTopMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByTopMsgPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSGGROUP_PSSYSCSS_TOPMSGPSSYSCSSID", "", iDataEntityModel.getName(), "PSVIEWMSGGROUP", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetTopMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByTopMsgPSSysCss(pSSysCss);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            PSViewMsgGroup pSViewMsgGroup2 = (PSViewMsgGroup)this.getDEModel().createEntity();
            pSViewMsgGroup2.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGroup2.setTopMsgPSSysCssId(null);
            this.update(pSViewMsgGroup2);
        }
    }

    public void removeByTopMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGroupServiceBase.this.onBeforeRemoveByTopMsgPSSysCss(pSSysCss2);
                PSViewMsgGroupServiceBase.this.internalRemoveByTopMsgPSSysCss(pSSysCss2);
                PSViewMsgGroupServiceBase.this.onAfterRemoveByTopMsgPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByTopMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByTopMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByTopMsgPSSysCss(pSSysCss);
        this.onBeforeRemoveByTopMsgPSSysCss(pSSysCss, arrayList);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            this.remove((IEntity)pSViewMsgGroup);
        }
        this.onAfterRemoveByTopMsgPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByTopMsgPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByTopMsgPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTopMsgPSSysCss(PSSysCss pSSysCss, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSGGROUP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSVIEWMSGGROUP", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            PSViewMsgGroup pSViewMsgGroup2 = (PSViewMsgGroup)this.getDEModel().createEntity();
            pSViewMsgGroup2.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGroup2.setPSSysDynaModelId(null);
            this.update(pSViewMsgGroup2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGroupServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSViewMsgGroupServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSViewMsgGroupServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            this.remove((IEntity)pSViewMsgGroup);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSSystem(pSSystem);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            PSViewMsgGroup pSViewMsgGroup2 = (PSViewMsgGroup)this.getDEModel().createEntity();
            pSViewMsgGroup2.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGroup2.setPSSystemId(null);
            this.update(pSViewMsgGroup2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGroupServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSViewMsgGroupServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSViewMsgGroupServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSViewMsgGroup> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSViewMsgGroup pSViewMsgGroup : arrayList) {
            this.remove((IEntity)pSViewMsgGroup);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSViewMsgGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapViewServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        pSCoreSysServiceBase = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSViewMsgGroup(pSViewMsgGroup);
        ((PSViewMsgGrpDetailServiceBase)pSCoreSysServiceBase).removeByPSViewMsgGroup(pSViewMsgGroup);
        super.onBeforeRemove(pSViewMsgGroup);
    }

    protected void onBeforeRemoveTemp(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        pSViewMsgGrpDetailService.removeTempByPSViewMsgGroup(pSViewMsgGroup);
        super.onBeforeRemoveTemp((IEntity)pSViewMsgGroup);
    }

    protected void getRelatedDataTempMajor(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        this.getRelatedDataTempMajor_PSViewMsgGrpDetail(pSViewMsgGroup);
        super.getRelatedDataTempMajor((IEntity)pSViewMsgGroup);
    }

    protected void getRelatedDataTempMajor_PSViewMsgGrpDetail(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSViewMsgGrpDetail> arrayList = null;
        String string = pSViewMsgGroup.getPSViewMsgGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSViewMsgGrpDetailService.selectByPSViewMsgGroup(pSViewMsgGroup) : pSViewMsgGrpDetailService.selectTempByPSViewMsgGroup(pSViewMsgGroup);
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            pSViewMsgGrpDetailService.getTempMajor(pSViewMsgGrpDetail);
        }
    }

    protected void updateRelatedDataTempMajor(PSViewMsgGroup pSViewMsgGroup, PSViewMsgGroup pSViewMsgGroup2) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.updateRelatedDataTempMajor_removePSViewMsgGrpDetail(pSViewMsgGroup, pSViewMsgGroup2);
        this.updateRelatedDataTempMajor_updatePSViewMsgGrpDetail(pSViewMsgGroup, pSViewMsgGroup2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSViewMsgGroup, (IEntity)pSViewMsgGroup2);
    }

    protected ArrayList<PSViewMsgGrpDetail> updateRelatedDataTempMajor_removePSViewMsgGrpDetail(PSViewMsgGroup pSViewMsgGroup, PSViewMsgGroup pSViewMsgGroup2) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSViewMsgGrpDetail> arrayList = pSViewMsgGrpDetailService.selectTempByPSViewMsgGroup(pSViewMsgGroup);
        ArrayList<PSViewMsgGrpDetail> arrayList2 = pSViewMsgGrpDetailService.selectByPSViewMsgGroup(pSViewMsgGroup2);
        HashMap<String, PSViewMsgGrpDetail> hashMap = new HashMap<String, PSViewMsgGrpDetail>();
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList2) {
            hashMap.put(pSViewMsgGrpDetail.getPSViewMsgGrpDetailId(), pSViewMsgGrpDetail);
        }
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            Object object = pSViewMsgGrpDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : hashMap.values()) {
            pSViewMsgGrpDetailService.remove((IEntity)pSViewMsgGrpDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSViewMsgGrpDetail(PSViewMsgGroup pSViewMsgGroup, PSViewMsgGroup pSViewMsgGroup2, ArrayList<PSViewMsgGrpDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            pSViewMsgGrpDetailService.updateTempMajor(pSViewMsgGrpDetail);
        }
    }

    protected void replaceParentInfo(PSViewMsgGroup pSViewMsgGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSViewMsgGroup, cloneSession);
        if (pSViewMsgGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSViewMsgGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSViewMsgGroup, (PSDataEntity)iEntity);
        }
        if (pSViewMsgGroup.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSViewMsgGroup.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSViewMsgGroup, (PSModule)iEntity);
        }
        if (pSViewMsgGroup.getBodyMsgPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSViewMsgGroup.getBodyMsgPSSysCssId())) != null) {
            this.onFillParentInfo_BodyMsgPSSysCss(pSViewMsgGroup, (PSSysCss)iEntity);
        }
        if (pSViewMsgGroup.getBottomMsgPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSViewMsgGroup.getBottomMsgPSSysCssId())) != null) {
            this.onFillParentInfo_BottomMsgPSSysCss(pSViewMsgGroup, (PSSysCss)iEntity);
        }
        if (pSViewMsgGroup.getTopMsgPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSViewMsgGroup.getTopMsgPSSysCssId())) != null) {
            this.onFillParentInfo_TopMsgPSSysCss(pSViewMsgGroup, (PSSysCss)iEntity);
        }
        if (pSViewMsgGroup.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSViewMsgGroup.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSViewMsgGroup, (PSSysDynaModel)iEntity);
        }
        if (pSViewMsgGroup.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSViewMsgGroup.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSViewMsgGroup, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSViewMsgGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BodyMsgPSSysCssId(bl, pSViewMsgGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BodyMsgStyle(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomMsgPSSysCssId(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomMsgStyle(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynamicMode(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupName(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopMsgPSSysCssId(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopMsgStyle(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSViewMsgGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSViewMsgGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BodyMsgPSSysCssId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isBodyMsgPSSysCssIdDirty() : !pSViewMsgGroup.isBodyMsgPSSysCssIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getBodyMsgPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BodyMsgPSSysCssId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BODYMSGPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BodyMsgStyle(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isBodyMsgStyleDirty() : !pSViewMsgGroup.isBodyMsgStyleDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getBodyMsgStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BodyMsgStyle_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BODYMSGSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomMsgPSSysCssId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isBottomMsgPSSysCssIdDirty() : !pSViewMsgGroup.isBottomMsgPSSysCssIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getBottomMsgPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomMsgPSSysCssId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMMSGPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomMsgStyle(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isBottomMsgStyleDirty() : !pSViewMsgGroup.isBottomMsgStyleDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getBottomMsgStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomMsgStyle_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMMSGSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isCodeNameDirty() : !pSViewMsgGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSViewMsgGroupDEModel(), "CODENAME", string3, pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynamicMode(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isDynamicModeDirty() : !pSViewMsgGroup.isDynamicModeDirty()) {
            return null;
        }
        Integer n = pSViewMsgGroup.getDynamicMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynamicMode_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMICMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isLockFlagDirty() : !pSViewMsgGroup.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSViewMsgGroup.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isMemoDirty() : !pSViewMsgGroup.isMemoDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSDEIdDirty() : !pSViewMsgGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSDENameDirty() : !pSViewMsgGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSModuleIdDirty() : !pSViewMsgGroup.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSSysDynaModelIdDirty() : !pSViewMsgGroup.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSSystemIdDirty() : !pSViewMsgGroup.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSSystemNameDirty() : !pSViewMsgGroup.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSViewMsgGroupIdDirty() && !bl2 : !pSViewMsgGroup.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSViewMsgGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupName(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isPSViewMsgGroupNameDirty() && !bl2 : !pSViewMsgGroup.isPSViewMsgGroupNameDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getPSViewMsgGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupName_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSViewMsgGroupDEModel(), "PSVIEWMSGGROUPNAME", string3, pSViewMsgGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSVIEWMSGGROUPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopMsgPSSysCssId(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isTopMsgPSSysCssIdDirty() : !pSViewMsgGroup.isTopMsgPSSysCssIdDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getTopMsgPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TopMsgPSSysCssId_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPMSGPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopMsgStyle(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isTopMsgStyleDirty() : !pSViewMsgGroup.isTopMsgStyleDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getTopMsgStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TopMsgStyle_Default((IEntity)pSViewMsgGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPMSGSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isUserCatDirty() : !pSViewMsgGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isUserParamsDirty() : !pSViewMsgGroup.isUserParamsDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isUserTagDirty() : !pSViewMsgGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isUserTag2Dirty() : !pSViewMsgGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isUserTag3Dirty() : !pSViewMsgGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSViewMsgGroup pSViewMsgGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGroup.isUserTag4Dirty() : !pSViewMsgGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSViewMsgGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSViewMsgGroup, bl2, bl3);
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

    protected void onSyncEntity(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSViewMsgGroup, bl);
    }

    protected void onSyncIndexEntities(PSViewMsgGroup pSViewMsgGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSViewMsgGroup, bl);
    }

    public Object getDataContextValue(PSViewMsgGroup pSViewMsgGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSViewMsgGroup, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSViewMsgGroup pSViewMsgGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSViewMsgGrpDetail_PSViewMsgGroup(pSViewMsgGroup, arrayList, n);
        super.onExportRelatedModel((IEntity)pSViewMsgGroup, arrayList, n);
    }

    /*
     * WARNING - void declaration
     */
    protected void onExportRelatedModel_PSViewMsgGrpDetail_PSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSViewMsgGrpDetail> arrayList2 = pSViewMsgGrpDetailService.selectByPSViewMsgGroup(pSViewMsgGroup);
        if ((n & 2) != 0) {
            void var7_8;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"b87a61033009834b4684848b10e4cea8");
            jSONObject.put("srfdename", (Object)"PSVIEWMSGGRPDETAIL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSViewMsgGroup, (String)"PSVIEWMSGGROUPID", (String)""));
            String object = "";
            for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList2) {
                void var7_10;
                if (!StringHelper.isNullOrEmpty((String)var7_8)) {
                    String string = (String)var7_8 + ";";
                }
                String string = (String)var7_10 + DataObject.getStringValue((IDataObject)pSViewMsgGrpDetail, (String)"PSVIEWMSGGRPDETAILID", (String)"");
            }
            jSONObject.put("srfarg2", (Object)var7_8);
            arrayList.add(jSONObject);
        }
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSViewMsgGrpDetail, (String)"srfsyspub", (int)1) == 0) continue;
            pSViewMsgGrpDetailService.exportModel(pSViewMsgGrpDetail, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSViewMsgGroup pSViewMsgGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSViewMsgGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BODYMSGPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BodyMsgPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BODYMSGPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BodyMsgPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BODYMSGSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BodyMsgStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMMSGPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomMsgPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMMSGPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomMsgPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMMSGSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomMsgStyle_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNAMICMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynamicMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPMSGPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopMsgPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPMSGPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopMsgPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPMSGSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopMsgStyle_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BodyMsgPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BODYMSGPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BodyMsgPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BODYMSGPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BodyMsgStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BODYMSGSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BottomMsgPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMMSGPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BottomMsgPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMMSGPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BottomMsgStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMMSGSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DynamicMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TopMsgPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOPMSGPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TopMsgPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOPMSGPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TopMsgStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOPMSGSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSViewMsgGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        super.onUpdateParent((IEntity)pSViewMsgGroup);
    }

    protected void onCopyDetails(PSViewMsgGroup pSViewMsgGroup, Object object) throws Exception {
        PSViewMsgGroup pSViewMsgGroup2 = new PSViewMsgGroup();
        pSViewMsgGroup2.set("PSVIEWMSGGROUPID", object);
        String string = DataObject.getStringValue((Object)pSViewMsgGroup.get("PSVIEWMSGGROUPID"));
        super.onCopyDetails((IEntity)pSViewMsgGroup, object);
    }

    @Override
    protected void exportCurXmlModel(PSViewMsgGroup pSViewMsgGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWMSGGROUP");
        if (!bl) {
            pSViewMsgGroup.setCreateDate(null);
            pSViewMsgGroup.setCreateMan(null);
            pSViewMsgGroup.setPSViewMsgGroupId(null);
            pSViewMsgGroup.setUpdateDate(null);
            pSViewMsgGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSViewMsgGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSViewMsgGroup pSViewMsgGroup, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSViewMsgGrpDetail(pSViewMsgGroup, xmlNode);
        super.onExportRelatedXmlModel(pSViewMsgGroup, xmlNode);
    }

    protected void exportRelatedXmlModel_PSViewMsgGrpDetail(PSViewMsgGroup pSViewMsgGroup, XmlNode xmlNode) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSViewMsgGrpDetail> arrayList = null;
        String string = pSViewMsgGroup.getPSViewMsgGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSViewMsgGrpDetailService.selectByPSViewMsgGroup(pSViewMsgGroup, "ORDER BY ORDERVALUE ASC") : pSViewMsgGrpDetailService.selectTempByPSViewMsgGroup(pSViewMsgGroup, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSVIEWMSGGRPDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
                pSViewMsgGrpDetail.set("ORDERVALUE", null);
                pSViewMsgGrpDetailService.exportXmlModel(pSViewMsgGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSViewMsgGroup pSViewMsgGroup, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSVIEWMSGGRPDETAILS");
        this.importRelatedXmlModel_PSViewMsgGrpDetail(pSViewMsgGroup, xmlNode2);
        super.onImportRelatedXmlModel(pSViewMsgGroup, xmlNode);
    }

    protected void importRelatedXmlModel_PSViewMsgGrpDetail(PSViewMsgGroup pSViewMsgGroup, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSViewMsgGroup.getPSViewMsgGroupId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSViewMsgGrpDetailService.removeByPSViewMsgGroup(pSViewMsgGroup);
        } else {
            pSViewMsgGrpDetailService.removeTempByPSViewMsgGroup(pSViewMsgGroup);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSViewMsgGrpDetail pSViewMsgGrpDetail = new PSViewMsgGrpDetail();
                pSViewMsgGrpDetail.setOrderValue(n);
                n += 100;
                pSViewMsgGrpDetailService.fillParentInfo((IEntity)pSViewMsgGrpDetail, "DER1N", "DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", pSViewMsgGroup.getPSViewMsgGroupId());
                pSViewMsgGrpDetailService.importXmlModel(pSViewMsgGrpDetail, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSViewMsgGroup pSViewMsgGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSViewMsgGroup, string);
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
            return "DER1N_PSVIEWMSGGROUP_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSVIEWMSGGROUP_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSViewMsgGroup pSViewMsgGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSViewMsgGroup.getCodeName())) {
            return pSViewMsgGroup.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSViewMsgGroup.getPSViewMsgGroupName())) {
            return pSViewMsgGroup.getPSViewMsgGroupName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSViewMsgGroup.getCodeName())) {
            return pSViewMsgGroup.getCodeName();
        }
        return super.getModelV2Tag(pSViewMsgGroup);
    }

    @Override
    public boolean setModelV2Tag(PSViewMsgGroup pSViewMsgGroup, String string) {
        pSViewMsgGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSVIEWMSGGROUPNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSViewMsgGroup pSViewMsgGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSViewMsgGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSViewMsgGroup, true);
        pSViewMsgGroup.set("CODENAME", string);
        if (this.select(pSViewMsgGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSViewMsgGroup, true);
        return super.getModelV2Entity(pSViewMsgGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSViewMsgGroup pSViewMsgGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSViewMsgGroup, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSViewMsgGroup pSViewMsgGroup, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSViewMsgGroup, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSViewMsgGroup pSViewMsgGroup, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID")) {
            Object object;
            PSViewMsgGrpDetail pSViewMsgGrpDetail2;
            Object object2;
            Object object3;
            Object object4;
            PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSViewMsgGrpDetail> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSVIEWMSGGROUP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSVIEWMSGGRPDETAIL", (Object)pSViewMsgGroup.getPSViewMsgGroupId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSViewMsgGrpDetail2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSViewMsgGrpDetail2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSViewMsgGrpDetail>();
                object4 = pSViewMsgGrpDetailService.selectByPSViewMsgGroup(pSViewMsgGroup);
                object3 = StringHelper.format((String)"PSVIEWMSGGROUP#%1$s", (Object)pSViewMsgGroup.getPSViewMsgGroupId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSViewMsgGrpDetail2 = object2.next();
                    object = pSViewMsgGrpDetailService.getModelV2ResScope((IEntity)pSViewMsgGrpDetail2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSViewMsgGrpDetail)PSModelV2Helper.toJSONObject((IEntity)pSViewMsgGrpDetail2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSViewMsgGrpDetailService.getModelV2Name(false);
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
                        if (objectNode.has("psviewmsggrpdetailname")) {
                            string = objectNode.get("psviewmsggrpdetailname").asText();
                        }
                        if (objectNode2.has("psviewmsggrpdetailname")) {
                            string2 = objectNode2.get("psviewmsggrpdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSViewMsgGrpDetail pSViewMsgGrpDetail2 : arrayList) {
                    object = new PSViewMsgGrpDetail();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSViewMsgGrpDetail2, false);
                    object3.add((JsonNode)pSViewMsgGrpDetailService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSViewMsgGroup, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSViewMsgGrpDetail> arrayList = pSViewMsgGrpDetailService.selectByPSViewMsgGroup(pSViewMsgGroup);
        String string = StringHelper.format((String)"PSVIEWMSGGROUP#%1$s", (Object)pSViewMsgGroup.getPSViewMsgGroupId());
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            String string2 = pSViewMsgGrpDetailService.getModelV2ResScope((IEntity)pSViewMsgGrpDetail);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSViewMsgGrpDetailService.emptyModelV2(pSViewMsgGrpDetail);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSViewMsgGroup.getPSViewMsgGroupId());
        pSViewMsgGrpDetailService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSViewMsgGrpDetailService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSVIEWMSGGRPDETAIL WHERE PSVIEWMSGGROUPID = ?", sqlParamList);
        super.onEmptyModelV2(pSViewMsgGroup);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSViewMsgGrpDetailService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSViewMsgGroup pSViewMsgGroup, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSViewMsgGrpDetail pSViewMsgGrpDetail = new PSViewMsgGrpDetail();
        pSViewMsgGrpDetail.set("PSVIEWMSGGROUPID", pSViewMsgGroup.getPSViewMsgGroupId());
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSViewMsgGrpDetailService.getModelV2Entity(pSViewMsgGrpDetail, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSViewMsgGroup, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSViewMsgGroup pSViewMsgGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSViewMsgGrpDetailService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSViewMsgGrpDetail pSViewMsgGrpDetail = new PSViewMsgGrpDetail();
                pSViewMsgGrpDetail.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
                pSViewMsgGrpDetail.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
                pSViewMsgGrpDetailService.compileModelV2(pSViewMsgGrpDetail, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSViewMsgGrpDetail pSViewMsgGrpDetail = new PSViewMsgGrpDetail();
                    pSViewMsgGrpDetail.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
                    pSViewMsgGrpDetail.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
                    pSViewMsgGrpDetailService.compileModelV2(pSViewMsgGrpDetail, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSViewMsgGroup, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSViewMsgGroup pSViewMsgGroup, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSViewMsgGrpDetails(pSViewMsgGroup, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSViewMsgGroup, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSViewMsgGrpDetails(PSViewMsgGroup pSViewMsgGroup, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSVIEWMSGGRPDETAIL", true), (boolean)false) == 0) {
            PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            PSViewMsgGrpDetail pSViewMsgGrpDetail = new PSViewMsgGrpDetail();
            pSViewMsgGrpDetail.setPSViewMsgGrpDetailId(pSMOSFile.getPSModelId());
            if (!pSViewMsgGrpDetailService.get((IEntity)pSViewMsgGrpDetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSViewMsgGrpDetail.getPSViewMsgGroupId(), (String)pSViewMsgGroup.getPSViewMsgGroupId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSViewMsgGrpDetailService.exportModelV2(pSViewMsgGrpDetail);
            pSViewMsgGrpDetail.reset();
            if (!pSViewMsgGrpDetailService.setModelV2ResScope((IEntity)pSViewMsgGrpDetail, "PSVIEWMSGGROUP", pSViewMsgGroup.getPSViewMsgGroupId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSViewMsgGrpDetailService.importModelV2(pSViewMsgGrpDetail, objectNode);
            SessionFactoryManager.commit();
            return pSViewMsgGrpDetailService.getFile((IEntity)pSViewMsgGrpDetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSVIEWMSG", true), (boolean)false) == 0) {
            PSViewMsgService pSViewMsgService = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
            PSViewMsg pSViewMsg = new PSViewMsg();
            pSViewMsg.setPSViewMsgId(pSMOSFile.getPSModelId());
            if (!pSViewMsgService.get((IEntity)pSViewMsg, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            PSViewMsgGrpDetail pSViewMsgGrpDetail = new PSViewMsgGrpDetail();
            pSViewMsgGrpDetail.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
            pSViewMsgGrpDetail.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
            this.fillPasteEntity((IEntity)pSViewMsgGrpDetail, "PASTETAG");
            pSViewMsgGrpDetailService.create(pSViewMsgGrpDetail);
            SessionFactoryManager.commit();
            return pSViewMsgGrpDetailService.getFile((IEntity)pSViewMsgGrpDetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSViewMsgGroup pSViewMsgGroup, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSViewMsgGrpDetails(pSViewMsgGroup, list);
        super.onFillPasteHelps(pSViewMsgGroup, list);
    }

    protected void onFillPasteHelps_PSViewMsgGrpDetails(PSViewMsgGroup pSViewMsgGroup, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSVIEWMSGGRPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u89c6\u56fe\u6d88\u606f\u7ec4]\u7684[\u89c6\u56fe\u6d88\u606f\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSVIEWMSGGRPDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID");
        pSHelpSection.setUserTag("DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSG_PSVIEWMSGID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u7684[\u89c6\u56fe\u6d88\u606f]\u6784\u5efa[\u89c6\u56fe\u6d88\u606f\u7ec4\u6210\u5458]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7ec4\u6210\u5458>", "DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "PSVIEWMSGGROUPID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSViewMsgGroupServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7ec4\u6210\u5458>");
            } else if (PSViewMsgGroupServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psviewmsggrpdetails");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID|PSVIEWMSGGROUPID");
            pSMOSFile2.setFileTag3("PSVIEWMSGGRPDETAIL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "PSVIEWMSGGROUPID", pSMOSFile.getPSModelId(), "", "")) {
                PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSViewMsgGrpDetailService, "DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "PSVIEWMSGGROUPID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSViewMsgGrpDetailService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSViewMsgGroupServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSViewMsgGroupServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7ec4\u6210\u5458>", (boolean)false) == 0 || PSViewMsgGroupServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSViewMsgGrpDetails", (boolean)true) == 0) {
            PSViewMsgGrpDetailService pSViewMsgGrpDetailService = (PSViewMsgGrpDetailService)ServiceGlobal.getService(PSViewMsgGrpDetailService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSViewMsgGrpDetailService, "DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "PSVIEWMSGGROUPID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSViewMsgGrpDetailService.selectEx((ISelectContext)selectContext);
            for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList2) {
                PSMOSFile pSMOSFile2 = pSViewMsgGrpDetailService.getFile(pSMOSFile, (IEntity)pSViewMsgGrpDetail, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)false) == 0) {
            if (PSViewMsgGroupServiceBase.getMOSVer() == 1) {
                return "<\u7ec4\u6210\u5458>";
            }
            if (PSViewMsgGroupServiceBase.getMOSVer() == 2) {
                return "psviewmsggrpdetails";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSViewMsgGroup pSViewMsgGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "VMGroup");
        defaultValueMap.put("PSVIEWMSGGROUPNAME", "\u89c6\u56fe\u6d88\u606f\u7ec4");
    }
}

