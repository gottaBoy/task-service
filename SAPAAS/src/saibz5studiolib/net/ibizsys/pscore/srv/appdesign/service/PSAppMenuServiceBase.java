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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.appdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.Serializable;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppMenuDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppMenuDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItemBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuLogic;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuLogicBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
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

public abstract class PSAppMenuServiceBase
extends PSCoreSysServiceBase<PSAppMenu> {
    private static final Log log = LogFactory.getLog(PSAppMenuServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSAppMenuDEModel pSAppMenuDEModel;
    private PSAppMenuDAO pSAppMenuDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService";
    }

    public PSAppMenuDEModel getPSAppMenuDEModel() {
        if (this.pSAppMenuDEModel == null) {
            try {
                this.pSAppMenuDEModel = (PSAppMenuDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppMenuDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppMenuDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppMenuDEModel();
    }

    public PSAppMenuDAO getPSAppMenuDAO() {
        if (this.pSAppMenuDAO == null) {
            try {
                this.pSAppMenuDAO = (PSAppMenuDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppMenuDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppMenuDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppMenuDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSAppMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSAppMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSAppMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSAppMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSAppMenu)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSAppMenu)iEntity);
            return;
        }
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void createWithModel(PSAppMenu pSAppMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSAppMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppMenu, ACTION_CREATEWITHMODEL);
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuServiceBase.this.getService(), PSAppMenuServiceBase.ACTION_CREATEWITHMODEL, 40, pSAppMenu2, null).getResult() != 1) {
                    PSAppMenuServiceBase.this.onCreateWithModel(pSAppMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSAppMenu, null);
        }
    }

    protected void onCreateWithModel(PSAppMenu pSAppMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSAppMenu pSAppMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSAppMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppMenu, ACTION_GETDRAFTFROMWITHMODEL);
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuServiceBase.this.getService(), PSAppMenuServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSAppMenu2, null).getResult() != 1) {
                    PSAppMenuServiceBase.this.onGetDraftFromWithModel(pSAppMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSAppMenu, null);
        }
    }

    protected void onGetDraftFromWithModel(PSAppMenu pSAppMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSAppMenu pSAppMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSAppMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppMenu, ACTION_GETDRAFTWITHMODEL);
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuServiceBase.this.getService(), PSAppMenuServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSAppMenu2, null).getResult() != 1) {
                    PSAppMenuServiceBase.this.onGetDraftWithModel(pSAppMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSAppMenu, null);
        }
    }

    protected void onGetDraftWithModel(PSAppMenu pSAppMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSAppMenu pSAppMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSAppMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppMenu, ACTION_GETWITHMODEL);
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuServiceBase.this.getService(), PSAppMenuServiceBase.ACTION_GETWITHMODEL, 40, pSAppMenu2, null).getResult() != 1) {
                    PSAppMenuServiceBase.this.onGetWithModel(pSAppMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSAppMenu, null);
        }
    }

    protected void onGetWithModel(PSAppMenu pSAppMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void previewSave(PSAppMenu pSAppMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, pSAppMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppMenu, ACTION_PREVIEWSAVE);
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuServiceBase.this.getService(), PSAppMenuServiceBase.ACTION_PREVIEWSAVE, 40, pSAppMenu2, null).getResult() != 1) {
                    PSAppMenuServiceBase.this.onPreviewSave(pSAppMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, pSAppMenu, null);
        }
    }

    protected void onPreviewSave(PSAppMenu pSAppMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSAppMenu pSAppMenu) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSAppMenu, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppMenu, ACTION_UPDATEWITHMODEL);
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppMenuServiceBase.this.getService(), PSAppMenuServiceBase.ACTION_UPDATEWITHMODEL, 40, pSAppMenu2, null).getResult() != 1) {
                    PSAppMenuServiceBase.this.onUpdateWithModel(pSAppMenu2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSAppMenu, null);
        }
    }

    protected void onUpdateWithModel(PSAppMenu pSAppMenu) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSAppMenu pSAppMenu, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlMsg);
            } else {
                iService.get(pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSAppMenu, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSDYNAAPP_PSDYNAAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService", (SessionFactory)this.getSessionFactory());
            PSDynaApp pSDynaApp = (PSDynaApp)iService.getDEModel().createEntity();
            pSDynaApp.set("PSDYNAAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaApp);
            } else {
                iService.get(pSDynaApp);
            }
            this.onFillParentInfo_PSDynaApp(pSAppMenu, pSDynaApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppMenu, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCounter);
            } else {
                iService.get(pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSAppMenu, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSAppMenu, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSAppMenu, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSAppMenu, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSAppMenu, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSAppMenu, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlMsg(PSAppMenu pSAppMenu, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSAppMenu.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSAppMenu.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDynaApp(PSAppMenu pSAppMenu, PSDynaApp pSDynaApp) throws Exception {
        pSAppMenu.setPSDynaAppId(pSDynaApp.getPSDynaAppId());
        pSAppMenu.setPSDynaAppName(pSDynaApp.getPSDynaAppName());
        if (pSDynaApp.getPSSysApp() != null) {
            this.onFillParentInfo_PSSysApp(pSAppMenu, pSDynaApp.getPSSysApp());
        }
    }

    protected void onFillParentInfo_PSSysApp(PSAppMenu pSAppMenu, PSSysApp pSSysApp) throws Exception {
        pSAppMenu.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppMenu.setPSSysAppName(pSSysApp.getPSSysAppName());
        pSAppMenu.setPSSystemId(pSSysApp.getPSSystemId());
    }

    protected void onFillParentInfo_PSSysCounter(PSAppMenu pSAppMenu, PSSysCounter pSSysCounter) throws Exception {
        pSAppMenu.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSAppMenu.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysCss(PSAppMenu pSAppMenu, PSSysCss pSSysCss) throws Exception {
        pSAppMenu.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSAppMenu.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSAppMenu pSAppMenu, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSAppMenu.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSAppMenu.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSAppMenu pSAppMenu, PSSysReqItem pSSysReqItem) throws Exception {
        pSAppMenu.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSAppMenu.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSAppMenu pSAppMenu, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSAppMenu.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSAppMenu.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSAppMenu pSAppMenu, boolean bl) throws Exception {
        if (bl && pSAppMenu.getPublicFlag() == null) {
            pSAppMenu.setPublicFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSDynaApp(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSSysCss(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSAppMenu, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSAppMenu, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaApp(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSAppMenu pSAppMenu, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppMenu pSAppMenu, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppMenu, bl);
    }

    public ArrayList<PSAppMenu> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppMenu> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPID", (Object)pSDynaAppBase.getPSDynaAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenu> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppMenu> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppMenu> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppMenu> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppMenu> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppMenu> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSAppMenu> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSAppMenu> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENU_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSAPPMENU", iDataEntityModel.getDataInfo(pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSCtrlMsgId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSAppMenuServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSDynaApp(pSDynaApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENU_PSDYNAAPP_PSDYNAAPPID", "", iDataEntityModel.getName(), "PSAPPMENU", iDataEntityModel.getDataInfo(pSDynaApp), arrayList.get(0)));
        }
    }

    public void resetPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSDynaApp(pSDynaApp);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSDynaAppId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        final PSDynaApp pSDynaApp2 = pSDynaApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSDynaApp(pSDynaApp2);
                PSAppMenuServiceBase.this.internalRemoveByPSDynaApp(pSDynaApp2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSDynaApp(pSDynaApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void internalRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSDynaApp(pSDynaApp);
        this.onBeforeRemoveByPSDynaApp(pSDynaApp, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSDynaApp(pSDynaApp, arrayList);
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSSysAppId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppMenuServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENU_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSAPPMENU", iDataEntityModel.getDataInfo(pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSSysCounterId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSAppMenuServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENU_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSAPPMENU", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSSysCssId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSAppMenuServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENU_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSAPPMENU", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSSysPFPluginId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppMenuServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENU_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSAPPMENU", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSSysReqItemId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppMenuServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMENU_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSAPPMENU", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSAppMenu pSAppMenu : arrayList) {
            PSAppMenu pSAppMenu2 = (PSAppMenu)this.getDEModel().createEntity();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppMenu2.setPSViewMsgGroupId(null);
            this.update(pSAppMenu2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSAppMenuServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSAppMenuServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSAppMenu> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSAppMenu pSAppMenu : arrayList) {
            this.remove(pSAppMenu);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSAppMenu> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppMenu pSAppMenu) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppIndexViewServiceBase)pSCoreSysServiceBase).testRemoveByBottomSidePSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppIndexViewServiceBase)pSCoreSysServiceBase).testRemoveByLeftSidePSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppIndexViewServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppIndexViewServiceBase)pSCoreSysServiceBase).testRemoveByRightSidePSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppIndexViewServiceBase)pSCoreSysServiceBase).testRemoveByTopSidePSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).removeByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).removeByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPVPartServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByLeftPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByRightPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUserModeServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUtilViewServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSAppMenu(pSAppMenu);
        super.onBeforeRemove(pSAppMenu);
    }

    protected void onBeforeRemoveTemp(PSAppMenu pSAppMenu) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).removeTempByPSAppMenu(pSAppMenu);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).removeTempByPSAppMenu(pSAppMenu);
        super.onBeforeRemoveTemp(pSAppMenu);
    }

    protected void getRelatedDataTempMajor(PSAppMenu pSAppMenu) throws Exception {
        this.getRelatedDataTempMajor_PSAppMenuItem(pSAppMenu);
        this.getRelatedDataTempMajor_PSAppMenuLogic(pSAppMenu);
        super.getRelatedDataTempMajor(pSAppMenu);
    }

    protected void getRelatedDataTempMajor_PSAppMenuItem(PSAppMenu pSAppMenu) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuItem> arrayList = null;
        String string = pSAppMenu.getPSAppMenuId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppMenuItemService.selectByPSAppMenu(pSAppMenu) : pSAppMenuItemService.selectTempByPSAppMenu(pSAppMenu);
        PSAppMenuServiceBase.sortHierarchyEntities(arrayList, (String)"PSAPPMENUITEMID", (String)"PPSAPPMENUITEMID");
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            pSAppMenuItemService.getTempMajor(pSAppMenuItem);
        }
    }

    protected void getRelatedDataTempMajor_PSAppMenuLogic(PSAppMenu pSAppMenu) throws Exception {
        PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuLogic> arrayList = null;
        String string = pSAppMenu.getPSAppMenuId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppMenuLogicService.selectByPSAppMenu(pSAppMenu) : pSAppMenuLogicService.selectTempByPSAppMenu(pSAppMenu);
        for (PSAppMenuLogic pSAppMenuLogic : arrayList) {
            pSAppMenuLogicService.getTempMajor(pSAppMenuLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSAppMenu pSAppMenu, PSAppMenu pSAppMenu2) throws Exception {
        ArrayList<PSAppMenuLogic> arrayList = this.updateRelatedDataTempMajor_removePSAppMenuLogic(pSAppMenu, pSAppMenu2);
        ArrayList<PSAppMenuItem> arrayList2 = this.updateRelatedDataTempMajor_removePSAppMenuItem(pSAppMenu, pSAppMenu2);
        this.updateRelatedDataTempMajor_updatePSAppMenuItem(pSAppMenu, pSAppMenu2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSAppMenuLogic(pSAppMenu, pSAppMenu2, arrayList);
        super.updateRelatedDataTempMajor(pSAppMenu, pSAppMenu2);
    }

    protected ArrayList<PSAppMenuItem> updateRelatedDataTempMajor_removePSAppMenuItem(PSAppMenu pSAppMenu, PSAppMenu pSAppMenu2) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuItem> arrayList = pSAppMenuItemService.selectTempByPSAppMenu(pSAppMenu);
        ArrayList<PSAppMenuItem> arrayList2 = pSAppMenuItemService.selectByPSAppMenu(pSAppMenu2);
        HashMap<String, PSAppMenuItem> hashMap = new HashMap<String, PSAppMenuItem>();
        for (PSAppMenuItem pSAppMenuItem : arrayList2) {
            hashMap.put(pSAppMenuItem.getPSAppMenuItemId(), pSAppMenuItem);
        }
        PSAppMenuServiceBase.sortHierarchyEntities(arrayList, (String)"PSAPPMENUITEMID", (String)"PPSAPPMENUITEMID");
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            Object object = pSAppMenuItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSAppMenuItem pSAppMenuItem : hashMap.values()) {
            pSAppMenuItemService.remove(pSAppMenuItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSAppMenuItem(PSAppMenu pSAppMenu, PSAppMenu pSAppMenu2, ArrayList<PSAppMenuItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            pSAppMenuItemService.updateTempMajor(pSAppMenuItem);
        }
    }

    protected ArrayList<PSAppMenuLogic> updateRelatedDataTempMajor_removePSAppMenuLogic(PSAppMenu pSAppMenu, PSAppMenu pSAppMenu2) throws Exception {
        PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuLogic> arrayList = pSAppMenuLogicService.selectTempByPSAppMenu(pSAppMenu);
        ArrayList<PSAppMenuLogic> arrayList2 = pSAppMenuLogicService.selectByPSAppMenu(pSAppMenu2);
        HashMap<String, PSAppMenuLogic> hashMap = new HashMap<String, PSAppMenuLogic>();
        for (PSAppMenuLogic pSAppMenuLogic : arrayList2) {
            hashMap.put(pSAppMenuLogic.getPSAppMenuLogicId(), pSAppMenuLogic);
        }
        for (PSAppMenuLogic pSAppMenuLogic : arrayList) {
            Object object = pSAppMenuLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSAppMenuLogic pSAppMenuLogic : hashMap.values()) {
            pSAppMenuLogicService.remove(pSAppMenuLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSAppMenuLogic(PSAppMenu pSAppMenu, PSAppMenu pSAppMenu2, ArrayList<PSAppMenuLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSAppMenuLogic pSAppMenuLogic : arrayList) {
            pSAppMenuLogicService.updateTempMajor(pSAppMenuLogic);
        }
    }

    protected void replaceParentInfo(PSAppMenu pSAppMenu, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppMenu, cloneSession);
        if (pSAppMenu.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSAppMenu.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSAppMenu, (PSCtrlMsg)iEntity);
        }
        if (pSAppMenu.getPSDynaAppId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPP", (Object)pSAppMenu.getPSDynaAppId())) != null) {
            this.onFillParentInfo_PSDynaApp(pSAppMenu, (PSDynaApp)iEntity);
        }
        if (pSAppMenu.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppMenu.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppMenu, (PSSysApp)iEntity);
        }
        if (pSAppMenu.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSAppMenu.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSAppMenu, (PSSysCounter)iEntity);
        }
        if (pSAppMenu.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSAppMenu.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSAppMenu, (PSSysCss)iEntity);
        }
        if (pSAppMenu.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSAppMenu.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSAppMenu, (PSSysPFPlugin)iEntity);
        }
        if (pSAppMenu.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSAppMenu.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSAppMenu, (PSSysReqItem)iEntity);
        }
        if (pSAppMenu.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSAppMenu.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSAppMenu, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppMenu pSAppMenu, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppMenu, bl);
        pSAppMenu.resetFromObjId();
    }

    protected void onCheckEntity(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppMenuStyle(bl, pSAppMenu, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomizedFlag(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexAlign(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexDir(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexVAlign(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromObjId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconAlign(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JSModel(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MenuModel(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MenuSN(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerTag(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerType(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuName(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PublicFlag(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppMenu, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppMenu, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppMenuStyle(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isAppMenuStyleDirty() : !pSAppMenu.isAppMenuStyleDirty()) {
            return null;
        }
        String string = pSAppMenu.getAppMenuStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppMenuStyle_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPMENUSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isCodeNameDirty() && !bl2 : !pSAppMenu.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppMenu.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomizedFlag(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isCustomizedFlagDirty() : !pSAppMenu.isCustomizedFlagDirty()) {
            return null;
        }
        Integer n = pSAppMenu.getCustomizedFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomizedFlag_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMIZEDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isDynaModelFlagDirty() : !pSAppMenu.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSAppMenu.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_FlexAlign(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isFlexAlignDirty() : !pSAppMenu.isFlexAlignDirty()) {
            return null;
        }
        String string = pSAppMenu.getFlexAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexAlign_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexDir(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isFlexDirDirty() : !pSAppMenu.isFlexDirDirty()) {
            return null;
        }
        String string = pSAppMenu.getFlexDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexDir_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexVAlign(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isFlexVAlignDirty() : !pSAppMenu.isFlexVAlignDirty()) {
            return null;
        }
        String string = pSAppMenu.getFlexVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexVAlign_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXVALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FromObjId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isFromObjIdDirty() : !pSAppMenu.isFromObjIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getFromObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromObjId_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconAlign(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isIconAlignDirty() : !pSAppMenu.isIconAlignDirty()) {
            return null;
        }
        String string = pSAppMenu.getIconAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconAlign_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JSModel(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isJSModelDirty() : !pSAppMenu.isJSModelDirty()) {
            return null;
        }
        String string = pSAppMenu.getJSModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JSModel_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isLayoutModeDirty() : !pSAppMenu.isLayoutModeDirty()) {
            return null;
        }
        String string = pSAppMenu.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isLogicNameDirty() : !pSAppMenu.isLogicNameDirty()) {
            return null;
        }
        String string = pSAppMenu.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isMemoDirty() : !pSAppMenu.isMemoDirty()) {
            return null;
        }
        String string = pSAppMenu.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_MenuModel(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isMenuModelDirty() : !pSAppMenu.isMenuModelDirty()) {
            return null;
        }
        String string = pSAppMenu.getMenuModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MenuModel_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MENUMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MenuSN(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isMenuSNDirty() : !pSAppMenu.isMenuSNDirty()) {
            return null;
        }
        String string = pSAppMenu.getMenuSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MenuSN_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MENUSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isOwnerIdDirty() : !pSAppMenu.isOwnerIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getOwnerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerId_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerTag(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isOwnerTagDirty() : !pSAppMenu.isOwnerTagDirty()) {
            return null;
        }
        String string = pSAppMenu.getOwnerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerTag_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerType(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isOwnerTypeDirty() : !pSAppMenu.isOwnerTypeDirty()) {
            return null;
        }
        String string = pSAppMenu.getOwnerType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerType_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenuId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSAppMenuIdDirty() && !bl2 : !pSAppMenu.isPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSAppMenuId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuId_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenuName(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSAppMenuNameDirty() && !bl2 : !pSAppMenu.isPSAppMenuNameDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSAppMenuName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuName_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppMenuDEModel(), "PSAPPMENUNAME", string3, pSAppMenu, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPMENUNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSCtrlMsgIdDirty() : !pSAppMenu.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaAppId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSDynaAppIdDirty() : !pSAppMenu.isPSDynaAppIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSDynaAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppId_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSSysAppIdDirty() && !bl2 : !pSAppMenu.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSSysCounterIdDirty() : !pSAppMenu.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSSysCssIdDirty() : !pSAppMenu.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSSysPFPluginIdDirty() : !pSAppMenu.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSSysReqItemIdDirty() : !pSAppMenu.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPSViewMsgGroupIdDirty() : !pSAppMenu.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSAppMenu.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_PublicFlag(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isPublicFlagDirty() : !pSAppMenu.isPublicFlagDirty()) {
            return null;
        }
        Integer n = pSAppMenu.getPublicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PublicFlag_Default(pSAppMenu, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBLICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isUserParamsDirty() : !pSAppMenu.isUserParamsDirty()) {
            return null;
        }
        String string = pSAppMenu.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isUserTagDirty() : !pSAppMenu.isUserTagDirty()) {
            return null;
        }
        String string = pSAppMenu.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppMenu, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppMenu pSAppMenu, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppMenu.isUserTag2Dirty() : !pSAppMenu.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppMenu.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppMenu, bl2, bl3);
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

    protected void onSyncEntity(PSAppMenu pSAppMenu, boolean bl) throws Exception {
        super.onSyncEntity(pSAppMenu, bl);
    }

    protected void onSyncIndexEntities(PSAppMenu pSAppMenu, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppMenu, bl);
    }

    public Object getDataContextValue(PSAppMenu pSAppMenu, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppMenu, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppMenu.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSAppMenu pSAppMenu, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSAppMenuLogic_PSAppMenu(pSAppMenu, arrayList, n);
        super.onExportRelatedModel(pSAppMenu, arrayList, n);
    }

    protected void onExportRelatedModel_PSAppMenuLogic_PSAppMenu(PSAppMenu pSAppMenu, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuLogic> arrayList2 = pSAppMenuLogicService.selectByPSAppMenu(pSAppMenu);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"f24a3208345b6e2fb296ab56647e6994");
            jSONObject.put("srfdename", (Object)"PSAPPMENULOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSAPPMENULOGIC_PSAPPMENU_PSAPPMENUID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSAppMenu, (String)"PSAPPMENUID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSAppMenuLogic pSAppMenuLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSAppMenuLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSAppMenuLogicService.exportModel(pSAppMenuLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSAppMenu pSAppMenu, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppMenu, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPMENUSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppMenuStyle_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMIZEDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomizedFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXVALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexVAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JSModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MENUMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MenuModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MENUSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MenuSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBLICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PublicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppMenuStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPMENUSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CustomizedFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXDIR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexVAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXVALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FromObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JSModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_MenuModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MENUMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MenuSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MENUSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERTAG", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSAPPMENUNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDynaAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PublicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSAppMenu pSAppMenu) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppMenu)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppMenu pSAppMenu) throws Exception {
        Object object = pSAppMenu.get("PSSYSAPPID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(pSAppMenu);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSAppMenu pSAppMenu, Object object) throws Exception {
        PSAppMenu pSAppMenu2 = new PSAppMenu();
        pSAppMenu2.set("PSAPPMENUID", object);
        String string = DataObject.getStringValue((Object)pSAppMenu.get("PSAPPMENUID"));
        super.onCopyDetails(pSAppMenu, object);
    }

    @Override
    protected void exportCurXmlModel(PSAppMenu pSAppMenu, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPMENU");
        if (!bl) {
            pSAppMenu.setCreateDate(null);
            pSAppMenu.setCreateMan(null);
            pSAppMenu.setPSAppMenuId(null);
            pSAppMenu.setUpdateDate(null);
            pSAppMenu.setUpdateMan(null);
            super.exportCurXmlModel(pSAppMenu, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSAppMenu pSAppMenu, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSAppMenuItem(pSAppMenu, xmlNode);
        this.exportRelatedXmlModel_PSAppMenuLogic(pSAppMenu, xmlNode);
        super.onExportRelatedXmlModel(pSAppMenu, xmlNode);
    }

    protected void exportRelatedXmlModel_PSAppMenuItem(PSAppMenu pSAppMenu, XmlNode xmlNode) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuItem> arrayList = null;
        String string = pSAppMenu.getPSAppMenuId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppMenuItemService.selectByPSAppMenu(pSAppMenu, "ORDER BY ORDERVALUE ASC") : pSAppMenuItemService.selectTempByPSAppMenu(pSAppMenu, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSAPPMENUITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSAppMenuItem pSAppMenuItem : arrayList) {
                if (pSAppMenuItem.getPPSAppMenuItemId() != null) continue;
                pSAppMenuItem.set("ORDERVALUE", null);
                pSAppMenuItemService.exportXmlModel(pSAppMenuItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSAppMenuLogic(PSAppMenu pSAppMenu, XmlNode xmlNode) throws Exception {
        PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuLogic> arrayList = null;
        String string = pSAppMenu.getPSAppMenuId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSAppMenuLogicService.selectByPSAppMenu(pSAppMenu, "ORDER BY ORDERVALUE ASC") : pSAppMenuLogicService.selectTempByPSAppMenu(pSAppMenu, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSAPPMENULOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSAppMenuLogic pSAppMenuLogic : arrayList) {
                pSAppMenuLogic.set("ORDERVALUE", null);
                pSAppMenuLogicService.exportXmlModel(pSAppMenuLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSAppMenu pSAppMenu, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSAPPMENUITEMS");
        this.importRelatedXmlModel_PSAppMenuItem(pSAppMenu, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSAPPMENULOGICS");
        this.importRelatedXmlModel_PSAppMenuLogic(pSAppMenu, xmlNode3);
        super.onImportRelatedXmlModel(pSAppMenu, xmlNode);
    }

    protected void importRelatedXmlModel_PSAppMenuItem(PSAppMenu pSAppMenu, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSAppMenu.getPSAppMenuId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSAppMenuItemService.removeByPSAppMenu(pSAppMenu);
        } else {
            pSAppMenuItemService.removeTempByPSAppMenu(pSAppMenu);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSAppMenuItem pSAppMenuItem = new PSAppMenuItem();
                pSAppMenuItem.setOrderValue(n);
                n += 100;
                pSAppMenuItemService.fillParentInfo(pSAppMenuItem, "DER1N", "DER1N_PSAPPMENUITEM_PSAPPMENU_PSAPPMENUID", pSAppMenu.getPSAppMenuId());
                pSAppMenuItemService.importXmlModel(pSAppMenuItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSAppMenuLogic(PSAppMenu pSAppMenu, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSAppMenu.getPSAppMenuId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSAppMenuLogicService.removeByPSAppMenu(pSAppMenu);
        } else {
            pSAppMenuLogicService.removeTempByPSAppMenu(pSAppMenu);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSAppMenuLogic pSAppMenuLogic = new PSAppMenuLogic();
                pSAppMenuLogic.setOrderValue(n);
                n += 100;
                pSAppMenuLogicService.fillParentInfo(pSAppMenuLogic, "DER1N", "DER1N_PSAPPMENULOGIC_PSAPPMENU_PSAPPMENUID", pSAppMenu.getPSAppMenuId());
                pSAppMenuLogicService.importXmlModel(pSAppMenuLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppMenu pSAppMenu, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppMenu, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppMenu pSAppMenu) {
        if (!StringHelper.isNullOrEmpty((String)pSAppMenu.getPSAppMenuName())) {
            return pSAppMenu.getPSAppMenuName();
        }
        return super.getModelV2Tag(pSAppMenu);
    }

    @Override
    public boolean setModelV2Tag(PSAppMenu pSAppMenu, String string) {
        pSAppMenu.setPSAppMenuName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPMENUNAME", "");
        map.put("PSAPPMENUNAME", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppMenu pSAppMenu, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppMenu.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppMenu, true);
        pSAppMenu.set("PSAPPMENUNAME", string);
        if (this.select(pSAppMenu, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppMenu, true);
        return super.getModelV2Entity(pSAppMenu, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppMenu pSAppMenu, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppMenu, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSAPPMENUITEM_PSAPPMENU_PSAPPMENUID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSAPPMENULOGIC_PSAPPMENU_PSAPPMENUID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSAppMenu pSAppMenu, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSAppMenu, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSAppMenu pSAppMenu, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPMENUITEM_PSAPPMENU_PSAPPMENUID")) {
            pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMENU#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPMENUITEM", (Object)pSAppMenu.getPSAppMenuId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSAPPMENU#%1$s", (Object)pSAppMenu.getPSAppMenuId());
                for (PSAppMenuItem item : ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).selectByPSAppMenu(pSAppMenu)) {
                    String itemScope = ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item);
                    if (StringHelper.compare(scope, itemScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psappmenuitemname")) {
                            string = objectNode.get("psappmenuitemname").asText();
                        }
                        if (objectNode2.has("psappmenuitemname")) {
                            string2 = objectNode2.get("psappmenuitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    PSAppMenuItem item = new PSAppMenuItem();
                    PSModelV2Helper.fromJSONObject(item, json, false);
                    item.remove("ordervalue");
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(item, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPMENULOGIC_PSAPPMENU_PSAPPMENUID")) {
            pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMENU#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPMENULOGIC", (Object)pSAppMenu.getPSAppMenuId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSAPPMENU#%1$s", (Object)pSAppMenu.getPSAppMenuId());
                for (PSAppMenuLogic logic : ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).selectByPSAppMenu(pSAppMenu)) {
                    String logicScope = ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(logic);
                    if (StringHelper.compare(scope, logicScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(logic, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psappmenulogicname")) {
                            string = objectNode.get("psappmenulogicname").asText();
                        }
                        if (objectNode2.has("psappmenulogicname")) {
                            string2 = objectNode2.get("psappmenulogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    PSAppMenuLogic logic = new PSAppMenuLogic();
                    PSModelV2Helper.fromJSONObject(logic, json, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(logic, string));
                }
            }
        }
        super.onExportCurModelV2(pSAppMenu, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSAppMenu pSAppMenu) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuItem> items = ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).selectByPSAppMenu(pSAppMenu);
        String string2 = StringHelper.format((String)"PSAPPMENU#%1$s", (Object)pSAppMenu.getPSAppMenuId());
        for (PSAppMenuItem entityBase : items) {
            string = ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSAppMenu.getPSAppMenuId());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPMENUITEM WHERE PSAPPMENUID = ?", params);
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuLogic> logics = ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).selectByPSAppMenu(pSAppMenu);
        string2 = StringHelper.format((String)"PSAPPMENU#%1$s", (Object)pSAppMenu.getPSAppMenuId());
        for (PSAppMenuLogic pSAppMenuLogic : logics) {
            string = ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSAppMenuLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSAppMenuLogic);
        }
        params = new SqlParamList();
        params.addString(pSAppMenu.getPSAppMenuId());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPMENULOGIC WHERE PSAPPMENUID = ?", params);
        super.onEmptyModelV2(pSAppMenu);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSAppMenu pSAppMenu, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSAppMenuItem();
        entityBase.set("PSAPPMENUID", pSAppMenu.getPSAppMenuId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppMenuLogic();
        entityBase.set("PSAPPMENUID", pSAppMenu.getPSAppMenuId());
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSAppMenu, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSAppMenu pSAppMenu, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        Serializable serializable;
        Object object2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                PSAppMenuItem object = new PSAppMenuItem();
                object.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
                object.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
                object.setPSSysAppId(pSAppMenu.getPSSysAppId());
                object.setOrderValue(n2 += 10);
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                File[] fileArray;
                File[] fileArray2 = fileArray = ((File)object2).listFiles();
                int n3 = fileArray2.length;
                for (int i = 0; i < n3; ++i) {
                    serializable = fileArray2[i];
                    if (!((File)serializable).isDirectory()) continue;
                    PSAppMenuItem pSAppMenuItem = new PSAppMenuItem();
                    pSAppMenuItem.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
                    pSAppMenuItem.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
                    pSAppMenuItem.setPSSysAppId(pSAppMenu.getPSSysAppId());
                    pSCoreSysServiceBase.compileModelV2(pSAppMenuItem, null, string, ((File)serializable).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(n2);
                PSAppMenuLogic logic = new PSAppMenuLogic();
                logic.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
                logic.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
                pSCoreSysServiceBase.compileModelV2(logic, objectNode2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string5);
            if (file.exists()) {
                for (File folder : file.listFiles()) {
                    if (!folder.isDirectory()) continue;
                    PSAppMenuLogic logic = new PSAppMenuLogic();
                    logic.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
                    logic.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
                    pSCoreSysServiceBase.compileModelV2(logic, null, string, folder.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSAppMenu, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSAppMenu pSAppMenu, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPMENUITEM_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppMenuItems(pSAppMenu, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPMENULOGIC_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppMenuLogics(pSAppMenu, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSAppMenu, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSAppMenuItems(PSAppMenu pSAppMenu, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPMENUITEM", true), (boolean)false) == 0) {
            PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
            PSAppMenuItem pSAppMenuItem = new PSAppMenuItem();
            pSAppMenuItem.setPSAppMenuItemId(pSMOSFile.getPSModelId());
            if (!pSAppMenuItemService.get(pSAppMenuItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppMenuItem.getPSAppMenuId(), (String)pSAppMenu.getPSAppMenuId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppMenuItemService.exportModelV2(pSAppMenuItem);
            pSAppMenuItem.reset();
            if (!pSAppMenuItemService.setModelV2ResScope(pSAppMenuItem, "PSAPPMENU", pSAppMenu.getPSAppMenuId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppMenuItemService.importModelV2(pSAppMenuItem, objectNode);
            SessionFactoryManager.commit();
            return pSAppMenuItemService.getFile(pSAppMenuItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppMenuLogics(PSAppMenu pSAppMenu, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPMENULOGIC", true), (boolean)false) == 0) {
            PSAppMenuLogicService pSAppMenuLogicService = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
            PSAppMenuLogic pSAppMenuLogic = new PSAppMenuLogic();
            pSAppMenuLogic.setPSAppMenuLogicId(pSMOSFile.getPSModelId());
            if (!pSAppMenuLogicService.get(pSAppMenuLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppMenuLogic.getPSAppMenuId(), (String)pSAppMenu.getPSAppMenuId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppMenuLogicService.exportModelV2(pSAppMenuLogic);
            pSAppMenuLogic.reset();
            if (!pSAppMenuLogicService.setModelV2ResScope(pSAppMenuLogic, "PSAPPMENU", pSAppMenu.getPSAppMenuId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppMenuLogicService.importModelV2(pSAppMenuLogic, objectNode);
            SessionFactoryManager.commit();
            return pSAppMenuLogicService.getFile(pSAppMenuLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSAppMenu pSAppMenu, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSAppMenuItems(pSAppMenu, list);
        this.onFillPasteHelps_PSAppMenuLogics(pSAppMenu, list);
        super.onFillPasteHelps(pSAppMenu, list);
    }

    protected void onFillPasteHelps_PSAppMenuItems(PSAppMenu pSAppMenu, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPMENUITEM");
        pSHelpSection.setSectionParam2("DER1N_PSAPPMENUITEM_PSAPPMENU_PSAPPMENUID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u83dc\u5355]\u7684[\u5e94\u7528\u83dc\u5355\u9879]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppMenuLogics(PSAppMenu pSAppMenu, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPMENULOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSAPPMENULOGIC_PSAPPMENU_PSAPPMENUID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u83dc\u5355]\u7684[\u5e94\u7528\u83dc\u5355\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}
