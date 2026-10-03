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
import net.ibizsys.pscore.srv.dedesign.dao.PSDESADetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESADetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetailParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailParamServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARSBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESADetailServiceBase
extends PSCoreSysServiceBase<PSDESADetail> {
    private static final Log log = LogFactory.getLog(PSDESADetailServiceBase.class);
    public static final String DATASET_CURAPI = "CurAPI";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCREQUESTMETHOD = "CalcRequestMethod";
    private PSDESADetailDEModel pSDESADetailDEModel;
    private PSDESADetailDAO pSDESADetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService";
    }

    public PSDESADetailDEModel getPSDESADetailDEModel() {
        if (this.pSDESADetailDEModel == null) {
            try {
                this.pSDESADetailDEModel = (PSDESADetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESADetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESADetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESADetailDEModel();
    }

    public PSDESADetailDAO getPSDESADetailDAO() {
        if (this.pSDESADetailDAO == null) {
            try {
                this.pSDESADetailDAO = (PSDESADetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESADetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESADetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESADetailDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPI, (boolean)true) == 0) {
            return this.fetchCurAPI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPI, (boolean)true) == 0) {
            return this.fetchTempCurAPI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCREQUESTMETHOD, (boolean)true) == 0) {
            this.calcRequestMethod((PSDESADetail)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPI, true);
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

    public void calcRequestMethod(PSDESADetail pSDESADetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCREQUESTMETHOD, 0, pSDESADetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDESADetail, ACTION_CALCREQUESTMETHOD);
        final PSDESADetail pSDESADetail2 = pSDESADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDESADetailServiceBase.this.getService(), PSDESADetailServiceBase.ACTION_CALCREQUESTMETHOD, 40, pSDESADetail2, null).getResult() != 1) {
                    PSDESADetailServiceBase.this.onCalcRequestMethod(pSDESADetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCREQUESTMETHOD, 99, pSDESADetail, null);
        }
    }

    protected void onCalcRequestMethod(PSDESADetail pSDESADetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcRequestMethod]");
    }

    protected void onFillParentInfo(PSDESADetail pSDESADetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDESADetail, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataQuery);
            } else {
                iService.get(pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDESADetail, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSDESADetail, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDESADetail, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDESARS_PSDESARSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService", (SessionFactory)this.getSessionFactory());
            PSDESARS pSDESARS = (PSDESARS)iService.getDEModel().createEntity();
            pSDESARS.set("PSDESARSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDESARS);
            } else {
                iService.get(pSDESARS);
            }
            this.onFillParentInfo_PSDESARS(pSDESADetail, pSDESARS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDESERVICEAPI_INPSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEServiceAPI);
            } else {
                iService.get(pSDEServiceAPI);
            }
            this.onFillParentInfo_InPSDEServiceAPI(pSDESADetail, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDESERVICEAPI_OUTPSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEServiceAPI);
            } else {
                iService.get(pSDEServiceAPI);
            }
            this.onFillParentInfo_OutPSDEServiceAPI(pSDESADetail, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEServiceAPI);
            } else {
                iService.get(pSDEServiceAPI);
            }
            this.onFillParentInfo_PSDEServiceAPI(pSDESADetail, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESADETAIL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDESADetail, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSDESADetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEAction(PSDESADetail pSDESADetail, PSDEAction pSDEAction) throws Exception {
        pSDESADetail.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDESADetail.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEDQ(PSDESADetail pSDESADetail, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDESADetail.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDESADetail.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_PSDEDS(PSDESADetail pSDESADetail, PSDEDataSet pSDEDataSet) throws Exception {
        pSDESADetail.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDESADetail.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDESADetail pSDESADetail, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDESADetail.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDESADetail.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDESARS(PSDESADetail pSDESADetail, PSDESARS pSDESARS) throws Exception {
        pSDESADetail.setPSDESARSId(pSDESARS.getPSDESARSId());
        pSDESADetail.setPSDESARSName(pSDESARS.getPSDESARSName());
    }

    protected void onFillParentInfo_InPSDEServiceAPI(PSDESADetail pSDESADetail, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSDESADetail.setInPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSDESADetail.setInPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
    }

    protected void onFillParentInfo_OutPSDEServiceAPI(PSDESADetail pSDESADetail, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSDESADetail.setOutPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSDESADetail.setOutPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
    }

    protected void onFillParentInfo_PSDEServiceAPI(PSDESADetail pSDESADetail, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSDESADetail.setPSDEId(pSDEServiceAPI.getPSDEId());
        pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSDESADetail.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
        pSDESADetail.setPSSysServiceAPIId(pSDEServiceAPI.getPSSysServiceAPIId());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDESADetail pSDESADetail, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDESADetail.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDESADetail.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        if (bl && pSDESADetail.getValidFlag() == null) {
            pSDESADetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDESADetail, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDESADetail, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDESADetail, bl);
        this.onFillEntityFullInfo_PSDEDS(pSDESADetail, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDESADetail, bl);
        this.onFillEntityFullInfo_PSDESARS(pSDESADetail, bl);
        this.onFillEntityFullInfo_InPSDEServiceAPI(pSDESADetail, bl);
        this.onFillEntityFullInfo_OutPSDEServiceAPI(pSDESADetail, bl);
        this.onFillEntityFullInfo_PSDEServiceAPI(pSDESADetail, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDESADetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        if (pSDESADetail.isPSDEActionIdDirty()) {
            if (pSDESADetail.getPSDEActionId() != null) {
                if (pSDESADetail.getPSDEActionId() == null || pSDESADetail.getPSDEActionName() == null) {
                    PSDEAction pSDEAction = pSDESADetail.getPSDEAction();
                    pSDESADetail.setPSDEActionName(pSDEAction.getPSDEActionName());
                }
            } else {
                pSDESADetail.setPSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDESADetail pSDESADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDS(PSDESADetail pSDESADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDESADetail pSDESADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDESARS(PSDESADetail pSDESADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InPSDEServiceAPI(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        if (pSDESADetail.isInPSDEServiceAPIIdDirty()) {
            if (pSDESADetail.getInPSDEServiceAPIId() != null) {
                if (pSDESADetail.getInPSDEServiceAPIId() == null || pSDESADetail.getInPSDEServiceAPIName() == null) {
                    PSDEServiceAPI pSDEServiceAPI = pSDESADetail.getInPSDEServiceAPI();
                    pSDESADetail.setInPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                }
            } else {
                pSDESADetail.setInPSDEServiceAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OutPSDEServiceAPI(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        if (pSDESADetail.isOutPSDEServiceAPIIdDirty()) {
            if (pSDESADetail.getOutPSDEServiceAPIId() != null) {
                if (pSDESADetail.getOutPSDEServiceAPIId() == null || pSDESADetail.getOutPSDEServiceAPIName() == null) {
                    PSDEServiceAPI pSDEServiceAPI = pSDESADetail.getOutPSDEServiceAPI();
                    pSDESADetail.setOutPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                }
            } else {
                pSDESADetail.setOutPSDEServiceAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEServiceAPI(PSDESADetail pSDESADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDESADetail pSDESADetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDESADetail, bl);
    }

    public ArrayList<PSDESADetail> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetail> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetail> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetail> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
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

    public ArrayList<PSDESADetail> selectByPSDESARS(PSDESARSBase pSDESARSBase) throws Exception {
        return this.selectByPSDESARS(pSDESARSBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByPSDESARS(PSDESARSBase pSDESARSBase, String string) throws Exception {
        return this.selectByPSDESARS(pSDESARSBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByPSDESARS(PSDESARSBase pSDESARSBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESARSID", (Object)pSDESARSBase.getPSDESARSId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESARSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESARSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetail> selectByInPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByInPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByInPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByInPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByInPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSDESERVICEAPIID", (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSDEServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSDEServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetail> selectByOutPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByOutPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByOutPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByOutPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByOutPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSDESERVICEAPIID", (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSDEServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSDEServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetail> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESERVICEAPIID", (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESADetail> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDESADetail> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDESADetail> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setPSDEActionId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDESADetailServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDESADetailServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEDQ(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSDEDATAQUERY_PSDEDQID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setPSDEDQId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDESADetailServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDESADetailServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setPSDEDSId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSDESADetailServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSDESADetailServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setPSDEOPPrivId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDESADetailServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDESADetailServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDESARS(PSDESARS pSDESARS) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDESARS(pSDESARS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESARS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDESARS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSDESARS_PSDESARSID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSDESARS), arrayList.get(0)));
        }
    }

    public void resetPSDESARS(PSDESARS pSDESARS) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDESARS(pSDESARS);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setPSDESARSId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByPSDESARS(PSDESARS pSDESARS) throws Exception {
        final PSDESARS pSDESARS2 = pSDESARS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByPSDESARS(pSDESARS2);
                PSDESADetailServiceBase.this.internalRemoveByPSDESARS(pSDESARS2);
                PSDESADetailServiceBase.this.onAfterRemoveByPSDESARS(pSDESARS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESARS(PSDESARS pSDESARS) throws Exception {
    }

    protected void internalRemoveByPSDESARS(PSDESARS pSDESARS) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDESARS(pSDESARS);
        this.onBeforeRemoveByPSDESARS(pSDESARS, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByPSDESARS(pSDESARS, arrayList);
    }

    protected void onAfterRemoveByPSDESARS(PSDESARS pSDESARS) throws Exception {
    }

    protected void onBeforeRemoveByPSDESARS(PSDESARS pSDESARS, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESARS(PSDESARS pSDESARS, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByInPSDEServiceAPI(pSDEServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSDESERVICEAPI_INPSDESERVICEAPIID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSDEServiceAPI), arrayList.get(0)));
        }
    }

    public void resetInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByInPSDEServiceAPI(pSDEServiceAPI);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setInPSDEServiceAPIId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByInPSDEServiceAPI(pSDEServiceAPI2);
                PSDESADetailServiceBase.this.internalRemoveByInPSDEServiceAPI(pSDEServiceAPI2);
                PSDESADetailServiceBase.this.onAfterRemoveByInPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByInPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByInPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByInPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByOutPSDEServiceAPI(pSDEServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSDESERVICEAPI_OUTPSDESERVICEAPIID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSDEServiceAPI), arrayList.get(0)));
        }
    }

    public void resetOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByOutPSDEServiceAPI(pSDEServiceAPI);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setOutPSDEServiceAPIId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByOutPSDEServiceAPI(pSDEServiceAPI2);
                PSDESADetailServiceBase.this.internalRemoveByOutPSDEServiceAPI(pSDEServiceAPI2);
                PSDESADetailServiceBase.this.onAfterRemoveByOutPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByOutPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByOutPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByOutPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    public void resetPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setPSDEServiceAPIId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSDESADetailServiceBase.this.internalRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSDESADetailServiceBase.this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESADETAIL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDESADETAIL", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDESADetail pSDESADetail : arrayList) {
            PSDESADetail pSDESADetail2 = (PSDESADetail)this.getDEModel().createEntity();
            pSDESADetail2.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
            pSDESADetail2.setPSSysSFPluginId(null);
            this.update(pSDESADetail2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESADetailServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDESADetailServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDESADetailServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDESADetail> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDESADetail pSDESADetail : arrayList) {
            this.remove(pSDESADetail);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDESADetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESADetail pSDESADetail) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDESADetail(pSDESADetail);
        ((PSDESADetailParamServiceBase)pSCoreSysServiceBase).removeByPSDESADetail(pSDESADetail);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDESADetail(pSDESADetail);
        super.onBeforeRemove(pSDESADetail);
    }

    protected void onBeforeRemoveTemp(PSDESADetail pSDESADetail) throws Exception {
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        pSDESADetailParamService.removeTempByPSDESADetail(pSDESADetail);
        super.onBeforeRemoveTemp(pSDESADetail);
    }

    protected void getRelatedDataTempMajor(PSDESADetail pSDESADetail) throws Exception {
        this.getRelatedDataTempMajor_PSDESADetailParam(pSDESADetail);
        super.getRelatedDataTempMajor(pSDESADetail);
    }

    protected void getRelatedDataTempMajor_PSDESADetailParam(PSDESADetail pSDESADetail) throws Exception {
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDESADetailParam> arrayList = null;
        String string = pSDESADetail.getPSDESADetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDESADetailParamService.selectByPSDESADetail(pSDESADetail) : pSDESADetailParamService.selectTempByPSDESADetail(pSDESADetail);
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            pSDESADetailParamService.getTempMajor(pSDESADetailParam);
        }
    }

    protected void updateRelatedDataTempMajor(PSDESADetail pSDESADetail, PSDESADetail pSDESADetail2) throws Exception {
        ArrayList<PSDESADetailParam> arrayList = this.updateRelatedDataTempMajor_removePSDESADetailParam(pSDESADetail, pSDESADetail2);
        this.updateRelatedDataTempMajor_updatePSDESADetailParam(pSDESADetail, pSDESADetail2, arrayList);
        super.updateRelatedDataTempMajor(pSDESADetail, pSDESADetail2);
    }

    protected ArrayList<PSDESADetailParam> updateRelatedDataTempMajor_removePSDESADetailParam(PSDESADetail pSDESADetail, PSDESADetail pSDESADetail2) throws Exception {
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDESADetailParam> arrayList = pSDESADetailParamService.selectTempByPSDESADetail(pSDESADetail);
        ArrayList<PSDESADetailParam> arrayList2 = pSDESADetailParamService.selectByPSDESADetail(pSDESADetail2);
        HashMap<String, PSDESADetailParam> hashMap = new HashMap<String, PSDESADetailParam>();
        for (PSDESADetailParam pSDESADetailParam : arrayList2) {
            hashMap.put(pSDESADetailParam.getPSDESADetailParamId(), pSDESADetailParam);
        }
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            Object object = pSDESADetailParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDESADetailParam pSDESADetailParam : hashMap.values()) {
            pSDESADetailParamService.remove(pSDESADetailParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDESADetailParam(PSDESADetail pSDESADetail, PSDESADetail pSDESADetail2, ArrayList<PSDESADetailParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            pSDESADetailParamService.updateTempMajor(pSDESADetailParam);
        }
    }

    protected void replaceParentInfo(PSDESADetail pSDESADetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDESADetail, cloneSession);
        if (pSDESADetail.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDESADetail.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDESADetail, (PSDEAction)iEntity);
        }
        if (pSDESADetail.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDESADetail.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDESADetail, (PSDEDataQuery)iEntity);
        }
        if (pSDESADetail.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDESADetail.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSDESADetail, (PSDEDataSet)iEntity);
        }
        if (pSDESADetail.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDESADetail.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDESADetail, (PSDEOPPriv)iEntity);
        }
        if (pSDESADetail.getPSDESARSId() != null && (iEntity = cloneSession.getEntity("PSDESARS", (Object)pSDESADetail.getPSDESARSId())) != null) {
            this.onFillParentInfo_PSDESARS(pSDESADetail, (PSDESARS)iEntity);
        }
        if (pSDESADetail.getInPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSDESADetail.getInPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_InPSDEServiceAPI(pSDESADetail, (PSDEServiceAPI)iEntity);
        }
        if (pSDESADetail.getOutPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSDESADetail.getOutPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_OutPSDEServiceAPI(pSDESADetail, (PSDEServiceAPI)iEntity);
        }
        if (pSDESADetail.getPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSDESADetail.getPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_PSDEServiceAPI(pSDESADetail, (PSDEServiceAPI)iEntity);
        }
        if (pSDESADetail.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDESADetail.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDESADetail, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDESADetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDESADetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParam(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParam2(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailType(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDEServiceAPIId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSDEServiceAPIName(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MethodTag(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NeedResourceKey(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoServiceCodeName(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDEServiceAPIId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSDEServiceAPIName(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParentKeyMode(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionName(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESADetailId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESADetailName(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESARSId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestField(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestMethod(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestParamType(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetValType(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceUrl(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTag(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDESADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDESADetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isCodeNameDirty() : !pSDESADetail.isCodeNameDirty()) {
            return null;
        }
        String string = pSDESADetail.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDESADetail, bl2, bl3);
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
                string3 = "PSDESERVICEAPIID";
                string3 = string3 + ";";
                string3 = string3 + "PSDESARSID";
                String string4 = this.checkFieldDupRule(this.getPSDESADetailDEModel(), "CODENAME", string3, pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isCodeName2Dirty() : !pSDESADetail.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDESADetail.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSDESADetail, bl2, bl3);
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
                string3 = "PSDESERVICEAPIID";
                string3 = string3 + ";";
                string3 = string3 + "PSDESARSID";
                String string4 = this.checkFieldDupRule(this.getPSDESADetailDEModel(), "CODENAME2", string3, pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailParam(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isDetailParamDirty() : !pSDESADetail.isDetailParamDirty()) {
            return null;
        }
        String string = pSDESADetail.getDetailParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailParam2(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isDetailParam2Dirty() : !pSDESADetail.isDetailParam2Dirty()) {
            return null;
        }
        String string = pSDESADetail.getDetailParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam2_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailType(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isDetailTypeDirty() && !bl2 : !pSDESADetail.isDetailTypeDirty()) {
            return null;
        }
        String string = pSDESADetail.getDetailType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailType_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDEServiceAPIId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isInPSDEServiceAPIIdDirty() : !pSDESADetail.isInPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getInPSDEServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDEServiceAPIId_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDESERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSDEServiceAPIName(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isInPSDEServiceAPINameDirty() : !pSDESADetail.isInPSDEServiceAPINameDirty()) {
            return null;
        }
        String string = pSDESADetail.getInPSDEServiceAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSDEServiceAPIName_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSDESERVICEAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isMemoDirty() : !pSDESADetail.isMemoDirty()) {
            return null;
        }
        String string = pSDESADetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_MethodTag(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isMethodTagDirty() && !bl2 : !pSDESADetail.isMethodTagDirty()) {
            return null;
        }
        String string = pSDESADetail.getMethodTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("METHODTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MethodTag_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("METHODTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDESERVICEAPIID";
                string3 = string3 + ";";
                string3 = string3 + "PSDESARSID";
                String string4 = this.checkFieldDupRule(this.getPSDESADetailDEModel(), "METHODTAG", string3, pSDESADetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("METHODTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NeedResourceKey(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isNeedResourceKeyDirty() : !pSDESADetail.isNeedResourceKeyDirty()) {
            return null;
        }
        Integer n = pSDESADetail.getNeedResourceKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NeedResourceKey_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoServiceCodeName(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isNoServiceCodeNameDirty() : !pSDESADetail.isNoServiceCodeNameDirty()) {
            return null;
        }
        Integer n = pSDESADetail.getNoServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoServiceCodeName_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOSERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isOrderValueDirty() : !pSDESADetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDESADetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutPSDEServiceAPIId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isOutPSDEServiceAPIIdDirty() : !pSDESADetail.isOutPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getOutPSDEServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDEServiceAPIId_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDESERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSDEServiceAPIName(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isOutPSDEServiceAPINameDirty() : !pSDESADetail.isOutPSDEServiceAPINameDirty()) {
            return null;
        }
        String string = pSDESADetail.getOutPSDEServiceAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSDEServiceAPIName_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSDESERVICEAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParentKeyMode(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isParentKeyModeDirty() : !pSDESADetail.isParentKeyModeDirty()) {
            return null;
        }
        String string = pSDESADetail.getParentKeyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParentKeyMode_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARENTKEYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDEActionIdDirty() : !pSDESADetail.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionName(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDEActionNameDirty() : !pSDESADetail.isPSDEActionNameDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDEActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionName_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDEDQIdDirty() : !pSDESADetail.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDEDQId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDEDSIdDirty() : !pSDESADetail.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDEOPPrivIdDirty() : !pSDESADetail.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDESADetailId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDESADetailIdDirty() && !bl2 : !pSDESADetail.isPSDESADetailIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDESADetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESADetailId_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESADetailName(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDESADetailNameDirty() : !pSDESADetail.isPSDESADetailNameDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDESADetailName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESADetailName_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESADETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESARSId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDESARSIdDirty() : !pSDESADetail.isPSDESARSIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDESARSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESARSId_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESARSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEServiceAPIId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSDEServiceAPIIdDirty() && !bl2 : !pSDESADetail.isPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSDEServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIId_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isPSSysSFPluginIdDirty() : !pSDESADetail.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDESADetail.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RequestField(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isRequestFieldDirty() : !pSDESADetail.isRequestFieldDirty()) {
            return null;
        }
        String string = pSDESADetail.getRequestField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestField_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RequestMethod(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isRequestMethodDirty() : !pSDESADetail.isRequestMethodDirty()) {
            return null;
        }
        String string = pSDESADetail.getRequestMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestMethod_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RequestParamType(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isRequestParamTypeDirty() : !pSDESADetail.isRequestParamTypeDirty()) {
            return null;
        }
        String string = pSDESADetail.getRequestParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestParamType_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RetValType(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isRetValTypeDirty() : !pSDESADetail.isRetValTypeDirty()) {
            return null;
        }
        String string = pSDESADetail.getRetValType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RetValType_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceUrl(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isServiceUrlDirty() : !pSDESADetail.isServiceUrlDirty()) {
            return null;
        }
        String string = pSDESADetail.getServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceUrl_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniqueTag(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isUniqueTagDirty() && !bl2 : !pSDESADetail.isUniqueTagDirty()) {
            return null;
        }
        String string = pSDESADetail.getUniqueTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTag_Default(pSDESADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDESERVICEAPIID";
                string3 = string3 + ";";
                string3 = string3 + "PSDESARSID";
                String string4 = this.checkFieldDupRule(this.getPSDESADetailDEModel(), "UNIQUETAG", string3, pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isUserCatDirty() : !pSDESADetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDESADetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isUserTagDirty() : !pSDESADetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDESADetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isUserTag2Dirty() : !pSDESADetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDESADetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isUserTag3Dirty() : !pSDESADetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDESADetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isUserTag4Dirty() : !pSDESADetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDESADetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDESADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDESADetail pSDESADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESADetail.isValidFlagDirty() && !bl2 : !pSDESADetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDESADetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDESADetail, bl2, bl3);
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

    protected void onSyncEntity(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDESADetail, bl);
    }

    protected void onSyncIndexEntities(PSDESADetail pSDESADetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDESADetail, bl);
    }

    public Object getDataContextValue(PSDESADetail pSDESADetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDESARS", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"CPSDESERVICEAPIID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDESARSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDESARSNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDESADetail, "psdeserviceapiid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDESADetail, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDEServiceAPI pSDEServiceAPI = pSDESADetail.getPSDEServiceAPI();
        if (pSDEServiceAPI != null && pSDEServiceAPI.contains(string)) {
            return pSDEServiceAPI.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDESADetail pSDESADetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDESADetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"DETAILPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"METHODTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MethodTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEEDRESOURCEKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NeedResourceKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOSERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARENTKEYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParentKeyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESARSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESARSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESARSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESARSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"RETVALTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetValType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceUrl_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DetailParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILPARAM", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILPARAM2", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDESERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSDEServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MethodTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("METHODTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NeedResourceKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutPSDEServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDESERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSDEServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParentKeyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARENTKEYMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDESADetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESADETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESADetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESADETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESARSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESARSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESARSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESARSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDESADetail pSDESADetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDESADetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESADetail pSDESADetail) throws Exception {
        super.onUpdateParent(pSDESADetail);
    }

    protected void onCopyDetails(PSDESADetail pSDESADetail, Object object) throws Exception {
        PSDESADetail pSDESADetail2 = new PSDESADetail();
        pSDESADetail2.set("PSDESADETAILID", object);
        String string = DataObject.getStringValue((Object)pSDESADetail.get("PSDESADETAILID"));
        super.onCopyDetails(pSDESADetail, object);
    }

    @Override
    protected void exportCurXmlModel(PSDESADetail pSDESADetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESADETAIL");
        if (!bl) {
            pSDESADetail.setCreateDate(null);
            pSDESADetail.setCreateMan(null);
            pSDESADetail.setMethodTag(null);
            pSDESADetail.setPSDESADetailId(null);
            pSDESADetail.setPSDESADetailName(null);
            pSDESADetail.setUniqueTag(null);
            pSDESADetail.setUpdateDate(null);
            pSDESADetail.setUpdateMan(null);
            super.exportCurXmlModel(pSDESADetail, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDESADetail pSDESADetail, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDESADetailParam(pSDESADetail, xmlNode);
        super.onExportRelatedXmlModel(pSDESADetail, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDESADetailParam(PSDESADetail pSDESADetail, XmlNode xmlNode) throws Exception {
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDESADetailParam> arrayList = null;
        String string = pSDESADetail.getPSDESADetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDESADetailParamService.selectByPSDESADetail(pSDESADetail, "ORDER BY ORDERVALUE ASC") : pSDESADetailParamService.selectTempByPSDESADetail(pSDESADetail, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDESADETAILPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSDESADetailParam pSDESADetailParam : arrayList) {
                pSDESADetailParam.set("ORDERVALUE", null);
                pSDESADetailParamService.exportXmlModel(pSDESADetailParam, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDESADetail pSDESADetail, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDESADETAILPARAMS");
        this.importRelatedXmlModel_PSDESADetailParam(pSDESADetail, xmlNode2);
        super.onImportRelatedXmlModel(pSDESADetail, xmlNode);
    }

    protected void importRelatedXmlModel_PSDESADetailParam(PSDESADetail pSDESADetail, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDESADetail.getPSDESADetailId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDESADetailParamService.removeByPSDESADetail(pSDESADetail);
        } else {
            pSDESADetailParamService.removeTempByPSDESADetail(pSDESADetail);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDESADetailParam pSDESADetailParam = new PSDESADetailParam();
                pSDESADetailParam.setOrderValue(n);
                n += 100;
                pSDESADetailParamService.fillParentInfo(pSDESADetailParam, "DER1N", "DER1N_PSDESADETAILPARAM_PSDESADETAIL_PSDESADETAILID", pSDESADetail.getPSDESADetailId());
                pSDESADetailParamService.importXmlModel(pSDESADetailParam, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDESADetail pSDESADetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDESADetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESARSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDESARS#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDESERVICEAPI#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESARSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESADETAIL_PSDESARS_PSDESARSID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESARSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESARSNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPINAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDESARS", (boolean)true) == 0) {
            iEntity.set("PSDESARSID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPI", (boolean)true) == 0) {
            iEntity.set("PSDESERVICEAPIID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDESARSID", "PSDESERVICEAPIID"};
    }

    @Override
    public String getModelV2Tag(PSDESADetail pSDESADetail) {
        if (!StringHelper.isNullOrEmpty((String)pSDESADetail.getUniqueTag())) {
            return pSDESADetail.getUniqueTag();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDESADetail.getCodeName())) {
            return pSDESADetail.getCodeName();
        }
        return super.getModelV2Tag(pSDESADetail);
    }

    @Override
    public boolean setModelV2Tag(PSDESADetail pSDESADetail, String string) {
        pSDESADetail.setUniqueTag(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("UNIQUETAG", "");
        map.put("CODENAME", "");
        map.put("PSDESARSID", "");
        map.put("PSDESERVICEAPIID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDESADetail pSDESADetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDESADetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDESADetail, true);
        pSDESADetail.set("UNIQUETAG", string);
        if (this.select(pSDESADetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDESADetail, true);
        return super.getModelV2Entity(pSDESADetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDESADetail pSDESADetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDESADetail, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDESADETAILPARAM_PSDESADETAIL_PSDESADETAILID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDESADetail pSDESADetail, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDESADetail, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDESADetail pSDESADetail, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDESADETAILPARAM_PSDESADETAIL_PSDESADETAILID")) {
            PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESADETAIL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDESADETAILPARAM", (Object)pSDESADetail.getPSDESADetailId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDESADETAIL#%1$s", (Object)pSDESADetail.getPSDESADetailId());
                for (PSDESADetailParam param : pSDESADetailParamService.selectByPSDESADetail(pSDESADetail)) {
                    String paramScope = pSDESADetailParamService.getModelV2ResScope(param);
                    if (StringHelper.compare((String)scope, (String)paramScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(param, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSDESADetailParamService.getModelV2Name(false);
                ArrayNode arrayNode = objectNode.putArray(modelName.toLowerCase());
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
                        if (objectNode.has("psdesadetailparamname")) {
                            string = objectNode.get("psdesadetailparamname").asText();
                        }
                        if (objectNode2.has("psdesadetailparamname")) {
                            string2 = objectNode2.get("psdesadetailparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode paramNode : arrayList) {
                    PSDESADetailParam param = new PSDESADetailParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)param, paramNode, false);
                    arrayNode.add((JsonNode)pSDESADetailParamService.exportModelV2(param, string));
                }
            }
        }
        super.onExportCurModelV2(pSDESADetail, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDESADetail pSDESADetail) throws Exception {
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDESADetailParam> arrayList = pSDESADetailParamService.selectByPSDESADetail(pSDESADetail);
        String string = StringHelper.format((String)"PSDESADETAIL#%1$s", (Object)pSDESADetail.getPSDESADetailId());
        for (PSDESADetailParam pSDESADetailParam : arrayList) {
            String string2 = pSDESADetailParamService.getModelV2ResScope(pSDESADetailParam);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDESADetailParamService.emptyModelV2(pSDESADetailParam);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDESADetail.getPSDESADetailId());
        pSDESADetailParamService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDESADetailParamService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDESADETAILPARAM WHERE PSDESADETAILID = ?", sqlParamList);
        super.onEmptyModelV2(pSDESADetail);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSDESADetailParamService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDESADetail pSDESADetail, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDESADetailParam pSDESADetailParam = new PSDESADetailParam();
        pSDESADetailParam.set("PSDESADETAILID", pSDESADetail.getPSDESADetailId());
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDESADetailParamService.getModelV2Entity(pSDESADetailParam, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDESADetail, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDESADetail pSDESADetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDESADetailParamService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDESADetailParam pSDESADetailParam = new PSDESADetailParam();
                pSDESADetailParam.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
                pSDESADetailParam.setPSDESADetailName(pSDESADetail.getPSDESADetailName());
                pSDESADetailParamService.compileModelV2(pSDESADetailParam, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDESADetailParam pSDESADetailParam = new PSDESADetailParam();
                    pSDESADetailParam.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
                    pSDESADetailParam.setPSDESADetailName(pSDESADetail.getPSDESADetailName());
                    pSDESADetailParamService.compileModelV2(pSDESADetailParam, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDESADetail, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDESADetail pSDESADetail, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDESADETAILPARAM_PSDESADETAIL_PSDESADETAILID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDESADetailParams(pSDESADetail, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDESADetail, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDESADetailParams(PSDESADetail pSDESADetail, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDESADETAILPARAM", true), (boolean)false) == 0) {
            PSDESADetailParamService pSDESADetailParamService = (PSDESADetailParamService)ServiceGlobal.getService(PSDESADetailParamService.class, (SessionFactory)this.getSessionFactory());
            PSDESADetailParam pSDESADetailParam = new PSDESADetailParam();
            pSDESADetailParam.setPSDESADetailParamId(pSMOSFile.getPSModelId());
            if (!pSDESADetailParamService.get(pSDESADetailParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDESADetailParam.getPSDESADetailId(), (String)pSDESADetail.getPSDESADetailId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDESADetailParamService.exportModelV2(pSDESADetailParam);
            pSDESADetailParam.reset();
            if (!pSDESADetailParamService.setModelV2ResScope(pSDESADetailParam, "PSDESADETAIL", pSDESADetail.getPSDESADetailId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDESADetailParamService.importModelV2(pSDESADetailParam, objectNode);
            SessionFactoryManager.commit();
            return pSDESADetailParamService.getFile(pSDESADetailParam);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDESADetail pSDESADetail, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDESADetailParams(pSDESADetail, list);
        super.onFillPasteHelps(pSDESADetail, list);
    }

    protected void onFillPasteHelps_PSDESADetailParams(PSDESADetail pSDESADetail, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESADETAILPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSDESADETAILPARAM_PSDESADETAIL_PSDESADETAILID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458]\u7684[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5\u53c2\u6570]");
        list.add(pSHelpSection);
    }
}
