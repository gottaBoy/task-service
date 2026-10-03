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
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlMsgDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlMsgDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlMsgServiceBase
extends PSCoreSysServiceBase<PSCtrlMsg> {
    private static final Log log = LogFactory.getLog(PSCtrlMsgServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEALL = "CurDEAll";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSALL = "CurSysAll";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSCtrlMsgDEModel pSCtrlMsgDEModel;
    private PSCtrlMsgDAO pSCtrlMsgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService";
    }

    public PSCtrlMsgDEModel getPSCtrlMsgDEModel() {
        if (this.pSCtrlMsgDEModel == null) {
            try {
                this.pSCtrlMsgDEModel = (PSCtrlMsgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlMsgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlMsgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlMsgDEModel();
    }

    public PSCtrlMsgDAO getPSCtrlMsgDAO() {
        if (this.pSCtrlMsgDAO == null) {
            try {
                this.pSCtrlMsgDAO = (PSCtrlMsgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlMsgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlMsgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlMsgDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEALL, (boolean)true) == 0) {
            return this.fetchCurDEAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSALL, (boolean)true) == 0) {
            return this.fetchCurSysAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEALL, (boolean)true) == 0) {
            return this.fetchTempCurDEAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSALL, (boolean)true) == 0) {
            return this.fetchTempCurSysAll(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEALL, true);
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

    public DBFetchResult fetchCurSysAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSALL, true);
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

    protected void onFillParentInfo(PSCtrlMsg pSCtrlMsg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLMSG_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSCtrlMsg, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLMSG_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSCtrlMsg, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLMSG_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSCtrlMsg, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLMSG_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSCtrlMsg, pSSystem);
            return;
        }
        super.onFillParentInfo(pSCtrlMsg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSCtrlMsg pSCtrlMsg, PSDataEntity pSDataEntity) throws Exception {
        pSCtrlMsg.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSCtrlMsg.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSModule(PSCtrlMsg pSCtrlMsg, PSModule pSModule) throws Exception {
        pSCtrlMsg.setPSModuleId(pSModule.getPSModuleId());
        pSCtrlMsg.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSCtrlMsg pSCtrlMsg, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSCtrlMsg.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSCtrlMsg.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSystem(PSCtrlMsg pSCtrlMsg, PSSystem pSSystem) throws Exception {
        pSCtrlMsg.setPSSystemId(pSSystem.getPSSystemId());
        pSCtrlMsg.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
        if (bl) {
            if (pSCtrlMsg.getCodeName() == null) {
                pSCtrlMsg.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "CtrlMsg", 25));
            }
            if (pSCtrlMsg.getPSCtrlMsgName() == null) {
                pSCtrlMsg.setPSCtrlMsgName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u90e8\u4ef6\u6d88\u606f", 25));
            }
        }
        super.onFillEntityFullInfo(pSCtrlMsg, bl);
        this.onFillEntityFullInfo_PSDE(pSCtrlMsg, bl);
        this.onFillEntityFullInfo_PSModule(pSCtrlMsg, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSCtrlMsg, bl);
        this.onFillEntityFullInfo_PSSystem(pSCtrlMsg, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
        if (pSCtrlMsg.isPSDEIdDirty()) {
            if (pSCtrlMsg.getPSDEId() != null) {
                if (pSCtrlMsg.getPSDEId() == null || pSCtrlMsg.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSCtrlMsg.getPSDE();
                    pSCtrlMsg.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSCtrlMsg.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
        if (pSCtrlMsg.isPSSystemIdDirty()) {
            if (pSCtrlMsg.getPSSystemId() != null) {
                if (pSCtrlMsg.getPSSystemId() == null || pSCtrlMsg.getPSSystemName() == null) {
                    PSSystem pSSystem = pSCtrlMsg.getPSSystem();
                    pSCtrlMsg.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSCtrlMsg.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
        super.onWriteBackParent(pSCtrlMsg, bl);
    }

    public ArrayList<PSCtrlMsg> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSCtrlMsg> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSCtrlMsg> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSCtrlMsg> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSCtrlMsg> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLMSG_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSCTRLMSG", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            PSCtrlMsg pSCtrlMsg2 = (PSCtrlMsg)this.getDEModel().createEntity();
            pSCtrlMsg2.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
            pSCtrlMsg2.setPSDEId(null);
            this.update(pSCtrlMsg2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlMsgServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSCtrlMsgServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSCtrlMsgServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            this.remove(pSCtrlMsg);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLMSG_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSCTRLMSG", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSModule(pSModule);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            PSCtrlMsg pSCtrlMsg2 = (PSCtrlMsg)this.getDEModel().createEntity();
            pSCtrlMsg2.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
            pSCtrlMsg2.setPSModuleId(null);
            this.update(pSCtrlMsg2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlMsgServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSCtrlMsgServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSCtrlMsgServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            this.remove(pSCtrlMsg);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLMSG_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSCTRLMSG", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            PSCtrlMsg pSCtrlMsg2 = (PSCtrlMsg)this.getDEModel().createEntity();
            pSCtrlMsg2.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
            pSCtrlMsg2.setPSSysDynaModelId(null);
            this.update(pSCtrlMsg2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlMsgServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSCtrlMsgServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSCtrlMsgServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            this.remove(pSCtrlMsg);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLMSG_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSCTRLMSG", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSSystem(pSSystem);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            PSCtrlMsg pSCtrlMsg2 = (PSCtrlMsg)this.getDEModel().createEntity();
            pSCtrlMsg2.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
            pSCtrlMsg2.setPSSystemId(null);
            this.update(pSCtrlMsg2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlMsgServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSCtrlMsgServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSCtrlMsgServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSCtrlMsg> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSCtrlMsg pSCtrlMsg : arrayList) {
            this.remove(pSCtrlMsg);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSCtrlMsg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlMsg pSCtrlMsg) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlMsgItemServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        ((PSCtrlMsgItemServiceBase)pSCoreSysServiceBase).removeByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapViewServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        pSCoreSysServiceBase = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarServiceBase)pSCoreSysServiceBase).testRemoveByPSCtrlMsg(pSCtrlMsg);
        super.onBeforeRemove(pSCtrlMsg);
    }

    protected void onBeforeRemoveTemp(PSCtrlMsg pSCtrlMsg) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        pSCtrlMsgItemService.removeTempByPSCtrlMsg(pSCtrlMsg);
        super.onBeforeRemoveTemp(pSCtrlMsg);
    }

    protected void getRelatedDataTempMajor(PSCtrlMsg pSCtrlMsg) throws Exception {
        this.getRelatedDataTempMajor_PSCtrlMsgItem(pSCtrlMsg);
        super.getRelatedDataTempMajor(pSCtrlMsg);
    }

    protected void getRelatedDataTempMajor_PSCtrlMsgItem(PSCtrlMsg pSCtrlMsg) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlMsgItem> arrayList = null;
        String string = pSCtrlMsg.getPSCtrlMsgId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSCtrlMsgItemService.selectByPSCtrlMsg(pSCtrlMsg) : pSCtrlMsgItemService.selectTempByPSCtrlMsg(pSCtrlMsg);
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            pSCtrlMsgItemService.getTempMajor(pSCtrlMsgItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSCtrlMsg pSCtrlMsg, PSCtrlMsg pSCtrlMsg2) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.updateRelatedDataTempMajor_removePSCtrlMsgItem(pSCtrlMsg, pSCtrlMsg2);
        this.updateRelatedDataTempMajor_updatePSCtrlMsgItem(pSCtrlMsg, pSCtrlMsg2, arrayList);
        super.updateRelatedDataTempMajor(pSCtrlMsg, pSCtrlMsg2);
    }

    protected ArrayList<PSCtrlMsgItem> updateRelatedDataTempMajor_removePSCtrlMsgItem(PSCtrlMsg pSCtrlMsg, PSCtrlMsg pSCtrlMsg2) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlMsgItem> arrayList = pSCtrlMsgItemService.selectTempByPSCtrlMsg(pSCtrlMsg);
        ArrayList<PSCtrlMsgItem> arrayList2 = pSCtrlMsgItemService.selectByPSCtrlMsg(pSCtrlMsg2);
        HashMap<String, PSCtrlMsgItem> hashMap = new HashMap<String, PSCtrlMsgItem>();
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList2) {
            hashMap.put(pSCtrlMsgItem.getPSCtrlMsgItemId(), pSCtrlMsgItem);
        }
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            Object object = pSCtrlMsgItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSCtrlMsgItem pSCtrlMsgItem : hashMap.values()) {
            pSCtrlMsgItemService.remove(pSCtrlMsgItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSCtrlMsgItem(PSCtrlMsg pSCtrlMsg, PSCtrlMsg pSCtrlMsg2, ArrayList<PSCtrlMsgItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            pSCtrlMsgItemService.updateTempMajor(pSCtrlMsgItem);
        }
    }

    protected void replaceParentInfo(PSCtrlMsg pSCtrlMsg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCtrlMsg, cloneSession);
        if (pSCtrlMsg.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSCtrlMsg.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSCtrlMsg, (PSDataEntity)iEntity);
        }
        if (pSCtrlMsg.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSCtrlMsg.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSCtrlMsg, (PSModule)iEntity);
        }
        if (pSCtrlMsg.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSCtrlMsg.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSCtrlMsg, (PSSysDynaModel)iEntity);
        }
        if (pSCtrlMsg.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSCtrlMsg.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSCtrlMsg, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCtrlMsg, bl);
        pSCtrlMsg.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSCtrlMsg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgModel(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgName(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlType(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSCtrlMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCtrlMsg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isCodeNameDirty() && !bl2 : !pSCtrlMsg.isCodeNameDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSCtrlMsg, bl2, bl3);
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
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSCtrlMsgDEModel(), "CODENAME", string3, pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isLockFlagDirty() : !pSCtrlMsg.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSCtrlMsg.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isMemoDirty() : !pSCtrlMsg.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_MsgModel(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isMsgModelDirty() : !pSCtrlMsg.isMsgModelDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getMsgModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgModel_Default(pSCtrlMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSCtrlMsgIdDirty() && !bl2 : !pSCtrlMsg.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSCtrlMsgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default(pSCtrlMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgName(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSCtrlMsgNameDirty() && !bl2 : !pSCtrlMsg.isPSCtrlMsgNameDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSCtrlMsgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgName_Default(pSCtrlMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSDEIdDirty() : !pSCtrlMsg.isPSDEIdDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSDENameDirty() : !pSCtrlMsg.isPSDENameDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewCtrlType(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSDEViewCtrlTypeDirty() : !pSCtrlMsg.isPSDEViewCtrlTypeDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSDEViewCtrlType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlType_Default(pSCtrlMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSModuleIdDirty() : !pSCtrlMsg.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSSysDynaModelIdDirty() : !pSCtrlMsg.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSSystemIdDirty() && !bl2 : !pSCtrlMsg.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isPSSystemNameDirty() && !bl2 : !pSCtrlMsg.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isUserCatDirty() : !pSCtrlMsg.isUserCatDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isUserTagDirty() : !pSCtrlMsg.isUserTagDirty()) {
            return null;
        }
        String string = pSCtrlMsg.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isUserTag2Dirty() : !pSCtrlMsg.isUserTag2Dirty()) {
            return null;
        }
        String string = pSCtrlMsg.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isUserTag3Dirty() : !pSCtrlMsg.isUserTag3Dirty()) {
            return null;
        }
        String string = pSCtrlMsg.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSCtrlMsg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSCtrlMsg pSCtrlMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsg.isUserTag4Dirty() : !pSCtrlMsg.isUserTag4Dirty()) {
            return null;
        }
        String string = pSCtrlMsg.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSCtrlMsg, bl2, bl3);
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

    protected void onSyncEntity(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
        super.onSyncEntity(pSCtrlMsg, bl);
    }

    protected void onSyncIndexEntities(PSCtrlMsg pSCtrlMsg, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCtrlMsg, bl);
    }

    public Object getDataContextValue(PSCtrlMsg pSCtrlMsg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCtrlMsg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlMsg pSCtrlMsg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCtrlMsg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MsgModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEViewCtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCtrlMsg pSCtrlMsg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCtrlMsg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlMsg pSCtrlMsg) throws Exception {
        super.onUpdateParent(pSCtrlMsg);
    }

    protected void onCopyDetails(PSCtrlMsg pSCtrlMsg, Object object) throws Exception {
        PSCtrlMsg pSCtrlMsg2 = new PSCtrlMsg();
        pSCtrlMsg2.set("PSCTRLMSGID", object);
        String string = DataObject.getStringValue((Object)pSCtrlMsg.get("PSCTRLMSGID"));
        super.onCopyDetails(pSCtrlMsg, object);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlMsg pSCtrlMsg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLMSG");
        if (!bl) {
            pSCtrlMsg.setCreateDate(null);
            pSCtrlMsg.setCreateMan(null);
            pSCtrlMsg.setPSCtrlMsgId(null);
            pSCtrlMsg.setUpdateDate(null);
            pSCtrlMsg.setUpdateMan(null);
            super.exportCurXmlModel(pSCtrlMsg, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSCtrlMsg pSCtrlMsg, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSCtrlMsgItem(pSCtrlMsg, xmlNode);
        super.onExportRelatedXmlModel(pSCtrlMsg, xmlNode);
    }

    protected void exportRelatedXmlModel_PSCtrlMsgItem(PSCtrlMsg pSCtrlMsg, XmlNode xmlNode) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlMsgItem> arrayList = null;
        String string = pSCtrlMsg.getPSCtrlMsgId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSCtrlMsgItemService.selectByPSCtrlMsg(pSCtrlMsg) : pSCtrlMsgItemService.selectTempByPSCtrlMsg(pSCtrlMsg);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSCTRLMSGITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
                pSCtrlMsgItemService.exportXmlModel(pSCtrlMsgItem, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSCtrlMsg pSCtrlMsg, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSCTRLMSGITEMS");
        this.importRelatedXmlModel_PSCtrlMsgItem(pSCtrlMsg, xmlNode2);
        super.onImportRelatedXmlModel(pSCtrlMsg, xmlNode);
    }

    protected void importRelatedXmlModel_PSCtrlMsgItem(PSCtrlMsg pSCtrlMsg, XmlNode xmlNode) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSCtrlMsg.getPSCtrlMsgId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSCtrlMsgItemService.removeByPSCtrlMsg(pSCtrlMsg);
        } else {
            pSCtrlMsgItemService.removeTempByPSCtrlMsg(pSCtrlMsg);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSCtrlMsgItem pSCtrlMsgItem = new PSCtrlMsgItem();
                pSCtrlMsgItemService.fillParentInfo(pSCtrlMsgItem, "DER1N", "DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", pSCtrlMsg.getPSCtrlMsgId());
                pSCtrlMsgItemService.importXmlModel(pSCtrlMsgItem, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSCtrlMsg pSCtrlMsg, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSCtrlMsg, string);
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
            return "DER1N_PSCTRLMSG_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCTRLMSG_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCTRLMSG_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSCtrlMsg pSCtrlMsg) {
        if (!StringHelper.isNullOrEmpty((String)pSCtrlMsg.getCodeName())) {
            return pSCtrlMsg.getCodeName();
        }
        return super.getModelV2Tag(pSCtrlMsg);
    }

    @Override
    public boolean setModelV2Tag(PSCtrlMsg pSCtrlMsg, String string) {
        pSCtrlMsg.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSCtrlMsg pSCtrlMsg, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSCtrlMsg.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSCtrlMsg, true);
        pSCtrlMsg.set("CODENAME", string);
        if (this.select(pSCtrlMsg, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSCtrlMsg, true);
        return super.getModelV2Entity(pSCtrlMsg, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSCtrlMsg pSCtrlMsg, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSCtrlMsg, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSCtrlMsg pSCtrlMsg, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSCtrlMsg, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSCtrlMsg pSCtrlMsg, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID")) {
            PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSCTRLMSG#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSCTRLMSGITEM", (Object)pSCtrlMsg.getPSCtrlMsgId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String itemJson : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)itemJson)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(itemJson));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String resScope = StringHelper.format((String)"PSCTRLMSG#%1$s", (Object)pSCtrlMsg.getPSCtrlMsgId());
                for (PSCtrlMsgItem item : pSCtrlMsgItemService.selectByPSCtrlMsg(pSCtrlMsg)) {
                    String itemScope = pSCtrlMsgItemService.getModelV2ResScope(item);
                    if (StringHelper.compare(resScope, itemScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode itemsNode = objectNode.putArray(pSCtrlMsgItemService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psctrlmsgitemname")) {
                            string = objectNode.get("psctrlmsgitemname").asText();
                        }
                        if (objectNode2.has("psctrlmsgitemname")) {
                            string2 = objectNode2.get("psctrlmsgitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : arrayList) {
                    PSCtrlMsgItem item = new PSCtrlMsgItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, itemNode, false);
                    itemsNode.add((JsonNode)pSCtrlMsgItemService.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSCtrlMsg, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSCtrlMsg pSCtrlMsg) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCtrlMsgItem> arrayList = pSCtrlMsgItemService.selectByPSCtrlMsg(pSCtrlMsg);
        String string = StringHelper.format((String)"PSCTRLMSG#%1$s", (Object)pSCtrlMsg.getPSCtrlMsgId());
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            String string2 = pSCtrlMsgItemService.getModelV2ResScope(pSCtrlMsgItem);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSCtrlMsgItemService.emptyModelV2(pSCtrlMsgItem);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSCtrlMsg.getPSCtrlMsgId());
        pSCtrlMsgItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSCtrlMsgItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSCTRLMSGITEM WHERE PSCTRLMSGID = ?", sqlParamList);
        super.onEmptyModelV2(pSCtrlMsg);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCtrlMsgItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSCtrlMsg pSCtrlMsg, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSCtrlMsgItem pSCtrlMsgItem = new PSCtrlMsgItem();
        pSCtrlMsgItem.set("PSCTRLMSGID", pSCtrlMsg.getPSCtrlMsgId());
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCtrlMsgItemService.getModelV2Entity(pSCtrlMsgItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSCtrlMsg, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSCtrlMsg pSCtrlMsg, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCtrlMsgItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSCtrlMsgItem pSCtrlMsgItem = new PSCtrlMsgItem();
                pSCtrlMsgItem.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
                pSCtrlMsgItem.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
                pSCtrlMsgItemService.compileModelV2(pSCtrlMsgItem, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSCtrlMsgItem pSCtrlMsgItem = new PSCtrlMsgItem();
                    pSCtrlMsgItem.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
                    pSCtrlMsgItem.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
                    pSCtrlMsgItemService.compileModelV2(pSCtrlMsgItem, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSCtrlMsg, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSCtrlMsg pSCtrlMsg, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSCtrlMsgItems(pSCtrlMsg, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSCtrlMsg, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSCtrlMsgItems(PSCtrlMsg pSCtrlMsg, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSCTRLMSGITEM", true), (boolean)false) == 0) {
            PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
            PSCtrlMsgItem pSCtrlMsgItem = new PSCtrlMsgItem();
            pSCtrlMsgItem.setPSCtrlMsgItemId(pSMOSFile.getPSModelId());
            if (!pSCtrlMsgItemService.get(pSCtrlMsgItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSCtrlMsgItem.getPSCtrlMsgId(), (String)pSCtrlMsg.getPSCtrlMsgId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSCtrlMsgItemService.exportModelV2(pSCtrlMsgItem);
            pSCtrlMsgItem.reset();
            if (!pSCtrlMsgItemService.setModelV2ResScope(pSCtrlMsgItem, "PSCTRLMSG", pSCtrlMsg.getPSCtrlMsgId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSCtrlMsgItemService.importModelV2(pSCtrlMsgItem, objectNode);
            SessionFactoryManager.commit();
            return pSCtrlMsgItemService.getFile(pSCtrlMsgItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSCtrlMsg pSCtrlMsg, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSCtrlMsgItems(pSCtrlMsg, list);
        super.onFillPasteHelps(pSCtrlMsg, list);
    }

    protected void onFillPasteHelps_PSCtrlMsgItems(PSCtrlMsg pSCtrlMsg, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSCTRLMSGITEM");
        pSHelpSection.setSectionParam2("DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u90e8\u4ef6\u6d88\u606f]\u7684[\u90e8\u4ef6\u6d88\u606f\u9879]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6d88\u606f\u9879>", "DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", "PSCTRLMSGID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSCtrlMsgServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6d88\u606f\u9879>");
            } else if (PSCtrlMsgServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psctrlmsgitems");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID|PSCTRLMSGID");
            pSMOSFile2.setFileTag3("PSCTRLMSGITEM");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", "PSCTRLMSGID", pSMOSFile.getPSModelId(), "", "")) {
                PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCtrlMsgItemService, "DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", "PSCTRLMSGID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSCtrlMsgItemService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSCtrlMsgServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSCtrlMsgServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6d88\u606f\u9879>", (boolean)false) == 0 || PSCtrlMsgServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSCtrlMsgItems", (boolean)true) == 0) {
            PSCtrlMsgItemService pSCtrlMsgItemService = (PSCtrlMsgItemService)ServiceGlobal.getService(PSCtrlMsgItemService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCtrlMsgItemService, "DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", "PSCTRLMSGID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSCtrlMsgItem> arrayList2 = pSCtrlMsgItemService.selectEx((ISelectContext)selectContext);
            for (PSCtrlMsgItem pSCtrlMsgItem : arrayList2) {
                PSMOSFile pSMOSFile2 = pSCtrlMsgItemService.getFile(pSMOSFile, pSCtrlMsgItem, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", (boolean)false) == 0) {
            if (PSCtrlMsgServiceBase.getMOSVer() == 1) {
                return "<\u6d88\u606f\u9879>";
            }
            if (PSCtrlMsgServiceBase.getMOSVer() == 2) {
                return "psctrlmsgitems";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    public Object getDataType(PSCtrlMsg pSCtrlMsg) throws Exception {
        return pSCtrlMsg.getPSDEViewCtrlType();
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSCtrlMsg pSCtrlMsg, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "CtrlMsg");
        defaultValueMap.put("PSCTRLMSGNAME", "\u90e8\u4ef6\u6d88\u606f");
    }
}
