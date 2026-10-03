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
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFRoleDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFRoleDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFRoleServiceBase
extends PSCoreSysServiceBase<PSWFRole> {
    private static final Log log = LogFactory.getLog(PSWFRoleServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSWFRoleDEModel pSWFRoleDEModel;
    private PSWFRoleDAO pSWFRoleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService";
    }

    public PSWFRoleDEModel getPSWFRoleDEModel() {
        if (this.pSWFRoleDEModel == null) {
            try {
                this.pSWFRoleDEModel = (PSWFRoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFRoleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFRoleDEModel();
    }

    public PSWFRoleDAO getPSWFRoleDAO() {
        if (this.pSWFRoleDAO == null) {
            try {
                this.pSWFRoleDAO = (PSWFRoleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFRoleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFRoleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFRoleDAO();
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

    protected void onFillParentInfo(PSWFRole pSWFRole, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFROLE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSWFRole, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFROLE_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSWFRole, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFROLE_PSDEFIELD_WFUSERIDPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFUserIdPSDEF(pSWFRole, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFROLE_PSDEFIELD_WFUSERNAMEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFUserNamePSDEF(pSWFRole, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFROLE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSWFRole, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFROLE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSWFRole, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFROLE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSWFRole, pSSystem);
            return;
        }
        super.onFillParentInfo(pSWFRole, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSWFRole pSWFRole, PSDataEntity pSDataEntity) throws Exception {
        pSWFRole.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSWFRole.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSWFRole pSWFRole, PSDEDataSet pSDEDataSet) throws Exception {
        pSWFRole.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSWFRole.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_WFUserIdPSDEF(PSWFRole pSWFRole, PSDEField pSDEField) throws Exception {
        pSWFRole.setWFUserIdPSDEFId(pSDEField.getPSDEFieldId());
        pSWFRole.setWFUserIdPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFUserNamePSDEF(PSWFRole pSWFRole, PSDEField pSDEField) throws Exception {
        pSWFRole.setWFUserNamePSDEFId(pSDEField.getPSDEFieldId());
        pSWFRole.setWFUserNamePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSWFRole pSWFRole, PSModule pSModule) throws Exception {
        pSWFRole.setPSModuleId(pSModule.getPSModuleId());
        pSWFRole.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSWFRole pSWFRole, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSWFRole.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSWFRole.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSWFRole pSWFRole, PSSystem pSSystem) throws Exception {
        pSWFRole.setPSSystemId(pSSystem.getPSSystemId());
        pSWFRole.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSWFRole pSWFRole, boolean bl) throws Exception {
        if (bl) {
            if (pSWFRole.getCodeName() == null) {
                pSWFRole.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "WFRole", 25));
            }
            if (pSWFRole.getEnable() == null) {
                pSWFRole.setEnable((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSWFRole, bl);
        this.onFillEntityFullInfo_PSDE(pSWFRole, bl);
        this.onFillEntityFullInfo_PSDEDS(pSWFRole, bl);
        this.onFillEntityFullInfo_WFUserIdPSDEF(pSWFRole, bl);
        this.onFillEntityFullInfo_WFUserNamePSDEF(pSWFRole, bl);
        this.onFillEntityFullInfo_PSModule(pSWFRole, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSWFRole, bl);
        this.onFillEntityFullInfo_PSSystem(pSWFRole, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSWFRole pSWFRole, boolean bl) throws Exception {
        if (pSWFRole.isPSDEIdDirty()) {
            if (pSWFRole.getPSDEId() != null) {
                if (pSWFRole.getPSDEId() == null || pSWFRole.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSWFRole.getPSDE();
                    pSWFRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSWFRole.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSWFRole pSWFRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_WFUserIdPSDEF(PSWFRole pSWFRole, boolean bl) throws Exception {
        if (pSWFRole.isWFUserIdPSDEFIdDirty()) {
            if (pSWFRole.getWFUserIdPSDEFId() != null) {
                if (pSWFRole.getWFUserIdPSDEFId() == null || pSWFRole.getWFUserIdPSDEFName() == null) {
                    PSDEField pSDEField = pSWFRole.getWFUserIdPSDEF();
                    pSWFRole.setWFUserIdPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFRole.setWFUserIdPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFUserNamePSDEF(PSWFRole pSWFRole, boolean bl) throws Exception {
        if (pSWFRole.isWFUserNamePSDEFIdDirty()) {
            if (pSWFRole.getWFUserNamePSDEFId() != null) {
                if (pSWFRole.getWFUserNamePSDEFId() == null || pSWFRole.getWFUserNamePSDEFName() == null) {
                    PSDEField pSDEField = pSWFRole.getWFUserNamePSDEF();
                    pSWFRole.setWFUserNamePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFRole.setWFUserNamePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSWFRole pSWFRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSWFRole pSWFRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSWFRole pSWFRole, boolean bl) throws Exception {
        if (pSWFRole.isPSSystemIdDirty()) {
            if (pSWFRole.getPSSystemId() != null) {
                if (pSWFRole.getPSSystemId() == null || pSWFRole.getPSSystemName() == null) {
                    PSSystem pSSystem = pSWFRole.getPSSystem();
                    pSWFRole.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSWFRole.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWFRole pSWFRole, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFRole, bl);
    }

    public ArrayList<PSWFRole> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSWFRole> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSWFRole> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFRole> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSWFRole> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSWFRole> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFRole> selectByWFUserIdPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFUserIdPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFRole> selectByWFUserIdPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFUserIdPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFRole> selectByWFUserIdPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFUSERIDPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFUserIdPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFUserIdPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFRole> selectByWFUserNamePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFUserNamePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFRole> selectByWFUserNamePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFUserNamePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFRole> selectByWFUserNamePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFUSERNAMEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFUserNamePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFUserNamePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFRole> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSWFRole> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSWFRole> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFRole> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSWFRole> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSWFRole> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFRole> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSWFRole> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSWFRole> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSWFRole> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFROLE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSWFROLE", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSWFRole pSWFRole : arrayList) {
            PSWFRole pSWFRole2 = (PSWFRole)this.getDEModel().createEntity();
            pSWFRole2.setPSWFRoleId(pSWFRole.getPSWFRoleId());
            pSWFRole2.setPSDEId(null);
            this.update(pSWFRole2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFRoleServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSWFRoleServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSWFRoleServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSWFRole pSWFRole : arrayList) {
            this.remove(pSWFRole);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFROLE_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSWFROLE", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSWFRole pSWFRole : arrayList) {
            PSWFRole pSWFRole2 = (PSWFRole)this.getDEModel().createEntity();
            pSWFRole2.setPSWFRoleId(pSWFRole.getPSWFRoleId());
            pSWFRole2.setPSDEDSId(null);
            this.update(pSWFRole2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFRoleServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSWFRoleServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSWFRoleServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSWFRole pSWFRole : arrayList) {
            this.remove(pSWFRole);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    public void testRemoveByWFUserIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByWFUserIdPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFROLE_PSDEFIELD_WFUSERIDPSDEFID", "", iDataEntityModel.getName(), "PSWFROLE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFUserIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByWFUserIdPSDEF(pSDEField);
        for (PSWFRole pSWFRole : arrayList) {
            PSWFRole pSWFRole2 = (PSWFRole)this.getDEModel().createEntity();
            pSWFRole2.setPSWFRoleId(pSWFRole.getPSWFRoleId());
            pSWFRole2.setWFUserIdPSDEFId(null);
            this.update(pSWFRole2);
        }
    }

    public void removeByWFUserIdPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFRoleServiceBase.this.onBeforeRemoveByWFUserIdPSDEF(pSDEField2);
                PSWFRoleServiceBase.this.internalRemoveByWFUserIdPSDEF(pSDEField2);
                PSWFRoleServiceBase.this.onAfterRemoveByWFUserIdPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFUserIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFUserIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByWFUserIdPSDEF(pSDEField);
        this.onBeforeRemoveByWFUserIdPSDEF(pSDEField, arrayList);
        for (PSWFRole pSWFRole : arrayList) {
            this.remove(pSWFRole);
        }
        this.onAfterRemoveByWFUserIdPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFUserIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFUserIdPSDEF(PSDEField pSDEField, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFUserIdPSDEF(PSDEField pSDEField, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    public void testRemoveByWFUserNamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByWFUserNamePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFROLE_PSDEFIELD_WFUSERNAMEPSDEFID", "", iDataEntityModel.getName(), "PSWFROLE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFUserNamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByWFUserNamePSDEF(pSDEField);
        for (PSWFRole pSWFRole : arrayList) {
            PSWFRole pSWFRole2 = (PSWFRole)this.getDEModel().createEntity();
            pSWFRole2.setPSWFRoleId(pSWFRole.getPSWFRoleId());
            pSWFRole2.setWFUserNamePSDEFId(null);
            this.update(pSWFRole2);
        }
    }

    public void removeByWFUserNamePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFRoleServiceBase.this.onBeforeRemoveByWFUserNamePSDEF(pSDEField2);
                PSWFRoleServiceBase.this.internalRemoveByWFUserNamePSDEF(pSDEField2);
                PSWFRoleServiceBase.this.onAfterRemoveByWFUserNamePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFUserNamePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFUserNamePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByWFUserNamePSDEF(pSDEField);
        this.onBeforeRemoveByWFUserNamePSDEF(pSDEField, arrayList);
        for (PSWFRole pSWFRole : arrayList) {
            this.remove(pSWFRole);
        }
        this.onAfterRemoveByWFUserNamePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFUserNamePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFUserNamePSDEF(PSDEField pSDEField, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFUserNamePSDEF(PSDEField pSDEField, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFROLE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSWFROLE", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSModule(pSModule);
        for (PSWFRole pSWFRole : arrayList) {
            PSWFRole pSWFRole2 = (PSWFRole)this.getDEModel().createEntity();
            pSWFRole2.setPSWFRoleId(pSWFRole.getPSWFRoleId());
            pSWFRole2.setPSModuleId(null);
            this.update(pSWFRole2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFRoleServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSWFRoleServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSWFRoleServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSWFRole pSWFRole : arrayList) {
            this.remove(pSWFRole);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFROLE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSWFROLE", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSWFRole pSWFRole : arrayList) {
            PSWFRole pSWFRole2 = (PSWFRole)this.getDEModel().createEntity();
            pSWFRole2.setPSWFRoleId(pSWFRole.getPSWFRoleId());
            pSWFRole2.setPSSysSFPluginId(null);
            this.update(pSWFRole2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFRoleServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWFRoleServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWFRoleServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSWFRole pSWFRole : arrayList) {
            this.remove(pSWFRole);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSSystem(pSSystem);
        for (PSWFRole pSWFRole : arrayList) {
            PSWFRole pSWFRole2 = (PSWFRole)this.getDEModel().createEntity();
            pSWFRole2.setPSWFRoleId(pSWFRole.getPSWFRoleId());
            pSWFRole2.setPSSystemId(null);
            this.update(pSWFRole2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFRoleServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSWFRoleServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSWFRoleServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSWFRole> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSWFRole pSWFRole : arrayList) {
            this.remove(pSWFRole);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSWFRole> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFRole pSWFRole) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSWFRole(pSWFRole);
        pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSWFRole(pSWFRole);
        super.onBeforeRemove(pSWFRole);
    }

    protected void replaceParentInfo(PSWFRole pSWFRole, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFRole, cloneSession);
        if (pSWFRole.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSWFRole.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSWFRole, (PSDataEntity)iEntity);
        }
        if (pSWFRole.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSWFRole.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSWFRole, (PSDEDataSet)iEntity);
        }
        if (pSWFRole.getWFUserIdPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFRole.getWFUserIdPSDEFId())) != null) {
            this.onFillParentInfo_WFUserIdPSDEF(pSWFRole, (PSDEField)iEntity);
        }
        if (pSWFRole.getWFUserNamePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFRole.getWFUserNamePSDEFId())) != null) {
            this.onFillParentInfo_WFUserNamePSDEF(pSWFRole, (PSDEField)iEntity);
        }
        if (pSWFRole.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSWFRole.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSWFRole, (PSModule)iEntity);
        }
        if (pSWFRole.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSWFRole.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSWFRole, (PSSysSFPlugin)iEntity);
        }
        if (pSWFRole.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSWFRole.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSWFRole, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFRole pSWFRole, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFRole, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSWFRole, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Enable(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFRoleId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFRoleName(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFRoleSN(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFRoleType(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserIdPSDEFId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserIdPSDEFName(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserNamePSDEFId(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFUserNamePSDEFName(bl, pSWFRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFRole, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isCodeNameDirty() && !bl2 : !pSWFRole.isCodeNameDirty()) {
            return null;
        }
        String string = pSWFRole.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSWFRole, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSWFRoleDEModel(), "CODENAME", string3, pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isDynaModelFlagDirty() : !pSWFRole.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFRole.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_Enable(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isEnableDirty() && !bl2 : !pSWFRole.isEnableDirty()) {
            return null;
        }
        Integer n = pSWFRole.getEnable();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Enable_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isLockFlagDirty() : !pSWFRole.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSWFRole.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isMemoDirty() : !pSWFRole.isMemoDirty()) {
            return null;
        }
        String string = pSWFRole.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSDEDSIdDirty() : !pSWFRole.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSWFRole.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSDEIdDirty() : !pSWFRole.isPSDEIdDirty()) {
            return null;
        }
        String string = pSWFRole.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSDENameDirty() : !pSWFRole.isPSDENameDirty()) {
            return null;
        }
        String string = pSWFRole.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSDynaInstIdDirty() : !pSWFRole.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFRole.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSModuleIdDirty() : !pSWFRole.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSWFRole.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSSysSFPluginIdDirty() : !pSWFRole.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSWFRole.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSSystemIdDirty() && !bl2 : !pSWFRole.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSWFRole.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSSystemNameDirty() && !bl2 : !pSWFRole.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSWFRole.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFRoleId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSWFRoleIdDirty() && !bl2 : !pSWFRole.isPSWFRoleIdDirty()) {
            return null;
        }
        String string = pSWFRole.getPSWFRoleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFRoleId_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFRoleName(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isPSWFRoleNameDirty() && !bl2 : !pSWFRole.isPSWFRoleNameDirty()) {
            return null;
        }
        String string = pSWFRole.getPSWFRoleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFROLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFRoleName_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFROLENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSWFRoleDEModel(), "PSWFROLENAME", string3, pSWFRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWFROLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isUserCatDirty() : !pSWFRole.isUserCatDirty()) {
            return null;
        }
        String string = pSWFRole.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isUserDataDirty() : !pSWFRole.isUserDataDirty()) {
            return null;
        }
        String string = pSWFRole.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isUserData2Dirty() : !pSWFRole.isUserData2Dirty()) {
            return null;
        }
        String string = pSWFRole.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isUserTagDirty() : !pSWFRole.isUserTagDirty()) {
            return null;
        }
        String string = pSWFRole.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isUserTag2Dirty() : !pSWFRole.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWFRole.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isUserTag3Dirty() : !pSWFRole.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWFRole.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isUserTag4Dirty() : !pSWFRole.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWFRole.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWFRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_WFRoleSN(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isWFRoleSNDirty() : !pSWFRole.isWFRoleSNDirty()) {
            return null;
        }
        String string = pSWFRole.getWFRoleSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFRoleSN_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFROLESN");
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
                String string4 = this.checkFieldDupRule(this.getPSWFRoleDEModel(), "WFROLESN", string3, pSWFRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("WFROLESN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFRoleType(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isWFRoleTypeDirty() && !bl2 : !pSWFRole.isWFRoleTypeDirty()) {
            return null;
        }
        String string = pSWFRole.getWFRoleType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFROLETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFRoleType_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFROLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserIdPSDEFId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isWFUserIdPSDEFIdDirty() : !pSWFRole.isWFUserIdPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFRole.getWFUserIdPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFUserIdPSDEFId_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERIDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserIdPSDEFName(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isWFUserIdPSDEFNameDirty() : !pSWFRole.isWFUserIdPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFRole.getWFUserIdPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFUserIdPSDEFName_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERIDPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserNamePSDEFId(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isWFUserNamePSDEFIdDirty() : !pSWFRole.isWFUserNamePSDEFIdDirty()) {
            return null;
        }
        String string = pSWFRole.getWFUserNamePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFUserNamePSDEFId_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERNAMEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFUserNamePSDEFName(boolean bl, PSWFRole pSWFRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFRole.isWFUserNamePSDEFNameDirty() : !pSWFRole.isWFUserNamePSDEFNameDirty()) {
            return null;
        }
        String string = pSWFRole.getWFUserNamePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFUserNamePSDEFName_Default(pSWFRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFUSERNAMEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFRole pSWFRole, boolean bl) throws Exception {
        super.onSyncEntity(pSWFRole, bl);
    }

    protected void onSyncIndexEntities(PSWFRole pSWFRole, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFRole, bl);
    }

    public Object getDataContextValue(PSWFRole pSWFRole, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWFRole, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSWFRole.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWFRole pSWFRole, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWFRole, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Enable_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSWFROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFRoleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WFROLESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFRoleSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFROLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFRoleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFUSERIDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFUserIdPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFUSERIDPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFUserIdPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFUSERNAMEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFUserNamePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFUSERNAMEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFUserNamePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Enable_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSWFRoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFROLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFRoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFROLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_WFRoleSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFROLESN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFRoleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFROLETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFUserIdPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERIDPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFUserIdPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERIDPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFUserNamePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERNAMEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFUserNamePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFUSERNAMEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWFRole pSWFRole) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFRole)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFRole pSWFRole) throws Exception {
        super.onUpdateParent(pSWFRole);
    }

    @Override
    protected void exportCurXmlModel(PSWFRole pSWFRole, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFROLE");
        if (!bl) {
            pSWFRole.setPSSystemId(null);
            pSWFRole.setPSSystemName(null);
            super.exportCurXmlModel(pSWFRole, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFRole pSWFRole, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFRole, string);
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
            return "DER1N_PSWFROLE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFROLE_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSWFRole pSWFRole) {
        if (!StringHelper.isNullOrEmpty((String)pSWFRole.getPSWFRoleName())) {
            return pSWFRole.getPSWFRoleName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFRole.getCodeName())) {
            return pSWFRole.getCodeName();
        }
        return super.getModelV2Tag(pSWFRole);
    }

    @Override
    public boolean setModelV2Tag(PSWFRole pSWFRole, String string) {
        pSWFRole.setPSWFRoleName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSWFROLENAME", "");
        map.put("CODENAME", "");
        map.put("PSWFROLENAME", "");
        map.put("WFROLESN", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFRole pSWFRole, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFRole.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFRole, true);
        pSWFRole.set("PSWFROLENAME", string);
        if (this.select(pSWFRole, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFRole, true);
        return super.getModelV2Entity(pSWFRole, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFRole pSWFRole, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWFRole, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSWFRole pSWFRole, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "WFRole");
    }
}

