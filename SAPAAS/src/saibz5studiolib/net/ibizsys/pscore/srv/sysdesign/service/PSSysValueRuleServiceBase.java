/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.entity.PSValueRuleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysValueRuleDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysValueRuleDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDEActionParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysValueRuleServiceBase
extends PSCoreSysServiceBase<PSSysValueRule> {
    private static final Log log = LogFactory.getLog(PSSysValueRuleServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysValueRuleDEModel pSSysValueRuleDEModel;
    private PSSysValueRuleDAO pSSysValueRuleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService";
    }

    public PSSysValueRuleDEModel getPSSysValueRuleDEModel() {
        if (this.pSSysValueRuleDEModel == null) {
            try {
                this.pSSysValueRuleDEModel = (PSSysValueRuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysValueRuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysValueRuleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysValueRuleDEModel();
    }

    public PSSysValueRuleDAO getPSSysValueRuleDAO() {
        if (this.pSSysValueRuleDAO == null) {
            try {
                this.pSSysValueRuleDAO = (PSSysValueRuleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysValueRuleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysValueRuleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysValueRuleDAO();
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

    protected void onFillParentInfo(PSSysValueRule pSSysValueRule, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVALUERULE_PSLANGUAGERES_RIPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_RIPSLanRes(pSSysValueRule, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVALUERULE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysValueRule, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVALUERULE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysValueRule, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVALUERULE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysValueRule, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVALUERULE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysValueRule, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVALUERULE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysValueRule, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVALUERULE_PSVALUERULE_PSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSValueRuleService", (SessionFactory)this.getSessionFactory());
            PSValueRule pSValueRule = (PSValueRule)iService.getDEModel().createEntity();
            pSValueRule.set("PSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSValueRule);
            } else {
                iService.get(pSValueRule);
            }
            this.onFillParentInfo_PSValueRule(pSSysValueRule, pSValueRule);
            return;
        }
        super.onFillParentInfo(pSSysValueRule, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_RIPSLanRes(PSSysValueRule pSSysValueRule, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysValueRule.setRIPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysValueRule.setRIPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSSysValueRule pSSysValueRule, PSModule pSModule) throws Exception {
        pSSysValueRule.setPSModuleId(pSModule.getPSModuleId());
        pSSysValueRule.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysValueRule pSSysValueRule, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysValueRule.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysValueRule.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysValueRule pSSysValueRule, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysValueRule.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysValueRule.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysValueRule pSSysValueRule, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysValueRule.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysValueRule.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysValueRule pSSysValueRule, PSSystem pSSystem) throws Exception {
        pSSysValueRule.setPSSystemId(pSSystem.getPSSystemId());
        pSSysValueRule.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSValueRule(PSSysValueRule pSSysValueRule, PSValueRule pSValueRule) throws Exception {
        pSSysValueRule.setPSValueRuleId(pSValueRule.getPSValueRuleId());
        pSSysValueRule.setPSValueRuleName(pSValueRule.getPSValueRuleName());
    }

    protected void onFillEntityFullInfo(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
        if (bl && pSSysValueRule.getCodeName() == null) {
            pSSysValueRule.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ValueRule", 25));
        }
        super.onFillEntityFullInfo(pSSysValueRule, bl);
        this.onFillEntityFullInfo_RIPSLanRes(pSSysValueRule, bl);
        this.onFillEntityFullInfo_PSModule(pSSysValueRule, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysValueRule, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysValueRule, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysValueRule, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysValueRule, bl);
        this.onFillEntityFullInfo_PSValueRule(pSSysValueRule, bl);
    }

    protected void onFillEntityFullInfo_RIPSLanRes(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
        if (pSSysValueRule.isRIPSLanResIdDirty()) {
            if (pSSysValueRule.getRIPSLanResId() != null) {
                if (pSSysValueRule.getRIPSLanResId() == null || pSSysValueRule.getRIPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysValueRule.getRIPSLanRes();
                    pSSysValueRule.setRIPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysValueRule.setRIPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
        if (pSSysValueRule.isPSSystemIdDirty()) {
            if (pSSysValueRule.getPSSystemId() != null) {
                if (pSSysValueRule.getPSSystemId() == null || pSSysValueRule.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysValueRule.getPSSystem();
                    pSSysValueRule.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysValueRule.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSValueRule(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysValueRule, bl);
    }

    public ArrayList<PSSysValueRule> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByRIPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysValueRule> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByRIPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysValueRule> selectByRIPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RIPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRIPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRIPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysValueRule> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysValueRule> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysValueRule> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysValueRule> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysValueRule> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysValueRule> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysValueRule> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysValueRule> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysValueRule> selectByPSValueRule(PSValueRuleBase pSValueRuleBase) throws Exception {
        return this.selectByPSValueRule(pSValueRuleBase, "", -1);
    }

    public ArrayList<PSSysValueRule> selectByPSValueRule(PSValueRuleBase pSValueRuleBase, String string) throws Exception {
        return this.selectByPSValueRule(pSValueRuleBase, string, -1);
    }

    public ArrayList<PSSysValueRule> selectByPSValueRule(PSValueRuleBase pSValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVALUERULEID", (Object)pSValueRuleBase.getPSValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByRIPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVALUERULE_PSLANGUAGERES_RIPSLANRESID", "", iDataEntityModel.getName(), "PSSYSVALUERULE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByRIPSLanRes(pSLanguageRes);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            PSSysValueRule pSSysValueRule2 = (PSSysValueRule)this.getDEModel().createEntity();
            pSSysValueRule2.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
            pSSysValueRule2.setRIPSLanResId(null);
            this.update(pSSysValueRule2);
        }
    }

    public void removeByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysValueRuleServiceBase.this.onBeforeRemoveByRIPSLanRes(pSLanguageRes2);
                PSSysValueRuleServiceBase.this.internalRemoveByRIPSLanRes(pSLanguageRes2);
                PSSysValueRuleServiceBase.this.onAfterRemoveByRIPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByRIPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByRIPSLanRes(pSLanguageRes, arrayList);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            this.remove(pSSysValueRule);
        }
        this.onAfterRemoveByRIPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRIPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVALUERULE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSVALUERULE", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSModule(pSModule);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            PSSysValueRule pSSysValueRule2 = (PSSysValueRule)this.getDEModel().createEntity();
            pSSysValueRule2.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
            pSSysValueRule2.setPSModuleId(null);
            this.update(pSSysValueRule2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysValueRuleServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysValueRuleServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysValueRuleServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            this.remove(pSSysValueRule);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVALUERULE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSVALUERULE", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            PSSysValueRule pSSysValueRule2 = (PSSysValueRule)this.getDEModel().createEntity();
            pSSysValueRule2.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
            pSSysValueRule2.setPSSysDynaModelId(null);
            this.update(pSSysValueRule2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysValueRuleServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysValueRuleServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysValueRuleServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            this.remove(pSSysValueRule);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVALUERULE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSVALUERULE", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            PSSysValueRule pSSysValueRule2 = (PSSysValueRule)this.getDEModel().createEntity();
            pSSysValueRule2.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
            pSSysValueRule2.setPSSysPFPluginId(null);
            this.update(pSSysValueRule2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysValueRuleServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysValueRuleServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysValueRuleServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            this.remove(pSSysValueRule);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVALUERULE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSVALUERULE", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            PSSysValueRule pSSysValueRule2 = (PSSysValueRule)this.getDEModel().createEntity();
            pSSysValueRule2.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
            pSSysValueRule2.setPSSysSFPluginId(null);
            this.update(pSSysValueRule2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysValueRuleServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysValueRuleServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysValueRuleServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            this.remove(pSSysValueRule);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            PSSysValueRule pSSysValueRule2 = (PSSysValueRule)this.getDEModel().createEntity();
            pSSysValueRule2.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
            pSSysValueRule2.setPSSystemId(null);
            this.update(pSSysValueRule2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysValueRuleServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysValueRuleServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysValueRuleServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            this.remove(pSSysValueRule);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    public void testRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSValueRule(pSValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVALUERULE_PSVALUERULE_PSVALUERULEID", "", iDataEntityModel.getName(), "PSSYSVALUERULE", iDataEntityModel.getDataInfo(pSValueRule), arrayList.get(0)));
        }
    }

    public void resetPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSValueRule(pSValueRule);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            PSSysValueRule pSSysValueRule2 = (PSSysValueRule)this.getDEModel().createEntity();
            pSSysValueRule2.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
            pSSysValueRule2.setPSValueRuleId(null);
            this.update(pSSysValueRule2);
        }
    }

    public void removeByPSValueRule(PSValueRule pSValueRule) throws Exception {
        final PSValueRule pSValueRule2 = pSValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysValueRuleServiceBase.this.onBeforeRemoveByPSValueRule(pSValueRule2);
                PSSysValueRuleServiceBase.this.internalRemoveByPSValueRule(pSValueRule2);
                PSSysValueRuleServiceBase.this.onAfterRemoveByPSValueRule(pSValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
    }

    protected void internalRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSSysValueRule> arrayList = this.selectByPSValueRule(pSValueRule);
        this.onBeforeRemoveByPSValueRule(pSValueRule, arrayList);
        for (PSSysValueRule pSSysValueRule : arrayList) {
            this.remove(pSSysValueRule);
        }
        this.onAfterRemoveByPSValueRule(pSValueRule, arrayList);
    }

    protected void onAfterRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSValueRule(PSValueRule pSValueRule, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSValueRule(PSValueRule pSValueRule, ArrayList<PSSysValueRule> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysValueRule pSSysValueRule) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEActionParamService)ServiceGlobal.getService(PSDEActionParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSDESAVRService)ServiceGlobal.getService(PSDESAVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESAVRServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSSubSysSADEFieldService)ServiceGlobal.getService(PSSubSysSADEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSSysDEFTypeService)ServiceGlobal.getService(PSSysDEFTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDEFTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        pSCoreSysServiceBase = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDynaModelAttrServiceBase)pSCoreSysServiceBase).testRemoveByPSSysValueRule(pSSysValueRule);
        super.onBeforeRemove(pSSysValueRule);
    }

    protected void replaceParentInfo(PSSysValueRule pSSysValueRule, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysValueRule, cloneSession);
        if (pSSysValueRule.getRIPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysValueRule.getRIPSLanResId())) != null) {
            this.onFillParentInfo_RIPSLanRes(pSSysValueRule, (PSLanguageRes)iEntity);
        }
        if (pSSysValueRule.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysValueRule.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysValueRule, (PSModule)iEntity);
        }
        if (pSSysValueRule.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysValueRule.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysValueRule, (PSSysDynaModel)iEntity);
        }
        if (pSSysValueRule.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysValueRule.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysValueRule, (PSSysPFPlugin)iEntity);
        }
        if (pSSysValueRule.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysValueRule.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysValueRule, (PSSysSFPlugin)iEntity);
        }
        if (pSSysValueRule.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysValueRule.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysValueRule, (PSSystem)iEntity);
        }
        if (pSSysValueRule.getPSValueRuleId() != null && (iEntity = cloneSession.getEntity("PSVALUERULE", (Object)pSSysValueRule.getPSValueRuleId())) != null) {
            this.onFillParentInfo_PSValueRule(pSSysValueRule, (PSValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysValueRule, bl);
        pSSysValueRule.resetPSValueRuleId();
        pSSysValueRule.resetPSValueRuleName();
    }

    protected void onCheckEntity(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSSysValueRule, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginValue(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomObj(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomParams(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndValue(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncBeginValue(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncEndValue(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleName(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSValueRuleId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegExpCode(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegExpCode2(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegExpCode3(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RegExpCode4(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RIPSLanResId(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RIPSLanResName(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleHolder(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleInfo(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleTag(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleTag2(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RuleType(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Script(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysValueRule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysValueRule, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isBeginTimeDirty() : !pSSysValueRule.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysValueRule.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginValue(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isBeginValueDirty() : !pSSysValueRule.isBeginValueDirty()) {
            return null;
        }
        Double d = pSSysValueRule.getBeginValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginValue_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isCodeNameDirty() : !pSSysValueRule.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysValueRule.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysValueRule, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysValueRuleDEModel(), "CODENAME", string3, pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomObj(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isCustomObjDirty() : !pSSysValueRule.isCustomObjDirty()) {
            return null;
        }
        String string = pSSysValueRule.getCustomObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomObj_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomParams(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isCustomParamsDirty() : !pSSysValueRule.isCustomParamsDirty()) {
            return null;
        }
        String string = pSSysValueRule.getCustomParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomParams_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isDynaModelFlagDirty() : !pSSysValueRule.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSSysValueRule.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isEndTimeDirty() : !pSSysValueRule.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysValueRule.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndValue(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isEndValueDirty() : !pSSysValueRule.isEndValueDirty()) {
            return null;
        }
        Double d = pSSysValueRule.getEndValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndValue_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncBeginValue(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isIncBeginValueDirty() : !pSSysValueRule.isIncBeginValueDirty()) {
            return null;
        }
        Integer n = pSSysValueRule.getIncBeginValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncBeginValue_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCBEGINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncEndValue(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isIncEndValueDirty() : !pSSysValueRule.isIncEndValueDirty()) {
            return null;
        }
        Integer n = pSSysValueRule.getIncEndValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncEndValue_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCENDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isLockFlagDirty() : !pSSysValueRule.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysValueRule.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isMemoDirty() : !pSSysValueRule.isMemoDirty()) {
            return null;
        }
        String string = pSSysValueRule.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSDynaInstIdDirty() : !pSSysValueRule.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSModuleIdDirty() : !pSSysValueRule.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSSysDynaModelIdDirty() : !pSSysValueRule.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSSysPFPluginIdDirty() : !pSSysValueRule.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSSysSFPluginIdDirty() : !pSSysValueRule.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSSystemIdDirty() : !pSSysValueRule.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSSystemNameDirty() && !bl2 : !pSSysValueRule.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSSysValueRuleIdDirty() && !bl2 : !pSSysValueRule.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSSysValueRuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleName(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSSysValueRuleNameDirty() && !bl2 : !pSSysValueRule.isPSSysValueRuleNameDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSSysValueRuleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleName_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysValueRuleDEModel(), "PSSYSVALUERULENAME", string3, pSSysValueRule, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSVALUERULENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSValueRuleId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isPSValueRuleIdDirty() : !pSSysValueRule.isPSValueRuleIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getPSValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSValueRuleId_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegExpCode(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRegExpCodeDirty() : !pSSysValueRule.isRegExpCodeDirty()) {
            return null;
        }
        String string = pSSysValueRule.getRegExpCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegExpCode_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGEXPCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegExpCode2(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRegExpCode2Dirty() : !pSSysValueRule.isRegExpCode2Dirty()) {
            return null;
        }
        String string = pSSysValueRule.getRegExpCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegExpCode2_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGEXPCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegExpCode3(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRegExpCode3Dirty() : !pSSysValueRule.isRegExpCode3Dirty()) {
            return null;
        }
        String string = pSSysValueRule.getRegExpCode3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegExpCode3_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGEXPCODE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RegExpCode4(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRegExpCode4Dirty() : !pSSysValueRule.isRegExpCode4Dirty()) {
            return null;
        }
        String string = pSSysValueRule.getRegExpCode4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RegExpCode4_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REGEXPCODE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RIPSLanResId(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRIPSLanResIdDirty() : !pSSysValueRule.isRIPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysValueRule.getRIPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RIPSLanResId_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RIPSLanResName(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRIPSLanResNameDirty() : !pSSysValueRule.isRIPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysValueRule.getRIPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RIPSLanResName_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleHolder(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRuleHolderDirty() : !pSSysValueRule.isRuleHolderDirty()) {
            return null;
        }
        Integer n = pSSysValueRule.getRuleHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RuleHolder_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULEHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleInfo(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRuleInfoDirty() && !bl2 : !pSSysValueRule.isRuleInfoDirty()) {
            return null;
        }
        String string = pSSysValueRule.getRuleInfo();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULEINFO");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleInfo_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULEINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleTag(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRuleTagDirty() : !pSSysValueRule.isRuleTagDirty()) {
            return null;
        }
        String string = pSSysValueRule.getRuleTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleTag_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleTag2(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRuleTag2Dirty() : !pSSysValueRule.isRuleTag2Dirty()) {
            return null;
        }
        String string = pSSysValueRule.getRuleTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleTag2_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RuleType(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isRuleTypeDirty() && !bl2 : !pSSysValueRule.isRuleTypeDirty()) {
            return null;
        }
        String string = pSSysValueRule.getRuleType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RuleType_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RULETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Script(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isScriptDirty() : !pSSysValueRule.isScriptDirty()) {
            return null;
        }
        String string = pSSysValueRule.getScript();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Script_Default(pSSysValueRule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SCRIPT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isUserCatDirty() : !pSSysValueRule.isUserCatDirty()) {
            return null;
        }
        String string = pSSysValueRule.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isUserTagDirty() : !pSSysValueRule.isUserTagDirty()) {
            return null;
        }
        String string = pSSysValueRule.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isUserTag2Dirty() : !pSSysValueRule.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysValueRule.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isUserTag3Dirty() : !pSSysValueRule.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysValueRule.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysValueRule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysValueRule pSSysValueRule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysValueRule.isUserTag4Dirty() : !pSSysValueRule.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysValueRule.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysValueRule, bl2, bl3);
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

    protected void onSyncEntity(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
        super.onSyncEntity(pSSysValueRule, bl);
    }

    protected void onSyncIndexEntities(PSSysValueRule pSSysValueRule, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysValueRule, bl);
    }

    public Object getDataContextValue(PSSysValueRule pSSysValueRule, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysValueRule, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysValueRule pSSysValueRule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysValueRule, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCBEGINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncBeginValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCENDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncEndValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGEXPCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegExpCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGEXPCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegExpCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGEXPCODE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegExpCode3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REGEXPCODE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RegExpCode4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RIPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RIPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULEHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RULETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RuleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SCRIPT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Script_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BeginValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_CustomObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IncBeginValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IncEndValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegExpCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGEXPCODE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegExpCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGEXPCODE2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegExpCode3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGEXPCODE3", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RegExpCode4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REGEXPCODE4", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RIPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RIPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RuleInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULEINFO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RuleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RULETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Script_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SCRIPT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysValueRule pSSysValueRule) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysValueRule)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysValueRule pSSysValueRule) throws Exception {
        super.onUpdateParent(pSSysValueRule);
    }

    @Override
    protected void exportCurXmlModel(PSSysValueRule pSSysValueRule, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSVALUERULE");
        if (!bl) {
            pSSysValueRule.setPSValueRuleName(null);
            super.exportCurXmlModel(pSSysValueRule, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysValueRule pSSysValueRule, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysValueRule, string);
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
            return "DER1N_PSSYSVALUERULE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVALUERULE_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysValueRule pSSysValueRule) {
        if (!StringHelper.isNullOrEmpty((String)pSSysValueRule.getCodeName())) {
            return pSSysValueRule.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysValueRule.getPSSysValueRuleName())) {
            return pSSysValueRule.getPSSysValueRuleName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysValueRule.getCodeName())) {
            return pSSysValueRule.getCodeName();
        }
        return super.getModelV2Tag(pSSysValueRule);
    }

    @Override
    public boolean setModelV2Tag(PSSysValueRule pSSysValueRule, String string) {
        pSSysValueRule.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSVALUERULENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysValueRule pSSysValueRule, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysValueRule.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysValueRule, true);
        pSSysValueRule.set("CODENAME", string);
        if (this.select(pSSysValueRule, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysValueRule, true);
        return super.getModelV2Entity(pSSysValueRule, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysValueRule pSSysValueRule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysValueRule, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysValueRule pSSysValueRule, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ValueRule");
    }
}

