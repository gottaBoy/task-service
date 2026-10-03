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
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAISchemeBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysServiceAPIDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysServiceAPIDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADERSBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADERSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADERSServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysServiceAPIServiceBase
extends PSCoreSysServiceBase<PSSubSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_ADDSYNCSADEMODELTASK = "X_ADDSYNCSADEMODELTASK";
    public static final String ACTION_IMPORTSCHEMA = "ImportSchema";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSubSysServiceAPIDEModel pSSubSysServiceAPIDEModel;
    private PSSubSysServiceAPIDAO pSSubSysServiceAPIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService";
    }

    public PSSubSysServiceAPIDEModel getPSSubSysServiceAPIDEModel() {
        if (this.pSSubSysServiceAPIDEModel == null) {
            try {
                this.pSSubSysServiceAPIDEModel = (PSSubSysServiceAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysServiceAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysServiceAPIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysServiceAPIDEModel();
    }

    public PSSubSysServiceAPIDAO getPSSubSysServiceAPIDAO() {
        if (this.pSSubSysServiceAPIDAO == null) {
            try {
                this.pSSubSysServiceAPIDAO = (PSSubSysServiceAPIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysServiceAPIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysServiceAPIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysServiceAPIDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDSYNCSADEMODELTASK, (boolean)true) == 0) {
            this.addSyncSADEModelTask((PSSubSysServiceAPI)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_IMPORTSCHEMA, (boolean)true) == 0) {
            this.importSchema((PSSubSysServiceAPI)iEntity);
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

    public void addSyncSADEModelTask(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSADEMODELTASK, 0, pSSubSysServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSubSysServiceAPI, ACTION_X_ADDSYNCSADEMODELTASK);
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSubSysServiceAPIServiceBase.this.getService(), PSSubSysServiceAPIServiceBase.ACTION_X_ADDSYNCSADEMODELTASK, 40, pSSubSysServiceAPI2, null).getResult() != 1) {
                    PSSubSysServiceAPIServiceBase.this.onAddSyncSADEModelTask(pSSubSysServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSADEMODELTASK, 99, pSSubSysServiceAPI, null);
        }
    }

    protected void onAddSyncSADEModelTask(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDSYNCSADEMODELTASK]");
    }

    public void importSchema(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_IMPORTSCHEMA, 0, pSSubSysServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSubSysServiceAPI, ACTION_IMPORTSCHEMA);
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSubSysServiceAPIServiceBase.this.getService(), PSSubSysServiceAPIServiceBase.ACTION_IMPORTSCHEMA, 40, pSSubSysServiceAPI2, null).getResult() != 1) {
                    PSSubSysServiceAPIServiceBase.this.onImportSchema(pSSubSysServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_IMPORTSCHEMA, 99, pSSubSysServiceAPI, null);
        }
    }

    protected void onImportSchema(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ImportSchema]");
    }

    protected void onFillParentInfo(PSSubSysServiceAPI pSSubSysServiceAPI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSDEVSLNSYSAPI_PSDEVSLNSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = (PSDevSlnSysAPI)iService.getDEModel().createEntity();
            pSDevSlnSysAPI.set("PSDEVSLNSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysAPI);
            } else {
                iService.get(pSDevSlnSysAPI);
            }
            this.onFillParentInfo_PSDevSlnSysAPI(pSSubSysServiceAPI, pSDevSlnSysAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSubSysServiceAPI, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSubSysServiceAPI, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSEAISCHEME_PSSYSEAISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIScheme pSSysEAIScheme = (PSSysEAIScheme)iService.getDEModel().createEntity();
            pSSysEAIScheme.set("PSSYSEAISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEAIScheme);
            } else {
                iService.get(pSSysEAIScheme);
            }
            this.onFillParentInfo_PSSysEAIScheme(pSSubSysServiceAPI, pSSysEAIScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSSubSysServiceAPI, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSSubSysServiceAPI, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSSAHANDLER_PSSYSSAHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService", (SessionFactory)this.getSessionFactory());
            PSSysSAHandler pSSysSAHandler = (PSSysSAHandler)iService.getDEModel().createEntity();
            pSSysSAHandler.set("PSSYSSAHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSAHandler);
            } else {
                iService.get(pSSysSAHandler);
            }
            this.onFillParentInfo_PSSysSAHandler(pSSubSysServiceAPI, pSSysSAHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysServiceAPI);
            } else {
                iService.get(pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSSubSysServiceAPI, pSSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_DEPSSysSFPlugin(pSSubSysServiceAPI, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSubSysServiceAPI, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSubSysServiceAPI, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSubSysServiceAPI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSysAPI(PSSubSysServiceAPI pSSubSysServiceAPI, PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        pSSubSysServiceAPI.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        pSSubSysServiceAPI.setPSDevSlnSysAPIName(pSDevSlnSysAPI.getPSDevSlnSysAPIName());
    }

    protected void onFillParentInfo_PSModule(PSSubSysServiceAPI pSSubSysServiceAPI, PSModule pSModule) throws Exception {
        pSSubSysServiceAPI.setPSModuleId(pSModule.getPSModuleId());
        pSSubSysServiceAPI.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSubSysServiceAPI.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSubSysServiceAPI.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysEAIScheme(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysEAIScheme pSSysEAIScheme) throws Exception {
        pSSubSysServiceAPI.setPSSysEAISchemeId(pSSysEAIScheme.getPSSysEAISchemeId());
        pSSubSysServiceAPI.setPSSysEAISchemeName(pSSysEAIScheme.getPSSysEAISchemeName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysReqItem pSSysReqItem) throws Exception {
        pSSubSysServiceAPI.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSSubSysServiceAPI.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysResource(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysResource pSSysResource) throws Exception {
        pSSubSysServiceAPI.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSubSysServiceAPI.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSAHandler(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysSAHandler pSSysSAHandler) throws Exception {
        pSSubSysServiceAPI.setPSSysSAHandlerId(pSSysSAHandler.getPSSysSAHandlerId());
        pSSubSysServiceAPI.setPSSysSAHandlerName(pSSysSAHandler.getPSSysSAHandlerName());
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSSubSysServiceAPI.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSSubSysServiceAPI.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillParentInfo_DEPSSysSFPlugin(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSubSysServiceAPI.setDEPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSubSysServiceAPI.setDEPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSubSysServiceAPI pSSubSysServiceAPI, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSubSysServiceAPI.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSubSysServiceAPI.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSubSysServiceAPI pSSubSysServiceAPI, PSSystem pSSystem) throws Exception {
        pSSubSysServiceAPI.setPSSystemId(pSSystem.getPSSystemId());
        pSSubSysServiceAPI.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
        if (bl) {
            if (pSSubSysServiceAPI.getAPISource() == null) {
                pSSubSysServiceAPI.setAPISource((String)this.getDefaultValue(this.getWebContext(), "", "NONE", 25));
            }
            if (pSSubSysServiceAPI.getCodeName() == null) {
                pSSubSysServiceAPI.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "SubSysAPI", 25));
            }
            if (pSSubSysServiceAPI.getDefDEDataSetReqMethod() == null) {
                pSSubSysServiceAPI.setDefDEDataSetReqMethod((String)this.getDefaultValue(this.getWebContext(), "", "GET", 25));
            }
            if (pSSubSysServiceAPI.getDefSelectReqMethod() == null) {
                pSSubSysServiceAPI.setDefSelectReqMethod((String)this.getDefaultValue(this.getWebContext(), "", "GET", 25));
            }
            if (pSSubSysServiceAPI.getFromDEModelFlag() == null) {
                pSSubSysServiceAPI.setFromDEModelFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSubSysServiceAPI.getPSSubSysServiceAPIName() == null) {
                pSSubSysServiceAPI.setPSSubSysServiceAPIName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5916\u90e8\u63a5\u53e3", 25));
            }
            if (pSSubSysServiceAPI.getValidFlag() == null) {
                pSSubSysServiceAPI.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSDevSlnSysAPI(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSModule(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysEAIScheme(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysResource(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysSAHandler(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_DEPSSysSFPlugin(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSubSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSystem(pSSubSysServiceAPI, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSysAPI(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
        if (pSSubSysServiceAPI.isPSDevSlnSysAPIIdDirty()) {
            if (pSSubSysServiceAPI.getPSDevSlnSysAPIId() != null) {
                if (pSSubSysServiceAPI.getPSDevSlnSysAPIId() == null || pSSubSysServiceAPI.getPSDevSlnSysAPIName() == null) {
                    PSDevSlnSysAPI pSDevSlnSysAPI = pSSubSysServiceAPI.getPSDevSlnSysAPI();
                    pSSubSysServiceAPI.setPSDevSlnSysAPIName(pSDevSlnSysAPI.getPSDevSlnSysAPIName());
                }
            } else {
                pSSubSysServiceAPI.setPSDevSlnSysAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIScheme(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSAHandler(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DEPSSysSFPlugin(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
        if (pSSubSysServiceAPI.isPSSystemIdDirty()) {
            if (pSSubSysServiceAPI.getPSSystemId() != null) {
                if (pSSubSysServiceAPI.getPSSystemId() == null || pSSubSysServiceAPI.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSubSysServiceAPI.getPSSystem();
                    pSSubSysServiceAPI.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSubSysServiceAPI.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubSysServiceAPI, bl);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string) throws Exception {
        return this.selectByPSDevSlnSysAPI(pSDevSlnSysAPIBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPIID", (Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysServiceAPI> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysServiceAPI> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string) throws Exception {
        return this.selectByPSSysEAIScheme(pSSysEAISchemeBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysEAIScheme(PSSysEAISchemeBase pSSysEAISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAISCHEMEID", (Object)pSSysEAISchemeBase.getPSSysEAISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAISchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysServiceAPI> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysSAHandler(PSSysSAHandlerBase pSSysSAHandlerBase) throws Exception {
        return this.selectByPSSysSAHandler(pSSysSAHandlerBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysSAHandler(PSSysSAHandlerBase pSSysSAHandlerBase, String string) throws Exception {
        return this.selectByPSSysSAHandler(pSSysSAHandlerBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysSAHandler(PSSysSAHandlerBase pSSysSAHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSAHANDLERID", (Object)pSSysSAHandlerBase.getPSSysSAHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSAHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSAHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysServiceAPI> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByDEPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByDEPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEPSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDEPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDEPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysServiceAPI> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSubSysServiceAPI> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    public void resetPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSDevSlnSysAPIId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        final PSDevSlnSysAPI pSDevSlnSysAPI2 = pSDevSlnSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSDevSlnSysAPI(pSDevSlnSysAPI);
        this.onBeforeRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSModule(pSModule);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSModuleId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSysDynaModelId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEAIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSEAISCHEME_PSSYSEAISCHEMEID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysEAIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSysEAISchemeId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        final PSSysEAIScheme pSSysEAIScheme2 = pSSysEAIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSysEAIScheme(pSSysEAIScheme2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysEAIScheme(pSSysEAIScheme);
        this.onBeforeRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSysEAIScheme(pSSysEAIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIScheme(PSSysEAIScheme pSSysEAIScheme, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSysReqItemId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSysResourceId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysSAHandler(pSSysSAHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSAHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSAHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSSAHANDLER_PSSYSSAHANDLERID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysSAHandler), arrayList.get(0)));
        }
    }

    public void resetPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysSAHandler(pSSysSAHandler);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSysSAHandlerId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        final PSSysSAHandler pSSysSAHandler2 = pSSysSAHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysSAHandler(pSSysSAHandler2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSysSAHandler(pSSysSAHandler2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSysSAHandler(pSSysSAHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
    }

    protected void internalRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysSAHandler(pSSysSAHandler);
        this.onBeforeRemoveByPSSysSAHandler(pSSysSAHandler, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSysSAHandler(pSSysSAHandler, arrayList);
    }

    protected void onAfterRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSysServiceAPIId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setDEPSSysSFPluginId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByDEPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByDEPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSysSFPluginId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSUBSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            PSSubSysServiceAPI pSSubSysServiceAPI2 = (PSSubSysServiceAPI)this.getDEModel().createEntity();
            pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
            pSSubSysServiceAPI2.setPSSystemId(null);
            this.update(pSSubSysServiceAPI2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysServiceAPIServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSubSysServiceAPIServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSubSysServiceAPIServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSubSysServiceAPI> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSubSysServiceAPI pSSubSysServiceAPI : arrayList) {
            this.remove(pSSubSysServiceAPI);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSubSysServiceAPI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSDEUtilDEService)ServiceGlobal.getService(PSDEUtilDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUtilDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADERSServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADEServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDataSyncAgentServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        pSCoreSysServiceBase = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUtilDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI);
        super.onBeforeRemove(pSSubSysServiceAPI);
    }

    protected void replaceParentInfo(PSSubSysServiceAPI pSSubSysServiceAPI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubSysServiceAPI, cloneSession);
        if (pSSubSysServiceAPI.getPSDevSlnSysAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPI", (Object)pSSubSysServiceAPI.getPSDevSlnSysAPIId())) != null) {
            this.onFillParentInfo_PSDevSlnSysAPI(pSSubSysServiceAPI, (PSDevSlnSysAPI)iEntity);
        }
        if (pSSubSysServiceAPI.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSubSysServiceAPI.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSubSysServiceAPI, (PSModule)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSubSysServiceAPI.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSubSysServiceAPI, (PSSysDynaModel)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSysEAISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAISCHEME", (Object)pSSubSysServiceAPI.getPSSysEAISchemeId())) != null) {
            this.onFillParentInfo_PSSysEAIScheme(pSSubSysServiceAPI, (PSSysEAIScheme)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSubSysServiceAPI.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSSubSysServiceAPI, (PSSysReqItem)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSubSysServiceAPI.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSSubSysServiceAPI, (PSSysResource)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSysSAHandlerId() != null && (iEntity = cloneSession.getEntity("PSSYSSAHANDLER", (Object)pSSubSysServiceAPI.getPSSysSAHandlerId())) != null) {
            this.onFillParentInfo_PSSysSAHandler(pSSubSysServiceAPI, (PSSysSAHandler)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSSubSysServiceAPI.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSSubSysServiceAPI, (PSSysServiceAPI)iEntity);
        }
        if (pSSubSysServiceAPI.getDEPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSubSysServiceAPI.getDEPSSysSFPluginId())) != null) {
            this.onFillParentInfo_DEPSSysSFPlugin(pSSubSysServiceAPI, (PSSysSFPlugin)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSubSysServiceAPI.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSubSysServiceAPI, (PSSysSFPlugin)iEntity);
        }
        if (pSSubSysServiceAPI.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSubSysServiceAPI.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSubSysServiceAPI, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubSysServiceAPI, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AddDEMode(bl, pSSubSysServiceAPI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AddDEParams(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AddDEPrefix(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APISource(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APITag(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APITag2(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APIType(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthAccessTokenUri(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientSecret(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthCode(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthMode(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam2(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam3(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam4(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthTimeout(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BaseClsParams(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgPSModelStorageId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgTag(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeNameMode(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefCreateReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefDEActionReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefDEDataSetReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefDeleteReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefGetDraftReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefGetReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefNeedResourceKey(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefSelectReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefUpdateReqMethod(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEPSSysSFPluginId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAPIModelEx(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromDEModelFlag(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderParams(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MethodCode(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAPIId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAPIName(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIName(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAISchemeId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSAHandlerId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResetDefActionCodeName(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ScriptEngine(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceDTOFlag(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam2(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam3(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam4(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParams(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServicePath(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceType(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Ver(bl, pSSubSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubSysServiceAPI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AddDEMode(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAddDEModeDirty() : !pSSubSysServiceAPI.isAddDEModeDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getAddDEMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AddDEMode_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADDDEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AddDEParams(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAddDEParamsDirty() : !pSSubSysServiceAPI.isAddDEParamsDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAddDEParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AddDEParams_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADDDEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AddDEPrefix(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAddDEPrefixDirty() : !pSSubSysServiceAPI.isAddDEPrefixDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAddDEPrefix();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AddDEPrefix_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADDDEPREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APISource(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAPISourceDirty() : !pSSubSysServiceAPI.isAPISourceDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAPISource();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APISource_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APISOURCE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APITag(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAPITagDirty() : !pSSubSysServiceAPI.isAPITagDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAPITag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APITag_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APITAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APITag2(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAPITag2Dirty() : !pSSubSysServiceAPI.isAPITag2Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAPITag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APITag2_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APITAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APIType(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAPITypeDirty() && !bl2 : !pSSubSysServiceAPI.isAPITypeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAPIType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APITYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_APIType_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APITYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthAccessTokenUri(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthAccessTokenUriDirty() : !pSSubSysServiceAPI.isAuthAccessTokenUriDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthAccessTokenUri();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthAccessTokenUri_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHACCESSTOKENURI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthClientIdDirty() : !pSSubSysServiceAPI.isAuthClientIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthClientId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientId_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthClientSecret(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthClientSecretDirty() : !pSSubSysServiceAPI.isAuthClientSecretDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthClientSecret();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientSecret_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthCode(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthCodeDirty() : !pSSubSysServiceAPI.isAuthCodeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthCode_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthMode(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthModeDirty() : !pSSubSysServiceAPI.isAuthModeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthMode_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthParamDirty() : !pSSubSysServiceAPI.isAuthParamDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam2(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthParam2Dirty() : !pSSubSysServiceAPI.isAuthParam2Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam2_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam3(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthParam3Dirty() : !pSSubSysServiceAPI.isAuthParam3Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam3_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthParam4(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthParam4Dirty() : !pSSubSysServiceAPI.isAuthParam4Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getAuthParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam4_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthTimeout(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isAuthTimeoutDirty() : !pSSubSysServiceAPI.isAuthTimeoutDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getAuthTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AuthTimeout_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHTIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isBaseClsParamsDirty() : !pSSubSysServiceAPI.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASECLSPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgPSModelStorageId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isCfgPSModelStorageIdDirty() : !pSSubSysServiceAPI.isCfgPSModelStorageIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getCfgPSModelStorageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgPSModelStorageId_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGPSMODELSTORAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CfgTag(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isCfgTagDirty() : !pSSubSysServiceAPI.isCfgTagDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getCfgTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgTag_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isCodeNameDirty() && !bl2 : !pSSubSysServiceAPI.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSubSysServiceAPI, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSubSysServiceAPIDEModel(), "CODENAME", string3, pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeNameMode(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isCodeNameModeDirty() : !pSSubSysServiceAPI.isCodeNameModeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getCodeNameMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeNameMode_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAMEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isCustomCodeDirty() : !pSSubSysServiceAPI.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isCustomModeDirty() : !pSSubSysServiceAPI.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefCreateReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefCreateReqMethodDirty() : !pSSubSysServiceAPI.isDefCreateReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefCreateReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefCreateReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFCREATEREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefDEActionReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefDEActionReqMethodDirty() : !pSSubSysServiceAPI.isDefDEActionReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefDEActionReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefDEActionReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFDEACTIONREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefDEDataSetReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefDEDataSetReqMethodDirty() : !pSSubSysServiceAPI.isDefDEDataSetReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefDEDataSetReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefDEDataSetReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFDEDATASETREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefDeleteReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefDeleteReqMethodDirty() : !pSSubSysServiceAPI.isDefDeleteReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefDeleteReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefDeleteReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFDELETEREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefGetDraftReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefGetDraftReqMethodDirty() : !pSSubSysServiceAPI.isDefGetDraftReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefGetDraftReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefGetDraftReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFGETDRAFTREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefGetReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefGetReqMethodDirty() : !pSSubSysServiceAPI.isDefGetReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefGetReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefGetReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFGETREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefNeedResourceKey(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefNeedResourceKeyDirty() : !pSSubSysServiceAPI.isDefNeedResourceKeyDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getDefNeedResourceKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefNeedResourceKey_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFNEEDRESOURCEKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefSelectReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefSelectReqMethodDirty() : !pSSubSysServiceAPI.isDefSelectReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefSelectReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefSelectReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFSELECTREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefUpdateReqMethod(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDefUpdateReqMethodDirty() : !pSSubSysServiceAPI.isDefUpdateReqMethodDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDefUpdateReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefUpdateReqMethod_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFUPDATEREQMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEPSSysSFPluginId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isDEPSSysSFPluginIdDirty() : !pSSubSysServiceAPI.isDEPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getDEPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEPSSysSFPluginId_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableAPIModelEx(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isEnableAPIModelExDirty() : !pSSubSysServiceAPI.isEnableAPIModelExDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getEnableAPIModelEx();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAPIModelEx_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEAPIMODELEX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FromDEModelFlag(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isFromDEModelFlagDirty() : !pSSubSysServiceAPI.isFromDEModelFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getFromDEModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FromDEModelFlag_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMDEMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderParams(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isHeaderParamsDirty() : !pSSubSysServiceAPI.isHeaderParamsDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getHeaderParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderParams_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isLockFlagDirty() : !pSSubSysServiceAPI.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isMemoDirty() : !pSSubSysServiceAPI.isMemoDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_MethodCode(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isMethodCodeDirty() : !pSSubSysServiceAPI.isMethodCodeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getMethodCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MethodCode_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("METHODCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isOrderValueDirty() : !pSSubSysServiceAPI.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPredefinedTypeDirty() : !pSSubSysServiceAPI.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysAPIId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSDevSlnSysAPIIdDirty() : !pSSubSysServiceAPI.isPSDevSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSDevSlnSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAPIId_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAPIName(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSDevSlnSysAPINameDirty() : !pSSubSysServiceAPI.isPSDevSlnSysAPINameDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSDevSlnSysAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAPIName_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSModuleIdDirty() : !pSSubSysServiceAPI.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSubSysServiceAPIIdDirty() && !bl2 : !pSSubSysServiceAPI.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysServiceAPIName(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSubSysServiceAPINameDirty() && !bl2 : !pSSubSysServiceAPI.isPSSubSysServiceAPINameDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSubSysServiceAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIName_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPINAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSubSysServiceAPIDEModel(), "PSSUBSYSSERVICEAPINAME", string3, pSSubSysServiceAPI, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSUBSYSSERVICEAPINAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSysDynaModelIdDirty() : !pSSubSysServiceAPI.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEAISchemeId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSysEAISchemeIdDirty() : !pSSubSysServiceAPI.isPSSysEAISchemeIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSysEAISchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAISchemeId_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSysReqItemIdDirty() : !pSSubSysServiceAPI.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSysResourceIdDirty() : !pSSubSysServiceAPI.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSAHandlerId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSysSAHandlerIdDirty() : !pSSubSysServiceAPI.isPSSysSAHandlerIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSysSAHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSAHandlerId_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSAHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSysServiceAPIIdDirty() : !pSSubSysServiceAPI.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
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
                String string4 = this.checkFieldDupRule(this.getPSSubSysServiceAPIDEModel(), "PSSYSSERVICEAPIID", string3, pSSubSysServiceAPI, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSysSFPluginIdDirty() : !pSSubSysServiceAPI.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSystemIdDirty() && !bl2 : !pSSubSysServiceAPI.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isPSSystemNameDirty() && !bl2 : !pSSubSysServiceAPI.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResetDefActionCodeName(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isResetDefActionCodeNameDirty() : !pSSubSysServiceAPI.isResetDefActionCodeNameDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getResetDefActionCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResetDefActionCodeName_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESETDEFACTIONCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ScriptEngine(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isScriptEngineDirty() : !pSSubSysServiceAPI.isScriptEngineDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getScriptEngine();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ScriptEngine_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SCRIPTENGINE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceCodeNameDirty() : !pSSubSysServiceAPI.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceDTOFlag(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceDTOFlagDirty() : !pSSubSysServiceAPI.isServiceDTOFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getServiceDTOFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ServiceDTOFlag_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEDTOFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceParam(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceParamDirty() : !pSSubSysServiceAPI.isServiceParamDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServiceParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam2(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceParam2Dirty() : !pSSubSysServiceAPI.isServiceParam2Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServiceParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam2_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam3(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceParam3Dirty() : !pSSubSysServiceAPI.isServiceParam3Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServiceParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam3_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceParam4(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceParam4Dirty() : !pSSubSysServiceAPI.isServiceParam4Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServiceParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam4_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceParams(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceParamsDirty() : !pSSubSysServiceAPI.isServiceParamsDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServiceParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParams_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServicePath(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServicePathDirty() : !pSSubSysServiceAPI.isServicePathDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServicePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServicePath_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceType(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isServiceTypeDirty() : !pSSubSysServiceAPI.isServiceTypeDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getServiceType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceType_Default(pSSubSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isUserCatDirty() : !pSSubSysServiceAPI.isUserCatDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isUserTagDirty() : !pSSubSysServiceAPI.isUserTagDirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isUserTag2Dirty() : !pSSubSysServiceAPI.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isUserTag3Dirty() : !pSSubSysServiceAPI.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isUserTag4Dirty() : !pSSubSysServiceAPI.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSubSysServiceAPI.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isValidFlagDirty() && !bl2 : !pSSubSysServiceAPI.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_Ver(boolean bl, PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysServiceAPI.isVerDirty() : !pSSubSysServiceAPI.isVerDirty()) {
            return null;
        }
        Integer n = pSSubSysServiceAPI.getVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Ver_Default(pSSubSysServiceAPI, bl2, bl3);
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

    protected void onSyncEntity(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
        super.onSyncEntity(pSSubSysServiceAPI, bl);
    }

    protected void onSyncIndexEntities(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubSysServiceAPI, bl);
    }

    public Object getDataContextValue(PSSubSysServiceAPI pSSubSysServiceAPI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubSysServiceAPI, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubSysServiceAPI, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADDDEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AddDEMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADDDEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AddDEParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADDDEPREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AddDEPrefix_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APISOURCE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APISource_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APITag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APITag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APIType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHACCESSTOKENURI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthAccessTokenUri_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCLIENTSECRET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthClientSecret_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthCode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"AUTHPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHTIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BASECLSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseClsParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGPSMODELSTORAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgPSModelStorageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAMEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeNameMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFCREATEREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefCreateReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFDEACTIONREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefDEActionReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFDEDATASETREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefDEDataSetReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFDELETEREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefDeleteReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFGETDRAFTREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefGetDraftReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFGETREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefGetReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFNEEDRESOURCEKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefNeedResourceKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFSELECTREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefSelectReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFUPDATEREQMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefUpdateReqMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEPSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEPSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEAPIMODELEX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAPIModelEx_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMDEMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromDEModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"METHODCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MethodCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSAHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSAHandlerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"RESETDEFACTIONCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResetDefActionCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SCRIPTENGINE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ScriptEngine_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEDTOFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceDTOFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServicePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AddDEMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AddDEParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADDDEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AddDEPrefix_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADDDEPREFIX", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APISource_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APISOURCE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APITag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APITAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APITag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APITAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APIType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APITYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthAccessTokenUri_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHACCESSTOKENURI", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_AuthCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_AuthParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AuthTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BaseClsParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASECLSPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgPSModelStorageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGPSMODELSTORAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_CodeNameMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAMEMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_DefCreateReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFCREATEREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefDEActionReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFDEACTIONREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefDEDataSetReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFDEDATASETREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefDeleteReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFDELETEREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefGetDraftReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFGETDRAFTREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefGetReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFGETREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefNeedResourceKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefSelectReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFSELECTREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefUpdateReqMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFUPDATEREQMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEPSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEPSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableAPIModelEx_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FromDEModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HeaderParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MethodCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("METHODCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysEAISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSAHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSAHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ResetDefActionCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ScriptEngine_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SCRIPTENGINE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceDTOFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ServiceParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ServiceType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubSysServiceAPI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        super.onUpdateParent(pSSubSysServiceAPI);
    }

    @Override
    protected void exportCurXmlModel(PSSubSysServiceAPI pSSubSysServiceAPI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYSSERVICEAPI");
        if (!bl) {
            pSSubSysServiceAPI.setCreateDate(null);
            pSSubSysServiceAPI.setCreateMan(null);
            pSSubSysServiceAPI.setPSSubSysServiceAPIId(null);
            pSSubSysServiceAPI.setUpdateDate(null);
            pSSubSysServiceAPI.setUpdateMan(null);
            super.exportCurXmlModel(pSSubSysServiceAPI, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSubSysServiceAPI pSSubSysServiceAPI, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSubSysServiceAPI, string);
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
            return "DER1N_PSSUBSYSSERVICEAPI_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSUBSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSubSysServiceAPI pSSubSysServiceAPI) {
        if (!StringHelper.isNullOrEmpty((String)pSSubSysServiceAPI.getCodeName())) {
            return pSSubSysServiceAPI.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSubSysServiceAPI.getPSSubSysServiceAPIName())) {
            return pSSubSysServiceAPI.getPSSubSysServiceAPIName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSubSysServiceAPI.getCodeName())) {
            return pSSubSysServiceAPI.getCodeName();
        }
        return super.getModelV2Tag(pSSubSysServiceAPI);
    }

    @Override
    public boolean setModelV2Tag(PSSubSysServiceAPI pSSubSysServiceAPI, String string) {
        pSSubSysServiceAPI.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSUBSYSSERVICEAPINAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSSERVICEAPIID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSubSysServiceAPI pSSubSysServiceAPI, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSubSysServiceAPI.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSubSysServiceAPI, true);
        pSSubSysServiceAPI.set("CODENAME", string);
        if (this.select(pSSubSysServiceAPI, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSubSysServiceAPI, true);
        return super.getModelV2Entity(pSSubSysServiceAPI, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSubSysServiceAPI pSSubSysServiceAPI, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSubSysServiceAPI, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 90;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSubSysServiceAPI pSSubSysServiceAPI, String string, String string2) throws Exception {
        String string3;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSUBSYSSERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSUBSYSSADE", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId()))).exists()) {
            pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
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
                PSSubSysSADE entityBase = new PSSubSysSADE();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSubSysSADEServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSubSysSADE)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSUBSYSSADE", (Object)entityBase.getPSSubSysSADEId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSUBSYSSERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSUBSYSSADERS", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId()))).exists()) {
            pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
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
                PSSubSysSADERS entityBase = new PSSubSysSADERS();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSubSysSADERSServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSubSysSADERS)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSUBSYSSADERS", (Object)entityBase.getPSSubSysSADERSId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSUBSYSSERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSUBSYSSADETAIL", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId()))).exists()) {
            pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
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
                PSSubSysSADetail entityBase = new PSSubSysSADetail();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSubSysSADetailServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSubSysSADetail)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSUBSYSSADETAIL", (Object)entityBase.getPSSubSysSADetailId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSubSysServiceAPI, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSubSysServiceAPI pSSubSysServiceAPI, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID")) {
            pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSUBSYSSERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSUBSYSSADE", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSUBSYSSERVICEAPI#%1$s", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                for (PSSubSysSADE entity : ((PSSubSysSADEServiceBase)pSCoreSysServiceBase).selectByPSSubSysServiceAPI(pSSubSysServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSSubSysSADEServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode items = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssubsyssadename")) {
                            string = objectNode.get("pssubsyssadename").asText();
                        }
                        if (objectNode2.has("pssubsyssadename")) {
                            string2 = objectNode2.get("pssubsyssadename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSSubSysSADE entity = new PSSubSysSADE();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    items.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID")) {
            pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSUBSYSSERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSUBSYSSADERS", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSUBSYSSERVICEAPI#%1$s", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                for (PSSubSysSADERS entity : ((PSSubSysSADERSServiceBase)pSCoreSysServiceBase).selectByPSSubSysServiceAPI(pSSubSysServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSSubSysSADERSServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode items = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssubsyssadersname")) {
                            string = objectNode.get("pssubsyssadersname").asText();
                        }
                        if (objectNode2.has("pssubsyssadersname")) {
                            string2 = objectNode2.get("pssubsyssadersname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSSubSysSADERS entity = new PSSubSysSADERS();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    items.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID")) {
            pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSUBSYSSERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSUBSYSSADETAIL", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSUBSYSSERVICEAPI#%1$s", (Object)pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                for (PSSubSysSADetail entity : ((PSSubSysSADetailServiceBase)pSCoreSysServiceBase).selectByPSSubSysServiceAPI(pSSubSysServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSSubSysSADetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode items = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssubsyssadetailname")) {
                            string = objectNode.get("pssubsyssadetailname").asText();
                        }
                        if (objectNode2.has("pssubsyssadetailname")) {
                            string2 = objectNode2.get("pssubsyssadetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSSubSysSADetail entity = new PSSubSysSADetail();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    items.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        super.onExportCurModelV2(pSSubSysServiceAPI, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        super.onEmptyModelV2(pSSubSysServiceAPI);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSubSysServiceAPI pSSubSysServiceAPI, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSubSysSADE();
        entityBase.set("PSSUBSYSSERVICEAPIID", pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSubSysSADERS();
        entityBase.set("PSSUBSYSSERVICEAPIID", pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSubSysSADetail();
        entityBase.set("PSSUBSYSSERVICEAPIID", pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSubSysServiceAPI, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSubSysServiceAPI pSSubSysServiceAPI, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSubSysServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    PSSubSysSADE entity = new PSSubSysSADE();
                    entity.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                    entity.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(entity, (ObjectNode)arrayNode.get(n2), string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File directory = new File(string4);
                if (directory.exists()) {
                    for (File child : directory.listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSSubSysSADE entity = new PSSubSysSADE();
                        entity.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                        entity.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSubSysServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    PSSubSysSADERS entity = new PSSubSysSADERS();
                    entity.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                    entity.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(entity, (ObjectNode)arrayNode.get(n2), string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File directory = new File(string5);
                if (directory.exists()) {
                    for (File child : directory.listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSSubSysSADERS entity = new PSSubSysSADERS();
                        entity.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                        entity.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSubSysServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    PSSubSysSADetail entity = new PSSubSysSADetail();
                    entity.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                    entity.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(entity, (ObjectNode)arrayNode.get(i), string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File directory = new File(string6);
                if (directory.exists()) {
                    for (File child : directory.listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSSubSysSADetail entity = new PSSubSysSADetail();
                        entity.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
                        entity.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSubSysServiceAPI, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSubSysServiceAPI pSSubSysServiceAPI, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSubSysSADEs(pSSubSysServiceAPI, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSubSysSADERSs(pSSubSysServiceAPI, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSubSysSADetails(pSSubSysServiceAPI, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSubSysServiceAPI, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSubSysSADEs(PSSubSysServiceAPI pSSubSysServiceAPI, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSUBSYSSADE", true), (boolean)false) == 0) {
            PSSubSysSADEService pSSubSysSADEService = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = new PSSubSysSADE();
            pSSubSysSADE.setPSSubSysSADEId(pSMOSFile.getPSModelId());
            if (!pSSubSysSADEService.get(pSSubSysSADE, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSubSysSADE.getPSSubSysServiceAPIId(), (String)pSSubSysServiceAPI.getPSSubSysServiceAPIId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSubSysSADEService.exportModelV2(pSSubSysSADE);
            pSSubSysSADE.reset();
            if (!pSSubSysSADEService.setModelV2ResScope(pSSubSysSADE, "PSSUBSYSSERVICEAPI", pSSubSysServiceAPI.getPSSubSysServiceAPIId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSubSysSADEService.importModelV2(pSSubSysSADE, objectNode);
            SessionFactoryManager.commit();
            return pSSubSysSADEService.getFile(pSSubSysSADE);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSubSysSADERSs(PSSubSysServiceAPI pSSubSysServiceAPI, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSUBSYSSADERS", true), (boolean)false) == 0) {
            PSSubSysSADERSService pSSubSysSADERSService = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
            PSSubSysSADERS pSSubSysSADERS = new PSSubSysSADERS();
            pSSubSysSADERS.setPSSubSysSADERSId(pSMOSFile.getPSModelId());
            if (!pSSubSysSADERSService.get(pSSubSysSADERS, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSubSysSADERS.getPSSubSysServiceAPIId(), (String)pSSubSysServiceAPI.getPSSubSysServiceAPIId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSubSysSADERSService.exportModelV2(pSSubSysSADERS);
            pSSubSysSADERS.reset();
            if (!pSSubSysSADERSService.setModelV2ResScope(pSSubSysSADERS, "PSSUBSYSSERVICEAPI", pSSubSysServiceAPI.getPSSubSysServiceAPIId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSubSysSADERSService.importModelV2(pSSubSysSADERS, objectNode);
            SessionFactoryManager.commit();
            return pSSubSysSADERSService.getFile(pSSubSysSADERS);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSubSysSADetails(PSSubSysServiceAPI pSSubSysServiceAPI, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSUBSYSSADETAIL", true), (boolean)false) == 0) {
            PSSubSysSADetailService pSSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
            PSSubSysSADetail pSSubSysSADetail = new PSSubSysSADetail();
            pSSubSysSADetail.setPSSubSysSADetailId(pSMOSFile.getPSModelId());
            if (!pSSubSysSADetailService.get(pSSubSysSADetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSubSysSADetail.getPSSubSysServiceAPIId(), (String)pSSubSysServiceAPI.getPSSubSysServiceAPIId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSubSysSADetailService.exportModelV2(pSSubSysSADetail);
            pSSubSysSADetail.reset();
            if (!pSSubSysSADetailService.setModelV2ResScope(pSSubSysSADetail, "PSSUBSYSSERVICEAPI", pSSubSysServiceAPI.getPSSubSysServiceAPIId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSubSysSADetailService.importModelV2(pSSubSysSADetail, objectNode);
            SessionFactoryManager.commit();
            return pSSubSysSADetailService.getFile(pSSubSysSADetail);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSubSysServiceAPI pSSubSysServiceAPI, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSubSysSADEs(pSSubSysServiceAPI, list);
        this.onFillPasteHelps_PSSubSysSADERSs(pSSubSysServiceAPI, list);
        this.onFillPasteHelps_PSSubSysSADetails(pSSubSysServiceAPI, list);
        super.onFillPasteHelps(pSSubSysServiceAPI, list);
    }

    protected void onFillPasteHelps_PSSubSysSADEs(PSSubSysServiceAPI pSSubSysServiceAPI, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSUBSYSSADE");
        pSHelpSection.setSectionParam2("DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5916\u90e8\u63a5\u53e3]\u7684[\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSubSysSADERSs(PSSubSysServiceAPI pSSubSysServiceAPI, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSUBSYSSADERS");
        pSHelpSection.setSectionParam2("DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5916\u90e8\u63a5\u53e3]\u7684[\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSubSysSADetails(PSSubSysServiceAPI pSSubSysServiceAPI, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSUBSYSSADETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5916\u90e8\u63a5\u53e3]\u7684[\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u63a5\u53e3\u5b9e\u4f53>", "DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u63a5\u53e3\u5b9e\u4f53>");
            } else if (PSSubSysServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssubsyssades");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID|PSSUBSYSSERVICEAPIID");
            pSMOSFile2.setFileTag3("PSSUBSYSSADE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb>", "DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb>");
            } else if (PSSubSysServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssubsyssaderss");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID|PSSUBSYSSERVICEAPIID");
            pSMOSFile2.setFileTag3("PSSUBSYSSADERS");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSSubSysServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u63a5\u53e3\u5b9e\u4f53>", (boolean)false) == 0 || PSSubSysServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSubSysSADEs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSubSysSADEService)ServiceGlobal.getService(PSSubSysSADEService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entry : arrayList) {
                EntityBase entityBase = (EntityBase)entry;
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSubSysServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb>", (boolean)false) == 0 || PSSubSysServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSubSysSADERSs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSubSysSADERSService)ServiceGlobal.getService(PSSubSysSADERSService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "PSSUBSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entry : arrayList) {
                EntityBase entityBase = (EntityBase)entry;
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSSUBSYSSADE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)false) == 0) {
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u63a5\u53e3\u5b9e\u4f53>";
            }
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 2) {
                return "pssubsyssades";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSUBSYSSADERS_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)false) == 0) {
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb>";
            }
            if (PSSubSysServiceAPIServiceBase.getMOSVer() == 2) {
                return "pssubsyssaderss";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSubSysServiceAPI pSSubSysServiceAPI, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "SubSysAPI");
        defaultValueMap.put("PSSUBSYSSERVICEAPINAME", "\u5916\u90e8\u63a5\u53e3");
    }
}
