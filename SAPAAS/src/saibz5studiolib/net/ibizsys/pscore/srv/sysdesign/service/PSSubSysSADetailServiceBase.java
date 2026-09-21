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
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADetailDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADetailDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetailParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailParamServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADetailServiceBase
extends PSCoreSysServiceBase<PSSubSysSADetail> {
    private static final Log log = LogFactory.getLog(PSSubSysSADetailServiceBase.class);
    public static final String DATASET_CURAPI = "CurAPI";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubSysSADetailDEModel pSSubSysSADetailDEModel;
    private PSSubSysSADetailDAO pSSubSysSADetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService";
    }

    public PSSubSysSADetailDEModel getPSSubSysSADetailDEModel() {
        if (this.pSSubSysSADetailDEModel == null) {
            try {
                this.pSSubSysSADetailDEModel = (PSSubSysSADetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysSADetailDEModel();
    }

    public PSSubSysSADetailDAO getPSSubSysSADetailDAO() {
        if (this.pSSubSysSADetailDAO == null) {
            try {
                this.pSSubSysSADetailDAO = (PSSubSysSADetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysSADetailDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPI, (boolean)true) == 0) {
            return this.fetchCurAPI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPI, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    protected void onFillParentInfo(PSSubSysSADetail pSSubSysSADetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_INPSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADE);
            } else {
                iService.get((IEntity)pSSubSysSADE);
            }
            this.onFillParentInfo_InPSSubSysSADE(pSSubSysSADetail, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_OUTPSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADE);
            } else {
                iService.get((IEntity)pSSubSysSADE);
            }
            this.onFillParentInfo_OutPSSubSysSADE(pSSubSysSADetail, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_PSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADE);
            } else {
                iService.get((IEntity)pSSubSysSADE);
            }
            this.onFillParentInfo_PSSubSysSADE(pSSubSysSADetail, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_RETPSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADE);
            } else {
                iService.get((IEntity)pSSubSysSADE);
            }
            this.onFillParentInfo_RetPSSubSysSADE(pSSubSysSADetail, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysServiceAPI);
            } else {
                iService.get((IEntity)pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSSubSysSADetail, pSSubSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSYSDYNAMODEL_INPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_InPSSysDynaModel(pSSubSysSADetail, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSYSDYNAMODEL_OUTPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_OutPSSysDynaModel(pSSubSysSADetail, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADETAIL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSubSysSADetail, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSSubSysSADetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_InPSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADetail.setInPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADetail.setInPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
    }

    protected void onFillParentInfo_OutPSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADetail.setOutPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADetail.setOutPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
    }

    protected void onFillParentInfo_PSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADetail.setPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADetail.setPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
        if (pSSubSysSADE.getPSSubSysServiceAPI() != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSSubSysSADetail, pSSubSysSADE.getPSSubSysServiceAPI());
        }
    }

    protected void onFillParentInfo_RetPSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADetail.setRetPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADetail.setRetPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSSubSysSADetail pSSubSysSADetail, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSSubSysSADetail.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSSubSysSADetail.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillParentInfo_InPSSysDynaModel(PSSubSysSADetail pSSubSysSADetail, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSubSysSADetail.setInPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSubSysSADetail.setInPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_OutPSSysDynaModel(PSSubSysSADetail pSSubSysSADetail, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSubSysSADetail.setOutPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSubSysSADetail.setOutPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSubSysSADetail pSSubSysSADetail, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSubSysSADetail.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSubSysSADetail.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
        if (bl && pSSubSysSADetail.getValidFlag() == null) {
            pSSubSysSADetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_InPSSubSysSADE(pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_OutPSSubSysSADE(pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_PSSubSysSADE(pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_RetPSSubSysSADE(pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_InPSSysDynaModel(pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_OutPSSysDynaModel(pSSubSysSADetail, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSubSysSADetail, bl);
    }

    protected void onFillEntityFullInfo_InPSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RetPSSubSysSADE(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
        if (pSSubSysSADetail.isPSSubSysServiceAPIIdDirty()) {
            if (pSSubSysSADetail.getPSSubSysServiceAPIId() != null) {
                if (pSSubSysSADetail.getPSSubSysServiceAPIId() == null || pSSubSysSADetail.getPSSubSysServiceAPIName() == null) {
                    PSSubSysServiceAPI pSSubSysServiceAPI = pSSubSysSADetail.getPSSubSysServiceAPI();
                    pSSubSysSADetail.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                }
            } else {
                pSSubSysSADetail.setPSSubSysServiceAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_InPSSysDynaModel(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSSysDynaModel(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSubSysSADetail, bl);
    }

    public ArrayList<PSSubSysSADetail> selectByInPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByInPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByInPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByInPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByInPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADetail> selectByOutPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByOutPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByOutPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByOutPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByOutPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADetail> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADetail> selectByRetPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByRetPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByRetPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByRetPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByRetPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RETPSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRetPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRetPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADetail> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysSADetail> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByInPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByInPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByInPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADetail> selectByOutPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByOutPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByOutPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByOutPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByOutPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OUTPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOutPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOutPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADetail> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSubSysSADetail> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSubSysSADetail> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByInPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByInPSSubSysSADE(pSSubSysSADE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_INPSSUBSYSSADEID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADE), arrayList.get(0)));
        }
    }

    public void resetInPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByInPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setInPSSubSysSADEId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByInPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByInPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.internalRemoveByInPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByInPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByInPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByInPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByInPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByInPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByInPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByInPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByInPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByOutPSSubSysSADE(pSSubSysSADE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_OUTPSSUBSYSSADEID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADE), arrayList.get(0)));
        }
    }

    public void resetOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByOutPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setOutPSSubSysSADEId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByOutPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.internalRemoveByOutPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByOutPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByOutPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByOutPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByOutPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_PSSUBSYSSADEID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADE), arrayList.get(0)));
        }
    }

    public void resetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setPSSubSysSADEId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.internalRemoveByPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    public void testRemoveByRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByRetPSSubSysSADE(pSSubSysSADE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_RETPSSUBSYSSADEID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADE), arrayList.get(0)));
        }
    }

    public void resetRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByRetPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setRetPSSubSysSADEId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByRetPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.internalRemoveByRetPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByRetPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByRetPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByRetPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByRetPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRetPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSubSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setPSSubSysServiceAPIId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSubSysSADetailServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    public void testRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSYSDYNAMODEL_INPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setInPSSysDynaModelId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByInPSSysDynaModel(pSSysDynaModel2);
                PSSubSysSADetailServiceBase.this.internalRemoveByInPSSysDynaModel(pSSysDynaModel2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByInPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByInPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByInPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByInPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByOutPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSYSDYNAMODEL_OUTPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByOutPSSysDynaModel(pSSysDynaModel);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setOutPSSysDynaModelId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByOutPSSysDynaModel(pSSysDynaModel2);
                PSSubSysSADetailServiceBase.this.internalRemoveByOutPSSysDynaModel(pSSysDynaModel2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByOutPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByOutPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByOutPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByOutPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADETAIL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSUBSYSSADETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            PSSubSysSADetail pSSubSysSADetail2 = (PSSubSysSADetail)this.getDEModel().createEntity();
            pSSubSysSADetail2.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
            pSSubSysSADetail2.setPSSysSFPluginId(null);
            this.update(pSSubSysSADetail2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADetailServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSubSysSADetailServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSubSysSADetailServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSubSysSADetail> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSubSysSADetail pSSubSysSADetail : arrayList) {
            this.remove((IEntity)pSSubSysSADetail);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSubSysSADetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysSADetail(pSSubSysSADetail);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysSADetail(pSSubSysSADetail);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysSADetail(pSSubSysSADetail);
        pSCoreSysServiceBase = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADetailParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSubSysSADetail(pSSubSysSADetail);
        ((PSSubSysSADetailParamServiceBase)pSCoreSysServiceBase).removeByPSSubSysSADetail(pSSubSysSADetail);
        super.onBeforeRemove(pSSubSysSADetail);
    }

    protected void onBeforeRemoveTemp(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        pSSubSysSADetailParamService.removeTempByPSSubSysSADetail(pSSubSysSADetail);
        super.onBeforeRemoveTemp((IEntity)pSSubSysSADetail);
    }

    protected void getRelatedDataTempMajor(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        this.getRelatedDataTempMajor_PSSubSysSADetailParam(pSSubSysSADetail);
        super.getRelatedDataTempMajor((IEntity)pSSubSysSADetail);
    }

    protected void getRelatedDataTempMajor_PSSubSysSADetailParam(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSubSysSADetailParam> arrayList = null;
        String string = pSSubSysSADetail.getPSSubSysSADetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSubSysSADetailParamService.selectByPSSubSysSADetail(pSSubSysSADetail) : pSSubSysSADetailParamService.selectTempByPSSubSysSADetail(pSSubSysSADetail);
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            pSSubSysSADetailParamService.getTempMajor(pSSubSysSADetailParam);
        }
    }

    protected void updateRelatedDataTempMajor(PSSubSysSADetail pSSubSysSADetail, PSSubSysSADetail pSSubSysSADetail2) throws Exception {
        ArrayList<PSSubSysSADetailParam> arrayList = this.updateRelatedDataTempMajor_removePSSubSysSADetailParam(pSSubSysSADetail, pSSubSysSADetail2);
        this.updateRelatedDataTempMajor_updatePSSubSysSADetailParam(pSSubSysSADetail, pSSubSysSADetail2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSubSysSADetail, (IEntity)pSSubSysSADetail2);
    }

    protected ArrayList<PSSubSysSADetailParam> updateRelatedDataTempMajor_removePSSubSysSADetailParam(PSSubSysSADetail pSSubSysSADetail, PSSubSysSADetail pSSubSysSADetail2) throws Exception {
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSubSysSADetailParam> arrayList = pSSubSysSADetailParamService.selectTempByPSSubSysSADetail(pSSubSysSADetail);
        ArrayList<PSSubSysSADetailParam> arrayList2 = pSSubSysSADetailParamService.selectByPSSubSysSADetail(pSSubSysSADetail2);
        HashMap<String, PSSubSysSADetailParam> hashMap = new HashMap<String, PSSubSysSADetailParam>();
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList2) {
            hashMap.put(pSSubSysSADetailParam.getPSSubSysSADetailParamId(), pSSubSysSADetailParam);
        }
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            Object object = pSSubSysSADetailParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSubSysSADetailParam pSSubSysSADetailParam : hashMap.values()) {
            pSSubSysSADetailParamService.remove((IEntity)pSSubSysSADetailParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSubSysSADetailParam(PSSubSysSADetail pSSubSysSADetail, PSSubSysSADetail pSSubSysSADetail2, ArrayList<PSSubSysSADetailParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            pSSubSysSADetailParamService.updateTempMajor(pSSubSysSADetailParam);
        }
    }

    protected void replaceParentInfo(PSSubSysSADetail pSSubSysSADetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSubSysSADetail, cloneSession);
        if (pSSubSysSADetail.getInPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADetail.getInPSSubSysSADEId())) != null) {
            this.onFillParentInfo_InPSSubSysSADE(pSSubSysSADetail, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADetail.getOutPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADetail.getOutPSSubSysSADEId())) != null) {
            this.onFillParentInfo_OutPSSubSysSADE(pSSubSysSADetail, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADetail.getPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADetail.getPSSubSysSADEId())) != null) {
            this.onFillParentInfo_PSSubSysSADE(pSSubSysSADetail, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADetail.getRetPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADetail.getRetPSSubSysSADEId())) != null) {
            this.onFillParentInfo_RetPSSubSysSADE(pSSubSysSADetail, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADetail.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSSubSysSADetail.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSSubSysSADetail, (PSSubSysServiceAPI)iEntity);
        }
        if (pSSubSysSADetail.getInPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSubSysSADetail.getInPSSysDynaModelId())) != null) {
            this.onFillParentInfo_InPSSysDynaModel(pSSubSysSADetail, (PSSysDynaModel)iEntity);
        }
        if (pSSubSysSADetail.getOutPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSubSysSADetail.getOutPSSysDynaModelId())) != null) {
            this.onFillParentInfo_OutPSSysDynaModel(pSSubSysSADetail, (PSSysDynaModel)iEntity);
        }
        if (pSSubSysSADetail.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSubSysSADetail.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSubSysSADetail, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSubSysSADetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AfterCode(bl, pSSubSysSADetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParam(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParam2(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParams(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag2(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailType(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSSubSysSADEId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InPSSysDynaModelId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyFieldName(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MethodCode(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NeedResourceKey(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoServiceCodeName(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSubSysSADEId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSysDynaModelId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicName(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADEId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADetailName(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIName(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestContentType(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestMethod(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestParamType(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetPSSubSysSADEId(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetStdDataType(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RetValType(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceUrl(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTag(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSubSysSADetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSubSysSADetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AfterCode(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isAfterCodeDirty() : !pSSubSysSADetail.isAfterCodeDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getAfterCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AfterCode_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AFTERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isCodeNameDirty() && !bl2 : !pSSubSysSADetail.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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
                string3 = "PSSUBSYSSADEID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADetailDEModel(), "CODENAME", string3, pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isCodeName2Dirty() : !pSSubSysSADetail.isCodeName2Dirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isCustomCodeDirty() : !pSSubSysSADetail.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isCustomModeDirty() : !pSSubSysSADetail.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetail.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isDetailIdDirty() : !pSSubSysSADetail.isDetailIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getDetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailParam(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isDetailParamDirty() : !pSSubSysSADetail.isDetailParamDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getDetailParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailParam2(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isDetailParam2Dirty() : !pSSubSysSADetail.isDetailParam2Dirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getDetailParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam2_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailParams(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isDetailParamsDirty() : !pSSubSysSADetail.isDetailParamsDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getDetailParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParams_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailTag(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isDetailTagDirty() : !pSSubSysSADetail.isDetailTagDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getDetailTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailTag2(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isDetailTag2Dirty() : !pSSubSysSADetail.isDetailTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getDetailTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag2_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailType(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isDetailTypeDirty() && !bl2 : !pSSubSysSADetail.isDetailTypeDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getDetailType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailType_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_InPSSubSysSADEId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isInPSSubSysSADEIdDirty() : !pSSubSysSADetail.isInPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getInPSSubSysSADEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSSubSysSADEId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InPSSysDynaModelId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isInPSSysDynaModelIdDirty() : !pSSubSysSADetail.isInPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getInPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InPSSysDynaModelId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyFieldName(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isKeyFieldNameDirty() : !pSSubSysSADetail.isKeyFieldNameDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getKeyFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyFieldName_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isMemoDirty() : !pSSubSysSADetail.isMemoDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_MethodCode(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isMethodCodeDirty() : !pSSubSysSADetail.isMethodCodeDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getMethodCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MethodCode_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_NeedResourceKey(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isNeedResourceKeyDirty() : !pSSubSysSADetail.isNeedResourceKeyDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetail.getNeedResourceKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NeedResourceKey_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoServiceCodeName(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isNoServiceCodeNameDirty() : !pSSubSysSADetail.isNoServiceCodeNameDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetail.getNoServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoServiceCodeName_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutPSSubSysSADEId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isOutPSSubSysSADEIdDirty() : !pSSubSysSADetail.isOutPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getOutPSSubSysSADEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSubSysSADEId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OutPSSysDynaModelId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isOutPSSysDynaModelIdDirty() : !pSSubSysSADetail.isOutPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getOutPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSysDynaModelId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSDEIdDirty() : !pSSubSysSADetail.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicName(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSDELogicNameDirty() : !pSSubSysSADetail.isPSDELogicNameDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSDELogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicName_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSDENameDirty() : !pSSubSysSADetail.isPSDENameDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysSADEId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSSubSysSADEIdDirty() : !pSSubSysSADetail.isPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSSubSysSADEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADEId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADetailId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSSubSysSADetailIdDirty() && !bl2 : !pSSubSysSADetail.isPSSubSysSADetailIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSSubSysSADetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADetailName(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSSubSysSADetailNameDirty() && !bl2 : !pSSubSysSADetail.isPSSubSysSADetailNameDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSSubSysSADetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADetailName_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSSubSysServiceAPIIdDirty() && !bl2 : !pSSubSysSADetail.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSubSysServiceAPIName(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSSubSysServiceAPINameDirty() && !bl2 : !pSSubSysSADetail.isPSSubSysServiceAPINameDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSSubSysServiceAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIName_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isPSSysSFPluginIdDirty() : !pSSubSysSADetail.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RequestContentType(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isRequestContentTypeDirty() : !pSSubSysSADetail.isRequestContentTypeDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getRequestContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestContentType_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTCONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestMethod(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isRequestMethodDirty() : !pSSubSysSADetail.isRequestMethodDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getRequestMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestMethod_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RequestParamType(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isRequestParamTypeDirty() : !pSSubSysSADetail.isRequestParamTypeDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getRequestParamType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestParamType_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RetPSSubSysSADEId(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isRetPSSubSysSADEIdDirty() : !pSSubSysSADetail.isRetPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getRetPSSubSysSADEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RetPSSubSysSADEId_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETPSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RetStdDataType(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isRetStdDataTypeDirty() : !pSSubSysSADetail.isRetStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetail.getRetStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RetStdDataType_Default((IEntity)pSSubSysSADetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETSTDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RetValType(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isRetValTypeDirty() : !pSSubSysSADetail.isRetValTypeDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getRetValType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RetValType_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceUrl(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isServiceUrlDirty() : !pSSubSysSADetail.isServiceUrlDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceUrl_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UniqueTag(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isUniqueTagDirty() : !pSSubSysSADetail.isUniqueTagDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getUniqueTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTag_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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
                string3 = "PSSUBSYSSERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADetailDEModel(), "UNIQUETAG", string3, pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isUserCatDirty() : !pSSubSysSADetail.isUserCatDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isUserTagDirty() : !pSSubSysSADetail.isUserTagDirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isUserTag2Dirty() : !pSSubSysSADetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isUserTag3Dirty() : !pSSubSysSADetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isUserTag4Dirty() : !pSSubSysSADetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSubSysSADetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSubSysSADetail pSSubSysSADetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADetail.isValidFlagDirty() && !bl2 : !pSSubSysSADetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysSADetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSubSysSADetail, bl2, bl3);
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

    protected void onSyncEntity(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSubSysSADetail, bl);
    }

    protected void onSyncIndexEntities(PSSubSysSADetail pSSubSysSADetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSubSysSADetail, bl);
    }

    public Object getDataContextValue(PSSubSysSADetail pSSubSysSADetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSubSysSADetail, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSysSADetail pSSubSysSADetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSubSysSADetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AFTERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterCode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"METHODCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MethodCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEEDRESOURCEKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NeedResourceKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOSERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OUTPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTCONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTPARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETPSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetPSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETPSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetPSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETSTDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RetStdDataType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AfterCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DetailParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_InPSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYFIELDNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_NeedResourceKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OutPSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OutPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OUTPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_PSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RequestContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTCONTENTTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_RetPSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETPSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RetPSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETPSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RetStdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSubSysSADetail pSSubSysSADetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSubSysSADetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        super.onUpdateParent((IEntity)pSSubSysSADetail);
    }

    protected void onCopyDetails(PSSubSysSADetail pSSubSysSADetail, Object object) throws Exception {
        PSSubSysSADetail pSSubSysSADetail2 = new PSSubSysSADetail();
        pSSubSysSADetail2.set("PSSUBSYSSADETAILID", object);
        String string = DataObject.getStringValue((Object)pSSubSysSADetail.get("PSSUBSYSSADETAILID"));
        super.onCopyDetails((IEntity)pSSubSysSADetail, object);
    }

    @Override
    protected void exportCurXmlModel(PSSubSysSADetail pSSubSysSADetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYSSADETAIL");
        if (!bl) {
            pSSubSysSADetail.setCreateDate(null);
            pSSubSysSADetail.setCreateMan(null);
            pSSubSysSADetail.setPSSubSysSADetailId(null);
            pSSubSysSADetail.setUpdateDate(null);
            pSSubSysSADetail.setUpdateMan(null);
            super.exportCurXmlModel(pSSubSysSADetail, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSubSysSADetail pSSubSysSADetail, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSubSysSADetailParam(pSSubSysSADetail, xmlNode);
        super.onExportRelatedXmlModel(pSSubSysSADetail, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSubSysSADetailParam(PSSubSysSADetail pSSubSysSADetail, XmlNode xmlNode) throws Exception {
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSubSysSADetailParam> arrayList = null;
        String string = pSSubSysSADetail.getPSSubSysSADetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSubSysSADetailParamService.selectByPSSubSysSADetail(pSSubSysSADetail, "ORDER BY ORDERVALUE ASC") : pSSubSysSADetailParamService.selectTempByPSSubSysSADetail(pSSubSysSADetail, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSUBSYSSADETAILPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
                pSSubSysSADetailParam.set("ORDERVALUE", null);
                pSSubSysSADetailParamService.exportXmlModel(pSSubSysSADetailParam, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSubSysSADetail pSSubSysSADetail, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSUBSYSSADETAILPARAMS");
        this.importRelatedXmlModel_PSSubSysSADetailParam(pSSubSysSADetail, xmlNode2);
        super.onImportRelatedXmlModel(pSSubSysSADetail, xmlNode);
    }

    protected void importRelatedXmlModel_PSSubSysSADetailParam(PSSubSysSADetail pSSubSysSADetail, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSubSysSADetail.getPSSubSysSADetailId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSubSysSADetailParamService.removeByPSSubSysSADetail(pSSubSysSADetail);
        } else {
            pSSubSysSADetailParamService.removeTempByPSSubSysSADetail(pSSubSysSADetail);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSubSysSADetailParam pSSubSysSADetailParam = new PSSubSysSADetailParam();
                pSSubSysSADetailParam.setOrderValue(n);
                n += 100;
                pSSubSysSADetailParamService.fillParentInfo((IEntity)pSSubSysSADetailParam, "DER1N", "DER1N_PSSUBSYSSADETAILPARAM_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", pSSubSysSADetail.getPSSubSysSADetailId());
                pSSubSysSADetailParamService.importXmlModel(pSSubSysSADetailParam, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSubSysSADetail pSSubSysSADetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSubSysSADetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSUBSYSSADE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSUBSYSSERVICEAPI#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSUBSYSSADETAIL_PSSUBSYSSADE_PSSUBSYSSADEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSUBSYSSADETAIL_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSERVICEAPINAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADE", (boolean)true) == 0) {
            iEntity.set("PSSUBSYSSADEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPI", (boolean)true) == 0) {
            iEntity.set("PSSUBSYSSERVICEAPIID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSUBSYSSADEID", "PSSUBSYSSERVICEAPIID"};
    }

    @Override
    public String getModelV2Tag(PSSubSysSADetail pSSubSysSADetail) {
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADetail.getCodeName())) {
            return pSSubSysSADetail.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADetail.getCodeName())) {
            return pSSubSysSADetail.getCodeName();
        }
        return super.getModelV2Tag(pSSubSysSADetail);
    }

    @Override
    public boolean setModelV2Tag(PSSubSysSADetail pSSubSysSADetail, String string) {
        pSSubSysSADetail.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSUBSYSSADEID", "");
        map.put("PSSUBSYSSERVICEAPIID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSubSysSADetail pSSubSysSADetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSubSysSADetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSubSysSADetail, true);
        pSSubSysSADetail.set("CODENAME", string);
        if (this.select(pSSubSysSADetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSubSysSADetail, true);
        return super.getModelV2Entity(pSSubSysSADetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSubSysSADetail pSSubSysSADetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSubSysSADetail, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSUBSYSSADETAILPARAM_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSubSysSADetail pSSubSysSADetail, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSubSysSADetail, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSubSysSADetail pSSubSysSADetail, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSUBSYSSADETAILPARAM_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID")) {
            Object object;
            PSSubSysSADetailParam pSSubSysSADetailParam2;
            Object object2;
            Object object3;
            Object object4;
            PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSubSysSADetailParam> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSUBSYSSADETAIL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSUBSYSSADETAILPARAM", (Object)pSSubSysSADetail.getPSSubSysSADetailId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSubSysSADetailParam2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSubSysSADetailParam2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSubSysSADetailParam>();
                object4 = pSSubSysSADetailParamService.selectByPSSubSysSADetail(pSSubSysSADetail);
                object3 = StringHelper.format((String)"PSSUBSYSSADETAIL#%1$s", (Object)pSSubSysSADetail.getPSSubSysSADetailId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSubSysSADetailParam2 = object2.next();
                    object = pSSubSysSADetailParamService.getModelV2ResScope((IEntity)pSSubSysSADetailParam2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSubSysSADetailParam)PSModelV2Helper.toJSONObject((IEntity)pSSubSysSADetailParam2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSubSysSADetailParamService.getModelV2Name(false);
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
                        if (objectNode.has("pssubsyssadetailparamname")) {
                            string = objectNode.get("pssubsyssadetailparamname").asText();
                        }
                        if (objectNode2.has("pssubsyssadetailparamname")) {
                            string2 = objectNode2.get("pssubsyssadetailparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSubSysSADetailParam pSSubSysSADetailParam2 : arrayList) {
                    object = new PSSubSysSADetailParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSubSysSADetailParam2, false);
                    object3.add((JsonNode)pSSubSysSADetailParamService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSubSysSADetail, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSubSysSADetail pSSubSysSADetail) throws Exception {
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSubSysSADetailParam> arrayList = pSSubSysSADetailParamService.selectByPSSubSysSADetail(pSSubSysSADetail);
        String string = StringHelper.format((String)"PSSUBSYSSADETAIL#%1$s", (Object)pSSubSysSADetail.getPSSubSysSADetailId());
        for (PSSubSysSADetailParam pSSubSysSADetailParam : arrayList) {
            String string2 = pSSubSysSADetailParamService.getModelV2ResScope((IEntity)pSSubSysSADetailParam);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSubSysSADetailParamService.emptyModelV2(pSSubSysSADetailParam);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSubSysSADetail.getPSSubSysSADetailId());
        pSSubSysSADetailParamService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSubSysSADetailParamService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSUBSYSSADETAILPARAM WHERE PSSUBSYSSADETAILID = ?", sqlParamList);
        super.onEmptyModelV2(pSSubSysSADetail);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSSubSysSADetailParamService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSubSysSADetail pSSubSysSADetail, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSubSysSADetailParam pSSubSysSADetailParam = new PSSubSysSADetailParam();
        pSSubSysSADetailParam.set("PSSUBSYSSADETAILID", pSSubSysSADetail.getPSSubSysSADetailId());
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSubSysSADetailParamService.getModelV2Entity(pSSubSysSADetailParam, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSubSysSADetail, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSubSysSADetail pSSubSysSADetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSubSysSADetailParamService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSubSysSADetailParam pSSubSysSADetailParam = new PSSubSysSADetailParam();
                pSSubSysSADetailParam.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
                pSSubSysSADetailParam.setPSSubSysSADetailName(pSSubSysSADetail.getPSSubSysSADetailName());
                pSSubSysSADetailParamService.compileModelV2(pSSubSysSADetailParam, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSubSysSADetailParam pSSubSysSADetailParam = new PSSubSysSADetailParam();
                    pSSubSysSADetailParam.setPSSubSysSADetailId(pSSubSysSADetail.getPSSubSysSADetailId());
                    pSSubSysSADetailParam.setPSSubSysSADetailName(pSSubSysSADetail.getPSSubSysSADetailName());
                    pSSubSysSADetailParamService.compileModelV2(pSSubSysSADetailParam, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSubSysSADetail, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSubSysSADetail pSSubSysSADetail, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSUBSYSSADETAILPARAM_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSubSysSADetailParams(pSSubSysSADetail, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSubSysSADetail, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSubSysSADetailParams(PSSubSysSADetail pSSubSysSADetail, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSUBSYSSADETAILPARAM", true), (boolean)false) == 0) {
            PSSubSysSADetailParamService pSSubSysSADetailParamService = (PSSubSysSADetailParamService)ServiceGlobal.getService(PSSubSysSADetailParamService.class, (SessionFactory)this.getSessionFactory());
            PSSubSysSADetailParam pSSubSysSADetailParam = new PSSubSysSADetailParam();
            pSSubSysSADetailParam.setPSSubSysSADetailParamId(pSMOSFile.getPSModelId());
            if (!pSSubSysSADetailParamService.get((IEntity)pSSubSysSADetailParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSubSysSADetailParam.getPSSubSysSADetailId(), (String)pSSubSysSADetail.getPSSubSysSADetailId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSubSysSADetailParamService.exportModelV2(pSSubSysSADetailParam);
            pSSubSysSADetailParam.reset();
            if (!pSSubSysSADetailParamService.setModelV2ResScope((IEntity)pSSubSysSADetailParam, "PSSUBSYSSADETAIL", pSSubSysSADetail.getPSSubSysSADetailId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSubSysSADetailParamService.importModelV2(pSSubSysSADetailParam, objectNode);
            SessionFactoryManager.commit();
            return pSSubSysSADetailParamService.getFile((IEntity)pSSubSysSADetailParam);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSubSysSADetail pSSubSysSADetail, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSubSysSADetailParams(pSSubSysSADetail, list);
        super.onFillPasteHelps(pSSubSysSADetail, list);
    }

    protected void onFillPasteHelps_PSSubSysSADetailParams(PSSubSysSADetail pSSubSysSADetail, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSUBSYSSADETAILPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSSUBSYSSADETAILPARAM_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5]\u7684[\u5916\u90e8\u7cfb\u7edf\u63a5\u53e3\u6210\u5458\u53c2\u6570]");
        list.add(pSHelpSection);
    }
}

