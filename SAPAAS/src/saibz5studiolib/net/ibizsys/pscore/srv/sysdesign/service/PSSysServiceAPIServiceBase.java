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
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysServiceAPIDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysServiceAPIDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARSBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrjBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysServiceAPIServiceBase
extends PSCoreSysServiceBase<PSSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_ADDSYNCCLIENTMODELTASK = "X_ADDSYNCCLIENTMODELTASK";
    public static final String ACTION_CREATESUBSYSFILE = "CreateSubSysFile";
    public static final String ACTION_GENUNIQUETAG = "GenUniqueTag";
    public static final String ACTION_REBUILDBYAPPDE = "RebuildByAppDE";
    public static final String ACTION_REBUILDDESARS = "RebuildDESARS";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysServiceAPIDEModel pSSysServiceAPIDEModel;
    private PSSysServiceAPIDAO pSSysServiceAPIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService";
    }

    public PSSysServiceAPIDEModel getPSSysServiceAPIDEModel() {
        if (this.pSSysServiceAPIDEModel == null) {
            try {
                this.pSSysServiceAPIDEModel = (PSSysServiceAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysServiceAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysServiceAPIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysServiceAPIDEModel();
    }

    public PSSysServiceAPIDAO getPSSysServiceAPIDAO() {
        if (this.pSSysServiceAPIDAO == null) {
            try {
                this.pSSysServiceAPIDAO = (PSSysServiceAPIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysServiceAPIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysServiceAPIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysServiceAPIDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDSYNCCLIENTMODELTASK, (boolean)true) == 0) {
            this.addSyncClientModelTask((PSSysServiceAPI)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATESUBSYSFILE, (boolean)true) == 0) {
            this.createSubSysFile((PSSysServiceAPI)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GENUNIQUETAG, (boolean)true) == 0) {
            this.genUniqueTag((PSSysServiceAPI)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_REBUILDBYAPPDE, (boolean)true) == 0) {
            this.rebuildByAppDE((PSSysServiceAPI)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_REBUILDDESARS, (boolean)true) == 0) {
            this.rebuildDESARS((PSSysServiceAPI)iEntity);
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

    public void addSyncClientModelTask(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCCLIENTMODELTASK, 0, pSSysServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysServiceAPI, ACTION_X_ADDSYNCCLIENTMODELTASK);
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysServiceAPIServiceBase.this.getService(), PSSysServiceAPIServiceBase.ACTION_X_ADDSYNCCLIENTMODELTASK, 40, pSSysServiceAPI2, null).getResult() != 1) {
                    PSSysServiceAPIServiceBase.this.onAddSyncClientModelTask(pSSysServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCCLIENTMODELTASK, 99, pSSysServiceAPI, null);
        }
    }

    protected void onAddSyncClientModelTask(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDSYNCCLIENTMODELTASK]");
    }

    public void createSubSysFile(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATESUBSYSFILE, 0, pSSysServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysServiceAPI, ACTION_CREATESUBSYSFILE);
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysServiceAPIServiceBase.this.getService(), PSSysServiceAPIServiceBase.ACTION_CREATESUBSYSFILE, 40, pSSysServiceAPI2, null).getResult() != 1) {
                    PSSysServiceAPIServiceBase.this.onCreateSubSysFile(pSSysServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATESUBSYSFILE, 99, pSSysServiceAPI, null);
        }
    }

    protected void onCreateSubSysFile(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateSubSysFile]");
    }

    public void genUniqueTag(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GENUNIQUETAG, 0, pSSysServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysServiceAPI, ACTION_GENUNIQUETAG);
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysServiceAPIServiceBase.this.getService(), PSSysServiceAPIServiceBase.ACTION_GENUNIQUETAG, 40, pSSysServiceAPI2, null).getResult() != 1) {
                    PSSysServiceAPIServiceBase.this.onGenUniqueTag(pSSysServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GENUNIQUETAG, 99, pSSysServiceAPI, null);
        }
    }

    protected void onGenUniqueTag(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GenUniqueTag]");
    }

    public void rebuildByAppDE(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDBYAPPDE, 0, pSSysServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysServiceAPI, ACTION_REBUILDBYAPPDE);
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysServiceAPIServiceBase.this.getService(), PSSysServiceAPIServiceBase.ACTION_REBUILDBYAPPDE, 40, pSSysServiceAPI2, null).getResult() != 1) {
                    PSSysServiceAPIServiceBase.this.onRebuildByAppDE(pSSysServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDBYAPPDE, 99, pSSysServiceAPI, null);
        }
    }

    protected void onRebuildByAppDE(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RebuildByAppDE]");
    }

    public void rebuildDESARS(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDDESARS, 0, pSSysServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysServiceAPI, ACTION_REBUILDDESARS);
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysServiceAPIServiceBase.this.getService(), PSSysServiceAPIServiceBase.ACTION_REBUILDDESARS, 40, pSSysServiceAPI2, null).getResult() != 1) {
                    PSSysServiceAPIServiceBase.this.onRebuildDESARS(pSSysServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDDESARS, 99, pSSysServiceAPI, null);
        }
    }

    protected void onRebuildDESARS(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RebuildDESARS]");
    }

    protected void onFillParentInfo(PSSysServiceAPI pSSysServiceAPI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSDEOPPRIV_DEFAULTPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_DefaultPSDEOPPriv(pSSysServiceAPI, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysServiceAPI, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysServiceAPI, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSSysServiceAPI, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSSysServiceAPI, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSSAHANDLER_PSSYSSAHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService", (SessionFactory)this.getSessionFactory());
            PSSysSAHandler pSSysSAHandler = (PSSysSAHandler)iService.getDEModel().createEntity();
            pSSysSAHandler.set("PSSYSSAHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSAHandler);
            } else {
                iService.get(pSSysSAHandler);
            }
            this.onFillParentInfo_PSSysSAHandler(pSSysServiceAPI, pSSysSAHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_DEPSSysSFPlugin(pSSysServiceAPI, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysServiceAPI, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysServiceAPI, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSERVICEAPI_PSSYSTRANSLATOR_OUTPSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTranslator);
            } else {
                iService.get(pSSysTranslator);
            }
            this.onFillParentInfo_OutPSSysTranslator(pSSysServiceAPI, pSSysTranslator);
            return;
        }
        super.onFillParentInfo(pSSysServiceAPI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DefaultPSDEOPPriv(PSSysServiceAPI pSSysServiceAPI, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSSysServiceAPI.setDefaultPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSSysServiceAPI.setDefaultPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSModule(PSSysServiceAPI pSSysServiceAPI, PSModule pSModule) throws Exception {
        pSSysServiceAPI.setPSModuleId(pSModule.getPSModuleId());
        pSSysServiceAPI.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysServiceAPI pSSysServiceAPI, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysServiceAPI.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysServiceAPI.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSSysServiceAPI pSSysServiceAPI, PSSysReqItem pSSysReqItem) throws Exception {
        pSSysServiceAPI.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSSysServiceAPI.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysResource(PSSysServiceAPI pSSysServiceAPI, PSSysResource pSSysResource) throws Exception {
        pSSysServiceAPI.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSysServiceAPI.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSAHandler(PSSysServiceAPI pSSysServiceAPI, PSSysSAHandler pSSysSAHandler) throws Exception {
        pSSysServiceAPI.setPSSysSAHandlerId(pSSysSAHandler.getPSSysSAHandlerId());
        pSSysServiceAPI.setPSSysSAHandlerName(pSSysSAHandler.getPSSysSAHandlerName());
    }

    protected void onFillParentInfo_DEPSSysSFPlugin(PSSysServiceAPI pSSysServiceAPI, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysServiceAPI.setDEPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysServiceAPI.setDEPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysServiceAPI pSSysServiceAPI, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysServiceAPI.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysServiceAPI.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysServiceAPI pSSysServiceAPI, PSSystem pSSystem) throws Exception {
        pSSysServiceAPI.setPSSystemId(pSSystem.getPSSystemId());
        pSSysServiceAPI.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_OutPSSysTranslator(PSSysServiceAPI pSSysServiceAPI, PSSysTranslator pSSysTranslator) throws Exception {
        pSSysServiceAPI.setOutPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSSysServiceAPI.setOutPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillEntityFullInfo(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
        if (bl) {
            if (pSSysServiceAPI.getCodeName() == null) {
                pSSysServiceAPI.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ServiceAPI", 25));
            }
            if (pSSysServiceAPI.getDefDEDataSetReqMethod() == null) {
                pSSysServiceAPI.setDefDEDataSetReqMethod((String)this.getDefaultValue(this.getWebContext(), "", "GET", 25));
            }
            if (pSSysServiceAPI.getDefSelectReqMethod() == null) {
                pSSysServiceAPI.setDefSelectReqMethod((String)this.getDefaultValue(this.getWebContext(), "", "GET", 25));
            }
            if (pSSysServiceAPI.getPSSysServiceAPIName() == null) {
                pSSysServiceAPI.setPSSysServiceAPIName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u670d\u52a1\u63a5\u53e3", 25));
            }
            if (pSSysServiceAPI.getValidFlag() == null) {
                pSSysServiceAPI.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_DefaultPSDEOPPriv(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSModule(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysResource(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysSAHandler(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_DEPSSysSFPlugin(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysServiceAPI, bl);
        this.onFillEntityFullInfo_OutPSSysTranslator(pSSysServiceAPI, bl);
    }

    protected void onFillEntityFullInfo_DefaultPSDEOPPriv(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
        if (pSSysServiceAPI.isDefaultPSDEOPPrivIdDirty()) {
            if (pSSysServiceAPI.getDefaultPSDEOPPrivId() != null) {
                if (pSSysServiceAPI.getDefaultPSDEOPPrivId() == null || pSSysServiceAPI.getDefaultPSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSSysServiceAPI.getDefaultPSDEOPPriv();
                    pSSysServiceAPI.setDefaultPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSSysServiceAPI.setDefaultPSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSAHandler(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DEPSSysSFPlugin(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
        if (pSSysServiceAPI.isPSSystemIdDirty()) {
            if (pSSysServiceAPI.getPSSystemId() != null) {
                if (pSSysServiceAPI.getPSSystemId() == null || pSSysServiceAPI.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysServiceAPI.getPSSystem();
                    pSSysServiceAPI.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysServiceAPI.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OutPSSysTranslator(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysServiceAPI, bl);
    }

    public ArrayList<PSSysServiceAPI> selectByDefaultPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByDefaultPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByDefaultPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByDefaultPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByDefaultPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEFAULTPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDefaultPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDefaultPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysServiceAPI> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByPSSysSAHandler(PSSysSAHandlerBase pSSysSAHandlerBase) throws Exception {
        return this.selectByPSSysSAHandler(pSSysSAHandlerBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysSAHandler(PSSysSAHandlerBase pSSysSAHandlerBase, String string) throws Exception {
        return this.selectByPSSysSAHandler(pSSysSAHandlerBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysSAHandler(PSSysSAHandlerBase pSSysSAHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByDEPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByDEPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysServiceAPI> selectByOutPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByOutPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSSysServiceAPI> selectByOutPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByOutPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSSysServiceAPI> selectByOutPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByDefaultPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSDEOPPRIV_DEFAULTPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByDefaultPSDEOPPriv(pSDEOPPriv);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setDefaultPSDEOPPrivId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByDefaultPSDEOPPriv(pSDEOPPriv2);
                PSSysServiceAPIServiceBase.this.internalRemoveByDefaultPSDEOPPriv(pSDEOPPriv2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByDefaultPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByDefaultPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByDefaultPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByDefaultPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDefaultPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSModule(pSModule);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setPSModuleId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysServiceAPIServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setPSSysDynaModelId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysServiceAPIServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setPSSysReqItemId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysServiceAPIServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setPSSysResourceId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSSysServiceAPIServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysSAHandler(pSSysSAHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSAHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSAHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSSAHANDLER_PSSYSSAHANDLERID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysSAHandler), arrayList.get(0)));
        }
    }

    public void resetPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysSAHandler(pSSysSAHandler);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setPSSysSAHandlerId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        final PSSysSAHandler pSSysSAHandler2 = pSSysSAHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysSAHandler(pSSysSAHandler2);
                PSSysServiceAPIServiceBase.this.internalRemoveByPSSysSAHandler(pSSysSAHandler2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByPSSysSAHandler(pSSysSAHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
    }

    protected void internalRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysSAHandler(pSSysSAHandler);
        this.onBeforeRemoveByPSSysSAHandler(pSSysSAHandler, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByPSSysSAHandler(pSSysSAHandler, arrayList);
    }

    protected void onAfterRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSAHandler(PSSysSAHandler pSSysSAHandler, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setDEPSSysSFPluginId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
                PSSysServiceAPIServiceBase.this.internalRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByDEPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByDEPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setPSSysSFPluginId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysServiceAPIServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setPSSystemId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysServiceAPIServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByOutPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSERVICEAPI_PSSYSTRANSLATOR_OUTPSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSSYSSERVICEAPI", iDataEntityModel.getDataInfo(pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByOutPSSysTranslator(pSSysTranslator);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getDEModel().createEntity();
            pSSysServiceAPI2.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSSysServiceAPI2.setOutPSSysTranslatorId(null);
            this.update(pSSysServiceAPI2);
        }
    }

    public void removeByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysServiceAPIServiceBase.this.onBeforeRemoveByOutPSSysTranslator(pSSysTranslator2);
                PSSysServiceAPIServiceBase.this.internalRemoveByOutPSSysTranslator(pSSysTranslator2);
                PSSysServiceAPIServiceBase.this.onAfterRemoveByOutPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysServiceAPI> arrayList = this.selectByOutPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByOutPSSysTranslator(pSSysTranslator, arrayList);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList) {
            this.remove(pSSysServiceAPI);
        }
        this.onAfterRemoveByOutPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSSysServiceAPI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESARSServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAISchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSerrviceAPI(pSSysServiceAPI);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSysSerrviceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchSchemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        pSCoreSysServiceBase = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniResServiceBase)pSCoreSysServiceBase).testRemoveByPSSysServiceAPI(pSSysServiceAPI);
        super.onBeforeRemove(pSSysServiceAPI);
    }

    protected void replaceParentInfo(PSSysServiceAPI pSSysServiceAPI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysServiceAPI, cloneSession);
        if (pSSysServiceAPI.getDefaultPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSSysServiceAPI.getDefaultPSDEOPPrivId())) != null) {
            this.onFillParentInfo_DefaultPSDEOPPriv(pSSysServiceAPI, (PSDEOPPriv)iEntity);
        }
        if (pSSysServiceAPI.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysServiceAPI.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysServiceAPI, (PSModule)iEntity);
        }
        if (pSSysServiceAPI.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysServiceAPI.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysServiceAPI, (PSSysDynaModel)iEntity);
        }
        if (pSSysServiceAPI.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSysServiceAPI.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSSysServiceAPI, (PSSysReqItem)iEntity);
        }
        if (pSSysServiceAPI.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSysServiceAPI.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSSysServiceAPI, (PSSysResource)iEntity);
        }
        if (pSSysServiceAPI.getPSSysSAHandlerId() != null && (iEntity = cloneSession.getEntity("PSSYSSAHANDLER", (Object)pSSysServiceAPI.getPSSysSAHandlerId())) != null) {
            this.onFillParentInfo_PSSysSAHandler(pSSysServiceAPI, (PSSysSAHandler)iEntity);
        }
        if (pSSysServiceAPI.getDEPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysServiceAPI.getDEPSSysSFPluginId())) != null) {
            this.onFillParentInfo_DEPSSysSFPlugin(pSSysServiceAPI, (PSSysSFPlugin)iEntity);
        }
        if (pSSysServiceAPI.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysServiceAPI.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysServiceAPI, (PSSysSFPlugin)iEntity);
        }
        if (pSSysServiceAPI.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysServiceAPI.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysServiceAPI, (PSSystem)iEntity);
        }
        if (pSSysServiceAPI.getOutPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSSysServiceAPI.getOutPSSysTranslatorId())) != null) {
            this.onFillParentInfo_OutPSSysTranslator(pSSysServiceAPI, (PSSysTranslator)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysServiceAPI, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_APILevel(bl, pSSysServiceAPI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APIMode(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APITag(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APITag2(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APIType(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthCheckTokenUri(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthClientSecret(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthMode(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam2(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam3(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AuthParam4(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BaseClsParams(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgPSModelStorageId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CfgTag(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeNameMode(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultPort(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultPSDEOPPrivId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultPSDEOPPrivName(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefCreateReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefDEActionReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefDEDataSetReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefDeleteReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefGetDraftReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefGetReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefNeedResourceKey(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefSelectReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefUpdateReqMethod(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEPSSysSFPluginId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAPIModelEx(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableGateway(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreAuthPatterns(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamingService(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSysTranslatorId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAPIId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSAHandlerId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIName(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResetDefActionCodeName(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceDTOFlag(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam2(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam3(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam4(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParams(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceType(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTag(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Ver(bl, pSSysServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysServiceAPI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_APILevel(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAPILevelDirty() : !pSSysServiceAPI.isAPILevelDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getAPILevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_APILevel_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APILEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APIMode(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAPIModeDirty() : !pSSysServiceAPI.isAPIModeDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getAPIMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_APIMode_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APIMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APITag(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAPITagDirty() : !pSSysServiceAPI.isAPITagDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAPITag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APITag_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_APITag2(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAPITag2Dirty() : !pSSysServiceAPI.isAPITag2Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAPITag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APITag2_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_APIType(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAPITypeDirty() && !bl2 : !pSSysServiceAPI.isAPITypeDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAPIType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APITYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_APIType_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthCheckTokenUri(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthCheckTokenUriDirty() : !pSSysServiceAPI.isAuthCheckTokenUriDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthCheckTokenUri();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthCheckTokenUri_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTHCHECKTOKENURI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AuthClientId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthClientIdDirty() : !pSSysServiceAPI.isAuthClientIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthClientId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthClientSecret(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthClientSecretDirty() : !pSSysServiceAPI.isAuthClientSecretDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthClientSecret();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthClientSecret_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthMode(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthModeDirty() : !pSSysServiceAPI.isAuthModeDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthMode_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthParamDirty() : !pSSysServiceAPI.isAuthParamDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam2(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthParam2Dirty() : !pSSysServiceAPI.isAuthParam2Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam2_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam3(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthParam3Dirty() : !pSSysServiceAPI.isAuthParam3Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam3_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_AuthParam4(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isAuthParam4Dirty() : !pSSysServiceAPI.isAuthParam4Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getAuthParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AuthParam4_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isBaseClsParamsDirty() : !pSSysServiceAPI.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CfgPSModelStorageId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isCfgPSModelStorageIdDirty() : !pSSysServiceAPI.isCfgPSModelStorageIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getCfgPSModelStorageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgPSModelStorageId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CfgTag(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isCfgTagDirty() : !pSSysServiceAPI.isCfgTagDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getCfgTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgTag_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isCodeNameDirty() && !bl2 : !pSSysServiceAPI.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysServiceAPIDEModel(), "CODENAME", string3, pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeNameMode(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isCodeNameModeDirty() : !pSSysServiceAPI.isCodeNameModeDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getCodeNameMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeNameMode_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isCustomCodeDirty() : !pSSysServiceAPI.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isCustomModeDirty() : !pSSysServiceAPI.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultPort(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefaultPortDirty() : !pSSysServiceAPI.isDefaultPortDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getDefaultPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultPort_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultPSDEOPPrivId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefaultPSDEOPPrivIdDirty() : !pSSysServiceAPI.isDefaultPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefaultPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultPSDEOPPrivId_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultPSDEOPPrivName(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefaultPSDEOPPrivNameDirty() : !pSSysServiceAPI.isDefaultPSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefaultPSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultPSDEOPPrivName_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefCreateReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefCreateReqMethodDirty() : !pSSysServiceAPI.isDefCreateReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefCreateReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefCreateReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefDEActionReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefDEActionReqMethodDirty() : !pSSysServiceAPI.isDefDEActionReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefDEActionReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefDEActionReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefDEDataSetReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefDEDataSetReqMethodDirty() : !pSSysServiceAPI.isDefDEDataSetReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefDEDataSetReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefDEDataSetReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefDeleteReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefDeleteReqMethodDirty() : !pSSysServiceAPI.isDefDeleteReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefDeleteReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefDeleteReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefGetDraftReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefGetDraftReqMethodDirty() : !pSSysServiceAPI.isDefGetDraftReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefGetDraftReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefGetDraftReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefGetReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefGetReqMethodDirty() : !pSSysServiceAPI.isDefGetReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefGetReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefGetReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefNeedResourceKey(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefNeedResourceKeyDirty() : !pSSysServiceAPI.isDefNeedResourceKeyDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getDefNeedResourceKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefNeedResourceKey_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefSelectReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefSelectReqMethodDirty() : !pSSysServiceAPI.isDefSelectReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefSelectReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefSelectReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefUpdateReqMethod(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDefUpdateReqMethodDirty() : !pSSysServiceAPI.isDefUpdateReqMethodDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDefUpdateReqMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefUpdateReqMethod_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEPSSysSFPluginId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isDEPSSysSFPluginIdDirty() : !pSSysServiceAPI.isDEPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getDEPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEPSSysSFPluginId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableAPIModelEx(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isEnableAPIModelExDirty() : !pSSysServiceAPI.isEnableAPIModelExDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getEnableAPIModelEx();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAPIModelEx_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableGateway(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isEnableGatewayDirty() : !pSSysServiceAPI.isEnableGatewayDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getEnableGateway();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableGateway_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEGATEWAY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreAuthPatterns(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isIgnoreAuthPatternsDirty() : !pSSysServiceAPI.isIgnoreAuthPatternsDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getIgnoreAuthPatterns();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IgnoreAuthPatterns_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREAUTHPATTERNS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isLockFlagDirty() : !pSSysServiceAPI.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isMemoDirty() : !pSSysServiceAPI.isMemoDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_NamingService(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isNamingServiceDirty() : !pSSysServiceAPI.isNamingServiceDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getNamingService();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamingService_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMINGSERVICE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isOrderValueDirty() : !pSSysServiceAPI.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutPSSysTranslatorId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isOutPSSysTranslatorIdDirty() : !pSSysServiceAPI.isOutPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getOutPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSysTranslatorId_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPredefinedTypeDirty() : !pSSysServiceAPI.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysAPIId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSDevSlnSysAPIIdDirty() : !pSSysServiceAPI.isPSDevSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSDevSlnSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAPIId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSModuleIdDirty() : !pSSysServiceAPI.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSysDynaModelIdDirty() : !pSSysServiceAPI.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSysReqItemIdDirty() : !pSSysServiceAPI.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSysResourceIdDirty() : !pSSysServiceAPI.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSAHandlerId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSysSAHandlerIdDirty() : !pSSysServiceAPI.isPSSysSAHandlerIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSysSAHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSAHandlerId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSysServiceAPIIdDirty() && !bl2 : !pSSysServiceAPI.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSysServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysServiceAPIName(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSysServiceAPINameDirty() && !bl2 : !pSSysServiceAPI.isPSSysServiceAPINameDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSysServiceAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIName_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPINAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysServiceAPIDEModel(), "PSSYSSERVICEAPINAME", string3, pSSysServiceAPI, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSERVICEAPINAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSysSFPluginIdDirty() : !pSSysServiceAPI.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSystemIdDirty() && !bl2 : !pSSysServiceAPI.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isPSSystemNameDirty() && !bl2 : !pSSysServiceAPI.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResetDefActionCodeName(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isResetDefActionCodeNameDirty() : !pSSysServiceAPI.isResetDefActionCodeNameDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getResetDefActionCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResetDefActionCodeName_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceCodeNameDirty() : !pSSysServiceAPI.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceDTOFlag(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceDTOFlagDirty() : !pSSysServiceAPI.isServiceDTOFlagDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getServiceDTOFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ServiceDTOFlag_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceParamDirty() : !pSSysServiceAPI.isServiceParamDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getServiceParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam2(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceParam2Dirty() : !pSSysServiceAPI.isServiceParam2Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getServiceParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam2_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam3(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceParam3Dirty() : !pSSysServiceAPI.isServiceParam3Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getServiceParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam3_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam4(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceParam4Dirty() : !pSSysServiceAPI.isServiceParam4Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getServiceParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam4_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParams(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceParamsDirty() : !pSSysServiceAPI.isServiceParamsDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getServiceParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParams_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceType(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isServiceTypeDirty() : !pSSysServiceAPI.isServiceTypeDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getServiceType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceType_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UniqueTag(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isUniqueTagDirty() : !pSSysServiceAPI.isUniqueTagDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getUniqueTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTag_Default(pSSysServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAG");
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
                String string4 = this.checkFieldDupRule(this.getPSSysServiceAPIDEModel(), "UNIQUETAG", string3, pSSysServiceAPI, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("UNIQUETAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isUserCatDirty() : !pSSysServiceAPI.isUserCatDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isUserTagDirty() : !pSSysServiceAPI.isUserTagDirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isUserTag2Dirty() : !pSSysServiceAPI.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isUserTag3Dirty() : !pSSysServiceAPI.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isUserTag4Dirty() : !pSSysServiceAPI.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysServiceAPI.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isValidFlagDirty() && !bl2 : !pSSysServiceAPI.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_Ver(boolean bl, PSSysServiceAPI pSSysServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysServiceAPI.isVerDirty() && !bl2 : !pSSysServiceAPI.isVerDirty()) {
            return null;
        }
        Integer n = pSSysServiceAPI.getVer();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Ver_Default(pSSysServiceAPI, bl2, bl3);
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

    protected void onSyncEntity(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
        super.onSyncEntity(pSSysServiceAPI, bl);
    }

    protected void onSyncIndexEntities(PSSysServiceAPI pSSysServiceAPI, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysServiceAPI, bl);
    }

    public Object getDataContextValue(PSSysServiceAPI pSSysServiceAPI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysServiceAPI, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysServiceAPI pSSysServiceAPI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysServiceAPI, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APILEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APILevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APIMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APIMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"AUTHCHECKTOKENURI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthCheckTokenUri_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"AUTHPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTHPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AuthParam4_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultPSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultPSDEOPPrivName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLEGATEWAY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableGateway_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREAUTHPATTERNS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreAuthPatterns_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMINGSERVICE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamingService_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAPIId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SERVICETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIQUETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniqueTag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_APILevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_APIMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_AuthCheckTokenUri_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AUTHCHECKTOKENURI", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DefaultPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultPSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultPSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_EnableGateway_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IgnoreAuthPatterns_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IGNOREAUTHPATTERNS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_NamingService_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMINGSERVICE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutPSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_UniqueTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIQUETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysServiceAPI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        super.onUpdateParent(pSSysServiceAPI);
    }

    @Override
    protected void exportCurXmlModel(PSSysServiceAPI pSSysServiceAPI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSERVICEAPI");
        if (!bl) {
            pSSysServiceAPI.setCreateDate(null);
            pSSysServiceAPI.setCreateMan(null);
            pSSysServiceAPI.setPSSysServiceAPIId(null);
            pSSysServiceAPI.setUpdateDate(null);
            pSSysServiceAPI.setUpdateMan(null);
            super.exportCurXmlModel(pSSysServiceAPI, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysServiceAPI pSSysServiceAPI, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysServiceAPI, string);
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
            return "DER1N_PSSYSSERVICEAPI_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysServiceAPI pSSysServiceAPI) {
        if (!StringHelper.isNullOrEmpty((String)pSSysServiceAPI.getCodeName())) {
            return pSSysServiceAPI.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysServiceAPI.getPSSysServiceAPIName())) {
            return pSSysServiceAPI.getPSSysServiceAPIName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysServiceAPI.getCodeName())) {
            return pSSysServiceAPI.getCodeName();
        }
        return super.getModelV2Tag(pSSysServiceAPI);
    }

    @Override
    public boolean setModelV2Tag(PSSysServiceAPI pSSysServiceAPI, String string) {
        pSSysServiceAPI.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSSERVICEAPINAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("UNIQUETAG", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysServiceAPI pSSysServiceAPI, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysServiceAPI.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysServiceAPI, true);
        pSSysServiceAPI.set("CODENAME", string);
        if (this.select(pSSysServiceAPI, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysServiceAPI, true);
        return super.getModelV2Entity(pSSysServiceAPI, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysServiceAPI pSSysServiceAPI, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysServiceAPI, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysServiceAPI pSSysServiceAPI, String string, String string2) throws Exception {
        String string3;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSTESTPRJ", (Object)pSSysServiceAPI.getPSSysServiceAPIId()))).exists()) {
            PSSysTestPrj entityBase;
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysTestPrj();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysTestPrj)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSTESTPRJ", (Object)entityBase.getPSSysTestPrjId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDESERVICEAPI", (Object)pSSysServiceAPI.getPSSysServiceAPIId()))).exists()) {
            PSDEServiceAPI entityBase;
            pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDEServiceAPI();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEServiceAPI)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDESERVICEAPI", (Object)entityBase.getPSDEServiceAPIId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDESARS", (Object)pSSysServiceAPI.getPSSysServiceAPIId()))).exists()) {
            PSDESARS entityBase;
            pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDESARS();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDESARSServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDESARS)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDESARS", (Object)entityBase.getPSDESARSId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysServiceAPI, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysServiceAPI pSSysServiceAPI, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID")) {
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTESTPRJ", (Object)pSSysServiceAPI.getPSSysServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSSERVICEAPI#%1$s", (Object)pSSysServiceAPI.getPSSysServiceAPIId());
                for (PSSysTestPrj entity : ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).selectByPSSysServiceAPI(pSSysServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity), (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode nodes = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssystestprjname")) {
                            string = objectNode.get("pssystestprjname").asText();
                        }
                        if (objectNode2.has("pssystestprjname")) {
                            string2 = objectNode2.get("pssystestprjname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSSysTestPrj entity = new PSSysTestPrj();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, node, false);
                    nodes.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID")) {
            pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDESERVICEAPI", (Object)pSSysServiceAPI.getPSSysServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSSERVICEAPI#%1$s", (Object)pSSysServiceAPI.getPSSysServiceAPIId());
                for (PSDEServiceAPI entity : ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).selectByPSSysServiceAPI(pSSysServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity), (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode nodes = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeserviceapiname")) {
                            string = objectNode.get("psdeserviceapiname").asText();
                        }
                        if (objectNode2.has("psdeserviceapiname")) {
                            string2 = objectNode2.get("psdeserviceapiname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEServiceAPI entity = new PSDEServiceAPI();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, node, false);
                    nodes.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID")) {
            pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDESARS", (Object)pSSysServiceAPI.getPSSysServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSSERVICEAPI#%1$s", (Object)pSSysServiceAPI.getPSSysServiceAPIId());
                for (PSDESARS entity : ((PSDESARSServiceBase)pSCoreSysServiceBase).selectByPSSysServiceAPI(pSSysServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSDESARSServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity), (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode nodes = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdesarsname")) {
                            string = objectNode.get("psdesarsname").asText();
                        }
                        if (objectNode2.has("psdesarsname")) {
                            string2 = objectNode2.get("psdesarsname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDESARS entity = new PSDESARS();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, node, false);
                    nodes.add((JsonNode)pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysServiceAPI, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        super.onEmptyModelV2(pSSysServiceAPI);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysServiceAPI pSSysServiceAPI, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysTestPrj();
        entityBase.set("PSSYSSERVICEAPIID", pSSysServiceAPI.getPSSysServiceAPIId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEServiceAPI();
        entityBase.set("PSSYSSERVICEAPIID", pSSysServiceAPI.getPSSysServiceAPIId());
        pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDESARS();
        entityBase.set("PSSYSSERVICEAPIID", pSSysServiceAPI.getPSSysServiceAPIId());
        pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysServiceAPI, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysServiceAPI pSSysServiceAPI, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    PSSysTestPrj entity = new PSSysTestPrj();
                    entity.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                    entity.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(entity, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSSysTestPrj entity = new PSSysTestPrj();
                        entity.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                        entity.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    PSDEServiceAPI entity = new PSDEServiceAPI();
                    entity.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                    entity.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(entity, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSDEServiceAPI entity = new PSDEServiceAPI();
                        entity.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                        entity.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    PSDESARS entity = new PSDESARS();
                    entity.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                    entity.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(entity, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (File child : ((File)object2).listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSDESARS entity = new PSDESARS();
                        entity.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                        entity.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysServiceAPI, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysServiceAPI pSSysServiceAPI, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEServiceAPIs(pSSysServiceAPI, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDESARSes(pSSysServiceAPI, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysServiceAPI, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEServiceAPIs(PSSysServiceAPI pSSysServiceAPI, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDESERVICEAPI", true), (boolean)false) == 0) {
            PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
            pSDEServiceAPI.setPSDEServiceAPIId(pSMOSFile.getPSModelId());
            if (!pSDEServiceAPIService.get(pSDEServiceAPI, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEServiceAPI.getPSSysServiceAPIId(), (String)pSSysServiceAPI.getPSSysServiceAPIId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEServiceAPIService.exportModelV2(pSDEServiceAPI);
            pSDEServiceAPI.reset();
            if (!pSDEServiceAPIService.setModelV2ResScope(pSDEServiceAPI, "PSSYSSERVICEAPI", pSSysServiceAPI.getPSSysServiceAPIId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEServiceAPIService.importModelV2(pSDEServiceAPI, objectNode);
            SessionFactoryManager.commit();
            return pSDEServiceAPIService.getFile(pSDEServiceAPI);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDATAENTITY", true), (boolean)false) == 0) {
            PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.setPSDataEntityId(pSMOSFile.getPSModelId());
            if (!pSDataEntityService.get(pSDataEntity, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
            pSDEServiceAPI.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSDEServiceAPI.setPSDEId(pSDataEntity.getPSDataEntityId());
            this.fillPasteEntity(pSDEServiceAPI, "PASTETAG");
            pSDEServiceAPIService.create(pSDEServiceAPI);
            SessionFactoryManager.commit();
            return pSDEServiceAPIService.getFile(pSDEServiceAPI);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDESARSes(PSSysServiceAPI pSSysServiceAPI, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDESARS", true), (boolean)false) == 0) {
            PSDESARSService pSDESARSService = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
            PSDESARS pSDESARS = new PSDESARS();
            pSDESARS.setPSDESARSId(pSMOSFile.getPSModelId());
            if (!pSDESARSService.get(pSDESARS, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDESARS.getPSSysServiceAPIId(), (String)pSSysServiceAPI.getPSSysServiceAPIId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDESARSService.exportModelV2(pSDESARS);
            pSDESARS.reset();
            if (!pSDESARSService.setModelV2ResScope(pSDESARS, "PSSYSSERVICEAPI", pSSysServiceAPI.getPSSysServiceAPIId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDESARSService.importModelV2(pSDESARS, objectNode);
            SessionFactoryManager.commit();
            return pSDESARSService.getFile(pSDESARS);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysServiceAPI pSSysServiceAPI, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEServiceAPIs(pSSysServiceAPI, list);
        this.onFillPasteHelps_PSDESARSes(pSSysServiceAPI, list);
        super.onFillPasteHelps(pSSysServiceAPI, list);
    }

    protected void onFillPasteHelps_PSDEServiceAPIs(PSSysServiceAPI pSSysServiceAPI, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESERVICEAPI");
        pSHelpSection.setSectionParam2("DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3]\u7684[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESERVICEAPI");
        pSHelpSection.setSectionParam2("DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID");
        pSHelpSection.setUserTag("DER1N_PSDESERVICEAPI_PSDATAENTITY_PSDEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u5b9e\u4f53\u7684[\u5b9e\u4f53]\u6784\u5efa[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDESARSes(PSSysServiceAPI pSSysServiceAPI, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESARS");
        pSHelpSection.setSectionParam2("DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3]\u7684[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5b9e\u4f53\u63a5\u53e3>", "DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5b9e\u4f53\u63a5\u53e3>");
            } else if (PSSysServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdeserviceapis");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID|PSSYSSERVICEAPIID");
            pSMOSFile2.setFileTag3("PSDESERVICEAPI");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u63a5\u53e3\u5173\u7cfb>", "DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u63a5\u53e3\u5173\u7cfb>");
            } else if (PSSysServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdesarses");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID|PSSYSSERVICEAPIID");
            pSMOSFile2.setFileTag3("PSDESARS");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSSysServiceAPIServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u6d4b\u8bd5\u9879\u76ee>", "DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6d4b\u8bd5\u9879\u76ee>");
            } else if (PSSysServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystestprjs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID|PSSYSSERVICEAPIID");
            pSMOSFile2.setFileTag3("PSSYSTESTPRJ");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<?> arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSSysServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5b9e\u4f53\u63a5\u53e3>", (boolean)false) == 0 || PSSysServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEServiceAPIs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entry : arrayList) {
                EntityBase entityBase = (EntityBase)entry;
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u63a5\u53e3\u5173\u7cfb>", (boolean)false) == 0 || PSSysServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDESARSes", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (Object entry : arrayList) {
                EntityBase entityBase = (EntityBase)entry;
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u6d4b\u8bd5\u9879\u76ee>", (boolean)false) == 0 || PSSysServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"pssystestprjs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "PSSYSSERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)false) == 0) {
            if (PSSysServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u5b9e\u4f53\u63a5\u53e3>";
            }
            if (PSSysServiceAPIServiceBase.getMOSVer() == 2) {
                return "psdeserviceapis";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDESARS_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)false) == 0) {
            if (PSSysServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u63a5\u53e3\u5173\u7cfb>";
            }
            if (PSSysServiceAPIServiceBase.getMOSVer() == 2) {
                return "psdesarses";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTPRJ_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)false) == 0) {
            if (PSSysServiceAPIServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u6d4b\u8bd5\u9879\u76ee>";
            }
            if (PSSysServiceAPIServiceBase.getMOSVer() == 2) {
                return "pssystestprjs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysServiceAPI pSSysServiceAPI, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ServiceAPI");
        defaultValueMap.put("PSSYSSERVICEAPINAME", "\u670d\u52a1\u63a5\u53e3");
    }
}
