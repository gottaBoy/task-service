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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetService;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysMsgTargetDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMsgTargetDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTarget;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMsgTargetServiceBase
extends PSCoreSysServiceBase<PSSysMsgTarget> {
    private static final Log log = LogFactory.getLog(PSSysMsgTargetServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysMsgTargetDEModel pSSysMsgTargetDEModel;
    private PSSysMsgTargetDAO pSSysMsgTargetDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService";
    }

    public PSSysMsgTargetDEModel getPSSysMsgTargetDEModel() {
        if (this.pSSysMsgTargetDEModel == null) {
            try {
                this.pSSysMsgTargetDEModel = (PSSysMsgTargetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMsgTargetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMsgTargetDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysMsgTargetDEModel();
    }

    public PSSysMsgTargetDAO getPSSysMsgTargetDAO() {
        if (this.pSSysMsgTargetDAO == null) {
            try {
                this.pSSysMsgTargetDAO = (PSSysMsgTargetDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysMsgTargetDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMsgTargetDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysMsgTargetDAO();
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

    protected void onFillParentInfo(PSSysMsgTarget pSSysMsgTarget, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysMsgTarget, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSSysMsgTarget, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSDEFIELD_TARGETPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TargetPSDEF(pSSysMsgTarget, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSDEFIELD_TARGETTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TargetTypePSDEF(pSSysMsgTarget, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSDEFIELD_USER2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_User2PSDEF(pSSysMsgTarget, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSDEFIELD_USERPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_UserPSDEF(pSSysMsgTarget, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysMsgTarget, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysMsgTarget, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysMsgTarget, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysMsgTarget, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMSGTARGET_PSSYSUTILDE_PSSYSUTILDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService", (SessionFactory)this.getSessionFactory());
            PSSysUtilDE pSSysUtilDE = (PSSysUtilDE)iService.getDEModel().createEntity();
            pSSysUtilDE.set("PSSYSUTILDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUtilDE);
            } else {
                iService.get(pSSysUtilDE);
            }
            this.onFillParentInfo_PSSysUtilDE(pSSysMsgTarget, pSSysUtilDE);
            return;
        }
        super.onFillParentInfo(pSSysMsgTarget, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysMsgTarget pSSysMsgTarget, PSDataEntity pSDataEntity) throws Exception {
        pSSysMsgTarget.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysMsgTarget.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSSysMsgTarget pSSysMsgTarget, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysMsgTarget.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysMsgTarget.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_TargetPSDEF(PSSysMsgTarget pSSysMsgTarget, PSDEField pSDEField) throws Exception {
        pSSysMsgTarget.setTargetPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTarget.setTargetPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TargetTypePSDEF(PSSysMsgTarget pSSysMsgTarget, PSDEField pSDEField) throws Exception {
        pSSysMsgTarget.setTargetTypePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTarget.setTargetTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_User2PSDEF(PSSysMsgTarget pSSysMsgTarget, PSDEField pSDEField) throws Exception {
        pSSysMsgTarget.setUser2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTarget.setUser2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_UserPSDEF(PSSysMsgTarget pSSysMsgTarget, PSDEField pSDEField) throws Exception {
        pSSysMsgTarget.setUserPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMsgTarget.setUserPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSSysMsgTarget pSSysMsgTarget, PSModule pSModule) throws Exception {
        pSSysMsgTarget.setPSModuleId(pSModule.getPSModuleId());
        pSSysMsgTarget.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysMsgTarget pSSysMsgTarget, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysMsgTarget.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysMsgTarget.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysMsgTarget pSSysMsgTarget, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysMsgTarget.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysMsgTarget.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysMsgTarget pSSysMsgTarget, PSSystem pSSystem) throws Exception {
        pSSysMsgTarget.setPSSystemId(pSSystem.getPSSystemId());
        pSSysMsgTarget.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUtilDE(PSSysMsgTarget pSSysMsgTarget, PSSysUtilDE pSSysUtilDE) throws Exception {
        pSSysMsgTarget.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
        pSSysMsgTarget.setPSSysUtilDEName(pSSysUtilDE.getPSSysUtilDEName());
    }

    protected void onFillEntityFullInfo(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        if (bl) {
            if (pSSysMsgTarget.getCodeName() == null) {
                pSSysMsgTarget.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "MsgTarget", 25));
            }
            if (pSSysMsgTarget.getMsgTargetType() == null) {
                pSSysMsgTarget.setMsgTargetType((String)this.getDefaultValue(this.getWebContext(), "", "RUNTIME", 25));
            }
            if (pSSysMsgTarget.getPSSysMsgTargetName() == null) {
                pSSysMsgTarget.setPSSysMsgTargetName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6d88\u606f\u76ee\u6807", 25));
            }
        }
        super.onFillEntityFullInfo(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_PSDE(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_PSDEDS(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_TargetPSDEF(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_TargetTypePSDEF(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_User2PSDEF(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_UserPSDEF(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_PSModule(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysMsgTarget, bl);
        this.onFillEntityFullInfo_PSSysUtilDE(pSSysMsgTarget, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        if (pSSysMsgTarget.isPSDEIdDirty()) {
            if (pSSysMsgTarget.getPSDEId() != null) {
                if (pSSysMsgTarget.getPSDEId() == null || pSSysMsgTarget.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysMsgTarget.getPSDE();
                    pSSysMsgTarget.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysMsgTarget.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TargetPSDEF(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        if (pSSysMsgTarget.isTargetPSDEFIdDirty()) {
            if (pSSysMsgTarget.getTargetPSDEFId() != null) {
                if (pSSysMsgTarget.getTargetPSDEFId() == null || pSSysMsgTarget.getTargetPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTarget.getTargetPSDEF();
                    pSSysMsgTarget.setTargetPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTarget.setTargetPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TargetTypePSDEF(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        if (pSSysMsgTarget.isTargetTypePSDEFIdDirty()) {
            if (pSSysMsgTarget.getTargetTypePSDEFId() != null) {
                if (pSSysMsgTarget.getTargetTypePSDEFId() == null || pSSysMsgTarget.getTargetTypePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTarget.getTargetTypePSDEF();
                    pSSysMsgTarget.setTargetTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTarget.setTargetTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_User2PSDEF(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        if (pSSysMsgTarget.isUser2PSDEFIdDirty()) {
            if (pSSysMsgTarget.getUser2PSDEFId() != null) {
                if (pSSysMsgTarget.getUser2PSDEFId() == null || pSSysMsgTarget.getUser2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTarget.getUser2PSDEF();
                    pSSysMsgTarget.setUser2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTarget.setUser2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UserPSDEF(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        if (pSSysMsgTarget.isUserPSDEFIdDirty()) {
            if (pSSysMsgTarget.getUserPSDEFId() != null) {
                if (pSSysMsgTarget.getUserPSDEFId() == null || pSSysMsgTarget.getUserPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMsgTarget.getUserPSDEF();
                    pSSysMsgTarget.setUserPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMsgTarget.setUserPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUtilDE(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysMsgTarget, bl);
    }

    public ArrayList<PSSysMsgTarget> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTargetPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTargetPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TARGETPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTargetPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTargetPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTarget> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTargetTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTargetTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TARGETTYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTargetTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTargetTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMsgTarget> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUser2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByUser2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUserPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByUserPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMsgTarget> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, "", -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, string, -1);
    }

    public ArrayList<PSSysMsgTarget> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUTILDEID", (Object)pSSysUtilDEBase.getPSSysUtilDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUtilDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUtilDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setPSDEId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysMsgTargetServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setPSDEDSId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSSysMsgTargetServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByTargetPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSDEFIELD_TARGETPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByTargetPSDEF(pSDEField);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setTargetPSDEFId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByTargetPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByTargetPSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.internalRemoveByTargetPSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByTargetPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByTargetPSDEF(pSDEField);
        this.onBeforeRemoveByTargetPSDEF(pSDEField, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByTargetPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTargetPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTargetPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByTargetTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSDEFIELD_TARGETTYPEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByTargetTypePSDEF(pSDEField);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setTargetTypePSDEFId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByTargetTypePSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.internalRemoveByTargetTypePSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByTargetTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByTargetTypePSDEF(pSDEField);
        this.onBeforeRemoveByTargetTypePSDEF(pSDEField, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByTargetTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTargetTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTargetTypePSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByUser2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSDEFIELD_USER2PSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByUser2PSDEF(pSDEField);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setUser2PSDEFId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByUser2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByUser2PSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.internalRemoveByUser2PSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByUser2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByUser2PSDEF(pSDEField);
        this.onBeforeRemoveByUser2PSDEF(pSDEField, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByUser2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByUserPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSDEFIELD_USERPSDEFID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByUserPSDEF(pSDEField);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setUserPSDEFId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByUserPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByUserPSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.internalRemoveByUserPSDEF(pSDEField2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByUserPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByUserPSDEF(pSDEField);
        this.onBeforeRemoveByUserPSDEF(pSDEField, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByUserPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEF(PSDEField pSDEField, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSModule(pSModule);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setPSModuleId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysMsgTargetServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setPSSysDynaModelId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysMsgTargetServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setPSSysSFPluginId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysMsgTargetServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setPSSystemId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysMsgTargetServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUTILDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUtilDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMSGTARGET_PSSYSUTILDE_PSSYSUTILDEID", "", iDataEntityModel.getName(), "PSSYSMSGTARGET", iDataEntityModel.getDataInfo(pSSysUtilDE), arrayList.get(0)));
        }
    }

    public void resetPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            PSSysMsgTarget pSSysMsgTarget2 = (PSSysMsgTarget)this.getDEModel().createEntity();
            pSSysMsgTarget2.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
            pSSysMsgTarget2.setPSSysUtilDEId(null);
            this.update(pSSysMsgTarget2);
        }
    }

    public void removeByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        final PSSysUtilDE pSSysUtilDE2 = pSSysUtilDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMsgTargetServiceBase.this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSSysMsgTargetServiceBase.this.internalRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSSysMsgTargetServiceBase.this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void internalRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysMsgTarget> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
        for (PSSysMsgTarget pSSysMsgTarget : arrayList) {
            this.remove(pSSysMsgTarget);
        }
        this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSSysMsgTarget> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysMsgTarget pSSysMsgTarget) throws Exception {
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        pSDENotifyTargetService.testRemoveByPSSysMsgTarget(pSSysMsgTarget);
        super.onBeforeRemove(pSSysMsgTarget);
    }

    protected void replaceParentInfo(PSSysMsgTarget pSSysMsgTarget, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysMsgTarget, cloneSession);
        if (pSSysMsgTarget.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysMsgTarget.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysMsgTarget, (PSDataEntity)iEntity);
        }
        if (pSSysMsgTarget.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysMsgTarget.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSSysMsgTarget, (PSDEDataSet)iEntity);
        }
        if (pSSysMsgTarget.getTargetPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTarget.getTargetPSDEFId())) != null) {
            this.onFillParentInfo_TargetPSDEF(pSSysMsgTarget, (PSDEField)iEntity);
        }
        if (pSSysMsgTarget.getTargetTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTarget.getTargetTypePSDEFId())) != null) {
            this.onFillParentInfo_TargetTypePSDEF(pSSysMsgTarget, (PSDEField)iEntity);
        }
        if (pSSysMsgTarget.getUser2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTarget.getUser2PSDEFId())) != null) {
            this.onFillParentInfo_User2PSDEF(pSSysMsgTarget, (PSDEField)iEntity);
        }
        if (pSSysMsgTarget.getUserPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMsgTarget.getUserPSDEFId())) != null) {
            this.onFillParentInfo_UserPSDEF(pSSysMsgTarget, (PSDEField)iEntity);
        }
        if (pSSysMsgTarget.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysMsgTarget.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysMsgTarget, (PSModule)iEntity);
        }
        if (pSSysMsgTarget.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysMsgTarget.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysMsgTarget, (PSSysDynaModel)iEntity);
        }
        if (pSSysMsgTarget.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysMsgTarget.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysMsgTarget, (PSSysSFPlugin)iEntity);
        }
        if (pSSysMsgTarget.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysMsgTarget.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysMsgTarget, (PSSystem)iEntity);
        }
        if (pSSysMsgTarget.getPSSysUtilDEId() != null && (iEntity = cloneSession.getEntity("PSSYSUTILDE", (Object)pSSysMsgTarget.getPSSysUtilDEId())) != null) {
            this.onFillParentInfo_PSSysUtilDE(pSSysMsgTarget, (PSSysUtilDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysMsgTarget, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysMsgTarget, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTargetParams(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTargetTag(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTargetTag2(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgTargetType(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTargetId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTargetName(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUtilDEId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetPSDEFId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetPSDEFName(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetTypePSDEFId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetTypePSDEFName(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEFName(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFId(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEFName(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysMsgTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysMsgTarget, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isCodeNameDirty() && !bl2 : !pSSysMsgTarget.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysMsgTarget, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysMsgTargetDEModel(), "CODENAME", string3, pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isCustomCodeDirty() : !pSSysMsgTarget.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isCustomModeDirty() : !pSSysMsgTarget.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysMsgTarget.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isMemoDirty() : !pSSysMsgTarget.isMemoDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_MsgTargetParams(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isMsgTargetParamsDirty() : !pSSysMsgTarget.isMsgTargetParamsDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getMsgTargetParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTargetParams_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTARGETPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTargetTag(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isMsgTargetTagDirty() : !pSSysMsgTarget.isMsgTargetTagDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getMsgTargetTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTargetTag_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTARGETTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTargetTag2(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isMsgTargetTag2Dirty() : !pSSysMsgTarget.isMsgTargetTag2Dirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getMsgTargetTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTargetTag2_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTARGETTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgTargetType(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isMsgTargetTypeDirty() && !bl2 : !pSSysMsgTarget.isMsgTargetTypeDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getMsgTargetType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTARGETTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgTargetType_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTARGETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSDEDSIdDirty() : !pSSysMsgTarget.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSDEIdDirty() : !pSSysMsgTarget.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSDENameDirty() : !pSSysMsgTarget.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSModuleIdDirty() : !pSSysMsgTarget.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSSysDynaModelIdDirty() : !pSSysMsgTarget.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgTargetId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSSysMsgTargetIdDirty() && !bl2 : !pSSysMsgTarget.isPSSysMsgTargetIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSSysMsgTargetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTARGETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTargetId_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTARGETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgTargetName(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSSysMsgTargetNameDirty() && !bl2 : !pSSysMsgTarget.isPSSysMsgTargetNameDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSSysMsgTargetName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTARGETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTargetName_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTARGETNAME");
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
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysMsgTargetDEModel(), "PSSYSMSGTARGETNAME", string3, pSSysMsgTarget, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSMSGTARGETNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSSysSFPluginIdDirty() : !pSSysMsgTarget.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSSystemIdDirty() : !pSSysMsgTarget.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUtilDEId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isPSSysUtilDEIdDirty() : !pSSysMsgTarget.isPSSysUtilDEIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getPSSysUtilDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUtilDEId_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUTILDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetPSDEFId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isTargetPSDEFIdDirty() : !pSSysMsgTarget.isTargetPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getTargetPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetPSDEFId_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetPSDEFName(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isTargetPSDEFNameDirty() : !pSSysMsgTarget.isTargetPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getTargetPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetPSDEFName_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetTypePSDEFId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isTargetTypePSDEFIdDirty() : !pSSysMsgTarget.isTargetTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getTargetTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetTypePSDEFId_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetTypePSDEFName(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isTargetTypePSDEFNameDirty() : !pSSysMsgTarget.isTargetTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getTargetTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetTypePSDEFName_Default(pSSysMsgTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEFId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUser2PSDEFIdDirty() : !pSSysMsgTarget.isUser2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUser2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_User2PSDEFName(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUser2PSDEFNameDirty() : !pSSysMsgTarget.isUser2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUser2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEFName_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUserCatDirty() : !pSSysMsgTarget.isUserCatDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFId(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUserPSDEFIdDirty() : !pSSysMsgTarget.isUserPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUserPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFId_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEFName(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUserPSDEFNameDirty() : !pSSysMsgTarget.isUserPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUserPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEFName_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUserTagDirty() : !pSSysMsgTarget.isUserTagDirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUserTag2Dirty() : !pSSysMsgTarget.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUserTag3Dirty() : !pSSysMsgTarget.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isUserTag4Dirty() : !pSSysMsgTarget.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysMsgTarget.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysMsgTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysMsgTarget pSSysMsgTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMsgTarget.isValidFlagDirty() && !bl2 : !pSSysMsgTarget.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysMsgTarget.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysMsgTarget, bl2, bl3);
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

    protected void onSyncEntity(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        super.onSyncEntity(pSSysMsgTarget, bl);
    }

    protected void onSyncIndexEntities(PSSysMsgTarget pSSysMsgTarget, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysMsgTarget, bl);
    }

    public Object getDataContextValue(PSSysMsgTarget pSSysMsgTarget, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysMsgTarget, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysMsgTarget pSSysMsgTarget, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysMsgTarget, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTARGETPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTargetParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTARGETTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTargetTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTARGETTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTargetTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGTARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgTargetType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTARGETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTargetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTARGETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTargetName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetTypePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MsgTargetParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTARGETPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTargetTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTARGETTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTargetTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTARGETTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MsgTargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGTARGETTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSSysMsgTargetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTARGETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTargetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTARGETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUtilDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUtilDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysMsgTarget pSSysMsgTarget) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysMsgTarget)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysMsgTarget pSSysMsgTarget) throws Exception {
        super.onUpdateParent(pSSysMsgTarget);
    }

    @Override
    protected void exportCurXmlModel(PSSysMsgTarget pSSysMsgTarget, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMSGTARGET");
        if (!bl) {
            pSSysMsgTarget.setCreateDate(null);
            pSSysMsgTarget.setCreateMan(null);
            pSSysMsgTarget.setPSSysMsgTargetId(null);
            pSSysMsgTarget.setPSSystemName(null);
            pSSysMsgTarget.setUpdateDate(null);
            pSSysMsgTarget.setUpdateMan(null);
            super.exportCurXmlModel(pSSysMsgTarget, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysMsgTarget pSSysMsgTarget, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysMsgTarget, string);
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
            return "DER1N_PSSYSMSGTARGET_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMSGTARGET_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysMsgTarget pSSysMsgTarget) {
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgTarget.getCodeName())) {
            return pSSysMsgTarget.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgTarget.getPSSysMsgTargetName())) {
            return pSSysMsgTarget.getPSSysMsgTargetName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysMsgTarget.getCodeName())) {
            return pSSysMsgTarget.getCodeName();
        }
        return super.getModelV2Tag(pSSysMsgTarget);
    }

    @Override
    public boolean setModelV2Tag(PSSysMsgTarget pSSysMsgTarget, String string) {
        pSSysMsgTarget.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSMSGTARGETNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSMSGTARGETNAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysMsgTarget pSSysMsgTarget, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysMsgTarget.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysMsgTarget, true);
        pSSysMsgTarget.set("CODENAME", string);
        if (this.select(pSSysMsgTarget, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysMsgTarget, true);
        return super.getModelV2Entity(pSSysMsgTarget, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysMsgTarget pSSysMsgTarget, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysMsgTarget, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysMsgTarget pSSysMsgTarget, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "MsgTarget");
        defaultValueMap.put("PSSYSMSGTARGETNAME", "\u6d88\u606f\u76ee\u6807");
    }
}

