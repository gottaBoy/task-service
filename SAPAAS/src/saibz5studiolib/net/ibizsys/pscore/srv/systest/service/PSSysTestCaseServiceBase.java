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
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.systest.service;

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
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValueBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.dao.PSSysTestCaseDAO;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTestCaseDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCAssert;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCAssertBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInput;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInputBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestDataBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModule;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModuleBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrjBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertService;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputService;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTestCaseServiceBase
extends PSCoreSysServiceBase<PSSysTestCase> {
    private static final Log log = LogFactory.getLog(PSSysTestCaseServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysTestCaseDEModel pSSysTestCaseDEModel;
    private PSSysTestCaseDAO pSSysTestCaseDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService";
    }

    public PSSysTestCaseDEModel getPSSysTestCaseDEModel() {
        if (this.pSSysTestCaseDEModel == null) {
            try {
                this.pSSysTestCaseDEModel = (PSSysTestCaseDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTestCaseDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestCaseDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTestCaseDEModel();
    }

    public PSSysTestCaseDAO getPSSysTestCaseDAO() {
        if (this.pSSysTestCaseDAO == null) {
            try {
                this.pSSysTestCaseDAO = (PSSysTestCaseDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.systest.dao.PSSysTestCaseDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestCaseDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTestCaseDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
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

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysTestCase pSSysTestCase, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSAPPVIEW_PSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppView);
            } else {
                iService.get((IEntity)pSAppView);
            }
            this.onFillParentInfo_PSAppView(pSSysTestCase, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysTestCase, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSSysTestCase, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysTestCase, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSSysTestCase, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDESADETAIL_PSDESADETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService", (SessionFactory)this.getSessionFactory());
            PSDESADetail pSDESADetail = (PSDESADetail)iService.getDEModel().createEntity();
            pSDESADetail.set("PSDESADETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESADetail);
            } else {
                iService.get((IEntity)pSDESADetail);
            }
            this.onFillParentInfo_PSDESADetail(pSSysTestCase, pSDESADetail);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEServiceAPI);
            } else {
                iService.get((IEntity)pSDEServiceAPI);
            }
            this.onFillParentInfo_PSDEServiceAPI(pSSysTestCase, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSSysTestCase, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSSYSSAMPLEVALUE_DEFPSSYSSAMPLEVALUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService", (SessionFactory)this.getSessionFactory());
            PSSysSampleValue pSSysSampleValue = (PSSysSampleValue)iService.getDEModel().createEntity();
            pSSysSampleValue.set("PSSYSSAMPLEVALUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSampleValue);
            } else {
                iService.get((IEntity)pSSysSampleValue);
            }
            this.onFillParentInfo_DEFPSSysSampleValue(pSSysTestCase, pSSysSampleValue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysTestCase, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysTestCase, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSSYSTESTDATA_PSSYSTESTDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory());
            PSSysTestData pSSysTestData = (PSSysTestData)iService.getDEModel().createEntity();
            pSSysTestData.set("PSSYSTESTDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTestData);
            } else {
                iService.get((IEntity)pSSysTestData);
            }
            this.onFillParentInfo_PSSysTestData(pSSysTestCase, pSSysTestData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService", (SessionFactory)this.getSessionFactory());
            PSSysTestModule pSSysTestModule = (PSSysTestModule)iService.getDEModel().createEntity();
            pSSysTestModule.set("PSSYSTESTMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTestModule);
            } else {
                iService.get((IEntity)pSSysTestModule);
            }
            this.onFillParentInfo_PSSysTestModule(pSSysTestCase, pSSysTestModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTCASE_PSSYSTESTPRJ_PSSYSTESTPRJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService", (SessionFactory)this.getSessionFactory());
            PSSysTestPrj pSSysTestPrj = (PSSysTestPrj)iService.getDEModel().createEntity();
            pSSysTestPrj.set("PSSYSTESTPRJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTestPrj);
            } else {
                iService.get((IEntity)pSSysTestPrj);
            }
            this.onFillParentInfo_PSSysTestPrj(pSSysTestCase, pSSysTestPrj);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysTestCase, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppView(PSSysTestCase pSSysTestCase, PSAppView pSAppView) throws Exception {
        pSSysTestCase.setPSAppViewId(pSAppView.getPSAppViewId());
        pSSysTestCase.setPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSDE(PSSysTestCase pSSysTestCase, PSDataEntity pSDataEntity) throws Exception {
        pSSysTestCase.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysTestCase.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEAction(PSSysTestCase pSSysTestCase, PSDEAction pSDEAction) throws Exception {
        pSSysTestCase.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSSysTestCase.setPSDEActionName(pSDEAction.getPSDEActionName());
        if (pSDEAction.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSSysTestCase, pSDEAction.getPSDE());
        }
    }

    protected void onFillParentInfo_PSDEF(PSSysTestCase pSSysTestCase, PSDEField pSDEField) throws Exception {
        pSSysTestCase.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysTestCase.setPSDEFName(pSDEField.getPSDEFieldName());
        if (pSDEField.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSSysTestCase, pSDEField.getPSDE());
        }
    }

    protected void onFillParentInfo_PSDELogic(PSSysTestCase pSSysTestCase, PSDELogic pSDELogic) throws Exception {
        pSSysTestCase.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysTestCase.setPSDELogicName(pSDELogic.getPSDELogicName());
        if (pSDELogic.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSSysTestCase, pSDELogic.getPSDE());
        }
    }

    protected void onFillParentInfo_PSDESADetail(PSSysTestCase pSSysTestCase, PSDESADetail pSDESADetail) throws Exception {
        pSSysTestCase.setPSDESADetailId(pSDESADetail.getPSDESADetailId());
        pSSysTestCase.setPSDESADetailName(pSDESADetail.getPSDESADetailName());
    }

    protected void onFillParentInfo_PSDEServiceAPI(PSSysTestCase pSSysTestCase, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSSysTestCase.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSSysTestCase.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSSysTestCase pSSysTestCase, PSSysReqItem pSSysReqItem) throws Exception {
        pSSysTestCase.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSSysTestCase.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_DEFPSSysSampleValue(PSSysTestCase pSSysTestCase, PSSysSampleValue pSSysSampleValue) throws Exception {
        pSSysTestCase.setDEFPSSysSampleValueId(pSSysSampleValue.getPSSysSampleValueId());
        pSSysTestCase.setDEFPSSysSampleValueName(pSSysSampleValue.getPSSysSampleValueName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysTestCase pSSysTestCase, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysTestCase.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysTestCase.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysTestCase pSSysTestCase, PSSystem pSSystem) throws Exception {
        pSSysTestCase.setPSSystemId(pSSystem.getPSSystemId());
        pSSysTestCase.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysTestData(PSSysTestCase pSSysTestCase, PSSysTestData pSSysTestData) throws Exception {
        pSSysTestCase.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
        pSSysTestCase.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
    }

    protected void onFillParentInfo_PSSysTestModule(PSSysTestCase pSSysTestCase, PSSysTestModule pSSysTestModule) throws Exception {
        pSSysTestCase.setPSSysTestModuleId(pSSysTestModule.getPSSysTestModuleId());
        pSSysTestCase.setPSSysTestModuleName(pSSysTestModule.getPSSysTestModuleName());
        if (pSSysTestModule.getPSSysTestPrj() != null) {
            this.onFillParentInfo_PSSysTestPrj(pSSysTestCase, pSSysTestModule.getPSSysTestPrj());
        }
    }

    protected void onFillParentInfo_PSSysTestPrj(PSSysTestCase pSSysTestCase, PSSysTestPrj pSSysTestPrj) throws Exception {
        pSSysTestCase.setPSSysAppId(pSSysTestPrj.getPSSysAppId());
        pSSysTestCase.setPSSysServiceAPIId(pSSysTestPrj.getPSSysServiceAPIId());
        pSSysTestCase.setPSSysTestPrjId(pSSysTestPrj.getPSSysTestPrjId());
        pSSysTestCase.setPSSysTestPrjName(pSSysTestPrj.getPSSysTestPrjName());
    }

    protected void onFillEntityFullInfo(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        if (bl) {
            if (pSSysTestCase.getCodeName() == null) {
                pSSysTestCase.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "TestCase", 25));
            }
            if (pSSysTestCase.getUserFlag() == null) {
                pSSysTestCase.setUserFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSysTestCase.getValidFlag() == null) {
                pSSysTestCase.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSAppView(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSDE(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSDEAction(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSDELogic(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSDESADetail(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSDEServiceAPI(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSSysTestCase, bl);
        this.onFillEntityFullInfo_DEFPSSysSampleValue(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSSysTestData(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSSysTestModule(pSSysTestCase, bl);
        this.onFillEntityFullInfo_PSSysTestPrj(pSSysTestCase, bl);
    }

    protected void onFillEntityFullInfo_PSAppView(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        if (pSSysTestCase.isPSDEIdDirty()) {
            if (pSSysTestCase.getPSDEId() != null) {
                if (pSSysTestCase.getPSDEId() == null || pSSysTestCase.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysTestCase.getPSDE();
                    pSSysTestCase.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysTestCase.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEAction(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        if (pSSysTestCase.isPSDEActionIdDirty()) {
            if (pSSysTestCase.getPSDEActionId() != null) {
                PSDEAction pSDEAction;
                if (pSSysTestCase.getPSDEActionId() == null || pSSysTestCase.getPSDEActionName() == null) {
                    pSDEAction = pSSysTestCase.getPSDEAction();
                    pSSysTestCase.setPSDEActionName(pSDEAction.getPSDEActionName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDEAction = pSSysTestCase.getPSDEAction()).getPSDEId(), (Object)pSSysTestCase.getPSDEId()) != 0L) {
                    pSSysTestCase.setPSDEId(pSDEAction.getPSDEId());
                    this.onFillEntityFullInfo_PSDE(pSSysTestCase, bl);
                }
            } else {
                pSSysTestCase.setPSDEActionName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        if (pSSysTestCase.isPSDEFIdDirty()) {
            if (pSSysTestCase.getPSDEFId() != null) {
                PSDEField pSDEField;
                if (pSSysTestCase.getPSDEFId() == null || pSSysTestCase.getPSDEFName() == null) {
                    pSDEField = pSSysTestCase.getPSDEF();
                    pSSysTestCase.setPSDEFName(pSDEField.getPSDEFieldName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDEField = pSSysTestCase.getPSDEF()).getPSDEId(), (Object)pSSysTestCase.getPSDEId()) != 0L) {
                    pSSysTestCase.setPSDEId(pSDEField.getPSDEId());
                    this.onFillEntityFullInfo_PSDE(pSSysTestCase, bl);
                }
            } else {
                pSSysTestCase.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDESADetail(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEServiceAPI(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DEFPSSysSampleValue(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        if (pSSysTestCase.isPSSystemIdDirty()) {
            if (pSSysTestCase.getPSSystemId() != null) {
                if (pSSysTestCase.getPSSystemId() == null || pSSysTestCase.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysTestCase.getPSSystem();
                    pSSysTestCase.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysTestCase.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysTestData(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestModule(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestPrj(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysTestCase, bl);
    }

    public ArrayList<PSSysTestCase> selectByPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestCase> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestCase> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestCase> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestCase> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestCase> selectByPSDESADetail(PSDESADetailBase pSDESADetailBase) throws Exception {
        return this.selectByPSDESADetail(pSDESADetailBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDESADetail(PSDESADetailBase pSDESADetailBase, String string) throws Exception {
        return this.selectByPSDESADetail(pSDESADetailBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDESADetail(PSDESADetailBase pSDESADetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESADETAILID", (Object)pSDESADetailBase.getPSDESADetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESADetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESADetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestCase> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestCase> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestCase> selectByDEFPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase) throws Exception {
        return this.selectByDEFPSSysSampleValue(pSSysSampleValueBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByDEFPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string) throws Exception {
        return this.selectByDEFPSSysSampleValue(pSSysSampleValueBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByDEFPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEFPSSYSSAMPLEVALUEID", (Object)pSSysSampleValueBase.getPSSysSampleValueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDEFPSSysSampleValueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDEFPSSysSampleValueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestCase> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestCase> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestCase> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTDATAID", (Object)pSSysTestDataBase.getPSSysTestDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTestDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTestDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestModule(PSSysTestModuleBase pSSysTestModuleBase) throws Exception {
        return this.selectByPSSysTestModule(pSSysTestModuleBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestModule(PSSysTestModuleBase pSSysTestModuleBase, String string) throws Exception {
        return this.selectByPSSysTestModule(pSSysTestModuleBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestModule(PSSysTestModuleBase pSSysTestModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTMODULEID", (Object)pSSysTestModuleBase.getPSSysTestModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTestModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTestModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestPrj(PSSysTestPrjBase pSSysTestPrjBase) throws Exception {
        return this.selectByPSSysTestPrj(pSSysTestPrjBase, "", -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestPrj(PSSysTestPrjBase pSSysTestPrjBase, String string) throws Exception {
        return this.selectByPSSysTestPrj(pSSysTestPrjBase, string, -1);
    }

    public ArrayList<PSSysTestCase> selectByPSSysTestPrj(PSSysTestPrjBase pSSysTestPrjBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTPRJID", (Object)pSSysTestPrjBase.getPSSysTestPrjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTestPrjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTestPrjCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSAPPVIEW_PSAPPVIEWID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSAppView), arrayList.get(0)));
        }
    }

    public void resetPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSAppView(pSAppView);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSAppViewId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSAppView(pSAppView2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSAppView(pSAppView2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSAppView(pSAppView);
        this.onBeforeRemoveByPSAppView(pSAppView, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSDEId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSDEActionId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSDEFId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSDELogicId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDESADetail(pSDESADetail, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESADETAIL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDESADetail);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSDESADETAIL_PSDESADETAILID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSDESADetail), arrayList.get(0)));
        }
    }

    public void resetPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDESADetail(pSDESADetail);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSDESADetailId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        final PSDESADetail pSDESADetail2 = pSDESADetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSDESADetail(pSDESADetail2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSDESADetail(pSDESADetail2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSDESADetail(pSDESADetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
    }

    protected void internalRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDESADetail(pSDESADetail);
        this.onBeforeRemoveByPSDESADetail(pSDESADetail, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSDESADetail(pSDESADetail, arrayList);
    }

    protected void onAfterRemoveByPSDESADetail(PSDESADetail pSDESADetail) throws Exception {
    }

    protected void onBeforeRemoveByPSDESADetail(PSDESADetail pSDESADetail, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESADetail(PSDESADetail pSDESADetail, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSDEServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSDEServiceAPIId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSSysReqItemId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByDEFPSSysSampleValue(pSSysSampleValue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSAMPLEVALUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSampleValue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSSYSSAMPLEVALUE_DEFPSSYSSAMPLEVALUEID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSSysSampleValue), arrayList.get(0)));
        }
    }

    public void resetDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByDEFPSSysSampleValue(pSSysSampleValue);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setDEFPSSysSampleValueId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        final PSSysSampleValue pSSysSampleValue2 = pSSysSampleValue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByDEFPSSysSampleValue(pSSysSampleValue2);
                PSSysTestCaseServiceBase.this.internalRemoveByDEFPSSysSampleValue(pSSysSampleValue2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByDEFPSSysSampleValue(pSSysSampleValue2);
            }
        });
    }

    protected void onBeforeRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void internalRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByDEFPSSysSampleValue(pSSysSampleValue);
        this.onBeforeRemoveByDEFPSSysSampleValue(pSSysSampleValue, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByDEFPSSysSampleValue(pSSysSampleValue, arrayList);
    }

    protected void onAfterRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void onBeforeRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDEFPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSSysSFPluginId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSSystemId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestData(pSSysTestData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTestData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSSYSTESTDATA_PSSYSTESTDATAID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSSysTestData), arrayList.get(0)));
        }
    }

    public void resetPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestData(pSSysTestData);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSSysTestDataId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSSysTestData(pSSysTestData2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSSysTestData(pSSysTestData2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSSysTestData(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestData(pSSysTestData);
        this.onBeforeRemoveByPSSysTestData(pSSysTestData, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSSysTestData(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestModule(pSSysTestModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTestModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSSYSTESTMODULE_PSSYSTESTMODULEID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSSysTestModule), arrayList.get(0)));
        }
    }

    public void resetPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestModule(pSSysTestModule);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSSysTestModuleId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
        final PSSysTestModule pSSysTestModule2 = pSSysTestModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSSysTestModule(pSSysTestModule2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSSysTestModule(pSSysTestModule2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSSysTestModule(pSSysTestModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
    }

    protected void internalRemoveByPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestModule(pSSysTestModule);
        this.onBeforeRemoveByPSSysTestModule(pSSysTestModule, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSSysTestModule(pSSysTestModule, arrayList);
    }

    protected void onAfterRemoveByPSSysTestModule(PSSysTestModule pSSysTestModule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestModule(PSSysTestModule pSSysTestModule, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestModule(PSSysTestModule pSSysTestModule, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestPrj(pSSysTestPrj, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTPRJ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTestPrj);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTCASE_PSSYSTESTPRJ_PSSYSTESTPRJID", "", iDataEntityModel.getName(), "PSSYSTESTCASE", iDataEntityModel.getDataInfo((IEntity)pSSysTestPrj), arrayList.get(0)));
        }
    }

    public void resetPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestPrj(pSSysTestPrj);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            PSSysTestCase pSSysTestCase2 = (PSSysTestCase)this.getDEModel().createEntity();
            pSSysTestCase2.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
            pSSysTestCase2.setPSSysTestPrjId(null);
            this.update(pSSysTestCase2);
        }
    }

    public void removeByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        final PSSysTestPrj pSSysTestPrj2 = pSSysTestPrj;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestCaseServiceBase.this.onBeforeRemoveByPSSysTestPrj(pSSysTestPrj2);
                PSSysTestCaseServiceBase.this.internalRemoveByPSSysTestPrj(pSSysTestPrj2);
                PSSysTestCaseServiceBase.this.onAfterRemoveByPSSysTestPrj(pSSysTestPrj2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
    }

    protected void internalRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
        ArrayList<PSSysTestCase> arrayList = this.selectByPSSysTestPrj(pSSysTestPrj);
        this.onBeforeRemoveByPSSysTestPrj(pSSysTestPrj, arrayList);
        for (PSSysTestCase pSSysTestCase : arrayList) {
            this.remove((IEntity)pSSysTestCase);
        }
        this.onAfterRemoveByPSSysTestPrj(pSSysTestPrj, arrayList);
    }

    protected void onAfterRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestPrj(PSSysTestPrj pSSysTestPrj, ArrayList<PSSysTestCase> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTestCase pSSysTestCase) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestCase(pSSysTestCase);
        ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).removeByPSSysTestCase(pSSysTestCase);
        pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCInputServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestCase(pSSysTestCase);
        ((PSSysTCInputServiceBase)pSCoreSysServiceBase).removeByPSSysTestCase(pSSysTestCase);
        super.onBeforeRemove(pSSysTestCase);
    }

    protected void onBeforeRemoveTemp(PSSysTestCase pSSysTestCase) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).removeTempByPSSysTestCase(pSSysTestCase);
        pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCInputServiceBase)pSCoreSysServiceBase).removeTempByPSSysTestCase(pSSysTestCase);
        super.onBeforeRemoveTemp((IEntity)pSSysTestCase);
    }

    protected void getRelatedDataTempMajor(PSSysTestCase pSSysTestCase) throws Exception {
        this.getRelatedDataTempMajor_PSSysTCInput(pSSysTestCase);
        this.getRelatedDataTempMajor_PSSysTCAssert(pSSysTestCase);
        super.getRelatedDataTempMajor((IEntity)pSSysTestCase);
    }

    protected void getRelatedDataTempMajor_PSSysTCInput(PSSysTestCase pSSysTestCase) throws Exception {
        PSSysTCInputService pSSysTCInputService = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTCInput> arrayList = null;
        String string = pSSysTestCase.getPSSysTestCaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysTCInputService.selectByPSSysTestCase(pSSysTestCase) : pSSysTCInputService.selectTempByPSSysTestCase(pSSysTestCase);
        for (PSSysTCInput pSSysTCInput : arrayList) {
            pSSysTCInputService.getTempMajor(pSSysTCInput);
        }
    }

    protected void getRelatedDataTempMajor_PSSysTCAssert(PSSysTestCase pSSysTestCase) throws Exception {
        PSSysTCAssertService pSSysTCAssertService = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTCAssert> arrayList = null;
        String string = pSSysTestCase.getPSSysTestCaseId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysTCAssertService.selectByPSSysTestCase(pSSysTestCase) : pSSysTCAssertService.selectTempByPSSysTestCase(pSSysTestCase);
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            pSSysTCAssertService.getTempMajor(pSSysTCAssert);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysTestCase pSSysTestCase, PSSysTestCase pSSysTestCase2) throws Exception {
        ArrayList<PSSysTCAssert> arrayList = this.updateRelatedDataTempMajor_removePSSysTCAssert(pSSysTestCase, pSSysTestCase2);
        ArrayList<PSSysTCInput> arrayList2 = this.updateRelatedDataTempMajor_removePSSysTCInput(pSSysTestCase, pSSysTestCase2);
        this.updateRelatedDataTempMajor_updatePSSysTCInput(pSSysTestCase, pSSysTestCase2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSSysTCAssert(pSSysTestCase, pSSysTestCase2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysTestCase, (IEntity)pSSysTestCase2);
    }

    protected ArrayList<PSSysTCInput> updateRelatedDataTempMajor_removePSSysTCInput(PSSysTestCase pSSysTestCase, PSSysTestCase pSSysTestCase2) throws Exception {
        PSSysTCInputService pSSysTCInputService = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTCInput> arrayList = pSSysTCInputService.selectTempByPSSysTestCase(pSSysTestCase);
        ArrayList<PSSysTCInput> arrayList2 = pSSysTCInputService.selectByPSSysTestCase(pSSysTestCase2);
        HashMap<String, PSSysTCInput> hashMap = new HashMap<String, PSSysTCInput>();
        for (PSSysTCInput pSSysTCInput : arrayList2) {
            hashMap.put(pSSysTCInput.getPSSysTCInputId(), pSSysTCInput);
        }
        for (PSSysTCInput pSSysTCInput : arrayList) {
            Object object = pSSysTCInput.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysTCInput pSSysTCInput : hashMap.values()) {
            pSSysTCInputService.remove((IEntity)pSSysTCInput);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysTCInput(PSSysTestCase pSSysTestCase, PSSysTestCase pSSysTestCase2, ArrayList<PSSysTCInput> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysTCInputService pSSysTCInputService = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysTCInput pSSysTCInput : arrayList) {
            pSSysTCInputService.updateTempMajor(pSSysTCInput);
        }
    }

    protected ArrayList<PSSysTCAssert> updateRelatedDataTempMajor_removePSSysTCAssert(PSSysTestCase pSSysTestCase, PSSysTestCase pSSysTestCase2) throws Exception {
        PSSysTCAssertService pSSysTCAssertService = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTCAssert> arrayList = pSSysTCAssertService.selectTempByPSSysTestCase(pSSysTestCase);
        ArrayList<PSSysTCAssert> arrayList2 = pSSysTCAssertService.selectByPSSysTestCase(pSSysTestCase2);
        HashMap<String, PSSysTCAssert> hashMap = new HashMap<String, PSSysTCAssert>();
        for (PSSysTCAssert pSSysTCAssert : arrayList2) {
            hashMap.put(pSSysTCAssert.getPSSysTCAssertId(), pSSysTCAssert);
        }
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            Object object = pSSysTCAssert.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysTCAssert pSSysTCAssert : hashMap.values()) {
            pSSysTCAssertService.remove((IEntity)pSSysTCAssert);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysTCAssert(PSSysTestCase pSSysTestCase, PSSysTestCase pSSysTestCase2, ArrayList<PSSysTCAssert> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysTCAssertService pSSysTCAssertService = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            pSSysTCAssertService.updateTempMajor(pSSysTCAssert);
        }
    }

    protected void replaceParentInfo(PSSysTestCase pSSysTestCase, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysTestCase, cloneSession);
        if (pSSysTestCase.getPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSSysTestCase.getPSAppViewId())) != null) {
            this.onFillParentInfo_PSAppView(pSSysTestCase, (PSAppView)iEntity);
        }
        if (pSSysTestCase.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysTestCase.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysTestCase, (PSDataEntity)iEntity);
        }
        if (pSSysTestCase.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysTestCase.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSSysTestCase, (PSDEAction)iEntity);
        }
        if (pSSysTestCase.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysTestCase.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysTestCase, (PSDEField)iEntity);
        }
        if (pSSysTestCase.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysTestCase.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSSysTestCase, (PSDELogic)iEntity);
        }
        if (pSSysTestCase.getPSDESADetailId() != null && (iEntity = cloneSession.getEntity("PSDESADETAIL", (Object)pSSysTestCase.getPSDESADetailId())) != null) {
            this.onFillParentInfo_PSDESADetail(pSSysTestCase, (PSDESADetail)iEntity);
        }
        if (pSSysTestCase.getPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSSysTestCase.getPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_PSDEServiceAPI(pSSysTestCase, (PSDEServiceAPI)iEntity);
        }
        if (pSSysTestCase.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSysTestCase.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSSysTestCase, (PSSysReqItem)iEntity);
        }
        if (pSSysTestCase.getDEFPSSysSampleValueId() != null && (iEntity = cloneSession.getEntity("PSSYSSAMPLEVALUE", (Object)pSSysTestCase.getDEFPSSysSampleValueId())) != null) {
            this.onFillParentInfo_DEFPSSysSampleValue(pSSysTestCase, (PSSysSampleValue)iEntity);
        }
        if (pSSysTestCase.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysTestCase.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysTestCase, (PSSysSFPlugin)iEntity);
        }
        if (pSSysTestCase.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysTestCase.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysTestCase, (PSSystem)iEntity);
        }
        if (pSSysTestCase.getPSSysTestDataId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTDATA", (Object)pSSysTestCase.getPSSysTestDataId())) != null) {
            this.onFillParentInfo_PSSysTestData(pSSysTestCase, (PSSysTestData)iEntity);
        }
        if (pSSysTestCase.getPSSysTestModuleId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTMODULE", (Object)pSSysTestCase.getPSSysTestModuleId())) != null) {
            this.onFillParentInfo_PSSysTestModule(pSSysTestCase, (PSSysTestModule)iEntity);
        }
        if (pSSysTestCase.getPSSysTestPrjId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTPRJ", (Object)pSSysTestCase.getPSSysTestPrjId())) != null) {
            this.onFillParentInfo_PSSysTestPrj(pSSysTestCase, (PSSysTestPrj)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysTestCase, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionParams(bl, pSSysTestCase, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AssertResult(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AssertType(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFPSSysSampleValueId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFValue(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExceptionData(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExceptionData2(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExceptionName(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InputValues(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionName(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESADetailId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestCaseId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestCaseName(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestModuleId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestPrjId(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RollbackTran(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetType(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCaseLevel(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCaseSN(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData3(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData4(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserFlag(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysTestCase, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysTestCase, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionParams(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isActionParamsDirty() : !pSSysTestCase.isActionParamsDirty()) {
            return null;
        }
        String string = pSSysTestCase.getActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionParams_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AssertResult(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isAssertResultDirty() : !pSSysTestCase.isAssertResultDirty()) {
            return null;
        }
        String string = pSSysTestCase.getAssertResult();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertResult_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTRESULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AssertType(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isAssertTypeDirty() : !pSSysTestCase.isAssertTypeDirty()) {
            return null;
        }
        String string = pSSysTestCase.getAssertType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AssertType_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASSERTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isCodeNameDirty() : !pSSysTestCase.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysTestCase.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysTestCase, bl2, bl3);
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
                string3 = "PSDEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTESTPRJID";
                String string4 = this.checkFieldDupRule(this.getPSSysTestCaseDEModel(), "CODENAME", string3, pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isContentDirty() : !pSSysTestCase.isContentDirty()) {
            return null;
        }
        String string = pSSysTestCase.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFPSSysSampleValueId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isDEFPSSysSampleValueIdDirty() : !pSSysTestCase.isDEFPSSysSampleValueIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getDEFPSSysSampleValueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFPSSysSampleValueId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFPSSYSSAMPLEVALUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFValue(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isDEFValueDirty() : !pSSysTestCase.isDEFValueDirty()) {
            return null;
        }
        String string = pSSysTestCase.getDEFValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFValue_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExceptionData(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isExceptionDataDirty() : !pSSysTestCase.isExceptionDataDirty()) {
            return null;
        }
        String string = pSSysTestCase.getExceptionData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExceptionData_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCEPTIONDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExceptionData2(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isExceptionData2Dirty() : !pSSysTestCase.isExceptionData2Dirty()) {
            return null;
        }
        String string = pSSysTestCase.getExceptionData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExceptionData2_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCEPTIONDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExceptionName(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isExceptionNameDirty() : !pSSysTestCase.isExceptionNameDirty()) {
            return null;
        }
        String string = pSSysTestCase.getExceptionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExceptionName_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCEPTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InputValues(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isInputValuesDirty() : !pSSysTestCase.isInputValuesDirty()) {
            return null;
        }
        String string = pSSysTestCase.getInputValues();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InputValues_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INPUTVALUES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isLockFlagDirty() : !pSSysTestCase.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysTestCase.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isMemoDirty() : !pSSysTestCase.isMemoDirty()) {
            return null;
        }
        String string = pSSysTestCase.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isOrderValueDirty() : !pSSysTestCase.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysTestCase.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSAppViewIdDirty() : !pSSysTestCase.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDEActionIdDirty() : !pSSysTestCase.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionName(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDEActionNameDirty() : !pSSysTestCase.isPSDEActionNameDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDEActionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionName_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDEFIdDirty() : !pSSysTestCase.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDEFNameDirty() : !pSSysTestCase.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDEIdDirty() : !pSSysTestCase.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDELogicIdDirty() : !pSSysTestCase.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDENameDirty() : !pSSysTestCase.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDESADetailId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDESADetailIdDirty() : !pSSysTestCase.isPSDESADetailIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDESADetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESADetailId_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEServiceAPIId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSDEServiceAPIIdDirty() : !pSSysTestCase.isPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSDEServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIId_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSysReqItemIdDirty() : !pSSysTestCase.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSysSFPluginIdDirty() : !pSSysTestCase.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSystemIdDirty() : !pSSysTestCase.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSystemNameDirty() : !pSSysTestCase.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTestCaseId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSysTestCaseIdDirty() && !bl2 : !pSSysTestCase.isPSSysTestCaseIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSysTestCaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTCASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestCaseId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestCaseName(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSysTestCaseNameDirty() && !bl2 : !pSSysTestCase.isPSSysTestCaseNameDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSysTestCaseName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTCASENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestCaseName_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTCASENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestDataId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSysTestDataIdDirty() : !pSSysTestCase.isPSSysTestDataIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSysTestDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestModuleId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSysTestModuleIdDirty() : !pSSysTestCase.isPSSysTestModuleIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSysTestModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestModuleId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestPrjId(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isPSSysTestPrjIdDirty() : !pSSysTestCase.isPSSysTestPrjIdDirty()) {
            return null;
        }
        String string = pSSysTestCase.getPSSysTestPrjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestPrjId_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTPRJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RollbackTran(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isRollbackTranDirty() : !pSSysTestCase.isRollbackTranDirty()) {
            return null;
        }
        Integer n = pSSysTestCase.getRollbackTran();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RollbackTran_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROLLBACKTRAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetType(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isTargetTypeDirty() && !bl2 : !pSSysTestCase.isTargetTypeDirty()) {
            return null;
        }
        String string = pSSysTestCase.getTargetType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetType_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCaseLevel(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isTestCaseLevelDirty() : !pSSysTestCase.isTestCaseLevelDirty()) {
            return null;
        }
        String string = pSSysTestCase.getTestCaseLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestCaseLevel_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCASELEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCaseSN(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isTestCaseSNDirty() : !pSSysTestCase.isTestCaseSNDirty()) {
            return null;
        }
        String string = pSSysTestCase.getTestCaseSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestCaseSN_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCASESN");
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
                String string4 = this.checkFieldDupRule(this.getPSSysTestCaseDEModel(), "TESTCASESN", string3, pSSysTestCase, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("TESTCASESN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserCatDirty() : !pSSysTestCase.isUserCatDirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserDataDirty() : !pSSysTestCase.isUserDataDirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserData2Dirty() : !pSSysTestCase.isUserData2Dirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData3(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserData3Dirty() : !pSSysTestCase.isUserData3Dirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserData3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData3_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData4(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserData4Dirty() : !pSSysTestCase.isUserData4Dirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserData4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData4_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserFlag(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserFlagDirty() && !bl2 : !pSSysTestCase.isUserFlagDirty()) {
            return null;
        }
        Integer n = pSSysTestCase.getUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_UserFlag_Default((IEntity)pSSysTestCase, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserTagDirty() : !pSSysTestCase.isUserTagDirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserTag2Dirty() : !pSSysTestCase.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserTag3Dirty() : !pSSysTestCase.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isUserTag4Dirty() : !pSSysTestCase.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysTestCase.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysTestCase pSSysTestCase, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestCase.isValidFlagDirty() && !bl2 : !pSSysTestCase.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysTestCase.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysTestCase, bl2, bl3);
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

    protected void onSyncEntity(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysTestCase, bl);
    }

    protected void onSyncIndexEntities(PSSysTestCase pSSysTestCase, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysTestCase, bl);
    }

    public Object getDataContextValue(PSSysTestCase pSSysTestCase, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysTestCase, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysTestModule pSSysTestModule = pSSysTestCase.getPSSysTestModule();
        if (pSSysTestModule != null && pSSysTestModule.contains(string)) {
            return pSSysTestModule.get(string);
        }
        PSSysTestPrj pSSysTestPrj = pSSysTestCase.getPSSysTestPrj();
        if (pSSysTestPrj != null && pSSysTestPrj.contains(string)) {
            return pSSysTestPrj.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTestCase pSSysTestCase, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysTestCase, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSERTRESULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertResult_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASSERTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AssertType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFPSSYSSAMPLEVALUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFPSSysSampleValueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFPSSYSSAMPLEVALUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFPSSysSampleValueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCEPTIONDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExceptionData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCEPTIONDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExceptionData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCEPTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExceptionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INPUTVALUES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InputValues_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESADETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESADetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTESTCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTPRJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestPrjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTPRJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestPrjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROLLBACKTRAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RollbackTran_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCASELEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCaseLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCASESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCaseSN_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ActionParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPARAMS", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AssertResult_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTRESULT", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AssertType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASSERTTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_DEFPSSysSampleValueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFPSSYSSAMPLEVALUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFPSSysSampleValueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFPSSYSSAMPLEVALUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFVALUE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExceptionData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCEPTIONDATA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExceptionData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCEPTIONDATA2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExceptionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCEPTIONNAME", iEntity, bl2, null, false, 260, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[260]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[260]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InputValues_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INPUTVALUES", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
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

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysTestCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestPrjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTPRJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestPrjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTPRJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RollbackTran_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestCaseLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTCASELEVEL", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestCaseSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTCASESN", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false) && this.checkFieldRegExRule("TESTCASESN", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSysTestCase pSSysTestCase) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysTestCase)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTestCase pSSysTestCase) throws Exception {
        IService iService;
        Object object = pSSysTestCase.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSTESTCASE_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSSysTestCase.get("PSDEACTIONID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID", object);
        }
        if ((object = pSSysTestCase.get("PSDEFID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID", object);
        }
        super.onUpdateParent((IEntity)pSSysTestCase);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSSysTestCase pSSysTestCase, Object object) throws Exception {
        PSSysTestCase pSSysTestCase2 = new PSSysTestCase();
        pSSysTestCase2.set("PSSYSTESTCASEID", object);
        String string = DataObject.getStringValue((Object)pSSysTestCase.get("PSSYSTESTCASEID"));
        super.onCopyDetails((IEntity)pSSysTestCase, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysTestCase pSSysTestCase, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTESTCASE");
        if (!bl) {
            pSSysTestCase.setCreateDate(null);
            pSSysTestCase.setCreateMan(null);
            pSSysTestCase.setPSSysTestCaseId(null);
            pSSysTestCase.setPSSysTestModuleName(null);
            pSSysTestCase.setUpdateDate(null);
            pSSysTestCase.setUpdateMan(null);
            super.exportCurXmlModel(pSSysTestCase, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysTestCase pSSysTestCase, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSSysTestCase, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysTestCase pSSysTestCase, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSSysTestCase, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTestCase pSSysTestCase, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTestCase, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEACTION#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDELOGIC#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTESTPRJ#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPVIEW#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFIELD#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDESERVICEAPI#%1$s", (Object)string);
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSDEACTION_PSDEACTIONID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSDELOGIC_PSDELOGICID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSSYSTESTPRJ_PSSYSTESTPRJID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSAPPVIEW_PSAPPVIEWID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSDEFIELD_PSDEFID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSDESERVICEAPI_PSDESERVICEAPIID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTCASE_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTPRJNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPVIEWNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPIID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDESERVICEAPINAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTION", (boolean)true) == 0) {
            iEntity.set("PSDEACTIONID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGIC", (boolean)true) == 0) {
            iEntity.set("PSDELOGICID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTPRJ", (boolean)true) == 0) {
            iEntity.set("PSSYSTESTPRJID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEW", (boolean)true) == 0) {
            iEntity.set("PSAPPVIEWID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELD", (boolean)true) == 0) {
            iEntity.set("PSDEFID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPI", (boolean)true) == 0) {
            iEntity.set("PSDESERVICEAPIID", (Object)string2);
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
        return new String[]{"PSDEID", "PSDEACTIONID", "PSDELOGICID", "PSSYSTESTPRJID", "PSAPPVIEWID", "PSDEFID", "PSDESERVICEAPIID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysTestCase pSSysTestCase) {
        if (!StringHelper.isNullOrEmpty((String)pSSysTestCase.getCodeName())) {
            return pSSysTestCase.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysTestCase.getCodeName())) {
            return pSSysTestCase.getCodeName();
        }
        return super.getModelV2Tag(pSSysTestCase);
    }

    @Override
    public boolean setModelV2Tag(PSSysTestCase pSSysTestCase, String string) {
        pSSysTestCase.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("TESTCASESN", "");
        map.put("PSDEID", "");
        map.put("PSDEACTIONID", "");
        map.put("PSDELOGICID", "");
        map.put("PSSYSTESTPRJID", "");
        map.put("PSAPPVIEWID", "");
        map.put("PSDEFID", "");
        map.put("PSDESERVICEAPIID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysTestCase pSSysTestCase, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTestCase.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTestCase, true);
        pSSysTestCase.set("CODENAME", string);
        if (this.select(pSSysTestCase, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysTestCase, true);
        return super.getModelV2Entity(pSSysTestCase, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTestCase pSSysTestCase, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysTestCase, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSTCINPUT_PSSYSTESTCASE_PSSYSTESTCASEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSSYSTCASSERT_PSSYSTESTCASE_PSSYSTESTCASEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysTestCase pSSysTestCase, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysTestCase, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysTestCase pSSysTestCase, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSSysTCInput> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTCINPUT_PSSYSTESTCASE_PSSYSTESTCASEID")) {
            pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSTESTCASE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTCINPUT", (Object)pSSysTestCase.getPSSysTestCaseId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysTCInput)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysTCInput>();
                object3 = ((PSSysTCInputServiceBase)pSCoreSysServiceBase).selectByPSSysTestCase(pSSysTestCase);
                arrayNode = StringHelper.format((String)"PSSYSTESTCASE#%1$s", (Object)pSSysTestCase.getPSSysTestCaseId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysTCInput)object2.next();
                    object = ((PSSysTCInputServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTCInput)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("pssystcinputname")) {
                            string = objectNode.get("pssystcinputname").asText();
                        }
                        if (objectNode2.has("pssystcinputname")) {
                            string2 = objectNode2.get("pssystcinputname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysTCInput();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTCASSERT_PSSYSTESTCASE_PSSYSTESTCASEID")) {
            pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSTESTCASE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTCASSERT", (Object)pSSysTestCase.getPSSysTestCaseId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysTCInput)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).selectByPSSysTestCase(pSSysTestCase);
                arrayNode = StringHelper.format((String)"PSSYSTESTCASE#%1$s", (Object)pSSysTestCase.getPSSysTestCaseId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysTCAssert)object2.next();
                    object = ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTCInput)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("pssystcassertname")) {
                            string = objectNode.get("pssystcassertname").asText();
                        }
                        if (objectNode2.has("pssystcassertname")) {
                            string2 = objectNode2.get("pssystcassertname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysTCAssert();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysTestCase, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysTestCase pSSysTestCase) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSSysTCInputServiceBase)pSCoreSysServiceBase).selectByPSSysTestCase(pSSysTestCase);
        String string2 = StringHelper.format((String)"PSSYSTESTCASE#%1$s", (Object)pSSysTestCase.getPSSysTestCaseId());
        for (PSSysTCInput entityBase : arrayList) {
            string = ((PSSysTCInputServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSSysTestCase.getPSSysTestCaseId());
        ((PSSysTCInputServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysTCInputServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSTCINPUT WHERE PSSYSTESTCASEID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).selectByPSSysTestCase(pSSysTestCase);
        string2 = StringHelper.format((String)"PSSYSTESTCASE#%1$s", (Object)pSSysTestCase.getPSSysTestCaseId());
        for (PSSysTCAssert pSSysTCAssert : arrayList) {
            string = ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSSysTCAssert);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysTCAssert);
        }
        object = new SqlParamList();
        object.addString(pSSysTestCase.getPSSysTestCaseId());
        ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSTCASSERT WHERE PSSYSTESTCASEID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysTestCase);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysTestCase pSSysTestCase, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysTCInput();
        entityBase.set("PSSYSTESTCASEID", pSSysTestCase.getPSSysTestCaseId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysTCAssert();
        entityBase.set("PSSYSTESTCASEID", pSSysTestCase.getPSSysTestCaseId());
        pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysTestCase, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysTestCase pSSysTestCase, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysTCInput();
                ((PSSysTCInputBase)object).setPSDEFId(pSSysTestCase.getPSDEFId());
                ((PSSysTCInputBase)object).setPSDEId(pSSysTestCase.getPSDEId());
                ((PSSysTCInputBase)object).setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
                ((PSSysTCInputBase)object).setPSSysTestCaseName(pSSysTestCase.getPSSysTestCaseName());
                ((PSSysTCInputBase)object).setTargetType(pSSysTestCase.getTargetType());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysTCInput();
                    entityBase.setPSDEFId(pSSysTestCase.getPSDEFId());
                    entityBase.setPSDEId(pSSysTestCase.getPSDEId());
                    entityBase.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
                    entityBase.setPSSysTestCaseName(pSSysTestCase.getPSSysTestCaseName());
                    entityBase.setTargetType(pSSysTestCase.getTargetType());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysTCAssert();
                ((PSSysTCAssertBase)object).setPSDEId(pSSysTestCase.getPSDEId());
                ((PSSysTCAssertBase)object).setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
                ((PSSysTCAssertBase)object).setPSSysTestCaseName(pSSysTestCase.getPSSysTestCaseName());
                ((PSSysTCAssertBase)object).setTargetType(pSSysTestCase.getTargetType());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysTCAssert();
                    entityBase.setPSDEId(pSSysTestCase.getPSDEId());
                    entityBase.setPSSysTestCaseId(pSSysTestCase.getPSSysTestCaseId());
                    entityBase.setPSSysTestCaseName(pSSysTestCase.getPSSysTestCaseName());
                    entityBase.setTargetType(pSSysTestCase.getTargetType());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysTestCase, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysTestCase pSSysTestCase, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSSysTestCase, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSSysTestCase pSSysTestCase, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSSysTestCase, list);
    }

    @Override
    public Object getDataType(PSSysTestCase pSSysTestCase) throws Exception {
        return pSSysTestCase.getTargetType();
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysTestCase pSSysTestCase, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "TestCase");
    }
}

