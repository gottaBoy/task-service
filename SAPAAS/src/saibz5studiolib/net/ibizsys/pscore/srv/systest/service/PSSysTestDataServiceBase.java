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
package net.ibizsys.pscore.srv.systest.service;

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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.dao.PSSysTestDataDAO;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTestDataDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTDItem;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestDataBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertService;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputService;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemService;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestModuleServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTestDataServiceBase
extends PSCoreSysServiceBase<PSSysTestData> {
    private static final Log log = LogFactory.getLog(PSSysTestDataServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysTestDataDEModel pSSysTestDataDEModel;
    private PSSysTestDataDAO pSSysTestDataDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.systest.service.PSSysTestDataService";
    }

    public PSSysTestDataDEModel getPSSysTestDataDEModel() {
        if (this.pSSysTestDataDEModel == null) {
            try {
                this.pSSysTestDataDEModel = (PSSysTestDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTestDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestDataDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTestDataDEModel();
    }

    public PSSysTestDataDAO getPSSysTestDataDAO() {
        if (this.pSSysTestDataDAO == null) {
            try {
                this.pSSysTestDataDAO = (PSSysTestDataDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.systest.dao.PSSysTestDataDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestDataDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTestDataDAO();
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

    protected void onFillParentInfo(PSSysTestData pSSysTestData, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTDATA_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysTestData, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTDATA_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEMainState);
            } else {
                iService.get((IEntity)pSDEMainState);
            }
            this.onFillParentInfo_PSDEMainState(pSSysTestData, pSDEMainState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTDATA_PSDESAMPLEDATA_PSDESAMPLEDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService", (SessionFactory)this.getSessionFactory());
            PSDESampleData pSDESampleData = (PSDESampleData)iService.getDEModel().createEntity();
            pSDESampleData.set("PSDESAMPLEDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDESampleData);
            } else {
                iService.get((IEntity)pSDESampleData);
            }
            this.onFillParentInfo_PSDESampleData(pSSysTestData, pSDESampleData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTDATA_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysTestData, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTDATA_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSSysTestData, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTDATA_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysTestData, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTESTDATA_PSSYSTESTDATA_MAINPSSYSTDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory());
            PSSysTestData pSSysTestData2 = (PSSysTestData)iService.getDEModel().createEntity();
            pSSysTestData2.set("PSSYSTESTDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTestData2);
            } else {
                iService.get((IEntity)pSSysTestData2);
            }
            this.onFillParentInfo_MainPSSysTD(pSSysTestData, pSSysTestData2);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysTestData, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysTestData pSSysTestData, PSDataEntity pSDataEntity) throws Exception {
        pSSysTestData.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysTestData.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEMainState(PSSysTestData pSSysTestData, PSDEMainState pSDEMainState) throws Exception {
        pSSysTestData.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
        pSSysTestData.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillParentInfo_PSDESampleData(PSSysTestData pSSysTestData, PSDESampleData pSDESampleData) throws Exception {
        pSSysTestData.setPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
        pSSysTestData.setPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
    }

    protected void onFillParentInfo_PSModule(PSSysTestData pSSysTestData, PSModule pSModule) throws Exception {
        pSSysTestData.setPSModuleId(pSModule.getPSModuleId());
        pSSysTestData.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSSysTestData pSSysTestData, PSSysReqItem pSSysReqItem) throws Exception {
        pSSysTestData.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSSysTestData.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSystem(PSSysTestData pSSysTestData, PSSystem pSSystem) throws Exception {
        pSSysTestData.setPSSystemId(pSSystem.getPSSystemId());
        pSSysTestData.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_MainPSSysTD(PSSysTestData pSSysTestData, PSSysTestData pSSysTestData2) throws Exception {
        pSSysTestData.setMainPSSysTDId(pSSysTestData2.getPSSysTestDataId());
        pSSysTestData.setMainPSSysTDName(pSSysTestData2.getPSSysTestDataName());
    }

    protected void onFillEntityFullInfo(PSSysTestData pSSysTestData, boolean bl) throws Exception {
        if (bl) {
            if (pSSysTestData.getBaseMode() == null) {
                pSSysTestData.setBaseMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysTestData.getCodeName() == null) {
                pSSysTestData.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "TestData", 25));
            }
            if (pSSysTestData.getUserFlag() == null) {
                pSSysTestData.setUserFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSysTestData.getValidFlag() == null) {
                pSSysTestData.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysTestData, bl);
        this.onFillEntityFullInfo_PSDE(pSSysTestData, bl);
        this.onFillEntityFullInfo_PSDEMainState(pSSysTestData, bl);
        this.onFillEntityFullInfo_PSDESampleData(pSSysTestData, bl);
        this.onFillEntityFullInfo_PSModule(pSSysTestData, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSSysTestData, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysTestData, bl);
        this.onFillEntityFullInfo_MainPSSysTD(pSSysTestData, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysTestData pSSysTestData, boolean bl) throws Exception {
        if (pSSysTestData.isPSDEIdDirty()) {
            if (pSSysTestData.getPSDEId() != null) {
                if (pSSysTestData.getPSDEId() == null || pSSysTestData.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysTestData.getPSDE();
                    pSSysTestData.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysTestData.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEMainState(PSSysTestData pSSysTestData, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDESampleData(PSSysTestData pSSysTestData, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSSysTestData pSSysTestData, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSSysTestData pSSysTestData, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysTestData pSSysTestData, boolean bl) throws Exception {
        if (pSSysTestData.isPSSystemIdDirty()) {
            if (pSSysTestData.getPSSystemId() != null) {
                if (pSSysTestData.getPSSystemId() == null || pSSysTestData.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysTestData.getPSSystem();
                    pSSysTestData.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysTestData.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MainPSSysTD(PSSysTestData pSSysTestData, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTestData pSSysTestData, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysTestData, bl);
    }

    public ArrayList<PSSysTestData> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysTestData> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysTestData> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestData> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSSysTestData> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSSysTestData> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAINSTATEID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMainStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMainStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestData> selectByPSDESampleData(PSDESampleDataBase pSDESampleDataBase) throws Exception {
        return this.selectByPSDESampleData(pSDESampleDataBase, "", -1);
    }

    public ArrayList<PSSysTestData> selectByPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string) throws Exception {
        return this.selectByPSDESampleData(pSDESampleDataBase, string, -1);
    }

    public ArrayList<PSSysTestData> selectByPSDESampleData(PSDESampleDataBase pSDESampleDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESAMPLEDATAID", (Object)pSDESampleDataBase.getPSDESampleDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESampleDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESampleDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTestData> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysTestData> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysTestData> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestData> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSysTestData> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSysTestData> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestData> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysTestData> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysTestData> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTestData> selectByMainPSSysTD(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectByMainPSSysTD(pSSysTestDataBase, "", -1);
    }

    public ArrayList<PSSysTestData> selectByMainPSSysTD(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        return this.selectByMainPSSysTD(pSSysTestDataBase, string, -1);
    }

    public ArrayList<PSSysTestData> selectByMainPSSysTD(PSSysTestDataBase pSSysTestDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAINPSSYSTDID", (Object)pSSysTestDataBase.getPSSysTestDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMainPSSysTDCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMainPSSysTDCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysTestData pSSysTestData : arrayList) {
            PSSysTestData pSSysTestData2 = (PSSysTestData)this.getDEModel().createEntity();
            pSSysTestData2.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
            pSSysTestData2.setPSDEId(null);
            this.update(pSSysTestData2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestDataServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysTestDataServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysTestDataServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysTestData pSSysTestData : arrayList) {
            this.remove((IEntity)pSSysTestData);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDEMainState(pSDEMainState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEMAINSTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEMainState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTDATA_PSDEMAINSTATE_PSDEMAINSTATEID", "", iDataEntityModel.getName(), "PSSYSTESTDATA", iDataEntityModel.getDataInfo((IEntity)pSDEMainState), arrayList.get(0)));
        }
    }

    public void resetPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDEMainState(pSDEMainState);
        for (PSSysTestData pSSysTestData : arrayList) {
            PSSysTestData pSSysTestData2 = (PSSysTestData)this.getDEModel().createEntity();
            pSSysTestData2.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
            pSSysTestData2.setPSDEMainStateId(null);
            this.update(pSSysTestData2);
        }
    }

    public void removeByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestDataServiceBase.this.onBeforeRemoveByPSDEMainState(pSDEMainState2);
                PSSysTestDataServiceBase.this.internalRemoveByPSDEMainState(pSDEMainState2);
                PSSysTestDataServiceBase.this.onAfterRemoveByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveByPSDEMainState(pSDEMainState, arrayList);
        for (PSSysTestData pSSysTestData : arrayList) {
            this.remove((IEntity)pSSysTestData);
        }
        this.onAfterRemoveByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    public void testRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDESampleData(pSDESampleData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESAMPLEDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDESampleData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTDATA_PSDESAMPLEDATA_PSDESAMPLEDATAID", "", iDataEntityModel.getName(), "PSSYSTESTDATA", iDataEntityModel.getDataInfo((IEntity)pSDESampleData), arrayList.get(0)));
        }
    }

    public void resetPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDESampleData(pSDESampleData);
        for (PSSysTestData pSSysTestData : arrayList) {
            PSSysTestData pSSysTestData2 = (PSSysTestData)this.getDEModel().createEntity();
            pSSysTestData2.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
            pSSysTestData2.setPSDESampleDataId(null);
            this.update(pSSysTestData2);
        }
    }

    public void removeByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        final PSDESampleData pSDESampleData2 = pSDESampleData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestDataServiceBase.this.onBeforeRemoveByPSDESampleData(pSDESampleData2);
                PSSysTestDataServiceBase.this.internalRemoveByPSDESampleData(pSDESampleData2);
                PSSysTestDataServiceBase.this.onAfterRemoveByPSDESampleData(pSDESampleData2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void internalRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSDESampleData(pSDESampleData);
        this.onBeforeRemoveByPSDESampleData(pSDESampleData, arrayList);
        for (PSSysTestData pSSysTestData : arrayList) {
            this.remove((IEntity)pSSysTestData);
        }
        this.onAfterRemoveByPSDESampleData(pSDESampleData, arrayList);
    }

    protected void onAfterRemoveByPSDESampleData(PSDESampleData pSDESampleData) throws Exception {
    }

    protected void onBeforeRemoveByPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESampleData(PSDESampleData pSDESampleData, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTDATA_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSTESTDATA", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSModule(pSModule);
        for (PSSysTestData pSSysTestData : arrayList) {
            PSSysTestData pSSysTestData2 = (PSSysTestData)this.getDEModel().createEntity();
            pSSysTestData2.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
            pSSysTestData2.setPSModuleId(null);
            this.update(pSSysTestData2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestDataServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysTestDataServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysTestDataServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysTestData pSSysTestData : arrayList) {
            this.remove((IEntity)pSSysTestData);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTDATA_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSSYSTESTDATA", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSSysTestData pSSysTestData : arrayList) {
            PSSysTestData pSSysTestData2 = (PSSysTestData)this.getDEModel().createEntity();
            pSSysTestData2.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
            pSSysTestData2.setPSSysReqItemId(null);
            this.update(pSSysTestData2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestDataServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysTestDataServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysTestDataServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSSysTestData pSSysTestData : arrayList) {
            this.remove((IEntity)pSSysTestData);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysTestData pSSysTestData : arrayList) {
            PSSysTestData pSSysTestData2 = (PSSysTestData)this.getDEModel().createEntity();
            pSSysTestData2.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
            pSSysTestData2.setPSSystemId(null);
            this.update(pSSysTestData2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestDataServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysTestDataServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysTestDataServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysTestData pSSysTestData : arrayList) {
            this.remove((IEntity)pSSysTestData);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    public void testRemoveByMainPSSysTD(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByMainPSSysTD(pSSysTestData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTestData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTESTDATA_PSSYSTESTDATA_MAINPSSYSTDID", "", iDataEntityModel.getName(), "PSSYSTESTDATA", iDataEntityModel.getDataInfo((IEntity)pSSysTestData), arrayList.get(0)));
        }
    }

    public void resetMainPSSysTD(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByMainPSSysTD(pSSysTestData);
        for (PSSysTestData pSSysTestData2 : arrayList) {
            PSSysTestData pSSysTestData3 = (PSSysTestData)this.getDEModel().createEntity();
            pSSysTestData3.setPSSysTestDataId(pSSysTestData2.getPSSysTestDataId());
            pSSysTestData3.setMainPSSysTDId(null);
            this.update(pSSysTestData3);
        }
    }

    public void removeByMainPSSysTD(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTestDataServiceBase.this.onBeforeRemoveByMainPSSysTD(pSSysTestData2);
                PSSysTestDataServiceBase.this.internalRemoveByMainPSSysTD(pSSysTestData2);
                PSSysTestDataServiceBase.this.onAfterRemoveByMainPSSysTD(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveByMainPSSysTD(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveByMainPSSysTD(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTestData> arrayList = this.selectByMainPSSysTD(pSSysTestData);
        this.onBeforeRemoveByMainPSSysTD(pSSysTestData, arrayList);
        for (PSSysTestData pSSysTestData2 : arrayList) {
            this.remove((IEntity)pSSysTestData2);
        }
        this.onAfterRemoveByMainPSSysTD(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveByMainPSSysTD(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveByMainPSSysTD(PSSysTestData pSSysTestData, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMainPSSysTD(PSSysTestData pSSysTestData, ArrayList<PSSysTestData> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTestData pSSysTestData) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysTCAssertService)ServiceGlobal.getService(PSSysTCAssertService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCAssertServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestData(pSSysTestData);
        pSCoreSysServiceBase = (PSSysTCInputService)ServiceGlobal.getService(PSSysTCInputService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTCInputServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestData(pSSysTestData);
        pSCoreSysServiceBase = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTDItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestData(pSSysTestData);
        ((PSSysTDItemServiceBase)pSCoreSysServiceBase).removeByPSSysTestData(pSSysTestData);
        pSCoreSysServiceBase = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTDItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysTestData(pSSysTestData);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestData(pSSysTestData);
        pSCoreSysServiceBase = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestDataServiceBase)pSCoreSysServiceBase).testRemoveByMainPSSysTD(pSSysTestData);
        pSCoreSysServiceBase = (PSSysTestModuleService)ServiceGlobal.getService(PSSysTestModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTestData(pSSysTestData);
        super.onBeforeRemove(pSSysTestData);
    }

    protected void onBeforeRemoveTemp(PSSysTestData pSSysTestData) throws Exception {
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        pSSysTDItemService.removeTempByPSSysTestData(pSSysTestData);
        super.onBeforeRemoveTemp((IEntity)pSSysTestData);
    }

    protected void getRelatedDataTempMajor(PSSysTestData pSSysTestData) throws Exception {
        this.getRelatedDataTempMajor_PSSysTDItem(pSSysTestData);
        super.getRelatedDataTempMajor((IEntity)pSSysTestData);
    }

    protected void getRelatedDataTempMajor_PSSysTDItem(PSSysTestData pSSysTestData) throws Exception {
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTDItem> arrayList = null;
        String string = pSSysTestData.getPSSysTestDataId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysTDItemService.selectByPSSysTestData(pSSysTestData) : pSSysTDItemService.selectTempByPSSysTestData(pSSysTestData);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            pSSysTDItemService.getTempMajor(pSSysTDItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysTestData pSSysTestData, PSSysTestData pSSysTestData2) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.updateRelatedDataTempMajor_removePSSysTDItem(pSSysTestData, pSSysTestData2);
        this.updateRelatedDataTempMajor_updatePSSysTDItem(pSSysTestData, pSSysTestData2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysTestData, (IEntity)pSSysTestData2);
    }

    protected ArrayList<PSSysTDItem> updateRelatedDataTempMajor_removePSSysTDItem(PSSysTestData pSSysTestData, PSSysTestData pSSysTestData2) throws Exception {
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTDItem> arrayList = pSSysTDItemService.selectTempByPSSysTestData(pSSysTestData);
        ArrayList<PSSysTDItem> arrayList2 = pSSysTDItemService.selectByPSSysTestData(pSSysTestData2);
        HashMap<String, PSSysTDItem> hashMap = new HashMap<String, PSSysTDItem>();
        for (PSSysTDItem pSSysTDItem : arrayList2) {
            hashMap.put(pSSysTDItem.getPSSysTDItemId(), pSSysTDItem);
        }
        for (PSSysTDItem pSSysTDItem : arrayList) {
            Object object = pSSysTDItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysTDItem pSSysTDItem : hashMap.values()) {
            pSSysTDItemService.remove((IEntity)pSSysTDItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysTDItem(PSSysTestData pSSysTestData, PSSysTestData pSSysTestData2, ArrayList<PSSysTDItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysTDItem pSSysTDItem : arrayList) {
            pSSysTDItemService.updateTempMajor(pSSysTDItem);
        }
    }

    protected void replaceParentInfo(PSSysTestData pSSysTestData, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysTestData, cloneSession);
        if (pSSysTestData.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysTestData.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysTestData, (PSDataEntity)iEntity);
        }
        if (pSSysTestData.getPSDEMainStateId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSSysTestData.getPSDEMainStateId())) != null) {
            this.onFillParentInfo_PSDEMainState(pSSysTestData, (PSDEMainState)iEntity);
        }
        if (pSSysTestData.getPSDESampleDataId() != null && (iEntity = cloneSession.getEntity("PSDESAMPLEDATA", (Object)pSSysTestData.getPSDESampleDataId())) != null) {
            this.onFillParentInfo_PSDESampleData(pSSysTestData, (PSDESampleData)iEntity);
        }
        if (pSSysTestData.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysTestData.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysTestData, (PSModule)iEntity);
        }
        if (pSSysTestData.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSysTestData.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSSysTestData, (PSSysReqItem)iEntity);
        }
        if (pSSysTestData.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysTestData.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysTestData, (PSSystem)iEntity);
        }
        if (pSSysTestData.getMainPSSysTDId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTDATA", (Object)pSSysTestData.getMainPSSysTDId())) != null) {
            this.onFillParentInfo_MainPSSysTD(pSSysTestData, (PSSysTestData)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTestData pSSysTestData, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysTestData, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BaseMode(bl, pSSysTestData, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainPSSysTDId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESampleDataId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataId(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataName(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RandomCount(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestDataTag(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestDataTag2(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestDataType(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Usage(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserFlag(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysTestData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysTestData, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BaseMode(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isBaseModeDirty() : !pSSysTestData.isBaseModeDirty()) {
            return null;
        }
        Integer n = pSSysTestData.getBaseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BaseMode_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isCodeNameDirty() && !bl2 : !pSSysTestData.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysTestData.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysTestData, bl2, bl3);
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
                string3 = "PSDEID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysTestDataDEModel(), "CODENAME", string3, pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isCustomCodeDirty() : !pSSysTestData.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysTestData.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_Data(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isDataDirty() : !pSSysTestData.isDataDirty()) {
            return null;
        }
        String string = pSSysTestData.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isLockFlagDirty() : !pSSysTestData.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysTestData.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_MainPSSysTDId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isMainPSSysTDIdDirty() : !pSSysTestData.isMainPSSysTDIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getMainPSSysTDId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainPSSysTDId_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINPSSYSTDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isMemoDirty() : !pSSysTestData.isMemoDirty()) {
            return null;
        }
        String string = pSSysTestData.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isOrderValueDirty() : !pSSysTestData.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysTestData.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSDEIdDirty() && !bl2 : !pSSysTestData.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSDEMainStateIdDirty() : !pSSysTestData.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSDEMainStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSDENameDirty() && !bl2 : !pSSysTestData.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDESampleDataId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSDESampleDataIdDirty() : !pSSysTestData.isPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSDESampleDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESampleDataId_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSModuleIdDirty() : !pSSysTestData.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSSysReqItemIdDirty() : !pSSysTestData.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSSystemIdDirty() : !pSSysTestData.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSSystemNameDirty() : !pSSysTestData.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTestDataId(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSSysTestDataIdDirty() && !bl2 : !pSSysTestData.isPSSysTestDataIdDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSSysTestDataId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataId_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTestDataName(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isPSSysTestDataNameDirty() && !bl2 : !pSSysTestData.isPSSysTestDataNameDirty()) {
            return null;
        }
        String string = pSSysTestData.getPSSysTestDataName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataName_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTDATANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RandomCount(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isRandomCountDirty() : !pSSysTestData.isRandomCountDirty()) {
            return null;
        }
        Integer n = pSSysTestData.getRandomCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RandomCount_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RANDOMCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestDataTag(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isTestDataTagDirty() : !pSSysTestData.isTestDataTagDirty()) {
            return null;
        }
        String string = pSSysTestData.getTestDataTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestDataTag_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTDATATAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestDataTag2(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isTestDataTag2Dirty() : !pSSysTestData.isTestDataTag2Dirty()) {
            return null;
        }
        String string = pSSysTestData.getTestDataTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestDataTag2_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTDATATAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestDataType(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isTestDataTypeDirty() : !pSSysTestData.isTestDataTypeDirty()) {
            return null;
        }
        String string = pSSysTestData.getTestDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestDataType_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Usage(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isUsageDirty() : !pSSysTestData.isUsageDirty()) {
            return null;
        }
        String string = pSSysTestData.getUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Usage_Default((IEntity)pSSysTestData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isUserCatDirty() : !pSSysTestData.isUserCatDirty()) {
            return null;
        }
        String string = pSSysTestData.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserFlag(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isUserFlagDirty() && !bl2 : !pSSysTestData.isUserFlagDirty()) {
            return null;
        }
        Integer n = pSSysTestData.getUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_UserFlag_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isUserTagDirty() : !pSSysTestData.isUserTagDirty()) {
            return null;
        }
        String string = pSSysTestData.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isUserTag2Dirty() : !pSSysTestData.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysTestData.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isUserTag3Dirty() : !pSSysTestData.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysTestData.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isUserTag4Dirty() : !pSSysTestData.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysTestData.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysTestData pSSysTestData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTestData.isValidFlagDirty() && !bl2 : !pSSysTestData.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysTestData.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysTestData, bl2, bl3);
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

    protected void onSyncEntity(PSSysTestData pSSysTestData, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysTestData, bl);
    }

    protected void onSyncIndexEntities(PSSysTestData pSSysTestData, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysTestData, bl);
    }

    public Object getDataContextValue(PSSysTestData pSSysTestData, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysTestData, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTestData pSSysTestData, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysTestData, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BASEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSSYSTDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSSysTDId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSSYSTDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSSysTDName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RANDOMCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RandomCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTDATATAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestDataTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTDATATAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestDataTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Usage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BaseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_MainPSSysTDId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSSYSTDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MainPSSysTDName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSSYSTDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEMainStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RandomCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestDataTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTDATATAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestDataTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTDATATAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTDATATYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_Usage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USAGE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSSysTestData pSSysTestData) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysTestData)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTestData pSSysTestData) throws Exception {
        Object object = pSSysTestData.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSTESTDATA_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSSysTestData);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSSysTestData pSSysTestData, Object object) throws Exception {
        PSSysTestData pSSysTestData2 = new PSSysTestData();
        pSSysTestData2.set("PSSYSTESTDATAID", object);
        String string = DataObject.getStringValue((Object)pSSysTestData.get("PSSYSTESTDATAID"));
        super.onCopyDetails((IEntity)pSSysTestData, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysTestData pSSysTestData, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTESTDATA");
        if (!bl) {
            pSSysTestData.setCreateDate(null);
            pSSysTestData.setCreateMan(null);
            pSSysTestData.setPSSysTestDataId(null);
            pSSysTestData.setUpdateDate(null);
            pSSysTestData.setUpdateMan(null);
            super.exportCurXmlModel(pSSysTestData, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysTestData pSSysTestData, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysTDItem(pSSysTestData, xmlNode);
        super.onExportRelatedXmlModel(pSSysTestData, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysTDItem(PSSysTestData pSSysTestData, XmlNode xmlNode) throws Exception {
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTDItem> arrayList = null;
        String string = pSSysTestData.getPSSysTestDataId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysTDItemService.selectByPSSysTestData(pSSysTestData, "ORDER BY ORDERVALUE ASC") : pSSysTDItemService.selectTempByPSSysTestData(pSSysTestData, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSTDITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysTDItem pSSysTDItem : arrayList) {
                pSSysTDItem.set("ORDERVALUE", null);
                pSSysTDItemService.exportXmlModel(pSSysTDItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysTestData pSSysTestData, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSTDITEMS");
        this.importRelatedXmlModel_PSSysTDItem(pSSysTestData, xmlNode2);
        super.onImportRelatedXmlModel(pSSysTestData, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysTDItem(PSSysTestData pSSysTestData, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysTestData.getPSSysTestDataId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysTDItemService.removeByPSSysTestData(pSSysTestData);
        } else {
            pSSysTDItemService.removeTempByPSSysTestData(pSSysTestData);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysTDItem pSSysTDItem = new PSSysTDItem();
                pSSysTDItem.setOrderValue(n);
                n += 100;
                pSSysTDItemService.fillParentInfo((IEntity)pSSysTDItem, "DER1N", "DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", pSSysTestData.getPSSysTestDataId());
                pSSysTDItemService.importXmlModel(pSSysTDItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTestData pSSysTestData, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTestData, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTDATA_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTDATA_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTESTDATA_PSSYSTEM_PSSYSTEMID";
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
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
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
        return new String[]{"PSDEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysTestData pSSysTestData) {
        if (!StringHelper.isNullOrEmpty((String)pSSysTestData.getCodeName())) {
            return pSSysTestData.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysTestData.getCodeName())) {
            return pSSysTestData.getCodeName();
        }
        return super.getModelV2Tag(pSSysTestData);
    }

    @Override
    public boolean setModelV2Tag(PSSysTestData pSSysTestData, String string) {
        pSSysTestData.setCodeName(string);
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
        map.put("PSDEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysTestData pSSysTestData, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTestData.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTestData, true);
        pSSysTestData.set("CODENAME", string);
        if (this.select(pSSysTestData, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysTestData, true);
        return super.getModelV2Entity(pSSysTestData, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTestData pSSysTestData, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysTestData, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysTestData pSSysTestData, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysTestData, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysTestData pSSysTestData, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID")) {
            Object object;
            PSSysTDItem pSSysTDItem2;
            Object object2;
            Object object3;
            Object object4;
            PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysTDItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSTESTDATA#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTDITEM", (Object)pSSysTestData.getPSSysTestDataId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysTDItem2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysTDItem2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysTDItem>();
                object4 = pSSysTDItemService.selectByPSSysTestData(pSSysTestData);
                object3 = StringHelper.format((String)"PSSYSTESTDATA#%1$s", (Object)pSSysTestData.getPSSysTestDataId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysTDItem2 = object2.next();
                    object = pSSysTDItemService.getModelV2ResScope((IEntity)pSSysTDItem2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysTDItem)PSModelV2Helper.toJSONObject((IEntity)pSSysTDItem2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysTDItemService.getModelV2Name(false);
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
                        if (objectNode.has("pssystditemname")) {
                            string = objectNode.get("pssystditemname").asText();
                        }
                        if (objectNode2.has("pssystditemname")) {
                            string2 = objectNode2.get("pssystditemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysTDItem pSSysTDItem2 : arrayList) {
                    object = new PSSysTDItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysTDItem2, false);
                    object3.add((JsonNode)pSSysTDItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysTestData, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysTestData pSSysTestData) throws Exception {
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTDItem> arrayList = pSSysTDItemService.selectByPSSysTestData(pSSysTestData);
        String string = StringHelper.format((String)"PSSYSTESTDATA#%1$s", (Object)pSSysTestData.getPSSysTestDataId());
        for (PSSysTDItem pSSysTDItem : arrayList) {
            String string2 = pSSysTDItemService.getModelV2ResScope((IEntity)pSSysTDItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysTDItemService.emptyModelV2(pSSysTDItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysTestData.getPSSysTestDataId());
        pSSysTDItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysTDItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSTDITEM WHERE PSSYSTESTDATAID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysTestData);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysTDItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysTestData pSSysTestData, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysTDItem pSSysTDItem = new PSSysTDItem();
        pSSysTDItem.set("PSSYSTESTDATAID", pSSysTestData.getPSSysTestDataId());
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysTDItemService.getModelV2Entity(pSSysTDItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysTestData, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysTestData pSSysTestData, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysTDItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysTDItem pSSysTDItem = new PSSysTDItem();
                pSSysTDItem.setPSDEId(pSSysTestData.getPSDEId());
                pSSysTDItem.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
                pSSysTDItem.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
                pSSysTDItemService.compileModelV2(pSSysTDItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysTDItem pSSysTDItem = new PSSysTDItem();
                    pSSysTDItem.setPSDEId(pSSysTestData.getPSDEId());
                    pSSysTDItem.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
                    pSSysTDItem.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
                    pSSysTDItemService.compileModelV2(pSSysTDItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysTestData, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysTestData pSSysTestData, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysTDItems(pSSysTestData, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysTestData, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysTDItems(PSSysTestData pSSysTestData, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSTDITEM", true), (boolean)false) == 0) {
            PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysTDItem pSSysTDItem = new PSSysTDItem();
            pSSysTDItem.setPSSysTDItemId(pSMOSFile.getPSModelId());
            if (!pSSysTDItemService.get((IEntity)pSSysTDItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysTDItem.getPSSysTestDataId(), (String)pSSysTestData.getPSSysTestDataId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysTDItemService.exportModelV2(pSSysTDItem);
            pSSysTDItem.reset();
            if (!pSSysTDItemService.setModelV2ResScope((IEntity)pSSysTDItem, "PSSYSTESTDATA", pSSysTestData.getPSSysTestDataId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysTDItemService.importModelV2(pSSysTDItem, objectNode);
            SessionFactoryManager.commit();
            return pSSysTDItemService.getFile((IEntity)pSSysTDItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysTestData pSSysTestData, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysTDItems(pSSysTestData, list);
        super.onFillPasteHelps(pSSysTestData, list);
    }

    protected void onFillPasteHelps_PSSysTDItems(PSSysTestData pSSysTestData, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSTDITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e]\u7684[\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u9879>", "DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", "PSSYSTESTDATAID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysTestDataServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u9879>");
            } else if (PSSysTestDataServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystditems");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID|PSSYSTESTDATAID");
            pSMOSFile2.setFileTag3("PSSYSTDITEM");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", "PSSYSTESTDATAID", pSMOSFile.getPSModelId(), "", "")) {
                PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysTDItemService, "DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", "PSSYSTESTDATAID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSSysTDItemService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysTestDataServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSSysTestDataServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u9879>", (boolean)false) == 0 || PSSysTestDataServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysTDItems", (boolean)true) == 0) {
            PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysTDItemService, "DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", "PSSYSTESTDATAID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSSysTDItemService.selectEx((ISelectContext)selectContext);
            for (PSSysTDItem pSSysTDItem : arrayList2) {
                PSMOSFile pSMOSFile2 = pSSysTDItemService.getFile(pSMOSFile, (IEntity)pSSysTDItem, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", (boolean)false) == 0) {
            if (PSSysTestDataServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u9879>";
            }
            if (PSSysTestDataServiceBase.getMOSVer() == 2) {
                return "pssystditems";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysTestData pSSysTestData, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "TestData");
    }
}

