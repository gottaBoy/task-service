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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUCMapDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUCMapDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapNodeService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUCMapServiceBase
extends PSCoreSysServiceBase<PSSysUCMap> {
    private static final Log log = LogFactory.getLog(PSSysUCMapServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_ADDACTORS = "ADDACTORS";
    public static final String ACTION_ADDUSERCASES = "ADDUSERCASES";
    public static final String ACTION_CALCCONNECTION = "CALCCONNECTION";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_GETWITHMODEL2 = "GetWithModel2";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysUCMapDEModel pSSysUCMapDEModel;
    private PSSysUCMapDAO pSSysUCMapDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService";
    }

    public PSSysUCMapDEModel getPSSysUCMapDEModel() {
        if (this.pSSysUCMapDEModel == null) {
            try {
                this.pSSysUCMapDEModel = (PSSysUCMapDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUCMapDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUCMapDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUCMapDEModel();
    }

    public PSSysUCMapDAO getPSSysUCMapDAO() {
        if (this.pSSysUCMapDAO == null) {
            try {
                this.pSSysUCMapDAO = (PSSysUCMapDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUCMapDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUCMapDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUCMapDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
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
        if (StringHelper.compare((String)string, (String)ACTION_ADDACTORS, (boolean)true) == 0) {
            this.addActors((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_ADDUSERCASES, (boolean)true) == 0) {
            this.addUserCases((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CALCCONNECTION, (boolean)true) == 0) {
            this.calcConnection((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL2, (boolean)true) == 0) {
            this.getWithModel2((PSSysUCMap)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSSysUCMap)iEntity);
            return;
        }
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void addActors(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_ADDACTORS, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_ADDACTORS);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_ADDACTORS, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onAddActors(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_ADDACTORS, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onAddActors(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ADDACTORS]");
    }

    public void addUserCases(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_ADDUSERCASES, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_ADDUSERCASES);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_ADDUSERCASES, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onAddUserCases(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_ADDUSERCASES, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onAddUserCases(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ADDUSERCASES]");
    }

    public void calcConnection(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCCONNECTION, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_CALCCONNECTION);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_CALCCONNECTION, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onCalcConnection(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCCONNECTION, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onCalcConnection(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CALCCONNECTION]");
    }

    public void createWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_CREATEWITHMODEL);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onCreateWithModel(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onCreateWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_GETDRAFTFROMWITHMODEL);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onGetDraftFromWithModel(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onGetDraftFromWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_GETDRAFTWITHMODEL);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onGetDraftWithModel(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onGetDraftWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_GETWITHMODEL);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onGetWithModel(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onGetWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void getWithModel2(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL2, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_GETWITHMODEL2);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_GETWITHMODEL2, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onGetWithModel2(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL2, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onGetWithModel2(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel2]");
    }

    public void updateWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSSysUCMap, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysUCMap, ACTION_UPDATEWITHMODEL);
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysUCMapServiceBase.this.getService(), PSSysUCMapServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSSysUCMap2, null).getResult() != 1) {
                    PSSysUCMapServiceBase.this.onUpdateWithModel(pSSysUCMap2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSSysUCMap, null);
        }
    }

    protected void onUpdateWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSSysUCMap pSSysUCMap, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUCMAP_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysUCMap, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUCMAP_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysUCMap, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUCMAP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysUCMap, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysUCMap, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysUCMap pSSysUCMap, PSModule pSModule) throws Exception {
        pSSysUCMap.setPSModuleId(pSModule.getPSModuleId());
        pSSysUCMap.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysUCMap pSSysUCMap, PSSysApp pSSysApp) throws Exception {
        pSSysUCMap.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysUCMap.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSystem(PSSysUCMap pSSysUCMap, PSSystem pSSystem) throws Exception {
        pSSysUCMap.setPSSystemId(pSSystem.getPSSystemId());
        pSSysUCMap.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
        if (bl) {
            if (pSSysUCMap.getCodeName() == null) {
                pSSysUCMap.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "UCMap", 25));
            }
            if (pSSysUCMap.getPSSysUCMapName() == null) {
                pSSysUCMap.setPSSysUCMapName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u7528\u4f8b\u56fe", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysUCMap, bl);
        this.onFillEntityFullInfo_PSModule(pSSysUCMap, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysUCMap, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysUCMap, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
        if (pSSysUCMap.isPSSystemIdDirty()) {
            if (pSSysUCMap.getPSSystemId() != null) {
                if (pSSysUCMap.getPSSystemId() == null || pSSysUCMap.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysUCMap.getPSSystem();
                    pSSysUCMap.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysUCMap.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysUCMap, bl);
    }

    public ArrayList<PSSysUCMap> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysUCMap> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysUCMap> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysUCMap> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysUCMap> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysUCMap> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysUCMap> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysUCMap> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysUCMap> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSSysUCMap> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUCMAP_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSUCMAP", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUCMap> arrayList = this.selectByPSModule(pSModule);
        for (PSSysUCMap pSSysUCMap : arrayList) {
            PSSysUCMap pSSysUCMap2 = (PSSysUCMap)this.getDEModel().createEntity();
            pSSysUCMap2.setPSSysUCMapId(pSSysUCMap.getPSSysUCMapId());
            pSSysUCMap2.setPSModuleId(null);
            this.update(pSSysUCMap2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysUCMapServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysUCMapServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUCMap> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysUCMap pSSysUCMap : arrayList) {
            this.remove((IEntity)pSSysUCMap);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUCMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUCMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysUCMap> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysUCMap pSSysUCMap : arrayList) {
            PSSysUCMap pSSysUCMap2 = (PSSysUCMap)this.getDEModel().createEntity();
            pSSysUCMap2.setPSSysUCMapId(pSSysUCMap.getPSSysUCMapId());
            pSSysUCMap2.setPSSysAppId(null);
            this.update(pSSysUCMap2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysUCMapServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysUCMapServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysUCMap> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysUCMap pSSysUCMap : arrayList) {
            this.remove((IEntity)pSSysUCMap);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysUCMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysUCMap> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUCMap> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysUCMap pSSysUCMap : arrayList) {
            PSSysUCMap pSSysUCMap2 = (PSSysUCMap)this.getDEModel().createEntity();
            pSSysUCMap2.setPSSysUCMapId(pSSysUCMap.getPSSysUCMapId());
            pSSysUCMap2.setPSSystemId(null);
            this.update(pSSysUCMap2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysUCMapServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysUCMapServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUCMap> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysUCMap pSSysUCMap : arrayList) {
            this.remove((IEntity)pSSysUCMap);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUCMap> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUCMap> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUCMap pSSysUCMap) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        pSSysUCMapNodeService.testRemoveByPSSysUCMap(pSSysUCMap);
        pSSysUCMapNodeService.removeByPSSysUCMap(pSSysUCMap);
        super.onBeforeRemove(pSSysUCMap);
    }

    protected void onBeforeRemoveTemp(PSSysUCMap pSSysUCMap) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        pSSysUCMapNodeService.removeTempByPSSysUCMap(pSSysUCMap);
        super.onBeforeRemoveTemp((IEntity)pSSysUCMap);
    }

    protected void getRelatedDataTempMajor(PSSysUCMap pSSysUCMap) throws Exception {
        this.getRelatedDataTempMajor_PSSysUCMapNode(pSSysUCMap);
        super.getRelatedDataTempMajor((IEntity)pSSysUCMap);
    }

    protected void getRelatedDataTempMajor_PSSysUCMapNode(PSSysUCMap pSSysUCMap) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUCMapNode> arrayList = null;
        String string = pSSysUCMap.getPSSysUCMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysUCMapNodeService.selectByPSSysUCMap(pSSysUCMap) : pSSysUCMapNodeService.selectTempByPSSysUCMap(pSSysUCMap);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            pSSysUCMapNodeService.getTempMajor(pSSysUCMapNode);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysUCMap pSSysUCMap, PSSysUCMap pSSysUCMap2) throws Exception {
        ArrayList<PSSysUCMapNode> arrayList = this.updateRelatedDataTempMajor_removePSSysUCMapNode(pSSysUCMap, pSSysUCMap2);
        this.updateRelatedDataTempMajor_updatePSSysUCMapNode(pSSysUCMap, pSSysUCMap2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysUCMap, (IEntity)pSSysUCMap2);
    }

    protected ArrayList<PSSysUCMapNode> updateRelatedDataTempMajor_removePSSysUCMapNode(PSSysUCMap pSSysUCMap, PSSysUCMap pSSysUCMap2) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUCMapNode> arrayList = pSSysUCMapNodeService.selectTempByPSSysUCMap(pSSysUCMap);
        ArrayList<PSSysUCMapNode> arrayList2 = pSSysUCMapNodeService.selectByPSSysUCMap(pSSysUCMap2);
        HashMap<String, PSSysUCMapNode> hashMap = new HashMap<String, PSSysUCMapNode>();
        for (PSSysUCMapNode pSSysUCMapNode : arrayList2) {
            hashMap.put(pSSysUCMapNode.getPSSysUCMapNodeId(), pSSysUCMapNode);
        }
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            Object object = pSSysUCMapNode.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysUCMapNode pSSysUCMapNode : hashMap.values()) {
            pSSysUCMapNodeService.remove((IEntity)pSSysUCMapNode);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysUCMapNode(PSSysUCMap pSSysUCMap, PSSysUCMap pSSysUCMap2, ArrayList<PSSysUCMapNode> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            pSSysUCMapNodeService.updateTempMajor(pSSysUCMapNode);
        }
    }

    protected void replaceParentInfo(PSSysUCMap pSSysUCMap, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysUCMap, cloneSession);
        if (pSSysUCMap.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysUCMap.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysUCMap, (PSModule)iEntity);
        }
        if (pSSysUCMap.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysUCMap.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysUCMap, (PSSysApp)iEntity);
        }
        if (pSSysUCMap.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysUCMap.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysUCMap, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysUCMap, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysUCMap, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapTag(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapTag2(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUCMapId(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUCMapName(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UCModel(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUCMap, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysUCMap, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isCodeNameDirty() && !bl2 : !pSSysUCMap.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysUCMap.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysUCMap, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysUCMapDEModel(), "CODENAME", string3, pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_MapTag(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isMapTagDirty() : !pSSysUCMap.isMapTagDirty()) {
            return null;
        }
        String string = pSSysUCMap.getMapTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapTag_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_MapTag2(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isMapTag2Dirty() : !pSSysUCMap.isMapTag2Dirty()) {
            return null;
        }
        String string = pSSysUCMap.getMapTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapTag2_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isMemoDirty() : !pSSysUCMap.isMemoDirty()) {
            return null;
        }
        String string = pSSysUCMap.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isPSModuleIdDirty() : !pSSysUCMap.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysUCMap.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isPSSysAppIdDirty() : !pSSysUCMap.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysUCMap.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isPSSystemIdDirty() : !pSSysUCMap.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysUCMap.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isPSSystemNameDirty() : !pSSysUCMap.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysUCMap.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUCMapId(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isPSSysUCMapIdDirty() && !bl2 : !pSSysUCMap.isPSSysUCMapIdDirty()) {
            return null;
        }
        String string = pSSysUCMap.getPSSysUCMapId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUCMapId_Default((IEntity)pSSysUCMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUCMapName(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isPSSysUCMapNameDirty() && !bl2 : !pSSysUCMap.isPSSysUCMapNameDirty()) {
            return null;
        }
        String string = pSSysUCMap.getPSSysUCMapName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUCMapName_Default((IEntity)pSSysUCMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUCMAPNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysUCMapDEModel(), "PSSYSUCMAPNAME", string3, pSSysUCMap, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSUCMAPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isTagsDirty() : !pSSysUCMap.isTagsDirty()) {
            return null;
        }
        String string = pSSysUCMap.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UCModel(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isUCModelDirty() : !pSSysUCMap.isUCModelDirty()) {
            return null;
        }
        String string = pSSysUCMap.getUCModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UCModel_Default((IEntity)pSSysUCMap, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UCMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isUserCatDirty() : !pSSysUCMap.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUCMap.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isUserTagDirty() : !pSSysUCMap.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUCMap.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isUserTag2Dirty() : !pSSysUCMap.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUCMap.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isUserTag3Dirty() : !pSSysUCMap.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUCMap.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUCMap pSSysUCMap, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUCMap.isUserTag4Dirty() : !pSSysUCMap.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUCMap.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysUCMap, bl2, bl3);
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

    protected void onSyncEntity(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysUCMap, bl);
    }

    protected void onSyncIndexEntities(PSSysUCMap pSSysUCMap, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysUCMap, bl);
    }

    public Object getDataContextValue(PSSysUCMap pSSysUCMap, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysUCMap, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUCMap pSSysUCMap, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysUCMap, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUCMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUCMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUCMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUCMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tags_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UCMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UCModel_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysUCMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUCMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUCMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUCMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UCModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UCMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysUCMap pSSysUCMap) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysUCMap)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUCMap pSSysUCMap) throws Exception {
        super.onUpdateParent((IEntity)pSSysUCMap);
    }

    protected void onCopyDetails(PSSysUCMap pSSysUCMap, Object object) throws Exception {
        PSSysUCMap pSSysUCMap2 = new PSSysUCMap();
        pSSysUCMap2.set("PSSYSUCMAPID", object);
        String string = DataObject.getStringValue((Object)pSSysUCMap.get("PSSYSUCMAPID"));
        super.onCopyDetails((IEntity)pSSysUCMap, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysUCMap pSSysUCMap, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUCMAP");
        if (!bl) {
            pSSysUCMap.setCreateDate(null);
            pSSysUCMap.setCreateMan(null);
            pSSysUCMap.setPSSysAppName(null);
            pSSysUCMap.setPSSysUCMapId(null);
            pSSysUCMap.setUpdateDate(null);
            pSSysUCMap.setUpdateMan(null);
            super.exportCurXmlModel(pSSysUCMap, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysUCMap pSSysUCMap, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysUCMapNode(pSSysUCMap, xmlNode);
        super.onExportRelatedXmlModel(pSSysUCMap, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysUCMapNode(PSSysUCMap pSSysUCMap, XmlNode xmlNode) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUCMapNode> arrayList = null;
        String string = pSSysUCMap.getPSSysUCMapId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysUCMapNodeService.selectByPSSysUCMap(pSSysUCMap) : pSSysUCMapNodeService.selectTempByPSSysUCMap(pSSysUCMap);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSUCMAPNODES");
            xmlNode.addNode(xmlNode2);
            for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
                pSSysUCMapNodeService.exportXmlModel(pSSysUCMapNode, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysUCMap pSSysUCMap, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSUCMAPNODES");
        this.importRelatedXmlModel_PSSysUCMapNode(pSSysUCMap, xmlNode2);
        super.onImportRelatedXmlModel(pSSysUCMap, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysUCMapNode(PSSysUCMap pSSysUCMap, XmlNode xmlNode) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysUCMap.getPSSysUCMapId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysUCMapNodeService.removeByPSSysUCMap(pSSysUCMap);
        } else {
            pSSysUCMapNodeService.removeTempByPSSysUCMap(pSSysUCMap);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysUCMapNode pSSysUCMapNode = new PSSysUCMapNode();
                pSSysUCMapNodeService.fillParentInfo((IEntity)pSSysUCMapNode, "DER1N", "DER1N_PSSYSUCMAPNODE_PSSYSUCMAP_PSSYSUCMAPID", pSSysUCMap.getPSSysUCMapId());
                pSSysUCMapNodeService.importXmlModel(pSSysUCMapNode, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUCMap pSSysUCMap, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUCMap, string);
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
            return "DER1N_PSSYSUCMAP_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUCMAP_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysUCMap pSSysUCMap) {
        if (!StringHelper.isNullOrEmpty((String)pSSysUCMap.getCodeName())) {
            return pSSysUCMap.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUCMap.getPSSysUCMapName())) {
            return pSSysUCMap.getPSSysUCMapName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUCMap.getCodeName())) {
            return pSSysUCMap.getCodeName();
        }
        return super.getModelV2Tag(pSSysUCMap);
    }

    @Override
    public boolean setModelV2Tag(PSSysUCMap pSSysUCMap, String string) {
        pSSysUCMap.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSUCMAPNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUCMap pSSysUCMap, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUCMap.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUCMap, true);
        pSSysUCMap.set("CODENAME", string);
        if (this.select(pSSysUCMap, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysUCMap, true);
        return super.getModelV2Entity(pSSysUCMap, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUCMap pSSysUCMap, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysUCMap, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSUCMAPNODE_PSSYSUCMAP_PSSYSUCMAPID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysUCMap pSSysUCMap, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysUCMap, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysUCMap pSSysUCMap, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSUCMAPNODE_PSSYSUCMAP_PSSYSUCMAPID")) {
            Object object;
            PSSysUCMapNode pSSysUCMapNode2;
            Object object2;
            Object object3;
            Object object4;
            PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysUCMapNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSUCMAP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSUCMAPNODE", (Object)pSSysUCMap.getPSSysUCMapId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysUCMapNode2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysUCMapNode2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysUCMapNode>();
                object4 = pSSysUCMapNodeService.selectByPSSysUCMap(pSSysUCMap);
                object3 = StringHelper.format((String)"PSSYSUCMAP#%1$s", (Object)pSSysUCMap.getPSSysUCMapId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysUCMapNode2 = object2.next();
                    object = pSSysUCMapNodeService.getModelV2ResScope((IEntity)pSSysUCMapNode2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysUCMapNode)PSModelV2Helper.toJSONObject((IEntity)pSSysUCMapNode2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysUCMapNodeService.getModelV2Name(false);
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
                        if (objectNode.has("pssysucmapnodename")) {
                            string = objectNode.get("pssysucmapnodename").asText();
                        }
                        if (objectNode2.has("pssysucmapnodename")) {
                            string2 = objectNode2.get("pssysucmapnodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysUCMapNode pSSysUCMapNode2 : arrayList) {
                    object = new PSSysUCMapNode();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysUCMapNode2, false);
                    object3.add((JsonNode)pSSysUCMapNodeService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysUCMap, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysUCMap pSSysUCMap) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUCMapNode> arrayList = pSSysUCMapNodeService.selectByPSSysUCMap(pSSysUCMap);
        String string = StringHelper.format((String)"PSSYSUCMAP#%1$s", (Object)pSSysUCMap.getPSSysUCMapId());
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            String string2 = pSSysUCMapNodeService.getModelV2ResScope((IEntity)pSSysUCMapNode);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysUCMapNodeService.emptyModelV2(pSSysUCMapNode);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysUCMap.getPSSysUCMapId());
        pSSysUCMapNodeService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysUCMapNodeService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSUCMAPNODE WHERE PSSYSUCMAPID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysUCMap);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysUCMapNodeService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysUCMap pSSysUCMap, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysUCMapNode pSSysUCMapNode = new PSSysUCMapNode();
        pSSysUCMapNode.set("PSSYSUCMAPID", pSSysUCMap.getPSSysUCMapId());
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysUCMapNodeService.getModelV2Entity(pSSysUCMapNode, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysUCMap, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysUCMap pSSysUCMap, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysUCMapNodeService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysUCMapNode pSSysUCMapNode = new PSSysUCMapNode();
                pSSysUCMapNode.setPSSysUCMapId(pSSysUCMap.getPSSysUCMapId());
                pSSysUCMapNode.setPSSysUCMapName(pSSysUCMap.getPSSysUCMapName());
                pSSysUCMapNodeService.compileModelV2(pSSysUCMapNode, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysUCMapNode pSSysUCMapNode = new PSSysUCMapNode();
                    pSSysUCMapNode.setPSSysUCMapId(pSSysUCMap.getPSSysUCMapId());
                    pSSysUCMapNode.setPSSysUCMapName(pSSysUCMap.getPSSysUCMapName());
                    pSSysUCMapNodeService.compileModelV2(pSSysUCMapNode, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysUCMap, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysUCMap pSSysUCMap, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSUCMAPNODE_PSSYSUCMAP_PSSYSUCMAPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysUCMapNodes(pSSysUCMap, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysUCMap, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysUCMapNodes(PSSysUCMap pSSysUCMap, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSUCMAPNODE", true), (boolean)false) == 0) {
            PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService(PSSysUCMapNodeService.class, (SessionFactory)this.getSessionFactory());
            PSSysUCMapNode pSSysUCMapNode = new PSSysUCMapNode();
            pSSysUCMapNode.setPSSysUCMapNodeId(pSMOSFile.getPSModelId());
            if (!pSSysUCMapNodeService.get((IEntity)pSSysUCMapNode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysUCMapNode.getPSSysUCMapId(), (String)pSSysUCMap.getPSSysUCMapId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysUCMapNodeService.exportModelV2(pSSysUCMapNode);
            pSSysUCMapNode.reset();
            if (!pSSysUCMapNodeService.setModelV2ResScope((IEntity)pSSysUCMapNode, "PSSYSUCMAP", pSSysUCMap.getPSSysUCMapId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysUCMapNodeService.importModelV2(pSSysUCMapNode, objectNode);
            SessionFactoryManager.commit();
            return pSSysUCMapNodeService.getFile((IEntity)pSSysUCMapNode);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysUCMap pSSysUCMap, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysUCMapNodes(pSSysUCMap, list);
        super.onFillPasteHelps(pSSysUCMap, list);
    }

    protected void onFillPasteHelps_PSSysUCMapNodes(PSSysUCMap pSSysUCMap, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSUCMAPNODE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSUCMAPNODE_PSSYSUCMAP_PSSYSUCMAPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u7528\u4f8b\u56fe]\u7684[\u7cfb\u7edf\u7528\u4f8b\u56fe\u8282\u70b9]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysUCMap pSSysUCMap, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "UCMap");
        defaultValueMap.put("PSSYSUCMAPNAME", "\u7528\u4f8b\u56fe");
    }
}

