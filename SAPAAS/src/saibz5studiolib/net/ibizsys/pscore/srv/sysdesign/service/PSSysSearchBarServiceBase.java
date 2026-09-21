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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSearchBarDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSearchBarDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchBarServiceBase
extends PSCoreSysServiceBase<PSSysSearchBar> {
    private static final Log log = LogFactory.getLog(PSSysSearchBarServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSearchBarDEModel pSSysSearchBarDEModel;
    private PSSysSearchBarDAO pSSysSearchBarDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService";
    }

    public PSSysSearchBarDEModel getPSSysSearchBarDEModel() {
        if (this.pSSysSearchBarDEModel == null) {
            try {
                this.pSSysSearchBarDEModel = (PSSysSearchBarDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSearchBarDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchBarDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSearchBarDEModel();
    }

    public PSSysSearchBarDAO getPSSysSearchBarDAO() {
        if (this.pSSysSearchBarDAO == null) {
            try {
                this.pSSysSearchBarDAO = (PSSysSearchBarDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSearchBarDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchBarDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSearchBarDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysSearchBar pSSysSearchBar, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysSearchBar, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlMsg);
            } else {
                iService.get((IEntity)pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSSysSearchBar, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysSearchBar, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSLANGUAGERES_GROUPMORETEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_GroupMoreTextPSLanRes(pSSysSearchBar, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysSearchBar, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCounter);
            } else {
                iService.get((IEntity)pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSSysSearchBar, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysSearchBar, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysSearchBar, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysSearchBar, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHBAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsgGroup);
            } else {
                iService.get((IEntity)pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSSysSearchBar, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSearchBar, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSSysSearchBar pSSysSearchBar, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSSysSearchBar.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSSysSearchBar.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSSysSearchBar pSSysSearchBar, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSSysSearchBar.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSSysSearchBar.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDE(PSSysSearchBar pSSysSearchBar, PSDataEntity pSDataEntity) throws Exception {
        pSSysSearchBar.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysSearchBar.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_GroupMoreTextPSLanRes(PSSysSearchBar pSSysSearchBar, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysSearchBar.setGroupMoreTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysSearchBar.setGroupMoreTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSSysSearchBar pSSysSearchBar, PSModule pSModule) throws Exception {
        pSSysSearchBar.setPSModuleId(pSModule.getPSModuleId());
        pSSysSearchBar.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysCounter(PSSysSearchBar pSSysSearchBar, PSSysCounter pSSysCounter) throws Exception {
        pSSysSearchBar.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSSysSearchBar.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysSearchBar pSSysSearchBar, PSSysCss pSSysCss) throws Exception {
        pSSysSearchBar.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysSearchBar.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysSearchBar pSSysSearchBar, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysSearchBar.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysSearchBar.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysSearchBar pSSysSearchBar, PSSystem pSSystem) throws Exception {
        pSSysSearchBar.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSearchBar.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSSysSearchBar pSSysSearchBar, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSSysSearchBar.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSSysSearchBar.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        if (bl && pSSysSearchBar.getMobFlag() == null) {
            pSSysSearchBar.setMobFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSDE(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_GroupMoreTextPSLanRes(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSModule(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysSearchBar, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSSysSearchBar, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        if (pSSysSearchBar.isPSDEIdDirty()) {
            if (pSSysSearchBar.getPSDEId() != null) {
                if (pSSysSearchBar.getPSDEId() == null || pSSysSearchBar.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysSearchBar.getPSDE();
                    pSSysSearchBar.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysSearchBar.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupMoreTextPSLanRes(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        if (pSSysSearchBar.isGroupMoreTextPSLanResIdDirty()) {
            if (pSSysSearchBar.getGroupMoreTextPSLanResId() != null) {
                if (pSSysSearchBar.getGroupMoreTextPSLanResId() == null || pSSysSearchBar.getGroupMoreTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysSearchBar.getGroupMoreTextPSLanRes();
                    pSSysSearchBar.setGroupMoreTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysSearchBar.setGroupMoreTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        if (pSSysSearchBar.isPSSystemIdDirty()) {
            if (pSSysSearchBar.getPSSystemId() != null) {
                if (pSSysSearchBar.getPSSystemId() == null || pSSysSearchBar.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysSearchBar.getPSSystem();
                    pSSysSearchBar.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysSearchBar.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSearchBar, bl);
    }

    public ArrayList<PSSysSearchBar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLLOGICGROUPID", (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlLogicGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlLogicGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchBar> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMSGID", (Object)pSCtrlMsgBase.getPSCtrlMsgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchBar> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchBar> selectByGroupMoreTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByGroupMoreTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByGroupMoreTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByGroupMoreTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByGroupMoreTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPMORETEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupMoreTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupMoreTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchBar> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchBar> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCOUNTERID", (Object)pSSysCounterBase.getPSSysCounterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCounterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCounterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchBar> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSearchBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchBar> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSearchBar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSSysSearchBar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSCtrlLogicGroupId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSCtrlMsgId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSDEId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByGroupMoreTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSLANGUAGERES_GROUPMORETEXTPSLANRESID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByGroupMoreTextPSLanRes(pSLanguageRes);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setGroupMoreTextPSLanResId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByGroupMoreTextPSLanRes(pSLanguageRes2);
                PSSysSearchBarServiceBase.this.internalRemoveByGroupMoreTextPSLanRes(pSLanguageRes2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByGroupMoreTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByGroupMoreTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByGroupMoreTextPSLanRes(pSLanguageRes, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByGroupMoreTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupMoreTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSModule(pSModule);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSModuleId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSSysCounterId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSSysCssId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSSysPFPluginId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSSystemId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHBAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSSYSSEARCHBAR", iDataEntityModel.getDataInfo((IEntity)pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            PSSysSearchBar pSSysSearchBar2 = (PSSysSearchBar)this.getDEModel().createEntity();
            pSSysSearchBar2.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
            pSSysSearchBar2.setPSViewMsgGroupId(null);
            this.update(pSSysSearchBar2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchBarServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysSearchBarServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysSearchBarServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysSearchBar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSSysSearchBar pSSysSearchBar : arrayList) {
            this.remove((IEntity)pSSysSearchBar);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysSearchBar> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSearchBar pSSysSearchBar) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchBar(pSSysSearchBar);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchBar(pSSysSearchBar);
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).removeByPSSysSearchBar(pSSysSearchBar);
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchBar(pSSysSearchBar);
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).removeByPSSysSearchBar(pSSysSearchBar);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysSearchBar(pSSysSearchBar);
        super.onBeforeRemove(pSSysSearchBar);
    }

    protected void onBeforeRemoveTemp(PSSysSearchBar pSSysSearchBar) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).removeTempByPSSysSearchBar(pSSysSearchBar);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).removeTempByPSSysSearchBar(pSSysSearchBar);
        super.onBeforeRemoveTemp((IEntity)pSSysSearchBar);
    }

    protected void getRelatedDataTempMajor(PSSysSearchBar pSSysSearchBar) throws Exception {
        this.getRelatedDataTempMajor_PSSysSearchBarItem(pSSysSearchBar);
        this.getRelatedDataTempMajor_PSSysSearchBarLogic(pSSysSearchBar);
        super.getRelatedDataTempMajor((IEntity)pSSysSearchBar);
    }

    protected void getRelatedDataTempMajor_PSSysSearchBarItem(PSSysSearchBar pSSysSearchBar) throws Exception {
        PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysSearchBarItem> arrayList = null;
        String string = pSSysSearchBar.getPSSysSearchBarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysSearchBarItemService.selectByPSSysSearchBar(pSSysSearchBar) : pSSysSearchBarItemService.selectTempByPSSysSearchBar(pSSysSearchBar);
        for (PSSysSearchBarItem pSSysSearchBarItem : arrayList) {
            pSSysSearchBarItemService.getTempMajor(pSSysSearchBarItem);
        }
    }

    protected void getRelatedDataTempMajor_PSSysSearchBarLogic(PSSysSearchBar pSSysSearchBar) throws Exception {
        PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysSearchBarLogic> arrayList = null;
        String string = pSSysSearchBar.getPSSysSearchBarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysSearchBarLogicService.selectByPSSysSearchBar(pSSysSearchBar) : pSSysSearchBarLogicService.selectTempByPSSysSearchBar(pSSysSearchBar);
        for (PSSysSearchBarLogic pSSysSearchBarLogic : arrayList) {
            pSSysSearchBarLogicService.getTempMajor(pSSysSearchBarLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysSearchBar pSSysSearchBar, PSSysSearchBar pSSysSearchBar2) throws Exception {
        ArrayList<PSSysSearchBarLogic> arrayList = this.updateRelatedDataTempMajor_removePSSysSearchBarLogic(pSSysSearchBar, pSSysSearchBar2);
        ArrayList<PSSysSearchBarItem> arrayList2 = this.updateRelatedDataTempMajor_removePSSysSearchBarItem(pSSysSearchBar, pSSysSearchBar2);
        this.updateRelatedDataTempMajor_updatePSSysSearchBarItem(pSSysSearchBar, pSSysSearchBar2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSSysSearchBarLogic(pSSysSearchBar, pSSysSearchBar2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysSearchBar, (IEntity)pSSysSearchBar2);
    }

    protected ArrayList<PSSysSearchBarItem> updateRelatedDataTempMajor_removePSSysSearchBarItem(PSSysSearchBar pSSysSearchBar, PSSysSearchBar pSSysSearchBar2) throws Exception {
        PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysSearchBarItem> arrayList = pSSysSearchBarItemService.selectTempByPSSysSearchBar(pSSysSearchBar);
        ArrayList<PSSysSearchBarItem> arrayList2 = pSSysSearchBarItemService.selectByPSSysSearchBar(pSSysSearchBar2);
        HashMap<String, PSSysSearchBarItem> hashMap = new HashMap<String, PSSysSearchBarItem>();
        for (PSSysSearchBarItem pSSysSearchBarItem : arrayList2) {
            hashMap.put(pSSysSearchBarItem.getPSSysSearchBarItemId(), pSSysSearchBarItem);
        }
        for (PSSysSearchBarItem pSSysSearchBarItem : arrayList) {
            Object object = pSSysSearchBarItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysSearchBarItem pSSysSearchBarItem : hashMap.values()) {
            pSSysSearchBarItemService.remove((IEntity)pSSysSearchBarItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysSearchBarItem(PSSysSearchBar pSSysSearchBar, PSSysSearchBar pSSysSearchBar2, ArrayList<PSSysSearchBarItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysSearchBarItem pSSysSearchBarItem : arrayList) {
            pSSysSearchBarItemService.updateTempMajor(pSSysSearchBarItem);
        }
    }

    protected ArrayList<PSSysSearchBarLogic> updateRelatedDataTempMajor_removePSSysSearchBarLogic(PSSysSearchBar pSSysSearchBar, PSSysSearchBar pSSysSearchBar2) throws Exception {
        PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysSearchBarLogic> arrayList = pSSysSearchBarLogicService.selectTempByPSSysSearchBar(pSSysSearchBar);
        ArrayList<PSSysSearchBarLogic> arrayList2 = pSSysSearchBarLogicService.selectByPSSysSearchBar(pSSysSearchBar2);
        HashMap<String, PSSysSearchBarLogic> hashMap = new HashMap<String, PSSysSearchBarLogic>();
        for (PSSysSearchBarLogic pSSysSearchBarLogic : arrayList2) {
            hashMap.put(pSSysSearchBarLogic.getPSSysSearchBarLogicId(), pSSysSearchBarLogic);
        }
        for (PSSysSearchBarLogic pSSysSearchBarLogic : arrayList) {
            Object object = pSSysSearchBarLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysSearchBarLogic pSSysSearchBarLogic : hashMap.values()) {
            pSSysSearchBarLogicService.remove((IEntity)pSSysSearchBarLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysSearchBarLogic(PSSysSearchBar pSSysSearchBar, PSSysSearchBar pSSysSearchBar2, ArrayList<PSSysSearchBarLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysSearchBarLogic pSSysSearchBarLogic : arrayList) {
            pSSysSearchBarLogicService.updateTempMajor(pSSysSearchBarLogic);
        }
    }

    protected void replaceParentInfo(PSSysSearchBar pSSysSearchBar, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSearchBar, cloneSession);
        if (pSSysSearchBar.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSSysSearchBar.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysSearchBar, (PSCtrlLogicGroup)iEntity);
        }
        if (pSSysSearchBar.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSSysSearchBar.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSSysSearchBar, (PSCtrlMsg)iEntity);
        }
        if (pSSysSearchBar.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysSearchBar.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysSearchBar, (PSDataEntity)iEntity);
        }
        if (pSSysSearchBar.getGroupMoreTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysSearchBar.getGroupMoreTextPSLanResId())) != null) {
            this.onFillParentInfo_GroupMoreTextPSLanRes(pSSysSearchBar, (PSLanguageRes)iEntity);
        }
        if (pSSysSearchBar.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysSearchBar.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysSearchBar, (PSModule)iEntity);
        }
        if (pSSysSearchBar.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSSysSearchBar.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSSysSearchBar, (PSSysCounter)iEntity);
        }
        if (pSSysSearchBar.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysSearchBar.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysSearchBar, (PSSysCss)iEntity);
        }
        if (pSSysSearchBar.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysSearchBar.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysSearchBar, (PSSysPFPlugin)iEntity);
        }
        if (pSSysSearchBar.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysSearchBar.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysSearchBar, (PSSystem)iEntity);
        }
        if (pSSysSearchBar.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSSysSearchBar.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSSysSearchBar, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSearchBar, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BarStyle(bl, pSSysSearchBar, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomized(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableQuickSearch(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMode(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMoreText(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMoreTextPSLanResId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMoreTextPSLanResName(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobFlag(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchBarId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchBarName(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickGroupCnt(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickSearchWidth(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSearchBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSearchBar, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BarStyle(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isBarStyleDirty() : !pSSysSearchBar.isBarStyleDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getBarStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BarStyle_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BARSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isBusyIndicatorDirty() : !pSSysSearchBar.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSSysSearchBar.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUSYINDICATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isCodeNameDirty() && !bl2 : !pSSysSearchBar.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysSearchBar, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysSearchBarDEModel(), "CODENAME", string3, pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableCustomized(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isEnableCustomizedDirty() : !pSSysSearchBar.isEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSSysSearchBar.getEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomized_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMIZED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableQuickSearch(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isEnableQuickSearchDirty() : !pSSysSearchBar.isEnableQuickSearchDirty()) {
            return null;
        }
        Integer n = pSSysSearchBar.getEnableQuickSearch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableQuickSearch_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEQUICKSEARCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMode(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isGroupModeDirty() : !pSSysSearchBar.isGroupModeDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMode_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMoreText(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isGroupMoreTextDirty() : !pSSysSearchBar.isGroupMoreTextDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getGroupMoreText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMoreText_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMORETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMoreTextPSLanResId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isGroupMoreTextPSLanResIdDirty() : !pSSysSearchBar.isGroupMoreTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getGroupMoreTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMoreTextPSLanResId_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMORETEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMoreTextPSLanResName(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isGroupMoreTextPSLanResNameDirty() : !pSSysSearchBar.isGroupMoreTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getGroupMoreTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMoreTextPSLanResName_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMORETEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isLockFlagDirty() : !pSSysSearchBar.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchBar.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isMemoDirty() : !pSSysSearchBar.isMemoDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobFlag(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isMobFlagDirty() : !pSSysSearchBar.isMobFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchBar.getMobFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobFlag_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSCtrlLogicGroupIdDirty() : !pSSysSearchBar.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSCtrlMsgIdDirty() : !pSSysSearchBar.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSDEIdDirty() && !bl2 : !pSSysSearchBar.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSDENameDirty() && !bl2 : !pSSysSearchBar.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSModuleIdDirty() : !pSSysSearchBar.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSSysCounterIdDirty() : !pSSysSearchBar.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCOUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSSysCssIdDirty() : !pSSysSearchBar.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSSysPFPluginIdDirty() : !pSSysSearchBar.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSearchBarId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSSysSearchBarIdDirty() && !bl2 : !pSSysSearchBar.isPSSysSearchBarIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSSysSearchBarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchBarId_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchBarName(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSSysSearchBarNameDirty() && !bl2 : !pSSysSearchBar.isPSSysSearchBarNameDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSSysSearchBarName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHBARNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchBarName_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHBARNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSSystemIdDirty() && !bl2 : !pSSysSearchBar.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSSystemNameDirty() && !bl2 : !pSSysSearchBar.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isPSViewMsgGroupIdDirty() : !pSSysSearchBar.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QuickGroupCnt(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isQuickGroupCntDirty() : !pSSysSearchBar.isQuickGroupCntDirty()) {
            return null;
        }
        Integer n = pSSysSearchBar.getQuickGroupCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_QuickGroupCnt_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUICKGROUPCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QuickSearchWidth(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isQuickSearchWidthDirty() : !pSSysSearchBar.isQuickSearchWidthDirty()) {
            return null;
        }
        Integer n = pSSysSearchBar.getQuickSearchWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_QuickSearchWidth_Default((IEntity)pSSysSearchBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUICKSEARCHWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isUserTagDirty() : !pSSysSearchBar.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSearchBar.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSearchBar pSSysSearchBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchBar.isUserTag2Dirty() : !pSSysSearchBar.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchBar.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysSearchBar, bl2, bl3);
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

    protected void onSyncEntity(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSearchBar, bl);
    }

    protected void onSyncIndexEntities(PSSysSearchBar pSSysSearchBar, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSearchBar, bl);
    }

    public Object getDataContextValue(PSSysSearchBar pSSysSearchBar, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSearchBar, string, iDataContextParam)) != null) {
            return object;
        }
        PSModule pSModule = pSSysSearchBar.getPSModule();
        if (pSModule != null && pSModule.contains(string)) {
            return pSModule.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSSysSearchBar pSSysSearchBar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSSysSearchBarLogic_PSSysSearchBar(pSSysSearchBar, arrayList, n);
        super.onExportRelatedModel((IEntity)pSSysSearchBar, arrayList, n);
    }

    protected void onExportRelatedModel_PSSysSearchBarLogic_PSSysSearchBar(PSSysSearchBar pSSysSearchBar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysSearchBarLogic> arrayList2 = pSSysSearchBarLogicService.selectByPSSysSearchBar(pSSysSearchBar);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"e9730d5b152c64bc5db8a0bfe0b6747c");
            jSONObject.put("srfdename", (Object)"PSSYSSEARCHBARLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSSYSSEARCHBARLOGIC_PSSYSSEARCHBAR_PSSYSSEARCHBARID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSSysSearchBar, (String)"PSSYSSEARCHBARID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSSysSearchBarLogic pSSysSearchBarLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSSysSearchBarLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSSysSearchBarLogicService.exportModel(pSSysSearchBarLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSSysSearchBar pSSysSearchBar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSearchBar, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BARSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BarStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEQUICKSEARCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableQuickSearch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMORETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMoreText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMORETEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMoreTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMORETEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMoreTextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchBarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchBarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKGROUPCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickGroupCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKSEARCHWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickSearchWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BarStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BARSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_EnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableQuickSearch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMoreText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMORETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMoreTextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMORETEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMoreTextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMORETEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_MobFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSCtrlLogicGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysCounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSearchBarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchBarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickGroupCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_QuickSearchWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSearchBar pSSysSearchBar) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysSearchBar)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSearchBar pSSysSearchBar) throws Exception {
        super.onUpdateParent((IEntity)pSSysSearchBar);
    }

    protected void onCopyDetails(PSSysSearchBar pSSysSearchBar, Object object) throws Exception {
        PSSysSearchBar pSSysSearchBar2 = new PSSysSearchBar();
        pSSysSearchBar2.set("PSSYSSEARCHBARID", object);
        String string = DataObject.getStringValue((Object)pSSysSearchBar.get("PSSYSSEARCHBARID"));
        super.onCopyDetails((IEntity)pSSysSearchBar, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysSearchBar pSSysSearchBar, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSEARCHBAR");
        if (!bl) {
            pSSysSearchBar.setCreateDate(null);
            pSSysSearchBar.setCreateMan(null);
            pSSysSearchBar.setPSSysSearchBarId(null);
            pSSysSearchBar.setUpdateDate(null);
            pSSysSearchBar.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSearchBar, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysSearchBar pSSysSearchBar, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysSearchBarItem(pSSysSearchBar, xmlNode);
        this.exportRelatedXmlModel_PSSysSearchBarLogic(pSSysSearchBar, xmlNode);
        super.onExportRelatedXmlModel(pSSysSearchBar, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysSearchBarItem(PSSysSearchBar pSSysSearchBar, XmlNode xmlNode) throws Exception {
        PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysSearchBarItem> arrayList = null;
        String string = pSSysSearchBar.getPSSysSearchBarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysSearchBarItemService.selectByPSSysSearchBar(pSSysSearchBar, "ORDER BY ORDERVALUE ASC") : pSSysSearchBarItemService.selectTempByPSSysSearchBar(pSSysSearchBar, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSSEARCHBARITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysSearchBarItem pSSysSearchBarItem : arrayList) {
                pSSysSearchBarItem.set("ORDERVALUE", null);
                pSSysSearchBarItemService.exportXmlModel(pSSysSearchBarItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysSearchBarLogic(PSSysSearchBar pSSysSearchBar, XmlNode xmlNode) throws Exception {
        PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysSearchBarLogic> arrayList = null;
        String string = pSSysSearchBar.getPSSysSearchBarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysSearchBarLogicService.selectByPSSysSearchBar(pSSysSearchBar, "ORDER BY ORDERVALUE ASC") : pSSysSearchBarLogicService.selectTempByPSSysSearchBar(pSSysSearchBar, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSSEARCHBARLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSSysSearchBarLogic pSSysSearchBarLogic : arrayList) {
                pSSysSearchBarLogic.set("ORDERVALUE", null);
                pSSysSearchBarLogicService.exportXmlModel(pSSysSearchBarLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysSearchBar pSSysSearchBar, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSSEARCHBARITEMS");
        this.importRelatedXmlModel_PSSysSearchBarItem(pSSysSearchBar, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSSYSSEARCHBARLOGICS");
        this.importRelatedXmlModel_PSSysSearchBarLogic(pSSysSearchBar, xmlNode3);
        super.onImportRelatedXmlModel(pSSysSearchBar, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysSearchBarItem(PSSysSearchBar pSSysSearchBar, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysSearchBar.getPSSysSearchBarId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysSearchBarItemService.removeByPSSysSearchBar(pSSysSearchBar);
        } else {
            pSSysSearchBarItemService.removeTempByPSSysSearchBar(pSSysSearchBar);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysSearchBarItem pSSysSearchBarItem = new PSSysSearchBarItem();
                pSSysSearchBarItem.setOrderValue(n);
                n += 100;
                pSSysSearchBarItemService.fillParentInfo((IEntity)pSSysSearchBarItem, "DER1N", "DER1N_PSSYSSEARCHBARITEM_PSSYSSEARCHBAR_PSSYSSEARCHBARID", pSSysSearchBar.getPSSysSearchBarId());
                pSSysSearchBarItemService.importXmlModel(pSSysSearchBarItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysSearchBarLogic(PSSysSearchBar pSSysSearchBar, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysSearchBar.getPSSysSearchBarId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysSearchBarLogicService.removeByPSSysSearchBar(pSSysSearchBar);
        } else {
            pSSysSearchBarLogicService.removeTempByPSSysSearchBar(pSSysSearchBar);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysSearchBarLogic pSSysSearchBarLogic = new PSSysSearchBarLogic();
                pSSysSearchBarLogic.setOrderValue(n);
                n += 100;
                pSSysSearchBarLogicService.fillParentInfo((IEntity)pSSysSearchBarLogic, "DER1N", "DER1N_PSSYSSEARCHBARLOGIC_PSSYSSEARCHBAR_PSSYSSEARCHBARID", pSSysSearchBar.getPSSysSearchBarId());
                pSSysSearchBarLogicService.importXmlModel(pSSysSearchBarLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSearchBar pSSysSearchBar, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSearchBar, string);
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
            return "DER1N_PSSYSSEARCHBAR_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHBAR_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHBAR_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysSearchBar pSSysSearchBar) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchBar.getCodeName())) {
            return pSSysSearchBar.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchBar.getCodeName())) {
            return pSSysSearchBar.getCodeName();
        }
        return super.getModelV2Tag(pSSysSearchBar);
    }

    @Override
    public boolean setModelV2Tag(PSSysSearchBar pSSysSearchBar, String string) {
        pSSysSearchBar.setCodeName(string);
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
    public boolean getModelV2Entity(PSSysSearchBar pSSysSearchBar, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSearchBar.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSearchBar, true);
        pSSysSearchBar.set("CODENAME", string);
        if (this.select(pSSysSearchBar, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSearchBar, true);
        return super.getModelV2Entity(pSSysSearchBar, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSearchBar pSSysSearchBar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSearchBar, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSSEARCHBARITEM_PSSYSSEARCHBAR_PSSYSSEARCHBARID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSSYSSEARCHBARLOGIC_PSSYSSEARCHBAR_PSSYSSEARCHBARID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysSearchBar pSSysSearchBar, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysSearchBar, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysSearchBar pSSysSearchBar, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSSysSearchBarItem> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSEARCHBARITEM_PSSYSSEARCHBAR_PSSYSSEARCHBARID")) {
            pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHBAR#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSEARCHBARITEM", (Object)pSSysSearchBar.getPSSysSearchBarId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysSearchBarItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysSearchBarItem>();
                object3 = ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).selectByPSSysSearchBar(pSSysSearchBar);
                arrayNode = StringHelper.format((String)"PSSYSSEARCHBAR#%1$s", (Object)pSSysSearchBar.getPSSysSearchBarId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysSearchBarItem)object2.next();
                    object = ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysSearchBarItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssyssearchbaritemname")) {
                            string = objectNode.get("pssyssearchbaritemname").asText();
                        }
                        if (objectNode2.has("pssyssearchbaritemname")) {
                            string2 = objectNode2.get("pssyssearchbaritemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysSearchBarItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSSEARCHBARLOGIC_PSSYSSEARCHBAR_PSSYSSEARCHBARID")) {
            pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSSEARCHBAR#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSSEARCHBARLOGIC", (Object)pSSysSearchBar.getPSSysSearchBarId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysSearchBarItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).selectByPSSysSearchBar(pSSysSearchBar);
                arrayNode = StringHelper.format((String)"PSSYSSEARCHBAR#%1$s", (Object)pSSysSearchBar.getPSSysSearchBarId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysSearchBarLogic)object2.next();
                    object = ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysSearchBarItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssyssearchbarlogicname")) {
                            string = objectNode.get("pssyssearchbarlogicname").asText();
                        }
                        if (objectNode2.has("pssyssearchbarlogicname")) {
                            string2 = objectNode2.get("pssyssearchbarlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysSearchBarLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysSearchBar, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysSearchBar pSSysSearchBar) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).selectByPSSysSearchBar(pSSysSearchBar);
        String string2 = StringHelper.format((String)"PSSYSSEARCHBAR#%1$s", (Object)pSSysSearchBar.getPSSysSearchBarId());
        for (PSSysSearchBarItem entityBase : arrayList) {
            string = ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSSysSearchBar.getPSSysSearchBarId());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSSEARCHBARITEM WHERE PSSYSSEARCHBARID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).selectByPSSysSearchBar(pSSysSearchBar);
        string2 = StringHelper.format((String)"PSSYSSEARCHBAR#%1$s", (Object)pSSysSearchBar.getPSSysSearchBarId());
        for (PSSysSearchBarLogic pSSysSearchBarLogic : arrayList) {
            string = ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSSysSearchBarLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysSearchBarLogic);
        }
        object = new SqlParamList();
        object.addString(pSSysSearchBar.getPSSysSearchBarId());
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSSEARCHBARLOGIC WHERE PSSYSSEARCHBARID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysSearchBar);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysSearchBar pSSysSearchBar, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysSearchBarItem();
        entityBase.set("PSSYSSEARCHBARID", pSSysSearchBar.getPSSysSearchBarId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysSearchBarLogic();
        entityBase.set("PSSYSSEARCHBARID", pSSysSearchBar.getPSSysSearchBarId());
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysSearchBar, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysSearchBar pSSysSearchBar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysSearchBarItem();
                ((PSSysSearchBarItemBase)object).setMobFlag(pSSysSearchBar.getMobFlag());
                ((PSSysSearchBarItemBase)object).setPSDEId(pSSysSearchBar.getPSDEId());
                ((PSSysSearchBarItemBase)object).setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
                ((PSSysSearchBarItemBase)object).setPSSysSearchBarName(pSSysSearchBar.getPSSysSearchBarName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysSearchBarItem();
                    entityBase.setMobFlag(pSSysSearchBar.getMobFlag());
                    entityBase.setPSDEId(pSSysSearchBar.getPSDEId());
                    entityBase.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
                    entityBase.setPSSysSearchBarName(pSSysSearchBar.getPSSysSearchBarName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysSearchBarLogic();
                ((PSSysSearchBarLogicBase)object).setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
                ((PSSysSearchBarLogicBase)object).setPSSysSearchBarName(pSSysSearchBar.getPSSysSearchBarName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysSearchBarLogic();
                    entityBase.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
                    entityBase.setPSSysSearchBarName(pSSysSearchBar.getPSSysSearchBarName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysSearchBar, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysSearchBar pSSysSearchBar, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHBARITEM_PSSYSSEARCHBAR_PSSYSSEARCHBARID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSearchBarItems(pSSysSearchBar, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSSEARCHBARLOGIC_PSSYSSEARCHBAR_PSSYSSEARCHBARID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysSearchBarLogics(pSSysSearchBar, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysSearchBar, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysSearchBarItems(PSSysSearchBar pSSysSearchBar, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSEARCHBARITEM", true), (boolean)false) == 0) {
            PSSysSearchBarItemService pSSysSearchBarItemService = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysSearchBarItem pSSysSearchBarItem = new PSSysSearchBarItem();
            pSSysSearchBarItem.setPSSysSearchBarItemId(pSMOSFile.getPSModelId());
            if (!pSSysSearchBarItemService.get((IEntity)pSSysSearchBarItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSearchBarItem.getPSSysSearchBarId(), (String)pSSysSearchBar.getPSSysSearchBarId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSearchBarItemService.exportModelV2(pSSysSearchBarItem);
            pSSysSearchBarItem.reset();
            if (!pSSysSearchBarItemService.setModelV2ResScope((IEntity)pSSysSearchBarItem, "PSSYSSEARCHBAR", pSSysSearchBar.getPSSysSearchBarId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSearchBarItemService.importModelV2(pSSysSearchBarItem, objectNode);
            SessionFactoryManager.commit();
            return pSSysSearchBarItemService.getFile((IEntity)pSSysSearchBarItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysSearchBarLogics(PSSysSearchBar pSSysSearchBar, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSSEARCHBARLOGIC", true), (boolean)false) == 0) {
            PSSysSearchBarLogicService pSSysSearchBarLogicService = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
            PSSysSearchBarLogic pSSysSearchBarLogic = new PSSysSearchBarLogic();
            pSSysSearchBarLogic.setPSSysSearchBarLogicId(pSMOSFile.getPSModelId());
            if (!pSSysSearchBarLogicService.get((IEntity)pSSysSearchBarLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysSearchBarLogic.getPSSysSearchBarId(), (String)pSSysSearchBar.getPSSysSearchBarId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysSearchBarLogicService.exportModelV2(pSSysSearchBarLogic);
            pSSysSearchBarLogic.reset();
            if (!pSSysSearchBarLogicService.setModelV2ResScope((IEntity)pSSysSearchBarLogic, "PSSYSSEARCHBAR", pSSysSearchBar.getPSSysSearchBarId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysSearchBarLogicService.importModelV2(pSSysSearchBarLogic, objectNode);
            SessionFactoryManager.commit();
            return pSSysSearchBarLogicService.getFile((IEntity)pSSysSearchBarLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysSearchBar pSSysSearchBar, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysSearchBarItems(pSSysSearchBar, list);
        this.onFillPasteHelps_PSSysSearchBarLogics(pSSysSearchBar, list);
        super.onFillPasteHelps(pSSysSearchBar, list);
    }

    protected void onFillPasteHelps_PSSysSearchBarItems(PSSysSearchBar pSSysSearchBar, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSEARCHBARITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSEARCHBARITEM_PSSYSSEARCHBAR_PSSYSSEARCHBARID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u641c\u7d22\u680f]\u7684[\u641c\u7d22\u680f\u9879]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysSearchBarLogics(PSSysSearchBar pSSysSearchBar, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSSEARCHBARLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSSYSSEARCHBARLOGIC_PSSYSSEARCHBAR_PSSYSSEARCHBARID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u641c\u7d22\u680f]\u7684[\u641c\u7d22\u680f\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}

