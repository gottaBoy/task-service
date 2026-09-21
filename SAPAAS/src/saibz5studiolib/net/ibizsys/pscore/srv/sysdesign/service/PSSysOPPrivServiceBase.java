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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRoleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysOPPrivDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysOPPrivDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleData;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleDataBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleResServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysOPPrivServiceBase
extends PSCoreSysServiceBase<PSSysOPPriv> {
    private static final Log log = LogFactory.getLog(PSSysOPPrivServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysOPPrivDEModel pSSysOPPrivDEModel;
    private PSSysOPPrivDAO pSSysOPPrivDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService";
    }

    public PSSysOPPrivDEModel getPSSysOPPrivDEModel() {
        if (this.pSSysOPPrivDEModel == null) {
            try {
                this.pSSysOPPrivDEModel = (PSSysOPPrivDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysOPPrivDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysOPPrivDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysOPPrivDEModel();
    }

    public PSSysOPPrivDAO getPSSysOPPrivDAO() {
        if (this.pSSysOPPrivDAO == null) {
            try {
                this.pSSysOPPrivDAO = (PSSysOPPrivDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysOPPrivDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysOPPrivDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysOPPrivDAO();
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

    protected void onFillParentInfo(PSSysOPPriv pSSysOPPriv, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysOPPriv, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSSysOPPriv, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSDEFIELD_ROLETAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_RoleTagPSDEF(pSSysOPPriv, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSDEFIELD_USERIDPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_UserIdPSDEF(pSSysOPPriv, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysOPPriv, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysOPPriv, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysOPPriv, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOPPRIV_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysOPPriv, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysOPPriv, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysOPPriv pSSysOPPriv, PSDataEntity pSDataEntity) throws Exception {
        pSSysOPPriv.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysOPPriv.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSSysOPPriv, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEDataSet(PSSysOPPriv pSSysOPPriv, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysOPPriv.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysOPPriv.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_RoleTagPSDEF(PSSysOPPriv pSSysOPPriv, PSDEField pSDEField) throws Exception {
        pSSysOPPriv.setRoleTagPSDEFId(pSDEField.getPSDEFieldId());
        pSSysOPPriv.setRoleTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_UserIdPSDEF(PSSysOPPriv pSSysOPPriv, PSDEField pSDEField) throws Exception {
        pSSysOPPriv.setUserIdPSDEFId(pSDEField.getPSDEFieldId());
        pSSysOPPriv.setUserIdPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSSysOPPriv pSSysOPPriv, PSModule pSModule) throws Exception {
        pSSysOPPriv.setPSModuleId(pSModule.getPSModuleId());
        pSSysOPPriv.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysOPPriv pSSysOPPriv, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysOPPriv.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysOPPriv.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysOPPriv pSSysOPPriv, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysOPPriv.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysOPPriv.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysOPPriv pSSysOPPriv, PSSystem pSSystem) throws Exception {
        pSSysOPPriv.setPSSystemId(pSSystem.getPSSystemId());
        pSSysOPPriv.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        if (bl) {
            if (pSSysOPPriv.getCodeName() == null) {
                pSSysOPPriv.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "SysRole", 25));
            }
            if (pSSysOPPriv.getSystemFlag() == null) {
                pSSysOPPriv.setSystemFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysOPPriv, bl);
        this.onFillEntityFullInfo_PSDE(pSSysOPPriv, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSSysOPPriv, bl);
        this.onFillEntityFullInfo_RoleTagPSDEF(pSSysOPPriv, bl);
        this.onFillEntityFullInfo_UserIdPSDEF(pSSysOPPriv, bl);
        this.onFillEntityFullInfo_PSModule(pSSysOPPriv, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysOPPriv, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysOPPriv, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysOPPriv, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        if (pSSysOPPriv.isPSDEIdDirty()) {
            if (pSSysOPPriv.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSSysOPPriv.getPSDEId() == null || pSSysOPPriv.getPSDEName() == null) {
                    pSDataEntity = pSSysOPPriv.getPSDE();
                    pSSysOPPriv.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSSysOPPriv.getPSDE()).getPSSystemId(), (Object)pSSysOPPriv.getPSSystemId()) != 0L) {
                    pSSysOPPriv.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSSysOPPriv, bl);
                }
            } else {
                pSSysOPPriv.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RoleTagPSDEF(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        if (pSSysOPPriv.isRoleTagPSDEFIdDirty()) {
            if (pSSysOPPriv.getRoleTagPSDEFId() != null) {
                if (pSSysOPPriv.getRoleTagPSDEFId() == null || pSSysOPPriv.getRoleTagPSDEFName() == null) {
                    PSDEField pSDEField = pSSysOPPriv.getRoleTagPSDEF();
                    pSSysOPPriv.setRoleTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysOPPriv.setRoleTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UserIdPSDEF(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        if (pSSysOPPriv.isUserIdPSDEFIdDirty()) {
            if (pSSysOPPriv.getUserIdPSDEFId() != null) {
                if (pSSysOPPriv.getUserIdPSDEFId() == null || pSSysOPPriv.getUserIdPSDEFName() == null) {
                    PSDEField pSDEField = pSSysOPPriv.getUserIdPSDEF();
                    pSSysOPPriv.setUserIdPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysOPPriv.setUserIdPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        if (pSSysOPPriv.isPSSystemIdDirty()) {
            if (pSSysOPPriv.getPSSystemId() != null) {
                if (pSSysOPPriv.getPSSystemId() == null || pSSysOPPriv.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysOPPriv.getPSSystem();
                    pSSysOPPriv.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysOPPriv.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysOPPriv, bl);
    }

    public ArrayList<PSSysOPPriv> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysOPPriv> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysOPPriv> selectByRoleTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByRoleTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByRoleTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByRoleTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByRoleTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ROLETAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRoleTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRoleTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysOPPriv> selectByUserIdPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUserIdPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByUserIdPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUserIdPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByUserIdPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERIDPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUserIdPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUserIdPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysOPPriv> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysOPPriv> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysOPPriv> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysOPPriv> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysOPPriv> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setPSDEId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysOPPrivServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOPPRIV_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSOPPRIV", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setPSDEDataSetId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysOPPrivServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByRoleTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByRoleTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOPPRIV_PSDEFIELD_ROLETAGPSDEFID", "", iDataEntityModel.getName(), "PSSYSOPPRIV", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetRoleTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByRoleTagPSDEF(pSDEField);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setRoleTagPSDEFId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByRoleTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByRoleTagPSDEF(pSDEField2);
                PSSysOPPrivServiceBase.this.internalRemoveByRoleTagPSDEF(pSDEField2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByRoleTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByRoleTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByRoleTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByRoleTagPSDEF(pSDEField);
        this.onBeforeRemoveByRoleTagPSDEF(pSDEField, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByRoleTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByRoleTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByRoleTagPSDEF(PSDEField pSDEField, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRoleTagPSDEF(PSDEField pSDEField, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByUserIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByUserIdPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOPPRIV_PSDEFIELD_USERIDPSDEFID", "", iDataEntityModel.getName(), "PSSYSOPPRIV", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetUserIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByUserIdPSDEF(pSDEField);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setUserIdPSDEFId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByUserIdPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByUserIdPSDEF(pSDEField2);
                PSSysOPPrivServiceBase.this.internalRemoveByUserIdPSDEF(pSDEField2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByUserIdPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUserIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUserIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByUserIdPSDEF(pSDEField);
        this.onBeforeRemoveByUserIdPSDEF(pSDEField, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByUserIdPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUserIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUserIdPSDEF(PSDEField pSDEField, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserIdPSDEF(PSDEField pSDEField, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOPPRIV_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSOPPRIV", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSModule(pSModule);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setPSModuleId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysOPPrivServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOPPRIV_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSOPPRIV", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setPSSysDynaModelId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysOPPrivServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOPPRIV_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSOPPRIV", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setPSSysSFPluginId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysOPPrivServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            PSSysOPPriv pSSysOPPriv2 = (PSSysOPPriv)this.getDEModel().createEntity();
            pSSysOPPriv2.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysOPPriv2.setPSSystemId(null);
            this.update(pSSysOPPriv2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOPPrivServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysOPPrivServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysOPPrivServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysOPPriv> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysOPPriv pSSysOPPriv : arrayList) {
            this.remove((IEntity)pSSysOPPriv);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysOPPriv> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysOPPriv pSSysOPPriv) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEOPPrivRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysOPPriv(pSSysOPPriv);
        pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).testRemoveByPSSysOPPriv(pSSysOPPriv);
        ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).removeByPSSysOPPriv(pSSysOPPriv);
        pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUserRoleResServiceBase)pSCoreSysServiceBase).testRemoveByPSSysOPPriv(pSSysOPPriv);
        super.onBeforeRemove(pSSysOPPriv);
    }

    protected void onBeforeRemoveTemp(PSSysOPPriv pSSysOPPriv) throws Exception {
        super.onBeforeRemoveTemp((IEntity)pSSysOPPriv);
    }

    protected void getRelatedDataTempMajor(PSSysOPPriv pSSysOPPriv) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSSysOPPriv);
    }

    protected void updateRelatedDataTempMajor(PSSysOPPriv pSSysOPPriv, PSSysOPPriv pSSysOPPriv2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSSysOPPriv, (IEntity)pSSysOPPriv2);
    }

    protected void replaceParentInfo(PSSysOPPriv pSSysOPPriv, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysOPPriv, cloneSession);
        if (pSSysOPPriv.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysOPPriv.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysOPPriv, (PSDataEntity)iEntity);
        }
        if (pSSysOPPriv.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysOPPriv.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSSysOPPriv, (PSDEDataSet)iEntity);
        }
        if (pSSysOPPriv.getRoleTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysOPPriv.getRoleTagPSDEFId())) != null) {
            this.onFillParentInfo_RoleTagPSDEF(pSSysOPPriv, (PSDEField)iEntity);
        }
        if (pSSysOPPriv.getUserIdPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysOPPriv.getUserIdPSDEFId())) != null) {
            this.onFillParentInfo_UserIdPSDEF(pSSysOPPriv, (PSDEField)iEntity);
        }
        if (pSSysOPPriv.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysOPPriv.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysOPPriv, (PSModule)iEntity);
        }
        if (pSSysOPPriv.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysOPPriv.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysOPPriv, (PSSysDynaModel)iEntity);
        }
        if (pSSysOPPriv.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysOPPriv.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysOPPriv, (PSSysSFPlugin)iEntity);
        }
        if (pSSysOPPriv.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysOPPriv.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysOPPriv, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysOPPriv, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysOPPriv, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEOpPriv(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GlobalFlag(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrivId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrivType(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysOPPrivId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysOPPrivName(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RoleTagPSDEFId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RoleTagPSDEFName(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SystemFlag(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserIdPSDEFId(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserIdPSDEFName(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRoleSN(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysOPPriv, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isCodeNameDirty() : !pSSysOPPriv.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysOPPriv, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysOPPrivDEModel(), "CODENAME", string3, pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isDefaultModeDirty() : !pSSysOPPriv.isDefaultModeDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getDefaultMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultMode_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEOpPriv(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isDEOpPrivDirty() : !pSSysOPPriv.isDEOpPrivDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getDEOpPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEOpPriv_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEOPPRIV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GlobalFlag(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isGlobalFlagDirty() : !pSSysOPPriv.isGlobalFlagDirty()) {
            return null;
        }
        Integer n = pSSysOPPriv.getGlobalFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GlobalFlag_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GLOBALFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isLockFlagDirty() : !pSSysOPPriv.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysOPPriv.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isMemoDirty() : !pSSysOPPriv.isMemoDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrivId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPrivIdDirty() && !bl2 : !pSSysOPPriv.isPrivIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrivId_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRIVID");
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
                String string4 = this.checkFieldDupRule(this.getPSSysOPPrivDEModel(), "PRIVID", string3, pSSysOPPriv, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PRIVID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrivType(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPrivTypeDirty() : !pSSysOPPriv.isPrivTypeDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPrivType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrivType_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRIVTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSDEDataSetIdDirty() : !pSSysOPPriv.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSDEIdDirty() : !pSSysOPPriv.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSDENameDirty() : !pSSysOPPriv.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSModuleIdDirty() : !pSSysOPPriv.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSSysDynaModelIdDirty() : !pSSysOPPriv.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysOPPrivId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSSysOPPrivIdDirty() && !bl2 : !pSSysOPPriv.isPSSysOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSSysOPPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysOPPrivId_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysOPPrivName(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSSysOPPrivNameDirty() && !bl2 : !pSSysOPPriv.isPSSysOPPrivNameDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSSysOPPrivName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysOPPrivName_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysOPPrivDEModel(), "PSSYSOPPRIVNAME", string3, pSSysOPPriv, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSOPPRIVNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSSysSFPluginIdDirty() : !pSSysOPPriv.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSSystemIdDirty() && !bl2 : !pSSysOPPriv.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isPSSystemNameDirty() && !bl2 : !pSSysOPPriv.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_RoleTagPSDEFId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isRoleTagPSDEFIdDirty() : !pSSysOPPriv.isRoleTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getRoleTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RoleTagPSDEFId_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROLETAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RoleTagPSDEFName(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isRoleTagPSDEFNameDirty() : !pSSysOPPriv.isRoleTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getRoleTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RoleTagPSDEFName_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROLETAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SystemFlag(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isSystemFlagDirty() : !pSSysOPPriv.isSystemFlagDirty()) {
            return null;
        }
        Integer n = pSSysOPPriv.getSystemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SystemFlag_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTEMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserCatDirty() : !pSSysOPPriv.isUserCatDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserIdPSDEFId(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserIdPSDEFIdDirty() : !pSSysOPPriv.isUserIdPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserIdPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserIdPSDEFId_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERIDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserIdPSDEFName(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserIdPSDEFNameDirty() : !pSSysOPPriv.isUserIdPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserIdPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserIdPSDEFName_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERIDPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserRoleSN(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserRoleSNDirty() : !pSSysOPPriv.isUserRoleSNDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserRoleSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserRoleSN_Default((IEntity)pSSysOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserTagDirty() : !pSSysOPPriv.isUserTagDirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserTag2Dirty() : !pSSysOPPriv.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserTag3Dirty() : !pSSysOPPriv.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysOPPriv pSSysOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOPPriv.isUserTag4Dirty() : !pSSysOPPriv.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysOPPriv.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysOPPriv, bl2, bl3);
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

    protected void onSyncEntity(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysOPPriv, bl);
    }

    protected void onSyncIndexEntities(PSSysOPPriv pSSysOPPriv, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysOPPriv, bl);
    }

    public Object getDataContextValue(PSSysOPPriv pSSysOPPriv, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysOPPriv, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysOPPriv.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysOPPriv pSSysOPPriv, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysOPPriv, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEOPPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEOpPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GLOBALFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GlobalFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRIVTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrivType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ROLETAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RoleTagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROLETAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RoleTagPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SystemFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERIDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserIdPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERIDPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserIdPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERROLESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserRoleSN_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEOpPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEOPPRIV", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GlobalFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRIVID", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrivType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRIVTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RoleTagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROLETAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RoleTagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROLETAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SystemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UserIdPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERIDPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserIdPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERIDPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserRoleSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLESN", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSysOPPriv pSSysOPPriv) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysOPPriv)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysOPPriv pSSysOPPriv) throws Exception {
        super.onUpdateParent((IEntity)pSSysOPPriv);
    }

    @Override
    protected void exportCurXmlModel(PSSysOPPriv pSSysOPPriv, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSOPPRIV");
        if (!bl) {
            super.exportCurXmlModel(pSSysOPPriv, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysOPPriv pSSysOPPriv, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysUserRoleData(pSSysOPPriv, xmlNode);
        this.exportRelatedXmlModel_PSSysUserRoleRes(pSSysOPPriv, xmlNode);
        super.onExportRelatedXmlModel(pSSysOPPriv, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysUserRoleData(PSSysOPPriv pSSysOPPriv, XmlNode xmlNode) throws Exception {
        PSSysUserRoleDataService pSSysUserRoleDataService = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUserRoleData> arrayList = null;
        String string = pSSysOPPriv.getPSSysOPPrivId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysUserRoleDataService.selectByPSSysOPPriv(pSSysOPPriv) : pSSysUserRoleDataService.selectTempByPSSysOPPriv(pSSysOPPriv);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSUSERROLEDATAS");
            xmlNode.addNode(xmlNode2);
            for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
                pSSysUserRoleDataService.exportXmlModel(pSSysUserRoleData, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysUserRoleRes(PSSysOPPriv pSSysOPPriv, XmlNode xmlNode) throws Exception {
        PSSysUserRoleResService pSSysUserRoleResService = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUserRoleRes> arrayList = null;
        String string = pSSysOPPriv.getPSSysOPPrivId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysUserRoleResService.selectByPSSysOPPriv(pSSysOPPriv) : pSSysUserRoleResService.selectTempByPSSysOPPriv(pSSysOPPriv);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSUSERROLERESES");
            xmlNode.addNode(xmlNode2);
            for (PSSysUserRoleRes pSSysUserRoleRes : arrayList) {
                pSSysUserRoleResService.exportXmlModel(pSSysUserRoleRes, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysOPPriv pSSysOPPriv, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSUSERROLEDATAS");
        this.importRelatedXmlModel_PSSysUserRoleData(pSSysOPPriv, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSSYSUSERROLERESES");
        this.importRelatedXmlModel_PSSysUserRoleRes(pSSysOPPriv, xmlNode3);
        super.onImportRelatedXmlModel(pSSysOPPriv, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysUserRoleData(PSSysOPPriv pSSysOPPriv, XmlNode xmlNode) throws Exception {
        PSSysUserRoleDataService pSSysUserRoleDataService = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysOPPriv.getPSSysOPPrivId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysUserRoleDataService.removeByPSSysOPPriv(pSSysOPPriv);
        } else {
            pSSysUserRoleDataService.removeTempByPSSysOPPriv(pSSysOPPriv);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysUserRoleData pSSysUserRoleData = new PSSysUserRoleData();
                pSSysUserRoleDataService.fillParentInfo((IEntity)pSSysUserRoleData, "DER1N", "DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", pSSysOPPriv.getPSSysOPPrivId());
                pSSysUserRoleDataService.importXmlModel(pSSysUserRoleData, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysUserRoleRes(PSSysOPPriv pSSysOPPriv, XmlNode xmlNode) throws Exception {
        PSSysUserRoleResService pSSysUserRoleResService = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysOPPriv.getPSSysOPPrivId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysUserRoleResService.removeByPSSysOPPriv(pSSysOPPriv);
        } else {
            pSSysUserRoleResService.removeTempByPSSysOPPriv(pSSysOPPriv);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysUserRoleRes pSSysUserRoleRes = new PSSysUserRoleRes();
                pSSysUserRoleResService.fillParentInfo((IEntity)pSSysUserRoleRes, "DER1N", "DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", pSSysOPPriv.getPSSysOPPrivId());
                pSSysUserRoleResService.importXmlModel(pSSysUserRoleRes, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysOPPriv pSSysOPPriv, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysOPPriv, string);
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
            return "DER1N_PSSYSOPPRIV_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSOPPRIV_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysOPPriv pSSysOPPriv) {
        if (!StringHelper.isNullOrEmpty((String)pSSysOPPriv.getCodeName())) {
            return pSSysOPPriv.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysOPPriv.getPSSysOPPrivName())) {
            return pSSysOPPriv.getPSSysOPPrivName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysOPPriv.getCodeName())) {
            return pSSysOPPriv.getCodeName();
        }
        return super.getModelV2Tag(pSSysOPPriv);
    }

    @Override
    public boolean setModelV2Tag(PSSysOPPriv pSSysOPPriv, String string) {
        pSSysOPPriv.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSOPPRIVNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysOPPriv pSSysOPPriv, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysOPPriv.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysOPPriv, true);
        pSSysOPPriv.set("CODENAME", string);
        if (this.select(pSSysOPPriv, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysOPPriv, true);
        return super.getModelV2Entity(pSSysOPPriv, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysOPPriv pSSysOPPriv, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysOPPriv, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEOPPRIVROLE_PSSYSOPPRIV_PSSYSOPPRIVID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return StringHelper.compare((String)"DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysOPPriv pSSysOPPriv, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEOPPRIVROLE_PSSYSOPPRIV_PSSYSOPPRIVID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSOPPRIV#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEOPPRIVROLE", (Object)pSSysOPPriv.getPSSysOPPrivId()))).exists()) {
            PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSDEOPPrivRoleService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSDEOPPrivRole pSDEOPPrivRole = new PSDEOPPrivRole();
                PSModelV2Helper.fromJSONObject((IDataObject)pSDEOPPrivRole, objectNode, false);
                String string6 = pSDEOPPrivRoleService.getModelV2Tag(pSDEOPPrivRole);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEOPPRIVROLE", (Object)pSDEOPPrivRole.getPSDEOPPrivRoleId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSDEOPPrivRoleService.exportModelV2(pSDEOPPrivRole, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysOPPriv, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysOPPriv pSSysOPPriv, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSSysUserRoleRes> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID")) {
            pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSOPPRIV#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSUSERROLERES", (Object)pSSysOPPriv.getPSSysOPPrivId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysUserRoleRes)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysUserRoleRes>();
                object4 = ((PSSysUserRoleResServiceBase)pSCoreSysServiceBase).selectByPSSysOPPriv(pSSysOPPriv);
                object3 = StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)pSSysOPPriv.getPSSysOPPrivId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysUserRoleRes)object2.next();
                    object = ((PSSysUserRoleResServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysUserRoleRes)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pssysuserroleresname")) {
                            string = objectNode.get("pssysuserroleresname").asText();
                        }
                        if (objectNode2.has("pssysuserroleresname")) {
                            string2 = objectNode2.get("pssysuserroleresname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysUserRoleRes();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEOPPRIVROLE_PSSYSOPPRIV_PSSYSOPPRIVID")) {
            pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSOPPRIV#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEOPPRIVROLE", (Object)pSSysOPPriv.getPSSysOPPrivId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysUserRoleRes)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEOPPrivRoleServiceBase)pSCoreSysServiceBase).selectByPSSysOPPriv(pSSysOPPriv);
                object3 = StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)pSSysOPPriv.getPSSysOPPrivId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEOPPrivRole)object2.next();
                    object = ((PSDEOPPrivRoleServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysUserRoleRes)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdeopprivrolename")) {
                            string = objectNode.get("psdeopprivrolename").asText();
                        }
                        if (objectNode2.has("psdeopprivrolename")) {
                            string2 = objectNode2.get("psdeopprivrolename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEOPPrivRole();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID")) {
            pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSOPPRIV#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSUSERROLEDATA", (Object)pSSysOPPriv.getPSSysOPPrivId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysUserRoleRes)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).selectByPSSysOPPriv(pSSysOPPriv);
                object3 = StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)pSSysOPPriv.getPSSysOPPrivId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysUserRoleData)object2.next();
                    object = ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysUserRoleRes)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("pssysuserroledataname")) {
                            string = objectNode.get("pssysuserroledataname").asText();
                        }
                        if (objectNode2.has("pssysuserroledataname")) {
                            string2 = objectNode2.get("pssysuserroledataname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysUserRoleData();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysOPPriv, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysOPPriv pSSysOPPriv) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSSysUserRoleResServiceBase)pSCoreSysServiceBase).selectByPSSysOPPriv(pSSysOPPriv);
        String string2 = StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)pSSysOPPriv.getPSSysOPPrivId());
        for (PSSysUserRoleRes entityBase : arrayList) {
            string = ((PSSysUserRoleResServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSSysOPPriv.getPSSysOPPrivId());
        ((PSSysUserRoleResServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysUserRoleResServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSUSERROLERES WHERE PSSYSOPPRIVID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).selectByPSSysOPPriv(pSSysOPPriv);
        string2 = StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)pSSysOPPriv.getPSSysOPPrivId());
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            string = ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSSysUserRoleData);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysUserRoleData);
        }
        object = new SqlParamList();
        object.addString(pSSysOPPriv.getPSSysOPPrivId());
        ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSUSERROLEDATA WHERE PSSYSOPPRIVID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysOPPriv);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysOPPriv pSSysOPPriv, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysUserRoleRes();
        entityBase.set("PSSYSOPPRIVID", pSSysOPPriv.getPSSysOPPrivId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEOPPrivRole();
        entityBase.set("PSSYSOPPRIVID", pSSysOPPriv.getPSSysOPPrivId());
        pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysUserRoleData();
        entityBase.set("PSSYSOPPRIVID", pSSysOPPriv.getPSSysOPPrivId());
        pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysOPPriv, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysOPPriv pSSysOPPriv, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysUserRoleRes();
                ((PSSysUserRoleResBase)object).setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
                ((PSSysUserRoleResBase)object).setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysUserRoleRes();
                    entityBase.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
                    entityBase.setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        if (!PSSysOPPrivServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEOPPrivRole();
                    ((PSDEOPPrivRoleBase)object).setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
                    ((PSDEOPPrivRoleBase)object).setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEOPPrivRole();
                        entityBase.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
                        entityBase.setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                object = new PSSysUserRoleData();
                ((PSSysUserRoleDataBase)object).setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
                ((PSSysUserRoleDataBase)object).setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string6);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysUserRoleData();
                    entityBase.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
                    entityBase.setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysOPPriv, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysOPPriv pSSysOPPriv, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysUserRoleReses(pSSysOPPriv, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysUserRoleDatas(pSSysOPPriv, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysOPPriv, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysUserRoleReses(PSSysOPPriv pSSysOPPriv, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSUSERROLERES", true), (boolean)false) == 0) {
            PSSysUserRoleResService pSSysUserRoleResService = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
            PSSysUserRoleRes pSSysUserRoleRes = new PSSysUserRoleRes();
            pSSysUserRoleRes.setPSSysUserRoleResId(pSMOSFile.getPSModelId());
            if (!pSSysUserRoleResService.get((IEntity)pSSysUserRoleRes, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysUserRoleRes.getPSSysOPPrivId(), (String)pSSysOPPriv.getPSSysOPPrivId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysUserRoleResService.exportModelV2(pSSysUserRoleRes);
            pSSysUserRoleRes.reset();
            if (!pSSysUserRoleResService.setModelV2ResScope((IEntity)pSSysUserRoleRes, "PSSYSOPPRIV", pSSysOPPriv.getPSSysOPPrivId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysUserRoleResService.importModelV2(pSSysUserRoleRes, objectNode);
            SessionFactoryManager.commit();
            return pSSysUserRoleResService.getFile((IEntity)pSSysUserRoleRes);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSUNIRES", true), (boolean)false) == 0) {
            PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = new PSSysUniRes();
            pSSysUniRes.setPSSysUniResId(pSMOSFile.getPSModelId());
            if (!pSSysUniResService.get((IEntity)pSSysUniRes, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSSysUserRoleResService pSSysUserRoleResService = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
            PSSysUserRoleRes pSSysUserRoleRes = new PSSysUserRoleRes();
            pSSysUserRoleRes.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysUserRoleRes.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
            this.fillPasteEntity((IEntity)pSSysUserRoleRes, "PASTETAG");
            pSSysUserRoleResService.create(pSSysUserRoleRes);
            SessionFactoryManager.commit();
            return pSSysUserRoleResService.getFile((IEntity)pSSysUserRoleRes);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysUserRoleDatas(PSSysOPPriv pSSysOPPriv, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSUSERROLEDATA", true), (boolean)false) == 0) {
            PSSysUserRoleDataService pSSysUserRoleDataService = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
            PSSysUserRoleData pSSysUserRoleData = new PSSysUserRoleData();
            pSSysUserRoleData.setPSSysUserRoleDataId(pSMOSFile.getPSModelId());
            if (!pSSysUserRoleDataService.get((IEntity)pSSysUserRoleData, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysUserRoleData.getPSSysOPPrivId(), (String)pSSysOPPriv.getPSSysOPPrivId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysUserRoleDataService.exportModelV2(pSSysUserRoleData);
            pSSysUserRoleData.reset();
            if (!pSSysUserRoleDataService.setModelV2ResScope((IEntity)pSSysUserRoleData, "PSSYSOPPRIV", pSSysOPPriv.getPSSysOPPrivId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysUserRoleDataService.importModelV2(pSSysUserRoleData, objectNode);
            SessionFactoryManager.commit();
            return pSSysUserRoleDataService.getFile((IEntity)pSSysUserRoleData);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEUSERROLE", true), (boolean)false) == 0) {
            PSDEUserRoleService pSDEUserRoleService = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
            PSDEUserRole pSDEUserRole = new PSDEUserRole();
            pSDEUserRole.setPSDEUserRoleId(pSMOSFile.getPSModelId());
            if (!pSDEUserRoleService.get((IEntity)pSDEUserRole, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSSysUserRoleDataService pSSysUserRoleDataService = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
            PSSysUserRoleData pSSysUserRoleData = new PSSysUserRoleData();
            pSSysUserRoleData.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
            pSSysUserRoleData.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
            this.fillPasteEntity((IEntity)pSSysUserRoleData, "PASTETAG");
            pSSysUserRoleDataService.create(pSSysUserRoleData);
            SessionFactoryManager.commit();
            return pSSysUserRoleDataService.getFile((IEntity)pSSysUserRoleData);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysOPPriv pSSysOPPriv, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysUserRoleReses(pSSysOPPriv, list);
        this.onFillPasteHelps_PSSysUserRoleDatas(pSSysOPPriv, list);
        super.onFillPasteHelps(pSSysOPPriv, list);
    }

    protected void onFillPasteHelps_PSSysUserRoleReses(PSSysOPPriv pSSysOPPriv, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSUSERROLERES");
        pSHelpSection.setSectionParam2("DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u64cd\u4f5c\u89d2\u8272]\u7684[\u7cfb\u7edf\u89d2\u8272\u8d44\u6e90\u80fd\u529b]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSUSERROLERES");
        pSHelpSection.setSectionParam2("DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID");
        pSHelpSection.setUserTag("DER1N_PSSYSUSERROLERES_PSSYSUNIRES_PSSYSUNIRESID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u7684[\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90]\u6784\u5efa[\u7cfb\u7edf\u89d2\u8272\u8d44\u6e90\u80fd\u529b]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysUserRoleDatas(PSSysOPPriv pSSysOPPriv, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSUSERROLEDATA");
        pSHelpSection.setSectionParam2("DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u64cd\u4f5c\u89d2\u8272]\u7684[\u7cfb\u7edf\u89d2\u8272\u6570\u636e\u80fd\u529b]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSUSERROLEDATA");
        pSHelpSection.setSectionParam2("DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID");
        pSHelpSection.setUserTag("DER1N_PSSYSUSERROLEDATA_PSDEUSERROLE_PSDEUSERROLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272]\u6784\u5efa[\u7cfb\u7edf\u89d2\u8272\u6570\u636e\u80fd\u529b]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u7edf\u4e00\u8d44\u6e90>", "DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysOPPrivServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7edf\u4e00\u8d44\u6e90>");
            } else if (PSSysOPPrivServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysuserrolereses");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID|PSSYSOPPRIVID");
            pSMOSFile2.setFileTag3("PSSYSUSERROLERES");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysOPPrivServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5b9e\u4f53\u89d2\u8272>", "DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysOPPrivServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5b9e\u4f53\u89d2\u8272>");
            } else if (PSSysOPPrivServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysuserroledatas");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID|PSSYSOPPRIVID");
            pSMOSFile2.setFileTag3("PSSYSUSERROLEDATA");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysOPPrivServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSSysOPPrivServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u7edf\u4e00\u8d44\u6e90>", (boolean)false) == 0 || PSSysOPPrivServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysUserRoleReses", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysOPPrivServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5b9e\u4f53\u89d2\u8272>", (boolean)false) == 0 || PSSysOPPrivServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysUserRoleDatas", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", "PSSYSOPPRIVID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", (boolean)false) == 0) {
            if (PSSysOPPrivServiceBase.getMOSVer() == 1) {
                return "<\u7edf\u4e00\u8d44\u6e90>";
            }
            if (PSSysOPPrivServiceBase.getMOSVer() == 2) {
                return "pssysuserrolereses";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", (boolean)false) == 0) {
            if (PSSysOPPrivServiceBase.getMOSVer() == 1) {
                return "<\u5b9e\u4f53\u89d2\u8272>";
            }
            if (PSSysOPPrivServiceBase.getMOSVer() == 2) {
                return "pssysuserroledatas";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysOPPriv pSSysOPPriv, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "SysRole");
    }
}

