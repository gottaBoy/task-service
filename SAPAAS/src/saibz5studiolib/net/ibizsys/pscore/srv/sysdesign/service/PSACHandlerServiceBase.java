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
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFACHandler;
import net.ibizsys.pscore.srv.config.entity.PSSFACHandlerBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSACHandlerDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSACHandlerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerAction;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTaskBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniStateBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDRBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSACHandlerServiceBase
extends PSCoreSysServiceBase<PSACHandler> {
    private static final Log log = LogFactory.getLog(PSACHandlerServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_SYSANDDERANGE = "SysAndDERange";
    private PSACHandlerDEModel pSACHandlerDEModel;
    private PSACHandlerDAO pSACHandlerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService";
    }

    public PSACHandlerDEModel getPSACHandlerDEModel() {
        if (this.pSACHandlerDEModel == null) {
            try {
                this.pSACHandlerDEModel = (PSACHandlerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSACHandlerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSACHandlerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSACHandlerDEModel();
    }

    public PSACHandlerDAO getPSACHandlerDAO() {
        if (this.pSACHandlerDAO == null) {
            try {
                this.pSACHandlerDAO = (PSACHandlerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSACHandlerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSACHandlerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSACHandlerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_SYSANDDERANGE, (boolean)true) == 0) {
            return this.fetchSysAndDERange(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchSysAndDERange(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_SYSANDDERANGE, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSACHandler pSACHandler, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDATAENTITY_GROUPPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_GroupPSDE(pSACHandler, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSACHandler, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_COPYPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_CopyPSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_CREATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_CreatePSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_GETDRAFTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_GetDraftPSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_GETPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_GetPSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_GROUPMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_GroupMovePSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_MOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_MovePSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_USER2PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_User2PSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEACTION_USERPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_UserPSDEAction(pSACHandler, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSACHandler, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEOPPRIV_CREATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_CreatePSDEOPPriv(pSACHandler, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEOPPRIV_EXPORTPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_ExportPSDEOPPriv(pSACHandler, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEOPPRIV_READPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_ReadPSDEOPPriv(pSACHandler, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEOPPRIV_REMOVEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_RemovePSDEOPPriv(pSACHandler, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEOPPRIV_UPDATEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_UpdatePSDEOPPriv(pSACHandler, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEOPPRIV_USER2PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_User2PSDEOPPriv(pSACHandler, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSDEOPPRIV_USERPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_UserPSDEOPPriv(pSACHandler, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSACHandler, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSFACHANDLER_PSSFACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFACHandlerService", (SessionFactory)this.getSessionFactory());
            PSSFACHandler pSSFACHandler = (PSSFACHandler)iService.getDEModel().createEntity();
            pSSFACHandler.set("PSSFACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFACHandler);
            } else {
                iService.get(pSSFACHandler);
            }
            this.onFillParentInfo_PSSFACHandler(pSACHandler, pSSFACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSACHandler, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSACHandler, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSYSTASK_PSSYSTASKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService", (SessionFactory)this.getSessionFactory());
            PSSysTask pSSysTask = (PSSysTask)iService.getDEModel().createEntity();
            pSSysTask.set("PSSYSTASKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTask);
            } else {
                iService.get(pSSysTask);
            }
            this.onFillParentInfo_PSSysTask(pSACHandler, pSSysTask);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSACHandler, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSYSUNISTATE_PSSYSUNISTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService", (SessionFactory)this.getSessionFactory());
            PSSysUniState pSSysUniState = (PSSysUniState)iService.getDEModel().createEntity();
            pSSysUniState.set("PSSYSUNISTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniState);
            } else {
                iService.get(pSSysUniState);
            }
            this.onFillParentInfo_PSSysUniState(pSACHandler, pSSysUniState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSYSUSERDR_PSSYSUSERDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService", (SessionFactory)this.getSessionFactory());
            PSSysUserDR pSSysUserDR = (PSSysUserDR)iService.getDEModel().createEntity();
            pSSysUserDR.set("PSSYSUSERDRID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUserDR);
            } else {
                iService.get(pSSysUserDR);
            }
            this.onFillParentInfo_PSSysUserDR(pSACHandler, pSSysUserDR);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSACHANDLER_PSSYSUSERDR_PSSYSUSERDRID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService", (SessionFactory)this.getSessionFactory());
            PSSysUserDR pSSysUserDR = (PSSysUserDR)iService.getDEModel().createEntity();
            pSSysUserDR.set("PSSYSUSERDRID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUserDR);
            } else {
                iService.get(pSSysUserDR);
            }
            this.onFillParentInfo_PSSysUserDR2(pSACHandler, pSSysUserDR);
            return;
        }
        super.onFillParentInfo(pSACHandler, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_GroupPSDE(PSACHandler pSACHandler, PSDataEntity pSDataEntity) throws Exception {
        pSACHandler.setGroupPSDEId(pSDataEntity.getPSDataEntityId());
        pSACHandler.setGroupPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSACHandler pSACHandler, PSDataEntity pSDataEntity) throws Exception {
        pSACHandler.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSACHandler.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSACHandler, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_CopyPSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setCopyPSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setCopyPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_CreatePSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setCreatePSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetDraftPSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setGetDraftPSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setGetDraftPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetPSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setGetPSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setGetPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GroupMovePSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setGroupMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setGroupMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_MovePSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_User2PSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setUser2PSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setUser2PSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UserPSDEAction(PSACHandler pSACHandler, PSDEAction pSDEAction) throws Exception {
        pSACHandler.setUserPSDEActionId(pSDEAction.getPSDEActionId());
        pSACHandler.setUserPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSACHandler pSACHandler, PSDEDataSet pSDEDataSet) throws Exception {
        pSACHandler.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSACHandler.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_CreatePSDEOPPriv(PSACHandler pSACHandler, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSACHandler.setCreatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSACHandler.setCreatePSDEOPPrivIName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_ExportPSDEOPPriv(PSACHandler pSACHandler, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSACHandler.setExportPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSACHandler.setExportPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_ReadPSDEOPPriv(PSACHandler pSACHandler, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSACHandler.setReadPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSACHandler.setReadPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_RemovePSDEOPPriv(PSACHandler pSACHandler, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSACHandler.setRemovePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSACHandler.setRemovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_UpdatePSDEOPPriv(PSACHandler pSACHandler, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSACHandler.setUpdatePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSACHandler.setUpdatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_User2PSDEOPPriv(PSACHandler pSACHandler, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSACHandler.setUser2PSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSACHandler.setUser2PSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_UserPSDEOPPriv(PSACHandler pSACHandler, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSACHandler.setUserPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSACHandler.setUserPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSModule(PSACHandler pSACHandler, PSModule pSModule) throws Exception {
        pSACHandler.setPSModuleId(pSModule.getPSModuleId());
        pSACHandler.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSFACHandler(PSACHandler pSACHandler, PSSFACHandler pSSFACHandler) throws Exception {
        pSACHandler.setPSSFACHandlerId(pSSFACHandler.getPSSFACHandlerId());
        pSACHandler.setPSSFACHandlerName(pSSFACHandler.getPSSFACHandlerName());
        pSACHandler.setPSSFId(pSSFACHandler.getPSSFId());
        pSACHandler.setPSSFName(pSSFACHandler.getPSSFName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSACHandler pSACHandler, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSACHandler.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSACHandler.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSACHandler pSACHandler, PSSysReqItem pSSysReqItem) throws Exception {
        pSACHandler.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSACHandler.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysTask(PSACHandler pSACHandler, PSSysTask pSSysTask) throws Exception {
        pSACHandler.setFinishFlag(pSSysTask.getFinishFlag());
        pSACHandler.setPSSysTaskId(pSSysTask.getPSSysTaskId());
        pSACHandler.setPSSysTaskName(pSSysTask.getPSSysTaskName());
    }

    protected void onFillParentInfo_PSSystem(PSACHandler pSACHandler, PSSystem pSSystem) throws Exception {
        pSACHandler.setPSSystemId(pSSystem.getPSSystemId());
        pSACHandler.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUniState(PSACHandler pSACHandler, PSSysUniState pSSysUniState) throws Exception {
        pSACHandler.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
        pSACHandler.setPSSysUniStateName(pSSysUniState.getPSSysUniStateName());
    }

    protected void onFillParentInfo_PSSysUserDR(PSACHandler pSACHandler, PSSysUserDR pSSysUserDR) throws Exception {
        pSACHandler.setPSSysUserDRId(pSSysUserDR.getPSSysUserDRId());
        pSACHandler.setPSSysUserDRName(pSSysUserDR.getPSSysUserDRName());
    }

    protected void onFillParentInfo_PSSysUserDR2(PSACHandler pSACHandler, PSSysUserDR pSSysUserDR) throws Exception {
        pSACHandler.setPSSysUserDRId2(pSSysUserDR.getPSSysUserDRId());
        pSACHandler.setPSSysUserDRName2(pSSysUserDR.getPSSysUserDRName());
    }

    protected void onFillEntityFullInfo(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSACHandler, bl);
        this.onFillEntityFullInfo_GroupPSDE(pSACHandler, bl);
        this.onFillEntityFullInfo_PSDE(pSACHandler, bl);
        this.onFillEntityFullInfo_CopyPSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_CreatePSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_GetDraftPSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_GetPSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_GroupMovePSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_MovePSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_User2PSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_UserPSDEAction(pSACHandler, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSACHandler, bl);
        this.onFillEntityFullInfo_CreatePSDEOPPriv(pSACHandler, bl);
        this.onFillEntityFullInfo_ExportPSDEOPPriv(pSACHandler, bl);
        this.onFillEntityFullInfo_ReadPSDEOPPriv(pSACHandler, bl);
        this.onFillEntityFullInfo_RemovePSDEOPPriv(pSACHandler, bl);
        this.onFillEntityFullInfo_UpdatePSDEOPPriv(pSACHandler, bl);
        this.onFillEntityFullInfo_User2PSDEOPPriv(pSACHandler, bl);
        this.onFillEntityFullInfo_UserPSDEOPPriv(pSACHandler, bl);
        this.onFillEntityFullInfo_PSModule(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSFACHandler(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSysTask(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSystem(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSysUniState(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSysUserDR(pSACHandler, bl);
        this.onFillEntityFullInfo_PSSysUserDR2(pSACHandler, bl);
    }

    protected void onFillEntityFullInfo_GroupPSDE(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isGroupPSDEIdDirty()) {
            if (pSACHandler.getGroupPSDEId() != null) {
                if (pSACHandler.getGroupPSDEId() == null || pSACHandler.getGroupPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSACHandler.getGroupPSDE();
                    pSACHandler.setGroupPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSACHandler.setGroupPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isPSDEIdDirty()) {
            if (pSACHandler.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSACHandler.getPSDEId() == null || pSACHandler.getPSDEName() == null) {
                    pSDataEntity = pSACHandler.getPSDE();
                    pSACHandler.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSACHandler.getPSDE()).getPSSystemId(), (Object)pSACHandler.getPSSystemId()) != 0L) {
                    pSACHandler.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSACHandler, bl);
                }
            } else {
                pSACHandler.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CopyPSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetDraftPSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetPSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupMovePSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MovePSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_User2PSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UserPSDEAction(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEOPPriv(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isCreatePSDEOPPrivIdDirty()) {
            if (pSACHandler.getCreatePSDEOPPrivId() != null) {
                if (pSACHandler.getCreatePSDEOPPrivId() == null || pSACHandler.getCreatePSDEOPPrivIName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSACHandler.getCreatePSDEOPPriv();
                    pSACHandler.setCreatePSDEOPPrivIName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSACHandler.setCreatePSDEOPPrivIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ExportPSDEOPPriv(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isExportPSDEOPPrivIdDirty()) {
            if (pSACHandler.getExportPSDEOPPrivId() != null) {
                if (pSACHandler.getExportPSDEOPPrivId() == null || pSACHandler.getExportPSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSACHandler.getExportPSDEOPPriv();
                    pSACHandler.setExportPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSACHandler.setExportPSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ReadPSDEOPPriv(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isReadPSDEOPPrivIdDirty()) {
            if (pSACHandler.getReadPSDEOPPrivId() != null) {
                if (pSACHandler.getReadPSDEOPPrivId() == null || pSACHandler.getReadPSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSACHandler.getReadPSDEOPPriv();
                    pSACHandler.setReadPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSACHandler.setReadPSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RemovePSDEOPPriv(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isRemovePSDEOPPrivIdDirty()) {
            if (pSACHandler.getRemovePSDEOPPrivId() != null) {
                if (pSACHandler.getRemovePSDEOPPrivId() == null || pSACHandler.getRemovePSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSACHandler.getRemovePSDEOPPriv();
                    pSACHandler.setRemovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSACHandler.setRemovePSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UpdatePSDEOPPriv(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isUpdatePSDEOPPrivIdDirty()) {
            if (pSACHandler.getUpdatePSDEOPPrivId() != null) {
                if (pSACHandler.getUpdatePSDEOPPrivId() == null || pSACHandler.getUpdatePSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSACHandler.getUpdatePSDEOPPriv();
                    pSACHandler.setUpdatePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSACHandler.setUpdatePSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_User2PSDEOPPriv(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isUser2PSDEOPPrivIdDirty()) {
            if (pSACHandler.getUser2PSDEOPPrivId() != null) {
                if (pSACHandler.getUser2PSDEOPPrivId() == null || pSACHandler.getUser2PSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSACHandler.getUser2PSDEOPPriv();
                    pSACHandler.setUser2PSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSACHandler.setUser2PSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UserPSDEOPPriv(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isUserPSDEOPPrivIdDirty()) {
            if (pSACHandler.getUserPSDEOPPrivId() != null) {
                if (pSACHandler.getUserPSDEOPPrivId() == null || pSACHandler.getUserPSDEOPPrivName() == null) {
                    PSDEOPPriv pSDEOPPriv = pSACHandler.getUserPSDEOPPriv();
                    pSACHandler.setUserPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                }
            } else {
                pSACHandler.setUserPSDEOPPrivName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFACHandler(PSACHandler pSACHandler, boolean bl) throws Exception {
        if (pSACHandler.isPSSFACHandlerIdDirty()) {
            if (pSACHandler.getPSSFACHandlerId() != null) {
                if (pSACHandler.getPSSFACHandlerId() == null || pSACHandler.getPSSFACHandlerName() == null) {
                    PSSFACHandler pSSFACHandler = pSACHandler.getPSSFACHandler();
                    pSACHandler.setPSSFACHandlerName(pSSFACHandler.getPSSFACHandlerName());
                    pSACHandler.setPSSFId(pSSFACHandler.getPSSFId());
                    pSACHandler.setPSSFName(pSSFACHandler.getPSSFName());
                }
            } else {
                pSACHandler.setPSSFACHandlerName(null);
                pSACHandler.setPSSFId(null);
                pSACHandler.setPSSFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTask(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniState(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserDR(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserDR2(PSACHandler pSACHandler, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSACHandler pSACHandler, boolean bl) throws Exception {
        super.onWriteBackParent(pSACHandler, bl);
    }

    public ArrayList<PSACHandler> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByGroupPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByGroupPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSACHandler> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("COPYPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCopyPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCopyPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GETDRAFTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGetDraftPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGetDraftPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByGetPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GETPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGetPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGetPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGroupMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGroupMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USER2PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUser2PSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUser2PSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByUserPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUserPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUserPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSACHandler> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByCreatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByCreatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByExportPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByExportPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByExportPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByExportPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByExportPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EXPORTPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByExportPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByExportPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByReadPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByReadPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByReadPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByReadPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByReadPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("READPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByReadPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByReadPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByUpdatePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByUpdatePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByUser2PSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByUser2PSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByUser2PSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByUser2PSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByUser2PSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USER2PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUser2PSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUser2PSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByUserPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByUserPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByUserPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByUserPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByUserPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUserPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUserPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSACHandler> selectByPSSFACHandler(PSSFACHandlerBase pSSFACHandlerBase) throws Exception {
        return this.selectByPSSFACHandler(pSSFACHandlerBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSFACHandler(PSSFACHandlerBase pSSFACHandlerBase, String string) throws Exception {
        return this.selectByPSSFACHandler(pSSFACHandlerBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSFACHandler(PSSFACHandlerBase pSSFACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFACHANDLERID", (Object)pSSFACHandlerBase.getPSSFACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSACHandler> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSACHandler> selectByPSSysTask(PSSysTaskBase pSSysTaskBase) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTASKID", (Object)pSSysTaskBase.getPSSysTaskId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTaskCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTaskCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSACHandler> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string) throws Exception {
        return this.selectByPSSysUniState(pSSysUniStateBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSysUniState(PSSysUniStateBase pSSysUniStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNISTATEID", (Object)pSSysUniStateBase.getPSSysUniStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase) throws Exception {
        return this.selectByPSSysUserDR(pSSysUserDRBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase, String string) throws Exception {
        return this.selectByPSSysUserDR(pSSysUserDRBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERDRID", (Object)pSSysUserDRBase.getPSSysUserDRId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserDRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserDRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSACHandler> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase) throws Exception {
        return this.selectByPSSysUserDR2(pSSysUserDRBase, "", -1);
    }

    public ArrayList<PSACHandler> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase, String string) throws Exception {
        return this.selectByPSSysUserDR2(pSSysUserDRBase, string, -1);
    }

    public ArrayList<PSACHandler> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERDRID2", (Object)pSSysUserDRBase.getPSSysUserDRId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserDR2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserDR2Cond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGroupPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDATAENTITY_GROUPPSDEID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGroupPSDE(pSDataEntity);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setGroupPSDEId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByGroupPSDE(pSDataEntity2);
                PSACHandlerServiceBase.this.internalRemoveByGroupPSDE(pSDataEntity2);
                PSACHandlerServiceBase.this.onAfterRemoveByGroupPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGroupPSDE(pSDataEntity);
        this.onBeforeRemoveByGroupPSDE(pSDataEntity, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByGroupPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDE(PSDataEntity pSDataEntity, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDE(PSDataEntity pSDataEntity, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSDEId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSACHandlerServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setCopyPSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByCopyPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByCopyPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByCopyPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        this.onBeforeRemoveByCopyPSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByCopyPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCreatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_CREATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setCreatePSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByCreatePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByCreatePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByCreatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        this.onBeforeRemoveByCreatePSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByCreatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGetDraftPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_GETDRAFTPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setGetDraftPSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByGetDraftPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByGetDraftPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGetPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_GETPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGetPSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setGetPSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByGetPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByGetPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByGetPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGetPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetPSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByGetPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGroupMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_GROUPMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGroupMovePSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setGroupMovePSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByGroupMovePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByGroupMovePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByGroupMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByGroupMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByGroupMovePSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByGroupMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGroupMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_MOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByMovePSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setMovePSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByMovePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByMovePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByMovePSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setRemovePSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setUpdatePSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUser2PSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_USER2PSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setUser2PSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByUser2PSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByUser2PSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByUser2PSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        this.onBeforeRemoveByUser2PSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByUser2PSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUserPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEACTION_USERPSDEACTIONID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUserPSDEAction(pSDEAction);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setUserPSDEActionId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByUserPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.internalRemoveByUserPSDEAction(pSDEAction2);
                PSACHandlerServiceBase.this.onAfterRemoveByUserPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUserPSDEAction(pSDEAction);
        this.onBeforeRemoveByUserPSDEAction(pSDEAction, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByUserPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSDEDataSetId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSACHandlerServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEOPPRIV_CREATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setCreatePSDEOPPrivId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.internalRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByCreatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByCreatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByExportPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEOPPRIV_EXPORTPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByExportPSDEOPPriv(pSDEOPPriv);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setExportPSDEOPPrivId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByExportPSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.internalRemoveByExportPSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.onAfterRemoveByExportPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByExportPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByExportPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByExportPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByExportPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByReadPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEOPPRIV_READPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByReadPSDEOPPriv(pSDEOPPriv);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setReadPSDEOPPrivId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByReadPSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.internalRemoveByReadPSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.onAfterRemoveByReadPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByReadPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByReadPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByReadPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByReadPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEOPPRIV_REMOVEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setRemovePSDEOPPrivId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.internalRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEOPPRIV_UPDATEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setUpdatePSDEOPPrivId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.internalRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUpdatePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByUpdatePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUser2PSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEOPPRIV_USER2PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUser2PSDEOPPriv(pSDEOPPriv);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setUser2PSDEOPPrivId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByUser2PSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.internalRemoveByUser2PSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.onAfterRemoveByUser2PSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUser2PSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByUser2PSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByUser2PSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUserPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSDEOPPRIV_USERPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUserPSDEOPPriv(pSDEOPPriv);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setUserPSDEOPPrivId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByUserPSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.internalRemoveByUserPSDEOPPriv(pSDEOPPriv2);
                PSACHandlerServiceBase.this.onAfterRemoveByUserPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByUserPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByUserPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByUserPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSModule(pSModule);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSModuleId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSACHandlerServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSFACHandler(PSSFACHandler pSSFACHandler) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSFACHandler(pSSFACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSSFACHANDLER_PSSFACHANDLERID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSSFACHandler), arrayList.get(0)));
        }
    }

    public void resetPSSFACHandler(PSSFACHandler pSSFACHandler) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSFACHandler(pSSFACHandler);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSFACHandlerId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSFACHandler(PSSFACHandler pSSFACHandler) throws Exception {
        final PSSFACHandler pSSFACHandler2 = pSSFACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSFACHandler(pSSFACHandler2);
                PSACHandlerServiceBase.this.internalRemoveByPSSFACHandler(pSSFACHandler2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSFACHandler(pSSFACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFACHandler(PSSFACHandler pSSFACHandler) throws Exception {
    }

    protected void internalRemoveByPSSFACHandler(PSSFACHandler pSSFACHandler) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSFACHandler(pSSFACHandler);
        this.onBeforeRemoveByPSSFACHandler(pSSFACHandler, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSFACHandler(pSSFACHandler, arrayList);
    }

    protected void onAfterRemoveByPSSFACHandler(PSSFACHandler pSSFACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSSFACHandler(PSSFACHandler pSSFACHandler, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFACHandler(PSSFACHandler pSSFACHandler, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSysDynaModelId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSACHandlerServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSysReqItemId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSACHandlerServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysTask(pSSysTask, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTASK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTask);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSSYSTASK_PSSYSTASKID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSSysTask), arrayList.get(0)));
        }
    }

    public void resetPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysTask(pSSysTask);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSysTaskId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSysTask(PSSysTask pSSysTask) throws Exception {
        final PSSysTask pSSysTask2 = pSSysTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSysTask(pSSysTask2);
                PSACHandlerServiceBase.this.internalRemoveByPSSysTask(pSSysTask2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSysTask(pSSysTask2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void internalRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysTask(pSSysTask);
        this.onBeforeRemoveByPSSysTask(pSSysTask, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSysTask(pSSysTask, arrayList);
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSystem(pSSystem);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSystemId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSACHandlerServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUniState(pSSysUniState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNISTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSSYSUNISTATE_PSSYSUNISTATEID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSSysUniState), arrayList.get(0)));
        }
    }

    public void resetPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUniState(pSSysUniState);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSysUniStateId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        final PSSysUniState pSSysUniState2 = pSSysUniState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSysUniState(pSSysUniState2);
                PSACHandlerServiceBase.this.internalRemoveByPSSysUniState(pSSysUniState2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSysUniState(pSSysUniState2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void internalRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUniState(pSSysUniState);
        this.onBeforeRemoveByPSSysUniState(pSSysUniState, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSysUniState(pSSysUniState, arrayList);
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniState(PSSysUniState pSSysUniState, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUserDR(pSSysUserDR, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERDR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUserDR);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSSYSUSERDR_PSSYSUSERDRID", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSSysUserDR), arrayList.get(0)));
        }
    }

    public void resetPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUserDR(pSSysUserDR);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSysUserDRId(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        final PSSysUserDR pSSysUserDR2 = pSSysUserDR;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSysUserDR(pSSysUserDR2);
                PSACHandlerServiceBase.this.internalRemoveByPSSysUserDR(pSSysUserDR2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSysUserDR(pSSysUserDR2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void internalRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUserDR(pSSysUserDR);
        this.onBeforeRemoveByPSSysUserDR(pSSysUserDR, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSysUserDR(pSSysUserDR, arrayList);
    }

    protected void onAfterRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUserDR2(pSSysUserDR, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERDR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUserDR);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSACHANDLER_PSSYSUSERDR_PSSYSUSERDRID2", "", iDataEntityModel.getName(), "PSACHANDLER", iDataEntityModel.getDataInfo(pSSysUserDR), arrayList.get(0)));
        }
    }

    public void resetPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUserDR2(pSSysUserDR);
        for (PSACHandler pSACHandler : arrayList) {
            PSACHandler pSACHandler2 = (PSACHandler)this.getDEModel().createEntity();
            pSACHandler2.setPSACHandlerId(pSACHandler.getPSACHandlerId());
            pSACHandler2.setPSSysUserDRId2(null);
            this.update(pSACHandler2);
        }
    }

    public void removeByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        final PSSysUserDR pSSysUserDR2 = pSSysUserDR;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSACHandlerServiceBase.this.onBeforeRemoveByPSSysUserDR2(pSSysUserDR2);
                PSACHandlerServiceBase.this.internalRemoveByPSSysUserDR2(pSSysUserDR2);
                PSACHandlerServiceBase.this.onAfterRemoveByPSSysUserDR2(pSSysUserDR2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void internalRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSACHandler> arrayList = this.selectByPSSysUserDR2(pSSysUserDR);
        this.onBeforeRemoveByPSSysUserDR2(pSSysUserDR, arrayList);
        for (PSACHandler pSACHandler : arrayList) {
            this.remove(pSACHandler);
        }
        this.onAfterRemoveByPSSysUserDR2(pSSysUserDR, arrayList);
    }

    protected void onAfterRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR, ArrayList<PSACHandler> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSACHandler pSACHandler) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerActionServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        ((PSACHandlerActionServiceBase)pSCoreSysServiceBase).removeByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByItemPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByItemPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveBySubPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEditorStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByPSACHandler(pSACHandler);
        super.onBeforeRemove(pSACHandler);
    }

    protected void replaceParentInfo(PSACHandler pSACHandler, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSACHandler, cloneSession);
        if (pSACHandler.getGroupPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSACHandler.getGroupPSDEId())) != null) {
            this.onFillParentInfo_GroupPSDE(pSACHandler, (PSDataEntity)iEntity);
        }
        if (pSACHandler.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSACHandler.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSACHandler, (PSDataEntity)iEntity);
        }
        if (pSACHandler.getCopyPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getCopyPSDEActionId())) != null) {
            this.onFillParentInfo_CopyPSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getCreatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getCreatePSDEActionId())) != null) {
            this.onFillParentInfo_CreatePSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getGetDraftPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getGetDraftPSDEActionId())) != null) {
            this.onFillParentInfo_GetDraftPSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getGetPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getGetPSDEActionId())) != null) {
            this.onFillParentInfo_GetPSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getGroupMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getGroupMovePSDEActionId())) != null) {
            this.onFillParentInfo_GroupMovePSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getMovePSDEActionId())) != null) {
            this.onFillParentInfo_MovePSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getUser2PSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getUser2PSDEActionId())) != null) {
            this.onFillParentInfo_User2PSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getUserPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSACHandler.getUserPSDEActionId())) != null) {
            this.onFillParentInfo_UserPSDEAction(pSACHandler, (PSDEAction)iEntity);
        }
        if (pSACHandler.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSACHandler.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSACHandler, (PSDEDataSet)iEntity);
        }
        if (pSACHandler.getCreatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSACHandler.getCreatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_CreatePSDEOPPriv(pSACHandler, (PSDEOPPriv)iEntity);
        }
        if (pSACHandler.getExportPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSACHandler.getExportPSDEOPPrivId())) != null) {
            this.onFillParentInfo_ExportPSDEOPPriv(pSACHandler, (PSDEOPPriv)iEntity);
        }
        if (pSACHandler.getReadPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSACHandler.getReadPSDEOPPrivId())) != null) {
            this.onFillParentInfo_ReadPSDEOPPriv(pSACHandler, (PSDEOPPriv)iEntity);
        }
        if (pSACHandler.getRemovePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSACHandler.getRemovePSDEOPPrivId())) != null) {
            this.onFillParentInfo_RemovePSDEOPPriv(pSACHandler, (PSDEOPPriv)iEntity);
        }
        if (pSACHandler.getUpdatePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSACHandler.getUpdatePSDEOPPrivId())) != null) {
            this.onFillParentInfo_UpdatePSDEOPPriv(pSACHandler, (PSDEOPPriv)iEntity);
        }
        if (pSACHandler.getUser2PSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSACHandler.getUser2PSDEOPPrivId())) != null) {
            this.onFillParentInfo_User2PSDEOPPriv(pSACHandler, (PSDEOPPriv)iEntity);
        }
        if (pSACHandler.getUserPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSACHandler.getUserPSDEOPPrivId())) != null) {
            this.onFillParentInfo_UserPSDEOPPriv(pSACHandler, (PSDEOPPriv)iEntity);
        }
        if (pSACHandler.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSACHandler.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSACHandler, (PSModule)iEntity);
        }
        if (pSACHandler.getPSSFACHandlerId() != null && (iEntity = cloneSession.getEntity("PSSFACHANDLER", (Object)pSACHandler.getPSSFACHandlerId())) != null) {
            this.onFillParentInfo_PSSFACHandler(pSACHandler, (PSSFACHandler)iEntity);
        }
        if (pSACHandler.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSACHandler.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSACHandler, (PSSysDynaModel)iEntity);
        }
        if (pSACHandler.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSACHandler.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSACHandler, (PSSysReqItem)iEntity);
        }
        if (pSACHandler.getPSSysTaskId() != null && (iEntity = cloneSession.getEntity("PSSYSTASK", (Object)pSACHandler.getPSSysTaskId())) != null) {
            this.onFillParentInfo_PSSysTask(pSACHandler, (PSSysTask)iEntity);
        }
        if (pSACHandler.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSACHandler.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSACHandler, (PSSystem)iEntity);
        }
        if (pSACHandler.getPSSysUniStateId() != null && (iEntity = cloneSession.getEntity("PSSYSUNISTATE", (Object)pSACHandler.getPSSysUniStateId())) != null) {
            this.onFillParentInfo_PSSysUniState(pSACHandler, (PSSysUniState)iEntity);
        }
        if (pSACHandler.getPSSysUserDRId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERDR", (Object)pSACHandler.getPSSysUserDRId())) != null) {
            this.onFillParentInfo_PSSysUserDR(pSACHandler, (PSSysUserDR)iEntity);
        }
        if (pSACHandler.getPSSysUserDRId2() != null && (iEntity = cloneSession.getEntity("PSSYSUSERDR", (Object)pSACHandler.getPSSysUserDRId2())) != null) {
            this.onFillParentInfo_PSSysUserDR2(pSACHandler, (PSSysUserDR)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSACHandler pSACHandler, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSACHandler, bl);
    }

    protected void onCheckEntity(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CacheScope(bl, pSACHandler, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTimeout(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CopyPSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEOPPrivId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEOPPrivIName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateTimeout(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlType(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCache(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableOrgDR(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSecBC(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSecDR(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUserDR(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportPSDEOPPrivId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportPSDEOPPrivName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FetchTimeout(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDraftPSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetPSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetTimeout(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMovePSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj2(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerParams(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerTag(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerTag2(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrgDR(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFACHandlerId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFACHandlerName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTaskId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniStateId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserDRId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserDRId2(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadPSDEOPPrivId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadPSDEOPPrivName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEOPPrivId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEOPPrivName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveTimeout(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SecBC(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SecDR(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysUserDR2Param(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysUserDRParam(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempMode(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniStateField(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniStateKeyValue(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEOPPrivId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEOPPrivName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateTimeout(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEOPPrivId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEOPPrivName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEActionId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEOPPrivId(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEOPPrivName(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSACHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSACHandler, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CacheScope(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCacheScopeDirty() : !pSACHandler.isCacheScopeDirty()) {
            return null;
        }
        Integer n = pSACHandler.getCacheScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CacheScope_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHESCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTimeout(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCacheTimeoutDirty() : !pSACHandler.isCacheTimeoutDirty()) {
            return null;
        }
        Integer n = pSACHandler.getCacheTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CacheTimeout_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCodeNameDirty() : !pSACHandler.isCodeNameDirty()) {
            return null;
        }
        String string = pSACHandler.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSACHandler, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSACHandlerDEModel(), "CODENAME", string3, pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_CopyPSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCopyPSDEActionIdDirty() : !pSACHandler.isCopyPSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getCopyPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CopyPSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COPYPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCreatePSDEActionIdDirty() : !pSACHandler.isCreatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getCreatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEOPPrivId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCreatePSDEOPPrivIdDirty() : !pSACHandler.isCreatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSACHandler.getCreatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEOPPrivId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEOPPrivIName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCreatePSDEOPPrivINameDirty() : !pSACHandler.isCreatePSDEOPPrivINameDirty()) {
            return null;
        }
        String string = pSACHandler.getCreatePSDEOPPrivIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEOPPrivIName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEOPPRIVINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateTimeout(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCreateTimeoutDirty() : !pSACHandler.isCreateTimeoutDirty()) {
            return null;
        }
        Integer n = pSACHandler.getCreateTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CreateTimeout_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlType(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCtrlTypeDirty() && !bl2 : !pSACHandler.isCtrlTypeDirty()) {
            return null;
        }
        String string = pSACHandler.getCtrlType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlType_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCustomCondDirty() : !pSACHandler.isCustomCondDirty()) {
            return null;
        }
        String string = pSACHandler.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isCustomTypeDirty() : !pSACHandler.isCustomTypeDirty()) {
            return null;
        }
        String string = pSACHandler.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isDynaModelFlagDirty() : !pSACHandler.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSACHandler.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableCache(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isEnableCacheDirty() : !pSACHandler.isEnableCacheDirty()) {
            return null;
        }
        Integer n = pSACHandler.getEnableCache();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCache_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECACHE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableOrgDR(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isEnableOrgDRDirty() : !pSACHandler.isEnableOrgDRDirty()) {
            return null;
        }
        Integer n = pSACHandler.getEnableOrgDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableOrgDR_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEORGDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSecBC(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isEnableSecBCDirty() : !pSACHandler.isEnableSecBCDirty()) {
            return null;
        }
        Integer n = pSACHandler.getEnableSecBC();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSecBC_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESECBC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSecDR(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isEnableSecDRDirty() : !pSACHandler.isEnableSecDRDirty()) {
            return null;
        }
        Integer n = pSACHandler.getEnableSecDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSecDR_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESECDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUserDR(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isEnableUserDRDirty() : !pSACHandler.isEnableUserDRDirty()) {
            return null;
        }
        Integer n = pSACHandler.getEnableUserDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUserDR_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUSERDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportPSDEOPPrivId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isExportPSDEOPPrivIdDirty() : !pSACHandler.isExportPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSACHandler.getExportPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExportPSDEOPPrivId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportPSDEOPPrivName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isExportPSDEOPPrivNameDirty() : !pSACHandler.isExportPSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSACHandler.getExportPSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExportPSDEOPPrivName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTPSDEOPPRIVINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FetchTimeout(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isFetchTimeoutDirty() : !pSACHandler.isFetchTimeoutDirty()) {
            return null;
        }
        Integer n = pSACHandler.getFetchTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FetchTimeout_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FETCHTIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetDraftPSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isGetDraftPSDEActionIdDirty() : !pSACHandler.isGetDraftPSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getGetDraftPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetDraftPSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETDRAFTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetPSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isGetPSDEActionIdDirty() : !pSACHandler.isGetPSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getGetPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetPSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetTimeout(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isGetTimeoutDirty() : !pSACHandler.isGetTimeoutDirty()) {
            return null;
        }
        Integer n = pSACHandler.getGetTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GetTimeout_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETTIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMovePSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isGroupMovePSDEActionIdDirty() : !pSACHandler.isGroupMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getGroupMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMovePSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isGroupPSDEIdDirty() : !pSACHandler.isGroupPSDEIdDirty()) {
            return null;
        }
        String string = pSACHandler.getGroupPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isGroupPSDENameDirty() : !pSACHandler.isGroupPSDENameDirty()) {
            return null;
        }
        String string = pSACHandler.getGroupPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isHandlerObjDirty() : !pSACHandler.isHandlerObjDirty()) {
            return null;
        }
        String string = pSACHandler.getHandlerObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj2(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isHandlerObj2Dirty() : !pSACHandler.isHandlerObj2Dirty()) {
            return null;
        }
        String string = pSACHandler.getHandlerObj2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj2_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerParams(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isHandlerParamsDirty() : !pSACHandler.isHandlerParamsDirty()) {
            return null;
        }
        String string = pSACHandler.getHandlerParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerParams_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerTag(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isHandlerTagDirty() : !pSACHandler.isHandlerTagDirty()) {
            return null;
        }
        String string = pSACHandler.getHandlerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerTag_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerTag2(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isHandlerTag2Dirty() : !pSACHandler.isHandlerTag2Dirty()) {
            return null;
        }
        String string = pSACHandler.getHandlerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerTag2_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isLockFlagDirty() : !pSACHandler.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSACHandler.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isMemoDirty() : !pSACHandler.isMemoDirty()) {
            return null;
        }
        String string = pSACHandler.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_MovePSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isMovePSDEActionIdDirty() : !pSACHandler.isMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrgDR(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isOrgDRDirty() : !pSACHandler.isOrgDRDirty()) {
            return null;
        }
        Integer n = pSACHandler.getOrgDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrgDR_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORGDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSACHandlerIdDirty() && !bl2 : !pSACHandler.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSACHandlerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSACHANDLERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSACHandlerNameDirty() && !bl2 : !pSACHandler.isPSACHandlerNameDirty()) {
            return null;
        }
        String string = pSACHandler.getPSACHandlerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSACHANDLERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSACHANDLERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSDEDataSetIdDirty() : !pSACHandler.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSDEIdDirty() : !pSACHandler.isPSDEIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSDENameDirty() : !pSACHandler.isPSDENameDirty()) {
            return null;
        }
        String string = pSACHandler.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSDynaInstIdDirty() : !pSACHandler.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSModuleIdDirty() : !pSACHandler.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFACHandlerId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSFACHandlerIdDirty() : !pSACHandler.isPSSFACHandlerIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSFACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFACHandlerId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFACHandlerName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSFACHandlerNameDirty() : !pSACHandler.isPSSFACHandlerNameDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSFACHandlerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFACHandlerName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFACHANDLERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSysDynaModelIdDirty() : !pSACHandler.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSysReqItemIdDirty() : !pSACHandler.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTaskId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSysTaskIdDirty() : !pSACHandler.isPSSysTaskIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSysTaskId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTaskId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSystemIdDirty() : !pSACHandler.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniStateId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSysUniStateIdDirty() : !pSACHandler.isPSSysUniStateIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSysUniStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniStateId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNISTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserDRId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSysUserDRIdDirty() : !pSACHandler.isPSSysUserDRIdDirty()) {
            return null;
        }
        String string = pSACHandler.getPSSysUserDRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserDRId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERDRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserDRId2(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isPSSysUserDRId2Dirty() : !pSACHandler.isPSSysUserDRId2Dirty()) {
            return null;
        }
        String string = pSACHandler.getPSSysUserDRId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserDRId2_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERDRID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReadPSDEOPPrivId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isReadPSDEOPPrivIdDirty() : !pSACHandler.isReadPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSACHandler.getReadPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReadPSDEOPPrivId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReadPSDEOPPrivName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isReadPSDEOPPrivNameDirty() : !pSACHandler.isReadPSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSACHandler.getReadPSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReadPSDEOPPrivName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isRemovePSDEActionIdDirty() : !pSACHandler.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEOPPrivId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isRemovePSDEOPPrivIdDirty() : !pSACHandler.isRemovePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSACHandler.getRemovePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEOPPrivId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEOPPrivName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isRemovePSDEOPPrivNameDirty() : !pSACHandler.isRemovePSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSACHandler.getRemovePSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEOPPrivName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveTimeout(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isRemoveTimeoutDirty() : !pSACHandler.isRemoveTimeoutDirty()) {
            return null;
        }
        Integer n = pSACHandler.getRemoveTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoveTimeout_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SecBC(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isSecBCDirty() : !pSACHandler.isSecBCDirty()) {
            return null;
        }
        String string = pSACHandler.getSecBC();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SecBC_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECBC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SecDR(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isSecDRDirty() : !pSACHandler.isSecDRDirty()) {
            return null;
        }
        Integer n = pSACHandler.getSecDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SecDR_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysUserDR2Param(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isSysUserDR2ParamDirty() : !pSACHandler.isSysUserDR2ParamDirty()) {
            return null;
        }
        String string = pSACHandler.getSysUserDR2Param();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysUserDR2Param_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSUSERDR2PARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysUserDRParam(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isSysUserDRParamDirty() : !pSACHandler.isSysUserDRParamDirty()) {
            return null;
        }
        String string = pSACHandler.getSysUserDRParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysUserDRParam_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSUSERDRPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempMode(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isTempModeDirty() : !pSACHandler.isTempModeDirty()) {
            return null;
        }
        Integer n = pSACHandler.getTempMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TempMode_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isToDoTaskDirty() : !pSACHandler.isToDoTaskDirty()) {
            return null;
        }
        String string = pSACHandler.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TODOTASK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniStateField(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUniStateFieldDirty() : !pSACHandler.isUniStateFieldDirty()) {
            return null;
        }
        String string = pSACHandler.getUniStateField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniStateField_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATEFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniStateKeyValue(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUniStateKeyValueDirty() : !pSACHandler.isUniStateKeyValueDirty()) {
            return null;
        }
        String string = pSACHandler.getUniStateKeyValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniStateKeyValue_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATEKEYVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUpdatePSDEActionIdDirty() : !pSACHandler.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEOPPrivId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUpdatePSDEOPPrivIdDirty() : !pSACHandler.isUpdatePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSACHandler.getUpdatePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEOPPrivId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEOPPrivName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUpdatePSDEOPPrivNameDirty() : !pSACHandler.isUpdatePSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSACHandler.getUpdatePSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEOPPrivName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateTimeout(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUpdateTimeoutDirty() : !pSACHandler.isUpdateTimeoutDirty()) {
            return null;
        }
        Integer n = pSACHandler.getUpdateTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UpdateTimeout_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUser2PSDEActionIdDirty() : !pSACHandler.isUser2PSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getUser2PSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEOPPrivId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUser2PSDEOPPrivIdDirty() : !pSACHandler.isUser2PSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSACHandler.getUser2PSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEOPPrivId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEOPPrivName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUser2PSDEOPPrivNameDirty() : !pSACHandler.isUser2PSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSACHandler.getUser2PSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEOPPrivName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEOPPRIVINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserCatDirty() : !pSACHandler.isUserCatDirty()) {
            return null;
        }
        String string = pSACHandler.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserParamsDirty() : !pSACHandler.isUserParamsDirty()) {
            return null;
        }
        String string = pSACHandler.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserPSDEActionId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserPSDEActionIdDirty() : !pSACHandler.isUserPSDEActionIdDirty()) {
            return null;
        }
        String string = pSACHandler.getUserPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEActionId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserPSDEOPPrivId(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserPSDEOPPrivIdDirty() : !pSACHandler.isUserPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSACHandler.getUserPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEOPPrivId_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserPSDEOPPrivName(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserPSDEOPPrivNameDirty() : !pSACHandler.isUserPSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSACHandler.getUserPSDEOPPrivName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEOPPrivName_Default(pSACHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEOPPRIVINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserTagDirty() : !pSACHandler.isUserTagDirty()) {
            return null;
        }
        String string = pSACHandler.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserTag2Dirty() : !pSACHandler.isUserTag2Dirty()) {
            return null;
        }
        String string = pSACHandler.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserTag3Dirty() : !pSACHandler.isUserTag3Dirty()) {
            return null;
        }
        String string = pSACHandler.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSACHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSACHandler pSACHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSACHandler.isUserTag4Dirty() : !pSACHandler.isUserTag4Dirty()) {
            return null;
        }
        String string = pSACHandler.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSACHandler, bl2, bl3);
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

    protected void onSyncEntity(PSACHandler pSACHandler, boolean bl) throws Exception {
        super.onSyncEntity(pSACHandler, bl);
    }

    protected void onSyncIndexEntities(PSACHandler pSACHandler, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSACHandler, bl);
    }

    public Object getDataContextValue(PSACHandler pSACHandler, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACTION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"GROUPMOVEPSDEACTIONID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"GROUPMOVEPSDEACTIONNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSACHandler, "grouppsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSACHandler, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSACHandler.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystem pSSystem = pSACHandler.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSACHandler pSACHandler, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSACHandler, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CACHESCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COPYPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CopyPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COPYPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CopyPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEOPPRIVINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEOPPrivIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECACHE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCache_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEORGDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableOrgDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESECBC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSecBC_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESECDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSecDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUSERDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUserDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportPSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTPSDEOPPRIVINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportPSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FETCHTIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FetchTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDRAFTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDraftPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDRAFTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDraftPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETTIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORGDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrgDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadPSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadPSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECBC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SecBC_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SecDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSUSERDR2PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysUserDR2Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSUSERDRPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysUserDRParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNISTATEFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniStateField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNISTATEKEYVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniStateKeyValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEOPPRIVINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEOPPRIVINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEOPPrivName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CacheScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CacheTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_CopyPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COPYPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CopyPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COPYPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_CreatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEOPPrivIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEOPPRIVINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCache_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableOrgDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSecBC_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSecDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableUserDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportPSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXPORTPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExportPSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXPORTPSDEOPPRIVINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FetchTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FinishFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GetDraftPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETDRAFTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetDraftPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETDRAFTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupMovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerObj2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLERPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_MovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrgDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSFACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysTaskId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUniStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadPSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("READPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadPSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("READPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemoveTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SecBC_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECBC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SecDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysUserDR2Param_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSUSERDR2PARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysUserDRParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSUSERDRPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TempMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ToDoTask_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TODOTASK", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniStateField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNISTATEFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniStateKeyValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNISTATEKEYVALUE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_UpdatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_User2PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEOPPRIVINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEOPPRIVINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSACHandler pSACHandler) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSACHandler)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSACHandler pSACHandler) throws Exception {
        Object object = pSACHandler.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSACHANDLER_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSACHandler);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSACHandler pSACHandler, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSACHANDLER");
        if (!bl) {
            pSACHandler.setCreateDate(null);
            pSACHandler.setCreateMan(null);
            pSACHandler.setPSACHandlerId(null);
            pSACHandler.setUpdateDate(null);
            pSACHandler.setUpdateMan(null);
            super.exportCurXmlModel(pSACHandler, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSACHandler pSACHandler, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSACHandler, string);
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
            return "DER1N_PSACHANDLER_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSACHANDLER_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSACHANDLER_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSACHandler pSACHandler) {
        if (!StringHelper.isNullOrEmpty((String)pSACHandler.getCodeName())) {
            return pSACHandler.getCodeName();
        }
        return super.getModelV2Tag(pSACHandler);
    }

    @Override
    public boolean setModelV2Tag(PSACHandler pSACHandler, String string) {
        pSACHandler.setCodeName(string);
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
    public boolean getModelV2Entity(PSACHandler pSACHandler, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSACHandler.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSACHandler, true);
        pSACHandler.set("CODENAME", string);
        if (this.select(pSACHandler, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSACHandler, true);
        return super.getModelV2Entity(pSACHandler, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSACHandler pSACHandler, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSACHandler, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSACHANDLERACTION_PSACHANDLER_PSACHANDLERID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSACHandler pSACHandler, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSACHANDLERACTION_PSACHANDLER_PSACHANDLERID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSACHANDLER#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSACHANDLERACTION", (Object)pSACHandler.getPSACHandlerId()))).exists()) {
            PSACHandlerActionService pSACHandlerActionService = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSACHandlerActionService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSACHandlerAction pSACHandlerAction = new PSACHandlerAction();
                PSModelV2Helper.fromJSONObject((IDataObject)pSACHandlerAction, objectNode, false);
                String string6 = pSACHandlerActionService.getModelV2Tag(pSACHandlerAction);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSACHANDLERACTION", (Object)pSACHandlerAction.getPSACHandlerActionId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSACHandlerActionService.exportModelV2(pSACHandlerAction, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSACHandler, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSACHandler pSACHandler, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSACHANDLERACTION_PSACHANDLER_PSACHANDLERID")) {
            PSACHandlerActionService pSACHandlerActionService = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSACHANDLER#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSACHANDLERACTION", (Object)pSACHandler.getPSACHandlerId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSACHANDLER#%1$s", (Object)pSACHandler.getPSACHandlerId());
                for (PSACHandlerAction item : pSACHandlerActionService.selectByPSACHandler(pSACHandler)) {
                    if (StringHelper.compare((String)scope, (String)pSACHandlerActionService.getModelV2ResScope(item), (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSACHandlerActionService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psachandleractionname")) {
                            string = objectNode.get("psachandleractionname").asText();
                        }
                        if (objectNode2.has("psachandleractionname")) {
                            string2 = objectNode2.get("psachandleractionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : arrayList) {
                    PSACHandlerAction item = new PSACHandlerAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, itemNode, false);
                    related.add((JsonNode)pSACHandlerActionService.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSACHandler, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSACHandler pSACHandler) throws Exception {
        super.onEmptyModelV2(pSACHandler);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSACHandlerActionService pSACHandlerActionService = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSACHandlerActionService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSACHandler pSACHandler, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSACHandlerAction pSACHandlerAction = new PSACHandlerAction();
        pSACHandlerAction.set("PSACHANDLERID", pSACHandler.getPSACHandlerId());
        PSACHandlerActionService pSACHandlerActionService = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSACHandlerActionService.getModelV2Entity(pSACHandlerAction, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSACHandler, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSACHandler pSACHandler, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSACHandlerServiceBase.isSimpleImportExportMode("")) {
            PSACHandlerActionService pSACHandlerActionService = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSACHandlerActionService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSACHandlerAction pSACHandlerAction = new PSACHandlerAction();
                    pSACHandlerAction.setPSACHandlerId(pSACHandler.getPSACHandlerId());
                    pSACHandlerAction.setPSACHandlerName(pSACHandler.getPSACHandlerName());
                    pSACHandlerActionService.compileModelV2(pSACHandlerAction, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSACHandlerAction pSACHandlerAction = new PSACHandlerAction();
                        pSACHandlerAction.setPSACHandlerId(pSACHandler.getPSACHandlerId());
                        pSACHandlerAction.setPSACHandlerName(pSACHandler.getPSACHandlerName());
                        pSACHandlerActionService.compileModelV2(pSACHandlerAction, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSACHandler, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSACHandler pSACHandler, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSACHANDLERACTION_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSACHandlerActions(pSACHandler, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSACHandler, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSACHandlerActions(PSACHandler pSACHandler, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSACHANDLERACTION", true), (boolean)false) == 0) {
            PSACHandlerActionService pSACHandlerActionService = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
            PSACHandlerAction pSACHandlerAction = new PSACHandlerAction();
            pSACHandlerAction.setPSACHandlerActionId(pSMOSFile.getPSModelId());
            if (!pSACHandlerActionService.get(pSACHandlerAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSACHandlerAction.getPSACHandlerId(), (String)pSACHandler.getPSACHandlerId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSACHandlerActionService.exportModelV2(pSACHandlerAction);
            pSACHandlerAction.reset();
            if (!pSACHandlerActionService.setModelV2ResScope(pSACHandlerAction, "PSACHANDLER", pSACHandler.getPSACHandlerId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSACHandlerActionService.importModelV2(pSACHandlerAction, objectNode);
            SessionFactoryManager.commit();
            return pSACHandlerActionService.getFile(pSACHandlerAction);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSACHandler pSACHandler, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSACHandlerActions(pSACHandler, list);
        super.onFillPasteHelps(pSACHandler, list);
    }

    protected void onFillPasteHelps_PSACHandlerActions(PSACHandler pSACHandler, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSACHANDLERACTION");
        pSHelpSection.setSectionParam2("DER1N_PSACHANDLERACTION_PSACHANDLER_PSACHANDLERID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u754c\u9762\u5904\u7406\u5bf9\u8c61]\u7684[\u754c\u9762\u5904\u7406\u5bf9\u8c61\u884c\u4e3a]");
        list.add(pSHelpSection);
    }
}

