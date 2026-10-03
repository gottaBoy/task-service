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
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIServiceBase;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysTranslatorDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTranslatorDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTranslatorServiceBase
extends PSCoreSysServiceBase<PSSysTranslator> {
    private static final Log log = LogFactory.getLog(PSSysTranslatorServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysTranslatorDEModel pSSysTranslatorDEModel;
    private PSSysTranslatorDAO pSSysTranslatorDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService";
    }

    public PSSysTranslatorDEModel getPSSysTranslatorDEModel() {
        if (this.pSSysTranslatorDEModel == null) {
            try {
                this.pSSysTranslatorDEModel = (PSSysTranslatorDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTranslatorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTranslatorDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTranslatorDEModel();
    }

    public PSSysTranslatorDAO getPSSysTranslatorDAO() {
        if (this.pSSysTranslatorDAO == null) {
            try {
                this.pSSysTranslatorDAO = (PSSysTranslatorDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysTranslatorDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTranslatorDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTranslatorDAO();
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

    protected void onFillParentInfo(PSSysTranslator pSSysTranslator, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysTranslator, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysTranslator, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSDEFIELD_KEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_KeyPSDEF(pSSysTranslator, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSDEFIELD_USER2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_User2PSDEF(pSSysTranslator, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSDEFIELD_USERPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_UserPSDEF(pSSysTranslator, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSDEFIELD_VALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ValuePSDEF(pSSysTranslator, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysTranslator, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysTranslator, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysTranslator, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTRANSLATOR_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysTranslator, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysTranslator, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSysTranslator pSSysTranslator, PSCodeList pSCodeList) throws Exception {
        pSSysTranslator.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysTranslator.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDE(PSSysTranslator pSSysTranslator, PSDataEntity pSDataEntity) throws Exception {
        pSSysTranslator.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysTranslator.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_KeyPSDEF(PSSysTranslator pSSysTranslator, PSDEField pSDEField) throws Exception {
        pSSysTranslator.setKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysTranslator.setKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_User2PSDEF(PSSysTranslator pSSysTranslator, PSDEField pSDEField) throws Exception {
        pSSysTranslator.setUser2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysTranslator.setUser2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_UserPSDEF(PSSysTranslator pSSysTranslator, PSDEField pSDEField) throws Exception {
        pSSysTranslator.setUserPSDEFId(pSDEField.getPSDEFieldId());
        pSSysTranslator.setUserPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ValuePSDEF(PSSysTranslator pSSysTranslator, PSDEField pSDEField) throws Exception {
        pSSysTranslator.setValuePSDEFId(pSDEField.getPSDEFieldId());
        pSSysTranslator.setValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSSysTranslator pSSysTranslator, PSModule pSModule) throws Exception {
        pSSysTranslator.setPSModuleId(pSModule.getPSModuleId());
        pSSysTranslator.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysTranslator pSSysTranslator, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysTranslator.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysTranslator.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysTranslator pSSysTranslator, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysTranslator.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysTranslator.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysTranslator pSSysTranslator, PSSystem pSSystem) throws Exception {
        pSSysTranslator.setPSSystemId(pSSystem.getPSSystemId());
        pSSysTranslator.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        if (bl) {
            if (pSSysTranslator.getCodeName() == null) {
                pSSysTranslator.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Translator", 25));
            }
            if (pSSysTranslator.getPSSysTranslatorName() == null) {
                pSSysTranslator.setPSSysTranslatorName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u503c\u8f6c\u6362\u5668", 25));
            }
            if (pSSysTranslator.getValidFlag() == null) {
                pSSysTranslator.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysTranslator, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysTranslator, bl);
        this.onFillEntityFullInfo_PSDE(pSSysTranslator, bl);
        this.onFillEntityFullInfo_KeyPSDEF(pSSysTranslator, bl);
        this.onFillEntityFullInfo_User2PSDEF(pSSysTranslator, bl);
        this.onFillEntityFullInfo_UserPSDEF(pSSysTranslator, bl);
        this.onFillEntityFullInfo_ValuePSDEF(pSSysTranslator, bl);
        this.onFillEntityFullInfo_PSModule(pSSysTranslator, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysTranslator, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysTranslator, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysTranslator, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        if (pSSysTranslator.isPSDEIdDirty()) {
            if (pSSysTranslator.getPSDEId() != null) {
                if (pSSysTranslator.getPSDEId() == null || pSSysTranslator.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysTranslator.getPSDE();
                    pSSysTranslator.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysTranslator.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_KeyPSDEF(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        if (pSSysTranslator.isKeyPSDEFIdDirty()) {
            if (pSSysTranslator.getKeyPSDEFId() != null) {
                if (pSSysTranslator.getKeyPSDEFId() == null || pSSysTranslator.getKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSSysTranslator.getKeyPSDEF();
                    pSSysTranslator.setKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysTranslator.setKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_User2PSDEF(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        if (pSSysTranslator.isUser2PSDEFIdDirty()) {
            if (pSSysTranslator.getUser2PSDEFId() != null) {
                if (pSSysTranslator.getUser2PSDEFId() == null || pSSysTranslator.getUser2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysTranslator.getUser2PSDEF();
                    pSSysTranslator.setUser2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysTranslator.setUser2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UserPSDEF(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        if (pSSysTranslator.isUserPSDEFIdDirty()) {
            if (pSSysTranslator.getUserPSDEFId() != null) {
                if (pSSysTranslator.getUserPSDEFId() == null || pSSysTranslator.getUserPSDEFName() == null) {
                    PSDEField pSDEField = pSSysTranslator.getUserPSDEF();
                    pSSysTranslator.setUserPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysTranslator.setUserPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ValuePSDEF(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        if (pSSysTranslator.isValuePSDEFIdDirty()) {
            if (pSSysTranslator.getValuePSDEFId() != null) {
                if (pSSysTranslator.getValuePSDEFId() == null || pSSysTranslator.getValuePSDEFName() == null) {
                    PSDEField pSDEField = pSSysTranslator.getValuePSDEF();
                    pSSysTranslator.setValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysTranslator.setValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysTranslator, bl);
    }

    public ArrayList<PSSysTranslator> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTranslator> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTranslator> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEYPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKeyPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKeyPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTranslator> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USER2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUser2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUser2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTranslator> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUserPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUserPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTranslator> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("VALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTranslator> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTranslator> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTranslator> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTranslator> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysTranslator> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysTranslator> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setPSCodeListId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysTranslatorServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setPSDEId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysTranslatorServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSDEFIELD_KEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByKeyPSDEF(pSDEField);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setKeyPSDEFId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByKeyPSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.internalRemoveByKeyPSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByKeyPSDEF(pSDEField);
        this.onBeforeRemoveByKeyPSDEF(pSDEField, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByUser2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSDEFIELD_USER2PSDEFID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByUser2PSDEF(pSDEField);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setUser2PSDEFId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByUser2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByUser2PSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.internalRemoveByUser2PSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByUser2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByUser2PSDEF(pSDEField);
        this.onBeforeRemoveByUser2PSDEF(pSDEField, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByUser2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByUserPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSDEFIELD_USERPSDEFID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByUserPSDEF(pSDEField);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setUserPSDEFId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByUserPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByUserPSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.internalRemoveByUserPSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByUserPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByUserPSDEF(pSDEField);
        this.onBeforeRemoveByUserPSDEF(pSDEField, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByUserPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSDEFIELD_VALUEPSDEFID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByValuePSDEF(pSDEField);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setValuePSDEFId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByValuePSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.internalRemoveByValuePSDEF(pSDEField2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByValuePSDEF(pSDEField);
        this.onBeforeRemoveByValuePSDEF(pSDEField, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSModule(pSModule);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setPSModuleId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysTranslatorServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setPSSysDynaModelId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysTranslatorServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTRANSLATOR_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSTRANSLATOR", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setPSSysSFPluginId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysTranslatorServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            PSSysTranslator pSSysTranslator2 = (PSSysTranslator)this.getDEModel().createEntity();
            pSSysTranslator2.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
            pSSysTranslator2.setPSSystemId(null);
            this.update(pSSysTranslator2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTranslatorServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysTranslatorServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysTranslatorServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTranslator> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysTranslator pSSysTranslator : arrayList) {
            this.remove(pSSysTranslator);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTranslator> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTranslator pSSysTranslator) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDEDataImpItemService)ServiceGlobal.getService(PSDEDataImpItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByExpPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByImpPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByOutPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysTranslator(pSSysTranslator);
        pSCoreSysServiceBase = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByOutPSSysTranslator(pSSysTranslator);
        super.onBeforeRemove(pSSysTranslator);
    }

    protected void replaceParentInfo(PSSysTranslator pSSysTranslator, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysTranslator, cloneSession);
        if (pSSysTranslator.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysTranslator.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysTranslator, (PSCodeList)iEntity);
        }
        if (pSSysTranslator.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysTranslator.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysTranslator, (PSDataEntity)iEntity);
        }
        if (pSSysTranslator.getKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysTranslator.getKeyPSDEFId())) != null) {
            this.onFillParentInfo_KeyPSDEF(pSSysTranslator, (PSDEField)iEntity);
        }
        if (pSSysTranslator.getUser2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysTranslator.getUser2PSDEFId())) != null) {
            this.onFillParentInfo_User2PSDEF(pSSysTranslator, (PSDEField)iEntity);
        }
        if (pSSysTranslator.getUserPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysTranslator.getUserPSDEFId())) != null) {
            this.onFillParentInfo_UserPSDEF(pSSysTranslator, (PSDEField)iEntity);
        }
        if (pSSysTranslator.getValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysTranslator.getValuePSDEFId())) != null) {
            this.onFillParentInfo_ValuePSDEF(pSSysTranslator, (PSDEField)iEntity);
        }
        if (pSSysTranslator.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysTranslator.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysTranslator, (PSModule)iEntity);
        }
        if (pSSysTranslator.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysTranslator.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysTranslator, (PSSysDynaModel)iEntity);
        }
        if (pSSysTranslator.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysTranslator.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysTranslator, (PSSysSFPlugin)iEntity);
        }
        if (pSSysTranslator.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysTranslator.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysTranslator, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysTranslator, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysTranslator, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFName(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorName(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TranslatorParams(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TranslatorTag(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TranslatorTag2(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TranslatorType(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFName(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFName(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFId(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFName(bl, pSSysTranslator, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysTranslator, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isCodeNameDirty() && !bl2 : !pSSysTranslator.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysTranslator.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysTranslator, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysTranslatorDEModel(), "CODENAME", string3, pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isCustomCodeDirty() : !pSSysTranslator.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysTranslator.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isCustomModeDirty() : !pSSysTranslator.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysTranslator.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_KeyPSDEFId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isKeyPSDEFIdDirty() : !pSSysTranslator.isKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFId_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFName(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isKeyPSDEFNameDirty() : !pSSysTranslator.isKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysTranslator.getKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFName_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isMemoDirty() : !pSSysTranslator.isMemoDirty()) {
            return null;
        }
        String string = pSSysTranslator.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSCodeListIdDirty() : !pSSysTranslator.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSDEIdDirty() : !pSSysTranslator.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSDENameDirty() : !pSSysTranslator.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSModuleIdDirty() : !pSSysTranslator.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSSysDynaModelIdDirty() : !pSSysTranslator.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSSysSFPluginIdDirty() : !pSSysTranslator.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSSystemIdDirty() : !pSSysTranslator.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSSysTranslatorIdDirty() && !bl2 : !pSSysTranslator.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSSysTranslatorId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTranslatorName(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isPSSysTranslatorNameDirty() && !bl2 : !pSSysTranslator.isPSSysTranslatorNameDirty()) {
            return null;
        }
        String string = pSSysTranslator.getPSSysTranslatorName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorName_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysTranslatorDEModel(), "PSSYSTRANSLATORNAME", string3, pSSysTranslator, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSTRANSLATORNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TranslatorParams(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isTranslatorParamsDirty() : !pSSysTranslator.isTranslatorParamsDirty()) {
            return null;
        }
        String string = pSSysTranslator.getTranslatorParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TranslatorParams_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRANSLATORPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TranslatorTag(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isTranslatorTagDirty() : !pSSysTranslator.isTranslatorTagDirty()) {
            return null;
        }
        String string = pSSysTranslator.getTranslatorTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TranslatorTag_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRANSLATORTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TranslatorTag2(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isTranslatorTag2Dirty() : !pSSysTranslator.isTranslatorTag2Dirty()) {
            return null;
        }
        String string = pSSysTranslator.getTranslatorTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TranslatorTag2_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRANSLATORTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TranslatorType(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isTranslatorTypeDirty() && !bl2 : !pSSysTranslator.isTranslatorTypeDirty()) {
            return null;
        }
        String string = pSSysTranslator.getTranslatorType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRANSLATORTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TranslatorType_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TRANSLATORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEFId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUser2PSDEFIdDirty() : !pSSysTranslator.isUser2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getUser2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFId_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEFName(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUser2PSDEFNameDirty() : !pSSysTranslator.isUser2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysTranslator.getUser2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFName_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUserCatDirty() : !pSSysTranslator.isUserCatDirty()) {
            return null;
        }
        String string = pSSysTranslator.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUserPSDEFIdDirty() : !pSSysTranslator.isUserPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getUserPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFId_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserPSDEFName(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUserPSDEFNameDirty() : !pSSysTranslator.isUserPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysTranslator.getUserPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFName_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUserTagDirty() : !pSSysTranslator.isUserTagDirty()) {
            return null;
        }
        String string = pSSysTranslator.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUserTag2Dirty() : !pSSysTranslator.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysTranslator.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUserTag3Dirty() : !pSSysTranslator.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysTranslator.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isUserTag4Dirty() : !pSSysTranslator.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysTranslator.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isValidFlagDirty() && !bl2 : !pSSysTranslator.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysTranslator.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysTranslator, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValuePSDEFId(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isValuePSDEFIdDirty() : !pSSysTranslator.isValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysTranslator.getValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFId_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValuePSDEFName(boolean bl, PSSysTranslator pSSysTranslator, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTranslator.isValuePSDEFNameDirty() : !pSSysTranslator.isValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysTranslator.getValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFName_Default(pSSysTranslator, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        super.onSyncEntity(pSSysTranslator, bl);
    }

    protected void onSyncIndexEntities(PSSysTranslator pSSysTranslator, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysTranslator, bl);
    }

    public Object getDataContextValue(PSSysTranslator pSSysTranslator, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysTranslator, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTranslator pSSysTranslator, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysTranslator, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRANSLATORPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TranslatorParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRANSLATORTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TranslatorTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRANSLATORTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TranslatorTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TRANSLATORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TranslatorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValuePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_KeyPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TranslatorParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRANSLATORPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TranslatorTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRANSLATORTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TranslatorTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRANSLATORTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TranslatorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TRANSLATORTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_User2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UserPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysTranslator pSSysTranslator) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysTranslator)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTranslator pSSysTranslator) throws Exception {
        super.onUpdateParent(pSSysTranslator);
    }

    @Override
    protected void exportCurXmlModel(PSSysTranslator pSSysTranslator, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTRANSLATOR");
        if (!bl) {
            pSSysTranslator.setCreateDate(null);
            pSSysTranslator.setCreateMan(null);
            pSSysTranslator.setPSSystemName(null);
            pSSysTranslator.setPSSysTranslatorId(null);
            pSSysTranslator.setUpdateDate(null);
            pSSysTranslator.setUpdateMan(null);
            super.exportCurXmlModel(pSSysTranslator, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTranslator pSSysTranslator, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTranslator, string);
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
            return "DER1N_PSSYSTRANSLATOR_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTRANSLATOR_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysTranslator pSSysTranslator) {
        if (!StringHelper.isNullOrEmpty((String)pSSysTranslator.getCodeName())) {
            return pSSysTranslator.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysTranslator.getPSSysTranslatorName())) {
            return pSSysTranslator.getPSSysTranslatorName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysTranslator.getCodeName())) {
            return pSSysTranslator.getCodeName();
        }
        return super.getModelV2Tag(pSSysTranslator);
    }

    @Override
    public boolean setModelV2Tag(PSSysTranslator pSSysTranslator, String string) {
        pSSysTranslator.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSTRANSLATORNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysTranslator pSSysTranslator, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTranslator.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTranslator, true);
        pSSysTranslator.set("CODENAME", string);
        if (this.select(pSSysTranslator, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysTranslator, true);
        return super.getModelV2Entity(pSSysTranslator, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTranslator pSSysTranslator, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysTranslator, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysTranslator pSSysTranslator, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Translator");
        defaultValueMap.put("PSSYSTRANSLATORNAME", "\u503c\u8f6c\u6362\u5668");
    }
}

