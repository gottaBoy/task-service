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
package net.ibizsys.pscore.srv.bdscheme.service;

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
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDSchemeDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDSchemeDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModule;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModuleBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPart;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPartBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableRS;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableRSBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDModuleService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDModuleServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
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

public abstract class PSSysBDSchemeServiceBase
extends PSCoreSysServiceBase<PSSysBDScheme> {
    private static final Log log = LogFactory.getLog(PSSysBDSchemeServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBDSchemeDEModel pSSysBDSchemeDEModel;
    private PSSysBDSchemeDAO pSSysBDSchemeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService";
    }

    public PSSysBDSchemeDEModel getPSSysBDSchemeDEModel() {
        if (this.pSSysBDSchemeDEModel == null) {
            try {
                this.pSSysBDSchemeDEModel = (PSSysBDSchemeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDSchemeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDSchemeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDSchemeDEModel();
    }

    public PSSysBDSchemeDAO getPSSysBDSchemeDAO() {
        if (this.pSSysBDSchemeDAO == null) {
            try {
                this.pSSysBDSchemeDAO = (PSSysBDSchemeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDSchemeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDSchemeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDSchemeDAO();
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

    protected void onFillParentInfo(PSSysBDScheme pSSysBDScheme, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDSCHEME_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysBDScheme, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDSCHEME_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysServiceAPI);
            } else {
                iService.get((IEntity)pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysBDScheme, pSSubSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDSCHEME_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysBDScheme, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService", (SessionFactory)this.getSessionFactory());
            PSSysModelGroup pSSysModelGroup = (PSSysModelGroup)iService.getDEModel().createEntity();
            pSSysModelGroup.set("PSSYSMODELGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelGroup);
            } else {
                iService.get((IEntity)pSSysModelGroup);
            }
            this.onFillParentInfo_PSSysModelGroup(pSSysBDScheme, pSSysModelGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDSCHEME_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysServiceAPI);
            } else {
                iService.get((IEntity)pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSSysBDScheme, pSSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDSCHEME_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysBDScheme, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDSCHEME_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysBDScheme, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysBDScheme, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysBDScheme pSSysBDScheme, PSModule pSModule) throws Exception {
        pSSysBDScheme.setPSModuleId(pSModule.getPSModuleId());
        pSSysBDScheme.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSSysBDScheme pSSysBDScheme, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSSysBDScheme.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSSysBDScheme.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysBDScheme pSSysBDScheme, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysBDScheme.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysBDScheme.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysModelGroup(PSSysBDScheme pSSysBDScheme, PSSysModelGroup pSSysModelGroup) throws Exception {
        pSSysBDScheme.setPSSysModelGroupId(pSSysModelGroup.getPSSysModelGroupId());
        pSSysBDScheme.setPSSysModelGroupName(pSSysModelGroup.getPSSysModelGroupName());
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSSysBDScheme pSSysBDScheme, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSSysBDScheme.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSSysBDScheme.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysBDScheme pSSysBDScheme, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysBDScheme.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysBDScheme.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysBDScheme pSSysBDScheme, PSSystem pSSystem) throws Exception {
        pSSysBDScheme.setPSSystemId(pSSystem.getPSSystemId());
        pSSysBDScheme.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBDScheme.getDefaultFlag() == null) {
                pSSysBDScheme.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysBDScheme.getModelVer() == null) {
                pSSysBDScheme.setModelVer((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysBDScheme.getPSSysBDPartsCnt() == null) {
                pSSysBDScheme.setPSSysBDPartsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysBDScheme.getPSSysBDTablesCnt() == null) {
                pSSysBDScheme.setPSSysBDTablesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysBDScheme, bl);
        this.onFillEntityFullInfo_PSModule(pSSysBDScheme, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSSysBDScheme, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysBDScheme, bl);
        this.onFillEntityFullInfo_PSSysModelGroup(pSSysBDScheme, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSSysBDScheme, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysBDScheme, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysBDScheme, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelGroup(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
        if (pSSysBDScheme.isPSSystemIdDirty()) {
            if (pSSysBDScheme.getPSSystemId() != null) {
                if (pSSysBDScheme.getPSSystemId() == null || pSSysBDScheme.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysBDScheme.getPSSystem();
                    pSSysBDScheme.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysBDScheme.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBDScheme, bl);
    }

    public ArrayList<PSSysBDScheme> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDScheme> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDScheme> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDScheme> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase) throws Exception {
        return this.selectByPSSysModelGroup(pSSysModelGroupBase, "", -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase, String string) throws Exception {
        return this.selectByPSSysModelGroup(pSSysModelGroupBase, string, -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysModelGroup(PSSysModelGroupBase pSSysModelGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDScheme> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDScheme> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDScheme> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysBDScheme> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDSCHEME_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSBDSCHEME", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSModule(pSModule);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            PSSysBDScheme pSSysBDScheme2 = (PSSysBDScheme)this.getDEModel().createEntity();
            pSSysBDScheme2.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
            pSSysBDScheme2.setPSModuleId(null);
            this.update(pSSysBDScheme2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDSchemeServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysBDSchemeServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysBDSchemeServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            this.remove(pSSysBDScheme);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDSCHEME_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSYSBDSCHEME", iDataEntityModel.getDataInfo((IEntity)pSSubSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            PSSysBDScheme pSSysBDScheme2 = (PSSysBDScheme)this.getDEModel().createEntity();
            pSSysBDScheme2.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
            pSSysBDScheme2.setPSSubSysServiceAPIId(null);
            this.update(pSSysBDScheme2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDSchemeServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysBDSchemeServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysBDSchemeServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            this.remove(pSSysBDScheme);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDSCHEME_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSBDSCHEME", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            PSSysBDScheme pSSysBDScheme2 = (PSSysBDScheme)this.getDEModel().createEntity();
            pSSysBDScheme2.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
            pSSysBDScheme2.setPSSysDynaModelId(null);
            this.update(pSSysBDScheme2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDSchemeServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysBDSchemeServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysBDSchemeServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            this.remove(pSSysBDScheme);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID", "", iDataEntityModel.getName(), "PSSYSBDSCHEME", iDataEntityModel.getDataInfo((IEntity)pSSysModelGroup), arrayList.get(0)));
        }
    }

    public void resetPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            PSSysBDScheme pSSysBDScheme2 = (PSSysBDScheme)this.getDEModel().createEntity();
            pSSysBDScheme2.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
            pSSysBDScheme2.setPSSysModelGroupId(null);
            this.update(pSSysBDScheme2);
        }
    }

    public void removeByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        final PSSysModelGroup pSSysModelGroup2 = pSSysModelGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDSchemeServiceBase.this.onBeforeRemoveByPSSysModelGroup(pSSysModelGroup2);
                PSSysBDSchemeServiceBase.this.internalRemoveByPSSysModelGroup(pSSysModelGroup2);
                PSSysBDSchemeServiceBase.this.onAfterRemoveByPSSysModelGroup(pSSysModelGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
    }

    protected void internalRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysModelGroup(pSSysModelGroup);
        this.onBeforeRemoveByPSSysModelGroup(pSSysModelGroup, arrayList);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            this.remove(pSSysBDScheme);
        }
        this.onAfterRemoveByPSSysModelGroup(pSSysModelGroup, arrayList);
    }

    protected void onAfterRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelGroup(PSSysModelGroup pSSysModelGroup, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDSCHEME_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSYSBDSCHEME", iDataEntityModel.getDataInfo((IEntity)pSSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            PSSysBDScheme pSSysBDScheme2 = (PSSysBDScheme)this.getDEModel().createEntity();
            pSSysBDScheme2.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
            pSSysBDScheme2.setPSSysServiceAPIId(null);
            this.update(pSSysBDScheme2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDSchemeServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysBDSchemeServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysBDSchemeServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            this.remove(pSSysBDScheme);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDSCHEME_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSBDSCHEME", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            PSSysBDScheme pSSysBDScheme2 = (PSSysBDScheme)this.getDEModel().createEntity();
            pSSysBDScheme2.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
            pSSysBDScheme2.setPSSysSFPluginId(null);
            this.update(pSSysBDScheme2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDSchemeServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBDSchemeServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysBDSchemeServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            this.remove(pSSysBDScheme);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            PSSysBDScheme pSSysBDScheme2 = (PSSysBDScheme)this.getDEModel().createEntity();
            pSSysBDScheme2.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
            pSSysBDScheme2.setPSSystemId(null);
            this.update(pSSysBDScheme2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDSchemeServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysBDSchemeServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysBDSchemeServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysBDScheme> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysBDScheme pSSysBDScheme : arrayList) {
            this.remove(pSSysBDScheme);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysBDScheme> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDScheme pSSysBDScheme) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDScheme(pSSysBDScheme);
        pSCoreSysServiceBase = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDScheme(pSSysBDScheme);
        pSCoreSysServiceBase = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDPartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDScheme(pSSysBDScheme);
        pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableRSServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDScheme(pSSysBDScheme);
        pSCoreSysServiceBase = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDScheme(pSSysBDScheme);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDScheme(pSSysBDScheme);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSysBDScheme(pSSysBDScheme);
        super.onBeforeRemove(pSSysBDScheme);
    }

    protected void replaceParentInfo(PSSysBDScheme pSSysBDScheme, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBDScheme, cloneSession);
        if (pSSysBDScheme.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysBDScheme.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysBDScheme, (PSModule)iEntity);
        }
        if (pSSysBDScheme.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSSysBDScheme.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysBDScheme, (PSSubSysServiceAPI)iEntity);
        }
        if (pSSysBDScheme.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysBDScheme.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysBDScheme, (PSSysDynaModel)iEntity);
        }
        if (pSSysBDScheme.getPSSysModelGroupId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELGROUP", (Object)pSSysBDScheme.getPSSysModelGroupId())) != null) {
            this.onFillParentInfo_PSSysModelGroup(pSSysBDScheme, (PSSysModelGroup)iEntity);
        }
        if (pSSysBDScheme.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSSysBDScheme.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSSysBDScheme, (PSSysServiceAPI)iEntity);
        }
        if (pSSysBDScheme.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysBDScheme.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysBDScheme, (PSSysSFPlugin)iEntity);
        }
        if (pSSysBDScheme.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysBDScheme.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysBDScheme, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBDScheme, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AuthClientId(bl, pSSysBDScheme, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientSecret(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthMode(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam2(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BDType(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BDTypes(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableServiceAPI(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSubSysServiceAPI(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelVer(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjNameCase(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDPartsCnt(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeName(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTablesCnt(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelGroupId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RowKeySeparator(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SchemeParams(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SchemeTag(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SchemeTag2(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam2(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServicePath(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubSysServiceCodeName(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDScheme, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBDScheme, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AuthClientId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isAuthClientIdDirty() : !pSSysBDScheme.isAuthClientIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getAuthClientId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthClientSecret(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isAuthClientSecretDirty() : !pSSysBDScheme.isAuthClientSecretDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getAuthClientSecret();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientSecret_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthMode(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isAuthModeDirty() : !pSSysBDScheme.isAuthModeDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getAuthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthMode_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isAuthParamDirty() : !pSSysBDScheme.isAuthParamDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getAuthParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam2(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isAuthParam2Dirty() : !pSSysBDScheme.isAuthParam2Dirty()) {
            return null;
        }
        String string = pSSysBDScheme.getAuthParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam2_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_BDType(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isBDTypeDirty() : !pSSysBDScheme.isBDTypeDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getBDType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BDType_Default((IEntity)pSSysBDScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BDTypes(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isBDTypesDirty() : !pSSysBDScheme.isBDTypesDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getBDTypes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BDTypes_Default((IEntity)pSSysBDScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BDTYPES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isCodeNameDirty() : !pSSysBDScheme.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBDScheme, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysBDSchemeDEModel(), "CODENAME", string3, pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isDefaultFlagDirty() : !pSSysBDScheme.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSysBDScheme.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSSysBDScheme, bl2, bl3);
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
                String string2 = this.checkFieldDupRule(this.getPSSysBDSchemeDEModel(), "DEFAULTFLAG", string, pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableServiceAPI(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isEnableServiceAPIDirty() : !pSSysBDScheme.isEnableServiceAPIDirty()) {
            return null;
        }
        Integer n = pSSysBDScheme.getEnableServiceAPI();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableServiceAPI_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableSubSysServiceAPI(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isEnableSubSysServiceAPIDirty() : !pSSysBDScheme.isEnableSubSysServiceAPIDirty()) {
            return null;
        }
        Integer n = pSSysBDScheme.getEnableSubSysServiceAPI();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSubSysServiceAPI_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isMemoDirty() : !pSSysBDScheme.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelVer(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isModelVerDirty() : !pSSysBDScheme.isModelVerDirty()) {
            return null;
        }
        Integer n = pSSysBDScheme.getModelVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelVer_Default((IEntity)pSSysBDScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ObjNameCase(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isObjNameCaseDirty() : !pSSysBDScheme.isObjNameCaseDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getObjNameCase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjNameCase_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isOrderValueDirty() : !pSSysBDScheme.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBDScheme.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSModuleIdDirty() : !pSSysBDScheme.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSubSysServiceAPIIdDirty() : !pSSysBDScheme.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDPartsCnt(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysBDPartsCntDirty() : !pSSysBDScheme.isPSSysBDPartsCntDirty()) {
            return null;
        }
        Integer n = pSSysBDScheme.getPSSysBDPartsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysBDPartsCnt_Default((IEntity)pSSysBDScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDPARTSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDSchemeId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysBDSchemeIdDirty() && !bl2 : !pSSysBDScheme.isPSSysBDSchemeIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSysBDSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDSchemeName(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysBDSchemeNameDirty() && !bl2 : !pSSysBDScheme.isPSSysBDSchemeNameDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSysBDSchemeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeName_Default((IEntity)pSSysBDScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTablesCnt(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysBDTablesCntDirty() : !pSSysBDScheme.isPSSysBDTablesCntDirty()) {
            return null;
        }
        Integer n = pSSysBDScheme.getPSSysBDTablesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysBDTablesCnt_Default((IEntity)pSSysBDScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysDynaModelIdDirty() : !pSSysBDScheme.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelGroupId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysModelGroupIdDirty() : !pSSysBDScheme.isPSSysModelGroupIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSysModelGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelGroupId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysServiceAPIIdDirty() : !pSSysBDScheme.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSysSFPluginIdDirty() : !pSSysBDScheme.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSystemIdDirty() : !pSSysBDScheme.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isPSSystemNameDirty() : !pSSysBDScheme.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_RowKeySeparator(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isRowKeySeparatorDirty() : !pSSysBDScheme.isRowKeySeparatorDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getRowKeySeparator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RowKeySeparator_Default((IEntity)pSSysBDScheme, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROWKEYSEPARATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SchemeParams(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isSchemeParamsDirty() : !pSSysBDScheme.isSchemeParamsDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getSchemeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SchemeParams_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_SchemeTag(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isSchemeTagDirty() : !pSSysBDScheme.isSchemeTagDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getSchemeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SchemeTag_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_SchemeTag2(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isSchemeTag2Dirty() : !pSSysBDScheme.isSchemeTag2Dirty()) {
            return null;
        }
        String string = pSSysBDScheme.getSchemeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SchemeTag2_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isServiceCodeNameDirty() : !pSSysBDScheme.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isServiceParamDirty() : !pSSysBDScheme.isServiceParamDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getServiceParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam2(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isServiceParam2Dirty() : !pSSysBDScheme.isServiceParam2Dirty()) {
            return null;
        }
        String string = pSSysBDScheme.getServiceParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam2_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServicePath(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isServicePathDirty() : !pSSysBDScheme.isServicePathDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getServicePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServicePath_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_SubSysServiceCodeName(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isSubSysServiceCodeNameDirty() : !pSSysBDScheme.isSubSysServiceCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getSubSysServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubSysServiceCodeName_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isUserCatDirty() : !pSSysBDScheme.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isUserTagDirty() : !pSSysBDScheme.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDScheme.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isUserTag2Dirty() : !pSSysBDScheme.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDScheme.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isUserTag3Dirty() : !pSSysBDScheme.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDScheme.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDScheme pSSysBDScheme, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDScheme.isUserTag4Dirty() : !pSSysBDScheme.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDScheme.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBDScheme, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBDScheme, bl);
    }

    protected void onSyncIndexEntities(PSSysBDScheme pSSysBDScheme, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBDScheme, bl);
    }

    public Object getDataContextValue(PSSysBDScheme pSSysBDScheme, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBDScheme, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDScheme pSSysBDScheme, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBDScheme, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"BDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BDType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BDTYPES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BDTypes_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MODELVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelVer_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBDPARTSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDPartsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTablesCnt_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ROWKEYSEPARATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RowKeySeparator_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BDType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BDTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BDTypes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BDTYPES", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysBDPartsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysBDTablesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_RowKeySeparator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROWKEYSEPARATOR", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected boolean onMergeChild(String string, String string2, PSSysBDScheme pSSysBDScheme) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) && this.onMergeChild_PSSysBDParts(pSSysBDScheme)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) && this.onMergeChild_PSSysBDTables(pSSysBDScheme)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, pSSysBDScheme)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSSysBDParts(PSSysBDScheme pSSysBDScheme) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSBDPARTSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysBDScheme.getPSSysBDSchemeId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSBDSCHEMEID", (Object)pSSysBDScheme.getPSSysBDSchemeId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysBDScheme, false);
        return true;
    }

    protected boolean onMergeChild_PSSysBDTables(PSSysBDScheme pSSysBDScheme) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSBDTABLESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysBDScheme.getPSSysBDSchemeId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSBDSCHEMEID", (Object)pSSysBDScheme.getPSSysBDSchemeId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysBDScheme, false);
        return true;
    }

    protected void onUpdateParent(PSSysBDScheme pSSysBDScheme) throws Exception {
        super.onUpdateParent(pSSysBDScheme);
    }

    @Override
    protected void exportCurXmlModel(PSSysBDScheme pSSysBDScheme, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDSCHEME");
        if (!bl) {
            pSSysBDScheme.setBDTypes(null);
            pSSysBDScheme.setCreateDate(null);
            pSSysBDScheme.setCreateMan(null);
            pSSysBDScheme.setModelVer(null);
            pSSysBDScheme.setPSSysBDPartsCnt(null);
            pSSysBDScheme.setPSSysBDSchemeId(null);
            pSSysBDScheme.setPSSysBDTablesCnt(null);
            pSSysBDScheme.setUpdateDate(null);
            pSSysBDScheme.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDScheme, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDScheme pSSysBDScheme, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDScheme, string);
        objectNode.remove("pssysbdpartscnt");
        objectNode.remove("pssysbdtablescnt");
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
            return "DER1N_PSSYSBDSCHEME_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMODELGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBDSCHEME_PSSYSMODELGROUP_PSSYSMODELGROUPID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBDSCHEME_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysBDScheme pSSysBDScheme) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDScheme.getCodeName())) {
            return pSSysBDScheme.getCodeName();
        }
        return super.getModelV2Tag(pSSysBDScheme);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDScheme pSSysBDScheme, String string) {
        pSSysBDScheme.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSMODELGROUPID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDScheme pSSysBDScheme, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDScheme.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDScheme, true);
        pSSysBDScheme.set("CODENAME", string);
        if (this.select(pSSysBDScheme, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDScheme, true);
        return super.getModelV2Entity(pSSysBDScheme, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDScheme pSSysBDScheme, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBDScheme, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 90;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBDScheme pSSysBDScheme, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDMODULE", (Object)pSSysBDScheme.getPSSysBDSchemeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysBDModule();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDModuleServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDModule)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDMODULE", (Object)((PSSysBDModule)entityBase).getPSSysBDModuleId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDPART", (Object)pSSysBDScheme.getPSSysBDSchemeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysBDPart();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDPartServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDPart)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDPART", (Object)((PSSysBDPart)entityBase).getPSSysBDPartId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDTABLE", (Object)pSSysBDScheme.getPSSysBDSchemeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysBDTable();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDTableServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDTable)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDTABLE", (Object)((PSSysBDTable)entityBase).getPSSysBDTableId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBDTABLERS", (Object)pSSysBDScheme.getPSSysBDSchemeId()))).exists()) {
            pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysBDTableRS();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysBDTableRSServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysBDTableRS)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBDTABLERS", (Object)((PSSysBDTableRS)entityBase).getPSSysBDTableRSId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysBDScheme, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBDScheme pSSysBDScheme, ObjectNode objectNode, String string, boolean bl) throws Exception {
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID")) {
            PSSysBDModuleService service = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDMODULE", (Object)pSSysBDScheme.getPSSysBDSchemeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSBDSCHEME#%1$s", (Object)pSSysBDScheme.getPSSysBDSchemeId());
                for (PSSysBDModule module : service.selectByPSSysBDScheme(pSSysBDScheme)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(module), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(module, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                Collections.sort(items, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssysbdmodulename")) {
                            string = objectNode.get("pssysbdmodulename").asText();
                        }
                        if (objectNode2.has("pssysbdmodulename")) {
                            string2 = objectNode2.get("pssysbdmodulename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                ArrayNode exported = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                for (ObjectNode item : items) {
                    PSSysBDModule module = new PSSysBDModule();
                    PSModelV2Helper.fromJSONObject(module, item, false);
                    exported.add(service.exportModelV2(module, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID")) {
            PSSysBDPartService service = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDPART", (Object)pSSysBDScheme.getPSSysBDSchemeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSBDSCHEME#%1$s", (Object)pSSysBDScheme.getPSSysBDSchemeId());
                for (PSSysBDPart part : service.selectByPSSysBDScheme(pSSysBDScheme)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(part), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(part, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                Collections.sort(items, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssysbdpartname")) {
                            string = objectNode.get("pssysbdpartname").asText();
                        }
                        if (objectNode2.has("pssysbdpartname")) {
                            string2 = objectNode2.get("pssysbdpartname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                ArrayNode exported = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                for (ObjectNode item : items) {
                    PSSysBDPart part = new PSSysBDPart();
                    PSModelV2Helper.fromJSONObject(part, item, false);
                    exported.add(service.exportModelV2(part, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID")) {
            PSSysBDTableService service = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDTABLE", (Object)pSSysBDScheme.getPSSysBDSchemeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSBDSCHEME#%1$s", (Object)pSSysBDScheme.getPSSysBDSchemeId());
                for (PSSysBDTable table : service.selectByPSSysBDScheme(pSSysBDScheme)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(table), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(table, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                Collections.sort(items, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssysbdtablename")) {
                            string = objectNode.get("pssysbdtablename").asText();
                        }
                        if (objectNode2.has("pssysbdtablename")) {
                            string2 = objectNode2.get("pssysbdtablename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                ArrayNode exported = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                for (ObjectNode item : items) {
                    PSSysBDTable table = new PSSysBDTable();
                    PSModelV2Helper.fromJSONObject(table, item, false);
                    exported.add(service.exportModelV2(table, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID")) {
            PSSysBDTableRSService service = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBDSCHEME#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBDTABLERS", (Object)pSSysBDScheme.getPSSysBDSchemeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSBDSCHEME#%1$s", (Object)pSSysBDScheme.getPSSysBDSchemeId());
                for (PSSysBDTableRS tableRS : service.selectByPSSysBDScheme(pSSysBDScheme)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(tableRS), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(tableRS, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                Collections.sort(items, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pssysbdtablersname")) {
                            string = objectNode.get("pssysbdtablersname").asText();
                        }
                        if (objectNode2.has("pssysbdtablersname")) {
                            string2 = objectNode2.get("pssysbdtablersname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                ArrayNode exported = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                for (ObjectNode item : items) {
                    PSSysBDTableRS tableRS = new PSSysBDTableRS();
                    PSModelV2Helper.fromJSONObject(tableRS, item, false);
                    exported.add(service.exportModelV2(tableRS, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBDScheme, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBDScheme pSSysBDScheme) throws Exception {
        super.onEmptyModelV2(pSSysBDScheme);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBDScheme pSSysBDScheme, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysBDModule();
        entityBase.set("PSSYSBDSCHEMEID", pSSysBDScheme.getPSSysBDSchemeId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBDPart();
        entityBase.set("PSSYSBDSCHEMEID", pSSysBDScheme.getPSSysBDSchemeId());
        pSCoreSysServiceBase = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBDTable();
        entityBase.set("PSSYSBDSCHEMEID", pSSysBDScheme.getPSSysBDSchemeId());
        pSCoreSysServiceBase = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysBDTableRS();
        entityBase.set("PSSYSBDSCHEMEID", pSSysBDScheme.getPSSysBDSchemeId());
        pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBDScheme, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBDScheme pSSysBDScheme, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysBDSchemeServiceBase.isSimpleImportExportMode("")) {
            PSSysBDModuleService service = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String modelName = service.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode item = (ObjectNode)arrayNode.get(i);
                    PSSysBDModule module = new PSSysBDModule();
                    module.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                    module.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                    service.compileModelV2(module, item, string, null, n);
                }
            } else {
                File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (directory.exists()) {
                    File[] folders = directory.listFiles();
                    if (folders != null) {
                        for (File folder : folders) {
                            if (!folder.isDirectory()) continue;
                            PSSysBDModule module = new PSSysBDModule();
                            module.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                            module.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                            service.compileModelV2(module, null, string, folder.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        if (!PSSysBDSchemeServiceBase.isSimpleImportExportMode("")) {
            PSSysBDPartService service = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String modelName = service.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode item = (ObjectNode)arrayNode.get(i);
                    PSSysBDPart part = new PSSysBDPart();
                    part.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                    part.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                    service.compileModelV2(part, item, string, null, n);
                }
            } else {
                File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (directory.exists()) {
                    File[] folders = directory.listFiles();
                    if (folders != null) {
                        for (File folder : folders) {
                            if (!folder.isDirectory()) continue;
                            PSSysBDPart part = new PSSysBDPart();
                            part.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                            part.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                            service.compileModelV2(part, null, string, folder.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        if (!PSSysBDSchemeServiceBase.isSimpleImportExportMode("")) {
            PSSysBDTableService service = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String modelName = service.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode item = (ObjectNode)arrayNode.get(i);
                    PSSysBDTable table = new PSSysBDTable();
                    table.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                    table.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                    service.compileModelV2(table, item, string, null, n);
                }
            } else {
                File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (directory.exists()) {
                    File[] folders = directory.listFiles();
                    if (folders != null) {
                        for (File folder : folders) {
                            if (!folder.isDirectory()) continue;
                            PSSysBDTable table = new PSSysBDTable();
                            table.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                            table.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                            service.compileModelV2(table, null, string, folder.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        if (!PSSysBDSchemeServiceBase.isSimpleImportExportMode("")) {
            PSSysBDTableRSService service = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String modelName = service.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray(objectNode, modelName.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode item = (ObjectNode)arrayNode.get(i);
                    PSSysBDTableRS tableRS = new PSSysBDTableRS();
                    tableRS.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                    tableRS.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                    service.compileModelV2(tableRS, item, string, null, n);
                }
            } else {
                File directory = new File(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)modelName));
                if (directory.exists()) {
                    File[] folders = directory.listFiles();
                    if (folders != null) {
                        for (File folder : folders) {
                            if (!folder.isDirectory()) continue;
                            PSSysBDTableRS tableRS = new PSSysBDTableRS();
                            tableRS.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
                            tableRS.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                            service.compileModelV2(tableRS, null, string, folder.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBDScheme, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBDScheme pSSysBDScheme, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDParts(pSSysBDScheme, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDTables(pSSysBDScheme, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBDTableRSes(pSSysBDScheme, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysBDScheme, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysBDParts(PSSysBDScheme pSSysBDScheme, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDPART", true), (boolean)false) == 0) {
            PSSysBDPartService pSSysBDPartService = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDPart pSSysBDPart = new PSSysBDPart();
            pSSysBDPart.setPSSysBDPartId(pSMOSFile.getPSModelId());
            if (!pSSysBDPartService.get(pSSysBDPart, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDPart.getPSSysBDSchemeId(), (String)pSSysBDScheme.getPSSysBDSchemeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDPartService.exportModelV2(pSSysBDPart);
            pSSysBDPart.reset();
            if (!pSSysBDPartService.setModelV2ResScope((IEntity)pSSysBDPart, "PSSYSBDSCHEME", pSSysBDScheme.getPSSysBDSchemeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDPartService.importModelV2(pSSysBDPart, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDPartService.getFile((IEntity)pSSysBDPart);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysBDTables(PSSysBDScheme pSSysBDScheme, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDTABLE", true), (boolean)false) == 0) {
            PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = new PSSysBDTable();
            pSSysBDTable.setPSSysBDTableId(pSMOSFile.getPSModelId());
            if (!pSSysBDTableService.get(pSSysBDTable, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDTable.getPSSysBDSchemeId(), (String)pSSysBDScheme.getPSSysBDSchemeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDTableService.exportModelV2(pSSysBDTable);
            pSSysBDTable.reset();
            if (!pSSysBDTableService.setModelV2ResScope((IEntity)pSSysBDTable, "PSSYSBDSCHEME", pSSysBDScheme.getPSSysBDSchemeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDTableService.importModelV2(pSSysBDTable, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDTableService.getFile((IEntity)pSSysBDTable);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysBDTableRSes(PSSysBDScheme pSSysBDScheme, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBDTABLERS", true), (boolean)false) == 0) {
            PSSysBDTableRSService pSSysBDTableRSService = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
            PSSysBDTableRS pSSysBDTableRS = new PSSysBDTableRS();
            pSSysBDTableRS.setPSSysBDTableRSId(pSMOSFile.getPSModelId());
            if (!pSSysBDTableRSService.get(pSSysBDTableRS, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBDTableRS.getPSSysBDSchemeId(), (String)pSSysBDScheme.getPSSysBDSchemeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBDTableRSService.exportModelV2(pSSysBDTableRS);
            pSSysBDTableRS.reset();
            if (!pSSysBDTableRSService.setModelV2ResScope((IEntity)pSSysBDTableRS, "PSSYSBDSCHEME", pSSysBDScheme.getPSSysBDSchemeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBDTableRSService.importModelV2(pSSysBDTableRS, objectNode);
            SessionFactoryManager.commit();
            return pSSysBDTableRSService.getFile((IEntity)pSSysBDTableRS);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysBDScheme pSSysBDScheme, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysBDParts(pSSysBDScheme, list);
        this.onFillPasteHelps_PSSysBDTables(pSSysBDScheme, list);
        this.onFillPasteHelps_PSSysBDTableRSes(pSSysBDScheme, list);
        super.onFillPasteHelps(pSSysBDScheme, list);
    }

    protected void onFillPasteHelps_PSSysBDParts(PSSysBDScheme pSSysBDScheme, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDPART");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5927\u6570\u636e\u4f53\u7cfb]\u7684[\u5927\u6570\u636e\u5206\u533a]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysBDTables(PSSysBDScheme pSSysBDScheme, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDTABLE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5927\u6570\u636e\u4f53\u7cfb]\u7684[\u5927\u6570\u636e\u5e93\u8868]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysBDTableRSes(PSSysBDScheme pSSysBDScheme, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBDTABLERS");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5927\u6570\u636e\u4f53\u7cfb]\u7684[\u5927\u6570\u636e\u8868\u5173\u7cfb]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6a21\u5757>", "DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6a21\u5757>");
            } else if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysbdmodules");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID|PSSYSBDSCHEMEID");
            pSMOSFile2.setFileTag3("PSSYSBDMODULE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u5206\u533a>", "DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u5206\u533a>");
            } else if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysbdparts");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID|PSSYSBDSCHEMEID");
            pSMOSFile2.setFileTag3("PSSYSBDPART");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u8868>", "DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u8868>");
            } else if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysbdtables");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID|PSSYSBDSCHEMEID");
            pSMOSFile2.setFileTag3("PSSYSBDTABLE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u8868\u5173\u7cfb>", "DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u8868\u5173\u7cfb>");
            } else if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysbdtablerses");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID|PSSYSBDSCHEMEID");
            pSMOSFile2.setFileTag3("PSSYSBDTABLERS");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSSysBDSchemeServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6a21\u5757>", (boolean)false) == 0 || PSSysBDSchemeServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"pssysbdmodules", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entity, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysBDSchemeServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u5206\u533a>", (boolean)false) == 0 || PSSysBDSchemeServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysBDParts", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entity, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysBDSchemeServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u8868>", (boolean)false) == 0 || PSSysBDSchemeServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysBDTables", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entity, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysBDSchemeServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u8868\u5173\u7cfb>", (boolean)false) == 0 || PSSysBDSchemeServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysBDTableRSes", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "PSSYSBDSCHEMEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entity, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSBDMODULE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)false) == 0) {
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                return "<\u6a21\u5757>";
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                return "pssysbdmodules";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)false) == 0) {
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u5206\u533a>";
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                return "pssysbdparts";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSBDTABLE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)false) == 0) {
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u8868>";
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                return "pssysbdtables";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)false) == 0) {
            if (PSSysBDSchemeServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u8868\u5173\u7cfb>";
            }
            if (PSSysBDSchemeServiceBase.getMOSVer() == 2) {
                return "pssysbdtablerses";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}
