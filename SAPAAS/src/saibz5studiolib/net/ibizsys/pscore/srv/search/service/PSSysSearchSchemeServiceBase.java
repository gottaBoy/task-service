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
package net.ibizsys.pscore.srv.search.service;

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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.dao.PSSysSearchSchemeDAO;
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchSchemeDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDEBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDocBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEServiceBase;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDocService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDocServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchSchemeServiceBase
extends PSCoreSysServiceBase<PSSysSearchScheme> {
    private static final Log log = LogFactory.getLog(PSSysSearchSchemeServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysSearchSchemeDEModel pSSysSearchSchemeDEModel;
    private PSSysSearchSchemeDAO pSSysSearchSchemeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService";
    }

    public PSSysSearchSchemeDEModel getPSSysSearchSchemeDEModel() {
        if (this.pSSysSearchSchemeDEModel == null) {
            try {
                this.pSSysSearchSchemeDEModel = (PSSysSearchSchemeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchSchemeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchSchemeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSearchSchemeDEModel();
    }

    public PSSysSearchSchemeDAO getPSSysSearchSchemeDAO() {
        if (this.pSSysSearchSchemeDAO == null) {
            try {
                this.pSSysSearchSchemeDAO = (PSSysSearchSchemeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.search.dao.PSSysSearchSchemeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchSchemeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSearchSchemeDAO();
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

    protected void onFillParentInfo(PSSysSearchScheme pSSysSearchScheme, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHSCHEME_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysSearchScheme, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHSCHEME_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysServiceAPI);
            } else {
                iService.get(pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysSearchScheme, pSSubSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHSCHEME_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysSearchScheme, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService", (SessionFactory)this.getSessionFactory());
            PSSysModelGroup pSSysModelGroup = (PSSysModelGroup)iService.getDEModel().createEntity();
            pSSysModelGroup.set("PSSYSMODELGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelGroup);
            } else {
                iService.get(pSSysModelGroup);
            }
            this.onFillParentInfo_PSSysModelGroup(pSSysSearchScheme, pSSysModelGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHSCHEME_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysServiceAPI);
            } else {
                iService.get(pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSSysSearchScheme, pSSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHSCHEME_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysSearchScheme, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHSCHEME_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysSearchScheme, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysSearchScheme, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysSearchScheme pSSysSearchScheme, PSModule pSModule) throws Exception {
        pSSysSearchScheme.setPSModuleId(pSModule.getPSModuleId());
        pSSysSearchScheme.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSSysSearchScheme pSSysSearchScheme, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSSysSearchScheme.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSSysSearchScheme.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysSearchScheme pSSysSearchScheme, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysSearchScheme.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysSearchScheme.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysModelGroup(PSSysSearchScheme pSSysSearchScheme, PSSysModelGroup pSSysModelGroup) throws Exception {
        pSSysSearchScheme.setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
        pSSysSearchScheme.setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSSysSearchScheme pSSysSearchScheme, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSSysSearchScheme.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSSysSearchScheme.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysSearchScheme pSSysSearchScheme, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysSearchScheme.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysSearchScheme.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysSearchScheme pSSysSearchScheme, PSSystem pSSystem) throws Exception {
        pSSysSearchScheme.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSearchScheme.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
        if (bl) {
            if (pSSysSearchScheme.getCodeName() == null) {
                pSSysSearchScheme.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "SearchScheme", 25));
            }
            if (pSSysSearchScheme.getPSSysSearchSchemeName() == null) {
                pSSysSearchScheme.setPSSysSearchSchemeName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5168\u6587\u68c0\u7d22", 25));
            }
        }
        super.onFillEntityFullInfo(pSSysSearchScheme, bl);
        this.onFillEntityFullInfo_PSModule(pSSysSearchScheme, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSSysSearchScheme, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysSearchScheme, bl);
        this.onFillEntityFullInfo_PSSysModelGroup(pSSysSearchScheme, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSSysSearchScheme, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysSearchScheme, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysSearchScheme, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelGroup(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
        if (pSSysSearchScheme.isPSSystemIdDirty()) {
            if (pSSysSearchScheme.getPSSystemId() != null) {
                if (pSSysSearchScheme.getPSSystemId() == null || pSSysSearchScheme.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysSearchScheme.getPSSystem();
                    pSSysSearchScheme.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysSearchScheme.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysSearchScheme, bl);
    }

    public ArrayList<PSSysSearchScheme> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchScheme> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchScheme> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchScheme> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase) throws Exception {
        return this.selectByPSSysModelGroup(pSSysModelGroupBase, "", -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase, String string) throws Exception {
        return this.selectByPSSysModelGroup(pSSysModelGroupBase, string, -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELGROUPID", (Object)pSSysModelGroupBase.getPSSysModelGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSERVICEAPIID", (Object)pSSysServiceAPIBase.getPSSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchScheme> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysSearchScheme> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHSCHEME_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSSEARCHSCHEME", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSModule(pSModule);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            PSSysSearchScheme pSSysSearchScheme2 = (PSSysSearchScheme)this.getDEModel().createEntity();
            pSSysSearchScheme2.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
            pSSysSearchScheme2.setPSModuleId(null);
            this.update(pSSysSearchScheme2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchSchemeServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysSearchSchemeServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysSearchSchemeServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            this.remove(pSSysSearchScheme);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHSCHEME_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSYSSEARCHSCHEME", iDataEntityModel.getDataInfo(pSSubSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            PSSysSearchScheme pSSysSearchScheme2 = (PSSysSearchScheme)this.getDEModel().createEntity();
            pSSysSearchScheme2.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
            pSSysSearchScheme2.setPSSubSysServiceAPIId(null);
            this.update(pSSysSearchScheme2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchSchemeServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysSearchSchemeServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysSearchSchemeServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            this.remove(pSSysSearchScheme);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHSCHEME_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSSEARCHSCHEME", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            PSSysSearchScheme pSSysSearchScheme2 = (PSSysSearchScheme)this.getDEModel().createEntity();
            pSSysSearchScheme2.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
            pSSysSearchScheme2.setPSSysDynaModelId(null);
            this.update(pSSysSearchScheme2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchSchemeServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSearchSchemeServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSearchSchemeServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            this.remove(pSSysSearchScheme);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysModelGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", "", iDataEntityModel.getName(), "PSSYSSEARCHSCHEME", iDataEntityModel.getDataInfo(pSSysModelGroup), arrayList.get(0)));
        }
    }

    public void resetPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            PSSysSearchScheme pSSysSearchScheme2 = (PSSysSearchScheme)this.getDEModel().createEntity();
            pSSysSearchScheme2.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
            pSSysSearchScheme2.setPSSysModelGroupId(null);
            this.update(pSSysSearchScheme2);
        }
    }

    public void removeByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        final PSSysModelGroup pSSysModelGroup2 = pSSysModelGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchSchemeServiceBase.this.onBeforeRemoveByPSSysModelGroup(pSSysModelGroup2);
                PSSysSearchSchemeServiceBase.this.internalRemoveByPSSysModelGroup(pSSysModelGroup2);
                PSSysSearchSchemeServiceBase.this.onAfterRemoveByPSSysModelGroup(pSSysModelGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
    }

    protected void internalRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup);
        this.onBeforeRemoveByPSSysModelGroup(pSSysModelGroup, arrayList);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            this.remove(pSSysSearchScheme);
        }
        this.onAfterRemoveByPSSysModelGroup(pSSysModelGroup, arrayList);
    }

    protected void onAfterRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHSCHEME_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSYSSEARCHSCHEME", iDataEntityModel.getDataInfo(pSSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            PSSysSearchScheme pSSysSearchScheme2 = (PSSysSearchScheme)this.getDEModel().createEntity();
            pSSysSearchScheme2.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
            pSSysSearchScheme2.setPSSysServiceAPIId(null);
            this.update(pSSysSearchScheme2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchSchemeServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysSearchSchemeServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysSearchSchemeServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            this.remove(pSSysSearchScheme);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHSCHEME_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSSEARCHSCHEME", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            PSSysSearchScheme pSSysSearchScheme2 = (PSSysSearchScheme)this.getDEModel().createEntity();
            pSSysSearchScheme2.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
            pSSysSearchScheme2.setPSSysSFPluginId(null);
            this.update(pSSysSearchScheme2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchSchemeServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysSearchSchemeServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysSearchSchemeServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            this.remove(pSSysSearchScheme);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHSCHEME_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSSEARCHSCHEME", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            PSSysSearchScheme pSSysSearchScheme2 = (PSSysSearchScheme)this.getDEModel().createEntity();
            pSSysSearchScheme2.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
            pSSysSearchScheme2.setPSSystemId(null);
            this.update(pSSysSearchScheme2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchSchemeServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysSearchSchemeServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysSearchSchemeServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSearchScheme> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysSearchScheme pSSysSearchScheme : arrayList) {
            this.remove(pSSysSearchScheme);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSearchScheme> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchScheme(pSSysSearchScheme);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchScheme(pSSysSearchScheme);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSysSearchScheme(pSSysSearchScheme);
        pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchScheme(pSSysSearchScheme);
        pSCoreSysServiceBase = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchDocServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchScheme(pSSysSearchScheme);
        super.onBeforeRemove(pSSysSearchScheme);
    }

    protected void replaceParentInfo(PSSysSearchScheme pSSysSearchScheme, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysSearchScheme, cloneSession);
        if (pSSysSearchScheme.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysSearchScheme.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysSearchScheme, (PSModule)iEntity);
        }
        if (pSSysSearchScheme.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSSysSearchScheme.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysSearchScheme, (PSSubSysServiceAPI)iEntity);
        }
        if (pSSysSearchScheme.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysSearchScheme.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysSearchScheme, (PSSysDynaModel)iEntity);
        }
        if (pSSysSearchScheme.getPSSysModelGroupId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELGROUP", (Object)pSSysSearchScheme.getPSSysModelGroupId())) != null) {
            this.onFillParentInfo_PSSysModelGroup(pSSysSearchScheme, (PSSysModelGroup)iEntity);
        }
        if (pSSysSearchScheme.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSSysSearchScheme.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSSysSearchScheme, (PSSysServiceAPI)iEntity);
        }
        if (pSSysSearchScheme.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysSearchScheme.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysSearchScheme, (PSSysSFPlugin)iEntity);
        }
        if (pSSysSearchScheme.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysSearchScheme.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysSearchScheme, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysSearchScheme, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AuthClientId(bl, pSSysSearchScheme, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientSecret(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthMode(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam2(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocReplicas(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocShards(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableServiceAPI(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSubSysServiceAPI(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjNameCase(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelGroupId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchSchemeId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchSchemeName(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SchemeParams(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SchemeTag(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SchemeTag2(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEngineType(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam2(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServicePath(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubSysServiceCodeName(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSearchScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysSearchScheme, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AuthClientId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isAuthClientIdDirty() : !pSSysSearchScheme.isAuthClientIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getAuthClientId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientId_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientSecret(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isAuthClientSecretDirty() : !pSSysSearchScheme.isAuthClientSecretDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getAuthClientSecret();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientSecret_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCLIENTSECRET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthMode(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isAuthModeDirty() : !pSSysSearchScheme.isAuthModeDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getAuthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthMode_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthParam(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isAuthParamDirty() : !pSSysSearchScheme.isAuthParamDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getAuthParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthParam2(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isAuthParam2Dirty() : !pSSysSearchScheme.isAuthParam2Dirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getAuthParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam2_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isCodeNameDirty() && !bl2 : !pSSysSearchScheme.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysSearchScheme, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysSearchSchemeDEModel(), "CODENAME", string3, pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isCodeName2Dirty() : !pSSysSearchScheme.isCodeName2Dirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
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
                String string4 = this.checkFieldDupRule(this.getPSSysSearchSchemeDEModel(), "CODENAME2", string3, pSSysSearchScheme, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocReplicas(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isDocReplicasDirty() : !pSSysSearchScheme.isDocReplicasDirty()) {
            return null;
        }
        Integer n = pSSysSearchScheme.getDocReplicas();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DocReplicas_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCREPLICAS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocShards(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isDocShardsDirty() : !pSSysSearchScheme.isDocShardsDirty()) {
            return null;
        }
        Integer n = pSSysSearchScheme.getDocShards();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DocShards_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCSHARDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableServiceAPI(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isEnableServiceAPIDirty() : !pSSysSearchScheme.isEnableServiceAPIDirty()) {
            return null;
        }
        Integer n = pSSysSearchScheme.getEnableServiceAPI();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableServiceAPI_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESERVICEAPI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSubSysServiceAPI(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isEnableSubSysServiceAPIDirty() : !pSSysSearchScheme.isEnableSubSysServiceAPIDirty()) {
            return null;
        }
        Integer n = pSSysSearchScheme.getEnableSubSysServiceAPI();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSubSysServiceAPI_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESUBSYSSERVICEAPI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isMemoDirty() : !pSSysSearchScheme.isMemoDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_ObjNameCase(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isObjNameCaseDirty() : !pSSysSearchScheme.isObjNameCaseDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getObjNameCase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjNameCase_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJNAMECASE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isOrderValueDirty() : !pSSysSearchScheme.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysSearchScheme.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSModuleIdDirty() : !pSSysSearchScheme.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSubSysServiceAPIIdDirty() : !pSSysSearchScheme.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSysDynaModelIdDirty() : !pSSysSearchScheme.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelGroupId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSysModelGroupIdDirty() : !pSSysSearchScheme.isPSSysModelGroupIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSysModelGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelGroupId_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchSchemeId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSysSearchSchemeIdDirty() && !bl2 : !pSSysSearchScheme.isPSSysSearchSchemeIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSysSearchSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchSchemeId_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSearchSchemeName(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSysSearchSchemeNameDirty() && !bl2 : !pSSysSearchScheme.isPSSysSearchSchemeNameDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSysSearchSchemeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchSchemeName_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysSearchSchemeDEModel(), "PSSYSSEARCHSCHEMENAME", string3, pSSysSearchScheme, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSEARCHSCHEMENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSysServiceAPIIdDirty() : !pSSysSearchScheme.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSysSFPluginIdDirty() : !pSSysSearchScheme.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSystemIdDirty() : !pSSysSearchScheme.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isPSSystemNameDirty() : !pSSysSearchScheme.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_SchemeParams(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isSchemeParamsDirty() : !pSSysSearchScheme.isSchemeParamsDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getSchemeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SchemeParams_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SCHEMEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SchemeTag(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isSchemeTagDirty() : !pSSysSearchScheme.isSchemeTagDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getSchemeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SchemeTag_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SCHEMETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SchemeTag2(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isSchemeTag2Dirty() : !pSSysSearchScheme.isSchemeTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getSchemeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SchemeTag2_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SCHEMETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchEngineType(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isSearchEngineTypeDirty() && !bl2 : !pSSysSearchScheme.isSearchEngineTypeDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getSearchEngineType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHENGINETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchEngineType_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHENGINETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isServiceCodeNameDirty() : !pSSysSearchScheme.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isServiceParamDirty() : !pSSysSearchScheme.isServiceParamDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getServiceParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceParam2(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isServiceParam2Dirty() : !pSSysSearchScheme.isServiceParam2Dirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getServiceParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam2_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServicePath(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isServicePathDirty() : !pSSysSearchScheme.isServicePathDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getServicePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServicePath_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubSysServiceCodeName(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isSubSysServiceCodeNameDirty() : !pSSysSearchScheme.isSubSysServiceCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getSubSysServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubSysServiceCodeName_Default(pSSysSearchScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBSYSSERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isUserCatDirty() : !pSSysSearchScheme.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isUserTagDirty() : !pSSysSearchScheme.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isUserTag2Dirty() : !pSSysSearchScheme.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isUserTag3Dirty() : !pSSysSearchScheme.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysSearchScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSearchScheme pSSysSearchScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchScheme.isUserTag4Dirty() : !pSSysSearchScheme.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSearchScheme.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysSearchScheme, bl2, bl3);
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

    protected void onSyncEntity(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
        super.onSyncEntity(pSSysSearchScheme, bl);
    }

    protected void onSyncIndexEntities(PSSysSearchScheme pSSysSearchScheme, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysSearchScheme, bl);
    }

    public Object getDataContextValue(PSSysSearchScheme pSSysSearchScheme, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysSearchScheme, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSearchScheme pSSysSearchScheme, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysSearchScheme, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTSECRET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientSecret_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCREPLICAS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocReplicas_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCSHARDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocShards_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESERVICEAPI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableServiceAPI_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESUBSYSSERVICEAPI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSubSysServiceAPI_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJNAMECASE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjNameCase_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SCHEMEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SchemeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SCHEMETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SchemeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SCHEMETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SchemeTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHENGINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchEngineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServicePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBSYSSERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubSysServiceCodeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AuthClientId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthClientSecret_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCLIENTSECRET", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
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

    protected String onTestValueRule_DocReplicas_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DocShards_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableServiceAPI_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSubSysServiceAPI_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ObjNameCase_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJNAMECASE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysModelGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SchemeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SCHEMEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SchemeTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SCHEMETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SchemeTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SCHEMETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchEngineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHENGINETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_ServiceParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServicePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubSysServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBSYSSERVICECODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSearchScheme pSSysSearchScheme) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysSearchScheme)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        super.onUpdateParent(pSSysSearchScheme);
    }

    @Override
    protected void exportCurXmlModel(PSSysSearchScheme pSSysSearchScheme, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSEARCHSCHEME");
        if (!bl) {
            pSSysSearchScheme.setCreateDate(null);
            pSSysSearchScheme.setCreateMan(null);
            pSSysSearchScheme.setPSSysSearchSchemeId(null);
            pSSysSearchScheme.setUpdateDate(null);
            pSSysSearchScheme.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSearchScheme, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSearchScheme pSSysSearchScheme, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSearchScheme, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSMODELGROUP#%1$s", (Object)string);
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
            return "DER1N_PSSYSSEARCHSCHEME_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHSCHEME_PSSYSTEM_PSSYSTEMID";
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPNAME", null);
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
        if (StringHelper.compare((String)string, (String)"PSSYSMODELGROUP", (boolean)true) == 0) {
            iEntity.set("PSSYSMODELGROUPID", (Object)string2);
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
        return new String[]{"PSMODULEID", "PSSYSMODELGROUPID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysSearchScheme pSSysSearchScheme) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchScheme.getCodeName())) {
            return pSSysSearchScheme.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchScheme.getPSSysSearchSchemeName())) {
            return pSSysSearchScheme.getPSSysSearchSchemeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchScheme.getCodeName())) {
            return pSSysSearchScheme.getCodeName();
        }
        return super.getModelV2Tag(pSSysSearchScheme);
    }

    @Override
    public boolean setModelV2Tag(PSSysSearchScheme pSSysSearchScheme, String string) {
        pSSysSearchScheme.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSSEARCHSCHEMENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSMODELGROUPID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSearchScheme pSSysSearchScheme, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSearchScheme.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSearchScheme, true);
        pSSysSearchScheme.set("CODENAME", string);
        if (this.select(pSSysSearchScheme, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSearchScheme, true);
        return super.getModelV2Entity(pSSysSearchScheme, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSearchScheme pSSysSearchScheme, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSearchScheme, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysSearchScheme pSSysSearchScheme, String string, String string2) throws Exception {
        String string3;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHSCHEME#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSEARCHDOC", (Object)pSSysSearchScheme.getPSSysSearchSchemeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
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
                PSSysSearchDoc searchDoc = new PSSysSearchDoc();
                PSModelV2Helper.fromJSONObject(searchDoc, objectNode, false);
                string3 = ((PSSysSearchDocServiceBase)pSCoreSysServiceBase).getModelV2Tag(searchDoc);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSEARCHDOC", (Object)searchDoc.getPSSysSearchDocId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(searchDoc, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHSCHEME#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSSEARCHDE", (Object)pSSysSearchScheme.getPSSysSearchSchemeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
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
                PSSysSearchDE searchDE = new PSSysSearchDE();
                PSModelV2Helper.fromJSONObject(searchDE, objectNode, false);
                string3 = ((PSSysSearchDEServiceBase)pSCoreSysServiceBase).getModelV2Tag(searchDE);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSSEARCHDE", (Object)searchDE.getPSSysSearchDEId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(searchDE, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysSearchScheme, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysSearchScheme pSSysSearchScheme, ObjectNode objectNode, String string, boolean bl) throws Exception {
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID")) {
            PSSysSearchDocService searchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> searchDocs = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHSCHEME#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSEARCHDOC", (Object)pSSysSearchScheme.getPSSysSearchSchemeId()));
                if (file.exists()) {
                    searchDocs = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        searchDocs.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                searchDocs = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSSEARCHSCHEME#%1$s", (Object)pSSysSearchScheme.getPSSysSearchSchemeId());
                for (PSSysSearchDoc searchDoc : searchDocService.selectByPSSysSearchScheme(pSSysSearchScheme)) {
                    if (StringHelper.compare(scope, searchDocService.getModelV2ResScope(searchDoc), false) != 0) continue;
                    searchDocs.add(PSModelV2Helper.toJSONObject(searchDoc, false));
                }
            }
            if (searchDocs != null && !searchDocs.isEmpty()) {
                ArrayNode docs = objectNode.putArray(searchDocService.getModelV2Name(false).toLowerCase());
                Collections.sort(searchDocs, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssyssearchdocname")) {
                            string = objectNode.get("pssyssearchdocname").asText();
                        }
                        if (objectNode2.has("pssyssearchdocname")) {
                            string2 = objectNode2.get("pssyssearchdocname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode docNode : searchDocs) {
                    PSSysSearchDoc searchDoc = new PSSysSearchDoc();
                    PSModelV2Helper.fromJSONObject(searchDoc, docNode, false);
                    docs.add(searchDocService.exportModelV2(searchDoc, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID")) {
            PSSysSearchDEService searchDEService = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> searchDEs = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHSCHEME#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSEARCHDE", (Object)pSSysSearchScheme.getPSSysSearchSchemeId()));
                if (file.exists()) {
                    searchDEs = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        searchDEs.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                searchDEs = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSSEARCHSCHEME#%1$s", (Object)pSSysSearchScheme.getPSSysSearchSchemeId());
                for (PSSysSearchDE searchDE : searchDEService.selectByPSSysSearchScheme(pSSysSearchScheme)) {
                    if (StringHelper.compare(scope, searchDEService.getModelV2ResScope(searchDE), false) != 0) continue;
                    searchDEs.add(PSModelV2Helper.toJSONObject(searchDE, false));
                }
            }
            if (searchDEs != null && !searchDEs.isEmpty()) {
                ArrayNode des = objectNode.putArray(searchDEService.getModelV2Name(false).toLowerCase());
                Collections.sort(searchDEs, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssyssearchdename")) {
                            string = objectNode.get("pssyssearchdename").asText();
                        }
                        if (objectNode2.has("pssyssearchdename")) {
                            string2 = objectNode2.get("pssyssearchdename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode deNode : searchDEs) {
                    PSSysSearchDE searchDE = new PSSysSearchDE();
                    PSModelV2Helper.fromJSONObject(searchDE, deNode, false);
                    des.add(searchDEService.exportModelV2(searchDE, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysSearchScheme, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        super.onEmptyModelV2(pSSysSearchScheme);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysSearchScheme pSSysSearchScheme, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysSearchDoc();
        entityBase.set("PSSYSSEARCHSCHEMEID", pSSysSearchScheme.getPSSysSearchSchemeId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysSearchDE();
        entityBase.set("PSSYSSEARCHSCHEMEID", pSSysSearchScheme.getPSSysSearchSchemeId());
        pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysSearchScheme, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysSearchScheme pSSysSearchScheme, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysSearchSchemeServiceBase.isSimpleImportExportMode("")) {
            PSSysSearchDocService searchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
            String modelName = searchDocService.getModelV2Name(null, false);
            ArrayNode arrayNode = null;
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int index = 0; index < arrayNode.size(); ++index) {
                    PSSysSearchDoc searchDoc = new PSSysSearchDoc();
                    searchDoc.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
                    searchDoc.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
                    searchDocService.compileModelV2(searchDoc, (ObjectNode)arrayNode.get(index), string, null, n);
                }
            } else {
                File folder = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (folder.exists()) {
                    File[] files = folder.listFiles();
                    if (files == null) {
                        throw new Exception("Unable to list model directory: " + folder);
                    }
                    for (File file : files) {
                        if (!file.isDirectory()) continue;
                        PSSysSearchDoc searchDoc = new PSSysSearchDoc();
                        searchDoc.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
                        searchDoc.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
                        searchDocService.compileModelV2(searchDoc, null, string, file.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysSearchSchemeServiceBase.isSimpleImportExportMode("")) {
            PSSysSearchDEService searchDEService = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
            String modelName = searchDEService.getModelV2Name(null, false);
            ArrayNode arrayNode = null;
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int index = 0; index < arrayNode.size(); ++index) {
                    PSSysSearchDE searchDE = new PSSysSearchDE();
                    searchDE.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
                    searchDE.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
                    searchDEService.compileModelV2(searchDE, (ObjectNode)arrayNode.get(index), string, null, n);
                }
            } else {
                File folder = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (folder.exists()) {
                    File[] files = folder.listFiles();
                    if (files == null) {
                        throw new Exception("Unable to list model directory: " + folder);
                    }
                    for (File file : files) {
                        if (!file.isDirectory()) continue;
                        PSSysSearchDE searchDE = new PSSysSearchDE();
                        searchDE.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
                        searchDE.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
                        searchDEService.compileModelV2(searchDE, null, string, file.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysSearchScheme, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysSearchScheme pSSysSearchScheme, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSearchDocs(pSSysSearchScheme, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSearchDEs(pSSysSearchScheme, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysSearchScheme, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysSearchDocs(PSSysSearchScheme pSSysSearchScheme, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSEARCHDOC", true), (boolean)false) == 0) {
            PSSysSearchDocService pSSysSearchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
            PSSysSearchDoc pSSysSearchDoc = new PSSysSearchDoc();
            pSSysSearchDoc.setPSSysSearchDocId(pSMOSFile.getPSModelId());
            if (!pSSysSearchDocService.get(pSSysSearchDoc, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSearchDoc.getPSSysSearchSchemeId(), (String)pSSysSearchScheme.getPSSysSearchSchemeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSearchDocService.exportModelV2(pSSysSearchDoc);
            pSSysSearchDoc.reset();
            if (!pSSysSearchDocService.setModelV2ResScope(pSSysSearchDoc, "PSSYSSEARCHSCHEME", pSSysSearchScheme.getPSSysSearchSchemeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSearchDocService.importModelV2(pSSysSearchDoc, objectNode);
            SessionFactoryManager.commit();
            return pSSysSearchDocService.getFile(pSSysSearchDoc);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysSearchDEs(PSSysSearchScheme pSSysSearchScheme, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSEARCHDE", true), (boolean)false) == 0) {
            PSSysSearchDEService pSSysSearchDEService = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
            PSSysSearchDE pSSysSearchDE = new PSSysSearchDE();
            pSSysSearchDE.setPSSysSearchDEId(pSMOSFile.getPSModelId());
            if (!pSSysSearchDEService.get(pSSysSearchDE, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSearchDE.getPSSysSearchSchemeId(), (String)pSSysSearchScheme.getPSSysSearchSchemeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSearchDEService.exportModelV2(pSSysSearchDE);
            pSSysSearchDE.reset();
            if (!pSSysSearchDEService.setModelV2ResScope(pSSysSearchDE, "PSSYSSEARCHSCHEME", pSSysSearchScheme.getPSSysSearchSchemeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSearchDEService.importModelV2(pSSysSearchDE, objectNode);
            SessionFactoryManager.commit();
            return pSSysSearchDEService.getFile(pSSysSearchDE);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysSearchScheme pSSysSearchScheme, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysSearchDocs(pSSysSearchScheme, list);
        this.onFillPasteHelps_PSSysSearchDEs(pSSysSearchScheme, list);
        super.onFillPasteHelps(pSSysSearchScheme, list);
    }

    protected void onFillPasteHelps_PSSysSearchDocs(PSSysSearchScheme pSSysSearchScheme, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSEARCHDOC");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5168\u6587\u68c0\u7d22\u4f53\u7cfb]\u7684[\u5168\u6587\u68c0\u7d22\u6587\u6863]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysSearchDEs(PSSysSearchScheme pSSysSearchScheme, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSEARCHDE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5168\u6587\u68c0\u7d22\u4f53\u7cfb]\u7684[\u5168\u6587\u68c0\u7d22\u5b9e\u4f53]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u68c0\u7d22\u6587\u6863>", "DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u68c0\u7d22\u6587\u6863>");
            } else if (PSSysSearchSchemeServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssearchdocs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID|PSSYSSEARCHSCHEMEID");
            pSMOSFile2.setFileTag3("PSSYSSEARCHDOC");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u68c0\u7d22\u5b9e\u4f53>", "DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u68c0\u7d22\u5b9e\u4f53>");
            } else if (PSSysSearchSchemeServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssyssearchdes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID|PSSYSSEARCHSCHEMEID");
            pSMOSFile2.setFileTag3("PSSYSSEARCHDE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<? extends IEntity> arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSSysSearchSchemeServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u68c0\u7d22\u6587\u6863>", (boolean)false) == 0 || PSSysSearchSchemeServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysSearchDocs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (IEntity entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysSearchSchemeServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u68c0\u7d22\u5b9e\u4f53>", (boolean)false) == 0 || PSSysSearchSchemeServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysSearchDEs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", "PSSYSSEARCHSCHEMEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (IEntity entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDOC_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)false) == 0) {
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 1) {
                return "<\u68c0\u7d22\u6587\u6863>";
            }
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 2) {
                return "pssyssearchdocs";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHDE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)false) == 0) {
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 1) {
                return "<\u68c0\u7d22\u5b9e\u4f53>";
            }
            if (PSSysSearchSchemeServiceBase.getMOSVer() == 2) {
                return "pssyssearchdes";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysSearchScheme pSSysSearchScheme, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "SearchScheme");
        defaultValueMap.put("PSSYSSEARCHSCHEMENAME", "\u5168\u6587\u68c0\u7d22");
    }
}
