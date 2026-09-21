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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSequenceDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSequenceDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSequenceServiceBase
extends PSCoreSysServiceBase<PSSysSequence> {
    private static final Log log = LogFactory.getLog(PSSysSequenceServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysSequenceDEModel pSSysSequenceDEModel;
    private PSSysSequenceDAO pSSysSequenceDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService";
    }

    public PSSysSequenceDEModel getPSSysSequenceDEModel() {
        if (this.pSSysSequenceDEModel == null) {
            try {
                this.pSSysSequenceDEModel = (PSSysSequenceDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSequenceDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSequenceDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSequenceDEModel();
    }

    public PSSysSequenceDAO getPSSysSequenceDAO() {
        if (this.pSSysSequenceDAO == null) {
            try {
                this.pSSysSequenceDAO = (PSSysSequenceDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSequenceDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSequenceDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSequenceDAO();
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

    protected void onFillParentInfo(PSSysSequence pSSysSequence, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysSequence, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSDEFIELD_KEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_KeyPSDEF(pSSysSequence, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSDEFIELD_TIMEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TimePSDEF(pSSysSequence, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSDEFIELD_TYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TypePSDEF(pSSysSequence, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSDEFIELD_USER2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_User2PSDEF(pSSysSequence, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSDEFIELD_USERPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_UserPSDEF(pSSysSequence, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSDEFIELD_VALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ValuePSDEF(pSSysSequence, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysSequence, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysSequence, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysSequence, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEQUENCE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysSequence, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSequence, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysSequence pSSysSequence, PSDataEntity pSDataEntity) throws Exception {
        pSSysSequence.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysSequence.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_KeyPSDEF(PSSysSequence pSSysSequence, PSDEField pSDEField) throws Exception {
        pSSysSequence.setKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysSequence.setKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TimePSDEF(PSSysSequence pSSysSequence, PSDEField pSDEField) throws Exception {
        pSSysSequence.setTimePSDEFId(pSDEField.getPSDEFieldId());
        pSSysSequence.setTimePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TypePSDEF(PSSysSequence pSSysSequence, PSDEField pSDEField) throws Exception {
        pSSysSequence.setTypePSDEFId(pSDEField.getPSDEFieldId());
        pSSysSequence.setTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_User2PSDEF(PSSysSequence pSSysSequence, PSDEField pSDEField) throws Exception {
        pSSysSequence.setUser2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysSequence.setUser2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_UserPSDEF(PSSysSequence pSSysSequence, PSDEField pSDEField) throws Exception {
        pSSysSequence.setUserPSDEFId(pSDEField.getPSDEFieldId());
        pSSysSequence.setUserPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ValuePSDEF(PSSysSequence pSSysSequence, PSDEField pSDEField) throws Exception {
        pSSysSequence.setValuePSDEFId(pSDEField.getPSDEFieldId());
        pSSysSequence.setValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSSysSequence pSSysSequence, PSModule pSModule) throws Exception {
        pSSysSequence.setPSModuleId(pSModule.getPSModuleId());
        pSSysSequence.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysSequence pSSysSequence, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysSequence.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysSequence.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysSequence pSSysSequence, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysSequence.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysSequence.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysSequence pSSysSequence, PSSystem pSSystem) throws Exception {
        pSSysSequence.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSequence.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (bl) {
            if (pSSysSequence.getCodeName() == null) {
                pSSysSequence.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Sequence", 25));
            }
            if (pSSysSequence.getPSSysSequenceName() == null) {
                pSSysSequence.setPSSysSequenceName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5e8f\u5217", 25));
            }
            if (pSSysSequence.getValidFlag() == null) {
                pSSysSequence.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysSequence, bl);
        this.onFillEntityFullInfo_PSDE(pSSysSequence, bl);
        this.onFillEntityFullInfo_KeyPSDEF(pSSysSequence, bl);
        this.onFillEntityFullInfo_TimePSDEF(pSSysSequence, bl);
        this.onFillEntityFullInfo_TypePSDEF(pSSysSequence, bl);
        this.onFillEntityFullInfo_User2PSDEF(pSSysSequence, bl);
        this.onFillEntityFullInfo_UserPSDEF(pSSysSequence, bl);
        this.onFillEntityFullInfo_ValuePSDEF(pSSysSequence, bl);
        this.onFillEntityFullInfo_PSModule(pSSysSequence, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysSequence, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysSequence, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysSequence, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (pSSysSequence.isPSDEIdDirty()) {
            if (pSSysSequence.getPSDEId() != null) {
                if (pSSysSequence.getPSDEId() == null || pSSysSequence.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysSequence.getPSDE();
                    pSSysSequence.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysSequence.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_KeyPSDEF(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (pSSysSequence.isKeyPSDEFIdDirty()) {
            if (pSSysSequence.getKeyPSDEFId() != null) {
                if (pSSysSequence.getKeyPSDEFId() == null || pSSysSequence.getKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSSysSequence.getKeyPSDEF();
                    pSSysSequence.setKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysSequence.setKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TimePSDEF(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (pSSysSequence.isTimePSDEFIdDirty()) {
            if (pSSysSequence.getTimePSDEFId() != null) {
                if (pSSysSequence.getTimePSDEFId() == null || pSSysSequence.getTimePSDEFName() == null) {
                    PSDEField pSDEField = pSSysSequence.getTimePSDEF();
                    pSSysSequence.setTimePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysSequence.setTimePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TypePSDEF(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (pSSysSequence.isTypePSDEFIdDirty()) {
            if (pSSysSequence.getTypePSDEFId() != null) {
                if (pSSysSequence.getTypePSDEFId() == null || pSSysSequence.getTypePSDEFName() == null) {
                    PSDEField pSDEField = pSSysSequence.getTypePSDEF();
                    pSSysSequence.setTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysSequence.setTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_User2PSDEF(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (pSSysSequence.isUser2PSDEFIdDirty()) {
            if (pSSysSequence.getUser2PSDEFId() != null) {
                if (pSSysSequence.getUser2PSDEFId() == null || pSSysSequence.getUser2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysSequence.getUser2PSDEF();
                    pSSysSequence.setUser2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysSequence.setUser2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UserPSDEF(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (pSSysSequence.isUserPSDEFIdDirty()) {
            if (pSSysSequence.getUserPSDEFId() != null) {
                if (pSSysSequence.getUserPSDEFId() == null || pSSysSequence.getUserPSDEFName() == null) {
                    PSDEField pSDEField = pSSysSequence.getUserPSDEF();
                    pSSysSequence.setUserPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysSequence.setUserPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ValuePSDEF(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        if (pSSysSequence.isValuePSDEFIdDirty()) {
            if (pSSysSequence.getValuePSDEFId() != null) {
                if (pSSysSequence.getValuePSDEFId() == null || pSSysSequence.getValuePSDEFName() == null) {
                    PSDEField pSDEField = pSSysSequence.getValuePSDEF();
                    pSSysSequence.setValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysSequence.setValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysSequence pSSysSequence, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysSequence pSSysSequence, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysSequence pSSysSequence, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysSequence pSSysSequence, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSequence, bl);
    }

    public ArrayList<PSSysSequence> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTimePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTimePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIMEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTimePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTimePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSequence> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSequence> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSequence> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysSequence> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysSequence> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSSysSequence> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setPSDEId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysSequenceServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysSequenceServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSDEFIELD_KEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByKeyPSDEF(pSDEField);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setKeyPSDEFId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByKeyPSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.internalRemoveByKeyPSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.onAfterRemoveByKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByKeyPSDEF(pSDEField);
        this.onBeforeRemoveByKeyPSDEF(pSDEField, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByTimePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSDEFIELD_TIMEPSDEFID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByTimePSDEF(pSDEField);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setTimePSDEFId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByTimePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByTimePSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.internalRemoveByTimePSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.onAfterRemoveByTimePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByTimePSDEF(pSDEField);
        this.onBeforeRemoveByTimePSDEF(pSDEField, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByTimePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTimePSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTimePSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSDEFIELD_TYPEPSDEFID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByTypePSDEF(pSDEField);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setTypePSDEFId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByTypePSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.internalRemoveByTypePSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.onAfterRemoveByTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByTypePSDEF(pSDEField);
        this.onBeforeRemoveByTypePSDEF(pSDEField, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTypePSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTypePSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByUser2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSDEFIELD_USER2PSDEFID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByUser2PSDEF(pSDEField);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setUser2PSDEFId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByUser2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByUser2PSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.internalRemoveByUser2PSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.onAfterRemoveByUser2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByUser2PSDEF(pSDEField);
        this.onBeforeRemoveByUser2PSDEF(pSDEField, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByUser2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByUserPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSDEFIELD_USERPSDEFID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByUserPSDEF(pSDEField);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setUserPSDEFId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByUserPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByUserPSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.internalRemoveByUserPSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.onAfterRemoveByUserPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByUserPSDEF(pSDEField);
        this.onBeforeRemoveByUserPSDEF(pSDEField, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByUserPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSDEFIELD_VALUEPSDEFID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByValuePSDEF(pSDEField);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setValuePSDEFId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByValuePSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.internalRemoveByValuePSDEF(pSDEField2);
                PSSysSequenceServiceBase.this.onAfterRemoveByValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByValuePSDEF(pSDEField);
        this.onBeforeRemoveByValuePSDEF(pSDEField, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByValuePSDEF(PSDEField pSDEField, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSModule(pSModule);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setPSModuleId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysSequenceServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysSequenceServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setPSSysDynaModelId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSequenceServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysSequenceServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEQUENCE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSSEQUENCE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setPSSysSFPluginId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysSequenceServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysSequenceServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysSequence pSSysSequence : arrayList) {
            PSSysSequence pSSysSequence2 = (PSSysSequence)this.getDEModel().createEntity();
            pSSysSequence2.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
            pSSysSequence2.setPSSystemId(null);
            this.update(pSSysSequence2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSequenceServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysSequenceServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysSequenceServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSequence> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysSequence pSSysSequence : arrayList) {
            this.remove((IEntity)pSSysSequence);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSequence> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSequence pSSysSequence) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSequence(pSSysSequence);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSequence(pSSysSequence);
        pSCoreSysServiceBase = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELNParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSequeue(pSSysSequence);
        super.onBeforeRemove(pSSysSequence);
    }

    protected void replaceParentInfo(PSSysSequence pSSysSequence, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSequence, cloneSession);
        if (pSSysSequence.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysSequence.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysSequence, (PSDataEntity)iEntity);
        }
        if (pSSysSequence.getKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysSequence.getKeyPSDEFId())) != null) {
            this.onFillParentInfo_KeyPSDEF(pSSysSequence, (PSDEField)iEntity);
        }
        if (pSSysSequence.getTimePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysSequence.getTimePSDEFId())) != null) {
            this.onFillParentInfo_TimePSDEF(pSSysSequence, (PSDEField)iEntity);
        }
        if (pSSysSequence.getTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysSequence.getTypePSDEFId())) != null) {
            this.onFillParentInfo_TypePSDEF(pSSysSequence, (PSDEField)iEntity);
        }
        if (pSSysSequence.getUser2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysSequence.getUser2PSDEFId())) != null) {
            this.onFillParentInfo_User2PSDEF(pSSysSequence, (PSDEField)iEntity);
        }
        if (pSSysSequence.getUserPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysSequence.getUserPSDEFId())) != null) {
            this.onFillParentInfo_UserPSDEF(pSSysSequence, (PSDEField)iEntity);
        }
        if (pSSysSequence.getValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysSequence.getValuePSDEFId())) != null) {
            this.onFillParentInfo_ValuePSDEF(pSSysSequence, (PSDEField)iEntity);
        }
        if (pSSysSequence.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysSequence.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysSequence, (PSModule)iEntity);
        }
        if (pSSysSequence.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysSequence.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysSequence, (PSSysDynaModel)iEntity);
        }
        if (pSSysSequence.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysSequence.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysSequence, (PSSysSFPlugin)iEntity);
        }
        if (pSSysSequence.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysSequence.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysSequence, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSequence, bl);
        pSSysSequence.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysSequence, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtFormatParams(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSequenceId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSequenceName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SequenceFormat(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SequenceParams(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SequenceTag(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SequenceTag2(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SequenceType(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeFormat(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimePSDEFId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimePSDEFName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypePSDEFId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypePSDEFName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFId(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValuePSDEFName(bl, pSSysSequence, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSequence, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isCodeNameDirty() && !bl2 : !pSSysSequence.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysSequence, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysSequenceDEModel(), "CODENAME", string3, pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isCustomCodeDirty() : !pSSysSequence.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysSequence.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isCustomModeDirty() : !pSSysSequence.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysSequence.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_ExtFormatParams(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isExtFormatParamsDirty() : !pSSysSequence.isExtFormatParamsDirty()) {
            return null;
        }
        String string = pSSysSequence.getExtFormatParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtFormatParams_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTFORMATPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isKeyPSDEFIdDirty() : !pSSysSequence.isKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_KeyPSDEFName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isKeyPSDEFNameDirty() : !pSSysSequence.isKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFName_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isMaxValueDirty() : !pSSysSequence.isMaxValueDirty()) {
            return null;
        }
        Integer n = pSSysSequence.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxValue_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isMemoDirty() : !pSSysSequence.isMemoDirty()) {
            return null;
        }
        String string = pSSysSequence.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isMinValueDirty() : !pSSysSequence.isMinValueDirty()) {
            return null;
        }
        Integer n = pSSysSequence.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinValue_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSDEIdDirty() : !pSSysSequence.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSDENameDirty() : !pSSysSequence.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSModuleIdDirty() : !pSSysSequence.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSSysDynaModelIdDirty() : !pSSysSequence.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSequenceId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSSysSequenceIdDirty() && !bl2 : !pSSysSequence.isPSSysSequenceIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSSysSequenceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEQUENCEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSequenceId_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEQUENCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSequenceName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSSysSequenceNameDirty() && !bl2 : !pSSysSequence.isPSSysSequenceNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSSysSequenceName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEQUENCENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSequenceName_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEQUENCENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysSequenceDEModel(), "PSSYSSEQUENCENAME", string3, pSSysSequence, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSEQUENCENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSSysSFPluginIdDirty() : !pSSysSequence.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isPSSystemIdDirty() : !pSSysSequence.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_SequenceFormat(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isSequenceFormatDirty() : !pSSysSequence.isSequenceFormatDirty()) {
            return null;
        }
        String string = pSSysSequence.getSequenceFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SequenceFormat_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEQUENCEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SequenceParams(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isSequenceParamsDirty() : !pSSysSequence.isSequenceParamsDirty()) {
            return null;
        }
        String string = pSSysSequence.getSequenceParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SequenceParams_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEQUENCEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SequenceTag(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isSequenceTagDirty() : !pSSysSequence.isSequenceTagDirty()) {
            return null;
        }
        String string = pSSysSequence.getSequenceTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SequenceTag_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEQUENCETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SequenceTag2(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isSequenceTag2Dirty() : !pSSysSequence.isSequenceTag2Dirty()) {
            return null;
        }
        String string = pSSysSequence.getSequenceTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SequenceTag2_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEQUENCETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SequenceType(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isSequenceTypeDirty() && !bl2 : !pSSysSequence.isSequenceTypeDirty()) {
            return null;
        }
        String string = pSSysSequence.getSequenceType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEQUENCETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SequenceType_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEQUENCETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeFormat(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isTimeFormatDirty() : !pSSysSequence.isTimeFormatDirty()) {
            return null;
        }
        String string = pSSysSequence.getTimeFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimeFormat_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimePSDEFId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isTimePSDEFIdDirty() : !pSSysSequence.isTimePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getTimePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimePSDEFId_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimePSDEFName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isTimePSDEFNameDirty() : !pSSysSequence.isTimePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getTimePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimePSDEFName_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypePSDEFId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isTypePSDEFIdDirty() : !pSSysSequence.isTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypePSDEFId_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypePSDEFName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isTypePSDEFNameDirty() : !pSSysSequence.isTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypePSDEFName_Default((IEntity)pSSysSequence, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEFId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUser2PSDEFIdDirty() : !pSSysSequence.isUser2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getUser2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_User2PSDEFName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUser2PSDEFNameDirty() : !pSSysSequence.isUser2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getUser2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFName_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUserCatDirty() : !pSSysSequence.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSequence.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUserPSDEFIdDirty() : !pSSysSequence.isUserPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getUserPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUserPSDEFNameDirty() : !pSSysSequence.isUserPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getUserPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFName_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUserTagDirty() : !pSSysSequence.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSequence.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUserTag2Dirty() : !pSSysSequence.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSequence.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUserTag3Dirty() : !pSSysSequence.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSequence.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isUserTag4Dirty() : !pSSysSequence.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSequence.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isValidFlagDirty() && !bl2 : !pSSysSequence.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysSequence.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValuePSDEFId(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isValuePSDEFIdDirty() : !pSSysSequence.isValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysSequence.getValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFId_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValuePSDEFName(boolean bl, PSSysSequence pSSysSequence, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSequence.isValuePSDEFNameDirty() : !pSSysSequence.isValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysSequence.getValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValuePSDEFName_Default((IEntity)pSSysSequence, bl2, bl3);
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

    protected void onSyncEntity(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSequence, bl);
    }

    protected void onSyncIndexEntities(PSSysSequence pSSysSequence, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSequence, bl);
    }

    public Object getDataContextValue(PSSysSequence pSSysSequence, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSequence, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSequence pSSysSequence, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSequence, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"EXTFORMATPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtFormatParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SEQUENCEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SequenceFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEQUENCEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SequenceParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEQUENCETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SequenceTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEQUENCETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SequenceTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEQUENCETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SequenceType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ExtFormatParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTFORMATPARAMS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_MaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysSequenceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSequenceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SequenceFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEQUENCEFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SequenceParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEQUENCEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SequenceTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEQUENCETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SequenceTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEQUENCETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SequenceType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEQUENCETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimeFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysSequence pSSysSequence) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysSequence)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSequence pSSysSequence) throws Exception {
        super.onUpdateParent((IEntity)pSSysSequence);
    }

    @Override
    protected void exportCurXmlModel(PSSysSequence pSSysSequence, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSEQUENCE");
        if (!bl) {
            pSSysSequence.setCreateDate(null);
            pSSysSequence.setCreateMan(null);
            pSSysSequence.setPSSysSequenceId(null);
            pSSysSequence.setPSSystemName(null);
            pSSysSequence.setUpdateDate(null);
            pSSysSequence.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSequence, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSequence pSSysSequence, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSequence, string);
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
            return "DER1N_PSSYSSEQUENCE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEQUENCE_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysSequence pSSysSequence) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSequence.getCodeName())) {
            return pSSysSequence.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSequence.getPSSysSequenceName())) {
            return pSSysSequence.getPSSysSequenceName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSequence.getCodeName())) {
            return pSSysSequence.getCodeName();
        }
        return super.getModelV2Tag(pSSysSequence);
    }

    @Override
    public boolean setModelV2Tag(PSSysSequence pSSysSequence, String string) {
        pSSysSequence.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSSEQUENCENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSequence pSSysSequence, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSequence.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSequence, true);
        pSSysSequence.set("CODENAME", string);
        if (this.select(pSSysSequence, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSequence, true);
        return super.getModelV2Entity(pSSysSequence, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSequence pSSysSequence, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSequence, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysSequence pSSysSequence, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Sequence");
        defaultValueMap.put("PSSYSSEQUENCENAME", "\u5e8f\u5217");
    }
}

