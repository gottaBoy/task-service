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
import net.ibizsys.paas.db.SelectCond;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysERMapDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysERMapDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysERMapServiceBase
extends PSCoreSysServiceBase<PSSysERMap> {
    private static final Log log = LogFactory.getLog(PSSysERMapServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_ADDDATAENTITIES = "ADDDATAENTITIES";
    public static final String ACTION_CALCCONNECTION = "CALCCONNECTION";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_GETWITHMODEL2 = "GetWithModel2";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSSysERMapDEModel pSSysERMapDEModel;
    private PSSysERMapDAO pSSysERMapDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService";
    }

    public PSSysERMapDEModel getPSSysERMapDEModel() {
        if (this.pSSysERMapDEModel == null) {
            try {
                this.pSSysERMapDEModel = (PSSysERMapDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysERMapDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysERMapDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysERMapDEModel();
    }

    public PSSysERMapDAO getPSSysERMapDAO() {
        if (this.pSSysERMapDAO == null) {
            try {
                this.pSSysERMapDAO = (PSSysERMapDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysERMapDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysERMapDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysERMapDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_ADDDATAENTITIES, (boolean)true) == 0) {
            this.addDataEntities((PSSysERMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CALCCONNECTION, (boolean)true) == 0) {
            this.calcConnection((PSSysERMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSSysERMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSSysERMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSSysERMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSSysERMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL2, (boolean)true) == 0) {
            this.getWithModel2((PSSysERMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSSysERMap)iEntity);
            return;
        }
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

    public void addDataEntities(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_ADDDATAENTITIES, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_ADDDATAENTITIES);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_ADDDATAENTITIES, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onAddDataEntities(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_ADDDATAENTITIES, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onAddDataEntities(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ADDDATAENTITIES]");
    }

    public void calcConnection(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCCONNECTION, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_CALCCONNECTION);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_CALCCONNECTION, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onCalcConnection(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCCONNECTION, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onCalcConnection(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CALCCONNECTION]");
    }

    public void createWithModel(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_CREATEWITHMODEL);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onCreateWithModel(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onCreateWithModel(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_GETDRAFTFROMWITHMODEL);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onGetDraftFromWithModel(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onGetDraftFromWithModel(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_GETDRAFTWITHMODEL);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onGetDraftWithModel(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onGetDraftWithModel(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_GETWITHMODEL);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onGetWithModel(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onGetWithModel(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void getWithModel2(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL2, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_GETWITHMODEL2);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_GETWITHMODEL2, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onGetWithModel2(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL2, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onGetWithModel2(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel2]");
    }

    public void updateWithModel(PSSysERMap pSSysERMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSSysERMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysERMap, ACTION_UPDATEWITHMODEL);
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysERMapServiceBase.this.getService(), PSSysERMapServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSSysERMap2, null).getResult() != 1) {
                    PSSysERMapServiceBase.this.onUpdateWithModel(pSSysERMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSSysERMap, null);
        }
    }

    protected void onUpdateWithModel(PSSysERMap pSSysERMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSSysERMap pSSysERMap, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAP_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysERMap, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAP_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysERMap, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysERMap, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysERMap, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysERMap pSSysERMap, PSModule pSModule) throws Exception {
        pSSysERMap.setPSModuleId(pSModule.getPSModuleId());
        pSSysERMap.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysERMap pSSysERMap, PSSysApp pSSysApp) throws Exception {
        pSSysERMap.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysERMap.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSystem(PSSysERMap pSSysERMap, PSSystem pSSystem) throws Exception {
        pSSysERMap.setPSSystemId(pSSystem.getPSSystemId());
        pSSysERMap.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysERMap pSSysERMap, boolean bl) throws Exception {
        if (bl) {
            if (pSSysERMap.getAllEntityFlag() == null) {
                pSSysERMap.setAllEntityFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysERMap.getIncSubSysFlag() == null) {
                pSSysERMap.setIncSubSysFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysERMap, bl);
        this.onFillEntityFullInfo_PSModule(pSSysERMap, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysERMap, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysERMap, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysERMap pSSysERMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysERMap pSSysERMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysERMap pSSysERMap, boolean bl) throws Exception {
        if (pSSysERMap.isPSSystemIdDirty()) {
            if (pSSysERMap.getPSSystemId() != null) {
                if (pSSysERMap.getPSSystemId() == null || pSSysERMap.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysERMap.getPSSystem();
                    pSSysERMap.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysERMap.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysERMap pSSysERMap, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysERMap, bl);
    }

    public ArrayList<PSSysERMap> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysERMap> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysERMap> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysERMap> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysERMap> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysERMap> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMap> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysERMap> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysERMap> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSSysERMap> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSERMAP_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSERMAP", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysERMap> arrayList = this.selectByPSModule(pSModule);
        for (PSSysERMap pSSysERMap : arrayList) {
            PSSysERMap pSSysERMap2 = (PSSysERMap)this.getDEModel().createEntity();
            pSSysERMap2.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
            pSSysERMap2.setPSModuleId(null);
            this.update(pSSysERMap2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysERMapServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysERMapServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysERMap> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysERMap pSSysERMap : arrayList) {
            this.remove((IEntity)pSSysERMap);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysERMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysERMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysERMap> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysERMap pSSysERMap : arrayList) {
            PSSysERMap pSSysERMap2 = (PSSysERMap)this.getDEModel().createEntity();
            pSSysERMap2.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
            pSSysERMap2.setPSSysAppId(null);
            this.update(pSSysERMap2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysERMapServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysERMapServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysERMap> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysERMap pSSysERMap : arrayList) {
            this.remove((IEntity)pSSysERMap);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysERMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysERMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysERMap> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysERMap pSSysERMap : arrayList) {
            PSSysERMap pSSysERMap2 = (PSSysERMap)this.getDEModel().createEntity();
            pSSysERMap2.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
            pSSysERMap2.setPSSystemId(null);
            this.update(pSSysERMap2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysERMapServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysERMapServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysERMap> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysERMap pSSysERMap : arrayList) {
            this.remove((IEntity)pSSysERMap);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysERMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysERMap> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysERMap pSSysERMap) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        pSSysERMapNodeService.testRemoveByPSSysERMap(pSSysERMap);
        pSSysERMapNodeService.removeByPSSysERMap(pSSysERMap);
        super.onBeforeRemove(pSSysERMap);
    }

    protected void onBeforeRemoveTemp(PSSysERMap pSSysERMap) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        pSSysERMapNodeService.removeTempByPSSysERMap(pSSysERMap);
        super.onBeforeRemoveTemp((IEntity)pSSysERMap);
    }

    protected void getRelatedDataTempMajor(PSSysERMap pSSysERMap) throws Exception {
        this.getRelatedDataTempMajor_PSSysERMapNode(pSSysERMap);
        super.getRelatedDataTempMajor((IEntity)pSSysERMap);
    }

    protected void getRelatedDataTempMajor_PSSysERMapNode(PSSysERMap pSSysERMap) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysERMapNode> arrayList = null;
        String string = pSSysERMap.getPSSysERMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap) : pSSysERMapNodeService.selectTempByPSSysERMap(pSSysERMap);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            pSSysERMapNodeService.getTempMajor(pSSysERMapNode);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysERMap pSSysERMap, PSSysERMap pSSysERMap2) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.updateRelatedDataTempMajor_removePSSysERMapNode(pSSysERMap, pSSysERMap2);
        this.updateRelatedDataTempMajor_updatePSSysERMapNode(pSSysERMap, pSSysERMap2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysERMap, (IEntity)pSSysERMap2);
    }

    protected ArrayList<PSSysERMapNode> updateRelatedDataTempMajor_removePSSysERMapNode(PSSysERMap pSSysERMap, PSSysERMap pSSysERMap2) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysERMapNode> arrayList = pSSysERMapNodeService.selectTempByPSSysERMap(pSSysERMap);
        ArrayList<PSSysERMapNode> arrayList2 = pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap2);
        HashMap<String, PSSysERMapNode> hashMap = new HashMap<String, PSSysERMapNode>();
        for (PSSysERMapNode pSSysERMapNode : arrayList2) {
            hashMap.put(pSSysERMapNode.getPSSysERMapNodeId(), pSSysERMapNode);
        }
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            Object object = pSSysERMapNode.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysERMapNode pSSysERMapNode : hashMap.values()) {
            pSSysERMapNodeService.remove((IEntity)pSSysERMapNode);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysERMapNode(PSSysERMap pSSysERMap, PSSysERMap pSSysERMap2, ArrayList<PSSysERMapNode> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            pSSysERMapNodeService.updateTempMajor(pSSysERMapNode);
        }
    }

    protected void replaceParentInfo(PSSysERMap pSSysERMap, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysERMap, cloneSession);
        if (pSSysERMap.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysERMap.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysERMap, (PSModule)iEntity);
        }
        if (pSSysERMap.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysERMap.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysERMap, (PSSysApp)iEntity);
        }
        if (pSSysERMap.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysERMap.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysERMap, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysERMap pSSysERMap, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysERMap, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllEntityFlag(bl, pSSysERMap, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefViewMode(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ERModel(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncSubSysFlag(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapTag(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapTag2(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysERMapId(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysERMapName(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeParams(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysERMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysERMap, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllEntityFlag(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isAllEntityFlagDirty() : !pSSysERMap.isAllEntityFlagDirty()) {
            return null;
        }
        Integer n = pSSysERMap.getAllEntityFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllEntityFlag_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLENTITYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isCodeNameDirty() && !bl2 : !pSSysERMap.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysERMap.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysERMap, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysERMapDEModel(), "CODENAME", string3, pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefViewMode(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isDefViewModeDirty() : !pSSysERMap.isDefViewModeDirty()) {
            return null;
        }
        String string = pSSysERMap.getDefViewMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefViewMode_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFVIEWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ERModel(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isERModelDirty() : !pSSysERMap.isERModelDirty()) {
            return null;
        }
        String string = pSSysERMap.getERModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ERModel_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncSubSysFlag(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isIncSubSysFlagDirty() : !pSSysERMap.isIncSubSysFlagDirty()) {
            return null;
        }
        Integer n = pSSysERMap.getIncSubSysFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncSubSysFlag_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCSUBSYSFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapTag(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isMapTagDirty() : !pSSysERMap.isMapTagDirty()) {
            return null;
        }
        String string = pSSysERMap.getMapTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapTag_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapTag2(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isMapTag2Dirty() : !pSSysERMap.isMapTag2Dirty()) {
            return null;
        }
        String string = pSSysERMap.getMapTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapTag2_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isMemoDirty() : !pSSysERMap.isMemoDirty()) {
            return null;
        }
        String string = pSSysERMap.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isPSModuleIdDirty() : !pSSysERMap.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysERMap.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isPSSysAppIdDirty() : !pSSysERMap.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysERMap.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysERMapId(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isPSSysERMapIdDirty() && !bl2 : !pSSysERMap.isPSSysERMapIdDirty()) {
            return null;
        }
        String string = pSSysERMap.getPSSysERMapId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysERMapId_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysERMapName(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isPSSysERMapNameDirty() && !bl2 : !pSSysERMap.isPSSysERMapNameDirty()) {
            return null;
        }
        String string = pSSysERMap.getPSSysERMapName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysERMapName_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isPSSystemIdDirty() : !pSSysERMap.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysERMap.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isPSSystemNameDirty() : !pSSysERMap.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysERMap.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_ShapeParams(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isShapeParamsDirty() : !pSSysERMap.isShapeParamsDirty()) {
            return null;
        }
        String string = pSSysERMap.getShapeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeParams_Default((IEntity)pSSysERMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isUserCatDirty() : !pSSysERMap.isUserCatDirty()) {
            return null;
        }
        String string = pSSysERMap.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isUserTagDirty() : !pSSysERMap.isUserTagDirty()) {
            return null;
        }
        String string = pSSysERMap.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isUserTag2Dirty() : !pSSysERMap.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysERMap.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isUserTag3Dirty() : !pSSysERMap.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysERMap.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysERMap pSSysERMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMap.isUserTag4Dirty() : !pSSysERMap.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysERMap.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysERMap, bl2, bl3);
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

    protected void onSyncEntity(PSSysERMap pSSysERMap, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysERMap, bl);
    }

    protected void onSyncIndexEntities(PSSysERMap pSSysERMap, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysERMap, bl);
    }

    public Object getDataContextValue(PSSysERMap pSSysERMap, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysERMap, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysERMap pSSysERMap, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysERMap, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLENTITYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllEntityFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFVIEWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefViewMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ERMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ERModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCSUBSYSFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncSubSysFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSERMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysERMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSERMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysERMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllEntityFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DefViewMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFVIEWMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ERModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ERMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IncSubSysFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MapTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysERMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSERMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysERMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSERMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ShapeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected boolean onMergeChild(String string, String string2, PSSysERMap pSSysERMap) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysERMap)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysERMap pSSysERMap) throws Exception {
        super.onUpdateParent((IEntity)pSSysERMap);
    }

    protected void onCopyDetails(PSSysERMap pSSysERMap, Object object) throws Exception {
        PSSysERMap pSSysERMap2 = new PSSysERMap();
        pSSysERMap2.set("PSSYSERMAPID", object);
        String string = DataObject.getStringValue((Object)pSSysERMap.get("PSSYSERMAPID"));
        super.onCopyDetails((IEntity)pSSysERMap, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysERMap pSSysERMap, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSERMAP");
        if (!bl) {
            pSSysERMap.setCreateDate(null);
            pSSysERMap.setCreateMan(null);
            pSSysERMap.setPSSysAppName(null);
            pSSysERMap.setPSSysERMapId(null);
            pSSysERMap.setUpdateDate(null);
            pSSysERMap.setUpdateMan(null);
            super.exportCurXmlModel(pSSysERMap, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysERMap pSSysERMap, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysERMapNode(pSSysERMap, xmlNode);
        super.onExportRelatedXmlModel(pSSysERMap, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysERMapNode(PSSysERMap pSSysERMap, XmlNode xmlNode) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysERMapNode> arrayList = null;
        String string = pSSysERMap.getPSSysERMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap) : pSSysERMapNodeService.selectTempByPSSysERMap(pSSysERMap);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSERMAPNODES");
            xmlNode.addNode(xmlNode2);
            for (PSSysERMapNode pSSysERMapNode : arrayList) {
                pSSysERMapNodeService.exportXmlModel(pSSysERMapNode, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysERMap pSSysERMap, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSERMAPNODES");
        this.importRelatedXmlModel_PSSysERMapNode(pSSysERMap, xmlNode2);
        super.onImportRelatedXmlModel(pSSysERMap, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysERMapNode(PSSysERMap pSSysERMap, XmlNode xmlNode) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysERMap.getPSSysERMapId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysERMapNodeService.removeByPSSysERMap(pSSysERMap);
        } else {
            pSSysERMapNodeService.removeTempByPSSysERMap(pSSysERMap);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysERMapNode pSSysERMapNode = new PSSysERMapNode();
                pSSysERMapNodeService.fillParentInfo((IEntity)pSSysERMapNode, "DER1N", "DER1N_PSSYSERMAPNODE_PSSYSERMAP_PSSYSERMAPID", pSSysERMap.getPSSysERMapId());
                pSSysERMapNodeService.importXmlModel(pSSysERMapNode, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysERMap pSSysERMap, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysERMap, string);
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
            return "DER1N_PSSYSERMAP_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSERMAP_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysERMap pSSysERMap) {
        if (!StringHelper.isNullOrEmpty((String)pSSysERMap.getCodeName())) {
            return pSSysERMap.getCodeName();
        }
        return super.getModelV2Tag(pSSysERMap);
    }

    @Override
    public boolean setModelV2Tag(PSSysERMap pSSysERMap, String string) {
        pSSysERMap.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysERMap pSSysERMap, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysERMap.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysERMap, true);
        pSSysERMap.set("CODENAME", string);
        if (this.select(pSSysERMap, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysERMap, true);
        return super.getModelV2Entity(pSSysERMap, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysERMap pSSysERMap, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysERMap, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSERMAPNODE_PSSYSERMAP_PSSYSERMAPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysERMap pSSysERMap, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysERMap, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysERMap pSSysERMap, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSERMAPNODE_PSSYSERMAP_PSSYSERMAPID")) {
            Object object;
            PSSysERMapNode pSSysERMapNode2;
            Object object2;
            Object object3;
            Object object4;
            PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysERMapNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSERMAP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSERMAPNODE", (Object)pSSysERMap.getPSSysERMapId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysERMapNode2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysERMapNode2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysERMapNode>();
                object4 = pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap);
                object3 = StringHelper.format((String)"PSSYSERMAP#%1$s", (Object)pSSysERMap.getPSSysERMapId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysERMapNode2 = object2.next();
                    object = pSSysERMapNodeService.getModelV2ResScope((IEntity)pSSysERMapNode2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysERMapNode)PSModelV2Helper.toJSONObject((IEntity)pSSysERMapNode2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysERMapNodeService.getModelV2Name(false);
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
                        if (objectNode.has("pssysermapnodename")) {
                            string = objectNode.get("pssysermapnodename").asText();
                        }
                        if (objectNode2.has("pssysermapnodename")) {
                            string2 = objectNode2.get("pssysermapnodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysERMapNode pSSysERMapNode2 : arrayList) {
                    object = new PSSysERMapNode();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysERMapNode2, false);
                    object3.add((JsonNode)pSSysERMapNodeService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysERMap, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysERMap pSSysERMap) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysERMapNode> arrayList = pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap);
        String string = StringHelper.format((String)"PSSYSERMAP#%1$s", (Object)pSSysERMap.getPSSysERMapId());
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            String string2 = pSSysERMapNodeService.getModelV2ResScope((IEntity)pSSysERMapNode);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysERMapNodeService.emptyModelV2(pSSysERMapNode);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysERMap.getPSSysERMapId());
        pSSysERMapNodeService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysERMapNodeService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSERMAPNODE WHERE PSSYSERMAPID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysERMap);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysERMapNodeService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysERMap pSSysERMap, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysERMapNode pSSysERMapNode = new PSSysERMapNode();
        pSSysERMapNode.set("PSSYSERMAPID", pSSysERMap.getPSSysERMapId());
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysERMapNodeService.getModelV2Entity(pSSysERMapNode, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysERMap, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysERMap pSSysERMap, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysERMapNodeService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysERMapNode pSSysERMapNode = new PSSysERMapNode();
                pSSysERMapNode.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
                pSSysERMapNode.setPSSysERMapName(pSSysERMap.getPSSysERMapName());
                pSSysERMapNodeService.compileModelV2(pSSysERMapNode, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysERMapNode pSSysERMapNode = new PSSysERMapNode();
                    pSSysERMapNode.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
                    pSSysERMapNode.setPSSysERMapName(pSSysERMap.getPSSysERMapName());
                    pSSysERMapNodeService.compileModelV2(pSSysERMapNode, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysERMap, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysERMap pSSysERMap, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSERMAPNODE_PSSYSERMAP_PSSYSERMAPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysERMapNodes(pSSysERMap, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysERMap, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysERMapNodes(PSSysERMap pSSysERMap, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSERMAPNODE", true), (boolean)false) == 0) {
            PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
            PSSysERMapNode pSSysERMapNode = new PSSysERMapNode();
            pSSysERMapNode.setPSSysERMapNodeId(pSMOSFile.getPSModelId());
            if (!pSSysERMapNodeService.get((IEntity)pSSysERMapNode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysERMapNode.getPSSysERMapId(), (String)pSSysERMap.getPSSysERMapId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysERMapNodeService.exportModelV2(pSSysERMapNode);
            pSSysERMapNode.reset();
            if (!pSSysERMapNodeService.setModelV2ResScope((IEntity)pSSysERMapNode, "PSSYSERMAP", pSSysERMap.getPSSysERMapId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysERMapNodeService.importModelV2(pSSysERMapNode, objectNode);
            SessionFactoryManager.commit();
            return pSSysERMapNodeService.getFile((IEntity)pSSysERMapNode);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysERMap pSSysERMap, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysERMapNodes(pSSysERMap, list);
        super.onFillPasteHelps(pSSysERMap, list);
    }

    protected void onFillPasteHelps_PSSysERMapNodes(PSSysERMap pSSysERMap, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSERMAPNODE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSERMAPNODE_PSSYSERMAP_PSSYSERMAPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edfER\u56fe]\u7684[\u7cfb\u7edfER\u56fe\u8282\u70b9]");
        list.add(pSHelpSection);
    }
}

