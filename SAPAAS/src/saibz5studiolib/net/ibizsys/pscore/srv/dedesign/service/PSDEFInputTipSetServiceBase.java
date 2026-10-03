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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFInputTipSetDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFInputTipSetDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFInputTipSetServiceBase
extends PSCoreSysServiceBase<PSDEFInputTipSet> {
    private static final Log log = LogFactory.getLog(PSDEFInputTipSetServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFInputTipSetDEModel pSDEFInputTipSetDEModel;
    private PSDEFInputTipSetDAO pSDEFInputTipSetDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService";
    }

    public PSDEFInputTipSetDEModel getPSDEFInputTipSetDEModel() {
        if (this.pSDEFInputTipSetDEModel == null) {
            try {
                this.pSDEFInputTipSetDEModel = (PSDEFInputTipSetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFInputTipSetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFInputTipSetDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFInputTipSetDEModel();
    }

    public PSDEFInputTipSetDAO getPSDEFInputTipSetDAO() {
        if (this.pSDEFInputTipSetDAO == null) {
            try {
                this.pSDEFInputTipSetDAO = (PSDEFInputTipSetDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFInputTipSetDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFInputTipSetDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFInputTipSetDAO();
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

    protected void onFillParentInfo(PSDEFInputTipSet pSDEFInputTipSet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEFInputTipSet, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEFInputTipSet, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSDEFIELD_CONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ContentPSDEF(pSDEFInputTipSet, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSDEFIELD_ECPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ECPSDEF(pSDEFInputTipSet, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSDEFIELD_LINKPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LinkPSDEF(pSDEFInputTipSet, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSDEFIELD_UNIQUETAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_UniqueTagPSDEF(pSDEFInputTipSet, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSDEFInputTipSet, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEFInputTipSet, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEFInputTipSet, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFINPUTTIPSET_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEFInputTipSet, pSSystem);
            return;
        }
        super.onFillParentInfo(pSDEFInputTipSet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEFInputTipSet pSDEFInputTipSet, PSDataEntity pSDataEntity) throws Exception {
        pSDEFInputTipSet.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFInputTipSet.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEFInputTipSet pSDEFInputTipSet, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEFInputTipSet.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEFInputTipSet.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_ContentPSDEF(PSDEFInputTipSet pSDEFInputTipSet, PSDEField pSDEField) throws Exception {
        pSDEFInputTipSet.setContentPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFInputTipSet.setContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ECPSDEF(PSDEFInputTipSet pSDEFInputTipSet, PSDEField pSDEField) throws Exception {
        pSDEFInputTipSet.setECPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFInputTipSet.setECPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LinkPSDEF(PSDEFInputTipSet pSDEFInputTipSet, PSDEField pSDEField) throws Exception {
        pSDEFInputTipSet.setLinkPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFInputTipSet.setLinkPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_UniqueTagPSDEF(PSDEFInputTipSet pSDEFInputTipSet, PSDEField pSDEField) throws Exception {
        pSDEFInputTipSet.setUniqueTagPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFInputTipSet.setUniqueTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSModule(PSDEFInputTipSet pSDEFInputTipSet, PSModule pSModule) throws Exception {
        pSDEFInputTipSet.setPSModuleId(pSModule.getPSModuleId());
        pSDEFInputTipSet.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEFInputTipSet pSDEFInputTipSet, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEFInputTipSet.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEFInputTipSet.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEFInputTipSet pSDEFInputTipSet, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEFInputTipSet.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEFInputTipSet.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSDEFInputTipSet pSDEFInputTipSet, PSSystem pSSystem) throws Exception {
        pSDEFInputTipSet.setPSSystemId(pSSystem.getPSSystemId());
        pSDEFInputTipSet.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_PSDE(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_ContentPSDEF(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_ECPSDEF(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_LinkPSDEF(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_UniqueTagPSDEF(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_PSModule(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEFInputTipSet, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEFInputTipSet, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        if (pSDEFInputTipSet.isPSDEIdDirty()) {
            if (pSDEFInputTipSet.getPSDEId() != null) {
                if (pSDEFInputTipSet.getPSDEId() == null || pSDEFInputTipSet.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFInputTipSet.getPSDE();
                    pSDEFInputTipSet.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFInputTipSet.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ContentPSDEF(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        if (pSDEFInputTipSet.isContentPSDEFIdDirty()) {
            if (pSDEFInputTipSet.getContentPSDEFId() != null) {
                if (pSDEFInputTipSet.getContentPSDEFId() == null || pSDEFInputTipSet.getContentPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFInputTipSet.getContentPSDEF();
                    pSDEFInputTipSet.setContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFInputTipSet.setContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ECPSDEF(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        if (pSDEFInputTipSet.isECPSDEFIdDirty()) {
            if (pSDEFInputTipSet.getECPSDEFId() != null) {
                if (pSDEFInputTipSet.getECPSDEFId() == null || pSDEFInputTipSet.getECPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFInputTipSet.getECPSDEF();
                    pSDEFInputTipSet.setECPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFInputTipSet.setECPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LinkPSDEF(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        if (pSDEFInputTipSet.isLinkPSDEFIdDirty()) {
            if (pSDEFInputTipSet.getLinkPSDEFId() != null) {
                if (pSDEFInputTipSet.getLinkPSDEFId() == null || pSDEFInputTipSet.getLinkPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFInputTipSet.getLinkPSDEF();
                    pSDEFInputTipSet.setLinkPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFInputTipSet.setLinkPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UniqueTagPSDEF(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        if (pSDEFInputTipSet.isUniqueTagPSDEFIdDirty()) {
            if (pSDEFInputTipSet.getUniqueTagPSDEFId() != null) {
                if (pSDEFInputTipSet.getUniqueTagPSDEFId() == null || pSDEFInputTipSet.getUniqueTagPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFInputTipSet.getUniqueTagPSDEF();
                    pSDEFInputTipSet.setUniqueTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFInputTipSet.setUniqueTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        if (pSDEFInputTipSet.isPSSystemIdDirty()) {
            if (pSDEFInputTipSet.getPSSystemId() != null) {
                if (pSDEFInputTipSet.getPSSystemId() == null || pSDEFInputTipSet.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDEFInputTipSet.getPSSystem();
                    pSDEFInputTipSet.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDEFInputTipSet.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFInputTipSet, bl);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFInputTipSet> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFInputTipSet> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFInputTipSet> selectByECPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByECPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByECPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByECPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByECPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ECPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByECPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByECPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFInputTipSet> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFInputTipSet> selectByUniqueTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByUniqueTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByUniqueTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByUniqueTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByUniqueTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UNIQUETAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUniqueTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUniqueTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFInputTipSet> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFInputTipSet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFInputTipSet> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFInputTipSet> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEFInputTipSet> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setPSDEId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setPSDEDataSetId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSDEFIELD_CONTENTPSDEFID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByContentPSDEF(pSDEField);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setContentPSDEFId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByContentPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByContentPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByContentPSDEF(pSDEField);
        this.onBeforeRemoveByContentPSDEF(pSDEField, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByECPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByECPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSDEFIELD_ECPSDEFID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetECPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByECPSDEF(pSDEField);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setECPSDEFId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByECPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByECPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByECPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByECPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByECPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByECPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByECPSDEF(pSDEField);
        this.onBeforeRemoveByECPSDEF(pSDEField, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByECPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByECPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByECPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByECPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByLinkPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSDEFIELD_LINKPSDEFID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByLinkPSDEF(pSDEField);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setLinkPSDEFId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByLinkPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByLinkPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByLinkPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByLinkPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByLinkPSDEF(pSDEField);
        this.onBeforeRemoveByLinkPSDEF(pSDEField, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByLinkPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByUniqueTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByUniqueTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSDEFIELD_UNIQUETAGPSDEFID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetUniqueTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByUniqueTagPSDEF(pSDEField);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setUniqueTagPSDEFId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByUniqueTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByUniqueTagPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByUniqueTagPSDEF(pSDEField2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByUniqueTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByUniqueTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByUniqueTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByUniqueTagPSDEF(pSDEField);
        this.onBeforeRemoveByUniqueTagPSDEF(pSDEField, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByUniqueTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByUniqueTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByUniqueTagPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUniqueTagPSDEF(PSDEField pSDEField, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSModule(pSModule);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setPSModuleId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setPSSysPFPluginId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFINPUTTIPSET_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEFINPUTTIPSET", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setPSSysSFPluginId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            PSDEFInputTipSet pSDEFInputTipSet2 = (PSDEFInputTipSet)this.getDEModel().createEntity();
            pSDEFInputTipSet2.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
            pSDEFInputTipSet2.setPSSystemId(null);
            this.update(pSDEFInputTipSet2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFInputTipSetServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEFInputTipSetServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEFInputTipSetServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEFInputTipSet> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEFInputTipSet pSDEFInputTipSet : arrayList) {
            this.remove(pSDEFInputTipSet);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEFInputTipSet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFInputTipSet(pSDEFInputTipSet);
        ((PSDataEntityServiceBase)pSCoreSysServiceBase).removeByPSDEFInputTipSet(pSDEFInputTipSet);
        pSCoreSysServiceBase = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFInputTipServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFInputTipSet(pSDEFInputTipSet);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFInputTipSet(pSDEFInputTipSet);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFInputTipSet(pSDEFInputTipSet);
        super.onBeforeRemove(pSDEFInputTipSet);
    }

    protected void replaceParentInfo(PSDEFInputTipSet pSDEFInputTipSet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFInputTipSet, cloneSession);
        if (pSDEFInputTipSet.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFInputTipSet.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEFInputTipSet, (PSDataEntity)iEntity);
        }
        if (pSDEFInputTipSet.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEFInputTipSet.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEFInputTipSet, (PSDEDataSet)iEntity);
        }
        if (pSDEFInputTipSet.getContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFInputTipSet.getContentPSDEFId())) != null) {
            this.onFillParentInfo_ContentPSDEF(pSDEFInputTipSet, (PSDEField)iEntity);
        }
        if (pSDEFInputTipSet.getECPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFInputTipSet.getECPSDEFId())) != null) {
            this.onFillParentInfo_ECPSDEF(pSDEFInputTipSet, (PSDEField)iEntity);
        }
        if (pSDEFInputTipSet.getLinkPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFInputTipSet.getLinkPSDEFId())) != null) {
            this.onFillParentInfo_LinkPSDEF(pSDEFInputTipSet, (PSDEField)iEntity);
        }
        if (pSDEFInputTipSet.getUniqueTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFInputTipSet.getUniqueTagPSDEFId())) != null) {
            this.onFillParentInfo_UniqueTagPSDEF(pSDEFInputTipSet, (PSDEField)iEntity);
        }
        if (pSDEFInputTipSet.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSDEFInputTipSet.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSDEFInputTipSet, (PSModule)iEntity);
        }
        if (pSDEFInputTipSet.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEFInputTipSet.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEFInputTipSet, (PSSysPFPlugin)iEntity);
        }
        if (pSDEFInputTipSet.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEFInputTipSet.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEFInputTipSet, (PSSysSFPlugin)iEntity);
        }
        if (pSDEFInputTipSet.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEFInputTipSet.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEFInputTipSet, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFInputTipSet, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEFInputTipSet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFName(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ECPSDEFId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ECPSDEFName(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFName(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFInputTipSetId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFInputTipSetName(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTagPSDEFId(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTagPSDEFName(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFInputTipSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFInputTipSet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isCodeNameDirty() : !pSDEFInputTipSet.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEFInputTipSet, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEFInputTipSetDEModel(), "CODENAME", string3, pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_ContentPSDEFId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isContentPSDEFIdDirty() : !pSDEFInputTipSet.isContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFId_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isContentPSDEFNameDirty() : !pSDEFInputTipSet.isContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFName_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ECPSDEFId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isECPSDEFIdDirty() : !pSDEFInputTipSet.isECPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getECPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ECPSDEFId_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ECPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ECPSDEFName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isECPSDEFNameDirty() : !pSDEFInputTipSet.isECPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getECPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ECPSDEFName_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ECPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEFId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isLinkPSDEFIdDirty() : !pSDEFInputTipSet.isLinkPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getLinkPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFId_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEFName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isLinkPSDEFNameDirty() : !pSDEFInputTipSet.isLinkPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getLinkPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFName_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isLockFlagDirty() : !pSDEFInputTipSet.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEFInputTipSet.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isMemoDirty() : !pSDEFInputTipSet.isMemoDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSDEDataSetIdDirty() : !pSDEFInputTipSet.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFInputTipSetId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSDEFInputTipSetIdDirty() && !bl2 : !pSDEFInputTipSet.isPSDEFInputTipSetIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSDEFInputTipSetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPSETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFInputTipSetId_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPSETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFInputTipSetName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSDEFInputTipSetNameDirty() && !bl2 : !pSDEFInputTipSet.isPSDEFInputTipSetNameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSDEFInputTipSetName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPSETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFInputTipSetName_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPSETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSDEIdDirty() : !pSDEFInputTipSet.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSDENameDirty() : !pSDEFInputTipSet.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSModuleIdDirty() : !pSDEFInputTipSet.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSSysPFPluginIdDirty() : !pSDEFInputTipSet.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSSysSFPluginIdDirty() : !pSDEFInputTipSet.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSSystemIdDirty() : !pSDEFInputTipSet.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isPSSystemNameDirty() : !pSDEFInputTipSet.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UniqueTagPSDEFId(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isUniqueTagPSDEFIdDirty() : !pSDEFInputTipSet.isUniqueTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getUniqueTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTagPSDEFId_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniqueTagPSDEFName(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isUniqueTagPSDEFNameDirty() : !pSDEFInputTipSet.isUniqueTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getUniqueTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTagPSDEFName_Default(pSDEFInputTipSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isUserCatDirty() : !pSDEFInputTipSet.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isUserTagDirty() : !pSDEFInputTipSet.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isUserTag2Dirty() : !pSDEFInputTipSet.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isUserTag3Dirty() : !pSDEFInputTipSet.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFInputTipSet pSDEFInputTipSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFInputTipSet.isUserTag4Dirty() : !pSDEFInputTipSet.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFInputTipSet.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEFInputTipSet, bl2, bl3);
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

    protected void onSyncEntity(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFInputTipSet, bl);
    }

    protected void onSyncIndexEntities(PSDEFInputTipSet pSDEFInputTipSet, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFInputTipSet, bl);
    }

    public Object getDataContextValue(PSDEFInputTipSet pSDEFInputTipSet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFInputTipSet, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFInputTipSet pSDEFInputTipSet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFInputTipSet, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ECPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ECPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ECPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ECPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPSETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPSETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipSetName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UNIQUETAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniqueTagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIQUETAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniqueTagPSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ECPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ECPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ECPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ECPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEFInputTipSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPSETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFInputTipSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPSETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UniqueTagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIQUETAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniqueTagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIQUETAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFInputTipSet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        super.onUpdateParent(pSDEFInputTipSet);
    }

    @Override
    protected void exportCurXmlModel(PSDEFInputTipSet pSDEFInputTipSet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFINPUTTIPSET");
        if (!bl) {
            pSDEFInputTipSet.setCreateDate(null);
            pSDEFInputTipSet.setCreateMan(null);
            pSDEFInputTipSet.setPSDEFInputTipSetId(null);
            pSDEFInputTipSet.setUpdateDate(null);
            pSDEFInputTipSet.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFInputTipSet, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFInputTipSet pSDEFInputTipSet, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFInputTipSet, string);
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
            return "DER1N_PSDEFINPUTTIPSET_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFINPUTTIPSET_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSDEFInputTipSet pSDEFInputTipSet) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFInputTipSet.getCodeName())) {
            return pSDEFInputTipSet.getCodeName();
        }
        return super.getModelV2Tag(pSDEFInputTipSet);
    }

    @Override
    public boolean setModelV2Tag(PSDEFInputTipSet pSDEFInputTipSet, String string) {
        pSDEFInputTipSet.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFInputTipSet pSDEFInputTipSet, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFInputTipSet.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFInputTipSet, true);
        pSDEFInputTipSet.set("CODENAME", string);
        if (this.select(pSDEFInputTipSet, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFInputTipSet, true);
        return super.getModelV2Entity(pSDEFInputTipSet, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFInputTipSet pSDEFInputTipSet, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEFInputTipSet, objectNode, string, string2, n);
    }
}

