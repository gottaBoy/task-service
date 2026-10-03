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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEServiceAPIDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEServiceAPIDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESAVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESAVRBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCaseBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEServiceAPIServiceBase
extends PSCoreSysServiceBase<PSDEServiceAPI> {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYSAPI = "CurSysAPI";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEEX = "CreateEx";
    public static final String ACTION_REBUILDDETAILS = "RebuildDetails";
    public static final String ACTION_REMOVEEX = "RemoveEx";
    private PSDEServiceAPIDEModel pSDEServiceAPIDEModel;
    private PSDEServiceAPIDAO pSDEServiceAPIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService";
    }

    public PSDEServiceAPIDEModel getPSDEServiceAPIDEModel() {
        if (this.pSDEServiceAPIDEModel == null) {
            try {
                this.pSDEServiceAPIDEModel = (PSDEServiceAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEServiceAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEServiceAPIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEServiceAPIDEModel();
    }

    public PSDEServiceAPIDAO getPSDEServiceAPIDAO() {
        if (this.pSDEServiceAPIDAO == null) {
            try {
                this.pSDEServiceAPIDAO = (PSDEServiceAPIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEServiceAPIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEServiceAPIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEServiceAPIDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSAPI, (boolean)true) == 0) {
            return this.fetchCurSysAPI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEEX, (boolean)true) == 0) {
            this.createEx((PSDEServiceAPI)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_REBUILDDETAILS, (boolean)true) == 0) {
            this.rebuildDetails((PSDEServiceAPI)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_REMOVEEX, (boolean)true) == 0) {
            this.removeEx((PSDEServiceAPI)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAPI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSAPI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void createEx(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEEX, 0, pSDEServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEServiceAPI, ACTION_CREATEEX);
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEServiceAPIServiceBase.this.getService(), PSDEServiceAPIServiceBase.ACTION_CREATEEX, 40, pSDEServiceAPI2, null).getResult() != 1) {
                    PSDEServiceAPIServiceBase.this.onCreateEx(pSDEServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEEX, 99, pSDEServiceAPI, null);
        }
    }

    protected void onCreateEx(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateEx]");
    }

    public void rebuildDetails(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDDETAILS, 0, pSDEServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEServiceAPI, ACTION_REBUILDDETAILS);
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEServiceAPIServiceBase.this.getService(), PSDEServiceAPIServiceBase.ACTION_REBUILDDETAILS, 40, pSDEServiceAPI2, null).getResult() != 1) {
                    PSDEServiceAPIServiceBase.this.onRebuildDetails(pSDEServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDDETAILS, 99, pSDEServiceAPI, null);
        }
    }

    protected void onRebuildDetails(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RebuildDetails]");
    }

    public void removeEx(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REMOVEEX, 0, pSDEServiceAPI, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEServiceAPI, ACTION_REMOVEEX);
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEServiceAPIServiceBase.this.getService(), PSDEServiceAPIServiceBase.ACTION_REMOVEEX, 40, pSDEServiceAPI2, null).getResult() != 1) {
                    PSDEServiceAPIServiceBase.this.onRemoveEx(pSDEServiceAPI2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REMOVEEX, 99, pSDEServiceAPI, null);
        }
    }

    protected void onRemoveEx(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RemoveEx]");
    }

    protected void onFillParentInfo(PSDEServiceAPI pSDEServiceAPI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEServiceAPI, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSDEServiceAPI, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSLANGUAGERES_LNPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_LNPSLanRes(pSDEServiceAPI, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEServiceAPI, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysServiceAPI);
            } else {
                iService.get(pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSDEServiceAPI, pSSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEServiceAPI, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSSYSTRANSLATOR_OUTPSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTranslator);
            } else {
                iService.get(pSSysTranslator);
            }
            this.onFillParentInfo_OutPSSysTranslator(pSDEServiceAPI, pSSysTranslator);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESERVICEAPI_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSDEServiceAPI, pSSysUniRes);
            return;
        }
        super.onFillParentInfo(pSDEServiceAPI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEServiceAPI pSDEServiceAPI, PSDataEntity pSDataEntity) throws Exception {
        pSDEServiceAPI.setDELogicName(pSDataEntity.getLogicName());
        pSDEServiceAPI.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEServiceAPI.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEFGroup(PSDEServiceAPI pSDEServiceAPI, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEServiceAPI.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEServiceAPI.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_LNPSLanRes(PSDEServiceAPI pSDEServiceAPI, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEServiceAPI.setLNPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEServiceAPI.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEServiceAPI pSDEServiceAPI, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEServiceAPI.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEServiceAPI.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSDEServiceAPI pSDEServiceAPI, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSDEServiceAPI.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSDEServiceAPI.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEServiceAPI pSDEServiceAPI, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEServiceAPI.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEServiceAPI.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_OutPSSysTranslator(PSDEServiceAPI pSDEServiceAPI, PSSysTranslator pSSysTranslator) throws Exception {
        pSDEServiceAPI.setOutPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDEServiceAPI.setOutPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSDEServiceAPI pSDEServiceAPI, PSSysUniRes pSSysUniRes) throws Exception {
        pSDEServiceAPI.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSDEServiceAPI.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
        if (bl && pSDEServiceAPI.getValidFlag() == null) {
            pSDEServiceAPI.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_PSDE(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_LNPSLanRes(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_OutPSSysTranslator(pSDEServiceAPI, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSDEServiceAPI, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
        if (pSDEServiceAPI.isPSDEIdDirty()) {
            if (pSDEServiceAPI.getPSDEId() != null) {
                if (pSDEServiceAPI.getPSDEId() == null || pSDEServiceAPI.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEServiceAPI.getPSDE();
                    pSDEServiceAPI.setDELogicName(pSDataEntity.getLogicName());
                    pSDEServiceAPI.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEServiceAPI.setDELogicName(null);
                pSDEServiceAPI.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LNPSLanRes(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
        if (pSDEServiceAPI.isLNPSLanResIdDirty()) {
            if (pSDEServiceAPI.getLNPSLanResId() != null) {
                if (pSDEServiceAPI.getLNPSLanResId() == null || pSDEServiceAPI.getLNPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEServiceAPI.getLNPSLanRes();
                    pSDEServiceAPI.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEServiceAPI.setLNPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OutPSSysTranslator(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEServiceAPI, bl);
    }

    public ArrayList<PSDEServiceAPI> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEServiceAPI> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEServiceAPI> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LNPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLNPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLNPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEServiceAPI> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEServiceAPI> selectByOutPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByOutPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByOutPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByOutPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByOutPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEServiceAPI> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSDEServiceAPI> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setPSDEId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEServiceAPIServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSDEFGROUP_PSDEFGROUPID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setPSDEFGroupId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEServiceAPIServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByLNPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSLANGUAGERES_LNPSLANRESID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setLNPSLanResId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEServiceAPIServiceBase.this.internalRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByLNPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByLNPSLanRes(pSLanguageRes, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByLNPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setPSSysReqItemId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEServiceAPIServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setPSSysServiceAPIId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSDEServiceAPIServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setPSSysSFPluginId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEServiceAPIServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByOutPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSSYSTRANSLATOR_OUTPSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByOutPSSysTranslator(pSSysTranslator);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setOutPSSysTranslatorId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByOutPSSysTranslator(pSSysTranslator2);
                PSDEServiceAPIServiceBase.this.internalRemoveByOutPSSysTranslator(pSSysTranslator2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByOutPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByOutPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByOutPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByOutPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOutPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESERVICEAPI_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSDESERVICEAPI", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)this.getDEModel().createEntity();
            pSDEServiceAPI2.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDEServiceAPI2.setPSSysUniResId(null);
            this.update(pSDEServiceAPI2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEServiceAPIServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEServiceAPIServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEServiceAPIServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEServiceAPI> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSDEServiceAPI pSDEServiceAPI : arrayList) {
            this.remove(pSDEServiceAPI);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEServiceAPI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByInPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByOutPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEServiceAPI(pSDEServiceAPI);
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).removeByPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESARSServiceBase)pSCoreSysServiceBase).testRemoveByCPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESARSServiceBase)pSCoreSysServiceBase).testRemoveByPPSDEServiceAPI(pSDEServiceAPI);
        ((PSDESARSServiceBase)pSCoreSysServiceBase).removeByPPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESAVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEServiceAPI(pSDEServiceAPI);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSDEServiceAPI(pSDEServiceAPI);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDEServiceAPI(pSDEServiceAPI);
        super.onBeforeRemove(pSDEServiceAPI);
    }

    protected void replaceParentInfo(PSDEServiceAPI pSDEServiceAPI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEServiceAPI, cloneSession);
        if (pSDEServiceAPI.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEServiceAPI.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEServiceAPI, (PSDataEntity)iEntity);
        }
        if (pSDEServiceAPI.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEServiceAPI.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSDEServiceAPI, (PSDEFGroup)iEntity);
        }
        if (pSDEServiceAPI.getLNPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEServiceAPI.getLNPSLanResId())) != null) {
            this.onFillParentInfo_LNPSLanRes(pSDEServiceAPI, (PSLanguageRes)iEntity);
        }
        if (pSDEServiceAPI.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEServiceAPI.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEServiceAPI, (PSSysReqItem)iEntity);
        }
        if (pSDEServiceAPI.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSDEServiceAPI.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSDEServiceAPI, (PSSysServiceAPI)iEntity);
        }
        if (pSDEServiceAPI.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEServiceAPI.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEServiceAPI, (PSSysSFPlugin)iEntity);
        }
        if (pSDEServiceAPI.getOutPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDEServiceAPI.getOutPSSysTranslatorId())) != null) {
            this.onFillParentInfo_OutPSSysTranslator(pSDEServiceAPI, (PSSysTranslator)iEntity);
        }
        if (pSDEServiceAPI.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSDEServiceAPI.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSDEServiceAPI, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEServiceAPI, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccCtrlArch(bl, pSDEServiceAPI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APITag(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APITag2(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BaseClsParams(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataAccMode(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFGroupMode(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDataExport(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDataImport(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDEAction(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDEDataSet(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSelect(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnaTempData(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResName(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorFlag(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutPSSysTranslatorId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIName(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceParam2(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEServiceAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEServiceAPI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccCtrlArch(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isAccCtrlArchDirty() : !pSDEServiceAPI.isAccCtrlArchDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getAccCtrlArch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AccCtrlArch_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCCTRLARCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APITag(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isAPITagDirty() : !pSDEServiceAPI.isAPITagDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getAPITag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APITag_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_APITag2(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isAPITag2Dirty() : !pSDEServiceAPI.isAPITag2Dirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getAPITag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_APITag2_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isBaseClsParamsDirty() : !pSDEServiceAPI.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isCodeNameDirty() : !pSDEServiceAPI.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEServiceAPI, bl2, bl3);
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
                string3 = "PSSYSSERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSDEServiceAPIDEModel(), "CODENAME", string3, pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isCodeName2Dirty() : !pSDEServiceAPI.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isCustomCodeDirty() : !pSDEServiceAPI.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isCustomModeDirty() : !pSDEServiceAPI.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataAccMode(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isDataAccModeDirty() : !pSDEServiceAPI.isDataAccModeDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getDataAccMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DataAccMode_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAACCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFGroupMode(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isDEFGroupModeDirty() : !pSDEServiceAPI.isDEFGroupModeDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getDEFGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFGroupMode_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFGROUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDataExport(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isEnableDataExportDirty() : !pSDEServiceAPI.isEnableDataExportDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getEnableDataExport();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDataExport_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDATAEXPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDataImport(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isEnableDataImportDirty() : !pSDEServiceAPI.isEnableDataImportDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getEnableDataImport();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDataImport_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDATAIMPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDEAction(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isEnableDEActionDirty() : !pSDEServiceAPI.isEnableDEActionDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getEnableDEAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDEAction_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDEACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDEDataSet(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isEnableDEDataSetDirty() : !pSDEServiceAPI.isEnableDEDataSetDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getEnableDEDataSet();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDEDataSet_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDEDATASET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSelect(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isEnableSelectDirty() : !pSDEServiceAPI.isEnableSelectDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getEnableSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSelect_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESELECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnaTempData(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isEnaTempDataDirty() : !pSDEServiceAPI.isEnaTempDataDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getEnaTempData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaTempData_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENATEMPDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isLNPSLanResIdDirty() : !pSDEServiceAPI.isLNPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getLNPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResId_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResName(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isLNPSLanResNameDirty() : !pSDEServiceAPI.isLNPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getLNPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResName_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isLockFlagDirty() : !pSDEServiceAPI.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isLogicNameDirty() : !pSDEServiceAPI.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorFlag(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isMajorFlagDirty() : !pSDEServiceAPI.isMajorFlagDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getMajorFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MajorFlag_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isMemoDirty() : !pSDEServiceAPI.isMemoDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isOrderValueDirty() : !pSDEServiceAPI.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutPSSysTranslatorId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isOutPSSysTranslatorIdDirty() : !pSDEServiceAPI.isOutPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getOutPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OutPSSysTranslatorId_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSDEFGroupIdDirty() : !pSDEServiceAPI.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSDEIdDirty() && !bl2 : !pSDEServiceAPI.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSDENameDirty() && !bl2 : !pSDEServiceAPI.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEServiceAPIId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSDEServiceAPIIdDirty() && !bl2 : !pSDEServiceAPI.isPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSDEServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIId_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEServiceAPIName(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSDEServiceAPINameDirty() && !bl2 : !pSDEServiceAPI.isPSDEServiceAPINameDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSDEServiceAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIName_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPINAME");
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
                string3 = "PSSYSSERVICEAPIID";
                String string4 = this.checkFieldDupRule(this.getPSDEServiceAPIDEModel(), "PSDESERVICEAPINAME", string3, pSDEServiceAPI, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDESERVICEAPINAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSSysReqItemIdDirty() : !pSDEServiceAPI.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSSysServiceAPIIdDirty() && !bl2 : !pSDEServiceAPI.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSSysServiceAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSSysSFPluginIdDirty() : !pSDEServiceAPI.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isPSSysUniResIdDirty() : !pSDEServiceAPI.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSDEServiceAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceParam(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isServiceParamDirty() : !pSDEServiceAPI.isServiceParamDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getServiceParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceParam2(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isServiceParam2Dirty() : !pSDEServiceAPI.isServiceParam2Dirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getServiceParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceParam2_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isUserCatDirty() : !pSDEServiceAPI.isUserCatDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isUserTagDirty() : !pSDEServiceAPI.isUserTagDirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isUserTag2Dirty() : !pSDEServiceAPI.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isUserTag3Dirty() : !pSDEServiceAPI.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isUserTag4Dirty() : !pSDEServiceAPI.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEServiceAPI.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEServiceAPI, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEServiceAPI pSDEServiceAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEServiceAPI.isValidFlagDirty() && !bl2 : !pSDEServiceAPI.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEServiceAPI.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEServiceAPI, bl2, bl3);
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

    protected void onSyncEntity(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
        super.onSyncEntity(pSDEServiceAPI, bl);
    }

    protected void onSyncIndexEntities(PSDEServiceAPI pSDEServiceAPI, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEServiceAPI, bl);
    }

    public Object getDataContextValue(PSDEServiceAPI pSDEServiceAPI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEServiceAPI, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysServiceAPI pSSysServiceAPI = pSDEServiceAPI.getPSSysServiceAPI();
        if (pSSysServiceAPI != null && pSSysServiceAPI.contains(string)) {
            return pSSysServiceAPI.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEServiceAPI pSDEServiceAPI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEServiceAPI, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCCTRLARCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccCtrlArch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APITag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APITAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APITag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BASECLSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseClsParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATAACCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataAccMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFGROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFGroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDATAEXPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDataExport_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDATAIMPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDataImport_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDEACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDEAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDEDataSet_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENATEMPDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaTempData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceParam2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AccCtrlArch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected String onTestValueRule_DataAccMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEFGroupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFGROUPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DELOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableDataExport_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDataImport_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDEAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDEDataSet_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnaTempData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LNPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDESERVICEAPINAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEServiceAPI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        Object object = pSDEServiceAPI.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDESERVICEAPI_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEServiceAPI);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEServiceAPI pSDEServiceAPI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESERVICEAPI");
        if (!bl) {
            pSDEServiceAPI.setCreateDate(null);
            pSDEServiceAPI.setCreateMan(null);
            pSDEServiceAPI.setPSDEServiceAPIId(null);
            pSDEServiceAPI.setUpdateDate(null);
            pSDEServiceAPI.setUpdateMan(null);
            super.exportCurXmlModel(pSDEServiceAPI, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEServiceAPI pSDEServiceAPI, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEServiceAPI, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSERVICEAPI#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESERVICEAPI_PSSYSSERVICEAPI_PSSYSSERVICEAPIID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSERVICEAPINAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPI", (boolean)true) == 0) {
            iEntity.set("PSSYSSERVICEAPIID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSERVICEAPIID"};
    }

    @Override
    public String getModelV2Tag(PSDEServiceAPI pSDEServiceAPI) {
        if (!StringHelper.isNullOrEmpty((String)pSDEServiceAPI.getPSDEServiceAPIName())) {
            return pSDEServiceAPI.getPSDEServiceAPIName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEServiceAPI.getCodeName())) {
            return pSDEServiceAPI.getCodeName();
        }
        return super.getModelV2Tag(pSDEServiceAPI);
    }

    @Override
    public boolean setModelV2Tag(PSDEServiceAPI pSDEServiceAPI, String string) {
        pSDEServiceAPI.setPSDEServiceAPIName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDESERVICEAPINAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSSERVICEAPIID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEServiceAPI pSDEServiceAPI, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEServiceAPI.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEServiceAPI, true);
        pSDEServiceAPI.set("PSDESERVICEAPINAME", string);
        if (this.select(pSDEServiceAPI, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEServiceAPI, true);
        return super.getModelV2Entity(pSDEServiceAPI, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEServiceAPI pSDEServiceAPI, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEServiceAPI, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        if (StringHelper.compare((String)"DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEServiceAPI pSDEServiceAPI, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)pSDEServiceAPI.getPSDEServiceAPIId()))).exists()) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysTestCase();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysTestCase)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSTESTCASE", (Object)((PSSysTestCase)entityBase).getPSSysTestCaseId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDESADETAIL", (Object)pSDEServiceAPI.getPSDEServiceAPIId()))).exists()) {
            pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDESADetail();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDESADetailServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDESADetail)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDESADETAIL", (Object)((PSDESADetail)entityBase).getPSDESADetailId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESERVICEAPI#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDESAVR", (Object)pSDEServiceAPI.getPSDEServiceAPIId()))).exists()) {
            pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSDESAVR();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDESAVRServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDESAVR)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDESAVR", (Object)((PSDESAVR)entityBase).getPSDESAVRId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSDEServiceAPI, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEServiceAPI pSDEServiceAPI, ObjectNode objectNode, String string, boolean bl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID")) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)pSDEServiceAPI.getPSDEServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDESERVICEAPI#%1$s", (Object)pSDEServiceAPI.getPSDEServiceAPIId());
                for (PSSysTestCase child : ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).selectByPSDEServiceAPI(pSDEServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssystestcasename")) {
                            string = objectNode.get("pssystestcasename").asText();
                        }
                        if (objectNode2.has("pssystestcasename")) {
                            string2 = objectNode2.get("pssystestcasename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSSysTestCase child = new PSSysTestCase();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID")) {
            pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDESADETAIL", (Object)pSDEServiceAPI.getPSDEServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDESERVICEAPI#%1$s", (Object)pSDEServiceAPI.getPSDEServiceAPIId());
                for (PSDESADetail child : ((PSDESADetailServiceBase)pSCoreSysServiceBase).selectByPSDEServiceAPI(pSDEServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSDESADetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdesadetailname")) {
                            string = objectNode.get("psdesadetailname").asText();
                        }
                        if (objectNode2.has("psdesadetailname")) {
                            string2 = objectNode2.get("psdesadetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDESADetail child = new PSDESADetail();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID")) {
            pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESERVICEAPI#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDESAVR", (Object)pSDEServiceAPI.getPSDEServiceAPIId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDESERVICEAPI#%1$s", (Object)pSDEServiceAPI.getPSDEServiceAPIId());
                for (PSDESAVR child : ((PSDESAVRServiceBase)pSCoreSysServiceBase).selectByPSDEServiceAPI(pSDEServiceAPI)) {
                    if (StringHelper.compare(scope, ((PSDESAVRServiceBase)pSCoreSysServiceBase).getModelV2ResScope(child), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdesavrname")) {
                            string = objectNode.get("psdesavrname").asText();
                        }
                        if (objectNode2.has("psdesavrname")) {
                            string2 = objectNode2.get("psdesavrname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDESAVR child = new PSDESAVR();
                    PSModelV2Helper.fromJSONObject(child, childNode, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(child, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEServiceAPI, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        super.onEmptyModelV2(pSDEServiceAPI);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEServiceAPI pSDEServiceAPI, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysTestCase();
        entityBase.set("PSDESERVICEAPIID", pSDEServiceAPI.getPSDEServiceAPIId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDESADetail();
        entityBase.set("PSDESERVICEAPIID", pSDEServiceAPI.getPSDEServiceAPIId());
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDESAVR();
        entityBase.set("PSDESERVICEAPIID", pSDEServiceAPI.getPSDEServiceAPIId());
        pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEServiceAPI, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEServiceAPI pSDEServiceAPI, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSDEServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode childNode = (ObjectNode)arrayNode.get(n2);
                    PSSysTestCase child = new PSSysTestCase();
                    child.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                    child.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File directory = new File(string4);
                if (directory.exists()) {
                    for (File childDirectory : directory.listFiles()) {
                        if (!childDirectory.isDirectory()) continue;
                        PSSysTestCase child = new PSSysTestCase();
                        child.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                        child.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode childNode = (ObjectNode)arrayNode.get(n2);
                    PSDESADetail child = new PSDESADetail();
                    child.setPSDEId(pSDEServiceAPI.getPSDEId());
                    child.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                    child.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                    child.setPSSysServiceAPIId(pSDEServiceAPI.getPSSysServiceAPIId());
                    pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File directory = new File(string5);
                if (directory.exists()) {
                    for (File childDirectory : directory.listFiles()) {
                        if (!childDirectory.isDirectory()) continue;
                        PSDESADetail child = new PSDESADetail();
                        child.setPSDEId(pSDEServiceAPI.getPSDEId());
                        child.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                        child.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                        child.setPSSysServiceAPIId(pSDEServiceAPI.getPSSysServiceAPIId());
                        pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEServiceAPIServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode childNode = (ObjectNode)arrayNode.get(i);
                    PSDESAVR child = new PSDESAVR();
                    child.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                    child.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                    pSCoreSysServiceBase.compileModelV2(child, childNode, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File directory = new File(string6);
                if (directory.exists()) {
                    for (File childDirectory : directory.listFiles()) {
                        if (!childDirectory.isDirectory()) continue;
                        PSDESAVR child = new PSDESAVR();
                        child.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                        child.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                        pSCoreSysServiceBase.compileModelV2(child, null, string, childDirectory.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEServiceAPI, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEServiceAPI pSDEServiceAPI, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDESADetails(pSDEServiceAPI, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDESAVRs(pSDEServiceAPI, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEServiceAPI, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDESADetails(PSDEServiceAPI pSDEServiceAPI, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDESADETAIL", true), (boolean)false) == 0) {
            PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            PSDESADetail pSDESADetail = new PSDESADetail();
            pSDESADetail.setPSDESADetailId(pSMOSFile.getPSModelId());
            if (!pSDESADetailService.get(pSDESADetail, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDESADetail.getPSDEServiceAPIId(), (String)pSDEServiceAPI.getPSDEServiceAPIId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDESADetailService.exportModelV2(pSDESADetail);
            pSDESADetail.reset();
            if (!pSDESADetailService.setModelV2ResScope(pSDESADetail, "PSDESERVICEAPI", pSDEServiceAPI.getPSDEServiceAPIId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDESADetailService.importModelV2(pSDESADetail, objectNode);
            SessionFactoryManager.commit();
            return pSDESADetailService.getFile(pSDESADetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACTION", true), (boolean)false) == 0) {
            PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = new PSDEAction();
            pSDEAction.setPSDEActionId(pSMOSFile.getPSModelId());
            if (!pSDEActionService.get(pSDEAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            PSDESADetail pSDESADetail = new PSDESADetail();
            pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDESADetail.setPSDEActionId(pSDEAction.getPSDEActionId());
            this.fillPasteEntity(pSDESADetail, "PASTETAG|DETAILTYPE:DEACTION");
            pSDESADetailService.create(pSDESADetail);
            if (StringHelper.compare((String)pSDEAction.getPSDEId(), (String)pSDESADetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDESADetailService.getFile(pSDESADetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDATAQUERY", true), (boolean)false) == 0) {
            PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
            pSDEDataQuery.setPSDEDataQueryId(pSMOSFile.getPSModelId());
            if (!pSDEDataQueryService.get(pSDEDataQuery, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            PSDESADetail pSDESADetail = new PSDESADetail();
            pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDESADetail.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
            this.fillPasteEntity(pSDESADetail, "PASTETAG|DETAILTYPE:DEDATAQUERY");
            pSDESADetailService.create(pSDESADetail);
            if (StringHelper.compare((String)pSDEDataQuery.getPSDEId(), (String)pSDESADetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDESADetailService.getFile(pSDESADetail);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDATASET", true), (boolean)false) == 0) {
            PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = new PSDEDataSet();
            pSDEDataSet.setPSDEDataSetId(pSMOSFile.getPSModelId());
            if (!pSDEDataSetService.get(pSDEDataSet, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            PSDESADetail pSDESADetail = new PSDESADetail();
            pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDESADetail.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
            this.fillPasteEntity(pSDESADetail, "PASTETAG|DETAILTYPE:FETCH");
            pSDESADetailService.create(pSDESADetail);
            if (StringHelper.compare((String)pSDEDataSet.getPSDEId(), (String)pSDESADetail.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDESADetailService.getFile(pSDESADetail);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDESAVRs(PSDEServiceAPI pSDEServiceAPI, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDESAVR", true), (boolean)false) == 0) {
            PSDESAVRService pSDESAVRService = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
            PSDESAVR pSDESAVR = new PSDESAVR();
            pSDESAVR.setPSDESAVRId(pSMOSFile.getPSModelId());
            if (!pSDESAVRService.get(pSDESAVR, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDESAVR.getPSDEServiceAPIId(), (String)pSDEServiceAPI.getPSDEServiceAPIId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDESAVRService.exportModelV2(pSDESAVR);
            pSDESAVR.reset();
            if (!pSDESAVRService.setModelV2ResScope(pSDESAVR, "PSDESERVICEAPI", pSDEServiceAPI.getPSDEServiceAPIId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDESAVRService.importModelV2(pSDESAVR, objectNode);
            SessionFactoryManager.commit();
            return pSDESAVRService.getFile(pSDESAVR);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEServiceAPI pSDEServiceAPI, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDESADetails(pSDEServiceAPI, list);
        this.onFillPasteHelps_PSDESAVRs(pSDEServiceAPI, list);
        super.onFillPasteHelps(pSDEServiceAPI, list);
    }

    protected void onFillPasteHelps_PSDESADetails(PSDEServiceAPI pSDEServiceAPI, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESADETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3]\u7684[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESADETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID");
        pSHelpSection.setUserTag("DER1N_PSDESADETAIL_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u884c\u4e3a]\u6784\u5efa[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESADETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID");
        pSHelpSection.setUserTag("DER1N_PSDESADETAIL_PSDEDATAQUERY_PSDEDQID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u6570\u636e\u67e5\u8be2]\u6784\u5efa[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESADETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID");
        pSHelpSection.setUserTag("DER1N_PSDESADETAIL_PSDEDATASET_PSDEDSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u6570\u636e\u96c6\u5408]\u6784\u5efa[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDESAVRs(PSDEServiceAPI pSDEServiceAPI, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESAVR");
        pSHelpSection.setSectionParam2("DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3]\u7684[\u5b9e\u4f53\u63a5\u53e3\u503c\u89c4\u5219]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u65b9\u6cd5>", "DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u65b9\u6cd5>");
            } else if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdesadetails");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID|PSDESERVICEAPIID");
            pSMOSFile2.setFileTag3("PSDESADETAIL");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u4ece\u5173\u7cfb>", "DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID", "CPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u4ece\u5173\u7cfb>");
            } else if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("minorpsdesarss");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID|CPSDESERVICEAPIID");
            pSMOSFile2.setFileTag3("PSDESARS");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID", "CPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID", "CPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u503c\u89c4\u5219>", "DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u503c\u89c4\u5219>");
            } else if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdesavrs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID|PSDESERVICEAPIID");
            pSMOSFile2.setFileTag3("PSDESAVR");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u4e3b\u5173\u7cfb>", "DER1N_PSDESARS_PSDESERVICEAPI_PPSDESERVICEAPIID", "PPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u4e3b\u5173\u7cfb>");
            } else if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("majorpsdesarss");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDESARS_PSDESERVICEAPI_PPSDESERVICEAPIID|PPSDESERVICEAPIID");
            pSMOSFile2.setFileTag3("PSDESARS");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDESARS_PSDESERVICEAPI_PPSDESERVICEAPIID", "PPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESARS_PSDESERVICEAPI_PPSDESERVICEAPIID", "PPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSDEServiceAPIServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u6d4b\u8bd5\u7528\u4f8b>", "DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6d4b\u8bd5\u7528\u4f8b>");
            } else if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystestcases");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID|PSDESERVICEAPIID");
            pSMOSFile2.setFileTag3("PSSYSTESTCASE");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<EntityBase> arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSDEServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u65b9\u6cd5>", (boolean)false) == 0 || PSDEServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDESADetails", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u4ece\u5173\u7cfb>", (boolean)false) == 0 || PSDEServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"MinorPSDESARSs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID", "CPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u503c\u89c4\u5219>", (boolean)false) == 0 || PSDEServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDESAVRs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u4e3b\u5173\u7cfb>", (boolean)false) == 0 || PSDEServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"MajorPSDESARSs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDESARS_PSDESERVICEAPI_PPSDESERVICEAPIID", "PPSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEServiceAPIServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u6d4b\u8bd5\u7528\u4f8b>", (boolean)false) == 0 || PSDEServiceAPIServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"pssystestcases", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", "PSDESERVICEAPIID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSDESADETAIL_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)false) == 0) {
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u65b9\u6cd5>";
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                return "psdesadetails";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDESARS_PSDESERVICEAPI_CPSDESERVICEAPIID", (boolean)false) == 0) {
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u4ece\u5173\u7cfb>";
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                return "minorpsdesarss";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDESAVR_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)false) == 0) {
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u503c\u89c4\u5219>";
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                return "psdesavrs";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDESARS_PSDESERVICEAPI_PPSDESERVICEAPIID", (boolean)false) == 0) {
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                return "<\u4e3b\u5173\u7cfb>";
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                return "majorpsdesarss";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)false) == 0) {
            if (PSDEServiceAPIServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u6d4b\u8bd5\u7528\u4f8b>";
            }
            if (PSDEServiceAPIServiceBase.getMOSVer() == 2) {
                return "pssystestcases";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}
